package com.vincenthuto.forcesofreality.common.item.tool.coven.module;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemMechanModuleBlade extends ItemMechanModuleBase implements IModuleUse {

	public ItemMechanModuleBlade(Properties properties, int tier, String useTextIn) {
		super(properties, tier, useTextIn);
	}

	@Override
	public int getAllegianceChance() {
		return 5;
	}

	@Override
	public int getDamageCost() {
		return 2;
	}

	@Override
	public void use(Player playerIn, InteractionHand handIn, ItemStack itemStack, Level worldIn) {
		if (!itemStack.getTag().getBoolean("swordstate")) {
			itemStack.getTag().putBoolean("swordstate", true);
		} else {
			itemStack.getTag().putBoolean("swordstate", false);
		}
	}

}
