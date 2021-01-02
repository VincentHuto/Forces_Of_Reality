package com.huto.forcesofreality.worldgen;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.init.BlockInit;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModFeatures {

	public static final BlockClusterFeatureConfig BREAKOUT_POINT = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.essence_breakout_point.get().getDefaultState()),
			new SimpleBlockPlacer())).tries(64).xSpread(20).ySpread(128).zSpread(20).build();
	public static final ConfiguredFeature<BlockClusterFeatureConfig, ?> BREAKOUT_POINT_FEATURE = Feature.FLOWER
			.withConfiguration(BREAKOUT_POINT);

	public static final BlockClusterFeatureConfig NULL_BREAKOUT_POINT = (new BlockClusterFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.null_breakout_point.get().getDefaultState()),
			new SimpleBlockPlacer())).tries(64).xSpread(20).ySpread(128).zSpread(20).build();
	public static final ConfiguredFeature<BlockClusterFeatureConfig, ?> NULL_BREAKOUT_POINT_FEATURE = Feature.FLOWER
			.withConfiguration(NULL_BREAKOUT_POINT);

	@SubscribeEvent
	public void onBiomeLoadingEvent(BiomeLoadingEvent event) {

		// spawn depend on biome type
		if (event.getCategory() == Biome.Category.FOREST || event.getCategory() == Biome.Category.PLAINS
				|| event.getCategory() == Biome.Category.TAIGA || event.getCategory() == Biome.Category.EXTREME_HILLS) {
			// spawn
			event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, BREAKOUT_POINT_FEATURE);
		}
		if (event.getCategory() == Biome.Category.DESERT || event.getCategory() == Biome.Category.SAVANNA
				|| event.getCategory() == Biome.Category.MESA || event.getCategory() == Biome.Category.NETHER) {
			// spawn
			event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					NULL_BREAKOUT_POINT_FEATURE);
		}
	}

	public static void setup() {
		Registry<ConfiguredFeature<?, ?>> r = WorldGenRegistries.CONFIGURED_FEATURE;
		Registry.register(r, new ResourceLocation(ForcesOfReality.MOD_ID, "breakout_point"), BREAKOUT_POINT_FEATURE);
		Registry.register(r, new ResourceLocation(ForcesOfReality.MOD_ID, "null_breakout_point"),
				NULL_BREAKOUT_POINT_FEATURE);

	}

}