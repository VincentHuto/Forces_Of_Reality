package com.huto.forcesofreality.network.adornment;
/*package com.huto.forcesofreality.network.adornments;

import java.util.function.Supplier;

import com.huto.forcesofreality.containers.ContainerChiselStation;
import com.huto.forcesofreality.objects.tileenties.TileEntityChiselStation;

import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketChiselCraftingEvent {

	public PacketChiselCraftingEvent() {
	}

	public static void encode(PacketChiselCraftingEvent msg, PacketBuffer buf) {
	}

	public static PacketChiselCraftingEvent decode(PacketBuffer buf) {
		return new PacketChiselCraftingEvent();
	}

	public static class Handler {

		public static void handle(final PacketChiselCraftingEvent msg, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				Container container = ctx.get().getSender().openContainer;
				if (container instanceof ContainerChiselStation) {
					TileEntityChiselStation station = ((ContainerChiselStation) container).getTe();
					station.craftEvent();
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}*/