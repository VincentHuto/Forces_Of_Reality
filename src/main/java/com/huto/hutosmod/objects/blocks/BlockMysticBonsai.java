package com.huto.hutosmod.objects.blocks;

import java.util.Random;

import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.objects.blocks.util.EnumBonsaiTypes;

import net.minecraft.item.ItemStack;

public class BlockMysticBonsai extends BlockBonsai {
	public BlockMysticBonsai(Properties properties, EnumBonsaiTypes type) {
		super(properties, type);
	}

	public ItemStack getShearDrop() {
		Random rand = new Random();
		return new ItemStack(ItemInit.akebi_pod.get(), rand.nextInt(4));
	}

}
