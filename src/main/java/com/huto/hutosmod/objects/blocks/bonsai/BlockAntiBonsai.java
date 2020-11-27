package com.huto.hutosmod.objects.blocks.bonsai;

import com.huto.hutosmod.objects.blocks.util.EnumBonsaiTypes;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class BlockAntiBonsai extends BlockBonsai {
	public BlockAntiBonsai(Properties properties, EnumBonsaiTypes type, int stage) {
		super(properties, type, stage);
	}

	@Override
	public Item getShearDrop() {
		return Items.APPLE;
	}

}
