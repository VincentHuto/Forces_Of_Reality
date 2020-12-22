package com.huto.forces_of_reality.worldgen;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.init.EntityInit;

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
					new Spawners(EntityInit.hastur_vassal.get(), 12, 6, 10));
		}
		if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.PLAINS)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.FOREST)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.SAVANNA)) {
			event.getSpawns().withSpawner(EntityClassification.CREATURE,
					new Spawners(EntityInit.ibis.get(), 12, 6, 10));
		}

		if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.MESA)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.SANDY)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.SAVANNA)) {
			event.getSpawns().withSpawner(EntityClassification.MONSTER,
					new Spawners(EntityInit.dread_bot.get(), 12, 6, 10));
		}

		if (BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.END)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.SWAMP)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.MUSHROOM)
				|| BiomeDictionary.hasType(biomeRegistryKey, BiomeDictionary.Type.SPOOKY)) {
			event.getSpawns().withSpawner(EntityClassification.MONSTER,
					new Spawners(EntityInit.scuttling_occulus.get(), 12, 6, 10));
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
