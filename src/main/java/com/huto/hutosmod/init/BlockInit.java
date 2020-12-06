package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.objects.blocks.BlockAbyssalSilt;
import com.huto.hutosmod.objects.blocks.BlockBeyondFlame;
import com.huto.hutosmod.objects.blocks.BlockChiselStation;
import com.huto.hutosmod.objects.blocks.BlockCrystalObj;
import com.huto.hutosmod.objects.blocks.BlockDisplayGlass;
import com.huto.hutosmod.objects.blocks.BlockHasturPylon;
import com.huto.hutosmod.objects.blocks.BlockIcoSphere;
import com.huto.hutosmod.objects.blocks.BlockMagicLight;
import com.huto.hutosmod.objects.blocks.BlockMagicRingLight;
import com.huto.hutosmod.objects.blocks.BlockMorelMushroom;
import com.huto.hutosmod.objects.blocks.BlockPassionFlower;
import com.huto.hutosmod.objects.blocks.BlockRuneModStation;
import com.huto.hutosmod.objects.blocks.BlockSingeriMushroom;
import com.huto.hutosmod.objects.blocks.BlockSlimeRepelent;
import com.huto.hutosmod.objects.blocks.BlockTeleporter;
import com.huto.hutosmod.objects.blocks.altars.BlockAscendentAltar;
import com.huto.hutosmod.objects.blocks.altars.BlockAuspiciousBundle;
import com.huto.hutosmod.objects.blocks.altars.BlockMachinaImperfecta;
import com.huto.hutosmod.objects.blocks.altars.BlockOccularHeap;
import com.huto.hutosmod.objects.blocks.altars.BlockSacrificePyre;
import com.huto.hutosmod.objects.blocks.altars.BlockUntoldEasel;
import com.huto.hutosmod.objects.blocks.bonsai.BlockAntiBonsai;
import com.huto.hutosmod.objects.blocks.bonsai.BlockBonsaiPlanter;
import com.huto.hutosmod.objects.blocks.bonsai.BlockJungleBonsai;
import com.huto.hutosmod.objects.blocks.bonsai.BlockMushroomBonsai;
import com.huto.hutosmod.objects.blocks.bonsai.BlockOakBonsai;
import com.huto.hutosmod.objects.blocks.bonsai.BlockSomnolentBonsai;
import com.huto.hutosmod.objects.blocks.bonsai.BlockSpruceBonsai;
import com.huto.hutosmod.objects.blocks.util.EnumBonsaiTypes;
import com.huto.hutosmod.objects.blocks.vibes.BlockAutoInscriber;
import com.huto.hutosmod.objects.blocks.vibes.BlockCapacitor;
import com.huto.hutosmod.objects.blocks.vibes.BlockKarmicAltar;
import com.huto.hutosmod.objects.blocks.vibes.BlockKarmicExtractor;
import com.huto.hutosmod.objects.blocks.vibes.BlockSomnolentHopper;
import com.huto.hutosmod.objects.blocks.vibes.BlockStorageDrum;
import com.huto.hutosmod.objects.blocks.vibes.BlockThermalInfluxer;
import com.huto.hutosmod.objects.blocks.vibes.BlockVibeAbsorber;
import com.huto.hutosmod.objects.blocks.vibes.BlockVibeAccel;
import com.huto.hutosmod.objects.blocks.vibes.BlockVibeFuser;
import com.huto.hutosmod.objects.blocks.vibes.BlockVibeGatherer;
import com.huto.hutosmod.objects.blocks.vibes.BlockVibeResonator;
import com.huto.hutosmod.objects.blocks.vibes.BlockVirtuousEnchant;
import com.huto.hutosmod.objects.blocks.vibes.BlockWandMaker;
import com.huto.hutosmod.objects.blocks.vibes.BlockWaveGatherer;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			HutosMod.MOD_ID);

	public static final RegistryObject<BlockMagicLight> light_block = BLOCKS.register("light_block",
			() -> new BlockMagicLight());
	public static final RegistryObject<BlockMagicRingLight> light_ring_block = BLOCKS.register("light_ring_block",
			() -> new BlockMagicRingLight());

	// TELEPORTEROS
	public static final RegistryObject<BlockTeleporter> teleporter = BLOCKS.register("teleporter",
			() -> new BlockTeleporter(Block.Properties.create(Material.IRON).hardnessAndResistance(50f, 2000f)
					.sound(SoundType.STONE).notSolid()));

	// Random
	public static final RegistryObject<Block> runed_obsidian = BLOCKS.register("runed_obsidian", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(50f, 2000f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> activated_obsidian = BLOCKS.register("activated_obsidian",
			() -> new Block(
					Block.Properties.create(Material.IRON).hardnessAndResistance(50f, 2000f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> nether_block = BLOCKS.register("nether_block", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> contained_magma = BLOCKS.register("contained_magma", () -> new Block(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> reversion_catalyst = BLOCKS.register("reversion_catalyst",
			() -> new Block(
					Block.Properties.create(Material.IRON).hardnessAndResistance(5f, 15f).sound(SoundType.ANVIL)));
	public static final RegistryObject<Block> display_glass = BLOCKS.register("display_glass",
			() -> new BlockDisplayGlass(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.1f, 1f)
					.sound(SoundType.GLASS).notSolid()));
	public static final RegistryObject<Block> phantasmal_glass = BLOCKS.register("phantasmal_glass",
			() -> new BlockDisplayGlass(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.1f, 1f)
					.sound(SoundType.GLASS).notSolid()));
	public static final RegistryObject<Block> mind_fog = BLOCKS.register("mind_fog", () -> new Block(
			Block.Properties.create(Material.SNOW).hardnessAndResistance(5f, 15f).sound(SoundType.CLOTH)));
	public static final RegistryObject<Block> old_iron_block = BLOCKS.register("old_iron_block",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5f, 15f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.ANVIL)));
	// Somnolent
	public static final RegistryObject<Block> somnolent_earth = BLOCKS.register("somnolent_earth",
			() -> new GrassBlock(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f, 15f)
					.harvestLevel(1).harvestTool(ToolType.SHOVEL).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> somnolent_media = BLOCKS.register("somnolent_media",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> somnolent_log = BLOCKS.register("somnolent_log",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0F)
					.harvestLevel(1).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<LeavesBlock> somnolent_leaves = BLOCKS.register("somnolent_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> somnolent_planks = BLOCKS.register("somnolent_planks",
			() -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5f, 15f).harvestLevel(1)
					.harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> somnolent_stone = BLOCKS.register("somnolent_stone",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5f, 15f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> somnolent_stone_smooth = BLOCKS.register("somnolent_stone_smooth",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5f, 15f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> somnolent_ore = BLOCKS.register("somnolent_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5f, 15f).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> somnolent_ore_somnolent = BLOCKS.register("somnolent_ore_somnolent",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5f, 15f).harvestLevel(3)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	// Anti
	public static final RegistryObject<Block> anti_earth = BLOCKS.register("anti_earth",
			() -> new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f, 15f).harvestLevel(1)
					.harvestTool(ToolType.SHOVEL).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> anti_log = BLOCKS.register("anti_log",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f)
					.harvestLevel(1).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<LeavesBlock> anti_leaves = BLOCKS.register("anti_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	public static final RegistryObject<Block> anti_planks = BLOCKS.register("anti_planks",
			() -> new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5f, 15f).harvestLevel(1)
					.harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
	public static final RegistryObject<Block> anti_media = BLOCKS.register("anti_media",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	// Nightmare
	public static final RegistryObject<Block> nightmare_earth = BLOCKS.register("nightmare_earth",
			() -> new Block(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.5f, 15f).harvestLevel(1)
					.harvestTool(ToolType.SHOVEL).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> nightmare_media = BLOCKS.register("nightmare_media",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	// Hastur
	public static final RegistryObject<Block> hastur_pylon = BLOCKS.register("hastur_pylon",
			() -> new BlockHasturPylon(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f)
					.harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE).notSolid()));
	public static final RegistryObject<Block> hastur_stone_core = BLOCKS.register("hastur_stone_core",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> hastur_stone = BLOCKS.register("hastur_stone",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> hastur_stone_smooth = BLOCKS.register("hastur_stone_smooth",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

	public static final RegistryObject<Block> untold_easel = BLOCKS.register("untold_easel",
			() -> new BlockUntoldEasel(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.7f, 15f)
					.harvestLevel(1).harvestTool(ToolType.PICKAXE).sound(SoundType.WOOD).notSolid()));
	// Seraph
	public static final RegistryObject<Block> gilded_wool = BLOCKS.register("gilded_wool",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.7f, 15f).harvestLevel(1)
					.harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ascendent_altar = BLOCKS.register("ascendent_altar",
			() -> new BlockAscendentAltar(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	// Eldritch
	public static final RegistryObject<Block> occular_heap = BLOCKS.register("occular_heap", () -> new BlockOccularHeap(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> abyssal_silt = BLOCKS.register("abyssal_silt",
			() -> new BlockAbyssalSilt(Block.Properties.from(Blocks.SAND)));
	public static final RegistryObject<Block> beyond_flames = BLOCKS.register("beyond_flames",
			() -> new BlockBeyondFlame(Block.Properties.from(Blocks.FIRE), 1.5f));

	// Beast
	public static final RegistryObject<Block> auspicious_bundle = BLOCKS.register("auspicious_bundle",
			() -> new BlockAuspiciousBundle(Block.Properties.create(Material.WOOD).hardnessAndResistance(50f, 1500f)
					.sound(SoundType.WOOD).notSolid()));
	public static final RegistryObject<Block> sacrificial_pyre = BLOCKS.register("sacrificial_pyre",
			() -> new BlockSacrificePyre(Block.Properties.create(Material.WOOD).hardnessAndResistance(50f, 1500f)
					.sound(SoundType.WOOD).notSolid()));

	// Machine
	public static final RegistryObject<Block> auric_block = BLOCKS.register("auric_block", () -> new Block(
			Block.Properties.create(Material.IRON).hardnessAndResistance(50f, 2000f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> machine_glass = BLOCKS.register("machine_glass",
			() -> new BlockDisplayGlass(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.1f, 1f)
					.sound(SoundType.GLASS).notSolid()));
	public static final RegistryObject<Block> machina_imperfecta = BLOCKS.register("machina_imperfecta",
			() -> new BlockMachinaImperfecta(Block.Properties.create(Material.IRON).hardnessAndResistance(50f, 1500f)
					.sound(SoundType.ANVIL).notSolid()));

	// Plants
	// Bonsais
	public static final RegistryObject<Block> bonsai_planter = BLOCKS.register("bonsai_planter",
			() -> new BlockBonsaiPlanter(Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f)
					.sound(SoundType.STONE).notSolid()));
	// Somnolent
	public static final RegistryObject<Block> somnolent_bonsai_stage_1 = BLOCKS.register("somnolent_bonsai_stage_1",
			() -> new BlockSomnolentBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.MYSTIC, 1));
	public static final RegistryObject<Block> somnolent_bonsai_stage_2 = BLOCKS.register("somnolent_bonsai_stage_2",
			() -> new BlockSomnolentBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.MYSTIC, 2));
	public static final RegistryObject<Block> somnolent_bonsai_stage_3 = BLOCKS.register("somnolent_bonsai_stage_3",
			() -> new BlockSomnolentBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.MYSTIC, 3));
	// Anti
	public static final RegistryObject<Block> anti_bonsai_stage_1 = BLOCKS.register("anti_bonsai_stage_1",
			() -> new BlockAntiBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.ANTI, 1));
	public static final RegistryObject<Block> anti_bonsai_stage_2 = BLOCKS.register("anti_bonsai_stage_2",
			() -> new BlockAntiBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.ANTI, 2));
	public static final RegistryObject<Block> anti_bonsai_stage_3 = BLOCKS.register("anti_bonsai_stage_3",
			() -> new BlockAntiBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.ANTI, 3));
	// Mushroom
	public static final RegistryObject<Block> mushroom_bonsai_stage_1 = BLOCKS
			.register("mushroom_bonsai_stage_1",
					() -> new BlockMushroomBonsai(Block.Properties.create(Material.ROCK)
							.hardnessAndResistance(50f, 1500f).sound(SoundType.STONE).notSolid(),
							EnumBonsaiTypes.MUSHROOM, 1));
	public static final RegistryObject<Block> mushroom_bonsai_stage_2 = BLOCKS
			.register("mushroom_bonsai_stage_2",
					() -> new BlockMushroomBonsai(Block.Properties.create(Material.ROCK)
							.hardnessAndResistance(50f, 1500f).sound(SoundType.STONE).notSolid(),
							EnumBonsaiTypes.MUSHROOM, 2));
	public static final RegistryObject<Block> mushroom_bonsai_stage_3 = BLOCKS
			.register("mushroom_bonsai_stage_3",
					() -> new BlockMushroomBonsai(Block.Properties.create(Material.ROCK)
							.hardnessAndResistance(50f, 1500f).sound(SoundType.STONE).notSolid(),
							EnumBonsaiTypes.MUSHROOM, 3));
	// Oak
	public static final RegistryObject<Block> oak_bonsai_stage_1 = BLOCKS.register("oak_bonsai_stage_1",
			() -> new BlockOakBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.OAK, 1));
	public static final RegistryObject<Block> oak_bonsai_stage_2 = BLOCKS.register("oak_bonsai_stage_2",
			() -> new BlockOakBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.OAK, 2));
	public static final RegistryObject<Block> oak_bonsai_stage_3 = BLOCKS.register("oak_bonsai_stage_3",
			() -> new BlockOakBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.OAK, 3));
	// Spruce
	public static final RegistryObject<Block> spruce_bonsai_stage_1 = BLOCKS.register("spruce_bonsai_stage_1",
			() -> new BlockSpruceBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.SPRUCE, 1));
	public static final RegistryObject<Block> spruce_bonsai_stage_2 = BLOCKS.register("spruce_bonsai_stage_2",
			() -> new BlockSpruceBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.SPRUCE, 2));
	public static final RegistryObject<Block> spruce_bonsai_stage_3 = BLOCKS.register("spruce_bonsai_stage_3",
			() -> new BlockSpruceBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.SPRUCE, 3));
	// Jungle
	public static final RegistryObject<Block> jungle_bonsai_stage_1 = BLOCKS.register("jungle_bonsai_stage_1",
			() -> new BlockJungleBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.JUNGLE, 1));
	public static final RegistryObject<Block> jungle_bonsai_stage_2 = BLOCKS.register("jungle_bonsai_stage_2",
			() -> new BlockJungleBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.JUNGLE, 2));
	public static final RegistryObject<Block> jungle_bonsai_stage_3 = BLOCKS.register("jungle_bonsai_stage_3",
			() -> new BlockJungleBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(10f, 1500f)
					.sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.JUNGLE, 3));

	// Misc
	public static final RegistryObject<Block> somnolent_grass = BLOCKS.register("somnolent_grass",
			() -> new TallGrassBlock(Block.Properties.from(Blocks.GRASS)));
	public static final RegistryObject<Block> morel_mushroom = BLOCKS.register("morel_mushroom",
			() -> new BlockMorelMushroom(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()
					.zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> morel_cap = BLOCKS.register("morel_cap", () -> new Block(
			Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5f, 15f).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> morel_stem = BLOCKS.register("morel_stem", () -> new Block(
			Block.Properties.create(Material.PLANTS).hardnessAndResistance(0.5f, 15f).sound(SoundType.PLANT)));
	public static final RegistryObject<Block> singeri_mushroom = BLOCKS.register("singeri_mushroom",
			() -> new BlockSingeriMushroom(Block.Properties.create(Material.PLANTS).doesNotBlockMovement()
					.tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> passion_flower = BLOCKS.register("passion_flower",
			() -> new BlockPassionFlower(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly()
					.zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> somnolent_sapling = BLOCKS.register("somnolent_sapling",
			() -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.create(Material.PLANTS)
					.doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));
	public static final RegistryObject<Block> anti_sapling = BLOCKS.register("anti_sapling",
			() -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.create(Material.PLANTS)
					.doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.PLANT)));

	// Tiles
	public static final RegistryObject<Block> wand_maker = BLOCKS.register("wand_maker", () -> new BlockWandMaker(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> vibe_resonator = BLOCKS.register("vibe_resonator",
			() -> new BlockVibeResonator(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> wave_gatherer = BLOCKS.register("wave_gatherer",
			() -> new BlockWaveGatherer(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> vibe_gatherer = BLOCKS.register("vibe_gatherer",
			() -> new BlockVibeGatherer(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> karmic_altar = BLOCKS.register("karmic_altar", () -> new BlockKarmicAltar(
			Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> virtuous_enchanter = BLOCKS.register("virtuous_enchanter",
			() -> new BlockVirtuousEnchant(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> karmic_extractor = BLOCKS.register("karmic_extractor",
			() -> new BlockKarmicExtractor(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> vibratory_fuser = BLOCKS.register("vibratory_fuser",
			() -> new BlockVibeFuser(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> vibe_absorber = BLOCKS.register("vibe_absorber",
			() -> new BlockVibeAbsorber(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> vibratory_accelerometer = BLOCKS.register("vibratory_accelerometer",
			() -> new BlockVibeAccel(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> thermal_influxer = BLOCKS.register("thermal_influxer",
			() -> new BlockThermalInfluxer(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> auto_inscriber = BLOCKS.register("auto_inscriber",
			() -> new BlockAutoInscriber(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> somnolent_hopper = BLOCKS.register("somnolent_hopper",
			() -> new BlockSomnolentHopper(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	

	// Storage
	public static final RegistryObject<Block> vibratory_storage_drum = BLOCKS.register("vibratory_storage_drum",
			() -> new BlockStorageDrum(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> vibratory_capacitor = BLOCKS.register("vibratory_capacitor",
			() -> new BlockCapacitor(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	// Misc
	public static final RegistryObject<Block> runic_chisel_station = BLOCKS.register("runic_chisel_station",
			() -> new BlockChiselStation(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> rune_mod_station = BLOCKS.register("rune_mod_station",
			() -> new BlockRuneModStation(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> slime_repelent = BLOCKS.register("slime_repelent",
			() -> new BlockSlimeRepelent(
					Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f).sound(SoundType.STONE)));

	// OBJ
	public static final RegistryObject<Block> obj_icosahedron = BLOCKS.register("obj_icosahedron",
			() -> new BlockIcoSphere(Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f)
					.sound(SoundType.STONE).notSolid()));
	public static final RegistryObject<Block> end_crystal_somnolent = BLOCKS.register("end_crystal_somnolent",
			() -> new BlockCrystalObj(Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f)
					.sound(SoundType.STONE).notSolid()));
	public static final RegistryObject<Block> end_crystal_nightmare = BLOCKS.register("end_crystal_nightmare",
			() -> new BlockCrystalObj(Block.Properties.create(Material.ROCK).hardnessAndResistance(50f, 1500f)
					.sound(SoundType.STONE).notSolid()));

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		if (FMLEnvironment.dist == Dist.CLIENT) {
			RenderTypeLookup.setRenderLayer(BlockInit.phantasmal_glass.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(BlockInit.display_glass.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.mind_fog.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(BlockInit.morel_mushroom.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.singeri_mushroom.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.passion_flower.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.somnolent_sapling.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.anti_sapling.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.wand_maker.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.somnolent_leaves.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.vibe_gatherer.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.anti_leaves.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.obj_icosahedron.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.end_crystal_somnolent.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.end_crystal_nightmare.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.somnolent_grass.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.sacrificial_pyre.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.auspicious_bundle.get(), RenderType.getCutout());
			RenderTypeLookup.setRenderLayer(BlockInit.machina_imperfecta.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(BlockInit.machine_glass.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(BlockInit.occular_heap.get(), RenderType.getTranslucent());
			RenderTypeLookup.setRenderLayer(BlockInit.untold_easel.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.bonsai_planter.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.teleporter.get(), RenderType.getCutoutMipped());

			
			RenderTypeLookup.setRenderLayer(BlockInit.anti_bonsai_stage_1.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.mushroom_bonsai_stage_1.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.somnolent_bonsai_stage_1.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.oak_bonsai_stage_1.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.jungle_bonsai_stage_1.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.spruce_bonsai_stage_1.get(), RenderType.getCutoutMipped());

			RenderTypeLookup.setRenderLayer(BlockInit.anti_bonsai_stage_2.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.mushroom_bonsai_stage_2.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.somnolent_bonsai_stage_2.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.oak_bonsai_stage_2.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.jungle_bonsai_stage_2.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.spruce_bonsai_stage_2.get(), RenderType.getCutoutMipped());

			RenderTypeLookup.setRenderLayer(BlockInit.anti_bonsai_stage_3.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.mushroom_bonsai_stage_3.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.somnolent_bonsai_stage_3.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.oak_bonsai_stage_3.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.jungle_bonsai_stage_3.get(), RenderType.getCutoutMipped());
			RenderTypeLookup.setRenderLayer(BlockInit.spruce_bonsai_stage_3.get(), RenderType.getCutoutMipped());

			RenderTypeLookup.setRenderLayer(BlockInit.beyond_flames.get(), RenderType.getTranslucent());

		}
	}

}
