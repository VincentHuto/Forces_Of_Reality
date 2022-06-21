package com.vincenthuto.forcesofreality.container;

import com.vincenthuto.forcesofreality.container.slot.SlotMechanGlove;
import com.vincenthuto.forcesofreality.init.ContainerInit;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemMechanGlove;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ContainerMechanGlove extends AbstractContainerMenu {
	public ContainerMechanGlove(final int windowId, final Inventory playerInventory, final FriendlyByteBuf data) {
		this(windowId, playerInventory);
	}

	public ContainerMechanGlove(final int windowId, final Inventory playerInventory) {
		this(windowId, playerInventory.player.level, playerInventory.player.blockPosition(), playerInventory,
				playerInventory.player);
	}

	public ContainerMechanGlove(int windowId, Level world, BlockPos pos, Inventory playerInventory,
			Player playerEntity) {
		super(ContainerInit.mechan_glove_container.get(), windowId);

		playerInv = playerInventory;
		ItemStack stack = findMechanGlove(playerEntity);

		if (stack == null || stack.isEmpty()) {
			playerEntity.closeContainer();
			return;
		}

		IItemHandler tmp = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);

		if (tmp instanceof MechanGloveItemHandler) {
			handler = (MechanGloveItemHandler) tmp;
			handler.load();
			slotcount = tmp.getSlots();
			itemKey = stack.getDescriptionId();

			addMySlots(stack);
			addPlayerSlots(playerInv);
		} else
			playerEntity.closeContainer();
	}

	public ContainerMechanGlove(int openType, int windowId, Level world, BlockPos pos, Inventory playerInventory,
			Player playerEntity) {
		this(windowId, world, pos, playerInventory, playerEntity);
	}

	public int slotcount = 0;
	private int slotID;
	public String itemKey = "";
	@SuppressWarnings("rawtypes")
//	public static final MenuType type = new MenuType<>(ContainerMechanGlove::new)
//			.setRegistryName("mechan_glove_container");

	private Inventory playerInv;
	public MechanGloveItemHandler handler;

	@Override
	public boolean stillValid(Player playerIn) {
		if (slotID == -106)
			return playerIn.getOffhandItem().getItem() instanceof ItemMechanGlove;
		return playerIn.getInventory().getItem(slotID).getItem() instanceof ItemMechanGlove;
	}

//	@Override
//	public void clicked(int slot, int dragType, ClickType clickTypeIn, Player player) {
//		if (slot >= 0) {
//			if (getSlot(slot).getItem().getItem() instanceof ItemMechanGlove)
//		if (clickTypeIn == ClickType.SWAP)
//
//		if (slot >= 0) {
//			/*
//			 * if (((ItemMechanGlove) findMechanGlove(player).getItem()).getModuleStack() !=
//			 * null) { ItemStack moduleStack = ((ItemMechanGlove)
//			 * findMechanGlove(player).getItem()).getModuleStack(); if
//			 * (getSlot(slot).getHasStack()) { if (getSlot(slot).getStack().getItem() ==
//			 * moduleStack.getItem()) { System.out.println("t"); if
//			 * (findMechanGlove(player).hasTag()) { if
//			 * (findMechanGlove(player).getTag().get("selectedstack") != null) {
//			 * findMechanGlove(player).getTag().put("selectedstack",
//			 * ItemStack.EMPTY.write(new CompoundTag())); ((ItemMechanGlove)
//			 * findMechanGlove(player).getItem()).setModuleStack(ItemStack.EMPTY); if
//			 * (getSlot(slot).getStack().getItem() == ItemInit.mechan_module_blade.get()) {
//			 * ((ItemMechanGlove) findMechanGlove(player).getItem()).setSwordState(false); }
//			 * } } }
//			 *
//			 * } } System.out.println(((ItemMechanGlove)
//			 * findMechanGlove(player).getItem()).getModuleStack());
//			 */ getSlot(slot).container.setChanged();
//		}
//
//	}

	private void addPlayerSlots(Inventory playerInventory) {
		int originX = 0;
		int originY = 0;
		switch (slotcount) {
		case 18:
			originX = 7;
			originY = 67;
			break;
		case 27:
			originX = 7;
			originY = 85;
			break;
		default:
			originX = 7;
			originY = 85;
		}

		// Player Inventory
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				int x = originX + col * 18;
				int y = originY + row * 18;
				int index = (col + row * 9) + 9;
				this.addSlot(new Slot(playerInventory, index, x + 1, y + 1));
			}
		}

		// Hotbar
		for (int col = 0; col < 9; col++) {
			int x = originX + col * 18;
			int y = originY + 58;
			this.addSlot(new Slot(playerInventory, col, x + 1, y + 1));
		}
	}

	private void addMySlots(ItemStack stack) {
		if (handler == null)
			return;

		int cols = slotcount % 3 == 0 ? 3 : 10;
		int rows = slotcount / cols;
		int slotindex = 0;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				int x = 7 + col * 18;
				int y = 17 + row * 18;

				this.addSlot(new SlotMechanGlove(handler, slotindex, x + 1, y + 1));
				slotindex++;
				if (slotindex >= slotcount)
					break;
			}
		}

	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			int bagslotcount = slots.size() - playerIn.getInventory().items.size();
			ItemStack itemstack1 = slot.getItem();
			if (itemstack1.getCount() < 1) {
				itemstack = itemstack1.copy();
				if (index < bagslotcount) {
					if (!this.moveItemStackTo(itemstack1, bagslotcount, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else if (!this.moveItemStackTo(itemstack1, 0, bagslotcount, false)) {
					return ItemStack.EMPTY;
				}
				if (itemstack1.isEmpty())
					slot.set(ItemStack.EMPTY);
				else
					slot.setChanged();
			}
		}
		return itemstack;
	}

	private ItemStack findMechanGlove(Player playerEntity) {
		Inventory inv = playerEntity.getInventory();

		if (playerEntity.getMainHandItem().getItem() instanceof ItemMechanGlove) {
			for (int i = 0; i <= 35; i++) {
				ItemStack stack = inv.getItem(i);
				if (stack == playerEntity.getMainHandItem()) {
					slotID = i;
					return stack;
				}
			}
		} else if (playerEntity.getOffhandItem().getItem() instanceof ItemMechanGlove) {
			slotID = -106;
			return playerEntity.getOffhandItem();
		} else {
			for (int i = 0; i <= 35; i++) {
				ItemStack stack = inv.getItem(i);
				if (stack.getItem() instanceof ItemMechanGlove) {
					slotID = i;
					return stack;
				}
			}
		}
		return ItemStack.EMPTY;
	}
}