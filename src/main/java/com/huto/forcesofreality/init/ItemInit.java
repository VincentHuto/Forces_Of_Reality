package com.huto.forcesofreality.init;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.ForcesOfReality.ForcesOfRealityItemGroup;
import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;
import com.huto.forcesofreality.font.ModTextFormatting;
import com.huto.forcesofreality.item.ItemAdvCovenTome;
import com.huto.forcesofreality.item.ItemCovenTome;
import com.huto.forcesofreality.item.ItemDryingAgent;
import com.huto.forcesofreality.item.ItemResonanceDestabalizer;
import com.huto.forcesofreality.item.ItemSacrificial;
import com.huto.forcesofreality.item.ItemSlugBucket;
import com.huto.forcesofreality.item.ItemSoakingAgent;
import com.huto.forcesofreality.item.ItemStormingAgent;
import com.huto.forcesofreality.item.ModSpawnEggItem;
import com.huto.forcesofreality.item.armor.EnumModArmorTiers;
import com.huto.forcesofreality.item.armor.ItemAuricHelm;
import com.huto.forcesofreality.item.armor.ItemBackWings;
import com.huto.forcesofreality.item.armor.ItemClovenHooves;
import com.huto.forcesofreality.item.armor.ItemEmpCharm;
import com.huto.forcesofreality.item.armor.ItemEnticingMantle;
import com.huto.forcesofreality.item.armor.ItemInfluenceSuppressor;
import com.huto.forcesofreality.item.armor.ItemSkullHelmet;
import com.huto.forcesofreality.item.armor.ItemSparkDirector;
import com.huto.forcesofreality.item.armor.ItemWrithingChest;
import com.huto.forcesofreality.item.armor.ItemWrithingHelm;
import com.huto.forcesofreality.item.coven.ItemConcecratedAurum;
import com.huto.forcesofreality.item.coven.ItemNeuroticMechanism;
import com.huto.forcesofreality.item.coven.ItemTwistedFabric;
import com.huto.forcesofreality.item.coven.sign.ItemBeastBreath;
import com.huto.forcesofreality.item.coven.sign.ItemCrossedKeys;
import com.huto.forcesofreality.item.coven.sign.ItemIntegralCog;
import com.huto.forcesofreality.item.coven.sign.ItemWatchfulPendant;
import com.huto.forcesofreality.item.coven.sign.ItemYellowSign;
import com.huto.forcesofreality.item.coven.tool.ItemAllegianceIdentifier;
import com.huto.forcesofreality.item.coven.tool.ItemBeastBolt;
import com.huto.forcesofreality.item.coven.tool.ItemBeastCrossbow;
import com.huto.forcesofreality.item.coven.tool.ItemDemonFlute;
import com.huto.forcesofreality.item.coven.tool.ItemDestabilizationCharm;
import com.huto.forcesofreality.item.coven.tool.ItemDiscordantBell;
import com.huto.forcesofreality.item.coven.tool.ItemDivineFeather;
import com.huto.forcesofreality.item.coven.tool.ItemMachinaCage;
import com.huto.forcesofreality.item.coven.tool.ItemMechanGlove;
import com.huto.forcesofreality.item.coven.tool.ItemStarSlug;
import com.huto.forcesofreality.item.coven.tool.ItemTrickAxe;
import com.huto.forcesofreality.item.coven.tool.ItemVorpalSword;
import com.huto.forcesofreality.item.coven.tool.ItemYellowTome;
import com.huto.forcesofreality.item.tool.EnumModToolTiers;
import com.huto.forcesofreality.item.tool.ItemBowBlade;
import com.huto.forcesofreality.item.tool.ItemDestructOrb;
import com.huto.forcesofreality.item.tool.ItemDestructOrbContained;
import com.huto.forcesofreality.item.tool.coven.module.ItemMechanModuleBase;
import com.huto.forcesofreality.item.tool.coven.module.ItemMechanModuleBlade;
import com.huto.forcesofreality.item.tool.coven.module.ItemMechanModuleLaser;
import com.huto.forcesofreality.item.tool.coven.module.ItemMechanModuleRocket;
import com.huto.forcesofreality.item.tool.coven.module.ItemMechanModuleSalvo;
import com.huto.forcesofreality.item.tool.coven.module.ItemMechanModuleShortCircuit;
import com.huto.forcesofreality.item.tool.coven.module.ItemMechanModuleThruster;
import com.huto.forcesofreality.item.tool.coven.module.ItemWickedModuleLaser;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
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
	public static final DeferredRegister<Item> ADVITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ForcesOfReality.MOD_ID);
	public static final DeferredRegister<Item> MODELEDITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ForcesOfReality.MOD_ID);
	public static final DeferredRegister<Item> HANDHELDITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ForcesOfReality.MOD_ID);
	public static final DeferredRegister<Item> SPAWNEGGS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ForcesOfReality.MOD_ID);

	public static final RegistryObject<Item> allegiance_identifier = ITEMS.register("allegiance_identifier",
			() -> new ItemAllegianceIdentifier(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));

	// Books

	public static final RegistryObject<Item> coven_tome = ITEMS.register("coven_tome",
			() -> new ItemCovenTome(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> coven_tome_adv = ITEMS.register("coven_tome_adv",
			() -> new ItemAdvCovenTome(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));

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
					EnumCovenants.ASCENDANT, 10));
	public static final RegistryObject<Item> seraph_feather = ITEMS.register("seraph_feather",
			() -> new ItemSacrificial(new Item.Properties().group(ForcesOfRealityItemGroup.instance),
					EnumCovenants.ASCENDANT, 1));
	public static final RegistryObject<Item> wing_fragment = ITEMS.register("wing_fragment",
			() -> new ItemSacrificial(new Item.Properties().group(ForcesOfRealityItemGroup.instance),
					EnumCovenants.ASCENDANT, 3));
	public static final RegistryObject<Item> anointed_iron_scrap = ITEMS.register("anointed_iron_scrap",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> star_slug = ITEMS.register("star_slug", () -> new ItemStarSlug(
			new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> discordant_bell = MODELEDITEMS.register("discordant_bell",
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
	public static final RegistryObject<Item> demon_flute = MODELEDITEMS.register("demon_flute",
			() -> new ItemDemonFlute(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)
					.rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> destabilization_charm = ADVITEMS.register("destabilization_charm",
			() -> new ItemDestabilizationCharm(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
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
	public static final RegistryObject<Item> unkept_hide = ITEMS.register("unkept_hide",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
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
	public static final RegistryObject<Item> first_beast_crossbow = ITEMS.register("first_beast_crossbow",
			() -> new ItemBeastCrossbow(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> first_beast_bolt = ITEMS.register("first_beast_bolt",
			() -> new ItemBeastBolt(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	// Machine
	public static final RegistryObject<Item> integral_cog = ITEMS.register("integral_cog",
			() -> new ItemIntegralCog(new Item.Properties().group(ForcesOfRealityItemGroup.instance)
					.rarity(ModTextFormatting.AURIC).maxStackSize(1), EnumCovenants.MACHINE, 10));
	public static final RegistryObject<Item> discared_gear = ITEMS.register("discared_gear",
			() -> new ItemSacrificial(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC),
					EnumCovenants.MACHINE, 1));
	public static final RegistryObject<Item> malfunctioning_mechanism = ITEMS.register("malfunctioning_mechanism",
			() -> new ItemSacrificial(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC),
					EnumCovenants.MACHINE, 3));
	public static final RegistryObject<Item> auric_ingot = ITEMS.register("auric_ingot", () -> new Item(
			new Item.Properties().group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC)));
	public static final RegistryObject<Item> machina_soul = ITEMS.register("machina_soul",
			() -> new Item(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> machina_cage = ITEMS.register("machina_cage",
			() -> new ItemMachinaCage(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> emp_charm = ADVITEMS.register("emp_charm",
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
	public static final RegistryObject<Item> machina_spark_director = MODELEDITEMS.register("machina_spark_director",
			() -> new ItemSparkDirector(EnumModArmorTiers.SPARKDIRECTOR, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC),
					false));
	public static final RegistryObject<Item> machina_spark_director_armored = MODELEDITEMS.register(
			"machina_spark_director_armored",
			() -> new ItemSparkDirector(EnumModArmorTiers.SPARKDIRECTOR_ARMORED, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC),
					true));

	// Gloves
	public static final RegistryObject<Item> mechan_glove = MODELEDITEMS.register("mechan_glove",
			() -> new ItemMechanGlove(new Item.Properties().rarity(Rarity.UNCOMMON).maxStackSize(1)
					.group(ForcesOfRealityItemGroup.instance).maxDamage(512), "mechan_glove", 3, 5, 1));
	public static final RegistryObject<Item> mechan_glove_superior = MODELEDITEMS
			.register("mechan_glove_superior",
					() -> new ItemMechanGlove(
							new Item.Properties().rarity(Rarity.RARE).maxStackSize(1)
									.group(ForcesOfRealityItemGroup.instance).maxDamage(1024),
							"mechan_glove_superior", 6, 10, 2));
	public static final RegistryObject<Item> mechan_glove_masterpiece = MODELEDITEMS
			.register("mechan_glove_masterpiece",
					() -> new ItemMechanGlove(
							new Item.Properties().rarity(Rarity.EPIC).maxStackSize(1)
									.group(ForcesOfRealityItemGroup.instance).maxDamage(2048),
							"mechan_glove_masterpiece", 9, 15, 3));
	public static final RegistryObject<Item> mechan_glove_godlike = MODELEDITEMS.register("mechan_glove_godlike",
			() -> new ItemMechanGlove(
					new Item.Properties().rarity(ModTextFormatting.AURIC).maxStackSize(1)
							.group(ForcesOfRealityItemGroup.instance).maxDamage(4096),
					"mechan_glove_godlike", 9, 35, 4));

	// Modules
	public static final RegistryObject<Item> mechan_module = ITEMS
			.register("mechan_module",
					() -> new ItemMechanModuleBase(
							new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1), 0,
							"Base Module"));
	public static final RegistryObject<Item> mechan_module_rocket = ITEMS.register("mechan_module_rocket",
			() -> new ItemMechanModuleRocket(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1), 1,
					"Fires a singluar exploding rocket at an angle"));
	public static final RegistryObject<Item> mechan_module_salvo = ITEMS.register("mechan_module_salvo",
			() -> new ItemMechanModuleSalvo(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1), 2,
					"Fire Several homing rockets that track down targets around player"));
	public static final RegistryObject<Item> mechan_module_shortcircuit = ITEMS.register("mechan_module_shortcircuit",
			() -> new ItemMechanModuleShortCircuit(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1), 3,
					"Fires a ball of electricity that leaps between targets"));
	public static final RegistryObject<Item> mechan_module_laser = ITEMS.register("mechan_module_laser",
			() -> new ItemMechanModuleLaser(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1), 2,
					"Fires a concetrated burst of energy from the glove"));
	public static final RegistryObject<Item> mechan_module_blade = ITEMS.register("mechan_module_blade",
			() -> new ItemMechanModuleBlade(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1), 1,
					"Extrudes a small blade from the glove increasing damage dealt"));
	public static final RegistryObject<Item> mechan_module_thruster = ITEMS.register("mechan_module_thruster",
			() -> new ItemMechanModuleThruster(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1), 3,
					"Increases the power of an equiped Machina Spark Director, Allows for boosting"));

	// InterCoven Items
	// Hastur + Machine
	public static final RegistryObject<Item> neurotic_mechanism = ITEMS.register("neurotic_mechanism",
			() -> new ItemNeuroticMechanism(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).rarity(ModTextFormatting.AURIC)));
	/*
	 * public static final RegistryObject<Item> null_bow_blade =
	 * ADVITEMS.register("null_bow_blade", () -> new ItemBowBlade( new
	 * Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1).
	 * maxDamage(1024), 2, 8, 1)); public static final RegistryObject<Item>
	 * somnolent_bow_blade = ADVITEMS.register("somnolent_bow_blade", () -> new
	 * ItemBowBlade( new
	 * Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1).
	 * maxDamage(512), 1, 6, 1));
	 */
	public static final RegistryObject<Item> auric_bow_blade = ADVITEMS.register("auric_bow_blade",
			() -> new ItemBowBlade(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1).maxDamage(2048), 3,
					10, 1));
	/*
	 * public static final RegistryObject<Item> null_trick_axe =
	 * ADVITEMS.register("null_trick_axe", () -> new ItemTrickAxe(new
	 * Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
	 * EnumModToolTiers.NULL)); public static final RegistryObject<Item>
	 * somnolent_trick_axe = ADVITEMS.register("somnolent_trick_axe", () -> new
	 * ItemTrickAxe(new
	 * Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
	 * EnumModToolTiers.MYSTIC));
	 */
	public static final RegistryObject<Item> auric_trick_axe = ADVITEMS.register("auric_trick_axe",
			() -> new ItemTrickAxe(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1),
					EnumModToolTiers.AURIC));
	// Ascendant + Machine
	public static final RegistryObject<Item> concecrated_aurum = ITEMS.register("concecrated_aurum",
			() -> new ItemConcecratedAurum(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> vorpal_blade = ITEMS.register("vorpal_blade",
			() -> new ItemVorpalSword(EnumModToolTiers.OLD_IRON, 3, -2.4F,
					new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	// Eldritch + Machine
	public static final RegistryObject<Item> wicked_module_laser = ITEMS.register("wicked_module_laser",
			() -> new ItemWickedModuleLaser(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1).rarity(Rarity.EPIC),
					4, "A Funtional Anomaly, Fires a blast of Eldritch beam"));
	// Eldritch+Hastur
	public static final RegistryObject<Item> twisted_fabric = ITEMS.register("twisted_fabric",
			() -> new ItemTwistedFabric(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	// Eldritch+Beast+Hastur
	public static final RegistryObject<Item> destruction_orb = ITEMS.register("destruction_orb",
			() -> new ItemDestructOrb(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));
	// Ascendant+Machine+Self
	public static final RegistryObject<Item> destruction_orb_contained = ITEMS.register("destruction_orb_contained",
			() -> new ItemDestructOrbContained(
					new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> bucket_slug = ITEMS.register("bucket_slug",
			() -> new ItemSlugBucket(new Item.Properties().group(ForcesOfRealityItemGroup.instance).maxStackSize(1)));

	// Charms
	public static final RegistryObject<Item> drying_agent = ITEMS.register("drying_agent",
			() -> new ItemDryingAgent(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> soaking_agent = ITEMS.register("soaking_agent",
			() -> new ItemSoakingAgent(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<Item> storming_agent = ITEMS.register("storming_agent",
			() -> new ItemStormingAgent(new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	// Armor
	public static final RegistryObject<Item> influence_supressor = ITEMS.register("influence_supressor",
			() -> new ItemInfluenceSuppressor(EnumModArmorTiers.SUPPRESSOR, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance)));

	public static final RegistryObject<Item> anointed_iron_helm = ITEMS.register("anointed_iron_helm",
			() -> new ArmorItem(EnumModArmorTiers.ANOINTED, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));

	public static final RegistryObject<Item> anointed_iron_chestplate = ITEMS.register("anointed_iron_chestplate",
			() -> new ArmorItem(EnumModArmorTiers.ANOINTED, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));

	public static final RegistryObject<Item> anointed_iron_leggings = ITEMS.register("anointed_iron_leggings",
			() -> new ArmorItem(EnumModArmorTiers.ANOINTED, EquipmentSlotType.LEGS,
					(new Item.Properties()).group(ForcesOfRealityItemGroup.instance).isImmuneToFire()));

	public static final RegistryObject<Item> anointed_iron_boots = ITEMS.register("anointed_iron_boots",
			() -> new ArmorItem(EnumModArmorTiers.ANOINTED, EquipmentSlotType.FEET,
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
	// Anointed Iron
	public static final RegistryObject<Item> anointed_iron_sword = HANDHELDITEMS.register("anointed_iron_sword",
			() -> new SwordItem(EnumModToolTiers.OLD_IRON, 3, -2.4F,
					new Item.Properties().group(ForcesOfRealityItemGroup.instance)));

	// Spawn Eggs
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_hastur = SPAWNEGGS.register("spawn_egg_hastur",
			() -> new ModSpawnEggItem(EntityInit.hastur, 10862336, 0,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_hastur_vassal = SPAWNEGGS
			.register("spawn_egg_hastur_vassal", () -> new ModSpawnEggItem(EntityInit.hastur_vassal, 10862336, 0x0000FF,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_tentacle = SPAWNEGGS.register("spawn_egg_tentacle",
			() -> new ModSpawnEggItem(EntityInit.tentacle, 22073, 12371968,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_denizen = SPAWNEGGS.register("spawn_egg_denizen",
			() -> new ModSpawnEggItem(EntityInit.denizen, 8750204, 12037632,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_denizen_sage = SPAWNEGGS
			.register("spawn_egg_denizen_sage", () -> new ModSpawnEggItem(EntityInit.denizen_sage, 8750204, 72037632,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_hastur_spawn = SPAWNEGGS
			.register("spawn_egg_hastur_spawn", () -> new ModSpawnEggItem(EntityInit.hastur_spawn, 4539136, 13548032,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_slug = SPAWNEGGS.register("spawn_egg_slug",
			() -> new ModSpawnEggItem(EntityInit.slug, 7761777, 4206080,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_seraphim = SPAWNEGGS.register("spawn_egg_seraphim",
			() -> new ModSpawnEggItem(EntityInit.seraphim, 16515071, 16514816,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_tetra = SPAWNEGGS.register("spawn_egg_tetra",
			() -> new ModSpawnEggItem(EntityInit.tetra, 14565021, 16464878,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_throne = SPAWNEGGS.register("spawn_egg_throne",
			() -> new ModSpawnEggItem(EntityInit.throne, 16777215, 12745984,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_beast_from_beyond = SPAWNEGGS
			.register("spawn_egg_beast_from_beyond", () -> new ModSpawnEggItem(EntityInit.beast_from_beyond, 9450752, 0,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_lord_of_the_wild = SPAWNEGGS
			.register("spawn_egg_lord_of_the_wild", () -> new ModSpawnEggItem(EntityInit.lord_of_the_wild, 9450752,
					7450752, new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_summoned_beast = SPAWNEGGS
			.register("spawn_egg_summoned_beast", () -> new ModSpawnEggItem(EntityInit.summoned_beast, 8155760, 9450752,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_malformed_automaton = SPAWNEGGS.register(
			"spawn_egg_malformed_automaton", () -> new ModSpawnEggItem(EntityInit.malformed_automaton, 15576576, 41873,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_dark_young = SPAWNEGGS
			.register("spawn_egg_dark_young", () -> new ModSpawnEggItem(EntityInit.dark_young, 0, 0xFA00FF,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_tulpa = SPAWNEGGS.register("spawn_egg_tulpa",
			() -> new ModSpawnEggItem(EntityInit.tulpa, 0, 0,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_scuttling_occulus = SPAWNEGGS
			.register("spawn_egg_scuttling_occulus", () -> new ModSpawnEggItem(EntityInit.scuttling_occulus, 12764357,
					5767365, new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_dread_bot = SPAWNEGGS.register("spawn_egg_dread_bot",
			() -> new ModSpawnEggItem(EntityInit.dread_bot, 12743680, 12764357,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_mechan = SPAWNEGGS.register("spawn_egg_mechan",
			() -> new ModSpawnEggItem(EntityInit.mechan, 12743680, 0,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_veritas = SPAWNEGGS.register("spawn_egg_veritas",
			() -> new ModSpawnEggItem(EntityInit.veritas, 0xFFFFFF, 0xFFFFFF,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_black_goat = SPAWNEGGS
			.register("spawn_egg_black_goat", () -> new ModSpawnEggItem(EntityInit.black_goat, 0xF23FaF, 0xF23FaF,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_angelic_fowl = SPAWNEGGS
			.register("spawn_egg_angelic_fowl", () -> new ModSpawnEggItem(EntityInit.angelic_fowl, 0xBDFFE2, 0xFFD25B,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_deranged_beast = SPAWNEGGS
			.register("spawn_egg_deranged_beast", () -> new ModSpawnEggItem(EntityInit.deranged_beast, 4603962, 5252864,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_uzouthrhix = SPAWNEGGS
			.register("spawn_egg_uzouthrhix", () -> new ModSpawnEggItem(EntityInit.uzouthrhix, 23862, 8133430,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_xanthous_king = SPAWNEGGS
			.register("spawn_egg_xanthous_king", () -> new ModSpawnEggItem(EntityInit.xanthous_king, 10862336, 852039,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_devotee = SPAWNEGGS.register("spawn_egg_devotee",
			() -> new ModSpawnEggItem(EntityInit.devotee, 4341573, 9604677,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));

	public static final RegistryObject<ModSpawnEggItem> spawn_egg_first_beast = SPAWNEGGS
			.register("spawn_egg_first_beast", () -> new ModSpawnEggItem(EntityInit.the_first_beast, 6499072, 11777460,
					new Item.Properties().group(ItemGroup.MISC).group(ForcesOfRealityItemGroup.instance)));

	@SubscribeEvent
	public static void registerItemColorHandlers(ColorHandlerEvent.Item event) {
		registerSpawnEggColorHandler(event.getItemColors(), ItemInit.spawn_egg_hastur, ItemInit.spawn_egg_hastur_vassal,
				ItemInit.spawn_egg_denizen, ItemInit.spawn_egg_denizen_sage, ItemInit.spawn_egg_tentacle,
				ItemInit.spawn_egg_hastur_spawn, ItemInit.spawn_egg_slug, ItemInit.spawn_egg_seraphim,
				ItemInit.spawn_egg_throne, ItemInit.spawn_egg_beast_from_beyond, ItemInit.spawn_egg_summoned_beast,
				ItemInit.spawn_egg_malformed_automaton, ItemInit.spawn_egg_dark_young, ItemInit.spawn_egg_tulpa,
				ItemInit.spawn_egg_scuttling_occulus, ItemInit.spawn_egg_dread_bot, ItemInit.spawn_egg_mechan,
				ItemInit.spawn_egg_veritas, ItemInit.spawn_egg_black_goat, ItemInit.spawn_egg_angelic_fowl,
				ItemInit.spawn_egg_deranged_beast, ItemInit.spawn_egg_tetra, ItemInit.spawn_egg_lord_of_the_wild,
				ItemInit.spawn_egg_uzouthrhix, ItemInit.spawn_egg_xanthous_king, ItemInit.spawn_egg_devotee,
				ItemInit.spawn_egg_first_beast);
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

		ItemModelsProperties.registerProperty(ItemInit.first_beast_crossbow.get(), new ResourceLocation("pull"),
				(p_239427_0_, p_239427_1_, p_239427_2_) -> {
					if (p_239427_2_ == null) {
						return 0.0F;
					} else {
						return ItemBeastCrossbow.isCharged(p_239427_0_) ? 0.0F
								: (float) (p_239427_0_.getUseDuration() - p_239427_2_.getItemInUseCount())
										/ (float) ItemBeastCrossbow.getChargeTime(p_239427_0_);
					}
				});
		ItemModelsProperties.registerProperty(ItemInit.first_beast_crossbow.get(), new ResourceLocation("pulling"),
				(p_239426_0_, p_239426_1_, p_239426_2_) -> {
					return p_239426_2_ != null && p_239426_2_.isHandActive()
							&& p_239426_2_.getActiveItemStack() == p_239426_0_
							&& !ItemBeastCrossbow.isCharged(p_239426_0_) ? 1.0F : 0.0F;
				});
		ItemModelsProperties.registerProperty(ItemInit.first_beast_crossbow.get(), new ResourceLocation("charged"),
				(p_239425_0_, p_239425_1_, p_239425_2_) -> {
					return p_239425_2_ != null && ItemBeastCrossbow.isCharged(p_239425_0_) ? 1.0F : 0.0F;
				});
		ItemModelsProperties.registerProperty(ItemInit.first_beast_crossbow.get(), new ResourceLocation("firework"),
				(p_239424_0_, p_239424_1_, p_239424_2_) -> {
					return p_239424_2_ != null && ItemBeastCrossbow.isCharged(p_239424_0_)
							&& ItemBeastCrossbow.hasChargedProjectile(p_239424_0_, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
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

		// Bow Blades
		/*
		 * // Null ItemModelsProperties.registerProperty(null_bow_blade.get(), new
		 * ResourceLocation(ForcesOfReality.MOD_ID, "open"), new IItemPropertyGetter() {
		 * 
		 * @Override public float call(ItemStack stack, ClientWorld world, LivingEntity
		 * ent) { if (stack.hasTag()) { if (stack.getTag().getBoolean("state")) { return
		 * 1; } else { return 0; } } return 0; } });
		 * ItemModelsProperties.registerProperty(null_bow_blade.get(), new
		 * ResourceLocation("pull"), (p_239429_0_, p_239429_1_, p_239429_2_) -> { if
		 * (p_239429_2_ == null) { return 0.0F; } else { return
		 * p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F : (float)
		 * (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F; }
		 * }); ItemModelsProperties.registerProperty(null_bow_blade.get(), new
		 * ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) -> {
		 * return p_239428_2_ != null && p_239428_2_.isHandActive() &&
		 * p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F; });
		 * 
		 * // Somnolent ItemModelsProperties.registerProperty(somnolent_bow_blade.get(),
		 * new ResourceLocation(ForcesOfReality.MOD_ID, "open"), new
		 * IItemPropertyGetter() {
		 * 
		 * @Override public float call(ItemStack stack, ClientWorld world, LivingEntity
		 * ent) { if (stack.hasTag()) { if (stack.getTag().getBoolean("state")) { return
		 * 1; } else { return 0; } } return 0; } });
		 * ItemModelsProperties.registerProperty(somnolent_bow_blade.get(), new
		 * ResourceLocation("pull"), (p_239429_0_, p_239429_1_, p_239429_2_) -> { if
		 * (p_239429_2_ == null) { return 0.0F; } else { return
		 * p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F : (float)
		 * (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F; }
		 * }); ItemModelsProperties.registerProperty(somnolent_bow_blade.get(), new
		 * ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) -> {
		 * return p_239428_2_ != null && p_239428_2_.isHandActive() &&
		 * p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F; });
		 */

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
		/*
		 * // Null ItemModelsProperties.registerProperty(null_trick_axe.get(), new
		 * ResourceLocation(ForcesOfReality.MOD_ID, "open"), new IItemPropertyGetter() {
		 * 
		 * @Override public float call(ItemStack stack, ClientWorld world, LivingEntity
		 * ent) { if (stack.hasTag()) { if (stack.getTag().getBoolean("state")) { return
		 * 1; } else { return 0; } } return 0; } });
		 * ItemModelsProperties.registerProperty(null_trick_axe.get(), new
		 * ResourceLocation("pull"), (p_239429_0_, p_239429_1_, p_239429_2_) -> { if
		 * (p_239429_2_ == null) { return 0.0F; } else { return
		 * p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F : (float)
		 * (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F; }
		 * }); ItemModelsProperties.registerProperty(null_trick_axe.get(), new
		 * ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) -> {
		 * return p_239428_2_ != null && p_239428_2_.isHandActive() &&
		 * p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F; });
		 * 
		 * // Somnolent ItemModelsProperties.registerProperty(somnolent_trick_axe.get(),
		 * new ResourceLocation(ForcesOfReality.MOD_ID, "open"), new
		 * IItemPropertyGetter() {
		 * 
		 * @Override public float call(ItemStack stack, ClientWorld world, LivingEntity
		 * ent) { if (stack.hasTag()) { if (stack.getTag().getBoolean("state")) { return
		 * 1; } else { return 0; } } return 0; } });
		 * ItemModelsProperties.registerProperty(somnolent_trick_axe.get(), new
		 * ResourceLocation("pull"), (p_239429_0_, p_239429_1_, p_239429_2_) -> { if
		 * (p_239429_2_ == null) { return 0.0F; } else { return
		 * p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F : (float)
		 * (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F; }
		 * }); ItemModelsProperties.registerProperty(somnolent_trick_axe.get(), new
		 * ResourceLocation("pulling"), (p_239428_0_, p_239428_1_, p_239428_2_) -> {
		 * return p_239428_2_ != null && p_239428_2_.isHandActive() &&
		 * p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F; });
		 */

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
