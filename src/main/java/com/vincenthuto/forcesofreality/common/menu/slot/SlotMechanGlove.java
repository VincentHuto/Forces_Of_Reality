package com.vincenthuto.forcesofreality.common.menu.slot;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.common.item.tool.coven.module.ItemMechanModuleBase;
import com.vincenthuto.forcesofreality.common.menu.MechanGloveItemHandler;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotMechanGlove extends SlotItemHandler {
	public SlotMechanGlove(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}

	@Override
	public int getMaxStackSize(@Nonnull ItemStack stack) {
		return 1;
	}

	@Override
	public boolean mayPlace(@Nonnull ItemStack stack) {
		if (stack.getItem() instanceof ItemMechanModuleBase) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void setChanged() {
		super.setChanged();
		if (getItemHandler() instanceof MechanGloveItemHandler)
			((MechanGloveItemHandler) getItemHandler()).setDirty();
	}
}