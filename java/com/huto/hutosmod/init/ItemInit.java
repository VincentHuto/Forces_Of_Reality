package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.HutosMod.HutosModItemGroup;
import com.huto.hutosmod.objects.items.EnumModArmorTiers;
import com.huto.hutosmod.objects.items.EnumModToolTiers;
import com.huto.hutosmod.objects.items.ItemAttractionCharm;
import com.huto.hutosmod.objects.items.ItemDebugTool;
import com.huto.hutosmod.objects.items.ItemDestructOrb;
import com.huto.hutosmod.objects.items.ItemDestructOrbContained;
import com.huto.hutosmod.objects.items.ItemDiscordantBell;
import com.huto.hutosmod.objects.items.ItemDryingAgent;
import com.huto.hutosmod.objects.items.ItemElderTome;
import com.huto.hutosmod.objects.items.ItemFrequencyMatcher;
import com.huto.hutosmod.objects.items.ItemGrandPurgingStone;
import com.huto.hutosmod.objects.items.ItemGuidanceRune;
import com.huto.hutosmod.objects.items.ItemKnapper;
import com.huto.hutosmod.objects.items.ItemMakerActivator;
import com.huto.hutosmod.objects.items.ItemManaExtractor;
import com.huto.hutosmod.objects.items.ItemMysteriousMask;
import com.huto.hutosmod.objects.items.ItemMysticTome;
import com.huto.hutosmod.objects.items.ItemPurgingStone;
import com.huto.hutosmod.objects.items.ItemRepulsionCharm;
import com.huto.hutosmod.objects.items.ItemSelfAnalyzer;
import com.huto.hutosmod.objects.items.ItemShatterIngot;
import com.huto.hutosmod.objects.items.ItemSlimeRepulsionCharm;
import com.huto.hutosmod.objects.items.ItemSoakingAgent;
import com.huto.hutosmod.objects.items.ItemStarSlug;
import com.huto.hutosmod.objects.items.ItemStormingAgent;
import com.huto.hutosmod.objects.items.ItemUpgrade;
import com.huto.hutosmod.objects.items.ItemVibeSeer;
import com.huto.hutosmod.objects.items.ItemWandConsumeVibes;
import com.huto.hutosmod.objects.items.ItemWandGainVibes;
import com.huto.hutosmod.objects.items.ItemYellowSign;
import com.huto.hutosmod.objects.items.ItemYellowTome;
import com.huto.hutosmod.objects.items.ModSpawnEggItem;
import com.huto.hutosmod.objects.items.ToolVeinPickaxe;
import com.huto.hutosmod.objects.items.runes.ItemContractRune;
import com.huto.hutosmod.objects.items.runes.ItemMilkweedRune;
import com.huto.hutosmod.objects.items.runes.ItemRune;

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

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HutosMod.MOD_ID);

	// Books
	public static final RegistryObject<Item> mystic_tome = ITEMS.register("mystic_tome",
			() -> new ItemMysticTome(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> elder_tome = ITEMS.register("elder_tome",
			() -> new ItemElderTome(new Item.Properties().group(HutosModItemGroup.instance)));

	// Grey
	public static final RegistryObject<Item> grey_ingot = ITEMS.register("grey_ingot",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> grey_powder = ITEMS.register("grey_powder",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> grey_crystal = ITEMS.register("grey_crystal",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

	// Channeling
	public static final RegistryObject<Item> essence_drop = ITEMS.register("essence_drop",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> channeling_ingot = ITEMS.register("channeling_ingot",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> emanating_ingot = ITEMS.register("emanating_ingot",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> mana_powder = ITEMS.register("mana_powder",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> mana_crystal = ITEMS.register("mana_crystal",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> channeling_rod = ITEMS.register("channeling_rod",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

	// Anti
	public static final RegistryObject<Item> anti_tear = ITEMS.register("anti_tear",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> null_ingot = ITEMS.register("null_ingot",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> shattered_ingot = ITEMS.register("shattered_ingot",
			() -> new ItemShatterIngot(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> nullifying_powder = ITEMS.register("nullifying_powder",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> null_crystal = ITEMS.register("null_crystal",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> null_rod = ITEMS.register("null_rod",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> destruction_orb = ITEMS.register("destruction_orb",
			() -> new ItemDestructOrb(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> destruction_orb_contained = ITEMS.register("destruction_orb_contained",
			() -> new ItemDestructOrbContained(
					new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	// Materials
	// Gems
	public static final RegistryObject<Item> gem_hematite = ITEMS.register("gem_hematite",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> gem_ruby = ITEMS.register("gem_ruby",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> gem_onyx = ITEMS.register("gem_onyx",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> gem_sapphire = ITEMS.register("gem_sapphire",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> gem_topaz = ITEMS.register("gem_topaz",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> gem_amethyst = ITEMS.register("gem_amethyst",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> gem_opal = ITEMS.register("gem_opal",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

	public static final RegistryObject<Item> readied_pane = ITEMS.register("readied_pane",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> phantasmal_pane = ITEMS.register("phantasmal_pane",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> resonant_fuel = ITEMS.register("resonant_fuel",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> magatamabead = ITEMS.register("magatamabead",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> enhancedmagatama = ITEMS.register("enhancedmagatama",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> energy_focus = ITEMS.register("energy_focus",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

	// Hastur
	public static final RegistryObject<Item> unsettling_fabric = ITEMS.register("unsettling_fabric",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> yellow_sign = ITEMS.register("yellow_sign", () -> new ItemYellowSign(
			new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> yellow_tome = ITEMS.register("yellow_tome", () -> new ItemYellowTome(
			new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1).rarity(Rarity.UNCOMMON)));
	public static final RegistryObject<Item> star_slug = ITEMS.register("star_slug", () -> new ItemStarSlug(
			new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1).rarity(Rarity.RARE)));
	public static final RegistryObject<Item> discordant_bell = ITEMS.register("discordant_bell",
			() -> new ItemDiscordantBell(
					new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1).rarity(Rarity.RARE)));
	// Karma
	public static final RegistryObject<Item> karmic_drop = ITEMS.register("karmic_drop",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> karmic_bar = ITEMS.register("karmic_bar",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> purging_stone = ITEMS.register("purging_stone",
			() -> new ItemPurgingStone(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> grand_purging_stone = ITEMS.register("grand_purging_stone",
			() -> new ItemGrandPurgingStone(new Item.Properties().group(HutosModItemGroup.instance)));

	// Food
	public static final RegistryObject<Item> singeri_soup = ITEMS.register("singeri_soup",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

	public static final RegistryObject<Item> raw_morel_on_a_stick = ITEMS.register("raw_morel_on_a_stick",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> cooked_morel_on_a_stick = ITEMS.register("cooked_morel_on_a_stick",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance).food(new Food.Builder().hunger(6)
					.saturation(1.5f).effect(new EffectInstance(Effects.ABSORPTION, 6000, 5), 0.7f).build())));
	public static final RegistryObject<Item> mana_bottle = ITEMS.register("mana_bottle",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

	// Charms
	public static final RegistryObject<Item> attraction_charm = ITEMS.register("attraction_charm",
			() -> new ItemAttractionCharm(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> repulsion_charm = ITEMS.register("repulsion_charm",
			() -> new ItemRepulsionCharm(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> slime_charm = ITEMS.register("slime_charm",
			() -> new ItemSlimeRepulsionCharm(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));

	public static final RegistryObject<Item> drying_agent = ITEMS.register("drying_agent",
			() -> new ItemDryingAgent(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> soaking_agent = ITEMS.register("soaking_agent",
			() -> new ItemSoakingAgent(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> storming_agent = ITEMS.register("storming_agent",
			() -> new ItemStormingAgent(new Item.Properties().group(HutosModItemGroup.instance)));

	// Tools
	public static final RegistryObject<Item> null_pickaxe = ITEMS.register("null_pickaxe",
			() -> new PickaxeItem(EnumModToolTiers.NULL, 1, -2.8F,
					new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> null_shovel = ITEMS.register("null_shovel",
			() -> new ShovelItem(EnumModToolTiers.NULL, 1.5F, -3.0F,
					new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> null_hoe = ITEMS.register("null_hoe",
			() -> new HoeItem(EnumModToolTiers.NULL, -3, 0.0F,
					new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> null_axe = ITEMS.register("null_axe",
			() -> new AxeItem(EnumModToolTiers.NULL, 5.0F, -3.0F,
					new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> null_sword = ITEMS.register("null_sword",
			() -> new SwordItem(EnumModToolTiers.NULL, 3, -2.4F,
					new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> duality_pick = ITEMS.register("duality_pick",
			() -> new ToolVeinPickaxe(EnumModToolTiers.NULL, 1, -2.8F,
					new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> duality_axe = ITEMS.register("duality_axe",
			() -> new AxeItem(EnumModToolTiers.NULL, 5.0F, -3.0F,
					new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> absorber_configurer = ITEMS.register("absorber_configurer",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> frequency_matcher = ITEMS.register("frequency_matcher",
			() -> new ItemFrequencyMatcher(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	// Knappers
	public static final RegistryObject<Item> iron_knapper = ITEMS.register("iron_knapper",
			() -> new ItemKnapper(25f, 1, 0, ItemTier.IRON, new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> obsidian_knapper = ITEMS.register("obsidian_knapper",
			() -> new ItemKnapper(50f, 1, 0, EnumModToolTiers.NULL,
					new Item.Properties().group(HutosModItemGroup.instance)));
	// Armor
	public static final RegistryObject<Item> vibrational_seer = ITEMS.register("vibrational_seer",
			() -> new ItemVibeSeer(EnumModArmorTiers.CIRCLET, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> mysterious_mask = ITEMS.register("mysterious_mask",
			() -> new ItemMysteriousMask(EnumModArmorTiers.MASK, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(HutosModItemGroup.instance)));

	public static final RegistryObject<Item> null_helmet = ITEMS.register("null_helmet",
			() -> new ArmorItem(EnumModArmorTiers.NULL, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(HutosModItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> null_chestplate = ITEMS.register("null_chestplate",
			() -> new ArmorItem(EnumModArmorTiers.NULL, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(HutosModItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> null_leggings = ITEMS.register("null_leggings",
			() -> new ArmorItem(EnumModArmorTiers.NULL, EquipmentSlotType.LEGS,
					(new Item.Properties()).group(HutosModItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> null_boots = ITEMS.register("null_boots",
			() -> new ArmorItem(EnumModArmorTiers.NULL, EquipmentSlotType.FEET,
					(new Item.Properties()).group(HutosModItemGroup.instance).isImmuneToFire()));

	public static final RegistryObject<Item> elder_helmet = ITEMS.register("elder_helmet",
			() -> new ArmorItem(EnumModArmorTiers.ELDER, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(HutosModItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> elder_chestplate = ITEMS.register("elder_chestplate",
			() -> new ArmorItem(EnumModArmorTiers.ELDER, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(HutosModItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> elder_leggings = ITEMS.register("elder_leggings",
			() -> new ArmorItem(EnumModArmorTiers.ELDER, EquipmentSlotType.LEGS,
					(new Item.Properties()).group(HutosModItemGroup.instance).isImmuneToFire()));
	public static final RegistryObject<Item> elder_boots = ITEMS.register("elder_boots",
			() -> new ArmorItem(EnumModArmorTiers.ELDER, EquipmentSlotType.FEET,
					(new Item.Properties()).group(HutosModItemGroup.instance).isImmuneToFire()));

	// Hands
	public static final RegistryObject<Item> mana_extractor = ITEMS.register("mana_extractor",
			() -> new ItemManaExtractor(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> maker_activator = ITEMS.register("maker_activator",
			() -> new ItemMakerActivator(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> vibration_debug_tool = ITEMS.register("vibration_debug_tool",
			() -> new ItemDebugTool(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> self_analyzer = ITEMS.register("self_analyzer",
			() -> new ItemSelfAnalyzer(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));

	// Wands
	public static final RegistryObject<Item> wand_consume_vibes = ITEMS.register("wand_consume_vibes",
			() -> new ItemWandConsumeVibes(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> wand_gain_vibes = ITEMS.register("wand_gain_vibes",
			() -> new ItemWandGainVibes(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	// Upgrades
	public static final RegistryObject<Item> upgrade_wrench = ITEMS.register("upgrade_wrench",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> upgrade_blank = ITEMS.register("upgrade_blank",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> upgrade_block = ITEMS.register("upgrade_block",
			() -> new ItemUpgrade(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> upgrade_player = ITEMS.register("upgrade_player",
			() -> new ItemUpgrade(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> upgrade_animal = ITEMS.register("upgrade_animal",
			() -> new ItemUpgrade(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> upgrade_mob = ITEMS.register("upgrade_mob",
			() -> new ItemUpgrade(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> upgrade_export = ITEMS.register("upgrade_export",
			() -> new ItemUpgrade(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> upgrade_import = ITEMS.register("upgrade_import",
			() -> new ItemUpgrade(new Item.Properties().group(HutosModItemGroup.instance)));

	// Runes
	public static final RegistryObject<Item> mind_spike = ITEMS.register("mind_spike",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> rune_blank = ITEMS.register("rune_blank",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

	// Contract Runes
	public static final RegistryObject<Item> rune_beast_c = ITEMS.register("rune_beast_c",
			() -> new ItemContractRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_corruption_c = ITEMS.register("rune_corruption_c",
			() -> new ItemContractRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_impurity_c = ITEMS.register("rune_impurity_c",
			() -> new ItemContractRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_milkweed_c = ITEMS.register("rune_milkweed_c",
			() -> new ItemMilkweedRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_radiance_c = ITEMS.register("rune_radiance_c",
			() -> new ItemContractRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_hunter_c = ITEMS.register("rune_hunter_c",
			() -> new ItemContractRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));

	// Base Runes
	public static final RegistryObject<Item> rune_metamorphosis = ITEMS.register("rune_metamorphosis",
			() -> new ItemRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_metamorphosis_cw = ITEMS.register("rune_metamorphosis_cw",
			() -> new ItemRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_lake = ITEMS.register("rune_lake",
			() -> new ItemRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_clawmark = ITEMS.register("rune_clawmark",
			() -> new ItemRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_rapture = ITEMS.register("rune_rapture",
			() -> new ItemRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_oedon = ITEMS.register("rune_oedon",
			() -> new ItemRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_eye = ITEMS.register("rune_eye",
			() -> new ItemRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_moon = ITEMS.register("rune_moon",
			() -> new ItemRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_beast = ITEMS.register("rune_beast",
			() -> new ItemRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_heir = ITEMS.register("rune_heir",
			() -> new ItemRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_guidance = ITEMS.register("rune_guidance",
			() -> new ItemGuidanceRune(new Item.Properties().group(HutosModItemGroup.instance).maxStackSize(1)));
	public static final RegistryObject<Item> rune_communion = ITEMS.register("rune_communion",
			() -> new ItemRune(new Item.Properties().group(HutosModItemGroup.instance)));

	// Spawn Eggs
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_dream_walker = ITEMS
			.register("spawn_egg_dream_walker", () -> new ModSpawnEggItem(EntityInit.dream_walker, 0x000000, 0xFFFFFF,
					new Item.Properties().group(ItemGroup.MISC).group(HutosModItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_dream_colin = ITEMS.register("spawn_egg_colin",
			() -> new ModSpawnEggItem(EntityInit.colin, 0x88008B, 0xFF7F00,
					new Item.Properties().group(ItemGroup.MISC).group(HutosModItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_hastur = ITEMS.register("spawn_egg_hastur",
			() -> new ModSpawnEggItem(EntityInit.hastur, 10862336, 0,
					new Item.Properties().group(ItemGroup.MISC).group(HutosModItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_tentacle = ITEMS.register("spawn_egg_tentacle",
			() -> new ModSpawnEggItem(EntityInit.tentacle, 22073, 12371968,
					new Item.Properties().group(ItemGroup.MISC).group(HutosModItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_denizen = ITEMS.register("spawn_egg_denizen",
			() -> new ModSpawnEggItem(EntityInit.denizen, 8750204, 12037632,
					new Item.Properties().group(ItemGroup.MISC).group(HutosModItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_denizen_sage = ITEMS
			.register("spawn_egg_denizen_sage", () -> new ModSpawnEggItem(EntityInit.denizen_sage, 8750204, 72037632,
					new Item.Properties().group(ItemGroup.MISC).group(HutosModItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_ibis = ITEMS.register("spawn_egg_ibis",
			() -> new ModSpawnEggItem(EntityInit.ibis, 9175040, 8672512,
					new Item.Properties().group(ItemGroup.MISC).group(HutosModItemGroup.instance)));
	public static final RegistryObject<ModSpawnEggItem> spawn_egg_hastur_spawn = ITEMS
			.register("spawn_egg_hastur_spawn", () -> new ModSpawnEggItem(EntityInit.hastur_spawn, 4539136, 13548032,
					new Item.Properties().group(ItemGroup.MISC).group(HutosModItemGroup.instance)));

	@SubscribeEvent
	public static void registerItemColorHandlers(ColorHandlerEvent.Item event) {
		registerSpawnEggColorHandler(event.getItemColors(), ItemInit.spawn_egg_dream_colin, ItemInit.spawn_egg_hastur,
				ItemInit.spawn_egg_dream_walker, ItemInit.spawn_egg_denizen, ItemInit.spawn_egg_denizen_sage,
				ItemInit.spawn_egg_ibis, ItemInit.spawn_egg_tentacle, ItemInit.spawn_egg_hastur_spawn);
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

		// Attract Charm
		ItemModelsProperties.registerProperty(attraction_charm.get(), new ResourceLocation(HutosMod.MOD_ID, "on"),
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

		// Slime Charm
		ItemModelsProperties.registerProperty(slime_charm.get(), new ResourceLocation(HutosMod.MOD_ID, "on"),
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
		ItemModelsProperties.registerProperty(repulsion_charm.get(), new ResourceLocation(HutosMod.MOD_ID, "on"),
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
		ItemModelsProperties.registerProperty(frequency_matcher.get(), new ResourceLocation(HutosMod.MOD_ID, "clear"),
				new IItemPropertyGetter() {
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
	}

}