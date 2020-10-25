package com.huto.hutosmod.network;

import java.util.function.Supplier;

import com.huto.hutosmod.containers.FilterContainer;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class FilterMessage {
	public FilterMessage(int opts) {
		this.opts = opts;
	}

	private int opts;

	public static FilterMessage decode(final PacketBuffer buffer) {
		return new FilterMessage(buffer.readInt());
	}

	public static void encode(final FilterMessage message, final PacketBuffer buffer) {
		buffer.writeInt(message.opts);
	}

	public static void handle(final FilterMessage message, final Supplier<NetworkEvent.Context> ctx) {
		if (ctx.get().getDirection().getReceptionSide().isServer())
			ctx.get().enqueueWork(() -> {
				ServerPlayerEntity player = ctx.get().getSender();
				if (player != null && player.openContainer instanceof FilterContainer)
					((FilterContainer) player.openContainer).saveFilter(message.opts);

			});
		ctx.get().setPacketHandled(true);
	}
}