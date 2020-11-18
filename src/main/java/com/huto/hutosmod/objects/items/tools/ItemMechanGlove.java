package com.huto.hutosmod.objects.items.tools;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.containers.ContainerMechanGlove;
import com.huto.hutosmod.containers.MechanGloveItemHandler;
import com.huto.hutosmod.entities.projectiles.EntityCorruptNote;
import com.huto.hutosmod.entities.projectiles.EntityDreadRocket;
import com.huto.hutosmod.events.ClientEventSubscriber;
import com.huto.hutosmod.font.ModTextFormatting;
import com.huto.hutosmod.gui.pages.GuiButtonTextured;
import com.huto.hutosmod.init.EntityInit;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.PacketUpdateMechanModule;
import com.huto.hutosmod.sounds.SoundHandler;

import net.java.games.input.Keyboard;
import net.minecraft.client.KeyboardListener;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.ActionResult;
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
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ItemMechanGlove extends Item {
	String name;
	Integer size;
	Rarity rare;
	ItemStack moduleStack;
	public static String TAG_SELECTEDSTACK = "selectedstack";
	public static int selectedModuleSlot;
	public static String TAG_SELECTED = "selected";

	public ItemMechanGlove(Properties props, String name, Integer size, Rarity rarity) {
		super(props);
		this.name = name;
		this.size = size;
		this.rare = rarity;
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return this.rare == Rarity.EPIC ? true : false;

	}

	@Override
	public boolean shouldSyncTag() {
		return true;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (worldIn.isRemote) {
			if (!playerIn.isSneaking()) {
				HutosMod.proxy.openMechanGui();
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
						return new ContainerMechanGlove(windowId, p_createMenu_3_.world, p_createMenu_3_.getPosition(),
								p_createMenu_2_, p_createMenu_3_);
					}
				});

			}
		}

		// NBT TAG
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
					tooltip.add(new StringTextComponent(TextFormatting.GREEN + "Size: " + size));
					if (stack.hasTag()) {
						ItemStack selectedModuleStack = handler.getStackInSlot(stack.getTag().getInt(TAG_SELECTED));
						tooltip.add(new TranslationTextComponent(
								TextFormatting.GOLD + "Selected Module: " + stack.getTag().getInt(TAG_SELECTED)));
						handler.getStackInSlot(stack.getTag().getInt(TAG_SELECTED));
						tooltip.add(new TranslationTextComponent(TextFormatting.GOLD + "Selected Module: "
								+ I18n.format(selectedModuleStack.getTranslationKey())));
						tooltip.add(new TranslationTextComponent(
								TextFormatting.GOLD + "Module: " + stack.getTag().get(TAG_SELECTEDSTACK)));

					}
				}
			}
		}

	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
		if (ClientEventSubscriber.keyBinds.get(0).isPressed()) {
			if (this.getModuleStack() != null) {
				if (this.getModuleStack().getItem() == ItemInit.mechan_module_salvo.get()) {
					EntityCorruptNote[] missArray = new EntityCorruptNote[5];
					for (int i = 0; i < 5; i++) {
						missArray[i] = new EntityCorruptNote((PlayerEntity) entityIn, false);
						missArray[i].setPosition(entityIn.getPosX() + ((Math.random() - 0.5) * 3.5),
								entityIn.getPosY() + 0.8, entityIn.getPosZ() + ((Math.random() - 0.5) * 3.5));
						worldIn.addEntity(missArray[i]);

					}

				} else if (this.getModuleStack().getItem() == ItemInit.mechan_module_rocket.get()) {
					EntityDreadRocket miss = new EntityDreadRocket((PlayerEntity) entityIn, false);
					miss.setPosition(entityIn.getPosX() + ((Math.random() - 0.5) * 3.5), entityIn.getPosY() + 0.8,
							entityIn.getPosZ() + ((Math.random() - 0.5) * 3.5));
					worldIn.addEntity(miss);
				}
			}

		}
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
