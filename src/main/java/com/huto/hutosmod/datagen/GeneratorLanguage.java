package com.huto.hutosmod.datagen;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.font.ModTextFormatting;
import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.init.EnchantmentInit;
import com.huto.hutosmod.init.EntityInit;
import com.huto.hutosmod.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;

public class GeneratorLanguage extends LanguageProvider {
	public GeneratorLanguage(DataGenerator gen) {
		super(gen, HutosMod.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		/***
		 * 
		 * Tabs,Tooltips,Keybinds, Etc
		 * 
		 */
		add("itemGroup.hutostab", "Forces of Reality");
		add("key.hutosmod.category", "Forces of Reality");
		// Biomes
		add("biome.hutosmod.dream_land", "Dream Lands");
		// Death msgs
		add("death.attack.tentacle", "%1$s was tentacled to death");
		// Container
		add("container.virtuous_enchanter", "Virtuous Enchanter");
		// Jei
		add("hutosmod.jei.wandmaker", "Wand Maker");
		add("hutosmod.jei.resonator", "Vibrarory Resonator");
		add("hutosmod.jei.vibefuser", "Vibrarory Conglomerator");
		add("hutosmod.jei.chisel_station", "Chisel Station");
		// Enchantments
		for (RegistryObject<Enchantment> e : EnchantmentInit.ENCHANTS.getEntries()) {
			addEnchantment(e,
					ModTextFormatting.convertInitToLang(e.get().getName().replace("enchantment.hutosmod.", "")));
		}
		for (RegistryObject<Block> b : BlockInit.BLOCKS.getEntries()) {
			addBlock(b, ModTextFormatting
					.convertInitToLang(b.get().asItem().getTranslationKey().replace("block.hutosmod.", "")));
		}
		for (RegistryObject<Item> i : ItemInit.ITEMS.getEntries()) {
			addItem(i, ModTextFormatting
					.convertInitToLang(i.get().asItem().getTranslationKey().replace("item.hutosmod.", "")));
		}
		for (RegistryObject<EntityType<?>> en : EntityInit.ENTITY_TYPES.getEntries()) {
			addEntityType(en,
					ModTextFormatting.convertInitToLang(en.get().getTranslationKey().replace("entity.hutosmod.", "")));
		}

		/***
		 * 
		 * Pages
		 * 
		 */
		// Guide
		// Intro
		add("title.mystictome.intro.page.1.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.mystictome.intro.page.2.text",
				"The reverberations previously mentioned are in a sense, cosmic whiplash on a universal scale. As the singularity expanded, every particle was thrown around in every which way. While at first, this was cause for chaos, the wheels of time have marched on and calmed things down as they do rendering the vibrations very minute, but minute is not zero. Minute for one atom can be magnified exponentially when concentrated enough, resonating with one another allowing for the force of the big bang to be felt once more.");
		add("title.mystictome.intro.page.3.text",
				"One of the quirks of the antimatter/matter duality is that the vibrations of these particles are opposite and equal as well. These vibrations follow the same principle that all other forms of vibration be it sound/light/electricity etc, in that they amplify when met with similar waves and cancel when met with opposing waves. Building on the concentration effect of these vibrations, the idea of karma can even be traced back as the balance of these vibrations within your body, and mana is just the net force of the anti and positive waves manifesting as a physical and invisible force.");
		add("title.mystictome.intro.page.4.text",
				"Matter and antimatter can become \"vibratory\" in some rare examples simply by happenstance when enough of a single frequency of resonating matter comes into close proximity and will somewhat meld together. When they coalesce they are called \"drops\" or \"tears\" for vibrations and antivibration respectively with \"essence\" being the overarching term for both forms of concentrated vibrational matter. Essence can be found in all forms of life with a very low concentration but can be coerced out of them upon death with specialized tools discussed later.");
		add("title.mystictome.intro.page.5.text",
				"The process of inducing vibrations is known as \"Channeling\", mystical sounding in nature, but the elders can be blamed for this. This can be done in a variety of ways all modeled off of trying to artificially induce the natural essence production, by essentially taking a chunk of vibratory or \"conductive\" matter and allowing it to collect more and more matter that begins to resonate with it, which is an exponential process. The beauty of this process is that once an original drop or tear of matter is created, it will naturally start to produce more of itself with little aide.If only there was a way to contain this growth...");
		add("title.mystictome.intro.page.6.text",
				"As mentioned prior, these vibrations behave the same way that any other wave does, and as such can be stopped or dampened with an opposite waveform. Producing this waveform can be tricky but with a little bit of experimenting, discovering that the more your around concentrated matter, the more sensitive you become to it, beginning to be able to sense slight differences in direction and amplitude each drop. By using matter of specific frequency you can change the characteristics of other matter by forcing contact with the target. The process of canceling vibrations intentionally is called \"Nullification\" and is incredibly useful.");
		add("title.mystictome.intro.page.7.text",
				"Due to the nature of life itself, being inherently organized, living beings are naturally enriched with essence, almost completely filled with positive vibrations in fact. This is not to say that ALL creatures are positive, there are some exceptions that have net negative vibrations(withers and end creatures), and some that have none at all(skeletons and other inorganic life)! Because of this, the essence can be farmed quite readily through the process of death, with the correct tools, of course, ones that nullified vibrations maybe?"); // Coven

		// World
		add("title.mystictome.world.page.1.text",
				"With all this talk of how important vibrations are, it should be no surprise that the world around you has been influenced if not entirely formed around these waves. Everything from where and the way plants grow, to the migration of animals, the weather patterns, and even the oceans currents all follow these principals. The scary part is that, even though you are not aware of it, even your own consciousness is influenced by these tiny events, affecting what you do and how you behave depending on where you may be. Many mental ailments in fact can be chalked up to vibrational imbalances.");
		add("title.mystictome.world.page.2.text",
				"The plants around us have very little way of communicating with us, so they can’t necessarily tell us what the vibrations do to influence them, but do to the research of scholars prior we have realized by forcing vibrations of all kinds into plants what effect they have on them. While they did exist prior albeit very solemnly, there is a type of tree that is especially good at vibrationally channeling and as such have even turned blue! Their existence now however has been spread even farther as a result of an experiment run loose and allowing a genetically altered species of this tree to appear even more commonly, albeit quite skinnier.");
		add("title.mystictome.world.page.3.text",
				"The mind sure is a magical place in its own right, but it is normally locked away inside of that skull of yours. When you dream the barrier between reality and imagination starts to dissolve, allowing for a glimpse into a world completely of your own subconscious. Believe it or not dreams and the mind are influenced vibrations, and when many people all sleep together they start harmonizing together as they dream.");
		add("title.mystictome.world.page.4.text",
				"Normally this harmony is not noticeable but with a little help from a form of amplification, dreams could be experienced together in a much more cohesive solid way. The method of amplification has been sadly lost to history, but whispers of a group in the past seems that there was a type of headwear that could serve this role perfectly. One day maybe you will be able to recreate this style of headwear by your own experimentation.");
		add("title.mystictome.world.page.5.text",
				"On the flip-side to good old fashioned Dreamscape Im sure you are well versed in by now, there is a secondary realm that exists on the same frequency at the opposite end of the spectrum known as \"The Nightmare realm\".Thisplaceseemstobeonlyaccessiblebythesamemeansastheordinarydreamscape,butonlywhencertainconditionsaremet...althoughitdoesseemthatthosewithamuchhigherkarmicdebtaremorelikelytovisittheremoreoften.");

		// Equipment
		add("title.mystictome.equip.page.1.text",
				"Duis congue fermentum lobortis. Donec volutpat, nisi ac semper accumsan, odio turpis vulputate diam, a dictum ex dui nec eros. Maecenas venenatis faucibus neque, id pharetra diam lobortis quis. Ut lacinia, ex eget viverra commodo, dui mi eleifend tellus, bibendum sagittis nulla ligula ut justo. Vivamus feugiat eros vel maximus euismod. Ut fermentum nisi ut nulla lobortis, at congue elit lacinia. Vestibulum ornare mauris et purus vestibulum semper. Ut dignissim sem vel tellus maximus, at congue justo convallis. Cras tristique.");
		add("title.mystictome.equip.page.2.text",
				"Duis congue fermentum lobortis. Donec volutpat, nisi ac semper accumsan, odio turpis vulputate diam, a dictum ex dui nec eros. Maecenas venenatis faucibus neque, id pharetra diam lobortis quis. Ut lacinia, ex eget viverra commodo, dui mi eleifend tellus, bibendum sagittis nulla ligula ut justo. Vivamus feugiat eros vel maximus euismod. Ut fermentum nisi ut nulla lobortis, at congue elit lacinia. Vestibulum ornare mauris et purus vestibulum semper. Ut dignissim sem vel tellus maximus, at congue justo convallis. Cras tristique.");

		// Blocks
		add("title.mystictome.blocks.page.1.text",
				"Duis congue fermentum lobortis. Donec volutpat, nisi ac semper accumsan, odio turpis vulputate diam, a dictum ex dui nec eros. Maecenas venenatis faucibus neque, id pharetra diam lobortis quis. Ut lacinia, ex eget viverra commodo, dui mi eleifend tellus, bibendum sagittis nulla ligula ut justo. Vivamus feugiat eros vel maximus euismod. Ut fermentum nisi ut nulla lobortis, at congue elit lacinia. Vestibulum ornare mauris et purus vestibulum semper. Ut dignissim sem vel tellus maximus, at congue justo convallis. Cras tristique.");
		add("title.mystictome.blocks.page.2.text",
				"Duis congue fermentum lobortis. Donec volutpat, nisi ac semper accumsan, odio turpis vulputate diam, a dictum ex dui nec eros. Maecenas venenatis faucibus neque, id pharetra diam lobortis quis. Ut lacinia, ex eget viverra commodo, dui mi eleifend tellus, bibendum sagittis nulla ligula ut justo. Vivamus feugiat eros vel maximus euismod. Ut fermentum nisi ut nulla lobortis, at congue elit lacinia. Vestibulum ornare mauris et purus vestibulum semper. Ut dignissim sem vel tellus maximus, at congue justo convallis. Cras tristique.");
		add("title.mystictome.blocks.page.3.text",
				"Duis congue fermentum lobortis. Donec volutpat, nisi ac semper accumsan, odio turpis vulputate diam, a dictum ex dui nec eros. Maecenas venenatis faucibus neque, id pharetra diam lobortis quis. Ut lacinia, ex eget viverra commodo, dui mi eleifend tellus, bibendum sagittis nulla ligula ut justo. Vivamus feugiat eros vel maximus euismod. Ut fermentum nisi ut nulla lobortis, at congue elit lacinia. Vestibulum ornare mauris et purus vestibulum semper. Ut dignissim sem vel tellus maximus, at congue justo convallis. Cras tristique.");
		add("title.mystictome.blocks.page.4.text",
				"Duis congue fermentum lobortis. Donec volutpat, nisi ac semper accumsan, odio turpis vulputate diam, a dictum ex dui nec eros. Maecenas venenatis faucibus neque, id pharetra diam lobortis quis. Ut lacinia, ex eget viverra commodo, dui mi eleifend tellus, bibendum sagittis nulla ligula ut justo. Vivamus feugiat eros vel maximus euismod. Ut fermentum nisi ut nulla lobortis, at congue elit lacinia. Vestibulum ornare mauris et purus vestibulum semper. Ut dignissim sem vel tellus maximus, at congue justo convallis. Cras tristique.");
		add("title.mystictome.blocks.page.5.text",
				"Duis congue fermentum lobortis. Donec volutpat, nisi ac semper accumsan, odio turpis vulputate diam, a dictum ex dui nec eros. Maecenas venenatis faucibus neque, id pharetra diam lobortis quis. Ut lacinia, ex eget viverra commodo, dui mi eleifend tellus, bibendum sagittis nulla ligula ut justo. Vivamus feugiat eros vel maximus euismod. Ut fermentum nisi ut nulla lobortis, at congue elit lacinia. Vestibulum ornare mauris et purus vestibulum semper. Ut dignissim sem vel tellus maximus, at congue justo convallis. Cras tristique.");
		add("title.mystictome.blocks.page.6.text",
				"Duis congue fermentum lobortis. Donec volutpat, nisi ac semper accumsan, odio turpis vulputate diam, a dictum ex dui nec eros. Maecenas venenatis faucibus neque, id pharetra diam lobortis quis. Ut lacinia, ex eget viverra commodo, dui mi eleifend tellus, bibendum sagittis nulla ligula ut justo. Vivamus feugiat eros vel maximus euismod. Ut fermentum nisi ut nulla lobortis, at congue elit lacinia. Vestibulum ornare mauris et purus vestibulum semper. Ut dignissim sem vel tellus maximus, at congue justo convallis. Cras tristique.");
		add("title.mystictome.blocks.page.7.text",
				"Duis congue fermentum lobortis. Donec volutpat, nisi ac semper accumsan, odio turpis vulputate diam, a dictum ex dui nec eros. Maecenas venenatis faucibus neque, id pharetra diam lobortis quis. Ut lacinia, ex eget viverra commodo, dui mi eleifend tellus, bibendum sagittis nulla ligula ut justo. Vivamus feugiat eros vel maximus euismod. Ut fermentum nisi ut nulla lobortis, at congue elit lacinia. Vestibulum ornare mauris et purus vestibulum semper. Ut dignissim sem vel tellus maximus, at congue justo convallis. Cras tristique.");
		add("title.mystictome.blocks.page.8.text",
				"Duis congue fermentum lobortis. Donec volutpat, nisi ac semper accumsan, odio turpis vulputate diam, a dictum ex dui nec eros. Maecenas venenatis faucibus neque, id pharetra diam lobortis quis. Ut lacinia, ex eget viverra commodo, dui mi eleifend tellus, bibendum sagittis nulla ligula ut justo. Vivamus feugiat eros vel maximus euismod. Ut fermentum nisi ut nulla lobortis, at congue elit lacinia. Vestibulum ornare mauris et purus vestibulum semper. Ut dignissim sem vel tellus maximus, at congue justo convallis. Cras tristique.");
		// Wands
		add("title.mystictome.wands.page.1.text",
				"Duis congue fermentum lobortis. Donec volutpat, nisi ac semper accumsan, odio turpis vulputate diam, a dictum ex dui nec eros. Maecenas venenatis faucibus neque, id pharetra diam lobortis quis. Ut lacinia, ex eget viverra commodo, dui mi eleifend tellus, bibendum sagittis nulla ligula ut justo. Vivamus feugiat eros vel maximus euismod. Ut fermentum nisi ut nulla lobortis, at congue elit lacinia. Vestibulum ornare mauris et purus vestibulum semper. Ut dignissim sem vel tellus maximus, at congue justo convallis. Cras tristique.");

		// Karma
		add("title.mystictome.runes.page.1.text",
				"One of the more obscure and well...macabre ways that vibrations can be channeled is through the use of special designs carved into slates called \"runes\", the carvings in these runes are unique and as such provide unique effects based on the direction, amount, and frequencies of vibrations they channel these. These runes are normally carried just on your person but they carry a bit deeper of an effect.");
		add("title.mystictome.runes.page.2.text",
				"These mind runes hide a bit darker side than just being a simple good luck charm however, they have physical and metaphysical sides. The channels in the stone are actually mirrored on the brain of the carrier, unlocking the effects inside of the person, not just applying them. While in functionality this change is almost unnoticeable, but can be uplifting knowing that these powers were within you all along.");
		// Elder
		add("title.mystictome.elder.page.1.text",
				"Maecenas sit amet mi magna. Vivamus a mauris vitae dolor vehicula aliquet at eu ipsum. Integer a ligula mollis, fermentum erat ornare, fringilla nisi. Vestibulum pharetra feugiat velit, a porta leo imperdiet quis. Cras rutrum sed urna sit amet egestas. Suspendisse faucibus eget erat et venenatis. Nam interdum sollicitudin erat, quis sodales ligula mattis ac. Phasellus rhoncus ultrices libero eget tempus. Nullam mattis lectus neque, at ultricies sapien interdum eget. Pellentesque eget consequat magna, sit amet vulputate neque. Ut lacus.");
		add("title.mystictome.elder.page.2.text",
				"Maecenas sit amet mi magna. Vivamus a mauris vitae dolor vehicula aliquet at eu ipsum. Integer a ligula mollis, fermentum erat ornare, fringilla nisi. Vestibulum pharetra feugiat velit, a porta leo imperdiet quis. Cras rutrum sed urna sit amet egestas. Suspendisse faucibus eget erat et venenatis. Nam interdum sollicitudin erat, quis sodales ligula mattis ac. Phasellus rhoncus ultrices libero eget tempus. Nullam mattis lectus neque, at ultricies sapien interdum eget. Pellentesque eget consequat magna, sit amet vulputate neque. Ut lacus.");
		// Covens
		// Self
		add("title.coventome.self.page.1.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true");
		add("title.coventome.self.page.2.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.self.page.3.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.self.page.4.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.self.page.5.text", "Tulpa");
		// Hastur
		add("title.coventome.hastur.page.1.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true");
		add("title.coventome.hastur.page.2.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.hastur.page.3.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.hastur.page.4.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		// Seraph
		add("title.coventome.ascendent.page.1.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true");
		add("title.coventome.ascendent.page.2.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.ascendent.page.3.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.ascendent.page.4.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		// Eldritch
		add("title.coventome.eldritch.page.1.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true");
		add("title.coventome.eldritch.page.2.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.eldritch.page.3.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.eldritch.page.4.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		// Beast
		add("title.coventome.beast.page.1.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true");
		add("title.coventome.beast.page.2.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.beast.page.3.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.beast.page.4.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		// Machine
		add("title.coventome.machine.page.1.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true");
		add("title.coventome.machine.page.2.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.machine.page.3.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.machine.page.4.text",
				"The big bang created the universe, making existence out of nothing, pushing everything out from a central point with incredible momentum. With this massive amount of force, came an equal production of both antimatter and standard matter. From the start, everything had it's opposite. This fact can be claimed to be one of the few principles in existence that always holds true, be it science or magic. The forging of the universe is not a relic of ages past, literal reverberations from the explosion can still be felt and interacted with.");
		add("title.coventome.machine.page.5.text",
				"To know the machine, to know the spark of life itself, just as you run on  spirit, as do machines, Create an artifical soul");
		add("title.coventome.machine.page.6.text",
				"No matter how meticulous the great tinkerer is, when starting any new task, mistakes and hiccups are bound to occur. The Malformed Automaton is exactly that hiccup. Broken and Deranged, It was cast into the scrap heap of creation to slowly rust and decay. However its primeval spark still remains, waiting eagerly to inhabit its old vessel");

		/***
		 * Rune Pattern Text
		 */
		// Misc
		add("name.RUNE", "Base Rune");
		add("name.CONTRACT", "Contract Runes");
		//Rune Binder
		add("hutosmod.nbtdata", "NBT Tags");
		add("hutosmod.whitelist", "Whitelist");
		add("hutosmod.autopickupenabled", "Auto-Pickup: Enabled");
		add("hutosmod.autopickupdisabled", "Auto-Pickup: Disabled");
		add("hutosmod.autopickup", "Auto-Pickup");
		add("hutosmod.shift", "Press <Shift> for info.");
		// Contract
		add("runepattern.rune_pattern_beast_c.text",
				"Beast Contract Rune, Unleash your inner beast, destroy your Ego and let the Id become all you are, a primal beast of pure strength.");
		add("runepattern.rune_pattern_corruption_c.text",
				"Corruption Contract Rune, Corrupted by those who wished you the worst, your faith has become dark, your dreams have become nightmares!");
		add("runepattern.rune_pattern_impurity_c.text",
				"Impurity Contract Rune, Your blood has become tainted and black, you hunger for all that is immoral and unclean...");
		add("runepattern.rune_pattern_milkweed_c.text",
				"Milkweed Contract Rune, Gain contact with the outer beings from beyond all known realms, learn from them, if you dare...");
		add("runepattern.rune_pattern_radiance_c.text",
				"Radiance Contract Rune, Shining symbol of rioutous grace and fury, unleash your inner saint against all the heathens you face!");
		add("runepattern.rune_pattern_hunter_c.text",
				"Hunter Contract Rune, A trained killer, set in your ways, a true hunter of hunters, the battle has become your symphony and weapons are your muse.");
		// Basic
		add("runepattern.rune_pattern_metamorphosis.text",
				"Anti Metamorphosis Rune, The crooked metamorphosis has begun, your vitatlity has increased, you feel like you could regrow anything!");
		add("runepattern.rune_pattern_metamorphosis_cw.text",
				"Metamorphois Rune, The proper metamorphosis has begun, your vitality has increased, you feel full of life anew!");
		add("runepattern.rune_pattern_lake.text",
				"Lake Rune, The rushing of sacred waters, the roar of a great ocean calls to you, you know your home, and it beckons you back..");
		add("runepattern.rune_pattern_clawmark.text",
				"Clawmark Rune, Tooth and Nail is all you know, the endless fight has just begun, bring the armies home, they are no threat.");
		add("runepattern.rune_pattern_rapture.text",
				"Rapture Rune, The blood of war is your fuel, the lifeblood of your enemy becomes your own, absorb those who would oppose you!");
		add("runepattern.rune_pattern_oedon.text",
				"Oedon Rune, You feel as if you have a false heart, one granted to you on contract, nevertheless this life is yours now, use it.");
		add("runepattern.rune_pattern_eye.text",
				"Eye Rune, Your eyes, o' glorious eyes! do not faulter, do not die, for you shall see, beyond the veil, to see what the darkness entails...");
		add("runepattern.rune_pattern_moon.text",
				"Moon Rune, The great moon above has become your muse, it is what drives you, turn away from the cursed sun, carpe noctum!");
		add("runepattern.rune_pattern_beast.text",
				"Beast Rune, The howl of a gale, the howl of the beast, it is one and all in you, run like the wind, endless and with drive!");
		add("runepattern.rune_pattern_heir.text",
				"Heir Rune, you develop this watchful sense,you, the spiritual succesor to a once great power, shall rekindle their former glory; Divine Heir.");
		add("runepattern.rune_guidance.text",
				"Guidance Rune, The supernatural blessing, one of fortune and direction, may it guide you to your wants, as it has so many others before.");
		add("runepattern.rune_communion.text",
				"Communion Rune, The call from beyond rings louder for you, you wish to join them, you must join them. join.joi,jo...");

	}
}