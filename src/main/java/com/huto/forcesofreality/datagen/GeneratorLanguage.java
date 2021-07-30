package com.huto.forcesofreality.datagen;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.font.ModTextFormatting;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.EnchantmentInit;
import com.huto.forcesofreality.init.EntityInit;
import com.huto.forcesofreality.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.enchantment.Enchantment;
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
		add("itemGroup.forcesofrealitytab", "Forces of Reality");
		add("key.forcesofreality.category", "Forces of Reality");
		// Biomes
		add("biome.forcesofreality.dream_land", "Dream Lands");
		// Death msgs
		add("death.attack.tentacle", "%1$s was tentacled to death");
		// Container
		add("container.virtuous_enchanter", "Virtuous Enchanter");
		// Jei
		add("forcesofreality.jei.wandmaker", "Wand Maker");
		add("forcesofreality.jei.resonator", "Vibrarory Resonator");
		add("forcesofreality.jei.vibefuser", "Vibrarory Conglomerator");
		add("forcesofreality.jei.chisel_station", "Chisel Station");
		// Enchantments
		for (RegistryObject<Enchantment> e : EnchantmentInit.ENCHANTS.getEntries()) {
			addEnchantment(e,
					ModTextFormatting.convertInitToLang(e.get().getName().replace("enchantment.forcesofreality.", "")));
		}
		for (RegistryObject<Block> b : BlockInit.BLOCKS.getEntries()) {
			addBlock(b, ModTextFormatting
					.convertInitToLang(b.get().asItem().getTranslationKey().replace("block.forcesofreality.", "")));
		}
		for (RegistryObject<Item> i : ItemInit.ITEMS.getEntries()) {
			addItem(i, ModTextFormatting
					.convertInitToLang(i.get().asItem().getTranslationKey().replace("item.forcesofreality.", "")));
		}
		for (RegistryObject<EntityType<?>> en : EntityInit.ENTITY_TYPES.getEntries()) {
			addEntityType(en,
					ModTextFormatting.convertInitToLang(en.get().getTranslationKey().replace("entity.forcesofreality.", "")));
		}

		/***
		 * Adornment Pattern Text
		 */
		// Misc
		add("name.RUNE", "Base Adornment");
		add("name.MAJOR", "Major Adornments");
		// Adornment Binder
		add("forcesofreality.nbtdata", "NBT Tags");
		add("forcesofreality.whitelist", "Whitelist");
		add("forcesofreality.autopickupenabled", "Auto-Pickup: Enabled");
		add("forcesofreality.autopickupdisabled", "Auto-Pickup: Disabled");
		add("forcesofreality.autopickup", "Auto-Pickup");
		add("forcesofreality.shift", "Press <Shift> for info.");

	}
}