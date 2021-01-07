package com.huto.forcesofreality.worldgen;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.init.EntityInit;

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID)
public class ModMobSpawning {

	@SubscribeEvent
	public static void onBiomeLoading(BiomeLoadingEvent event) {

		RegistryKey<Biome> biomeRegistryKey = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName());
		if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.RIVER)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.OCEAN)) {
			event.getSpawns().withSpawner(EntityClassification.MONSTER,
					new Spawners(EntityInit.hastur_vassal.get(), 50, 1, 3));
		}
		if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.PLAINS)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.FOREST)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.SAVANNA)
						&& BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.OCEAN)) {
			event.getSpawns().withSpawner(EntityClassification.CREATURE,
					new Spawners(EntityInit.ibis.get(), 12, 6, 10));
		}
		if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.COLD)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.MOUNTAIN)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.SNOWY)
						&& BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.OCEAN)) {
			event.getSpawns().withSpawner(EntityClassification.CREATURE,
					new Spawners(EntityInit.angelic_fowl.get(), 2, 1, 2));
		}

		if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.MESA)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.SANDY)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.SAVANNA)
						&& BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.OCEAN)) {
			event.getSpawns().withSpawner(EntityClassification.MONSTER,
					new Spawners(EntityInit.dread_bot.get(), 50, 1, 2));
		}

		if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.END)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.SWAMP)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.MUSHROOM)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.SPOOKY)) {
			event.getSpawns().withSpawner(EntityClassification.MONSTER,
					new Spawners(EntityInit.scuttling_occulus.get(), 50, 3, 5));
		}

		// func_242575_a(Entity Classification, new Spawners(Entity Type, Spawn Chance
		// Weight, Minimum Spawned, Maximum Spawned))
		// event.getSpawns().func_242575_a(EntityClassification.AMBIENT, new
		// Spawners(EntityInit.ibis.get(), 1, 1, 1));
		/*
		 * event.getSpawns().withSpawnCost(EntityInit.ibis.get(), 31, 31);
		 * event.getSpawns().getEntityTypes().add(EntityInit.ibis.get());
		 */

	}

}
