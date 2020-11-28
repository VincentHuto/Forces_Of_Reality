package com.huto.hutosmod.datagen;

import java.util.function.Consumer;

import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.init.ItemInit;

import net.minecraft.block.Blocks;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

public class GeneratorRecipes extends RecipeProvider {
	public GeneratorRecipes(DataGenerator generator) {
		super(generator);
	}
	@Override
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		
		CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ItemInit.raw_clay_flask.get()), ItemInit.cured_clay_flask.get(), 1f, 200);
		
		//Rune Patterns
	
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.ball_of_eyes.get()).
			addIngredient(ItemInit.suspicious_eye.get(),3).
			addIngredient(ItemInit.vitreous_humor.get(),2).
			addCriterion("has_beastly_bone", hasItem(ItemInit.suspicious_eye.get())).build(consumer);
		
		
		ShapelessRecipeBuilder.shapelessRecipe(BlockInit.auspicious_bundle.get()).
			addIngredient(Items.BONE,2).
			addIngredient(Items.STICK,3)
		  .addIngredient(ItemInit.beastly_bone.get(),2)
		  .addIngredient(Blocks.DIRT,2)
		  .addCriterion("has_beastly_bone", hasItem(ItemInit.beastly_bone.get())).build(consumer);
		
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.auric_ingot.get()).
		  addIngredient(Items.IRON_INGOT)
		  .addIngredient(ItemInit.machina_soul.get(),3)
		  .addCriterion("has_machina_soul", hasItem(ItemInit.machina_soul.get())).build(consumer);
		
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern.get()).
		  addIngredient(Items.PAPER)
		  .addIngredient(ItemInit.rune_blank.get())
		  .addCriterion("has_rune_blank", hasItem(ItemInit.rune_blank.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_beast_c.get()).
		   addIngredient(ItemInit.rune_pattern.get())
		  .addIngredient(Tags.Items.GEMS_DIAMOND)
		  .addIngredient(ItemInit.blooddrawn_fang.get())
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_beast.get()).
		   addIngredient(ItemInit.rune_pattern.get())
		  .addIngredient(Items.BEEF)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_clawmark.get()).
		   addIngredient(ItemInit.rune_pattern.get())
		  .addIngredient(Items.FLINT)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_communion.get()).
		   addIngredient(ItemInit.rune_pattern.get())
		  .addIngredient(Items.GHAST_TEAR)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_corruption_c.get()).
		   addIngredient(ItemInit.rune_pattern.get()).
		   addIngredient(ItemInit.nullifying_powder.get())
		  .addIngredient(Tags.Items.GEMS_DIAMOND)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_hunter_c.get()).
		   addIngredient(ItemInit.rune_pattern.get())
			  .addIngredient(Items.GOLDEN_SWORD)
		  .addIngredient(Tags.Items.GEMS_DIAMOND)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_heir.get()).
		   addIngredient(ItemInit.rune_pattern.get())
		  .addIngredient(Items.STRING)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_impurity_c.get()).
		   addIngredient(ItemInit.rune_pattern.get())
			  .addIngredient(Items.ROTTEN_FLESH)
		  .addIngredient(Tags.Items.GEMS_DIAMOND)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_lake.get()).
		   addIngredient(ItemInit.rune_pattern.get())
		  .addIngredient(Items.WATER_BUCKET)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		  
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_metamorphosis_cw.get()).
			   addIngredient(ItemInit.rune_pattern.get())
			  .addIngredient(Items.GOLDEN_APPLE)
			  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		  
		  
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_metamorphosis.get()).
			   addIngredient(ItemInit.rune_pattern.get())
			  .addIngredient(Items.GOLDEN_CARROT)
			  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_milkweed_c.get()).
		   addIngredient(ItemInit.rune_pattern.get())
		   .addIngredient(ItemInit.suspicious_eye.get())
		  .addIngredient(Tags.Items.GEMS_DIAMOND)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_moon.get()).
		   addIngredient(ItemInit.rune_pattern.get())
		  .addIngredient(Items.REDSTONE)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
	
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_oedon.get()).
		   addIngredient(ItemInit.rune_pattern.get())
		  .addIngredient(Items.RED_DYE)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_radiance_c.get()).
		   addIngredient(ItemInit.rune_pattern.get())
		   .addIngredient(Items.GLOWSTONE_DUST)
		  .addIngredient(Tags.Items.GEMS_DIAMOND)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.rune_pattern_rapture.get()).
		   addIngredient(ItemInit.rune_pattern.get())
		   .addIngredient(Items.GLOWSTONE_DUST)
		  .addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
		
		//Misc
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.vitreous_humor.get(),1)
		  .addIngredient(ItemInit.suspicious_eye.get())
		  .addCriterion("has_suspicious_eye", hasItem(ItemInit.suspicious_eye.get())).build(consumer);
		
/*		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.vitreous_humor.get(),3)
		  .addIngredient(ItemInit.ball_of_eyes.get())
		  .addCriterion("has_ball_of_eyes", hasItem(ItemInit.ball_of_eyes.get())).build(consumer);*/
		
		ShapelessRecipeBuilder.shapelessRecipe(BlockInit.vibratory_capacitor.get(),3)
		  .addIngredient(BlockInit.vibratory_storage_drum.get())
		  .addCriterion("has_vibratory_storage_drum", hasItem(BlockInit.vibratory_storage_drum.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.singeri_soup.get()).
		  addIngredient(BlockInit.singeri_mushroom.get(),3)
		  .addIngredient(Items.BOWL)
		  .addCriterion("has_singeri_mushroom", hasItem(BlockInit.singeri_mushroom.get()
				  )).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.mystic_tome.get()).
		  addIngredient(ItemInit.mana_powder.get(),3)
		  .addIngredient(Items.BOOK)
		  .addCriterion("has_mana_powder", hasItem(ItemInit.mana_powder.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.raw_morel_on_a_stick.get()).
		  addIngredient(BlockInit.morel_mushroom.get(),3)
		  .addIngredient(Items.STICK)
		  .addCriterion("has_morel_mushroom", hasItem(BlockInit.morel_mushroom.get())).build(consumer);
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.mana_bottle.get()).
		  addIngredient(BlockInit.passion_flower.get())
		  .addIngredient(ItemInit.mana_powder.get(),2)
		  .addIngredient(Items.GLASS_BOTTLE)
		  .addCriterion("has_passion_flower", hasItem(BlockInit.passion_flower.get())).build(consumer);
		
		
		ShapelessRecipeBuilder.shapelessRecipe(ItemInit.channeling_ingot.get()).
			  addIngredient(Tags.Items.INGOTS_IRON)
			  .addIngredient(ItemInit.mana_powder.get(),2)
			  .addCriterion("has_iron_ingot", hasItem(Tags.Items.INGOTS_IRON)).build(consumer);
		
		 ShapelessRecipeBuilder.shapelessRecipe(ItemInit.grey_powder.get(),3).
			  addIngredient(Tags.Items.GUNPOWDER)
			 .addIngredient(Tags.Items.GEMS_QUARTZ)
			 .addIngredient(Items.BONE_MEAL,3)		  
			 .addCriterion("has_runed_obsidian", hasItem(Items.BONE_MEAL)).build(consumer);

		  ShapelessRecipeBuilder.shapelessRecipe(ItemInit.nullifying_powder.get(),3).
			  addIngredient(ItemInit.mana_powder.get())
			  .addIngredient(ItemInit.grey_powder.get())
			 .addIngredient(Tags.Items.GUNPOWDER)
			 .addIngredient(Items.REDSTONE,3)		  
			 .addCriterion("has_runed_obsidian", hasItem(Items.BONE_MEAL)).build(consumer);

		  ShapelessRecipeBuilder.shapelessRecipe(BlockInit.runed_obsidian.get()).
		  addIngredient(Items.FLINT)
		  .addIngredient(Tags.Items.OBSIDIAN)
		  .addCriterion("has_flint", hasItem(Items.FLINT)).build(consumer);
		 
		  ShapelessRecipeBuilder.shapelessRecipe(BlockInit.anti_planks.get(),4).
		  addIngredient(BlockInit.anti_log.get())
		  .addCriterion("has_anti_log", hasItem(BlockInit.anti_log.get())).build(consumer);
		  
		  ShapelessRecipeBuilder.shapelessRecipe(BlockInit.mystic_planks.get(),4).
		  addIngredient(BlockInit.mystic_log.get())
		  .addCriterion("has_mystic_log", hasItem(BlockInit.mystic_log.get())).build(consumer);
		 
		  ShapelessRecipeBuilder.shapelessRecipe(ItemInit.channeling_rod.get(),1).
		  addIngredient(ItemInit.mana_powder.get(),3)
		  .addIngredient(Items.STICK)
		  .addCriterion("has_mana_powder", hasItem(ItemInit.mana_powder.get())).build(consumer);
		  
		  ShapedRecipeBuilder.shapedRecipe(BlockInit.contained_magma.get())
			.key('N', Tags.Items.INGOTS_NETHER_BRICK)
			.key('O', Blocks.MAGMA_BLOCK)
			.key('P', ItemInit.nullifying_powder.get())
			.patternLine("NON")
			.patternLine("OPO")
			.patternLine("NON")
			.addCriterion("has_nullifying_powder", hasItem( ItemInit.nullifying_powder.get())).build(consumer);
		  
		  
		  ShapedRecipeBuilder.shapedRecipe(BlockInit.nether_block.get())
			.key('N', Tags.Items.INGOTS_NETHER_BRICK)
			.key('O', Tags.Items.OBSIDIAN)
			.key('P', ItemInit.nullifying_powder.get())
			.patternLine("NON")
			.patternLine("OPO")
			.patternLine("NON")
			.addCriterion("has_nullifying_powder", hasItem( ItemInit.nullifying_powder.get())).build(consumer);
		  
		  ShapedRecipeBuilder.shapedRecipe(ItemInit.energy_focus.get())
			.key('N', ItemInit.phantasmal_pane.get())
			.key('O', Tags.Items.INGOTS_GOLD)
			.key('P', ItemInit.nullifying_powder.get())
			.patternLine("NON")
			.patternLine("OPO")
			.patternLine("NON")
			.addCriterion("has_phantasmal_pane", hasItem( ItemInit.phantasmal_pane.get())).build(consumer);
		  
		  ShapedRecipeBuilder.shapedRecipe(ItemInit.absorber_configurer.get())
			.key('S', ItemInit.null_rod.get())
			.key('Q', Tags.Items.GEMS_QUARTZ)
			.key('E', Tags.Items.GEMS_EMERALD)
			.key('A', ItemInit.gem_amethyst.get())
			.key('R', ItemInit.gem_ruby.get())			
			.patternLine(" EQ")
			.patternLine(" RA")
			.patternLine("S  ")
			.addCriterion("has_null_rod", hasItem( ItemInit.null_rod.get())).build(consumer);
		  
		  
		  ShapedRecipeBuilder.shapedRecipe(ItemInit.frequency_matcher.get())
			.key('S', ItemInit.null_rod.get())
			.key('B', ItemInit.upgrade_blank.get())
			.key('Q', ItemInit.gem_opal.get())			
			.patternLine(" BQ")
			.patternLine(" SB")
			.patternLine("S  ")
			.addCriterion("has_gem_opal", hasItem( ItemInit.gem_opal.get())).build(consumer);
		 
		  
		  ShapedRecipeBuilder.shapedRecipe(ItemInit.anti_tear.get())
			.key('K', ItemInit.essence_drop.get())
			.key('S', ItemInit.nullifying_powder.get())
			.patternLine("SSS")
			.patternLine("SKS")
			.patternLine("SSS")
			.addCriterion("has_essence_drop", hasItem(ItemInit.essence_drop.get())).build(consumer);
		  
		ShapedRecipeBuilder.shapedRecipe(BlockInit.gilded_wool.get())
			.key('K', Blocks.RED_WOOL)
			.key('S', Tags.Items.NUGGETS_GOLD)
			.patternLine("SSS")
			.patternLine("SKS")
			.patternLine("SSS")
			.addCriterion("has_nuggets_gold", hasItem( Tags.Items.NUGGETS_GOLD)).build(consumer);
		  
		 ShapedRecipeBuilder.shapedRecipe(ItemInit.grand_purging_stone.get())
			.key('K', ItemInit.purging_stone.get())
			.key('S', ItemInit.karmic_drop.get())
			.patternLine("SSS")
			.patternLine("SKS")
			.patternLine("SSS")
			.addCriterion("has_purging_stone", hasItem( ItemInit.purging_stone.get())).build(consumer);
		  
		  ShapedRecipeBuilder.shapedRecipe(ItemInit.purging_stone.get())
				.key('K', Tags.Items.STONE)
				.key('S', ItemInit.karmic_drop.get())
				.key('A', ItemInit.nullifying_powder.get())
				.patternLine("SAS")
				.patternLine("SKS")
				.patternLine("SSS")
				.addCriterion("has_karmic_drop", hasItem( ItemInit.karmic_drop.get())).build(consumer);
		  
		  
		  ShapedRecipeBuilder.shapedRecipe(BlockInit.enchanted_stone.get())
			.key('K', Tags.Items.STONE)
			.key('S', ItemInit.mana_powder.get())
			.patternLine("SSS")
			.patternLine("SKS")
			.patternLine("SSS")
			.addCriterion("has_mana_powder", hasItem(ItemInit.mana_powder.get())).build(consumer);
		  
		  ShapedRecipeBuilder.shapedRecipe(BlockInit.auric_block.get())
			.key('A', ItemInit.auric_ingot.get())
			.patternLine("AAA")
			.patternLine("AAA")
			.patternLine("AAA")
			.addCriterion("has_auric_ingot", hasItem(ItemInit.auric_ingot.get())).build(consumer);
		  
		  ShapedRecipeBuilder.shapedRecipe(BlockInit.old_iron_block.get())
			.key('A', ItemInit.old_iron_scrap.get())
			.patternLine("AAA")
			.patternLine("AAA")
			.patternLine("AAA")
			.addCriterion("has_old_iron_scrap", hasItem(ItemInit.old_iron_scrap.get())).build(consumer);
		  
		  ShapedRecipeBuilder.shapedRecipe(ItemInit.rune_blank.get())
			.key('N', BlockInit.runed_obsidian.get())
			.key('O', BlockInit.mind_fog.get())
			.key('P', ItemInit.anti_tear.get())
			.patternLine("NON")
			.patternLine("OPO")
			.patternLine("NON")
			.addCriterion("has_runed_obsidian", hasItem(BlockInit.runed_obsidian.get())).build(consumer);
		  
		  ShapedRecipeBuilder.shapedRecipe(BlockInit.bonsai_planter.get())
			.key('F', Tags.Items.INGOTS_BRICK)
			.key('N', Blocks.DIRT)
			.patternLine("FNF")
			.patternLine("FFF")
			.patternLine("F F")
			.addCriterion("has_brick", hasItem(Tags.Items.INGOTS_BRICK)).build(consumer);
		  
		ShapedRecipeBuilder.shapedRecipe(BlockInit.vibratory_accelerometer.get())
				.key('R', BlockInit.runed_obsidian.get())
				.key('E', ItemInit.energy_focus.get())
				.key('A',	BlockInit.activated_obsidian.get())
				.key('N', BlockInit.nether_block.get())
				.key('O', Blocks.OBSIDIAN)
				.patternLine("EOE")
				.patternLine("RNR")
				.patternLine("AAA")
				.addCriterion("has_runed_obsidian", hasItem(BlockInit.runed_obsidian.get())).build(consumer);
		
		  ShapedRecipeBuilder.shapedRecipe(ItemInit.iron_knapper.get())
				.key('N',Items.STICK)
				.key('P', Tags.Items.INGOTS_IRON)
				.patternLine("  P")
				.patternLine(" N ")
				.patternLine("N  ")
				.addCriterion("has_iron_ingot", hasItem(Tags.Items.INGOTS_IRON)).build(consumer);
		
		  ShapedRecipeBuilder.shapedRecipe(ItemInit.obsidian_knapper.get())
				.key('N',ItemInit.null_rod.get())
				.key('P', BlockInit.runed_obsidian.get())
				.patternLine("  P")
				.patternLine(" N ")
				.patternLine("N  ")
				.addCriterion("has_runed_obsidian", hasItem(BlockInit.runed_obsidian.get())).build(consumer);
		
		  
			ShapedRecipeBuilder.shapedRecipe(BlockInit.karmic_altar.get())
				.key('R', BlockInit.runed_obsidian.get())
				.key('E',ItemInit.energy_focus.get())
				.key('A', BlockInit.activated_obsidian.get())
				.key('N', BlockInit.nether_block.get())
				.key('B', Items.BLAZE_POWDER)
				.patternLine("EBE")
				.patternLine("RAR")
				.patternLine("NRN")
				.addCriterion("has_energy_focus", hasItem(ItemInit.energy_focus.get())).build(consumer);
		  
		  
			ShapedRecipeBuilder.shapedRecipe(ItemInit.magatamabead.get())
				.key('N',Tags.Items.OBSIDIAN)
				.key('P', ItemInit.mana_powder.get())
				.patternLine("NNN")
				.patternLine("NNN")
				.patternLine(" PN")
				.addCriterion("has_obsidian", hasItem(Tags.Items.OBSIDIAN)).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.maker_activator.get())
				.key('N', BlockInit.nether_block.get())
				.key('F', ItemInit.energy_focus.get())
				.key('C',ItemInit.mana_crystal.get())
				.key('S', BlockInit.enchanted_stone_smooth.get())
				.patternLine("F F")
				.patternLine("NCN")
				.patternLine("SSS")
				.addCriterion("has_energy_focus", hasItem(ItemInit.energy_focus.get())).build(consumer);
			
	
			
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.vibration_debug_tool.get())
				.key('C', ItemInit.channeling_ingot.get())
				.key('U', ItemInit.upgrade_blank.get())
				.key('E', ItemInit.essence_drop.get())
				.patternLine("EUE")
				.patternLine(" C ")
				.patternLine(" C ")
				.addCriterion("has_essence_drop", hasItem(ItemInit.essence_drop.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.mana_extractor.get())
				.key('N', BlockInit.nether_block.get())
				.key('F', ItemInit.energy_focus.get())
				.key('C',ItemInit.mana_crystal.get())
				.key('R', BlockInit.runed_obsidian.get())
				.key('P', ItemInit.mana_powder.get())
				.patternLine("F F")
				.patternLine("NCN")
				.patternLine("RPR")
				.addCriterion("has_energy_focus", hasItem(ItemInit.energy_focus.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(BlockInit.vibratory_fuser.get())
				.key('A', BlockInit.activated_obsidian.get())
				.key('E', ItemInit.energy_focus.get())
				.key('N',BlockInit.nether_block.get())
				.key('R', BlockInit.runed_obsidian.get())
				.patternLine("ERE")
				.patternLine("N N")
				.patternLine("NAN")
				.addCriterion("has_energy_focus", hasItem(ItemInit.energy_focus.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.vibrational_seer.get())
				.key('G', Tags.Items.INGOTS_GOLD)
				.key('E', ItemInit.essence_drop.get())
				.patternLine("GGG")
				.patternLine("GEG")
				.patternLine(" G ")
				.addCriterion("has_essence_drop", hasItem(ItemInit.essence_drop.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.mind_spike.get())
				.key('B', ItemInit.null_ingot.get())
				.key('E', ItemInit.essence_drop.get())
				.key('N', ItemInit.null_rod.get())
				.patternLine("  N")
				.patternLine("EBE")
				.patternLine("BBE")
				.addCriterion("has_null_ingot", hasItem(ItemInit.null_ingot.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.raw_clay_flask.get())
				.key('C', Items.CLAY_BALL)
				.patternLine(" C ")
				.patternLine("C C")
				.patternLine("CCC")
				.addCriterion("has_clay", hasItem(Items.CLAY_BALL)).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.readied_pane.get(),4)
				.key('R', Items.REDSTONE)
				.key('G', Tags.Items.GLASS)
				.key('O', Tags.Items.OBSIDIAN)
				.patternLine("ORO")
				.patternLine("RGR")
				.patternLine("ORO")
				.addCriterion("has_glass", hasItem(Tags.Items.GLASS)).build(consumer);
		
			ShapedRecipeBuilder.shapedRecipe(ItemInit.rune_binder.get())
				.key('R', ItemInit.rune_pattern.get())
				.key('G', ItemInit.grey_ingot.get())
				.patternLine("GGG")
				.patternLine("GRG")
				.patternLine("GGG")
				.addCriterion("has_rune_pattern", hasItem(ItemInit.rune_pattern.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(BlockInit.wand_maker.get())
				.key('N', BlockInit.nether_block.get())
				.key('F', ItemInit.energy_focus.get())
				.key('R', BlockInit.runed_obsidian.get())
				.key('M', ItemInit.magatamabead.get())
				.patternLine("MFM")
				.patternLine("MNM")
				.patternLine("RRR")
				.addCriterion("has_energy_focus", hasItem(ItemInit.energy_focus.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.upgrade_wrench.get())
				.key('R', ItemInit.channeling_rod.get())
				.key('C', ItemInit.channeling_ingot.get())
				.key('U', ItemInit.upgrade_blank.get())
				.patternLine("  U")
				.patternLine(" C ")
				.patternLine("R  ")
				.addCriterion("has_upgrade_blank", hasItem(ItemInit.upgrade_blank.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.upgrade_blank.get())
				.key('R', ItemInit.nullifying_powder.get())
				.key('G', Tags.Items.INGOTS_GOLD)
				.patternLine("GGG")
				.patternLine("GRG")
				.patternLine("GGG")
				.addCriterion("has_nullifying_powder", hasItem(ItemInit.nullifying_powder.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.old_iron_helm.get())
				.key('R', ItemInit.old_iron_scrap.get())
				.patternLine("RRR")
				.patternLine("R R")
				.addCriterion("has_old_iron_scrap", hasItem(ItemInit.old_iron_scrap.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.old_iron_chestplate.get())
				.key('R', ItemInit.old_iron_scrap.get())
				.patternLine("R R")
				.patternLine("RRR")
				.patternLine("RRR")
				.addCriterion("has_old_iron_scrap", hasItem(ItemInit.old_iron_scrap.get())).build(consumer);
			
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.old_iron_leggings.get())
				.key('R', ItemInit.old_iron_scrap.get())
				.patternLine("RRR")
				.patternLine("R R")
				.patternLine("R R")
				.addCriterion("has_old_iron_scrap", hasItem(ItemInit.old_iron_scrap.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.old_iron_boots.get())
				.key('R', ItemInit.old_iron_scrap.get())
				.patternLine("R R")
				.patternLine("R R")
				.addCriterion("has_old_iron_scrap", hasItem(ItemInit.old_iron_scrap.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.old_iron_sword.get())
				.key('R', ItemInit.old_iron_scrap.get())
				.key('N', ItemInit.null_rod.get())
				.patternLine("R")
				.patternLine("R")
				.patternLine("N")
				.addCriterion("has_old_iron_scrap", hasItem(ItemInit.old_iron_scrap.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(BlockInit.ascendent_altar.get())
				.key('B', Items.QUARTZ_BLOCK)
				.key('P', Items.QUARTZ_PILLAR)
				.key('O', Items.GOLD_BLOCK)
				.key('G', BlockInit.gilded_wool.get())
				.patternLine("BGB")
				.patternLine("POP")
				.patternLine("BOB")
				.addCriterion("has_gilded_wool", hasItem(BlockInit.gilded_wool.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(BlockInit.untold_easel.get())
				.key('N', ItemInit.null_rod.get())
				.key('T', ItemInit.unsettling_tapestry.get())
				.key('P', Items.FLOWER_POT)
				.key('Y', ItemInit.yellow_sign.get())
				.patternLine("TTT")
				.patternLine("PNY")
				.patternLine("N N")
				.addCriterion("has_yellow_sign", hasItem(ItemInit.yellow_sign.get())).build(consumer);
			
			ShapedRecipeBuilder.shapedRecipe(ItemInit.occular_seed.get())
				.key('W', ItemInit.writhing_thread.get())
				.key('E', ItemInit.ball_of_eyes.get())
				.patternLine("W W")
				.patternLine(" E ")
				.patternLine("W W")
				.addCriterion("has_ball_of_eyes", hasItem(ItemInit.ball_of_eyes.get())).build(consumer);
			
			
	}
}