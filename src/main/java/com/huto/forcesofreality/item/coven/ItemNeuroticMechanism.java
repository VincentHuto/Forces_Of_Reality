package com.huto.forcesofreality.item.coven;

import java.util.List;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ItemNeuroticMechanism extends Item {

	public ItemNeuroticMechanism(Properties properties) {
		super(properties);
	}

	@Override
	public void addInformation(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(new TextComponent("A Scrap of what was Nonfunctioning ").mergeStyle(TextFormatting.ITALIC));
		tooltip.add(new StringTextComponent("Machinery now Hums with a Twisted Will").mergeStyle(TextFormatting.ITALIC));

		
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		return new StringTextComponent(TextFormatting.YELLOW + "Neurotic " + TextFormatting.GOLD + "Mechanism ");
	}

}
