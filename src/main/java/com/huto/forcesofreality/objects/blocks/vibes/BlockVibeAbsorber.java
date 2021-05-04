package com.huto.forcesofreality.objects.blocks.vibes;

import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.objects.blocks.util.ModInventoryVibeHelper;
import com.huto.forcesofreality.objects.items.ItemUpgrade;
import com.huto.forcesofreality.objects.tileenties.vibes.gen.TileEntityAbsorber;
import com.hutoslib.common.VanillaPacketDispatcher;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockVibeAbsorber extends Block {
	public static final DirectionProperty FACING = DirectionalBlock.FACING;
	private static final VoxelShape SHAPE_U = Stream
			.of(Block.makeCuboidShape(4, 0, 4, 12, 1, 12), Block.makeCuboidShape(5, 1, 5, 11, 2, 11),
					Block.makeCuboidShape(11, 2, 4, 12, 3, 5), Block.makeCuboidShape(4, 2, 4, 5, 3, 5),
					Block.makeCuboidShape(11, 2, 11, 12, 3, 12), Block.makeCuboidShape(4, 2, 11, 5, 3, 12),
					Block.makeCuboidShape(7, 2, 7, 9, 7, 9), Block.makeCuboidShape(7, 8, 7, 9, 10, 9))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_D = Stream.of(Block.makeCuboidShape(4, 15, 4, 12, 16, 12),
			Block.makeCuboidShape(5, 14, 5, 11, 15, 11), Block.makeCuboidShape(11, 13, 11, 12, 14, 12),
			Block.makeCuboidShape(4, 13, 11, 5, 14, 12), Block.makeCuboidShape(11, 13, 4, 12, 14, 5),
			Block.makeCuboidShape(4, 13, 4, 5, 14, 5), Block.makeCuboidShape(7, 9, 7, 9, 14, 9)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(4, 4, 15, 12, 12, 16),
			Block.makeCuboidShape(5, 5, 14, 11, 11, 15), Block.makeCuboidShape(11, 4, 13, 12, 5, 14),
			Block.makeCuboidShape(4, 4, 13, 5, 5, 14), Block.makeCuboidShape(11, 11, 13, 12, 12, 14),
			Block.makeCuboidShape(4, 11, 13, 5, 12, 14),
			Block.makeCuboidShape(7, 6.999999999999998, 8.999999999999998, 9, 8.999999999999998, 13.999999999999998))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(4, 4, 0, 12, 12, 1),
			Block.makeCuboidShape(5, 5, 1, 11, 11, 2), Block.makeCuboidShape(11, 11, 2, 12, 12, 3),
			Block.makeCuboidShape(4, 11, 2, 5, 12, 3), Block.makeCuboidShape(11, 4, 2, 12, 5, 3),
			Block.makeCuboidShape(4, 4, 2, 5, 5, 3),
			Block.makeCuboidShape(7, 6.999999999999998, 1.9999999999999982, 9, 8.999999999999998, 6.999999999999998))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(15, 4, 4, 16, 12, 12),
			Block.makeCuboidShape(14, 5, 5, 15, 11, 11), Block.makeCuboidShape(13, 11, 4, 14, 12, 5),
			Block.makeCuboidShape(13, 4, 4, 14, 5, 5), Block.makeCuboidShape(13, 11, 11, 14, 12, 12),
			Block.makeCuboidShape(13, 4, 11, 14, 5, 12),
			Block.makeCuboidShape(9.000000000000002, 7.000000000000002, 7, 14.000000000000004, 9.000000000000002, 9))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(0, 4, 4, 1, 12, 12),
			Block.makeCuboidShape(1, 5, 5, 2, 11, 11), Block.makeCuboidShape(2, 4, 4, 3, 5, 5),
			Block.makeCuboidShape(2, 11, 4, 3, 12, 5), Block.makeCuboidShape(2, 4, 11, 3, 5, 12),
			Block.makeCuboidShape(2, 11, 11, 3, 12, 12),
			Block.makeCuboidShape(1.9999999999999996, 7.000000000000002, 7, 7.000000000000002, 9.000000000000002, 9))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public BlockVibeAbsorber(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.UP));

	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch ((Direction) state.get(FACING)) {
		case UP:
			return SHAPE_U;
		case DOWN:
			return SHAPE_D;
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_S;
		case WEST:
			return SHAPE_W;
		case EAST:
			return SHAPE_E;
		default:
			return SHAPE_U;
		}
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (worldIn.isRemote)
			return ActionResultType.PASS;
		TileEntityAbsorber te = (TileEntityAbsorber) worldIn.getTileEntity(pos);
		ItemStack stack = player.getHeldItem(handIn);
		if (stack.getItem() == ItemInit.upgrade_wrench.get()) {
			ModInventoryVibeHelper.withdrawFromInventory(te, player);
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;
		}
		// If there is something in your hand add it to the block if its not an //
		if (!stack.isEmpty() && stack.getItem() instanceof ItemUpgrade) {
			te.addItem(player, stack, handIn);
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;
		}
		// Upgrade clause
		if (stack.getItem() == ItemInit.enhanced_magatama.get() && te.getTankLevel() < 3) {
			te.addTankLevel(1);
			te.checkTransferRate();
			te.checkTankSize();
			player.getHeldItemMainhand().shrink(1);
			player.getHeldItemOffhand().shrink(1);
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;
		}
		// Cycle Clause
		if (stack.getItem() == ItemInit.absorber_configurer.get()) {
			te.cycleEnumMode();
			VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
			return ActionResultType.SUCCESS;

		}
		VanillaPacketDispatcher.dispatchTEToNearbyPlayers(te);
		return ActionResultType.FAIL;

	}

	@Override
	public void animateTick(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos,
			@Nonnull Random random) {
		TileEntityAbsorber tile = (TileEntityAbsorber) world.getTileEntity(pos);
		if (tile != null && tile instanceof TileEntityAbsorber) {
			int count = (int) (4 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() - 0.1 + random.nextDouble() * 1.2;
					double randY = pos.getY() - 0.1 + random.nextDouble() * 1.2;
					double randZ = pos.getZ() - 0.1 + random.nextDouble() * 1.2;

					world.addParticle(ParticleTypes.PORTAL, randX, randY, randZ, 0, 0, 0);

				}
			}
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		Direction direction = context.getFace();
		BlockState blockstate = context.getWorld().getBlockState(context.getPos().offset(direction.getOpposite()));
		return blockstate.isIn(this) && blockstate.get(FACING) == direction
				? this.getDefaultState().with(FACING, direction.getOpposite())
				: this.getDefaultState().with(FACING, direction);
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.with(FACING, mirrorIn.mirror(state.get(FACING)));
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
		return new TileEntityAbsorber();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

}
