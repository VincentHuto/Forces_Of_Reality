package com.huto.hutosmod.objects.blocks.vibes;

import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.huto.hutosmod.objects.tileenties.vibes.func.TileEntityVibeConcetrator;
import com.huto.hutosmod.particles.ParticleColor;
import com.huto.hutosmod.particles.data.GlowParticleData;

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

public class BlockVibeConcetrator extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(3, 6, 3, 7, 11, 7),
			Block.makeCuboidShape(1, 0, 1, 5, 1, 5), Block.makeCuboidShape(1, 3, 1, 2, 5, 2),
			Block.makeCuboidShape(11, 3, 1, 12, 5, 2), Block.makeCuboidShape(11, 3, 11, 12, 5, 12),
			Block.makeCuboidShape(1, 3, 11, 2, 5, 12), Block.makeCuboidShape(1, 3, 14, 2, 5, 15),
			Block.makeCuboidShape(11, 3, 14, 12, 5, 15), Block.makeCuboidShape(11, 3, 4, 12, 5, 5),
			Block.makeCuboidShape(1, 3, 4, 2, 5, 5), Block.makeCuboidShape(2, 1, 2, 4, 5, 4),
			Block.makeCuboidShape(4, 3, 11, 5, 5, 12), Block.makeCuboidShape(14, 3, 11, 15, 5, 12),
			Block.makeCuboidShape(14, 3, 1, 15, 5, 2), Block.makeCuboidShape(4, 3, 1, 5, 5, 2),
			Block.makeCuboidShape(4, 3, 14, 5, 5, 15), Block.makeCuboidShape(14, 3, 14, 15, 5, 15),
			Block.makeCuboidShape(14, 3, 4, 15, 5, 5), Block.makeCuboidShape(1, 0, 11, 5, 1, 15),
			Block.makeCuboidShape(3, 11, 3, 13, 14, 13), Block.makeCuboidShape(9, 6, 9, 13, 11, 13),
			Block.makeCuboidShape(3, 6, 9, 7, 11, 13), Block.makeCuboidShape(11, 5, 1, 15, 6, 5),
			Block.makeCuboidShape(1, 5, 11, 5, 6, 15), Block.makeCuboidShape(11, 5, 11, 15, 6, 15),
			Block.makeCuboidShape(11, 0, 11, 15, 1, 15), Block.makeCuboidShape(12, 1, 12, 14, 5, 14),
			Block.makeCuboidShape(2, 1, 12, 4, 5, 14), Block.makeCuboidShape(9, 6, 3, 13, 11, 7),
			Block.makeCuboidShape(1, 5, 1, 5, 6, 5), Block.makeCuboidShape(13, 8, 3, 14, 10, 13),
			Block.makeCuboidShape(2, 12, 3, 3, 14, 13), Block.makeCuboidShape(3, 12, 13, 13, 14, 14),
			Block.makeCuboidShape(1, 10, 7, 3, 12, 9), Block.makeCuboidShape(7, 10, 1, 9, 12, 3),
			Block.makeCuboidShape(7, 10, 13, 9, 12, 15), Block.makeCuboidShape(3, 8, 13, 13, 10, 14),
			Block.makeCuboidShape(2, 8, 3, 3, 10, 13), Block.makeCuboidShape(13, 12, 3, 14, 14, 13),
			Block.makeCuboidShape(12, 1, 2, 14, 5, 4), Block.makeCuboidShape(3, 8, 2, 13, 10, 3),
			Block.makeCuboidShape(11, 0, 1, 15, 1, 5), Block.makeCuboidShape(3, 12, 2, 13, 14, 3),
			Block.makeCuboidShape(13, 10, 7, 15, 12, 9), Block.makeCuboidShape(4, 3, 4, 5, 5, 5)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();;

	public BlockVibeConcetrator(Properties properties) {
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
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
		TileEntity te = worldIn.getTileEntity(pos);
		if (te instanceof TileEntityVibeConcetrator) {
			((TileEntityVibeConcetrator) te).checkStructure();
		}
	}

	@Override
	public void animateTick(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos,
			@Nonnull Random random) {
		TileEntityVibeConcetrator tile = (TileEntityVibeConcetrator) world.getTileEntity(pos);
		if (tile != null && tile instanceof TileEntityVibeConcetrator) {
			int count = (int) (10 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() - 0.1 + random.nextDouble() * 1.2;
					double randY = pos.getY() - 0.1 + random.nextDouble() * 1.2;
					double randZ = pos.getZ() - 0.1 + random.nextDouble() * 1.2;
					if (tile.canGenerate()) {
						world.addParticle(GlowParticleData.createData(new ParticleColor(200, 0, 0)),
								pos.getX() + 0.5 + randX, pos.getY() + 0.8f + randY, pos.getZ() + 0.5 + randZ, 0,
								world.rand.nextFloat() * 0.06f, 0);
					}
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
		return new TileEntityVibeConcetrator();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

}
