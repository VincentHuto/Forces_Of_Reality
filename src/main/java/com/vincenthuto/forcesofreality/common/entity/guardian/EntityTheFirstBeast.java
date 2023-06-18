package com.vincenthuto.forcesofreality.common.entity.guardian;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import com.vincenthuto.forcesofreality.common.entity.projectile.EntityFirstBeastBolt;
import com.vincenthuto.forcesofreality.common.entity.projectile.EntityWolfShot;
import com.vincenthuto.forcesofreality.common.entity.summon.EntitySummonedBeast;
import com.vincenthuto.forcesofreality.common.item.coven.tool.ItemBeastBolt;
import com.vincenthuto.forcesofreality.common.item.coven.tool.ItemBeastCrossbow;
import com.vincenthuto.forcesofreality.registry.EntityInit;
import com.vincenthuto.forcesofreality.registry.ItemInit;
import com.vincenthuto.forcesofreality.registry.SoundInit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance.IntRange;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

public class EntityTheFirstBeast extends Monster
		implements IEntityAdditionalSpawnData, /* IAnimatable */ CrossbowAttackMob {

	enum CrossbowState {
		UNCHARGED, CHARGING, CHARGED, READY_TO_ATTACK;
	}
	class GoalFirstBeastCrossbowAttack<T extends Monster & RangedAttackMob & CrossbowAttackMob> extends Goal {
		public final IntRange PATHFINDING_DELAY_RANGE = new IntRange(20, 40);
		private final T mob;
		private EntityTheFirstBeast.CrossbowState crossbowState = EntityTheFirstBeast.CrossbowState.UNCHARGED;
		private final double speedModifier;
		private final float attackRadiusSqr;
		private int seeTime;
		private int attackDelay;
		private int updatePathDelay;

		public GoalFirstBeastCrossbowAttack(T shooter, double speed, float p_i50322_4_) {
			this.mob = shooter;
			this.speedModifier = speed;
			this.attackRadiusSqr = p_i50322_4_ * p_i50322_4_;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		@Override
		public boolean canContinueToUse() {
			return this.isValidTarget() && (this.canUse() || !this.mob.getNavigation().isDone())
					&& this.isHoldingCrossbow();
		}

		private boolean canRun() {
			return this.crossbowState == EntityTheFirstBeast.CrossbowState.UNCHARGED;
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		@Override
		public boolean canUse() {
			return this.isValidTarget() && this.isHoldingCrossbow();
		}

		private boolean isHoldingCrossbow() {
			return this.mob.isHolding(ItemInit.first_beast_crossbow.get());
		}

		private boolean isValidTarget() {
			return this.mob.getTarget() != null && this.mob.getTarget().isAlive();
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		@Override
		public void stop() {
			super.stop();
			this.mob.setAggressive(false);
			this.mob.setTarget((LivingEntity) null);
			this.seeTime = 0;
			if (this.mob.isUsingItem()) {
				this.mob.stopUsingItem();
				this.mob.setChargingCrossbow(false);
				ItemBeastCrossbow.setCharged(this.mob.getUseItem(), false);
			}

		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		@Override
		public void tick() {
			LivingEntity livingentity = this.mob.getTarget();
			if (livingentity != null) {
				boolean flag = this.mob.getSensing().hasLineOfSight(livingentity);
				boolean flag1 = this.seeTime > 0;
				if (flag != flag1) {
					this.seeTime = 0;
				}

				if (flag) {
					++this.seeTime;
				} else {
					--this.seeTime;
				}

				double d0 = this.mob.distanceToSqr(livingentity);
				boolean flag2 = (d0 > this.attackRadiusSqr || this.seeTime < 5) && this.attackDelay == 0;
				if (flag2) {
					--this.updatePathDelay;
					if (this.updatePathDelay <= 0) {
						this.mob.getNavigation().moveTo(livingentity,
								this.canRun() ? this.speedModifier : this.speedModifier * 0.5D);
						this.updatePathDelay = PATHFINDING_DELAY_RANGE.fromSliderValue(this.mob.getRandom().nextDouble());
					}
				} else {
					this.updatePathDelay = 0;
					this.mob.getNavigation().stop();
				}

				this.mob.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
				if (this.crossbowState == EntityTheFirstBeast.CrossbowState.UNCHARGED) {
					if (!flag2) {
						this.mob.startUsingItem(
								ProjectileUtil.getWeaponHoldingHand(this.mob, ItemInit.first_beast_crossbow.get()));
						this.crossbowState = EntityTheFirstBeast.CrossbowState.CHARGING;
						this.mob.setChargingCrossbow(true);
					}
				} else if (this.crossbowState == EntityTheFirstBeast.CrossbowState.CHARGING) {
					if (!this.mob.isUsingItem()) {
						this.crossbowState = EntityTheFirstBeast.CrossbowState.UNCHARGED;

//						if (noActiveAnimation()) {
//							AnimationPacket.send(EntityTheFirstBeast.this, ARROW_ANIMATION);
//						}
					}

					int i = this.mob.getTicksUsingItem();
					ItemStack itemstack = this.mob.getUseItem();
					if (i >= ItemBeastCrossbow.getChargeTime(itemstack)) {
						this.mob.releaseUsingItem();
						this.crossbowState = EntityTheFirstBeast.CrossbowState.CHARGED;
						this.attackDelay = 20 + this.mob.getRandom().nextInt(20);
						this.mob.setChargingCrossbow(false);

//						if (noActiveAnimation()) {
//							AnimationPacket.send(EntityTheFirstBeast.this, ARROW_ANIMATION);
//						}
					}
				} else if (this.crossbowState == EntityTheFirstBeast.CrossbowState.CHARGED) {
					--this.attackDelay;
					if (this.attackDelay == 0) {
						this.crossbowState = EntityTheFirstBeast.CrossbowState.READY_TO_ATTACK;

					}
				} else if (this.crossbowState == EntityTheFirstBeast.CrossbowState.READY_TO_ATTACK && flag) {
					this.mob.performRangedAttack(livingentity, 1.0F);
					ItemStack itemstack1 = this.mob.getItemInHand(
							ProjectileUtil.getWeaponHoldingHand(this.mob, ItemInit.first_beast_crossbow.get()));
					ItemBeastCrossbow.setCharged(itemstack1, false);
					this.crossbowState = EntityTheFirstBeast.CrossbowState.UNCHARGED;

//					if (noActiveAnimation()) {
//						AnimationPacket.send(EntityTheFirstBeast.this, ARROW_ANIMATION);
//					}

				}

			}
		}

	}
	@OnlyIn(Dist.CLIENT)
	private static class HasturMusic extends AbstractTickableSoundInstance {
		private final EntityTheFirstBeast hastur;

		public HasturMusic(EntityTheFirstBeast hastur) {
			super(SoundInit.ENTITY_BEAST_FROM_BEYOND_MUSIC.get(), SoundSource.RECORDS,RandomSource.create());

			this.hastur = hastur;
			this.x = hastur.getSource().getX();
			this.y = hastur.getSource().getY();
			this.z = hastur.getSource().getZ();
			this.looping = true;
		}

		@Override
		public void tick() {
			if (!hastur.isAlive()) {
				this.stop();
			}
		}
	}
	private static final String TAG_SOURCE_X = "sourceX";
	private static final String TAG_SOURCE_Y = "sourceY";
private static final String TAG_SOURCE_Z = "sourcesZ";
	private static final EntityDataAccessor<Boolean> DATA_CHARGING_STATE = SynchedEntityData
			.defineId(EntityTheFirstBeast.class, EntityDataSerializers.BOOLEAN);
	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).add(Attributes.MOVEMENT_SPEED, 0.3D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.15D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	private BlockPos source = BlockPos.ZERO;

	//	public static final Animation ARROW_ANIMATION = new Animation(64);
//	public static final Animation CHARGE_ANIMATION = new Animation(104);
//	public static final Animation BITE_ANIMATION = new Animation(17);
	private int animationTick;

	public int deathTicks;

	private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(),
			BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

	public EntityTheFirstBeast(EntityType<? extends EntityTheFirstBeast> type, Level worldIn) {
		super(type, worldIn);
		this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(ItemInit.first_beast_crossbow.get()));

	}

	@Override
	public void addAdditionalSaveData(CompoundTag cmp) {
		super.addAdditionalSaveData(cmp);
		cmp.putInt(TAG_SOURCE_X, source.getX());
		cmp.putInt(TAG_SOURCE_Y, source.getY());
		cmp.putInt(TAG_SOURCE_Z, source.getZ());
	}

	@SuppressWarnings("unused")
	@Override
	public void aiStep() {
		super.aiStep();
		///Animation animation = getAnimation();
		//int animTick = getAnimationTick();
	}

	@Override
	public boolean canFireProjectileWeapon(ProjectileWeaponItem p_230280_1_) {
		return p_230280_1_ == Items.BOW;
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_CHARGING_STATE, false);

	}

	@Override
	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		ItemEntity itementity = this.spawnAtLocation(ItemInit.breath_of_the_beast.get());
		if (itementity != null) {
			itementity.setExtendedLifetime();
		}

	}

	private void dropExperience(int xp) {
		while (xp > 0) {
			int i = ExperienceOrb.getExperienceValue(xp);
			xp -= i;
			this.level().addFreshEntity(new ExperienceOrb(this.level(), this.getX(), this.getY(), this.getZ(), i));
		}

	}

	@Override
	protected void enchantSpawnedWeapon(RandomSource p_217049_, float p_217050_) {
		super.enchantSpawnedWeapon(p_217049_, p_217050_);
		if (this.random.nextInt(300) == 0) {
			ItemStack itemstack = this.getOffhandItem();
			if (itemstack.getItem() == ItemInit.first_beast_crossbow.get()) {
				Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemstack);
				map.putIfAbsent(Enchantments.PIERCING, 1);
				EnchantmentHelper.setEnchantments(map, itemstack);
				this.setItemSlot(EquipmentSlot.OFFHAND, itemstack);
			}
		}
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn,
			MobSpawnType reason, SpawnGroupData spawnDataIn, CompoundTag dataTag) {
		this.populateDefaultEquipmentSlots(random, difficultyIn);
		this.populateDefaultEquipmentEnchantments(random, difficultyIn);
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);

	}

	protected EntityFirstBeastBolt fireArrow(ItemStack arrowStack, EntityTheFirstBeast shooter, float distanceFactor) {
		ItemBeastBolt arrowitem = (ItemBeastBolt) (arrowStack.getItem() instanceof ItemBeastBolt ? arrowStack.getItem()
				: ItemInit.first_beast_bolt.get());
		EntityFirstBeastBolt abstractarrowentity = arrowitem.createArrow(shooter.level(),
				arrowStack, shooter);
		abstractarrowentity.setEnchantmentEffectsFromEntity(shooter, distanceFactor);
		if (arrowStack.getItem() == Items.TIPPED_ARROW && abstractarrowentity instanceof EntityFirstBeastBolt) {
			abstractarrowentity.setPotionEffect(arrowStack);
		}

		return abstractarrowentity;
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.ENTITY_BEAST_FROM_BEYOND_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.ENTITY_BEAST_FROM_BEYOND_DEATH.get();

	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ENTITY_BEAST_FROM_BEYOND_HURT.get();

	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}

	public BlockPos getSource() {
		return source;
	}

	@SuppressWarnings("unused")
	private void greatHowl() {
		playSound(SoundEvents.WOLF_HOWL, .25F, 1f);
		this.setDeltaMovement(0, 0, 0);
		this.setDeltaMovement(0, 0, 0);
		this.setDeltaMovement(0, 0, 0);
		this.setDeltaMovement(0, 0, 0);

		repel(level(), new AABB(this.position().add(-8, -8, -8), this.position().add(8, 8, 8)), this.position().x() + 0.5,
				this.position().y(), this.position().z() + 0.5);
	}

	@Override
	public void heal(float amount) {
		super.heal(amount);

	}

	public boolean isArmored() {
		return this.getHealth() <= this.getMaxHealth() / 2.0F;
	}

	public boolean isCharging() {
		return this.entityData.get(DATA_CHARGING_STATE);
	}

	public boolean isVulnerable() {
		return this.getHealth() <= this.getMaxHealth() / 4.0F;
	}

	@Override
	public void onCrossbowAttackPerformed() {
		this.noActionTime = 0;
	}

	@Override
	public void performRangedAttack(LivingEntity target, float distanceFactor) {
		ItemStack itemstack = this
				.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, Items.BOW)));
		AbstractArrow abstractarrowentity = this.fireArrow(itemstack, this, distanceFactor);
		if (this.getMainHandItem().getItem() instanceof net.minecraft.world.item.BowItem)
			abstractarrowentity = ((net.minecraft.world.item.BowItem) this.getMainHandItem().getItem())
					.customArrow(abstractarrowentity);
		double d0 = target.getX() - this.getX();
		double d1 = target.getY(0.3333333333333333D) - abstractarrowentity.getY();
		double d2 = target.getZ() - this.getZ();
		double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
		abstractarrowentity.shoot(d0, d1 + d3 * 0.2F, d2, 1.6F,
				14 - this.level().getDifficulty().getId() * 4);
		this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
		this.level().addFreshEntity(abstractarrowentity);
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundInit.ENTITY_BEAST_FROM_BEYOND_STEP.get(), 0.15F, 1.0F);
	}

	
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource p_217055_, DifficultyInstance p_217056_) {
		super.populateDefaultEquipmentSlots(p_217055_, p_217056_);
		this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(ItemInit.first_beast_crossbow.get()));	}

	@Override
	public void readAdditionalSaveData(CompoundTag cmp) {
		super.readAdditionalSaveData(cmp);
		int x = cmp.getInt(TAG_SOURCE_X);
		int y = cmp.getInt(TAG_SOURCE_Y);
		int z = cmp.getInt(TAG_SOURCE_Z);
		source = new BlockPos(x, y, z);

	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void readSpawnData(FriendlyByteBuf additionalData) {
		source = BlockPos.of(additionalData.readLong());
		Minecraft.getInstance().getSoundManager().play(new HasturMusic(this));

	}

	@Override
	protected void registerGoals() {
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Villager.class, true));
		this.goalSelector.addGoal(1, new GoalFirstBeastCrossbowAttack<>(this, 1.0D, 8.0F));

	}

	public void repel(Level world, AABB effectBounds, double x, double y, double z) {
		List<Entity> list = world.getEntities(this, effectBounds);
		for (Entity ent : list) {
			if (!(ent instanceof EntitySummonedBeast)) {
				Vec3 p = new Vec3(x, y, z);
				Vec3 t = new Vec3(ent.getX(), ent.getY(), ent.getZ());
				double distance = p.distanceTo(t) + 0.1D;
				Vec3 r = new Vec3(t.x - p.x, t.y - p.y, t.z - p.z);
				ent.setDeltaMovement(r.x * 2 / distance, r.y * 2 / distance, r.z * 2 / distance);
				for (int countparticles = 0; countparticles <= 10; ++countparticles) {
					world.addParticle(ParticleTypes.SMOKE,
							ent.getX() + (world.random.nextDouble() - 0.5D) * ent.getBbWidth(),
							ent.getY() + world.random.nextDouble() * ent.getBbHeight()
									- ent.getMyRidingOffset() - 0.5,
							ent.getZ() + (world.random.nextDouble() - 0.5D) * ent.getBbWidth(), 0.0D, 0.0D,
							0.0D);
					ent.playSound(SoundEvents.WOLF_HOWL, .15F, 1f + (float) Math.random() * 0.2F);

				}
			}
		}
	}

	@Override
	public void setChargingCrossbow(boolean isCharging) {
		this.entityData.set(DATA_CHARGING_STATE, isCharging);
	}

	@Override
	public void shootCrossbowProjectile(LivingEntity p_230284_1_, ItemStack p_230284_2_, Projectile p_230284_3_,
			float p_230284_4_) {
		this.shootCrossbowProjectile(this, p_230284_1_, p_230284_3_, p_230284_4_, 1.6F);
	}

	@SuppressWarnings("unused")
	private void spawnWolfShot() {
		EntityWolfShot missile = new EntityWolfShot(this, true);
		missile.setPos(this.getX() + (Math.random() - 0.5 * 0.1), this.getY() + (Math.random() - 0.5 * 0.1),
				this.getZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			playSound(SoundEvents.WOLF_GROWL, 0.6F, 0.8F + (float) Math.random() * 0.2F);
			level().addFreshEntity(missile);
		}
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	// Attacks
	public void summonHounds(int numTent) {
		EntitySummonedBeast[] tentArray = new EntitySummonedBeast[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntitySummonedBeast(EntityInit.summoned_beast.get(), level());
			tentArray[i].setBeastType(random.nextInt(4));
			float xMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 1.5 + yMod, this.getZ() + 0.5 + zMod);
			if (!level().isClientSide) {
				level().addFreshEntity(tentArray[i]);
			}
		}
	}

	@SuppressWarnings("unused")
	@Override
	public void tick() {
		super.tick();
//		updateAnimations();
		float diffMult = 1f;
		// Protection
		if (isArmored()) {
			heal(0.05f);
			diffMult = 0.7f;
		}
		if (isVulnerable()) {
			heal(0.1f);
			diffMult = 0.1f;
		} else {
			diffMult = 1;
		}

		// Attacks

		int attackRoll = tickCount + random.nextInt(5);
		if (this.deathTicks <= 0) {

			/*
			 * if (attackRoll % 50 * diffMult == 0) { this.spawnWolfShot(); } else if
			 * (attackRoll % 120 * diffMult == 0) { if (world.rand.nextBoolean()) { // //
			 * this.summonTentacleAid(rand.nextInt(10)); } else { // //
			 * this.summonSpawnAid(rand.nextInt(5)); } } else if (attackRoll % 130 *
			 * diffMult == 0) { this.greatHowl(); } if (this.onGround()) { if (attackRoll
			 * % 100 * diffMult == 0) { this.summonHounds(rand.nextInt(1) + 2); } }
			 */

			// Removed Starstrikes to use on the seraphim, still has the one missle spawn
			// though
			float f = (this.random.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;
			/*
			 * this.world.addParticle(ParticleTypes.AMBIENT_ENTITY_EFFECT, this.getPosX() +
			 * (double) f, this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double)
			 * f2, 0.0D, 0.0D, 0.0D);
			 */
		}
	}

	// Death
	/**
	 * handles entity death timer, experience orb and particle creation
	 */
	@Override
	protected void tickDeath() {
		++this.deathTicks;
		if (this.deathTicks >= 100 && this.deathTicks <= 200) {
			float f = (this.random.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;
			this.level().addParticle(ParticleTypes.ASH, this.getX() + f, this.getY() + 2.0D + f1,
					this.getZ() + f2, 0.0D, 0.0D, 0.0D);

			if (this.deathTicks >= 100) {
				this.level().addParticle(ParticleTypes.FALLING_LAVA, this.getX() + f,
						this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}

			if (this.deathTicks >= 150) {
				this.level().addParticle(ParticleTypes.FLASH, this.getX() + f, this.getY() + 2.0D + f1,
						this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}

		}

		boolean flag = this.level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT);

		if (!this.level().isClientSide && deathTicks % (15 + random.nextInt(4)) == 0) {
			ItemEntity outputItem = new ItemEntity(level(), this.getX(), this.getY(), this.getZ(),
					new ItemStack(ItemInit.blooddrawn_fang.get()));
			level().addFreshEntity(outputItem);
		}

		if (this.deathTicks == 200) {
			if (level().isClientSide) {
				level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_EXPLODE,
						SoundSource.HOSTILE, 3f, 0.2f, false);
			}
		}

		if (this.deathTicks == 200 && !this.level().isClientSide) {
			if (flag) {
				this.dropExperience(Mth.floor(500 * 0.2F));
			}
			this.remove(RemovalReason.KILLED);
		}

	}

	@Override
	public void writeSpawnData(FriendlyByteBuf buffer) {
		buffer.writeLong(source.asLong());

	}

//	// Animation
//	@Override
//	public int getAnimationTick() {
//		return animationTick;
//	}
//
//	@Override
//	public void setAnimationTick(int tick) {
//		animationTick = tick;
//	}
//
//	@Override
//	public Animation getAnimation() {
//		return animation;
//	}
//
//	@Override
//	public void setAnimation(Animation animation) {
//		if (animation == null)
//			animation = NO_ANIMATION;
//		setAnimationTick(0);
//		this.animation = animation;
//	}
//
//	@Override
//	public Animation[] getAnimations() {
//		return new Animation[] { BITE_ANIMATION, ARROW_ANIMATION, CHARGE_ANIMATION };
//	}

}