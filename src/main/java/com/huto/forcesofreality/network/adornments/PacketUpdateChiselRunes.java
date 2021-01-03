package com.huto.forcesofreality.network.adornments;
/*package com.huto.forcesofreality.network.adornments;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.huto.forcesofreality.containers.ContainerChiselStation;
import com.huto.forcesofreality.objects.tileenties.TileEntityChiselStation;

import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketUpdateChiselAdornments {
	private List<Integer> runes;

	public PacketUpdateChiselAdornments(List<Integer> runesIn) {
		this.runes = runesIn;
	}

	public static void encode(PacketUpdateChiselAdornments msg, PacketBuffer buf) {
		buf.writeInt(msg.runes.size());
		for (Integer i : msg.runes) {
			buf.writeInt(i);
		}
	}

	public static PacketUpdateChiselAdornments decode(PacketBuffer buf) {
		List<Integer> runesIn = new ArrayList<Integer>();
		int listSize = buf.readInt();
		for (int is = 0; is < listSize; is++) {
			runesIn.add(buf.readInt());
		}
		return new PacketUpdateChiselAdornments(runesIn);
	}

	public List<Integer> getAdornments() {
		return runes;
	}

	public static class Handler {

		public static void handle(final PacketUpdateChiselAdornments msg, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				Container container = ctx.get().getSender().openContainer;
				if (container instanceof ContainerChiselStation) {
					TileEntityChiselStation station = ((ContainerChiselStation) container).getTe();
					station.setAdornmentList(msg.getAdornments());
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}*/