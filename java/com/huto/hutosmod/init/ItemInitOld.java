package com.huto.hutosmod.init;
/*package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.HutosMod.HutosModItemGroup;
import com.huto.hutosmod.objects.items.ItemAttractionCharm;
import com.huto.hutosmod.objects.items.ItemRepulsionCharm;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(HutosMod.MOD_ID)
@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD)
public class ItemInit {

	public static final Item example_item = null;
	public static final Item grey_ingot = null;
	public static final Item grey_powder = null;
	public static final Item grey_crystal = null;
	public static final Item null_ingot = null;
	public static final Item nullifying_powder = null;
	public static final Item null_crystal = null;
	public static final Item null_rod = null;
	public static final Item channeling_ingot = null;
	public static final Item mana_powder = null;
	public static final Item mana_crystal = null;
	public static final Item channeling_rod = null;
	public static final Item essence_drop = null;
	public static final Item karmic_drop = null;
	public static final Item karmic_bar = null;
	public static final Item anti_tear = null;
	public static final Item readied_pane = null;
	public static final Item phantasmal_pane = null;
	public static final Item mind_spike = null;
	public static final Item magatamabead = null;
	public static final Item enhancedmagatama = null;
	public static final Item energy_focus = null;
	public static final Item purging_stone = null;
	public static final Item grand_purging_stone = null;
	public static final Item resonant_fuel = null;
	public static final Item drying_agent = null;
	public static Item repulsion_charm = null;
	public static Item attraction_charm = null;
	public static final Item singeri_soup = null;
	public static final Item raw_morel_on_a_stick = null;
	public static final Item cooked_morel_on_a_stick = null;
	public static final Item mana_bottle = null;

	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) {
		// Material
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("example_item"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("grey_ingot"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("grey_powder"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("grey_crystal"));

		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("essence_drop"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("channeling_ingot"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("mana_powder"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("mana_crystal"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("channeling_rod"));

		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("anti_tear"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("null_ingot"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("nullifying_powder"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("null_crystal"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("null_rod"));

		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("karmic_drop"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("karmic_bar"));

		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("readied_pane"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("phantasmal_pane"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("drying_agent"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("resonant_fuel"));

		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("magatamabead"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("enhancedmagatama"));

		// Karma
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("purging_stone"));
		event.getRegistry().register(new Item(new Item.Properties().group(HutosModItemGroup.instance))
				.setRegistryName("grand_purging_stone"));

		// Food
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("singeri_soup"));
		event.getRegistry().register(new Item(new Item.Properties().group(HutosModItemGroup.instance))
				.setRegistryName("raw_morel_on_a_stick"));
		event.getRegistry()
				.register(new Item(new Item.Properties().group(HutosModItemGroup.instance)
						.food(new Food.Builder().hunger(6).saturation(1.5f)
								.effect(new EffectInstance(Effects.ABSORPTION, 6000, 5), 0.7f).build()))
										.setRegistryName("cooked_morel_on_a_stick"));
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("mana_bottle"));

		// Charms

		attraction_charm = new ItemAttractionCharm(new Item.Properties().group(HutosModItemGroup.instance))
				.setRegistryName("attraction_charm");
		event.getRegistry().register(attraction_charm);
		
		repulsion_charm = new ItemRepulsionCharm(new Item.Properties().group(HutosModItemGroup.instance))
				.setRegistryName("repulsion_charm");
		event.getRegistry().register(repulsion_charm);


		// Runes
		event.getRegistry().register(
				new Item(new Item.Properties().group(HutosModItemGroup.instance)).setRegistryName("mind_spike"));

	}

}
*/