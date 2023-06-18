package com.vincenthuto.forcesofreality.common.block.bonsai;

import java.util.Map;
import java.util.stream.Stream;

import com.vincenthuto.forcesofreality.registry.BlockInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockBonsaiPlanter extends Block {
	public static final Map<Block, Item> BLOCK_TO_ITEM = net.minecraftforge.registries.GameData.getBlockItemMap();
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	private static final VoxelShape SHAPE_N = Stream
			.of(Block.box(1.9999875000000022, 0, 3.9999874999999996, 4.999987500000002, 1, 6.9999875),
					Block.box(10.9999875, 0, 3.9999874999999996, 13.9999875, 1, 6.9999875),
					Block.box(10.9999875, 0, 8.9999875, 13.9999875, 1, 11.9999875),
					Block.box(1.9999875000000022, 0, 8.9999875, 4.999987500000002, 1, 11.9999875),
					Block.box(12.9999875, 2, 4.9999875, 13.9999875, 5, 10.9999875),
					Block.box(2.9999875000000022, 1, 4.9999875, 12.9999875, 2, 10.9999875),
					Block.box(1.9999875000000022, 2, 4.9999875, 2.9999875000000022, 5, 10.9999875),
					Block.box(2.9999875000000022, 2, 10.9999875, 12.9999875, 5, 11.9999875),
					Block.box(2.9999875000000022, 2, 3.9999874999999996, 12.9999875, 5, 4.9999875),
					Block.box(2.9999875000000022, 4, 4.9999875, 12.9999875, 5, 10.9999875))
			.reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream
			.of(Block.box(8.9999875, 0, 1.9999875000000014, 11.9999875, 1, 4.999987500000001),
					Block.box(8.9999875, 0, 10.9999875, 11.9999875, 1, 13.9999875),
					Block.box(3.9999875000000005, 0, 10.9999875, 6.9999875000000005, 1, 13.9999875),
					Block.box(3.9999875000000005, 0, 1.9999875000000014, 6.9999875000000005, 1, 4.999987500000001),
					Block.box(4.9999875000000005, 2, 12.9999875, 10.9999875, 5, 13.9999875),
					Block.box(4.9999875000000005, 1, 2.9999875000000022, 10.9999875, 2, 12.9999875),
					Block.box(4.9999875000000005, 2, 1.9999875000000014, 10.9999875, 5, 2.9999875000000014),
					Block.box(3.9999875000000005, 2, 2.9999875000000022, 4.9999875000000005, 5, 12.9999875),
					Block.box(10.9999875, 2, 2.9999875000000022, 11.9999875, 5, 12.9999875),
					Block.box(4.9999875000000005, 4, 2.9999875000000022, 10.9999875, 5, 12.9999875))
			.reduce((v1, v2) -> {
				return Shapes.join(v1, v2, BooleanOp.OR);
			}).get();

	private static final VoxelShape SHAPE_R = Block.box(-8, 0, -7, 24, 32, 25);

	public BlockBonsaiPlanter(Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public VoxelShape getOcclusionShape(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return SHAPE_R;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		switch (state.getValue(FACING)) {
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
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@SuppressWarnings("deprecation")
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void onNeighborChange(BlockState state, LevelReader world, BlockPos pos, BlockPos neighbor) {
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn,
			BlockHitResult hit) {
		ItemStack stack = player.getMainHandItem();
		Item sapling = stack.getItem();
		if (sapling == BLOCK_TO_ITEM.getOrDefault(Blocks.OAK_SAPLING, Items.AIR)) {
			worldIn.setBlockAndUpdate(pos,
					BlockInit.oak_bonsai_stage_1.get().defaultBlockState().setValue(FACING, state.getValue(FACING)));
			return InteractionResult.SUCCESS;
		}
		if (sapling == BLOCK_TO_ITEM.getOrDefault(Blocks.SPRUCE_SAPLING, Items.AIR)) {
			worldIn.setBlockAndUpdate(pos,
					BlockInit.spruce_bonsai_stage_1.get().defaultBlockState().setValue(FACING, state.getValue(FACING)));
			return InteractionResult.SUCCESS;
		}
		/*
		 * if (sapling == Item.getItemFromBlock(BlockInit.morel_mushroom.get()) ||
		 * sapling == Item.getItemFromBlock(BlockInit.singeri_mushroom.get())) {
		 *
		 * worldIn.setBlockState(pos,
		 * BlockInit.mushroom_bonsai_stage_1.get().getDefaultState().with(FACING,
		 * state.get(FACING))); return InteractionResult.SUCCESS; } if (sapling ==
		 * Item.getItemFromBlock(BlockInit.anti_sapling.get())) {
		 * worldIn.setBlockState(pos,
		 * BlockInit.anti_bonsai_stage_1.get().getDefaultState().with(FACING,
		 * state.get(FACING))); return InteractionResult.SUCCESS; } if (sapling ==
		 * Item.getItemFromBlock(BlockInit.somnolent_sapling.get())) {
		 * worldIn.setBlockState(pos,
		 * BlockInit.somnolent_bonsai_stage_1.get().getDefaultState().with(FACING,
		 * state.get(FACING)));
		 *
		 * return InteractionResult.SUCCESS; }
		 */ else {
			return InteractionResult.PASS;

		}

	}

}
