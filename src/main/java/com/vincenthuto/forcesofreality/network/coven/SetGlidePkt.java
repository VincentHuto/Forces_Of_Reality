package com.vincenthuto.forcesofreality.network.coven;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class SetGlidePkt {

	private boolean allowGlide;

	public SetGlidePkt(boolean allowGlide) {
		this.allowGlide = allowGlide;
	}

	public static void encode(SetGlidePkt msg, FriendlyByteBuf buf) {
		buf.writeBoolean(msg.allowGlide);
	}

	public static SetGlidePkt decode(FriendlyByteBuf buf) {
		return new SetGlidePkt(buf.readBoolean());
	}

	public static class Handler {

		public static void handle(final SetGlidePkt message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				if (message.allowGlide) {
					Minecraft.getInstance().player.startFallFlying();
				} else {
					Minecraft.getInstance().player.hasImpulse = false;
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}