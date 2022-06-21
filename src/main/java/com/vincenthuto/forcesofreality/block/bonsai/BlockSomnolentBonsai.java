package com.vincenthuto.forcesofreality.block.bonsai;

import com.vincenthuto.forcesofreality.block.util.EnumBonsaiTypes;
import com.vincenthuto.forcesofreality.init.BlockInit;

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
