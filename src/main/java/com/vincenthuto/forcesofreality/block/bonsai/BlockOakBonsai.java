package com.vincenthuto.forcesofreality.block.bonsai;

import com.vincenthuto.forcesofreality.block.util.EnumBonsaiTypes;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class BlockOakBonsai extends BlockBonsai {
	public BlockOakBonsai(Properties properties, EnumBonsaiTypes type, int stage) {
		super(properties, type, stage);
	}

	@Override
	public Item getShearDrop() {
		return Items.APPLE;
	}

}
