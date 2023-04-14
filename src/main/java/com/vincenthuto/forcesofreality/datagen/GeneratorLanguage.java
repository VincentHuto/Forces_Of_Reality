package com.vincenthuto.forcesofreality.datagen;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.font.ModTextFormatting;
import com.vincenthuto.forcesofreality.init.BlockInit;
import com.vincenthuto.forcesofreality.init.EnchantmentInit;
import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.forcesofreality.init.ItemInit;

import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class GeneratorLanguage extends LanguageProvider {
	public GeneratorLanguage(PackOutput gen) {
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
			addEnchantment(e, ModTextFormatting
					.convertInitToLang(e.get().getDescriptionId().replace("enchantment.forcesofreality.", "")));
		}
		for (RegistryObject<Block> b : BlockInit.BLOCKS.getEntries()) {
			addBlock(b, ModTextFormatting
					.convertInitToLang(b.get().asItem().getDescriptionId().replace("block.forcesofreality.", "")));
		}
		for (RegistryObject<Item> i : ItemInit.ITEMS.getEntries()) {
			addItem(i, ModTextFormatting
					.convertInitToLang(i.get().asItem().getDescriptionId().replace("item.forcesofreality.", "")));
		}
		for (RegistryObject<EntityType<?>> en : EntityInit.ENTITY_TYPES.getEntries()) {
			addEntityType(en, ModTextFormatting
					.convertInitToLang(en.get().getDescriptionId().replace("entity.forcesofreality.", "")));
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