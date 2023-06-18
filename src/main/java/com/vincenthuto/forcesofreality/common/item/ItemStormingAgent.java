package com.vincenthuto.forcesofreality.common.item;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemStormingAgent extends Item {
	public static int count = 0;

	public ItemStormingAgent(Properties prop) {
		super(prop);

	}

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entityItem) {
		count++;

		Random rand = new Random();
		BlockPos pos = entityItem.blockPosition();
		Level world = entityItem.getCommandSenderWorld();

		if (!entityItem.getCommandSenderWorld().isRaining() || !entityItem.getCommandSenderWorld().isThundering()) {
			if (!entityItem.hasImpulse)
				if (count > 0) {
					entityItem.setDeltaMovement(0, 0.05, 0);

					if (world.isClientSide) {
						double x = pos.getX() + 0.5D + rand.nextDouble() - rand.nextDouble();
						double y = pos.getY() + rand.nextDouble() - rand.nextDouble();
						double z = pos.getZ() + 0.5D + rand.nextDouble() - rand.nextDouble();
						world.addParticle(ParticleTypes.DRIPPING_HONEY, x, y, z, 0.0D, 0.0D, 0.0D);
						world.addParticle(ParticleTypes.CRIT, x, y, z, 0.0D, 0.0D, 0.0D);
					}
					count = 0;
				}
			if (entityItem.tickCount > 150) {
				double x = pos.getX() + 0.5D + rand.nextDouble() - rand.nextDouble();
				double y = pos.getY() + rand.nextDouble() - rand.nextDouble();
				double z = pos.getZ() + 0.5D + rand.nextDouble() - rand.nextDouble();
				if (!world.isClientSide) {

					ServerLevel sWorld = (ServerLevel) world;
					sWorld.setWeatherParameters(0, 10000, true, true);
					for (int i = 0; i < 10; i++) {
						sWorld.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0.0D, 0.0D, 0.0D);
					}
					entityItem.remove(RemovalReason.KILLED);
				}
				for (int i = 0; i < 10; i++) {
					world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0.0D, 0.0D, 0.0D);
				}
			}
		}

		return super.onEntityItemUpdate(stack, entityItem);
	}

}
