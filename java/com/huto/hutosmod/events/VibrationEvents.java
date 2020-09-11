package com.huto.hutosmod.events;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.capabilities.IVibrations;
import com.huto.hutosmod.capabilities.VibrationProvider;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.VibrationPacketServer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class VibrationEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity) {
			System.out.println("Attatches Capability");
			event.addCapability(new ResourceLocation(HutosMod.MOD_ID, "vibrations"), new VibrationProvider());
		}
	}

	@SubscribeEvent
	public static void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		float amount = VibrationProvider.getPlayerVibes(player);
		PacketHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), new VibrationPacketServer(amount));
		player.sendStatusMessage(
				new StringTextComponent("Welcome! Current Resonance: " + TextFormatting.GOLD + amount + "Hz"), false);
	}

	public static void playerDeath(PlayerEvent.Clone event) {
		IVibrations currencyOld = event.getOriginal().getCapability(VibrationProvider.VIBE_CAPA)
				.orElseThrow(IllegalStateException::new);
		IVibrations currencyNew = event.getEntity().getCapability(VibrationProvider.VIBE_CAPA)
				.orElseThrow(IllegalStateException::new);
		currencyNew.setVibes(currencyOld.getVibes() - 20f);
		((PlayerEntity) event.getEntity()).sendStatusMessage(
				new StringTextComponent(TextFormatting.ITALIC + "Upon death, your resonance has decreased to: "
						+ TextFormatting.RED + TextFormatting.ITALIC + currencyNew.getVibes() + "Hz"),
				false);
	}
}
