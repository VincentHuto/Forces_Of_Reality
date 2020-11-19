package com.huto.hutosmod.network;

import java.util.function.Supplier;

import com.huto.hutosmod.objects.items.tools.ItemMechanGlove;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class MechanGloveActionMessage {
	public static MechanGloveActionMessage decode(final PacketBuffer buffer) {
		buffer.readByte();
		return new MechanGloveActionMessage();
	}

	public static void encode(final MechanGloveActionMessage message, final PacketBuffer buffer) {
		buffer.writeByte(0);
	}

	public static void handle(final MechanGloveActionMessage message, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			PlayerEntity player = ctx.get().getSender();
			if (player == null)
				return;
			if (player.getHeldItemMainhand().getItem() instanceof ItemMechanGlove) {
				((ItemMechanGlove) player.getHeldItemMainhand().getItem()).moduleUse(player,
						player.getHeldItemMainhand(), player.getEntityWorld());
			}
			if (player.getHeldItemOffhand().getItem() instanceof ItemMechanGlove) {
				((ItemMechanGlove) player.getHeldItemOffhand().getItem()).moduleUse(player, player.getHeldItemOffhand(),
						player.getEntityWorld());
			}
		});
		ctx.get().setPacketHandled(true);
	}
}