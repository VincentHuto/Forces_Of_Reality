package com.huto.forcesofreality.objects.items.coven.tool.modules;

import com.huto.forcesofreality.entities.projectiles.EntityShortCircuit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemMechanModuleShortCircuit extends ItemMechanModuleBase implements IModuleUse {

	public ItemMechanModuleShortCircuit(Properties properties, int tier, String useTextIn) {
		super(properties, tier, useTextIn);
	}

	@Override
	public int getDamageCost() {
		return 6;
	}

	@Override
	public int getAllegianceChance() {
		return 25;
	}

	@Override
	public void use(PlayerEntity playerIn, Hand handIn, ItemStack itemStack, World worldIn) {
		EntityShortCircuit miss = new EntityShortCircuit((PlayerEntity) playerIn, true);
		miss.setPosition(playerIn.getPosX() - 0.5, playerIn.getPosY() + 0.6, playerIn.getPosZ() - 0.5);
		miss.setDirectionMotion(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 5.0F, 1.0F);
		worldIn.addEntity(miss);
	}

}
