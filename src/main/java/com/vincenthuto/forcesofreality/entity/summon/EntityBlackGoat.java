package com.vincenthuto.forcesofreality.entity.summon;

import javax.annotation.Nullable;

import com.vincenthuto.forcesofreality.entity.guardian.EntityDarkYoung;
import com.vincenthuto.forcesofreality.entity.lord.EntityUzouthrhix;
import com.vincenthuto.forcesofreality.init.SoundInit;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class EntityBlackGoat extends Monster {
	public float deathTicks = 1;

	public EntityBlackGoat(EntityType<? extends EntityBlackGoat> type, Level worldIn) {
		super(type, worldIn);

	}

	@Override
	protected float getSoundVolume() {
		return 0.3f;
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
	public void tick() {
		super.tick();

		// Particle Effects
		float f = (this.random.nextFloat() - 0.5F) * 2.0F;
		float f1 = -1;
		float f2 = (this.random.nextFloat() - 0.5F) * 2.0F;
		if (this.tickCount < 2) {
			this.level.addParticle(ParticleTypes.SMOKE, this.getX() + f, this.getY() + 2.0D + f1,
					this.getZ() + f2, 0.0D, 0.0D, 0.0D);
		}

		if (this.tickCount > 2 && this.tickCount < 20) {

			this.level.addParticle(ParticleTypes.REVERSE_PORTAL, this.getX() + f,
					this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D, 0.0D, 0.0D);
		}

		if (this.tickCount > 180 && this.tickCount < 220) {
			this.level.addParticle(ParticleTypes.REVERSE_PORTAL, this.getX() + f,
					this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D, 0.0D, 0.0D);

		}
		if (this.tickCount == 220) {
			this.level.addParticle(ParticleTypes.SMOKE, this.getX() + f, this.getY() + 2.0D + f1,
					this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			if (!this.level.isClientSide) {
				this.setHealth(0);
			} else {
				if (!level.isClientSide) {
					level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.SNOW_BREAK,
							SoundSource.HOSTILE, 3f, 1.2f, false);
				}
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
			if (level.isClientSide) {
				level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.NETHER_GOLD_ORE_BREAK,
						SoundSource.HOSTILE, 3f, 0.2f, false);
				this.level.addParticle(ParticleTypes.SMOKE, this.getX() + g, this.getY() + 2.0D + g1,
						this.getZ() + g2, 0.0D, 0.0D, 0.0D);
			}
		}

		if (this.deathTicks <= 0.1 && !this.level.isClientSide) {
			this.remove(RemovalReason.KILLED);
		}

	}

	@Override
	public void playerTouch(Player entityIn) {
		super.playerTouch(entityIn);
		entityIn.hurt(DamageSource.mobAttack(this), 1.5f);

	}

	@Override
	protected void doPush(Entity entityIn) {
		super.doPush(entityIn);
		if (!(entityIn instanceof EntityBlackGoat || entityIn instanceof EntityDarkYoung
				|| entityIn instanceof EntityUzouthrhix)) {
			entityIn.hurt(DamageSource.mobAttack(this), 1.5f);
		}

	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new MoveTowardsTargetGoal(this, 1.3f, 30));
		this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, false));

	}

	public static AttributeSupplier.Builder setAttributes() {
		return LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 30.0D)
				.add(Attributes.ATTACK_KNOCKBACK).add(Attributes.MOVEMENT_SPEED, 0.2f).add(Attributes.MAX_HEALTH, 5f);
	}

	@Override
	protected int calculateFallDamage(float distance, float damageMultiplier) {
		return 0;
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.ITEM_STAR_SLUG_STRIKE.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.ITEM_STAR_SLUG_STRIKE.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ITEM_STAR_SLUG_STRIKE.get();
	}
}
