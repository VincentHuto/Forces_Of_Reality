package com.huto.hutosmod.network;

import java.util.function.Supplier;

import com.huto.hutosmod.objects.items.tools.ItemMechanGlove;

import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketUpdateMechanModule {
	private int selected;

	public PacketUpdateMechanModule(int selectedIn) {
		this.selected = selectedIn;
	}

	public static void encode(PacketUpdateMechanModule msg, PacketBuffer buf) {
		buf.writeInt(msg.selected);
	}

	public static PacketUpdateMechanModule decode(PacketBuffer buf) {
		int select = buf.readInt();
		return new PacketUpdateMechanModule(select);
	}


	public static class Handler {

		public static void handle(final PacketUpdateMechanModule msg, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				ItemStack stack = ctx.get().getSender().getHeldItemMainhand();
				if(stack.getItem() instanceof ItemMechanGlove) {
					stack.getTag().putInt("selected", msg.selected);
					System.out.println(stack.getShareTag().get("selected"));
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}