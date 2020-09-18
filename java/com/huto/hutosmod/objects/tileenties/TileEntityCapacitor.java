package com.huto.hutosmod.objects.tileenties;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationProvider;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.init.TileEntityInit;
import com.huto.hutosmod.objects.tileenties.util.VanillaPacketDispatcher;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Hand;

public class TileEntityCapacitor extends TileVibeSimpleInventory implements ITickableTileEntity {
	
	IVibrations vibes = getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(IllegalStateException::new);
	public static final String TAG_LEVEL = "tankLevel";
	public static final String TAG_SIZE = "tankSize";
	public int tankLevel = 0;
	float maxVibes = 0.0F;

	public TileEntityCapacitor() {
		super(TileEntityInit.vibratory_capacitor.get());
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
	}

	@Override
	public void writePacketNBT(CompoundNBT tag) {
		super.writePacketNBT(tag);
		tag.putInt(TAG_LEVEL, tankLevel);
		tag.putFloat(TAG_SIZE, maxVibes);

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
				}
				break;
			}

		if (did)
			System.out.println("add ITEM");
		VanillaPacketDispatcher.dispatchTEToNearbyPlayers(world, pos);
		return true;
	}

	@Override
	public int getSizeInventory() {
		return 2;
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

	public boolean isEmpty() {
		for (int i = 0; i < getSizeInventory(); i++)
			if (!itemHandler.getStackInSlot(i).isEmpty())
				return false;

		return true;
	}

}
