package com.huto.hutosmod.objects.blocks;

import java.util.Random;

import com.huto.hutosmod.init.BlockInit;
import com.huto.hutosmod.objects.blocks.util.EnumBonsaiTypes;

import net.minecraft.item.ItemStack;

public class BlockMushroomBonsai extends BlockBonsai {
	public BlockMushroomBonsai(Properties properties, EnumBonsaiTypes type) {
		super(properties, type);
	}

	public ItemStack getShearDrop() {
		Random rand = new Random();
		return rand.nextBoolean() ? new ItemStack(BlockInit.morel_mushroom.get(), rand.nextInt(4))
				: new ItemStack(BlockInit.singeri_mushroom.get(), rand.nextInt(4));
	}

}
