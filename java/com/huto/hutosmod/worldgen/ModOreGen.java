package com.huto.hutosmod.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.google.common.collect.Lists;
import com.huto.hutosmod.init.BlockInit;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class ModOreGen {

	// OBUFSCATION HELPERS
	// func_242733_d(int) = MaxSpawnHeight 
	// func_242731_b(int) = MinSpawnHeight
	// OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a = FillerReplacement
	// Features.States.DIAMOND_ORE, 8 == chance?
	// func_242732_c(1) MaxVeinSiz

	public static void initGen() {
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE /* Feature Registering */,
				BlockInit.enchanted_ore.getId() /* Resource Location */,
				Feature.NO_SURFACE_ORE
						/* no_surface_ore */.withConfiguration(new OreFeatureConfig(
								OreFeatureConfig.FillerBlockType.field_241882_a /* base_stone_overworld */,
								BlockInit.enchanted_ore.get().getDefaultState(), 9))
						.withPlacement(Placement.field_242910_o /* depth */ .configure(new DepthAverageConfig(12, 12)))
						.func_242728_a()/* spreadHorizontally */.func_242732_c(5).func_242733_d(1)
		/* chance and size? */
		);
	}

	public static void setupGen() {
		for (Map.Entry<RegistryKey<Biome>, Biome> biome : WorldGenRegistries.BIOME
				.getEntries() /* Collection of Biome Entries */) {
			if (!biome.getValue().getCategory().equals(Biome.Category.NETHER)
					&& !biome.getValue().getCategory().equals(Biome.Category.THEEND)) {
				addFeatureToBiome(biome.getValue(), GenerationStage.Decoration.UNDERGROUND_ORES,
						WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(BlockInit.enchanted_ore.getId()));
			}
		}
	}

	public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration decoration,
			ConfiguredFeature<?, ?> configuredFeature) {
		List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = new ArrayList<>(
				biome.getGenerationSettings().getFeatures() /* List of Configured Features */
		);

		while (biomeFeatures.size() <= decoration.ordinal()) {
			biomeFeatures.add(Lists.newArrayList());
		}

		List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(biomeFeatures.get(decoration.ordinal()));
		features.add(() -> configuredFeature);
		biomeFeatures.set(decoration.ordinal(), features);

		/* Change field_242484_f that contains the Configured Features of the Biome */
		ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, biome.getGenerationSettings(),
				biomeFeatures, "field_242484_f");
	}
}