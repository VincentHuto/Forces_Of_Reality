package com.huto.forcesofreality.enchantment;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

public class EnchantmentInfluenceSuppression extends Enchantment {
	public EnchantmentInfluenceSuppression(Enchantment.Rarity rarityIn, EquipmentSlot... slots) {
		super(rarityIn, EnchantmentCategory.ARMOR_HEAD, slots);
	}

	/**
	 * Returns the minimal value of enchantability needed on the enchantment level
	 * passed.
	 */
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 10 + 20 * (enchantmentLevel - 1);
	}
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return super.getMinEnchantability(enchantmentLevel) + 50;
	}

	/**
	 * Returns the maximum level that the enchantment can have.
	 */
	@Override
	public int getMaxLevel() {
		return 1;
	}

	/**
	 * Determines if this enchantment can be applied to a specific ItemStack.
	 */
	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof ArmorItem ? true : super.canApply(stack);
	}

}
