package com.huto.forcesofreality.item.tool.coven.module;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ItemMechanModuleBase extends Item implements IModuleUse {
	public static String TAG_TIER = "tier";
	String useText;
	int tier;

	public ItemMechanModuleBase(Properties properties, int tier, String useTextIn) {
		super(properties);
		this.tier = tier;
		this.useText = useTextIn;
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
	public int getTier() {
		return tier;
	}

	@Override
	public InteractionResultHolder<ItemStack> onItemRightClick(Level worldIn, Player playerIn, InteractionHand handIn) {
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
		tooltip.add(new StringTextComponent(TextFormatting.GOLD + "Level: " + tier));
}

	@Override
	public boolean shouldSyncTag() {
		return true;
	}

	@Override
	public int getDamageCost() {
		return 0;
	}

	@Override
	public int getAllegianceChance() {
		return 0;
	}

	@Override
	public void use(PlayerEntity playerIn, Hand handIn, ItemStack itemStack, World worldIn) {
	}
}
