package com.vincenthuto.forcesofreality.common.item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Helpers for Inventories, ItemStacks, Items, and the Ore Dictionary Notice:
 * Please try to keep methods tidy and alphabetically ordered. Thanks!
 */
public final class ItemHelper {

	public static final Comparator<ItemStack> ITEMSTACK_ASCENDING = (o1, o2) -> {
		if (o1.isEmpty() && o2.isEmpty()) {
			return 0;
		}
		if (o1.isEmpty()) {
			return 1;
		}
		if (o2.isEmpty()) {
			return -1;
		}
		if (o1.getItem() != o2.getItem()) {
			// Same item id
			return o1.getCount() - o2.getCount();
		}
		// Different id
		return Item.getId(o1.getItem()) - Item.getId(o2.getItem());
	};

	/**
	 * Gets an ActionResult based on a type
	 */
	public static InteractionResultHolder<ItemStack> actionResultFromType(InteractionResult type, ItemStack stack) {
		switch (type) {
		case SUCCESS:
			return InteractionResultHolder.success(stack);
		case CONSUME:
			return InteractionResultHolder.consume(stack);
		case FAIL:
			return InteractionResultHolder.fail(stack);
		case PASS:
		default:
			return InteractionResultHolder.pass(stack);
		}
	}

	/**
	 * @return True if the only aspect these stacks differ by is stack size, false
	 *         if item, meta, or nbt differ.
	 */
	public static boolean areItemStacksEqual(ItemStack stack1, ItemStack stack2) {
		return ItemStack.matches(getNormalizedStack(stack1), getNormalizedStack(stack2));
	}

	/**
	 * Compacts an inventory and returns if the inventory is/was empty.
	 *
	 * @return True if the inventory was empty.
	 */
	public static boolean compactInventory(IItemHandlerModifiable inventory) {
		List<ItemStack> temp = new ArrayList<>();
		for (int i = 0; i < inventory.getSlots(); i++) {
			ItemStack stackInSlot = inventory.getStackInSlot(i);
			if (!stackInSlot.isEmpty()) {
				temp.add(stackInSlot);
				inventory.setStackInSlot(i, ItemStack.EMPTY);
			}
		}
		for (ItemStack s : temp) {
			ItemHandlerHelper.insertItemStacked(inventory, s, false);
		}
		return temp.isEmpty();
	}

	/**
	 * Compacts and sorts list of items, without regard for stack sizes
	 */
	public static void compactItemListNoStacksize(List<ItemStack> list) {
		for (int i = 0; i < list.size(); i++) {
			ItemStack s = list.get(i);
			if (!s.isEmpty()) {
				for (int j = i + 1; j < list.size(); j++) {
					ItemStack s1 = list.get(j);
					if (ItemHandlerHelper.canItemStacksStack(s, s1)) {
						s.grow(s1.getCount());
						list.set(j, ItemStack.EMPTY);
					}
				}
			}
		}
		list.removeIf(ItemStack::isEmpty);
		list.sort(ITEMSTACK_ASCENDING);
	}

	/**
	 * Copies the nbt compound similar to how {@link CompoundTag#copy()} does,
	 * except it just skips the desired key instead of having to copy a potentially
	 * large value which may be expensive, and then remove it from the copy.
	 *
	 * @implNote If the input {@link CompoundTag} only contains the key we want to
	 *           skip, we return null instead of an empty {@link CompoundTag}.
	 */
	@Nullable
	public static CompoundTag copyNBTSkipKey(@Nonnull CompoundTag nbt, @Nonnull String keyToSkip) {
		CompoundTag copiedNBT = new CompoundTag();
		for (String key : nbt.getAllKeys()) {
			if (keyToSkip.equals(key)) {
				continue;
			}
			Tag innerNBT = nbt.get(key);
			if (innerNBT != null) {
				// Shouldn't be null but double check
				copiedNBT.put(key, innerNBT.copy());
			}
		}
		if (copiedNBT.isEmpty()) {
			return null;
		}
		return copiedNBT;
	}

	/**
	 * Returns an ItemStack with stacksize 1.
	 */
	public static ItemStack getNormalizedStack(ItemStack stack) {
		ItemStack result = stack.copy();
		result.setCount(1);
		return result;
	}

	public static IItemHandlerModifiable immutableCopy(IItemHandler toCopy) {
		final List<ItemStack> list = new ArrayList<>(toCopy.getSlots());
		for (int i = 0; i < toCopy.getSlots(); i++) {
			list.add(toCopy.getStackInSlot(i));
		}
		return new IItemHandlerModifiable() {
			@Nonnull
			@Override
			public ItemStack extractItem(int slot, int amount, boolean simulate) {
				return ItemStack.EMPTY;
			}

			@Override
			public int getSlotLimit(int slot) {
				return getStackInSlot(slot).getMaxStackSize();
			}

			@Override
			public int getSlots() {
				return list.size();
			}

			@Nonnull
			@Override
			public ItemStack getStackInSlot(int slot) {
				return list.get(slot);
			}

			@Nonnull
			@Override
			public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
				return stack;
			}

			@Override
			public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
				return true;
			}

			@Override
			public void setStackInSlot(int slot, @Nonnull ItemStack stack) {
			}
		};
	}

	public static boolean isDamageable(ItemStack stack) {
		return stack.isDamageableItem();
	}

	public static boolean isOre(Block b) {
		return ForgeRegistries.BLOCKS.tags().getTag(BlockTags.STONE_ORE_REPLACEABLES).contains(b)
				|| ForgeRegistries.BLOCKS.tags().getTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES).contains(b);
	}

	public static boolean isOre(BlockState state) {
		return state.is(Tags.Blocks.ORES);
	}

	public static boolean isOre(Item i) {
		return isOre(Block.byItem(i));
	}

	@Nullable
	public static CompoundTag recombineNBT(List<CompoundTag> pieces) {
		if (pieces.isEmpty()) {
			return null;
		}
		CompoundTag combinedNBT = pieces.get(0);
		for (int i = 1; i < pieces.size(); i++) {
			combinedNBT = combinedNBT.merge(pieces.get(i));
		}
		return combinedNBT;
	}

	/**
	 * @return The amount of the given stack that could not fit. If it all fit, zero
	 *         is returned
	 */
	public static int simulateFit(NonNullList<ItemStack> inv, ItemStack stack) {
		int remainder = stack.getCount();
		for (ItemStack invStack : inv) {
			if (invStack.isEmpty()) {
				// Slot is empty, just put it all there
				return 0;
			}
			if (ItemHandlerHelper.canItemStacksStack(stack, invStack)) {
				int amountSlotNeeds = invStack.getMaxStackSize() - invStack.getCount();
				// Double check we don't have an over sized stack
				if (amountSlotNeeds > 0) {
					if (remainder <= amountSlotNeeds) {
						// If the slot can accept it all, return it all fit
						return 0;
					}
					// Otherwise take that many items out and
					remainder -= amountSlotNeeds;
				}
			}
		}
		return remainder;
	}

	public static BlockState stackToState(ItemStack stack) {
		if (stack.getItem() instanceof BlockItem) {
			return ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
		}
		return null;
	}
}