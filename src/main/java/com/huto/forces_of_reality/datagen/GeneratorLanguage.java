package com.huto.forces_of_reality.datagen;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.font.ModTextFormatting;
import com.huto.forces_of_reality.init.BlockInit;
import com.huto.forces_of_reality.init.EnchantmentInit;
import com.huto.forces_of_reality.init.EntityInit;
import com.huto.forces_of_reality.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;

public class GeneratorLanguage extends LanguageProvider {
	public GeneratorLanguage(DataGenerator gen) {
		super(gen, ForcesOfReality.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		/***
		 * 
		 * Tabs,Tooltips,Keybinds, Etc
		 * 
		 */
		add("itemGroup.hutostab", "Forces of Reality");
		add("key.forces_of_reality.category", "Forces of Reality");
		// Biomes
		add("biome.forces_of_reality.dream_land", "Dream Lands");
		// Death msgs
		add("death.attack.tentacle", "%1$s was tentacled to death");
		// Container
		add("container.virtuous_enchanter", "Virtuous Enchanter");
		// Jei
		add("forces_of_reality.jei.wandmaker", "Wand Maker");
		add("forces_of_reality.jei.resonator", "Vibrarory Resonator");
		add("forces_of_reality.jei.vibefuser", "Vibrarory Conglomerator");
		add("forces_of_reality.jei.chisel_station", "Chisel Station");
		// Enchantments
		for (RegistryObject<Enchantment> e : EnchantmentInit.ENCHANTS.getEntries()) {
			addEnchantment(e,
					ModTextFormatting.convertInitToLang(e.get().getName().replace("enchantment.forces_of_reality.", "")));
		}
		for (RegistryObject<Block> b : BlockInit.BLOCKS.getEntries()) {
			addBlock(b, ModTextFormatting
					.convertInitToLang(b.get().asItem().getTranslationKey().replace("block.forces_of_reality.", "")));
		}
		for (RegistryObject<Item> i : ItemInit.ITEMS.getEntries()) {
			addItem(i, ModTextFormatting
					.convertInitToLang(i.get().asItem().getTranslationKey().replace("item.forces_of_reality.", "")));
		}
		for (RegistryObject<EntityType<?>> en : EntityInit.ENTITY_TYPES.getEntries()) {
			addEntityType(en,
					ModTextFormatting.convertInitToLang(en.get().getTranslationKey().replace("entity.forces_of_reality.", "")));
		}

		/***
		 * Rune Pattern Text
		 */
		// Misc
		add("name.RUNE", "Base Rune");
		add("name.CONTRACT", "Contract Runes");
		// Rune Binder
		add("forces_of_reality.nbtdata", "NBT Tags");
		add("forces_of_reality.whitelist", "Whitelist");
		add("forces_of_reality.autopickupenabled", "Auto-Pickup: Enabled");
		add("forces_of_reality.autopickupdisabled", "Auto-Pickup: Disabled");
		add("forces_of_reality.autopickup", "Auto-Pickup");
		add("forces_of_reality.shift", "Press <Shift> for info.");

	}
}