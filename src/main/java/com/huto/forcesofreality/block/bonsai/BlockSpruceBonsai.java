package com.huto.forcesofreality.block.bonsai;

import com.huto.forcesofreality.block.util.EnumBonsaiTypes;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BlockSpruceBonsai extends BlockBonsai {
	public BlockSpruceBonsai(Properties properties, EnumBonsaiTypes type, int stage) {
		super(properties, type, stage);
	}

	@Override
	public Item getShearDrop() {
		return Items.SNOWBALL;
	}

}
