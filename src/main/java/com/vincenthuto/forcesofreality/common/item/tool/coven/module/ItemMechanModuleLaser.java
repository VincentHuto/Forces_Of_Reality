package com.vincenthuto.forcesofreality.common.item.tool.coven.module;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemMechanModuleLaser extends ItemMechanModuleBase implements IModuleUse {

	public ItemMechanModuleLaser(Properties properties, int tier, String useTextIn) {
		super(properties, tier, useTextIn);
	}

	@Override
	public int getAllegianceChance() {
		return 20;
	}

	@Override
	public int getDamageCost() {
		return 10;
	}

	@Override
	public void use(Player playerIn, InteractionHand handIn, ItemStack itemStack, Level worldIn) {
		playerIn.startUsingItem(handIn);

	}

}
