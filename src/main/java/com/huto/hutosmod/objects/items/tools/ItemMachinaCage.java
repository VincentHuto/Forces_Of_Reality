package com.huto.hutosmod.objects.items.tools;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemMachinaCage extends Item {
	public static String TAG_TIER = "tier";

	public ItemMachinaCage(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));

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
