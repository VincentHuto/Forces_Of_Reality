package com.huto.hutosmod.objects.items;

import java.util.List;

import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.font.ModTextFormatting;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemSacrificial extends Item {

	public int devoAmount;
	public EnumCovenants coven;

	public ItemSacrificial(Properties prop, EnumCovenants covenIn, int devoIn) {
		super(prop);
		this.devoAmount = devoIn;
		this.coven = covenIn;
	}

	public int getDevoAmount() {
		return devoAmount;
	}

	public EnumCovenants getCoven() {
		return coven;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent(TextFormatting.GOLD+"Devoted Coven: " +  ModTextFormatting.toProperCase(coven.name())));
		tooltip.add(new StringTextComponent(TextFormatting.GREEN+"Devoted Amount: " +  devoAmount));

	}

}
