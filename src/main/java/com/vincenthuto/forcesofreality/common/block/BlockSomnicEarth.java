package com.vincenthuto.forcesofreality.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SpreadingSnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class BlockSomnicEarth extends SpreadingSnowyDirtBlock implements BonemealableBlock {
	public BlockSomnicEarth(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public boolean isBonemealSuccess(Level p_220878_, RandomSource p_220879_, BlockPos p_220880_,
			BlockState p_220881_) {
		return true;
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader p_256559_, BlockPos p_50898_, BlockState p_50899_,
			boolean p_50900_) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel p_220874_, RandomSource p_220875_, BlockPos p_220876_,
			BlockState p_220877_) {
		/*
		 * BlockPos blockpos = pos.up(); BlockState blockstate =
		 * BlockInit.mystic_earth.get().getDefaultState();
		 *
		 * label48: for (int i = 0; i < 128; ++i) { BlockPos blockpos1 = blockpos;
		 *
		 * for (int j = 0; j < i / 16; ++j) { blockpos1 = blockpos1.add(rand.nextInt(3)
		 * - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1); if
		 * (!worldIn.getBlockState(blockpos1.down()).matchesBlock(this) ||
		 * worldIn.getBlockState(blockpos1).hasOpaqueCollisionShape(worldIn, blockpos1))
		 * { continue label48; } }
		 *
		 * BlockState blockstate2 = worldIn.getBlockState(blockpos1); if
		 * (blockstate2.matchesBlock(blockstate.getBlock()) && rand.nextInt(10) == 0) {
		 * ((IGrowable) blockstate.getBlock()).grow(worldIn, rand, blockpos1,
		 * blockstate2); }
		 *
		 * if (blockstate2.isAir()) { BlockState blockstate1; if (rand.nextInt(8) == 0)
		 * { List<ConfiguredFeature<?, ?>> list =
		 * worldIn.getBiome(blockpos1).getGenerationSettings() .getFlowerFeatures(); if
		 * (list.isEmpty()) { continue; }
		 *
		 * ConfiguredFeature<?, ?> configuredfeature = list.get(0); FlowersFeature
		 * flowersfeature = (FlowersFeature) configuredfeature.feature; blockstate1 =
		 * flowersfeature.getFlowerToPlace(rand, blockpos1, configuredfeature.config());
		 * } else { blockstate1 = blockstate; }
		 *
		 * if (blockstate1.isValidPosition(worldIn, blockpos1)) {
		 * worldIn.setBlockState(blockpos1, blockstate1, 3); } } }
		 */
	}

}