package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.objects.tileenties.TileEntityAbsorber;
import com.huto.hutosmod.objects.tileenties.TileEntityAscendentAltar;
import com.huto.hutosmod.objects.tileenties.TileEntityAuspiciousBundle;
import com.huto.hutosmod.objects.tileenties.TileEntityCapacitor;
import com.huto.hutosmod.objects.tileenties.TileEntityChiselStation;
import com.huto.hutosmod.objects.tileenties.TileEntityHasturPylon;
import com.huto.hutosmod.objects.tileenties.TileEntityIcoSphere;
import com.huto.hutosmod.objects.tileenties.TileEntityKarmicAltar;
import com.huto.hutosmod.objects.tileenties.TileEntityKarmicExtractor;
import com.huto.hutosmod.objects.tileenties.TileEntityMachinaImperfecta;
import com.huto.hutosmod.objects.tileenties.TileEntityMagicLight;
import com.huto.hutosmod.objects.tileenties.TileEntityMagicRingLight;
import com.huto.hutosmod.objects.tileenties.TileEntityOccularHeap;
import com.huto.hutosmod.objects.tileenties.TileEntityRuneModStation;
import com.huto.hutosmod.objects.tileenties.TileEntitySacrificePyre;
import com.huto.hutosmod.objects.tileenties.TileEntitySlimeRepelent;
import com.huto.hutosmod.objects.tileenties.TileEntityStorageDrum;
import com.huto.hutosmod.objects.tileenties.TileEntityTeleporter;
import com.huto.hutosmod.objects.tileenties.TileEntityThermalInfluxer;
import com.huto.hutosmod.objects.tileenties.TileEntityUntoldEasel;
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

	public static final RegistryObject<TileEntityType<TileEntityChiselStation>> runic_chisel_station = TILES
			.register("runic_chisel_station", () -> TileEntityType.Builder
					.create(TileEntityChiselStation::new, BlockInit.runic_chisel_station.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityRuneModStation>> rune_mod_station = TILES
			.register("rune_mod_station", () -> TileEntityType.Builder
					.create(TileEntityRuneModStation::new, BlockInit.rune_mod_station.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntitySlimeRepelent>> slime_repelent = TILES
			.register("slime_repelent", () -> TileEntityType.Builder
					.create(TileEntitySlimeRepelent::new, BlockInit.slime_repelent.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityAscendentAltar>> ascendent_altar = TILES
			.register("ascendent_altar", () -> TileEntityType.Builder
					.create(TileEntityAscendentAltar::new, BlockInit.ascendent_altar.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityOccularHeap>> occular_heap = TILES.register(
			"occular_heap",
			() -> TileEntityType.Builder.create(TileEntityOccularHeap::new, BlockInit.occular_heap.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityTeleporter>> teleporter = TILES.register("teleporter",
			() -> TileEntityType.Builder.create(TileEntityTeleporter::new, BlockInit.teleporter.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntitySacrificePyre>> sacrifice_pyre = TILES
			.register("sacrifice_pyre", () -> TileEntityType.Builder
					.create(TileEntitySacrificePyre::new, BlockInit.sacrificial_pyre.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityAuspiciousBundle>> auspicious_bundle = TILES
			.register("auspicious_bundle", () -> TileEntityType.Builder
					.create(TileEntityAuspiciousBundle::new, BlockInit.auspicious_bundle.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityMachinaImperfecta>> machina_imperfecta = TILES
			.register("machina_imperfecta", () -> TileEntityType.Builder
					.create(TileEntityMachinaImperfecta::new, BlockInit.machina_imperfecta.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityUntoldEasel>> untold_easel = TILES.register(
			"untold_easel",
			() -> TileEntityType.Builder.create(TileEntityUntoldEasel::new, BlockInit.untold_easel.get()).build(null));
	
	public static final RegistryObject<TileEntityType<TileEntityMagicLight>> light_block = TILES.register(
			"light_block",
			() -> TileEntityType.Builder.create(TileEntityMagicLight::new, BlockInit.light_block.get()).build(null));
	
	public static final RegistryObject<TileEntityType<TileEntityMagicRingLight>> light_ring_block = TILES.register(
			"light_ring_block",
			() -> TileEntityType.Builder.create(TileEntityMagicRingLight::new, BlockInit.light_ring_block.get()).build(null));
	
	

}
