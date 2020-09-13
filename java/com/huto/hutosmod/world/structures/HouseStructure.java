/*package com.huto.hutosmod.world.structures;

import com.huto.hutosmod.HutosMod;
import com.mojang.serialization.Codec;

import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;

public class HouseStructure extends Structure<NoFeatureConfig> {

	public HouseStructure(Codec<NoFeatureConfig> config) {
		super(config);
	}
	
	
	@Override
	protected boolean func_230363_a_(ChunkGenerator chunkGen, BiomeProvider biomeProv, long p_230363_3_,
			SharedSeedRandom rand, int chunkX, int chunkZ, Biome biome, ChunkPos pos,
			NoFeatureConfig config) {
		
		
		return super.func_230363_a_(chunkGen, biomeProv, p_230363_3_, rand, chunkX, chunkZ, biome,
				pos, config);
	}

	
	@Override
	public IStartFactory<NoFeatureConfig> getStartFactory() {
		return HouseStructure.Start::new;
	}

	
	@Override
	public String getStructureName() {
		// TODO Auto-generated method stub
		return HutosMod.MOD_ID + ":house";
	}
}
*/