package com.vincenthuto.forcesofreality.entity.mob;

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.monster.Guardian;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntityHasturVassal extends Monster {
	static class AttackGoal extends Goal {
		private final EntityHasturVassal guardian;
		private int tickCounter;

		public AttackGoal(EntityHasturVassal guardian) {
			this.guardian = guardian;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		@Override
		public boolean canContinueToUse() {
			return super.canContinueToUse() && (this.guardian.distanceToSqr(this.guardian.getTarget()) > 9.0D);
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		@Override
		public boolean canUse() {
			LivingEntity livingentity = this.guardian.getTarget();
			return livingentity != null && livingentity.isAlive();
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		@Override
		public void start() {
			this.tickCounter = -10;
			this.guardian.getNavigation().stop();
			this.guardian.getLookControl().setLookAt(this.guardian.getTarget(), 90.0F, 90.0F);
			this.guardian.hasImpulse = true;
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		@Override
		public void stop() {
			this.guardian.setTargetedEntity(0);
			this.guardian.setTarget((LivingEntity) null);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		public void tick() {
			LivingEntity livingentity = this.guardian.getTarget();
			this.guardian.getNavigation().stop();
			this.guardian.getLookControl().setLookAt(livingentity, 90.0F, 90.0F);
			if (!this.guardian.hasLineOfSight(livingentity)) {
				this.guardian.setTarget((LivingEntity) null);
			} else {
				++this.tickCounter;
				if (this.tickCounter == 0) {
					this.guardian.setTargetedEntity(this.guardian.getTarget().getId());
					if (!this.guardian.isSilent()) {
						// this.guardian.world.setEntityState(this.guardian, (byte) 21);
					}
				} else if (this.tickCounter >= this.guardian.getAttackDuration()) {
					float f = 1.0F;
					if (this.guardian.level.getDifficulty() == Difficulty.HARD) {
						f += 2.0F;
					}
					
					livingentity.hurt(livingentity.damageSources().indirectMagic(this.guardian, this.guardian), f);
					livingentity.hurt(livingentity.damageSources().mobAttack(this.guardian),
							(float) this.guardian.getAttributeValue(Attributes.ATTACK_DAMAGE));
					this.guardian.setTarget((LivingEntity) null);
				}

				super.tick();
			}
		}
	}
	class FleeGoal extends Goal {
		private int tickCounter;

		private FleeGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		@Override
		public boolean canUse() {
			LivingEntity livingentity = EntityHasturVassal.this.getLastHurtByMob();
			if (EntityHasturVassal.this.isInWater() && livingentity != null) {
				return EntityHasturVassal.this.distanceToSqr(livingentity) < 100.0D;
			} else {
				return false;
			}
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		@Override
		public void start() {
			this.tickCounter = 0;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		@SuppressWarnings({ "deprecation" })
		public void tick() {
			++this.tickCounter;
			LivingEntity livingentity = EntityHasturVassal.this.getLastHurtByMob();
			if (livingentity != null) {
				Vec3 vector3d = new Vec3(EntityHasturVassal.this.getX() - livingentity.getX(),
						EntityHasturVassal.this.getY() - livingentity.getY(),
						EntityHasturVassal.this.getZ() - livingentity.getZ());
				BlockState blockstate = EntityHasturVassal.this.level.getBlockState(BlockPos.containing(
						EntityHasturVassal.this.getX() + vector3d.x, EntityHasturVassal.this.getY() + vector3d.y,
						EntityHasturVassal.this.getZ() + vector3d.z));
				FluidState fluidstate = EntityHasturVassal.this.level.getFluidState(BlockPos.containing(
						EntityHasturVassal.this.getX() + vector3d.x, EntityHasturVassal.this.getY() + vector3d.y,
						EntityHasturVassal.this.getZ() + vector3d.z));
				if (fluidstate.is(FluidTags.WATER) || blockstate.isAir()) {
					double d0 = vector3d.length();
					if (d0 > 0.0D) {
						vector3d.normalize();
						float f = 3.0F;
						if (d0 > 5.0D) {
							f = (float) (f - (d0 - 5.0D) / 5.0D);
						}

						if (f > 0.0F) {
							vector3d = vector3d.scale(f);
						}
					}

					if (blockstate.isAir()) {
						vector3d = vector3d.subtract(0.0D, vector3d.y, 0.0D);
					}

					EntityHasturVassal.this.setMovementVector((float) vector3d.x / 20.0F, (float) vector3d.y / 20.0F,
							(float) vector3d.z / 20.0F);
				}

				if (this.tickCounter % 10 == 5) {
					EntityHasturVassal.this.level.addParticle(ParticleTypes.BUBBLE, EntityHasturVassal.this.getX(),
							EntityHasturVassal.this.getY(), EntityHasturVassal.this.getZ(), 0.0D, 0.0D, 0.0D);
				}

			}
		}
	}
	class MoveRandomGoal extends Goal {
		private final EntityHasturVassal squid;

		public MoveRandomGoal(EntityHasturVassal p_i48823_2_) {
			this.squid = p_i48823_2_;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		@Override
		public boolean canUse() {
			return true;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		public void tick() {
			int i = this.squid.getNoActionTime();
			if (i > 100) {
				this.squid.setMovementVector(0.0F, 0.0F, 0.0F);
			} else if (this.squid.getRandom().nextInt(50) == 0 || !this.squid.wasTouchingWater
					|| !this.squid.hasMovementVector()) {
				float f = this.squid.getRandom().nextFloat() * ((float) Math.PI * 2F);
				float f1 = Mth.cos(f) * 0.2F;
				float f2 = -0.1F + this.squid.getRandom().nextFloat() * 0.2F;
				float f3 = Mth.sin(f) * 0.2F;
				this.squid.setMovementVector(f1, f2, f3);
			}

		}
	}
	static class TargetPredicate implements Predicate<LivingEntity> {
		private final EntityHasturVassal parentEntity;

		public TargetPredicate(EntityHasturVassal guardian) {
			this.parentEntity = guardian;
		}

		@Override
		public boolean test(@Nullable LivingEntity p_test_1_) {
			return (p_test_1_ instanceof Player || p_test_1_ instanceof Squid)
					&& p_test_1_.distanceToSqr(this.parentEntity) > 9.0D;
		}
	}

	private static final EntityDataAccessor<Boolean> MOVING = SynchedEntityData.defineId(Guardian.class,
			EntityDataSerializers.BOOLEAN);
	private static final EntityDataAccessor<Integer> TARGET_ENTITY = SynchedEntityData
			.defineId(EntityHasturVassal.class, EntityDataSerializers.INT);
	@SuppressWarnings("deprecation")
	public static boolean checkSquidSpawnRules(EntityType<EntityHasturVassal> p_223365_0_, LevelAccessor p_223365_1_,
			MobSpawnType reason, BlockPos p_223365_3_, Random p_223365_4_) {
		return p_223365_3_.getY() > 45 && p_223365_3_.getY() < p_223365_1_.getSeaLevel();
	}
	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes().add(Attributes.ATTACK_DAMAGE, 6.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.MAX_HEALTH, 30.0D);
	}
	private LivingEntity targetedEntity;
	private LivingEntity attackTarget;
	public float squidPitch;
	public float prevSquidPitch;
	public float squidYaw;
	public float prevSquidYaw;
	public float squidRotation;
	public float prevSquidRotation;
	public float tentacleAngle;
	public float lastTentacleAngle;
	private float randomMotionSpeed;

	private float rotationVelocity;

	private float rotateSpeed;

	private float randomMotionVecX;

	private float randomMotionVecY;

	private float randomMotionVecZ;

	private int clientSideAttackTime;

	public EntityHasturVassal(EntityType<? extends EntityHasturVassal> type, Level worldIn) {
		super(type, worldIn);
		this.random.setSeed(this.getId());
		this.rotationVelocity = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
	}

	@Override
	public void aiStep() {
		if (this.isAlive()) {
			if (this.level.isClientSide) {
				if (this.isMoving() && this.isInWater()) {
					Vec3 vector3d1 = this.getViewVector(0.0F);

					for (int i = 0; i < 2; ++i) {
						this.level.addParticle(ParticleTypes.ASH, this.getRandomX(0.5D) - vector3d1.x * 1.5D,
								this.getRandomY() - vector3d1.y * 1.5D, this.getRandomZ(0.5D) - vector3d1.z * 1.5D,
								0.0D, 0.0D, 0.0D);
					}
				}

				if (this.hasTargetedEntity()) {
					if (this.clientSideAttackTime < this.getAttackDuration()) {
						++this.clientSideAttackTime;
					}

					LivingEntity livingentity = this.getTargetedEntity();
					if (livingentity != null) {
						this.getLookControl().setLookAt(livingentity, 90.0F, 90.0F);
						this.getLookControl().tick();
						double d5 = this.getAttackAnimationScale(0.0F);
						double d0 = livingentity.getX() - this.getX();
						double d1 = livingentity.getY(0.5D) - this.getEyeY();
						double d2 = livingentity.getZ() - this.getZ();
						double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
						d0 = d0 / d3;
						d1 = d1 / d3;
						d2 = d2 / d3;
						double d4 = this.random.nextDouble();

						while (d4 < d3) {
							d4 += 1.8D - d5 + this.random.nextDouble() * (1.7D - d5);
							this.level.addParticle(ParticleTypes.ASH, this.getX() + d0 * d4, this.getEyeY() + d1 * d4,
									this.getZ() + d2 * d4, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			}

			if (this.isInWaterOrBubble()) {
				this.setAirSupply(300);
			} else if (this.onGround) {
				this.setDeltaMovement(
						this.getDeltaMovement().add((this.random.nextFloat() * 2.0F - 1.0F) * 0.4F, 0.5D,
								(this.random.nextFloat() * 2.0F - 1.0F) * 0.4F));
				setYRot(this.random.nextFloat() * 360.0F);
				this.onGround = false;
				this.hasImpulse = true;
			}

			if (this.hasTargetedEntity()) {
				setYRot(yHeadRot);
			}
		}
		super.aiStep();
		this.prevSquidPitch = this.squidPitch;
		this.prevSquidYaw = this.squidYaw;
		this.prevSquidRotation = this.squidRotation;
		this.lastTentacleAngle = this.tentacleAngle;
		this.squidRotation += this.rotationVelocity;
		if (this.squidRotation > (Math.PI * 2D)) {
			if (this.level.isClientSide) {
				this.squidRotation = ((float) Math.PI * 2F);
			} else {
				this.squidRotation = (float) (this.squidRotation - (Math.PI * 2D));
				if (this.random.nextInt(10) == 0) {
					this.rotationVelocity = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
				}

				this.level.broadcastEntityEvent(this, (byte) 19);
			}
		}

		if (this.isInWaterOrBubble()) {
			if (this.squidRotation < (float) Math.PI) {
				float f = this.squidRotation / (float) Math.PI;
				this.tentacleAngle = Mth.sin(f * f * (float) Math.PI) * (float) Math.PI * 0.25F;
				if (f > 0.75D) {
					this.randomMotionSpeed = 1.0F;
					this.rotateSpeed = 1.0F;
				} else {
					this.rotateSpeed *= 0.8F;
				}
			} else {
				this.tentacleAngle = 0.0F;
				this.randomMotionSpeed *= 0.9F;
				this.rotateSpeed *= 0.99F;
			}

			if (!this.level.isClientSide) {
				this.setDeltaMovement(this.randomMotionVecX * this.randomMotionSpeed,
						this.randomMotionVecY * this.randomMotionSpeed,
						this.randomMotionVecZ * this.randomMotionSpeed);
			}

			Vec3 vector3d = this.getDeltaMovement();
			float f1 = Mth.sqrt((float) this.distanceToSqr(vector3d));
			this.yBodyRot += (-((float) Mth.atan2(vector3d.x, vector3d.z)) * (180F / (float) Math.PI) - this.yBodyRot)
					* 0.1F;
			setYRot(yBodyRot);
			this.squidYaw = (float) (this.squidYaw + Math.PI * this.rotateSpeed * 1.5D);
			this.squidPitch += (-((float) Mth.atan2(f1, vector3d.y)) * (180F / (float) Math.PI)
					- this.squidPitch) * 0.1F;
		} else {
			this.tentacleAngle = Mth.abs(Mth.sin(this.squidRotation)) * (float) Math.PI * 0.25F;
			if (!this.level.isClientSide) {
				double d0 = this.getDeltaMovement().y;
				if (this.hasEffect(MobEffects.LEVITATION)) {
					d0 = 0.05D * (this.getEffect(MobEffects.LEVITATION).getAmplifier() + 1);
				} else if (!this.isNoGravity()) {
					d0 -= 0.08D;
				}

				this.setDeltaMovement(0.0D, d0 * 0.98F, 0.0D);
			}

			this.squidPitch = (float) (this.squidPitch + (-90.0F - this.squidPitch) * 0.02D);
		}

	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(MOVING, false);
		this.entityData.define(TARGET_ENTITY, 0);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.SQUID_AMBIENT;
	}

	public float getAttackAnimationScale(float p_175477_1_) {
		return (this.clientSideAttackTime + p_175477_1_) / this.getAttackDuration();
	}

	public int getAttackDuration() {
		return 80;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.SQUID_DEATH;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.SQUID_HURT;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		return sizeIn.height * 0.5F;
	}

	@Override
	@Nullable
	public LivingEntity getTarget() {
		return this.attackTarget;
	}

	@Nullable
	public LivingEntity getTargetedEntity() {
		if (!this.hasTargetedEntity()) {
			return null;
		} else if (this.level.isClientSide) {
			if (this.targetedEntity != null) {
				return this.targetedEntity;
			} else {
				Entity entity = this.level.getEntity(this.entityData.get(TARGET_ENTITY));
				if (entity instanceof LivingEntity) {
					this.targetedEntity = (LivingEntity) entity;
					return this.targetedEntity;
				} else {
					return null;
				}
			}
		} else {
			return this.getTarget();
		}
	}

	/**
	 * Handler for {@link World#setEntityState}
	 */
	@Override
	@OnlyIn(Dist.CLIENT)
	public void handleEntityEvent(byte id) {
		if (id == 19) {
			this.squidRotation = 0.0F;
		} else {
			super.handleEntityEvent(id);
		}

	}

	public boolean hasMovementVector() {
		return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
	}

	public boolean hasTargetedEntity() {
		return this.entityData.get(TARGET_ENTITY) != 0;
	}

	/**
	 * Called when the entity is attacked.
	 */
	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (super.hurt(source, amount) && this.getLastHurtByMob() != null) {
			this.squirtInk();
			return true;
		} else {
			return false;
		}
	}

	protected boolean isMovementNoisy() {
		return false;
	}

	/**
	 * Called frequently so the entity can update its state every tick as required.
	 * For example, zombies and skeletons use this to react to sunlight and start to
	 * burn.
	 */
	public boolean isMoving() {
		return this.entityData.get(MOVING);
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
		super.onSyncedDataUpdated(key);
		if (TARGET_ENTITY.equals(key)) {
			this.clientSideAttackTime = 0;
			this.targetedEntity = null;
		}

	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(4, new EntityHasturVassal.AttackGoal(this));
		this.goalSelector.addGoal(0, new EntityHasturVassal.MoveRandomGoal(this));
		this.goalSelector.addGoal(1, new EntityHasturVassal.FleeGoal());
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false,
				new EntityHasturVassal.TargetPredicate(this)));

	}

	private Vec3 rotateVector(Vec3 p_207400_1_) {
		Vec3 vector3d = p_207400_1_.xRot(this.prevSquidPitch * ((float) Math.PI / 180F));
		return vector3d.yRot(-this.yBodyRotO * ((float) Math.PI / 180F));
	}

	public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn) {
		this.randomMotionVecX = randomMotionVecXIn;
		this.randomMotionVecY = randomMotionVecYIn;
		this.randomMotionVecZ = randomMotionVecZIn;
	}

	@SuppressWarnings("unused")
	private void setMoving(boolean moving) {
		this.entityData.set(MOVING, moving);
	}

	/**
	 * Sets the active target the Task system uses for tracking
	 */
	@Override
	public void setTarget(@Nullable LivingEntity entitylivingbaseIn) {
		this.attackTarget = entitylivingbaseIn;
		net.minecraftforge.common.ForgeHooks.onLivingSetAttackTarget(this, entitylivingbaseIn);
	}

	private void setTargetedEntity(int entityId) {
		this.entityData.set(TARGET_ENTITY, entityId);
	}

	private void squirtInk() {
		this.playSound(SoundEvents.SQUID_SQUIRT, this.getSoundVolume(), this.getVoicePitch());
		Vec3 vector3d = this.rotateVector(new Vec3(0.0D, -1.0D, 0.0D)).add(this.getX(), this.getY(), this.getZ());

		for (int i = 0; i < 30; ++i) {
			Vec3 vector3d1 = this.rotateVector(new Vec3(this.random.nextFloat() * 0.6D - 0.3D, -1.0D,
					this.random.nextFloat() * 0.6D - 0.3D));
			Vec3 vector3d2 = vector3d1.scale(0.3D + this.random.nextFloat() * 2.0F);
			((ServerLevel) this.level).sendParticles(ParticleTypes.REVERSE_PORTAL, vector3d.x, vector3d.y + 0.5D,
					vector3d.z, 0, vector3d2.x, vector3d2.y, vector3d2.z, (double) 0.1F);
		}

	}

	@Override
	public void travel(Vec3 travelVector) {
		this.move(MoverType.SELF, this.getDeltaMovement());
	}
}
