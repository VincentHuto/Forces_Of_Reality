package com.huto.hutosmod.objects.items;

import com.huto.hutosmod.objects.blocks.IActivatable;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;

public class ItemMakerActivator extends Item {

	public ItemMakerActivator(Properties prop) {
		super(prop);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		ItemStack stack = context.getPlayer().getHeldItem(context.getHand());
		Block block = context.getWorld().getBlockState(context.getPos()).getBlock();
		BlockPos pos = context.getPos();
		if (block instanceof IActivatable) {
			boolean wanded;
			if (context.getWorld().isRemote) {
				context.getPlayer().swingArm(context.getHand());
				context.getPlayer().playSound(SoundEvents.BLOCK_ANVIL_USE, 0.11F, 1F);
			}
			wanded = true;

			wanded = ((IActivatable) block).onUsedByActivator(context.getPlayer(), stack, context.getWorld(), pos,
					context.getFace());
			if (wanded && context.getWorld().isRemote)
				context.getPlayer().swingArm(context.getHand());
			return wanded ? ActionResultType.SUCCESS : ActionResultType.FAIL;
		}
		return ActionResultType.PASS;
	}

}
