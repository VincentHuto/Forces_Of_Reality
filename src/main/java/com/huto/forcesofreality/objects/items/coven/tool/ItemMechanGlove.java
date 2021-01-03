package com.huto.forcesofreality.objects.items.coven.tool;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.containers.ContainerMechanGlove;
import com.huto.forcesofreality.containers.MechanGloveItemHandler;
import com.huto.forcesofreality.entities.projectiles.EntityDreadRocket;
import com.huto.forcesofreality.entities.projectiles.EntityDreadRocketDirected;
import com.huto.forcesofreality.entities.projectiles.EntityShortCircuit;
import com.huto.forcesofreality.font.ModTextFormatting;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.objects.items.armor.ItemSparkDirector;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
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

public class ItemMechanGlove extends Item {
	String name;
	Integer size;
	Rarity rare;
	ItemStack moduleStack;
	public String TAG_SELECTEDSTACK = "selectedstack";
	public int selectedModuleSlot;
	public String TAG_SELECTED = "selected";
	public static boolean swordstate;
	public static String TAG_SWORDSTATE = "swordstate";

	public ItemMechanGlove(Properties props, String name, Integer size, Rarity rarity) {
		super(props);
		this.name = name;
		this.size = size;
		this.rare = rarity;
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return this.rare == ModTextFormatting.AURIC ? true : false;

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
		if (handIn == Hand.MAIN_HAND) {
			if (worldIn.isRemote) {
				if (!playerIn.isSneaking()) {
					ForcesOfReality.proxy.openMechanGui();
					playerIn.playSound(SoundEvents.ITEM_BOOK_PAGE_TURN, 0.40f, 1F);
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
							return new ContainerMechanGlove(windowId, p_createMenu_3_.world,
									p_createMenu_3_.getPosition(), p_createMenu_2_, p_createMenu_3_);
						}
					});

				}
			}
		}

		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));

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
	public void moduleUse(PlayerEntity playerIn, ItemStack itemStack, World worldIn) {
		if (itemStack.getTag() != null) {
			if (itemStack.getTag().get(TAG_SELECTEDSTACK) != null) {
				ItemStack moduleStack = itemStack.read((CompoundNBT) itemStack.getTag().get(TAG_SELECTEDSTACK));
				if (moduleStack.getItem() == ItemInit.mechan_module_salvo.get()) {
					EntityDreadRocket[] missArray = new EntityDreadRocket[5];
					for (int i = 0; i < 5; i++) {
						missArray[i] = new EntityDreadRocket((PlayerEntity) playerIn, false);
						missArray[i].setPosition(playerIn.getPosX() + ((Math.random() - 0.5) * 3.5),
								playerIn.getPosY() + 0.3, playerIn.getPosZ() + ((Math.random() - 0.5) * 3.5));
						worldIn.addEntity(missArray[i]);
					}
				} else if (moduleStack.getItem() == ItemInit.mechan_module_rocket.get()) {
					EntityDreadRocketDirected miss = new EntityDreadRocketDirected((PlayerEntity) playerIn, false);
					miss.setPosition(playerIn.getPosX() - 0.5, playerIn.getPosY() + 0.6, playerIn.getPosZ() - 0.5);
					miss.setDirectionMotion(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.0F, 1.0F);
					worldIn.addEntity(miss);
				} else if (moduleStack.getItem() == ItemInit.mechan_module_shortcircuit.get()) {
					EntityShortCircuit miss = new EntityShortCircuit((PlayerEntity) playerIn, true);
					miss.setPosition(playerIn.getPosX() - 0.5, playerIn.getPosY() + 0.6, playerIn.getPosZ() - 0.5);
					miss.setDirectionMotion(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 5.0F, 1.0F);
					worldIn.addEntity(miss);
				} else if (moduleStack.getItem() == ItemInit.mechan_module_laser.get()) {
					// TODO "This is where id put my laser, IF I HAD ONE"
				} else if (moduleStack.getItem() == ItemInit.mechan_module_thruster.get()) {
					if (playerIn.inventory.armorInventory.get(2).getItem() instanceof ItemSparkDirector	) {
						ItemStack armor = playerIn.inventory.armorInventory.get(2);
						if (armor.getOrCreateTag().getFloat("heightmodifier") == 0.1f) {
							armor.getOrCreateTag().putFloat("heightmodifier", 0.2f);
						} else {
							armor.getOrCreateTag().putFloat("heightmodifier", 0.1f);
						}
					}
				} else if (moduleStack.getItem() == ItemInit.mechan_module_blade.get()) {
					if (!itemStack.getTag().getBoolean(TAG_SWORDSTATE)) {
						itemStack.getTag().putBoolean(TAG_SWORDSTATE, true);
					} else {
						itemStack.getTag().putBoolean(TAG_SWORDSTATE, false);
					}

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
