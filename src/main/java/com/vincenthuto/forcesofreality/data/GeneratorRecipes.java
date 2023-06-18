package com.vincenthuto.forcesofreality.data;
//package com.vincenthuto.forcesofreality.datagen;
//
//import java.util.function.Consumer;
//
//import com.vincenthuto.forcesofreality.init.BlockInit;
//import com.vincenthuto.forcesofreality.init.ItemInit;
//
//import net.minecraft.data.DataGenerator;
//import net.minecraft.data.recipes.FinishedRecipe;
//import net.minecraft.data.recipes.RecipeProvider;
//import net.minecraft.data.recipes.ShapedRecipeBuilder;
//import net.minecraft.data.recipes.ShapelessRecipeBuilder;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraftforge.common.Tags;
//
//public class GeneratorRecipes extends RecipeProvider {
//	public GeneratorRecipes(DataGenerator generator) {
//		super(generator);
//	}
//
//	@Override
//	protected void buildShapelessRecipes(Consumer<FinishedRecipe> consumer) {
//
//		ShapelessRecipeBuilder.shapeless(ItemInit.writhing_thread.get(), 2).requires(Items.STRING, 1)
//				.requires(ItemInit.vitreous_humor.get(), 1).requires(Items.ENDER_PEARL, 2)
//				.unlockedBy("has_vitreous_humor", has(ItemInit.vitreous_humor.get())).save(consumer);
//
//		ShapelessRecipeBuilder.shapeless(ItemInit.ball_of_eyes.get()).requires(ItemInit.suspicious_eye.get(), 3)
//				.requires(ItemInit.vitreous_humor.get(), 2)
//				.unlockedBy("has_beastly_bone", has(ItemInit.suspicious_eye.get())).save(consumer);
//
//		ShapelessRecipeBuilder.shapeless(BlockInit.auspicious_bundle.get()).requires(Items.BONE, 2)
//				.requires(Items.STICK, 3).requires(ItemInit.beastly_bone.get(), 2).requires(Blocks.DIRT, 2)
//				.unlockedBy("has_beastly_bone", has(ItemInit.beastly_bone.get())).save(consumer);
//
//		// Misc
//
//		ShapelessRecipeBuilder.shapeless(ItemInit.vitreous_humor.get(), 1).requires(ItemInit.suspicious_eye.get())
//				.unlockedBy("has_suspicious_eye", has(ItemInit.suspicious_eye.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(BlockInit.gilded_wool.get()).define('K', Blocks.RED_WOOL)
//				.define('S', Tags.Items.NUGGETS_GOLD).pattern("SSS").pattern("SKS").pattern("SSS")
//				.unlockedBy("has_nuggets_gold", has(Tags.Items.NUGGETS_GOLD)).save(consumer);
//
//		ShapedRecipeBuilder.shaped(BlockInit.auric_block.get()).define('A', ItemInit.auric_ingot.get()).pattern("AAA")
//				.pattern("AAA").pattern("AAA").unlockedBy("has_auric_ingot", has(ItemInit.auric_ingot.get()))
//				.save(consumer);
//
//		ShapedRecipeBuilder.shaped(BlockInit.anointed_iron_block.get()).define('A', ItemInit.anointed_iron_scrap.get())
//				.pattern("AAA").pattern("AAA").pattern("AAA")
//				.unlockedBy("has_anointed_iron_scrap", has(ItemInit.anointed_iron_scrap.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.machina_cage.get()).define('A', Items.IRON_INGOT)
//				.define('S', ItemInit.machina_soul.get()).pattern("AAA").pattern("ASA").pattern(" A ")
//				.unlockedBy("has_machina_soul", has(ItemInit.machina_soul.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(BlockInit.bonsai_planter.get()).define('F', Tags.Items.INGOTS_BRICK)
//				.define('N', Blocks.DIRT).pattern("FNF").pattern("FFF").pattern("F F")
//				.unlockedBy("has_brick", has(Tags.Items.INGOTS_BRICK)).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.anointed_iron_helm.get()).define('R', ItemInit.anointed_iron_scrap.get())
//				.pattern("RRR").pattern("R R")
//				.unlockedBy("has_anointed_iron_scrap", has(ItemInit.anointed_iron_scrap.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.anointed_iron_chestplate.get())
//				.define('R', ItemInit.anointed_iron_scrap.get()).pattern("R R").pattern("RRR").pattern("RRR")
//				.unlockedBy("has_anointed_iron_scrap", has(ItemInit.anointed_iron_scrap.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.anointed_iron_leggings.get())
//				.define('R', ItemInit.anointed_iron_scrap.get()).pattern("RRR").pattern("R R").pattern("R R")
//				.unlockedBy("has_anointed_iron_scrap", has(ItemInit.anointed_iron_scrap.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.anointed_iron_boots.get()).define('R', ItemInit.anointed_iron_scrap.get())
//				.pattern("R R").pattern("R R")
//				.unlockedBy("has_anointed_iron_scrap", has(ItemInit.anointed_iron_scrap.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.anointed_iron_sword.get()).define('R', ItemInit.anointed_iron_scrap.get())
//				.define('N', Items.STICK).pattern("R").pattern("R").pattern("N")
//				.unlockedBy("has_anointed_iron_scrap", has(ItemInit.anointed_iron_scrap.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(BlockInit.ascendant_altar.get()).define('B', Items.QUARTZ_BLOCK)
//				.define('P', Items.QUARTZ_PILLAR).define('O', Items.GOLD_BLOCK).define('G', BlockInit.gilded_wool.get())
//				.pattern("BGB").pattern("POP").pattern("BOB")
//				.unlockedBy("has_gilded_wool", has(BlockInit.gilded_wool.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(BlockInit.untold_easel.get()).define('N', Items.STICK)
//				.define('T', ItemInit.unsettling_tapestry.get()).define('P', Items.FLOWER_POT)
//				.define('Y', ItemInit.yellow_sign.get()).pattern("TTT").pattern("PNY").pattern("N N")
//				.unlockedBy("has_yellow_sign", has(ItemInit.yellow_sign.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.occular_seed.get()).define('W', ItemInit.writhing_thread.get())
//				.define('E', ItemInit.ball_of_eyes.get()).pattern("W W").pattern(" E ").pattern("W W")
//				.unlockedBy("has_ball_of_eyes", has(ItemInit.ball_of_eyes.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(BlockInit.machina_imperfecta.get()).define('A', BlockInit.auric_block.get())
//				.define('N', ItemInit.malfunctioning_mechanism.get()).define('D', ItemInit.discared_gear.get())
//				.pattern("ADA").pattern("ANA").pattern("ADA")
//				.unlockedBy("has_discared_gear", has(ItemInit.discared_gear.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.writhing_helmet.get()).define('R', ItemInit.writhing_thread.get())
//				.define('V', ItemInit.vitreous_humor.get()).define('S', ItemInit.ball_of_eyes.get()).pattern("VSV")
//				.pattern("RRR").pattern("R R").unlockedBy("has_writhing_thread", has(ItemInit.writhing_thread.get()))
//				.save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.writhing_chestplate.get()).define('R', ItemInit.writhing_thread.get())
//				.define('E', ItemInit.ball_of_eyes.get()).pattern("R R").pattern("RER").pattern("RRR")
//				.unlockedBy("has_writhing_thread", has(ItemInit.writhing_thread.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.writhing_leggings.get()).define('R', ItemInit.writhing_thread.get())
//				.pattern("RRR").pattern("R R").pattern("R R")
//				.unlockedBy("has_writhing_thread", has(ItemInit.writhing_thread.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.writhing_boots.get()).define('R', ItemInit.writhing_thread.get())
//				.pattern("R R").pattern("R R").unlockedBy("has_writhing_thread", has(ItemInit.writhing_thread.get()))
//				.save(consumer);
////
////		ShapedRecipeBuilder.shapedRecipe(BlockInit.rafflesia_of_fidelity.get())
////				.key('R', BlockInit.rafflesia_flower.get()).key('I', BlockInit.anointed_iron_block.get())
////				.key('O', BlockInit.runed_obsidian.get()).key('F', BlockInit.vibratory_fuser.get())
////				.key('A', BlockInit.activated_obsidian.get()).patternLine("IRI").patternLine("IFI").patternLine("AOA")
////				.addCriterion("has_rafflesia_flower", hasItem(BlockInit.rafflesia_flower.get())).build(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.skull_helmet.get()).define('B', ItemInit.beastly_bone.get())
//				.define('F', ItemInit.blooddrawn_fang.get()).pattern("BBB").pattern("B B").pattern("FBF")
//				.unlockedBy("has_beastly_bone", has(ItemInit.beastly_bone.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.enticing_mantle.get()).define('B', ItemInit.beastly_bone.get())
//				.define('F', ItemInit.unkept_hide.get()).pattern("BFB").pattern("FFF").pattern("FFF")
//				.unlockedBy("has_beastly_bone", has(ItemInit.beastly_bone.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.legs_of_fawn.get()).define('B', ItemInit.beastly_bone.get())
//				.define('F', ItemInit.unkept_hide.get()).pattern("BFB").pattern("F F").pattern("F F")
//				.unlockedBy("has_beastly_bone", has(ItemInit.beastly_bone.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.cloven_hooves.get()).define('B', ItemInit.beastly_bone.get())
//				.define('F', ItemInit.unkept_hide.get()).pattern("BFB").pattern("B B")
//				.unlockedBy("has_beastly_bone", has(ItemInit.beastly_bone.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.mechan_module.get()).define('I', ItemInit.auric_ingot.get())
//				.define('M', ItemInit.malfunctioning_mechanism.get()).define('K', ItemInit.machina_cage.get())
//				.pattern("III").pattern("IMI").pattern("IKI")
//				.unlockedBy("has_auric_bar", has(ItemInit.auric_ingot.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.mechan_module_rocket.get()).define('A', ItemInit.auric_ingot.get())
//				.define('I', Items.IRON_INGOT).define('M', ItemInit.mechan_module.get()).define('G', Items.GUNPOWDER)
//				.pattern("A A").pattern("IMI").pattern("GGG")
//				.unlockedBy("has_mechan_module", has(ItemInit.mechan_module.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.mechan_module_salvo.get()).define('A', ItemInit.auric_ingot.get())
//				.define('F', ItemInit.malfunctioning_mechanism.get()).define('I', Items.IRON_INGOT)
//				.define('M', ItemInit.mechan_module_rocket.get()).define('G', Items.GUNPOWDER).pattern("AFA")
//				.pattern("IMI").pattern("GGG")
//				.unlockedBy("has_mechan_module_rocket", has(ItemInit.mechan_module_rocket.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.mechan_module_shortcircuit.get()).define('A', ItemInit.auric_ingot.get())
//				.define('M', ItemInit.mechan_module.get()).define('R', Items.REDSTONE).define('G', Items.GLOWSTONE)
//				.pattern("RGR").pattern("AMA").pattern("RGR")
//				.unlockedBy("has_mechan_module", has(ItemInit.mechan_module.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.mechan_module_laser.get()).define('A', ItemInit.auric_ingot.get())
//				.define('M', ItemInit.mechan_module.get()).define('R', Items.REDSTONE).define('G', Items.FIRE_CHARGE)
//				.pattern("RGR").pattern("AMA").pattern("RGR")
//				.unlockedBy("has_mechan_module", has(ItemInit.mechan_module.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.mechan_module_blade.get()).define('A', ItemInit.auric_ingot.get())
//				.define('I', Items.IRON_SWORD).define('M', ItemInit.mechan_module.get()).define('G', Items.GUNPOWDER)
//				.define('R', Items.REDSTONE).define('S', ItemInit.machina_soul.get()).pattern("IAI").pattern("RMG")
//				.pattern("SRS").unlockedBy("has_mechan_module", has(ItemInit.mechan_module.get())).save(consumer);
//
//		ShapedRecipeBuilder.shaped(ItemInit.mechan_module_thruster.get()).define('M', ItemInit.mechan_module.get())
//				.define('K', ItemInit.machina_cage.get()).define('G', Items.FIRE_CHARGE)
//				.define('S', ItemInit.machina_soul.get()).define('F', ItemInit.destruction_orb_contained.get())
//				.pattern("GKG").pattern("FMF").pattern("SGS")
//				.unlockedBy("has_mechan_module", has(ItemInit.mechan_module.get())).save(consumer);
//
//	}
//}