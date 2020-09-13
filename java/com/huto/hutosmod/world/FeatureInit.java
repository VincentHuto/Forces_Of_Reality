package com.huto.hutosmod.world;


import com.huto.hutosmod.HutosMod;

import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Bus.MOD,modid=HutosMod.MOD_ID)
public class FeatureInit {
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
			HutosMod.MOD_ID);

//	public static final RegistryObject<HouseStructure> HOUSE = FEATURES.register("house", () -> new HouseStructure(NoFeatureConfig::deserialize));
//	public static IStructurePieceType HOUSE_PIECE = HousePieces.Piece::new;
	
		@SubscribeEvent
		public static void registerStructurePieces(RegistryEvent.Register<Feature<?>> event) {
		//	Registry<T>.register(Registry.STRUCTURE_PIECE, "HOUSE".toLowerCase(Locale.ROOT), HOUSE_PIECE);
		}
	
}
