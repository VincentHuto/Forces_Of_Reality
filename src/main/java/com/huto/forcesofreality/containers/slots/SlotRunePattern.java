package com.huto.forcesofreality.containers.slots;

import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePattern;
import com.huto.forcesofreality.objects.items.tools.ItemRuneBinder;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

public class SlotRunePattern extends Slot {

	public SlotRunePattern(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if (stack.getItem() instanceof ItemRunePattern || stack.getItem() instanceof ItemRuneBinder) {
			return true;
		} else {
			return false;
		}
	}

}
