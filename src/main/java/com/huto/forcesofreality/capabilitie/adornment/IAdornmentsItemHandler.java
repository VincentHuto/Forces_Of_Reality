package com.huto.forcesofreality.capabilitie.adornment;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;

public interface IAdornmentsItemHandler extends IItemHandlerModifiable {

    boolean isItemValidForSlot(int slot, ItemStack stack);

    boolean isEventBlocked();

    void setEventBlock(boolean blockEvents);

    void tick();
}