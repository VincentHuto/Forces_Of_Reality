package com.huto.forcesofreality.entity.mob;

import java.util.EnumSet;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntityHasturVassal extends MonsterEntity {
	private static final DataParameter<Boolean> MOVING = EntityDataManager.createKey(GuardianEntity.class,
			DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> TARGET_ENTITY = EntityDataManager.createKey(EntityHasturVassal.class,
			DataSerializers.VARINT);
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

	public EntityHasturVassal(EntityType<? extends EntityHasturVassal> type, World worldIn) {
		super(type, worldIn);
		this.rand.setSeed((long) this.getEntityId());
		this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(4, new EntityHasturVassal.AttackGoal(this));
		this.goalSelector.addGoal(0, new EntityHasturVassal.MoveRandomGoal(this));
		this.goalSelector.addGoal(1, new EntityHasturVassal.FleeGoal());
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 10, true, false,
				new EntityHasturVassal.TargetPredicate(this)));

	}

	protected void registerData() {
		super.registerData();
		this.dataManager.register(MOVING, false);
		this.dataManager.register(TARGET_ENTITY, 0);
	}

	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D)
				.createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D)
				.createMutableAttribute(Attributes.MAX_HEALTH, 30.0D);
	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return sizeIn.height * 0.5F;
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SQUID_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SQUID_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SQUID_DEATH;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.4F;
	}

	@SuppressWarnings("unused")
	private void setMoving(boolean moving) {
		this.dataManager.set(MOVING, moving);
	}

	protected boolean canTriggerWalking() {
		return false;
	}

	/**
	 * Called frequently so the entity can update its state every tick as required.
	 * For example, zombies and skeletons use this to react to sunlight and start to
	 * burn.
	 */
	public boolean isMoving() {
		return this.dataManager.get(MOVING);
	}

	public float getAttackAnimationScale(float p_175477_1_) {
		return ((float) this.clientSideAttackTime + p_175477_1_) / (float) this.getAttackDuration();
	}

	public void livingTick() {
		if (this.isAlive()) {
			if (this.world.isRemote) {
				if (this.isMoving() && this.isInWater()) {
					Vector3d vector3d1 = this.getLook(0.0F);

					for (int i = 0; i < 2; ++i) {
						this.world.addParticle(ParticleTypes.ASH, this.getPosXRandom(0.5D) - vector3d1.x * 1.5D,
								this.getPosYRandom() - vector3d1.y * 1.5D,
								this.getPosZRandom(0.5D) - vector3d1.z * 1.5D, 0.0D, 0.0D, 0.0D);
					}
				}

				if (this.hasTargetedEntity()) {
					if (this.clientSideAttackTime < this.getAttackDuration()) {
						++this.clientSideAttackTime;
					}

					LivingEntity livingentity = this.getTargetedEntity();
					if (livingentity != null) {
						this.getLookController().setLookPositionWithEntity(livingentity, 90.0F, 90.0F);
						this.getLookController().tick();
						double d5 = (double) this.getAttackAnimationScale(0.0F);
						double d0 = livingentity.getPosX() - this.getPosX();
						double d1 = livingentity.getPosYHeight(0.5D) - this.getPosYEye();
						double d2 = livingentity.getPosZ() - this.getPosZ();
						double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
						d0 = d0 / d3;
						d1 = d1 / d3;
						d2 = d2 / d3;
						double d4 = this.rand.nextDouble();

						while (d4 < d3) {
							d4 += 1.8D - d5 + this.rand.nextDouble() * (1.7D - d5);
							this.world.addParticle(ParticleTypes.ASH, this.getPosX() + d0 * d4,
									this.getPosYEye() + d1 * d4, this.getPosZ() + d2 * d4, 0.0D, 0.0D, 0.0D);
						}
					}
				}
			}

			if (this.isInWaterOrBubbleColumn()) {
				this.setAir(300);
			} else if (this.onGround) {
				this.setMotion(this.getMotion().add((double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F), 0.5D,
						(double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F)));
				this.rotationYaw = this.rand.nextFloat() * 360.0F;
				this.onGround = false;
				this.isAirBorne = true;
			}

			if (this.hasTargetedEntity()) {
				this.rotationYaw = this.rotationYawHead;
			}
		}
		super.livingTick();
		this.prevSquidPitch = this.squidPitch;
		this.prevSquidYaw = this.squidYaw;
		this.prevSquidRotation = this.squidRotation;
		this.lastTentacleAngle = this.tentacleAngle;
		this.squidRotation += this.rotationVelocity;
		if ((double) this.squidRotation > (Math.PI * 2D)) {
			if (this.world.isRemote) {
				this.squidRotation = ((float) Math.PI * 2F);
			} else {
				this.squidRotation = (float) ((double) this.squidRotation - (Math.PI * 2D));
				if (this.rand.nextInt(10) == 0) {
					this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
				}

				this.world.setEntityState(this, (byte) 19);
			}
		}

		if (this.isInWaterOrBubbleColumn()) {
			if (this.squidRotation < (float) Math.PI) {
				float f = this.squidRotation / (float) Math.PI;
				this.tentacleAngle = MathHelper.sin(f * f * (float) Math.PI) * (float) Math.PI * 0.25F;
				if ((double) f > 0.75D) {
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

			if (!this.world.isRemote) {
				this.setMotion((double) (this.randomMotionVecX * this.randomMotionSpeed),
						(double) (this.randomMotionVecY * this.randomMotionSpeed),
						(double) (this.randomMotionVecZ * this.randomMotionSpeed));
			}

			Vector3d vector3d = this.getMotion();
			float f1 = MathHelper.sqrt(horizontalMag(vector3d));
			this.renderYawOffset += (-((float) MathHelper.atan2(vector3d.x, vector3d.z)) * (180F / (float) Math.PI)
					- this.renderYawOffset) * 0.1F;
			this.rotationYaw = this.renderYawOffset;
			this.squidYaw = (float) ((double) this.squidYaw + Math.PI * (double) this.rotateSpeed * 1.5D);
			this.squidPitch += (-((float) MathHelper.atan2((double) f1, vector3d.y)) * (180F / (float) Math.PI)
					- this.squidPitch) * 0.1F;
		} else {
			this.tentacleAngle = MathHelper.abs(MathHelper.sin(this.squidRotation)) * (float) Math.PI * 0.25F;
			if (!this.world.isRemote) {
				double d0 = this.getMotion().y;
				if (this.isPotionActive(Effects.LEVITATION)) {
					d0 = 0.05D * (double) (this.getActivePotionEffect(Effects.LEVITATION).getAmplifier() + 1);
				} else if (!this.hasNoGravity()) {
					d0 -= 0.08D;
				}

				this.setMotion(0.0D, d0 * (double) 0.98F, 0.0D);
			}

			this.squidPitch = (float) ((double) this.squidPitch + (double) (-90.0F - this.squidPitch) * 0.02D);
		}

	}

	public boolean hasTargetedEntity() {
		return this.dataManager.get(TARGET_ENTITY) != 0;
	}

	@Override
	public void notifyDataManagerChange(DataParameter<?> key) {
		super.notifyDataManagerChange(key);
		if (TARGET_ENTITY.equals(key)) {
			this.clientSideAttackTime = 0;
			this.targetedEntity = null;
		}

	}

	@Nullable
	public LivingEntity getTargetedEntity() {
		if (!this.hasTargetedEntity()) {
			return null;
		} else if (this.world.isRemote) {
			if (this.targetedEntity != null) {
				return this.targetedEntity;
			} else {
				Entity entity = this.world.getEntityByID(this.dataManager.get(TARGET_ENTITY));
				if (entity instanceof LivingEntity) {
					this.targetedEntity = (LivingEntity) entity;
					return this.targetedEntity;
				} else {
					return null;
				}
			}
		} else {
			return this.getAttackTarget();
		}
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (super.attackEntityFrom(source, amount) && this.getRevengeTarget() != null) {
			this.squirtInk();
			return true;
		} else {
			return false;
		}
	}

	private void setTargetedEntity(int entityId) {
		this.dataManager.set(TARGET_ENTITY, entityId);
	}

	private Vector3d func_207400_b(Vector3d p_207400_1_) {
		Vector3d vector3d = p_207400_1_.rotatePitch(this.prevSquidPitch * ((float) Math.PI / 180F));
		return vector3d.rotateYaw(-this.prevRenderYawOffset * ((float) Math.PI / 180F));
	}

	private void squirtInk() {
		this.playSound(SoundEvents.ENTITY_SQUID_SQUIRT, this.getSoundVolume(), this.getSoundPitch());
		Vector3d vector3d = this.func_207400_b(new Vector3d(0.0D, -1.0D, 0.0D)).add(this.getPosX(), this.getPosY(),
				this.getPosZ());

		for (int i = 0; i < 30; ++i) {
			Vector3d vector3d1 = this.func_207400_b(new Vector3d((double) this.rand.nextFloat() * 0.6D - 0.3D, -1.0D,
					(double) this.rand.nextFloat() * 0.6D - 0.3D));
			Vector3d vector3d2 = vector3d1.scale(0.3D + (double) (this.rand.nextFloat() * 2.0F));
			((ServerWorld) this.world).spawnParticle(ParticleTypes.REVERSE_PORTAL, vector3d.x, vector3d.y + 0.5D, vector3d.z,
					0, vector3d2.x, vector3d2.y, vector3d2.z, (double) 0.1F);
		}

	}

	public void travel(Vector3d travelVector) {
		this.move(MoverType.SELF, this.getMotion());
	}

	@SuppressWarnings("deprecation")
	public static boolean func_223365_b(EntityType<EntityHasturVassal> p_223365_0_, IWorld p_223365_1_,
			SpawnReason reason, BlockPos p_223365_3_, Random p_223365_4_) {
		return p_223365_3_.getY() > 45 && p_223365_3_.getY() < p_223365_1_.getSeaLevel();
	}

	public int getAttackDuration() {
		return 80;
	}

	/**
	 * Handler for {@link World#setEntityState}
	 */
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 19) {
			this.squidRotation = 0.0F;
		} else {
			super.handleStatusUpdate(id);
		}

	}

	@Nullable
	public LivingEntity getAttackTarget() {
		return this.attackTarget;
	}

	/**
	 * Sets the active target the Task system uses for tracking
	 */
	public void setAttackTarget(@Nullable LivingEntity entitylivingbaseIn) {
		this.attackTarget = entitylivingbaseIn;
		net.minecraftforge.common.ForgeHooks.onLivingSetAttackTarget(this, entitylivingbaseIn);
	}

	public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn) {
		this.randomMotionVecX = randomMotionVecXIn;
		this.randomMotionVecY = randomMotionVecYIn;
		this.randomMotionVecZ = randomMotionVecZIn;
	}

	public boolean hasMovementVector() {
		return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
	}

	class FleeGoal extends Goal {
		private int tickCounter;

		private FleeGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			LivingEntity livingentity = EntityHasturVassal.this.getRevengeTarget();
			if (EntityHasturVassal.this.isInWater() && livingentity != null) {
				return EntityHasturVassal.this.getDistanceSq(livingentity) < 100.0D;
			} else {
				return false;
			}
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.tickCounter = 0;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@SuppressWarnings({ "deprecation" })
		public void tick() {
			++this.tickCounter;
			LivingEntity livingentity = EntityHasturVassal.this.getRevengeTarget();
			if (livingentity != null) {
				Vector3d vector3d = new Vector3d(EntityHasturVassal.this.getPosX() - livingentity.getPosX(),
						EntityHasturVassal.this.getPosY() - livingentity.getPosY(),
						EntityHasturVassal.this.getPosZ() - livingentity.getPosZ());
				BlockState blockstate = EntityHasturVassal.this.world.getBlockState(new BlockPos(
						EntityHasturVassal.this.getPosX() + vector3d.x, EntityHasturVassal.this.getPosY() + vector3d.y,
						EntityHasturVassal.this.getPosZ() + vector3d.z));
				FluidState fluidstate = EntityHasturVassal.this.world.getFluidState(new BlockPos(
						EntityHasturVassal.this.getPosX() + vector3d.x, EntityHasturVassal.this.getPosY() + vector3d.y,
						EntityHasturVassal.this.getPosZ() + vector3d.z));
				if (fluidstate.isTagged(FluidTags.WATER) || blockstate.isAir()) {
					double d0 = vector3d.length();
					if (d0 > 0.0D) {
						vector3d.normalize();
						float f = 3.0F;
						if (d0 > 5.0D) {
							f = (float) ((double) f - (d0 - 5.0D) / 5.0D);
						}

						if (f > 0.0F) {
							vector3d = vector3d.scale((double) f);
						}
					}

					if (blockstate.isAir()) {
						vector3d = vector3d.subtract(0.0D, vector3d.y, 0.0D);
					}

					EntityHasturVassal.this.setMovementVector((float) vector3d.x / 20.0F, (float) vector3d.y / 20.0F,
							(float) vector3d.z / 20.0F);
				}

				if (this.tickCounter % 10 == 5) {
					EntityHasturVassal.this.world.addParticle(ParticleTypes.BUBBLE, EntityHasturVassal.this.getPosX(),
							EntityHasturVassal.this.getPosY(), EntityHasturVassal.this.getPosZ(), 0.0D, 0.0D, 0.0D);
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
		public boolean shouldExecute() {
			return true;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			int i = this.squid.getIdleTime();
			if (i > 100) {
				this.squid.setMovementVector(0.0F, 0.0F, 0.0F);
			} else if (this.squid.getRNG().nextInt(50) == 0 || !this.squid.inWater || !this.squid.hasMovementVector()) {
				float f = this.squid.getRNG().nextFloat() * ((float) Math.PI * 2F);
				float f1 = MathHelper.cos(f) * 0.2F;
				float f2 = -0.1F + this.squid.getRNG().nextFloat() * 0.2F;
				float f3 = MathHelper.sin(f) * 0.2F;
				this.squid.setMovementVector(f1, f2, f3);
			}

		}
	}

	static class AttackGoal extends Goal {
		private final EntityHasturVassal guardian;
		private int tickCounter;

		public AttackGoal(EntityHasturVassal guardian) {
			this.guardian = guardian;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			LivingEntity livingentity = this.guardian.getAttackTarget();
			return livingentity != null && livingentity.isAlive();
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			return super.shouldContinueExecuting()
					&& (this.guardian.getDistanceSq(this.guardian.getAttackTarget()) > 9.0D);
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.tickCounter = -10;
			this.guardian.getNavigator().clearPath();
			this.guardian.getLookController().setLookPositionWithEntity(this.guardian.getAttackTarget(), 90.0F, 90.0F);
			this.guardian.isAirBorne = true;
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		public void resetTask() {
			this.guardian.setTargetedEntity(0);
			this.guardian.setAttackTarget((LivingEntity) null);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			LivingEntity livingentity = this.guardian.getAttackTarget();
			this.guardian.getNavigator().clearPath();
			this.guardian.getLookController().setLookPositionWithEntity(livingentity, 90.0F, 90.0F);
			if (!this.guardian.canEntityBeSeen(livingentity)) {
				this.guardian.setAttackTarget((LivingEntity) null);
			} else {
				++this.tickCounter;
				if (this.tickCounter == 0) {
					this.guardian.setTargetedEntity(this.guardian.getAttackTarget().getEntityId());
					if (!this.guardian.isSilent()) {
						// this.guardian.world.setEntityState(this.guardian, (byte) 21);
					}
				} else if (this.tickCounter >= this.guardian.getAttackDuration()) {
					float f = 1.0F;
					if (this.guardian.world.getDifficulty() == Difficulty.HARD) {
						f += 2.0F;
					}

					livingentity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this.guardian, this.guardian),
							f);
					livingentity.attackEntityFrom(DamageSource.causeMobDamage(this.guardian),
							(float) this.guardian.getAttributeValue(Attributes.ATTACK_DAMAGE));
					this.guardian.setAttackTarget((LivingEntity) null);
				}

				super.tick();
			}
		}
	}

	static class TargetPredicate implements Predicate<LivingEntity> {
		private final EntityHasturVassal parentEntity;

		public TargetPredicate(EntityHasturVassal guardian) {
			this.parentEntity = guardian;
		}

		public boolean test(@Nullable LivingEntity p_test_1_) {
			return (p_test_1_ instanceof PlayerEntity || p_test_1_ instanceof SquidEntity)
					&& p_test_1_.getDistanceSq(this.parentEntity) > 9.0D;
		}
	}
}
