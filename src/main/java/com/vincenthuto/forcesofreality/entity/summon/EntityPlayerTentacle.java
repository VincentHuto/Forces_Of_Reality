package com.vincenthuto.forcesofreality.entity.summon;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.init.SoundInit;

import net.minecraft.Util;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;

public class EntityPlayerTentacle extends Mob {
	private static final EntityDataAccessor<Integer> TENTACLE_TYPE = SynchedEntityData
			.defineId(EntityPlayerTentacle.class, EntityDataSerializers.INT);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_ID = Util.make(Maps.newHashMap(), (p_213410_0_) -> {
		p_213410_0_.put(0,
				new ResourceLocation(ForcesOfReality.MOD_ID, "textures/entity/tentacle/model_tentacle_green.png"));
		p_213410_0_.put(1,
				new ResourceLocation(ForcesOfReality.MOD_ID, "textures/entity/tentacle/model_tentacle_yellow.png"));
		p_213410_0_.put(2,
				new ResourceLocation(ForcesOfReality.MOD_ID, "textures/entity/tentacle/model_tentacle_grey.png"));
	});
	public static AttributeSupplier.Builder setAttributes() {
		return LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.ATTACK_KNOCKBACK).add(Attributes.MOVEMENT_SPEED, 0f)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0);
	}
	public float deathTicks = 1;

	Player caster;

	public EntityPlayerTentacle(EntityType<? extends EntityPlayerTentacle> type, Level worldIn) {
		super(type, worldIn);

	}

	public EntityPlayerTentacle(EntityType<? extends EntityPlayerTentacle> type, Level worldIn, Player casterIn) {
		super(type, worldIn);
		this.caster = casterIn;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(TENTACLE_TYPE, 1);

	}

	@Override
	protected void doPush(Entity entityIn) {
		super.doPush(entityIn);
		if (!(entityIn instanceof EntityPlayerTentacle) && !(entityIn instanceof Player)) {
			entityIn.hurt(entityIn.damageSources().mobAttack(this), 4.5f);
		}

		if (entityIn instanceof Player) {
			Player playerENt = (Player) entityIn;
			if (caster != null && playerENt.getUUID() != caster.getUUID()) {
				entityIn.hurt(entityIn.damageSources().generic(), 4.5f);
			}
		}
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn,
			MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setTentacleType(this.random.nextInt(4));
		this.populateDefaultEquipmentSlots(random, difficultyIn);
		Level world = worldIn.getLevel();

		this.setTentacleType(1);

		return spawnDataIn;

	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.ENTITY_TENTACLE_AMBIENT.get();
	}

	@Override
	protected AABB getBoundingBoxForPose(Pose pose) {
		return super.getBoundingBoxForPose(pose).inflate(3);
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

	public int getTentacleType() {
		return this.entityData.get(TENTACLE_TYPE);
	}

	public ResourceLocation getTentacleTypeName() {
		return TEXTURE_BY_ID.getOrDefault(this.getTentacleType(), TEXTURE_BY_ID.get(0));
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
	}

	public void setTentacleType(int type) {
		if (type <= 0 || type >= 4) {
			type = this.random.nextInt(5);
		}

		this.entityData.set(TENTACLE_TYPE, type);
	}

	@Override
	public void tick() {
		super.tick();

		// Particle Effects
		float f = (this.random.nextFloat() - 0.5F) * 2.0F;
		float f1 = -1;
		float f2 = (this.random.nextFloat() - 0.5F) * 2.0F;
		if (this.tickCount < 2) {
			this.level.addParticle(ParticleTypes.POOF, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D,
					0.0D, 0.0D);
		}

		if (this.tickCount > 2 && this.tickCount < 10) {

			this.level.addParticle(ParticleTypes.ITEM_SLIME, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2,
					0.0D, 0.0D, 0.0D);
		}

		if (this.tickCount > 40 && this.tickCount < 80) {
			this.level.addParticle(ParticleTypes.ITEM_SLIME, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2,
					0.0D, 0.0D, 0.0D);

		}
		if (this.tickCount == 80) {
			this.level.addParticle(ParticleTypes.POOF, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D,
					0.0D, 0.0D);
			if (!this.level.isClientSide) {
				this.setHealth(0);
			} else {
				if (!level.isClientSide) {
					level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.SLIME_DEATH,
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
		deathTicks -= 0.1;
		if (this.deathTicks <= 0.1) {
			if (level.isClientSide) {
				level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.SLIME_BLOCK_BREAK,
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
