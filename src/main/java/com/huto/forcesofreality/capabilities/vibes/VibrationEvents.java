package com.huto.forcesofreality.capabilities.vibes;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.vibes.VibrationPacketServer;
import com.huto.forcesofreality.objects.tileenties.vibes.TileModVibes;
import com.huto.forcesofreality.objects.tileenties.vibes.TileVibeSimpleInventory;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class VibrationEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity) {
			event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "vibrations"), new VibrationProvider());
		}
	}

	@SubscribeEvent
	public static void attachCapabilitiesTile(final AttachCapabilitiesEvent<TileEntity> event) {
		if (event.getObject() instanceof TileVibeSimpleInventory) {
			event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "vibrations"), new VibrationProvider());
		}
		if (event.getObject() instanceof TileModVibes) {
			event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "vibrations"), new VibrationProvider());
		}
	}

	@SubscribeEvent
	public static void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		float amount = VibrationProvider.getPlayerVibes(player);
		PacketHandler.CHANNELVIBES.send(PacketDistributor.PLAYER.with(() -> player), new VibrationPacketServer(amount));
		player.sendStatusMessage(
				new StringTextComponent("Welcome! Current Resonance: " + TextFormatting.GOLD + amount + "Hz"), false);
	}

	@SubscribeEvent
	public static void onDimensionChange(PlayerChangedDimensionEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		float amount = VibrationProvider.getPlayerVibes(player);
		PacketHandler.CHANNELVIBES.send(PacketDistributor.PLAYER.with(() -> player), new VibrationPacketServer(amount));
		player.sendStatusMessage(
				new StringTextComponent("Welcome! Current Resonance: " + TextFormatting.GOLD + amount + "Hz"), false);
	}

	@SubscribeEvent
	public static void playerDeath(PlayerEvent.Clone event) {
		IVibrations vibesOld = event.getOriginal().getCapability(VibrationProvider.VIBE_CAPA)
				.orElseThrow(IllegalStateException::new);
		IVibrations vibesNew = event.getEntity().getCapability(VibrationProvider.VIBE_CAPA)
				.orElseThrow(IllegalStateException::new);
		vibesNew.setVibes(vibesOld.getVibes() - 20f);
		((PlayerEntity) event.getEntity()).sendStatusMessage(
				new StringTextComponent(TextFormatting.ITALIC + "Upon death, your resonance has decreased to: "
						+ TextFormatting.RED + TextFormatting.ITALIC + vibesNew.getVibes() + "Hz"),
				false);
	}

}
