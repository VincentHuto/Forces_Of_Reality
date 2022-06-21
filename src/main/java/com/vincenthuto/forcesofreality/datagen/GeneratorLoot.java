//package com.vincenthuto.forcesofreality.datagen;
//
//import java.util.List;
//import java.util.Map;
//import java.util.function.BiConsumer;
//import java.util.function.Consumer;
//import java.util.function.Supplier;
//import java.util.stream.Collectors;
//
//import com.google.common.collect.ImmutableList;
//import com.mojang.datafixers.util.Pair;
//import com.vincenthuto.forcesofreality.ForcesOfReality;
//import com.vincenthuto.forcesofreality.init.BlockInit;
//
//import net.minecraft.data.DataGenerator;
//import net.minecraft.data.loot.BlockLoot;
//import net.minecraft.data.loot.LootTableProvider;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.storage.loot.LootTable;
//import net.minecraft.world.level.storage.loot.LootTables;
//import net.minecraft.world.level.storage.loot.ValidationContext;
//import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
//import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
//import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegistryObject;
//
//public class GeneratorLoot extends LootTableProvider {
//	public GeneratorLoot(DataGenerator dataGeneratorIn) {
//		super(dataGeneratorIn);
//	}
//
//	@Override
//	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
//		return ImmutableList.of(Pair.of(Blocks::new, LootContextParamSets.BLOCK));
//	}
//
//	private static class Blocks extends BlockLoot {
//		@Override
//		protected void addTables() {
//
//			for (RegistryObject<Block> b : BlockInit.BLOCKS.getEntries()) {
//				this.dropSelf(b.get());
//
//			}
//		}
//
//		@Override
//		protected Iterable<Block> getKnownBlocks() {
//			return ForgeRegistries.BLOCKS.getValues().stream()
//					.filter(b -> b.getRegistryName().getNamespace().equals(ForcesOfReality.MOD_ID))
//					.collect(Collectors.toList());
//		}
//
//	}
//
//	@Override
//	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
//		map.forEach((name, table) -> LootTables.validate(validationtracker, name, table));
//	}
//}