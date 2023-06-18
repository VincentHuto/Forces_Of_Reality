package com.vincenthuto.forcesofreality.common.tile.coven;

import com.vincenthuto.forcesofreality.common.capability.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.registry.BlockEntityInit;
import com.vincenthuto.forcesofreality.registry.BlockInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityOccularHeap extends DevotionalBlockEntity {

	public BlockEntityOccularHeap(BlockPos pos, BlockState state) {
		super(BlockEntityInit.occular_heap.get(), pos, state);
	}

	public boolean checkStructure() {
		BlockPos adj = getBlockPos().relative(Direction.DOWN);
		BlockState blockState = getLevel().getBlockState(adj);
		Block block = blockState.getBlock();
		if (block == BlockInit.abyssal_silt.get()) {
			this.sacMod = 2;
			return true;
		} else {
			this.sacMod = 1;
			return false;
		}

	}


	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.ELDRITCH;
	}
}
