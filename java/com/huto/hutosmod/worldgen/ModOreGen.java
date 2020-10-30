package com.huto.hutosmod.worldgen;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.BlockInit;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModOreGen {

	public static ConfiguredFeature<?, ?> EnchantedOreGen;
	public static ConfiguredFeature<?, ?> MysticEnchantedOreGen;

	public static void registerConfiguredFeatures() {
		Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
		EnchantedOreGen = Feature.ORE
				.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a,
						BlockInit.enchanted_ore.get().getDefaultState(), 10))
				.withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(3, 3, 40))).func_242729_a(1);
		Registry.register(registry, new ResourceLocation(HutosMod.MOD_ID, "enchanted_ore_gen"), EnchantedOreGen);

		
		MysticEnchantedOreGen = Feature.ORE
				.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a,
						BlockInit.enchanted_ore_mystic.get().getDefaultState(), 10))
				.withPlacement(Placement.field_242907_l.configure(new TopSolidRangeConfig(5, 5, 60))).func_242729_a(1);
		Registry.register(registry, new ResourceLocation(HutosMod.MOD_ID, "enchanted_ore_gen"), MysticEnchantedOreGen);

		
	}

	public static void addStuffToBiomes(BiomeLoadingEvent event) {
		RegistryKey<Biome> biome = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
		if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.VOID) && isValidBiome(event.getCategory())) {
			event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, EnchantedOreGen);
			event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, MysticEnchantedOreGen);

		}

	}

	private static boolean isValidBiome(Biome.Category biomeCategory) {
		// If this does weird things to unclassified biomes (Category.NONE), then we
		// should also mark that biome as invalid
		return biomeCategory != Biome.Category.THEEND && biomeCategory != Biome.Category.NETHER;
	}

}