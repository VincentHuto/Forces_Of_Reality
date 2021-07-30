package com.huto.forcesofreality.item.coven.tool;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ItemMachinaCage extends Item {
	public static String TAG_TIER = "tier";

	public ItemMachinaCage(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResultHolder<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {

		return InteractionResultHolder.resultSuccess(playerIn.getHeldItem(handIn));

	}

	@Nullable
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if (stack.getTag() != null) {
			tooltip.add(
					new StringTextComponent(TextFormatting.GOLD + "Soul Strength: " + stack.getTag().getInt(TAG_TIER)));
		} else {
			tooltip.add(new StringTextComponent(TextFormatting.GOLD + "Soul Strength: " + 0));
		}
	}

	@Override
	public boolean shouldSyncTag() {
		return true;
	}
}
