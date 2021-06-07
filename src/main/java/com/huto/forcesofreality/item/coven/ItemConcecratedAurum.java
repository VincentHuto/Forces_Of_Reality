package com.huto.forcesofreality.item.coven;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemConcecratedAurum extends Item {

	public ItemConcecratedAurum(Properties properties) {
		super(properties);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("A Stange Flowing Amalgam of ").mergeStyle(TextFormatting.ITALIC));
		tooltip.add(new StringTextComponent("Holy Steel and Enchanted Bronze").mergeStyle(TextFormatting.ITALIC));

		
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		return new StringTextComponent(TextFormatting.AQUA + "Concecrated " + TextFormatting.GOLD + "Aurum");
	}

}
