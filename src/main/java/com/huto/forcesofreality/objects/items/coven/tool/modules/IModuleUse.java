package com.huto.forcesofreality.objects.items.coven.tool.modules;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public interface IModuleUse {

	int getTier();

	int getDamageCost();

	int getAllegianceChance();

	public boolean canUseModule(int rarity);

	public void use(PlayerEntity playerIn, Hand handIn, ItemStack itemStack, World worldIn);

}
