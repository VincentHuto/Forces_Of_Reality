package com.huto.forces_of_reality.init;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.objects.tileenties.TileEntityChiselStation;
import com.huto.forces_of_reality.objects.tileenties.TileEntityIcoSphere;
import com.huto.forces_of_reality.objects.tileenties.TileEntityMachinaImperfecta;
import com.huto.forces_of_reality.objects.tileenties.TileEntityMagicLight;
import com.huto.forces_of_reality.objects.tileenties.TileEntityMagicRingLight;
import com.huto.forces_of_reality.objects.tileenties.TileEntityRuneModStation;
import com.huto.forces_of_reality.objects.tileenties.TileEntitySlimeRepelent;
import com.huto.forces_of_reality.objects.tileenties.TileEntityTeleporter;
import com.huto.forces_of_reality.objects.tileenties.TileEntityVirtuousEnchant;
import com.huto.forces_of_reality.objects.tileenties.coven.TileEntityAscendentAltar;
import com.huto.forces_of_reality.objects.tileenties.coven.TileEntityAuspiciousBundle;
import com.huto.forces_of_reality.objects.tileenties.coven.TileEntityHasturPylon;
import com.huto.forces_of_reality.objects.tileenties.coven.TileEntityOccularHeap;
import com.huto.forces_of_reality.objects.tileenties.coven.TileEntitySacrificePyre;
import com.huto.forces_of_reality.objects.tileenties.coven.TileEntityUntoldEasel;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntityAutoInscriber;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntityCrystalHarmonizer;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntityKarmicAltar;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntityKarmicExtractor;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntityLectorTable;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntitySomnolentHopper;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntityVibeConcetrator;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntityVibeFuser;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntityVibeResonator;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntityWandMaker;
import com.huto.forces_of_reality.objects.tileenties.vibes.gen.TileEntityAbsorber;
import com.huto.forces_of_reality.objects.tileenties.vibes.gen.TileEntityCapacitor;
import com.huto.forces_of_reality.objects.tileenties.vibes.gen.TileEntityStorageDrum;
import com.huto.forces_of_reality.objects.tileenties.vibes.gen.TileEntityTectonicAbsorber;
import com.huto.forces_of_reality.objects.tileenties.vibes.gen.TileEntityThermalInfluxer;
import com.huto.forces_of_reality.objects.tileenties.vibes.gen.TileEntityVibeGatherer;
import com.huto.forces_of_reality.objects.tileenties.vibes.gen.TileEntityWaveGatherer;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {
	public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, ForcesOfReality.MOD_ID);

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

	public static final RegistryObject<TileEntityType<TileEntityMagicLight>> light_block = TILES.register("light_block",
			() -> TileEntityType.Builder.create(TileEntityMagicLight::new, BlockInit.light_block.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityMagicRingLight>> light_ring_block = TILES
			.register("light_ring_block", () -> TileEntityType.Builder
					.create(TileEntityMagicRingLight::new, BlockInit.light_ring_block.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityAutoInscriber>> auto_inscriber = TILES
			.register("auto_inscriber", () -> TileEntityType.Builder
					.create(TileEntityAutoInscriber::new, BlockInit.auto_inscriber.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntitySomnolentHopper>> somnolent_hopper = TILES
			.register("somnolent_hopper", () -> TileEntityType.Builder
					.create(TileEntitySomnolentHopper::new, BlockInit.somnolent_hopper.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityLectorTable>> lector_table = TILES.register(
			"lector_table",
			() -> TileEntityType.Builder.create(TileEntityLectorTable::new, BlockInit.lector_table.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityTectonicAbsorber>> tectonic_absorber = TILES
			.register("tectonic_absorber", () -> TileEntityType.Builder
					.create(TileEntityTectonicAbsorber::new, BlockInit.tectonic_absorber.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityCrystalHarmonizer>> crystal_harmonizer = TILES
			.register("crystal_harmonizer", () -> TileEntityType.Builder
					.create(TileEntityCrystalHarmonizer::new, BlockInit.crystal_harmonizer.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityVibeConcetrator>> vibe_concentrator = TILES
			.register("vibe_concentrator", () -> TileEntityType.Builder
					.create(TileEntityVibeConcetrator::new, BlockInit.vibe_concentrator.get()).build(null));

}
