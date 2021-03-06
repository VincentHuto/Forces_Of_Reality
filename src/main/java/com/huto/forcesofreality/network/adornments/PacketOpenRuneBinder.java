package com.huto.forcesofreality.network.adornments;
/*package com.huto.forcesofreality.network.adornments;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.containers.ContainerAdornmentBinder;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketOpenAdornmentBinder {
	public static PacketOpenAdornmentBinder decode(final PacketBuffer buffer) {
		buffer.readByte();
		return new PacketOpenAdornmentBinder();
	}

	public static void encode(final PacketOpenAdornmentBinder message, final PacketBuffer buffer) {
		buffer.writeByte(0);
	}

	public static void handle(final PacketOpenAdornmentBinder message, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayerEntity player = ctx.get().getSender();
			if (!ForcesOfReality.findAdornmentBinder(player).isEmpty()) {
				player.openContainer(new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return ForcesOfReality.findAdornmentBinder(player).getDisplayName();
					}

					@Nullable
					@Override
					public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_,
							PlayerEntity p_createMenu_3_) {
						return new ContainerAdornmentBinder(p_createMenu_1_, p_createMenu_3_.world,
								p_createMenu_3_.getPosition(), p_createMenu_2_, p_createMenu_3_);
					}
				});
			}
		});
		ctx.get().setPacketHandled(true);
	}
}*/