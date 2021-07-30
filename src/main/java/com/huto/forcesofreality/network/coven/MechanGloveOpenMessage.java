package com.huto.forcesofreality.network.coven;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.container.ContainerMechanGlove;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

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
				player.openContainer(new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return ForcesOfReality.findMechanGlove(player).getDisplayName();
					}

					@Nullable
					@Override
					public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_,
							PlayerEntity p_createMenu_3_) {
						return new ContainerMechanGlove(p_createMenu_1_, p_createMenu_3_.world,
								p_createMenu_3_.getPosition(), p_createMenu_2_, p_createMenu_3_);
					}
				});
			}
		});
		ctx.get().setPacketHandled(true);
	}
}