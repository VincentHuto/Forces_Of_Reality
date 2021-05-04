package com.huto.forcesofreality.entities.projectiles;

import java.util.Random;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.init.EntityInit;
import com.hutoslib.client.particle.ParticleColor;
import com.hutoslib.common.PacketHandler;
import com.hutoslib.math.Vector3;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityShortCircuit extends ThrowableEntity {
	public static EntityType<EntityShortCircuit> TYPE = EntityInit.short_circuit.get();
	LivingEntity thrower;

	public EntityShortCircuit(EntityType<EntityShortCircuit> type, World world) {
		super(type, world);
	}

	public EntityShortCircuit(World world) {
		this(TYPE, world);
	}

	public EntityShortCircuit(LivingEntity throwerIn, boolean evil) {
		super(TYPE, throwerIn, throwerIn.world);
		thrower = throwerIn;
	}

	@Nonnull
	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public void tick() {
		super.tick();
		Random rand = new Random();
		Vector3 endVec = Vector3.fromEntityCenter(this).add(rand.nextInt(2) - rand.nextInt(2),
				rand.nextInt(2) - rand.nextInt(2), rand.nextInt(2) - rand.nextInt(2));
		if (this.rand.nextInt(10) % 2 == 0) {
			Vector3d speedVec = new Vector3d(endVec.x, endVec.y, endVec.z);
			PacketHandler.sendLightningSpawn(this.getPositionVec().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					(RegistryKey<World>) this.world.getDimensionKey(), ParticleColor.YELLOW, 2, 10, 9, 0.2f);

		}

		for (int i = 0; i < 5; i++) {
			world.addParticle(ParticleTypes.SQUID_INK, this.getPosX(), this.getPosY(), this.getPosZ(), 0, 0, 0);

		}

	}

	@Override
	public void writeAdditional(CompoundNBT cmp) {
		super.writeAdditional(cmp);
	}

	@Override
	public void readAdditional(CompoundNBT cmp) {
		super.readAdditional(cmp);
	}

	/**
	 * Similar to setArrowHeading, it's point the throwable entity to a x, y, z
	 * direction.
	 */
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		Vector3d vector3d = (new Vector3d(x, y, z)).normalize()
				.add(this.rand.nextGaussian() * (double) 0.0075F * (double) inaccuracy,
						this.rand.nextGaussian() * (double) 0.0075F * (double) inaccuracy,
						this.rand.nextGaussian() * (double) 0.0075F * (double) inaccuracy)
				.scale((double) velocity);
		this.setMotion(vector3d);
		float f = MathHelper.sqrt(horizontalMag(vector3d));
		this.rotationYaw = (float) (MathHelper.atan2(vector3d.x, vector3d.z) * (double) (180F / (float) Math.PI));
		this.rotationPitch = (float) (MathHelper.atan2(vector3d.y, (double) f) * (double) (180F / (float) Math.PI));
		this.prevRotationYaw = this.rotationYaw;
		this.prevRotationPitch = this.rotationPitch;
	}

	public void setDirectionMotion(Entity shooter, float p_234612_2_, float p_234612_3_, float p_234612_4_,
			float p_234612_5_, float p_234612_6_) {
		float f = -MathHelper.sin(p_234612_3_ * ((float) Math.PI / 180F))
				* MathHelper.cos(p_234612_2_ * ((float) Math.PI / 180F));
		float f1 = -MathHelper.sin((p_234612_2_ + p_234612_4_) * ((float) Math.PI / 180F));
		float f2 = MathHelper.cos(p_234612_3_ * ((float) Math.PI / 180F))
				* MathHelper.cos(p_234612_2_ * ((float) Math.PI / 180F));
		this.shoot((double) f, (double) f1, (double) f2, p_234612_5_, p_234612_6_);
		Vector3d vector3d = shooter.getMotion();
		this.setMotion(this.getMotion().add(vector3d.x, shooter.isOnGround() ? 0.0D : vector3d.y, vector3d.z));
	}

	@Override
	protected void registerData() {
	}

	@Override
	protected void onImpact(@Nonnull RayTraceResult pos) {
		switch (pos.getType()) {
		case BLOCK: {
			EntityShorting[] shortings = new EntityShorting[5];
			for (int i = 0; i < shortings.length; i++) {
				shortings[i] = new EntityShorting((LivingEntity) func_234616_v_(), world);
				shortings[i].setPosition(this.getPosX() + rand.nextInt(2) - rand.nextInt(2), this.getPosY(),
						this.getPosZ() + rand.nextInt(2) - rand.nextInt(2));
				if (shortings[i].findTarget()) {
					world.addEntity(shortings[i]);
				}
			}
			remove();
			break;
		}
		case ENTITY: {
			EntityShorting[] shortings = new EntityShorting[5];
			for (int i = 0; i < shortings.length; i++) {
				shortings[i] = new EntityShorting((LivingEntity) func_234616_v_(), world);
				shortings[i].setPosition(this.getPosX() + rand.nextInt(2) - rand.nextInt(2), this.getPosY(),
						this.getPosZ() + rand.nextInt(2) - rand.nextInt(2));
				if (shortings[i].findTarget()) {
					world.addEntity(shortings[i]);
				}
			}
			remove();
			break;
		}
		default: {
			remove();
			break;
		}
		}
	}

}