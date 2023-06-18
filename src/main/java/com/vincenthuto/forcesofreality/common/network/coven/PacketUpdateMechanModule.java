package com.vincenthuto.forcesofreality.common.network.coven;

import java.util.function.Supplier;

import com.vincenthuto.forcesofreality.common.item.coven.tool.ItemMechanGlove;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

public class PacketUpdateMechanModule {
	public static class Handler {
		public static void handle(final PacketUpdateMechanModule msg, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				ItemStack stack = ctx.get().getSender().getMainHandItem();
				if (stack.getItem() instanceof ItemMechanGlove) {
					ItemMechanGlove glove = (ItemMechanGlove) stack.getItem();
					glove.clearOldModuleUse(ctx.get().getSender(), stack,
							ctx.get().getSender().getCommandSenderWorld());
					stack.getShareTag().putInt("selected", msg.selected);
					stack.getShareTag().put("selectedstack", msg.stack.save(new CompoundTag()));
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
	public static PacketUpdateMechanModule decode(FriendlyByteBuf buf) {
		int select = buf.readInt();
		ItemStack stk = buf.readItem();
		return new PacketUpdateMechanModule(select, stk);
	}

	public static void encode(PacketUpdateMechanModule msg, FriendlyByteBuf buf) {
		buf.writeInt(msg.selected);
		buf.writeItem(msg.stack);
	}

	private int selected;

	private ItemStack stack;

	public PacketUpdateMechanModule(int selectedIn, ItemStack currentStack) {
		this.selected = selectedIn;
		this.stack = currentStack;
	}
}