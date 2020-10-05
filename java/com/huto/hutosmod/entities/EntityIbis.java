package com.huto.hutosmod.entities;

import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Maps;
import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.EntityInit;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.server.ServerWorld;

public class EntityIbis extends AnimalEntity {
	private static final DataParameter<Integer> IBIS_TYPE = EntityDataManager.createKey(EntityIbis.class,
			DataSerializers.VARINT);
	private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.WHEAT_SEEDS, Items.MELON_SEEDS,
			Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_ID = Util.make(Maps.newHashMap(), (p_213410_0_) -> {
		p_213410_0_.put(0, new ResourceLocation(HutosMod.MOD_ID, "textures/entity/ibis/model_ibis_red.png"));
		p_213410_0_.put(1, new ResourceLocation(HutosMod.MOD_ID, "textures/entity/ibis/model_ibis_grey.png"));
		p_213410_0_.put(2, new ResourceLocation(HutosMod.MOD_ID, "textures/entity/ibis/model_ibis_brown.png"));
	});

	public float wingRotation;
	public float destPos;
	public float oFlapSpeed;
	public float oFlap;
	public float wingRotDelta = 1.0F;
	public int timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
	public boolean chickenJockey;

	public EntityIbis(EntityType<? extends EntityIbis> type, World worldIn) {
		super(type, worldIn);
		this.setPathPriority(PathNodeType.WATER, 0.0F);
	}

	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
		this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
		this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return this.isChild() ? sizeIn.height * 0.85F : sizeIn.height * 0.92F;
	}

	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 4.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
	}

	/**
	 * Called frequently so the entity can update its state every tick as required.
	 * For example, zombies and skeletons use this to react to sunlight and start to
	 * burn.
	 */
	public void livingTick() {
		super.livingTick();
		this.oFlap = this.wingRotation;
		this.oFlapSpeed = this.destPos;
		this.destPos = (float) ((double) this.destPos + (double) (this.onGround ? -1 : 4) * 0.3D);
		this.destPos = MathHelper.clamp(this.destPos, 0.0F, 1.0F);
		if (!this.onGround && this.wingRotDelta < 1.0F) {
			this.wingRotDelta = 1.0F;
		}

		this.wingRotDelta = (float) ((double) this.wingRotDelta * 0.9D);
		Vector3d vector3d = this.getMotion();
		if (!this.onGround && vector3d.y < 0.0D) {
			this.setMotion(vector3d.mul(1.0D, 0.6D, 1.0D));
		}

		this.wingRotation += this.wingRotDelta * 2.0F;
		if (!this.world.isRemote && this.isAlive() && !this.isChild() && !this.isChickenJockey()
				&& --this.timeUntilNextEgg <= 0) {
			this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F,
					(this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			this.entityDropItem(Items.EGG);
			this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
		}

	}

	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_CHICKEN_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_CHICKEN_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_CHICKEN_DEATH;
	}

	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
	}

	public ResourceLocation getIbisTypeName() {
		return TEXTURE_BY_ID.getOrDefault(this.getIbisType(), TEXTURE_BY_ID.get(0));
	}

	@Override
	public EntityIbis func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		EntityIbis catentity = EntityInit.ibis.get().create(p_241840_1_);
		if (p_241840_2_ instanceof EntityIbis) {
			if (this.rand.nextBoolean()) {
				catentity.setIbisType(this.getIbisType());
			} else {
				catentity.setIbisType(((EntityIbis) p_241840_2_).getIbisType());
			}

		}
		return catentity;

	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed it
	 * (wheat, carrots or seeds depending on the animal type)
	 */
	public boolean isBreedingItem(ItemStack stack) {
		return TEMPTATION_ITEMS.test(stack);
	}

	/**
	 * Get the experience points the entity currently has.
	 */
	protected int getExperiencePoints(PlayerEntity player) {
		return this.isChickenJockey() ? 10 : super.getExperiencePoints(player);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.chickenJockey = compound.getBoolean("IsChickenJockey");
		if (compound.contains("EggLayTime")) {
			this.timeUntilNextEgg = compound.getInt("EggLayTime");
		}

	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putBoolean("IsChickenJockey", this.chickenJockey);
		compound.putInt("EggLayTime", this.timeUntilNextEgg);
	}

	public boolean canDespawn(double distanceToClosestPlayer) {
		return this.isChickenJockey();
	}

	public void updatePassenger(Entity passenger) {
		super.updatePassenger(passenger);
		float f = MathHelper.sin(this.renderYawOffset * ((float) Math.PI / 180F));
		float f1 = MathHelper.cos(this.renderYawOffset * ((float) Math.PI / 180F));
		passenger.setPosition(this.getPosX() + (double) (0.1F * f),
				this.getPosYHeight(0.5D) + passenger.getYOffset() + 0.0D, this.getPosZ() - (double) (0.1F * f1));
		if (passenger instanceof LivingEntity) {
			((LivingEntity) passenger).renderYawOffset = this.renderYawOffset;
		}

	}

	/**
	 * Determines if this chicken is a jokey with a zombie riding it.
	 */
	public boolean isChickenJockey() {
		return this.chickenJockey;
	}

	/**
	 * Sets whether this chicken is a jockey or not.
	 */
	public void setChickenJockey(boolean jockey) {
		this.chickenJockey = jockey;
	}


	public int getIbisType() {
		return this.dataManager.get(IBIS_TYPE);
	}

	public void setIbisType(int type) {
		if (type <= 0 || type >= 3) {
			type = this.rand.nextInt(4);
		}

		this.dataManager.set(IBIS_TYPE, type);
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(IBIS_TYPE, 1);
	}

	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setIbisType(this.rand.nextInt(4));

		World world = worldIn.getWorld();
		if (world instanceof ServerWorld && ((ServerWorld) world).func_241112_a_()
				.func_235010_a_(this.getPosition(), true, Structure.field_236374_j_).isValid()) {
			this.setIbisType(1);
			this.enablePersistence();
		}
		return spawnDataIn;

	}

}