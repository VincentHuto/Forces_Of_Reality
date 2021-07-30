package com.huto.forcesofreality.item.tool.coven.module;

import com.huto.forcesofreality.entity.projectile.EntityDreadRocket;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ItemMechanModuleSalvo extends ItemMechanModuleBase implements IModuleUse {

	public ItemMechanModuleSalvo(Properties properties,int tier, String useTextIn) {
		super(properties,tier, useTextIn);
	}

	@Override
	public int getDamageCost() {
		return 4;
	}

	@Override
	public int getAllegianceChance() {
		return 20;
	}

	@Override
	public void use(Player playerIn,InteractionHand handIn, ItemStack itemStack, Level worldIn) {
		EntityDreadRocket[] missArray = new EntityDreadRocket[5];
		for (int i = 0; i < 5; i++) {
			missArray[i] = new EntityDreadRocket((Player) playerIn, false);
			missArray[i].setPosition(playerIn.getPosX() + ((Math.random() - 0.5) * 3.5), playerIn.getPosY() + 0.3,
					playerIn.getPosZ() + ((Math.random() - 0.5) * 3.5));
			worldIn.addEntity(missArray[i]);
		}
	}

}
