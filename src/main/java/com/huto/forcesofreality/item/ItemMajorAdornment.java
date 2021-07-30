package com.huto.forcesofreality.item;

import com.huto.forcesofreality.capabilitie.adornment.AdornmentType;
import com.huto.forcesofreality.capabilitie.adornment.IAdornment;
import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import net.minecraft.world.item.Item.Properties;

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
