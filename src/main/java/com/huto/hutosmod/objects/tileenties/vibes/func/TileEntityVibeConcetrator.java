package com.huto.hutosmod.objects.tileenties.vibes.func;

import java.util.Set;

import com.google.common.collect.Sets;
import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationProvider;
import com.huto.hutosmod.capabilities.vibes.chunk.ChunkVibrationProvider;
import com.huto.hutosmod.capabilities.vibes.chunk.IChunkVibrations;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.objects.tileenties.util.IImportableTile;
import com.huto.hutosmod.objects.tileenties.vibes.TileModVibes;
import com.huto.hutosmod.objects.tileenties.vibes.gen.TileEntityAbsorber;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class TileEntityVibeConcetrator extends TileModVibes implements ITickableTileEntity, IImportableTile {
	IVibrations vibes = getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);
	public static final String TAG_VIBES = "vibes";
	public final String TAG_SIZE = "tankSize";
	float maxVibes = 250;
	public float clientVibes = 0.0f;

	public TileEntityVibeConcetrator() {
		super(TileEntityInit.vibe_concentrator.get());
	}

	public IVibrations getVibeCap() {
		return vibes;
	}

	public float getMaxVibes() {
		return maxVibes;
	}

	public void setMaxVibes(float maxVibes) {
		this.maxVibes = maxVibes;
	}

	@Override
	public void tick() {
		if (!world.isRemote) {
			IChunkVibrations chunkVibe = world.getChunkAt(getPos())
					.getCapability(ChunkVibrationProvider.CHUNK_ENERGY_CHUNK_CAPABILITY)
					.orElseThrow(NullPointerException::new);
			if (!isVibeFull() && chunkVibe.canExtract()) {
				chunkVibe.extractEnergy(1);
				vibes.addVibes(1);
			}
			if (vibes.getVibes() >= 100) {
				selectRandPos(world);
			}
		}
	}

	@SuppressWarnings("deprecation")
	public BlockPos selectRandPos(World worldIn) {
		Iterable<BlockPos> radiusPositions = BlockPos.getAllInBoxMutable(this.pos.add(5.0f, 2.0f, 5.0f),
				this.pos.add(-5.0f, -2.0f, -5.0f));
		for (BlockPos s : radiusPositions) {
			if (isValidPosition(worldIn.getBlockState(s), worldIn, s)
					&& worldIn.getBlockState(s.add(0, 1, 0)).isAir()) {
				if (worldIn.rand.nextInt(7500) == 0) {
					if (worldIn.rand.nextBoolean()) {
						worldIn.setBlockState(s.add(0, 1, 0), BlockInit.essence_breakout_point.get().getDefaultState());
					} else {
						worldIn.setBlockState(s.add(0, 1, 0), BlockInit.null_breakout_point.get().getDefaultState());

					}
					vibes.subtractVibes(50);
				}
			}
		}

		return pos;
	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos;
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.getBlock() == Blocks.GRASS_BLOCK || blockstate.getBlock() == Blocks.STONE
				|| blockstate.getBlock() == Blocks.DIRT || blockstate.getBlock() == BlockInit.somnolent_earth.get()
				|| blockstate.getBlock() == BlockInit.somnolent_stone.get()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSpotGrowable(World worldIn, BlockPos posIn) {
		if (isValidPosition(worldIn.getBlockState(posIn), worldIn, posIn)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean canGenerate(World worldIn, BlockPos posIn) {
		return vibes.getVibes() > 5 && isSpotGrowable(worldIn, posIn) ? true : false;
	}

	public boolean isVibeFull() {
		return vibes.getVibes() >= maxVibes ? true : false;
	}

	public boolean checkStructure() {
		Set<Block> allowedBlocks = Sets.newHashSet(BlockInit.somnolent_stone.get(),
				BlockInit.somnolent_stone_smooth.get());
		BlockPos adj = getPos().offset(Direction.DOWN);
		BlockState blockState = world.getBlockState(adj);
		Block block = blockState.getBlock();
		return allowedBlocks.contains(block) ? true : false;

	}

	public void sendUpdates() {
		world.markBlockRangeForRenderUpdate(pos, getBlockState(), getBlockState());
		world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 3);
		markDirty();
	}

	// NBT data
	@Override
	public void readPacketNBT(CompoundNBT tag) {
		super.readPacketNBT(tag);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
	}

	@Override
	public void writePacketNBT(CompoundNBT tag) {
		super.writePacketNBT(tag);
		tag.putFloat(TAG_SIZE, maxVibes);
		tag.putFloat(TAG_VIBES, vibes.getVibes());
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		return super.write(compound);
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
	}

	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		super.getUpdatePacket();
		CompoundNBT nbtTag = new CompoundNBT();
		nbtTag.putFloat(TAG_SIZE, maxVibes);
		nbtTag.putFloat(TAG_VIBES, vibes.getVibes());
		return new SUpdateTileEntityPacket(getPos(), -1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		CompoundNBT tag = pkt.getNbtCompound();
		super.onDataPacket(net, pkt);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
	}

	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT tag) {
		super.handleUpdateTag(state, tag);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
	}

	@Override
	public void importFromAbsorber(TileEntityAbsorber importFrom, float rate) {
		this.vibes.addVibes(rate);
		importFrom.vibes.subtractVibes(rate);
	}

	@Override
	public boolean canImport() {
		if (vibes.getVibes() < maxVibes) {
			return true;
		} else {
			return false;
		}
	}

}
