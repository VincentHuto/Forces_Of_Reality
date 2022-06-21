package com.vincenthuto.forcesofreality.tile.coven;

import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.init.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityUntoldEasel extends DevotionalBlockEntity {

	public BlockEntityUntoldEasel(BlockPos pos, BlockState state) {
		super(BlockEntityInit.untold_easel.get(), pos, state);
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.HASTUR;
	}
}
