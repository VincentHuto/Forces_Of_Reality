package com.huto.forcesofreality.objects.items.coven.tool.modules;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public interface IModuleUse {

	int getDamageCost();

	int getAllegianceChance();

	public void use(PlayerEntity playerIn,Hand handIn, ItemStack itemStack, World worldIn);

}
