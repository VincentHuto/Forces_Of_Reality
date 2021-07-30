package com.huto.forcesofreality.item.tool.coven.module;

import com.huto.forcesofreality.entity.projectile.EntityDreadRocketDirected;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

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
	public void use(Player playerIn,InteractionHand handIn, ItemStack itemStack, Level worldIn) {
		EntityDreadRocketDirected miss = new EntityDreadRocketDirected((Player) playerIn, false);
		miss.setPosition(playerIn.getPosX() - 0.5, playerIn.getPosY() + 0.6, playerIn.getPosZ() - 0.5);
		miss.setDirectionMotion(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.0F, 1.0F);
		System.out.println(miss.getThrower());
		worldIn.addEntity(miss);
	}

}
