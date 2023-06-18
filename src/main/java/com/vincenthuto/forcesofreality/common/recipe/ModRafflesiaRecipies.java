package com.vincenthuto.forcesofreality.common.recipe;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.vincenthuto.forcesofreality.registry.ItemInit;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class ModRafflesiaRecipies {
	public static final List<RecipeRafflesia> rafflesiaRecipies = new ArrayList<>();

	public static RecipeRafflesia recipeSusEye, recipeFang, recipeGear, recipeFabric, recipeFeather;
	public static RecipeRafflesia recipeBallEye, recipeNecBone, recipeNeurMech, recipeTapes, recipeWing;
	public static RecipeRafflesia recipeConcAurum, recipeSeraphChest;

	public static void init() {

		recipeSeraphChest = registerRecipe(new ResourceLocation("seraph_wings"),
				new ItemStack(ItemInit.seraph_wings.get(), 1), 130,
				Ingredient.of(ItemInit.anointed_iron_chestplate.get()), Ingredient.of(ItemInit.wing_fragment.get()),
				Ingredient.of(ItemInit.wing_fragment.get()), Ingredient.of(ItemInit.wing_fragment.get()),
				Ingredient.of(ItemInit.wing_fragment.get()), Ingredient.of(ItemInit.crossed_keys.get()));

		recipeConcAurum = registerRecipe(new ResourceLocation("concaurum"),
				new ItemStack(ItemInit.concecrated_aurum.get(), 1), 100,
				Ingredient.of(ItemInit.anointed_iron_scrap.get()), Ingredient.of(ItemInit.auric_ingot.get()),
				Ingredient.of(ItemInit.discared_gear.get()), Ingredient.of(ItemInit.seraph_feather.get()));

		recipeSusEye = registerRecipe(new ResourceLocation("suseye"), new ItemStack(ItemInit.suspicious_eye.get(), 1),
				15, Ingredient.of(ItemInit.discared_gear.get()), Ingredient.of(ItemInit.unsettling_fabric.get()),
				Ingredient.of(ItemInit.seraph_feather.get()), Ingredient.of(ItemInit.blooddrawn_fang.get()));

		recipeFang = registerRecipe(new ResourceLocation("fang"), new ItemStack(ItemInit.blooddrawn_fang.get(), 1), 15,

				Ingredient.of(ItemInit.discared_gear.get()), Ingredient.of(ItemInit.unsettling_fabric.get()),
				Ingredient.of(ItemInit.seraph_feather.get()), Ingredient.of(ItemInit.suspicious_eye.get()));

		recipeGear = registerRecipe(new ResourceLocation("gear"), new ItemStack(ItemInit.discared_gear.get(), 1), 15,
				Ingredient.of(ItemInit.blooddrawn_fang.get()), Ingredient.of(ItemInit.unsettling_fabric.get()),
				Ingredient.of(ItemInit.seraph_feather.get()), Ingredient.of(ItemInit.suspicious_eye.get()));

		recipeFabric = registerRecipe(new ResourceLocation("fabric"),
				new ItemStack(ItemInit.unsettling_fabric.get(), 1), 15, Ingredient.of(ItemInit.blooddrawn_fang.get()),
				Ingredient.of(ItemInit.discared_gear.get()), Ingredient.of(ItemInit.seraph_feather.get()),
				Ingredient.of(ItemInit.suspicious_eye.get()));

		recipeFeather = registerRecipe(new ResourceLocation("feather"), new ItemStack(ItemInit.seraph_feather.get(), 1),
				15, Ingredient.of(ItemInit.blooddrawn_fang.get()), Ingredient.of(ItemInit.discared_gear.get()),
				Ingredient.of(ItemInit.unsettling_fabric.get()), Ingredient.of(ItemInit.suspicious_eye.get()));

		recipeBallEye = registerRecipe(new ResourceLocation("balleye"), new ItemStack(ItemInit.ball_of_eyes.get(), 1),
				30, Ingredient.of(ItemInit.beastly_bone.get()), Ingredient.of(ItemInit.malfunctioning_mechanism.get()),
				Ingredient.of(ItemInit.unsettling_tapestry.get()), Ingredient.of(ItemInit.wing_fragment.get()));

		recipeNecBone = registerRecipe(new ResourceLocation("necbone"), new ItemStack(ItemInit.beastly_bone.get(), 1),
				30, Ingredient.of(ItemInit.ball_of_eyes.get()), Ingredient.of(ItemInit.malfunctioning_mechanism.get()),
				Ingredient.of(ItemInit.unsettling_tapestry.get()), Ingredient.of(ItemInit.wing_fragment.get()));

		recipeNeurMech = registerRecipe(new ResourceLocation("neurmech"),
				new ItemStack(ItemInit.malfunctioning_mechanism.get(), 1), 30,
				Ingredient.of(ItemInit.ball_of_eyes.get()), Ingredient.of(ItemInit.beastly_bone.get()),
				Ingredient.of(ItemInit.unsettling_tapestry.get()), Ingredient.of(ItemInit.wing_fragment.get()));

		recipeTapes = registerRecipe(new ResourceLocation("unstape"),
				new ItemStack(ItemInit.unsettling_tapestry.get(), 1), 30, Ingredient.of(ItemInit.ball_of_eyes.get()),
				Ingredient.of(ItemInit.beastly_bone.get()), Ingredient.of(ItemInit.malfunctioning_mechanism.get()),
				Ingredient.of(ItemInit.wing_fragment.get()));

		recipeWing = registerRecipe(new ResourceLocation("wingfrag"), new ItemStack(ItemInit.wing_fragment.get(), 1),
				30, Ingredient.of(ItemInit.ball_of_eyes.get()), Ingredient.of(ItemInit.beastly_bone.get()),
				Ingredient.of(ItemInit.malfunctioning_mechanism.get()),
				Ingredient.of(ItemInit.unsettling_tapestry.get()));

	}

	public static RecipeRafflesia registerRecipe(ResourceLocation rl, ItemStack output, float vibes,
			Ingredient... inputs) {
		Preconditions.checkArgument(inputs.length <= 7);
		RecipeRafflesia recipe = new RecipeRafflesia(rl, output, vibes, inputs);
		rafflesiaRecipies.add(recipe);
		return recipe;
	}
}
