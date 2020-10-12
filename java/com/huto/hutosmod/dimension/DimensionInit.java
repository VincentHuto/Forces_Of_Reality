package com.huto.hutosmod.dimension;

import com.huto.hutosmod.HutosMod;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class DimensionInit {

	public static final RegistryKey<World> MINING_DIMENSION = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
			new ResourceLocation(HutosMod.MOD_ID, "mining"));
	
	public static final RegistryKey<World> dreamlands = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
			new ResourceLocation(HutosMod.MOD_ID, "dreamlands"));
	
}
