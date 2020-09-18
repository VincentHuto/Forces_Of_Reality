package com.huto.hutosmod.containers.mindrunes;

import com.huto.hutosmod.capabilities.mindrunes.IRune;
import com.huto.hutosmod.capabilities.mindrunes.IRunesItemHandler;
import com.huto.hutosmod.capabilities.mindrunes.RunesCapabilities;
import com.huto.hutosmod.objects.items.ItemContractRune;
import com.huto.hutosmod.objects.items.ItemRune;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class SlotRune extends SlotItemHandler {
    int baubleSlot;
    PlayerEntity player;

    public SlotRune(PlayerEntity player, IRunesItemHandler itemHandler, int slot, int par4, int par5) {
        super(itemHandler, slot, par4, par5);
        this.baubleSlot = slot;
        this.player = player;
    }

    /**
     * Check if the stack is a valid item for this slot.
     */
    @Override
    public boolean isItemValid(ItemStack stack) {
    	if(stack.getItem() instanceof ItemRune && !(stack.getItem() instanceof ItemContractRune)) {
    		return true;
    	}else {
    		return false;
    	}
    //    return ((IRunesItemHandler) getItemHandler()).isItemValidForSlot(baubleSlot, stack);
    }

    @Override
    public boolean canTakeStack(PlayerEntity player) {
        ItemStack stack = getStack();
        if (stack.isEmpty())
            return false;

        IRune bauble = stack.getCapability(RunesCapabilities.ITEM_RUNE).orElseThrow(NullPointerException::new);
        return bauble.canUnequip(player);
    }

    @Override
    public ItemStack onTake(PlayerEntity playerIn, ItemStack stack) {
        if (!getHasStack() && !((IRunesItemHandler) getItemHandler()).isEventBlocked() && stack.getCapability(RunesCapabilities.ITEM_RUNE).isPresent()) {
            stack.getCapability(RunesCapabilities.ITEM_RUNE, null).ifPresent((iBauble) -> iBauble.onUnequipped(playerIn));
        }
        super.onTake(playerIn, stack);
        return stack;
    }

    @Override
    public void putStack(ItemStack stack) {
        if (getHasStack() && !ItemStack.areItemStacksEqual(stack, getStack()) && !((IRunesItemHandler) getItemHandler()).isEventBlocked() && getStack().getCapability(RunesCapabilities.ITEM_RUNE, null).isPresent()) {
            getStack().getCapability(RunesCapabilities.ITEM_RUNE, null).ifPresent((iBauble) -> iBauble.onUnequipped(player));
        }

        ItemStack oldstack = getStack().copy();
        super.putStack(stack);

        if (getHasStack() && !ItemStack.areItemStacksEqual(oldstack, getStack()) && !((IRunesItemHandler) getItemHandler()).isEventBlocked() && getStack().getCapability(RunesCapabilities.ITEM_RUNE, null).isPresent()) {
            getStack().getCapability(RunesCapabilities.ITEM_RUNE, null).ifPresent((iBauble) -> iBauble.onEquipped(player));
        }
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }
}