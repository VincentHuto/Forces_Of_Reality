package com.huto.forcesofreality.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.huto.forcesofreality.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class ModRafflesiaRecipies {
	public static final List<RecipeRafflesia> rafflesiaRecipies = new ArrayList<>();

	public static RecipeRafflesia recipeSusEye;

	public static void init() {
		recipeSusEye = registerRecipe(new ResourceLocation("suseye"), new ItemStack(ItemInit.suspicious_eye.get(), 1),
				15, Ingredient.fromItems(ItemInit.gem_opal.get()), Ingredient.fromItems(ItemInit.discared_gear.get()),
				Ingredient.fromItems(ItemInit.akebi_pod.get()), Ingredient.fromItems(ItemInit.unsettling_fabric.get()),
				Ingredient.fromItems(ItemInit.unsettling_fabric.get()),
				Ingredient.fromItems(ItemInit.blooddrawn_fang.get()),
				Ingredient.fromItems(ItemInit.blooddrawn_fang.get()));

	}

	public static RecipeRafflesia registerRecipe(ResourceLocation rl, ItemStack output, float vibes,
			Ingredient... inputs) {
		Preconditions.checkArgument(inputs.length <= 7);
		RecipeRafflesia recipe = new RecipeRafflesia(rl, output, vibes, inputs);
		rafflesiaRecipies.add(recipe);
		return recipe;
	}
}
