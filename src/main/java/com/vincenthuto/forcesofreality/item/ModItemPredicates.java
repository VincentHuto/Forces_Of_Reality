package com.vincenthuto.forcesofreality.item;

import java.util.function.Predicate;

import com.vincenthuto.forcesofreality.item.tool.ItemBowBlade;

import net.minecraft.world.item.Item;

public class ModItemPredicates {
	public static Predicate<Item> BOWBLADE = new Predicate<>() {
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
