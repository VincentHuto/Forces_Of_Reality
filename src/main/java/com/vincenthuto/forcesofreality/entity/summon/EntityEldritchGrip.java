package com.vincenthuto.forcesofreality.entity.summon;

import javax.annotation.Nullable;

import com.vincenthuto.forcesofreality.entity.guardian.EntityHastur;
import com.vincenthuto.forcesofreality.entity.lord.EntityTrueXanthousKing;
import com.vincenthuto.forcesofreality.entity.lord.EntityXanthousKing;
import com.vincenthuto.forcesofreality.init.SoundInit;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;

public class EntityEldritchGrip extends Monster {
	public static AttributeSupplier.Builder setAttributes() {
		return LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.ATTACK_KNOCKBACK).add(Attributes.MOVEMENT_SPEED, 0f)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1f);
	}

	public float deathTicks = 1;

	public EntityEldritchGrip(EntityType<? extends EntityEldritchGrip> type, Level worldIn) {
		super(type, worldIn);

	}

	@Override
	public boolean canBeLeashed(Player player) {
		return false;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();

	}

	@Override
	public boolean displayFireAnimation() {
		return false;
	}

	@Override
	protected void doPush(Entity entityIn) {
		super.doPush(entityIn);
		if (!(entityIn instanceof EntityTentacle || entityIn instanceof EntityHastur
				|| entityIn instanceof EntityXanthousKing || entityIn instanceof EntityTrueXanthousKing)) {
			((LivingEntity) entityIn).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 2));

		}

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
		return SoundInit.ENTITY_TENTACLE_AMBIENT.get();
	}

	@Override
	public AABB getBoundingBoxForCulling() {
		return super.getBoundingBoxForCulling().inflate(10);
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.ENTITY_TENTACLE_DEATH.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ENTITY_TENTACLE_HURT.get();
	}

	@Override
	protected float getSoundVolume() {
		return 0.3f;
	}


	@Override
	public boolean isAffectedByPotions() {
		return false;
	}

	@Override
	public boolean isAttackable() {
		return false;
	}

	@Override
	public boolean isPickable() {
		return false;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	public boolean isUnderWater() {
		return true;
	}

	@Override
	public void playerTouch(Player entityIn) {
		super.playerTouch(entityIn);
		// entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 3.5f);
		entityIn.setDeltaMovement(0, -0.5f, 0);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
	}

	@Override
	public void tick() {
		super.tick();

		// Particle Effects
		float f = (this.random.nextFloat() - 0.5F) * 1.5F;
		float f1 = -1;
		float f3 = (this.random.nextFloat() - 0.5F) * 1.5F;
		float f2 = (this.random.nextFloat() - 0.5F) * 1.5F;
		if (this.tickCount > 0) {
			for (int j = 0; j < 10; j++) {
				this.level.addParticle(ParticleTypes.SMOKE, this.getX() + f * 1.6,
						this.getY() + 2.1D + f1 * 1.6, this.getZ() + f2 * 1.6, 0.0D, 0.0D, 0.0D);
			}
		}
		if (this.tickCount > 15) {
			for (int i = 0; i < 2; i++) {
				this.level.addParticle(ParticleTypes.SMOKE, this.getX() + f * 0.5, this.getY(),
						this.getZ() + f2 * 0.5, 0.0D, 0.0D, 0.0D);
				this.level.addParticle(ParticleTypes.ASH, this.getX() + f,
						this.getY() + (0.0D + i) + f3, this.getZ() + f2, 0.0D, 0.0D, 0.0D);

				this.level.addParticle(ParticleTypes.AMBIENT_ENTITY_EFFECT, this.getX() + f,
						this.getY() + (0.0D + i) + f3, this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}
		}
		if (this.tickCount == 200) {
			this.level.addParticle(ParticleTypes.SMOKE, this.getX() + f, this.getY() + 2.0D + f1,
					this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			if (!this.level.isClientSide) {
				this.setHealth(0);
			} else {
				if (!level.isClientSide) {
					level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE,
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
				level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE,
						SoundSource.HOSTILE, 3f, 0.2f, false);
				this.level.addParticle(ParticleTypes.SMOKE, this.getX() + g, this.getY() + 2.0D + g1,
						this.getZ() + g2, 0.0D, 0.0D, 0.0D);
			}
		}

		if (this.deathTicks <= 0.1 && !this.level.isClientSide) {
			this.remove(RemovalReason.KILLED);
		}

	}
}
