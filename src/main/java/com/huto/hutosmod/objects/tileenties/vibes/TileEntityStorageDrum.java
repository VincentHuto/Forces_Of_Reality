package com.huto.hutosmod.objects.tileenties.vibes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.objects.tileenties.util.ITank;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Hand;

public class TileEntityStorageDrum extends TileVibeSimpleInventory implements ITickableTileEntity, ITank {
	public final String TAG_LEVEL = "tankLevel";
	public final String TAG_SIZE = "tankSize";
	public int tankLevel = 0;
	public float maxVibes = 0.0F;
	public float clientVibes = 0.0f;

	public TileEntityStorageDrum() {
		super(TileEntityInit.vibratory_storage_drum.get());
	}

	@Override
	public void tick() {
	}

	// Vibe Stuff
	@Override
	public void onLoad() {
		super.onLoad();
		this.getTankSize();
	}

	public float getTankSize() {
		if (tankLevel == 0) {
			return this.maxVibes = 100;
		} else if (tankLevel > 0 && tankLevel <= 9) {
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
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(tag);
		tankLevel = tag.getInt(TAG_LEVEL);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
	}

	@Override
	public void writePacketNBT(CompoundNBT tag) {
		super.writePacketNBT(tag);
		tag.merge(itemHandler.serializeNBT());
		tag.putInt(TAG_LEVEL, tankLevel);
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
		nbtTag.merge(itemHandler.serializeNBT());
		nbtTag.putInt(TAG_LEVEL, tankLevel);
		nbtTag.putFloat(TAG_SIZE, maxVibes);
		nbtTag.putFloat(TAG_VIBES, vibes.getVibes());
		return new SUpdateTileEntityPacket(getPos(), -1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		CompoundNBT tag = pkt.getNbtCompound();
		super.onDataPacket(net, pkt);
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(tag);
		tankLevel = tag.getInt(TAG_LEVEL);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
	}

	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT tag) {
		super.handleUpdateTag(state, tag);
		tankLevel = tag.getInt(TAG_LEVEL);
		maxVibes = tag.getFloat(TAG_SIZE);
		clientVibes = tag.getFloat(TAG_VIBES);
	}

	@Override
	public boolean addItem(@Nullable PlayerEntity player, ItemStack stack, @Nullable Hand hand) {
		if (stack.getItem() == ItemInit.maker_activator.get())
			return false;

		boolean did = false;

		for (int i = 0; i < getSizeInventory(); i++)
			if (itemHandler.getStackInSlot(i).isEmpty()) {
				did = true;
				ItemStack stackToAdd = stack.copy();
				stackToAdd.setCount(1);
				itemHandler.setStackInSlot(i, stackToAdd);
				if (player == null || !player.abilities.isCreativeMode) {
					stack.shrink(1);
					world.notifyBlockUpdate(pos, getState(), getState(), 2);
					world.notifyBlockUpdate(pos, getState(), getState(), 3);

				}
				break;
			}

		if (did)
		world.notifyBlockUpdate(pos, getState(), getState(), 2);
		VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, pos);
		return true;
	}

	@Override
	public int getSizeInventory() {
		return 4;
	}

	@Override
	protected SimpleItemStackHandler createItemHandler() {
		return new SimpleItemStackHandler(this, false) {
			@Override
			protected int getStackLimit(int slot, @Nonnull ItemStack stack) {
				return 1;
			}
		};
	}

	@Override
	public boolean canImport() {
		for (int i = 0; i < getSizeInventory(); i++) {
			if (itemHandler.getStackInSlot(i).getItem() == ItemInit.upgrade_import.get()
					&& vibes.getVibes() < maxVibes) {
				return true;
			}
		}
		return false;

	}

	public boolean canExport() {
		for (int i = 0; i < getSizeInventory(); i++) {
			if (itemHandler.getStackInSlot(i).getItem() == ItemInit.upgrade_export.get() && vibes.getVibes() > 10) {
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty() {
		for (int i = 0; i < getSizeInventory(); i++) {
			if (!itemHandler.getStackInSlot(i).isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void sendUpdates() {
		world.markBlockRangeForRenderUpdate(pos, getState(), getState());
		world.notifyBlockUpdate(pos, getState(), getState(), 2);
		markDirty();
	}

	public boolean isVibeFull() {
		return vibes.getVibes() < maxVibes ? false : true;
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

}
