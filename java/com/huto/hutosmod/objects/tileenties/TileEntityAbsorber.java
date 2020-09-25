package com.huto.hutosmod.objects.tileenties;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationProvider;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.objects.tileenties.util.IExportableTile;
import com.huto.hutosmod.objects.tileenties.util.IImportableTile;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class TileEntityAbsorber extends TileVibeSimpleInventory implements ITickableTileEntity {
	IVibrations vibes = getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);
	public final String TAG_LEVEL = "tankLevel";
	public final String TAG_SIZE = "tankSize";
	public final String TAG_RATE = "transRate";
	public final String TAG_ENUMMODE = "powerEnumMode";
	public final String TAG_CLIENTMODE = "powerEnumMode";

	public final String TAG_BLOCKPOS = "blockPos";
	public final String TAG_LINKEDPOS = "linkedBlockPos";
	public int tankLevel = 0;
	public float maxVibes = 0.0F;
	public float transferRate = 0.0F;
	public EnumAbsorberStates enumMode = EnumAbsorberStates.DEFAULT;
	public List<BlockPos> linkedBlocks = new ArrayList<BlockPos>();
	public final String TAG_VIBES = "vibes";
	public float clientVibes = 0.0f;
	public EnumAbsorberStates clientEnumMode = EnumAbsorberStates.DEFAULT;

	public TileEntityAbsorber() {
		super(TileEntityInit.vibe_absorber.get());
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return super.getRenderBoundingBox().grow(4);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void tick() {

		if (!world.isRemote) {
			world.notifyBlockUpdate(pos, getState(), getState(), 2);
		}

		if (linkedBlocks != null) {
			for (int i = 0; i < linkedBlocks.size(); i++) {
				if (world.getBlockState(linkedBlocks.get(i)).isAir()) {
					linkedBlocks.remove(i);
				}
			}

			// System.out.println(getUpdateTag().get(TAG_LINKEDPOS));
			if (linkedBlocks != null) {
				for (int i = 0; i < linkedBlocks.size(); i++) {
					// System.out.println(vibes.getVibes());
					if (linkedBlocks.get(i) != null) {
						// Importing from Absorber
						if (world.getTileEntity(linkedBlocks.get(i)) instanceof IImportableTile) {
							IImportableTile te = (IImportableTile) world.getTileEntity(linkedBlocks.get(i));
							if (this.isExportState() && te.canImport()) {
								// System.out.println("Should be Exporting");
								te.importFromAbsorber(this, transferRate);
								te.sendUpdates();
								VanillaPacketDispatcher.dispatchTEToNearbyPlayers(this);

							}

						}

						// Exporting to Absorber
						if (world.getTileEntity(linkedBlocks.get(i)) instanceof IExportableTile) {
							IExportableTile te = (IExportableTile) world.getTileEntity(linkedBlocks.get(i));
							if (this.isImportState() && this.vibes.getVibes() <= maxVibes && te.canExport()) {
								// System.out.println("Should be Importing");
								te.exportToAbsorber(this, transferRate);
								te.sendUpdates();
								VanillaPacketDispatcher.dispatchTEToNearbyPlayers(this);

							}
						}
						// Other Absorbers
						/*
						 * if (world.getTileEntity(linkedBlocks.get(i)) instanceof TileEntityAbsorber) {
						 * TileEntityAbsorber other = (TileEntityAbsorber)
						 * world.getTileEntity(linkedBlocks.get(i)); if (this.isImportState() &&
						 * other.isExportState()) { if (this.vibes.getVibes() < other.vibes.getVibes())
						 * this.vibes.addVibes(transferRate); other.vibes.subtractVibes(transferRate); }
						 * if (this.isExportState() && other.isImportState()) { if
						 * (this.vibes.getVibes() > other.vibes.getVibes())
						 * other.vibes.addVibes(transferRate); this.vibes.subtractVibes(transferRate); }
						 * this.sendUpdates(); other.sendUpdates(); }
						 */
					}
				}
			}
		}
	}

	public boolean isImportState() {
		return (this.getEnumMode() == EnumAbsorberStates.IMPORT || this.getEnumMode() == EnumAbsorberStates.BOTH) ? true
				: false;
	}

	public boolean isExportState() {
		return (this.getEnumMode() == EnumAbsorberStates.EXPORT || this.getEnumMode() == EnumAbsorberStates.BOTH) ? true
				: false;
	}

	// Item Stuff
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

	public boolean isVibeFull() {
		return vibes.getVibes() < maxVibes ? false : true;
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
			return this.transferRate = 0.1f;
		} else if (tankLevel > 0 && tankLevel < 4) {
			return this.transferRate = (tankLevel + 1) * 0.1f;
		} else {
			return transferRate;
		}
	}

	public float getTankSize() {
		if (tankLevel == 0) {
			return this.maxVibes = 10;
		} else if (tankLevel > 0 && tankLevel < 4) {
			return this.maxVibes = (tankLevel + 1) * 10;
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
	public boolean shouldRefresh(World world, BlockPos pos, @Nonnull BlockState oldState,
			@Nonnull BlockState newState) {
		return oldState.getBlock() != newState.getBlock();
	}

	@SuppressWarnings("static-access")
	@Override
	public void readPacketNBT(CompoundNBT tag) {
		super.readPacketNBT(tag);
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(tag);
		tankLevel = tag.getInt(TAG_LEVEL);
		maxVibes = tag.getFloat(TAG_SIZE);
		transferRate = tag.getFloat(TAG_RATE);
		enumMode = enumMode.valueOf(tag.getString(TAG_ENUMMODE));
		clientVibes = tag.getFloat(TAG_VIBES);
		clientEnumMode = enumMode.valueOf(tag.getString(TAG_CLIENTMODE));
		ListNBT tagList = tag.getList(TAG_LINKEDPOS, Constants.NBT.TAG_COMPOUND);
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
		tag.merge(itemHandler.serializeNBT());
		tag.putInt(TAG_LEVEL, tankLevel);
		tag.putFloat(TAG_SIZE, maxVibes);
		tag.putFloat(TAG_RATE, transferRate);
		tag.putString(TAG_ENUMMODE, enumMode.toString());
		tag.putFloat(TAG_VIBES, vibes.getVibes());
		tag.putString(TAG_CLIENTMODE, enumMode.toString());
		ListNBT tagList = new ListNBT();
		for (int i = 0; i < linkedBlocks.size(); i++) {
			tagList.add(NBTUtil.writeBlockPos(linkedBlocks.get(i)));
			NBTUtil.writeBlockPos(linkedBlocks.get(i));
		}
		tag.put(TAG_LINKEDPOS, tagList);
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
		nbtTag.merge(itemHandler.serializeNBT());
		nbtTag.putInt(TAG_LEVEL, tankLevel);
		nbtTag.putFloat(TAG_SIZE, maxVibes);
		nbtTag.putFloat(TAG_VIBES, vibes.getVibes());
		nbtTag.putString(TAG_ENUMMODE, enumMode.toString());
		nbtTag.putString(TAG_CLIENTMODE, enumMode.toString());
		return new SUpdateTileEntityPacket(getPos(), -1, nbtTag);
	}

	@SuppressWarnings("static-access")
	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		CompoundNBT tag = pkt.getNbtCompound();
		super.onDataPacket(net, pkt);
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(tag);
		tankLevel = tag.getInt(TAG_LEVEL);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
		enumMode = enumMode.valueOf(tag.getString(TAG_ENUMMODE));
		clientEnumMode = enumMode.valueOf(tag.getString(TAG_CLIENTMODE));

	}

	@SuppressWarnings("static-access")
	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT tag) {
		super.handleUpdateTag(state, tag);
		tankLevel = tag.getInt(TAG_LEVEL);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
		enumMode = enumMode.valueOf(tag.getString(TAG_ENUMMODE));
		clientEnumMode = enumMode.valueOf(tag.getString(TAG_CLIENTMODE));
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

}
