package com.huto.forcesofreality.capabilitie.adornment;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.util.LazyOptional;

public class AdornmentsApi {

	// Retrieves the Adornments inventory capability handler for the supplied player
	public static LazyOptional<IAdornmentsItemHandler> getAdornmentsHandler(Player player) {
		return player.getCapability(AdornmentsCapabilities.ADORNMENTS);
	}

	public static int isAdornmentEquipped(Player player, Item adornment) {
		return getAdornmentsHandler(player).map(handler -> {
			for (int a = 0; a < handler.getSlots(); a++) {
				if (!handler.getStackInSlot(a).isEmpty() && handler.getStackInSlot(a).getItem() == adornment)
					return a;
			}
			return -1;
		}).orElse(-1);
	}
}