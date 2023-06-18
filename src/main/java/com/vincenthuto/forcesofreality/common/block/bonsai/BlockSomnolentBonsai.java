package com.vincenthuto.forcesofreality.common.block.bonsai;

import com.vincenthuto.forcesofreality.common.block.util.EnumBonsaiTypes;
import com.vincenthuto.forcesofreality.registry.BlockInit;

import net.minecraft.world.item.Item;

public class BlockSomnolentBonsai extends BlockBonsai {
	public BlockSomnolentBonsai(Properties properties, EnumBonsaiTypes type, int stage) {
		super(properties, type, stage);
	}

	@Override
	public Item getShearDrop() {
		return BlockInit.abyssal_silt.get().asItem();
	}

}
