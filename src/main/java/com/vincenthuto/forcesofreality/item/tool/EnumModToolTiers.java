package com.vincenthuto.forcesofreality.item.tool;

import java.util.function.Supplier;

import com.vincenthuto.forcesofreality.init.ItemInit;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum EnumModToolTiers implements Tier {

	/*
	 * NULL(5, 1024, 10.0F, 5.0F, 25, () -> { return
	 * Ingredient.fromItems(ItemInit.shattered_ingot.get()); }),
	 *
	 * MYSTIC(4, 512, 8.0F, 4.0F, 20, () -> { return
	 * Ingredient.fromItems(ItemInit.emanating_ingot.get()); }),
	 */ AURIC(6, 2048, 9.0F, 5.0F, 30, () -> {
		return Ingredient.of(ItemInit.auric_ingot.get());
	}), OLD_IRON(5, 1024, 3.0F, 7.0F, 10, () -> {
		return Ingredient.of(ItemInit.anointed_iron_scrap.get());
	});

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyLoadedValue<Ingredient> repairMaterial;

	private EnumModToolTiers(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn,
			int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantability = enchantabilityIn;
		this.repairMaterial = new LazyLoadedValue<>(repairMaterialIn);
	}

	@Override
	public float getAttackDamageBonus() {
		return this.attackDamage;
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}

	@Override
	public int getLevel() {
		return this.harvestLevel;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairMaterial.get();
	}

	@Override
	public float getSpeed() {
		return this.efficiency;
	}

	@Override
	public int getUses() {
		return this.maxUses;
	}
}