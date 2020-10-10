package com.huto.hutosmod.objects.blocks;

import java.util.stream.Stream;

import com.huto.hutosmod.objects.tileenties.TileEntityAscendentAltar;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BlockAscendentAltar extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream
			.of(Block.makeCuboidShape(0, 0, 1, 16, 1, 15), Block.makeCuboidShape(3, 1, 4, 13, 3, 12),
					Block.makeCuboidShape(3, 11, 4, 13, 13, 12), Block.makeCuboidShape(0, 13, 1, 16, 14, 15),
					Block.makeCuboidShape(1, 12, 14, 15, 13, 15), Block.makeCuboidShape(3, 1, 2, 13, 2, 4),
					Block.makeCuboidShape(3, 1, 12, 13, 2, 14), Block.makeCuboidShape(1, 12, 1, 15, 13, 2),
					Block.makeCuboidShape(13, 1, 2, 15, 2, 14), Block.makeCuboidShape(13, 12, 2, 16, 13, 14),
					Block.makeCuboidShape(1, 1, 2, 3, 2, 14), Block.makeCuboidShape(0, 12, 2, 3, 13, 14),
					Block.makeCuboidShape(9, 3, 6, 12, 11, 10), Block.makeCuboidShape(4, 3, 6, 7, 11, 10))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream
			.of(Block.makeCuboidShape(1, 0, 0, 15, 1, 16), Block.makeCuboidShape(4, 1, 3, 12, 3, 13),
					Block.makeCuboidShape(4, 11, 3, 12, 13, 13), Block.makeCuboidShape(1, 13, 0, 15, 14, 16),
					Block.makeCuboidShape(14, 12, 1, 15, 13, 15), Block.makeCuboidShape(2, 1, 3, 4, 2, 13),
					Block.makeCuboidShape(12, 1, 3, 14, 2, 13), Block.makeCuboidShape(1, 12, 1, 2, 13, 15),
					Block.makeCuboidShape(2, 1, 1, 14, 2, 3), Block.makeCuboidShape(2, 12, 0, 14, 13, 3),
					Block.makeCuboidShape(2, 1, 13, 14, 2, 15), Block.makeCuboidShape(2, 12, 13, 14, 13, 16),
					Block.makeCuboidShape(6, 3, 4, 10, 11, 7), Block.makeCuboidShape(6, 3, 9, 10, 11, 12))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public BlockAscendentAltar(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.SOUTH));

	}

	/*
	 * @Override public ActionResultType onBlockActivated(BlockState state, World
	 * worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult
	 * result) { if (!worldIn.isRemote) { TileEntity tile =
	 * worldIn.getTileEntity(pos); if (tile instanceof TileEntityChiselStation) {
	 * TileEntityChiselStation te = (TileEntityChiselStation) tile; if
	 * (te.numPlayersUsing < 2) { NetworkHooks.openGui((ServerPlayerEntity) player,
	 * (TileEntityChiselStation) tile, pos); return ActionResultType.SUCCESS; } }
	 * else { return ActionResultType.PASS;
	 * 
	 * } } return ActionResultType.FAIL; }
	 */
	/*
	 * @Override public void onReplaced(BlockState state, World worldIn, BlockPos
	 * pos, BlockState newState, boolean isMoving) { if (state.getBlock() !=
	 * newState.getBlock()) { TileEntity te = worldIn.getTileEntity(pos); if (te
	 * instanceof TileEntityChiselStation) { InventoryHelper.dropItems(worldIn, pos,
	 * ((TileEntityChiselStation) te).getItems()); } }
	 * 
	 * }
	 */

	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch ((Direction) state.get(FACING)) {
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_N;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_E;
		default:
			return SHAPE_N;
		}
	}

	@Override
	public void onNeighborChange(BlockState state, IWorldReader world, BlockPos pos, BlockPos neighbor) {
	}

	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
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
		return new TileEntityAscendentAltar();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

}
