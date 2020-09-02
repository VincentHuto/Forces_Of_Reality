package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD)
public class BlockInitNew {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			HutosMod.MOD_ID);

	// Random
	public static final RegistryObject<Block> example_block = BLOCKS.register("example_block", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> runed_obsidian = BLOCKS.register("runed_obsidian", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> activated_obsidian = BLOCKS.register("activated_obsidian",
			() -> new Block(
					Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> reversion_catalyst = BLOCKS.register("reversion_catalyst",
			() -> new Block(
					Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> display_glass = BLOCKS.register("display_glass", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));

	// Mystic
	public static final RegistryObject<Block> mystic_earth = BLOCKS.register("mystic_earth", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> mystic_media = BLOCKS.register("mystic_media", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> mystic_planks = BLOCKS.register("mystic_planks", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> enchanted_stone = BLOCKS.register("enchanted_stone", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> enchanted_stone_smooth = BLOCKS.register("enchanted_stone_smooth",
			() -> new Block(
					Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> enchanted_ore = BLOCKS.register("enchanted_ore", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> enchanted_ore_mystic = BLOCKS.register("enchanted_ore_mystic",
			() -> new Block(
					Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));

	// Anti
	public static final RegistryObject<Block> anti_earth = BLOCKS.register("anti_earth", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> anti_media = BLOCKS.register("anti_media", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	// Nightmare
	public static final RegistryObject<Block> nightmare_earth = BLOCKS.register("nightmare_earth", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> nightmare_media = BLOCKS.register("nightmare_media", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));

	// Plants
	public static final RegistryObject<Block> morel_mushroom = BLOCKS.register("morel_mushroom", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> singeri_mushroom = BLOCKS.register("singeri_mushroom", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));
	public static final RegistryObject<Block> passion_flower = BLOCKS.register("passion_flower", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(0.7f, 15f).sound(SoundType.SAND)));

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		// if(world.isRemote) Basically, Makes the plants see through, similar to
		// isFullblock thing
		if (FMLEnvironment.dist == Dist.CLIENT) {
			RenderTypeLookup.setRenderLayer(morel_mushroom.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(singeri_mushroom.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(passion_flower.get(), RenderType.getCutout());

		}
	}
}
