package com.vincenthuto.forcesofreality.init;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;
import com.vincenthuto.forcesofreality.item.ItemCovenTome;
import com.vincenthuto.forcesofreality.item.ItemDryingAgent;
import com.vincenthuto.forcesofreality.item.ItemSacrificial;
import com.vincenthuto.forcesofreality.item.ItemSlugBucket;
import com.vincenthuto.forcesofreality.item.ItemSoakingAgent;
import com.vincenthuto.forcesofreality.item.ItemStormingAgent;
import com.vincenthuto.forcesofreality.item.armor.EnumModArmorTiers;
import com.vincenthuto.forcesofreality.item.armor.ItemAuricArmor;
import com.vincenthuto.forcesofreality.item.armor.ItemBackWings;
import com.vincenthuto.forcesofreality.item.armor.ItemBeastlyArmor;
import com.vincenthuto.forcesofreality.item.armor.ItemEmpCharm;
import com.vincenthuto.forcesofreality.item.armor.ItemInfluenceSuppressor;
import com.vincenthuto.forcesofreality.item.armor.ItemSparkDirector;
import com.vincenthuto.forcesofreality.item.armor.ItemWrithingArmor;
import com.vincenthuto.forcesofreality.item.coven.ItemConcecratedAurum;
import com.vincenthuto.forcesofreality.item.coven.ItemNeuroticMechanism;
import com.vincenthuto.forcesofreality.item.coven.ItemTwistedFabric;
import com.vincenthuto.forcesofreality.item.coven.sign.ItemBeastBreath;
import com.vincenthuto.forcesofreality.item.coven.sign.ItemCrossedKeys;
import com.vincenthuto.forcesofreality.item.coven.sign.ItemIntegralCog;
import com.vincenthuto.forcesofreality.item.coven.sign.ItemWatchfulPendant;
import com.vincenthuto.forcesofreality.item.coven.sign.ItemYellowSign;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemAllegianceIdentifier;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemBeastBolt;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemBeastCrossbow;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemDemonFlute;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemDestabilizationCharm;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemDiscordantBell;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemDivineFeather;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemMachinaCage;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemMechanGlove;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemStarSlug;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemTrickAxe;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemVorpalSword;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemYellowTome;
import com.vincenthuto.forcesofreality.item.tool.EnumModToolTiers;
import com.vincenthuto.forcesofreality.item.tool.ItemBowBlade;
import com.vincenthuto.forcesofreality.item.tool.ItemDestructOrb;
import com.vincenthuto.forcesofreality.item.tool.ItemDestructOrbContained;
import com.vincenthuto.forcesofreality.item.tool.coven.module.ItemMechanModuleBase;
import com.vincenthuto.forcesofreality.item.tool.coven.module.ItemMechanModuleBlade;
import com.vincenthuto.forcesofreality.item.tool.coven.module.ItemMechanModuleLaser;
import com.vincenthuto.forcesofreality.item.tool.coven.module.ItemMechanModuleRocket;
import com.vincenthuto.forcesofreality.item.tool.coven.module.ItemMechanModuleSalvo;
import com.vincenthuto.forcesofreality.item.tool.coven.module.ItemMechanModuleShortCircuit;
import com.vincenthuto.forcesofreality.item.tool.coven.module.ItemMechanModuleThruster;
import com.vincenthuto.forcesofreality.item.tool.coven.module.ItemWickedModuleLaser;
import com.vincenthuto.hutoslib.client.HLTextUtils;
import com.vincenthuto.hutoslib.common.item.ModSpawnEggItem;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

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
					new Item.Properties().stacksTo(1)));

	// Books
	public static ResourceLocation guide = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/somnolent_tome.png");
	public static ResourceLocation elder = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/elder_tome.png");
	public static ResourceLocation coven = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/coven_tome.png");
	public static ResourceLocation covenadv = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/adv_coven_tome.png");

	public static final RegistryObject<Item> coven_tome = ITEMS.register("coven_tome",
			() -> new ItemCovenTome(new Item.Properties().stacksTo(1), guide));

//	public static final RegistryObject<Item> coven_tome = ITEMS.register("coven_tome",
//			() -> new ItemCovenTome(new Item.Properties().stacksTo(1)));
//	public static final RegistryObject<Item> coven_tome_adv = ITEMS.register("coven_tome_adv",
//			() -> new ItemAdvCovenTome(new Item.Properties().stacksTo(1)));

	// Hastur

	public static final RegistryObject<Item> yellow_sign = ITEMS.register("yellow_sign",
			() -> new ItemYellowSign(
					new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON),
					EnumCovenants.HASTUR, 10));
	public static final RegistryObject<Item> unsettling_fabric = ITEMS.register("unsettling_fabric",
			() -> new ItemSacrificial(new Item.Properties(),
					EnumCovenants.HASTUR, 1));
	public static final RegistryObject<Item> unsettling_tapestry = ITEMS.register("unsettling_tapestry",
			() -> new ItemSacrificial(new Item.Properties(),
					EnumCovenants.HASTUR, 3));
	public static final RegistryObject<Item> yellow_tome = ITEMS.register("yellow_tome", () -> new ItemYellowTome(
			new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));

	// Seraph
	public static final RegistryObject<Item> crossed_keys = ITEMS.register("crossed_keys",
			() -> new ItemCrossedKeys(new Item.Properties().stacksTo(1),
					EnumCovenants.ASCENDANT, 10));
	public static final RegistryObject<Item> seraph_feather = ITEMS.register("seraph_feather",
			() -> new ItemSacrificial(new Item.Properties(),
					EnumCovenants.ASCENDANT, 1));
	public static final RegistryObject<Item> wing_fragment = ITEMS.register("wing_fragment",
			() -> new ItemSacrificial(new Item.Properties(),
					EnumCovenants.ASCENDANT, 3));
	public static final RegistryObject<Item> anointed_iron_scrap = ITEMS.register("anointed_iron_scrap",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> star_slug = ITEMS.register("star_slug", () -> new ItemStarSlug(
			new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> discordant_bell = MODELEDITEMS.register("discordant_bell",
			() -> new ItemDiscordantBell(
					new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> divine_feather = ITEMS.register("divine_feather",
			() -> new ItemDivineFeather(
					new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> seraph_wings = ITEMS.register("seraph_wings",
			() -> new ItemBackWings(EnumModArmorTiers.ANOINTED, ArmorItem.Type.CHESTPLATE,
					(new Item.Properties())));

	// Eldritch
	public static final RegistryObject<Item> everwatchful_pendant = ITEMS.register("everwatchful_pendant",
			() -> new ItemWatchfulPendant(new Item.Properties().stacksTo(1),
					EnumCovenants.ELDRITCH, 10));
	public static final RegistryObject<Item> suspicious_eye = ITEMS.register("suspicious_eye",
			() -> new ItemSacrificial(new Item.Properties(),
					EnumCovenants.ELDRITCH, 1));
	public static final RegistryObject<Item> ball_of_eyes = ITEMS.register("ball_of_eyes",
			() -> new ItemSacrificial(new Item.Properties(),
					EnumCovenants.ELDRITCH, 3));
	public static final RegistryObject<Item> occular_seed = ITEMS.register("occular_seed",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> vitreous_humor = ITEMS.register("vitreous_humor",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> writhing_thread = ITEMS.register("writhing_thread",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> demon_flute = MODELEDITEMS.register("demon_flute",
			() -> new ItemDemonFlute(
					new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> destabilization_charm = ADVITEMS.register("destabilization_charm",
			() -> new ItemDestabilizationCharm(
					new Item.Properties().stacksTo(1)));
	// Beast
	public static final RegistryObject<Item> breath_of_the_beast = ITEMS.register("breath_of_the_beast",
			() -> new ItemBeastBreath(new Item.Properties().stacksTo(1),
					EnumCovenants.BEAST, 10));
	public static final RegistryObject<Item> blooddrawn_fang = ITEMS.register("blooddrawn_fang",
			() -> new ItemSacrificial(new Item.Properties(), EnumCovenants.BEAST,
					1));
	public static final RegistryObject<Item> beastly_bone = ITEMS.register("beastly_bone",
			() -> new ItemSacrificial(new Item.Properties(), EnumCovenants.BEAST,
					3));
	public static final RegistryObject<Item> unkept_hide = ITEMS.register("unkept_hide",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> skull_helmet = ITEMS.register("skull_helmet",
			() -> new ItemBeastlyArmor(EnumModArmorTiers.BEASTLY, ArmorItem.Type.HELMET));
	public static final RegistryObject<Item> enticing_mantle = ITEMS.register("enticing_mantle",
			() -> new ItemBeastlyArmor(EnumModArmorTiers.BEASTLY, ArmorItem.Type.CHESTPLATE));
	public static final RegistryObject<Item> legs_of_fawn = ITEMS.register("legs_of_fawn",
			() -> new ArmorItem(EnumModArmorTiers.BEASTLY, ArmorItem.Type.LEGGINGS,
					new Item.Properties().fireResistant()));
	public static final RegistryObject<Item> cloven_hooves = ITEMS.register("cloven_hooves",
			() -> new ItemBeastlyArmor(EnumModArmorTiers.BEASTLY, ArmorItem.Type.BOOTS));
	public static final RegistryObject<Item> first_beast_crossbow = ITEMS.register("first_beast_crossbow",
			() -> new ItemBeastCrossbow(new Item.Properties()));
	public static final RegistryObject<Item> first_beast_bolt = ITEMS.register("first_beast_bolt",
			() -> new ItemBeastBolt(new Item.Properties()));

	// Machine
	public static final RegistryObject<Item> integral_cog = ITEMS.register("integral_cog",
			() -> new ItemIntegralCog(
					new Item.Properties().rarity(HLTextUtils.AURIC).stacksTo(1),
					EnumCovenants.MACHINE, 10));
	public static final RegistryObject<Item> discared_gear = ITEMS.register("discared_gear",
			() -> new ItemSacrificial(
					new Item.Properties().rarity(HLTextUtils.AURIC),
					EnumCovenants.MACHINE, 1));
	public static final RegistryObject<Item> malfunctioning_mechanism = ITEMS.register("malfunctioning_mechanism",
			() -> new ItemSacrificial(
					new Item.Properties().rarity(HLTextUtils.AURIC),
					EnumCovenants.MACHINE, 3));
	public static final RegistryObject<Item> auric_ingot = ITEMS.register("auric_ingot",
			() -> new Item(new Item.Properties().rarity(HLTextUtils.AURIC)));
	public static final RegistryObject<Item> machina_soul = ITEMS.register("machina_soul",
			() -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> machina_cage = ITEMS.register("machina_cage",
			() -> new ItemMachinaCage(new Item.Properties()));
	public static final RegistryObject<Item> emp_charm = ADVITEMS.register("emp_charm", () -> new ItemEmpCharm(
			new Item.Properties().stacksTo(1).rarity(HLTextUtils.AURIC)));
	public static final RegistryObject<Item> auric_helm = ITEMS.register("auric_helm",
			() -> new ItemAuricArmor(EnumModArmorTiers.AURIC, ArmorItem.Type.HELMET));
	public static final RegistryObject<Item> auric_chest = ITEMS.register("auric_chest",
			() -> new ItemAuricArmor(EnumModArmorTiers.AURIC, ArmorItem.Type.CHESTPLATE));
	public static final RegistryObject<Item> auric_leggings = ITEMS.register("auric_leggings",
			() -> new ItemAuricArmor(EnumModArmorTiers.AURIC, ArmorItem.Type.LEGGINGS));
	public static final RegistryObject<Item> auric_boots = ITEMS.register("auric_boots",
			() -> new ItemAuricArmor(EnumModArmorTiers.AURIC, ArmorItem.Type.BOOTS));
	public static final RegistryObject<Item> machina_spark_director = MODELEDITEMS.register("machina_spark_director",
			() -> new ItemSparkDirector(EnumModArmorTiers.AURIC, ArmorItem.Type.CHESTPLATE,
					(new Item.Properties()).rarity(HLTextUtils.AURIC), false));
	public static final RegistryObject<Item> machina_spark_director_armored = MODELEDITEMS.register(
			"machina_spark_director_armored", () -> new ItemSparkDirector(EnumModArmorTiers.AURIC, ArmorItem.Type.CHESTPLATE,
					(new Item.Properties()).rarity(HLTextUtils.AURIC), true));

	// Gloves
	public static final RegistryObject<Item> mechan_glove = MODELEDITEMS.register("mechan_glove",
			() -> new ItemMechanGlove(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1)
					.durability(512), "mechan_glove", 3, 5, 1));
	public static final RegistryObject<Item> mechan_glove_superior = MODELEDITEMS
			.register("mechan_glove_superior",
					() -> new ItemMechanGlove(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)
							.durability(1024), "mechan_glove_superior", 6, 10,
							2));
	public static final RegistryObject<Item> mechan_glove_masterpiece = MODELEDITEMS
			.register("mechan_glove_masterpiece",
					() -> new ItemMechanGlove(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1)
							.durability(2048), "mechan_glove_masterpiece", 9, 15,
							3));
	public static final RegistryObject<Item> mechan_glove_godlike = MODELEDITEMS
			.register("mechan_glove_godlike",
					() -> new ItemMechanGlove(
							new Item.Properties().rarity(HLTextUtils.AURIC).stacksTo(1)
									.durability(4096),
							"mechan_glove_godlike", 9, 35, 4));

	// Modules
	public static final RegistryObject<Item> mechan_module = ITEMS.register("mechan_module",
			() -> new ItemMechanModuleBase(new Item.Properties().stacksTo(1), 0,
					"Base Module"));
	public static final RegistryObject<Item> mechan_module_rocket = ITEMS.register("mechan_module_rocket",
			() -> new ItemMechanModuleRocket(new Item.Properties().stacksTo(1),
					1, "Fires a singluar exploding rocket at an angle"));
	public static final RegistryObject<Item> mechan_module_salvo = ITEMS.register("mechan_module_salvo",
			() -> new ItemMechanModuleSalvo(new Item.Properties().stacksTo(1), 2,
					"Fire Several homing rockets that track down targets around player"));
	public static final RegistryObject<Item> mechan_module_shortcircuit = ITEMS.register("mechan_module_shortcircuit",
			() -> new ItemMechanModuleShortCircuit(
					new Item.Properties().stacksTo(1), 3,
					"Fires a ball of electricity that leaps between targets"));
	public static final RegistryObject<Item> mechan_module_laser = ITEMS.register("mechan_module_laser",
			() -> new ItemMechanModuleLaser(new Item.Properties().stacksTo(1), 2,
					"Fires a concetrated burst of energy from the glove"));
	public static final RegistryObject<Item> mechan_module_blade = ITEMS.register("mechan_module_blade",
			() -> new ItemMechanModuleBlade(new Item.Properties().stacksTo(1), 1,
					"Extrudes a small blade from the glove increasing damage dealt"));
	public static final RegistryObject<Item> mechan_module_thruster = ITEMS.register("mechan_module_thruster",
			() -> new ItemMechanModuleThruster(new Item.Properties().stacksTo(1),
					3, "Increases the power of an equiped Machina Spark Director, Allows for boosting"));

	// InterCoven Items
	// Hastur + Machine
	public static final RegistryObject<Item> neurotic_mechanism = ITEMS.register("neurotic_mechanism",
			() -> new ItemNeuroticMechanism(
					new Item.Properties().rarity(HLTextUtils.AURIC)));
	/*
	 * public static final RegistryObject<Item> null_bow_blade =
	 * ADVITEMS.register("null_bow_blade", () -> new ItemBowBlade( new
	 * Item.Properties().stacksTo(1).
	 * durability(1024), 2, 8, 1)); public static final RegistryObject<Item>
	 * somnolent_bow_blade = ADVITEMS.register("somnolent_bow_blade", () -> new
	 * ItemBowBlade( new
	 * Item.Properties().stacksTo(1).
	 * durability(512), 1, 6, 1));
	 */
	public static final RegistryObject<Item> auric_bow_blade = ADVITEMS.register("auric_bow_blade",
			() -> new ItemBowBlade(
					new Item.Properties().stacksTo(1).durability(2048), 3, 10,
					1));
	/*
	 * public static final RegistryObject<Item> null_trick_axe =
	 * ADVITEMS.register("null_trick_axe", () -> new ItemTrickAxe(new
	 * Item.Properties().stacksTo(1),
	 * EnumModToolTiers.NULL)); public static final RegistryObject<Item>
	 * somnolent_trick_axe = ADVITEMS.register("somnolent_trick_axe", () -> new
	 * ItemTrickAxe(new
	 * Item.Properties().stacksTo(1),
	 * EnumModToolTiers.MYSTIC));
	 */
	public static final RegistryObject<Item> auric_trick_axe = ADVITEMS.register("auric_trick_axe",
			() -> new ItemTrickAxe(new Item.Properties().stacksTo(1),
					EnumModToolTiers.AURIC));
	// Ascendant + Machine
	public static final RegistryObject<Item> concecrated_aurum = ITEMS.register("concecrated_aurum",
			() -> new ItemConcecratedAurum(new Item.Properties()));
	public static final RegistryObject<Item> vorpal_blade = ITEMS.register("vorpal_blade",
			() -> new ItemVorpalSword(EnumModToolTiers.OLD_IRON, 3, -2.4F,
					new Item.Properties()));
	// Eldritch + Machine
	public static final RegistryObject<Item> wicked_module_laser = ITEMS.register("wicked_module_laser",
			() -> new ItemWickedModuleLaser(
					new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 4,
					"A Funtional Anomaly, Fires a blast of Eldritch beam"));
	// Eldritch+Hastur
	public static final RegistryObject<Item> twisted_fabric = ITEMS.register("twisted_fabric",
			() -> new ItemTwistedFabric(new Item.Properties()));

	// Eldritch+Beast+Hastur
	public static final RegistryObject<Item> destruction_orb = ITEMS.register("destruction_orb",
			() -> new ItemDestructOrb(new Item.Properties().stacksTo(1)));
	// Ascendant+Machine+Self
	public static final RegistryObject<Item> destruction_orb_contained = ITEMS.register("destruction_orb_contained",
			() -> new ItemDestructOrbContained(
					new Item.Properties().stacksTo(1)));

	public static final RegistryObject<Item> bucket_slug = ITEMS.register("bucket_slug",
			() -> new ItemSlugBucket(new Item.Properties().stacksTo(1)));

	// Charms
	public static final RegistryObject<Item> drying_agent = ITEMS.register("drying_agent",
			() -> new ItemDryingAgent(new Item.Properties()));
	public static final RegistryObject<Item> soaking_agent = ITEMS.register("soaking_agent",
			() -> new ItemSoakingAgent(new Item.Properties()));
	public static final RegistryObject<Item> storming_agent = ITEMS.register("storming_agent",
			() -> new ItemStormingAgent(new Item.Properties()));

	// Armor
	public static final RegistryObject<Item> influence_supressor = ITEMS.register("influence_supressor",
			() -> new ItemInfluenceSuppressor(EnumModArmorTiers.SUPPRESSOR, ArmorItem.Type.HELMET,
					(new Item.Properties())));

	public static final RegistryObject<Item> anointed_iron_helm = ITEMS.register("anointed_iron_helm",
			() -> new ArmorItem(EnumModArmorTiers.ANOINTED, ArmorItem.Type.HELMET,
					(new Item.Properties())));

	public static final RegistryObject<Item> anointed_iron_chestplate = ITEMS.register("anointed_iron_chestplate",
			() -> new ArmorItem(EnumModArmorTiers.ANOINTED, ArmorItem.Type.CHESTPLATE,
					(new Item.Properties())));

	public static final RegistryObject<Item> anointed_iron_leggings = ITEMS.register("anointed_iron_leggings",
			() -> new ArmorItem(EnumModArmorTiers.ANOINTED, ArmorItem.Type.LEGGINGS,
					(new Item.Properties())));

	public static final RegistryObject<Item> anointed_iron_boots = ITEMS.register("anointed_iron_boots",
			() -> new ArmorItem(EnumModArmorTiers.ANOINTED, ArmorItem.Type.BOOTS,
					(new Item.Properties())));

	public static final RegistryObject<Item> writhing_helmet = ITEMS.register("writhing_helmet",
			() -> new ItemWrithingArmor(EnumModArmorTiers.WRITHING, ArmorItem.Type.HELMET));
	public static final RegistryObject<Item> writhing_chestplate = ITEMS.register("writhing_chestplate",
			() -> new ItemWrithingArmor(EnumModArmorTiers.WRITHING, ArmorItem.Type.CHESTPLATE));
	public static final RegistryObject<Item> writhing_leggings = ITEMS.register("writhing_leggings",
			() -> new ArmorItem(EnumModArmorTiers.WRITHING, ArmorItem.Type.LEGGINGS,
					(new Item.Properties())));
	public static final RegistryObject<Item> writhing_boots = ITEMS.register("writhing_boots",
			() -> new ArmorItem(EnumModArmorTiers.WRITHING, ArmorItem.Type.BOOTS,
					(new Item.Properties())));

	// Tools
	// Anointed Iron
	public static final RegistryObject<Item> anointed_iron_sword = HANDHELDITEMS.register("anointed_iron_sword",
			() -> new SwordItem(EnumModToolTiers.OLD_IRON, 3, -2.4F,
					new Item.Properties()));

	// Spawn Eggs
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_hastur = SPAWNEGGS.register("spawn_egg_hastur",
			() -> new ModSpawnEggItem(EntityInit.hastur, 10862336, 0,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_hastur_vassal = SPAWNEGGS
			.register("spawn_egg_hastur_vassal", () -> new ModSpawnEggItem(EntityInit.hastur_vassal, 10862336, 0x0000FF,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_tentacle = SPAWNEGGS.register("spawn_egg_tentacle",
			() -> new ModSpawnEggItem(EntityInit.tentacle, 22073, 12371968,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_denizen = SPAWNEGGS.register("spawn_egg_denizen",
			() -> new ModSpawnEggItem(EntityInit.denizen, 8750204, 12037632,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_denizen_sage = SPAWNEGGS
			.register("spawn_egg_denizen_sage", () -> new ModSpawnEggItem(EntityInit.denizen_sage, 8750204, 72037632,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_hastur_spawn = SPAWNEGGS
			.register("spawn_egg_hastur_spawn", () -> new ModSpawnEggItem(EntityInit.hastur_spawn, 4539136, 13548032,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_slug = SPAWNEGGS.register("spawn_egg_slug",
			() -> new ModSpawnEggItem(EntityInit.slug, 7761777, 4206080,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_seraphim = SPAWNEGGS.register("spawn_egg_seraphim",
			() -> new ModSpawnEggItem(EntityInit.seraphim, 16515071, 16514816,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_tetra = SPAWNEGGS.register("spawn_egg_tetra",
			() -> new ModSpawnEggItem(EntityInit.tetra, 14565021, 16464878,
					new Item.Properties()));
//	public static final RegistryObject<ModSpawnEggItem> spawn_egg_throne = SPAWNEGGS.register("spawn_egg_throne",
//			() -> new ModSpawnEggItem(EntityInit.throne, 16777215, 12745984,
//					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_beast_from_beyond = SPAWNEGGS
			.register("spawn_egg_beast_from_beyond", () -> new ModSpawnEggItem(EntityInit.beast_from_beyond, 9450752, 0,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_lord_of_the_wild = SPAWNEGGS.register(
			"spawn_egg_lord_of_the_wild", () -> new ModSpawnEggItem(EntityInit.lord_of_the_wild, 9450752, 7450752,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_summoned_beast = SPAWNEGGS
			.register("spawn_egg_summoned_beast", () -> new ModSpawnEggItem(EntityInit.summoned_beast, 8155760, 9450752,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_malformed_automaton = SPAWNEGGS.register(
			"spawn_egg_malformed_automaton", () -> new ModSpawnEggItem(EntityInit.malformed_automaton, 15576576, 41873,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_dark_young = SPAWNEGGS
			.register("spawn_egg_dark_young", () -> new ModSpawnEggItem(EntityInit.dark_young, 0, 0xFA00FF,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_tulpa = SPAWNEGGS.register("spawn_egg_tulpa",
			() -> new ModSpawnEggItem(EntityInit.tulpa, 0, 0,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_scuttling_occulus = SPAWNEGGS.register(
			"spawn_egg_scuttling_occulus", () -> new ModSpawnEggItem(EntityInit.scuttling_occulus, 12764357, 5767365,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_dread_bot = SPAWNEGGS.register("spawn_egg_dread_bot",
			() -> new ModSpawnEggItem(EntityInit.dread_bot, 12743680, 12764357,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_mechan = SPAWNEGGS.register("spawn_egg_mechan",
			() -> new ModSpawnEggItem(EntityInit.mechan, 12743680, 0,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_veritas = SPAWNEGGS.register("spawn_egg_veritas",
			() -> new ModSpawnEggItem(EntityInit.veritas, 0xFFFFFF, 0xFFFFFF,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_black_goat = SPAWNEGGS
			.register("spawn_egg_black_goat", () -> new ModSpawnEggItem(EntityInit.black_goat, 0xF23FaF, 0xF23FaF,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_angelic_fowl = SPAWNEGGS
			.register("spawn_egg_angelic_fowl", () -> new ModSpawnEggItem(EntityInit.angelic_fowl, 0xBDFFE2, 0xFFD25B,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_deranged_beast = SPAWNEGGS
			.register("spawn_egg_deranged_beast", () -> new ModSpawnEggItem(EntityInit.deranged_beast, 4603962, 5252864,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_uzouthrhix = SPAWNEGGS
			.register("spawn_egg_uzouthrhix", () -> new ModSpawnEggItem(EntityInit.uzouthrhix, 23862, 8133430,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_xanthous_king = SPAWNEGGS
			.register("spawn_egg_xanthous_king", () -> new ModSpawnEggItem(EntityInit.xanthous_king, 10862336, 852039,
					new Item.Properties()));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_devotee = SPAWNEGGS.register("spawn_egg_devotee",
			() -> new ModSpawnEggItem(EntityInit.devotee, 4341573, 9604677,
					new Item.Properties()));

	public static final RegistryObject<ModSpawnEggItem> spawn_egg_first_beast = SPAWNEGGS
			.register("spawn_egg_first_beast", () -> new ModSpawnEggItem(EntityInit.the_first_beast, 6499072, 11777460,
					new Item.Properties()));

	@SuppressWarnings("deprecation")
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void itemPropOverrideClient(final FMLClientSetupEvent event) {

		ItemProperties.register(ItemInit.first_beast_crossbow.get(), new ResourceLocation("pull"),
				new ItemPropertyFunction() {
					@Override
					public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
						if (ent == null) {
							return 0.0F;
						} else {
							return ItemBeastCrossbow.isCharged(stack) ? 0.0F
									: (float) (stack.getUseDuration() - ent.getUseItemRemainingTicks())
											/ (float) ItemBeastCrossbow.getChargeTime(stack);
						}
					}
				});
		ItemProperties.register(ItemInit.first_beast_crossbow.get(), new ResourceLocation("pulling"),
				new ItemPropertyFunction() {
					@Override
					public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
						return ent != null && ent.isUsingItem() && ent.getUseItem() == stack
								&& !ItemBeastCrossbow.isCharged(stack) ? 1.0F : 0.0F;
					}
				});
		ItemProperties.register(ItemInit.first_beast_crossbow.get(), new ResourceLocation("charged"),
				new ItemPropertyFunction() {
					@Override
					public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
						return ent != null && ItemBeastCrossbow.isCharged(stack) ? 1.0F : 0.0F;
					}
				});
		ItemProperties.register(ItemInit.first_beast_crossbow.get(), new ResourceLocation("firework"),
				new ItemPropertyFunction() {
					@Override
					public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
						return ent != null && ItemBeastCrossbow.isCharged(stack)
								&& ItemBeastCrossbow.hasChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
					}
				});

		// Mechan Glove
		ItemProperties.register(mechan_glove.get(), new ResourceLocation(ForcesOfReality.MOD_ID, "on"),
				new ItemPropertyFunction() {
					@Override
					public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
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
		ItemProperties.register(mechan_glove_superior.get(), new ResourceLocation(ForcesOfReality.MOD_ID, "on"),
				new ItemPropertyFunction() {
					@Override
					public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
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
		ItemProperties.register(mechan_glove_masterpiece.get(), new ResourceLocation(ForcesOfReality.MOD_ID, "on"),
				new ItemPropertyFunction() {
					@Override
					public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
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
		ItemProperties.register(mechan_glove_godlike.get(), new ResourceLocation(ForcesOfReality.MOD_ID, "on"),
				new ItemPropertyFunction() {
					@Override
					public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
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
		ItemProperties.register(emp_charm.get(), new ResourceLocation(ForcesOfReality.MOD_ID, "on"),
				new ItemPropertyFunction() {
					@Override
					public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
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

		// Auric
		ItemProperties.register(auric_bow_blade.get(), new ResourceLocation(ForcesOfReality.MOD_ID, "open"),
				new ItemPropertyFunction() {
					@Override
					public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
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
		ItemProperties.register(auric_bow_blade.get(), new ResourceLocation("pull"), new ItemPropertyFunction() {
			@Override
			public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
				if (ent == null) {
					return 0.0F;
				} else {
					return ent.getUseItem() != stack ? 0.0F
							: (stack.getUseDuration() - ent.getUseItemRemainingTicks()) / 20.0F;
				}
			}
		});
		ItemProperties.register(auric_bow_blade.get(), new ResourceLocation("pulling"), new ItemPropertyFunction() {
			@Override
			public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
				return ent != null && ent.isUsingItem() && ent.getUseItem() == stack ? 1.0F : 0.0F;
			}
		});

		// Trick Axe
		/*
		 * // Null ItemProperties.register(null_trick_axe.get(), new
		 * ResourceLocation(ForcesOfReality.MOD_ID, "open"), new ItemPropertyFunction()
		 * {
		 *
		 * @Override public float call(ItemStack stack, ClientLevel world, LivingEntity
		 * ent) { if (stack.hasTag()) { if (stack.getTag().getBoolean("state")) { return
		 * 1; } else { return 0; } } return 0; } });
		 * ItemProperties.register(null_trick_axe.get(), new ResourceLocation("pull"),
		 * (p_239429_0_, p_239429_1_, ent) -> { if (ent == null) { return 0.0F; } else {
		 * return ent.getUseItem() != p_239429_0_ ? 0.0F : (float)
		 * (p_239429_0_.getUseDuration() - ent.getUseItemRemainingTicks()) / 20.0F; }
		 * }); ItemProperties.register(null_trick_axe.get(), new
		 * ResourceLocation("pulling"), (stack, p_239428_1_, ent) -> { return ent !=
		 * null && ent.isUsingItem() && ent.getUseItem() == stack ? 1.0F : 0.0F; });
		 *
		 * // Somnolent ItemProperties.register(somnolent_trick_axe.get(), new
		 * ResourceLocation(ForcesOfReality.MOD_ID, "open"), new ItemPropertyFunction()
		 * {
		 *
		 * @Override public float call(ItemStack stack, ClientLevel world, LivingEntity
		 * ent) { if (stack.hasTag()) { if (stack.getTag().getBoolean("state")) { return
		 * 1; } else { return 0; } } return 0; } });
		 * ItemProperties.register(somnolent_trick_axe.get(), new
		 * ResourceLocation("pull"), (p_239429_0_, p_239429_1_, ent) -> { if (ent ==
		 * null) { return 0.0F; } else { return ent.getUseItem() != p_239429_0_ ? 0.0F :
		 * (float) (p_239429_0_.getUseDuration() - ent.getUseItemRemainingTicks()) /
		 * 20.0F; } }); ItemProperties.register(somnolent_trick_axe.get(), new
		 * ResourceLocation("pulling"), (stack, p_239428_1_, ent) -> { return ent !=
		 * null && ent.isUsingItem() && ent.getUseItem() == stack ? 1.0F : 0.0F; });
		 */

		// Somnolent
		ItemProperties.register(auric_trick_axe.get(), new ResourceLocation(ForcesOfReality.MOD_ID, "open"),
				new ItemPropertyFunction() {
					@Override
					public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
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
		ItemProperties.register(auric_trick_axe.get(), new ResourceLocation("pull"), new ItemPropertyFunction() {
			@Override
			public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
				if (ent == null) {
					return 0.0F;
				} else {
					return ent.getUseItem() != stack ? 0.0F
							: (stack.getUseDuration() - ent.getUseItemRemainingTicks()) / 20.0F;
				}
			}
		});
		ItemProperties.register(auric_trick_axe.get(), new ResourceLocation("pulling"), new ItemPropertyFunction() {
			@Override
			public float call(ItemStack stack, ClientLevel world, LivingEntity ent, int p_174679_) {
				return ent != null && ent.isUsingItem() && ent.getUseItem() == stack ? 1.0F : 0.0F;
			}
		});

	}

	@SafeVarargs
	public static void registerItemColorHandler(ItemColors colors, ItemColor itemColor,
			RegistryObject<ModSpawnEggItem>... items) {
		for (RegistryObject<ModSpawnEggItem> itemProvider : items) {
			colors.register(itemColor, itemProvider.get());
		}
	}

	@SubscribeEvent
	public static void registerItemColorHandlers(RegisterColorHandlersEvent.Item event) {
		registerSpawnEggColorHandler(event.getItemColors(), ItemInit.spawn_egg_hastur, ItemInit.spawn_egg_hastur_vassal,
				ItemInit.spawn_egg_denizen, ItemInit.spawn_egg_denizen_sage, ItemInit.spawn_egg_tentacle,
				ItemInit.spawn_egg_hastur_spawn, ItemInit.spawn_egg_slug, ItemInit.spawn_egg_seraphim,
				/* ItemInit.spawn_egg_throne, */ ItemInit.spawn_egg_beast_from_beyond,
				ItemInit.spawn_egg_summoned_beast, ItemInit.spawn_egg_malformed_automaton,
				ItemInit.spawn_egg_dark_young, ItemInit.spawn_egg_tulpa, ItemInit.spawn_egg_scuttling_occulus,
				ItemInit.spawn_egg_dread_bot, ItemInit.spawn_egg_mechan, ItemInit.spawn_egg_veritas,
				ItemInit.spawn_egg_black_goat, ItemInit.spawn_egg_angelic_fowl, ItemInit.spawn_egg_deranged_beast,
				ItemInit.spawn_egg_tetra, ItemInit.spawn_egg_lord_of_the_wild, ItemInit.spawn_egg_uzouthrhix,
				ItemInit.spawn_egg_xanthous_king, ItemInit.spawn_egg_devotee, ItemInit.spawn_egg_first_beast);
	}

	@SafeVarargs
	public static void registerSpawnEggColorHandler(ItemColors colors, RegistryObject<ModSpawnEggItem>... spawnEggs) {
		for (RegistryObject<ModSpawnEggItem> spawnEgg : spawnEggs) {
			registerItemColorHandler(colors, (stack, tintIndex) -> spawnEgg.get().getColor(tintIndex), spawnEgg);
		}
	}

}