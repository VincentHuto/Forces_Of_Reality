package com.vincenthuto.forcesofreality.common.enchantment;

import com.vincenthuto.forcesofreality.registry.EnchantmentInit;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.MendingEnchantment;

public class EnchantmentBowBladeInfinity extends Enchantment {
	public EnchantmentBowBladeInfinity(Enchantment.Rarity rarityIn, EquipmentSlot... slots) {
		super(rarityIn, EnchantmentInit.BOWBLADE, slots);
	}

	/**
	 * Determines if the enchantment passed can be applyied together with this
	 * enchantment.
	 */
	@Override
	public boolean checkCompatibility(Enchantment ench) {
		return ench instanceof MendingEnchantment ? false : super.checkCompatibility(ench);
	}

	@Override
	public int getMaxCost(int enchantmentLevel) {
		return 50;
	}

	/**
	 * Returns the maximum level that the enchantment can have.
	 */
	@Override
	public int getMaxLevel() {
		return 1;
	}

	/**
	 * Returns the minimal value of enchantability needed on the enchantment level
	 * passed.
	 */
	@Override
	public int getMinCost(int enchantmentLevel) {
		return 20;
	}
}