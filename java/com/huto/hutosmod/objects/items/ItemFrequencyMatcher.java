package com.huto.hutosmod.objects.items;

import java.util.List;

import com.huto.hutosmod.objects.tileenties.TileEntityAbsorber;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemFrequencyMatcher extends Item {

	public static BlockPos linkedPos;
	public static String TAG_POS = "LinkedPos";
	public static String TAG_POS_NAME = "PosName";

	public ItemFrequencyMatcher(Properties prop) {
		super(prop);

	}

	public static BlockPos getLinkedPos() {
		return linkedPos;
	}

	public static void setLinkedPos(BlockPos linkedPos) {
		ItemFrequencyMatcher.linkedPos = linkedPos;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItemMainhand();
		CompoundNBT compound = stack.getTag();

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext ctx) {
		PlayerEntity player = ctx.getPlayer();
		World world = ctx.getWorld();
		ItemStack stack = ctx.getItem();
		BlockPos blockPos = ctx.getPos();
		if (!stack.hasTag()) {
			stack.setTag(new CompoundNBT());
		}
		CompoundNBT compound = stack.getTag();
		if (!player.isSneaking() && !(world.getTileEntity(blockPos) instanceof TileEntityAbsorber)) {
			player.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 0.40f, 1F);
			CompoundNBT posCompound = NBTUtil.writeBlockPos(blockPos);
			compound.putString(TAG_POS_NAME, I18n.format(world.getBlockState(blockPos).getBlock().getTranslationKey()));
			compound.put(TAG_POS, posCompound);
			stack.setTag(compound);
		}

		if (!player.isSneaking() && world.getTileEntity(blockPos) instanceof TileEntityAbsorber) {
			TileEntityAbsorber te = (TileEntityAbsorber) world.getTileEntity(blockPos);
			player.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE, 0.40f, 1F);
			if (stack.getTag().get(TAG_POS) != null) {
				BlockPos newPos = NBTUtil.readBlockPos(stack.getTag().getCompound(TAG_POS));
				te.addToLinkedBlocks(newPos);
				te.sendUpdates();
			}

		}
		return ActionResultType.SUCCESS;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
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
		}
	}
}
