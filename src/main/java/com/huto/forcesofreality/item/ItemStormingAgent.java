package com.huto.forcesofreality.item;

import java.util.Random;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ItemStormingAgent extends Item {
	public ItemStormingAgent(Properties prop) {
		super(prop);

	}

	public static int count = 0;

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entityItem) {
		count++;

		Random rand = new Random();
		BlockPos pos = entityItem.getPosition();
		World world = entityItem.getEntityWorld();

		if (!entityItem.getEntityWorld().isRaining() || !entityItem.getEntityWorld().isThundering()) {
			if (!entityItem.isAirBorne)
				if (count > 0) {
					entityItem.setMotion(0, 0.05, 0);

					if (world.isRemote) {
						double x = (double) pos.getX() + 0.5D + rand.nextDouble() - rand.nextDouble();
						double y = (double) pos.getY() + rand.nextDouble() - rand.nextDouble();
						double z = (double) pos.getZ() + 0.5D + rand.nextDouble() - rand.nextDouble();
						world.addParticle(ParticleTypes.DRIPPING_HONEY, x, y, z, 0.0D, 0.0D, 0.0D);
						world.addParticle(ParticleTypes.CRIT, x, y, z, 0.0D, 0.0D, 0.0D);
					}
					count = 0;
				}
			if (entityItem.ticksExisted > 150) {
				double x = (double) pos.getX() + 0.5D + rand.nextDouble() - rand.nextDouble();
				double y = (double) pos.getY() + rand.nextDouble() - rand.nextDouble();
				double z = (double) pos.getZ() + 0.5D + rand.nextDouble() - rand.nextDouble();
				if (!world.isRemote) {

					ServerWorld sWorld = (ServerWorld) world;
					sWorld.setWeather(0, 10000, true, true);
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
