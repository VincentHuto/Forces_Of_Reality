package com.huto.hutosmod.network;

import java.util.function.Supplier;

import com.huto.hutosmod.objects.items.tools.ItemMechanGlove;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketUpdateMechanModule {
	private int selected;
	private ItemStack stack;

	public PacketUpdateMechanModule(int selectedIn, ItemStack currentStack) {
		this.selected = selectedIn;
		this.stack = currentStack;
	}

	public static void encode(PacketUpdateMechanModule msg, PacketBuffer buf) {
		buf.writeInt(msg.selected);
		buf.writeItemStack(msg.stack);
	}

	public static PacketUpdateMechanModule decode(PacketBuffer buf) {
		int select = buf.readInt();
		ItemStack stk = buf.readItemStack();
		return new PacketUpdateMechanModule(select, stk);
	}

	public static class Handler {

		public static void handle(final PacketUpdateMechanModule msg, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				ItemStack stack = ctx.get().getSender().getHeldItemMainhand();
				if (stack.getItem() instanceof ItemMechanGlove) {
					ItemMechanGlove glove = (ItemMechanGlove) stack.getItem();
					stack.getShareTag().putInt(ItemMechanGlove.TAG_SELECTED, msg.selected);
					stack.getShareTag().put(ItemMechanGlove.TAG_SELECTEDSTACK, msg.stack.write(new CompoundNBT()));
					glove.setSelectedModuleSlot(msg.selected);
					glove.setModuleStack(msg.stack);
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}