package com.huto.hutosmod.objects.blocks;

import com.huto.hutosmod.objects.blocks.util.EnumBonsaiTypes;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class BlockJungleBonsai extends BlockBonsai {
	public BlockJungleBonsai(Properties properties, EnumBonsaiTypes type,int stage) {
		super(properties, type,stage);
	}

	@Override
	public Item getShearDrop() {
		return Items.COCOA_BEANS;
	}


}
