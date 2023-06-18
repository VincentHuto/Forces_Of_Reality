package com.vincenthuto.forcesofreality.common.item.coven.tool;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ItemMachinaCage extends Item {
	public static String TAG_TIER = "tier";

	public ItemMachinaCage(Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		if (stack.getTag() != null) {
			tooltip.add(
					Component.translatable(ChatFormatting.GOLD + "Soul Strength: " + stack.getTag().getInt(TAG_TIER)));
		} else {
			tooltip.add(Component.translatable(ChatFormatting.GOLD + "Soul Strength: " + 0));
		}
	}

	@Override
	public boolean shouldOverrideMultiplayerNbt() {
		return true;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {

		return InteractionResultHolder.success(playerIn.getItemInHand(handIn));

	}
}
