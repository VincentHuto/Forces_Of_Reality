package com.huto.forces_of_reality.objects.blocks.bonsai;

import com.huto.forces_of_reality.objects.blocks.util.EnumBonsaiTypes;

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
