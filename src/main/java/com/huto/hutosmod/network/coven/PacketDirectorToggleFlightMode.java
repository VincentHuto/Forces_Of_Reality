package com.huto.hutosmod.network.coven;

import java.util.function.Supplier;

import com.huto.hutosmod.objects.items.armor.ItemSparkDirector;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketDirectorToggleFlightMode {
	public static PacketDirectorToggleFlightMode decode(final PacketBuffer buffer) {
		buffer.readByte();
		return new PacketDirectorToggleFlightMode();
	}

	public static void encode(final PacketDirectorToggleFlightMode message, final PacketBuffer buffer) {
		buffer.writeByte(0);
	}

	public static void handle(final PacketDirectorToggleFlightMode message, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			PlayerEntity player = ctx.get().getSender();
			if (player == null)
				return;
			if (player.inventory.armorItemInSlot(2).getItem() instanceof ItemSparkDirector) {
				((ItemSparkDirector) player.inventory.armorItemInSlot(2).getItem()).toggleFlightMode(player,
						player.inventory.armorItemInSlot(2));
			}
		});
		ctx.get().setPacketHandled(true);
	}
}