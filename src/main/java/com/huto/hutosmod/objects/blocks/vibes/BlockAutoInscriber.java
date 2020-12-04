package com.huto.hutosmod.objects.blocks.vibes;

import java.util.stream.Stream;

import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.objects.blocks.util.IActivatable;
import com.huto.hutosmod.objects.blocks.util.ModInventoryVibeHelper;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;
import com.huto.hutosmod.objects.tileenties.vibes.TileEntityAutoInscriber;

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

public class BlockAutoInscriber extends Block implements IActivatable{
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(14, 2, 0, 16, 13, 2),
			Block.makeCuboidShape(14, 2, 14, 16, 13, 16), Block.makeCuboidShape(0, 15, 0, 16, 16, 16),
			Block.makeCuboidShape(2, 14, 0, 14, 15, 2), Block.makeCuboidShape(2, 14, 14, 14, 15, 16),
			Block.makeCuboidShape(0, 14, 2, 2, 15, 14), Block.makeCuboidShape(14, 14, 2, 16, 15, 14),
			Block.makeCuboidShape(2, 1, 0, 14, 2, 2), Block.makeCuboidShape(14, 1, 2, 16, 2, 14),
			Block.makeCuboidShape(2, 1, 14, 14, 2, 16), Block.makeCuboidShape(0, 1, 2, 2, 2, 14),
			Block.makeCuboidShape(3, 2, 1, 13, 3, 3), Block.makeCuboidShape(3, 2, 13, 13, 3, 15),
			Block.makeCuboidShape(1, 2, 3, 3, 3, 13), Block.makeCuboidShape(13, 2, 3, 15, 3, 13),
			Block.makeCuboidShape(2, 1, 2, 14, 2, 14), Block.makeCuboidShape(0, 2, 0, 2, 13, 2),
			Block.makeCuboidShape(0, 2, 14, 2, 13, 16), Block.makeCuboidShape(-1, 13, -1, 2, 15, 2),
			Block.makeCuboidShape(-1, 13, 14, 2, 15, 17), Block.makeCuboidShape(14, 13, 14, 17, 15, 17),
			Block.makeCuboidShape(14, 13, -1, 17, 15, 2), Block.makeCuboidShape(14, 0, 14, 16, 2, 16),
			Block.makeCuboidShape(14, 0, 0, 16, 2, 2), Block.makeCuboidShape(0, 0, 14, 2, 2, 16),
			Block.makeCuboidShape(0, 0, 0, 2, 2, 2), Block.makeCuboidShape(2, 0, 2, 14, 1, 14)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();


	public BlockAutoInscriber(Properties properties) {
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
		TileEntityAutoInscriber te = (TileEntityAutoInscriber) worldIn.getTileEntity(pos);
		ItemStack stack = player.getHeldItemMainhand();

		if (stack.isEmpty()) {
			ModInventoryVibeHelper.withdrawFromInventory(te, player);
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;
		}
		// If there is something in your hand add it to the block if its not an //
		if (!stack.isEmpty() && !(stack.getItem() == ItemInit.enhanced_magatama.get())) {
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
		return new TileEntityAutoInscriber();
	}

	@Override
	public boolean onUsedByActivator(PlayerEntity player, ItemStack stack, World world, BlockPos pos, Direction face) {
		((TileEntityAutoInscriber) world.getTileEntity(pos)).onActivated(player, stack);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

}
