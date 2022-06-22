package com.vincenthuto.forcesofreality.network.coven;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class PacketCovenantClient {

	public PacketCovenantClient() {

	}

	public static void handle(final PacketCovenantClient msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayer sender = ctx.get().getSender(); // the client that sent this packet
			if (sender != null) {
//				ICovenant covenant = sender.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalStateException::new);
//				PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> sender),
//						new PacketCovenantServer(covenant.getDevotion()));
			}
		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final PacketCovenantClient msg, final FriendlyByteBuf packetBuffer) {

	}

	public static PacketCovenantClient decode(final FriendlyByteBuf packetBuffer) {
		return new PacketCovenantClient();
	}
}