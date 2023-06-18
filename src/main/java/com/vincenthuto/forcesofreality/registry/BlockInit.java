package com.vincenthuto.forcesofreality.registry;

import java.util.Collection;
import java.util.stream.Stream;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.block.BlockAbyssalSilt;
import com.vincenthuto.forcesofreality.common.block.BlockAdornmentModStation;
import com.vincenthuto.forcesofreality.common.block.BlockBeyondFlame;
import com.vincenthuto.forcesofreality.common.block.BlockHasturPylon;
import com.vincenthuto.forcesofreality.common.block.BlockRafflesiaFlower;
import com.vincenthuto.forcesofreality.common.block.altar.BlockAscendantAltar;
import com.vincenthuto.forcesofreality.common.block.altar.BlockAuspiciousBundle;
import com.vincenthuto.forcesofreality.common.block.altar.BlockHunterEffigy;
import com.vincenthuto.forcesofreality.common.block.altar.BlockMachinaImperfecta;
import com.vincenthuto.forcesofreality.common.block.altar.BlockOccularHeap;
import com.vincenthuto.forcesofreality.common.block.altar.BlockSacrificePyre;
import com.vincenthuto.forcesofreality.common.block.altar.BlockUntoldEasel;
import com.vincenthuto.forcesofreality.common.block.bonsai.BlockBonsaiPlanter;
import com.vincenthuto.forcesofreality.common.block.bonsai.BlockJungleBonsai;
import com.vincenthuto.forcesofreality.common.block.bonsai.BlockMushroomBonsai;
import com.vincenthuto.forcesofreality.common.block.bonsai.BlockOakBonsai;
import com.vincenthuto.forcesofreality.common.block.bonsai.BlockSpruceBonsai;
import com.vincenthuto.forcesofreality.common.block.util.EnumBonsaiTypes;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			ForcesOfReality.MOD_ID);
	public static final DeferredRegister<Block> SPECIALBLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			ForcesOfReality.MOD_ID);

	// Random
	public static final RegistryObject<Block> anointed_iron_block = BLOCKS.register("anointed_iron_block",
			() -> new Block(Block.Properties.of().strength(5f, 15f).sound(SoundType.ANVIL)));
	// Hastur
	public static final RegistryObject<Block> hastur_pylon = BLOCKS.register("hastur_pylon", () -> new BlockHasturPylon(
			Block.Properties.of().strength(0.7f, 15f).sound(SoundType.STONE).noOcclusion()));
	public static final RegistryObject<Block> hastur_stone_core = BLOCKS.register("hastur_stone_core",
			() -> new Block(Block.Properties.of().strength(0.7f, 15f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> hastur_stone = BLOCKS.register("hastur_stone",
			() -> new Block(Block.Properties.of().strength(0.7f, 15f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> hastur_stone_smooth = BLOCKS.register("hastur_stone_smooth",
			() -> new Block(Block.Properties.of().strength(0.7f, 15f).sound(SoundType.STONE)));

	public static final RegistryObject<Block> untold_easel = BLOCKS.register("untold_easel", () -> new BlockUntoldEasel(
			Block.Properties.of().strength(0.7f, 15f).sound(SoundType.WOOD).noOcclusion()));
	// Seraph
	public static final RegistryObject<Block> gilded_wool = BLOCKS.register("gilded_wool",
			() -> new Block(Block.Properties.of().strength(0.7f, 15f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> ascendant_altar = BLOCKS.register("ascendant_altar",
			() -> new BlockAscendantAltar(
					Block.Properties.of().strength(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> anointing_focus = BLOCKS.register("anointing_focus",
			() -> new Block(Block.Properties.of().strength(0.7f, 15f).sound(SoundType.STONE)));

	// Eldritch
	public static final RegistryObject<Block> occular_heap = BLOCKS.register("occular_heap", () -> new BlockOccularHeap(
			Block.Properties.of().strength(50f, 1500f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> abyssal_silt = BLOCKS.register("abyssal_silt",
			() -> new BlockAbyssalSilt(Block.Properties.copy(Blocks.SAND)));
	public static final RegistryObject<Block> beyond_flames = BLOCKS.register("beyond_flames",
			() -> new BlockBeyondFlame(Block.Properties.copy(Blocks.FIRE), 1.5f));

	// Beast
	public static final RegistryObject<Block> auspicious_bundle = BLOCKS.register("auspicious_bundle",
			() -> new BlockAuspiciousBundle(
					Block.Properties.of().strength(50f, 1500f).sound(SoundType.WOOD).noOcclusion()));
	public static final RegistryObject<Block> sacrificial_pyre = BLOCKS.register("sacrificial_pyre",
			() -> new BlockSacrificePyre(
					Block.Properties.of().strength(50f, 1500f).sound(SoundType.WOOD).noOcclusion()));

	public static final RegistryObject<Block> hunter_effigy = BLOCKS.register("hunter_effigy",
			() -> new BlockHunterEffigy(
					Block.Properties.of().strength(50f, 1500f).sound(SoundType.STONE).noOcclusion()));

	// Machine
	public static final RegistryObject<Block> auric_block = BLOCKS.register("auric_block",
			() -> new Block(Block.Properties.of().strength(50f, 2000f).sound(SoundType.STONE)));
	public static final RegistryObject<Block> machine_glass = BLOCKS.register("machine_glass", () -> new GlassBlock(
			Block.Properties.of().strength(0.1f, 1f).sound(SoundType.GLASS).noOcclusion()));
	public static final RegistryObject<Block> machina_imperfecta = BLOCKS.register("machina_imperfecta",
			() -> new BlockMachinaImperfecta(
					Block.Properties.of().strength(50f, 1500f).sound(SoundType.ANVIL).noOcclusion()));

	// Bonsais
	public static final RegistryObject<Block> bonsai_planter = BLOCKS.register("bonsai_planter",
			() -> new BlockBonsaiPlanter(
					Block.Properties.of().strength(50f, 1500f).sound(SoundType.STONE).noOcclusion()));
	/*
	 * // Somnolent public static final RegistryObject<Block>
	 * somnolent_bonsai_stage_1 = BLOCKS .register("somnolent_bonsai_stage_1", () ->
	 * new BlockSomnolentBonsai(Block.Properties.create(Material.ROCK)
	 * .hardnessAndResistance(10f, 1500f).sound(SoundType.STONE).notSolid(),
	 * EnumBonsaiTypes.MYSTIC, 1)); public static final RegistryObject<Block>
	 * somnolent_bonsai_stage_2 = BLOCKS .register("somnolent_bonsai_stage_2", () ->
	 * new BlockSomnolentBonsai(Block.Properties.create(Material.ROCK)
	 * .hardnessAndResistance(10f, 1500f).sound(SoundType.STONE).notSolid(),
	 * EnumBonsaiTypes.MYSTIC, 2)); public static final RegistryObject<Block>
	 * somnolent_bonsai_stage_3 = BLOCKS .register("somnolent_bonsai_stage_3", () ->
	 * new BlockSomnolentBonsai(Block.Properties.create(Material.ROCK)
	 * .hardnessAndResistance(10f, 1500f).sound(SoundType.STONE).notSolid(),
	 * EnumBonsaiTypes.MYSTIC, 3)); // Anti public static final
	 * RegistryObject<Block> anti_bonsai_stage_1 =
	 * BLOCKS.register("anti_bonsai_stage_1", () -> new
	 * BlockAntiBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(
	 * 10f, 1500f) .sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.ANTI, 1));
	 * public static final RegistryObject<Block> anti_bonsai_stage_2 =
	 * BLOCKS.register("anti_bonsai_stage_2", () -> new
	 * BlockAntiBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(
	 * 10f, 1500f) .sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.ANTI, 2));
	 * public static final RegistryObject<Block> anti_bonsai_stage_3 =
	 * BLOCKS.register("anti_bonsai_stage_3", () -> new
	 * BlockAntiBonsai(Block.Properties.create(Material.ROCK).hardnessAndResistance(
	 * 10f, 1500f) .sound(SoundType.STONE).notSolid(), EnumBonsaiTypes.ANTI, 3));
	 */
	// Mushroom
	public static final RegistryObject<Block> mushroom_bonsai_stage_1 = BLOCKS.register("mushroom_bonsai_stage_1",
			() -> new BlockMushroomBonsai(
					Block.Properties.of().strength(50f, 1500f).sound(SoundType.STONE).noOcclusion(),
					EnumBonsaiTypes.MUSHROOM, 1));
	public static final RegistryObject<Block> mushroom_bonsai_stage_2 = BLOCKS.register("mushroom_bonsai_stage_2",
			() -> new BlockMushroomBonsai(
					Block.Properties.of().strength(50f, 1500f).sound(SoundType.STONE).noOcclusion(),
					EnumBonsaiTypes.MUSHROOM, 2));
	public static final RegistryObject<Block> mushroom_bonsai_stage_3 = BLOCKS.register("mushroom_bonsai_stage_3",
			() -> new BlockMushroomBonsai(
					Block.Properties.of().strength(50f, 1500f).sound(SoundType.STONE).noOcclusion(),
					EnumBonsaiTypes.MUSHROOM, 3));
	// Oak
	public static final RegistryObject<Block> oak_bonsai_stage_1 = BLOCKS.register("oak_bonsai_stage_1",
			() -> new BlockOakBonsai(
					Block.Properties.of().strength(10f, 1500f).sound(SoundType.STONE).noOcclusion(),
					EnumBonsaiTypes.OAK, 1));
	public static final RegistryObject<Block> oak_bonsai_stage_2 = BLOCKS.register("oak_bonsai_stage_2",
			() -> new BlockOakBonsai(
					Block.Properties.of().strength(10f, 1500f).sound(SoundType.STONE).noOcclusion(),
					EnumBonsaiTypes.OAK, 2));
	public static final RegistryObject<Block> oak_bonsai_stage_3 = BLOCKS.register("oak_bonsai_stage_3",
			() -> new BlockOakBonsai(
					Block.Properties.of().strength(10f, 1500f).sound(SoundType.STONE).noOcclusion(),
					EnumBonsaiTypes.OAK, 3));
	// Spruce
	public static final RegistryObject<Block> spruce_bonsai_stage_1 = BLOCKS.register("spruce_bonsai_stage_1",
			() -> new BlockSpruceBonsai(
					Block.Properties.of().strength(10f, 1500f).sound(SoundType.STONE).noOcclusion(),
					EnumBonsaiTypes.SPRUCE, 1));
	public static final RegistryObject<Block> spruce_bonsai_stage_2 = BLOCKS.register("spruce_bonsai_stage_2",
			() -> new BlockSpruceBonsai(
					Block.Properties.of().strength(10f, 1500f).sound(SoundType.STONE).noOcclusion(),
					EnumBonsaiTypes.SPRUCE, 2));
	public static final RegistryObject<Block> spruce_bonsai_stage_3 = BLOCKS.register("spruce_bonsai_stage_3",
			() -> new BlockSpruceBonsai(
					Block.Properties.of().strength(10f, 1500f).sound(SoundType.STONE).noOcclusion(),
					EnumBonsaiTypes.SPRUCE, 3));
	// Jungle
	public static final RegistryObject<Block> jungle_bonsai_stage_1 = BLOCKS.register("jungle_bonsai_stage_1",
			() -> new BlockJungleBonsai(
					Block.Properties.of().strength(10f, 1500f).sound(SoundType.STONE).noOcclusion(),
					EnumBonsaiTypes.JUNGLE, 1));
	public static final RegistryObject<Block> jungle_bonsai_stage_2 = BLOCKS.register("jungle_bonsai_stage_2",
			() -> new BlockJungleBonsai(
					Block.Properties.of().strength(10f, 1500f).sound(SoundType.STONE).noOcclusion(),
					EnumBonsaiTypes.JUNGLE, 2));
	public static final RegistryObject<Block> jungle_bonsai_stage_3 = BLOCKS.register("jungle_bonsai_stage_3",
			() -> new BlockJungleBonsai(
					Block.Properties.of().strength(10f, 1500f).sound(SoundType.STONE).noOcclusion(),
					EnumBonsaiTypes.JUNGLE, 3));

	// Misc
	public static final RegistryObject<Block> rafflesia_flower = BLOCKS.register("rafflesia_flower",
			() -> new BlockRafflesiaFlower(Block.Properties.of().noCollission().randomTicks().instabreak()
					.sound(SoundType.GRASS)));

	// Tiles

	public static final RegistryObject<Block> rafflesia_of_fidelity = BLOCKS.register("rafflesia_of_fidelity",
			() -> new BlockRafflesiaFlower(
					Block.Properties.of().strength(50f, 1500f).sound(SoundType.STONE)));
	// Misc
	public static final RegistryObject<Block> self_reflection_station = BLOCKS.register("self_reflection_station",
			() -> new BlockAdornmentModStation(
					Block.Properties.of().strength(50f, 1500f).sound(SoundType.STONE)));

	public static Stream<RegistryObject<Block>> getAllBlockEntriesAsStream() {

		Stream<RegistryObject<Block>> combinedStream = Stream.of(BLOCKS.getEntries(), SPECIALBLOCKS.getEntries())
				.flatMap(Collection::stream);

		return combinedStream;
	}

}
