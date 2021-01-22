package com.huto.forcesofreality.containers.slots;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.containers.MechanGloveItemHandler;
import com.huto.forcesofreality.objects.items.coven.tool.modules.ItemMechanModuleBase;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotMechanGlove extends SlotItemHandler {
	public SlotMechanGlove(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}

	@Override
	public int getItemStackLimit(@Nonnull ItemStack stack) {
		return 1;
	}

	@Override
	public boolean isItemValid(@Nonnull ItemStack stack) {
		if (stack.getItem() instanceof ItemMechanModuleBase) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void onSlotChanged() {
		super.onSlotChanged();
		if (getItemHandler() instanceof MechanGloveItemHandler)
			((MechanGloveItemHandler) getItemHandler()).setDirty();
	}
}