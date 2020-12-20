package com.huto.hutosmod.objects.blocks;

import java.util.Random;

import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.particles.ParticleColor;
import com.huto.hutosmod.particles.data.GlowParticleData;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class BlockBreakoutPoint extends BushBlock {
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);

	public BlockBreakoutPoint(AbstractBlock.Properties properties) {
		super(properties);
	}

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	@Override
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		super.animateTick(stateIn, worldIn, pos, rand);
		if (stateIn.getBlock() == BlockInit.null_breakout_point.get()) {
			worldIn.addParticle(GlowParticleData.createData(new ParticleColor(200, 0, 0)), pos.getX() + 0.5,
					pos.getY() + 0.8f, pos.getZ() + 0.5, 0, worldIn.rand.nextFloat() * 0.06f, 0);
		}
		if (stateIn.getBlock() == BlockInit.essence_breakout_point.get()) {
			worldIn.addParticle(GlowParticleData.createData(new ParticleColor(0, 0, 200)), pos.getX() + 0.5,
					pos.getY() + 0.8f, pos.getZ() + 0.5, 0, worldIn.rand.nextFloat() * 0.06f, 0);

		}

	}

	/**
	 * Performs a random tick on a block.
	 */
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		if (random.nextInt(25) == 0) {
			int i = 5;
			// int j = 4;

			for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
				if (worldIn.getBlockState(blockpos).isIn(this)) {
					--i;
					if (i <= 0) {
						return;
					}
				}
			}

			BlockPos blockpos1 = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2),
					random.nextInt(3) - 1);

			for (int k = 0; k < 4; ++k) {
				if (worldIn.isAirBlock(blockpos1) && state.isValidPosition(worldIn, blockpos1)) {
					pos = blockpos1;
				}

				blockpos1 = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2),
						random.nextInt(3) - 1);
			}

			if (worldIn.isAirBlock(blockpos1) && state.isValidPosition(worldIn, blockpos1)) {
				worldIn.setBlockState(blockpos1, state, 2);
			}
		}

	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.getBlock() == Blocks.GRASS_BLOCK || blockstate.getBlock() == BlockInit.somnolent_earth.get()
				|| blockstate.getBlock() == BlockInit.somnolent_stone.get()) {
			return true;
		} else {
			return false;
		}
	}

}