package com.huto.hutosmod.objects.items.runes;

import com.huto.hutosmod.capabilities.mindrunes.RuneType;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;
import com.huto.hutosmod.capabilities.mindrunes.IRune;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class ItemContractRune extends ItemRune implements IRune {

	EnumCovenants assignedCovenant;

	public ItemContractRune(Properties properties, EnumCovenants covenIn) {
		super(properties);
		this.assignedCovenant = covenIn;

	}

	public EnumCovenants getAssignedCovenant() {
		return assignedCovenant;
	}

	public void setAssignedCovenant(EnumCovenants assignedCovenant) {
		this.assignedCovenant = assignedCovenant;
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
