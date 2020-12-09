package com.huto.hutosmod.objects.items;

import java.util.List;

import com.huto.hutosmod.dimension.DimensionalPosition;
import com.huto.hutosmod.objects.blocks.BlockTeleporter;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemHarmonicImprint extends Item {

	public static BlockPos linkedPos;
	public static String TAG_POS = "LinkedPos";
	public static String TAG_POS_NAME = "PosName";
	public static boolean state;
	public static String TAG_STATE = "state";

	public ItemHarmonicImprint(Properties prop) {
		super(prop);

	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean stateIn) {
		state = stateIn;
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		CompoundNBT compound = stack.getOrCreateTag();
		return compound.get(TAG_POS) != null;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new TranslationTextComponent("Used to save positional data for warping"));
		if (stack.hasTag()) {
			if (stack.getTag().get(TAG_POS) != null) {
				tooltip.add(
						new TranslationTextComponent("Selected Block " + stack.getTag().get(TAG_POS_NAME).toString())
								.mergeStyle(TextFormatting.GOLD));
				tooltip.add(new TranslationTextComponent("Selected Coords " + stack.getTag().get(TAG_POS).toString())
						.mergeStyle(TextFormatting.GOLD));
			} else {
				tooltip.add(new TranslationTextComponent("NO POS SAVED").mergeStyle(TextFormatting.GOLD));
			}
			if (stack.getTag().getBoolean(TAG_STATE)) {
				tooltip.add(new TranslationTextComponent("State: Link").mergeStyle(TextFormatting.BLUE));
			} else {
				tooltip.add(new TranslationTextComponent("State: Unlink").mergeStyle(TextFormatting.RED));
			}
		}
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		// TODO Auto-generated method stub
		super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext ctx) {

		PlayerEntity player = ctx.getPlayer();
		World world = ctx.getWorld();
		ItemStack stack = ctx.getItem();
		BlockPos blockPos = ctx.getPos();
		CompoundNBT compound = stack.getOrCreateTag();
		ResourceLocation dim = player.world.getDimensionKey().getLocation();
	

		if (!world.isRemote && !(world.getBlockState(blockPos).getBlock() instanceof BlockTeleporter)) {
			if (!player.isSneaking()) {
				DimensionalPosition dp = new DimensionalPosition(dim, blockPos);
				CompoundNBT dimNbt = dp.serializeNBT();
				player.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 0.40f, 1F);
				compound.putString(TAG_POS_NAME,
						I18n.format(world.getBlockState(blockPos).getBlock().getTranslationKey()));
				compound.put(TAG_POS, dimNbt);
				stack.setTag(compound);
			}

		}

		return ActionResultType.SUCCESS;

	}
}