package com.huto.forcesofreality.objects.blocks.bonsai;

import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.objects.blocks.util.EnumBonsaiTypes;

import net.minecraft.item.Item;

public class BlockSomnolentBonsai extends BlockBonsai {
	public BlockSomnolentBonsai(Properties properties, EnumBonsaiTypes type,int stage) {
		super(properties, type,stage);
	}
	@Override
	public Item getShearDrop() {
		return ItemInit.akebi_pod.get();
	}

}
