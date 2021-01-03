package com.huto.forcesofreality.capabilities.adornments;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.LazyOptional;

public class AdornmentsApi {

	// Retrieves the Adornments inventory capability handler for the supplied player
	public static LazyOptional<IAdornmentsItemHandler> getAdornmentsHandler(PlayerEntity player) {
		return player.getCapability(AdornmentsCapabilities.ADORNMENTS);
	}

	public static int isAdornmentEquipped(PlayerEntity player, Item adornment) {
		return getAdornmentsHandler(player).map(handler -> {
			for (int a = 0; a < handler.getSlots(); a++) {
				if (!handler.getStackInSlot(a).isEmpty() && handler.getStackInSlot(a).getItem() == adornment)
					return a;
			}
			return -1;
		}).orElse(-1);
	}
}