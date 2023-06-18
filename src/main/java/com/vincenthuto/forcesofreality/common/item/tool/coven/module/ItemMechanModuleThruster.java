package com.vincenthuto.forcesofreality.common.item.tool.coven.module;

import com.vincenthuto.forcesofreality.common.item.armor.ItemSparkDirector;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemMechanModuleThruster extends ItemMechanModuleBase implements IModuleUse {

	public ItemMechanModuleThruster(Properties properties, int tier, String useTextIn) {
		super(properties, tier, useTextIn);
	}

	@Override
	public int getAllegianceChance() {
		return 10;
	}

	@Override
	public int getDamageCost() {
		return 2;
	}

	@Override
	public void use(Player playerIn, InteractionHand handIn, ItemStack itemStack, Level worldIn) {
		if (playerIn.getInventory().armor.get(2).getItem() instanceof ItemSparkDirector) {
			ItemStack armor = playerIn.getInventory().armor.get(2);
			if (armor.getOrCreateTag().getFloat("heightmodifier") == 0.1f) {
				armor.getOrCreateTag().putFloat("heightmodifier", 0.2f);
			} else {
				armor.getOrCreateTag().putFloat("heightmodifier", 0.1f);
			}
		}
	}

}
