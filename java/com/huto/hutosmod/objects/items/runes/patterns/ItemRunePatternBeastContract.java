package com.huto.hutosmod.objects.items.runes.patterns;

import com.huto.hutosmod.gui.GuiRunePattern;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.recipes.ModChiselRecipes;
import com.huto.hutosmod.recipes.RecipeChiselStation;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class ItemRunePatternBeastContract extends ItemRunePattern  {

	public ItemRunePatternBeastContract(Properties prop, String textIn) {
		super(prop, textIn);
	}

	@Override
	public Rarity getRarity(ItemStack par1ItemStack) {
		return Rarity.COMMON;
	}

	@Override
	public RecipeChiselStation getRecipe() {
		return ModChiselRecipes.recipeBeastContract;
	}

	@Override
	public GuiRunePattern getPatternGui() {
		return new GuiRunePattern(new ItemStack(ItemInit.rune_beast_c.get()), ModChiselRecipes.recipeBeastContract,
				text);
	}

}