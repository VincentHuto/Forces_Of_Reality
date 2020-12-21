package com.huto.forces_of_reality.network.karma;

import java.util.function.Supplier;

import com.huto.forces_of_reality.capabilities.karma.activation.KarmaActivationProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class KarmaActivationPacketServer {
	private int karma;

	public KarmaActivationPacketServer(int karmaIn) {
		this.karma = karmaIn;
	}

	// This code only runs on the client
	@SuppressWarnings("unused")
	public static void handle(final KarmaActivationPacketServer msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
			// Set the amount in the screen
			Minecraft.getInstance().player.getCapability(KarmaActivationProvider.KARMA_CAPA)
					.orElseThrow(IllegalStateException::new).setKarmaActivation(msg.karma);
		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final KarmaActivationPacketServer msg, final PacketBuffer packetBuffer) {
		packetBuffer.writeInt(msg.karma);
	}

	public static KarmaActivationPacketServer decode(final PacketBuffer packetBuffer) {
		return new KarmaActivationPacketServer(packetBuffer.readInt());
	}
}