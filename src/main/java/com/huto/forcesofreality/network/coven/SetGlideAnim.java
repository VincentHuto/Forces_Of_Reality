package com.huto.forcesofreality.network.coven;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.network.NetworkEvent;

public class SetGlideAnim {

	public SetGlideAnim() {
	}

	public static void encode(SetGlideAnim msg, FriendlyByteBuf buf) {
	}

	public static SetGlideAnim decode(FriendlyByteBuf buf) {
		return new SetGlideAnim();
	}

	public static class Handler {

		public static void handle(final SetGlideAnim message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				ctx.get().getSender().startFallFlying();
			});
			ctx.get().setPacketHandled(true);
		}
	}
}