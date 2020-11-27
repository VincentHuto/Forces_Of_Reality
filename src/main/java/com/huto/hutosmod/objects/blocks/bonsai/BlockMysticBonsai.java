package com.huto.hutosmod.objects.blocks.bonsai;

import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.objects.blocks.util.EnumBonsaiTypes;

import net.minecraft.item.Item;

public class BlockMysticBonsai extends BlockBonsai {
	public BlockMysticBonsai(Properties properties, EnumBonsaiTypes type,int stage) {
		super(properties, type,stage);
	}
	@Override
	public Item getShearDrop() {
		return ItemInit.akebi_pod.get();
	}

}
