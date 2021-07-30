package com.huto.forcesofreality.container.slot;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.Container;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class SlotAdornmentOffHand extends Slot {

	public SlotAdornmentOffHand(Container inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return super.isItemValid(stack);
	}

	@Nullable
	@Override
	public Pair<ResourceLocation, ResourceLocation> getBackground() { // getSlotTexture
		return Pair.of(PlayerContainer.LOCATION_BLOCKS_TEXTURE, PlayerContainer.EMPTY_ARMOR_SLOT_SHIELD);
	}
}
