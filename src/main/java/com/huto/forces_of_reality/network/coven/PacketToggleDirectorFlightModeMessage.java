package com.huto.forces_of_reality.network.coven;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketToggleDirectorFlightModeMessage {
	public PacketToggleDirectorFlightModeMessage(boolean enabled) {
		this.enabled = enabled;
	}
	private boolean enabled;
	public static PacketToggleDirectorFlightModeMessage decode(final PacketBuffer buffer) {
		boolean en = buffer.readBoolean();
		return new PacketToggleDirectorFlightModeMessage(en);
	}

	public static void encode(final PacketToggleDirectorFlightModeMessage message, final PacketBuffer buffer) {
		buffer.writeBoolean(message.enabled);
	}

	public static void handle(final PacketToggleDirectorFlightModeMessage message, final Supplier<NetworkEvent.Context> ctx) {
		if (ctx.get().getDirection().getReceptionSide().isClient())
			ctx.get().enqueueWork(() -> {
				boolean flightMode = message.enabled;
				Minecraft.getInstance().player.sendStatusMessage(
						new StringTextComponent(I18n.format(
								flightMode ? "forces_of_reality.flightmodeenabled" : "forces_of_reality.flightmodedisabled")),
						true);
			});
		ctx.get().setPacketHandled(true);
	}
}