package com.vincenthuto.forcesofreality.common.item;

import java.util.List;

import com.vincenthuto.forcesofreality.client.font.ModTextFormatting;
import com.vincenthuto.forcesofreality.common.capability.covenant.EnumCovenants;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ItemSacrificial extends Item {

	public int devoAmount;
	public EnumCovenants coven;

	public ItemSacrificial(Properties prop, EnumCovenants covenIn, int devoIn) {
		super(prop);
		this.devoAmount = devoIn;
		this.coven = covenIn;
	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		tooltip.add(Component
				.translatable(ChatFormatting.GOLD + "Devoted Coven: " + ModTextFormatting.toProperCase(coven.name())));
		tooltip.add(Component.translatable(ChatFormatting.GREEN + "Sacrifical Worth: " + devoAmount));

	}

	public EnumCovenants getCoven() {
		return coven;
	}

	public int getDevoAmount() {
		return devoAmount;
	}

}
