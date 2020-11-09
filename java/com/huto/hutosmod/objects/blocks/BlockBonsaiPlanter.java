package com.huto.hutosmod.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
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

public class BlockBonsaiPlanter extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(1.9999875000000022, 0, 3.9999874999999996, 4.999987500000002, 1, 6.9999875),
			Block.makeCuboidShape(10.9999875, 0, 3.9999874999999996, 13.9999875, 1, 6.9999875),
			Block.makeCuboidShape(10.9999875, 0, 8.9999875, 13.9999875, 1, 11.9999875),
			Block.makeCuboidShape(1.9999875000000022, 0, 8.9999875, 4.999987500000002, 1, 11.9999875),
			Block.makeCuboidShape(12.9999875, 2, 4.9999875, 13.9999875, 5, 10.9999875),
			Block.makeCuboidShape(2.9999875000000022, 1, 4.9999875, 12.9999875, 2, 10.9999875),
			Block.makeCuboidShape(1.9999875000000022, 2, 4.9999875, 2.9999875000000022, 5, 10.9999875),
			Block.makeCuboidShape(2.9999875000000022, 2, 10.9999875, 12.9999875, 5, 11.9999875),
			Block.makeCuboidShape(2.9999875000000022, 2, 3.9999874999999996, 12.9999875, 5, 4.9999875),
			Block.makeCuboidShape(2.9999875000000022, 4, 4.9999875, 12.9999875, 5, 10.9999875)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(8.9999875, 0, 1.9999875000000014, 11.9999875, 1, 4.999987500000001),
			Block.makeCuboidShape(8.9999875, 0, 10.9999875, 11.9999875, 1, 13.9999875),
			Block.makeCuboidShape(3.9999875000000005, 0, 10.9999875, 6.9999875000000005, 1, 13.9999875),
			Block.makeCuboidShape(3.9999875000000005, 0, 1.9999875000000014, 6.9999875000000005, 1, 4.999987500000001),
			Block.makeCuboidShape(4.9999875000000005, 2, 12.9999875, 10.9999875, 5, 13.9999875),
			Block.makeCuboidShape(4.9999875000000005, 1, 2.9999875000000022, 10.9999875, 2, 12.9999875),
			Block.makeCuboidShape(4.9999875000000005, 2, 1.9999875000000014, 10.9999875, 5, 2.9999875000000014),
			Block.makeCuboidShape(3.9999875000000005, 2, 2.9999875000000022, 4.9999875000000005, 5, 12.9999875),
			Block.makeCuboidShape(10.9999875, 2, 2.9999875000000022, 11.9999875, 5, 12.9999875),
			Block.makeCuboidShape(4.9999875000000005, 4, 2.9999875000000022, 10.9999875, 5, 12.9999875)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();


	private static final VoxelShape SHAPE_R = Block.makeCuboidShape(-8, 0, -7, 24, 32, 25);

	public BlockBonsaiPlanter(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	@Override
	public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return SHAPE_R;
	}

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



/*	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		ItemStack stack = player.getHeldItemMainhand();
		Item item = stack.getItem();
		if (item == Items.SHEARS) {
			ItemEntity outputItem = new ItemEntity(worldIn, pos.getX() + 0.5, pos.getY() + 1.5, pos.getZ() + 0.5,
					getShearDrop());
			worldIn.addEntity(outputItem);
			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.FAIL;

		}

	}
*/
}
