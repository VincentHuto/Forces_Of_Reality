package com.huto.hutosmod.gui.pages.coven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.gui.pages.GuiTomeImage;
import com.huto.hutosmod.init.ItemInit;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CovenPageLib {

	public static List<GuiCovenPage> HasturPageList = new ArrayList<GuiCovenPage>();
	public static List<GuiCovenPage> EldritchPageList = new ArrayList<GuiCovenPage>();
	public static List<GuiCovenPage> AscendentPageList = new ArrayList<GuiCovenPage>();
	public static List<GuiCovenPage> BeastPageList = new ArrayList<GuiCovenPage>();
	public static List<GuiCovenPage> MachinePageList = new ArrayList<GuiCovenPage>();
	public static List<GuiCovenPage> SelfPageList = new ArrayList<GuiCovenPage>();

	public static List<List<GuiCovenPage>> ChapterList = new ArrayList<List<GuiCovenPage>>();
	public static List<GuiCovenPageTOC> TOCPageList = new ArrayList<GuiCovenPageTOC>();

	// HASTUR
	public static String SELF_PAGE_1 = "title.coventome.self.page.1.text";
	public static String SELF_PAGE_2 = "title.coventome.self.page.2.text";
	public static String SELF_PAGE_3 = "title.coventome.self.page.3.text";
	public static String SELF_PAGE_4 = "title.coventome.self.page.4.text";
	public static String SELF_PAGE_5 = "title.coventome.self.page.5.text";

	// HASTUR
	public static String HASTUR_PAGE_1 = "title.coventome.hastur.page.1.text";
	public static String HASTUR_PAGE_2 = "title.coventome.hastur.page.2.text";
	public static String HASTUR_PAGE_3 = "title.coventome.hastur.page.3.text";
	public static String HASTUR_PAGE_4 = "title.coventome.hastur.page.4.text";

	// ASCENDENT
	public static String ASCENDENT_PAGE_1 = "title.coventome.ascendent.page.1.text";
	public static String ASCENDENT_PAGE_2 = "title.coventome.ascendent.page.2.text";
	public static String ASCENDENT_PAGE_3 = "title.coventome.ascendent.page.3.text";
	public static String ASCENDENT_PAGE_4 = "title.coventome.ascendent.page.4.text";

	// ELDRITCH
	public static String ELDRITCH_PAGE_1 = "title.coventome.eldritch.page.1.text";
	public static String ELDRITCH_PAGE_2 = "title.coventome.eldritch.page.2.text";
	public static String ELDRITCH_PAGE_3 = "title.coventome.eldritch.page.3.text";
	public static String ELDRITCH_PAGE_4 = "title.coventome.eldritch.page.4.text";

	// BEAST
	public static String BEAST_PAGE_1 = "title.coventome.beast.page.1.text";
	public static String BEAST_PAGE_2 = "title.coventome.beast.page.2.text";
	public static String BEAST_PAGE_3 = "title.coventome.beast.page.3.text";
	public static String BEAST_PAGE_4 = "title.coventome.beast.page.4.text";

	// Machine
	public static String MACHINE_PAGE_1 = "title.coventome.machine.page.1.text";
	public static String MACHINE_PAGE_2 = "title.coventome.machine.page.2.text";
	public static String MACHINE_PAGE_3 = "title.coventome.machine.page.3.text";
	public static String MACHINE_PAGE_4 = "title.coventome.machine.page.4.text";
	public static String MACHINE_PAGE_5 = "title.coventome.machine.page.5.text";
	public static String MACHINE_PAGE_6 = "title.coventome.machine.page.6.text";

	public static void registerPages() {

		HasturPageList.clear();
		EldritchPageList.clear();
		AscendentPageList.clear();
		BeastPageList.clear();
		MachinePageList.clear();
		SelfPageList.clear();

		ChapterList.clear();
		TOCPageList.clear();

		// SELF
		SelfPageList.add(new GuiCovenImagePage(1, EnumCovenants.SELF, "Self", "Altar", SELF_PAGE_1,
				new GuiTomeImage(new ResourceLocation(HutosMod.MOD_ID, "textures/gui/pageimages/coven/self/altar.png"),
						0, 0, 104, 104, 0.00970625F)));
		SelfPageList.add(new GuiCovenPage(2, EnumCovenants.SELF, "Me, Myself, and I", "The Path of the Self",
				new ItemStack(ItemInit.allegiance_identifier.get()), I18n.format(SELF_PAGE_2)));
		SelfPageList.add(new GuiCovenPage(3, EnumCovenants.SELF, "Self Care", "Mental and Physica;",
				new ItemStack(ItemInit.rune_blank.get()), I18n.format(SELF_PAGE_3)));
		SelfPageList.add(new GuiCovenPage(4, EnumCovenants.SELF, "Escaping the pull", "The whole of the Law",
				new ItemStack(ItemInit.influence_supressor.get()), I18n.format(SELF_PAGE_4)));
		SelfPageList.add(new GuiCovenImagePage(5, EnumCovenants.SELF, "Tulpa", "Inner Self", SELF_PAGE_5,
				new GuiTomeImage(new ResourceLocation(HutosMod.MOD_ID, "textures/gui/pageimages/coven/self/tulpa.png"),
						0, 0, 104, 104, 0.00970625F)));
		// HASTUR
		HasturPageList.add(new GuiCovenImagePage(1, EnumCovenants.HASTUR, "Hasturs", "Altar", HASTUR_PAGE_1,
				new GuiTomeImage(
						new ResourceLocation(HutosMod.MOD_ID, "textures/gui/pageimages/coven/hastur/altar.png"), 0, 0,
						104, 104, 0.00970625F)));
		HasturPageList.add(new GuiCovenPage(2, EnumCovenants.HASTUR, "The Lord in Yellow", "It Started Somewhere",
				new ItemStack(ItemInit.unsettling_tapestry.get()), I18n.format(HASTUR_PAGE_2)));
		HasturPageList.add(new GuiCovenPage(3, EnumCovenants.HASTUR, "Scraps of Himself", "Its not polyester",
				new ItemStack(ItemInit.unsettling_fabric.get()), I18n.format(HASTUR_PAGE_3)));
		HasturPageList.add(new GuiCovenPage(4, EnumCovenants.HASTUR, "Channeling Power", "Only as he wills it",
				new ItemStack(ItemInit.yellow_tome.get()), I18n.format(HASTUR_PAGE_4)));

		// ELDRITCH
		EldritchPageList.add(new GuiCovenImagePage(1, EnumCovenants.ELDRITCH, "Eldritch", "Altar", ELDRITCH_PAGE_1,
				new GuiTomeImage(
						new ResourceLocation(HutosMod.MOD_ID, "textures/gui/pageimages/coven/eldritch/altar.png"), 0, 0,
						104, 104, 0.00970625F)));

		EldritchPageList.add(new GuiCovenPage(2, EnumCovenants.ELDRITCH, "The Eldritch Truth", "Whispers from beyond",
				new ItemStack(ItemInit.ball_of_eyes.get()), I18n.format(ELDRITCH_PAGE_2)));
		EldritchPageList.add(new GuiCovenPage(3, EnumCovenants.ELDRITCH, "The Eye on the Inside", "Keep an eye out",
				new ItemStack(ItemInit.suspicious_eye.get()), I18n.format(ELDRITCH_PAGE_3)));
		EldritchPageList.add(new GuiCovenPage(4, EnumCovenants.ELDRITCH, "Cognito Hazard", "What you dont know...",
				new ItemStack(ItemInit.karmic_drop.get()), I18n.format(ELDRITCH_PAGE_4)));

		// Ascendent
		AscendentPageList.add(new GuiCovenImagePage(1, EnumCovenants.ASCENDENT, "Ascendent", "Altar", ASCENDENT_PAGE_1,
				new GuiTomeImage(
						new ResourceLocation(HutosMod.MOD_ID, "textures/gui/pageimages/coven/ascendent/altar.png"), 0,
						0, 104, 104, 0.00970625F)));
		AscendentPageList.add(new GuiCovenPage(2, EnumCovenants.ASCENDENT, "The Higher Beings", "Seraphim and Beyond",
				new ItemStack(ItemInit.wing_fragment.get()), I18n.format(ASCENDENT_PAGE_2)));
		AscendentPageList.add(new GuiCovenPage(3, EnumCovenants.ASCENDENT, "Magic Down", "Feather Collecting",
				new ItemStack(ItemInit.seraph_feather.get()), I18n.format(ASCENDENT_PAGE_3)));
		AscendentPageList.add(new GuiCovenPage(4, EnumCovenants.ASCENDENT, "Holy Flares", "Star Spawn",
				new ItemStack(ItemInit.star_slug.get()), I18n.format(ASCENDENT_PAGE_4)));

		// Beast

		BeastPageList.add(new GuiCovenImagePage(1, EnumCovenants.BEAST, "Beast", "Altar", BEAST_PAGE_1,
				new GuiTomeImage(new ResourceLocation(HutosMod.MOD_ID, "textures/gui/pageimages/coven/beast/altar.png"),
						0, 0, 104, 104, 0.00970625F)));
		BeastPageList.add(new GuiCovenPage(2, EnumCovenants.BEAST, "Fight Tooth and Nail", "Beastly Blood",
				new ItemStack(ItemInit.beastly_bone.get()), I18n.format(BEAST_PAGE_2)));
		BeastPageList.add(new GuiCovenPage(3, EnumCovenants.BEAST, "Just a Nail", "Nail Clippings",
				new ItemStack(ItemInit.blooddrawn_fang.get()), I18n.format(BEAST_PAGE_3)));
		BeastPageList.add(new GuiCovenPage(4, EnumCovenants.BEAST, "Thermal Vision", "Hunt as a Beast",
				new ItemStack(ItemInit.influence_supressor.get()), I18n.format(BEAST_PAGE_4)));

		// Machine
		MachinePageList.add(new GuiCovenImagePage(1, EnumCovenants.MACHINE, "Machine", "Altar", MACHINE_PAGE_1,
				new GuiTomeImage(
						new ResourceLocation(HutosMod.MOD_ID, "textures/gui/pageimages/coven/machina/altar.png"), 0, 0,
						104, 104, 0.00970625F)));
		MachinePageList.add(new GuiCovenPage(2, EnumCovenants.MACHINE, "The World of Machines", "Facts and Logic",
				new ItemStack(ItemInit.auric_ingot.get()), I18n.format(MACHINE_PAGE_2)));
		MachinePageList.add(new GuiCovenPage(3, EnumCovenants.MACHINE, "Sentient Machines", "T-1000",
				new ItemStack(ItemInit.neurotic_mechanism.get()), I18n.format(MACHINE_PAGE_3)));
		MachinePageList.add(new GuiCovenPage(4, EnumCovenants.MACHINE, "Trick Tools", "Mechanical Advantage",
				new ItemStack(ItemInit.somnolent_trick_axe.get()), I18n.format(MACHINE_PAGE_4)));
		MachinePageList.add(new GuiCovenImagePage(5, EnumCovenants.MACHINE, "Machina Soul", "Life Spark",
				MACHINE_PAGE_5,
				new GuiTomeImage(
						new ResourceLocation(HutosMod.MOD_ID, "textures/gui/pageimages/coven/machina/spark.png"), 0, 0,
						104, 104, 0.00970625F)));
		MachinePageList.add(new GuiCovenImagePage(6, EnumCovenants.MACHINE, "Malformed Automaton",
				"The Failed Creation", MACHINE_PAGE_6,
				new GuiTomeImage(
						new ResourceLocation(HutosMod.MOD_ID, "textures/gui/pageimages/coven/machina/automaton.png"), 0,
						0, 104, 102, 0.0096625F)));

		// Adding Chapters
		Collections.addAll(ChapterList, HasturPageList, EldritchPageList, AscendentPageList, BeastPageList,
				MachinePageList, SelfPageList);

		// TOC PAGES
		TOCPageList.add(new GuiCovenPageTOC(EnumCovenants.HASTUR, new ItemStack(ItemInit.yellow_sign.get())));
		TOCPageList
				.add(new GuiCovenPageTOC(EnumCovenants.ELDRITCH, new ItemStack(ItemInit.everwatchful_pendant.get())));
		TOCPageList.add(new GuiCovenPageTOC(EnumCovenants.ASCENDENT, new ItemStack(ItemInit.crossed_keys.get())));
		TOCPageList.add(new GuiCovenPageTOC(EnumCovenants.BEAST, new ItemStack(ItemInit.breath_of_the_beast.get())));
		TOCPageList.add(new GuiCovenPageTOC(EnumCovenants.MACHINE, new ItemStack(ItemInit.neurotic_mechanism.get())));
		TOCPageList.add(new GuiCovenPageTOC(EnumCovenants.SELF, new ItemStack(ItemInit.purging_stone.get())));

		// Adding the table of contents to each chapter
		HasturPageList.add(0, TOCPageList.get(0));
		EldritchPageList.add(0, TOCPageList.get(1));
		AscendentPageList.add(0, TOCPageList.get(2));
		BeastPageList.add(0, TOCPageList.get(3));
		MachinePageList.add(0, TOCPageList.get(4));
		SelfPageList.add(0, TOCPageList.get(5));

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

	public static List<GuiCovenPage> getSelfPageList() {
		return SelfPageList;
	}

	public static List<List<GuiCovenPage>> getChapterList() {
		return ChapterList;
	}

}
