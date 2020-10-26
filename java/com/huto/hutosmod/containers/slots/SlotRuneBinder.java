package com.huto.hutosmod.containers.slots;


import javax.annotation.Nonnull;

import com.huto.hutosmod.containers.RuneBinderItemHandler;

import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.items.CapabilityItemHandler;
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
        //check for shulkers.
        if (stack.getItem() instanceof BlockItem) {
            if (((BlockItem) stack.getItem()).getBlock().isIn(BlockTags.SHULKER_BOXES)) {
                return false;
            }
        }
        if (stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).isPresent())
            return false;
        if (stack.hasTag()) {
            CompoundNBT tag = stack.getTag();
            return !(tag.contains("Items") || tag.contains("Inventory"));
        }
        return true;
    }

    @Override
    public void onSlotChanged() {
        super.onSlotChanged();
        if (getItemHandler() instanceof RuneBinderItemHandler)
            ((RuneBinderItemHandler) getItemHandler()).setDirty();
    }
}