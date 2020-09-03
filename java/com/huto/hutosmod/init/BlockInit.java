package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.objects.blocks.BlockDisplayGlass;
import com.huto.hutosmod.objects.blocks.BlockMorelMushroom;
import com.huto.hutosmod.objects.blocks.BlockPassionFlower;
import com.huto.hutosmod.objects.blocks.BlockSingeriMushroom;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
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
public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			HutosMod.MOD_ID);

	// Random
	public static final RegistryObject<Block> runed_obsidian = BLOCKS.register("runed_obsidian", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(50f, 2000f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> activated_obsidian = BLOCKS.register("activated_obsidian",
			() -> new Block(
					Block.Properties.create(Material.IRON).hardnessAndResistance(50f, 2000f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> reversion_catalyst = BLOCKS.register("reversion_catalyst",
			() -> new Block(
					Block.Properties.create(Material.IRON).hardnessAndResistance(5f, 15f).sound(SoundType.ANVIL)));
	public static final RegistryObject<Block> display_glass = BLOCKS.register("display_glass",
			() -> new BlockDisplayGlass(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.1f, 1f)
					.sound(SoundType.GLASS).notSolid()));
	public static final RegistryObject<Block> nether_block = BLOCKS.register("nether_block", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	// Mystic
	public static final RegistryObject<Block> mystic_earth = BLOCKS.register("mystic_earth", () -> new Block(
			Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f, 15f).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> mystic_media = BLOCKS.register("mystic_media", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> mystic_log = BLOCKS.register("mystic_log", () -> new RotatedPillarBlock(
			Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f, 15f).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> mystic_planks = BLOCKS.register("mystic_planks", () -> new Block(
			Block.Properties.create(Material.WOOD).hardnessAndResistance(2f, 5f).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> enchanted_stone = BLOCKS.register("enchanted_stone", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(5f, 15f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> enchanted_stone_smooth = BLOCKS.register("enchanted_stone_smooth",
			() -> new Block(
					Block.Properties.create(Material.IRON).hardnessAndResistance(5f, 15f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> enchanted_ore = BLOCKS.register("enchanted_ore", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> enchanted_ore_mystic = BLOCKS.register("enchanted_ore_mystic",
			() -> new Block(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f).sound(SoundType.STONE)));

	// Anti
	public static final RegistryObject<Block> anti_earth = BLOCKS.register("anti_earth", () -> new Block(
			Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f, 15f).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> anti_log = BLOCKS.register("anti_log", () -> new RotatedPillarBlock(
			Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f, 15f).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> anti_media = BLOCKS.register("anti_media", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f).sound(SoundType.STONE)));
	// Nightmare
	public static final RegistryObject<Block> nightmare_earth = BLOCKS.register("nightmare_earth", () -> new Block(
			Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f, 15f).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> nightmare_media = BLOCKS.register("nightmare_media", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f).sound(SoundType.STONE)));

	// Plants
	public static final RegistryObject<Block> morel_mushroom = BLOCKS.register("morel_mushroom",
			() -> new BlockMorelMushroom(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()
					.zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> singeri_mushroom = BLOCKS.register("singeri_mushroom",
			() -> new BlockSingeriMushroom(Block.Properties.create(Material.PLANTS).doesNotBlockMovement()
					.tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> passion_flower = BLOCKS.register("passion_flower",
			() -> new BlockPassionFlower(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()
					.zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> mystic_sapling = BLOCKS.register("mystic_sapling",
			() -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.create(Material.PLANTS)
					.doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		// if(world.isRemote) Basically, Makes the plants see through, similar to
		// isFullblock thing
		if (FMLEnvironment.dist == Dist.CLIENT) {
			RenderTypeLookup.setRenderLayer(display_glass.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(morel_mushroom.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(singeri_mushroom.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(passion_flower.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(mystic_sapling.get(), RenderType.getCutout());

		}
	}
}
