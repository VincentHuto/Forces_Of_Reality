package com.huto.forcesofreality.item.tool.coven.module;

import com.huto.forcesofreality.entity.projectile.EntityDreadRocketDirected;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemMechanModuleRocket extends ItemMechanModuleBase implements IModuleUse {

	public ItemMechanModuleRocket(Properties properties,int tier, String useTextIn) {
		super(properties,tier, useTextIn);
	}

	@Override
	public int getDamageCost() {
		return 2;
	}

	@Override
	public int getAllegianceChance() {
		return 10;
	}

	@Override
	public void use(PlayerEntity playerIn,Hand handIn, ItemStack itemStack, World worldIn) {
		EntityDreadRocketDirected miss = new EntityDreadRocketDirected((PlayerEntity) playerIn, false);
		miss.setPosition(playerIn.getPosX() - 0.5, playerIn.getPosY() + 0.6, playerIn.getPosZ() - 0.5);
		miss.setDirectionMotion(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.0F, 1.0F);
		System.out.println(miss.getThrower());
		worldIn.addEntity(miss);
	}

}
