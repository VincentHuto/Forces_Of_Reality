package com.huto.forcesofreality.enchantment;

import com.huto.forcesofreality.init.EnchantmentInit;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

public class EnchantmentBowBladeFlame extends Enchantment {
	public EnchantmentBowBladeFlame(Enchantment.Rarity rarityIn, EquipmentSlot... slots) {
		super(rarityIn, EnchantmentInit.BOWBLADE, slots);
	}

	/**
	 * Returns the minimal value of enchantability needed on the enchantment level
	 * passed.
	 */
	public int getMinEnchantability(int enchantmentLevel) {
		return 20;
	}

	public int getMaxEnchantability(int enchantmentLevel) {
		return 50;
	}

	/**
	 * Returns the maximum level that the enchantment can have.
	 */
	public int getMaxLevel() {
		return 1;
	}
}