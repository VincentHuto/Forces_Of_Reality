package com.huto.forces_of_reality.objects.items.runes;

import com.huto.forces_of_reality.capabilities.covenant.EnumCovenants;
import com.huto.forces_of_reality.capabilities.mindrunes.IRune;
import com.huto.forces_of_reality.capabilities.mindrunes.RuneType;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class ItemContractRune extends ItemRune implements IRune {


	
	public ItemContractRune(Properties properties, EnumCovenants covenIn,int deepenAmount) {
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
	public RuneType getRuneType() {
		return RuneType.CONTRACT;
	}

	
}
