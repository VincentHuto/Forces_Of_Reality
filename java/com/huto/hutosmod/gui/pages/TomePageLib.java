package com.huto.hutosmod.gui.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.init.ItemInit;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

public class TomePageLib {

	// This is the page array for the book, needed because i dont know how to add
	// the pages to their own like sub class
	public static List<GuiTomePage> IntroPageList = new ArrayList<GuiTomePage>();
	public static List<GuiTomePage> KarmaPageList = new ArrayList<GuiTomePage>();
	public static List<GuiTomePage> WorldGenPageList = new ArrayList<GuiTomePage>();
	public static List<GuiTomePage> ArmorPageList = new ArrayList<GuiTomePage>();
	public static List<GuiTomePage> BlocksPageList = new ArrayList<GuiTomePage>();
	public static List<GuiTomePage> GeneratePageList = new ArrayList<GuiTomePage>();
	public static List<GuiTomePage> WandsPageList = new ArrayList<GuiTomePage>();
	public static List<GuiTomePage> RunesPageList = new ArrayList<GuiTomePage>();
	public static List<GuiTomePage> ElderPageList = new ArrayList<GuiTomePage>();
	public static List<GuiTomePageTOC> TOCPageList = new ArrayList<GuiTomePageTOC>();
	public static List<List<GuiTomePage>> ChapterList = new ArrayList<List<GuiTomePage>>();

	// Text Locations
	public static String INTRO_PAGE_1 = "title.mystictome.intro.page.1.text";
	public static String INTRO_PAGE_2 = "title.mystictome.intro.page.2.text";
	public static String INTRO_PAGE_3 = "title.mystictome.intro.page.3.text";
	public static String INTRO_PAGE_4 = "title.mystictome.intro.page.4.text";
	public static String INTRO_PAGE_5 = "title.mystictome.intro.page.5.text";
	public static String INTRO_PAGE_6 = "title.mystictome.intro.page.6.text";
	public static String INTRO_PAGE_7 = "title.mystictome.intro.page.7.text";

	// World
	public static String WORLD_PAGE_1 = "title.mystictome.world.page.1.text";
	public static String WORLD_PAGE_2 = "title.mystictome.world.page.2.text";
	public static String WORLD_PAGE_3 = "title.mystictome.world.page.3.text";
	public static String WORLD_PAGE_4 = "title.mystictome.world.page.4.text";
	public static String WORLD_PAGE_5 = "title.mystictome.world.page.5.text";

	// Equips
	public static String EQUIP_PAGE_1 = "title.mystictome.equip.page.1.text";
	public static String EQUIP_PAGE_2 = "title.mystictome.equip.page.2.text";

	// Machines
	public static String MACHINE_PAGE_1 = "title.mystictome.blocks.page.1.text";
	public static String MACHINE_PAGE_2 = "title.mystictome.blocks.page.2.text";
	public static String MACHINE_PAGE_3 = "title.mystictome.blocks.page.3.text";
	public static String MACHINE_PAGE_4 = "title.mystictome.blocks.page.4.text";
	public static String MACHINE_PAGE_5 = "title.mystictome.blocks.page.5.text";
	public static String MACHINE_PAGE_6 = "title.mystictome.blocks.page.6.text";
	public static String MACHINE_PAGE_7 = "title.mystictome.blocks.page.7.text";
	public static String MACHINE_PAGE_8 = "title.mystictome.blocks.page.8.text";

	// Generate
	public static String GENERATION_PAGE_1 = "title.mystictome.blocks.page.1.text";

	// Wands
	public static String WANDS_PAGE_1 = "title.mystictome.wands.page.1.text";
	// Runes
	public static String RUNES_PAGE_1 = "title.mystictome.runes.page.1.text";
	public static String RUNES_PAGE_2 = "title.mystictome.runes.page.2.text";

	// Karma
	public static String KARMA_PAGE_1 = "title.mystictome.karma.page.1.text";
	// Elder
	public static String ELDER_PAGE_1 = "title.mystictome.elder.page.1.text";
	public static String ELDER_PAGE_2 = "title.mystictome.elder.page.2.text";
	public static String ELDER_PAGE_3 = "title.mystictome.elder.page.3.text";

	public static void registerPages() {

		IntroPageList.clear();
		KarmaPageList.clear();
		WorldGenPageList.clear();
		ArmorPageList.clear();
		BlocksPageList.clear();
		GeneratePageList.clear();
		WandsPageList.clear();
		RunesPageList.clear();
		ElderPageList.clear();
		ChapterList.clear();
		TOCPageList.clear();

		// Intro
		IntroPageList.add(new GuiTomePage(1, EnumTomeCatagories.INTRO, "In the Begining", "It Started Somewhere",
				new ItemStack(ItemInit.channeling_ingot.get()), I18n.format(INTRO_PAGE_1)));
		IntroPageList.add(new GuiTomePage(2, EnumTomeCatagories.INTRO, "Duality of Nature", "Yin and Yang",
				new ItemStack(ItemInit.magatamabead.get()), I18n.format(INTRO_PAGE_2)));
		IntroPageList.add(new GuiTomePage(3, EnumTomeCatagories.INTRO, "Vibes", "Cosmic Vibrations",
				new ItemStack(ItemInit.energy_focus.get()), I18n.format(INTRO_PAGE_3)));
		IntroPageList.add(new GuiTomePage(4, EnumTomeCatagories.INTRO, "A World of Essence", "Only the Essentials",
				new ItemStack(ItemInit.essence_drop.get()), I18n.format(INTRO_PAGE_4)));
		IntroPageList.add(new GuiTomePage(5, EnumTomeCatagories.INTRO, "Channeling Basics", "Use the Force",
				new ItemStack(ItemInit.channeling_rod.get()), I18n.format(INTRO_PAGE_5)));
		IntroPageList.add(new GuiTomePage(6, EnumTomeCatagories.INTRO, "Nullification", "Counter Attack",
				new ItemStack(ItemInit.null_crystal.get()), I18n.format(INTRO_PAGE_6)));
		IntroPageList.add(new GuiTomePage(7, EnumTomeCatagories.INTRO, "Vital Essence", "The Power of Vitals",
				new ItemStack(ItemInit.null_ingot.get()), I18n.format(INTRO_PAGE_7)));

		// Karma

		KarmaPageList.add(new GuiTomePage(1, EnumTomeCatagories.KARMA, "Karma", "Be careful what you do",
				new ItemStack(ItemInit.karmic_drop.get()), I18n.format(KARMA_PAGE_1)));

		// World Gen

		WorldGenPageList.add(new GuiTomePage(1, EnumTomeCatagories.WORLDGEN, "The World", "Its all Natural!",
				new ItemStack(BlockInit.mystic_earth.get()), I18n.format(WORLD_PAGE_1)));
		WorldGenPageList.add(new GuiTomePage(2, EnumTomeCatagories.WORLDGEN, "Plants", "Vibrational Flora",
				new ItemStack(BlockInit.mystic_sapling.get()), I18n.format(WORLD_PAGE_2)));
		WorldGenPageList.add(new GuiTomePage(3, EnumTomeCatagories.WORLDGEN, "DreamScape", "Page 3",
				new ItemStack(BlockInit.mystic_media.get()), I18n.format(WORLD_PAGE_3)));
		WorldGenPageList.add(new GuiTomePage(4, EnumTomeCatagories.WORLDGEN, "Access", "Mysterious Mask",
				new ItemStack(ItemInit.anti_tear.get()), I18n.format(WORLD_PAGE_4)));
		WorldGenPageList.add(new GuiTomePage(5, EnumTomeCatagories.WORLDGEN, "Nightmares", "The Bad Place",
				new ItemStack(BlockInit.nightmare_earth.get()), I18n.format(WORLD_PAGE_5)));

		// Weapons and Armor
		ArmorPageList.add(new GuiTomePage(1, EnumTomeCatagories.EQUIPS, "Equipables", "Form AND Function",
				new ItemStack(ItemInit.null_chestplate.get()), I18n.format(EQUIP_PAGE_1)));
		ArmorPageList.add(new GuiTomePage(2, EnumTomeCatagories.EQUIPS, "Visualization", "Know what you got",
				new ItemStack(ItemInit.vibrational_seer.get()), I18n.format(EQUIP_PAGE_2)));
		// Machines
		BlocksPageList.add(new GuiTomePage(1, EnumTomeCatagories.MACHINES, "Mana Belljar", "Clunky but works",
				new ItemStack(BlockInit.vibratory_accelerometer.get()), I18n.format(MACHINE_PAGE_3)));
		BlocksPageList.add(new GuiTomePage(2, EnumTomeCatagories.MACHINES, "Mana Storage", "Its like a cool battery",
				new ItemStack(BlockInit.vibratory_storage_drum.get()), I18n.format(MACHINE_PAGE_4)));
		BlocksPageList.add(new GuiTomePage(3, EnumTomeCatagories.MACHINES, "Mana Resonator", "Infusing and Upgrading",
				new ItemStack(BlockInit.vibe_resonator.get()), I18n.format(MACHINE_PAGE_5)));
		BlocksPageList.add(new GuiTomePage(4, EnumTomeCatagories.MACHINES, "Mana Collider", "Mix this and that...",
				new ItemStack(BlockInit.vibratory_fuser.get()), I18n.format(MACHINE_PAGE_6)));
		BlocksPageList.add(new GuiTomePage(5, EnumTomeCatagories.MACHINES, "Wand Fabricator", "Channeling finally",
				new ItemStack(BlockInit.wand_maker.get()), I18n.format(MACHINE_PAGE_8)));
		BlocksPageList.add(new GuiTomePage(6, EnumTomeCatagories.MACHINES, "Karmic Extractor", "Clean yourself up",
				new ItemStack(BlockInit.karmic_extractor.get()), I18n.format(MACHINE_PAGE_7)));

		// Generate
		GeneratePageList.add(new GuiTomePage(1, EnumTomeCatagories.GENERATION, "Mana Gathering",
				"It comes from the air", new ItemStack(BlockInit.vibe_gatherer.get()), I18n.format(GENERATION_PAGE_1)));
		GeneratePageList
				.add(new GuiTomePage(2, EnumTomeCatagories.GENERATION, "Karmic Altar", "Give some food, get power back",
						new ItemStack(BlockInit.karmic_altar.get()), I18n.format(GENERATION_PAGE_1)));
		GeneratePageList.add(new GuiTomePage(3, EnumTomeCatagories.GENERATION, "Wave Generator", "Go with the Flow",
				new ItemStack(BlockInit.wave_gatherer.get()), I18n.format(GENERATION_PAGE_1)));
		// Wands & Magic Gloves
		WandsPageList.add(new GuiTomePage(1, EnumTomeCatagories.WANDS, "Wands", "Watch where your pointing it",
				new ItemStack(ItemInit.wand_consume_vibes.get()), I18n.format(WANDS_PAGE_1)));
		// Runes

		RunesPageList.add(new GuiTomePage(1, EnumTomeCatagories.RUNES, "Runes", "More than goodluck",
				new ItemStack(ItemInit.rune_beast.get()), I18n.format(RUNES_PAGE_1)));
		RunesPageList.add(new GuiTomePage(2, EnumTomeCatagories.RUNES, "Runes cont.", "Etching your mind",
				new ItemStack(ItemInit.mind_spike.get()), I18n.format(RUNES_PAGE_2)));

		// Elder
		ElderPageList.add(new GuiTomePage(1, EnumTomeCatagories.ELDER, "The Elders", "Of the aeons old",
				new ItemStack(ItemInit.anti_tear.get()), I18n.format(ELDER_PAGE_1)));
		ElderPageList.add(new GuiTomePage(2, EnumTomeCatagories.ELDER, "Gem Enchanting", "Virtuosity at its finest",
				new ItemStack(BlockInit.virtuous_enchanter.get()), I18n.format(ELDER_PAGE_2)));
		ElderPageList.add(new GuiTomePage(3, EnumTomeCatagories.ELDER, "Elder Runes", "Exclusive Perks",
				new ItemStack(ItemInit.rune_milkweed_c.get()), I18n.format(ELDER_PAGE_2)));

		// Adding Chapters
		Collections.addAll(ChapterList, IntroPageList, KarmaPageList, WorldGenPageList, WorldGenPageList, ArmorPageList,
				BlocksPageList, GeneratePageList, WandsPageList, RunesPageList, ElderPageList);

		// TOC PAGES
		TOCPageList.add(new GuiTomePageTOC(EnumTomeCatagories.INTRO, new ItemStack(ItemInit.mana_powder.get())));
		TOCPageList.add(new GuiTomePageTOC(EnumTomeCatagories.KARMA, new ItemStack(ItemInit.purging_stone.get())));
		TOCPageList.add(new GuiTomePageTOC(EnumTomeCatagories.WORLDGEN, new ItemStack(BlockInit.morel_mushroom.get())));
		TOCPageList.add(new GuiTomePageTOC(EnumTomeCatagories.EQUIPS, new ItemStack(ItemInit.null_helmet.get())));
		TOCPageList.add(
				new GuiTomePageTOC(EnumTomeCatagories.MACHINES, new ItemStack(BlockInit.activated_obsidian.get())));
		TOCPageList
				.add(new GuiTomePageTOC(EnumTomeCatagories.GENERATION, new ItemStack(ItemInit.emanating_ingot.get())));
		TOCPageList.add(new GuiTomePageTOC(EnumTomeCatagories.WANDS, new ItemStack(ItemInit.wand_consume_vibes.get())));
		TOCPageList.add(new GuiTomePageTOC(EnumTomeCatagories.RUNES, new ItemStack(ItemInit.rune_milkweed_c.get())));
		TOCPageList.add(new GuiTomePageTOC(EnumTomeCatagories.ELDER, new ItemStack(ItemInit.elder_helmet.get())));

		// Adding the table of contents to each chapter
		IntroPageList.add(0, TOCPageList.get(0));
		KarmaPageList.add(0, TOCPageList.get(1));
		WorldGenPageList.add(0, TOCPageList.get(2));
		ArmorPageList.add(0, TOCPageList.get(3));
		BlocksPageList.add(0, TOCPageList.get(4));
		GeneratePageList.add(0, TOCPageList.get(5));
		WandsPageList.add(0, TOCPageList.get(6));
		RunesPageList.add(0, TOCPageList.get(7));
		ElderPageList.add(0, TOCPageList.get(8));

	}

	public static List<GuiTomePage> getIntroPageList() {
		return IntroPageList;
	}

	public static List<GuiTomePage> getKarmaPageList() {
		return KarmaPageList;
	}

	public static List<GuiTomePage> getWorldGenPageList() {
		return WorldGenPageList;
	}

	public static List<GuiTomePage> getArmorPageList() {
		return ArmorPageList;
	}

	public static List<GuiTomePage> getBlocksPageList() {
		return BlocksPageList;
	}

	public static List<GuiTomePage> getGeneratePageList() {
		return GeneratePageList;
	}

	public static List<GuiTomePage> getWandsPageList() {
		return WandsPageList;
	}

	public static List<GuiTomePage> getRunesPageList() {
		return RunesPageList;
	}

	public static List<GuiTomePage> getElderPageList() {
		return ElderPageList;
	}

	public static List<List<GuiTomePage>> getChapterList() {
		return ChapterList;
	}

}
