package com.huto.forcesofreality.container.slot;

import com.huto.forcesofreality.capabilitie.adornment.AdornmentsCapabilities;
import com.huto.forcesofreality.capabilitie.adornment.IAdornment;
import com.huto.forcesofreality.capabilitie.adornment.IAdornmentsItemHandler;
import com.huto.forcesofreality.item.ItemMajorAdornment;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class SlotAdornment extends SlotItemHandler {
	int runeSlot;
	Player player;

	public SlotAdornment(Player player, IAdornmentsItemHandler itemHandler, int slot, int par4, int par5) {
		super(itemHandler, slot, par4, par5);
		this.runeSlot = slot;
		this.player = player;
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if (stack.getItem() instanceof IAdornment && !(stack.getItem() instanceof ItemMajorAdornment)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean canTakeStack(Player player) {
		ItemStack stack = getStack();
		if (stack.isEmpty())
			return false;

		IAdornment adornment = stack.getCapability(AdornmentsCapabilities.ITEM_ADORNMENT).orElseThrow(NullPointerException::new);
		return adornment.canUnequip(player);
	}

	@Override
	public ItemStack onTake(PlayerEntity playerIn, ItemStack stack) {
		if (!getHasStack() && !((IAdornmentsItemHandler) getItemHandler()).isEventBlocked()
				&& stack.getCapability(AdornmentsCapabilities.ITEM_ADORNMENT).isPresent()) {
			stack.getCapability(AdornmentsCapabilities.ITEM_ADORNMENT, null)
					.ifPresent((iBauble) -> iBauble.onUnequipped(playerIn));
		}
		super.onTake(playerIn, stack);
		return stack;
	}

	@Override
	public void putStack(ItemStack stack) {
		if (getHasStack() && !ItemStack.areItemStacksEqual(stack, getStack())
				&& !((IAdornmentsItemHandler) getItemHandler()).isEventBlocked()
				&& getStack().getCapability(AdornmentsCapabilities.ITEM_ADORNMENT, null).isPresent()) {
			getStack().getCapability(AdornmentsCapabilities.ITEM_ADORNMENT, null)
					.ifPresent((iBauble) -> iBauble.onUnequipped(player));
		}

		ItemStack oldstack = getStack().copy();
		super.putStack(stack);

		if (getHasStack() && !ItemStack.areItemStacksEqual(oldstack, getStack())
				&& !((IAdornmentsItemHandler) getItemHandler()).isEventBlocked()
				&& getStack().getCapability(AdornmentsCapabilities.ITEM_ADORNMENT, null).isPresent()) {
			getStack().getCapability(AdornmentsCapabilities.ITEM_ADORNMENT, null)
					.ifPresent((iBauble) -> iBauble.onEquipped(player));
		}
	}

	@Override
	public int getSlotStackLimit() {
		return 1;
	}
}