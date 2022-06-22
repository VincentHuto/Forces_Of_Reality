package com.vincenthuto.forcesofreality.block;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.tile.coven.BlockEntityHasturPylon;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockHasturPylon extends Block implements EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private static final VoxelShape SHAPE_N = Block.box(2, 1, 2, 14, 18, 14);

	public BlockHasturPylon(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));

	}

	@Override
	public RenderShape getRenderShape(BlockState pState) {
		return RenderShape.MODEL;
	}

	@Override
	public VoxelShape getOcclusionShape(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return SHAPE_N;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		return SHAPE_N;
	}

	@Override
	public void onNeighborChange(BlockState state, LevelReader world, BlockPos pos, BlockPos neighbor) {
	}

	@Override
	public void animateTick(@Nonnull BlockState state, @Nonnull Level world, @Nonnull BlockPos pos,
			@Nonnull RandomSource random) {
		BlockEntityHasturPylon tile = (BlockEntityHasturPylon) world.getBlockEntity(pos);
		if (tile != null && tile instanceof BlockEntityHasturPylon) {
			int count = (int) (10 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() - 0.1 + random.nextDouble() * 1.2;
					double randY = pos.getY() - 0.1 + random.nextDouble() * 1.2;
					double randZ = pos.getZ() - 0.1 + random.nextDouble() * 1.2;
					world.addParticle(ParticleTypes.REVERSE_PORTAL, randX, randY, randZ, 0, 0, 0);
					world.addParticle(ParticleTypes.SMOKE, randX, randY, randZ, 0, 0, 0);

				}
			}
		}
	}

	@Override
	public void destroy(LevelAccessor worldIn, BlockPos pos, BlockState state) {
		super.destroy(worldIn, pos, state);

		// inner ring
		for (int j = 0; j < 10; j++) {

			worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
					Math.sin(j) / 9, Math.sin(j) / 3, Math.cos(j) / 9);
			worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
					Math.cos(j) / 9, Math.sin(j) / 3, Math.sin(j) / 9);
			worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
					Math.sin(-j) / 9, Math.sin(j) / 3, Math.cos(-j) / 9);
			worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
					Math.cos(-j) / 9, Math.sin(j) / 3, Math.sin(-j) / 9);

		}
		// outer ring
		for (int i = 0; i < 10; i++) {
			worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
					Math.sin(i) / 3, Math.sin(i) / 3, Math.cos(i) / 3);
			worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
					Math.cos(i) / 3, Math.sin(i) / 3, Math.sin(i) / 3);
			worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
					Math.sin(-i) / 3, Math.sin(i) / 3, Math.cos(-i) / 3);
			worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
					Math.cos(-i) / 3, Math.sin(i) / 3, Math.sin(-i) / 3);
		}
		worldIn.playSound(null, pos, SoundEvents.BEACON_DEACTIVATE, SoundSource.AMBIENT, 0.1f, 0.3F);

	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void attack(BlockState state, Level worldIn, BlockPos pos, Player player) {
		super.attack(state, worldIn, pos, player);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new BlockEntityHasturPylon(p_153215_, p_153216_);
	}
}
