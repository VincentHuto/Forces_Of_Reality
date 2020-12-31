package com.huto.forcesofreality.init;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.ForcesOfReality.ForcesOfRealityItemGroup;
import com.huto.forcesofreality.capabilities.covenant.EnumCovenants;
import com.huto.forcesofreality.font.ModTextFormatting;
import com.huto.forcesofreality.objects.items.ItemActualizationNode;
import com.huto.forcesofreality.objects.items.ItemChannelingIngot;
import com.huto.forcesofreality.objects.items.ItemCovenTome;
import com.huto.forcesofreality.objects.items.ItemDryingAgent;
import com.huto.forcesofreality.objects.items.ItemElderTome;
import com.huto.forcesofreality.objects.items.ItemGrandPurgingStone;
import com.huto.forcesofreality.objects.items.ItemHarmonicImprint;
import com.huto.forcesofreality.objects.items.ItemManaPowder;
import com.huto.forcesofreality.objects.items.ItemNullIngot;
import com.huto.forcesofreality.objects.items.ItemPurgingStone;
import com.huto.forcesofreality.objects.items.ItemSacrificial;
import com.huto.forcesofreality.objects.items.ItemShatterIngot;
import com.huto.forcesofreality.objects.items.ItemSlugBucket;
import com.huto.forcesofreality.objects.items.ItemSoakingAgent;
import com.huto.forcesofreality.objects.items.ItemSomnolentTome;
import com.huto.forcesofreality.objects.items.ItemStormingAgent;
import com.huto.forcesofreality.objects.items.ItemUpgrade;
import com.huto.forcesofreality.objects.items.ModSpawnEggItem;
import com.huto.forcesofreality.objects.items.armor.EnumModArmorTiers;
import com.huto.forcesofreality.objects.items.armor.ItemAttractionCharm;
import com.huto.forcesofreality.objects.items.armor.ItemAuricHelm;
import com.huto.forcesofreality.objects.items.armor.ItemBackWings;
import com.huto.forcesofreality.objects.items.armor.ItemClovenHooves;
import com.huto.forcesofreality.objects.items.armor.ItemEmpCharm;
import com.huto.forcesofreality.objects.items.armor.ItemEnticingMantle;
import com.huto.forcesofreality.objects.items.armor.ItemInfluenceSuppressor;
import com.huto.forcesofreality.objects.items.armor.ItemMysteriousMask;
import com.huto.forcesofreality.objects.items.armor.ItemRepulsionCharm;
import com.huto.forcesofreality.objects.items.armor.ItemSkullHelmet;
import com.huto.forcesofreality.objects.items.armor.ItemSlimeRepulsionCharm;
import com.huto.forcesofreality.objects.items.armor.ItemSparkDirector;
import com.huto.forcesofreality.objects.items.armor.ItemVibeSeer;
import com.huto.forcesofreality.objects.items.armor.ItemWrithingChest;
import com.huto.forcesofreality.objects.items.armor.ItemWrithingHelm;
import com.huto.forcesofreality.objects.items.fidelity.ItemBeastBreath;
import com.huto.forcesofreality.objects.items.fidelity.ItemCrossedKeys;
import com.huto.forcesofreality.objects.items.fidelity.ItemIntegralCog;
import com.huto.forcesofreality.objects.items.fidelity.ItemWatchfulPendant;
import com.huto.forcesofreality.objects.items.fidelity.ItemYellowSign;
import com.huto.forcesofreality.objects.items.runes.ItemContractRune;
import com.huto.forcesofreality.objects.items.runes.ItemGuidanceRune;
import com.huto.forcesofreality.objects.items.runes.ItemMilkweedRune;
import com.huto.forcesofreality.objects.items.runes.ItemRune;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternBeast;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternBeastContract;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternClawmark;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternCommunion;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternCorruptionContract;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternEye;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternGuidance;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternHeir;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternHunterContract;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternImpurityContract;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternLake;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternMetamorphosis;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternMetamorphosisCW;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternMilkWeedContract;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternMoon;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternOedon;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternRadianceContract;
import com.huto.forcesofreality.objects.items.runes.patterns.ItemRunePatternRapture;
import com.huto.forcesofreality.objects.items.tools.EnumModToolTiers;
import com.huto.forcesofreality.objects.items.tools.ItemAllegianceIdentifier;
import com.huto.forcesofreality.objects.items.tools.ItemBowBlade;
import com.huto.forcesofreality.objects.items.tools.ItemDebugTool;
import com.huto.forcesofreality.objects.items.tools.ItemDemonFlute;
import com.huto.forcesofreality.objects.items.tools.ItemDestructOrb;
import com.huto.forcesofreality.objects.items.tools.ItemDestructOrbContained;
import com.huto.forcesofreality.objects.items.tools.ItemDiscordantBell;
import com.huto.forcesofreality.objects.items.tools.ItemDivineFeather;
import com.huto.forcesofreality.objects.items.tools.ItemFrequencyMatcher;
import com.huto.forcesofreality.objects.items.tools.ItemKnapper;
import com.huto.forcesofreality.objects.items.tools.ItemMachinaCage;
import com.huto.forcesofreality.objects.items.tools.ItemMakerActivator;
import com.huto.forcesofreality.objects.items.tools.ItemManaExtractor;
import com.huto.forcesofreality.objects.items.tools.ItemMechanGlove;
import com.huto.forcesofreality.objects.items.tools.ItemMechanModuleBase;
import com.huto.forcesofreality.objects.items.tools.ItemResonanceDestabalizer;
import com.huto.forcesofreality.objects.items.tools.ItemRuneBinder;
import com.huto.forcesofreality.objects.items.tools.ItemSelfAnalyzer;
import com.huto.forcesofreality.objects.items.tools.ItemSelfReflectionMirror;
import com.huto.forcesofreality.objects.items.tools.ItemStarSlug;
import com.huto.forcesofreality.objects.items.tools.ItemTrickAxe;
import com.huto.forcesofreality.objects.items.tools.ItemWandConsumeVibes;
import com.huto.forcesofreality.objects.items.tools.ItemWandGainVibes;
import com.huto.forcesofreality.objects.items.tools.ItemYellowTome;
import com.huto.forcesofreality.objects.items.tools.ToolVeinPickaxe;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ForcesOfReality.MOD_ID);

	// Return Rune
	public static final RegistryObject<Item> resonance_destabalizer = ITEMS.register("resonance_destabalizer",
			() -> new ItemResonanceDestabalizer(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	public static final RegistryObject<Item> allegiance_identifier = ITEMS.register("allegiance_identifier",
			() -> new ItemAllegianceIdentifier(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));

	// Books
	public static final RegistryObject<Item> somnolent_tome = ITEMS.register("somnolent_tome",
			() -> new ItemSomnolentTome(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> elder_tome = ITEMS.register("elder_tome",
			() -> new ItemElderTome(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> coven_tome = ITEMS.register("coven_tome",
			() -> new ItemCovenTome(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));

	// Grey
	public static final RegistryObject<Item> grey_ingot = ITEMS.register("grey_ingot",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> grey_powder = ITEMS.register("grey_powder",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> grey_crystal = ITEMS.register("grey_crystal",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	// Channeling
	public static final RegistryObject<Item> essence_drop = ITEMS.register("essence_drop",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> channeling_ingot = ITEMS.register("channeling_ingot",
			() -> new ItemChannelingIngot(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> emanating_ingot = ITEMS.register("emanating_ingot",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> somnolent_powder = ITEMS.register("somnolent_powder",
			() -> new ItemManaPowder(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> somnolent_crystal = ITEMS.register("somnolent_crystal",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> channeling_rod = ITEMS.register("channeling_rod",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	// Anti
	public static final RegistryObject<Item> anti_tear = ITEMS.register("anti_tear",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> null_ingot = ITEMS.register("null_ingot",
			() -> new ItemNullIngot(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> shattered_ingot = ITEMS.register("shattered_ingot",
			() -> new ItemShatterIngot(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> nullifying_powder = ITEMS.register("nullifying_powder",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> null_crystal = ITEMS.register("null_crystal",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> null_rod = ITEMS.register("null_rod",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> destruction_orb = ITEMS.register("destruction_orb",
			() -> new ItemDestructOrb(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));

	// Karma
	public static final RegistryObject<Item> node_of_actualization = ITEMS.register("node_of_actualization",
			() -> new ItemActualizationNode(new Item.Properties().group(ForcesOfRealityItemGroup.instance)
					.maxStackSize(1).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> karmic_drop = ITEMS.register("karmic_drop",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> karmic_bar = ITEMS.register("karmic_bar",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> purging_stone = ITEMS.register("purging_stone",
			() -> new ItemPurgingStone(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> grand_purging_stone = ITEMS.register("grand_purging_stone",
			() -> new ItemGrandPurgingStone(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> destruction_orb_contained = ITEMS.register("destruction_orb_contained",
			() -> new ItemDestructOrbContained(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	// Materials
	// Gems

	public static final RegistryObject<Item> gem_hematite = ITEMS.register("gem_hematite",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> gem_ruby = ITEMS.register("gem_ruby",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> gem_onyx = ITEMS.register("gem_onyx",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> gem_sapphire = ITEMS.register("gem_sapphire",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> gem_topaz = ITEMS.register("gem_topaz",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> gem_amethyst = ITEMS.register("gem_amethyst",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> gem_opal = ITEMS.register("gem_opal",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> ibis_beak = ITEMS.register("ibis_beak",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> readied_pane = ITEMS.register("readied_pane",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> resonant_fuel = ITEMS.register("resonant_fuel",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> magatamabead = ITEMS.register("magatamabead",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> enhanced_magatama = ITEMS.register("enhanced_magatama",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> energy_focus = ITEMS.register("energy_focus",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> old_iron_scrap = ITEMS.register("old_iron_scrap",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> raw_clay_flask = ITEMS.register("raw_clay_flask",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> cured_clay_flask = ITEMS.register("cured_clay_flask",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> harmonic_imprint = ITEMS.register("harmonic_imprint",
			() -> new ItemHarmonicImprint(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	// Hastur
	public static final RegistryObject<Item> yellow_sign = ITEMS.register("yellow_sign", () -> new ItemYellowSign(
			new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1).rarity(Rarity.UNCOMMON),
			EnumCovenants.HASTUR, 10));
	public static final RegistryObject<Item> unsettling_fabric = ITEMS.register("unsettling_fabric",
			() -> new ItemSacrificial(new Item.Properties().group(ForcesOfRealityItemGroup.instance),
					EnumCovenants.HASTUR, 1));
	public static final RegistryObject<Item> unsettling_tapestry = ITEMS.register("unsettling_tapestry",
			() -> new ItemSacrificial(new Item.Properties().group(ForcesOfRealityItemGroup.instance),
					EnumCovenants.HASTUR, 3));
	public static final RegistryObject<Item> yellow_tome = ITEMS.register("yellow_tome", () -> new ItemYellowTome(
			new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1).rarity(Rarity.UNCOMMON)));

	// Seraph
	public static final RegistryObject<Item> crossed_keys = ITEMS.register("crossed_keys",
			() -> new ItemCrossedKeys(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.ASCENDENT, 10));
	public static final RegistryObject<Item> seraph_feather = ITEMS.register("seraph_feather",
			() -> new ItemSacrificial(new Item.Properties().group(ForcesOfRealityItemGroup.instance),
					EnumCovenants.ASCENDENT, 1));
	public static final RegistryObject<Item> wing_fragment = ITEMS.register("wing_fragment",
			() -> new ItemSacrificial(new Item.Properties().group(ForcesOfRealityItemGroup.instance),
					EnumCovenants.ASCENDENT, 3));
	public static final RegistryObject<Item> star_slug = ITEMS.register("star_slug", () -> new ItemStarSlug(
			new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> discordant_bell = ITEMS.register("discordant_bell",
			() -> new ItemDiscordantBell(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)
					.rarity(Rarity.RARE)));
	public static final RegistryObject<Item> divine_feather = ITEMS.register("divine_feather",
			() -> new ItemDivineFeather(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)
					.rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> seraph_wings = ITEMS.register("seraph_wings",
			() -> new ItemBackWings(EnumModArmorTiers.SERAPHWINGS, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance)));

	// Eldritch
	public static final RegistryObject<Item> everwatchful_pendant = ITEMS.register("everwatchful_pendant",
			() -> new ItemWatchfulPendant(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.ELDRITCH, 10));
	public static final RegistryObject<Item> suspicious_eye = ITEMS.register("suspicious_eye",
			() -> new ItemSacrificial(new Item.Properties().group(ForcesOfRealityItemGroup.instance),
					EnumCovenants.ELDRITCH, 1));
	public static final RegistryObject<Item> ball_of_eyes = ITEMS.register("ball_of_eyes",
			() -> new ItemSacrificial(new Item.Properties().group(ForcesOfRealityItemGroup.instance),
					EnumCovenants.ELDRITCH, 3));
	public static final RegistryObject<Item> occular_seed = ITEMS.register("occular_seed",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> vitreous_humor = ITEMS.register("vitreous_humor",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> writhing_thread = ITEMS.register("writhing_thread",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> demon_flute = ITEMS.register("demon_flute", () -> new ItemDemonFlute(
			new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1).rarity(Rarity.UNCOMMON)));

	// Beast
	public static final RegistryObject<Item> breath_of_the_beast = ITEMS.register("breath_of_the_beast",
			() -> new ItemBeastBreath(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.BEAST, 10));
	public static final RegistryObject<Item> blooddrawn_fang = ITEMS.register("blooddrawn_fang",
			() -> new ItemSacrificial(new Item.Properties().group(ForcesOfRealityItemGroup.instance),
					EnumCovenants.BEAST, 1));
	public static final RegistryObject<Item> beastly_bone = ITEMS.register("beastly_bone",
			() -> new ItemSacrificial(new Item.Properties().group(ForcesOfRealityItemGroup.instance),
					EnumCovenants.BEAST, 3));
	public static final RegistryObject<Item> skull_helmet = ITEMS.register("skull_helmet",
			() -> new ItemSkullHelmet(EnumModArmorTiers.SKULL, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> enticing_mantle = ITEMS.register("enticing_mantle",
			() -> new ItemEnticingMantle(EnumModArmorTiers.MANTLE, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> legs_of_fawn = ITEMS.register("legs_of_fawn",
			() -> new ArmorItem(EnumModArmorTiers.MANTLE, EquipmentSlotType.LEGS,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> cloven_hooves = ITEMS.register("cloven_hooves",
			() -> new ItemClovenHooves(EnumModArmorTiers.MANTLE, EquipmentSlotType.FEET,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance)));
	// Machine
	public static final RegistryObject<Item> integral_cog = ITEMS.register("integral_cog",
			() -> new ItemIntegralCog(new Item.Properties().group(ForcesOfRealityItemGroup.instance)
					.rarity(ModTextFormatting.AURIC).maxStackSize(1), EnumCovenants.MACHINE, 10));
	public static final RegistryObject<Item> discared_gear = ITEMS.register("discared_gear",
			() -> new ItemSacrificial(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC),
					EnumCovenants.MACHINE, 1));
	public static final RegistryObject<Item> neurotic_mechanism = ITEMS.register("neurotic_mechanism",
			() -> new ItemSacrificial(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC),
					EnumCovenants.MACHINE, 3));
	public static final RegistryObject<Item> auric_ingot = ITEMS.register("auric_ingot", () -> new Item(
			new Item.Properties().group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC)));
	public static final RegistryObject<Item> machina_soul = ITEMS.register("machina_soul",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> machina_cage = ITEMS.register("machina_cage",
			() -> new ItemMachinaCage(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> emp_charm = ITEMS.register("emp_charm",
			() -> new ItemEmpCharm(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)
					.rarity(ModTextFormatting.AURIC)));
	public static final RegistryObject<Item> auric_helm = ITEMS.register("auric_helm",
			() -> new ItemAuricHelm(EnumModArmorTiers.AURICHELM, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC)));
	public static final RegistryObject<Item> auric_chest = ITEMS.register("auric_chest",
			() -> new ArmorItem(EnumModArmorTiers.AURICCHEST, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC)));
	public static final RegistryObject<Item> auric_leggings = ITEMS.register("auric_leggings",
			() -> new ArmorItem(EnumModArmorTiers.AURICCHEST, EquipmentSlotType.LEGS,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC)));
	public static final RegistryObject<Item> auric_boots = ITEMS.register("auric_boots",
			() -> new ArmorItem(EnumModArmorTiers.AURICCHEST, EquipmentSlotType.FEET,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC)));
	public static final RegistryObject<Item> machina_spark_director = ITEMS.register("machina_spark_director",
			() -> new ItemSparkDirector(EnumModArmorTiers.SPARKDIRECTOR, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC),
					false));
	public static final RegistryObject<Item> machina_spark_director_armored = ITEMS.register(
			"machina_spark_director_armored",
			() -> new ItemSparkDirector(EnumModArmorTiers.SPARKDIRECTOR_ARMORED, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC),
					true));

	// Gloves
	public static final RegistryObject<Item> mechan_glove = ITEMS.register("mechan_glove", () -> new ItemMechanGlove(
			new Item.Properties().rarity(Rarity.UNCOMMON).maxStackSize(1).group(ForcesOfRealityItemGroup.instance),
			"mechan_glove", 3, Rarity.UNCOMMON));
	public static final RegistryObject<Item> mechan_glove_superior = ITEMS.register("mechan_glove_superior",
			() -> new ItemMechanGlove(
					new Item.Properties().rarity(Rarity.RARE).maxStackSize(1).group(ForcesOfRealityItemGroup.instance),
					"mechan_glove_superior", 6, Rarity.RARE));
	public static final RegistryObject<Item> mechan_glove_masterpiece = ITEMS.register("mechan_glove_masterpiece",
			() -> new ItemMechanGlove(
					new Item.Properties().rarity(Rarity.EPIC).maxStackSize(1).group(ForcesOfRealityItemGroup.instance),
					"mechan_glove_masterpiece", 9, Rarity.EPIC));
	public static final RegistryObject<Item> mechan_glove_godlike = ITEMS
			.register("mechan_glove_godlike",
					() -> new ItemMechanGlove(
							new Item.Properties().rarity(ModTextFormatting.AURIC).maxStackSize(1)
									.group(ForcesOfRealityItemGroup.instance),
							"mechan_glove_godlike", 9, ModTextFormatting.AURIC));
	// Modules
	public static final RegistryObject<Item> mechan_module = ITEMS
			.register("mechan_module",
					() -> new ItemMechanModuleBase(
							new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
							"Base Module"));
	public static final RegistryObject<Item> mechan_module_rocket = ITEMS.register("mechan_module_rocket",
			() -> new ItemMechanModuleBase(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Fires a singluar exploding rocket at an angle"));
	public static final RegistryObject<Item> mechan_module_salvo = ITEMS.register("mechan_module_salvo",
			() -> new ItemMechanModuleBase(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Fire Several homing rockets that track down targets around player"));
	public static final RegistryObject<Item> mechan_module_shortcircuit = ITEMS.register("mechan_module_shortcircuit",
			() -> new ItemMechanModuleBase(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Fires a ball of electricity that leaps between targets"));
	public static final RegistryObject<Item> mechan_module_laser = ITEMS.register("mechan_module_laser",
			() -> new ItemMechanModuleBase(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Fires a concetrated burst of energy from the glove"));
	public static final RegistryObject<Item> mechan_module_blade = ITEMS.register("mechan_module_blade",
			() -> new ItemMechanModuleBase(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Extrudes a small blade from the glove increasing damage dealt"));
	public static final RegistryObject<Item> mechan_module_thruster = ITEMS.register("mechan_module_thruster",
			() -> new ItemMechanModuleBase(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Increases the power of an equiped Machina Spark Director, Allows for boosting"));

	// Food
	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> akebi_pod = ITEMS.register("akebi_pod",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance).food(new Food.Builder()
					.hunger(6).saturation(1.5f).effect(new EffectInstance(Effects.GLOWING, 6000, 5), 0.7f).build())));
	public static final RegistryObject<Item> singeri_soup = ITEMS.register("singeri_soup",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> raw_morel_on_a_stick = ITEMS.register("raw_morel_on_a_stick",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> cooked_morel_on_a_stick = ITEMS.register("cooked_morel_on_a_stick",
			() -> new Item(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).food(new Food.Builder().hunger(6)
							.saturation(1.5f).effect(new EffectInstance(Effects.ABSORPTION, 6000, 5), 0.7f).build())));
	public static final RegistryObject<Item> somnolent_bottle = ITEMS.register("somnolent_bottle",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> bucket_slug = ITEMS.register("bucket_slug",
			() -> new ItemSlugBucket(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));

	// Charms
	public static final RegistryObject<Item> attraction_charm = ITEMS.register("attraction_charm",
			() -> new ItemAttractionCharm(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> repulsion_charm = ITEMS.register("repulsion_charm",
			() -> new ItemRepulsionCharm(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> slime_charm = ITEMS.register("slime_charm",
			() -> new ItemSlimeRepulsionCharm(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> drying_agent = ITEMS.register("drying_agent",
			() -> new ItemDryingAgent(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> soaking_agent = ITEMS.register("soaking_agent",
			() -> new ItemSoakingAgent(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> storming_agent = ITEMS.register("storming_agent",
			() -> new ItemStormingAgent(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	// Armor
	public static final RegistryObject<Item> vibrational_seer = ITEMS.register("vibrational_seer",
			() -> new ItemVibeSeer(EnumModArmorTiers.CIRCLET, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> mysterious_mask = ITEMS.register("mysterious_mask",
			() -> new ItemMysteriousMask(EnumModArmorTiers.MASK, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> influence_supressor = ITEMS.register("influence_supressor",
			() -> new ItemInfluenceSuppressor(EnumModArmorTiers.SUPPRESSOR, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance)));

	public static final RegistryObject<Item> old_iron_helm = ITEMS.register("old_iron_helm",
			() -> new ArmorItem(EnumModArmorTiers.OLDIRON, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));

	public static final RegistryObject<Item> old_iron_chestplate = ITEMS.register("old_iron_chestplate",
			() -> new ArmorItem(EnumModArmorTiers.OLDIRON, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));

	public static final RegistryObject<Item> old_iron_leggings = ITEMS.register("old_iron_leggings",
			() -> new ArmorItem(EnumModArmorTiers.OLDIRON, EquipmentSlotType.LEGS,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));

	public static final RegistryObject<Item> old_iron_boots = ITEMS.register("old_iron_boots",
			() -> new ArmorItem(EnumModArmorTiers.OLDIRON, EquipmentSlotType.FEET,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));

	public static final RegistryObject<Item> null_helmet = ITEMS.register("null_helmet",
			() -> new ArmorItem(EnumModArmorTiers.NULL, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> null_chestplate = ITEMS.register("null_chestplate",
			() -> new ArmorItem(EnumModArmorTiers.NULL, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> null_leggings = ITEMS.register("null_leggings",
			() -> new ArmorItem(EnumModArmorTiers.NULL, EquipmentSlotType.LEGS,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> null_boots = ITEMS.register("null_boots",
			() -> new ArmorItem(EnumModArmorTiers.NULL, EquipmentSlotType.FEET,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));

	public static final RegistryObject<Item> elder_helmet = ITEMS.register("elder_helmet",
			() -> new ArmorItem(EnumModArmorTiers.ELDER, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> elder_chestplate = ITEMS.register("elder_chestplate",
			() -> new ArmorItem(EnumModArmorTiers.ELDER, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> elder_leggings = ITEMS.register("elder_leggings",
			() -> new ArmorItem(EnumModArmorTiers.ELDER, EquipmentSlotType.LEGS,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> elder_boots = ITEMS.register("elder_boots",
			() -> new ArmorItem(EnumModArmorTiers.ELDER, EquipmentSlotType.FEET,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));

	public static final RegistryObject<Item> writhing_helmet = ITEMS.register("writhing_helmet",
			() -> new ItemWrithingHelm(EnumModArmorTiers.WRITHINGHELM, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> writhing_chestplate = ITEMS.register("writhing_chestplate",
			() -> new ItemWrithingChest(EnumModArmorTiers.WRITHINGCHEST, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> writhing_leggings = ITEMS.register("writhing_leggings",
			() -> new ArmorItem(EnumModArmorTiers.WRITHING, EquipmentSlotType.LEGS,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> writhing_boots = ITEMS.register("writhing_boots",
			() -> new ArmorItem(EnumModArmorTiers.WRITHING, EquipmentSlotType.FEET,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));

	// Tools
	public static final RegistryObject<Item> null_bow_blade = ITEMS.register("null_bow_blade",
			() -> new ItemBowBlade(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1).maxDamage(1024), 2,
					8, 1));
	public static final RegistryObject<Item> somnolent_bow_blade = ITEMS.register("somnolent_bow_blade",
			() -> new ItemBowBlade(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1).maxDamage(512), 1, 6,
					1));
	public static final RegistryObject<Item> auric_bow_blade = ITEMS.register("auric_bow_blade",
			() -> new ItemBowBlade(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1).maxDamage(2048), 3,
					10, 1));

	public static final RegistryObject<Item> null_trick_axe = ITEMS.register("null_trick_axe",
			() -> new ItemTrickAxe(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumModToolTiers.NULL));
	public static final RegistryObject<Item> somnolent_trick_axe = ITEMS.register("somnolent_trick_axe",
			() -> new ItemTrickAxe(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumModToolTiers.MYSTIC));
	public static final RegistryObject<Item> auric_trick_axe = ITEMS.register("auric_trick_axe",
			() -> new ItemTrickAxe(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumModToolTiers.AURIC));
	// Old Iron
	public static final RegistryObject<Item> old_iron_sword = ITEMS.register("old_iron_sword",
			() -> new SwordItem(EnumModToolTiers.OLD_IRON, 3, -2.4F,
					new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	// Null
	public static final RegistryObject<Item> null_pickaxe = ITEMS.register("null_pickaxe",
			() -> new PickaxeItem(EnumModToolTiers.NULL, 1, -2.8F,
					new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> null_shovel = ITEMS.register("null_shovel",
			() -> new ShovelItem(EnumModToolTiers.NULL, 1.5F, -3.0F,
					new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> null_hoe = ITEMS.register("null_hoe",
			() -> new HoeItem(EnumModToolTiers.NULL, -3, 0.0F,
					new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> null_axe = ITEMS.register("null_axe",
			() -> new AxeItem(EnumModToolTiers.NULL, 5.0F, -3.0F,
					new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> null_sword = ITEMS.register("null_sword",
			() -> new SwordItem(EnumModToolTiers.NULL, 3, -2.4F,
					new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> duality_pick = ITEMS.register("duality_pick",
			() -> new ToolVeinPickaxe(EnumModToolTiers.NULL, 1, -2.8F,
					new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> duality_axe = ITEMS.register("duality_axe",
			() -> new AxeItem(EnumModToolTiers.NULL, 5.0F, -3.0F,
					new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> absorber_configurer = ITEMS.register("absorber_configurer",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> frequency_matcher = ITEMS.register("frequency_matcher",
			() -> new ItemFrequencyMatcher(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	// Knappers
	public static final RegistryObject<Item> iron_knapper = ITEMS.register("iron_knapper", () -> new ItemKnapper(25f, 1,
			0, ItemTier.IRON, new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> obsidian_knapper = ITEMS.register("obsidian_knapper",
			() -> new ItemKnapper(50f, 1, 0, EnumModToolTiers.NULL,
					new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	// Hands
	public static final RegistryObject<Item> mana_extractor = ITEMS.register("mana_extractor",
			() -> new ItemManaExtractor(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> maker_activator = ITEMS.register("maker_activator",
			() -> new ItemMakerActivator(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> vibration_debug_tool = ITEMS.register("vibration_debug_tool",
			() -> new ItemDebugTool(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> self_analyzer = ITEMS.register("self_analyzer",
			() -> new ItemSelfAnalyzer(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));

	// Wands
	public static final RegistryObject<Item> wand_consume_vibes = ITEMS.register("wand_consume_vibes",
			() -> new ItemWandConsumeVibes(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> wand_gain_vibes = ITEMS.register("wand_gain_vibes",
			() -> new ItemWandGainVibes(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));

	// Upgrades
	public static final RegistryObject<Item> upgrade_wrench = ITEMS.register("upgrade_wrench",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> upgrade_blank = ITEMS.register("upgrade_blank",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> upgrade_block = ITEMS.register("upgrade_block",
			() -> new ItemUpgrade(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> upgrade_player = ITEMS.register("upgrade_player",
			() -> new ItemUpgrade(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> upgrade_animal = ITEMS.register("upgrade_animal",
			() -> new ItemUpgrade(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> upgrade_mob = ITEMS.register("upgrade_mob",
			() -> new ItemUpgrade(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> upgrade_export = ITEMS.register("upgrade_export",
			() -> new ItemUpgrade(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> upgrade_import = ITEMS.register("upgrade_import",
			() -> new ItemUpgrade(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	// Runes

	public static final RegistryObject<Item> self_reflection_mirror = ITEMS.register("self_reflection_mirror",
			() -> new ItemSelfReflectionMirror(new Item.Properties().group(ForcesOfRealityItemGroup.instance)
					.maxStackSize(1).rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<Item> mind_spike = ITEMS.register("mind_spike",
			() -> new ItemRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.SELF, 1));
	public static final RegistryObject<Item> rune_blank = ITEMS.register("rune_blank",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> rune_pattern = ITEMS.register("rune_pattern",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	public static final RegistryObject<Item> rune_binder = ITEMS.register("rune_binder",
			() -> new ItemRuneBinder("rune_binder", 18, Rarity.UNCOMMON));
	public static final RegistryObject<Item> rune_binder_upgraded = ITEMS.register("rune_binder_upgraded",
			() -> new ItemRuneBinder("rune_binder_upgraded", 27, Rarity.RARE));

	// Contract Runes
	public static final RegistryObject<Item> rune_beast_c = ITEMS.register("rune_beast_c",
			() -> new ItemContractRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.BEAST, 5));
	public static final RegistryObject<Item> rune_pattern_beast_c = ITEMS.register("rune_pattern_beast_c",
			() -> new ItemRunePatternBeastContract(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Beast Contract Rune, Unleash your inner beast, destroy your Ego and let the Id become all you are, a primal beast of pure strength."));
	public static final RegistryObject<Item> rune_corruption_c = ITEMS.register("rune_corruption_c",
			() -> new ItemContractRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.SELF, 5));
	public static final RegistryObject<Item> rune_pattern_corruption_c = ITEMS.register("rune_pattern_corruption_c",
			() -> new ItemRunePatternCorruptionContract(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Corruption Contract Rune, Corrupted by those who wished you the worst, your faith has become dark, your dreams have become nightmares!"));
	public static final RegistryObject<Item> rune_impurity_c = ITEMS.register("rune_impurity_c",
			() -> new ItemContractRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.ELDRITCH, 5));
	public static final RegistryObject<Item> rune_pattern_impurity_c = ITEMS.register("rune_pattern_impurity_c",
			() -> new ItemRunePatternImpurityContract(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Impurity Contract Rune, Your blood has become tainted and black, you hunger for all that is immoral and unclean..."));
	public static final RegistryObject<Item> rune_milkweed_c = ITEMS.register("rune_milkweed_c",
			() -> new ItemMilkweedRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.ELDRITCH, 5));
	public static final RegistryObject<Item> rune_pattern_milkweed_c = ITEMS.register("rune_pattern_milkweed_c",
			() -> new ItemRunePatternMilkWeedContract(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Milkweed Contract Rune, Gain contact with the outer beings from beyond all known realms, learn from them, if you dare..."));
	public static final RegistryObject<Item> rune_radiance_c = ITEMS.register("rune_radiance_c",
			() -> new ItemContractRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.ASCENDENT, 5));
	public static final RegistryObject<Item> rune_pattern_radiance_c = ITEMS.register("rune_pattern_radiance_c",
			() -> new ItemRunePatternRadianceContract(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Radiance Contract Rune, Shining symbol of rioutous grace and fury, unleash your inner saint against all the heathens you face!"));
	public static final RegistryObject<Item> rune_hunter_c = ITEMS.register("rune_hunter_c",
			() -> new ItemContractRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.SELF, 5));
	public static final RegistryObject<Item> rune_pattern_hunter_c = ITEMS.register("rune_pattern_hunter_c",
			() -> new ItemRunePatternHunterContract(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Hunter Contract Rune, A trained killer, set in your ways, a true hunter of hunters, weapons are your muse, the battle has become your muse."));

	// Base Runes
	public static final RegistryObject<Item> rune_metamorphosis = ITEMS.register("rune_metamorphosis",
			() -> new ItemRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.SELF, 1));
	public static final RegistryObject<Item> rune_pattern_metamorphosis = ITEMS.register("rune_pattern_metamorphosis",
			() -> new ItemRunePatternMetamorphosis(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Anti Metamorphosis Rune, The crooked metamorphosis has begun, your vitatlity has increased, you feel like you could regrow anything!"));
	public static final RegistryObject<Item> rune_metamorphosis_cw = ITEMS.register("rune_metamorphosis_cw",
			() -> new ItemRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.SELF, 1));

	public static final RegistryObject<Item> rune_pattern_metamorphosis_cw = ITEMS.register(
			"rune_pattern_metamorphosis_cw",
			() -> new ItemRunePatternMetamorphosisCW(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Metamorphois Rune, The proper metamorphosis has begun, your vitality has increased, you feel full of life anew!"));
	public static final RegistryObject<Item> rune_lake = ITEMS.register("rune_lake",
			() -> new ItemRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.SELF, 1));
	public static final RegistryObject<Item> rune_pattern_lake = ITEMS.register("rune_pattern_lake",
			() -> new ItemRunePatternLake(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Lake Rune, The rushing of sacred waters, the roar of a great ocean calls to you, you know your home, and it beckons you back.."));
	public static final RegistryObject<Item> rune_clawmark = ITEMS.register("rune_clawmark",
			() -> new ItemRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.BEAST, 1));
	public static final RegistryObject<Item> rune_pattern_clawmark = ITEMS.register("rune_pattern_clawmark",
			() -> new ItemRunePatternClawmark(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Clawmark Rune, Tooth and Nail is all you know, the endless fight has just begun, bring the armies home, they are no threat."));
	public static final RegistryObject<Item> rune_rapture = ITEMS.register("rune_rapture",
			() -> new ItemRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.SELF, 1));
	public static final RegistryObject<Item> rune_pattern_rapture = ITEMS.register("rune_pattern_rapture",
			() -> new ItemRunePatternRapture(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Rapture Rune, The blood of war is your fuel, the lifeblood of your enemy becomes your own, absorb those who would oppose you!"));
	public static final RegistryObject<Item> rune_oedon = ITEMS.register("rune_oedon",
			() -> new ItemRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.SELF, 1));
	public static final RegistryObject<Item> rune_pattern_oedon = ITEMS.register("rune_pattern_oedon",
			() -> new ItemRunePatternOedon(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Oedon Rune, You feel as if you have a false heart, one granted to you on contract, nevertheless this life is yours now, use it."));
	public static final RegistryObject<Item> rune_eye = ITEMS.register("rune_eye",
			() -> new ItemRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.SELF, 1));
	public static final RegistryObject<Item> rune_pattern_eye = ITEMS.register("rune_pattern_eye",
			() -> new ItemRunePatternEye(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Eye Rune, Your eyes, o' glorious eyes! do not faulter, do not die, for you shall see, beyond the veil, to see what the darkness entails..."));
	public static final RegistryObject<Item> rune_moon = ITEMS.register("rune_moon",
			() -> new ItemRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.SELF, 1));
	public static final RegistryObject<Item> rune_pattern_moon = ITEMS.register("rune_pattern_moon",
			() -> new ItemRunePatternMoon(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Moon Rune, The great moon above has become your muse, it is what drives you, turn away from the cursed sun, carpe noctum!"));
	public static final RegistryObject<Item> rune_beast = ITEMS.register("rune_beast",
			() -> new ItemRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.BEAST, 1));
	public static final RegistryObject<Item> rune_pattern_beast = ITEMS.register("rune_pattern_beast",
			() -> new ItemRunePatternBeast(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Beast Rune, The howl of a gale, the howl of the beast, it is one and all in you, run like the wind, endless and with drive!"));
	public static final RegistryObject<Item> rune_heir = ITEMS.register("rune_heir",
			() -> new ItemRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.SELF, 1));
	public static final RegistryObject<Item> rune_pattern_heir = ITEMS.register("rune_pattern_heir",
			() -> new ItemRunePatternHeir(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Heir Rune, you develop this watchful sense,you, the spiritual succesor to a once great power, shall rekindle their former glory; Divine Heir."));
	public static final RegistryObject<Item> rune_guidance = ITEMS.register("rune_guidance",
			() -> new ItemGuidanceRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumCovenants.SELF, 1));
	public static final RegistryObject<Item> rune_pattern_guidance = ITEMS.register("rune_pattern_guidance",
			() -> new ItemRunePatternGuidance(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Guidance Rune, The supernatural blessing, one of fortune and direction, may it guide you to your wants, as it has so many others before."));
	public static final RegistryObject<Item> rune_communion = ITEMS.register("rune_communion",
			() -> new ItemRune(new Item.Properties().group(ForcesOfRealityItemGroup.instance), EnumCovenants.ASCENDENT,
					1));
	public static final RegistryObject<Item> rune_pattern_communion = ITEMS.register("rune_pattern_communion",
			() -> new ItemRunePatternCommunion(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					"Communion Rune, The call from beyond rings louder for you, you wish to join them, you must join them. join.joi,jo..."));

	// Spawn Eggs
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_dream_walker = ITEMS
			.register("spawn_egg_dream_walker", () -> new ModSpawnEggItem(EntityInit.dream_walker, 0x000000, 0xFFFFFF,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_dream_colin = ITEMS.register("spawn_egg_colin",
			() -> new ModSpawnEggItem(EntityInit.colin, 0x88008B, 0xFF7F00,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_hastur = ITEMS.register("spawn_egg_hastur",
			() -> new ModSpawnEggItem(EntityInit.hastur, 10862336, 0,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_hastur_vassal = ITEMS
			.register("spawn_egg_hastur_vassal", () -> new ModSpawnEggItem(EntityInit.hastur_vassal, 10862336, 0x0000FF,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_tentacle = ITEMS.register("spawn_egg_tentacle",
			() -> new ModSpawnEggItem(EntityInit.tentacle, 22073, 12371968,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_denizen = ITEMS.register("spawn_egg_denizen",
			() -> new ModSpawnEggItem(EntityInit.denizen, 8750204, 12037632,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_denizen_sage = ITEMS
			.register("spawn_egg_denizen_sage", () -> new ModSpawnEggItem(EntityInit.denizen_sage, 8750204, 72037632,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_ibis = ITEMS.register("spawn_egg_ibis",
			() -> new ModSpawnEggItem(EntityInit.ibis, 9175040, 8672512,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_hastur_spawn = ITEMS
			.register("spawn_egg_hastur_spawn", () -> new ModSpawnEggItem(EntityInit.hastur_spawn, 4539136, 13548032,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_slug = ITEMS.register("spawn_egg_slug",
			() -> new ModSpawnEggItem(EntityInit.slug, 7761777, 4206080,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_seraphim = ITEMS.register("spawn_egg_seraphim",
			() -> new ModSpawnEggItem(EntityInit.seraphim, 16515071, 16514816,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_throne = ITEMS.register("spawn_egg_throne",
			() -> new ModSpawnEggItem(EntityInit.throne, 16777215, 12745984,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_beast_from_beyond = ITEMS
			.register("spawn_egg_beast_from_beyond", () -> new ModSpawnEggItem(EntityInit.beast_from_beyond, 9450752, 0,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_summoned_beast = ITEMS
			.register("spawn_egg_summoned_beast", () -> new ModSpawnEggItem(EntityInit.summoned_beast, 8155760, 9450752,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_malformed_automaton = ITEMS.register(
			"spawn_egg_malformed_automaton", () -> new ModSpawnEggItem(EntityInit.malformed_automaton, 15576576, 41873,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_dark_young = ITEMS.register("spawn_egg_dark_young",
			() -> new ModSpawnEggItem(EntityInit.dark_young, 0, 0xFA00FF,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_tulpa = ITEMS.register("spawn_egg_tulpa",
			() -> new ModSpawnEggItem(EntityInit.tulpa, 0, 0,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_scuttling_occulus = ITEMS
			.register("spawn_egg_scuttling_occulus", () -> new ModSpawnEggItem(EntityInit.scuttling_occulus, 12764357,
					5767365, new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_dread_bot = ITEMS.register("spawn_egg_dread_bot",
			() -> new ModSpawnEggItem(EntityInit.dread_bot, 12743680, 12764357,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_mechan = ITEMS.register("spawn_egg_mechan",
			() -> new ModSpawnEggItem(EntityInit.mechan, 12743680, 0,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_veritas = ITEMS.register("spawn_egg_veritas",
			() -> new ModSpawnEggItem(EntityInit.veritas, 0xFFFFFF, 0xFFFFFF,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_black_goat = ITEMS.register("spawn_egg_black_goat",
			() -> new ModSpawnEggItem(EntityInit.black_goat, 0xF23FaF, 0xF23FaF,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_angelic_fowl = ITEMS.register("spawn_egg_angelic_fowl",
			() -> new ModSpawnEggItem(EntityInit.angelic_fowl
					, 0xBDFFE2, 0xFFD25B,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	

	@SubscribeEvent
	public static void registerItemColorHandlers(ColorHandlerEvent.Item event) {
		registerSpawnEggColorHandler(event.getItemColors(), ItemInit.spawn_egg_dream_colin, ItemInit.spawn_egg_hastur,
				ItemInit.spawn_egg_hastur_vassal, ItemInit.spawn_egg_dream_walker, ItemInit.spawn_egg_denizen,
				ItemInit.spawn_egg_denizen_sage, ItemInit.spawn_egg_ibis, ItemInit.spawn_egg_tentacle,
				ItemInit.spawn_egg_hastur_spawn, ItemInit.spawn_egg_slug, ItemInit.spawn_egg_seraphim,
				ItemInit.spawn_egg_throne, ItemInit.spawn_egg_beast_from_beyond, ItemInit.spawn_egg_summoned_beast,
				ItemInit.spawn_egg_malformed_automaton, ItemInit.spawn_egg_dark_young, ItemInit.spawn_egg_tulpa,
				ItemInit.spawn_egg_scuttling_occulus, ItemInit.spawn_egg_dread_bot, ItemInit.spawn_egg_mechan,
				ItemInit.spawn_egg_veritas, ItemInit.spawn_egg_black_goat, ItemInit.spawn_egg_angelic_fowl);
	}

	@SuppressWarnings("unchecked")
	@SafeVarargs
	public static void registerSpawnEggColorHandler(ItemColors colors, RegistryObject<ModSpawnEggItem>... spawnEggs) {
		for (RegistryObject<ModSpawnEggItem> spawnEgg : spawnEggs) {
			registerItemColorHandler(colors, (stack, tintIndex) -> spawnEgg.get().getColor(tintIndex), spawnEgg);
		}
	}

	@SuppressWarnings("unchecked")
	public static void registerItemColorHandler(ItemColors colors, IItemColor itemColor,
			RegistryObject<ModSpawnEggItem>... items) {
		for (RegistryObject<ModSpawnEggItem> itemProvider : items) {
			colors.register(itemColor, itemProvider.get());
		}
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void itemPropOverrideClient(final FMLClientSetupEvent event) {

		ItemModelsProperties.registerProperty(channeling_ingot.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.registerProperty(channeling_ingot.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});

		// Mechan Glove
		ItemModelsProperties.registerProperty(mechan_glove.get(), new ResourceLocation(ForcesOfReality.MOD_ID, "on"),
				new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("swordstate")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});
		ItemModelsProperties.registerProperty(mechan_glove_superior.get(),
				new ResourceLocation(ForcesOfReality.MOD_ID, "on"), new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("swordstate")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});
		ItemModelsProperties.registerProperty(mechan_glove_masterpiece.get(),
				new ResourceLocation(ForcesOfReality.MOD_ID, "on"), new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("swordstate")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});
		ItemModelsProperties.registerProperty(mechan_glove_godlike.get(),
				new ResourceLocation(ForcesOfReality.MOD_ID, "on"), new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("swordstate")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});
		// Imprint
		ItemModelsProperties.registerProperty(harmonic_imprint.get(),
				new ResourceLocation(ForcesOfReality.MOD_ID, "saved"), new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("state")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});

		// EMP Charm
		ItemModelsProperties.registerProperty(emp_charm.get(), new ResourceLocation(ForcesOfReality.MOD_ID, "on"),
				new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("state")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});

		// Attract Charm
		ItemModelsProperties.registerProperty(attraction_charm.get(),
				new ResourceLocation(ForcesOfReality.MOD_ID, "on"), new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("state")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});

		// Slime Charm
		ItemModelsProperties.registerProperty(slime_charm.get(), new ResourceLocation(ForcesOfReality.MOD_ID, "on"),
				new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("state")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});

		// Repulsion Charm
		ItemModelsProperties.registerProperty(repulsion_charm.get(), new ResourceLocation(ForcesOfReality.MOD_ID, "on"),
				new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("state")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});

		// Frequency Matcher
		ItemModelsProperties.registerProperty(frequency_matcher.get(),
				new ResourceLocation(ForcesOfReality.MOD_ID, "clear"), new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("state")) {
								return 0;
							} else {
								return 1;
							}
						}
						return 0;
					}
				});

		// Bow Blades
		// Null
		ItemModelsProperties.registerProperty(null_bow_blade.get(),
				new ResourceLocation(ForcesOfReality.MOD_ID, "open"), new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("state")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});
		ItemModelsProperties.registerProperty(null_bow_blade.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.registerProperty(null_bow_blade.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});

		// Somnolent
		ItemModelsProperties.registerProperty(somnolent_bow_blade.get(),
				new ResourceLocation(ForcesOfReality.MOD_ID, "open"), new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("state")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});
		ItemModelsProperties.registerProperty(somnolent_bow_blade.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.registerProperty(somnolent_bow_blade.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});

		// Auric
		ItemModelsProperties.registerProperty(auric_bow_blade.get(),
				new ResourceLocation(ForcesOfReality.MOD_ID, "open"), new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("state")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});
		ItemModelsProperties.registerProperty(auric_bow_blade.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.registerProperty(auric_bow_blade.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});

		// Trick Axe
		// Null
		ItemModelsProperties.registerProperty(null_trick_axe.get(),
				new ResourceLocation(ForcesOfReality.MOD_ID, "open"), new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("state")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});
		ItemModelsProperties.registerProperty(null_trick_axe.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.registerProperty(null_trick_axe.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});

		// Somnolent
		ItemModelsProperties.registerProperty(somnolent_trick_axe.get(),
				new ResourceLocation(ForcesOfReality.MOD_ID, "open"), new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("state")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});
		ItemModelsProperties.registerProperty(somnolent_trick_axe.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.registerProperty(somnolent_trick_axe.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});

		// Somnolent
		ItemModelsProperties.registerProperty(auric_trick_axe.get(),
				new ResourceLocation(ForcesOfReality.MOD_ID, "open"), new IItemPropertyGetter() {
					@Override
					public float call(ItemStack stack, ClientWorld world, LivingEntity ent) {
						if (stack.hasTag()) {
							if (stack.getTag().getBoolean("state")) {
								return 1;
							} else {
								return 0;
							}
						}
						return 0;
					}
				});
		ItemModelsProperties.registerProperty(auric_trick_axe.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.registerProperty(auric_trick_axe.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});

	}

}
