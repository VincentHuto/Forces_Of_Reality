package com.vincenthuto.forcesofreality.block;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockRafflesiaFlower extends BushBlock implements BonemealableBlock {
	protected static final VoxelShape SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);

	public BlockRafflesiaFlower(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPE;
	}

	/**
	 * Performs a random tick on a block.
	 */
	public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
		if (random.nextInt(25) == 0) {
			int i = 5;
			// int j = 4;

			for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, -1, -4), pos.offset(4, 1, 4))) {
				if (worldIn.getBlockState(blockpos).is(this)) {
					--i;
					if (i <= 0) {
						return;
					}
				}
			}

			BlockPos blockpos1 = pos.offset(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2),
					random.nextInt(3) - 1);

			for (int k = 0; k < 4; ++k) {
				if (worldIn.isEmptyBlock(blockpos1) && state.canSurvive(worldIn, blockpos1)) {
					pos = blockpos1;
				}

				blockpos1 = pos.offset(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2),
						random.nextInt(3) - 1);
			}

			if (worldIn.isEmptyBlock(blockpos1) && state.canSurvive(worldIn, blockpos1)) {
				worldIn.setBlock(blockpos1, state, 2);
			}
		}

	}

	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return state.isSolidRender(worldIn, pos);
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
			return true;
		} else {
			return worldIn.getRawBrightness(pos, 0) < 13
					&& blockstate.canSustainPlant(worldIn, blockpos, net.minecraft.core.Direction.UP, this);
		}
	}

//	public boolean grow(ServerLevel world, BlockPos pos, BlockState state, Random rand) {
//		world.removeBlock(pos, false);
//		ConfiguredFeature<?, ?> configuredfeature;
//		if (this == Blocks.BROWN_MUSHROOM) {
//			configuredfeature = Features.HUGE_BROWN_MUSHROOM;
//		} else {
//			if (this != Blocks.RED_MUSHROOM) {
//				world.setBlock(pos, state, 3);
//				return false;
//			}
//
//			configuredfeature = Features.HUGE_RED_MUSHROOM;
//		}
//
//		if (configuredfeature.place(world, world.getChunkSource().getGenerator(), rand, pos)) {
//			return true;
//		} else {
//			world.setBlock(pos, state, 3);
//			return false;
//		}
//	}

	/**
	 * Whether this IGrowable can grow
	 */
	@Override
	public boolean isValidBonemealTarget(BlockGetter worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	public boolean isBonemealSuccess(Level worldIn, Random rand, BlockPos pos, BlockState state) {
		return rand.nextFloat() < 0.4D;
	}
	
	@Override
	public void performBonemeal(ServerLevel p_220874_, RandomSource p_220875_, BlockPos p_220876_,
			BlockState p_220877_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isBonemealSuccess(Level p_220878_, RandomSource p_220879_, BlockPos p_220880_,
			BlockState p_220881_) {
		// TODO Auto-generated method stub
		return false;
	}

//	public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
//		this.grow(worldIn, pos, state, rand);
//	}
}