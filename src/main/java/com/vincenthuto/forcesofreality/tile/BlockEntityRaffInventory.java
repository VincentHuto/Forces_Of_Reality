
package com.vincenthuto.forcesofreality.tile;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.vincenthuto.hutoslib.common.block.entity.TileMod;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public abstract class BlockEntityRaffInventory extends TileMod {

	/*
	 * Extension of ItemStackHandler that uses our own slot array, allows for
	 * control of writing, allows control over stack limits, and allows for
	 * itemstack-slot validation
	 */
	public static class SimpleItemStackHandler extends ItemStackHandler {

		private final boolean allowWrite;
		private final BlockEntityRaffInventory tile;

		public SimpleItemStackHandler(BlockEntityRaffInventory inv, boolean allowWrite) {
			super(inv.getSizeInventory());
			this.allowWrite = allowWrite;
			tile = inv;
		}

		@Nonnull
		@Override
		public ItemStack extractItem(int slot, int amount, boolean simulate) {
			if (allowWrite) {

				return super.extractItem(slot, amount, simulate);
			} else
				return ItemStack.EMPTY;
		}

		@Nonnull
		@Override
		public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
			if (allowWrite) {
				return super.insertItem(slot, stack, simulate);
			} else
				return stack;
		}

		@Override
		public void onContentsChanged(int slot) {
			tile.setChanged();
		}
	}

	public SimpleItemStackHandler itemHandler = createItemHandler();

	public BlockEntityRaffInventory(BlockEntityType<?> BlockEntityTypeIn,BlockPos worldPosition, BlockState blockState) {
		super(BlockEntityTypeIn, worldPosition, blockState);
	}

	public boolean addItem(@Nullable Player player, ItemStack stack, @Nullable InteractionHand hand) {
		boolean did = false;
		for (int i = 0; i < getSizeInventory(); i++)
			if (itemHandler.getStackInSlot(i).isEmpty()) {
				did = true;
				ItemStack stackToAdd = stack.copy();
				stackToAdd.setCount(1);
				itemHandler.setStackInSlot(i, stackToAdd);
				if (player == null || !player.getAbilities().instabuild) {
					stack.shrink(1);
				}
				break;
			}
		if (did) {
			return true;
		} else {
			return false;
		}
	}

	public boolean canHopperExtract() {
		return false;
	}

	protected SimpleItemStackHandler createItemHandler() {
		return new SimpleItemStackHandler(this, true);
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		/*
		 * if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return
		 * CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(itemHandler);
		 */
		return super.getCapability(cap, side);
	}

	public IItemHandlerModifiable getItemHandler() {
		return itemHandler;
	}

	public abstract int getSizeInventory();

	public BlockState getState() {
		return level.getBlockState(worldPosition);
	}

	@Override
	public void readPacketNBT(CompoundTag par1CompoundTag) {
		itemHandler = createItemHandler();
		itemHandler.deserializeNBT(par1CompoundTag);
	}

	public void sendUpdates() {
		level.setBlocksDirty(worldPosition, getState(), getState());
		level.sendBlockUpdated(worldPosition, getState(), getState(), 3);
		setChanged();
	}

	public void setBlockToUpdate() {
		sendUpdates();
	}

	@Override
	public void writePacketNBT(CompoundTag par1CompoundTag) {
		par1CompoundTag.merge(itemHandler.serializeNBT());

	}
}