package com.huto.forces_of_reality.entities.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;

import com.huto.forces_of_reality.init.ItemInit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityManaDustItem extends ItemEntity {

	private int pickupDelayNew = 40;

	public EntityManaDustItem(EntityType<? extends ItemEntity> p_i50217_1_, World world) {
		super(p_i50217_1_, world);

	}

	public EntityManaDustItem(EntityType<? extends ItemEntity> p_i50217_1_, World p_i50217_2_, double posX, double posY,
			double posZ, ItemStack stack) {
		super(p_i50217_1_, p_i50217_2_);
		this.setPosition(posX, posY, posZ);
		this.setItem(stack);
		this.lifespan = (stack.getItem() == null ? 6000 : stack.getEntityLifespan(p_i50217_2_));
	}

	@Override
	public void tick() {

		if (this.pickupDelayNew > 0 && this.pickupDelayNew != 32767) {
			--this.pickupDelayNew;
		}

		// Client FX
		if (world.isRemote) {
			double r = 0.1;
			double m = 0.1;
			for (int i = 0; i < 1; i++) {
				world.addParticle(ParticleTypes.AMBIENT_ENTITY_EFFECT, getPosX() + r * (Math.random() - 0.5),
						getPosY() + r * (Math.random() - 0.5), getPosZ() + r * (Math.random() - 0.5),
						m * (Math.random() - 0.5), m * (Math.random() - 0.5), m * (Math.random() - 0.5));
			}
		}
		List<Item> recipeList = Arrays.asList(Items.REDSTONE, Items.GLOWSTONE_DUST);
		List<Entity> entList = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getBoundingBox().grow(0.75));
		List<Item> itemList = new ArrayList<Item>();
		List<ItemEntity> itemEntList = new ArrayList<ItemEntity>();

		for (int i = 0; i < entList.size(); i++) {
			if (entList.get(i) instanceof ItemEntity) {
				ItemEntity itemEnt = (ItemEntity) entList.get(i);
				if (recipeList.contains(itemEnt.getItem().getItem())) {
					if (!itemList.contains(itemEnt.getItem().getItem())) {
						itemList.add(itemEnt.getItem().getItem());
					}

					if (!itemEntList.contains(itemEnt)) {
						itemEntList.add(itemEnt);
					}

					if (itemList.containsAll(recipeList)) {
						if (!world.isRemote) {
							for (ItemEntity it : itemEntList) {
								it.getItem().shrink(1);
							}
							world.addEntity(new ItemEntity(world, this.getPosX(), this.getPosY(), this.getPosZ(),
									new ItemStack(ItemInit.machina_soul.get())));
							this.getItem().shrink(1);
						} else {
							world.addParticle(ParticleTypes.POOF, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D,
									0.0D, 0.0D);
							world.addParticle(ParticleTypes.SMOKE, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D,
									0.0D, 0.0D);
						}
					}
				}
			}
		}
		super.tick();

	}

	@Nonnull
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}
