package com.huto.forcesofreality.objects.items.coven.tool.modules;

import com.huto.forcesofreality.objects.items.armor.ItemSparkDirector;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemMechanModuleThruster extends ItemMechanModuleBase implements IModuleUse {

	public ItemMechanModuleThruster(Properties properties,int tier, String useTextIn) {
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
		if (playerIn.inventory.armorInventory.get(2).getItem() instanceof ItemSparkDirector) {
			ItemStack armor = playerIn.inventory.armorInventory.get(2);
			if (armor.getOrCreateTag().getFloat("heightmodifier") == 0.1f) {
				armor.getOrCreateTag().putFloat("heightmodifier", 0.2f);
			} else {
				armor.getOrCreateTag().putFloat("heightmodifier", 0.1f);
			}
		}
	}

}
