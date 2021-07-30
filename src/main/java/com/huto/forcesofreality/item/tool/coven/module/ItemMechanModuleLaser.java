package com.huto.forcesofreality.item.tool.coven.module;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ItemMechanModuleLaser extends ItemMechanModuleBase implements IModuleUse {

	public ItemMechanModuleLaser(Properties properties,int tier, String useTextIn) {
		super(properties,tier, useTextIn);
	}

	@Override
	public int getDamageCost() {
		return 10;
	}

	@Override
	public int getAllegianceChance() {
		return 20;
	}

	@Override
	public void use(Player playerIn,InteractionHand handIn, ItemStack itemStack, Level worldIn) {
		playerIn.setActiveHand(handIn);

	}

}
