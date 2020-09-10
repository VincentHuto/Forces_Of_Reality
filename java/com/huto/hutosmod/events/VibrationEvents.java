package com.huto.hutosmod.events;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.capabilities.IVibrations;
import com.huto.hutosmod.capabilities.VibrationProvider;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class VibrationEvents {
	// Event used to attach the currency to all players
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity) {
			System.out.println("Attatches Capability");
			event.addCapability(new ResourceLocation(HutosMod.MOD_ID, "vibrations"), new VibrationProvider());
		}
	}

	// Event used to clone the current currency to the new one. If the event is not
	// present, then it will start anew
	@SubscribeEvent
	public static void playerDeath(PlayerEvent.Clone event) {
		IVibrations currencyOld = event.getOriginal().getCapability(VibrationProvider.VIBE_CAPA)
				.orElseThrow(IllegalStateException::new);
		IVibrations currencyNew = event.getEntity().getCapability(VibrationProvider.VIBE_CAPA)
				.orElseThrow(IllegalStateException::new);
		currencyNew.setVibes(currencyOld.getVibes());
	}
}
