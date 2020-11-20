package com.huto.hutosmod.objects.blocks;

import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.init.ParticleInit;
import com.huto.hutosmod.objects.blocks.util.IActivatable;
import com.huto.hutosmod.objects.blocks.util.ModInventoryVibeHelper;
import com.huto.hutosmod.objects.tileenties.TileEntityWandMaker;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockWandMaker extends Block implements IActivatable {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream
			.of(Block.makeCuboidShape(2, 0, 2, 14, 2, 14), Block.makeCuboidShape(4, 2, 4, 12, 3, 12),
					Block.makeCuboidShape(7, 3, 7, 9, 10, 9), Block.makeCuboidShape(4, 10, 4, 12, 11, 12))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public BlockWandMaker(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_N;
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (worldIn.isRemote)
			return ActionResultType.SUCCESS;
		TileEntityWandMaker te = (TileEntityWandMaker) worldIn.getTileEntity(pos);
		ItemStack stack = player.getHeldItemMainhand();

		if (stack.isEmpty()) {
			ModInventoryVibeHelper.withdrawFromInventory(te, player);
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;
		}
		// If there is something in your hand add it to the block if its not an //
		if (!stack.isEmpty() && !(stack.getItem() == ItemInit.enhancedmagatama.get())) {
			te.addItem(player, stack, handIn);
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;
		}
		// Upgrade clause
		if (stack.getItem() == ItemInit.enhancedmagatama.get() && te.getLevel() < 9) {
			te.addLevel(1);
			player.getHeldItemMainhand().shrink(1);

		}
		VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
		return ActionResultType.SUCCESS;
	}

	@Override
	public void animateTick(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos,
			@Nonnull Random random) {
		TileEntityWandMaker tile = (TileEntityWandMaker) world.getTileEntity(pos);
		if (tile != null && tile instanceof TileEntityWandMaker) {
			int count = (int) (10 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() - 0.1 + random.nextDouble() * 1.2;
					double randY = pos.getY() - 0.1 + random.nextDouble() * 1.2;
					double randZ = pos.getZ() - 0.1 + random.nextDouble() * 1.2;
					/*
					 * world.addParticle(new GenericParticleData(false, 0.0f, 1.0f, 0.0f, 1.0f,
					 * 100), pos.getX() + 0.5f, pos.getY() + 0.5f, pos.getZ() + 0.5f, 0.0f, 0.0f,
					 * 0.0f);
					 */
					world.addParticle((BasicParticleType) ParticleInit.RADIATION.getParticleType(), randX, randY, randZ,
							0, 0, 0);

				}
			}
		}
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
		return new TileEntityWandMaker();
	}

	@Override
	public boolean onUsedByActivator(PlayerEntity player, ItemStack stack, World world, BlockPos pos, Direction face) {
		((TileEntityWandMaker) world.getTileEntity(pos)).onActivated(player, stack);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

}
