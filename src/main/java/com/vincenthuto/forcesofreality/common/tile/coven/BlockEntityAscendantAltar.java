package com.vincenthuto.forcesofreality.common.tile.coven;

import com.vincenthuto.forcesofreality.common.capability.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.registry.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityAscendantAltar extends DevotionalBlockEntity {

	public BlockEntityAscendantAltar(BlockPos pos, BlockState state) {
		super(BlockEntityInit.ascendant_altar.get(), pos, state);
	}


	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.ASCENDANT;
	}
}
