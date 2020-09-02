/*package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.HutosMod.HutosModItemGroup;
import com.huto.hutosmod.objects.blocks.BlockMorelMushroom;
import com.huto.hutosmod.objects.blocks.BlockPassionFlower;
import com.huto.hutosmod.objects.blocks.BlockSingeriMushroom;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(HutosMod.MOD_ID)
@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD)
public class BlockInit {

	public static final Block example_block = null;
	public static final Block activated_obsidian = null;
	public static final Block anti_earth = null;
	public static final Block anti_media = null;
	public static final Block display_glass = null;
	public static final Block enchanted_ore = null;
	public static final Block enchanted_ore_mystic = null;
	public static final Block enchanted_stone = null;
	public static final Block enchanted_stone_smooth = null;
	public static final Block mystic_earth = null;
	public static final Block mystic_media = null;
	public static final Block mystic_planks = null;
	public static final Block nightmare_earth = null;
	public static final Block nightmare_media = null;
	public static final Block reversion_catalyst = null;
	public static final Block runed_obsidian = null;
	public static Block morel_mushroom = null;
	public static Block singeri_mushroom = null;
	public static Block passion_flower = null;

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("example_block"));

		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("runed_obsidian"));
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("activated_obsidian"));
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("reversion_catalyst"));
		// Mystic
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("mystic_earth"));
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("mystic_media"));
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("mystic_planks"));
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("enchanted_stone"));
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("enchanted_stone_smooth"));
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("enchanted_ore"));
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("enchanted_ore_mystic"));
		// Anti
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("anti_earth"));
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("anti_media"));

		// Nightmare
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("nightmare_earth"));
		event.getRegistry().register(
				new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND))
						.setRegistryName("nightmare_media"));
		// Plants

		morel_mushroom = new BlockMorelMushroom(Block.Properties.create(Material.PLANTS, MaterialColor.RED)
				.doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT))
						.setRegistryName("morel_mushroom");
		event.getRegistry().register(morel_mushroom);

		singeri_mushroom = new BlockSingeriMushroom(Block.Properties.create(Material.PLANTS, MaterialColor.RED)
				.doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT))
						.setRegistryName("singeri_mushroom");
		event.getRegistry().register(singeri_mushroom);

		passion_flower = new BlockPassionFlower(Block.Properties.create(Material.PLANTS, MaterialColor.RED)
				.doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT))
						.setRegistryName("passion_flower");
		event.getRegistry().register(passion_flower);

		// if(world.isRemote) Basically, Makes the plants see through, similar to isFullblock thing
		if (FMLEnvironment.dist == Dist.CLIENT) {
			RenderTypeLookup.setRenderLayer(morel_mushroom, RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(singeri_mushroom, RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(passion_flower, RenderType.getCutout());

		}

	}

	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry()
				.register(new BlockItem(example_block, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("example_block"));
		event.getRegistry()
				.register(new BlockItem(runed_obsidian, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("runed_obsidian"));
		event.getRegistry()
				.register(new BlockItem(activated_obsidian, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("activated_obsidian"));
		event.getRegistry()
				.register(new BlockItem(reversion_catalyst, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("reversion_catalyst"));
		// Mystic
		event.getRegistry()
				.register(new BlockItem(enchanted_ore, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("enchanted_ore"));
		event.getRegistry()
				.register(new BlockItem(enchanted_ore_mystic, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("enchanted_ore_mystic"));
		event.getRegistry()
				.register(new BlockItem(enchanted_stone, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("enchanted_stone"));
		event.getRegistry()
				.register(new BlockItem(enchanted_stone_smooth, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("enchanted_stone_smooth"));
		event.getRegistry()
				.register(new BlockItem(mystic_earth, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("mystic_earth"));
		event.getRegistry()
				.register(new BlockItem(mystic_media, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("mystic_media"));
		event.getRegistry()
				.register(new BlockItem(mystic_planks, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("mystic_planks"));
		// Anti
		event.getRegistry().register(new BlockItem(anti_earth, new Item.Properties().group(HutosModItemGroup.instance))
				.setRegistryName("anti_earth"));
		event.getRegistry().register(new BlockItem(anti_media, new Item.Properties().group(HutosModItemGroup.instance))
				.setRegistryName("anti_media"));

		// Nightmare
		event.getRegistry()
				.register(new BlockItem(nightmare_earth, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("nightmare_earth"));
		event.getRegistry()
				.register(new BlockItem(nightmare_media, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("nightmare_media"));
		// Plants
		event.getRegistry()
				.register(new BlockItem(morel_mushroom, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("morel_mushroom"));
		event.getRegistry()
				.register(new BlockItem(singeri_mushroom, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("singeri_mushroom"));
		event.getRegistry()
				.register(new BlockItem(passion_flower, new Item.Properties().group(HutosModItemGroup.instance))
						.setRegistryName("passion_flower"));
	}

}
*/