package com.huto.forcesofreality.capabilitie.adornment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.events.adornments.AdornmentEntityEventHandler;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

public class AdornmentsContainer extends ItemStackHandler implements IAdornmentsItemHandler {

	private final static int RUNE_SLOTS = 7;
	private final ItemStack[] previous = new ItemStack[RUNE_SLOTS];
	private boolean[] changed = new boolean[RUNE_SLOTS];
	private boolean blockEvents = false;
	private LivingEntity holder;

	public AdornmentsContainer(LivingEntity player) {
		super(RUNE_SLOTS);
		this.holder = player;
		Arrays.fill(previous, ItemStack.EMPTY);
	}

	@Override
	public void setSize(int size) {
		if (size != RUNE_SLOTS)
			System.out.println("Cannot resize rune container");
	}

	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		LazyOptional<IAdornment> opt = stack.getCapability(AdornmentsCapabilities.ITEM_ADORNMENT);
		if (stack.isEmpty() || !opt.isPresent())
			return false;
		IAdornment adornment = opt.orElseThrow(NullPointerException::new);
		return adornment.canEquip(holder) && adornment.getAdornmentType().hasSlot(slot);
	}

	@Override
	public void setStackInSlot(int slot, @Nonnull ItemStack stack) {
		if (stack.isEmpty() || this.isItemValidForSlot(slot, stack)) {
			super.setStackInSlot(slot, stack);
		}
	}

	@Override
	public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
		if (!this.isItemValidForSlot(slot, stack))
			return stack;
		return super.insertItem(slot, stack, simulate);
	}

	@Override
	public boolean isEventBlocked() {
		return blockEvents;
	}

	@Override
	public void setEventBlock(boolean blockEvents) {
		this.blockEvents = blockEvents;
	}

	@Override
	protected void onContentsChanged(int slot) {
		this.changed[slot] = true;
	}

	public void tick() {
		for (int i = 0; i < getSlots(); i++) {
			ItemStack stack = getStackInSlot(i);
			if (stack.getItem() != Items.AIR) {
				stack.getCapability(AdornmentsCapabilities.ITEM_ADORNMENT).ifPresent(b -> b.onWornTick(holder));
			}
		}
		sync();
	}

	private void sync() {
		if (!(holder instanceof ServerPlayer)) {
			return;
		}

		List<Player> receivers = null;
		for (byte i = 0; i < getSlots(); i++) {
			ItemStack stack = getStackInSlot(i);
			boolean autosync = stack.getCapability(AdornmentsCapabilities.ITEM_ADORNMENT).map(b -> b.willAutoSync(holder))
					.orElse(false);
			if (changed[i] || autosync && !ItemStack.areItemStacksEqual(stack, previous[i])) {
				if (receivers == null) {
					receivers = new ArrayList<>(((ServerWorld) holder.world).getPlayers());
					receivers.add((ServerPlayerEntity) holder);
				}
				AdornmentEntityEventHandler.syncSlot((ServerPlayerEntity) holder, i, stack, receivers);
				this.changed[i] = false;
				previous[i] = stack.copy();
			}
		}
	}

	public LivingEntity getHolder() {
		return this.holder;
	}
}
