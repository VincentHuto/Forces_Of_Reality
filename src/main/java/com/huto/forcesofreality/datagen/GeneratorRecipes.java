package com.huto.forcesofreality.datagen;

import java.util.function.Consumer;

import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.ItemInit;

import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraftforge.common.Tags;

public class GeneratorRecipes extends RecipeProvider {
	public GeneratorRecipes(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {

		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.writhing_thread.get(), 2).addIngredient(Items.STRING, 1)
				.addIngredient(ItemInit.vitreous_humor.get(), 1).addIngredient(Items.ENDER_PEARL, 2)
				.addCriterion("has_vitreous_humor", hasItem(ItemInit.vitreous_humor.get())).build(consumer);

		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.ball_of_eyes.get())
				.addIngredient(ItemInit.suspicious_eye.get(), 3).addIngredient(ItemInit.vitreous_humor.get(), 2)
				.addCriterion("has_beastly_bone", hasItem(ItemInit.suspicious_eye.get())).build(consumer);

		ShapelessRecipeBuilder.shapelessRecipe(BlockInit.auspicious_bundle.get()).addIngredient(Items.BONE, 2)
				.addIngredient(Items.STICK, 3).addIngredient(ItemInit.beastly_bone.get(), 2)
				.addIngredient(Blocks.DIRT, 2).addCriterion("has_beastly_bone", hasItem(ItemInit.beastly_bone.get()))
				.build(consumer);

		// Misc

		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.vitreous_humor.get(), 1)
				.addIngredient(ItemInit.suspicious_eye.get())
				.addCriterion("has_suspicious_eye", hasItem(ItemInit.suspicious_eye.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(BlockInit.gilded_wool.get()).key('K', Blocks.RED_WOOL)
				.key('S', Tags.Items.NUGGETS_GOLD).patternLine("SSS").patternLine("SKS").patternLine("SSS")
				.addCriterion("has_nuggets_gold", hasItem(Tags.Items.NUGGETS_GOLD)).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(BlockInit.auric_block.get()).key('A', ItemInit.auric_ingot.get())
				.patternLine("AAA").patternLine("AAA").patternLine("AAA")
				.addCriterion("has_auric_ingot", hasItem(ItemInit.auric_ingot.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(BlockInit.anointed_iron_block.get())
				.key('A', ItemInit.anointed_iron_scrap.get()).patternLine("AAA").patternLine("AAA").patternLine("AAA")
				.addCriterion("has_anointed_iron_scrap", hasItem(ItemInit.anointed_iron_scrap.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.machina_cage.get()).key('A', Items.IRON_INGOT)
				.key('S', ItemInit.machina_soul.get()).patternLine("AAA").patternLine("ASA").patternLine(" A ")
				.addCriterion("has_machina_soul", hasItem(ItemInit.machina_soul.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(BlockInit.bonsai_planter.get()).key('F', Tags.Items.INGOTS_BRICK)
				.key('N', Blocks.DIRT).patternLine("FNF").patternLine("FFF").patternLine("F F")
				.addCriterion("has_brick", hasItem(Tags.Items.INGOTS_BRICK)).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.anointed_iron_helm.get()).key('R', ItemInit.anointed_iron_scrap.get())
				.patternLine("RRR").patternLine("R R")
				.addCriterion("has_anointed_iron_scrap", hasItem(ItemInit.anointed_iron_scrap.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.anointed_iron_chestplate.get())
				.key('R', ItemInit.anointed_iron_scrap.get()).patternLine("R R").patternLine("RRR").patternLine("RRR")
				.addCriterion("has_anointed_iron_scrap", hasItem(ItemInit.anointed_iron_scrap.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.anointed_iron_leggings.get())
				.key('R', ItemInit.anointed_iron_scrap.get()).patternLine("RRR").patternLine("R R").patternLine("R R")
				.addCriterion("has_anointed_iron_scrap", hasItem(ItemInit.anointed_iron_scrap.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.anointed_iron_boots.get())
				.key('R', ItemInit.anointed_iron_scrap.get()).patternLine("R R").patternLine("R R")
				.addCriterion("has_anointed_iron_scrap", hasItem(ItemInit.anointed_iron_scrap.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.anointed_iron_sword.get())
				.key('R', ItemInit.anointed_iron_scrap.get()).key('N', Items.STICK).patternLine("R").patternLine("R")
				.patternLine("N").addCriterion("has_anointed_iron_scrap", hasItem(ItemInit.anointed_iron_scrap.get()))
				.build(consumer);

		ShapedRecipeBuilder.shapedRecipe(BlockInit.ascendant_altar.get()).key('B', Items.QUARTZ_BLOCK)
				.key('P', Items.QUARTZ_PILLAR).key('O', Items.GOLD_BLOCK).key('G', BlockInit.gilded_wool.get())
				.patternLine("BGB").patternLine("POP").patternLine("BOB")
				.addCriterion("has_gilded_wool", hasItem(BlockInit.gilded_wool.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(BlockInit.untold_easel.get()).key('N', Items.STICK)
				.key('T', ItemInit.unsettling_tapestry.get()).key('P', Items.FLOWER_POT)
				.key('Y', ItemInit.yellow_sign.get()).patternLine("TTT").patternLine("PNY").patternLine("N N")
				.addCriterion("has_yellow_sign", hasItem(ItemInit.yellow_sign.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.occular_seed.get()).key('W', ItemInit.writhing_thread.get())
				.key('E', ItemInit.ball_of_eyes.get()).patternLine("W W").patternLine(" E ").patternLine("W W")
				.addCriterion("has_ball_of_eyes", hasItem(ItemInit.ball_of_eyes.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(BlockInit.machina_imperfecta.get()).key('A', BlockInit.auric_block.get())
				.key('N', ItemInit.malfunctioning_mechanism.get()).key('D', ItemInit.discared_gear.get())
				.patternLine("ADA").patternLine("ANA").patternLine("ADA")
				.addCriterion("has_discared_gear", hasItem(ItemInit.discared_gear.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.writhing_helmet.get()).key('R', ItemInit.writhing_thread.get())
				.key('V', ItemInit.vitreous_humor.get()).key('S', ItemInit.ball_of_eyes.get()).patternLine("VSV")
				.patternLine("RRR").patternLine("R R")
				.addCriterion("has_writhing_thread", hasItem(ItemInit.writhing_thread.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.writhing_chestplate.get()).key('R', ItemInit.writhing_thread.get())
				.key('E', ItemInit.ball_of_eyes.get()).patternLine("R R").patternLine("RER").patternLine("RRR")
				.addCriterion("has_writhing_thread", hasItem(ItemInit.writhing_thread.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.writhing_leggings.get()).key('R', ItemInit.writhing_thread.get())
				.patternLine("RRR").patternLine("R R").patternLine("R R")
				.addCriterion("has_writhing_thread", hasItem(ItemInit.writhing_thread.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.writhing_boots.get()).key('R', ItemInit.writhing_thread.get())
				.patternLine("R R").patternLine("R R")
				.addCriterion("has_writhing_thread", hasItem(ItemInit.writhing_thread.get())).build(consumer);
//
//		ShapedRecipeBuilder.shapedRecipe(BlockInit.rafflesia_of_fidelity.get())
//				.key('R', BlockInit.rafflesia_flower.get()).key('I', BlockInit.anointed_iron_block.get())
//				.key('O', BlockInit.runed_obsidian.get()).key('F', BlockInit.vibratory_fuser.get())
//				.key('A', BlockInit.activated_obsidian.get()).patternLine("IRI").patternLine("IFI").patternLine("AOA")
//				.addCriterion("has_rafflesia_flower", hasItem(BlockInit.rafflesia_flower.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.skull_helmet.get()).key('B', ItemInit.beastly_bone.get())
				.key('F', ItemInit.blooddrawn_fang.get()).patternLine("BBB").patternLine("B B").patternLine("FBF")
				.addCriterion("has_beastly_bone", hasItem(ItemInit.beastly_bone.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.enticing_mantle.get()).key('B', ItemInit.beastly_bone.get())
				.key('F', ItemInit.unkept_hide.get()).patternLine("BFB").patternLine("FFF").patternLine("FFF")
				.addCriterion("has_beastly_bone", hasItem(ItemInit.beastly_bone.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.legs_of_fawn.get()).key('B', ItemInit.beastly_bone.get())
				.key('F', ItemInit.unkept_hide.get()).patternLine("BFB").patternLine("F F").patternLine("F F")
				.addCriterion("has_beastly_bone", hasItem(ItemInit.beastly_bone.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.cloven_hooves.get()).key('B', ItemInit.beastly_bone.get())
				.key('F', ItemInit.unkept_hide.get()).patternLine("BFB").patternLine("B B")
				.addCriterion("has_beastly_bone", hasItem(ItemInit.beastly_bone.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.mechan_module.get()).key('I', ItemInit.auric_ingot.get())
				.key('M', ItemInit.malfunctioning_mechanism.get()).key('K', ItemInit.machina_cage.get())
				.patternLine("III").patternLine("IMI").patternLine("IKI")
				.addCriterion("has_auric_bar", hasItem(ItemInit.auric_ingot.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.mechan_module_rocket.get()).key('A', ItemInit.auric_ingot.get())
				.key('I', Items.IRON_INGOT).key('M', ItemInit.mechan_module.get()).key('G', Items.GUNPOWDER)
				.patternLine("A A").patternLine("IMI").patternLine("GGG")
				.addCriterion("has_mechan_module", hasItem(ItemInit.mechan_module.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.mechan_module_salvo.get()).key('A', ItemInit.auric_ingot.get())
				.key('F', ItemInit.malfunctioning_mechanism.get()).key('I', Items.IRON_INGOT)
				.key('M', ItemInit.mechan_module_rocket.get()).key('G', Items.GUNPOWDER).patternLine("AFA")
				.patternLine("IMI").patternLine("GGG")
				.addCriterion("has_mechan_module_rocket", hasItem(ItemInit.mechan_module_rocket.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.mechan_module_shortcircuit.get()).key('A', ItemInit.auric_ingot.get())
				.key('M', ItemInit.mechan_module.get()).key('R', Items.REDSTONE).key('G', Items.GLOWSTONE)
				.patternLine("RGR").patternLine("AMA").patternLine("RGR")
				.addCriterion("has_mechan_module", hasItem(ItemInit.mechan_module.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.mechan_module_laser.get()).key('A', ItemInit.auric_ingot.get())
				.key('M', ItemInit.mechan_module.get()).key('R', Items.REDSTONE).key('G', Items.FIRE_CHARGE)
				.patternLine("RGR").patternLine("AMA").patternLine("RGR")
				.addCriterion("has_mechan_module", hasItem(ItemInit.mechan_module.get())).build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.mechan_module_blade.get()).key('A', ItemInit.auric_ingot.get())
				.key('I', Items.IRON_SWORD).key('M', ItemInit.mechan_module.get()).key('G', Items.GUNPOWDER)
				.key('R', Items.REDSTONE).key('S', ItemInit.machina_soul.get()).patternLine("IAI").patternLine("RMG")
				.patternLine("SRS").addCriterion("has_mechan_module", hasItem(ItemInit.mechan_module.get()))
				.build(consumer);

		ShapedRecipeBuilder.shapedRecipe(ItemInit.mechan_module_thruster.get()).key('M', ItemInit.mechan_module.get())
				.key('K', ItemInit.machina_cage.get()).key('G', Items.FIRE_CHARGE).key('S', ItemInit.machina_soul.get())
				.key('F', ItemInit.destruction_orb_contained.get()).patternLine("GKG").patternLine("FMF")
				.patternLine("SGS").addCriterion("has_mechan_module", hasItem(ItemInit.mechan_module.get()))
				.build(consumer);

	}
}