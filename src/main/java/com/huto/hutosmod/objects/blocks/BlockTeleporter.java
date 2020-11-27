package com.huto.hutosmod.objects.blocks;

import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.huto.hutosmod.dimension.DimensionInit;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.objects.tileenties.TileEntityTeleporter;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
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
	private static final VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(-11, 31, 0, 27, 32, 16),
			Block.makeCuboidShape(-12, 29, -1, 28, 31, 17), Block.makeCuboidShape(-1, 0.1, 0, 16, 0.1, 15),
			Block.makeCuboidShape(16, 3, 13, 19, 28, 16), Block.makeCuboidShape(16, 28, -2, 29, 29, 18),
			Block.makeCuboidShape(16, 2, -2, 29, 3, 18), Block.makeCuboidShape(24, 3, 13, 27, 28, 16),
			Block.makeCuboidShape(16, 0, -3, 30, 2, 19), Block.makeCuboidShape(-13, 28, -2, 0, 29, 18),
			Block.makeCuboidShape(-13, 2, -2, 0, 3, 18), Block.makeCuboidShape(16, 3, 0, 19, 28, 3),
			Block.makeCuboidShape(24, 3, 0, 27, 28, 3), Block.makeCuboidShape(18, 3, 3, 24, 28, 13),
			Block.makeCuboidShape(-14, 0, -3, 0, 2, 19), Block.makeCuboidShape(-11, 3, 0, -8, 28, 3),
			Block.makeCuboidShape(-3, 3, 0, 0, 28, 3), Block.makeCuboidShape(-9, 3, 3, -3, 28, 13),
			Block.makeCuboidShape(-11, 3, 13, -8, 28, 16), Block.makeCuboidShape(-3, 3, 13, 0, 28, 16))
			.reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	private static final VoxelShape SHAPE_E = Stream
			.of(Block.makeCuboidShape(-0.42499999999999627, 31, -10.724999999999996, 15.575, 32, 27.275),
					Block.makeCuboidShape(-1.4249999999999963, 29, -11.724999999999996, 16.575, 31, 28.275),
					Block.makeCuboidShape(-0.42499999999999627, 0.1, 0.27500000000000213, 14.575, 0.1, 17.275),
					Block.makeCuboidShape(12.575, 3, -2.724999999999998, 15.575, 28, 0.27500000000000213),
					Block.makeCuboidShape(-2.4249999999999963, 28, -12.724999999999996, 17.575, 29,
							0.27500000000000213),
					Block.makeCuboidShape(-2.4249999999999963, 2, -12.724999999999996, 17.575, 3, 0.27500000000000213),
					Block.makeCuboidShape(12.575, 3, -10.724999999999996, 15.575, 28, -7.724999999999996),
					Block.makeCuboidShape(-3.4249999999999963, 0, -13.724999999999996, 18.575, 2, 0.27500000000000213),
					Block.makeCuboidShape(-2.4249999999999963, 28, 16.275, 17.575, 29, 29.275),
					Block.makeCuboidShape(-2.4249999999999963, 2, 16.275, 17.575, 3, 29.275),
					Block.makeCuboidShape(-0.42499999999999627, 3, -2.724999999999998, 2.575, 28, 0.27500000000000213),
					Block.makeCuboidShape(-0.42499999999999627, 3, -10.724999999999996, 2.575, 28, -7.724999999999996),
					Block.makeCuboidShape(2.575, 3, -7.724999999999996, 12.575, 28, -1.7249999999999979),
					Block.makeCuboidShape(-3.4249999999999963, 0, 16.275, 18.575, 2, 30.275),
					Block.makeCuboidShape(-0.42499999999999627, 3, 24.275, 2.575, 28, 27.275),
					Block.makeCuboidShape(-0.42499999999999627, 3, 16.275, 2.575, 28, 19.275),
					Block.makeCuboidShape(2.575, 3, 19.275, 12.575, 28, 25.275),
					Block.makeCuboidShape(12.575, 3, 24.275, 15.575, 28, 27.275),
					Block.makeCuboidShape(12.575, 3, 16.275, 15.575, 28, 19.275))
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
	public BlockRenderType getRenderType(BlockState p_149645_1_) {
		return BlockRenderType.MODEL;
	}

	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityTeleporter();
	}

}