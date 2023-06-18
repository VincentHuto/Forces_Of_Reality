package com.vincenthuto.forcesofreality.common.block.bonsai;

import com.vincenthuto.forcesofreality.common.block.util.EnumBonsaiTypes;
import com.vincenthuto.forcesofreality.registry.BlockInit;

import net.minecraft.world.item.Item;

public class BlockMushroomBonsai extends BlockBonsai {
	public BlockMushroomBonsai(Properties properties, EnumBonsaiTypes type, int stage) {
		super(properties, type, stage);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Item getShearDrop() {
		return Item.byBlock(BlockInit.abyssal_silt.get());
	}

}
