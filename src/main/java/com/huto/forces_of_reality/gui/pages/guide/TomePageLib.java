package com.huto.forces_of_reality.gui.pages.guide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.gui.pages.EnumTomeCatagories;
import com.huto.forces_of_reality.gui.pages.GuiTomeImage;
import com.huto.forces_of_reality.init.BlockInit;
import com.huto.forces_of_reality.init.ItemInit;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TomePageLib {

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
	public static String INTRO_PAGE_1 = "The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.";
	public static String INTRO_PAGE_2 = "The reverberations previously mentioned are in a sense, cosmic whiplash on a universal scale. As the singularity expanded, every particle was thrown around in every which way. While at first, this was cause for chaos, the wheels of time have marched on and calmed things down as they do rendering the vibrations very minute, but minute is not zero. Minute for one atom can be magnified exponentially when concentrated enough, resonating with one another allowing for the force of the big bang to be felt once more";
	public static String INTRO_PAGE_3 = "One of the quirks of the antimatter/matter duality is that the vibrations of these particles are opposite and equal as well. These vibrations follow the same principle that all other forms of vibration be it sound/light/electricity etc, in that they amplify when met with similar waves and cancel when met with opposing waves. Building on the concentration effect of these vibrations, the idea of karma can even be traced back as the balance of these vibrations within your body, and mana is just the net force of the anti and positive waves manifesting as a physical and invisible force.";
	public static String INTRO_PAGE_4 = "Matter and antimatter can become \"vibratory\" in some rare examples simply by happenstance when enough of a single frequency of resonating matter comes into close proximity and will somewhat meld together. When they coalesce they are called \"drops\" or \"tears\" for vibrations and antivibration respectively with \"essence\" being the overarching term for both forms of concentrated vibrational matter. Essence can be found in all forms of life with a very low concentration but can be coerced out of them upon death with specialized tools discussed later.";
	public static String INTRO_PAGE_5 =  "The process of inducing vibrations is known as \"Channeling\", somnolental sounding in nature, but the elders can be blamed for this. This can be done in a variety of ways all modeled off of trying to artificially induce the natural essence production, by essentially taking a chunk of vibratory or \"conductive\" matter and allowing it to collect more and more matter that begins to resonate with it, which is an exponential process. The beauty of this process is that once an original drop or tear of matter is created, it will naturally start to produce more of itself with little aide.If only there was a way to contain this growth...";
	public static String INTRO_PAGE_6 = "As mentioned prior, these vibrations behave the same way that any other wave does, and as such can be stopped or dampened with an opposite waveform. Producing this waveform can be tricky but with a little bit of experimenting, discovering that the more your around concentrated matter, the more sensitive you become to it, beginning to be able to sense slight differences in direction and amplitude each drop. By using matter of specific frequency you can change the characteristics of other matter by forcing contact with the target. The process of canceling vibrations intentionally is called \"Nullification\" and is incredibly useful.";
	public static String INTRO_PAGE_7 =  "Due to the nature of life itself, being inherently organized, living beings are naturally enriched with essence, almost completely filled with positive vibrations in fact. This is not to say that ALL creatures are positive, there are some exceptions that have net negative vibrations(withers and end creatures), and some that have none at all(skeletons and other inorganic life)! Because of this, the essence can be farmed quite readily through the process of death, with the correct tools, of course, ones that nullified vibrations maybe?";
	public static String INTRO_PAGE_8 = "title.somnolenttome.intro.page.8.text";

	// World
	public static String WORLD_PAGE_1 ="With all this talk of how important vibrations are, it should be no surprise that the world around you has been influenced if not entirely formed around these waves. Everything from where and the way plants grow, to the migration of animals, the weather patterns, and even the oceans currents all follow these principals. The scary part is that, even though you are not aware of it, even your own consciousness is influenced by these tiny events, affecting what you do and how you behave depending on where you may be. Many mental ailments in fact can be chalked up to vibrational imbalances.";
	public static String WORLD_PAGE_2 = "The plants around us have very little way of communicating with us, so they can’t necessarily tell us what the vibrations do to influence them, but do to the research of scholars prior we have realized by forcing vibrations of all kinds into plants what effect they have on them. While they did exist prior albeit very solemnly, there is a type of tree that is especially good at vibrationally channeling and as such have even turned blue! Their existence now however has been spread even farther as a result of an experiment run loose and allowing a genetically altered species of this tree to appear even more commonly, albeit quite skinnier.";
	public static String WORLD_PAGE_3 = "The mind sure is a magical place in its own right, but it is normally locked away inside of that skull of yours. When you dream the barrier between reality and imagination starts to dissolve, allowing for a glimpse into a world completely of your own subconscious. Believe it or not dreams and the mind are influenced vibrations, and when many people all sleep together they start harmonizing together as they dream.";
	public static String WORLD_PAGE_4 = "Normally this harmony is not noticeable but with a little help from a form of amplification, dreams could be experienced together in a much more cohesive solid way. The method of amplification has been sadly lost to history, but whispers of a group in the past seems that there was a type of headwear that could serve this role perfectly. One day maybe you will be able to recreate this style of headwear by your own experimentation.";
	public static String WORLD_PAGE_5 =	"On the flip-side to good old fashioned Dreamscape Im sure you are well versed in by now, there is a secondary realm that exists on the same frequency at the opposite end of the spectrum known as \"The Nightmare realm\".This place seems to be only accessibleby the same means as the ordinary dreamscape,but only when certain conditions are met...although it does seem that those with a much higher karmic debt are more likely to visit there more often.";


	// Equips
	public static String EQUIP_PAGE_1 = "title.somnolenttome.equip.page.1.text";
	public static String EQUIP_PAGE_2 = "title.somnolenttome.equip.page.2.text";
	public static String EQUIP_PAGE_3 = "title.somnolenttome.equip.page.3.text";

	// Machines
	public static String MACHINE_PAGE_1 = "title.somnolenttome.blocks.page.1.text";
	public static String MACHINE_PAGE_2 = "title.somnolenttome.blocks.page.2.text";
	public static String MACHINE_PAGE_3 = "title.somnolenttome.blocks.page.3.text";
	public static String MACHINE_PAGE_4 = "title.somnolenttome.blocks.page.4.text";
	public static String MACHINE_PAGE_5 = "title.somnolenttome.blocks.page.5.text";
	public static String MACHINE_PAGE_6 = "title.somnolenttome.blocks.page.6.text";
	public static String MACHINE_PAGE_7 = "title.somnolenttome.blocks.page.7.text";
	public static String MACHINE_PAGE_8 = "title.somnolenttome.blocks.page.8.text";

	// Generate
	public static String GENERATION_PAGE_1 = "title.somnolenttome.blocks.page.1.text";
	public static String GENERATION_PAGE_2 = "title.somnolenttome.blocks.page.2.text";
	public static String GENERATION_PAGE_3 = "title.somnolenttome.blocks.page.3.text";

	// Wands
	public static String WANDS_PAGE_1 = "title.somnolenttome.wands.page.1.text";
	public static String WANDS_PAGE_2 = "title.somnolenttome.wands.page.2.text";
	public static String WANDS_PAGE_3 = "title.somnolenttome.wands.page.3.text";

	// Runes
	public static String RUNES_PAGE_1 = "title.somnolenttome.runes.page.1.text";
	public static String RUNES_PAGE_2 = "title.somnolenttome.runes.page.2.text";

	// Karma
	public static String KARMA_PAGE_1 = "title.somnolenttome.karma.page.1.text";
	// Elder
	public static String ELDER_PAGE_1 = "title.somnolenttome.elder.page.1.text";
	public static String ELDER_PAGE_2 = "title.somnolenttome.elder.page.2.text";
	public static String ELDER_PAGE_3 = "title.somnolenttome.elder.page.3.text";

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

		IntroPageList.add(new GuiTomeImagePage(8, EnumTomeCatagories.INTRO, "ImageTest", "Picture Yo","",
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/blue.png"), 0, 0)));
		 List<ITextComponent> textIn = new ArrayList<ITextComponent>();
		 textIn.add(new StringTextComponent("Hello"));
		 textIn.add(new StringTextComponent("I "));
		 textIn.add(new StringTextComponent("Am"));
		 textIn.add(new StringTextComponent("Red"));

		IntroPageList.add(new GuiTomeImagePage(9, EnumTomeCatagories.INTRO, "ImageTest2", "Pictures Yo","",
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/altar1.png"), 0, 0),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/altar2.png"), 1, 1),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/altar3.png"), 2, 2),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/altar4.png"), 3, 3),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/altar5.png"), 4, 4),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/blue.png"), 5, 5),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/red.png"), 6, 6),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/green.png"), 7, 7),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/white.png"), 8, 8),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/black.png"), 9, 9),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/blue.png"), 10, 10),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/red.png"), 11, 11,textIn)));
		IntroPageList.add(new GuiTomeImagePage(10, EnumTomeCatagories.INTRO, "ImageTest3", "Stretchy Yo","",
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/horizextend1.png"), 0,
						0, 128, 64),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/scaled1.png"), 1, 3,
						128, 128),
				new GuiTomeImage(new ResourceLocation(ForcesOfReality.MOD_ID, "textures/gui/pageimages/vertextend1.png"), 6, 8,
						64, 128)));

		// Karma
		KarmaPageList.add(new GuiTomePage(1, EnumTomeCatagories.KARMA, "Karma", "Be careful what you do",
				new ItemStack(ItemInit.karmic_drop.get()), I18n.format(KARMA_PAGE_1)));
		// World Gen
		WorldGenPageList.add(new GuiTomePage(1, EnumTomeCatagories.WORLDGEN, "The World", "Its all Natural!",
				new ItemStack(BlockInit.somnolent_earth.get()), I18n.format(WORLD_PAGE_1)));
		WorldGenPageList.add(new GuiTomePage(2, EnumTomeCatagories.WORLDGEN, "Plants", "Vibrational Flora",
				new ItemStack(BlockInit.somnolent_sapling.get()), I18n.format(WORLD_PAGE_2)));
		WorldGenPageList.add(new GuiTomePage(3, EnumTomeCatagories.WORLDGEN, "DreamScape", "Page 3",
				new ItemStack(BlockInit.somnolent_media.get()), I18n.format(WORLD_PAGE_3)));
		WorldGenPageList.add(new GuiTomePage(4, EnumTomeCatagories.WORLDGEN, "Access", "Mysterious Mask",
				new ItemStack(ItemInit.anti_tear.get()), I18n.format(WORLD_PAGE_4)));
		WorldGenPageList.add(new GuiTomePage(5, EnumTomeCatagories.WORLDGEN, "Nightmares", "The Bad Place",
				new ItemStack(BlockInit.nightmare_earth.get()), I18n.format(WORLD_PAGE_5)));
		// Weapons and Armor
		ArmorPageList.add(new GuiTomePage(1, EnumTomeCatagories.EQUIPS, "Equipables", "Form AND Function",
				new ItemStack(ItemInit.null_chestplate.get()), I18n.format(EQUIP_PAGE_1)));
		ArmorPageList.add(new GuiTomePage(2, EnumTomeCatagories.EQUIPS, "Visualization", "Know what you got",
				new ItemStack(ItemInit.vibrational_seer.get()), I18n.format(EQUIP_PAGE_2)));
		ArmorPageList.add(new GuiTomePage(3, EnumTomeCatagories.EQUIPS, "Null Armor", "Protect yourself",
				new ItemStack(ItemInit.null_helmet.get()), I18n.format(EQUIP_PAGE_3)));
		// Machines
		BlocksPageList.add(new GuiTomePage(1, EnumTomeCatagories.MACHINES, "Accelerometer", "Firmly Grasp it",
				new ItemStack(BlockInit.vibratory_accelerometer.get()), I18n.format(MACHINE_PAGE_1)));
		BlocksPageList.add(new GuiTomePage(2, EnumTomeCatagories.MACHINES, "Absorber", "Here and There",
				new ItemStack(BlockInit.vibe_absorber.get()), I18n.format(MACHINE_PAGE_2)));
		BlocksPageList.add(new GuiTomePage(3, EnumTomeCatagories.MACHINES, "Vibe Storage", "Its like a cool battery",
				new ItemStack(BlockInit.vibratory_storage_drum.get()), I18n.format(MACHINE_PAGE_4)));
		BlocksPageList.add(new GuiTomePage(4, EnumTomeCatagories.MACHINES, "Resonator", "Infusing and Upgrading",
				new ItemStack(BlockInit.vibe_resonator.get()), I18n.format(MACHINE_PAGE_5)));
		BlocksPageList.add(new GuiTomePage(5, EnumTomeCatagories.MACHINES, "Collider", "Mix this and that...",
				new ItemStack(BlockInit.vibratory_fuser.get()), I18n.format(MACHINE_PAGE_6)));
		BlocksPageList.add(new GuiTomePage(6, EnumTomeCatagories.MACHINES, "Wand Fabricator", "Channeling finally",
				new ItemStack(BlockInit.wand_maker.get()), I18n.format(MACHINE_PAGE_7)));
		BlocksPageList.add(new GuiTomePage(7, EnumTomeCatagories.MACHINES, "Karmic Extractor", "Clean yourself up",
				new ItemStack(BlockInit.karmic_extractor.get()), I18n.format(MACHINE_PAGE_8)));
		// Generate
		GeneratePageList.add(new GuiTomePage(1, EnumTomeCatagories.GENERATION, "Vibe Gathering",
				"It comes from the air", new ItemStack(BlockInit.vibe_gatherer.get()), I18n.format(GENERATION_PAGE_1)));
		GeneratePageList
				.add(new GuiTomePage(2, EnumTomeCatagories.GENERATION, "Karmic Altar", "Give some food, get power back",
						new ItemStack(BlockInit.karmic_altar.get()), I18n.format(GENERATION_PAGE_1)));
		GeneratePageList.add(new GuiTomePage(3, EnumTomeCatagories.GENERATION, "Wave Generator", "Go with the Flow",
				new ItemStack(BlockInit.wave_gatherer.get()), I18n.format(GENERATION_PAGE_2)));
		GeneratePageList.add(new GuiTomePage(4, EnumTomeCatagories.GENERATION, "Thermal Generator", "Thermal Influx",
				new ItemStack(BlockInit.thermal_influxer.get()), I18n.format(GENERATION_PAGE_3)));
		// Wands & Magic Gloves
		WandsPageList.add(new GuiTomePage(1, EnumTomeCatagories.WANDS, "Wands", "Watch where your pointing it",
				new ItemStack(ItemInit.wand_consume_vibes.get()), I18n.format(WANDS_PAGE_1)));
		WandsPageList.add(new GuiTomePage(2, EnumTomeCatagories.WANDS, "Frequency Matching", "Link this to That",
				new ItemStack(ItemInit.frequency_matcher.get()), I18n.format(WANDS_PAGE_2)));
		WandsPageList.add(new GuiTomePage(3, EnumTomeCatagories.WANDS, "Configuerer", "Swithcing Modes",
				new ItemStack(ItemInit.absorber_configurer.get()), I18n.format(WANDS_PAGE_3)));
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
		TOCPageList.add(new GuiTomePageTOC(EnumTomeCatagories.INTRO, new ItemStack(ItemInit.somnolent_powder.get())));
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
