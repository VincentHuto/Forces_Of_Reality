package com.vincenthuto.forcesofreality.network.coven;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraftforge.network.NetworkEvent;

public class PacketToggleDirectorFlightModeMessage {
	public static PacketToggleDirectorFlightModeMessage decode(final FriendlyByteBuf buffer) {
		boolean en = buffer.readBoolean();
		return new PacketToggleDirectorFlightModeMessage(en);
	}

	public static void encode(final PacketToggleDirectorFlightModeMessage message, final FriendlyByteBuf buffer) {
		buffer.writeBoolean(message.enabled);
	}

	public static void handle(final PacketToggleDirectorFlightModeMessage message,
			final Supplier<NetworkEvent.Context> ctx) {
		if (ctx.get().getDirection().getReceptionSide().isClient())
			ctx.get().enqueueWork(() -> {
				boolean flightMode = message.enabled;
				Minecraft.getInstance().player.displayClientMessage(Component.translatable(I18n
						.get(flightMode ? "forcesofreality.flightmodeenabled" : "forcesofreality.flightmodedisabled")),
						true);
			});
		ctx.get().setPacketHandled(true);
	}

	private boolean enabled;

	public PacketToggleDirectorFlightModeMessage(boolean enabled) {
		this.enabled = enabled;
	}
}