package com.huto.forcesofreality.item;

import java.util.Random;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.server.ServerWorld;

import net.minecraft.world.item.Item.Properties;

public class ItemSoakingAgent extends Item {
	public ItemSoakingAgent(Properties prop) {
		super(prop);

	}

	public static int count = 0;

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entityItem) {
		count++;

		Random rand = new Random();
		BlockPos pos = entityItem.getPosition();
		Level world = entityItem.getEntityWorld();

		if (!entityItem.getEntityWorld().isRaining() || entityItem.getEntityWorld().isThundering()) {
			if (!entityItem.isAirBorne)
				if (count > 0) {
					entityItem.setMotion(0, 0.05, 0);
					if (world.isRemote) {
						double x = (double) pos.getX() + 0.5D + rand.nextDouble() - rand.nextDouble();
						double y = (double) pos.getY() + rand.nextDouble() - rand.nextDouble();
						double z = (double) pos.getZ() + 0.5D + rand.nextDouble() - rand.nextDouble();
						world.addParticle(ParticleTypes.FALLING_WATER, x, y, z, 0.0D, 0.0D, 0.0D);
						world.addParticle(ParticleTypes.BUBBLE, x, y, z, 0.0D, 0.0D, 0.0D);
					}
					count = 0;
				}
			if (entityItem.ticksExisted > 150) {
				double x = (double) pos.getX() + 0.5D + rand.nextDouble() - rand.nextDouble();
				double y = (double) pos.getY() + rand.nextDouble() - rand.nextDouble();
				double z = (double) pos.getZ() + 0.5D + rand.nextDouble() - rand.nextDouble();
				if (!world.isRemote) {

					ServerWorld sWorld = (ServerWorld) world;
					sWorld.setWeather(0, 10000, true, false);
					for (int i = 0; i < 10; i++) {
						sWorld.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0.0D, 0.0D, 0.0D);
					}
					entityItem.remove();
				}
				for (int i = 0; i < 10; i++) {
					world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		return super.onEntityItemUpdate(stack, entityItem);
	}

}
