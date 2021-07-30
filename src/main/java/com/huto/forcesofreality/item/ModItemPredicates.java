package com.huto.forcesofreality.item;

import java.util.function.Predicate;

import com.huto.forcesofreality.item.tool.ItemBowBlade;

import net.minecraft.world.item.Item;

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
