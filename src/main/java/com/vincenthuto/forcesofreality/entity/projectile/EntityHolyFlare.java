package com.vincenthuto.forcesofreality.entity.projectile;

import javax.annotation.Nullable;

import com.vincenthuto.forcesofreality.entity.guardian.EntitySeraphim;
import com.vincenthuto.forcesofreality.entity.summon.EntityThrone;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
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

public class EntityHolyFlare extends Monster {
	public static AttributeSupplier.Builder setAttributes() {
		return LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.ATTACK_KNOCKBACK).add(Attributes.MOVEMENT_SPEED, 0f)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1f);
	}

	public float deathTicks = 1;

	public EntityHolyFlare(EntityType<? extends EntityHolyFlare> type, Level worldIn) {
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
		if (!(entityIn instanceof EntityHolyFlare || entityIn instanceof EntitySeraphim
				|| entityIn instanceof EntityThrone)) {
			entityIn.hurt(entityIn.damageSources().mobAttack(this), 1.5f);
			((LivingEntity) entityIn).addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 2));

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
		entityIn.setDeltaMovement(0, 0.5f, 0);
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
				this.level.addParticle(ParticleTypes.CLOUD, this.getX() + f * 1.6, this.getY() + 2.1D + f1 * 1.6,
						this.getZ() + f2 * 1.6, 0.0D, 0.0D, 0.0D);
			}
		}
		if (this.tickCount > 15) {
			for (int i = 0; i < 6; i++) {
				this.level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, this.getX() + f, this.getY() + (0.0D + i) + f3,
						this.getZ() + f2, 0.0D, 0.0D, 0.0D);

				this.level.addParticle(ParticleTypes.ENCHANT, this.getX() + f, this.getY() + (0.0D + i) + f3,
						this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}
		}
		if (this.tickCount == 200) {
			this.level.addParticle(ParticleTypes.POOF, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D,
					0.0D, 0.0D);
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
				this.level.addParticle(ParticleTypes.POOF, this.getX() + g, this.getY() + 2.0D + g1, this.getZ() + g2,
						0.0D, 0.0D, 0.0D);
			}
		}

		if (this.deathTicks <= 0.1 && !this.level.isClientSide) {
			this.remove(RemovalReason.KILLED);
		}

	}
}
