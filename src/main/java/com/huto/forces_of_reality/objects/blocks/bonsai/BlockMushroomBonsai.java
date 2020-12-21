package com.huto.forces_of_reality.objects.blocks.bonsai;

import com.huto.forces_of_reality.init.BlockInit;
import com.huto.forces_of_reality.objects.blocks.util.EnumBonsaiTypes;

import net.minecraft.item.Item;

public class BlockMushroomBonsai extends BlockBonsai {
	public BlockMushroomBonsai(Properties properties, EnumBonsaiTypes type, int stage) {
		super(properties, type, stage);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Item getShearDrop() {
		return Item.getItemFromBlock(BlockInit.morel_mushroom.get());
	}

}
