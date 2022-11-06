package com.vincenthuto.forcesofreality.entity.passive;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.init.SoundInit;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class EntityDenizenSage extends Animal {
	private static final EntityDataAccessor<Integer> DENIZEN_TYPE = SynchedEntityData.defineId(EntityDenizenSage.class,
			EntityDataSerializers.INT);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_ID = Util.make(Maps.newHashMap(), (p_213410_0_) -> {
		p_213410_0_.put(0, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/denizen_sage/model_denizen_sage_grey.png"));
		p_213410_0_.put(1, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/denizen_sage/model_denizen_sage_grey_cloak.png"));
		p_213410_0_.put(2, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/denizen_sage/model_denizen_sage_red.png"));
		p_213410_0_.put(3, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/denizen_sage/model_denizen_sage_red_cloak.png"));
		p_213410_0_.put(4, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/denizen_sage/model_denizen_sage_white.png"));
		p_213410_0_.put(5, new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/entity/denizen_sage/model_denizen_sage_white_cloak.png"));
	});

	public static AttributeSupplier.Builder setAttributes() {
		return LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE, 16.0D)
				.add(Attributes.ATTACK_KNOCKBACK).add(Attributes.MOVEMENT_SPEED, 0.15f)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0);
	}

	public EntityDenizenSage(EntityType<? extends EntityDenizenSage> type, Level worldIn) {
		super(type, worldIn);

	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DENIZEN_TYPE, random.nextInt(6));

	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn,
			MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setDenizenType(this.random.nextInt(7));
		this.populateDefaultEquipmentSlots(random, difficultyIn);

		this.setDenizenType(1);

		return spawnDataIn;

	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.ENTITY_DENIZEN_AMBIENT.get();
	}

	@Override
	public EntityDenizenSage getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		EntityDenizenSage catentity = EntityInit.denizen_sage.get().create(p_241840_1_);
		if (p_241840_2_ instanceof EntityDenizenSage) {
			if (this.random.nextBoolean()) {
				catentity.setDenizenType(this.getDenizenType());
			} else {
				catentity.setDenizenType(((EntityDenizenSage) p_241840_2_).getDenizenType());
			}

		}
		return catentity;

	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.ENTITY_DENIZEN_DEATH.get();
	}

	public int getDenizenType() {
		return this.entityData.get(DENIZEN_TYPE);
	}

	public ResourceLocation getDenizenTypeName() {
		return TEXTURE_BY_ID.getOrDefault(this.getDenizenType(), TEXTURE_BY_ID.get(0));
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ENTITY_DENIZEN_HURT.get();
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		return this.isBaby() ? sizeIn.height * 0.95F : 1.3F;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.PARROT_STEP, 0.15F, 1.0F);
	}

	@Override
	protected void populateDefaultEquipmentSlots(RandomSource p_217055_, DifficultyInstance p_217056_) {
		super.populateDefaultEquipmentSlots(p_217055_, p_217056_);
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ItemInit.anointed_iron_sword.get()));
		this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(ItemInit.allegiance_identifier.get()));
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.WHEAT), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
	}

	public void setDenizenType(int type) {
		if (type <= 0 || type >= 6) {
			type = this.random.nextInt(7);
		}

		this.entityData.set(DENIZEN_TYPE, type);
	}
}