package com.huto.forcesofreality.enchantment;

import com.huto.forcesofreality.init.EnchantmentInit;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.entity.EquipmentSlot;

public class EnchantmentBowBladePower extends Enchantment {
	public EnchantmentBowBladePower(Enchantment.Rarity rarityIn, EquipmentSlot... slots) {
		super(rarityIn, EnchantmentInit.BOWBLADE, slots);
	}

	/**
	 * Returns the minimal value of enchantability needed on the enchantment level
	 * passed.
	 */
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 1 + (enchantmentLevel - 1) * 10;
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel) + 15;
	}

	/**
	 * Returns the maximum level that the enchantment can have.
	 */
	@Override
	public int getMaxLevel() {
		return 5;
	}
}