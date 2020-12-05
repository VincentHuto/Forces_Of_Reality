package com.huto.hutosmod.objects.blocks;

import java.util.stream.Stream;

import com.huto.hutosmod.dimension.DimensionInit;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.objects.tileenties.TileEntityTeleporter;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.DimensionType;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ServerWorld;

public class BlockTeleporter extends Block {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(-12, 29, -1, 28, 31, 17),
			Block.makeCuboidShape(-11, 31, 0, 27, 32, 16),
			Block.makeCuboidShape(-1, 0.10000000000000009, 0, 16, 1.1, 15), Block.makeCuboidShape(0, 0, 15, 16, 29, 17),
			Block.makeCuboidShape(-14, 0, -3, 0, 2, 19), Block.makeCuboidShape(-11, 3, 0, -8, 28, 3),
			Block.makeCuboidShape(-3, 3, 0, 0, 28, 3), Block.makeCuboidShape(-9, 3, 3, -3, 28, 13),
			Block.makeCuboidShape(-11, 3, 13, -8, 28, 16), Block.makeCuboidShape(-3, 3, 13, 0, 28, 16),
			Block.makeCuboidShape(16, 3, 13, 19, 28, 16), Block.makeCuboidShape(16, 28, -2, 29, 29, 18),
			Block.makeCuboidShape(16, 2, -2, 29, 3, 18), Block.makeCuboidShape(24, 3, 13, 27, 28, 16),
			Block.makeCuboidShape(16, 0, -3, 30, 2, 19), Block.makeCuboidShape(-13, 28, -2, 0, 29, 18),
			Block.makeCuboidShape(-13, 2, -2, 0, 3, 18), Block.makeCuboidShape(16, 3, 0, 19, 28, 3),
			Block.makeCuboidShape(24, 3, 0, 27, 28, 3), Block.makeCuboidShape(18, 3, 3, 24, 28, 13))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_S = Stream
			.of(Block.makeCuboidShape(-12.149999999999999, 29, -0.25, 27.85, 31, 17.75),
					Block.makeCuboidShape(-11.149999999999999, 31, 0.75, 26.85, 32, 16.75),
					Block.makeCuboidShape(-0.14999999999999947, 0.10000000000000009, 1.75, 16.85, 1.1, 16.75),
					Block.makeCuboidShape(-0.14999999999999947, 0, -0.25, 15.85, 29, 1.75),
					Block.makeCuboidShape(15.85, 0, -2.25, 29.85, 2, 19.75),
					Block.makeCuboidShape(23.85, 3, 13.75, 26.85, 28, 16.75),
					Block.makeCuboidShape(15.85, 3, 13.75, 18.85, 28, 16.75),
					Block.makeCuboidShape(18.85, 3, 3.75, 24.85, 28, 13.75),
					Block.makeCuboidShape(23.85, 3, 0.75, 26.85, 28, 3.75),
					Block.makeCuboidShape(15.85, 3, 0.75, 18.85, 28, 3.75),
					Block.makeCuboidShape(-3.1499999999999995, 3, 0.75, -0.14999999999999947, 28, 3.75),
					Block.makeCuboidShape(-13.149999999999999, 28, -1.25, -0.14999999999999947, 29, 18.75),
					Block.makeCuboidShape(-13.149999999999999, 2, -1.25, -0.14999999999999947, 3, 18.75),
					Block.makeCuboidShape(-11.149999999999999, 3, 0.75, -8.149999999999999, 28, 3.75),
					Block.makeCuboidShape(-14.149999999999999, 0, -2.25, -0.14999999999999947, 2, 19.75),
					Block.makeCuboidShape(15.85, 28, -1.25, 28.85, 29, 18.75),
					Block.makeCuboidShape(15.85, 2, -1.25, 28.85, 3, 18.75),
					Block.makeCuboidShape(-3.1499999999999995, 3, 13.75, -0.14999999999999947, 28, 16.75),
					Block.makeCuboidShape(-11.149999999999999, 3, 13.75, -8.149999999999999, 28, 16.75),
					Block.makeCuboidShape(-8.149999999999999, 3, 3.75, -2.1499999999999995, 28, 13.75))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();
	private static final VoxelShape SHAPE_E = Stream
			.of(Block.makeCuboidShape(-0.7000000000000002, 29, -11.55, 17.3, 31, 28.45),
					Block.makeCuboidShape(0.2999999999999998, 31, -10.55, 16.3, 32, 27.45),
					Block.makeCuboidShape(1.2999999999999998, 0.10000000000000009, -0.5500000000000007, 16.3, 1.1,
							16.45),
					Block.makeCuboidShape(-0.7000000000000002, 0, 0.4500000000000002, 1.2999999999999998, 29, 16.45),
					Block.makeCuboidShape(-2.7, 0, -13.55, 19.3, 2, 0.4500000000000002),
					Block.makeCuboidShape(13.3, 3, -10.55, 16.3, 28, -7.550000000000001),
					Block.makeCuboidShape(13.3, 3, -2.5500000000000007, 16.3, 28, 0.4500000000000002),
					Block.makeCuboidShape(3.3, 3, -8.55, 13.3, 28, -2.5500000000000007),
					Block.makeCuboidShape(0.2999999999999998, 3, -10.55, 3.3, 28, -7.550000000000001),
					Block.makeCuboidShape(0.2999999999999998, 3, -2.5500000000000007, 3.3, 28, 0.4500000000000002),
					Block.makeCuboidShape(0.2999999999999998, 3, 16.45, 3.3, 28, 19.45),
					Block.makeCuboidShape(-1.7000000000000002, 28, 16.45, 18.3, 29, 29.45),
					Block.makeCuboidShape(-1.7000000000000002, 2, 16.45, 18.3, 3, 29.45),
					Block.makeCuboidShape(0.2999999999999998, 3, 24.45, 3.3, 28, 27.45),
					Block.makeCuboidShape(-2.7, 0, 16.45, 19.3, 2, 30.45),
					Block.makeCuboidShape(-1.7000000000000002, 28, -12.55, 18.3, 29, 0.4500000000000002),
					Block.makeCuboidShape(-1.7000000000000002, 2, -12.55, 18.3, 3, 0.4500000000000002),
					Block.makeCuboidShape(13.3, 3, 16.45, 16.3, 28, 19.45),
					Block.makeCuboidShape(13.3, 3, 24.45, 16.3, 28, 27.45),
					Block.makeCuboidShape(3.3, 3, 18.45, 13.3, 28, 24.45))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_W = Stream
			.of(Block.makeCuboidShape(-1.4500000000000002, 29, -11.7, 16.55, 31, 28.3),
					Block.makeCuboidShape(-0.4500000000000002, 31, -10.7, 15.55, 32, 27.3),
					Block.makeCuboidShape(-0.4500000000000002, 0.10000000000000009, 0.3000000000000007, 14.55, 1.1,
							17.3),
					Block.makeCuboidShape(14.55, 0, 0.3000000000000007, 16.55, 29, 16.3),
					Block.makeCuboidShape(-3.45, 0, 16.3, 18.55, 2, 30.3),
					Block.makeCuboidShape(-0.4500000000000002, 3, 24.3, 2.55, 28, 27.3),
					Block.makeCuboidShape(-0.4500000000000002, 3, 16.3, 2.55, 28, 19.3),
					Block.makeCuboidShape(2.55, 3, 19.3, 12.55, 28, 25.3),
					Block.makeCuboidShape(12.55, 3, 24.3, 15.55, 28, 27.3),
					Block.makeCuboidShape(12.55, 3, 16.3, 15.55, 28, 19.3),
					Block.makeCuboidShape(12.55, 3, -2.6999999999999993, 15.55, 28, 0.3000000000000007),
					Block.makeCuboidShape(-2.45, 28, -12.7, 17.55, 29, 0.3000000000000007),
					Block.makeCuboidShape(-2.45, 2, -12.7, 17.55, 3, 0.3000000000000007),
					Block.makeCuboidShape(12.55, 3, -10.7, 15.55, 28, -7.699999999999999),
					Block.makeCuboidShape(-3.45, 0, -13.7, 18.55, 2, 0.3000000000000007),
					Block.makeCuboidShape(-2.45, 28, 16.3, 17.55, 29, 29.3),
					Block.makeCuboidShape(-2.45, 2, 16.3, 17.55, 3, 29.3),
					Block.makeCuboidShape(-0.4500000000000002, 3, -2.6999999999999993, 2.55, 28, 0.3000000000000007),
					Block.makeCuboidShape(-0.4500000000000002, 3, -10.7, 2.55, 28, -7.699999999999999),
					Block.makeCuboidShape(2.55, 3, -7.699999999999999, 12.55, 28, -1.6999999999999993))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_R = Block.makeCuboidShape(-8, 0, -7, 24, 32, 25);

	public BlockTeleporter(Properties properties) {
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
			return SHAPE_S;
		case SOUTH:
			return SHAPE_N;
		case EAST:
			return SHAPE_W;
		case WEST:
			return SHAPE_E;
		default:
			return SHAPE_N;
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
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player,
			Hand hand, BlockRayTraceResult result) {
		if (player instanceof ServerPlayerEntity) {
			transferPlayer((ServerPlayerEntity) player, pos);
		}
		return ActionResultType.SUCCESS;
	}

	public boolean transferPlayer(ServerPlayerEntity playerMP, BlockPos pos) {
		if (playerMP.getRidingEntity() != null || playerMP.isBeingRidden()) {
			return false;
		}

		if (playerMP.world.getDimensionKey().equals(DimensionInit.dreamlands)) {

			ServerWorld teleportWorld = playerMP.server
					.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, DimensionType.OVERWORLD_ID));

			if (teleportWorld == null) {
				return false;
			}

			Chunk chunk = (Chunk) teleportWorld.getChunk(pos);
			BlockPos teleporterPos = findPortalInChunk(chunk);

			if (teleporterPos == null) {
				teleporterPos = placeTeleporterOverworld(teleportWorld, chunk);
			}
			if (teleporterPos == null) {
				return true;
			}

			playerMP.addExperienceLevel(0);
			playerMP.teleport(teleportWorld, teleporterPos.getX() + 0.5D, teleporterPos.getY() + 1D,
					teleporterPos.getZ() + 0.5D, playerMP.rotationYaw, playerMP.rotationPitch);
		} else if (playerMP.world.getDimensionKey()
				.equals(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, DimensionType.OVERWORLD_ID))) {
			ServerWorld teleportWorld = playerMP.server.getWorld(DimensionInit.dreamlands);

			if (teleportWorld == null) {
				return false;
			}

			Chunk chunk = (Chunk) teleportWorld.getChunk(pos);
			BlockPos teleporterPos = findPortalInChunk(chunk);

			if (teleporterPos == null) {
				teleporterPos = placeTeleporterMining(teleportWorld, chunk);
			}
			if (teleporterPos == null) {
				return true;
			}
			playerMP.addExperienceLevel(0);
			playerMP.teleport(teleportWorld, teleporterPos.getX() + 0.5D, teleporterPos.getY() + 1D,
					teleporterPos.getZ() + 0.5D, playerMP.rotationYaw, playerMP.rotationPitch);
		} else {
			playerMP.sendStatusMessage(new TranslationTextComponent("message.wrong_dimension"), true);
		}

		return true;
	}

	@SuppressWarnings("deprecation")
	private BlockPos findPortalInChunk(Chunk chunk) {
		for (TileEntity tile : chunk.getTileEntityMap().values()) {
			if (tile instanceof TileEntityTeleporter) {
				BlockPos pos = tile.getPos();
				if (chunk.getBlockState(pos.up()).isAir()) {
					return pos;
				}
			}
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	private BlockPos placeTeleporterMining(ServerWorld world, Chunk chunk) {
		BlockPos.Mutable pos = new BlockPos.Mutable();
		for (int y = 0; y < 255; y++) {
			for (int x = 0; x < 16; x++) {
				for (int z = 0; z < 16; z++) {
					pos.setPos(x, y, z);
					if (chunk.getBlockState(pos).isAir() && chunk.getBlockState(pos.up(1)).isAir()
							&& chunk.getBlockState(pos.up(2)).isAir()) {
						BlockPos absolutePos = chunk.getPos().asBlockPos().add(pos.getX(), pos.getY(), pos.getZ());
						world.setBlockState(absolutePos, BlockInit.teleporter.get().getDefaultState());
						return absolutePos;
					}
				}
			}
		}

		for (int y = 0; y < 255; y++) {
			for (int x = 0; x < 16; x++) {
				for (int z = 0; z < 16; z++) {
					pos.setPos(x, y, z);
					if (isAirOrStone(chunk, pos) && isAirOrStone(chunk, pos.up(1)) && isAirOrStone(chunk, pos.up(2))) {
						BlockPos absolutePos = chunk.getPos().asBlockPos().add(pos.getX(), pos.getY(), pos.getZ());
						if (isReplaceable(world, absolutePos.up(3))
								&& isReplaceable(world, absolutePos.up(1).offset(Direction.NORTH))
								&& isReplaceable(world, absolutePos.up(1).offset(Direction.NORTH))
								&& isReplaceable(world, absolutePos.up(1).offset(Direction.SOUTH))
								&& isReplaceable(world, absolutePos.up(1).offset(Direction.EAST))
								&& isReplaceable(world, absolutePos.up(1).offset(Direction.WEST))
								&& isReplaceable(world, absolutePos.up(2).offset(Direction.NORTH))
								&& isReplaceable(world, absolutePos.up(2).offset(Direction.SOUTH))
								&& isReplaceable(world, absolutePos.up(2).offset(Direction.EAST))
								&& isReplaceable(world, absolutePos.up(2).offset(Direction.WEST))) {
							world.setBlockState(absolutePos, BlockInit.teleporter.get().getDefaultState());
							world.setBlockState(absolutePos.up(1), Blocks.AIR.getDefaultState());
							world.setBlockState(absolutePos.up(2), Blocks.AIR.getDefaultState());
							world.setBlockState(absolutePos.up(3), Blocks.STONE.getDefaultState());
							world.setBlockState(absolutePos.up(1).offset(Direction.NORTH),
									Blocks.STONE.getDefaultState());
							world.setBlockState(absolutePos.up(1).offset(Direction.SOUTH),
									Blocks.STONE.getDefaultState());
							world.setBlockState(absolutePos.up(1).offset(Direction.EAST),
									Blocks.STONE.getDefaultState());
							world.setBlockState(absolutePos.up(1).offset(Direction.WEST),
									Blocks.STONE.getDefaultState());
							world.setBlockState(absolutePos.up(2).offset(Direction.NORTH),
									Blocks.STONE.getDefaultState());
							world.setBlockState(absolutePos.up(2).offset(Direction.SOUTH),
									Blocks.STONE.getDefaultState());
							world.setBlockState(absolutePos.up(2).offset(Direction.EAST),
									Blocks.STONE.getDefaultState());
							world.setBlockState(absolutePos.up(2).offset(Direction.WEST),
									Blocks.STONE.getDefaultState());
							return absolutePos;
						}
					}
				}
			}
		}

		return null;
	}

	@SuppressWarnings("deprecation")
	private boolean isAirOrStone(Chunk chunk, BlockPos pos) {
		BlockState state = chunk.getBlockState(pos);
		return state.getBlock().equals(Blocks.STONE) || state.isAir();
	}

	@SuppressWarnings("deprecation")
	private boolean isReplaceable(World world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		return state.getBlock().equals(Blocks.STONE) || state.getBlock().equals(Blocks.GRANITE)
				|| state.getBlock().equals(Blocks.ANDESITE) || state.getBlock().equals(Blocks.DIORITE)
				|| state.getBlock().equals(Blocks.DIRT) || state.getBlock().equals(Blocks.GRAVEL)
				|| state.getBlock().equals(Blocks.LAVA) || state.isAir();
	}

	@SuppressWarnings("deprecation")
	private BlockPos placeTeleporterOverworld(ServerWorld world, Chunk chunk) {
		BlockPos.Mutable pos = new BlockPos.Mutable();
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				for (int y = 63; y < 255; y++) {
					pos.setPos(x, y, z);
					if (chunk.getBlockState(pos).isAir() && chunk.getBlockState(pos.up(1)).isAir()) {
						BlockPos absolutePos = chunk.getPos().asBlockPos().add(pos.getX(), pos.getY(), pos.getZ());
						world.setBlockState(absolutePos, BlockInit.teleporter.get().getDefaultState());
						return absolutePos;
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityTeleporter();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		super.onEntityCollision(state, worldIn, pos, entityIn);
		if (entityIn instanceof ServerPlayerEntity) {
			//transferPlayer((ServerPlayerEntity) entityIn, pos);
		}
	}

}