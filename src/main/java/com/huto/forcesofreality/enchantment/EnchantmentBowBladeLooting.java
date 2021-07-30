package com.huto.forcesofreality.enchantment;

import com.huto.forcesofreality.init.EnchantmentInit;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.world.entity.EquipmentSlot;

public class EnchantmentBowBladeLooting extends Enchantment {
	public EnchantmentBowBladeLooting(Enchantment.Rarity rarityIn, EnchantmentCategory typeIn,
			EquipmentSlot... slots) {
		super(rarityIn, EnchantmentInit.BOWBLADE, slots);
	}

	/**
	 * Returns the minimal value of enchantability needed on the enchantment level
	 * passed.
	 */
	public int getMinEnchantability(int enchantmentLevel) {
		return 15 + (enchantmentLevel - 1) * 9;
	}

	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + 50;
	}

	/**
	 * Returns the maximum level that the enchantment can have.
	 */
	public int getMaxLevel() {
		return 3;
	}

	/**
	 * Determines if the enchantment passed can be applyied together with this
	 * enchantment.
	 */
	public boolean canApplyTogether(Enchantment ench) {
		return super.canApplyTogether(ench) && ench != Enchantments.SILK_TOUCH;
	}
}