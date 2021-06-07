package com.huto.forcesofreality.capabilitie.adornment;

import java.util.concurrent.Callable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class AdornmentsItemHandlerCap {

	public static class IAdornmentsItemHandlerStorage implements Capability.IStorage<IAdornmentsItemHandler> {

		@Nullable
		@Override
		public INBT writeNBT(Capability<IAdornmentsItemHandler> capability, IAdornmentsItemHandler instance, Direction side) {
			return null;
		}

		@Override
		public void readNBT(Capability<IAdornmentsItemHandler> capability, IAdornmentsItemHandler instance, Direction side,
				INBT nbt) {

		}
	}

	public static class IAdornmentsItemHandlerFactory implements Callable<IAdornmentsItemHandler> {

		@Override
		public IAdornmentsItemHandler call() {
			return new IAdornmentsItemHandler() {
				@Override
				public boolean isItemValidForSlot(int slot, ItemStack stack) {
					return false;
				}

				@Override
				public boolean isEventBlocked() {
					return false;
				}

				@Override
				public void setEventBlock(boolean blockEvents) {

				}

				@Override
				public void setStackInSlot(int slot, @Nonnull ItemStack stack) {

				}

				@Override
				public int getSlots() {
					return 0;
				}

				@Nonnull
				@Override
				public ItemStack getStackInSlot(int slot) {
					return null;
				}

				@Nonnull
				@Override
				public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
					return null;
				}

				@Nonnull
				@Override
				public ItemStack extractItem(int slot, int amount, boolean simulate) {
					return null;
				}

				@Override
				public int getSlotLimit(int slot) {
					return 0;
				}

				@Override
				public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
					return false;
				}

				@Override
				public void tick() {

				}
			};
		}
	}
}
