package com.huto.hutosmod.objects.items;


import com.huto.hutosmod.capabilities.mindrunes.RuneType;
import com.huto.hutosmod.capabilities.mindrunes.IRune;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class ItemContractRune extends ItemRune implements IRune{

	public ItemContractRune(Properties properties) {
		super(properties);
		properties.maxStackSize(1);

	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.RARE;
	}
	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
	}

	@Override
	public RuneType getBaubleType() {
		return RuneType.TRINKET;
	}
}
