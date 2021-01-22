package com.huto.forcesofreality.objects.items.coven.tool;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.huto.forcesofreality.containers.ContainerMechanGlove;
import com.huto.forcesofreality.containers.MechanGloveItemHandler;
import com.huto.forcesofreality.events.ClientEventSubscriber;
import com.huto.forcesofreality.font.ModTextFormatting;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.network.PacketHandler;
import com.huto.forcesofreality.network.coven.MechanGloveActionMessage;
import com.huto.forcesofreality.objects.blocks.BlockBeyondFlame;
import com.huto.forcesofreality.objects.items.armor.ItemSparkDirector;
import com.huto.forcesofreality.objects.items.coven.tool.modules.IModuleUse;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.item.UseAction;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

public class ItemMechanGlove extends Item {
	String name;
	Integer size;
	int range;
	Rarity rare;
	ItemStack moduleStack;
	public String TAG_SELECTEDSTACK = "selectedstack";
	public int selectedModuleSlot;
	public String TAG_SELECTED = "selected";
	public static boolean swordstate;
	public static String TAG_SWORDSTATE = "swordstate";

	public ItemMechanGlove(Properties props, String name, Integer size, int range, Rarity rarity) {
		super(props);
		this.name = name;
		this.size = size;
		this.rare = rarity;
		this.range = range;
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return this.rare == ModTextFormatting.AURIC ? true : false;

	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	public int getRange() {
		return range;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
		super.onUse(worldIn, livingEntityIn, stack, count);
		RayTraceResult trace = livingEntityIn.pick(range, ClientEventSubscriber.getPartialTicks(), true);
		switch (trace.getType()) {
		case ENTITY: {
		}
		case BLOCK: {
			if (stack.getTag() != null) {
				if (stack.getTag().get(TAG_SELECTEDSTACK) != null) {
					@SuppressWarnings("static-access")
					ItemStack moduleStack = stack.read((CompoundNBT) stack.getTag().get(TAG_SELECTEDSTACK));
					BlockPos hitPos = ((BlockRayTraceResult) trace).getPos();
					Block hitBlock = worldIn.getBlockState(hitPos).getBlock();
					if (moduleStack.getItem() == ItemInit.mechan_module_laser.get()) {
				
						ItemStack smeltStack = worldIn.getRecipeManager()
								.getRecipe(IRecipeType.SMELTING, new Inventory(new ItemStack(hitBlock)), worldIn)
								.map(FurnaceRecipe::getRecipeOutput)
								.filter(itemStack -> !new ItemStack(hitBlock).isEmpty())
								.map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack,
										new ItemStack(hitBlock).getCount() * new ItemStack(hitBlock).getCount()))
								.orElse(new ItemStack(hitBlock));
						if (smeltStack.getItem() != new ItemStack(hitBlock).getItem()) {
							if (smeltStack.getItem() instanceof BlockItem) {
								BlockItem smeltBlock = (BlockItem) smeltStack.getItem();
								worldIn.destroyBlock(hitPos, false);
								worldIn.setBlockState(hitPos, smeltBlock.getBlock().getDefaultState());
							} else {
								if (worldIn.rand.nextInt(20) % 3 == 0) {
									worldIn.addEntity(new ItemEntity(worldIn, hitPos.getX(), hitPos.getY(),
											hitPos.getZ(), smeltStack));
								}
								worldIn.destroyBlock(hitPos, false);
							}
						} else {
							if (!hitBlock.getDefaultState().isAir() && hitBlock != BlockInit.beyond_flames.get() && hitBlock != Blocks.FIRE) {
								if (hitBlock.isFlammable(hitBlock.getDefaultState(), worldIn,
										((BlockRayTraceResult) trace).getPos(),
										((BlockRayTraceResult) trace).getFace())) {
									BlockPos blockpos1 = hitPos.offset(((BlockRayTraceResult) trace).getFace());
									BlockState blockstate1 = AbstractFireBlock.getFireForPlacement(worldIn, blockpos1);
									worldIn.setBlockState(blockpos1, blockstate1, 11);

								}
							}
						}
					} else if (moduleStack.getItem() == ItemInit.wicked_module_laser.get()) {
						if (!hitBlock.getDefaultState().isAir() && hitBlock != Blocks.FIRE && hitBlock !=BlockInit.beyond_flames.get()) {
								BlockPos blockpos1 = hitPos.offset(((BlockRayTraceResult) trace).getFace());
								BlockBeyondFlame blockstate1 = (BlockBeyondFlame)BlockInit.beyond_flames.get();
								BlockState state = blockstate1.getFireForPlacement(worldIn, blockpos1);
								worldIn.setBlockState(blockpos1, state, 11);

							}
					}
				}
			}

		}

		default:
			break;
		}

	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000 / 4;
	}

	@Override
	public boolean shouldSyncTag() {
		return true;
	}

	public boolean getSwordState() {
		return swordstate;
	}

	public void setSwordState(boolean swordstateIn) {
		swordstate = swordstateIn;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (worldIn.isRemote) {
			if (!playerIn.isSneaking()) {
				PacketHandler.MECHANGLOVE.sendToServer(new MechanGloveActionMessage());
			}
		}
		if (!worldIn.isRemote) {
			if (playerIn.isSneaking()) {
				// open
				playerIn.openContainer(new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return playerIn.getHeldItem(handIn).getDisplayName();
					}

					@Nullable
					@Override
					public Container createMenu(int windowId, PlayerInventory p_createMenu_2_,
							PlayerEntity p_createMenu_3_) {
						return new ContainerMechanGlove(windowId, p_createMenu_3_.world, p_createMenu_3_.getPosition(),
								p_createMenu_2_, p_createMenu_3_);
					}
				});

			}
		}
		return ActionResult.resultPass(playerIn.getHeldItem(handIn));
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if (worldIn != null) {
			if (stack != null) {
				IItemHandler handler = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
						.orElseThrow(IllegalArgumentException::new);
				if (handler != null) {
					tooltip.add(new StringTextComponent(
							TextFormatting.LIGHT_PURPLE + "Rarity: " + ModTextFormatting.toProperCase(rare.name())));
					tooltip.add(new StringTextComponent(TextFormatting.GREEN + "Supported Modules: " + size));
					if (stack.hasTag()) {
						ItemStack selectedModuleStack = handler.getStackInSlot(stack.getTag().getInt(TAG_SELECTED));
						if (selectedModuleStack.getItem() != Items.AIR) {
							tooltip.add(new TranslationTextComponent(TextFormatting.GOLD + "Selected Module: "
									+ I18n.format(selectedModuleStack.getTranslationKey())));
						} else {
							tooltip.add(new TranslationTextComponent(TextFormatting.GOLD + "No Module Selected"));
						}
						if (!stack.getTag().getBoolean(TAG_SWORDSTATE)) {
							tooltip.add(new TranslationTextComponent(
									TextFormatting.DARK_GREEN + "Damage:" + getHitDamage(rare)));
						} else {
							tooltip.add(new TranslationTextComponent(
									TextFormatting.DARK_GREEN + "Damage:" + getHitDamage(rare) * 3f));
						}
					} else {
						tooltip.add(new TranslationTextComponent(TextFormatting.RED + "No Modules Inserted"));
					}
				}
			}
		}

	}

	@SuppressWarnings("static-access")
	public void moduleUse(PlayerEntity playerIn, Hand handIn, ItemStack itemStack, World worldIn) {
		if (itemStack.getTag() != null) {
			if (itemStack.getTag().get(TAG_SELECTEDSTACK) != null) {
				ItemStack moduleStack = itemStack.read((CompoundNBT) itemStack.getTag().get(TAG_SELECTEDSTACK));
				if (moduleStack.getItem() instanceof IModuleUse) {
					((IModuleUse) moduleStack.getItem()).use(playerIn, handIn, itemStack, worldIn);
					itemStack.damageItem(((IModuleUse) moduleStack.getItem()).getDamageCost(), playerIn, (entity) -> {
						entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
					});
				}
			}
		}

	}

	public void clearOldModuleUse(PlayerEntity playerIn, ItemStack itemStack, World worldIn) {
		if (itemStack.getTag().getBoolean(TAG_SWORDSTATE)) {
			itemStack.getTag().putBoolean(TAG_SWORDSTATE, false);
		}
		if (playerIn.inventory.armorInventory.get(2).getItem() instanceof ItemSparkDirector) {
			ItemStack armor = playerIn.inventory.armorInventory.get(2);
			armor.getOrCreateTag().putFloat("heightmodifier", 0.1f);
		}
	}

	public float getHitDamage(Rarity rareIn) {
		if (rareIn == Rarity.COMMON) {
			return 1f;
		} else if (rareIn == Rarity.UNCOMMON) {
			return 2f;
		} else if (rareIn == Rarity.RARE) {
			return 3f;
		} else if (rareIn == Rarity.EPIC) {
			return 4f;
		} else if (rareIn == ModTextFormatting.AURIC) {
			return 5f;
		} else {
			return 1f;

		}
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		DamageSource mechanGloveSource = DamageSource.causePlayerDamage((PlayerEntity) attacker);
		if (stack.getTag() != null) {
			if (stack.getTag().get(TAG_SELECTEDSTACK) != null) {
				ItemStack moduleStack = stack.read((CompoundNBT) stack.getTag().get(TAG_SELECTEDSTACK));
				if (moduleStack.getItem() == ItemInit.mechan_module_blade.get()) {
					if (!stack.hasTag()) {
						stack.setTag(new CompoundNBT());
						CompoundNBT compound = stack.getTag();
						compound.putBoolean(TAG_SWORDSTATE, false);
					}
					CompoundNBT compound = stack.getTag();
					if (!compound.getBoolean(TAG_SWORDSTATE)) {
						target.attackEntityFrom(mechanGloveSource, getHitDamage(rare));
					} else {
						target.attackEntityFrom(mechanGloveSource, getHitDamage(rare) * 3f);

					}
				}
			}
		}

		return super.hitEntity(stack, target, attacker);
	}

	public ItemStack getModuleStack() {
		return moduleStack;
	}

	public void setModuleStack(ItemStack moduleStackIn) {
		this.moduleStack = moduleStackIn;
	}

	public void setSelectedModuleSlot(int selectedModuleIn) {
		selectedModuleSlot = selectedModuleIn;
	}

	public int getSelectedModuleSlot() {
		return selectedModuleSlot;
	}

	@Nullable
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
		return new MechanGloveCaps(stack, size, nbt);
	}

	@SuppressWarnings("rawtypes")
	class MechanGloveCaps implements ICapabilitySerializable {
		public MechanGloveCaps(ItemStack stack, int size, CompoundNBT nbtIn) {
			itemStack = stack;
			this.size = size;
			inventory = new MechanGloveItemHandler(itemStack, size);
			optional = LazyOptional.of(() -> inventory);
		}

		@SuppressWarnings("unused")
		private int size;
		private ItemStack itemStack;
		private MechanGloveItemHandler inventory;
		private LazyOptional<IItemHandler> optional;

		@Nonnull
		@Override
		public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				return optional.cast();
			} else
				return LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			inventory.save();
			return new CompoundNBT();
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			inventory.load();
		}
	}
}
