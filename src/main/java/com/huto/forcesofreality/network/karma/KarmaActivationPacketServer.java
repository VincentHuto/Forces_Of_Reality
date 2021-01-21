package com.huto.forcesofreality.network.karma;

import java.util.function.Supplier;

import com.huto.forcesofreality.capabilities.karma.activation.KarmaActivationProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
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
            PlayerEntity player = Minecraft.getInstance().player;
            if(player != null) {
                if (player instanceof PlayerEntity) {
                	player.getCapability(KarmaActivationProvider.KARMA_CAPA)
					.orElseThrow(IllegalStateException::new).setKarmaActivation(msg.karma);
                }
            }
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