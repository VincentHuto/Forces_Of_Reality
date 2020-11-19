package com.huto.hutosmod.network;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.network.mindrunes.OpenNormalInvPacket;
import com.huto.hutosmod.network.mindrunes.OpenRunesInvPacket;
import com.huto.hutosmod.network.mindrunes.SyncPacket;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler {
	private static int networkID = 0;
	private static final String PROTOCOL_VERSION = "1";

	public static SimpleChannel INSTANCE;

	public static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
			.named(new ResourceLocation(HutosMod.MOD_ID + ("main_channel")))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals).serverAcceptedVersions(PROTOCOL_VERSION::equals)
			.networkProtocolVersion(() -> PROTOCOL_VERSION).simpleChannel();
	public static final SimpleChannel CHANNELVIBES = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(HutosMod.MOD_ID, "vibrationchannel"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);
	public static final SimpleChannel CHANNELKARMA = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(HutosMod.MOD_ID, "karmachannel"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);
	public static final SimpleChannel CHANNELCOVENANT = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(HutosMod.MOD_ID, "covenantchannel"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);
	public static final SimpleChannel CHANNELMODULETIER = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(HutosMod.MOD_ID, "modulechannel"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals);

	public static void registerChannels() {
		// Register Networking packets
		// Vibes
		CHANNELVIBES.registerMessage(networkID++, VibrationPacketClient.class, VibrationPacketClient::encode,
				VibrationPacketClient::decode, VibrationPacketClient::handle);
		CHANNELVIBES.registerMessage(networkID++, VibrationPacketServer.class, VibrationPacketServer::encode,
				VibrationPacketServer::decode, VibrationPacketServer::handle);

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
		// Covenant
		CHANNELCOVENANT.registerMessage(networkID++, CovenantPacketClient.class, CovenantPacketClient::encode,
				CovenantPacketClient::decode, CovenantPacketClient::handle);
		CHANNELCOVENANT.registerMessage(networkID++, CovenantPacketServer.class, CovenantPacketServer::encode,
				CovenantPacketServer::decode, CovenantPacketServer::handle);

		// Fly
		HANDLER.registerMessage(networkID++, SetFlyPKT.class, SetFlyPKT::encode, SetFlyPKT::decode,
				SetFlyPKT.Handler::handle);
		HANDLER.registerMessage(networkID++, ImportVibePacket.class, ImportVibePacket::encode, ImportVibePacket::decode,
				ImportVibePacket.Handler::handle);
		HANDLER.registerMessage(networkID++, ExportVibePacket.class, ExportVibePacket::encode, ExportVibePacket::decode,
				ExportVibePacket.Handler::handle);

		HANDLER.registerMessage(networkID++, PacketUpdateChiselRunes.class, PacketUpdateChiselRunes::encode,
				PacketUpdateChiselRunes::decode, PacketUpdateChiselRunes.Handler::handle);
		HANDLER.registerMessage(networkID++, PacketChiselCraftingEvent.class, PacketChiselCraftingEvent::encode,
				PacketChiselCraftingEvent::decode, PacketChiselCraftingEvent.Handler::handle);
		HANDLER.registerMessage(networkID++, PacketUpdateMechanModule.class, PacketUpdateMechanModule::encode,
				PacketUpdateMechanModule::decode, PacketUpdateMechanModule.Handler::handle);

		// MindRunes
		INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(HutosMod.MOD_ID, "runechannel"), () -> "1.0",
				s -> true, s -> true);

		INSTANCE.registerMessage(networkID++, OpenRunesInvPacket.class, OpenRunesInvPacket::toBytes,
				OpenRunesInvPacket::new, OpenRunesInvPacket::handle);
		INSTANCE.registerMessage(networkID++, OpenNormalInvPacket.class, OpenNormalInvPacket::toBytes,
				OpenNormalInvPacket::new, OpenNormalInvPacket::handle);
		INSTANCE.registerMessage(networkID++, SyncPacket.class, SyncPacket::toBytes, SyncPacket::new,
				SyncPacket::handle);

	}

	public static SimpleChannel RUNEBINDER = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(HutosMod.MOD_ID, "runebindernetwork"), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);;

	public static SimpleChannel registerRuneBinderChannels() {
		RUNEBINDER.messageBuilder(TogglePickupMessage.class, networkID++).decoder(TogglePickupMessage::decode)
				.encoder(TogglePickupMessage::encode).consumer(TogglePickupMessage::handle).add();
		RUNEBINDER.messageBuilder(OpenMessage.class, networkID++).decoder(OpenMessage::decode)
				.encoder(OpenMessage::encode).consumer(OpenMessage::handle).add();
		RUNEBINDER.messageBuilder(ToggleMessageMessage.class, networkID++).decoder(ToggleMessageMessage::decode)
				.encoder(ToggleMessageMessage::encode).consumer(ToggleMessageMessage::handle).add();
		return RUNEBINDER;
	}

	public static SimpleChannel MECHANGLOVE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(HutosMod.MOD_ID, "mechanglovenetwork"), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);;

	public static SimpleChannel registerMechanGloveChannels() {
		MECHANGLOVE.messageBuilder(MechanGloveOpenMessage.class, networkID++).decoder(MechanGloveOpenMessage::decode)
				.encoder(MechanGloveOpenMessage::encode).consumer(MechanGloveOpenMessage::handle).add();
		MECHANGLOVE.messageBuilder(MechanGloveActionMessage.class, networkID++)
				.decoder(MechanGloveActionMessage::decode).encoder(MechanGloveActionMessage::encode)
				.consumer(MechanGloveActionMessage::handle).add();
		return MECHANGLOVE;
	}

}
