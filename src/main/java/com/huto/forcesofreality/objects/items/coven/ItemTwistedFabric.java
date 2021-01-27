package com.huto.forcesofreality.objects.items.coven;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemTwistedFabric extends Item {

	public ItemTwistedFabric(Properties properties) {
		super(properties);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("Eldritch corruption meets ").mergeStyle(TextFormatting.ITALIC));
		tooltip.add(new StringTextComponent("Living Fabric...What Could Go Wrong?").mergeStyle(TextFormatting.ITALIC));

		
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		return new StringTextComponent(TextFormatting.DARK_PURPLE + "Twisted " + TextFormatting.YELLOW + "Fabric");
	}

}
