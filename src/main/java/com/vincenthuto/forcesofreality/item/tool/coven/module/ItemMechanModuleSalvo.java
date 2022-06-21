package com.vincenthuto.forcesofreality.item.tool.coven.module;

import com.vincenthuto.forcesofreality.entity.projectile.EntityDreadRocket;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemMechanModuleSalvo extends ItemMechanModuleBase implements IModuleUse {

	public ItemMechanModuleSalvo(Properties properties, int tier, String useTextIn) {
		super(properties, tier, useTextIn);
	}

	@Override
	public int getAllegianceChance() {
		return 20;
	}

	@Override
	public int getDamageCost() {
		return 4;
	}

	@Override
	public void use(Player playerIn, InteractionHand handIn, ItemStack itemStack, Level worldIn) {
		EntityDreadRocket[] missArray = new EntityDreadRocket[5];
		for (int i = 0; i < 5; i++) {
			missArray[i] = new EntityDreadRocket(playerIn, false);
			missArray[i].setPos(playerIn.getX() + ((Math.random() - 0.5) * 3.5), playerIn.getY() + 0.3,
					playerIn.getZ() + ((Math.random() - 0.5) * 3.5));
			worldIn.addFreshEntity(missArray[i]);
		}
	}

}
