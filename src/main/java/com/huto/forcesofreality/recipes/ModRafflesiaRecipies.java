package com.huto.forcesofreality.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.ItemInit;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class ModRafflesiaRecipies {
	public static final List<RecipeRafflesia> rafflesiaRecipies = new ArrayList<>();

	public static RecipeRafflesia recipeSusEye, recipeFang, recipeGear, recipeFabric, recipeFeather;
	public static RecipeRafflesia recipeBallEye, recipeNecBone, recipeNeurMech, recipeTapes, recipeWing;
	public static RecipeRafflesia recipeConcAurum;

	public static void init() {
		
		
		
		recipeConcAurum = registerRecipe(new ResourceLocation("concaurum"), new ItemStack(ItemInit.annointed_bronze.get(), 1),
				100, Ingredient.fromItems(ItemInit.emanating_ingot.get()), Ingredient.fromItems(ItemInit.anointed_iron_scrap.get()),
				Ingredient.fromItems(ItemInit.auric_ingot.get()), Ingredient.fromItems(ItemInit.discared_gear.get()),
				Ingredient.fromItems(ItemInit.seraph_feather.get()));
		
		
		recipeSusEye = registerRecipe(new ResourceLocation("suseye"), new ItemStack(ItemInit.suspicious_eye.get(), 1),
				15, Ingredient.fromItems(ItemInit.grey_crystal.get()), Ingredient.fromItems(ItemInit.grey_powder.get()),
				Ingredient.fromItems(ItemInit.discared_gear.get()), Ingredient.fromItems(BlockInit.akebi.get()),
				Ingredient.fromItems(ItemInit.unsettling_fabric.get()),
				Ingredient.fromItems(ItemInit.seraph_feather.get()),
				Ingredient.fromItems(ItemInit.blooddrawn_fang.get()));

		recipeFang = registerRecipe(new ResourceLocation("fang"), new ItemStack(ItemInit.blooddrawn_fang.get(), 1), 15,
				Ingredient.fromItems(ItemInit.grey_crystal.get()), Ingredient.fromItems(ItemInit.grey_powder.get()),
				Ingredient.fromItems(ItemInit.discared_gear.get()), Ingredient.fromItems(BlockInit.akebi.get()),
				Ingredient.fromItems(ItemInit.unsettling_fabric.get()),
				Ingredient.fromItems(ItemInit.seraph_feather.get()),
				Ingredient.fromItems(ItemInit.suspicious_eye.get()));

		recipeGear = registerRecipe(new ResourceLocation("gear"), new ItemStack(ItemInit.discared_gear.get(), 1), 15,
				Ingredient.fromItems(ItemInit.grey_crystal.get()), Ingredient.fromItems(ItemInit.grey_powder.get()),
				Ingredient.fromItems(ItemInit.blooddrawn_fang.get()), Ingredient.fromItems(BlockInit.akebi.get()),
				Ingredient.fromItems(ItemInit.unsettling_fabric.get()),
				Ingredient.fromItems(ItemInit.seraph_feather.get()),
				Ingredient.fromItems(ItemInit.suspicious_eye.get()));

		recipeFabric = registerRecipe(new ResourceLocation("fabric"),
				new ItemStack(ItemInit.unsettling_fabric.get(), 1), 15,
				Ingredient.fromItems(ItemInit.grey_crystal.get()), Ingredient.fromItems(ItemInit.grey_powder.get()),
				Ingredient.fromItems(ItemInit.blooddrawn_fang.get()), Ingredient.fromItems(BlockInit.akebi.get()),
				Ingredient.fromItems(ItemInit.discared_gear.get()), Ingredient.fromItems(ItemInit.seraph_feather.get()),
				Ingredient.fromItems(ItemInit.suspicious_eye.get()));

		recipeFeather = registerRecipe(new ResourceLocation("feather"), new ItemStack(ItemInit.seraph_feather.get(), 1),
				15, Ingredient.fromItems(ItemInit.grey_crystal.get()), Ingredient.fromItems(ItemInit.grey_powder.get()),
				Ingredient.fromItems(ItemInit.blooddrawn_fang.get()), Ingredient.fromItems(BlockInit.akebi.get()),
				Ingredient.fromItems(ItemInit.discared_gear.get()),
				Ingredient.fromItems(ItemInit.unsettling_fabric.get()),
				Ingredient.fromItems(ItemInit.suspicious_eye.get()));

		recipeBallEye = registerRecipe(new ResourceLocation("balleye"), new ItemStack(ItemInit.ball_of_eyes.get(), 1),
				30, Ingredient.fromItems(ItemInit.grey_crystal.get()), Ingredient.fromItems(ItemInit.grey_powder.get()),
				Ingredient.fromItems(ItemInit.beastly_bone.get()), Ingredient.fromItems(BlockInit.akebi.get()),
				Ingredient.fromItems(ItemInit.neurotic_mechanism.get()),
				Ingredient.fromItems(ItemInit.unsettling_tapestry.get()),
				Ingredient.fromItems(ItemInit.wing_fragment.get()));

		recipeNecBone = registerRecipe(new ResourceLocation("necbone"), new ItemStack(ItemInit.beastly_bone.get(), 1),
				30, Ingredient.fromItems(ItemInit.grey_crystal.get()), Ingredient.fromItems(ItemInit.grey_powder.get()),
				Ingredient.fromItems(ItemInit.ball_of_eyes.get()), Ingredient.fromItems(BlockInit.akebi.get()),
				Ingredient.fromItems(ItemInit.neurotic_mechanism.get()),
				Ingredient.fromItems(ItemInit.unsettling_tapestry.get()),
				Ingredient.fromItems(ItemInit.wing_fragment.get()));

		recipeNeurMech = registerRecipe(new ResourceLocation("neurmech"),
				new ItemStack(ItemInit.neurotic_mechanism.get(), 1), 30,
				Ingredient.fromItems(ItemInit.grey_crystal.get()), Ingredient.fromItems(ItemInit.grey_powder.get()),
				Ingredient.fromItems(ItemInit.ball_of_eyes.get()), Ingredient.fromItems(BlockInit.akebi.get()),
				Ingredient.fromItems(ItemInit.beastly_bone.get()),
				Ingredient.fromItems(ItemInit.unsettling_tapestry.get()),
				Ingredient.fromItems(ItemInit.wing_fragment.get()));

		recipeTapes = registerRecipe(new ResourceLocation("unstape"),
				new ItemStack(ItemInit.unsettling_tapestry.get(), 1), 30,
				Ingredient.fromItems(ItemInit.grey_crystal.get()), Ingredient.fromItems(ItemInit.grey_powder.get()),
				Ingredient.fromItems(ItemInit.ball_of_eyes.get()), Ingredient.fromItems(BlockInit.akebi.get()),
				Ingredient.fromItems(ItemInit.beastly_bone.get()),
				Ingredient.fromItems(ItemInit.neurotic_mechanism.get()),
				Ingredient.fromItems(ItemInit.wing_fragment.get()));

		recipeWing = registerRecipe(new ResourceLocation("wingfrag"), new ItemStack(ItemInit.wing_fragment.get(), 1),
				30, Ingredient.fromItems(ItemInit.grey_crystal.get()), Ingredient.fromItems(ItemInit.grey_powder.get()),
				Ingredient.fromItems(ItemInit.ball_of_eyes.get()), Ingredient.fromItems(BlockInit.akebi.get()),
				Ingredient.fromItems(ItemInit.beastly_bone.get()),
				Ingredient.fromItems(ItemInit.neurotic_mechanism.get()),
				Ingredient.fromItems(ItemInit.unsettling_tapestry.get()));

	}

	public static RecipeRafflesia registerRecipe(ResourceLocation rl, ItemStack output, float vibes,
			Ingredient... inputs) {
		Preconditions.checkArgument(inputs.length <= 7);
		RecipeRafflesia recipe = new RecipeRafflesia(rl, output, vibes, inputs);
		rafflesiaRecipies.add(recipe);
		return recipe;
	}
}
