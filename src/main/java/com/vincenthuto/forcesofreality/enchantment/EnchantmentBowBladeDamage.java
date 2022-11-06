package com.vincenthuto.forcesofreality.enchantment;

import com.vincenthuto.forcesofreality.init.EnchantmentInit;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantmentBowBladeDamage extends Enchantment {
	@SuppressWarnings("unused")
	private static final String[] DAMAGE_NAMES = new String[] { "all", "undead", "arthropods" };
	private static final int[] MIN_COST = new int[] { 1, 5, 5 };
	private static final int[] LEVEL_COST = new int[] { 11, 8, 8 };
	private static final int[] LEVEL_COST_SPAN = new int[] { 20, 20, 20 };
	public final int damageType;

	public EnchantmentBowBladeDamage(Enchantment.Rarity rarityIn, int damageTypeIn, EquipmentSlot... slots) {
		super(rarityIn, EnchantmentInit.BOWBLADE, slots);
		this.damageType = damageTypeIn;
	}

	/**
	 * Determines if this enchantment can be applied to a specific ItemStack.
	 */
	@Override
	public boolean canEnchant(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canEnchant(stack);
	}

	/**
	 * Determines if the enchantment passed can be applyied together with this
	 * enchantment.
	 */
	@Override
	public boolean checkCompatibility(Enchantment ench) {
		return !(ench instanceof EnchantmentBowBladeDamage);
	}

	/**
	 * Called whenever a mob is damaged with an item that has this enchantment on
	 * it.
	 */
	@Override
	public void doPostAttack(LivingEntity user, Entity target, int level) {
		if (target instanceof LivingEntity) {
			LivingEntity livingentity = (LivingEntity) target;
			if (this.damageType == 2 && livingentity.getMobType() == MobType.ARTHROPOD) {
				int i = 20 + user.getRandom().nextInt(10 * level);
				livingentity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, i, 3));
			}
		}

	}

	/**
	 * Calculates the additional damage that will be dealt by an item with this
	 * enchantment. This alternative to calcModifierDamage is sensitive to the
	 * targets EnumCreatureAttribute.
	 */
	@Override
	public float getDamageBonus(int level, MobType creatureType) {
		if (this.damageType == 0) {
			return 1.0F + Math.max(0, level - 1) * 0.5F;
		} else if (this.damageType == 1 && creatureType == MobType.UNDEAD) {
			return level * 2.5F;
		} else {
			return this.damageType == 2 && creatureType == MobType.ARTHROPOD ? level * 2.5F : 0.0F;
		}
	}

	@Override
	public int getMaxCost(int enchantmentLevel) {
		return this.getMinCost(enchantmentLevel) + LEVEL_COST_SPAN[this.damageType];
	}

	/**
	 * Returns the maximum level that the enchantment can have.
	 */
	@Override
	public int getMaxLevel() {
		return 5;
	}

	/**
	 * Returns the minimal value of enchantability needed on the enchantment level
	 * passed.
	 */
	@Override
	public int getMinCost(int enchantmentLevel) {
		return MIN_COST[this.damageType] + (enchantmentLevel - 1) * LEVEL_COST[this.damageType];
	}
}