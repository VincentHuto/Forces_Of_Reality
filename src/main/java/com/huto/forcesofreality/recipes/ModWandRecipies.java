package com.huto.forcesofreality.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.huto.forcesofreality.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class ModWandRecipies {
	public static final List<RecipeWandMaker> wandMakerRecipies = new ArrayList<>();

	public static RecipeWandMaker recipeManaConsumption, recipeManaAbsorbtion;

	public static void init() {

		recipeManaConsumption = registerRecipe(new ResourceLocation("wand_consume_evibes"),
				new ItemStack(ItemInit.wand_consume_vibes.get(), 1), 50,
				Ingredient.fromItems(ItemInit.channeling_ingot.get()),
				Ingredient.fromItems(ItemInit.channeling_rod.get()), Ingredient.fromItems(ItemInit.null_crystal.get()));
		recipeManaAbsorbtion = registerRecipe(new ResourceLocation("wand_gain_vibes"),
				new ItemStack(ItemInit.wand_gain_vibes.get(), 1), 0,
				Ingredient.fromItems(ItemInit.channeling_ingot.get()),
				Ingredient.fromItems(ItemInit.channeling_rod.get()),
				Ingredient.fromItems(ItemInit.somnolent_crystal.get()));

	}

	public static RecipeWandMaker registerRecipe(ResourceLocation rl, ItemStack output, float vibes,
			Ingredient... inputs) {
		Preconditions.checkArgument(inputs.length <= 4);
		RecipeWandMaker recipe = new RecipeWandMaker(rl, output, vibes, inputs);
		wandMakerRecipies.add(recipe);
		return recipe;
	}

}
