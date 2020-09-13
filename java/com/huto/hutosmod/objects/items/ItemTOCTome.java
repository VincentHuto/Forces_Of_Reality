package com.huto.hutosmod.objects.items;


import com.huto.hutosmod.gui.pages.EnumTomeCatagories;
import com.huto.hutosmod.gui.pages.GuiTomePageTOC;
import com.huto.hutosmod.gui.pages.GuiTomeTitle;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemTOCTome extends Item {

	public ItemTOCTome(Properties prop) {
		super(prop);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		if (worldIn.isRemote) {
			Minecraft.getInstance().displayGuiScreen(new GuiTomePageTOC(EnumTomeCatagories.INTRO, stack));
		}
		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}

	@Override
	public Rarity getRarity(ItemStack par1ItemStack) {
		return Rarity.UNCOMMON;
	}

}
