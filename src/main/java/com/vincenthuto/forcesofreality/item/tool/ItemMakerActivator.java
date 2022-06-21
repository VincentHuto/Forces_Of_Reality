package com.vincenthuto.forcesofreality.item.tool;

import com.vincenthuto.forcesofreality.block.util.IActivatable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

public class ItemMakerActivator extends Item {

	public ItemMakerActivator(Properties prop) {
		super(prop);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		ItemStack stack = context.getPlayer().getItemInHand(context.getHand());
		Block block = context.getLevel().getBlockState(context.getClickedPos()).getBlock();
		BlockPos pos = context.getClickedPos();
		if (block instanceof IActivatable) {
			boolean acti;
			if (context.getLevel().isClientSide) {
				context.getPlayer().swing(context.getHand());
				context.getPlayer().playSound(SoundEvents.ANVIL_USE, 0.11F, 1F);
			}
			acti = true;

			acti = ((IActivatable) block).onUsedByActivator(context.getPlayer(), stack, context.getLevel(), pos,
					context.getClickedFace());
			if (acti && context.getLevel().isClientSide)
				context.getPlayer().swing(context.getHand());
			return acti ? InteractionResult.SUCCESS : InteractionResult.FAIL;
		}
		return InteractionResult.PASS;
	}

}
