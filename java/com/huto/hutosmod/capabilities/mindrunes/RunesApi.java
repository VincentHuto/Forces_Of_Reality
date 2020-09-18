package com.huto.hutosmod.capabilities.mindrunes;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.LazyOptional;

/**
 * @author Azanor
 * @author lazynessmind - porter
 */
public class RunesApi {

    //Retrieves the baubles inventory capability handler for the supplied player
    public static LazyOptional<IRunesItemHandler> getBaublesHandler(PlayerEntity player) {
        return player.getCapability(RunesCapabilities.RUNES);
    }

    //Returns if the passed in item is equipped in a bauble slot. Will return the first slot found
    //@return -1 if not found and slot number if it is found
    public static int isBaubleEquipped(PlayerEntity player, Item bauble) {
        return getBaublesHandler(player).map(handler -> {
            for (int a = 0; a < handler.getSlots(); a++) {
                if (!handler.getStackInSlot(a).isEmpty() && handler.getStackInSlot(a).getItem() == bauble)
                    return a;
            }
            return -1;
        }).orElse(-1);
    }
}