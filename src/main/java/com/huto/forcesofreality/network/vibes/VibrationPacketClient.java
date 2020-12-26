package com.huto.forcesofreality.network.vibes;

import java.util.function.Supplier;

import com.huto.forcesofreality.capabilities.vibes.IVibrations;
import com.huto.forcesofreality.capabilities.vibes.VibrationProvider;
import com.huto.forcesofreality.network.PacketHandler;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class VibrationPacketClient {

	public VibrationPacketClient() {

	}

	public static void handle(final VibrationPacketClient msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
			if (sender != null) {
				// Get the currency
				IVibrations vibes = sender.getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);
				// Send message back to the client to set the information
				PacketHandler.CHANNELVIBES.send(PacketDistributor.PLAYER.with(() -> sender),
						new VibrationPacketServer(vibes.getVibes()));
			}
		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final VibrationPacketClient msg, final PacketBuffer packetBuffer) {

	}

	public static VibrationPacketClient decode(final PacketBuffer packetBuffer) {
		return new VibrationPacketClient();
	}
}