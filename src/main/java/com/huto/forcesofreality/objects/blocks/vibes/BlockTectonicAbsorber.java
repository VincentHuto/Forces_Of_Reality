package com.huto.forcesofreality.objects.blocks.vibes;

import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.objects.tileenties.vibes.gen.TileEntityTectonicAbsorber;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
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

public class BlockTectonicAbsorber extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(4, 9, 5, 5, 13, 11),
			Block.makeCuboidShape(5, 9, 4, 11, 13, 5), Block.makeCuboidShape(5, 9, 11, 11, 13, 12),
			Block.makeCuboidShape(11, 9, 5, 12, 13, 11), Block.makeCuboidShape(5, 3, 11, 11, 6, 12),
			Block.makeCuboidShape(5, 3, 4, 11, 6, 5), Block.makeCuboidShape(11, 3, 5, 12, 6, 11),
			Block.makeCuboidShape(4, 3, 5, 5, 6, 11), Block.makeCuboidShape(5, 3, 5, 11, 12, 11),
			Block.makeCuboidShape(6, 12.01, 6, 10, 12.01, 10), Block.makeCuboidShape(4, 2, 4, 12, 3, 12),
			Block.makeCuboidShape(5, 1, 5, 11, 2, 11), Block.makeCuboidShape(2, 0, 2, 4, 4, 4),
			Block.makeCuboidShape(12, 0, 2, 14, 4, 4), Block.makeCuboidShape(3, 4, 3, 5, 6, 5),
			Block.makeCuboidShape(3, 4, 11, 5, 6, 13), Block.makeCuboidShape(11, 4, 11, 13, 6, 13),
			Block.makeCuboidShape(11, 4, 3, 13, 6, 5), Block.makeCuboidShape(7, 1, 3, 9, 2, 5),
			Block.makeCuboidShape(7, 1, 11, 9, 2, 13), Block.makeCuboidShape(4, 0, 4, 12, 1, 12),
			Block.makeCuboidShape(2, 0, 12, 4, 4, 14), Block.makeCuboidShape(12, 0, 12, 14, 4, 14),
			Block.makeCuboidShape(3, 1, 7, 5, 2, 9), Block.makeCuboidShape(11, 1, 7, 13, 2, 9)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public BlockTectonicAbsorber(Properties properties) {
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
		if (te instanceof TileEntityTectonicAbsorber) {
			((TileEntityTectonicAbsorber) te).checkStructure();
		}
	}

	@Override
	public void animateTick(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos,
			@Nonnull Random random) {
		TileEntityTectonicAbsorber tile = (TileEntityTectonicAbsorber) world.getTileEntity(pos);
		if (tile != null && tile instanceof TileEntityTectonicAbsorber) {
			int count = (int) (10 * 0.5f);
			if (count > 0) {
				for (int i = 0; i < random.nextInt(count); i++) {
					double randX = pos.getX() - 0.1 + random.nextDouble() * 1.2;
					double randY = pos.getY() - 0.1 + random.nextDouble() * 1.2;
					double randZ = pos.getZ() - 0.1 + random.nextDouble() * 1.2;
					if (tile.canGenerate()) {
						world.addParticle(ParticleTypes.ASH, randX, randY, randZ, 0, 0, 0);
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
		return new TileEntityTectonicAbsorber();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		super.onBlockClicked(state, worldIn, pos, player);
	}

}
