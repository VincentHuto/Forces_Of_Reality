package com.vincenthuto.forcesofreality.gui.guide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vincenthuto.hutoslib.client.screen.guide.GuiGuidePage;
import com.vincenthuto.hutoslib.client.screen.guide.GuiGuideTitlePage;
import com.vincenthuto.hutoslib.client.screen.guide.TomeCategoryTab.TabColor;
import com.vincenthuto.hutoslib.client.screen.guide.TomeChapter;
import com.vincenthuto.hutoslib.client.screen.guide.TomeLib;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ForcesLib extends TomeLib {

	// Self
	public static String SELF_PAGE_1 = "Self: focused on peace, self reliance, non destruction and healing.Bonsais, Akebi fruit, chakra";
	public static String SELF_PAGE_2 = "Guardian: Tulpa";
	public static String SELF_PAGE_3 = "Lord: Veritas";
	public static String SELF_PAGE_4 = "Animal: Self";
	public static String SELF_PAGE_5 = "Altar: Bonsais and the devotion is based on grooming them";
	public static String SELF_PAGE_6 = "Alignment: Positive\nCounter coven- Hastur";
	public static String SELF_PAGE_7 = "Tools: ";

	// Hastur
	public static String HASTUR_PAGE_1 = "Hastur: Focused on control, deception, cunning, yellow, and tentacles";
	public static String HASTUR_PAGE_2 = "Guardian: Hastur;The Lord in yellow.";
	public static String HASTUR_PAGE_3 = "Lord: Hastur; The Great Xanthous Deciever";
	public static String HASTUR_PAGE_4 = "Animal: Hastur Vassal";
	public static String HASTUR_PAGE_5 = "Altar: Untold Easel\nDevotional: Yellow Sign\nSacrifices:(Unsettling Fabric, Unsettling Tapestry)";
	public static String HASTUR_PAGE_6 = "Alignment: Positive\nCounter coven- Hastur";
	public static String HASTUR_PAGE_7 = "Tools: Yellow Tome";

	// Ascendant
	public static String ASCENDANT_PAGE_1 = "Ascendant: Light,justice, Wings, order, Anti undead etc";
	public static String ASCENDANT_PAGE_2 = "Guardian: Seraph";
	public static String ASCENDANT_PAGE_3 = "Lord: Tetra;The 4-Fold Light";
	public static String ASCENDANT_PAGE_4 = "Animal: Angelic Fowl";
	public static String ASCENDANT_PAGE_5 = "Altar: Ascendant Altar\nDevotional: Crossed Keys\nSacrifices(Seraph Feather,Wing Fragment)";
	public static String ASCENDANT_PAGE_6 = "Alignment: Positive\nCounter coven- Eldritch";
	public static String ASCENDANT_PAGE_7 = "Tools: Divine Feather\nDiscordent Bell\nSeraph Wings";

	// Eldritch
	public static String ELDRITCH_PAGE_1 = "Eldritch: Chaos, confusion eyes purple black, obscuration, mist, teleportation,body mutation";
	public static String ELDRITCH_PAGE_2 = "Guardian: Dark Young";
	public static String ELDRITCH_PAGE_3 = "Lord: Uzouthrhix";
	public static String ELDRITCH_PAGE_4 = "Animal: Scuttling Occulus";
	public static String ELDRITCH_PAGE_5 = "Altar: Occular Heap\nDevotional: Everwatchful Pendant\nSacrifices(Suspicious Eye,Ball of Eyes)";
	public static String ELDRITCH_PAGE_6 = "Alignment: Negative\nCounter coven- Ascendant";
	public static String ELDRITCH_PAGE_7 = "Tools: Demon Flute\nDestabilization Charm\nSoaking & Strorming Agents";
	// Beast
	public static String BEAST_PAGE_1 = "Beast: Wild, bloodlust, nature, primal, pack mentality, swarming ,fur, bones, teeth, etc";
	public static String BEAST_PAGE_2 = "Guardian: Beast from Beyond";
	public static String BEAST_PAGE_3 = "Lord: The Lord of the Wild";
	public static String BEAST_PAGE_4 = "Animal: Deranged Beast";
	public static String BEAST_PAGE_5 = "Altar: Sacrificial Pyre\nDevotional: Breath of the Beast\nSacrifices(Blooddrawn Fang,Beastly Bone)";
	public static String BEAST_PAGE_6 = "Alignment: Negative\nCounter coven- Machine";
	public static String BEAST_PAGE_7 = "Tools: Predator View\nBoost in Forest and like biomes";
	// Machine
	public static String MACHINE_PAGE_1 = "Machina: Hand made creations and true order, binary truths, cogs and wheels, electricy and rockets, The Machina Spark and it's power, Mechanical Augmentation";
	public static String MACHINE_PAGE_2 = "Guardian: Malformed Automaton \nNo matter how meticulous the great tinkerer is, when starting any new task, mistakes and hiccups are bound to occur. The Malformed Automaton is exactly that hiccup. Broken and Deranged, It was cast into the scrap heap of creation to slowly rust and decay. However its primeval spark still remains, waiting eagerly to inhabit its old vessel";
	public static String MACHINE_PAGE_3 = "Lord: Mechan; The Great Tinkerer/The Origin of Spark";
	public static String MACHINE_PAGE_4 = "Animal: DreadBot";
	public static String MACHINE_PAGE_5 = "Altar: Machina Spark\nDevotional: Integral Cog\nSacrifices(Discarded Cog,Neurotic Mechanism)";
	public static String MACHINE_PAGE_6 = "Alignment: Positive\nCounter coven- Beast";
	public static String MACHINE_PAGE_7 = "Tools: Mechan Glove and Modules";
	public static String MACHINE_PAGE_8 = "Machina Spark: To know the machine, to know the spark of life itself, just as you run on  spirit, as do machines, Create an artifical soul and you can achieve anything";
	// Combination
	public static String COMBINE_PAGE_1 = "Up until this point it appeared that despite having alignments and similarites, It has seemed that each coven stayed pretty well seperate from one another, well after doing enough research the ability to combine two(or more) covens powers seems not so crazy afterall.";
	public static String COMBINE_PAGE_2 = "Now while it may be possible, it certainly wont be easy, as the process of being in the graces of one lord is hard enough, let alone several who are willing to work with one another, that says, the one immobile boundry is that covens that are directly opposed to one another remain impossible to combine.";
	public static String COMBINE_PAGE_3 = "Examples of these impossibilites include Hastur-Self, Eldritch-Ascendant, and Machine-Beast, everyother combination, even of several should in theory be possible, with more similar covens being easy than others, and the more combined the harder it will be.";
	public static String COMBINE_PAGE_4 = "As mentioned, to be able to combine several covens powers, you must be in good graces with each of the covens lords with a high alliegence to all partys involved, and even then, the materials needed to form such combinations are exotic and expensive, but will be worth the cost in the end.";
	public static String COMBINE_PAGE_5 = "As a primary example, Calling on the powers of Both Mechan and Uzouthrhix will allow the creation of a corrupted glove module, channeling eldritch energy into the gauntlet to unleash a blast of destructive eldritch energy.";
	public static String COMBINE_PAGE_6 = "Concecrated Aurum is a blessed amalgam of both annointed iron scraps as well as auric energy, they can be created in a few ways, all forms however bestow enchanted properties unto the metal, giving it destructive powers on undead and beasts alike.";
	public static String COMBINE_PAGE_7 = "The cornered hounds are far more than a way of referencing their moods,they physically spawn out of the corners of rooms and hunt down whatever being they are instructed to, fading back to the abyss once finished off.";
	public static String COMBINE_PAGE_8 = "Combining the Cunning wit of Hastur along with the ingenious technology of mechan provides us with a solution most tricky to our weapons and tools, Using trick tools they are items that function as 2 or more at once, from bowblades to trickaxes";

	public static List<TomeChapter> chapters = new ArrayList<>();
	public static List<GuiGuidePage> introPages = new ArrayList<>();
	public static List<GuiGuidePage> selfPages = new ArrayList<>();
	public static List<GuiGuidePage> hasturPages = new ArrayList<>();
	public static List<GuiGuidePage> eldritchPages = new ArrayList<>();
	public static List<GuiGuidePage> ascendantPages = new ArrayList<>();
	public static List<GuiGuidePage> beastPages = new ArrayList<>();
	public static List<GuiGuidePage> machinePages = new ArrayList<>();
	public static List<GuiGuidePage> combinePages = new ArrayList<>();

	public static TomeChapter introChapter, selfChapter, hasturChapter, eldritchChapter, ascendantChapter, beastChapter,
			machineChapter, combineChapter;

	@Override
	public List<TomeChapter> getChapters() {
		return chapters;
	}

	@Override
	public GuiGuideTitlePage getTitle() {
		return new ForcesTitlePage();
	}

	@Override
	public void registerChapters() {
		introChapter = new TomeChapter("Intro", TabColor.BLACK, new ForcesGuideTOC("Intro"), introPages);
		selfChapter = new TomeChapter("Self", TabColor.WHITE, new ForcesGuideTOC("Self"), selfPages);
		hasturChapter = new TomeChapter("Hastur", TabColor.YELLOW, new ForcesGuideTOC("Hastur"), hasturPages);
		eldritchChapter = new TomeChapter("Eldritch", TabColor.PURPLE, new ForcesGuideTOC("Eldritch"), eldritchPages);
		ascendantChapter = new TomeChapter("Ascendant", TabColor.CYAN, new ForcesGuideTOC("Ascendant"), ascendantPages);
		beastChapter = new TomeChapter("Beast", TabColor.RED, new ForcesGuideTOC("Beast"), beastPages);
		machineChapter = new TomeChapter("Machine", TabColor.ORANGE, new ForcesGuideTOC("Machine"), machinePages);
		combineChapter = new TomeChapter("Combine", TabColor.RAINBOW, new ForcesGuideTOC("Combine"), combinePages);

		Collections.addAll(chapters, introChapter, selfChapter, hasturChapter, eldritchChapter, ascendantChapter,
				beastChapter, machineChapter, combineChapter);

	}

	@Override
	public void registerTome() {

		introPages.add(new ForcesGuideTOC("Intro"));
		introPages.add(new ForcesGuidePage(1, "Intro", "Hemomancy", "No its not Blood Magic",
				"Welcome to Hemomancy! My first(released) major mod, This is a magic mod centered around blood, and blood control, focusing more so on the quality and efficency of blood rather than quantity."));
		introPages.add(new ForcesGuidePage(2, "Intro", "Intro", "Getting to know yourself",
				"ejfiuoejhwiofehjwiofhnjewifnhjuew", new ItemStack(Items.BOOK)));

		selfPages.add(new ForcesGuideTOC("Self"));
		selfPages.add(new ForcesGuidePage(1, "Self", "The Path of One", "", SELF_PAGE_1));
		selfPages.add(new ForcesGuidePage(2, "Self", "Guardian", "Tulpa", SELF_PAGE_2));
		selfPages.add(new ForcesGuidePage(3, "Self", "Lord", "Veritas", SELF_PAGE_3));
		selfPages.add(new ForcesGuidePage(4, "Self", "Animal", "Ibis", SELF_PAGE_4));
		selfPages.add(new ForcesGuidePage(5, "Self", "Altar", "Bonsai", SELF_PAGE_5));
		selfPages.add(new ForcesGuidePage(6, "Self", "Alignment", "Positive", SELF_PAGE_6));
		selfPages.add(new ForcesGuidePage(7, "Self", "Tools", "Tricks of the Trade", SELF_PAGE_7));
		hasturPages.add(new ForcesGuideTOC("Hastur"));
		hasturPages.add(new ForcesGuidePage(1, "Hastur", "Hastur", "The Great Deciever", HASTUR_PAGE_1));
		hasturPages.add(new ForcesGuidePage(2, "Hastur", "Guardian", "Hastur; The Lord in Yellow", HASTUR_PAGE_2));
		hasturPages.add(new ForcesGuidePage(3, "Hastur", "Lord", "Hastur; The Great Xanthous Deciever", HASTUR_PAGE_3));
		hasturPages.add(new ForcesGuidePage(4, "Hastur", "Animal", "Hastur Vassal", HASTUR_PAGE_4));
		hasturPages.add(new ForcesGuidePage(5, "Hastur", "Altar", "Untold Easel", HASTUR_PAGE_5));
		hasturPages.add(new ForcesGuidePage(6, "Hastur", "Alignment", "Negative", HASTUR_PAGE_6));
		hasturPages.add(new ForcesGuidePage(7, "Hastur", "Tools", "Tricks of the Trade", HASTUR_PAGE_7));
		eldritchPages.add(new ForcesGuideTOC("Eldritch"));
		eldritchPages.add(new ForcesGuidePage(1, "Eldritch", "Eldritch", "The Bizzare and Obscure", ELDRITCH_PAGE_1));
		eldritchPages.add(new ForcesGuidePage(2, "Eldritch", "Guardian", "The Dark Young", ELDRITCH_PAGE_2));
		eldritchPages.add(new ForcesGuidePage(3, "Eldritch", "Lord", "*($8($?$!jrjsn+UFHHHHH", ELDRITCH_PAGE_3));
		eldritchPages.add(new ForcesGuidePage(4, "Eldritch", "Animal", "Scuttling Occulus", ELDRITCH_PAGE_4));
		eldritchPages.add(new ForcesGuidePage(5, "Eldritch", "Altar", "Occular Heap", ELDRITCH_PAGE_5));
		eldritchPages.add(new ForcesGuidePage(6, "Eldritch", "Alignment", "Negative", ELDRITCH_PAGE_6));
		eldritchPages.add(new ForcesGuidePage(7, "Eldritch", "Tools", "Tricks of the Trade", ELDRITCH_PAGE_7));
		ascendantPages.add(new ForcesGuideTOC("Ascendant"));

		ascendantPages.add(new ForcesGuidePage(1, "Ascendant", "Ascendant", "The Heavens Above", ASCENDANT_PAGE_1));
		ascendantPages
				.add(new ForcesGuidePage(2, "Ascendant", "Guardian", "Seraph; The Holy Knight", ASCENDANT_PAGE_2));
		ascendantPages.add(new ForcesGuidePage(3, "Ascendant", "Lord", "Tetra: The Four-Fold Light", ASCENDANT_PAGE_3));
		ascendantPages.add(new ForcesGuidePage(4, "Ascendant", "Animal", "Angelic Fowl", ASCENDANT_PAGE_4));
		ascendantPages.add(new ForcesGuidePage(5, "Ascendant", "Altar", "Ascendant Altar", ASCENDANT_PAGE_5));
		ascendantPages.add(new ForcesGuidePage(6, "Ascendant", "Alignment", "Positive", ASCENDANT_PAGE_6));
		ascendantPages.add(new ForcesGuidePage(7, "Ascendant", "Tools", "Tricks of the Trade", ASCENDANT_PAGE_7));
		beastPages.add(new ForcesGuideTOC("Beast"));

		beastPages.add(new ForcesGuidePage(1, "Beast", "Beast", "Unleash your Wild Side", BEAST_PAGE_1));
		beastPages.add(new ForcesGuidePage(2, "Beast", "Guardian", "Beast from Beyondight", BEAST_PAGE_2));
		beastPages.add(new ForcesGuidePage(3, "Beast", "Lord", "Ferox: The Lord of the Wild", BEAST_PAGE_3));
		beastPages.add(new ForcesGuidePage(4, "Beast", "Animal", "Deranged Beast", BEAST_PAGE_4));
		beastPages.add(new ForcesGuidePage(5, "Beast", "Altar", "Sacrificial Pyre", BEAST_PAGE_5));
		beastPages.add(new ForcesGuidePage(6, "Beast", "Alignment", "Negative", BEAST_PAGE_6));
		beastPages.add(new ForcesGuidePage(7, "Beast", "Tools", "Tricks of the Trade", BEAST_PAGE_7));
		machinePages.add(new ForcesGuideTOC("Machine"));

		machinePages
				.add(new ForcesGuidePage(1, "Machine", "Machine", "Construct the life you deserve", MACHINE_PAGE_1));
		machinePages.add(new ForcesGuidePage(2, "Machine", "Guardian", "Malformed Automaton", MACHINE_PAGE_2));
		machinePages.add(new ForcesGuidePage(3, "Machine", "Lord", "Mechan; The Great Tinkerer", MACHINE_PAGE_3));
		machinePages.add(new ForcesGuidePage(4, "Machine", "Animal", "Dreadbot", MACHINE_PAGE_4));
		machinePages.add(new ForcesGuidePage(5, "Machine", "Altar", "Machina Imperfecta", MACHINE_PAGE_5));
		machinePages.add(new ForcesGuidePage(6, "Machine", "Alignment", "Positive", MACHINE_PAGE_6));
		machinePages.add(new ForcesGuidePage(7, "Machine", "Tools", "Tricks of the Trade", MACHINE_PAGE_7));
		combinePages.add(new ForcesGuideTOC("Combine"));

		combinePages.add(new ForcesGuidePage(1, "Combine", "Forbidden Techniques", "Crossing Streams", COMBINE_PAGE_1));
		combinePages.add(new ForcesGuidePage(2, "Combine", "Direct Opposition", "Impossibilities", COMBINE_PAGE_2));
		combinePages.add(new ForcesGuidePage(3, "Combine", "What Can be done", "It comes with a cost", COMBINE_PAGE_3));
		combinePages.add(new ForcesGuidePage(4, "Combine", "Wicked Module", "Eldritch Machines", COMBINE_PAGE_4));
		combinePages.add(new ForcesGuidePage(5, "Combine", "Anointed Bronze", "Holy Bars", COMBINE_PAGE_5));
		combinePages.add(new ForcesGuidePage(6, "Combine", "Yellow Fiends", "Ensnared Beasts", COMBINE_PAGE_6));
		combinePages.add(new ForcesGuidePage(7, "Combine", "Eldritch Beings", "Conered Hounds", COMBINE_PAGE_7));
		combinePages.add(new ForcesGuidePage(8, "Combine", "Trick Weapons", "Tricks of the Trade", COMBINE_PAGE_8));

		registerChapters();
	}

}
