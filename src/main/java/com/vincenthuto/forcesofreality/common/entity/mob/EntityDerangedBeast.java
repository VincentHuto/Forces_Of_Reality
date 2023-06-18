package com.vincenthuto.forcesofreality.common.entity.mob;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.vincenthuto.forcesofreality.ForcesOfReality;

import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class EntityDerangedBeast extends Monster {
	private static final EntityDataAccessor<Integer> BEAST_TYPE = SynchedEntityData.defineId(EntityDerangedBeast.class,
			EntityDataSerializers.INT);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_ID = Util.make(Maps.newHashMap(), (p_213410_0_) -> {
		p_213410_0_.put(0, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/deranged_beast/model_deranged_beast_grey.png"));
		p_213410_0_.put(1, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/deranged_beast/model_deranged_beast_brown.png"));
		p_213410_0_.put(2, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/deranged_beast/model_deranged_beast_white.png"));
	});
	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 7.0D).add(Attributes.MOVEMENT_SPEED, 0.3D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1.15D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	public float deathTicks = 1;

	public EntityDerangedBeast(EntityType<? extends EntityDerangedBeast> type, Level worldIn) {
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
		/*
		 * if (!(entityIn instanceof EntityDerangedBeast || entityIn instanceof
		 * EntityBeastFromBeyond)) {
		 * entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 1.5f); }
		 */
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn,
			MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setBeastType(this.random.nextInt(4));

		return spawnDataIn;

	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.WOLF_AMBIENT;
	}

	public int getBeastType() {
		return this.entityData.get(BEAST_TYPE);
	}

	public ResourceLocation getBeastTypeName() {
		return TEXTURE_BY_ID.getOrDefault(this.getBeastType(), TEXTURE_BY_ID.get(0));
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.WOLF_DEATH;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.WOLF_HURT;
	}

	@Override
	protected float getSoundVolume() {
		return 0.3f;
	}

	@Override
	public void playerTouch(Player entityIn) {
		super.playerTouch(entityIn);
		// entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 1.5f);

	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));

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

		/*
		 * // Particle Effects float f = (this.rand.nextFloat() - 0.5F) * 2.0F; float f1
		 * = -1; float f2 = (this.rand.nextFloat() - 0.5F) * 2.0F; if (this.ticksExisted
		 * < 2) { this.world.addParticle(ParticleTypes.POOF, this.getPosX() + (double)
		 * f, this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D,
		 * 0.0D, 0.0D); }
		 *
		 * if (this.ticksExisted > 2 && this.ticksExisted < 20) {
		 *
		 * this.world.addParticle(ParticleTypes.ITEM_SNOWBALL, this.getPosX() + (double)
		 * f, this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D,
		 * 0.0D, 0.0D); }
		 *
		 * if (this.ticksExisted > 180 && this.ticksExisted < 220) {
		 * this.world.addParticle(ParticleTypes.ITEM_SNOWBALL, this.getPosX() + (double)
		 * f, this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D,
		 * 0.0D, 0.0D);
		 *
		 * } if (this.ticksExisted == 220) { this.world.addParticle(ParticleTypes.POOF,
		 * this.getPosX() + (double) f, this.getPosY() + 2.0D + (double) f1,
		 * this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D); if (!this.world.isRemote) {
		 * this.setHealth(0); } else { if (!world.isRemote) {
		 * world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(),
		 * SoundEvents.BLOCK_SNOW_BREAK, SoundCategory.HOSTILE, 3f, 1.2f, false); } } }
		 */
	}
}
