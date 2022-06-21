package com.vincenthuto.forcesofreality.item.coven;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ItemNeuroticMechanism extends Item {

	public ItemNeuroticMechanism(Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(Component.translatable("A Scrap of what was Nonfunctioning ").withStyle(ChatFormatting.ITALIC));
		tooltip.add(Component.translatable("Machinery now Hums with a Twisted Will").withStyle(ChatFormatting.ITALIC));

		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public Component getName(ItemStack stack) {
		return Component.translatable(ChatFormatting.YELLOW + "Neurotic " + ChatFormatting.GOLD + "Mechanism ");
	}

}
