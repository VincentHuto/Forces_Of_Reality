package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.HutosMod.HutosModItemGroup;
import com.huto.hutosmod.objects.items.EnumModArmorTiers;
import com.huto.hutosmod.objects.items.EnumModToolTiers;
import com.huto.hutosmod.objects.items.ItemAttractionCharm;
import com.huto.hutosmod.objects.items.ItemRepulsionCharm;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HutosMod.MOD_ID);

	// Books

	public static final RegistryObject<Item> mystic_tome = ITEMS.register("mystic_tome",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> elder_tome = ITEMS.register("elder_tome",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

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
	public static final RegistryObject<Item> nullifying_powder = ITEMS.register("nullifying_powder",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> null_crystal = ITEMS.register("null_crystal",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> null_rod = ITEMS.register("null_rod",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

	// Materials

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

	// Karma

	public static final RegistryObject<Item> karmic_drop = ITEMS.register("karmic_drop",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> karmic_bar = ITEMS.register("karmic_bar",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> purging_stone = ITEMS.register("purging_stone",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> grand_purging_stone = ITEMS.register("grand_purging_stone",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

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
			() -> new ItemAttractionCharm(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> repulsion_charm = ITEMS.register("repulsion_charm",
			() -> new ItemRepulsionCharm(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> drying_agent = ITEMS.register("drying_agent",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> soaking_agent = ITEMS.register("soaking_agent",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> storming_agent = ITEMS.register("storming_agent",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

	// Runes

	public static final RegistryObject<Item> mind_spike = ITEMS.register("mind_spike",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

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

	// Armor

	public static final RegistryObject<Item> null_helmet = ITEMS.register("null_helmet",
			() -> new ArmorItem(EnumModArmorTiers.NULL, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(HutosModItemGroup.instance).isBurnable()));
	public static final RegistryObject<Item> null_chestplate = ITEMS.register("null_chestplate",
			() -> new ArmorItem(EnumModArmorTiers.NULL, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(HutosModItemGroup.instance).isBurnable()));
	public static final RegistryObject<Item> null_leggings = ITEMS.register("null_leggings",
			() -> new ArmorItem(EnumModArmorTiers.NULL, EquipmentSlotType.LEGS,
					(new Item.Properties()).group(HutosModItemGroup.instance).isBurnable()));
	public static final RegistryObject<Item> null_boots = ITEMS.register("null_boots",
			() -> new ArmorItem(EnumModArmorTiers.NULL, EquipmentSlotType.FEET,
					(new Item.Properties()).group(HutosModItemGroup.instance).isBurnable()));

	public static final RegistryObject<Item> elder_helmet = ITEMS.register("elder_helmet",
			() -> new ArmorItem(EnumModArmorTiers.ELDER, EquipmentSlotType.HEAD,
					(new Item.Properties()).group(HutosModItemGroup.instance).isBurnable()));
	public static final RegistryObject<Item> elder_chestplate = ITEMS.register("elder_chestplate",
			() -> new ArmorItem(EnumModArmorTiers.ELDER, EquipmentSlotType.CHEST,
					(new Item.Properties()).group(HutosModItemGroup.instance).isBurnable()));
	public static final RegistryObject<Item> elder_leggings = ITEMS.register("elder_leggings",
			() -> new ArmorItem(EnumModArmorTiers.ELDER, EquipmentSlotType.LEGS,
					(new Item.Properties()).group(HutosModItemGroup.instance).isBurnable()));
	public static final RegistryObject<Item> elder_boots = ITEMS.register("elder_boots",
			() -> new ArmorItem(EnumModArmorTiers.ELDER, EquipmentSlotType.FEET,
					(new Item.Properties()).group(HutosModItemGroup.instance).isBurnable()));

	// Hands

	public static final RegistryObject<Item> mana_extractor = ITEMS.register("mana_extractor",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));
	public static final RegistryObject<Item> maker_activator = ITEMS.register("maker_activator",
			() -> new Item(new Item.Properties().group(HutosModItemGroup.instance)));

}