package com.vincenthuto.forcesofreality.common.entity.projectile;

import javax.annotation.Nonnull;

import com.vincenthuto.forcesofreality.registry.EntityInit;

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
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;

public class EntityDreadRocketDirected extends ThrowableProjectile {
	public static EntityType<EntityDreadRocketDirected> TYPE = EntityInit.dread_rocket_directed.get();
	LivingEntity thrower;

	public EntityDreadRocketDirected(EntityType<EntityDreadRocketDirected> type, Level world) {
		super(type, world);
	}

	public EntityDreadRocketDirected(Level world) {
		this(TYPE, world);
	}

	public EntityDreadRocketDirected(LivingEntity throwerIn, boolean evil) {
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

	public LivingEntity getThrower() {
		return thrower;
	}

	@Override
	protected void onHit(@Nonnull HitResult pos) {
		switch (pos.getType()) {
		case BLOCK: {
			if (!level().isClientSide) {
				this.level().explode(this, this.getX(), this.getY() + this.getBbHeight() / 16.0F, this.getZ(),3.0F, ExplosionInteraction.TNT);
			}
			remove(RemovalReason.KILLED);
			break;
		}
		case ENTITY: {
			if (!level().isClientSide) {
				this.level().explode(this, this.getX(), this.getY() + this.getBbHeight() / 16.0F, this.getZ(),3.0F, ExplosionInteraction.NONE);

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
		level().addParticle(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 0, 0, 0);
		level().addParticle(ParticleTypes.CRIT, this.getX() + (Math.random() - 0.5) * 0.4,
				this.getY() + (Math.random() - 0.5) * 0.4, this.getZ() + (Math.random() - 0.5) * 0.4, 0, 0, 0);

	}

}