package com.huto.forcesofreality.init;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.worldgen.AkebiTreeDecorator;

import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TreeDecoratorInit {

	public static TreeDecoratorType<AkebiTreeDecorator> AKEBI;
	public static final DeferredRegister<TreeDecoratorType<?>> TREEDECORATORS = DeferredRegister
			.create(ForgeRegistries.TREE_DECORATOR_TYPES, ForcesOfReality.MOD_ID);
	public static final RegistryObject<TreeDecoratorType<AkebiTreeDecorator>> akebi = TREEDECORATORS.register("akebi",
			() -> new TreeDecoratorType<>(AkebiTreeDecorator.field_236866_a_));

}
