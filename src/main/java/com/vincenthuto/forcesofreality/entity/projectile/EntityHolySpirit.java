package com.vincenthuto.forcesofreality.entity.projectile;

import javax.annotation.Nonnull;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;

public class EntityHolySpirit extends AbstractHurtingProjectile {

	public EntityHolySpirit(EntityType<? extends EntityHolySpirit> p_i50173_1_, Level p_i50173_2_) {
		super(p_i50173_1_, p_i50173_2_);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.put("power", this.newDoubleList(new double[] { this.xPower, this.yPower, this.zPower }));
	}

	@Override
	protected boolean canHitEntity(Entity p_230298_1_) {
		return super.canHitEntity(p_230298_1_) && !p_230298_1_.noPhysics;
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);

	}

	/**
	 * Gets how bright this entity is.
	 */
	public float getBrightness() {
		return 1.0F;
	}

	/**
	 * Return the motion factor for this projectile. The factor is multiplied by the
	 * original motion.
	 */
	@Override
	protected float getInertia() {
		return 1F;
	}

	@Override
	public float getPickRadius() {
		return 1.0F;
	}

	@Override
	protected ParticleOptions getTrailParticle() {
		return ParticleTypes.WHITE_ASH;
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else {
			this.markHurt();
			Entity entity = source.getEntity();
			if (entity != null) {
				Vec3 vector3d = entity.getLookAngle();
				this.setDeltaMovement(vector3d);
				this.xPower = vector3d.x * 0.1D;
				this.yPower = vector3d.y * 0.1D;
				this.zPower = vector3d.z * 0.1D;
				this.setOwner(entity);
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * Returns true if other Entities should be prevented from moving through this
	 * Entity.
	 */
	@Override
	public boolean isPickable() {
		return true;
	}

	@Override
	protected void onHit(@Nonnull HitResult pos) {
		switch (pos.getType()) {
		case BLOCK: {
			remove(RemovalReason.KILLED);
			break;
		}
		case ENTITY: {
			((EntityHitResult) pos).getEntity().hurt(((EntityHitResult) pos).getEntity().damageSources().magic(), 10f);
			remove(RemovalReason.KILLED);
			break;
		}
		default: {
			remove(RemovalReason.KILLED);
			break;
		}
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("power", 9)) {
			ListTag listnbt = compound.getList("power", 6);
			if (listnbt.size() == 3) {
				this.xPower = listnbt.getDouble(0);
				this.yPower = listnbt.getDouble(1);
				this.zPower = listnbt.getDouble(2);
			}
		}

	}

	public void setDirectionMotion(Entity shooter, float x, float y, float z, float velocity, float inaccuracy) {
		float f = -Mth.sin(y * ((float) Math.PI / 180F)) * Mth.cos(x * ((float) Math.PI / 180F));
		float f1 = -Mth.sin((x + z) * ((float) Math.PI / 180F));
		float f2 = Mth.cos(y * ((float) Math.PI / 180F)) * Mth.cos(x * ((float) Math.PI / 180F));
		this.shoot(f, f1, f2, velocity, inaccuracy);
		Vec3 vector3d = shooter.getDeltaMovement();
		this.setDeltaMovement(this.getDeltaMovement().add(vector3d.x, vector3d.y, vector3d.z));
	}

	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		Vec3 vector3d = (new Vec3(x, y, z)).normalize().scale(velocity);
		this.setDeltaMovement(vector3d);
		float f = Mth.sqrt((float) distanceToSqr(vector3d));
		this.setYRot((float) (Mth.atan2(vector3d.x, vector3d.z) * (180F / (float) Math.PI)));
		this.setXRot((float) (Mth.atan2(vector3d.y, f) * (180F / (float) Math.PI)));
		this.yRotO = this.getYRot();
		this.xRotO = this.getXRot();
	}

	@Override
	protected boolean shouldBurn() {
		return false;
	}

	/**
	 * Checks if the entity is in range to render.
	 */
	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean shouldRenderAtSqrDistance(double distance) {
		double d0 = this.getBoundingBox().getSize() * 4.0D;
		if (Double.isNaN(d0)) {
			d0 = 4.0D;
		}
		d0 = d0 * 64.0D;
		return distance < d0 * d0;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	@SuppressWarnings("deprecation")
	public void tick() {
		if (tickCount > 75) {
			if (!level.isClientSide) {
				this.level.explode(this, this.getX(), this.getY() + this.getBbHeight() / 16.0F, this.getZ(),
						3.0F, ExplosionInteraction.NONE);
			}
			remove(RemovalReason.KILLED);
		}

		Entity entity = this.getOwner();
		if (this.level.isClientSide
				|| (entity == null || !entity.isRemoved()) && this.level.hasChunkAt(this.blockPosition())) {
			super.tick();

			HitResult raytraceresult = ProjectileUtil.getHitResult(this, this::canHitEntity);
			if (raytraceresult.getType() != HitResult.Type.MISS
					&& !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
				this.onHit(raytraceresult);
			}

			this.checkInsideBlocks();
			Vec3 vector3d = this.getDeltaMovement();
			double d0 = this.getX() + vector3d.x;
			double d1 = this.getY() + vector3d.y;
			double d2 = this.getZ() + vector3d.z;
			ProjectileUtil.rotateTowardsMovement(this, 0.2F);
			float f = this.getInertia();

			this.setDeltaMovement(vector3d.add(this.xPower, this.yPower, this.zPower).scale(f));
			this.setPos(d0, d1, d2);
		} else {

			this.remove(RemovalReason.KILLED);
		}
	}
}
