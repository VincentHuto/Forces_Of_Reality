package com.huto.hutosmod.objects.tileenties;

import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationProvider;
import com.huto.hutosmod.init.TileEntityInit;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;

public class TileEntityAbsorber extends TileVibeSimpleInventory implements ITickableTileEntity {
	IVibrations vibes = getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);
	public static final String TAG_LEVEL = "tankLevel";
	public static final String TAG_SIZE = "tankSize";
	public static final String TAG_RATE = "transRate";
	public static final String TAG_MODE = "powerMode";

	public int tankLevel = 0;
	public float maxVibes = 0.0F;
	public float transferRate = 0.0F;
	public int mode = 0;

	public TileEntityAbsorber() {
		super(TileEntityInit.vibe_absorber.get());
	}

	@Override
	public void tick() {
		//System.out.println(this.getMode());
	}

	// Vibe Stuff
	@Override
	public void onLoad() {
		super.onLoad();
		this.getTankSize();
		this.checkTransferRate();
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public void cycleMode() {
		switch (mode) {
		case 0:
			setMode(1);
			break;
		case 1:
			setMode(2);
			break;
		case 2:
			setMode(3);
			break;
		case 3:
			setMode(0);
			break;
		default:
			setMode(0);
			break;

		}
	}

	public float checkTransferRate() {
		if (tankLevel == 0) {
			return this.transferRate = 1.0f;
		} else if (tankLevel > 0 && tankLevel < 4) {
			return this.transferRate = (tankLevel + 1) * 1.0f;
		} else {
			return transferRate;
		}
	}

	public float getTankSize() {
		if (tankLevel == 0) {
			return this.maxVibes = 100;
		} else if (tankLevel > 0 && tankLevel < 4) {
			return this.maxVibes = (tankLevel + 1) * 100;
		} else {
			return maxVibes;
		}
	}

	public boolean isFull() {
		return vibes.getVibes() <= this.getMaxVibes() ? false : true;
	}

	public IVibrations getVibeCap() {
		return vibes;
	}

	public float getMaxVibes() {
		return maxVibes;
	}

	public float getTransferRate() {
		return transferRate;
	}

	public void addTankLevel(float tankValue) {
		this.tankLevel += tankValue;
	}

	public int getTankLevel() {
		return tankLevel;
	}

	public void setTankLevel(int tankLevel) {
		this.tankLevel = tankLevel;
	}

	// NBT data
	@Override
	public void readPacketNBT(CompoundNBT tag) {
		super.readPacketNBT(tag);
		tankLevel = tag.getInt(TAG_LEVEL);
		maxVibes = tag.getFloat(TAG_SIZE);
		transferRate = tag.getFloat(TAG_RATE);
		mode = tag.getInt(TAG_MODE);
	}

	@Override
	public void writePacketNBT(CompoundNBT tag) {
		super.writePacketNBT(tag);
		tag.putInt(TAG_LEVEL, tankLevel);
		tag.putFloat(TAG_SIZE, maxVibes);
		tag.putFloat(TAG_RATE, transferRate);
		tag.putInt(TAG_MODE, mode);

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
	public int getSizeInventory() {
		return 1;
	}

}
