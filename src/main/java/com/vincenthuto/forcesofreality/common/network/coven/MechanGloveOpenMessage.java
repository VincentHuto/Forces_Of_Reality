package com.vincenthuto.forcesofreality.common.network.coven;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.menu.ContainerMechanGlove;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.network.NetworkEvent;

public class MechanGloveOpenMessage {
	public static MechanGloveOpenMessage decode(final FriendlyByteBuf buffer) {
		buffer.readByte();
		return new MechanGloveOpenMessage();
	}

	public static void encode(final MechanGloveOpenMessage message, final FriendlyByteBuf buffer) {
		buffer.writeByte(0);
	}

	public static void handle(final MechanGloveOpenMessage message, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayer player = ctx.get().getSender();
			if (!ForcesOfReality.findMechanGlove(player).isEmpty()) {
				player.openMenu(new MenuProvider() {
					@Nullable
					@Override
					public AbstractContainerMenu createMenu(int p_createMenu_1_, Inventory p_createMenu_2_,
							Player p_createMenu_3_) {
						return new ContainerMechanGlove(p_createMenu_1_, p_createMenu_3_.level(),
								p_createMenu_3_.blockPosition(), p_createMenu_2_, p_createMenu_3_);
					}

					@Override
					public Component getDisplayName() {
						return ForcesOfReality.findMechanGlove(player).getHoverName();
					}
				});
			}
		});
		ctx.get().setPacketHandled(true);
	}
}