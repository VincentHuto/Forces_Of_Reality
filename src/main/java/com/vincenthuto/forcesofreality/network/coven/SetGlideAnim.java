package com.vincenthuto.forcesofreality.network.coven;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class SetGlideAnim {

	public static class Handler {

		public static void handle(final SetGlideAnim message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				ctx.get().getSender().startFallFlying();
			});
			ctx.get().setPacketHandled(true);
		}
	}

	public static SetGlideAnim decode(FriendlyByteBuf buf) {
		return new SetGlideAnim();
	}

	public static void encode(SetGlideAnim msg, FriendlyByteBuf buf) {
	}

	public SetGlideAnim() {
	}
}