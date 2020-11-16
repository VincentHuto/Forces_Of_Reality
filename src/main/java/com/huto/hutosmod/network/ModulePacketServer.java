package com.huto.hutosmod.network;

import java.util.function.Supplier;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class ModulePacketServer {
	private int karma;

	public ModulePacketServer(int karmaIn) {
		this.karma = karmaIn;
	}

	// This code only runs on the client
	@SuppressWarnings("unused")
	public static void handle(final ModulePacketServer msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
		//	ServerPlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
			// Set the amount in the screen
		/*	Minecraft.getInstance().player.getCapability(KarmaProvider.KARMA_CAPA)
					.orElseThrow(IllegalStateException::new).setKarma(msg.karma);*/
		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final ModulePacketServer msg, final PacketBuffer packetBuffer) {
		packetBuffer.writeInt(msg.karma);
	}

	public static ModulePacketServer decode(final PacketBuffer packetBuffer) {
		return new ModulePacketServer(packetBuffer.readInt());
	}
}