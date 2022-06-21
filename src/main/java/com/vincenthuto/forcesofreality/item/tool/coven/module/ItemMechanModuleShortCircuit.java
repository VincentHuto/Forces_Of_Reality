package com.vincenthuto.forcesofreality.item.tool.coven.module;

import com.vincenthuto.forcesofreality.entity.projectile.EntityShortCircuit;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemMechanModuleShortCircuit extends ItemMechanModuleBase implements IModuleUse {

	public ItemMechanModuleShortCircuit(Properties properties, int tier, String useTextIn) {
		super(properties, tier, useTextIn);
	}

	@Override
	public int getAllegianceChance() {
		return 25;
	}

	@Override
	public int getDamageCost() {
		return 6;
	}

	@Override
	public void use(Player playerIn, InteractionHand handIn, ItemStack itemStack, Level worldIn) {
		EntityShortCircuit miss = new EntityShortCircuit(playerIn, true);
		miss.setPos(playerIn.getX() - 0.5, playerIn.getY() + 0.6, playerIn.getZ() - 0.5);
		miss.setDirectionMotion(playerIn, playerIn.getXRot(), playerIn.getYRot(), 0.0F, 5.0F, 1.0F);
		worldIn.addFreshEntity(miss);
	}

}
