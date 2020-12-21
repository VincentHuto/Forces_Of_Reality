package com.huto.forces_of_reality.worldgen;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.init.EntityInit;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=ForcesOfReality.MOD_ID)
public class ModMobSpawning {

	 @SubscribeEvent
     public static void onBiomeLoading(BiomeLoadingEvent event) {

		 //func_242575_a(Entity Classification, new Spawners(Entity Type, Spawn Chance Weight, Minimum Spawned, Maximum Spawned))
      //   event.getSpawns().func_242575_a(EntityClassification.AMBIENT, new Spawners(EntityInit.ibis.get(), 1, 1, 1));
		/* event.getSpawns().withSpawnCost(EntityInit.ibis.get(), 31, 31);
		 event.getSpawns().getEntityTypes().add(EntityInit.ibis.get());*/
		 event.getSpawns().withSpawner(EntityClassification.CREATURE, new Spawners(EntityInit.ibis.get(), 12, 6, 10));
	 }
	
}
