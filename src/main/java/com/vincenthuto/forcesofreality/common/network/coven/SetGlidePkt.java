package com.vincenthuto.forcesofreality.common.network.coven;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class SetGlidePkt {

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

	public static SetGlidePkt decode(FriendlyByteBuf buf) {
		return new SetGlidePkt(buf.readBoolean());
	}

	public static void encode(SetGlidePkt msg, FriendlyByteBuf buf) {
		buf.writeBoolean(msg.allowGlide);
	}

	private boolean allowGlide;

	public SetGlidePkt(boolean allowGlide) {
		this.allowGlide = allowGlide;
	}
}