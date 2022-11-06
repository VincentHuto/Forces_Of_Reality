package com.vincenthuto.forcesofreality.entity.passive;

import javax.annotation.Nullable;

import com.vincenthuto.forcesofreality.init.EntityInit;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

public class EntityAngelicFowl extends Animal {
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.of(Items.WHEAT_SEEDS, Items.MELON_SEEDS,
			Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 4.0D).add(Attributes.MOVEMENT_SPEED, 0.25D);
	}
	public float wingRotation;
	public float destPos;
	public float oFlapSpeed;
	public float oFlap;
	public float wingRotDelta = 1.0F;
	public int timeUntilNextEgg = this.random.nextInt(6000) + 6000;

	public boolean chickenJockey;

	public EntityAngelicFowl(EntityType<? extends EntityAngelicFowl> type, Level worldIn) {
		super(type, worldIn);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("IsChickenJockey", this.chickenJockey);
		compound.putInt("EggLayTime", this.timeUntilNextEgg);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.oFlap = this.wingRotation;
		this.oFlapSpeed = this.destPos;
		this.destPos = (float) (this.destPos + (this.onGround ? -1 : 4) * 0.3D);
		this.destPos = Mth.clamp(this.destPos, 0.0F, 1.0F);
		if (!this.onGround && this.wingRotDelta < 1.0F) {
			this.wingRotDelta = 1.0F;
		}

		this.wingRotDelta = (float) (this.wingRotDelta * 0.9D);
		Vec3 vector3d = this.getDeltaMovement();
		if (!this.onGround && vector3d.y < 0.0D) {
			this.setDeltaMovement(vector3d.multiply(1.0D, 0.6D, 1.0D));
		}

		this.wingRotation += this.wingRotDelta * 2.0F;

		if (!this.level.isClientSide && this.isAlive() && !this.isBaby() && !this.isChickenJockey()
				&& --this.timeUntilNextEgg <= 0) {
			this.playSound(SoundEvents.CHICKEN_EGG, 1.0F,
					(this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			this.spawnAtLocation(Items.EGG);
			this.timeUntilNextEgg = this.random.nextInt(6000) + 6000;
		}

	}

	public boolean causeFallDamage(float distance, float damageMultiplier) {
		return false;
	}

	@Override
	public boolean checkSpawnRules(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
		/*
		 * if (world.getBiomeManager().getBiome(getPosition()) == ForgeRegistries.BIOMES
		 * .getValue(Biomes.LUKEWARM_OCEAN.getLocation())) { return true; } else {
		 * return super.; }
		 */
		return super.checkSpawnRules(worldIn, spawnReasonIn);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();

	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn,
			MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);

	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.CHICKEN_AMBIENT;
	}

	@Override
	public EntityAngelicFowl getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		return EntityInit.angelic_fowl.get().create(p_241840_1_);
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.CHICKEN_DEATH;
	}

	/**
	 * Get the experience points the entity currently has.
	 */
	protected int getExperienceReward(Player player) {
		return this.isChickenJockey() ? 10 : super.getExperienceReward();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.CHICKEN_HURT;
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		return this.isBaby() ? sizeIn.height * 0.85F : sizeIn.height * 0.92F;
	}

	/**
	 * Determines if this chicken is a jokey with a zombie riding it.
	 */
	public boolean isChickenJockey() {
		return this.chickenJockey;
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed it
	 * (wheat, carrots or seeds depending on the animal type)
	 */
	@Override
	public boolean isFood(ItemStack stack) {
		return TEMPTATION_ITEMS.test(stack);
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
	}

	@Override
	public void positionRider(Entity passenger) {
		super.positionRider(passenger);
		float f = Mth.sin(this.yBodyRot * ((float) Math.PI / 180F));
		float f1 = Mth.cos(this.yBodyRot * ((float) Math.PI / 180F));
		passenger.setPos(this.getX() + 0.1F * f, this.getY(0.5D) + passenger.getMyRidingOffset() + 0.0D,
				this.getZ() - 0.1F * f1);
		if (passenger instanceof LivingEntity) {
			((LivingEntity) passenger).yBodyRot = this.yBodyRot;
		}

	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		this.chickenJockey = compound.getBoolean("IsChickenJockey");
		if (compound.contains("EggLayTime")) {
			this.timeUntilNextEgg = compound.getInt("EggLayTime");
		}

	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, TEMPTATION_ITEMS, false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return this.isChickenJockey();
	}

	/**
	 * Sets whether this chicken is a jockey or not.
	 */
	public void setChickenJockey(boolean jockey) {
		this.chickenJockey = jockey;
	}
}