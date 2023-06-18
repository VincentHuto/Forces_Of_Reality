package com.vincenthuto.forcesofreality.common.entity.summon;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.entity.guardian.EntityBeastFromBeyond;
import com.vincenthuto.forcesofreality.common.entity.guardian.EntityTheFirstBeast;
import com.vincenthuto.forcesofreality.common.entity.lord.EntityLordOfTheWild;
import com.vincenthuto.forcesofreality.registry.SoundInit;

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

public class EntitySummonedBeast extends Monster {
	private static final EntityDataAccessor<Integer> BEAST_TYPE = SynchedEntityData.defineId(EntitySummonedBeast.class,
			EntityDataSerializers.INT);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_ID = Util.make(Maps.newHashMap(), (p_213410_0_) -> {
		p_213410_0_.put(0, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/summoned_beast/model_summoned_beast_grey.png"));
		p_213410_0_.put(1, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/summoned_beast/model_summoned_beast_brown.png"));
		p_213410_0_.put(2, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/summoned_beast/model_summoned_beast_white.png"));
	});
	public static AttributeSupplier.Builder setAttributes() {
		return LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 30.0D)
				.add(Attributes.ATTACK_KNOCKBACK).add(Attributes.MOVEMENT_SPEED, 0.2f).add(Attributes.MAX_HEALTH, 5f);
	}

	public float deathTicks = 1;

	public EntitySummonedBeast(EntityType<? extends EntitySummonedBeast> type, Level worldIn) {
		super(type, worldIn);

	}

	@Override
	protected int calculateFallDamage(float distance, float damageMultiplier) {
		return 0;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(BEAST_TYPE, 1);

	}

	@Override
	protected void doPush(Entity entityIn) {
		super.doPush(entityIn);
		if (!(entityIn instanceof EntitySummonedBeast || entityIn instanceof EntityBeastFromBeyond
				|| entityIn instanceof EntityTheFirstBeast || entityIn instanceof EntityLordOfTheWild)) {
			entityIn.hurt(entityIn.damageSources().mobAttack(this), 1.5f);
		}

	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn,
			MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setBeastType(this.random.nextInt(4));
		this.populateDefaultEquipmentSlots(random, difficultyIn);
		Level world = worldIn.getLevel();

		this.setBeastType(1);

		return spawnDataIn;

	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.ITEM_STAR_SLUG_STRIKE.get();
	}

	public int getBeastType() {
		return this.entityData.get(BEAST_TYPE);
	}

	public ResourceLocation getBeastTypeName() {
		return TEXTURE_BY_ID.getOrDefault(this.getBeastType(), TEXTURE_BY_ID.get(0));
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.ITEM_STAR_SLUG_STRIKE.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ITEM_STAR_SLUG_STRIKE.get();
	}

	@Override
	protected float getSoundVolume() {
		return 0.3f;
	}

	@Override
	public void playerTouch(Player entityIn) {
		super.playerTouch(entityIn);
		entityIn.hurt(entityIn.damageSources().mobAttack(this), 1.5f);

	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new MoveTowardsTargetGoal(this, 1.3d, 30));
		this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, false));

	}

	public void setBeastType(int type) {
		if (type <= 0 || type >= 4) {
			type = this.random.nextInt(5);
		}

		this.entityData.set(BEAST_TYPE, type);
	}

	@Override
	public void tick() {
		super.tick();

		// Particle Effects
		float f = (this.random.nextFloat() - 0.5F) * 2.0F;
		float f1 = -1;
		float f2 = (this.random.nextFloat() - 0.5F) * 2.0F;
		if (this.tickCount < 2) {
			this.level().addParticle(ParticleTypes.POOF, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D,
					0.0D, 0.0D);
		}

		if (this.tickCount > 2 && this.tickCount < 20) {

			this.level().addParticle(ParticleTypes.ITEM_SNOWBALL, this.getX() + f, this.getY() + 2.0D + f1,
					this.getZ() + f2, 0.0D, 0.0D, 0.0D);
		}

		if (this.tickCount > 180 && this.tickCount < 220) {
			this.level().addParticle(ParticleTypes.ITEM_SNOWBALL, this.getX() + f, this.getY() + 2.0D + f1,
					this.getZ() + f2, 0.0D, 0.0D, 0.0D);

		}
		if (this.tickCount == 220) {
			this.level().addParticle(ParticleTypes.POOF, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D,
					0.0D, 0.0D);
			if (!this.level().isClientSide) {
				this.setHealth(0);
			} else {
				if (!level().isClientSide) {
					level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.SNOW_BREAK,
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
			if (level().isClientSide) {
				level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.NETHER_GOLD_ORE_BREAK,
						SoundSource.HOSTILE, 3f, 0.2f, false);
				this.level().addParticle(ParticleTypes.POOF, this.getX() + g, this.getY() + 2.0D + g1, this.getZ() + g2,
						0.0D, 0.0D, 0.0D);
			}
		}

		if (this.deathTicks <= 0.1 && !this.level().isClientSide) {
			this.remove(RemovalReason.KILLED);
		}

	}
}
