package com.vincenthuto.forcesofreality.common.entity.lord;

import java.util.List;

import com.vincenthuto.forcesofreality.common.entity.passive.EntityDenizen;
import com.vincenthuto.forcesofreality.common.entity.projectile.EntityTrackingOrb;
import com.vincenthuto.forcesofreality.common.entity.summon.EntityEldritchGrip;
import com.vincenthuto.forcesofreality.common.entity.summon.EntityHasturClone;
import com.vincenthuto.forcesofreality.common.entity.summon.EntityHasturSpawn;
import com.vincenthuto.forcesofreality.common.entity.summon.EntityTentacle;
import com.vincenthuto.forcesofreality.registry.EntityInit;
import com.vincenthuto.forcesofreality.registry.SoundInit;
import com.vincenthuto.hutoslib.math.MathUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

public class EntityXanthousKing extends Monster implements IEntityAdditionalSpawnData/* , IAnimatable */ {

	@OnlyIn(Dist.CLIENT)
	private static class HasturMusic extends AbstractTickableSoundInstance {
		private final EntityXanthousKing hastur;

		public HasturMusic(EntityXanthousKing hastur) {
			super(SoundInit.ENTITY_HASTUR_MUSIC.get(), SoundSource.RECORDS,RandomSource.create());

			this.hastur = hastur;
			this.x = hastur.getSource().getX();
			this.y = hastur.getSource().getY();
			this.z = hastur.getSource().getZ();
			this.looping = true;
		}

		@Override
		public float getVolume() {
			return super.getVolume() / 2;
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
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).add(Attributes.MOVEMENT_SPEED, 0.15D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}
private BlockPos source = BlockPos.ZERO;
	protected int clientTickCounter = -1;
//	private Animation animation = NO_ANIMATION;
//	public static final Animation LIGHTNING_ANIMATION = new Animation(64);
//	public static final Animation CHARGE_ANIMATION = new Animation(104);
//	public static final Animation BITE_ANIMATION = new Animation(17);
	public int lightningCooldown = 0;
	public boolean beached = true;
	//	public final TickFloat beachedTimer = new TickFloat().setLimit(0, 1);
	private int animationTick;

	public int deathTicks;

	private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(),
			BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

	public EntityXanthousKing(EntityType<? extends EntityXanthousKing> type, Level worldIn) {
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

		boolean prevBeached = beached;
		if (!beached && onGround() && !wasTouchingWater)
			beached = true;
		else if (beached && wasTouchingWater)
			beached = false;
		if (prevBeached != beached)
			refreshDimensions();
//		beachedTimer.add((beached) ? 0.1f : -0.05f);
//
//		Animation animation = getAnimation();
//		int animTick = getAnimationTick();
//		if (animation == BITE_ANIMATION) {
//			if (animTick == 0)
//				playSound(SoundInit.ENTITY_DARK_YOUNG_HIT.get(), .25F, 1f);
//			else if (animTick == 6)
//				attackInBox(getBoundingBox()
//						.move(Vec3.directionFromRotation(isInWater() ? getXRot() : 0, yHeadRot).scale(5.5f)).inflate(0.85),
//						40);
//		}
	}

	protected void applyEntityAI() {
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, true));
		/*
		 * this.targetSelector.addGoal(1, new NearestAttackableHasturAttacks<>(this,
		 * PlayerEntity.class, true));
		 *
		 *
		 * this.targetSelector.addGoal(1, new NearestAttackableTentacle<>(this,
		 * PlayerEntity.class, rand.nextInt(2), true));
		 */
	}

	public void attackInBox(AABB box, int disabledShieldTime) {
		List<LivingEntity> attackables = level().getEntitiesOfClass(LivingEntity.class, box,
				entity -> entity != this && !hasPassenger(entity));
		for (LivingEntity attacking : attackables) {
			doHurtTarget(attacking);
			if (disabledShieldTime > 0 && attacking instanceof Player) {
				Player player = ((Player) attacking);
				if (player.isUsingItem() ) {
					player.getCooldowns().addCooldown(Items.SHIELD, disabledShieldTime);
					player.stopUsingItem();
					level().broadcastEntityEvent(player, (byte) 9);
				}
			}
		}
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
		this.getBossInfo().setProgress(this.getHealth() / this.getMaxHealth());

	}

	@Override
	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		/*
		 * ItemEntity itementity = this.entityDropItem(ItemInit.yellow_sign.get()); if
		 * (itementity != null) { itementity.setNoDespawn(); }
		 */

	}

	private void dropExperience(int xp) {
		while (xp > 0) {
			int i = ExperienceOrb.getExperienceValue(xp);
			xp -= i;
			this.level().addFreshEntity(new ExperienceOrb(this.level(), this.getX(), this.getY(), this.getZ(), i));
		}

	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.ENTITY_HASTUR_AMBIENT.get();
	}

	public ServerBossEvent getBossInfo() {
		return bossInfo;
	}

	public int getClientTicks() {
		return this.clientTickCounter;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.ENTITY_HASTUR_DEATH.get();

	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ENTITY_HASTUR_HURT.get();

	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}

	public BlockPos getSource() {
		return source;
	}

	@Override
	public void heal(float amount) {
		super.heal(amount);

	}

	public boolean isArmored() {
		return this.getHealth() <= this.getMaxHealth() / 2.0F;
	}

	public boolean isVulnerable() {
		return this.getHealth() <= this.getMaxHealth() / 4.0F;
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
		/*
		 * this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		 * this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		 */
		this.applyEntityAI();
	//	goalSelector.addGoal(2, new AttackGoal());
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.12));
		this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 3d, 5));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));

	}

	public void setClientTicks(int ticks) {
		this.clientTickCounter = ticks;
	}

	private void spawnMissile() {
		EntityTrackingOrb missile = new EntityTrackingOrb(this, true);
		missile.setPos(this.getX() + (Math.random() - 0.5 * 0.1), this.getY() + 2.4 + (Math.random() - 0.5 * 0.1),
				this.getZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			playSound(SoundInit.ENTITY_HASTUR_HIT.get(), 0.6F, 0.8F + (float) Math.random() * 0.2F);
			level().addFreshEntity(missile);
		}
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.getBossInfo().addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.getBossInfo().removePlayer(player);
	}

	public void summonClones(int numTent) {
		EntityHasturClone[] tentArray = new EntityHasturClone[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityHasturClone(EntityInit.hastur_clone.get(), level());
			float xMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 1.5 + yMod, this.getZ() + 0.5 + zMod);
			if (!level().isClientSide) {
				playSound(SoundInit.ENTITY_HASTUR_HURT.get(), 0.6F, 0.8F + (float) Math.random() * 0.2F);
				level().addFreshEntity(tentArray[i]);

			}
		}
	}

	public void summonDenizenAid(int numTent) {
		EntityDenizen[] tentArray = new EntityDenizen[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityDenizen(EntityInit.denizen.get(), level());
			tentArray[i].setDenizenType(random.nextInt(7));
			float xMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 1.5 + yMod, this.getZ() + 0.5 + zMod);
			if (!level().isClientSide) {
				level().addFreshEntity(tentArray[i]);

			}
		}
	}

	public void summonEldritchGrip(int numTent) {
		EntityEldritchGrip[] tentArray = new EntityEldritchGrip[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityEldritchGrip(EntityInit.eldritch_grip.get(), level());
			float xMod = (this.random.nextFloat() - 0.5F) * 16.0F;
			// float yMod = (this.rand.nextFloat() - 0.5F) * 2.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 16.0F;
			tentArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 0.1, this.getZ() + 0.5 + zMod);
			if (!level().isClientSide) {
				level().addFreshEntity(tentArray[i]);

			}
		}
	}

	public void summonSpawnAid(int numSpawn) {
		EntityHasturSpawn[] spawnArray = new EntityHasturSpawn[numSpawn];
		for (int i = 0; i < numSpawn; i++) {
			spawnArray[i] = new EntityHasturSpawn(EntityInit.hastur_spawn.get(), level());
			spawnArray[i].setSpawnType(random.nextInt(3));
			float xMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			spawnArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 2.5 + yMod, this.getZ() + 0.5 + zMod);
			if (!level().isClientSide) {
				level().addFreshEntity(spawnArray[i]);
			}
		}
	}

	// Attack types
	public void summonTentacleAid(int numTent) {
		EntityTentacle[] tentArray = new EntityTentacle[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityTentacle(EntityInit.tentacle.get(), level());
			tentArray[i].setTentacleType(random.nextInt(4));
			float xMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 1.5 + yMod, this.getZ() + 0.5 + zMod);
			if (!level().isClientSide) {
				level().addFreshEntity(tentArray[i]);

			}
		}
	}

	@Override
	public void tick() {
		super.tick();
	//	updateAnimations();
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
		if (this.deathTicks <= 0) {
			int attackRoll = tickCount + random.nextInt(5);

			if (attackRoll % 50 * diffMult == 0) {
				this.spawnMissile();
			} else if (attackRoll % 120 * diffMult == 0) {
				if (level().random.nextBoolean()) {
					this.summonTentacleAid(random.nextInt(10));
				} else {
					this.summonSpawnAid(random.nextInt(5));
				}
			} else if (attackRoll % 130 * diffMult == 0) {
		//		this.summonClones(random.nextInt(2));
			}
			if (this.onGround()) {
				if (attackRoll % 100 * diffMult == 0) {
					this.summonEldritchGrip(random.nextInt(1) + 3);
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
				setYRot((float) MathUtils.getAngle(EntityXanthousKing.this, target) + 90f);
			}

//			if (noActiveAnimation()) {
//				/*
//				 * if (distFromTarget > 50 && distFromTarget < 89) {
//				 * AnimationPacket.send(EntityXanthousKing.this, LIGHTNING_ANIMATION);
//				 *
//				 * } else if (distFromTarget > 90) { //
//				 * AnimationPacket.send(EntityUzouthrhix.this, CHARGE_ANIMATION); } else
//				 */if (isClose
//						&& Mth.degreesDifferenceAbs((float) MathUtils.getAngle(EntityXanthousKing.this, target) + 90,
//								yRot) < 30) {
//					AnimationPacket.send(EntityXanthousKing.this, BITE_ANIMATION);
//				}
//			}

			// Removed Starstrikes to use on the seraphim, still has the one missle spawn
			// though
			float f = (this.random.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;
			this.level().addParticle(ParticleTypes.WARPED_SPORE, this.getX() + f,
					this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			this.level().addParticle(ParticleTypes.CRIMSON_SPORE, this.getX() + f,
					this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D, 0.0D, 0.0D);
		}
	}

	// Death
	/**
	 * handles entity death timer, experience orb and particle creation
	 */
	@Override
	protected void tickDeath() {
		++this.deathTicks;
		if (this.deathTicks >= 75 && this.deathTicks <= 120) {
			float f = (this.random.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;
			this.level().addParticle(ParticleTypes.ASH, this.getX() + f, this.getY() + 2.0D + f1,
					this.getZ() + f2, 0.0D, 0.0D, 0.0D);

			if (this.deathTicks >= 75) {
				this.level().addParticle(ParticleTypes.FLASH, this.getX() + f, this.getY() + 2.0D + f1,
						this.getZ() + f2, 0.0D, 0.0D, 0.0D);
				this.level().addParticle(ParticleTypes.DRIPPING_HONEY, this.getX() + f,
						this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}
		}

		boolean flag = this.level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT);

		/*
		 * if (!this.world.isRemote && deathTicks % (15 + rand.nextInt(4)) == 0) {
		 * ItemEntity outputItem = new ItemEntity(world, this.getPosX(), this.getPosY(),
		 * this.getPosZ(), new ItemStack(ItemInit.unsettling_fabric.get()));
		 * world.addEntity(outputItem); }
		 */

		if (this.deathTicks == 120) {
			if (level().isClientSide) {
				level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_EXPLODE,
						SoundSource.HOSTILE, 3f, 0.2f, false);
			}
		}

		if (this.deathTicks == 120 && !this.level().isClientSide) {
			if (flag) {
				this.dropExperience(Mth.floor(500 * 0.2F));
			}
			this.remove(RemovalReason.KILLED);
			EntityTrueXanthousKing king = new EntityTrueXanthousKing(EntityInit.true_xanthous_king.get(), level());
			king.setPos(this.getX(), this.getY() + 1, this.getZ());
			level().addFreshEntity(king);
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
//		return new Animation[] { BITE_ANIMATION, LIGHTNING_ANIMATION, CHARGE_ANIMATION };
//	}
//
//	// Bite Goal
//	private class AttackGoal extends Goal {
//		public AttackGoal() {
//			setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
//		}
//
//		@Override
//		public boolean canUse() {
//			return !isControlledByLocalInstance() && getTarget() != null;
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
//			if (isClose)
//				yRot = (float) MathUtils.getAngle(EntityXanthousKing.this, target) + 90f;
//
//			if (noActiveAnimation()) {
//				if (isClose
//						&& Mth.degreesDifferenceAbs((float) MathUtils.getAngle(EntityXanthousKing.this, target) + 90,
//								yRot) < 30)
//					AnimationPacket.send(EntityXanthousKing.this, BITE_ANIMATION);
//			}
//		}
//	}
}