package com.huto.hutosmod.objects.items;

import java.util.function.Predicate;

import com.huto.hutosmod.objects.items.tools.ItemBowBlade;

import net.minecraft.item.Item;

public class ModItemPredicates {
	public static Predicate<Item> BOWBLADE = new Predicate<Item>() {
		@Override
		public boolean test(Item e) {
			if (e instanceof ItemBowBlade) {
				return true;
			} else {
				return false;
			}
		}
	};
}
