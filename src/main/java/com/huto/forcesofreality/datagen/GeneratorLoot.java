package com.huto.forcesofreality.datagen;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.init.BlockInit;
import com.mojang.datafixers.util.Pair;

import net.minecraft.world.level.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class GeneratorLoot extends LootTableProvider {
	public GeneratorLoot(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}

	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
		return ImmutableList.of(Pair.of(Blocks::new, LootContextParamSets.BLOCK));
	}

	private static class Blocks extends BlockLoot {
		@Override
		protected void addTables() {

			for (RegistryObject<Block> b : BlockInit.BLOCKS.getEntries()) {
				this.registerDropSelfLootTable(b.get());

			}
		}
		   @Override
	        protected Iterable<Block> getKnownBlocks() {
	            return ForgeRegistries.BLOCKS.getValues().stream()
	                    .filter(b -> b.getRegistryName().getNamespace().equals(ForcesOfReality.MOD_ID))
	                    .collect(Collectors.toList());
	        }
		
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
		map.forEach((name, table) -> LootTableManager.validateLootTable(validationtracker, name, table));
	}
}