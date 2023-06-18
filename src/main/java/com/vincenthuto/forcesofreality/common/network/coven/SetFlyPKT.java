package com.vincenthuto.forcesofreality.common.network.coven;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

public class SetFlyPKT {

	public static class Handler {

		public static void handle(final SetFlyPKT message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				Minecraft.getInstance().player.getAbilities().mayfly = message.allowFlying;
				Minecraft.getInstance().player.getAbilities().flying = message.isFlying;
			});
			ctx.get().setPacketHandled(true);
		}
	}
	public static SetFlyPKT decode(FriendlyByteBuf buf) {
		return new SetFlyPKT(buf.readBoolean(), buf.readBoolean());
	}

	public static void encode(SetFlyPKT msg, FriendlyByteBuf buf) {
		buf.writeBoolean(msg.allowFlying);
		buf.writeBoolean(msg.isFlying);
	}

	private boolean allowFlying;

	private boolean isFlying;

	public SetFlyPKT(boolean allowFlying, boolean isFlying) {
		this.allowFlying = allowFlying;
		this.isFlying = isFlying;
	}
}