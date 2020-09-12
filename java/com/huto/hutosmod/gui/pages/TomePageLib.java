package com.huto.hutosmod.gui.pages;

import java.util.ArrayList;
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

	// Text Locations
	public static String INTRO_PAGE_1 = "title.mystictome.intro.page.1";
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

	public static void registerPages() {

		System.out.println("REGISTERING PAEGS");
		IntroPageList.clear();
		KarmaPageList.clear();
		WorldGenPageList.clear();
		ArmorPageList.clear();
		BlocksPageList.clear();
		GeneratePageList.clear();
		WandsPageList.clear();
		RunesPageList.clear();
		ElderPageList.clear();
		// LEXICON PAGES

		// Intro
		IntroPageList.add(new GuiTomePage(0, EnumTomeCatagories.INTRO, "Page 1", "In the Begining",
				new ItemStack(ItemInit.channeling_ingot.get()), I18n.format(INTRO_PAGE_1)));
		IntroPageList.add(new GuiTomePage(1, EnumTomeCatagories.INTRO, "Page 2", "Duality of Nature",
				new ItemStack(ItemInit.magatamabead.get()), I18n.format(INTRO_PAGE_2)));
		IntroPageList.add(new GuiTomePage(2, EnumTomeCatagories.INTRO, "Page 3", "Cosmic Vibrations",
				new ItemStack(ItemInit.energy_focus.get()), I18n.format(INTRO_PAGE_3)));
		IntroPageList.add(new GuiTomePage(3, EnumTomeCatagories.INTRO, "Page 4", "A World of essence",
				new ItemStack(ItemInit.essence_drop.get()), I18n.format(INTRO_PAGE_4)));
		IntroPageList.add(new GuiTomePage(4, EnumTomeCatagories.INTRO, "Page 5", "Channeling Basics",
				new ItemStack(ItemInit.channeling_rod.get()), I18n.format(INTRO_PAGE_5)));
		IntroPageList.add(new GuiTomePage(5, EnumTomeCatagories.INTRO, "Page 6", "Nullification",
				new ItemStack(ItemInit.null_crystal.get()), I18n.format(INTRO_PAGE_6)));
		IntroPageList.add(new GuiTomePage(6, EnumTomeCatagories.INTRO, "Page 7", "The power of vitals",
				new ItemStack(ItemInit.null_ingot.get()), I18n.format(INTRO_PAGE_7)));

		// Karma
		KarmaPageList.add(new GuiTomePage(0, EnumTomeCatagories.KARMA, "Karma", "Be careful what you do",
				new ItemStack(ItemInit.karmic_drop.get()), I18n.format(KARMA_PAGE_1)));

		// World Gen
		WorldGenPageList.add(new GuiTomePage(0, EnumTomeCatagories.WORLDGEN, "Page 1", "Its all Natural!",
				new ItemStack(BlockInit.mystic_earth.get()), I18n.format(WORLD_PAGE_1)));
		WorldGenPageList.add(new GuiTomePage(1, EnumTomeCatagories.WORLDGEN, "Page 2", "Vibrational Flora",
				new ItemStack(BlockInit.mystic_sapling.get()), I18n.format(WORLD_PAGE_2)));
		WorldGenPageList.add(new GuiTomePage(2, EnumTomeCatagories.WORLDGEN, "Page 3", "DreamScape",
				new ItemStack(BlockInit.mystic_media.get()), I18n.format(WORLD_PAGE_3)));
		WorldGenPageList.add(new GuiTomePage(3, EnumTomeCatagories.WORLDGEN, "Page 4", "Mysterious Mask",
				new ItemStack(ItemInit.anti_tear.get()), I18n.format(WORLD_PAGE_4)));
		WorldGenPageList.add(new GuiTomePage(4, EnumTomeCatagories.WORLDGEN, "Page 5", "Nightmares",
				new ItemStack(BlockInit.nightmare_earth.get()), I18n.format(WORLD_PAGE_5)));

		// Weapons and Armor
		ArmorPageList.add(new GuiTomePage(0, EnumTomeCatagories.EQUIPS, "Page 1", "Form AND Function",
				new ItemStack(ItemInit.null_chestplate.get()), I18n.format(EQUIP_PAGE_1)));
		// Machines
		BlocksPageList.add(new GuiTomePage(0, EnumTomeCatagories.MACHINES, "Mana Belljar", "Clunky but works",
				new ItemStack(BlockInit.activated_obsidian.get()), I18n.format(MACHINE_PAGE_3)));
		BlocksPageList.add(new GuiTomePage(1, EnumTomeCatagories.MACHINES, "Mana Storage", "Its like a cool battery",
				new ItemStack(BlockInit.activated_obsidian.get()), I18n.format(MACHINE_PAGE_4)));
		BlocksPageList.add(new GuiTomePage(2, EnumTomeCatagories.MACHINES, "Mana Resonator", "Infusing and Upgrading",
				new ItemStack(BlockInit.vibe_resonator.get()), I18n.format(MACHINE_PAGE_5)));
		BlocksPageList.add(new GuiTomePage(3, EnumTomeCatagories.MACHINES, "Mana Collider", "Mix this and that...",
				new ItemStack(BlockInit.activated_obsidian.get()), I18n.format(MACHINE_PAGE_6)));
		BlocksPageList.add(new GuiTomePage(4, EnumTomeCatagories.MACHINES, "Wand Fabricator", "Channeling finally",
				new ItemStack(BlockInit.wand_maker.get()), I18n.format(MACHINE_PAGE_8)));
		BlocksPageList.add(new GuiTomePage(5, EnumTomeCatagories.MACHINES, "Karmic Extractor", "Clean yourself up",
				new ItemStack(BlockInit.activated_obsidian.get()), I18n.format(MACHINE_PAGE_7)));
		// Generate
		GeneratePageList
				.add(new GuiTomePage(0, EnumTomeCatagories.GENERATION, "Mana Gathering", "It comes from the air",
						new ItemStack(BlockInit.activated_obsidian.get()), I18n.format(GENERATION_PAGE_1)));
		GeneratePageList
				.add(new GuiTomePage(1, EnumTomeCatagories.GENERATION, "Karmic Altar", "Give some food, get power back",
						new ItemStack(BlockInit.activated_obsidian.get()), I18n.format(GENERATION_PAGE_1)));
		GeneratePageList.add(new GuiTomePage(2, EnumTomeCatagories.GENERATION, "Wave Generator", "Go with the Flow",
				new ItemStack(BlockInit.activated_obsidian.get()), I18n.format(GENERATION_PAGE_1)));
		// Wands & Magic Gloves
		WandsPageList.add(new GuiTomePage(0, EnumTomeCatagories.WANDS, "Wands", "Watch where your pointing it",
				new ItemStack(ItemInit.wand_consume_vibes.get()), I18n.format(WANDS_PAGE_1)));
		// Runes
		RunesPageList.add(new GuiTomePage(0, EnumTomeCatagories.RUNES, "Runes", "More than goodluck",
				new ItemStack(ItemInit.anti_tear.get()), I18n.format(RUNES_PAGE_1)));
		RunesPageList.add(new GuiTomePage(1, EnumTomeCatagories.RUNES, "Runes cont.", "Etching your mind",
				new ItemStack(ItemInit.anti_tear.get()), I18n.format(RUNES_PAGE_2)));

		// Elder
		ElderPageList.add(new GuiTomePage(0, EnumTomeCatagories.ELDER, " The Elders", "Of the aeons old",
				new ItemStack(ItemInit.anti_tear.get()), I18n.format(ELDER_PAGE_1)));
	}
}
