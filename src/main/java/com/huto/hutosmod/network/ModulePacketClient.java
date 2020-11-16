package com.huto.hutosmod.network;

import java.util.function.Supplier;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class ModulePacketClient {

	public ModulePacketClient() {

	}

	public static void handle(final ModulePacketClient msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
			if (sender != null) {
				// Get the currency
			//	IKarma karma = sender.getCapability(KarmaProvider.KARMA_CAPA).orElseThrow(IllegalStateException::new);
				// Send message back to the client to set the information
				/*PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> sender),
						new ModulePacketServer(karma.getKarma()));*/
			}
		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final ModulePacketClient msg, final PacketBuffer packetBuffer) {

	}

	public static ModulePacketClient decode(final PacketBuffer packetBuffer) {
		return new ModulePacketClient();
	}
}