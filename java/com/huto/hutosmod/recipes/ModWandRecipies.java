package com.huto.hutosmod.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.huto.hutosmod.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class ModWandRecipies {
	public static final List<RecipeWandMaker> wandMakerRecipies = new ArrayList<>();

	public static RecipeWandMaker recipeManaConsumption,recipeManaAbsorbtion,test;

	public static void init() {

		recipeManaConsumption = registerRecipe(new ResourceLocation("wand_consume_vibes"),
				new ItemStack(ItemInit.wand_consume_vibes.get(), 1), 50,
				Ingredient.fromItems(ItemInit.channeling_ingot.get()),
				Ingredient.fromItems(ItemInit.channeling_rod.get()), Ingredient.fromItems(ItemInit.null_crystal.get()));
		recipeManaAbsorbtion = registerRecipe(new ResourceLocation("wand_gain_vibes"),
				new ItemStack(ItemInit.wand_gain_vibes.get(), 1), 0,
				Ingredient.fromItems(ItemInit.channeling_ingot.get()),
				Ingredient.fromItems(ItemInit.channeling_rod.get()), Ingredient.fromItems(ItemInit.mana_crystal.get()));
		test = registerRecipe(new ResourceLocation("anti_tear"),
				new ItemStack(ItemInit.anti_tear.get(), 1), 0, Ingredient.fromItems(ItemInit.drying_agent.get()),
				Ingredient.fromItems(ItemInit.storming_agent.get()),
				Ingredient.fromItems(ItemInit.soaking_agent.get()));
	}

	public static RecipeWandMaker registerRecipe(ResourceLocation rl, ItemStack output, float mana,
			Ingredient... inputs) {
		Preconditions.checkArgument(inputs.length <= 4);
		RecipeWandMaker recipe = new RecipeWandMaker(rl, output, mana, inputs);
		wandMakerRecipies.add(recipe);
		return recipe;
	}

}
