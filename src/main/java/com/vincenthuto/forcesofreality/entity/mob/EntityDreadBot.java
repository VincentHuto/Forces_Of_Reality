package com.vincenthuto.forcesofreality.entity.mob;

import javax.annotation.Nullable;

import com.vincenthuto.forcesofreality.entity.util.GoalFireDreadRocket;
import com.vincenthuto.forcesofreality.init.SoundInit;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class EntityDreadBot extends Monster {
	public static AttributeSupplier.Builder setAttributes() {
		return LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 5.0D).add(Attributes.ATTACK_KNOCKBACK)
				.add(Attributes.MOVEMENT_SPEED, 0.2f).add(Attributes.MAX_HEALTH, 10.5f);
	}

	public float deathTicks = 1;

	public EntityDreadBot(EntityType<? extends EntityDreadBot> type, Level worldIn) {
		super(type, worldIn);

	}

	@Override
	protected int calculateFallDamage(float distance, float damageMultiplier) {
		return 0;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();

	}

	@Override
	protected void doPush(Entity entityIn) {
		super.doPush(entityIn);
		/*
		 * if (!(entityIn instanceof EntityDreadBot || entityIn instanceof
		 * EntityHastur)) { entityIn.attackEntityFrom(DamageSource.causeMobDamage(this),
		 * 1.5f); }
		 */

	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn,
			MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);

		return spawnDataIn;

	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.ENTITY_DREADBOT_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.ENTITY_DREADBOT_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ENTITY_DREADBOT_HURT.get();
	}

	@Override
	protected float getSoundVolume() {
		return 0.3f;
	}

	@Override
	public void playerTouch(Player entityIn) {
		// entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 1f);

	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(6, new GoalFireDreadRocket(this));
		this.targetSelector.addGoal(1, new GoalFireDreadRocket(this));

	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void tickDeath() {
		super.tickDeath();
		// this.remove(RemovalReason.KILLED);

	}
}
