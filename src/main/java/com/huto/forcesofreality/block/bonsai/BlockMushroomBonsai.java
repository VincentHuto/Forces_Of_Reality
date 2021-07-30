package com.huto.forcesofreality.block.bonsai;

import com.huto.forcesofreality.block.util.EnumBonsaiTypes;
import com.huto.forcesofreality.init.BlockInit;

import net.minecraft.world.item.Item;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BlockMushroomBonsai extends BlockBonsai {
	public BlockMushroomBonsai(Properties properties, EnumBonsaiTypes type, int stage) {
		super(properties, type, stage);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Item getShearDrop() {
		return Item.getItemFromBlock(BlockInit.abyssal_silt.get());
	}

}
