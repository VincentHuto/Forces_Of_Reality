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
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.phys.Vec3;

public class EntitySlug extends Animal {

	private static final EntityDataAccessor<Integer> SLUG_TYPE = SynchedEntityData.defineId(EntitySlug.class,
			EntityDataSerializers.INT);
	public static final Map<Integer, ResourceLocation> TEXTURE_BY_ID = Util.make(Maps.newHashMap(), (p_213410_0_) -> {
		p_213410_0_.put(0, new ResourceLocation(ForcesOfReality.MOD_ID, "textures/entity/slug/model_slug_yellow.png"));
		p_213410_0_.put(1, new ResourceLocation(ForcesOfReality.MOD_ID, "textures/entity/slug/model_slug_grey.png"));
		p_213410_0_.put(2, new ResourceLocation(ForcesOfReality.MOD_ID, "textures/entity/slug/model_slug_brown.png"));
	});

	public EntitySlug(EntityType<? extends EntitySlug> type, Level worldIn) {
		super(type, worldIn);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	int timer = 0;

	@Override
	public void tick() {
		super.tick();

		if (!level.isClientSide) {
			// System.out.println(world.getBlockState(this.getPosition().add(0, 1,
			// 0)).getBlock());
			if (level.getBlockState(this.blockPosition().offset(0, 1, 0)).getBlock() instanceof CropBlock) {
				// Block crop = world.getBlockState(this.getPosition().add(0, 1, 0)).getBlock();
				if (timer <= 150) {
					timer++;
					if (timer % 15 == 0) {
						this.playSound(SoundEvents.CHORUS_FLOWER_DEATH, 1, 1);
					}
				}

				if (timer > 150) {
					level.setBlock(this.blockPosition().offset(0, 1, 0), Blocks.AIR.defaultBlockState(), 2);
					this.playSound(SoundEvents.PLAYER_BURP, 1, 1);
					timer = 0;
				}
			}
		}
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new PanicGoal(this, 1.4D));
		this.goalSelector.addGoal(0, new MoveToBlockGoal(this, 1.5f, 10) {
			@Override
			protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
				if (worldIn.getBlockState(pos).getBlock() instanceof CropBlock) {
					return true;
				} else {
					return false;
				}
			}
		});
		this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.SUGAR), false));
		this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.75D));

	}

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 2.0D).add(Attributes.MOVEMENT_SPEED, 0.15F);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.ENTITY_TENTACLE_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ENTITY_TENTACLE_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.ENTITY_TENTACLE_DEATH.get();
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	@Override
	protected float getSoundVolume() {
		return 0.2F;
	}

	@Override
	public InteractionResult interactAt(Player player, Vec3 vec, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (itemstack.getItem() == Items.BUCKET && !this.isBaby()) {
			player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
			ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, player,
					ItemInit.bucket_slug.get().getDefaultInstance());
			player.setItemInHand(hand, itemstack1);
			this.remove(RemovalReason.DISCARDED);
			float f = (this.random.nextFloat() - 0.5F) * 2.0F;
			float f1 = -1;
			float f2 = (this.random.nextFloat() - 0.5F) * 2.0F;
			this.level.addParticle(ParticleTypes.POOF, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D,
					0.0D, 0.0D);

			return InteractionResult.sidedSuccess(this.level.isClientSide);
		} else {
			return super.interactAt(player, vec, hand);
		}
	}

	@Override
	public EntitySlug getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
		EntitySlug catentity = EntityInit.slug.get().create(p_241840_1_);
		if (p_241840_2_ instanceof EntitySlug) {
			if (this.random.nextBoolean()) {
				catentity.setSlugType(this.getSlugType());
			} else {
				catentity.setSlugType(((EntitySlug) p_241840_2_).getSlugType());
			}

		}
		return catentity;

	}

	public ResourceLocation getSlugTypeName() {
		return TEXTURE_BY_ID.getOrDefault(this.getSlugType(), TEXTURE_BY_ID.get(0));
	}

	public int getSlugType() {
		return this.entityData.get(SLUG_TYPE);
	}

	public void setSlugType(int type) {
		if (type <= 0 || type >= 3) {
			type = this.random.nextInt(4);
		}

		this.entityData.set(SLUG_TYPE, type);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SLUG_TYPE, random.nextInt(3));
	}

	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn,
			MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setSlugType(this.random.nextInt(4));
		Level world = worldIn.getLevel();
		this.setSlugType(1);

		return spawnDataIn;

	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
		return this.isBaby() ? sizeIn.height * 0.1F : 1F;
	}
}