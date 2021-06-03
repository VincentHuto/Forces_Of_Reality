package com.huto.forcesofreality.init;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.objects.tileenties.TileEntityAdornmentModStation;
import com.huto.forcesofreality.objects.tileenties.TileEntityIcoSphere;
import com.huto.forcesofreality.objects.tileenties.TileEntityMachinaImperfecta;
import com.huto.forcesofreality.objects.tileenties.TileEntityRafflesiaOfFidelity;
import com.huto.forcesofreality.objects.tileenties.coven.TileEntityAscendantAltar;
import com.huto.forcesofreality.objects.tileenties.coven.TileEntityAuspiciousBundle;
import com.huto.forcesofreality.objects.tileenties.coven.TileEntityHasturPylon;
import com.huto.forcesofreality.objects.tileenties.coven.TileEntityHunterEffigy;
import com.huto.forcesofreality.objects.tileenties.coven.TileEntityOccularHeap;
import com.huto.forcesofreality.objects.tileenties.coven.TileEntitySacrificePyre;
import com.huto.forcesofreality.objects.tileenties.coven.TileEntityUntoldEasel;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {
	public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, ForcesOfReality.MOD_ID);

	public static final RegistryObject<TileEntityType<TileEntityHasturPylon>> hastur_pylon = TILES.register(
			"hastur_pylon",
			() -> TileEntityType.Builder.create(TileEntityHasturPylon::new, BlockInit.hastur_pylon.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityIcoSphere>> obj_icosahedron = TILES.register(
			"obj_icosahedron",
			() -> TileEntityType.Builder.create(TileEntityIcoSphere::new, BlockInit.obj_icosahedron.get()).build(null));

	/*
	 * public static final RegistryObject<TileEntityType<TileEntityChiselStation>>
	 * runic_chisel_station = TILES .register("runic_chisel_station", () ->
	 * TileEntityType.Builder .create(TileEntityChiselStation::new,
	 * BlockInit.runic_chisel_station.get()).build(null));
	 */
	public static final RegistryObject<TileEntityType<TileEntityAdornmentModStation>> self_reflection_station = TILES
			.register("self_reflection_station", () -> TileEntityType.Builder
					.create(TileEntityAdornmentModStation::new, BlockInit.self_reflection_station.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityAscendantAltar>> ascendant_altar = TILES
			.register("ascendant_altar", () -> TileEntityType.Builder
					.create(TileEntityAscendantAltar::new, BlockInit.ascendant_altar.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityOccularHeap>> occular_heap = TILES.register(
			"occular_heap",
			() -> TileEntityType.Builder.create(TileEntityOccularHeap::new, BlockInit.occular_heap.get()).build(null));

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

	public static final RegistryObject<TileEntityType<TileEntityRafflesiaOfFidelity>> rafflesia_of_fidelity = TILES
			.register("rafflesia_of_fidelity", () -> TileEntityType.Builder
					.create(TileEntityRafflesiaOfFidelity::new, BlockInit.rafflesia_of_fidelity.get()).build(null));

	public static final RegistryObject<TileEntityType<TileEntityHunterEffigy>> hunter_effigy = TILES
			.register("hunter_effigy", () -> TileEntityType.Builder
					.create(TileEntityHunterEffigy::new, BlockInit.hunter_effigy.get()).build(null));

}
