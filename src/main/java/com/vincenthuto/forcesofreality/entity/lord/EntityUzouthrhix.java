package com.vincenthuto.forcesofreality.entity.lord;

import java.util.EnumSet;
import java.util.List;

import com.vincenthuto.forcesofreality.entity.summon.EntityBlackGoat;
import com.vincenthuto.forcesofreality.entity.summon.EntitySummonedBeast;
import com.vincenthuto.forcesofreality.init.BlockInit;
import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.init.SoundInit;
import com.vincenthuto.hutoslib.client.particle.util.ParticleColor;
import com.vincenthuto.hutoslib.common.network.HLPacketHandler;
import com.vincenthuto.hutoslib.math.MathUtils;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.event.entity.EntityTeleportEvent;
import net.minecraftforge.network.NetworkHooks;

public class EntityUzouthrhix extends Monster implements IEntityAdditionalSpawnData/* , IAnimatable */ {

	// Bite Goal
	private class AttackGoal extends Goal {
		public AttackGoal() {
			setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
		}

		@Override
		public boolean canUse() {
			return !isControlledByLocalInstance() && getTarget() != null;
		}

		@Override
		public void tick() {
			LivingEntity target = getTarget();
			if (target == null)
				return;
			double distFromTarget = distanceToSqr(target);

			getLookControl().setLookAt(target, getMaxHeadYRot(), getMaxHeadXRot());

			boolean isClose = distFromTarget < 40;

			if (getNavigation().isDone())
				getNavigation().moveTo(target, 1.2);
//
//			if (isClose)
//				yRotO = (float) MathUtils.getAngle(EntityUzouthrhix.this, target) + 90f;
//
//			if (noActiveAnimation()) {
//				if (isClose && Mth.degreesDifferenceAbs((float) MathUtils.getAngle(EntityUzouthrhix.this, target) + 90,
//						yRot) < 30)
//					AnimationPacket.send(EntityUzouthrhix.this, BITE_ANIMATION);
//			}
		}
	}
	@OnlyIn(Dist.CLIENT)
	private static class HasturMusic extends AbstractTickableSoundInstance {
		private final EntityUzouthrhix hastur;

		public HasturMusic(EntityUzouthrhix hastur) {
			super(SoundInit.ENTITY_DARK_YOUNG_MUSIC.get(), SoundSource.RECORDS, RandomSource.create());

			this.hastur = hastur;
			this.x = hastur.getSource().getX();
			this.y = hastur.getSource().getY();
			this.z = hastur.getSource().getZ();
			this.looping = true;
		}

		@Override
		public float getVolume() {
			return super.getVolume();
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
	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).add(Attributes.MOVEMENT_SPEED, 0.3D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1.15D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}
	private BlockPos source = BlockPos.ZERO;
private int attackTimer;
	private int teleportTime;
	public int deathTicks;
	//	private Animation animation = NO_ANIMATION;
//	public static final Animation LIGHTNING_ANIMATION = new Animation(64);
//	public static final Animation CHARGE_ANIMATION = new Animation(104);
//	public static final Animation BITE_ANIMATION = new Animation(17);
	public int lightningCooldown = 0;
	public boolean beached = true;
	// public final TickFloat beachedTimer = new TickFloat().setLimit(0, 1);
	private int animationTick;

	private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(),
			BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

	public boolean clawStrikeFlag;

	public final AnimationState idleAnimationState = new AnimationState();

	public EntityUzouthrhix(EntityType<? extends EntityUzouthrhix> type, Level worldIn) {
		super(type, worldIn);

	}

	@Override
	public void addAdditionalSaveData(CompoundTag cmp) {
		super.addAdditionalSaveData(cmp);
		cmp.putInt(TAG_SOURCE_X, source.getX());
		cmp.putInt(TAG_SOURCE_Y, source.getY());
		cmp.putInt(TAG_SOURCE_Z, source.getZ());
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (lightningCooldown > 0) {
			--lightningCooldown;
		}
		if (this.attackTimer > 0) {
			--this.attackTimer;
		}

		boolean prevBeached = beached;
		if (!beached && onGround && !wasTouchingWater)
			beached = true;
		else if (beached && wasTouchingWater)
			beached = false;
		if (prevBeached != beached)
			refreshDimensions();
		// beachedTimer.add((beached) ? 0.1f : -0.05f);

//		Animation animation = getAnimation();
//		int animTick = getAnimationTick();
//		if (animation == LIGHTNING_ANIMATION) {
//			lightningCooldown += 6;
//			if (animTick == 10)
//				playSound(SoundInit.ENTITY_DARK_YOUNG_HIT, .25F, 1f);
//			if (!level.isClientSide && animTick >= 10) {
//				LivingEntity target = getTarget();
//				if (target != null) {
//					if (animTick % 30 == 0) {
//						this.shock(getTarget());
//					}
//				}
//			}
//
//		} else if (animation == BITE_ANIMATION) {
//			if (animTick == 0)
//				playSound(SoundInit.ENTITY_DARK_YOUNG_HIT, .25F, 1f);
//			else if (animTick == 6)
//				attackInBox(getBoundingBox()
//						.move(Vec3.directionFromRotation(isInWater() ? xRot : 0, yHeadRot).scale(5.5f)).inflate(0.85),
//						40);
//		}

	}

	public void attackInBox(AABB box, int disabledShieldTime) {
		List<LivingEntity> attackables = level.getEntitiesOfClass(LivingEntity.class, box,
				entity -> entity != this && !hasPassenger(entity));
		for (LivingEntity attacking : attackables) {
			doHurtTarget(attacking);
			if (disabledShieldTime > 0 && attacking instanceof Player) {
				Player player = ((Player) attacking);
				if (player.isUsingItem()) {
					player.getCooldowns().addCooldown(Items.SHIELD, disabledShieldTime);
					player.stopUsingItem();
					level.broadcastEntityEvent(player, (byte) 9);
				}
			}
		}
	}

	private void beyondFlames(Entity target) {
		if (target != null) {
			playSound(SoundEvents.DRAGON_FIREBALL_EXPLODE, .25F, 1f);
			setFlame(target.blockPosition().offset(2, 0, 0));
			setFlame(target.blockPosition().offset(-2, 0, 0));
			setFlame(target.blockPosition().offset(0, 0, 2));
			setFlame(target.blockPosition().offset(0, 0, -2));
			setFlame(target.blockPosition().offset(-1, 0, 1));
			setFlame(target.blockPosition().offset(1, 0, -1));
			setFlame(target.blockPosition().offset(-1, 0, -1));
			setFlame(target.blockPosition().offset(1, 0, 1));
		}
	}

	public boolean canZap() {
		return isInWaterOrRain() && lightningCooldown <= 0;
	}

	@Override
	protected void customServerAiStep() {
		/*
		 * if (this.rand.nextFloat() * 30.0F < (10 - 0.4F) * 2.0F) {
		 * this.teleportRandomly(); }
		 */
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		this.attackTimer = 10;
		return super.doHurtTarget(entityIn);
	}

	@Override
	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		ItemEntity itementity = this.spawnAtLocation(ItemInit.everwatchful_pendant.get());
		if (itementity != null) {
			itementity.setExtendedLifetime();
		}

	}

	private void dropExperience(int xp) {
		while (xp > 0) {
			int i = ExperienceOrb.getExperienceValue(xp);
			xp -= i;
			this.level.addFreshEntity(new ExperienceOrb(this.level, this.getX(), this.getY(), this.getZ(), i));
		}

	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn,
			MobSpawnType reason, SpawnGroupData spawnDataIn, CompoundTag dataTag) {
		return super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.ENTITY_DARK_YOUNG_AMBIENT.get();
	}

	@OnlyIn(Dist.CLIENT)
	public int getAttackTimer() {
		return this.attackTimer;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return null;

	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ENTITY_DARK_YOUNG_HURT.get();

	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}

	public BlockPos getSource() {
		return source;
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions size) {
		return size.height * (beached ? 1f : 0.6f);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void handleEntityEvent(byte id) {
		if (id == 4) {
			this.attackTimer = 10;
			this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
		} else {
			super.handleEntityEvent(id);
		}

	}

	@Override
	public void heal(float amount) {
		super.heal(amount);

	}

	public boolean isArmored() {
		return this.getHealth() < this.getMaxHealth() / 2.0F && this.getHealth() >= this.getMaxHealth() / 4.0F;
	}

	public boolean isJumpingOutOfWater() {
		return !isInWater() && !beached;
	}

	public boolean isVulnerable() {
		return this.getHealth() < this.getMaxHealth() / 4.0F;
	}

	@SuppressWarnings("unused")
	private void massBlind(Entity target) {
		if (target != null) {
			if (target instanceof Player) {
				Player player = (Player) target;
				// player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 80, 255));
			}
		}
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
	}

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
		goalSelector.addGoal(2, new AttackGoal());
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 2.3d, 50));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));

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
							ent.getY() + world.random.nextDouble() * ent.getBbHeight() - ent.getMyRidingOffset() - 0.5,
							ent.getZ() + (world.random.nextDouble() - 0.5D) * ent.getBbWidth(), 0.0D, 0.0D, 0.0D);
					playSound(SoundInit.ENTITY_DARK_YOUNG_HIT.get(), .25F, 1f);

				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void setFlame(BlockPos pos) {
		if (level.getBlockState(pos).isAir()) {
			level.setBlockAndUpdate(pos, BlockInit.beyond_flames.get().defaultBlockState());
		}
	}

////Animation
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
//		return new Animation[] { BITE_ANIMATION, LIGHTNING_ANIMATION, CHARGE_ANIMATION };
//	}

	private void shock(Entity target) {
		if (target != null) {
			playSound(SoundInit.ENTITY_DARK_YOUNG_HIT.get(), .25F, 1f);
			this.setDeltaMovement(0, 0, 0);
			Vector3 endVec = Vector3.fromEntityCenter(target);
			Vec3 speedVec = new Vec3(endVec.x, endVec.y, endVec.z);
			HLPacketHandler.sendLightningSpawn(this.position().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					this.level.dimension(), ParticleColor.BLACK, 2, 10, 9, 0.2f);
			HLPacketHandler.sendLightningSpawn(this.position().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					this.level.dimension(), ParticleColor.WHITE, 2, 10, 9, 0.2f);
			HLPacketHandler.sendLightningSpawn(this.position().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					this.level.dimension(), ParticleColor.PURPLE, 2, 10, 9, 0.2f);
			if (target.position().distanceTo(this.position()) < random.nextInt(27)) {
				target.hurt(DamageSource.LIGHTNING_BOLT, 4f);
			}
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

	// Attack types
	public void summonGoats(int numTent) {
		EntityBlackGoat[] tentArray = new EntityBlackGoat[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityBlackGoat(EntityInit.black_goat.get(), level);
			float xMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 1.5 + yMod, this.getZ() + 0.5 + zMod);
			if (!level.isClientSide) {
				level.addFreshEntity(tentArray[i]);
			}
		}
	}

	/**
	 * Teleport the boss
	 *
	 * @return
	 */
	private boolean teleport(double x, double y, double z) {
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos(x, y, z);
		while (blockpos$mutable.getY() > 0
				&& !this.level.getBlockState(blockpos$mutable).getMaterial().blocksMotion()) {
			blockpos$mutable.move(Direction.DOWN);
		}
		BlockState blockstate = this.level.getBlockState(blockpos$mutable);
		boolean flag = blockstate.getMaterial().blocksMotion();
		boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
		if (flag && !flag1) {
			EntityTeleportEvent event = new EntityTeleportEvent(this, x, y, z);
			if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
				return false;
			boolean flag2 = this.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
			if (flag2 && !this.isSilent()) {
				this.level.playSound((Player) null, this.xo, this.yo, this.zo,
						SoundInit.ENTITY_DARK_YOUNG_TELEPORT.get(), this.getSoundSource(), 0.5f, 0.5f);
				this.playSound(SoundInit.ENTITY_DARK_YOUNG_TELEPORT.get(), 0.5f, 0.5f);
			}
			return flag2;
		} else {
			return false;
		}
	}

	/**
	 * Teleport to a random nearby position
	 */
	protected boolean teleportRandomly() {
		if (!this.level.isClientSide() && this.isAlive()) {
			double d0 = this.getX() + (this.random.nextDouble() - 0.5D) * 16.0D;
			double d1 = this.getY() + (this.random.nextInt(64) - 32);
			double d2 = this.getZ() + (this.random.nextDouble() - 0.5D) * 16.0D;
			return this.teleport(d0, d1, d2);
		} else {
			return false;
		}
	}

	/**
	 * Teleport to another entity
	 */
	private boolean teleportToEntity(Entity target) {
		Vec3 vector3d = new Vec3(this.getX() - target.getX(), this.getY(0.5D) - target.getEyeY(),
				this.getZ() - target.getZ());
		vector3d = vector3d.normalize();
		double d1 = this.getX() + (this.random.nextDouble() - 0.5D) * 8.0D - vector3d.x * 8.0D;
		double d2 = this.getY() + (this.random.nextInt(16) - 8) - vector3d.y * 8.0D;
		double d3 = this.getZ() + (this.random.nextDouble() - 0.5D) * 8.0D - vector3d.z * 8.0D;
		return this.teleport(d1, d2, d3);
	}

	@Override
	public void tick() {
		super.tick();
		// updateAnimations();
		if (this.level.isClientSide()) {
			this.idleAnimationState.startIfStopped(this.tickCount);
		}
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

		if (tickCount % 50 > 10) {
			this.clawStrikeFlag = true;
		} else {
			this.clawStrikeFlag = false;
		}

		int attackRoll = tickCount + random.nextInt(5);
		if (this.deathTicks <= 0) {
			if (attackRoll % 100 * diffMult == 0) {
				this.beyondFlames(getTarget());
			}
			if (attackRoll % 120 == 0) {
				this.massBlind(getTarget());
			}
			if (attackRoll % 170 == 0) {
				this.summonGoats(3);
			}
			if (this.getTarget() != null) {
				if (this.teleportTime++ >= random.nextInt(20000) && this.teleportToEntity(this)) {
					this.teleportTime = 0;
				}
			}

			LivingEntity target = getTarget();
			if (target == null)
				return;
			double distFromTarget = distanceToSqr(target);

			getLookControl().setLookAt(target, getMaxHeadYRot(), getMaxHeadXRot());

			boolean isClose = distFromTarget < 40;

			if (getNavigation().isDone())
				getNavigation().moveTo(target, 1.2);

			if (isClose) {
				yBodyRot = (float) MathUtils.getAngle(EntityUzouthrhix.this, target) + 90f;
			}

//			if (noActiveAnimation()) {
//				if (distFromTarget > 50 && distFromTarget < 89) {
//					AnimationPacket.send(EntityUzouthrhix.this, LIGHTNING_ANIMATION);
//
//				} else if (distFromTarget > 90) {
//					// AnimationPacket.send(EntityUzouthrhix.this, CHARGE_ANIMATION);
//				} else if (isClose
//						&& Mth.degreesDifferenceAbs((float) MathUtils.getAngle(EntityUzouthrhix.this, target) + 90,
//								yRot) < 30) {
//					AnimationPacket.send(EntityUzouthrhix.this, BITE_ANIMATION);
//				}
//			}

			float f = (this.random.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;
			this.level.addParticle(ParticleTypes.ASH, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D,
					0.0D, 0.0D);
			this.level.addParticle(ParticleTypes.ASH, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D,
					0.0D, 0.0D);
		}
	}

	// Death
	/**
	 * handles entity death timer, experience orb and particle creation
	 */
	@Override
	protected void tickDeath() {
		++this.deathTicks;
		float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
		float f = (this.random.nextFloat() - 0.5F) * 8.0F;
		float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;
		if (this.deathTicks == 1) {
			if (level.isClientSide) {
				level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundInit.ENTITY_DARK_YOUNG_DEATH.get(),
						SoundSource.HOSTILE, 0.5f, 0.9f, false);
			}
		}
		if (this.deathTicks >= 100 && this.deathTicks <= 150) {

			this.level.addParticle(ParticleTypes.SOUL_FIRE_FLAME, this.getX() + f, this.getY() + 2.0D + f1,
					this.getZ() + f2, 0.0D, 0.0D, 0.0D);

			if (this.deathTicks >= 70) {
				this.level.addParticle(ParticleTypes.SMOKE, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2,
						0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks >= 100) {
				this.level.addParticle(ParticleTypes.SOUL, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2,
						0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks >= 130) {
				this.level.addParticle(ParticleTypes.DRIPPING_OBSIDIAN_TEAR, this.getX() + f, this.getY() + 2.0D + f1,
						this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks > 130) {
				this.level.addParticle(ParticleTypes.FLASH, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2,
						0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks >= 150) {
				this.level.addParticle(ParticleTypes.EXPLOSION, this.getX() + f, this.getY() + 2.0D + f1,
						this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}
		}

		boolean flag = this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT);

		if (!this.level.isClientSide && deathTicks % (15 + random.nextInt(4)) == 0) {
			ItemEntity outputItem = new ItemEntity(level, this.getX(), this.getY(), this.getZ(),
					new ItemStack(ItemInit.vitreous_humor.get()));
			level.addFreshEntity(outputItem);
		}

		if (this.deathTicks == 150) {
			if (level.isClientSide) {
				level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_EXPLODE,
						SoundSource.HOSTILE, 3f, 0.2f, false);
			}
		}

		if (this.deathTicks == 150 && !this.level.isClientSide) {
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

//	// Move Goal
//	private class MoveTowardsTargetGoal extends Goal {
//		private final PathfinderMob creature;
//		private LivingEntity targetEntity;
//		private double movePosX;
//		private double movePosY;
//		private double movePosZ;
//		private final double speed;
//		private final float maxTargetDistance;
//
//		public MoveTowardsTargetGoal(PathfinderMob creature, double speedIn, float targetMaxDistance) {
//			this.creature = creature;
//			this.speed = speedIn;
//			this.maxTargetDistance = targetMaxDistance;
//			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
//		}
//
//		@Override
//		public void tick() {
//			LivingEntity target = getTarget();
//			if (target == null)
//				return;
//			double distFromTarget = distanceToSqr(target);
//
//			getLookControl().setLookAt(target, getMaxHeadYRot(), getMaxHeadXRot());
//
//			boolean isClose = distFromTarget < 40;
//
//			if (getNavigation().isDone())
//				getNavigation().moveTo(target, 1.2);
//
////			if (isClose)
////				yRot = (float) MathUtils.getAngle(EntityUzouthrhix.this, target) + 90f;
////
////			if (noActiveAnimation()) {
////				if (distFromTarget > 120) {
////					AnimationPacket.send(EntityUzouthrhix.this, CHARGE_ANIMATION);
////				}
////			}
//		}
//
//		/**
//		 * Returns whether execution should begin. You can also read and cache any state
//		 * necessary for execution in this method as well.
//		 */
//		@Override
//		public boolean canUse() {
//			this.targetEntity = this.creature.getTarget();
//			if (this.targetEntity == null) {
//				return false;
//			} else if (this.targetEntity
//					.distanceToSqr(this.creature) > this.maxTargetDistance * this.maxTargetDistance) {
//				return false;
//			} else {
//				Vec3 vector3d = RandomPos.getPosTowards(this.creature, 16, 7, this.targetEntity.position());
//				if (vector3d == null) {
//					return false;
//
//				} else {
//					this.movePosX = vector3d.x;
//					this.movePosY = vector3d.y;
//					this.movePosZ = vector3d.z;
//					return true;
//				}
//			}
//		}
//
//		/**
//		 * Returns whether an in-progress EntityAIBase should continue executing
//		 */
//		@Override
//		public boolean canContinueToUse() {
//			return !this.creature.getNavigation().isDone() && this.targetEntity.isAlive() && this.targetEntity
//					.distanceToSqr(this.creature) < this.maxTargetDistance * this.maxTargetDistance;
//		}
//
//		/**
//		 * Reset the task's internal state. Called when this task is interrupted by
//		 * another one
//		 */
//		@Override
//		public void stop() {
//			this.targetEntity = null;
//		}
//
//		/**
//		 * Execute a one shot task or start executing a continuous task
//		 */
//		@Override
//		public void start() {
//			this.creature.getNavigation().moveTo(this.movePosX, this.movePosY, this.movePosZ, this.speed);
//		}
//	}

}