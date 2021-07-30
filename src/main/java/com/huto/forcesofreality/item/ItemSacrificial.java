package com.huto.forcesofreality.item;

import java.util.List;

import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.font.ModTextFormatting;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

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
	public void addInformation(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent(TextFormatting.GOLD+"Devoted Coven: " +  ModTextFormatting.toProperCase(coven.name())));
		tooltip.add(new StringTextComponent(TextFormatting.GREEN+"Sacrifical Worth: " +  devoAmount));

	}

}
