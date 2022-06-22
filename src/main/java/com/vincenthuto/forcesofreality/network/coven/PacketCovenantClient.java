package com.vincenthuto.forcesofreality.network.coven;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class CovenantPacketClient {

	public CovenantPacketClient() {

	}

	public static void handle(final CovenantPacketClient msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayer sender = ctx.get().getSender(); // the client that sent this packet
			if (sender != null) {
//				ICovenant covenant = sender.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalStateException::new);
//				PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> sender),
//						new CovenantPacketServer(covenant.getDevotion()));
			}
		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final CovenantPacketClient msg, final FriendlyByteBuf packetBuffer) {

	}

	public static CovenantPacketClient decode(final FriendlyByteBuf packetBuffer) {
		return new CovenantPacketClient();
	}
}