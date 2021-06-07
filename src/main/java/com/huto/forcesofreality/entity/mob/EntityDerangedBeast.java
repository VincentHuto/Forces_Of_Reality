package com.huto.forcesofreality.entity.mob;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.huto.forcesofreality.ForcesOfReality;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;

public class EntityDerangedBeast extends MonsterEntity {
	private static final DataParameter<Integer> BEAST_TYPE = EntityDataManager.createKey(EntityDerangedBeast.class,
			DataSerializers.VARINT);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_ID = Util.make(Maps.newHashMap(), (p_213410_0_) -> {
		p_213410_0_.put(0, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/deranged_beast/model_deranged_beast_grey.png"));
		p_213410_0_.put(1, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/deranged_beast/model_deranged_beast_brown.png"));
		p_213410_0_.put(2, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/deranged_beast/model_deranged_beast_white.png"));
	});
	public float deathTicks = 1;

	public EntityDerangedBeast(EntityType<? extends EntityDerangedBeast> type, World worldIn) {
		super(type, worldIn);

	}

	public ResourceLocation getBeastTypeName() {
		return TEXTURE_BY_ID.getOrDefault(this.getBeastType(), TEXTURE_BY_ID.get(0));
	}

	public int getBeastType() {
		return this.dataManager.get(BEAST_TYPE);
	}

	public void setBeastType(int type) {
		if (type <= 0 || type >= 4) {
			type = this.rand.nextInt(5);
		}

		this.dataManager.set(BEAST_TYPE, type);
	}

	@Override
	protected float getSoundVolume() {
		return 0.3f;
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(BEAST_TYPE, 1);

	}

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setBeastType(this.rand.nextInt(4));
		this.setEquipmentBasedOnDifficulty(difficultyIn);
		World world = worldIn.getWorld();
		if (world instanceof ServerWorld && ((ServerWorld) world).getStructureManager()
				.getStructureStart(this.getPosition(), true, Structure.SWAMP_HUT).isValid()) {
			this.setBeastType(1);
			this.enablePersistence();
		}

		return spawnDataIn;

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

	@Override
	public void onCollideWithPlayer(PlayerEntity entityIn) {
		super.onCollideWithPlayer(entityIn);
	//	entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 1.5f);

	}

	@Override
	protected void collideWithEntity(Entity entityIn) {
		super.collideWithEntity(entityIn);
		/*if (!(entityIn instanceof EntityDerangedBeast || entityIn instanceof EntityBeastFromBeyond)) {
			entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 1.5f);
		}
*/
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));

	}

	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 7.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.15D)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	@Override
	protected int calculateFallDamage(float distance, float damageMultiplier) {
		return 0;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_WOLF_AMBIENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_WOLF_DEATH;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_WOLF_HURT;
	}
}
