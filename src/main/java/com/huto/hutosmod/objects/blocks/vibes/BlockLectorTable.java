package com.huto.hutosmod.objects.blocks.vibes;

import java.util.stream.Stream;

import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;
import com.huto.hutosmod.objects.tileenties.vibes.func.TileEntityLectorTable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
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

public class BlockLectorTable extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream
			.of(Block.makeCuboidShape(0, 12, 1, 1, 13, 15), Block.makeCuboidShape(12, 0, 3, 13, 6, 4),
					Block.makeCuboidShape(14, 0, 2, 15, 2, 3), Block.makeCuboidShape(13, 0, 1, 14, 2, 2),
					Block.makeCuboidShape(13, 0, 2, 14, 3, 3), Block.makeCuboidShape(12, 0, 2, 13, 4, 3),
					Block.makeCuboidShape(13, 0, 3, 14, 4, 4), Block.makeCuboidShape(11, 0, 0, 14, 1, 1),
					Block.makeCuboidShape(15, 0, 2, 16, 1, 5), Block.makeCuboidShape(0, 0.1, 0, 16, 0.1, 16),
					Block.makeCuboidShape(11, 6, 3, 13, 8, 5), Block.makeCuboidShape(3, 0, 3, 4, 6, 4),
					Block.makeCuboidShape(3, 6, 3, 5, 8, 5), Block.makeCuboidShape(2, 0, 2, 3, 3, 3),
					Block.makeCuboidShape(3, 0, 2, 4, 4, 3), Block.makeCuboidShape(2, 0, 3, 3, 4, 4),
					Block.makeCuboidShape(1, 0, 2, 2, 2, 3), Block.makeCuboidShape(4, 4, 4, 5, 6, 5),
					Block.makeCuboidShape(4, 4, 11, 5, 6, 12), Block.makeCuboidShape(11, 4, 11, 12, 6, 12),
					Block.makeCuboidShape(11, 4, 4, 12, 6, 5), Block.makeCuboidShape(2, 0, 1, 3, 2, 2),
					Block.makeCuboidShape(0, 0, 2, 1, 1, 5), Block.makeCuboidShape(2, 0, 0, 5, 1, 1),
					Block.makeCuboidShape(3, 0, 12, 4, 6, 13), Block.makeCuboidShape(3, 6, 11, 5, 8, 13),
					Block.makeCuboidShape(2, 0, 13, 3, 3, 14), Block.makeCuboidShape(3, 0, 13, 4, 4, 14),
					Block.makeCuboidShape(2, 0, 12, 3, 4, 13), Block.makeCuboidShape(1, 0, 13, 2, 2, 14),
					Block.makeCuboidShape(2, 0, 14, 3, 2, 15), Block.makeCuboidShape(0, 0, 11, 1, 1, 14),
					Block.makeCuboidShape(2, 0, 15, 5, 1, 16), Block.makeCuboidShape(12, 0, 12, 13, 6, 13),
					Block.makeCuboidShape(11, 6, 11, 13, 8, 13), Block.makeCuboidShape(13, 0, 13, 14, 3, 14),
					Block.makeCuboidShape(12, 0, 13, 13, 4, 14), Block.makeCuboidShape(13, 0, 12, 14, 4, 13),
					Block.makeCuboidShape(14, 0, 13, 15, 2, 14), Block.makeCuboidShape(13, 0, 14, 14, 2, 15),
					Block.makeCuboidShape(15, 0, 11, 16, 1, 14), Block.makeCuboidShape(11, 0, 15, 14, 1, 16),
					Block.makeCuboidShape(4, 8, 4, 12, 10, 12), Block.makeCuboidShape(1, 10, 1, 15, 12, 15),
					Block.makeCuboidShape(0, 12.01, 0, 16, 13.01, 1),
					Block.makeCuboidShape(0, 12.01, 15, 16, 13.01, 16), Block.makeCuboidShape(15, 12, 1, 16, 13, 15),
					Block.makeCuboidShape(0, 13, -1, 16, 14, 0), Block.makeCuboidShape(0, 13, 16, 16, 14, 17),
					Block.makeCuboidShape(-1, 13, 1, 0, 14, 15), Block.makeCuboidShape(16, 13, 1, 17, 14, 15),
					Block.makeCuboidShape(12, 12, 1, 13, 13, 15), Block.makeCuboidShape(9, 12, 1, 10, 13, 15),
					Block.makeCuboidShape(3, 12, 1, 4, 13, 15), Block.makeCuboidShape(6, 12, 1, 7, 13, 15),
					Block.makeCuboidShape(1, 12.01, 3, 15, 13.01, 4), Block.makeCuboidShape(1, 12.01, 6, 15, 13.01, 7),
					Block.makeCuboidShape(1, 12.01, 9, 15, 13.01, 10),
					Block.makeCuboidShape(1, 12.01, 12, 15, 13.01, 13), Block.makeCuboidShape(7, 0, 7, 9, 8, 9),
					Block.makeCuboidShape(7, 0, 9, 9, 3, 11), Block.makeCuboidShape(7, 0, 5, 9, 3, 7),
					Block.makeCuboidShape(5, 0, 7, 7, 3, 9), Block.makeCuboidShape(9, 0, 7, 11, 3, 9),
					Block.makeCuboidShape(11, 0, 7, 12, 1, 9), Block.makeCuboidShape(4, 0, 7, 5, 1, 9),
					Block.makeCuboidShape(7, 0, 4, 9, 1, 5), Block.makeCuboidShape(7, 0, 11, 9, 1, 12))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public BlockLectorTable(Properties properties) {
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
		TileEntityLectorTable te = (TileEntityLectorTable) worldIn.getTileEntity(pos);
		ItemStack stack = player.getHeldItemMainhand();

		// Upgrade clause
		if (stack.getItem() == ItemInit.enhanced_magatama.get() && te.getLevel() < 5) {
			te.addLevel(1);
			player.getHeldItemMainhand().shrink(1);

		}
		VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
		return ActionResultType.SUCCESS;
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
		return new TileEntityLectorTable();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

}
