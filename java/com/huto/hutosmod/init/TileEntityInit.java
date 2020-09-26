package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.objects.tileenties.TileEntityAbsorber;
import com.huto.hutosmod.objects.tileenties.TileEntityCapacitor;
import com.huto.hutosmod.objects.tileenties.TileEntityHasturPylon;
import com.huto.hutosmod.objects.tileenties.TileEntityIcoSphere;
import com.huto.hutosmod.objects.tileenties.TileEntityKarmicAltar;
import com.huto.hutosmod.objects.tileenties.TileEntityKarmicExtractor;
import com.huto.hutosmod.objects.tileenties.TileEntityStorageDrum;
import com.huto.hutosmod.objects.tileenties.TileEntityThermalInfluxer;
import com.huto.hutosmod.objects.tileenties.TileEntityVibeFuser;
import com.huto.hutosmod.objects.tileenties.TileEntityVibeGatherer;
import com.huto.hutosmod.objects.tileenties.TileEntityVibeResonator;
import com.huto.hutosmod.objects.tileenties.TileEntityVirtuousEnchant;
import com.huto.hutosmod.objects.tileenties.TileEntityWandMaker;
import com.huto.hutosmod.objects.tileenties.TileEntityWaveGatherer;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {
	public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, HutosMod.MOD_ID);

	public static final RegistryObject<TileEntityType<TileEntityWandMaker>> wand_maker = TILES.register("wand_maker",
			() -> TileEntityType.Builder.create(TileEntityWandMaker::new, BlockInit.wand_maker.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityVibeResonator>> vibe_resonator = TILES
			.register("vibe_resonator", () -> TileEntityType.Builder
					.create(TileEntityVibeResonator::new, BlockInit.vibe_resonator.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityWaveGatherer>> wave_gatherer = TILES
			.register("wave_gatherer", () -> TileEntityType.Builder
					.create(TileEntityWaveGatherer::new, BlockInit.wave_gatherer.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityVibeGatherer>> vibe_gatherer = TILES
			.register("vibe_gatherer", () -> TileEntityType.Builder
					.create(TileEntityVibeGatherer::new, BlockInit.vibe_gatherer.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityKarmicAltar>> karmic_altar = TILES.register(
			"karmic_altar",
			() -> TileEntityType.Builder.create(TileEntityKarmicAltar::new, BlockInit.karmic_altar.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityVirtuousEnchant>> virtuous_enchanter = TILES
			.register("virtuous_enchanter", () -> TileEntityType.Builder
					.create(TileEntityVirtuousEnchant::new, BlockInit.virtuous_enchanter.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityStorageDrum>> vibratory_storage_drum = TILES
			.register("vibratory_storage_drum", () -> TileEntityType.Builder
					.create(TileEntityStorageDrum::new, BlockInit.vibratory_storage_drum.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityCapacitor>> vibratory_capacitor = TILES
			.register("vibratory_capacitor", () -> TileEntityType.Builder
					.create(TileEntityCapacitor::new, BlockInit.vibratory_capacitor.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityKarmicExtractor>> karmic_extractor = TILES
			.register("karmic_extractor", () -> TileEntityType.Builder
					.create(TileEntityKarmicExtractor::new, BlockInit.karmic_extractor.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityVibeFuser>> vibratory_fuser = TILES.register(
			"vibratory_fuser",
			() -> TileEntityType.Builder.create(TileEntityVibeFuser::new, BlockInit.vibratory_fuser.get()).build(null));
	public static final RegistryObject<TileEntityType<TileEntityAbsorber>> vibe_absorber = TILES.register(
			"vibe_absorber",
			() -> TileEntityType.Builder.create(TileEntityAbsorber::new, BlockInit.vibe_absorber.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityHasturPylon>> hastur_pylon = TILES.register(
			"hastur_pylon",
			() -> TileEntityType.Builder.create(TileEntityHasturPylon::new, BlockInit.hastur_pylon.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityIcoSphere>> obj_icosahedron = TILES.register(
			"obj_icosahedron",
			() -> TileEntityType.Builder.create(TileEntityIcoSphere::new, BlockInit.obj_icosahedron.get()).build(null));
	public static final RegistryObject<TileEntityType<TileEntityThermalInfluxer>> thermal_influxer = TILES
			.register("thermal_influxer", () -> TileEntityType.Builder
					.create(TileEntityThermalInfluxer::new, BlockInit.thermal_influxer.get()).build(null));

}
