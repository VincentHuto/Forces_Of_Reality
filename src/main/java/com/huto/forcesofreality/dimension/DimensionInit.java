package com.huto.forcesofreality.dimension;

import com.huto.forcesofreality.ForcesOfReality;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class DimensionInit {
	public static final RegistryKey<World> dreamlands = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
			new ResourceLocation(ForcesOfReality.MOD_ID, "dreamlands"));
	public static final RegistryKey<World> mining = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
			new ResourceLocation(ForcesOfReality.MOD_ID, "mining"));
}
