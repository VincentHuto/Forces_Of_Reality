package com.huto.forcesofreality.objects.items.tools;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemMechanModuleBase extends Item {
	public static String TAG_TIER = "tier";
	String useText;

	public ItemMechanModuleBase(Properties properties, String useTextIn) {
		super(properties);
		this.useText = useTextIn;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		// NBT TAG
		ItemStack stack = playerIn.getHeldItemMainhand();

		if (!stack.hasTag()) {
			stack.setTag(new CompoundNBT());
			CompoundNBT compound = stack.getTag();
			compound.putInt(TAG_TIER, 0);
		}
		CompoundNBT compound = stack.getTag();
		if (stack.getTag() != null) {
			int sel = compound.getInt(TAG_TIER);
			compound.putInt(TAG_TIER, sel + 1);
			playerIn.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 0.40f, 1F);
		}
		stack.setTag(compound);

		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));

	}

	@Nullable
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new StringTextComponent(TextFormatting.GOLD + "Use: " + useText));
		if (stack.getTag() != null) {
			tooltip.add(new StringTextComponent(TextFormatting.GOLD + "" + stack.getTag().getInt(TAG_TIER)));
		} else {
			tooltip.add(new StringTextComponent(TextFormatting.GOLD + "" + 0));
		}
	}

	@Override
	public boolean shouldSyncTag() {
		return true;
	}
}
