package com.huto.hutosmod.network.karma;

import java.util.function.Supplier;

import com.huto.hutosmod.capabilities.karma.activation.IKarmaActivation;
import com.huto.hutosmod.capabilities.karma.activation.KarmaActivationProvider;
import com.huto.hutosmod.network.PacketHandler;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class KarmaActivationPacketClient {

	public KarmaActivationPacketClient() {

	}

	public static void handle(final KarmaActivationPacketClient msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
			if (sender != null) {
				// Get the currency
				IKarmaActivation karma = sender.getCapability(KarmaActivationProvider.KARMA_CAPA)
						.orElseThrow(IllegalStateException::new);
				// Send message back to the client to set the information
				PacketHandler.CHANNELKARMA.send(PacketDistributor.PLAYER.with(() -> sender),
						new KarmaActivationPacketServer(karma.getActivation()));
			}
		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final KarmaActivationPacketClient msg, final PacketBuffer packetBuffer) {

	}

	public static KarmaActivationPacketClient decode(final PacketBuffer packetBuffer) {
		return new KarmaActivationPacketClient();
	}
}