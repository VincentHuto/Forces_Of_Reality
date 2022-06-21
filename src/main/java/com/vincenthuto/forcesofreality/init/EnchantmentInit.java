package com.vincenthuto.forcesofreality.init;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.enchantment.EnchantmentBowBladeDamage;
import com.vincenthuto.forcesofreality.enchantment.EnchantmentBowBladeFireAspect;
import com.vincenthuto.forcesofreality.enchantment.EnchantmentBowBladeFlame;
import com.vincenthuto.forcesofreality.enchantment.EnchantmentBowBladeInfinity;
import com.vincenthuto.forcesofreality.enchantment.EnchantmentBowBladeKnockBack;
import com.vincenthuto.forcesofreality.enchantment.EnchantmentBowBladePower;
import com.vincenthuto.forcesofreality.enchantment.EnchantmentBowBladePunch;
import com.vincenthuto.forcesofreality.enchantment.EnchantmentInfluenceSuppression;
import com.vincenthuto.forcesofreality.item.ModItemPredicates;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class EnchantmentInit {
	public static final DeferredRegister<Enchantment> ENCHANTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS,
			ForcesOfReality.MOD_ID);

	public static final EnchantmentCategory BOWBLADE = EnchantmentCategory.create("BOWBLADE", ModItemPredicates.BOWBLADE);

	public static final RegistryObject<Enchantment> bow_blade_sharpness = ENCHANTS.register("bow_blade_sharpness",
			() -> new EnchantmentBowBladeDamage(Enchantment.Rarity.COMMON, 0, EquipmentSlot.MAINHAND));
	public static final RegistryObject<Enchantment> bow_blade_smite = ENCHANTS.register("bow_blade_smite",
			() -> new EnchantmentBowBladeDamage(Enchantment.Rarity.UNCOMMON, 1, EquipmentSlot.MAINHAND));
	public static final RegistryObject<Enchantment> bow_blade_bane_of_arthropods = ENCHANTS.register(
			"bow_blade_bane_of_arthropods",
			() -> new EnchantmentBowBladeDamage(Enchantment.Rarity.UNCOMMON, 2, EquipmentSlot.MAINHAND));
	public static final RegistryObject<Enchantment> bow_blade_fire_aspect = ENCHANTS.register("bow_blade_fire_aspect",
			() -> new EnchantmentBowBladeFireAspect(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
	public static final RegistryObject<Enchantment> bow_blade_knockback = ENCHANTS.register("bow_blade_knockback",
			() -> new EnchantmentBowBladeKnockBack(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));

	public static final RegistryObject<Enchantment> bow_blade_power = ENCHANTS.register("bow_blade_power",
			() -> new EnchantmentBowBladePower(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND));

	public static final RegistryObject<Enchantment> bow_blade_flame = ENCHANTS.register("bow_blade_flame",
			() -> new EnchantmentBowBladeFlame(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND));

	public static final RegistryObject<Enchantment> bow_blade_punch = ENCHANTS.register("bow_blade_punch",
			() -> new EnchantmentBowBladePunch(Enchantment.Rarity.COMMON, EquipmentSlot.MAINHAND));
	public static final RegistryObject<Enchantment> bow_blade_infinity = ENCHANTS.register("bow_blade_infinity",
			() -> new EnchantmentBowBladeInfinity(Enchantment.Rarity.VERY_RARE, EquipmentSlot.MAINHAND));

	public static final RegistryObject<Enchantment> influence_suppression = ENCHANTS.register("influence_suppression",
			() -> new EnchantmentInfluenceSuppression(Enchantment.Rarity.VERY_RARE, EquipmentSlot.HEAD));

}
