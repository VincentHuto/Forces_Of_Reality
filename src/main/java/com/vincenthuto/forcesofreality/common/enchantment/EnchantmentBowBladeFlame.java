package com.vincenthuto.forcesofreality.common.enchantment;

import com.vincenthuto.forcesofreality.registry.EnchantmentInit;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantmentBowBladeFlame extends Enchantment {
	public EnchantmentBowBladeFlame(Enchantment.Rarity rarityIn, EquipmentSlot... slots) {
		super(rarityIn, EnchantmentInit.BOWBLADE, slots);
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