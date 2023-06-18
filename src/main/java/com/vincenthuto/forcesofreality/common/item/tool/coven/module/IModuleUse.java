package com.vincenthuto.forcesofreality.common.item.tool.coven.module;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public interface IModuleUse {

	public boolean canUseModule(int rarity);

	int getAllegianceChance();

	int getDamageCost();

	int getTier();

	public void use(Player playerIn, InteractionHand handIn, ItemStack itemStack, Level worldIn);

}
