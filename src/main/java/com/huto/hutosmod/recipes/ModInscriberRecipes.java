package com.huto.hutosmod.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.init.ItemInit;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class ModInscriberRecipes {
	public static final List<RecipeAutoInscriber> inscriberRecipies = new ArrayList<>();

	public static RecipeAutoInscriber recipeRunedObsidian,recipeRunedObsidianIron,recipeRunedObsidianObsidian;

	public static void init() {

	/*	recipeRunedObsidian = registerRecipe(new ResourceLocation("runed_obsidian"),
				new ItemStack(BlockInit.runed_obsidian.get(), 1), 50, Ingredient.fromItems(Blocks.OBSIDIAN));*/
		recipeRunedObsidianIron = registerRecipe(new ResourceLocation("runed_obsidian_iron"),
				new ItemStack(BlockInit.runed_obsidian.get(), 1), 50, Ingredient.fromItems(Blocks.OBSIDIAN),Ingredient.fromItems(ItemInit.iron_knapper.get()));
		recipeRunedObsidianObsidian = registerRecipe(new ResourceLocation("runed_obsidian_obsidian"),
				new ItemStack(BlockInit.runed_obsidian.get(), 1), 25, Ingredient.fromItems(Blocks.OBSIDIAN),Ingredient.fromItems(ItemInit.obsidian_knapper.get()));

	
	}

	public static RecipeAutoInscriber registerRecipe(ResourceLocation rl, ItemStack output, float vibes,
			Ingredient... inputs) {
		Preconditions.checkArgument(inputs.length <= 2);
		RecipeAutoInscriber recipe = new RecipeAutoInscriber(rl, output, vibes, inputs);
		inscriberRecipies.add(recipe);
		return recipe;
	}

}
