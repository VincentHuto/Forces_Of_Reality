package com.huto.forcesofreality.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.objects.tileenties.util.EnumCrystalTypes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class ModHarmonizerRecipes {
	public static final List<RecipeHarmonizer> harmonizerRecipes = new ArrayList<>();

	public static RecipeHarmonizer recipeTopaz, recipeSapphire, recipeAmeythst,recipeRuby, recipeOpal, recipeOpalNew,
			recipeHematite, recipeOnyx;

	public static void init() {

		recipeTopaz = registerRecipe(new ResourceLocation("recipetopaz"), new ItemStack(ItemInit.gem_topaz.get(), 1),
				30, EnumCrystalTypes.TOPAZ, Ingredient.fromItems(Items.DIAMOND));
		recipeSapphire = registerRecipe(new ResourceLocation("recipesapphire"),
				new ItemStack(ItemInit.gem_sapphire.get(), 1), 30, EnumCrystalTypes.SAPPHIRE,
				Ingredient.fromItems(Items.DIAMOND));
		recipeAmeythst = registerRecipe(new ResourceLocation("recipeameythst"),
				new ItemStack(ItemInit.gem_amethyst.get(), 1), 30, EnumCrystalTypes.AMETHYST,
				Ingredient.fromItems(Items.DIAMOND));
		recipeRuby = registerRecipe(new ResourceLocation("reciperuby"),
				new ItemStack(ItemInit.gem_ruby.get(), 1), 30, EnumCrystalTypes.RUBY,
				Ingredient.fromItems(Items.DIAMOND));
		recipeOpal = registerRecipe(new ResourceLocation("recipeopal"), new ItemStack(ItemInit.gem_opal.get(), 1), 30,
				EnumCrystalTypes.OPAL, Ingredient.fromItems(Items.DIAMOND));
		recipeOpalNew = registerRecipe(new ResourceLocation("recipeopalnew"), new ItemStack(ItemInit.gem_opal.get(), 1),
				30, EnumCrystalTypes.OPAL, Ingredient.fromItems(Items.DIAMOND),
				Ingredient.fromItems(Items.AZURE_BLUET));
		recipeHematite = registerRecipe(new ResourceLocation("recipehematite"),
				new ItemStack(ItemInit.gem_hematite.get(), 1), 30, EnumCrystalTypes.HEMATITE,
				Ingredient.fromItems(Items.DIAMOND));
		recipeOnyx = registerRecipe(new ResourceLocation("recipeonyx"), new ItemStack(ItemInit.gem_onyx.get(), 1), 30,
				EnumCrystalTypes.ONYX, Ingredient.fromItems(Items.DIAMOND));

	}

	public static RecipeHarmonizer registerRecipe(ResourceLocation rl, ItemStack output, float vibes,
			EnumCrystalTypes type, Ingredient... inputs) {
		Preconditions.checkArgument(inputs.length <= 2);
		RecipeHarmonizer recipe = new RecipeHarmonizer(rl, output, vibes, type, inputs);
		harmonizerRecipes.add(recipe);
		return recipe;
	}

}
