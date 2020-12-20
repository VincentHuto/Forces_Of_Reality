package com.huto.hutosmod.objects.blocks.vibes;

import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.huto.hutosmod.objects.blocks.util.IActivatable;
import com.huto.hutosmod.objects.tileenties.vibes.func.TileEntityKarmicExtractor;

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

public class BlockKarmicExtractor extends Block implements IActivatable{
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(3, 2, 3, 13, 4, 13),
			Block.makeCuboidShape(1, 0, 1, 15, 2, 15), Block.makeCuboidShape(5, 4, 5, 11, 5, 11),
			Block.makeCuboidShape(7, 12, 7, 9, 14, 9), Block.makeCuboidShape(7, 12, 7, 9, 14, 9),
			Block.makeCuboidShape(5, 4, 4, 6, 12, 5), Block.makeCuboidShape(4, 4, 5, 5, 12, 6),
			Block.makeCuboidShape(5, 4, 11, 6, 12, 12), Block.makeCuboidShape(4, 4, 10, 5, 12, 11),
			Block.makeCuboidShape(10, 4, 4, 11, 12, 5), Block.makeCuboidShape(11, 4, 5, 12, 12, 6),
			Block.makeCuboidShape(10, 4, 11, 11, 12, 12), Block.makeCuboidShape(11, 4, 10, 12, 12, 11))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();;

	public BlockKarmicExtractor(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));

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
		TileEntityKarmicExtractor tile = (TileEntityKarmicExtractor) world.getTileEntity(pos);
		if (tile != null && tile instanceof TileEntityKarmicExtractor) {
			int count = (int) (10 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() - 0.1 + random.nextDouble() * 1.2;
					double randY = pos.getY() - 0.1 + random.nextDouble() * 1.2;
					double randZ = pos.getZ() - 0.1 + random.nextDouble() * 1.2;
					world.addParticle(ParticleTypes.ASH, randX, randY, randZ, 1, 1, 1);

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
		return new TileEntityKarmicExtractor();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

	@Override
	public boolean onUsedByActivator(PlayerEntity player, ItemStack stack, World world, BlockPos pos, Direction face) {
		((TileEntityKarmicExtractor) world.getTileEntity(pos)).onActivated(player, stack);
		return true;
	}


}
