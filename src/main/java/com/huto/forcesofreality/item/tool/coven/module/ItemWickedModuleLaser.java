package com.huto.forcesofreality.item.tool.coven.module;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemWickedModuleLaser extends ItemMechanModuleBase implements IModuleUse {

	public ItemWickedModuleLaser(Properties properties, int tier, String useTextIn) {
		super(properties, tier, useTextIn);
	}

	@Override
	public int getDamageCost() {
		return 25;
	}

	@Override
	public int getAllegianceChance() {
		return 35;
	}

	@Override
	public void use(PlayerEntity playerIn, Hand handIn, ItemStack itemStack, World worldIn) {
		playerIn.setActiveHand(handIn);

	}

	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		return new StringTextComponent(
				TextFormatting.DARK_PURPLE + "Wicked Module: " + TextFormatting.GOLD + "Eldritch Beam");
	}

}
