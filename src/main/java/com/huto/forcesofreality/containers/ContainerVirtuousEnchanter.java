package com.huto.forcesofreality.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.ContainerInit;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.objects.tileenties.TileEntityVirtuousEnchant;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ContainerVirtuousEnchanter extends Container {

	public final IInventory tableInventory = new Inventory(2) {
		public void markDirty() {
			super.markDirty();
			ContainerVirtuousEnchanter.this.onCraftMatrixChanged(this);
		}
	};

	public final TileEntityVirtuousEnchant te;
	private final IWorldPosCallable canInteractWithCallable;

	public static EnumVirtuousTypes enchantingType;

	public ContainerVirtuousEnchanter(final int windowId, final PlayerInventory playerInv,
			final TileEntityVirtuousEnchant teIn) {
		super(ContainerInit.virtuous_enchanter.get(), windowId);
		this.te = teIn;
		this.canInteractWithCallable = IWorldPosCallable.of(te.getWorld(), te.getPos());

		// Main Inv
		this.addSlot(new Slot(tableInventory, 0, 15, 47));
		// Gems
		this.addSlot(new Slot(tableInventory, 1, 35, 47) {
			@Override
			public boolean isItemValid(ItemStack stack) {
				if (ItemTags.getCollection().get(new ResourceLocation(ForcesOfReality.MOD_ID, "mod_gems"))
						.contains(stack.getItem())) {
					return true;
				}
				return false;
			}
		});

		// Player Inv
		int startPlayerInvY = 84;
		int startX = 8;
		int slostSizePlus2 = 18;
		for (int row = 0; row < 3; ++row) {
			for (int column = 0; column < 9; ++column) {
				this.addSlot(new Slot(playerInv, 9 + (row * 9) + column, startX + (column * slostSizePlus2),
						startPlayerInvY + (row * slostSizePlus2)));
			}
		}
		// HotBar
		int hotbarY = 142;
		for (int column = 0; column < 9; ++column) {
			this.addSlot(new Slot(playerInv, column, startX + (column * slostSizePlus2), hotbarY));
		}

		this.trackInt(IntReferenceHolder.create(this.enchantLevels, 0));
		this.trackInt(IntReferenceHolder.create(this.enchantLevels, 1));
		this.trackInt(IntReferenceHolder.create(this.enchantLevels, 2));
		this.trackInt(this.xpSeed).set(playerInv.player.getXPSeed());
		this.trackInt(IntReferenceHolder.create(this.enchantClue, 0));
		this.trackInt(IntReferenceHolder.create(this.enchantClue, 1));
		this.trackInt(IntReferenceHolder.create(this.enchantClue, 2));
		this.trackInt(IntReferenceHolder.create(this.worldClue, 0));
		this.trackInt(IntReferenceHolder.create(this.worldClue, 1));
		this.trackInt(IntReferenceHolder.create(this.worldClue, 2));
	}

	public static void updateEnchantingType(ItemStack stack) {
		Item item = stack.getItem();
		if (item == ItemInit.gem_topaz.get()) {
			enchantingType = EnumVirtuousTypes.TOPAZ;
		} else if (item == ItemInit.gem_amethyst.get()) {
			enchantingType = EnumVirtuousTypes.AMETHYST;
		} else if (item == ItemInit.gem_hematite.get()) {
			enchantingType = EnumVirtuousTypes.HEMATITE;
		} else if (item == ItemInit.gem_sapphire.get()) {
			enchantingType = EnumVirtuousTypes.SAPPHIRE;
		} else if (item == ItemInit.gem_onyx.get()) {
			enchantingType = EnumVirtuousTypes.ONYX;
		} else if (item == ItemInit.gem_ruby.get()) {
			enchantingType = EnumVirtuousTypes.RUBY;
		} else if (item == ItemInit.gem_opal.get()) {
			enchantingType = EnumVirtuousTypes.OPAL;
		} else {
			enchantingType = EnumVirtuousTypes.DEFAULT;
		}
	}

	public EnumVirtuousTypes getEnchantingType() {
		return enchantingType;
	}

	public static float getGemModifier() {
		switch (enchantingType) {
		case TOPAZ:
			return 2.0f;
		case AMETHYST:
			return 3.0f;
		case HEMATITE:
			return 4.0f;
		case SAPPHIRE:
			return 5.0f;
		case ONYX:
			return 6.0f;
		case RUBY:
			return 7.0f;
		case OPAL:
			return 20.0f;
		default:
			return 1.0f;
		}
	}

	private static TileEntityVirtuousEnchant getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInv.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof TileEntityVirtuousEnchant) {
			return (TileEntityVirtuousEnchant) tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct! " + tileAtPos);
	}

	public ContainerVirtuousEnchanter(final int windowId, final PlayerInventory playerInventory,
			final PacketBuffer data) {
		this(windowId, playerInventory, getTileEntity(playerInventory, data));
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.virtuous_enchanter.get());
	}

	/**
	 * Handle when the stack in slot {@code index} is shift-clicked. Normally this
	 * moves the stack between the player inventory and the other inventory(s).
	 */
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index == 0) {
				if (!this.mergeItemStack(itemstack1, 2, 38, true)) {
					return ItemStack.EMPTY;
				}
			} else if (index == 1) {
				if (!this.mergeItemStack(itemstack1, 2, 38, true)) {
					return ItemStack.EMPTY;
				}
			} else if (ItemTags.getCollection().get(new ResourceLocation(ForcesOfReality.MOD_ID, "mod_gems"))
					.contains(itemstack1.getItem())) {
				if (!this.mergeItemStack(itemstack1, 1, 2, true)) {
					return ItemStack.EMPTY;
				}
			} else {
				if (this.inventorySlots.get(0).getHasStack() || !this.inventorySlots.get(0).isItemValid(itemstack1)) {
					return ItemStack.EMPTY;
				}

				ItemStack itemstack2 = itemstack1.copy();
				itemstack2.setCount(1);
				itemstack1.shrink(1);
				this.inventorySlots.get(0).putStack(itemstack2);
			}

			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTake(playerIn, itemstack1);
		}

		return itemstack;
	}

	// Actual Enchantment stuff
	private final Random rand = new Random();
	private final IntReferenceHolder xpSeed = IntReferenceHolder.single();
	public final int[] enchantLevels = new int[3];
	public final int[] enchantClue = new int[] { -1, -1, -1 };
	public final int[] worldClue = new int[] { -1, -1, -1 };

	@SuppressWarnings("deprecation")
	@Override
	public void onCraftMatrixChanged(IInventory inventoryIn) {
		if (inventoryIn == this.tableInventory) {
			ItemStack itemstack = inventoryIn.getStackInSlot(0);
			if (!itemstack.isEmpty() && itemstack.isEnchantable()) {
				this.canInteractWithCallable.consume((world, blockPos) -> {
					int power = 0;
					for (int k = -1; k <= 1; ++k) {
						for (int l = -1; l <= 1; ++l) {
							if ((k != 0 || l != 0) && world.isAirBlock(blockPos.add(l, 0, k))
									&& world.isAirBlock(blockPos.add(l, 1, k))) {
								power += getPower(world, blockPos.add(l * 2, 0, k * 2));
								power += getPower(world, blockPos.add(l * 2, 1, k * 2));
								if (l != 0 && k != 0) {
									power += getPower(world, blockPos.add(l * 2, 0, k));
									power += getPower(world, blockPos.add(l * 2, 1, k));
									power += getPower(world, blockPos.add(l, 0, k * 2));
									power += getPower(world, blockPos.add(l, 1, k * 2));
								}
							}
						}
					}
					ItemStack itemstack1 = inventoryIn.getStackInSlot(1);
					updateEnchantingType(itemstack1);
					enchantingType = getEnchantingType();

					this.rand.setSeed((long) this.xpSeed.get());
					for (int i1 = 0; i1 < 3; ++i1) {
						this.enchantLevels[i1] = EnchantmentHelper.calcItemStackEnchantability(this.rand, i1,
								(int) power, itemstack);
						this.enchantClue[i1] = -1;
						this.worldClue[i1] = -1;
						if (this.enchantLevels[i1] < i1 + 1) {
							this.enchantLevels[i1] = 0;
						}
						this.enchantLevels[i1] = net.minecraftforge.event.ForgeEventFactory.onEnchantmentLevelSet(world,
								blockPos, i1, (int) power, itemstack, enchantLevels[i1]);
					}

					for (int j1 = 0; j1 < 3; ++j1) {
						if (this.enchantLevels[j1] > 0) {
							List<EnchantmentData> list = this.getEnchantmentList(itemstack, j1, this.enchantLevels[j1]);
							if (list != null && !list.isEmpty()) {
								EnchantmentData enchantmentdata = list.get(this.rand.nextInt(list.size()));
								// this.enchantlevls[j1] is the xp levels
								// this.worldClue[j1] is enchant power
								// this.enchantclue[j1] is maybe the enchanment ids/objs?
								this.enchantClue[j1] = Registry.ENCHANTMENT.getId(enchantmentdata.enchantment);
								this.worldClue[j1] = enchantmentdata.enchantmentLevel;
							//	System.out.println(enchantmentdata.enchantment.getName() + " " + this.worldClue[j1]);
							}
						}
					}

					this.detectAndSendChanges();
				});
			} else {
				for (int i = 0; i < 3; ++i) {
					this.enchantLevels[i] = 0;
					this.enchantClue[i] = -1;
					this.worldClue[i] = -1;
				}
			}
		}
	}

	/**
	 * Handles the given Button-click on the server, currently only used by
	 * enchanting. Name is for legacy.
	 */
	@Override
	public boolean enchantItem(PlayerEntity playerIn, int id) {
		ItemStack itemstack = this.tableInventory.getStackInSlot(0);
		ItemStack itemstack1 = this.tableInventory.getStackInSlot(1);
		int i = id + 1;
		if ((itemstack1.isEmpty() || itemstack1.getCount() < i) && !playerIn.abilities.isCreativeMode) {
			return false;
		} else if (this.enchantLevels[id] <= 0 || itemstack.isEmpty()
				|| (playerIn.experienceLevel < i || playerIn.experienceLevel < this.enchantLevels[id])
						&& !playerIn.abilities.isCreativeMode) {
			return false;
		} else {
			this.canInteractWithCallable.consume((p_217003_6_, p_217003_7_) -> {
				ItemStack itemstack2 = itemstack;
				List<EnchantmentData> list = this.getEnchantmentList(itemstack, id, this.enchantLevels[id]);
				if (!list.isEmpty()) {
					playerIn.onEnchant(itemstack, i);
					boolean flag = itemstack.getItem() == Items.BOOK;
					if (flag) {
						itemstack2 = new ItemStack(Items.ENCHANTED_BOOK);
						CompoundNBT compoundnbt = itemstack.getTag();
						if (compoundnbt != null) {
							itemstack2.setTag(compoundnbt.copy());
						}

						this.tableInventory.setInventorySlotContents(0, itemstack2);
					}

					for (int j = 0; j < list.size(); ++j) {
						EnchantmentData enchantmentdata = list.get(j);
						if (flag) {
							// EnchantedBookItem.addEnchantment(itemstack2, enchantmentdata);
							// Modifying the power of the old enchant
							if (checkEnchantList(getEnchantingType(), enchantmentdata)) {
								EnchantedBookItem.addEnchantment(itemstack2,
										new EnchantmentData(enchantmentdata.enchantment,
												(int) (enchantmentdata.enchantmentLevel * getGemModifier())));

							} else {
								// If its not in that gems specialty
								EnchantedBookItem.addEnchantment(itemstack2, new EnchantmentData(
										enchantmentdata.enchantment, (int) (enchantmentdata.enchantmentLevel)));
							}
						} else {
							// Modifying the power of the old enchant
							if (checkEnchantList(getEnchantingType(), enchantmentdata)) {
								itemstack2.addEnchantment(enchantmentdata.enchantment,
										(int) (enchantmentdata.enchantmentLevel * getGemModifier()));
							} else {
								// If its not in that gems specialty
								itemstack2.addEnchantment(enchantmentdata.enchantment,
										(int) (enchantmentdata.enchantmentLevel));
							}
						}
					}

					if (!playerIn.abilities.isCreativeMode) {
						itemstack1.shrink(i);
						if (itemstack1.isEmpty()) {
							this.tableInventory.setInventorySlotContents(1, ItemStack.EMPTY);
						}
					}

					playerIn.addStat(Stats.ENCHANT_ITEM);
					if (playerIn instanceof ServerPlayerEntity) {
						CriteriaTriggers.ENCHANTED_ITEM.trigger((ServerPlayerEntity) playerIn, itemstack2, i);
					}

					this.tableInventory.markDirty();
					this.xpSeed.set(playerIn.getXPSeed());
					this.onCraftMatrixChanged(this.tableInventory);
					p_217003_6_.playSound((PlayerEntity) null, p_217003_7_, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE,
							SoundCategory.BLOCKS, 1.0F, p_217003_6_.rand.nextFloat() * 0.1F + 0.9F);
				}

			});
			return true;
		}
	}

	public boolean checkEnchantList(EnumVirtuousTypes type, EnchantmentData enchantmentdata) {
		List<Enchantment> topazList = new ArrayList<Enchantment>();
		List<Enchantment> hematiteList = new ArrayList<Enchantment>();
		List<Enchantment> onyxList = new ArrayList<Enchantment>();
		List<Enchantment> rubyList = new ArrayList<Enchantment>();
		List<Enchantment> sapphireList = new ArrayList<Enchantment>();
		List<Enchantment> amethystList = new ArrayList<Enchantment>();
		List<Enchantment> opalList = new ArrayList<Enchantment>();

		Collections.addAll(onyxList, Enchantments.FEATHER_FALLING, Enchantments.FIRE_PROTECTION,Enchantments.EFFICIENCY);
		Collections.addAll(topazList, Enchantments.SHARPNESS, Enchantments.POWER, Enchantments.THORNS,
				Enchantments.QUICK_CHARGE, Enchantments.MULTISHOT, Enchantments.PIERCING);
		Collections.addAll(hematiteList, Enchantments.PROTECTION, Enchantments.UNBREAKING, Enchantments.KNOCKBACK,
				Enchantments.PUNCH);
		Collections.addAll(amethystList, Enchantments.LOOTING, Enchantments.FORTUNE, Enchantments.MENDING,
				Enchantments.LUCK_OF_THE_SEA, Enchantments.LOYALTY);
		Collections.addAll(rubyList, Enchantments.FIRE_ASPECT, Enchantments.FLAME, Enchantments.SWEEPING,
				Enchantments.BANE_OF_ARTHROPODS, Enchantments.SMITE);
		Collections.addAll(sapphireList, Enchantments.RESPIRATION, Enchantments.AQUA_AFFINITY,
				Enchantments.DEPTH_STRIDER, Enchantments.FROST_WALKER, Enchantments.IMPALING, Enchantments.RIPTIDE,
				Enchantments.CHANNELING);
		opalList.addAll(topazList);
		opalList.addAll(hematiteList);
		opalList.addAll(onyxList);
		opalList.addAll(rubyList);
		opalList.addAll(sapphireList);
		opalList.addAll(amethystList);

		Enchantment enchant = enchantmentdata.enchantment;
		if (type == EnumVirtuousTypes.TOPAZ && topazList.contains(enchant)) {
			return true;
		} else if (type == EnumVirtuousTypes.AMETHYST && amethystList.contains(enchant)) {
			return true;
		} else if (type == EnumVirtuousTypes.HEMATITE && hematiteList.contains(enchant)) {
			return true;
		} else if (type == EnumVirtuousTypes.ONYX && onyxList.contains(enchant)) {
			return true;
		} else if (type == EnumVirtuousTypes.RUBY && rubyList.contains(enchant)) {
			return true;
		} else if (type == EnumVirtuousTypes.SAPPHIRE && sapphireList.contains(enchant)) {
			return true;
		} else if (type == EnumVirtuousTypes.OPAL && opalList.contains(enchant)) {
			return true;
		} else {
			return false;
		}

	}

	private float getPower(net.minecraft.world.World world, net.minecraft.util.math.BlockPos pos) {

		if (world.getBlockState(pos).getBlock() == BlockInit.end_crystal_somnolent.get()
				|| world.getBlockState(pos).getBlock() == BlockInit.end_crystal_nightmare.get()) {
			return 3f;
		} else {
			return world.getBlockState(pos).getEnchantPowerBonus(world, pos);
		}
	}

	private List<EnchantmentData> getEnchantmentList(ItemStack stack, int enchantSlot, int level) {
		this.rand.setSeed((long) (this.xpSeed.get() + enchantSlot));
		List<EnchantmentData> list = EnchantmentHelper.buildEnchantmentList(this.rand, stack, level, false);
		if (stack.getItem() == Items.BOOK && list.size() > 1) {
			list.remove(this.rand.nextInt(list.size()));
		}

		return list;
	}

	@OnlyIn(Dist.CLIENT)
	public int getGemAmount() {
		ItemStack itemstack = this.tableInventory.getStackInSlot(1);
		return itemstack.isEmpty() ? 0 : itemstack.getCount();
	}

	@OnlyIn(Dist.CLIENT)
	public int func_217005_f() {
		return this.xpSeed.get();
	}

	@Override
	public void onContainerClosed(PlayerEntity playerIn) {
		super.onContainerClosed(playerIn);
		this.canInteractWithCallable.consume((p_217004_2_, p_217004_3_) -> {
			this.clearContainer(playerIn, playerIn.world, this.tableInventory);
		});
	}

}
