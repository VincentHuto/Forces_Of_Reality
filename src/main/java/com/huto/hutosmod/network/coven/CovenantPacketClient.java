package com.huto.hutosmod.network.coven;

import java.util.function.Supplier;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.network.PacketHandler;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class CovenantPacketClient {

	public CovenantPacketClient() {

	}

	public static void handle(final CovenantPacketClient msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
			if (sender != null) {
				ICovenant covenant = sender.getCapability(CovenantProvider.COVEN_CAPA)
						.orElseThrow(IllegalStateException::new);
				PacketHandler.CHANNELCOVENANT.send(PacketDistributor.PLAYER.with(() -> sender),
						new CovenantPacketServer(covenant.getDevotion()));
			}
		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final CovenantPacketClient msg, final PacketBuffer packetBuffer) {

	}

	public static CovenantPacketClient decode(final PacketBuffer packetBuffer) {
		return new CovenantPacketClient();
	}
}