package com.huto.hutosmod.objects.tileenties;

import java.util.ArrayList;
import java.util.List;

import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationProvider;
import com.huto.hutosmod.init.TileEntityInit;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants;

public class TileEntityAbsorber extends TileVibeSimpleInventory implements ITickableTileEntity {
	IVibrations vibes = getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);
	public static final String TAG_LEVEL = "tankLevel";
	public static final String TAG_SIZE = "tankSize";
	public static final String TAG_RATE = "transRate";
	public static final String TAG_ENUMMODE = "powerEnumMode";
	public static final String TAG_BLOCKPOS = "blockPos";
	public static final String TAG_LINKEDPOS = "linkedBlockPos";
	public int tankLevel = 0;
	public float maxVibes = 0.0F;
	public float transferRate = 0.0F;
	public EnumAbsorberStates enumMode = EnumAbsorberStates.DEFAULT;
	public List<BlockPos> linkedBlocks = new ArrayList<BlockPos>();

	public TileEntityAbsorber() {
		super(TileEntityInit.vibe_absorber.get());
	}

	@Override
	public void tick() {
	//	System.out.println(getUpdateTag().get(TAG_LINKEDPOS));
		if (linkedBlocks != null) {
			for (int i = 0; i < linkedBlocks.size(); i++) {
				// System.out.println(world.getBlockState(linkedBlocks.get(i)).getBlock());
				// System.out.println(world.getTileEntity(linkedBlocks.get(i)) instanceof
				// TileEntityStorageDrum);
				if (world.getTileEntity(linkedBlocks.get(i)) instanceof TileEntityStorageDrum) {
					TileEntityStorageDrum te = (TileEntityStorageDrum) world.getTileEntity(linkedBlocks.get(i));
					te.vibes.addVibes(0.2f);

				}else if(world.getTileEntity(linkedBlocks.get(i)) instanceof TileEntityCapacitor) {
					TileEntityCapacitor te = (TileEntityCapacitor) world.getTileEntity(linkedBlocks.get(i));
					te.vibes.addVibes(0.05f);
				}
			}
		}

	}

	// Vibe Stuff
	@Override
	public void onLoad() {
		super.onLoad();
		this.getTankSize();
		this.checkTransferRate();
	}

	public List<BlockPos> getLinkedBlocks() {
		return linkedBlocks;
	}

	public void setLinkedBlocks(List<BlockPos> linkedBlocks) {
		this.linkedBlocks = linkedBlocks;
	}

	public void addToLinkedBlocks(BlockPos linkedBlocksIn) {
		if (!(linkedBlocks.contains(linkedBlocksIn))) {
			this.linkedBlocks.add(linkedBlocksIn);
			this.markDirty();
		}
	}

	public void clearLinkedBlocks() {
		if (linkedBlocks != null) {
			for (int i = 0; i < linkedBlocks.size(); i++) {
				this.linkedBlocks.remove(i);
				this.markDirty();
			}
		}
	}

	public void removeFromLinkedBlocks(BlockPos linkedBlocksIn) {
		if (linkedBlocks.contains(linkedBlocksIn)) {
			this.linkedBlocks.remove(linkedBlocksIn);
			this.markDirty();
		}
	}

	// Modes
	public void cycleEnumMode() {
		switch (enumMode) {
		case DEFAULT:
			setEnumMode(EnumAbsorberStates.IMPORT);
			break;
		case IMPORT:
			setEnumMode(EnumAbsorberStates.EXPORT);
			break;
		case EXPORT:
			setEnumMode(EnumAbsorberStates.BOTH);
			break;
		case BOTH:
			setEnumMode(EnumAbsorberStates.DEFAULT);
			break;
		default:
			setEnumMode(EnumAbsorberStates.DEFAULT);
			break;

		}
	}

	private void setEnumMode(EnumAbsorberStates enumModeIn) {
		this.enumMode = enumModeIn;

	}

	public EnumAbsorberStates getEnumMode() {
		return enumMode;
	}

	// Transfer/Size
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
	@SuppressWarnings("static-access")
	@Override
	public void readPacketNBT(CompoundNBT tag) {
		super.readPacketNBT(tag);
		tankLevel = tag.getInt(TAG_LEVEL);
		maxVibes = tag.getFloat(TAG_SIZE);
		transferRate = tag.getFloat(TAG_RATE);
		enumMode = enumMode.valueOf(tag.getString(TAG_ENUMMODE));
		ListNBT tagList = tag.getList(TAG_LINKEDPOS, Constants.NBT.TAG_COMPOUND);
		tagList.clear();
		if (linkedBlocks != null || tagList != null) {
			for (int i = 0; i < tagList.size(); i++) {
				if (!(linkedBlocks.contains(NBTUtil.readBlockPos(tagList.getCompound(i))))) {
					linkedBlocks.add(NBTUtil.readBlockPos(tagList.getCompound(i)));
				}
			}
		}
	}

	@Override
	public void writePacketNBT(CompoundNBT tag) {
		super.writePacketNBT(tag);
		tag.putInt(TAG_LEVEL, tankLevel);
		tag.putFloat(TAG_SIZE, maxVibes);
		tag.putFloat(TAG_RATE, transferRate);
		tag.putString(TAG_ENUMMODE, enumMode.toString());
		ListNBT tagList = new ListNBT();
		for (int i = 0; i < linkedBlocks.size(); i++) {
			tagList.add(NBTUtil.writeBlockPos(linkedBlocks.get(i)));
			NBTUtil.writeBlockPos(linkedBlocks.get(i));
		}
		tag.put(TAG_LINKEDPOS, tagList);
	}

	@Override
	public CompoundNBT write(CompoundNBT tag) {
		super.write(tag);
		return tag;
	}

	@Override
	public void read(BlockState state, CompoundNBT tag) {
		super.read(state, tag);
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

}
