package com.huto.forcesofreality.network.coven;

import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class SetGlidePkt {

	private boolean allowGlide;

	public SetGlidePkt(boolean allowGlide) {
		this.allowGlide = allowGlide;
	}

	public static void encode(SetGlidePkt msg, PacketBuffer buf) {
		buf.writeBoolean(msg.allowGlide);
	}

	public static SetGlidePkt decode(PacketBuffer buf) {
		return new SetGlidePkt(buf.readBoolean());
	}

	public static class Handler {

		public static void handle(final SetGlidePkt message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				if (message.allowGlide) {
					Minecraft.getInstance().player.startFallFlying();
				} else {
					Minecraft.getInstance().player.isAirBorne = false;
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}