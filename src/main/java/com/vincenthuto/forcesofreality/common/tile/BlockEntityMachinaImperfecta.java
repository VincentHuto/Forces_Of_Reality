package com.vincenthuto.forcesofreality.common.tile;

import com.vincenthuto.forcesofreality.common.capability.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.common.tile.coven.DevotionalBlockEntity;
import com.vincenthuto.forcesofreality.registry.BlockEntityInit;

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
