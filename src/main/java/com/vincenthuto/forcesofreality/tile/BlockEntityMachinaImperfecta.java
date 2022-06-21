package com.vincenthuto.forcesofreality.tile;

import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.init.BlockEntityInit;
import com.vincenthuto.forcesofreality.tile.coven.DevotionalBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityMachinaImperfecta extends DevotionalBlockEntity {

	public BlockEntityMachinaImperfecta(BlockPos worldPosition, BlockState blockState) {
		super(BlockEntityInit.machina_imperfecta.get(), worldPosition, blockState);
	}

	@Override
	public EnumCovenants getCovenType() {
		return EnumCovenants.MACHINE;
	}
}
