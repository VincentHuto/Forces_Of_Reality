package com.huto.hutosmod.objects.items;


import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class ItemContractRune extends ItemRune {

	public ItemContractRune(Properties properties) {
		super(properties);
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.RARE;
	}
	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
	}
}
