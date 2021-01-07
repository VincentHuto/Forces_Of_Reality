package com.huto.forcesofreality.recipes;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.ItemInit;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class ModFuserRecipies {
	public static final List<RecipeFuser> fuserRecipies = new ArrayList<>();

	public static RecipeFuser recipeGrandPurgingStone, recipeGreyBar, recipeKarmicBar, recipePhantasmalPane,
			recipeUpgradeBlock, recipeUpgradePeople, recipeUpgradeMob, recipeUpgradeAnimal, recipeUpgradeImport,
			recipeUpgradeExport, recipeElderTome, recipeCovenTome, recipeOpal, recipeNullBowBlade, recipeSomnolentBowBlade,
			recipeAuricBowBlade, recipeNullTrickAxe, recipeSomnolentTrickAxe, recipeAuricTrickAxe, recipeIdentifier,
			recipeArmoredDirector, recipeAuricIngot, recipeCryingObsidian, recipePhantasmalGlass, recipeSeraphChest,
			recipeAuricHelm, recipeAuricChest, recipeAuricLegs, recipeAuricBoots, recipeAuricDirector;

	public static void init() {

		recipeSeraphChest = registerRecipe(new ResourceLocation("seraph_wings"),
				new ItemStack(ItemInit.seraph_wings.get(), 1), 30,
				Ingredient.fromItems(ItemInit.anointed_iron_chestplate.get()),
				Ingredient.fromItems(ItemInit.wing_fragment.get()), Ingredient.fromItems(ItemInit.wing_fragment.get()),
				Ingredient.fromItems(ItemInit.wing_fragment.get()), Ingredient.fromItems(ItemInit.wing_fragment.get()),
				Ingredient.fromItems(ItemInit.crossed_keys.get()));

		recipeCryingObsidian = registerRecipe(new ResourceLocation("crying_obsidian"),
				new ItemStack(Blocks.CRYING_OBSIDIAN, 1), 15, Ingredient.fromItems(ItemInit.essence_drop.get()),
				Ingredient.fromItems(Blocks.OBSIDIAN));

		recipeAuricIngot = registerRecipe(new ResourceLocation("auric_ingot"),
				new ItemStack(ItemInit.auric_ingot.get(), 1), 30, Ingredient.fromItems(ItemInit.machina_soul.get()),
				Ingredient.fromItems(Items.IRON_INGOT), Ingredient.fromItems(ItemInit.machina_soul.get()));

		recipeArmoredDirector = registerRecipe(new ResourceLocation("machina_spark_director_armored"),
				new ItemStack(ItemInit.machina_spark_director_armored.get(), 1), 150,
				Ingredient.fromItems(ItemInit.machina_spark_director.get()),
				Ingredient.fromItems(ItemInit.auric_chest.get()));

		recipeAuricHelm = registerRecipe(new ResourceLocation("auric_helm"),
				new ItemStack(ItemInit.auric_helm.get(), 1), 30, Ingredient.fromItems(ItemInit.machina_soul.get()),
				Ingredient.fromItems(ItemInit.auric_ingot.get()), Ingredient.fromItems(ItemInit.machina_soul.get()),
				Ingredient.fromItems(Items.IRON_HELMET));

		recipeAuricChest = registerRecipe(new ResourceLocation("auric_chest"),
				new ItemStack(ItemInit.auric_chest.get(), 1), 30, Ingredient.fromItems(ItemInit.machina_soul.get()),
				Ingredient.fromItems(ItemInit.auric_ingot.get()), Ingredient.fromItems(ItemInit.machina_soul.get()),
				Ingredient.fromItems(Items.IRON_CHESTPLATE));

		recipeAuricDirector = registerRecipe(new ResourceLocation("spark_director"),
				new ItemStack(ItemInit.machina_spark_director.get(), 1), 30,
				Ingredient.fromItems(ItemInit.machina_soul.get()), Ingredient.fromItems(ItemInit.auric_ingot.get()),
				Ingredient.fromItems(ItemInit.machina_soul.get()), Ingredient.fromItems(ItemInit.auric_ingot.get()),
				Ingredient.fromItems(ItemInit.machina_cage.get()));

		recipeAuricLegs = registerRecipe(new ResourceLocation("auric_legs"),
				new ItemStack(ItemInit.auric_leggings.get(), 1), 30, Ingredient.fromItems(ItemInit.machina_soul.get()),
				Ingredient.fromItems(ItemInit.auric_ingot.get()), Ingredient.fromItems(ItemInit.machina_soul.get()),
				Ingredient.fromItems(Items.IRON_LEGGINGS));

		recipeAuricBoots = registerRecipe(new ResourceLocation("auric_boots"),
				new ItemStack(ItemInit.auric_boots.get(), 1), 30, Ingredient.fromItems(ItemInit.machina_soul.get()),
				Ingredient.fromItems(ItemInit.auric_ingot.get()), Ingredient.fromItems(ItemInit.machina_soul.get()),
				Ingredient.fromItems(Items.IRON_BOOTS));

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

		recipeSomnolentBowBlade = registerRecipe(new ResourceLocation("somnolent_bow_blade"),
				new ItemStack(ItemInit.somnolent_bow_blade.get(), 1), 100, Ingredient.fromItems(Items.DIAMOND_SWORD),
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

		recipeSomnolentTrickAxe = registerRecipe(new ResourceLocation("somnolent_trick_axe"),
				new ItemStack(ItemInit.somnolent_trick_axe.get(), 1), 100, Ingredient.fromItems(Items.DIAMOND_AXE),
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
				new ItemStack(BlockInit.phantasmal_pane.get(), 1), 10,
				Ingredient.fromItems(ItemInit.readied_pane.get()), Ingredient.fromItems(ItemInit.essence_drop.get()),
				Ingredient.fromItems(ItemInit.anti_tear.get()));

		recipePhantasmalGlass = registerRecipe(new ResourceLocation("phantasmal_glass"),
				new ItemStack(BlockInit.phantasmal_glass.get(), 1), 30, Ingredient.fromItems(Blocks.GLASS),
				Ingredient.fromItems(ItemInit.essence_drop.get()), Ingredient.fromItems(ItemInit.anti_tear.get()),
				Ingredient.fromItems(ItemInit.essence_drop.get()), Ingredient.fromItems(ItemInit.anti_tear.get()));

		recipeUpgradeBlock = registerRecipe(new ResourceLocation("upgrade_block"),
				new ItemStack(ItemInit.upgrade_block.get(), 1), 50,
				Ingredient.fromItems(ItemInit.somnolent_crystal.get()),
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
				Ingredient.fromItems(ItemInit.somnolent_tome.get()));
		recipeCovenTome = registerRecipe(new ResourceLocation("coven_tome"),
				new ItemStack(ItemInit.coven_tome.get(), 1), 150, Ingredient.fromItems(ItemInit.grey_ingot.get()),
				Ingredient.fromItems(ItemInit.somnolent_tome.get()));

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
