package com.vincenthuto.forcesofreality.common.item.coven;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ItemConcecratedAurum extends Item {

	public ItemConcecratedAurum(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(Component.translatable("A Stange Flowing Amalgam of ").withStyle(ChatFormatting.ITALIC));
		tooltip.add(Component.translatable("Holy Steel and Enchanted Bronze").withStyle(ChatFormatting.ITALIC));

		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public Component getName(ItemStack stack) {
		return Component.translatable(ChatFormatting.AQUA + "Concecrated " + ChatFormatting.GOLD + "Aurum");
	}

}
