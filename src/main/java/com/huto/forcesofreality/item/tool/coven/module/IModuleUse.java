package com.huto.forcesofreality.item.tool.coven.module;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;

public interface IModuleUse {

	int getTier();

	int getDamageCost();

	int getAllegianceChance();

	public boolean canUseModule(int rarity);

	public void use(Player playerIn, InteractionHand handIn, ItemStack itemStack, Level worldIn);

}
