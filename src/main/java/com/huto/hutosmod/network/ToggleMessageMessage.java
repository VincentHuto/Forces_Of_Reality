package com.huto.hutosmod.network;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

public class ToggleMessageMessage {
	public ToggleMessageMessage(boolean enabled) {
		this.enabled = enabled;
	}

	private boolean enabled;

	public static ToggleMessageMessage decode(final PacketBuffer buffer) {
		boolean en = buffer.readBoolean();
		return new ToggleMessageMessage(en);
	}

	public static void encode(final ToggleMessageMessage message, final PacketBuffer buffer) {
		buffer.writeBoolean(message.enabled);
	}

	public static void handle(final ToggleMessageMessage message, final Supplier<NetworkEvent.Context> ctx) {
		if (ctx.get().getDirection().getReceptionSide().isClient())
			ctx.get().enqueueWork(() -> {
				boolean Pickup = message.enabled;
				Minecraft.getInstance().player.sendStatusMessage(
						new StringTextComponent(I18n.format(
								Pickup ? "hutosmod.autopickupenabled" : "hutosmod.autopickupdisabled")),
						true);
			});
		ctx.get().setPacketHandled(true);
	}
}