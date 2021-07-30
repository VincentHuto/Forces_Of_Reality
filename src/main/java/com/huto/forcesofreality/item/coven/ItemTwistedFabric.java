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

public class ItemTwistedFabric extends Item {

	public ItemTwistedFabric(Properties properties) {
		super(properties);
	}

	@Override
	public void addInformation(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(new TextComponent("Somewhere Between Living Flesh").mergeStyle(TextFormatting.ITALIC));
		tooltip.add(new StringTextComponent("And Possesed Fabric...").mergeStyle(TextFormatting.ITALIC));

		
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		return new StringTextComponent(TextFormatting.DARK_PURPLE + "Twisted " + TextFormatting.YELLOW + "Fabric");
	}

}
