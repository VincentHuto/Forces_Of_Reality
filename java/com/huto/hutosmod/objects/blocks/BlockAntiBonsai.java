package com.huto.hutosmod.objects.blocks;

import java.util.Random;

import com.huto.hutosmod.objects.blocks.util.EnumBonsaiTypes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class BlockAntiBonsai extends BlockBonsai {
	public BlockAntiBonsai(Properties properties, EnumBonsaiTypes type) {
		super(properties, type);
	}

	public ItemStack getShearDrop() {
		Random rand = new Random();
		return new ItemStack(Items.APPLE, rand.nextInt(4));
	}

}
