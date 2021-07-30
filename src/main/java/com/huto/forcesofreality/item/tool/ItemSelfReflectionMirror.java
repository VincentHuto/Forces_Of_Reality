package com.huto.forcesofreality.item.tool;

import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.adornment.OpenAdornmentsInvPacket;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ItemSelfReflectionMirror extends Item {

	public ItemSelfReflectionMirror(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {
		if (worldIn.isRemote) {
			PacketHandler.INSTANCE.sendToServer(new OpenAdornmentsInvPacket());
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
