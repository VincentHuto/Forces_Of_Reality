package com.vincenthuto.forcesofreality.init;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.tile.BlockEntityAdornmentModStation;
import com.vincenthuto.forcesofreality.tile.BlockEntityMachinaImperfecta;
import com.vincenthuto.forcesofreality.tile.BlockEntityRafflesiaOfFidelity;
import com.vincenthuto.forcesofreality.tile.coven.BlockEntityAscendantAltar;
import com.vincenthuto.forcesofreality.tile.coven.BlockEntityAuspiciousBundle;
import com.vincenthuto.forcesofreality.tile.coven.BlockEntityHasturPylon;
import com.vincenthuto.forcesofreality.tile.coven.BlockEntityHunterEffigy;
import com.vincenthuto.forcesofreality.tile.coven.BlockEntityOccularHeap;
import com.vincenthuto.forcesofreality.tile.coven.BlockEntitySacrificePyre;
import com.vincenthuto.forcesofreality.tile.coven.BlockEntityUntoldEasel;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInit {
	public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister
			.create(ForgeRegistries.BLOCK_ENTITIES, ForcesOfReality.MOD_ID);

	public static final RegistryObject<BlockEntityType<BlockEntityHasturPylon>> hastur_pylon = TILES.register(
			"hastur_pylon",
			() -> BlockEntityType.Builder.of(BlockEntityHasturPylon::new, BlockInit.hastur_pylon.get()).build(null));

	/*
	 * public static final RegistryObject<BlockEntityType<BlockEntityChiselStation>>
	 * runic_chisel_station = TILES .register("runic_chisel_station", () ->
	 * BlockEntityType.Builder .create(BlockEntityChiselStation::new,
	 * BlockInit.runic_chisel_station.get()).build(null));
	 */
	public static final RegistryObject<BlockEntityType<BlockEntityAdornmentModStation>> self_reflection_station = TILES
			.register("self_reflection_station", () -> BlockEntityType.Builder
					.of(BlockEntityAdornmentModStation::new, BlockInit.self_reflection_station.get()).build(null));

	public static final RegistryObject<BlockEntityType<BlockEntityAscendantAltar>> ascendant_altar = TILES
			.register("ascendant_altar", () -> BlockEntityType.Builder
					.of(BlockEntityAscendantAltar::new, BlockInit.ascendant_altar.get()).build(null));

	public static final RegistryObject<BlockEntityType<BlockEntityOccularHeap>> occular_heap = TILES.register(
			"occular_heap",
			() -> BlockEntityType.Builder.of(BlockEntityOccularHeap::new, BlockInit.occular_heap.get()).build(null));

	public static final RegistryObject<BlockEntityType<BlockEntitySacrificePyre>> sacrifice_pyre = TILES
			.register("sacrifice_pyre", () -> BlockEntityType.Builder
					.of(BlockEntitySacrificePyre::new, BlockInit.sacrificial_pyre.get()).build(null));

	public static final RegistryObject<BlockEntityType<BlockEntityAuspiciousBundle>> auspicious_bundle = TILES
			.register("auspicious_bundle", () -> BlockEntityType.Builder
					.of(BlockEntityAuspiciousBundle::new, BlockInit.auspicious_bundle.get()).build(null));

	public static final RegistryObject<BlockEntityType<BlockEntityMachinaImperfecta>> machina_imperfecta = TILES
			.register("machina_imperfecta", () -> BlockEntityType.Builder
					.of(BlockEntityMachinaImperfecta::new, BlockInit.machina_imperfecta.get()).build(null));

	public static final RegistryObject<BlockEntityType<BlockEntityUntoldEasel>> untold_easel = TILES.register(
			"untold_easel",
			() -> BlockEntityType.Builder.of(BlockEntityUntoldEasel::new, BlockInit.untold_easel.get()).build(null));

	public static final RegistryObject<BlockEntityType<BlockEntityRafflesiaOfFidelity>> rafflesia_of_fidelity = TILES
			.register("rafflesia_of_fidelity", () -> BlockEntityType.Builder
					.of(BlockEntityRafflesiaOfFidelity::new, BlockInit.rafflesia_of_fidelity.get()).build(null));

	public static final RegistryObject<BlockEntityType<BlockEntityHunterEffigy>> hunter_effigy = TILES.register(
			"hunter_effigy",
			() -> BlockEntityType.Builder.of(BlockEntityHunterEffigy::new, BlockInit.hunter_effigy.get()).build(null));

}
