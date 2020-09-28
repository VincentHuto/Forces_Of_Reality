package com.huto.hutosmod.containers;

import java.util.Objects;

import com.huto.hutosmod.gui.GuiChiselStation;
import com.huto.hutosmod.init.ContainerInit;
import com.huto.hutosmod.objects.tileenties.TileEntityChiselStation;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;

public class ContainerChiselStation extends Container {
	private final int numRows;
	private final TileEntityChiselStation chestInventory;
	public int[] activatedRunes;
	GuiChiselStation station;

	public ContainerChiselStation(final int windowId, final PlayerInventory playerInv,
			final TileEntityChiselStation chestInventory) {
		super(ContainerInit.runic_chisel_station.get(), windowId);
		this.chestInventory = chestInventory;
		this.numRows = 4;
		// chestInventory.openInventory(player);
		// SLOTS
		this.addSlot(new Slot(chestInventory, 0, 8, 18 + 1 * 18));
		this.addSlot(new Slot(chestInventory, 1, 8, 22 + 2 * 18));
		this.addSlot(new Slot(chestInventory, 2, 145, 44));
		// INVENTORY
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				this.addSlot(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 104 + y * 18));
			}
		}
		// HOTBAR
		for (int x = 0; x < 9; x++) {
			this.addSlot(new Slot(playerInv, x, 8 + x * 18, 162));
		}

	}

	private static TileEntityChiselStation getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInv.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof TileEntityChiselStation) {
			return (TileEntityChiselStation) tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}

	public ContainerChiselStation(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return this.chestInventory.isUsableByPlayer(playerIn);
	}

	@Override
	public void onContainerClosed(PlayerEntity playerIn) {
		super.onContainerClosed(playerIn);
		chestInventory.closeInventory(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack = slot.getStack();
			stack = itemStack.copy();
			if (index < this.numRows * 9) {
				if (!this.mergeItemStack(itemStack, this.numRows * 9, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemStack, 0, this.numRows * 9, false)) {
				return ItemStack.EMPTY;
			}
			if (itemStack.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		return stack;
	}

	public TileEntityChiselStation getChestInventory() {
		return this.chestInventory;
	}
}
