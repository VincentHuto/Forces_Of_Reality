package com.huto.hutosmod.objects.items;

import java.util.Random;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class ItemDryingAgent extends Item {

	public ItemDryingAgent(Properties prop) {
		super(prop);

	}

	public static int count = 0;

	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entityItem) {
		count++;

		Random rand = new Random();
		BlockPos pos = entityItem.getPosition();
		World world = entityItem.getEntityWorld();

		if (entityItem.getEntityWorld().isRaining() || entityItem.getEntityWorld().isThundering()) {
			if (!entityItem.isAirBorne)
				if (count > 0) {
					if (world.isRemote) {
					      double x = (double)pos.getX() + 0.5D+ rand.nextDouble() - rand.nextDouble();
					      double y = (double)pos.getY() + rand.nextDouble() - rand.nextDouble();
					      double z = (double)pos.getZ() + 0.5D+ rand.nextDouble() - rand.nextDouble();
					      world.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
					      world.addParticle( ParticleTypes.FLAME, x, y, z, 0.0D, 0.0D, 0.0D);
					}
					count = 0;
				}
			if (entityItem.ticksExisted > 150) {
				if (!world.isRemote) {
					ServerWorld sWorld = (ServerWorld) world;
					sWorld.func_241113_a_(10000, 0, false, false);
					entityItem.remove();
				}
			}
		}

		return super.onEntityItemUpdate(stack, entityItem);
	}

}
