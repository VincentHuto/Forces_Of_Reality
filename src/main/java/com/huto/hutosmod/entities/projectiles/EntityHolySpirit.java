package com.huto.hutosmod.entities.projectiles;

import javax.annotation.Nonnull;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityHolySpirit extends DamagingProjectileEntity {

	public EntityHolySpirit(EntityType<? extends EntityHolySpirit> p_i50173_1_, World p_i50173_2_) {
		super(p_i50173_1_, p_i50173_2_);
	}

	/**
	 * Checks if the entity is in range to render.
	 */
	@OnlyIn(Dist.CLIENT)
	public boolean isInRangeToRenderDist(double distance) {
		double d0 = this.getBoundingBox().getAverageEdgeLength() * 4.0D;
		if (Double.isNaN(d0)) {
			d0 = 4.0D;
		}
		d0 = d0 * 64.0D;
		return distance < d0 * d0;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@SuppressWarnings("deprecation")
	public void tick() {
		if (ticksExisted > 75) {
			if (!world.isRemote) {
				this.world.createExplosion(this, this.getPosX(), this.getPosY() + (double) (this.getHeight() / 16.0F),
						this.getPosZ(), 3.0F, Explosion.Mode.DESTROY);
			}
			remove();
		}

		Entity entity = this.func_234616_v_();
		if (this.world.isRemote
				|| (entity == null || !entity.removed) && this.world.isBlockLoaded(this.getPosition())) {
			super.tick();

			RayTraceResult raytraceresult = ProjectileHelper.func_234618_a_(this, this::func_230298_a_);
			if (raytraceresult.getType() != RayTraceResult.Type.MISS
					&& !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
				this.onImpact(raytraceresult);
			}

			this.doBlockCollisions();
			Vector3d vector3d = this.getMotion();
			double d0 = this.getPosX() + vector3d.x;
			double d1 = this.getPosY() + vector3d.y;
			double d2 = this.getPosZ() + vector3d.z;
			ProjectileHelper.rotateTowardsMovement(this, 0.2F);
			float f = this.getMotionFactor();

			this.setMotion(vector3d.add(this.accelerationX, this.accelerationY, this.accelerationZ).scale((double) f));
			this.setPosition(d0, d1, d2);
		} else {

			this.remove();
		}
	}

	protected boolean func_230298_a_(Entity p_230298_1_) {
		return super.func_230298_a_(p_230298_1_) && !p_230298_1_.noClip;
	}

	protected boolean isFireballFiery() {
		return false;
	}

	/**
	 * Return the motion factor for this projectile. The factor is multiplied by the
	 * original motion.
	 */
	protected float getMotionFactor() {
		return 0.95F;
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.put("power",
				this.newDoubleNBTList(new double[] { this.accelerationX, this.accelerationY, this.accelerationZ }));
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if (compound.contains("power", 9)) {
			ListNBT listnbt = compound.getList("power", 6);
			if (listnbt.size() == 3) {
				this.accelerationX = listnbt.getDouble(0);
				this.accelerationY = listnbt.getDouble(1);
				this.accelerationZ = listnbt.getDouble(2);
			}
		}

	}

	/**
	 * Returns true if other Entities should be prevented from moving through this
	 * Entity.
	 */
	public boolean canBeCollidedWith() {
		return true;
	}

	public float getCollisionBorderSize() {
		return 1.0F;
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else {
			this.markVelocityChanged();
			Entity entity = source.getTrueSource();
			if (entity != null) {
				Vector3d vector3d = entity.getLookVec();
				this.setMotion(vector3d);
				this.accelerationX = vector3d.x * 0.1D;
				this.accelerationY = vector3d.y * 0.1D;
				this.accelerationZ = vector3d.z * 0.1D;
				this.setShooter(entity);
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	protected IParticleData getParticle() {
		return ParticleTypes.WHITE_ASH;
	}

	@Override
	protected void onImpact(@Nonnull RayTraceResult pos) {
		switch (pos.getType()) {
		case BLOCK: {
			remove();
			break;
		}
		case ENTITY: {
			((EntityRayTraceResult) pos).getEntity().attackEntityFrom(DamageSource.MAGIC, 10f);
			remove();
			break;
		}
		default: {
			remove();
			break;
		}
		}
	}

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

	public void setDirectionMotion(Entity shooter, float x, float y, float z, float velocity, float inaccuracy) {
		float f = -MathHelper.sin(y * ((float) Math.PI / 180F)) * MathHelper.cos(x * ((float) Math.PI / 180F));
		float f1 = -MathHelper.sin((x + z) * ((float) Math.PI / 180F));
		float f2 = MathHelper.cos(y * ((float) Math.PI / 180F)) * MathHelper.cos(x * ((float) Math.PI / 180F));
		this.shoot((double) f, (double) f1, (double) f2, velocity, inaccuracy);
		Vector3d vector3d = shooter.getMotion();
		this.setMotion(this.getMotion().add(vector3d.x, shooter.isOnGround() ? 0.0D : vector3d.y, vector3d.z));
	}

	/**
	 * Gets how bright this entity is.
	 */
	public float getBrightness() {
		return 1.0F;
	}

	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);

	}
}
