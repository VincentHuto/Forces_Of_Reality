package com.vincenthuto.forcesofreality.tile.coven;

import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.init.BlockEntityInit;

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
