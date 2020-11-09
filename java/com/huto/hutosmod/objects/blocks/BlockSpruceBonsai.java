package com.huto.hutosmod.objects.blocks;

import java.util.Random;

import com.huto.hutosmod.objects.blocks.util.EnumBonsaiTypes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class BlockSpruceBonsai extends BlockBonsai {
	public BlockSpruceBonsai(Properties properties, EnumBonsaiTypes type) {
		super(properties, type);
	}

	public ItemStack getShearDrop() {
		Random rand = new Random();
		return new ItemStack(Items.SNOWBALL, rand.nextInt(4));
	}

}
