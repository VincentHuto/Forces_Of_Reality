package com.huto.hutosmod.entities;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.EntityInit;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;

public class EntityDenizen extends AnimalEntity {
	private static final DataParameter<Integer> DENIZEN_TYPE = EntityDataManager.createKey(EntityDenizen.class,
			DataSerializers.VARINT);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_ID = Util.make(Maps.newHashMap(), (p_213410_0_) -> {
		p_213410_0_.put(0, new ResourceLocation(HutosMod.MOD_ID, "textures/entity/denizen/model_denizen_grey.png"));
		p_213410_0_.put(1, new ResourceLocation(HutosMod.MOD_ID, "textures/entity/denizen/model_denizen_grey_cloak.png"));
		p_213410_0_.put(2, new ResourceLocation(HutosMod.MOD_ID, "textures/entity/denizen/model_denizen_red.png"));
		p_213410_0_.put(3, new ResourceLocation(HutosMod.MOD_ID, "textures/entity/denizen/model_denizen_red_cloak.png"));
		p_213410_0_.put(4, new ResourceLocation(HutosMod.MOD_ID, "textures/entity/denizen/model_denizen_white.png"));
		p_213410_0_.put(5, new ResourceLocation(HutosMod.MOD_ID, "textures/entity/denizen/model_denizen_white_cloak.png"));
	});

	public EntityDenizen(EntityType<? extends EntityDenizen> type, World worldIn) {
		super(type, worldIn);

	}

	public ResourceLocation getDenizenTypeName() {
		return TEXTURE_BY_ID.getOrDefault(this.getDenizenType(), TEXTURE_BY_ID.get(0));
	}

	public int getDenizenType() {
		return this.dataManager.get(DENIZEN_TYPE);
	}

	public void setDenizenType(int type) {
		if (type <= 0 || type >= 6) {
			type = this.rand.nextInt(7);
		}

		this.dataManager.set(DENIZEN_TYPE, type);
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(DENIZEN_TYPE, 1);

	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.fromItems(Items.WHEAT), false));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
	}

	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return LivingEntity.registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 16.0D)
				.createMutableAttribute(Attributes.ATTACK_KNOCKBACK)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.15f)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundHandler.ENTITY_DENIZEN_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.ENTITY_DENIZEN_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundHandler.ENTITY_DENIZEN_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_PARROT_STEP, 0.15F, 1.0F);
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}


	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return this.isChild() ? sizeIn.height * 0.95F : 1.3F;
	}

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setDenizenType(this.rand.nextInt(7));

		World world = worldIn.getWorld();
		if (world instanceof ServerWorld && ((ServerWorld) world).func_241112_a_()
				.func_235010_a_(this.getPosition(), true, Structure.field_236374_j_).isValid()) {
			this.setDenizenType(1);
			this.enablePersistence();
		}
		return spawnDataIn;

	}

	@Override
	public EntityDenizen func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		EntityDenizen catentity = EntityInit.denizen.get().create(p_241840_1_);
		if (p_241840_2_ instanceof EntityDenizen) {
			if (this.rand.nextBoolean()) {
				catentity.setDenizenType(this.getDenizenType());
			} else {
				catentity.setDenizenType(((EntityDenizen) p_241840_2_).getDenizenType());
			}

		}
		return catentity;

	}
}