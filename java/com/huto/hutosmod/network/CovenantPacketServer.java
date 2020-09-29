package com.huto.hutosmod.network;

import java.util.function.Supplier;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class CovenantPacketServer {
	private String covenant;

	public CovenantPacketServer(String covenIn) {
		this.covenant = covenIn;
	}

	// This code only runs on the client
	@SuppressWarnings("unused")
	public static void handle(final CovenantPacketServer msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
			// Set the amount in the screen
			Minecraft.getInstance().player.getCapability(CovenantProvider.COVEN_CAPA)
					.orElseThrow(IllegalStateException::new).setCovenant(EnumCovenants.valueOf(msg.covenant));
		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final CovenantPacketServer msg, final PacketBuffer packetBuffer) {
		packetBuffer.writeString(msg.covenant);
	}

	public static CovenantPacketServer decode(final PacketBuffer packetBuffer) {
		return new CovenantPacketServer(packetBuffer.readString());
	}
}