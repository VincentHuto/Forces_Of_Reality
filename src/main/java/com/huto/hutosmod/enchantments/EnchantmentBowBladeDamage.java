package com.huto.hutosmod.enchantments;

import com.huto.hutosmod.init.EnchantmentInit;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class EnchantmentBowBladeDamage extends Enchantment {
	@SuppressWarnings("unused")
	private static final String[] DAMAGE_NAMES = new String[] { "all", "undead", "arthropods" };
	private static final int[] MIN_COST = new int[] { 1, 5, 5 };
	private static final int[] LEVEL_COST = new int[] { 11, 8, 8 };
	private static final int[] LEVEL_COST_SPAN = new int[] { 20, 20, 20 };
	public final int damageType;

	public EnchantmentBowBladeDamage(Enchantment.Rarity rarityIn, int damageTypeIn, EquipmentSlotType... slots) {
		super(rarityIn, EnchantmentInit.BOWBLADE, slots);
		this.damageType = damageTypeIn;
	}

	/**
	 * Returns the minimal value of enchantability needed on the enchantment level
	 * passed.
	 */
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return MIN_COST[this.damageType] + (enchantmentLevel - 1) * LEVEL_COST[this.damageType];
	}

	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return this.getMinEnchantability(enchantmentLevel) + LEVEL_COST_SPAN[this.damageType];
	}

	/**
	 * Returns the maximum level that the enchantment can have.
	 */
	@Override
	public int getMaxLevel() {
		return 5;
	}

	/**
	 * Calculates the additional damage that will be dealt by an item with this
	 * enchantment. This alternative to calcModifierDamage is sensitive to the
	 * targets EnumCreatureAttribute.
	 */
	@Override
	public float calcDamageByCreature(int level, CreatureAttribute creatureType) {
		if (this.damageType == 0) {
			return 1.0F + (float) Math.max(0, level - 1) * 0.5F;
		} else if (this.damageType == 1 && creatureType == CreatureAttribute.UNDEAD) {
			return (float) level * 2.5F;
		} else {
			return this.damageType == 2 && creatureType == CreatureAttribute.ARTHROPOD ? (float) level * 2.5F : 0.0F;
		}
	}

	/**
	 * Determines if the enchantment passed can be applyied together with this
	 * enchantment.
	 */
	@Override
	public boolean canApplyTogether(Enchantment ench) {
		return !(ench instanceof EnchantmentBowBladeDamage);
	}

	/**
	 * Determines if this enchantment can be applied to a specific ItemStack.
	 */
	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApply(stack);
	}

	/**
	 * Called whenever a mob is damaged with an item that has this enchantment on
	 * it.
	 */
	@Override
	public void onEntityDamaged(LivingEntity user, Entity target, int level) {
		if (target instanceof LivingEntity) {
			LivingEntity livingentity = (LivingEntity) target;
			if (this.damageType == 2 && livingentity.getCreatureAttribute() == CreatureAttribute.ARTHROPOD) {
				int i = 20 + user.getRNG().nextInt(10 * level);
				livingentity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, i, 3));
			}
		}

	}
}