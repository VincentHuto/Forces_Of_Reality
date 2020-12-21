package com.huto.forces_of_reality.objects.items;

import com.huto.forces_of_reality.entities.item.EntityManaDustItem;
import com.huto.forces_of_reality.init.EntityInit;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemManaPowder extends Item {

	public ItemManaPowder(Properties prop) {
		super(prop);
	}

	@Override
	public boolean hasCustomEntity(ItemStack stack) {
		return true;
	}

	@Override
	public Entity createEntity(World world, Entity location, ItemStack itemstack) {
		EntityManaDustItem itementity = new EntityManaDustItem(EntityInit.mana_dust.get(), world, location.getPosX(),
				location.getPosY(), location.getPosZ(), itemstack);
		itementity.setPickupDelay(40);
		itementity.setMotion(location.getMotion());
		return itementity;
	}
}