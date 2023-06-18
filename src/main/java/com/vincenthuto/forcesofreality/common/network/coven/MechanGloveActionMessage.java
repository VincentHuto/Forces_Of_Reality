package com.vincenthuto.forcesofreality.common.network.coven;

import java.util.function.Supplier;

import com.vincenthuto.forcesofreality.common.item.coven.tool.ItemMechanGlove;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

public class MechanGloveActionMessage {
	public static MechanGloveActionMessage decode(final FriendlyByteBuf buffer) {
		return new MechanGloveActionMessage();
	}

	public static void encode(final MechanGloveActionMessage message, final FriendlyByteBuf buffer) {
	}

	public static void handle(final MechanGloveActionMessage message, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			Player player = ctx.get().getSender();
			if (player == null)
				return;

			if (player.getMainHandItem().getItem() instanceof ItemMechanGlove) {
				((ItemMechanGlove) player.getMainHandItem().getItem()).moduleUse(player, InteractionHand.MAIN_HAND,
						player.getMainHandItem(), player.getCommandSenderWorld());
			}
			if (player.getOffhandItem().getItem() instanceof ItemMechanGlove) {
				((ItemMechanGlove) player.getOffhandItem().getItem()).moduleUse(player, InteractionHand.OFF_HAND,
						player.getOffhandItem(), player.getCommandSenderWorld());
			}
		});
		ctx.get().setPacketHandled(true);
	}
}