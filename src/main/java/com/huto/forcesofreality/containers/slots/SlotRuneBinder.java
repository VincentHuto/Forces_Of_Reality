package com.huto.forcesofreality.containers.slots;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.containers.RuneBinderItemHandler;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePattern;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotRuneBinder extends SlotItemHandler {
	public SlotRuneBinder(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}

	@Override
	public int getItemStackLimit(@Nonnull ItemStack stack) {
		return 1;
	}

	@Override
	public boolean isItemValid(@Nonnull ItemStack stack) {
		// check for shulkers.
		if (stack.getItem() instanceof ItemRunePattern) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void onSlotChanged() {
		super.onSlotChanged();
		if (getItemHandler() instanceof RuneBinderItemHandler)
			((RuneBinderItemHandler) getItemHandler()).setDirty();
	}
}