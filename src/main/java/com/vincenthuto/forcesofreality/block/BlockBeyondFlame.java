package com.vincenthuto.forcesofreality.block;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockBeyondFlame extends FireBlock {

	public BlockBeyondFlame(BlockBehaviour.Properties builder, float fireDamageIn) {
		super(builder);
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos pos, Random rand) {
		if (rand.nextInt(24) == 0) {
			worldIn.playLocalSound(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
					SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F + rand.nextFloat(),
					rand.nextFloat() * 0.7F + 0.3F, false);
		}

		BlockPos blockpos = pos.below();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (!this.canBurn(blockstate) && !blockstate.isFaceSturdy(worldIn, blockpos, Direction.UP)) {
			if (this.canBurn(worldIn.getBlockState(pos.west()))) {
				for (int j = 0; j < 2; ++j) {
					double d3 = pos.getX() + rand.nextDouble() * 0.1F;
					double d8 = pos.getY() + rand.nextDouble();
					double d13 = pos.getZ() + rand.nextDouble();
					worldIn.addParticle(ParticleTypes.ASH, d3, d8, d13, 0.0D, 0.0D, 0.0D);
					worldIn.addParticle(ParticleTypes.PORTAL, d3, d8, d13, 0.0D, 0.0D, 0.0D);

				}
			}

			if (this.canBurn(worldIn.getBlockState(pos.east()))) {
				for (int k = 0; k < 2; ++k) {
					double d4 = pos.getX() + 1 - rand.nextDouble() * 0.1F;
					double d9 = pos.getY() + rand.nextDouble();
					double d14 = pos.getZ() + rand.nextDouble();
					worldIn.addParticle(ParticleTypes.ASH, d4, d9, d14, 0.0D, 0.0D, 0.0D);
					worldIn.addParticle(ParticleTypes.PORTAL, d4, d9, d14, 0.0D, 0.0D, 0.0D);

				}
			}

			if (this.canBurn(worldIn.getBlockState(pos.north()))) {
				for (int l = 0; l < 2; ++l) {
					double d5 = pos.getX() + rand.nextDouble();
					double d10 = pos.getY() + rand.nextDouble();
					double d15 = pos.getZ() + rand.nextDouble() * 0.1F;
					worldIn.addParticle(ParticleTypes.ASH, d5, d10, d15, 0.0D, 0.0D, 0.0D);
					worldIn.addParticle(ParticleTypes.PORTAL, d5, d10, d15, 0.0D, 0.0D, 0.0D);

				}
			}

			if (this.canBurn(worldIn.getBlockState(pos.south()))) {
				for (int i1 = 0; i1 < 2; ++i1) {
					double d6 = pos.getX() + rand.nextDouble();
					double d11 = pos.getY() + rand.nextDouble();
					double d16 = pos.getZ() + 1 - rand.nextDouble() * 0.1F;
					worldIn.addParticle(ParticleTypes.ASH, d6, d11, d16, 0.0D, 0.0D, 0.0D);
					worldIn.addParticle(ParticleTypes.PORTAL, d6, d11, d16, 0.0D, 0.0D, 0.0D);

				}
			}

			if (this.canBurn(worldIn.getBlockState(pos.above()))) {
				for (int j1 = 0; j1 < 2; ++j1) {
					double d7 = pos.getX() + rand.nextDouble();
					double d12 = pos.getY() + 1 - rand.nextDouble() * 0.1F;
					double d17 = pos.getZ() + rand.nextDouble();
					worldIn.addParticle(ParticleTypes.ASH, d7, d12, d17, 0.0D, 0.0D, 0.0D);
					worldIn.addParticle(ParticleTypes.PORTAL, d7, d12, d17, 0.0D, 0.0D, 0.0D);

				}
			}
		} else {
			for (int i = 0; i < 3; ++i) {
				double d0 = pos.getX() + rand.nextDouble();
				double d1 = pos.getY() + rand.nextDouble() * 0.5D + 0.5D;
				double d2 = pos.getZ() + rand.nextDouble();
				worldIn.addParticle(ParticleTypes.ASH, d0, d1, d2, 0.0D, 0.0D, 0.0D);
				worldIn.addParticle(ParticleTypes.PORTAL, d0, d1, d2, 0.0D, 0.0D, 0.0D);

			}
		}

	}

}
