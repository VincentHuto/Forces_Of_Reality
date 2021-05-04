package com.huto.forcesofreality.network;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.models.animation.AnimationPacket;
import com.huto.forcesofreality.network.adornments.OpenAdornmentsInvPacket;
import com.huto.forcesofreality.network.adornments.OpenNormalInvPacket;
import com.huto.forcesofreality.network.adornments.SyncPacket;
import com.huto.forcesofreality.network.coven.CovenantPacketClient;
import com.huto.forcesofreality.network.coven.CovenantPacketServer;
import com.huto.forcesofreality.network.coven.MechanGloveActionMessage;
import com.huto.forcesofreality.network.coven.MechanGloveOpenMessage;
import com.huto.forcesofreality.network.coven.PacketDirectorToggleFlightMode;
import com.huto.forcesofreality.network.coven.PacketToggleDirectorFlightModeMessage;
import com.huto.forcesofreality.network.coven.PacketUpdateMechanModule;
import com.huto.forcesofreality.network.coven.SetFlyPKT;
import com.huto.forcesofreality.network.coven.SetGlideAnim;
import com.huto.forcesofreality.network.coven.SetGlidePkt;
import com.huto.forcesofreality.network.coven.SyncCovenPacket;
import com.huto.forcesofreality.network.coven.SyncKarmaPacket;
import com.huto.forcesofreality.network.karma.KarmaActivationPacketClient;
import com.huto.forcesofreality.network.karma.KarmaActivationPacketServer;
import com.huto.forcesofreality.network.karma.KarmaPacketClient;
import com.huto.forcesofreality.network.karma.KarmaPacketServer;
import com.huto.forcesofreality.network.vibes.ExportVibePacket;
import com.huto.forcesofreality.network.vibes.ImportVibePacket;
import com.huto.forcesofreality.network.vibes.UpdateChunkEnergyValueMessage;
import com.huto.forcesofreality.network.vibes.VibrationPacketClient;
import com.huto.forcesofreality.network.vibes.VibrationPacketServer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler {
	private static int networkID = 0;
	private static final String PROTOCOL_VERSION = "1";

	public static SimpleChannel INSTANCE;

	public static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
			.named(new ResourceLocation(ForcesOfReality.MOD_ID + ("main_channel")))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals).serverAcceptedVersions(PROTOCOL_VERSION::equals)
			.networkProtocolVersion(() -> PROTOCOL_VERSION).simpleChannel();
	public static final SimpleChannel CHANNELVIBES = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(ForcesOfReality.MOD_ID, "vibrationchannel"), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	public static final SimpleChannel CHANNELKARMA = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(ForcesOfReality.MOD_ID, "karmachannel"), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

	public static final SimpleChannel CHANNELCOVENANT = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(ForcesOfReality.MOD_ID, "covenantchannel"), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	public static final SimpleChannel CHANNELMODULETIER = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modulechannel"), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	public static final SimpleChannel ANIMATIONS = NetworkRegistry.ChannelBuilder
			.named(new ResourceLocation(ForcesOfReality.MOD_ID, "animchannel"))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals).serverAcceptedVersions(PROTOCOL_VERSION::equals)
			.networkProtocolVersion(() -> PROTOCOL_VERSION).simpleChannel();

	public static void registerChannels() {
		// Register Networking packets
		ANIMATIONS.messageBuilder(AnimationPacket.class, networkID++, NetworkDirection.PLAY_TO_CLIENT)
				.encoder(AnimationPacket::encode).decoder(AnimationPacket::new).consumer(AnimationPacket::handle).add();

		// Vibes
		CHANNELVIBES.registerMessage(networkID++, VibrationPacketClient.class, VibrationPacketClient::encode,
				VibrationPacketClient::decode, VibrationPacketClient::handle);
		CHANNELVIBES.registerMessage(networkID++, VibrationPacketServer.class, VibrationPacketServer::encode,
				VibrationPacketServer::decode, VibrationPacketServer::handle);
		CHANNELVIBES.registerMessage(networkID++, UpdateChunkEnergyValueMessage.class,
				UpdateChunkEnergyValueMessage::encode, UpdateChunkEnergyValueMessage::decode,
				UpdateChunkEnergyValueMessage::handle);

		// Karma
		CHANNELKARMA.registerMessage(networkID++, KarmaPacketClient.class, KarmaPacketClient::encode,
				KarmaPacketClient::decode, KarmaPacketClient::handle);
		CHANNELKARMA.registerMessage(networkID++, KarmaPacketServer.class, KarmaPacketServer::encode,
				KarmaPacketServer::decode, KarmaPacketServer::handle);
		CHANNELKARMA.registerMessage(networkID++, KarmaActivationPacketClient.class,
				KarmaActivationPacketClient::encode, KarmaActivationPacketClient::decode,
				KarmaActivationPacketClient::handle);
		CHANNELKARMA.registerMessage(networkID++, KarmaActivationPacketServer.class,
				KarmaActivationPacketServer::encode, KarmaActivationPacketServer::decode,
				KarmaActivationPacketServer::handle);
		CHANNELKARMA.messageBuilder(SyncKarmaPacket.class, networkID++).encoder(SyncKarmaPacket::encode)
				.decoder(SyncKarmaPacket::new).consumer(SyncKarmaPacket::handle).add();

		// Covenant
		CHANNELCOVENANT.registerMessage(networkID++, CovenantPacketClient.class, CovenantPacketClient::encode,
				CovenantPacketClient::decode, CovenantPacketClient::handle);
		CHANNELCOVENANT.registerMessage(networkID++, CovenantPacketServer.class, CovenantPacketServer::encode,
				CovenantPacketServer::decode, CovenantPacketServer::handle);
		CHANNELCOVENANT.messageBuilder(SyncCovenPacket.class, networkID++).encoder(SyncCovenPacket::encode)
				.decoder(SyncCovenPacket::new).consumer(SyncCovenPacket::handle).add();
		// Fly
		HANDLER.registerMessage(networkID++, SetFlyPKT.class, SetFlyPKT::encode, SetFlyPKT::decode,
				SetFlyPKT.Handler::handle);
		HANDLER.registerMessage(networkID++, SetGlidePkt.class, SetGlidePkt::encode, SetGlidePkt::decode,
				SetGlidePkt.Handler::handle);
		HANDLER.registerMessage(networkID++, ImportVibePacket.class, ImportVibePacket::encode, ImportVibePacket::decode,
				ImportVibePacket.Handler::handle);
		HANDLER.registerMessage(networkID++, ExportVibePacket.class, ExportVibePacket::encode, ExportVibePacket::decode,
				ExportVibePacket.Handler::handle);
		HANDLER.registerMessage(networkID++, PacketUpdateMechanModule.class, PacketUpdateMechanModule::encode,
				PacketUpdateMechanModule::decode, PacketUpdateMechanModule.Handler::handle);
		HANDLER.registerMessage(networkID++, SetGlideAnim.class, SetGlideAnim::encode, SetGlideAnim::decode,
				SetGlideAnim.Handler::handle);
		// MindAdornments
		INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(ForcesOfReality.MOD_ID, "runechannel"),
				() -> "1.0", s -> true, s -> true);

		INSTANCE.registerMessage(networkID++, OpenAdornmentsInvPacket.class, OpenAdornmentsInvPacket::toBytes,
				OpenAdornmentsInvPacket::new, OpenAdornmentsInvPacket::handle);
		INSTANCE.registerMessage(networkID++, OpenNormalInvPacket.class, OpenNormalInvPacket::toBytes,
				OpenNormalInvPacket::new, OpenNormalInvPacket::handle);
		INSTANCE.registerMessage(networkID++, SyncPacket.class, SyncPacket::toBytes, SyncPacket::new,
				SyncPacket::handle);

	}

	public static SimpleChannel MECHANGLOVE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(ForcesOfReality.MOD_ID, "mechanglovenetwork"), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);;

	public static SimpleChannel registerMechanGloveChannels() {
		MECHANGLOVE.messageBuilder(MechanGloveOpenMessage.class, networkID++).decoder(MechanGloveOpenMessage::decode)
				.encoder(MechanGloveOpenMessage::encode).consumer(MechanGloveOpenMessage::handle).add();
		MECHANGLOVE.messageBuilder(MechanGloveActionMessage.class, networkID++)
				.decoder(MechanGloveActionMessage::decode).encoder(MechanGloveActionMessage::encode)
				.consumer(MechanGloveActionMessage::handle).add();

		MECHANGLOVE.messageBuilder(PacketDirectorToggleFlightMode.class, networkID++)
				.decoder(PacketDirectorToggleFlightMode::decode).encoder(PacketDirectorToggleFlightMode::encode)
				.consumer(PacketDirectorToggleFlightMode::handle).add();
		MECHANGLOVE.messageBuilder(PacketToggleDirectorFlightModeMessage.class, networkID++)
				.decoder(PacketToggleDirectorFlightModeMessage::decode)
				.encoder(PacketToggleDirectorFlightModeMessage::encode)
				.consumer(PacketToggleDirectorFlightModeMessage::handle).add();

		return MECHANGLOVE;
	}

	public static void sendToClients(SyncKarmaPacket myPacket, PlayerEntity affectedEntity) {
		CHANNELKARMA.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> affectedEntity), myPacket);
	}

	public static void sendCovenToClients(SyncCovenPacket myPacket, PlayerEntity affectedEntity) {
		CHANNELCOVENANT.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> affectedEntity), myPacket);
	}

}
