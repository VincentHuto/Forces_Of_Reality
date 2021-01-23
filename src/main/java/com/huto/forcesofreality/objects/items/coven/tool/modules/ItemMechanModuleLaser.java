package com.huto.forcesofreality.objects.items.coven.tool.modules;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

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
	public void use(PlayerEntity playerIn,Hand handIn, ItemStack itemStack, World worldIn) {
		playerIn.setActiveHand(handIn);

	}

}
