package com.vincenthuto.forcesofreality.network;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.network.coven.MechanGloveActionMessage;
import com.vincenthuto.forcesofreality.network.coven.MechanGloveOpenMessage;
import com.vincenthuto.forcesofreality.network.coven.PacketCovenantClient;
import com.vincenthuto.forcesofreality.network.coven.PacketCovenantServer;
import com.vincenthuto.forcesofreality.network.coven.PacketDirectorToggleFlightMode;
import com.vincenthuto.forcesofreality.network.coven.PacketToggleDirectorFlightModeMessage;
import com.vincenthuto.forcesofreality.network.coven.PacketUpdateMechanModule;
import com.vincenthuto.forcesofreality.network.coven.SetFlyPKT;
import com.vincenthuto.forcesofreality.network.coven.SetGlideAnim;
import com.vincenthuto.forcesofreality.network.coven.SetGlidePkt;
import com.vincenthuto.forcesofreality.network.coven.SyncCovenPacket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
	private static int networkID = 0;
	private static final String PROTOCOL_VERSION = "1";

	public static SimpleChannel INSTANCE;

	public static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
			.named(new ResourceLocation(ForcesOfReality.MOD_ID + ("main_channel")))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals).serverAcceptedVersions(PROTOCOL_VERSION::equals)
			.networkProtocolVersion(() -> PROTOCOL_VERSION).simpleChannel();

	public static final SimpleChannel CHANNELCOVENANT = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(ForcesOfReality.MOD_ID, "covenantchannel"), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

	public static final SimpleChannel CHANNELMODULETIER = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modulechannel"), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

	public static SimpleChannel MECHANGLOVE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(ForcesOfReality.MOD_ID, "mechanglovenetwork"), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

	public static void registerChannels() {
		// Register Networking packets

		// Covenant
		
		CHANNELCOVENANT.registerMessage(networkID++, PacketCovenantServer.class, PacketCovenantServer::encode, PacketCovenantServer::decode,
				PacketCovenantServer::handle);
		CHANNELCOVENANT.registerMessage(networkID++, PacketCovenantClient.class, PacketCovenantClient::encode, PacketCovenantClient::decode,
				PacketCovenantClient::handle);
		CHANNELCOVENANT.registerMessage(networkID++, SyncCovenPacket.class, SyncCovenPacket::encode, SyncCovenPacket::decode,
				SyncCovenPacket::handle);
		
//		CHANNELCOVENANT.registerMessage(networkID++, CovenantPacketClient.class, CovenantPacketClient::encode,
//				CovenantPacketClient::decode, CovenantPacketClient::handle);
//		CHANNELCOVENANT.registerMessage(networkID++, PacketCovenantServer.class, PacketCovenantServer::encode,
//				PacketCovenantServer::decode, PacketCovenantServer::handle);
//		CHANNELCOVENANT.messageBuilder(SyncCovenPacket.class, networkID++).encoder(SyncCovenPacket::encode)
//				.decoder(SyncCovenPacket::new).consumer(SyncCovenPacket::handle).add();
		// Fly
		HANDLER.registerMessage(networkID++, SetFlyPKT.class, SetFlyPKT::encode, SetFlyPKT::decode,
				SetFlyPKT.Handler::handle);
		HANDLER.registerMessage(networkID++, SetGlidePkt.class, SetGlidePkt::encode, SetGlidePkt::decode,
				SetGlidePkt.Handler::handle);
		HANDLER.registerMessage(networkID++, PacketUpdateMechanModule.class, PacketUpdateMechanModule::encode,
				PacketUpdateMechanModule::decode, PacketUpdateMechanModule.Handler::handle);
		HANDLER.registerMessage(networkID++, SetGlideAnim.class, SetGlideAnim::encode, SetGlideAnim::decode,
				SetGlideAnim.Handler::handle);
		// MindAdornments
		INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(ForcesOfReality.MOD_ID, "runechannel"),
				() -> "1.0", s -> true, s -> true);

		MECHANGLOVE.registerMessage(networkID++, MechanGloveActionMessage.class, MechanGloveActionMessage::encode,
				MechanGloveActionMessage::decode, MechanGloveActionMessage::handle);

		MECHANGLOVE.registerMessage(networkID++, PacketDirectorToggleFlightMode.class,
				PacketDirectorToggleFlightMode::encode, PacketDirectorToggleFlightMode::decode,
				PacketDirectorToggleFlightMode::handle);

		MECHANGLOVE.registerMessage(networkID++, MechanGloveOpenMessage.class, MechanGloveOpenMessage::encode,
				MechanGloveOpenMessage::decode, MechanGloveOpenMessage::handle);
		MECHANGLOVE.registerMessage(networkID++, PacketToggleDirectorFlightModeMessage.class,
				PacketToggleDirectorFlightModeMessage::encode, PacketToggleDirectorFlightModeMessage::decode,
				PacketToggleDirectorFlightModeMessage::handle);

	}

	public static void sendCovenToClients(SyncCovenPacket myPacket, Player affectedEntity) {
		CHANNELCOVENANT.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> affectedEntity), myPacket);
	}

}
