package com.huto.forcesofreality.worldgen;

import com.huto.forcesofreality.ForcesOfReality;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

public class ModTreeDecorators {

	public static TreeDecoratorType<AkebiTreeDecorator> AKEBI;

	public static void registerConfiguredFeatures() {
		Registry<TreeDecoratorType<?>> registry = Registry.TREE_DECORATOR_TYPE;
		AKEBI = Registry.register(registry, new ResourceLocation(ForcesOfReality.MOD_ID, "akebi"), AKEBI);
	}

}
