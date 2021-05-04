package com.huto.forcesofreality.objects.tileenties.vibes.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.SetMultimap;
import com.huto.forcesofreality.capabilities.vibes.IVibrations;
import com.huto.forcesofreality.capabilities.vibes.VibrationProvider;
import com.huto.forcesofreality.init.TileEntityInit;
import com.huto.forcesofreality.objects.tileenties.util.EnumAbsorberStates;
import com.huto.forcesofreality.objects.tileenties.util.IExportableTile;
import com.huto.forcesofreality.objects.tileenties.util.IImportableTile;
import com.huto.forcesofreality.objects.tileenties.util.ITank;
import com.huto.forcesofreality.objects.tileenties.vibes.TileVibeSimpleInventory;
import com.hutoslib.common.VanillaPacketDispatcher;

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

public class TileEntityAbsorber extends TileVibeSimpleInventory implements ITickableTileEntity, ITank {
	public IVibrations vibes = getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);
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
	public List<BlockPos> clientLinkedBlocks = new ArrayList<BlockPos>();
	public final String TAG_VIBES = "vibes";
	public float clientVibes = 0.0f;
	public EnumAbsorberStates clientEnumMode = EnumAbsorberStates.DEFAULT;
	public SetMultimap<BlockPos, BlockPos> lasers;

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
		if (linkedBlocks != null) {
			for (int i = 0; i < linkedBlocks.size(); i++) {
				if (world.getBlockState(linkedBlocks.get(i)).isAir()) {
					linkedBlocks.remove(i);
				}
			}

			if (linkedBlocks != null) {
				for (int i = 0; i < linkedBlocks.size(); i++) {
					if (linkedBlocks.get(i) != null) {
						// Importing from Absorber
						if (world.getTileEntity(linkedBlocks.get(i)) instanceof IImportableTile) {
							IImportableTile te = (IImportableTile) world.getTileEntity(linkedBlocks.get(i));
							if (this.isExportState() && this.vibes.getVibes() > transferRate && te.canImport()) {
								te.importFromAbsorber(this, transferRate);
								te.sendUpdates();
								VanillaPacketDispatcher.dispatchTEToNearbyPlayers(this);

							}

						}

						// Exporting to Absorber
						if (world.getTileEntity(linkedBlocks.get(i)) instanceof IExportableTile) {
							IExportableTile te = (IExportableTile) world.getTileEntity(linkedBlocks.get(i));
							if (this.isImportState() && this.vibes.getVibes() <= maxVibes && te.canExport()) {
								te.exportToAbsorber(this, transferRate);
								te.sendUpdates();
								VanillaPacketDispatcher.dispatchTEToNearbyPlayers(this);

							}
						}

						// Tanks
						if (world.getTileEntity(linkedBlocks.get(i)) instanceof ITank) {
							ITank te = (ITank) world.getTileEntity(linkedBlocks.get(i));
							if (this.isExportState() && this.vibes.getVibes() > transferRate && te.canImport()) {
								te.importFromAbsorber(this, transferRate);
								te.sendUpdates();
								VanillaPacketDispatcher.dispatchTEToNearbyPlayers(this);

							}
							if (this.isImportState() && this.vibes.getVibes() <= maxVibes && te.canExport()) {
								// Limit how much it can export when importing so that it will fill with
								// priority
								te.exportToAbsorber(this, transferRate * 0.5f);
								te.sendUpdates();
								VanillaPacketDispatcher.dispatchTEToNearbyPlayers(this);
							}
						}
					}
				}
			}
		}
		lasers.clear();
		List<BlockPos> connectedNodes = getLinkedBlocks();
		for (BlockPos targetpos : connectedNodes) {
			if (canAdd(getPos(), targetpos)) {
				getLasers().put(getPos(), targetpos);
				sendUpdates();

			}
		}
	}

	public static boolean canAdd(BlockPos sourcePos, BlockPos targetPos) {
		SetMultimap<BlockPos, BlockPos> lasers = HashMultimap.create();
		if (!lasers.containsKey(targetPos))
			return true;
		Set<BlockPos> tempSet = lasers.get(targetPos);
		if (!tempSet.contains(sourcePos))
			return true;
		return false;
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
		this.checkTankSize();
		this.checkTransferRate();
		setLasers(HashMultimap.create());

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

	// Transfer
	public float checkTransferRate() {
		if (tankLevel == 0) {
			return this.transferRate = 0.1f;
		} else if (tankLevel > 0 && tankLevel < 4) {
			return this.transferRate = (tankLevel + 1) * 0.1f;
		} else {
			return transferRate;
		}
	}

	// Size
	public float checkTankSize() {
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
		ListNBT tagList = new ListNBT();
		for (int i = 0; i < linkedBlocks.size(); i++) {
			tagList.add(NBTUtil.writeBlockPos(linkedBlocks.get(i)));
			NBTUtil.writeBlockPos(linkedBlocks.get(i));
		}
		nbtTag.put(TAG_LINKEDPOS, tagList);
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
		ListNBT tagList = pkt.getNbtCompound().getList(TAG_LINKEDPOS, Constants.NBT.TAG_COMPOUND);
		List<BlockPos> newLinkedList = new ArrayList<BlockPos>();
		for (int i = 0; i < tagList.size(); i++) {
			newLinkedList.add(NBTUtil.readBlockPos((CompoundNBT) tagList.get(i)));
		}
		this.linkedBlocks = newLinkedList;
		clientLinkedBlocks = newLinkedList;
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
		if (tag.get(TAG_LINKEDPOS) != null) {
			for (int i = 0; i < linkedBlocks.size(); i++) {
				clientLinkedBlocks.add(linkedBlocks.get(i));
			}
		}
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public void importFromAbsorber(TileEntityAbsorber importFrom, float rate) {
		if (!this.isVibeFull()) {
			this.vibes.addVibes(rate);
			importFrom.vibes.subtractVibes(rate);
		}
	}

	@Override
	public void exportToAbsorber(TileEntityAbsorber exportToIn, float rateIn) {
		if (vibes.getVibes() > rateIn) {
			this.vibes.subtractVibes(rateIn);
			exportToIn.vibes.addVibes(rateIn);
		}
	}

	@Override
	public void sendUpdates() {
		world.markBlockRangeForRenderUpdate(pos, getState(), getState());
		world.notifyBlockUpdate(pos, getState(), getState(), 3);
		markDirty();
	}

	@Override
	public boolean canImport() {
		if (vibes.getVibes() < maxVibes) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canExport() {
		if (vibes.getVibes() > 1) {
			return true;
		}
		return false;
	}

	public SetMultimap<BlockPos, BlockPos> getLasers() {
		return lasers;
	}

	public void setLasers(SetMultimap<BlockPos, BlockPos> lasers) {
		this.lasers = lasers;
	}
}
