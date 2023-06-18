package com.vincenthuto.forcesofreality.common.entity.summon;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.vincenthuto.forcesofreality.ForcesOfReality;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.FlyingMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntityHasturSpawn extends FlyingMob implements Enemy {
	static enum AttackPhase {
		CIRCLE, SWOOP;
	}
	class BodyHelperController extends BodyRotationControl {
		public BodyHelperController(Mob mob) {
			super(mob);
		}

		/**
		 * Update the Head and Body rendenring angles
		 */
		@Override
		public void clientTick() {
			EntityHasturSpawn.this.yHeadRot = EntityHasturSpawn.this.yBodyRot;
			EntityHasturSpawn.this.yBodyRot = EntityHasturSpawn.this.getYRot();
		}
	}
	class LookHelperController extends LookControl {
		public LookHelperController(Mob entityIn) {
			super(entityIn);
		}

		/**
		 * Updates look
		 */
		@Override
		public void tick() {
		}
	}
	abstract class MoveGoal extends Goal {
		public MoveGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		protected boolean touchingTarget() {
			return EntityHasturSpawn.this.orbitOffset.distanceToSqr(EntityHasturSpawn.this.getX(),
					EntityHasturSpawn.this.getY(), EntityHasturSpawn.this.getZ()) < 4.0D;
		}
	}
	class MoveHelperController extends MoveControl {
		private float speedFactor = 0.1F;

		public MoveHelperController(Mob entityIn) {
			super(entityIn);
		}

		@Override
		public void tick() {
			if (EntityHasturSpawn.this.horizontalCollision) {
				//EntityHasturSpawn.this.getYRot() += 180.0F;
				this.speedFactor = 0.1F;
			}

			float f = (float) (EntityHasturSpawn.this.orbitOffset.x - EntityHasturSpawn.this.getX());
			float f1 = (float) (EntityHasturSpawn.this.orbitOffset.y - EntityHasturSpawn.this.getY());
			float f2 = (float) (EntityHasturSpawn.this.orbitOffset.z - EntityHasturSpawn.this.getZ());
			double d0 = Mth.sqrt(f * f + f2 * f2);
			double d1 = 1.0D - Mth.abs(f1 * 0.7F) / d0;
			f = (float) (f * d1);
			f2 = (float) (f2 * d1);
			d0 = Mth.sqrt(f * f + f2 * f2);
			double d2 = Mth.sqrt(f * f + f2 * f2 + f1 * f1);
			float f3 = EntityHasturSpawn.this.getYRot();
			float f4 = (float) Mth.atan2(f2, f);
			float f5 = Mth.wrapDegrees(EntityHasturSpawn.this.getYRot() + 90.0F);
			float f6 = Mth.wrapDegrees(f4 * (180F / (float) Math.PI));
			EntityHasturSpawn.this.yBodyRot = Mth.approachDegrees(f5, f6, 4.0F) - 90.0F;
			EntityHasturSpawn.this.yBodyRot = EntityHasturSpawn.this.getYRot();
			if (Mth.degreesDifferenceAbs(f3, EntityHasturSpawn.this.getYRot()) < 3.0F) {
				this.speedFactor = Mth.approach(this.speedFactor, 1.8F, 0.005F * (1.8F / this.speedFactor));
			} else {
				this.speedFactor = Mth.approach(this.speedFactor, 0.2F, 0.025F);
			}

			float f7 = (float) (-(Mth.atan2((-f1), d0) * (180F / (float) Math.PI)));
			//EntityHasturSpawn.this.getXRot() = f7;
			float f8 = EntityHasturSpawn.this.getYRot() + 90.0F;
			double d3 = this.speedFactor * Mth.cos(f8 * ((float) Math.PI / 180F)) * Math.abs(f / d2);
			double d4 = this.speedFactor * Mth.sin(f8 * ((float) Math.PI / 180F)) * Math.abs(f2 / d2);
			double d5 = this.speedFactor * Mth.sin(f7 * ((float) Math.PI / 180F)) * Math.abs(f1 / d2);
			Vec3 vector3d = EntityHasturSpawn.this.getDeltaMovement();
			EntityHasturSpawn.this
					.setDeltaMovement(vector3d.add((new Vec3(d3, d5, d4)).subtract(vector3d).scale(0.2D)));
		}
	}
	class OrbitPointGoal extends EntityHasturSpawn.MoveGoal {
		private float angle;
		private float distance;
		private float height;
		private float clockwise;

		private OrbitPointGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		@Override
		public boolean canUse() {
			return EntityHasturSpawn.this.getTarget() == null
					|| EntityHasturSpawn.this.attackPhase == EntityHasturSpawn.AttackPhase.CIRCLE;
		}

		private void selectNext() {
			if (BlockPos.ZERO.equals(EntityHasturSpawn.this.orbitPosition)) {
				EntityHasturSpawn.this.orbitPosition = EntityHasturSpawn.this.blockPosition();
			}

			this.angle += this.clockwise * 15.0F * ((float) Math.PI / 180F);
			EntityHasturSpawn.this.orbitOffset = Vec3.atLowerCornerOf(EntityHasturSpawn.this.orbitPosition)
					.add(this.distance * Mth.cos(this.angle), -4.0F + this.height, this.distance * Mth.sin(this.angle));
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		@Override
		public void start() {
			this.distance = 5.0F + EntityHasturSpawn.this.random.nextFloat() * 10.0F;
			this.height = -4.0F + EntityHasturSpawn.this.random.nextFloat() * 9.0F;
			this.clockwise = EntityHasturSpawn.this.random.nextBoolean() ? 1.0F : -1.0F;
			this.selectNext();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		public void tick() {
			if (EntityHasturSpawn.this.random.nextInt(350) == 0) {
				this.height = -4.0F + EntityHasturSpawn.this.random.nextFloat() * 1.0F;
			}

			if (EntityHasturSpawn.this.random.nextInt(250) == 0) {
				++this.distance;
				if (this.distance > 15.0F) {
					this.distance = 5.0F;
					this.clockwise = -this.clockwise;
				}
			}

			if (EntityHasturSpawn.this.random.nextInt(450) == 0) {
				this.angle = EntityHasturSpawn.this.random.nextFloat() * 2.0F * (float) Math.PI;
				this.selectNext();
			}

			if (this.touchingTarget()) {
				this.selectNext();
			}

			if (EntityHasturSpawn.this.orbitOffset.y < EntityHasturSpawn.this.getY()
					&& !EntityHasturSpawn.this.level().isEmptyBlock(EntityHasturSpawn.this.blockPosition().below(1))) {
				this.height = Math.max(1.0F, this.height);
				this.selectNext();
			}

			if (EntityHasturSpawn.this.orbitOffset.y > EntityHasturSpawn.this.getY()
					&& !EntityHasturSpawn.this.level().isEmptyBlock(EntityHasturSpawn.this.blockPosition().above(1))) {
				this.height = Math.min(-1.0F, this.height);
				this.selectNext();
			}

		}
	}
	class PickAttackGoal extends Goal {
		private int tickDelay;

		private PickAttackGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		@Override
		public boolean canUse() {
			LivingEntity livingentity = EntityHasturSpawn.this.getTarget();
			return livingentity != null
					? EntityHasturSpawn.this.canAttack(EntityHasturSpawn.this.getTarget(), TargetingConditions.DEFAULT)
					: false;
		}

		private void setAnchorAboveTarget() {
			EntityHasturSpawn.this.orbitPosition = EntityHasturSpawn.this.getTarget().blockPosition()
					.above(5 /* + EntityHasturSpawn.this.rand.nextInt(5) */);
			if (EntityHasturSpawn.this.orbitPosition.getY() < EntityHasturSpawn.this.level().getSeaLevel()) {
				EntityHasturSpawn.this.orbitPosition = BlockPos.containing(EntityHasturSpawn.this.orbitPosition.getX(),
						EntityHasturSpawn.this.getTarget().getY() + 13, EntityHasturSpawn.this.orbitPosition.getZ());
			}

		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		@Override
		public void start() {
			this.tickDelay = 10;
			EntityHasturSpawn.this.attackPhase = EntityHasturSpawn.AttackPhase.CIRCLE;
			this.setAnchorAboveTarget();
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		@Override
		public void stop() {
			EntityHasturSpawn.this.orbitPosition = EntityHasturSpawn.this.level()
					.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, EntityHasturSpawn.this.orbitPosition)
					.above(5/* + EntityHasturSpawn.this.rand.nextInt(5) */);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		public void tick() {
			if (EntityHasturSpawn.this.attackPhase == EntityHasturSpawn.AttackPhase.CIRCLE) {
				--this.tickDelay;
				if (this.tickDelay <= 0) {
					EntityHasturSpawn.this.attackPhase = EntityHasturSpawn.AttackPhase.SWOOP;
					this.setAnchorAboveTarget();
					this.tickDelay = (8 + EntityHasturSpawn.this.random.nextInt(4)) * 20;
					EntityHasturSpawn.this.playSound(SoundEvents.PHANTOM_SWOOP, 10.0F,
							0.95F + EntityHasturSpawn.this.random.nextFloat() * 0.1F);
				}
			}

		}
	}

	class SweepAttackGoal extends EntityHasturSpawn.MoveGoal {
		/**
		 * Keep ticking a continuous task that has already been started
		 */
		Random rand = new Random();

		private SweepAttackGoal() {
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		@Override
		public boolean canContinueToUse() {
			LivingEntity livingentity = EntityHasturSpawn.this.getTarget();
			if (livingentity == null) {
				return false;
			} else if (!livingentity.isAlive()) {
				return false;
			} else if (!(livingentity instanceof Player)
					|| !((Player) livingentity).isSpectator() && !((Player) livingentity).isCreative()) {
				if (!this.canUse()) {
					return false;
				} else {
					if (EntityHasturSpawn.this.tickCount % 20 == 0) {
						List<Cat> list = EntityHasturSpawn.this.level().getEntitiesOfClass(Cat.class,
								EntityHasturSpawn.this.getBoundingBox().inflate(16.0D),
								EntitySelector.ENTITY_STILL_ALIVE);
						if (!list.isEmpty()) {
							for (Cat catentity : list) {
								catentity.hiss();
							}

							return false;
						}
					}

					return true;
				}
			} else {
				return false;
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		@Override
		public boolean canUse() {
			return EntityHasturSpawn.this.getTarget() != null
					&& EntityHasturSpawn.this.attackPhase == EntityHasturSpawn.AttackPhase.SWOOP;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		@Override
		public void start() {
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		@Override
		public void stop() {
			EntityHasturSpawn.this.setTarget((LivingEntity) null);
			EntityHasturSpawn.this.attackPhase = EntityHasturSpawn.AttackPhase.CIRCLE;
		}

		@Override
		public void tick() {

			LivingEntity livingentity = EntityHasturSpawn.this.getTarget();
			EntityHasturSpawn.this.orbitOffset = new Vec3(livingentity.getX(), livingentity.getY(0.5D),
					livingentity.getZ());
			if (EntityHasturSpawn.this.getBoundingBox().inflate(0.2F).intersects(livingentity.getBoundingBox())) {
				// EntityHasturSpawn.this.attackEntityAsMob(livingentity);
				livingentity.hurt(livingentity.damageSources().generic(), 1.5f);

				EntityHasturSpawn.this.attackPhase = EntityHasturSpawn.AttackPhase.CIRCLE;
				if (!EntityHasturSpawn.this.isSilent()) {
					EntityHasturSpawn.this.level().levelEvent(1039, EntityHasturSpawn.this.blockPosition(), 0);
				}
			} else if (EntityHasturSpawn.this.horizontalCollision || EntityHasturSpawn.this.hurtTime > 0) {
				EntityHasturSpawn.this.attackPhase = EntityHasturSpawn.AttackPhase.CIRCLE;
			}

		}
	}

	private static final EntityDataAccessor<Integer> SIZE = SynchedEntityData.defineId(EntityHasturSpawn.class,
			EntityDataSerializers.INT);

	private static final EntityDataAccessor<Integer> SPAWN_TYPE = SynchedEntityData.defineId(EntityHasturSpawn.class,
			EntityDataSerializers.INT);

	public static final Map<Integer, ResourceLocation> TEXTURE_BY_ID = Util.make(Maps.newHashMap(), (p_213410_0_) -> {
		p_213410_0_.put(0, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/hastur_spawn/model_hastur_spawn_green.png"));
		p_213410_0_.put(1, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/hastur_spawn/model_hastur_spawn_brown.png"));
		p_213410_0_.put(2, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/hastur_spawn/model_hastur_spawn_grey.png"));
	});

	public static AttributeSupplier.Builder setAttributes() {
		return LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 16.0D).add(Attributes.ATTACK_DAMAGE,
				1);
	}

	private Vec3 orbitOffset = Vec3.ZERO;

	private BlockPos orbitPosition = BlockPos.ZERO;

	private EntityHasturSpawn.AttackPhase attackPhase = EntityHasturSpawn.AttackPhase.CIRCLE;

	public float deathTicks = 1;

	public EntityHasturSpawn(EntityType<? extends EntityHasturSpawn> type, Level worldIn) {
		super(type, worldIn);
		this.xpReward = 5;
		this.moveControl = new EntityHasturSpawn.MoveHelperController(this);
		this.lookControl = new EntityHasturSpawn.LookHelperController(this);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("AX", this.orbitPosition.getX());
		compound.putInt("AY", this.orbitPosition.getY());
		compound.putInt("AZ", this.orbitPosition.getZ());
		compound.putInt("Size", this.getPhantomSize());
	}

	/**
	 * Called frequently so the entity can update its state every tick as required.
	 * For example, zombies and skeletons use this to react to sunlight and start to
	 * burn.
	 */
	@Override
	public void aiStep() {
		if (this.isAlive() && this.isSunBurnTick()) {
			// this.setFire(8);
		}

		super.aiStep();
	}

	@Override
	public boolean canAttackType(EntityType<?> typeIn) {
		return true;
	}

	@Override
	protected BodyRotationControl createBodyControl() {
		return new EntityHasturSpawn.BodyHelperController(this);
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SIZE, 0);
		this.entityData.define(SPAWN_TYPE, 1);
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn,
			MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		this.orbitPosition = this.blockPosition().above(5);
		this.setPhantomSize(0);
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setSpawnType(this.random.nextInt(4));
		this.populateDefaultEquipmentSlots(random, difficultyIn);

		return spawnDataIn;

	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.PHANTOM_AMBIENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.PHANTOM_DEATH;
	}

	@Override
	public EntityDimensions getDimensions(Pose poseIn) {
		int i = this.getPhantomSize();
		EntityDimensions entitysize = super.getDimensions(poseIn);
		float f = (entitysize.width + 0.2F * i) / entitysize.width;
		return entitysize.scale(f);
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.PHANTOM_HURT;
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEAD;
	}

	public int getPhantomSize() {
		return this.entityData.get(SIZE);
	}

	@Override
	public SoundSource getSoundSource() {
		return SoundSource.HOSTILE;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 0.3F;
	}
	
	
//	public int getSpawnType() {
//		return this.entityData.get(SPAWN_TYPE).va;
//	} 
	
	public ResourceLocation getSpawnTypeName() {
		return TEXTURE_BY_ID.getOrDefault(this.getSpawnType(), TEXTURE_BY_ID.get(0));
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		return sizeIn.height * 0.35F;
	}

	@Override
	public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
		if (SIZE.equals(key)) {
			this.updatePhantomSize();
		}

		super.onSyncedDataUpdated(key);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("AX")) {
			this.orbitPosition = new BlockPos(compound.getInt("AX"), compound.getInt("AY"), compound.getInt("AZ"));
		}

		this.setPhantomSize(compound.getInt("Size"));
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new EntityHasturSpawn.PickAttackGoal());
		this.goalSelector.addGoal(2, new EntityHasturSpawn.SweepAttackGoal());
		this.goalSelector.addGoal(3, new EntityHasturSpawn.OrbitPointGoal());
	//	this.targetSelector.addGoal(1, new EntityHasturSpawn.AttackPlayerGoal());
	}

//	class AttackPlayerGoal extends Goal {
//		private final TargetingConditions attackTargeting = (new TargetingConditions()).range(64.0D);
//		private int tickDelay = 20;
//
//		private AttackPlayerGoal() {
//		}
//
//		/**
//		 * Returns whether execution should begin. You can also read and cache any state
//		 * necessary for execution in this method as well.
//		 */
//		@Override
//		public boolean canUse() {
//			if (this.tickDelay > 0) {
//				--this.tickDelay;
//				return false;
//			} else {
//				this.tickDelay = 60;
//				List<Player> list = EntityHasturSpawn.this.level().getNearbyPlayers(this.attackTargeting,
//						EntityHasturSpawn.this, EntityHasturSpawn.this.getBoundingBox().inflate(16.0D, 64.0D, 16.0D));
//				if (!list.isEmpty()) {
//					list.sort(Comparator.<Entity, Double>comparing(Entity::getY).reversed());
//
//					for (Player playerentity : list) {
//						if (EntityHasturSpawn.this.canAttack(playerentity, TargetingConditions.DEFAULT)) {
//							EntityHasturSpawn.this.setTarget(playerentity);
//							return true;
//						}
//					}
//				}
//
//				return false;
//			}
//		}
//
//		/**
//		 * Returns whether an in-progress EntityAIBase should continue executing
//		 */
//		@Override
//		public boolean canContinueToUse() {
//			LivingEntity livingentity = EntityHasturSpawn.this.getTarget();
//			return livingentity != null ? EntityHasturSpawn.this.canAttack(livingentity, TargetingConditions.DEFAULT)
//					: false;
//		}
//	}

	public void setPhantomSize(int sizeIn) {
		this.entityData.set(SIZE, Mth.clamp(sizeIn, 0, 64));
	}

	public void setSpawnType(int type) {
		if (type <= 0 || type >= 4) {
			type = this.random.nextInt(5);
		}

		this.entityData.set(SPAWN_TYPE, type);
	}

	@Override
	protected boolean shouldDespawnInPeaceful() {
		return true;
	}

	/**
	 * Checks if the entity is in range to render.
	 */
	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean shouldRenderAtSqrDistance(double distance) {
		return true;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void tick() {
		super.tick();

		// Particle Effects
		float g = (this.random.nextFloat() - 0.5F) * 2.0F;
		float g1 = -1;
		float g2 = (this.random.nextFloat() - 0.5F) * 2.0F;
		if (tickCount < 2) {
			this.level().addParticle(ParticleTypes.POOF, this.getX() + g, this.getY() + 2.0D + g1, this.getZ() + g2, 0.0D,
					0.0D, 0.0D);
		}
		if (tickCount > 2 && tickCount < 20) {
			this.level().addParticle(ParticleTypes.ITEM_SLIME, this.getX() + g, this.getY() + 2.0D + g1, this.getZ() + g2,
					0.0D, 0.0D, 0.0D);
		}
		if (tickCount > 150 && tickCount < 200) {
			this.level().addParticle(ParticleTypes.ITEM_SLIME, this.getX() + g, this.getY() + 2.0D + g1, this.getZ() + g2,
					0.0D, 0.0D, 0.0D);

		}
		if (tickCount == 200) {
			this.level().addParticle(ParticleTypes.POOF, this.getX() + g, this.getY() + 2.0D + g1, this.getZ() + g2, 0.0D,
					0.0D, 0.0D);
			if (!this.level().isClientSide) {
				// this.remove(RemovalReason.KILLED);
				this.setHealth(0);
			} else {
				if (!level().isClientSide) {
					level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.SLIME_DEATH,
							SoundSource.HOSTILE, 3f, 1.2f, false);
				}
			}
		}

		if (this.level().isClientSide) {
			float f = Mth.cos((this.getId() * 3 + this.tickCount) * 0.13F + (float) Math.PI);
			float f1 = Mth.cos((this.getId() * 3 + this.tickCount + 1) * 0.13F + (float) Math.PI);
			if (f > 0.0F && f1 <= 0.0F) {
				this.level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.PHANTOM_FLAP,
						this.getSoundSource(), 0.95F + this.random.nextFloat() * 0.05F,
						0.95F + this.random.nextFloat() * 0.05F, false);
			}
		}
	}

	@Override
	protected void tickDeath() {
		// Particle Effects
		float g = (this.random.nextFloat() - 0.5F) * 2.0F;
		float g1 = -1;
		float g2 = (this.random.nextFloat() - 0.5F) * 2.0F;
		deathTicks -= 0.05;
		if (this.deathTicks <= 0.1) {
			if (level().isClientSide) {
				level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.SLIME_BLOCK_BREAK,
						SoundSource.HOSTILE, 3f, 0.2f, false);
				this.level().addParticle(ParticleTypes.POOF, this.getX() + g, this.getY() + 2.0D + g1, this.getZ() + g2,
						0.0D, 0.0D, 0.0D);
			}
		}

		if (this.deathTicks <= 0.1 && !this.level().isClientSide) {
			this.remove(RemovalReason.KILLED);
		}

	}

	private void updatePhantomSize() {
		this.refreshDimensions();
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(6 + this.getPhantomSize());
	}
}