package com.vincenthuto.forcesofreality.init;

import com.vincenthuto.forcesofreality.ForcesOfReality;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class FeatureInit {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
			ForcesOfReality.MOD_ID);

	// Feature
	/*
	 * public static final RegistryObject<Feature<OreFeatureConfig>> GOOFEATURE =
	 * FEATURES.register("enchantedorefeature", () -> new
	 * GooFeature(OreFeatureConfig.CODEC));
	 */

}
