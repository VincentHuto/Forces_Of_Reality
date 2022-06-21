package com.vincenthuto.forcesofreality.item.tool.coven.module;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ItemMechanModuleBase extends Item implements IModuleUse {
	public static String TAG_TIER = "tier";
	String useText;
	int tier;

	public ItemMechanModuleBase(Properties properties, int tier, String useTextIn) {
		super(properties);
		this.tier = tier;
		this.useText = useTextIn;
	}

	@Nullable
	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		tooltip.add(Component.translatable(ChatFormatting.GOLD + "Use: " + useText));
		tooltip.add(Component.translatable(ChatFormatting.GOLD + "Level: " + tier));
	}

	@Override
	public boolean canUseModule(int rarity) {
		if (rarity >= tier) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getAllegianceChance() {
		return 0;
	}

	@Override
	public int getDamageCost() {
		return 0;
	}

	@Override
	public int getTier() {
		return tier;
	}

	@Override
	public boolean shouldOverrideMultiplayerNbt() {
		return true;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		// NBT TAG
		ItemStack stack = playerIn.getMainHandItem();

		if (!stack.hasTag()) {
			stack.setTag(new CompoundTag());
			CompoundTag compound = stack.getTag();
			compound.putInt(TAG_TIER, 0);
		}
		CompoundTag compound = stack.getTag();
		if (stack.getTag() != null) {
			int sel = compound.getInt(TAG_TIER);
			compound.putInt(TAG_TIER, sel + 1);
			playerIn.playSound(SoundEvents.BEACON_ACTIVATE, 0.40f, 1F);
		}
		stack.setTag(compound);

		return InteractionResultHolder.success(playerIn.getItemInHand(handIn));

	}

	@Override
	public void use(Player playerIn, InteractionHand handIn, ItemStack itemStack, Level worldIn) {
	}
}
