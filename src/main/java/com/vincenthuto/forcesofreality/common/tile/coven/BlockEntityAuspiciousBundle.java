package com.vincenthuto.forcesofreality.common.tile.coven;

import com.vincenthuto.forcesofreality.registry.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityAuspiciousBundle extends BlockEntity {

	public BlockEntityAuspiciousBundle(BlockPos pos, BlockState state) {
		super(BlockEntityInit.auspicious_bundle.get(), pos, state);
	}

}
