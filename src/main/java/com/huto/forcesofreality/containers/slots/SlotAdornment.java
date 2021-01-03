package com.huto.forcesofreality.containers.slots;

import com.huto.forcesofreality.capabilities.adornments.IAdornment;
import com.huto.forcesofreality.capabilities.adornments.IAdornmentsItemHandler;
import com.huto.forcesofreality.capabilities.adornments.AdornmentsCapabilities;
import com.huto.forcesofreality.objects.items.ItemMajorAdornment;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class SlotAdornment extends SlotItemHandler {
	int runeSlot;
	PlayerEntity player;

	public SlotAdornment(PlayerEntity player, IAdornmentsItemHandler itemHandler, int slot, int par4, int par5) {
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
	public boolean canTakeStack(PlayerEntity player) {
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