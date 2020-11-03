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
			recipeUpgradeExport, recipeElderTome, recipeOpal, recipeNullBowBlade, recipeMysticBowBlade,
			recipeAuricBowBlade, recipeNullTrickAxe, recipeMysticTrickAxe, recipeAuricTrickAxe, recipeIdentifier;

	public static void init() {

		recipeIdentifier = registerRecipe(new ResourceLocation("allegeiance_identifier"),
				new ItemStack(ItemInit.allegiance_identifier.get(), 1), 30,
				Ingredient.fromItems(ItemInit.blooddrawn_fang.get()),
				Ingredient.fromItems(ItemInit.discared_gear.get()), Ingredient.fromItems(ItemInit.purging_stone.get()),
				Ingredient.fromItems(ItemInit.seraph_feather.get()),
				Ingredient.fromItems(ItemInit.unsettling_fabric.get()),
				Ingredient.fromItems(ItemInit.suspicious_eye.get()));

		recipeAuricBowBlade = registerRecipe(new ResourceLocation("auric_bow_blade"),
				new ItemStack(ItemInit.auric_bow_blade.get(), 1), 200, Ingredient.fromItems(ItemInit.auric_ingot.get()),
				Ingredient.fromItems(ItemInit.auric_ingot.get()), Ingredient.fromItems(Items.BOW),
				Ingredient.fromItems(ItemInit.writhing_thread.get()),
				Ingredient.fromItems(ItemInit.neurotic_mechanism.get()),
				Ingredient.fromItems(ItemInit.machina_soul.get()));

		recipeNullBowBlade = registerRecipe(new ResourceLocation("null_bow_blade"),
				new ItemStack(ItemInit.null_bow_blade.get(), 1), 100, Ingredient.fromItems(ItemInit.null_sword.get()),
				Ingredient.fromItems(Items.BOW), Ingredient.fromItems(ItemInit.writhing_thread.get()),
				Ingredient.fromItems(ItemInit.neurotic_mechanism.get()));

		recipeMysticBowBlade = registerRecipe(new ResourceLocation("mystic_bow_blade"),
				new ItemStack(ItemInit.mystic_bow_blade.get(), 1), 100, Ingredient.fromItems(Items.DIAMOND_SWORD),
				Ingredient.fromItems(Items.BOW), Ingredient.fromItems(ItemInit.writhing_thread.get()),
				Ingredient.fromItems(ItemInit.neurotic_mechanism.get()));

		recipeAuricTrickAxe = registerRecipe(new ResourceLocation("auric_trick_axe"),
				new ItemStack(ItemInit.auric_trick_axe.get(), 1), 200, Ingredient.fromItems(ItemInit.auric_ingot.get()),
				Ingredient.fromItems(ItemInit.auric_ingot.get()), Ingredient.fromItems(Items.ENDER_EYE),
				Ingredient.fromItems(ItemInit.writhing_thread.get()),
				Ingredient.fromItems(ItemInit.neurotic_mechanism.get()),
				Ingredient.fromItems(ItemInit.machina_soul.get()));

		recipeNullTrickAxe = registerRecipe(new ResourceLocation("null_trick_axe"),
				new ItemStack(ItemInit.null_trick_axe.get(), 1), 100, Ingredient.fromItems(ItemInit.null_axe.get()),
				Ingredient.fromItems(Items.ENDER_EYE), Ingredient.fromItems(ItemInit.writhing_thread.get()),
				Ingredient.fromItems(ItemInit.neurotic_mechanism.get()));

		recipeMysticTrickAxe = registerRecipe(new ResourceLocation("mystic_trick_axe"),
				new ItemStack(ItemInit.mystic_trick_axe.get(), 1), 100, Ingredient.fromItems(Items.DIAMOND_AXE),
				Ingredient.fromItems(Items.ENDER_EYE), Ingredient.fromItems(ItemInit.writhing_thread.get()),
				Ingredient.fromItems(ItemInit.neurotic_mechanism.get()));

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
		recipeUpgradeExport = registerRecipe(new ResourceLocation("upgrade_export"),
				new ItemStack(ItemInit.upgrade_export.get(), 1), 50, Ingredient.fromItems(ItemInit.gem_ruby.get()),
				Ingredient.fromItems(ItemInit.upgrade_blank.get()));
		recipeUpgradeImport = registerRecipe(new ResourceLocation("upgrade_import"),
				new ItemStack(ItemInit.upgrade_import.get(), 1), 50, Ingredient.fromItems(ItemInit.gem_sapphire.get()),
				Ingredient.fromItems(ItemInit.upgrade_blank.get()));
		recipeElderTome = registerRecipe(new ResourceLocation("elder_tome"),
				new ItemStack(ItemInit.elder_tome.get(), 1), 150, Ingredient.fromItems(ItemInit.karmic_bar.get()),
				Ingredient.fromItems(ItemInit.mystic_tome.get()));

		recipeOpal = registerRecipe(new ResourceLocation("gem_opal"), new ItemStack(ItemInit.gem_opal.get(), 1), 150,
				Ingredient.fromItems(ItemInit.gem_amethyst.get()), Ingredient.fromItems(ItemInit.gem_hematite.get()),
				Ingredient.fromItems(ItemInit.gem_onyx.get()), Ingredient.fromItems(ItemInit.gem_ruby.get()),
				Ingredient.fromItems(ItemInit.gem_sapphire.get()), Ingredient.fromItems(ItemInit.gem_topaz.get()));

	}

	public static RecipeFuser registerRecipe(ResourceLocation rl, ItemStack output, float vibes, Ingredient... inputs) {
		Preconditions.checkArgument(inputs.length <= 6);
		RecipeFuser recipe = new RecipeFuser(rl, output, vibes, inputs);
		fuserRecipies.add(recipe);
		return recipe;
	}

}
