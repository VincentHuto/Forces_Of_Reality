package com.huto.forcesofreality.network.coven;

import java.util.function.Supplier;

import com.huto.forcesofreality.item.coven.tool.ItemMechanGlove;

import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.network.NetworkEvent;

public class PacketUpdateMechanModule {
	private int selected;
	private ItemStack stack;

	public PacketUpdateMechanModule(int selectedIn, ItemStack currentStack) {
		this.selected = selectedIn;
		this.stack = currentStack;
	}

	public static void encode(PacketUpdateMechanModule msg, FriendlyByteBuf buf) {
		buf.writeInt(msg.selected);
		buf.writeItemStack(msg.stack);
	}

	public static PacketUpdateMechanModule decode(FriendlyByteBuf buf) {
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
					glove.clearOldModuleUse(ctx.get().getSender(), stack, ctx.get().getSender().getEntityWorld());
					stack.getShareTag().putInt("selected", msg.selected);
					stack.getShareTag().put("selectedstack", msg.stack.write(new CompoundNBT()));
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}