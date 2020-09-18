package com.huto.hutosmod.objects.items;

import java.util.List;

import com.huto.hutosmod.capabilities.mindrunes.RuneType;
import com.huto.hutosmod.capabilities.mindrunes.IRune;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemRune extends Item implements IRune{
	public int level = 1;
	public String TAG_LEVEL = "level";

	public ItemRune(Properties properties) {
		super(properties);
		properties.maxStackSize(1);

	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
		/*
		 * if (!stack.hasTag()) { stack.setTag(new CompoundNBT()); CompoundNBT compound
		 * = stack.getTag(); compound.putInt(TAG_LEVEL, level); }
		 */
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItemMainhand();
		if (!stack.hasTag()) {
			stack.setTag(new CompoundNBT());
			CompoundNBT compound = stack.getTag();
			compound.putInt(TAG_LEVEL, level);
		}
		CompoundNBT compound = stack.getTag();
		compound.putInt(TAG_LEVEL, this.getLevel());

		playerIn.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 0.40f, 1F);
		compound.putInt(TAG_LEVEL, level++);
		stack.setTag(compound);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		if (stack.hasTag()) {
			tooltip.add(new TranslationTextComponent("Form: " + stack.getTag().getInt(TAG_LEVEL))
					.mergeStyle(TextFormatting.BLUE));
		}
	}

	@Override
	public RuneType getBaubleType() {
		return RuneType.TRINKET;
	}

}
