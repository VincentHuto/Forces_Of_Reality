package com.huto.forcesofreality.item.tool;

import com.huto.forcesofreality.block.util.IActivatable;

import net.minecraft.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;

import net.minecraft.world.item.Item.Properties;

public class ItemMakerActivator extends Item {

	public ItemMakerActivator(Properties prop) {
		super(prop);
	}

	@Override
	public InteractionResult onItemUse(UseOnContext context) {
		ItemStack stack = context.getPlayer().getHeldItem(context.getHand());
		Block block = context.getWorld().getBlockState(context.getPos()).getBlock();
		BlockPos pos = context.getPos();
		if (block instanceof IActivatable) {
			boolean acti;
			if (context.getWorld().isRemote) {
				context.getPlayer().swingArm(context.getHand());
				context.getPlayer().playSound(SoundEvents.BLOCK_ANVIL_USE, 0.11F, 1F);
			}
			acti = true;

			acti = ((IActivatable) block).onUsedByActivator(context.getPlayer(), stack, context.getWorld(), pos,
					context.getFace());
			if (acti && context.getWorld().isRemote)
				context.getPlayer().swingArm(context.getHand());
			return acti ? ActionResultType.SUCCESS : ActionResultType.FAIL;
		}
		return ActionResultType.PASS;
	}

}
