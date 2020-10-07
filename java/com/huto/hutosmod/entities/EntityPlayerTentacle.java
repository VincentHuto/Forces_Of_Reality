package com.huto.hutosmod.entities;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;

public class EntityPlayerTentacle extends MobEntity {
	private static final DataParameter<Integer> TENTACLE_TYPE = EntityDataManager.createKey(EntityPlayerTentacle.class,
			DataSerializers.VARINT);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_ID = Util.make(Maps.newHashMap(), (p_213410_0_) -> {
		p_213410_0_.put(0, new ResourceLocation(HutosMod.MOD_ID, "textures/entity/tentacle/model_tentacle_green.png"));
		p_213410_0_.put(1, new ResourceLocation(HutosMod.MOD_ID, "textures/entity/tentacle/model_tentacle_yellow.png"));
		p_213410_0_.put(2, new ResourceLocation(HutosMod.MOD_ID, "textures/entity/tentacle/model_tentacle_grey.png"));
	});
	public float deathTicks = 1;
	PlayerEntity caster;

	public EntityPlayerTentacle(EntityType<? extends EntityPlayerTentacle> type, World worldIn) {
		super(type, worldIn);

	}

	public EntityPlayerTentacle(EntityType<? extends EntityPlayerTentacle> type, World worldIn, PlayerEntity casterIn) {
		super(type, worldIn);
		this.caster = casterIn;
	}

	@Override
	protected AxisAlignedBB getBoundingBox(Pose pose) {
		return super.getBoundingBox(pose).grow(3);
	}

	public ResourceLocation getTentacleTypeName() {
		return TEXTURE_BY_ID.getOrDefault(this.getTentacleType(), TEXTURE_BY_ID.get(0));
	}

	public int getTentacleType() {
		return this.dataManager.get(TENTACLE_TYPE);
	}

	public void setTentacleType(int type) {
		if (type <= 0 || type >= 4) {
			type = this.rand.nextInt(5);
		}

		this.dataManager.set(TENTACLE_TYPE, type);
	}

	@Override
	protected float getSoundVolume() {
		return 0.3f;
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(TENTACLE_TYPE, 1);

	}

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setTentacleType(this.rand.nextInt(4));
		this.setEquipmentBasedOnDifficulty(difficultyIn);
		World world = worldIn.getWorld();
		if (world instanceof ServerWorld && ((ServerWorld) world).func_241112_a_()
				.func_235010_a_(this.getPosition(), true, Structure.field_236374_j_).isValid()) {
			this.setTentacleType(1);
			this.enablePersistence();
		}

		return spawnDataIn;

	}

	@Override
	public void tick() {
		super.tick();

		// Particle Effects
		float f = (this.rand.nextFloat() - 0.5F) * 2.0F;
		float f1 = -1;
		float f2 = (this.rand.nextFloat() - 0.5F) * 2.0F;
		if (this.ticksExisted < 2) {
			this.world.addParticle(ParticleTypes.POOF, this.getPosX() + (double) f, this.getPosY() + 2.0D + (double) f1,
					this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
		}

		if (this.ticksExisted > 2 && this.ticksExisted < 10) {

			this.world.addParticle(ParticleTypes.ITEM_SLIME, this.getPosX() + (double) f,
					this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
		}

		if (this.ticksExisted > 40 && this.ticksExisted < 80) {
			this.world.addParticle(ParticleTypes.ITEM_SLIME, this.getPosX() + (double) f,
					this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);

		}
		if (this.ticksExisted == 80) {
			this.world.addParticle(ParticleTypes.POOF, this.getPosX() + (double) f, this.getPosY() + 2.0D + (double) f1,
					this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
			if (!this.world.isRemote) {
				this.setHealth(0);
			} else {
				if (!world.isRemote) {
					world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_SLIME_DEATH,
							SoundCategory.HOSTILE, 3f, 1.2f, false);
				}
			}
		}
	}

	@Override
	protected void onDeathUpdate() {
		// Particle Effects
		float g = (this.rand.nextFloat() - 0.5F) * 2.0F;
		float g1 = -1;
		float g2 = (this.rand.nextFloat() - 0.5F) * 2.0F;
		deathTicks -= 0.1;
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
	protected void collideWithEntity(Entity entityIn) {
		super.collideWithEntity(entityIn);
		if (!(entityIn instanceof EntityPlayerTentacle) && !(entityIn instanceof PlayerEntity)) {
			entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), 4.5f);
		}

		if (entityIn instanceof PlayerEntity) {
			PlayerEntity playerENt = (PlayerEntity) entityIn;
			if (caster != null && playerENt.getUniqueID() != caster.getUniqueID()) {
				entityIn.attackEntityFrom(new DamageSource("tentacle"), 4.5f);
			}
		}
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
	}

	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D)
				.createMutableAttribute(Attributes.ATTACK_KNOCKBACK)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0f)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundHandler.ENTITY_TENTACLE_AMBIENT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundHandler.ENTITY_TENTACLE_DEATH;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.ENTITY_TENTACLE_HURT;
	}
}
