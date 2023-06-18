package com.vincenthuto.forcesofreality.common.tile;

import com.vincenthuto.forcesofreality.registry.BlockEntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlockEntityAdornmentModStation extends BlockEntity {

	public BlockEntityAdornmentModStation(BlockPos worldPosition, BlockState blockState) {
		super(BlockEntityInit.self_reflection_station.get(), worldPosition, blockState);
	}

//	@Override
//	public void tick() {
//		if (level().isClientSide) {
//			int count = (int) ((int) (4 * 0.5f) + level().random.nextFloat());
//			if (count % 2 == 0) {
//				for (int i = 0; i < level().random.nextInt(count); i++) {
//					double randX = worldPosition.getX();
//					double randY = worldPosition.getY();
//					double randZ = worldPosition.getZ();
//
//					level().addParticle(ParticleTypes.FLAME, randX + 0.1, randY + 1, randZ + 0.1, 0, 0.005, 0);
//					level().addParticle(ParticleTypes.FLAME, randX + 0.9, randY + 1, randZ + 0.1, 0, 0.005, 0);
//					level().addParticle(ParticleTypes.FLAME, randX + 0.1, randY + 1, randZ + 0.9, 0, 0.005, 0);
//					level().addParticle(ParticleTypes.FLAME, randX + 0.9, randY + 1, randZ + 0.9, 0, 0.005, 0);
//
//				}
//			}
//		}
//
//	}
}
