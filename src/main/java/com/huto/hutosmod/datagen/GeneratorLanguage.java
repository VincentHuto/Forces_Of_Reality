package com.huto.hutosmod.datagen;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.font.ModTextFormatting;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.init.EnchantmentInit;
import com.huto.hutosmod.init.EntityInit;
import com.huto.hutosmod.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;

public class GeneratorLanguage extends LanguageProvider {
	public GeneratorLanguage(DataGenerator gen) {
		super(gen, HutosMod.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		/***
		 * 
		 * Tabs,Tooltips,Keybinds, Etc
		 * 
		 */
		add("itemGroup.hutostab", "Forces of Reality");
		add("key.hutosmod.category", "Forces of Reality");
		// Biomes
		add("biome.hutosmod.dream_land", "Dream Lands");
		// Death msgs
		add("death.attack.tentacle", "%1$s was tentacled to death");
		// Container
		add("container.virtuous_enchanter", "Virtuous Enchanter");
		// Jei
		add("hutosmod.jei.wandmaker", "Wand Maker");
		add("hutosmod.jei.resonator", "Vibrarory Resonator");
		add("hutosmod.jei.vibefuser", "Vibrarory Conglomerator");
		add("hutosmod.jei.chisel_station", "Chisel Station");
		// Enchantments
		for (RegistryObject<Enchantment> e : EnchantmentInit.ENCHANTS.getEntries()) {
			addEnchantment(e,
					ModTextFormatting.convertInitToLang(e.get().getName().replace("enchantment.hutosmod.", "")));
		}
		for (RegistryObject<Block> b : BlockInit.BLOCKS.getEntries()) {
			addBlock(b, ModTextFormatting
					.convertInitToLang(b.get().asItem().getTranslationKey().replace("block.hutosmod.", "")));
		}
		for (RegistryObject<Item> i : ItemInit.ITEMS.getEntries()) {
			addItem(i, ModTextFormatting
					.convertInitToLang(i.get().asItem().getTranslationKey().replace("item.hutosmod.", "")));
		}
		for (RegistryObject<EntityType<?>> en : EntityInit.ENTITY_TYPES.getEntries()) {
			addEntityType(en,
					ModTextFormatting.convertInitToLang(en.get().getTranslationKey().replace("entity.hutosmod.", "")));
		}

		/***
		 * Rune Pattern Text
		 */
		// Misc
		add("name.RUNE", "Base Rune");
		add("name.CONTRACT", "Contract Runes");
		// Rune Binder
		add("hutosmod.nbtdata", "NBT Tags");
		add("hutosmod.whitelist", "Whitelist");
		add("hutosmod.autopickupenabled", "Auto-Pickup: Enabled");
		add("hutosmod.autopickupdisabled", "Auto-Pickup: Disabled");
		add("hutosmod.autopickup", "Auto-Pickup");
		add("hutosmod.shift", "Press <Shift> for info.");

	}
}