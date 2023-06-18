package com.vincenthuto.forcesofreality.common.item.tool.coven.module;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemWickedModuleLaser extends ItemMechanModuleBase implements IModuleUse {

	public ItemWickedModuleLaser(Properties properties, int tier, String useTextIn) {
		super(properties, tier, useTextIn);
	}

	@Override
	public int getAllegianceChance() {
		return 35;
	}

	@Override
	public int getDamageCost() {
		return 25;
	}

	@Override
	public Component getName(ItemStack stack) {
		return Component
				.translatable(ChatFormatting.DARK_PURPLE + "Wicked Module: " + ChatFormatting.GOLD + "Eldritch Beam");
	}

	@Override
	public void use(Player playerIn, InteractionHand handIn, ItemStack itemStack, Level worldIn) {
		playerIn.startUsingItem(handIn);

	}

}
