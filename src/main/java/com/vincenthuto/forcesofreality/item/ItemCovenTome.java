package com.vincenthuto.forcesofreality.item;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.hutoslib.common.item.ItemGuideBook;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemCovenTome extends ItemGuideBook {
	public ItemCovenTome(Properties prop, ResourceLocation loc) {
		super(prop, loc);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level lvl, Player p_41433_, InteractionHand p_41434_) {
		if (lvl.isClientSide()) {
			ForcesOfReality.proxy.openGuideGui();
		}
		return super.use(lvl, p_41433_, p_41434_);
	}
}
