package com.vincenthuto.forcesofreality.common.network.coven;

import java.util.function.Supplier;

import com.vincenthuto.forcesofreality.common.item.armor.ItemSparkDirector;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

public class PacketDirectorToggleFlightMode {
	public static PacketDirectorToggleFlightMode decode(final FriendlyByteBuf buffer) {
		buffer.readByte();
		return new PacketDirectorToggleFlightMode();
	}

	public static void encode(final PacketDirectorToggleFlightMode message, final FriendlyByteBuf buffer) {
		buffer.writeByte(0);
	}

	public static void handle(final PacketDirectorToggleFlightMode message, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			Player player = ctx.get().getSender();
			if (player == null)
				return;
			if (player.getInventory().getArmor(2).getItem() instanceof ItemSparkDirector) {
				((ItemSparkDirector) player.getInventory().getArmor(2).getItem()).toggleFlightMode(player,
						player.getInventory().getArmor(2));
			}
		});
		ctx.get().setPacketHandled(true);
	}
}