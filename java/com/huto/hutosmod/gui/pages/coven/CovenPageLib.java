package com.huto.hutosmod.gui.pages.coven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.huto.hutosmod.init.ItemInit;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CovenPageLib {

	// This is the page array for the book, needed because i dont know how to add
	// the pages to their own like sub class
	public static List<GuiCovenPage> HasturPageList = new ArrayList<GuiCovenPage>();
	public static List<GuiCovenPage> EldritchPageList = new ArrayList<GuiCovenPage>();
	public static List<GuiCovenPage> AscendentPageList = new ArrayList<GuiCovenPage>();

//	public static List<GuiCovenPage> ElderPageList = new ArrayList<GuiCovenPage>();
	public static List<List<GuiCovenPage>> ChapterList = new ArrayList<List<GuiCovenPage>>();
	public static List<GuiCovenPageTOC> TOCPageList = new ArrayList<GuiCovenPageTOC>();

	// Text Locations
	public static String HASTUR_PAGE_1 = "title.mystictome.hastur.page.1.text";
	public static String HASTUR_PAGE_2 = "title.mystictome.hastur.page.2.text";
	public static String HASTUR_PAGE_3 = "title.mystictome.hastur.page.3.text";

	// World
	public static String ASCENDENT_PAGE_1 = "title.mystictome.ascendent.page.1.text";
	public static String ASCENDENT_PAGE_2 = "title.mystictome.ascendent.page.2.text";
	public static String ASCENDENT_PAGE_3 = "title.mystictome.ascendent.page.3.text";

	// ELDRITCH
	public static String ELDRITCH_PAGE_1 = "title.mystictome.eldritch.page.1.text";
	public static String ELDRITCH_PAGE_2 = "title.mystictome.eldritch.page.2.text";
	public static String ELDRITCH_PAGE_3 = "title.mystictome.eldritch.page.3.text";

	public static void registerPages() {

		HasturPageList.clear();
		EldritchPageList.clear();
		AscendentPageList.clear();

		// ElderPageList.clear();
		ChapterList.clear();
		TOCPageList.clear();

		// HASTUR
		HasturPageList.add(new GuiCovenPage(1, EnumCovenTomeCatagories.HASTUR, "The Lord in Yellow",
				"It Started Somewhere", new ItemStack(ItemInit.unsettling_tapestry.get()), I18n.format(HASTUR_PAGE_1)));
		HasturPageList.add(new GuiCovenPage(2, EnumCovenTomeCatagories.HASTUR, "Scraps of Himself", "Its not polyester",
				new ItemStack(ItemInit.unsettling_fabric.get()), I18n.format(HASTUR_PAGE_2)));
		HasturPageList.add(new GuiCovenPage(3, EnumCovenTomeCatagories.HASTUR, "Channeling Power",
				"Only as he wills it", new ItemStack(ItemInit.yellow_tome.get()), I18n.format(HASTUR_PAGE_3)));

		// ELDRITCH
		EldritchPageList.add(new GuiCovenPage(1, EnumCovenTomeCatagories.ELDRITCH, "The Eldritch Truth",
				"Whispers from beyond", new ItemStack(ItemInit.ball_of_eyes.get()), I18n.format(ELDRITCH_PAGE_1)));
		EldritchPageList.add(new GuiCovenPage(2, EnumCovenTomeCatagories.ELDRITCH, "The Eye on the Inside",
				"Keep an eye out", new ItemStack(ItemInit.suspicious_eye.get()), I18n.format(ELDRITCH_PAGE_2)));
		EldritchPageList.add(new GuiCovenPage(3, EnumCovenTomeCatagories.ELDRITCH, "Cognito Hazard",
				"What you dont know...", new ItemStack(ItemInit.karmic_drop.get()), I18n.format(ELDRITCH_PAGE_3)));

		// Ascendent
		AscendentPageList.add(new GuiCovenPage(1, EnumCovenTomeCatagories.ASCENDENT, "The Higher Beings",
				"Seraphim and Beyond", new ItemStack(ItemInit.wing_fragment.get()), I18n.format(ASCENDENT_PAGE_1)));
		AscendentPageList.add(new GuiCovenPage(2, EnumCovenTomeCatagories.ASCENDENT, "Magic Down", "Feather Collecting",
				new ItemStack(ItemInit.seraph_feather.get()), I18n.format(ASCENDENT_PAGE_2)));
		AscendentPageList.add(new GuiCovenPage(3, EnumCovenTomeCatagories.ASCENDENT, "Holy Flares", "Star Spawn",
				new ItemStack(ItemInit.star_slug.get()), I18n.format(ASCENDENT_PAGE_3)));

		// Adding Chapters
		Collections.addAll(ChapterList, HasturPageList, EldritchPageList, AscendentPageList);

		// TOC PAGES
		TOCPageList.add(new GuiCovenPageTOC(EnumCovenTomeCatagories.HASTUR, new ItemStack(ItemInit.yellow_sign.get())));
		TOCPageList.add(new GuiCovenPageTOC(EnumCovenTomeCatagories.ELDRITCH,
				new ItemStack(ItemInit.everwatchful_pendant.get())));
		TOCPageList.add(
				new GuiCovenPageTOC(EnumCovenTomeCatagories.ASCENDENT, new ItemStack(ItemInit.crossed_keys.get())));

		// Adding the table of contents to each chapter
		HasturPageList.add(0, TOCPageList.get(0));
		EldritchPageList.add(0, TOCPageList.get(1));
		AscendentPageList.add(0, TOCPageList.get(2));

	}

	public static List<GuiCovenPage> getHasturPageList() {
		return HasturPageList;
	}

	public static List<GuiCovenPage> getEldritchPageList() {
		return EldritchPageList;
	}

	public static List<GuiCovenPage> getAscendentPageList() {
		return AscendentPageList;
	}

	public static List<List<GuiCovenPage>> getChapterList() {
		return ChapterList;
	}

}
