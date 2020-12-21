package com.huto.forces_of_reality.objects.items.runes.patterns;

import com.huto.forces_of_reality.gui.GuiRunePattern;
import com.huto.forces_of_reality.init.ItemInit;
import com.huto.forces_of_reality.recipes.ModChiselRecipes;
import com.huto.forces_of_reality.recipes.RecipeChiselStation;

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