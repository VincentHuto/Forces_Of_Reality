package com.vincenthuto.forcesofreality.common.entity.projectile;

import java.util.Random;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.registry.EntityInit;
import com.vincenthuto.hutoslib.client.particle.util.ParticleColor;
import com.vincenthuto.hutoslib.common.network.HLPacketHandler;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class EntityShortCircuit extends ThrowableProjectile {
	public static EntityType<EntityShortCircuit> TYPE = EntityInit.short_circuit.get();
	LivingEntity thrower;

	public EntityShortCircuit(EntityType<EntityShortCircuit> type, Level world) {
		super(type, world);
	}

	public EntityShortCircuit(Level world) {
		this(TYPE, world);
	}

	public EntityShortCircuit(LivingEntity throwerIn, boolean evil) {
		super(TYPE, throwerIn, throwerIn.level());
		thrower = throwerIn;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag cmp) {
		super.addAdditionalSaveData(cmp);
	}

	@Override
	protected void defineSynchedData() {
	}

	@Nonnull
	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void onHit(@Nonnull HitResult pos) {
		switch (pos.getType()) {
		case BLOCK: {
			EntityShorting[] shortings = new EntityShorting[5];
			for (int i = 0; i < shortings.length; i++) {
				shortings[i] = new EntityShorting((LivingEntity) getOwner(), level());
				shortings[i].setPos(this.getX() + random.nextInt(2) - random.nextInt(2), this.getY(),
						this.getZ() + random.nextInt(2) - random.nextInt(2));
				if (shortings[i].findTarget()) {
					level().addFreshEntity(shortings[i]);
				}
			}
			remove(RemovalReason.KILLED);
			break;
		}
		case ENTITY: {
			EntityShorting[] shortings = new EntityShorting[5];
			for (int i = 0; i < shortings.length; i++) {
				shortings[i] = new EntityShorting((LivingEntity) getOwner(), level());
				shortings[i].setPos(this.getX() + random.nextInt(2) - random.nextInt(2), this.getY(),
						this.getZ() + random.nextInt(2) - random.nextInt(2));
				if (shortings[i].findTarget()) {
					level().addFreshEntity(shortings[i]);
				}
			}
			remove(RemovalReason.KILLED);
			break;
		}
		default: {
			remove(RemovalReason.KILLED);
			break;
		}
		}
	}

	@Override
	public void readAdditionalSaveData(CompoundTag cmp) {
		super.readAdditionalSaveData(cmp);
	}

	public void setDirectionMotion(Entity shooter, float p_234612_2_, float p_234612_3_, float p_234612_4_,
			float p_234612_5_, float p_234612_6_) {
		float f = -Mth.sin(p_234612_3_ * ((float) Math.PI / 180F)) * Mth.cos(p_234612_2_ * ((float) Math.PI / 180F));
		float f1 = -Mth.sin((p_234612_2_ + p_234612_4_) * ((float) Math.PI / 180F));
		float f2 = Mth.cos(p_234612_3_ * ((float) Math.PI / 180F)) * Mth.cos(p_234612_2_ * ((float) Math.PI / 180F));
		this.shoot(f, f1, f2, p_234612_5_, p_234612_6_);
		Vec3 vector3d = shooter.getDeltaMovement();
		this.setDeltaMovement(
				this.getDeltaMovement().add(vector3d.x, shooter.onGround() ? 0.0D : vector3d.y, vector3d.z));
	}

	/**
	 * Similar to setArrowHeading, it's point the throwable entity to a x, y, z
	 * direction.
	 */
	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		Vec3 vector3d = (new Vec3(x, y, z)).normalize()
				.add(this.random.nextGaussian() * 0.0075F * inaccuracy,
						this.random.nextGaussian() * 0.0075F * inaccuracy,
						this.random.nextGaussian() * 0.0075F * inaccuracy)
				.scale(velocity);
		this.setDeltaMovement(vector3d);
		float f = Mth.sqrt((float) distanceToSqr(vector3d));
		this.setYRot((float) (Mth.atan2(vector3d.x, vector3d.z) * (180F / (float) Math.PI)));
		this.setXRot((float) (Mth.atan2(vector3d.y, f) * (180F / (float) Math.PI)));
		this.yRotO = this.getYRot();
		this.xRotO = this.getXRot();
	}

	@Override
	public void tick() {
		super.tick();
		Random rand = new Random();
		Vector3 endVec = Vector3.fromEntityCenter(this).add(rand.nextInt(2) - rand.nextInt(2),
				rand.nextInt(2) - rand.nextInt(2), rand.nextInt(2) - rand.nextInt(2));
		if (this.random.nextInt(10) % 2 == 0) {
			Vec3 speedVec = new Vec3(endVec.x, endVec.y, endVec.z);
			HLPacketHandler.sendLightningSpawn(this.position().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					this.level().dimension(), ParticleColor.YELLOW, 2, 10, 9, 0.2f);

		}

		for (int i = 0; i < 5; i++) {
			level().addParticle(ParticleTypes.SQUID_INK, this.getX(), this.getY(), this.getZ(), 0, 0, 0);

		}

	}

}