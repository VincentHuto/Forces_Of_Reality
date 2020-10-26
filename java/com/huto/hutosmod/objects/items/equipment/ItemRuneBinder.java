package com.huto.hutosmod.objects.items.equipment;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.HutosMod.HutosModItemGroup;
import com.huto.hutosmod.containers.ContainerRuneBinder;
import com.huto.hutosmod.containers.RuneBinderItemHandler;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.ToggleMessageMessage;
import com.huto.hutosmod.objects.items.runes.patterns.ItemRunePattern;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

public class ItemRuneBinder extends Item {
	public ItemRuneBinder(String name, Integer size, Rarity rarity) {
		super(new Item.Properties().maxStackSize(1).group(HutosModItemGroup.instance));
		this.name = name;
		this.size = size;
		this.rarity = rarity;
	}

	String name;
	Integer size;
	Rarity rarity;

	@Override
	public Rarity getRarity(ItemStack stack) {
		return rarity;
	}

	public ItemRuneBinder setName() {
		setRegistryName(HutosMod.MOD_ID, name);

		return this;
	}

	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return false;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		if (!worldIn.isRemote) {
			if (playerIn.isSneaking()) {
				/*
				 * playerIn.openContainer(new INamedContainerProvider() {
				 * 
				 * @Override public ITextComponent getDisplayName() { return new
				 * StringTextComponent("Rune Binder Filter"); }
				 * 
				 * @Nullable
				 * 
				 * @Override public Container createMenu(int p_createMenu_1_, PlayerInventory
				 * p_createMenu_2_, PlayerEntity p_createMenu_3_) { return new
				 * ContainerFilter(p_createMenu_1_, p_createMenu_3_.world,
				 * p_createMenu_3_.getPosition(), p_createMenu_2_, p_createMenu_3_); } });
				 */
			} else {
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
						return new ContainerRuneBinder(windowId, p_createMenu_3_.world, p_createMenu_3_.getPosition(),
								p_createMenu_2_, p_createMenu_3_);
					}
				});
			}
		}
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}

	@Nullable
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
		return new RuneBinderCaps(stack, size, nbt);
	}

	@SuppressWarnings("rawtypes")
	class RuneBinderCaps implements ICapabilitySerializable {
		public RuneBinderCaps(ItemStack stack, int size, CompoundNBT nbtIn) {
			itemStack = stack;
			this.size = size;
			inventory = new RuneBinderItemHandler(itemStack, size);
			optional = LazyOptional.of(() -> inventory);
		}

		@SuppressWarnings("unused")
		private int size;
		private ItemStack itemStack;
		private RuneBinderItemHandler inventory;
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

	public void togglePickup(PlayerEntity playerEntity, ItemStack stack) {
		CompoundNBT nbt = stack.getOrCreateTag();

		boolean Pickup = !nbt.getBoolean("Pickup");

		nbt.putBoolean("Pickup", Pickup);
		if (playerEntity instanceof ServerPlayerEntity)
			PacketHandler.RUNEBINDER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) playerEntity),
					new ToggleMessageMessage(Pickup));
		else
			playerEntity.sendStatusMessage(new StringTextComponent(
					I18n.format(Pickup ? "hutosmod.autopickupenabled" : "hutosmod.autopickupdisabled")), true);

	}

	public boolean filterItem(ItemStack item, ItemStack packItem) {
		return item.getItem() instanceof ItemRunePattern ? true : false;

	}

	public boolean pickupEvent(EntityItemPickupEvent event, ItemStack stack) {
		CompoundNBT nbt = stack.getTag();
		if (nbt == null)
			return false;

		if (!nbt.getBoolean("Pickup"))
			return false;

		LazyOptional<IItemHandler> stupidIdiot = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
		if (!stupidIdiot.isPresent())
			return false;

		IItemHandler handler = stupidIdiot.orElse(null);
		if (handler == null || !(handler instanceof RuneBinderItemHandler))
			return false;
		((RuneBinderItemHandler) handler).loadIfNotLoaded();

		if (!filterItem(event.getItem().getItem(), stack))
			return false;

		ItemStack pickedUp = event.getItem().getItem();
		for (int i = 0; i < handler.getSlots(); i++) {
			ItemStack slot = handler.getStackInSlot(i);
			if (slot.isEmpty() || (ItemHandlerHelper.canItemStacksStack(slot, pickedUp) && slot.getCount() < 1
					&& slot.getCount() < handler.getSlotLimit(i))) {
				int remainder = handler.insertItem(i, pickedUp.copy(), false).getCount();
				pickedUp.setCount(remainder);
				if (remainder == 0)
					break;
			}
		}
		return pickedUp.isEmpty();
	}

	private boolean hasTranslation(String key) {
		return !I18n.format(key).equals(key);
	}

	private String fallbackString(String key, String fallback) {
		String tmp = I18n.format(key);
		return tmp.equals(key) ? fallback : tmp;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		String translationKey = getTranslationKey();

		boolean pickupEnabled = stack.getOrCreateTag().getBoolean("Pickup");
		if (pickupEnabled)
			tooltip.add(new StringTextComponent(I18n.format("hutosmod.autopickupenabled")));
		else
			tooltip.add(new StringTextComponent(I18n.format("hutosmod.autopickupdisabled")));

		if (Screen.hasShiftDown()) {
			tooltip.add(new StringTextComponent(I18n.format(translationKey + ".info")));
			if (hasTranslation(translationKey + ".info2"))
				tooltip.add(new StringTextComponent(I18n.format(translationKey + ".info2")));
			if (hasTranslation(translationKey + ".info3"))
				tooltip.add(new StringTextComponent(I18n.format(translationKey + ".info3")));
		} else {
			tooltip.add(new StringTextComponent(fallbackString("hutosmod.shift", "Press <§6§oShift§r> for info.")));
		}
	}
}