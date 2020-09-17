package com.huto.hutosmod.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.huto.hutosmod.init.ItemInit;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class ModFuserRecipies {
	public static final List<RecipeFuser> fuserRecipies = new ArrayList<>();

	public static RecipeFuser recipeGrandPurgingStone, recipeGreyBar, recipeKarmicBar, recipePhantasmalPane,
			recipeUpgradeBlock, recipeUpgradePeople, recipeUpgradeMob, recipeUpgradeAnimal, recipeUpgradeImport,
			recipeUpgradeExport, recipeElderTome;

	public static void init() {

		recipeGrandPurgingStone = registerRecipe(new ResourceLocation("grand_purging_stone"),
				new ItemStack(ItemInit.grand_purging_stone.get(), 1), 100,
				Ingredient.fromItems(ItemInit.purging_stone.get()), Ingredient.fromItems(ItemInit.karmic_drop.get()));
		recipeGreyBar = registerRecipe(new ResourceLocation("grey_ingot"), new ItemStack(ItemInit.grey_ingot.get(), 1),
				10, Ingredient.fromItems(ItemInit.null_ingot.get()),
				Ingredient.fromItems(ItemInit.channeling_ingot.get()));
		recipeKarmicBar = registerRecipe(new ResourceLocation("karmic_bar"),
				new ItemStack(ItemInit.karmic_bar.get(), 1), 10, Ingredient.fromItems(ItemInit.karmic_drop.get()),
				Ingredient.fromItems(ItemInit.grey_ingot.get()));
		recipePhantasmalPane = registerRecipe(new ResourceLocation("phantasmal_pane"),
				new ItemStack(ItemInit.phantasmal_pane.get(), 1), 10, Ingredient.fromItems(ItemInit.readied_pane.get()),
				Ingredient.fromItems(ItemInit.essence_drop.get()), Ingredient.fromItems(ItemInit.anti_tear.get()));
		recipeUpgradeBlock = registerRecipe(new ResourceLocation("upgrade_block"),
				new ItemStack(ItemInit.upgrade_block.get(), 1), 50, Ingredient.fromItems(ItemInit.mana_crystal.get()),
				Ingredient.fromItems(ItemInit.upgrade_blank.get()));
		recipeUpgradeAnimal = registerRecipe(new ResourceLocation("upgrade_animal"),
				new ItemStack(ItemInit.upgrade_animal.get(), 1), 50, Ingredient.fromItems(Blocks.GRASS_BLOCK),
				Ingredient.fromItems(ItemInit.upgrade_blank.get()));
		recipeUpgradePeople = registerRecipe(new ResourceLocation("upgrade_player"),
				new ItemStack(ItemInit.upgrade_player.get(), 1), 50, Ingredient.fromItems(Items.NETHER_STAR),
				Ingredient.fromItems(ItemInit.upgrade_blank.get()));
		recipeUpgradeExport = registerRecipe(new ResourceLocation("upgrade_absorber"),
				new ItemStack(ItemInit.upgrade_absorber.get(), 1), 50, Ingredient.fromItems(ItemInit.gem_ruby.get()),
				Ingredient.fromItems(ItemInit.upgrade_blank.get()));
		recipeUpgradeImport = registerRecipe(new ResourceLocation("upgrade_import"),
				new ItemStack(ItemInit.upgrade_import.get(), 1), 50, Ingredient.fromItems(ItemInit.gem_sapphire.get()),
				Ingredient.fromItems(ItemInit.upgrade_blank.get()));
		recipeElderTome = registerRecipe(new ResourceLocation("elder_tome"),
				new ItemStack(ItemInit.elder_tome.get(), 1), 150, Ingredient.fromItems(ItemInit.karmic_bar.get()),
				Ingredient.fromItems(ItemInit.mystic_tome.get()));
		;
	}

	public static RecipeFuser registerRecipe(ResourceLocation rl, ItemStack output, float mana, Ingredient... inputs) {
		Preconditions.checkArgument(inputs.length <= 6);
		RecipeFuser recipe = new RecipeFuser(rl, output, mana, inputs);
		fuserRecipies.add(recipe);
		return recipe;
	}

}
