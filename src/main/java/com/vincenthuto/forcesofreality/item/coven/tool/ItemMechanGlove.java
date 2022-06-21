package com.vincenthuto.forcesofreality.item.coven.tool;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.vincenthuto.forcesofreality.block.BlockBeyondFlame;
import com.vincenthuto.forcesofreality.container.ContainerMechanGlove;
import com.vincenthuto.forcesofreality.container.MechanGloveItemHandler;
import com.vincenthuto.forcesofreality.init.BlockInit;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.item.armor.ItemSparkDirector;
import com.vincenthuto.forcesofreality.item.tool.coven.module.IModuleUse;
import com.vincenthuto.forcesofreality.network.PacketHandler;
import com.vincenthuto.forcesofreality.network.coven.MechanGloveActionMessage;
import com.vincenthuto.hutoslib.client.HLClientUtils;

import net.minecraft.ChatFormatting;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

public class ItemMechanGlove extends Item {
	@SuppressWarnings("rawtypes")
	class MechanGloveCaps implements ICapabilitySerializable {
		@SuppressWarnings("unused")
		private int size;

		private ItemStack itemStack;
		private MechanGloveItemHandler inventory;
		private LazyOptional<IItemHandler> optional;

		public MechanGloveCaps(ItemStack stack, int size, CompoundTag nbtIn) {
			itemStack = stack;
			this.size = size;
			inventory = new MechanGloveItemHandler(itemStack, size);
			optional = LazyOptional.of(() -> inventory);
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			inventory.load();
		}

		@Nonnull
		@Override
		public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
			if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
				return optional.cast();
			} else
				return LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			inventory.save();
			return new CompoundTag();
		}
	}

	public static boolean swordstate;
	public static String TAG_SWORDSTATE = "swordstate";
	String name;
	Integer size;
	int range;
	int rare;
	ItemStack moduleStack;
	public String TAG_SELECTEDSTACK = "selectedstack";
	public int selectedModuleSlot;

	public String TAG_SELECTED = "selected";

	public ItemMechanGlove(Properties props, String name, Integer size, int range, int rarity) {
		super(props);
		this.name = name;
		this.size = size;
		this.rare = rarity;
		this.range = range;
	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		if (worldIn != null) {
			if (stack != null) {
				IItemHandler handler = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
						.orElseThrow(IllegalArgumentException::new);
				if (handler != null) {
					tooltip.add(Component.translatable(ChatFormatting.LIGHT_PURPLE + "Level: " + rare));
					tooltip.add(Component.translatable(ChatFormatting.GREEN + "Supported Modules: " + size));
					if (stack.hasTag()) {
						@SuppressWarnings("static-access")
						ItemStack selectedModuleStack = ItemStack
								.of((CompoundTag) stack.getTag().get(TAG_SELECTEDSTACK));
						if (selectedModuleStack.getItem() != Items.AIR) {
							tooltip.add(Component.translatable(ChatFormatting.GOLD + "Selected Module: "
									+ I18n.get(selectedModuleStack.getDescriptionId())));
						} else {
							tooltip.add(Component.translatable(ChatFormatting.GOLD + "No Module Selected"));
						}
						if (!stack.getTag().getBoolean(TAG_SWORDSTATE)) {
							tooltip.add(
									Component.translatable(ChatFormatting.DARK_GREEN + "Damage:" + getHitDamage(rare)));
						} else {
							tooltip.add(Component
									.translatable(ChatFormatting.DARK_GREEN + "Damage:" + getHitDamage(rare) * 3f));
						}
					} else {
						tooltip.add(Component.translatable(ChatFormatting.RED + "No Modules Inserted"));
					}
				}
			}
		}

	}

	public void clearOldModuleUse(Player playerIn, ItemStack itemStack, Level worldIn) {
		if (itemStack.getTag().getBoolean(TAG_SWORDSTATE)) {
			itemStack.getTag().putBoolean(TAG_SWORDSTATE, false);
		}
		if (playerIn.getInventory().armor.get(2).getItem() instanceof ItemSparkDirector) {
			ItemStack armor = playerIn.getInventory().armor.get(2);
			armor.getOrCreateTag().putFloat("heightmodifier", 0.1f);
		}
	}

	public float getHitDamage(int rareIn) {
		return rareIn;

	}

	public ItemStack getModuleStack() {
		return moduleStack;
	}

	public int getRange() {
		return range;
	}

	public int getSelectedModuleSlot() {
		return selectedModuleSlot;
	}

	public boolean getSwordState() {
		return swordstate;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000 / 4;
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		DamageSource mechanGloveSource = DamageSource.playerAttack((Player) attacker);
		if (stack.getTag() != null) {
			if (stack.getTag().get(TAG_SELECTEDSTACK) != null) {
				ItemStack moduleStack = ItemStack.of((CompoundTag) stack.getTag().get(TAG_SELECTEDSTACK));
				if (moduleStack.getItem() == ItemInit.mechan_module_blade.get()) {
					if (!stack.hasTag()) {
						stack.setTag(new CompoundTag());
						CompoundTag compound = stack.getTag();
						compound.putBoolean(TAG_SWORDSTATE, false);
					}
					CompoundTag compound = stack.getTag();
					if (!compound.getBoolean(TAG_SWORDSTATE)) {
						target.hurt(mechanGloveSource, getHitDamage(rare));
					} else {
						target.hurt(mechanGloveSource, getHitDamage(rare) * 3f);

					}
				}
			}
		}

		return super.hurtEnemy(stack, target, attacker);
	}

	@Nullable
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
		return new MechanGloveCaps(stack, size, nbt);
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return this.rare >= 4 ? true : false;

	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return repair.getItem() == ItemInit.auric_ingot.get() ? true : super.isValidRepairItem(toRepair, repair);
	}

	@SuppressWarnings("static-access")
	public void moduleUse(Player playerIn, InteractionHand handIn, ItemStack itemStack, Level worldIn) {
		// ICovenant coven =
		// playerIn.getCapability(CovenantProvider.COVEN_CAPA).orElseThrow(NullPointerException::new);

		if (itemStack.getTag() != null) {
			if (itemStack.getTag().get(TAG_SELECTEDSTACK) != null) {
				// if (coven.getDevotionByCoven(EnumCovenants.MACHINE) > 1) {

				ItemStack moduleStack = ItemStack.of((CompoundTag) itemStack.getTag().get(TAG_SELECTEDSTACK));
				if (moduleStack.getItem() instanceof IModuleUse) {
					if (((IModuleUse) moduleStack.getItem()).canUseModule(rare)) {
						((IModuleUse) moduleStack.getItem()).use(playerIn, handIn, itemStack, worldIn);
						itemStack.hurtAndBreak(((IModuleUse) moduleStack.getItem()).getDamageCost(), playerIn,
								(entity) -> {
									entity.broadcastBreakEvent(EquipmentSlot.MAINHAND);
								});

						if (worldIn.random.nextInt(101) < ((IModuleUse) moduleStack.getItem()).getAllegianceChance()) {
//						//		coven.setCovenDevotion(EnumCovenants.MACHINE, -1);
//								PacketHandler.CHANNELCOVENANT.send(
//										PacketDistributor.PLAYER.with(() -> (ServerPlayer) playerIn),
//										new CovenantPacketServer(coven.getDevotion()));
							playerIn.displayClientMessage(
									Component.translatable(
											ChatFormatting.RED + "Abuse of Power does not come without consequence"),
									true);
						}

					} else {
						playerIn.displayClientMessage(
								Component.translatable(ChatFormatting.GRAY + "Glove not capable of using module!"),
								true);
					}
				}
			} else {
				playerIn.displayClientMessage(
						Component.translatable(ChatFormatting.RED + "Your Devotion is not high enough"), true);
			}

		}
	}

//	}

	@SuppressWarnings("deprecation")
	@Override
	public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
		super.onUseTick(worldIn, livingEntityIn, stack, count);
		HitResult trace = livingEntityIn.pick(range, HLClientUtils.getPartialTicks(), true);
		switch (trace.getType()) {
		case ENTITY: {
		}
		case BLOCK: {
			if (stack.getTag() != null) {
				if (stack.getTag().get(TAG_SELECTEDSTACK) != null) {
					@SuppressWarnings("static-access")
					ItemStack moduleStack = ItemStack.of((CompoundTag) stack.getTag().get(TAG_SELECTEDSTACK));
					BlockPos hitPos = ((BlockHitResult) trace).getBlockPos();
					Block hitBlock = worldIn.getBlockState(hitPos).getBlock();
					if (moduleStack.getItem() == ItemInit.mechan_module_laser.get()) {

						ItemStack smeltStack = worldIn.getRecipeManager()
								.getRecipeFor(RecipeType.SMELTING, new SimpleContainer(new ItemStack(hitBlock)),
										worldIn)
								.map(SmeltingRecipe::getResultItem)
								.filter(itemStack -> !new ItemStack(hitBlock).isEmpty())
								.map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack,
										new ItemStack(hitBlock).getCount() * new ItemStack(hitBlock).getCount()))
								.orElse(new ItemStack(hitBlock));
						if (smeltStack.getItem() != new ItemStack(hitBlock).getItem()) {
							if (smeltStack.getItem() instanceof BlockItem) {
								BlockItem smeltBlock = (BlockItem) smeltStack.getItem();
								worldIn.destroyBlock(hitPos, false);
								worldIn.setBlockAndUpdate(hitPos, smeltBlock.getBlock().defaultBlockState());
							} else {
								if (worldIn.random.nextInt(20) % 3 == 0) {
									worldIn.addFreshEntity(new ItemEntity(worldIn, hitPos.getX(), hitPos.getY(),
											hitPos.getZ(), smeltStack));
								}
								worldIn.destroyBlock(hitPos, false);
							}
						} else {
							if (!hitBlock.defaultBlockState().isAir() && hitBlock != BlockInit.beyond_flames.get()
									&& hitBlock != Blocks.FIRE) {
								if (hitBlock.isFlammable(hitBlock.defaultBlockState(), worldIn,
										((BlockHitResult) trace).getBlockPos(),
										((BlockHitResult) trace).getDirection())) {
									BlockPos blockpos1 = hitPos.relative(((BlockHitResult) trace).getDirection());
									BlockState blockstate1 = BaseFireBlock.getState(worldIn, blockpos1);
									worldIn.setBlock(blockpos1, blockstate1, 11);

								}
							}
						}
					} else if (moduleStack.getItem() == ItemInit.wicked_module_laser.get()) {
						if (!hitBlock.defaultBlockState().isAir() && hitBlock != Blocks.FIRE
								&& hitBlock != BlockInit.beyond_flames.get()) {
							BlockPos blockpos1 = hitPos.relative(((BlockHitResult) trace).getDirection());
							BlockBeyondFlame blockstate1 = (BlockBeyondFlame) BlockInit.beyond_flames.get();
							BlockState state = blockstate1.getState(worldIn, blockpos1);
							worldIn.setBlock(blockpos1, state, 11);

						}
					}
				}
			}

		}

		default:
			break;
		}

	}

	public void setModuleStack(ItemStack moduleStackIn) {
		this.moduleStack = moduleStackIn;
	}

	public void setSelectedModuleSlot(int selectedModuleIn) {
		selectedModuleSlot = selectedModuleIn;
	}

	public void setSwordState(boolean swordstateIn) {
		swordstate = swordstateIn;
	}

	@Override
	public boolean shouldOverrideMultiplayerNbt() {
		return true;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		if (worldIn.isClientSide) {
			if (!playerIn.isShiftKeyDown()) {
				PacketHandler.MECHANGLOVE.sendToServer(new MechanGloveActionMessage());
			}
		}
		if (!worldIn.isClientSide) {
			if (playerIn.isShiftKeyDown()) {
				// open
				playerIn.openMenu(new MenuProvider() {
					@Nullable
					@Override
					public AbstractContainerMenu createMenu(int windowId, Inventory p_createMenu_2_,
							Player p_createMenu_3_) {
						return new ContainerMechanGlove(windowId, p_createMenu_3_.level,
								p_createMenu_3_.blockPosition(), p_createMenu_2_, p_createMenu_3_);
					}

					@Override
					public Component getDisplayName() {
						return playerIn.getItemInHand(handIn).getHoverName();
					}
				});

			}
		}
		return InteractionResultHolder.pass(playerIn.getItemInHand(handIn));
	}
}
