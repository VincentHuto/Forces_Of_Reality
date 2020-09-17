package com.huto.hutosmod.objects.blocks;

import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.huto.hutosmod.objects.tileenties.TileEntityStorageDrum;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BlockStorageDrum extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(1, 0, 1, 15, 1, 15),
			Block.makeCuboidShape(1, 22, 1, 15, 23, 15), Block.makeCuboidShape(2, 23, 2, 14, 24, 14),
			Block.makeCuboidShape(14, 1, 1, 15, 22, 2), Block.makeCuboidShape(1, 1, 1, 2, 22, 2),
			Block.makeCuboidShape(14, 1, 14, 15, 22, 15), Block.makeCuboidShape(1, 1, 14, 2, 22, 15))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();;

	public BlockStorageDrum(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (worldIn.isRemote)
			return ActionResultType.SUCCESS;
		TileEntityStorageDrum te = (TileEntityStorageDrum) worldIn.getTileEntity(pos);
		ItemStack stack = player.getHeldItem(handIn);
		if (player.isSneaking()) {
			ModInventoryVibeHelper.withdrawFromInventory(te, player);
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);

			return ActionResultType.SUCCESS;
		}
		if (!stack.isEmpty()) {
			te.addItem(player, stack, handIn);
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;
		}

		return ActionResultType.FAIL;

	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_N;
	}

	@Override
	public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {
	}

	@Override
	public void animateTick(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos,
			@Nonnull Random random) {
		TileEntityStorageDrum tile = (TileEntityStorageDrum) world.getTileEntity(pos);
		if (tile != null && tile instanceof TileEntityStorageDrum) {
			int count = (int) (10 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() - 0.1 + random.nextDouble() * 1.2;
					double randY = pos.getY() - 0.1 + random.nextDouble() * 1.2;
					double randZ = pos.getZ() - 0.1 + random.nextDouble() * 1.2;
					world.addParticle(ParticleTypes.REVERSE_PORTAL, randX, randY, randZ, 0, 0, 0);

				}
			}
		}
	}

	@Override
	public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
		super.onPlayerDestroy(worldIn, pos, state);

		// inner ring
		for (int j = 0; j < 30; j++) {

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
		for (int i = 0; i < 30; i++) {
			worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
					Math.sin(i) / 3, Math.sin(i) / 3, Math.cos(i) / 3);
			worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
					Math.cos(i) / 3, Math.sin(i) / 3, Math.sin(i) / 3);
			worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
					Math.sin(-i) / 3, Math.sin(i) / 3, Math.cos(-i) / 3);
			worldIn.addParticle(ParticleTypes.DRAGON_BREATH, pos.getX() + .5, pos.getY(), pos.getZ() + .5,
					Math.cos(-i) / 3, Math.sin(i) / 3, Math.sin(-i) / 3);
		}

		worldIn.playSound(null, pos, SoundEvents.BLOCK_BEACON_DEACTIVATE,  SoundCategory.AMBIENT, 10f, 0.01F);

	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityStorageDrum();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

}
