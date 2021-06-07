package com.huto.forcesofreality.block.bonsai;

import com.huto.forcesofreality.block.util.EnumBonsaiTypes;
import com.huto.forcesofreality.init.BlockInit;

import net.minecraft.item.Item;

public class BlockSomnolentBonsai extends BlockBonsai {
	public BlockSomnolentBonsai(Properties properties, EnumBonsaiTypes type,int stage) {
		super(properties, type,stage);
	}
	@Override
	public Item getShearDrop() {
		return BlockInit.abyssal_silt.get().asItem();
	}

}
