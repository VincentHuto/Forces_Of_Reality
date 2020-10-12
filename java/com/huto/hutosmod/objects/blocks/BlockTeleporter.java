package com.huto.hutosmod.objects.blocks;

import javax.annotation.Nullable;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.dimension.DimensionInit;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.objects.tileenties.TileEntityTeleporter;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ServerWorld;

public class BlockTeleporter extends Block {
	public BlockTeleporter(Properties properties) {
		super(properties);
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
			ServerWorld teleportWorld = playerMP.server.getWorld(HutosMod.SERVER_CONFIG.overworldDimension);

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
		} else if (playerMP.world.getDimensionKey().equals(HutosMod.SERVER_CONFIG.overworldDimension)) {
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

	private boolean isAirOrStone(Chunk chunk, BlockPos pos) {
		BlockState state = chunk.getBlockState(pos);
		return state.getBlock().equals(Blocks.STONE) || state.isAir();
	}

	private boolean isReplaceable(World world, BlockPos pos) {
		BlockState state = world.getBlockState(pos);
		return state.getBlock().equals(Blocks.STONE) || state.getBlock().equals(Blocks.GRANITE)
				|| state.getBlock().equals(Blocks.ANDESITE) || state.getBlock().equals(Blocks.DIORITE)
				|| state.getBlock().equals(Blocks.DIRT) || state.getBlock().equals(Blocks.GRAVEL)
				|| state.getBlock().equals(Blocks.LAVA) || state.isAir();
	}

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