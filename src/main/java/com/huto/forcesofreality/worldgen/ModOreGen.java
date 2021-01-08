package com.huto.forcesofreality.worldgen;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.init.BlockInit;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModOreGen {

	public static final RuleTest SOMNOLENT_STONE_DREAMLANDS = new BlockMatchRuleTest(BlockInit.somnolent_stone.get());

	public static ConfiguredFeature<?, ?> EnchantedOreGen;
	public static ConfiguredFeature<?, ?> SomnolentEnchantedOreGen;
	public static ConfiguredFeature<?, ?> GeodeOreGen;

	public static void registerConfiguredFeatures() {
		Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
		EnchantedOreGen = Feature.ORE
				.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.somnolent_ore_somnolent.get().getDefaultState(), 10))
				.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(5, 5, 60))).chance(1);

		Registry.register(registry, new ResourceLocation(ForcesOfReality.MOD_ID, "enchanted_ore_gen"), EnchantedOreGen);

		SomnolentEnchantedOreGen = Feature.ORE
				.withConfiguration(new OreFeatureConfig(SOMNOLENT_STONE_DREAMLANDS,
						BlockInit.somnolent_ore.get().getDefaultState(), 10))
				.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(3, 3, 140))).chance(1);
		Registry.register(registry, new ResourceLocation(ForcesOfReality.MOD_ID, "enchanted_ore_mystic_gen"),
				SomnolentEnchantedOreGen);

		GeodeOreGen = Feature.ORE
				.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
						BlockInit.stone_geode.get().getDefaultState(), 3))
				.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(2, 2, 20))).chance(1);
		Registry.register(registry, new ResourceLocation(ForcesOfReality.MOD_ID, "geode_ore_gen"), EnchantedOreGen);

	}

	public static void addStuffToBiomes(BiomeLoadingEvent event) {
		RegistryKey<Biome> biome = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
		if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.VOID) && isValidBiome(event.getCategory())) {
			event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, EnchantedOreGen);
			event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, SomnolentEnchantedOreGen);
			event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, GeodeOreGen);

		}

	}

	private static boolean isValidBiome(Biome.Category biomeCategory) {
		// If this does weird things to unclassified biomes (Category.NONE), then we
		// should also mark that biome as invalid
		return biomeCategory != Biome.Category.THEEND && biomeCategory != Biome.Category.NETHER;
	}

}