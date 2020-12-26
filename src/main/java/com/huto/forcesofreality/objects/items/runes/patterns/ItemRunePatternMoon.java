package com.huto.forcesofreality.objects.items.runes.patterns;

import com.huto.forcesofreality.gui.GuiRunePattern;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.recipes.ModChiselRecipes;
import com.huto.forcesofreality.recipes.RecipeChiselStation;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class ItemRunePatternMoon extends ItemRunePattern  {

	public ItemRunePatternMoon(Properties prop, String textIn) {
		super(prop, textIn);
	}

	@Override
	public Rarity getRarity(ItemStack par1ItemStack) {
		return Rarity.COMMON;
	}

	@Override
	public RecipeChiselStation getRecipe() {
		return ModChiselRecipes.recipeMoon;
	}

	@Override
	public GuiRunePattern getPatternGui() {
		return new GuiRunePattern(new ItemStack(ItemInit.rune_moon.get()), ModChiselRecipes.recipeMoon, text);
	}
}