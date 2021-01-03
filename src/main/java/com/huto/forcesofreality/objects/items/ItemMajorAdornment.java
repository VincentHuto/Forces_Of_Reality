package com.huto.forcesofreality.objects.items;

import com.huto.forcesofreality.capabilities.covenant.EnumCovenants;
import com.huto.forcesofreality.capabilities.adornments.IAdornment;
import com.huto.forcesofreality.capabilities.adornments.AdornmentType;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class ItemMajorAdornment extends ItemAdornment implements IAdornment {


	
	public ItemMajorAdornment(Properties properties, EnumCovenants covenIn,int deepenAmount) {
		super(properties, covenIn, deepenAmount);


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
	public AdornmentType getAdornmentType() {
		return AdornmentType.MAJOR;
	}

	
}
