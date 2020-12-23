package com.huto.forces_of_reality.objects.blocks.vibes;

import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.huto.forces_of_reality.init.ItemInit;
import com.huto.forces_of_reality.objects.blocks.util.IActivatable;
import com.huto.forces_of_reality.objects.blocks.util.ModInventoryVibeHelper;
import com.huto.forces_of_reality.objects.tileenties.util.VanillaPacketDispatcher;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntityRafflesiaOfFidelity;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockRafflesiaOfFidelity extends Block implements IActivatable {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(4, 1, 4, 12, 3, 12),
			Block.makeCuboidShape(1, 10, 1, 15, 11, 15), Block.makeCuboidShape(5, 11, 14, 11, 12, 20),
			Block.makeCuboidShape(5, 11, -4, 11, 12, 2), Block.makeCuboidShape(14, 11, 9, 20, 12, 15),
			Block.makeCuboidShape(14, 11, 1, 20, 12, 7), Block.makeCuboidShape(-3, 11, 9, 3, 12, 15),
			Block.makeCuboidShape(-3, 11, 1, 3, 12, 7), Block.makeCuboidShape(1, 7, 1, 4, 8, 4),
			Block.makeCuboidShape(1, 7, 12, 4, 8, 15), Block.makeCuboidShape(12, 7, 12, 15, 8, 15),
			Block.makeCuboidShape(12, 7, 1, 15, 8, 4), Block.makeCuboidShape(4, 8, 4, 12, 10, 12),
			Block.makeCuboidShape(7, 4, 7, 9, 7, 9), Block.makeCuboidShape(5, 3, 5, 11, 4, 11),
			Block.makeCuboidShape(6, 0, 6, 10, 1, 10), Block.makeCuboidShape(5, 7, 5, 11, 8, 11),
			Block.makeCuboidShape(4, 3, 4, 5, 4, 5), Block.makeCuboidShape(4, 0, 4, 6, 1, 6),
			Block.makeCuboidShape(11, 3, 4, 12, 4, 5), Block.makeCuboidShape(9, 4, 6, 10, 7, 7),
			Block.makeCuboidShape(6, 4, 6, 7, 7, 7), Block.makeCuboidShape(9, 4, 9, 10, 7, 10),
			Block.makeCuboidShape(13, 8, 13, 14, 10, 14), Block.makeCuboidShape(2, 8, 13, 3, 10, 14),
			Block.makeCuboidShape(4, 11, 4, 5, 15, 5), Block.makeCuboidShape(11, 11, 4, 12, 15, 5),
			Block.makeCuboidShape(11, 11, 11, 12, 15, 12), Block.makeCuboidShape(11, 11, 11, 12, 15, 12),
			Block.makeCuboidShape(4, 11, 11, 5, 15, 12), Block.makeCuboidShape(13, 8, 2, 14, 10, 3),
			Block.makeCuboidShape(2, 8, 2, 3, 10, 3), Block.makeCuboidShape(6, 4, 9, 7, 7, 10),
			Block.makeCuboidShape(10, 0, 4, 12, 1, 6), Block.makeCuboidShape(4, 3, 11, 5, 4, 12),
			Block.makeCuboidShape(4, 0, 10, 6, 1, 12), Block.makeCuboidShape(11, 3, 11, 12, 4, 12),
			Block.makeCuboidShape(10, 0, 10, 12, 1, 12), Block.makeCuboidShape(12, 1, 12, 13, 3, 13),
			Block.makeCuboidShape(12, 1, 3, 13, 3, 4), Block.makeCuboidShape(3, 1, 3, 4, 3, 4),
			Block.makeCuboidShape(3, 1, 12, 4, 3, 13), Block.makeCuboidShape(6, 12, 4, 10, 15, 5),
			Block.makeCuboidShape(6, 11, 6, 10, 12, 10), Block.makeCuboidShape(4, 12, 6, 5, 15, 10),
			Block.makeCuboidShape(4, 13.848901058456383, 1.2806942183044017, 12, 13.848901058456383, 5.280694218304388),
			Block.makeCuboidShape(5, 13.848901058456383, 0.28069421830440167, 11, 13.848901058456383,
					1.2806942183043883),
			Block.makeCuboidShape(1.2683148011248995, 13.911136591332374, 5, 2.26831480112489, 13.911136591332374, 11),
			Block.makeCuboidShape(2.2683148011248995, 13.911136591332374, 4, 5.26831480112489, 13.911136591332374, 12),
			Block.makeCuboidShape(6, 13.500000000000002, 6, 10, 15.5, 10),
			Block.makeCuboidShape(4, 13.767311814473318, 10.703076672022226, 12, 13.767311814473318,
					13.703076672022215),
			Block.makeCuboidShape(10.690697254842712, 13.705076281597337, 4, 13.69069725484272, 13.705076281597337, 12),
			Block.makeCuboidShape(5, 13.767311814473318, 13.703076672022226, 11, 13.767311814473318,
					14.703076672022215),
			Block.makeCuboidShape(13.690697254842712, 13.705076281597337, 5, 14.69069725484272, 13.705076281597337, 11),
			Block.makeCuboidShape(6, 12, 11, 10, 15, 12), Block.makeCuboidShape(5, 12, 5, 11, 15, 11),
			Block.makeCuboidShape(11, 12, 6, 12, 15, 10)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public BlockRafflesiaOfFidelity(Properties properties) {
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
		TileEntityRafflesiaOfFidelity te = (TileEntityRafflesiaOfFidelity) worldIn.getTileEntity(pos);
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
	public void animateTick(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos,
			@Nonnull Random random) {
		TileEntityRafflesiaOfFidelity tile = (TileEntityRafflesiaOfFidelity) world.getTileEntity(pos);
		if (tile != null && tile instanceof TileEntityRafflesiaOfFidelity) {
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
					world.addParticle(ParticleTypes.WHITE_ASH, randX, randY, randZ, 0, 0, 0);

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
		return new TileEntityRafflesiaOfFidelity();
	}

	@Override
	public boolean onUsedByActivator(PlayerEntity player, ItemStack stack, World world, BlockPos pos, Direction face) {
		((TileEntityRafflesiaOfFidelity) world.getTileEntity(pos)).onActivated(player, stack);
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

}
