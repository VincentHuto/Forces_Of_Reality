package com.huto.forces_of_reality.network.karma;

import java.util.function.Supplier;

import com.huto.forces_of_reality.capabilities.karma.IKarma;
import com.huto.forces_of_reality.capabilities.karma.KarmaProvider;
import com.huto.forces_of_reality.network.PacketHandler;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class KarmaPacketClient {

	public KarmaPacketClient() {

	}

	public static void handle(final KarmaPacketClient msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
			if (sender != null) {
				// Get the currency
				IKarma karma = sender.getCapability(KarmaProvider.KARMA_CAPA).orElseThrow(IllegalStateException::new);
				// Send message back to the client to set the information
				PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> sender),
						new KarmaPacketServer(karma.getKarma()));
			}
		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final KarmaPacketClient msg, final PacketBuffer packetBuffer) {

	}

	public static KarmaPacketClient decode(final PacketBuffer packetBuffer) {
		return new KarmaPacketClient();
	}
}