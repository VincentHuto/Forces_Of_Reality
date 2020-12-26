package com.huto.forcesofreality.objects.items.runes.patterns;

import com.huto.forcesofreality.gui.GuiRunePattern;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.recipes.ModChiselRecipes;
import com.huto.forcesofreality.recipes.RecipeChiselStation;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class ItemRunePatternImpurityContract extends ItemRunePattern  {

	public ItemRunePatternImpurityContract(Properties prop, String textIn) {
		super(prop, textIn);
	}

	@Override
	public Rarity getRarity(ItemStack par1ItemStack) {
		return Rarity.COMMON;
	}

	@Override
	public RecipeChiselStation getRecipe() {
		return ModChiselRecipes.recipeImpurityContract;
	}

	@Override
	public GuiRunePattern getPatternGui() {
		return new GuiRunePattern(new ItemStack(ItemInit.rune_impurity_c.get()),
				ModChiselRecipes.recipeImpurityContract, text);
	}
}