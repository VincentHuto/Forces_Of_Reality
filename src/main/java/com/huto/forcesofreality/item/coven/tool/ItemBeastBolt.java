package com.huto.forcesofreality.item.coven.tool;

import com.huto.forcesofreality.entity.projectile.EntityFirstBeastBolt;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraft.world.item.Item.Properties;

public class ItemBeastBolt extends ArrowItem {

	public ItemBeastBolt(Properties builder) {
		super(builder);
	}

	@Override
	public EntityFirstBeastBolt createArrow(Level worldIn, ItemStack stack, LivingEntity shooter) {
		EntityFirstBeastBolt arrowentity = new EntityFirstBeastBolt(worldIn, shooter);
		arrowentity.setPotionEffect(stack);
		return arrowentity;
	}
}
