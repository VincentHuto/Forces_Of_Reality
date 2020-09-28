package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationProvider;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.objects.tileenties.util.IExportableTile;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

public class TileEntityThermalInfluxer extends TileModVibes implements ITickableTileEntity, IExportableTile {

	IVibrations vibes = getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);
	public static final String TAG_VIBES = "vibes";
	public final String TAG_SIZE = "tankSize";
	float maxVibes = 150;
	public float clientVibes = 0.0f;

	public TileEntityThermalInfluxer() {
		super(TileEntityInit.thermal_influxer.get());
	}

	@Override
	public void tick() {
		if (!world.isRemote) {
			world.notifyBlockUpdate(pos, getBlockState(), getBlockState(), 2);
		}
		if (canGenerate()) {
			vibes.addVibes(0.4f);
		}
	}

	public boolean checkStructure() {
		BlockPos adj = getPos().offset(Direction.DOWN);
		BlockState blockState = world.getBlockState(adj);
		Block block = blockState.getBlock();
		if (block == Blocks.LAVA) {
			return true;
		} else {
			return false;
		}

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

	public boolean isVibeFull() {

		return vibes.getVibes() <= maxVibes - 1.10 ? true : false;
	}

	public boolean canGenerate() {
		return checkStructure() && isVibeFull() ? true : false;
	}

	@Override
	public boolean canExport() {
		if (this.vibes.getVibes() > 1.10f) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public void exportToAbsorber(TileEntityAbsorber exportToIn, float rateIn) {
		if (!this.isVibeFull() && vibes.getVibes() > rateIn) {
			this.vibes.subtractVibes(rateIn);
			exportToIn.vibes.addVibes(rateIn);
		}
	}

	@Override
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
}
