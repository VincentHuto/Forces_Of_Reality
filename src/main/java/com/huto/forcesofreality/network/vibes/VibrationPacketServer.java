package com.huto.forcesofreality.network.vibes;

import java.util.function.Supplier;

import com.huto.forcesofreality.capabilities.vibes.VibrationProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class VibrationPacketServer {
	private float vibes;

	public VibrationPacketServer(float vibesIn) {
		this.vibes = vibesIn;
	}

	// This code only runs on the client
	@SuppressWarnings("unused")
	public static void handle(final VibrationPacketServer msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
			Minecraft.getInstance().player.getCapability(VibrationProvider.VIBE_CAPA)
					.orElseThrow(IllegalStateException::new).setVibes(msg.vibes);
		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final VibrationPacketServer msg, final PacketBuffer packetBuffer) {
		packetBuffer.writeFloat(msg.vibes);
	}

	public static VibrationPacketServer decode(final PacketBuffer packetBuffer) {
		return new VibrationPacketServer(packetBuffer.readFloat());
	}
}