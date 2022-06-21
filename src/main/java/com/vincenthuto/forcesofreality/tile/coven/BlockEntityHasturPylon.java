package com.vincenthuto.forcesofreality.tile.coven;

import com.vincenthuto.forcesofreality.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityHasturPylon extends BlockEntity {

	public BlockEntityHasturPylon(BlockPos pos, BlockState state) {
		super(BlockEntityInit.hastur_pylon.get(), pos, state);
	}



}
