package com.huto.hutosmod.containers.slots;

import com.huto.hutosmod.objects.items.equipment.ItemRuneBinder;
import com.huto.hutosmod.objects.items.runes.patterns.ItemRunePattern;

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
