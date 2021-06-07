package com.huto.forcesofreality.entity.summon;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.huto.forcesofreality.ForcesOfReality;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.BodyController;
import net.minecraft.entity.ai.controller.LookController;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntityHasturSpawn extends FlyingEntity implements IMob {
	private static final DataParameter<Integer> SIZE = EntityDataManager.createKey(EntityHasturSpawn.class,
			DataSerializers.VARINT);
	private Vector3d orbitOffset = Vector3d.ZERO;
	private BlockPos orbitPosition = BlockPos.ZERO;
	private EntityHasturSpawn.AttackPhase attackPhase = EntityHasturSpawn.AttackPhase.CIRCLE;
	private static final DataParameter<Integer> SPAWN_TYPE = EntityDataManager.createKey(EntityHasturSpawn.class,
			DataSerializers.VARINT);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_ID = Util.make(Maps.newHashMap(), (p_213410_0_) -> {
		p_213410_0_.put(0,
				new ResourceLocation(ForcesOfReality.MOD_ID, "textures/entity/hastur_spawn/model_hastur_spawn_green.png"));
		p_213410_0_.put(1,
				new ResourceLocation(ForcesOfReality.MOD_ID, "textures/entity/hastur_spawn/model_hastur_spawn_brown.png"));
		p_213410_0_.put(2,
				new ResourceLocation(ForcesOfReality.MOD_ID, "textures/entity/hastur_spawn/model_hastur_spawn_grey.png"));
	});
	public float deathTicks = 1;

	public EntityHasturSpawn(EntityType<? extends EntityHasturSpawn> type, World worldIn) {
		super(type, worldIn);
		this.experienceValue = 5;
		this.moveController = new EntityHasturSpawn.MoveHelperController(this);
		this.lookController = new EntityHasturSpawn.LookHelperController(this);
	}

	public ResourceLocation getSpawnTypeName() {
		return TEXTURE_BY_ID.getOrDefault(this.getSpawnType(), TEXTURE_BY_ID.get(0));
	}

	public int getSpawnType() {
		return this.dataManager.get(SPAWN_TYPE);
	}

	public void setSpawnType(int type) {
		if (type <= 0 || type >= 4) {
			type = this.rand.nextInt(5);
		}

		this.dataManager.set(SPAWN_TYPE, type);
	}



	protected BodyController createBodyController() {
		return new EntityHasturSpawn.BodyHelperController(this);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(1, new EntityHasturSpawn.PickAttackGoal());
		this.goalSelector.addGoal(2, new EntityHasturSpawn.SweepAttackGoal());
		this.goalSelector.addGoal(3, new EntityHasturSpawn.OrbitPointGoal());
		this.targetSelector.addGoal(1, new EntityHasturSpawn.AttackPlayerGoal());
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(SIZE, 0);
		this.dataManager.register(SPAWN_TYPE, 1);
	}

	public void setPhantomSize(int sizeIn) {
		this.dataManager.set(SIZE, MathHelper.clamp(sizeIn, 0, 64));
	}

	private void updatePhantomSize() {
		this.recalculateSize();
		this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((double) (6 + this.getPhantomSize()));
	}

	public int getPhantomSize() {
		return this.dataManager.get(SIZE);
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return sizeIn.height * 0.35F;
	}

	@Override
	public void notifyDataManagerChange(DataParameter<?> key) {
		if (SIZE.equals(key)) {
			this.updatePhantomSize();
		}

		super.notifyDataManagerChange(key);
	}

	@Override
	protected boolean isDespawnPeaceful() {
		return true;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void tick() {
		super.tick();

		// Particle Effects
		float g = (this.rand.nextFloat() - 0.5F) * 2.0F;
		float g1 = -1;
		float g2 = (this.rand.nextFloat() - 0.5F) * 2.0F;
		if (ticksExisted < 2) {
			this.world.addParticle(ParticleTypes.POOF, this.getPosX() + (double) g, this.getPosY() + 2.0D + (double) g1,
					this.getPosZ() + (double) g2, 0.0D, 0.0D, 0.0D);
		}
		if (ticksExisted > 2 && ticksExisted < 20) {
			this.world.addParticle(ParticleTypes.ITEM_SLIME, this.getPosX() + (double) g,
					this.getPosY() + 2.0D + (double) g1, this.getPosZ() + (double) g2, 0.0D, 0.0D, 0.0D);
		}
		if (ticksExisted > 150 && ticksExisted < 200) {
			this.world.addParticle(ParticleTypes.ITEM_SLIME, this.getPosX() + (double) g,
					this.getPosY() + 2.0D + (double) g1, this.getPosZ() + (double) g2, 0.0D, 0.0D, 0.0D);

		}
		if (ticksExisted == 200) {
			this.world.addParticle(ParticleTypes.POOF, this.getPosX() + (double) g, this.getPosY() + 2.0D + (double) g1,
					this.getPosZ() + (double) g2, 0.0D, 0.0D, 0.0D);
			if (!this.world.isRemote) {
				// this.remove();
				this.setHealth(0);
			} else {
				if (!world.isRemote) {
					world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_SLIME_DEATH,
							SoundCategory.HOSTILE, 3f, 1.2f, false);
				}
			}
		}

		if (this.world.isRemote) {
			float f = MathHelper.cos((float) (this.getEntityId() * 3 + this.ticksExisted) * 0.13F + (float) Math.PI);
			float f1 = MathHelper
					.cos((float) (this.getEntityId() * 3 + this.ticksExisted + 1) * 0.13F + (float) Math.PI);
			if (f > 0.0F && f1 <= 0.0F) {
				this.world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_PHANTOM_FLAP,
						this.getSoundCategory(), 0.95F + this.rand.nextFloat() * 0.05F,
						0.95F + this.rand.nextFloat() * 0.05F, false);
			}
		}
	}

	/**
	 * Called frequently so the entity can update its state every tick as required.
	 * For example, zombies and skeletons use this to react to sunlight and start to
	 * burn.
	 */
	@Override
	public void livingTick() {
		if (this.isAlive() && this.isInDaylight()) {
			// this.setFire(8);
		}

		super.livingTick();
	}

	@Override
	protected void onDeathUpdate() {
		// Particle Effects
		float g = (this.rand.nextFloat() - 0.5F) * 2.0F;
		float g1 = -1;
		float g2 = (this.rand.nextFloat() - 0.5F) * 2.0F;
		deathTicks -= 0.05;
		if (this.deathTicks <= 0.1) {
			if (world.isRemote) {
				world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.BLOCK_SLIME_BLOCK_BREAK,
						SoundCategory.HOSTILE, 3f, 0.2f, false);
				this.world.addParticle(ParticleTypes.POOF, this.getPosX() + (double) g,
						this.getPosY() + 2.0D + (double) g1, this.getPosZ() + (double) g2, 0.0D, 0.0D, 0.0D);
			}
		}

		if (this.deathTicks <= 0.1 && !this.world.isRemote) {
			this.remove();
		}

	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();
	}

	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		this.orbitPosition = this.getPosition().up(5);
		this.setPhantomSize(0);
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setSpawnType(this.rand.nextInt(4));
		this.setEquipmentBasedOnDifficulty(difficultyIn);
		World world = worldIn.getWorld();
		if (world instanceof ServerWorld && ((ServerWorld) world).getStructureManager()
				.getStructureStart(this.getPosition(), true, Structure.SWAMP_HUT).isValid()) {
			this.setSpawnType(1);
			this.enablePersistence();
		}

		return spawnDataIn;

	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		if (compound.contains("AX")) {
			this.orbitPosition = new BlockPos(compound.getInt("AX"), compound.getInt("AY"), compound.getInt("AZ"));
		}

		this.setPhantomSize(compound.getInt("Size"));
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putInt("AX", this.orbitPosition.getX());
		compound.putInt("AY", this.orbitPosition.getY());
		compound.putInt("AZ", this.orbitPosition.getZ());
		compound.putInt("Size", this.getPhantomSize());
	}

	/**
	 * Checks if the entity is in range to render.
	 */
	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isInRangeToRenderDist(double distance) {
		return true;
	}

	@Override
	public SoundCategory getSoundCategory() {
		return SoundCategory.HOSTILE;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_PHANTOM_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_PHANTOM_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_PHANTOM_DEATH;
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}

	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 1);
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 0.3F;
	}

	@Override
	public boolean canAttack(EntityType<?> typeIn) {
		return true;
	}

	@Override
	public EntitySize getSize(Pose poseIn) {
		int i = this.getPhantomSize();
		EntitySize entitysize = super.getSize(poseIn);
		float f = (entitysize.width + 0.2F * (float) i) / entitysize.width;
		return entitysize.scale(f);
	}

	static enum AttackPhase {
		CIRCLE, SWOOP;
	}

	class AttackPlayerGoal extends Goal {
		private final EntityPredicate field_220842_b = (new EntityPredicate()).setDistance(64.0D);
		private int tickDelay = 20;

		private AttackPlayerGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			if (this.tickDelay > 0) {
				--this.tickDelay;
				return false;
			} else {
				this.tickDelay = 60;
				List<PlayerEntity> list = EntityHasturSpawn.this.world.getTargettablePlayersWithinAABB(
						this.field_220842_b, EntityHasturSpawn.this,
						EntityHasturSpawn.this.getBoundingBox().grow(16.0D, 64.0D, 16.0D));
				if (!list.isEmpty()) {
					list.sort(Comparator.<Entity, Double>comparing(Entity::getPosY).reversed());

					for (PlayerEntity playerentity : list) {
						if (EntityHasturSpawn.this.canAttack(playerentity, EntityPredicate.DEFAULT)) {
							EntityHasturSpawn.this.setAttackTarget(playerentity);
							return true;
						}
					}
				}

				return false;
			}
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			LivingEntity livingentity = EntityHasturSpawn.this.getAttackTarget();
			return livingentity != null ? EntityHasturSpawn.this.canAttack(livingentity, EntityPredicate.DEFAULT)
					: false;
		}
	}

	class BodyHelperController extends BodyController {
		public BodyHelperController(MobEntity mob) {
			super(mob);
		}

		/**
		 * Update the Head and Body rendenring angles
		 */
		public void updateRenderAngles() {
			EntityHasturSpawn.this.rotationYawHead = EntityHasturSpawn.this.renderYawOffset;
			EntityHasturSpawn.this.renderYawOffset = EntityHasturSpawn.this.rotationYaw;
		}
	}

	class LookHelperController extends LookController {
		public LookHelperController(MobEntity entityIn) {
			super(entityIn);
		}

		/**
		 * Updates look
		 */
		public void tick() {
		}
	}

	abstract class MoveGoal extends Goal {
		public MoveGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		protected boolean func_203146_f() {
			return EntityHasturSpawn.this.orbitOffset.squareDistanceTo(EntityHasturSpawn.this.getPosX(),
					EntityHasturSpawn.this.getPosY(), EntityHasturSpawn.this.getPosZ()) < 4.0D;
		}
	}

	class MoveHelperController extends MovementController {
		private float speedFactor = 0.1F;

		public MoveHelperController(MobEntity entityIn) {
			super(entityIn);
		}

		public void tick() {
			if (EntityHasturSpawn.this.collidedHorizontally) {
				EntityHasturSpawn.this.rotationYaw += 180.0F;
				this.speedFactor = 0.1F;
			}

			float f = (float) (EntityHasturSpawn.this.orbitOffset.x - EntityHasturSpawn.this.getPosX());
			float f1 = (float) (EntityHasturSpawn.this.orbitOffset.y - EntityHasturSpawn.this.getPosY());
			float f2 = (float) (EntityHasturSpawn.this.orbitOffset.z - EntityHasturSpawn.this.getPosZ());
			double d0 = (double) MathHelper.sqrt(f * f + f2 * f2);
			double d1 = 1.0D - (double) MathHelper.abs(f1 * 0.7F) / d0;
			f = (float) ((double) f * d1);
			f2 = (float) ((double) f2 * d1);
			d0 = (double) MathHelper.sqrt(f * f + f2 * f2);
			double d2 = (double) MathHelper.sqrt(f * f + f2 * f2 + f1 * f1);
			float f3 = EntityHasturSpawn.this.rotationYaw;
			float f4 = (float) MathHelper.atan2((double) f2, (double) f);
			float f5 = MathHelper.wrapDegrees(EntityHasturSpawn.this.rotationYaw + 90.0F);
			float f6 = MathHelper.wrapDegrees(f4 * (180F / (float) Math.PI));
			EntityHasturSpawn.this.rotationYaw = MathHelper.approachDegrees(f5, f6, 4.0F) - 90.0F;
			EntityHasturSpawn.this.renderYawOffset = EntityHasturSpawn.this.rotationYaw;
			if (MathHelper.degreesDifferenceAbs(f3, EntityHasturSpawn.this.rotationYaw) < 3.0F) {
				this.speedFactor = MathHelper.approach(this.speedFactor, 1.8F, 0.005F * (1.8F / this.speedFactor));
			} else {
				this.speedFactor = MathHelper.approach(this.speedFactor, 0.2F, 0.025F);
			}

			float f7 = (float) (-(MathHelper.atan2((double) (-f1), d0) * (double) (180F / (float) Math.PI)));
			EntityHasturSpawn.this.rotationPitch = f7;
			float f8 = EntityHasturSpawn.this.rotationYaw + 90.0F;
			double d3 = (double) (this.speedFactor * MathHelper.cos(f8 * ((float) Math.PI / 180F)))
					* Math.abs((double) f / d2);
			double d4 = (double) (this.speedFactor * MathHelper.sin(f8 * ((float) Math.PI / 180F)))
					* Math.abs((double) f2 / d2);
			double d5 = (double) (this.speedFactor * MathHelper.sin(f7 * ((float) Math.PI / 180F)))
					* Math.abs((double) f1 / d2);
			Vector3d vector3d = EntityHasturSpawn.this.getMotion();
			EntityHasturSpawn.this.setMotion(vector3d.add((new Vector3d(d3, d5, d4)).subtract(vector3d).scale(0.2D)));
		}
	}

	class OrbitPointGoal extends EntityHasturSpawn.MoveGoal {
		private float field_203150_c;
		private float field_203151_d;
		private float field_203152_e;
		private float field_203153_f;

		private OrbitPointGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			return EntityHasturSpawn.this.getAttackTarget() == null
					|| EntityHasturSpawn.this.attackPhase == EntityHasturSpawn.AttackPhase.CIRCLE;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.field_203151_d = 5.0F + EntityHasturSpawn.this.rand.nextFloat() * 10.0F;
			this.field_203152_e = -4.0F + EntityHasturSpawn.this.rand.nextFloat() * 9.0F;
			this.field_203153_f = EntityHasturSpawn.this.rand.nextBoolean() ? 1.0F : -1.0F;
			this.func_203148_i();
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (EntityHasturSpawn.this.rand.nextInt(350) == 0) {
				this.field_203152_e = -4.0F + EntityHasturSpawn.this.rand.nextFloat() * 1.0F;
			}

			if (EntityHasturSpawn.this.rand.nextInt(250) == 0) {
				++this.field_203151_d;
				if (this.field_203151_d > 15.0F) {
					this.field_203151_d = 5.0F;
					this.field_203153_f = -this.field_203153_f;
				}
			}

			if (EntityHasturSpawn.this.rand.nextInt(450) == 0) {
				this.field_203150_c = EntityHasturSpawn.this.rand.nextFloat() * 2.0F * (float) Math.PI;
				this.func_203148_i();
			}

			if (this.func_203146_f()) {
				this.func_203148_i();
			}

			if (EntityHasturSpawn.this.orbitOffset.y < EntityHasturSpawn.this.getPosY()
					&& !EntityHasturSpawn.this.world.isAirBlock(EntityHasturSpawn.this.getPosition().down(1))) {
				this.field_203152_e = Math.max(1.0F, this.field_203152_e);
				this.func_203148_i();
			}

			if (EntityHasturSpawn.this.orbitOffset.y > EntityHasturSpawn.this.getPosY()
					&& !EntityHasturSpawn.this.world.isAirBlock(EntityHasturSpawn.this.getPosition().up(1))) {
				this.field_203152_e = Math.min(-1.0F, this.field_203152_e);
				this.func_203148_i();
			}

		}

		private void func_203148_i() {
			if (BlockPos.ZERO.equals(EntityHasturSpawn.this.orbitPosition)) {
				EntityHasturSpawn.this.orbitPosition = EntityHasturSpawn.this.getPosition();
			}

			this.field_203150_c += this.field_203153_f * 15.0F * ((float) Math.PI / 180F);
			EntityHasturSpawn.this.orbitOffset = Vector3d.copy(EntityHasturSpawn.this.orbitPosition).add(
					(double) (this.field_203151_d * MathHelper.cos(this.field_203150_c)),
					(double) (-4.0F + this.field_203152_e),
					(double) (this.field_203151_d * MathHelper.sin(this.field_203150_c)));
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
		public boolean shouldExecute() {
			LivingEntity livingentity = EntityHasturSpawn.this.getAttackTarget();
			return livingentity != null
					? EntityHasturSpawn.this.canAttack(EntityHasturSpawn.this.getAttackTarget(),
							EntityPredicate.DEFAULT)
					: false;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.tickDelay = 10;
			EntityHasturSpawn.this.attackPhase = EntityHasturSpawn.AttackPhase.CIRCLE;
			this.func_203143_f();
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		public void resetTask() {
			EntityHasturSpawn.this.orbitPosition = EntityHasturSpawn.this.world
					.getHeight(Heightmap.Type.MOTION_BLOCKING, EntityHasturSpawn.this.orbitPosition)
					.up(5/* + EntityHasturSpawn.this.rand.nextInt(5) */);
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			if (EntityHasturSpawn.this.attackPhase == EntityHasturSpawn.AttackPhase.CIRCLE) {
				--this.tickDelay;
				if (this.tickDelay <= 0) {
					EntityHasturSpawn.this.attackPhase = EntityHasturSpawn.AttackPhase.SWOOP;
					this.func_203143_f();
					this.tickDelay = (8 + EntityHasturSpawn.this.rand.nextInt(4)) * 20;
					EntityHasturSpawn.this.playSound(SoundEvents.ENTITY_PHANTOM_SWOOP, 10.0F,
							0.95F + EntityHasturSpawn.this.rand.nextFloat() * 0.1F);
				}
			}

		}

		private void func_203143_f() {
			EntityHasturSpawn.this.orbitPosition = EntityHasturSpawn.this.getAttackTarget().getPosition()
					.up(5 /* + EntityHasturSpawn.this.rand.nextInt(5) */);
			if (EntityHasturSpawn.this.orbitPosition.getY() < EntityHasturSpawn.this.world.getSeaLevel()) {
				EntityHasturSpawn.this.orbitPosition = new BlockPos(EntityHasturSpawn.this.orbitPosition.getX(),
						EntityHasturSpawn.this.getAttackTarget().getPosY() + 13,
						EntityHasturSpawn.this.orbitPosition.getZ());
			}

		}
	}

	class SweepAttackGoal extends EntityHasturSpawn.MoveGoal {
		private SweepAttackGoal() {
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			return EntityHasturSpawn.this.getAttackTarget() != null
					&& EntityHasturSpawn.this.attackPhase == EntityHasturSpawn.AttackPhase.SWOOP;
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			LivingEntity livingentity = EntityHasturSpawn.this.getAttackTarget();
			if (livingentity == null) {
				return false;
			} else if (!livingentity.isAlive()) {
				return false;
			} else if (!(livingentity instanceof PlayerEntity)
					|| !((PlayerEntity) livingentity).isSpectator() && !((PlayerEntity) livingentity).isCreative()) {
				if (!this.shouldExecute()) {
					return false;
				} else {
					if (EntityHasturSpawn.this.ticksExisted % 20 == 0) {
						List<CatEntity> list = EntityHasturSpawn.this.world.getEntitiesWithinAABB(CatEntity.class,
								EntityHasturSpawn.this.getBoundingBox().grow(16.0D), EntityPredicates.IS_ALIVE);
						if (!list.isEmpty()) {
							for (CatEntity catentity : list) {
								catentity.func_213420_ej();
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
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		public void resetTask() {
			EntityHasturSpawn.this.setAttackTarget((LivingEntity) null);
			EntityHasturSpawn.this.attackPhase = EntityHasturSpawn.AttackPhase.CIRCLE;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		Random rand = new Random();

		public void tick() {

			LivingEntity livingentity = EntityHasturSpawn.this.getAttackTarget();
			EntityHasturSpawn.this.orbitOffset = new Vector3d(livingentity.getPosX(), livingentity.getPosYHeight(0.5D),
					livingentity.getPosZ());
			if (EntityHasturSpawn.this.getBoundingBox().grow((double) 0.2F).intersects(livingentity.getBoundingBox())) {
				// EntityHasturSpawn.this.attackEntityAsMob(livingentity);
				livingentity.attackEntityFrom(DamageSource.causeMobDamage(EntityHasturSpawn.this), 1.5f);

				EntityHasturSpawn.this.attackPhase = EntityHasturSpawn.AttackPhase.CIRCLE;
				if (!EntityHasturSpawn.this.isSilent()) {
					EntityHasturSpawn.this.world.playEvent(1039, EntityHasturSpawn.this.getPosition(), 0);
				}
			} else if (EntityHasturSpawn.this.collidedHorizontally || EntityHasturSpawn.this.hurtTime > 0) {
				EntityHasturSpawn.this.attackPhase = EntityHasturSpawn.AttackPhase.CIRCLE;
			}

		}
	}
}