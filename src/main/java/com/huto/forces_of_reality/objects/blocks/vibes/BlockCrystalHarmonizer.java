package com.huto.forces_of_reality.objects.blocks.vibes;

import java.util.stream.Stream;

import com.huto.forces_of_reality.init.ItemInit;
import com.huto.forces_of_reality.objects.blocks.util.IActivatable;
import com.huto.forces_of_reality.objects.blocks.util.ModInventoryVibeHelper;
import com.huto.forces_of_reality.objects.tileenties.util.VanillaPacketDispatcher;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntityCrystalHarmonizer;

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

public class BlockCrystalHarmonizer extends Block implements IActivatable {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(4, 7, 5, 5, 9, 11),
			Block.makeCuboidShape(5, 7, 4, 11, 9, 5), Block.makeCuboidShape(5, 7, 11, 11, 9, 12),
			Block.makeCuboidShape(11, 7, 5, 12, 9, 11), Block.makeCuboidShape(2, 0, 2, 5, 1, 5),
			Block.makeCuboidShape(2, 0, 11, 5, 1, 14), Block.makeCuboidShape(11, 0, 2, 14, 1, 5),
			Block.makeCuboidShape(11, 0, 11, 14, 1, 14), Block.makeCuboidShape(5, 0, 11, 11, 3, 12),
			Block.makeCuboidShape(5, 0, 4, 11, 3, 5), Block.makeCuboidShape(11, 0, 5, 12, 3, 11),
			Block.makeCuboidShape(4, 0, 5, 5, 3, 11), Block.makeCuboidShape(14, 0, 5, 15, 1, 11),
			Block.makeCuboidShape(5, 0, 14, 11, 1, 15), Block.makeCuboidShape(5, 0, 1, 11, 1, 2),
			Block.makeCuboidShape(1, 0, 5, 2, 1, 11), Block.makeCuboidShape(5, 0, 5, 11, 9, 11),
			Block.makeCuboidShape(4, 9, 4, 12, 10, 12), Block.makeCuboidShape(12, 10, 4, 13, 11, 12),
			Block.makeCuboidShape(3, 10, 4, 4, 11, 12), Block.makeCuboidShape(4, 10, 3, 12, 11, 4),
			Block.makeCuboidShape(4, 10, 12, 12, 11, 13), Block.makeCuboidShape(4, 13, 12, 12, 14, 13),
			Block.makeCuboidShape(4, 13, 3, 12, 14, 4), Block.makeCuboidShape(12, 13, 4, 13, 14, 12),
			Block.makeCuboidShape(3, 13, 4, 4, 14, 12), Block.makeCuboidShape(1, 0.01, 1, 15, 0.010000000000000009, 15))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public BlockCrystalHarmonizer(Properties properties) {
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
		TileEntityCrystalHarmonizer te = (TileEntityCrystalHarmonizer) worldIn.getTileEntity(pos);
		ItemStack stack = player.getHeldItemMainhand();

		if (stack.isEmpty()) {
			ModInventoryVibeHelper.withdrawFromInventory(te, player);
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;
		}
		// If there is something in your hand add it to the block if its not an //
		if (!stack.isEmpty() && stack.getItem() != ItemInit.enhanced_magatama.get()&& stack.getItem() != ItemInit.vibration_debug_tool.get()) {
			te.addItem(player, stack, handIn);
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;
		}
		// Upgrade clause
		if (stack.getItem() == ItemInit.enhanced_magatama.get() && te.getLevel() < 9) {
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
		return new TileEntityCrystalHarmonizer();
	}

	@Override
	public boolean onUsedByActivator(PlayerEntity player, ItemStack stack, World world, BlockPos pos, Direction face) {
		((TileEntityCrystalHarmonizer) world.getTileEntity(pos)).onActivated(player, stack);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

}
