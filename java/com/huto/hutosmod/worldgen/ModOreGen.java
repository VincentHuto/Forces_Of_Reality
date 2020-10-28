package com.huto.hutosmod.worldgen;

import com.huto.hutosmod.init.BlockInit;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class ModOreGen {

	public static void addStuffToBiomes(BiomeLoadingEvent event) {
		RegistryKey<Biome> biome = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
		if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.VOID)) {
			event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.ORE
							.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a,
									BlockInit.enchanted_ore.get().getDefaultState(), 13))
							.func_242733_d(50).func_242728_a());

		}
	}
}