package com.huto.hutosmod.objects.items;

import com.huto.hutosmod.capabilities.covenant.EnumCovenants;

import net.minecraft.item.Item;

public class ItemSacrificial extends Item {

	public int devoAmount;
	public EnumCovenants coven;

	public ItemSacrificial(Properties prop, EnumCovenants covenIn, int devoIn) {
		super(prop);
		this.devoAmount = devoIn;
		this.coven = covenIn;
	}

	public int getDevoAmount() {
		return devoAmount;
	}

	public EnumCovenants getCoven() {
		return coven;
	}

}
