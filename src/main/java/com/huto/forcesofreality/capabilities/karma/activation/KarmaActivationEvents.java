package com.huto.forcesofreality.capabilities.karma.activation;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.SyncKarmaPacket;
import com.huto.forcesofreality.network.karma.KarmaPacketServer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class KarmaActivationEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity) {
			KarmaActivationProvider provider = new KarmaActivationProvider();
			event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "karmaactivation"),
					new KarmaActivationProvider());
			event.addListener(provider::invalidate);
		}
	}
	
	

	@SubscribeEvent
	public static void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayerEntity) {
			ServerPlayerEntity player = (ServerPlayerEntity) event.getEntity();
			player.getCapability(KarmaActivationProvider.KARMA_CAPA).ifPresent(kar -> {
				PacketHandler.sendToClients(new SyncKarmaPacket(kar.getEnabled(), player.getEntityId()), player);
				PacketHandler.CHANNELKARMA.send(
						PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> (ServerPlayerEntity) player),
						new SyncKarmaPacket(kar.getEnabled(), player.getEntityId()));
			});

		}
	}

	@SubscribeEvent
	public static void onDimensionChange(PlayerChangedDimensionEvent event) {
		ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
		int amount = KarmaActivationProvider.getPlayerKarma(player);
		PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> player), new KarmaPacketServer(amount));
		IKarmaActivation act = player.getCapability(KarmaActivationProvider.KARMA_CAPA)
				.orElseThrow(IllegalStateException::new);
		player.sendStatusMessage(
				new StringTextComponent("Welcome! Current Karma: " + TextFormatting.GOLD + act.getEnabled()), false);
	}

	@SubscribeEvent
	public static void playerDeath(PlayerEvent.Clone event) {
		IKarmaActivation karmaOld = event.getOriginal().getCapability(KarmaActivationProvider.KARMA_CAPA)
				.orElseThrow(IllegalStateException::new);
		IKarmaActivation karmaNew = event.getEntity().getCapability(KarmaActivationProvider.KARMA_CAPA)
				.orElseThrow(IllegalStateException::new);
		karmaNew.setKarmaActivation(karmaOld.getActivation());
	}
}
