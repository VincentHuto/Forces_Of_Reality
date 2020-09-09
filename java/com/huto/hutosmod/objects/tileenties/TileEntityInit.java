package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.BlockInit;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {
	public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, HutosMod.MOD_ID);

	public static final RegistryObject<TileEntityType<TileEntityWandMaker>> wand_maker = TILES.register("quarry",
			() -> TileEntityType.Builder.create(TileEntityWandMaker::new, BlockInit.wand_maker.get()).build(null));
}
