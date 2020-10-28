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

	public static List<GuiCovenPage> HasturPageList = new ArrayList<GuiCovenPage>();
	public static List<GuiCovenPage> EldritchPageList = new ArrayList<GuiCovenPage>();
	public static List<GuiCovenPage> AscendentPageList = new ArrayList<GuiCovenPage>();
	public static List<GuiCovenPage> BeastPageList = new ArrayList<GuiCovenPage>();
	public static List<GuiCovenPage> MachinePageList = new ArrayList<GuiCovenPage>();

	public static List<List<GuiCovenPage>> ChapterList = new ArrayList<List<GuiCovenPage>>();
	public static List<GuiCovenPageTOC> TOCPageList = new ArrayList<GuiCovenPageTOC>();

	// HASTUR
	public static String HASTUR_PAGE_1 = "title.coventome.hastur.page.1.text";
	public static String HASTUR_PAGE_2 = "title.coventome.hastur.page.2.text";
	public static String HASTUR_PAGE_3 = "title.coventome.hastur.page.3.text";

	// ASCENDENT
	public static String ASCENDENT_PAGE_1 = "title.coventome.ascendent.page.1.text";
	public static String ASCENDENT_PAGE_2 = "title.coventome.ascendent.page.2.text";
	public static String ASCENDENT_PAGE_3 = "title.coventome.ascendent.page.3.text";

	// ELDRITCH
	public static String ELDRITCH_PAGE_1 = "title.coventome.eldritch.page.1.text";
	public static String ELDRITCH_PAGE_2 = "title.coventome.eldritch.page.2.text";
	public static String ELDRITCH_PAGE_3 = "title.coventome.eldritch.page.3.text";

	// BEAST
	public static String BEAST_PAGE_1 = "title.coventome.beast.page.1.text";
	public static String BEAST_PAGE_2 = "title.coventome.beast.page.2.text";
	public static String BEAST_PAGE_3 = "title.coventome.beast.page.3.text";

	// Machine
	public static String MACHINE_PAGE_1 = "title.coventome.machine.page.1.text";
	public static String MACHINE_PAGE_2 = "title.coventome.machine.page.2.text";
	public static String MACHINE_PAGE_3 = "title.coventome.machine.page.3.text";

	public static void registerPages() {

		HasturPageList.clear();
		EldritchPageList.clear();
		AscendentPageList.clear();
		BeastPageList.clear();
		MachinePageList.clear();

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

		// Beast
		BeastPageList.add(new GuiCovenPage(1, EnumCovenTomeCatagories.BEAST, "Fight Tooth and Nail", "Beastly Blood",
				new ItemStack(ItemInit.beastly_bone.get()), I18n.format(BEAST_PAGE_1)));
		BeastPageList.add(new GuiCovenPage(2, EnumCovenTomeCatagories.BEAST, "Just a Nail", "Nail Clippings",
				new ItemStack(ItemInit.blooddrawn_fang.get()), I18n.format(BEAST_PAGE_2)));
		BeastPageList.add(new GuiCovenPage(3, EnumCovenTomeCatagories.BEAST, "Thermal Vision", "Hunt as a Beast",
				new ItemStack(ItemInit.influence_supressor.get()), I18n.format(BEAST_PAGE_3)));

		// Machine
		MachinePageList.add(new GuiCovenPage(1, EnumCovenTomeCatagories.MACHINE, "Fight Tooth and Nail",
				"Machinely Blood", new ItemStack(ItemInit.auric_ingot.get()), I18n.format(MACHINE_PAGE_1)));
		MachinePageList.add(new GuiCovenPage(2, EnumCovenTomeCatagories.MACHINE, "Just a Nail", "Nail Clippings",
				new ItemStack(ItemInit.neurotic_mechanism.get()), I18n.format(MACHINE_PAGE_2)));
		MachinePageList.add(new GuiCovenPage(3, EnumCovenTomeCatagories.MACHINE, "Thermal Vision", "Hunt as a Machine",
				new ItemStack(ItemInit.mystic_trick_axe.get()), I18n.format(MACHINE_PAGE_3)));

		// Adding Chapters
		Collections.addAll(ChapterList, HasturPageList, EldritchPageList, AscendentPageList, BeastPageList,
				MachinePageList);

		// TOC PAGES
		TOCPageList.add(new GuiCovenPageTOC(EnumCovenTomeCatagories.HASTUR, new ItemStack(ItemInit.yellow_sign.get())));
		TOCPageList.add(new GuiCovenPageTOC(EnumCovenTomeCatagories.ELDRITCH,
				new ItemStack(ItemInit.everwatchful_pendant.get())));
		TOCPageList.add(
				new GuiCovenPageTOC(EnumCovenTomeCatagories.ASCENDENT, new ItemStack(ItemInit.crossed_keys.get())));
		TOCPageList.add(
				new GuiCovenPageTOC(EnumCovenTomeCatagories.BEAST, new ItemStack(ItemInit.breath_of_the_beast.get())));
		TOCPageList.add(
				new GuiCovenPageTOC(EnumCovenTomeCatagories.MACHINE, new ItemStack(ItemInit.neurotic_mechanism.get())));
		// Adding the table of contents to each chapter

		HasturPageList.add(0, TOCPageList.get(0));
		EldritchPageList.add(0, TOCPageList.get(1));
		AscendentPageList.add(0, TOCPageList.get(2));
		BeastPageList.add(0, TOCPageList.get(3));
		MachinePageList.add(0, TOCPageList.get(4));

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

	public static List<GuiCovenPage> getBeastPageList() {
		return BeastPageList;
	}

	public static List<GuiCovenPage> getMachinePageList() {
		return MachinePageList;
	}

	public static List<List<GuiCovenPage>> getChapterList() {
		return ChapterList;
	}

}
