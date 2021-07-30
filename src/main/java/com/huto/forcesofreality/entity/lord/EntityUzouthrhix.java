package com.huto.forcesofreality.entity.lord;

import java.util.EnumSet;
import java.util.List;

import com.huto.forcesofreality.entity.summon.EntityBlackGoat;
import com.huto.forcesofreality.entity.summon.EntitySummonedBeast;
import com.huto.forcesofreality.init.BlockInit;
import com.huto.forcesofreality.init.EntityInit;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.sound.SoundHandler;
import com.hutoslib.client.model.Animation;
import com.hutoslib.client.model.AnimationPacket;
import com.hutoslib.client.model.IAnimatable;
import com.hutoslib.client.model.TickFloat;
import com.hutoslib.client.particle.util.ParticleColor;
import com.hutoslib.common.HutosLibPacketHandler;
import com.hutoslib.math.MathUtils;
import com.hutoslib.math.Vector3;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.TickableSound;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.GameRules;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityUzouthrhix extends Monster implements IEntityAdditionalSpawnData, IAnimatable {

	private BlockPos source = BlockPos.ZERO;
	private static final String TAG_SOURCE_X = "sourceX";
	private static final String TAG_SOURCE_Y = "sourceY";
	private static final String TAG_SOURCE_Z = "sourcesZ";
	private int attackTimer;
	private int teleportTime;
	public int deathTicks;
	private Animation animation = NO_ANIMATION;
	public static final Animation LIGHTNING_ANIMATION = new Animation(64);
	public static final Animation CHARGE_ANIMATION = new Animation(104);
	public static final Animation BITE_ANIMATION = new Animation(17);
	public int lightningCooldown = 0;
	public boolean beached = true;
	public final TickFloat beachedTimer = new TickFloat().setLimit(0, 1);
	private int animationTick;
	private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(),
			BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
	public boolean clawStrikeFlag;

	public EntityUzouthrhix(EntityType<? extends EntityUzouthrhix> type, World worldIn) {
		super(type, worldIn);

	}

	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
	}

	@Override
	protected void registerGoals() {
		goalSelector.addGoal(2, new AttackGoal());
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(1, new MoveTowardsTargetGoal(this, 2.3d, 50));
		this.goalSelector.addGoal(10, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));

	}

	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.15D)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void handleStatusUpdate(byte id) {
		if (id == 4) {
			this.attackTimer = 10;
			this.playSound(SoundEvents.ENTITY_IRON_GOLEM_ATTACK, 1.0F, 1.0F);
		} else {
			super.handleStatusUpdate(id);
		}

	}

	@OnlyIn(Dist.CLIENT)
	public int getAttackTimer() {
		return this.attackTimer;
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		this.attackTimer = 10;
		return super.attackEntityAsMob(entityIn);
	}

	public boolean canZap() {
		return isWet() && lightningCooldown <= 0;
	}

	@Override
	public void livingTick() {
		super.livingTick();
		if (lightningCooldown > 0) {
			--lightningCooldown;
		}
		if (this.attackTimer > 0) {
			--this.attackTimer;
		}

		boolean prevBeached = beached;
		if (!beached && onGround && !inWater)
			beached = true;
		else if (beached && inWater)
			beached = false;
		if (prevBeached != beached)
			recalculateSize();
		beachedTimer.add((beached) ? 0.1f : -0.05f);

		Animation animation = getAnimation();
		int animTick = getAnimationTick();
		if (animation == LIGHTNING_ANIMATION) {
			lightningCooldown += 6;
			if (animTick == 10)
				playSound(SoundHandler.ENTITY_DARK_YOUNG_HIT, .25F, 1f);
			if (!world.isRemote && animTick >= 10) {
				LivingEntity target = getAttackTarget();
				if (target != null) {
					if (animTick % 30 == 0) {
						this.shock(getAttackTarget());
					}
				}
			}

		} else if (animation == BITE_ANIMATION) {
			if (animTick == 0)
				playSound(SoundHandler.ENTITY_DARK_YOUNG_HIT, .25F, 1f);
			else if (animTick == 6)
				attackInBox(getBoundingBox()
						.offset(Vector3d.fromPitchYaw(isInWater() ? rotationPitch : 0, rotationYawHead).scale(5.5f))
						.grow(0.85), 40);
		}

	}

	public void attackInBox(AxisAlignedBB box, int disabledShieldTime) {
		List<LivingEntity> attackables = world.getEntitiesWithinAABB(LivingEntity.class, box,
				entity -> entity != this && !isPassenger(entity));
		for (LivingEntity attacking : attackables) {
			attackEntityAsMob(attacking);
			if (disabledShieldTime > 0 && attacking instanceof PlayerEntity) {
				PlayerEntity player = ((PlayerEntity) attacking);
				if (player.isHandActive() && player.getActiveItemStack().isShield(player)) {
					player.getCooldownTracker().setCooldown(Items.SHIELD, disabledShieldTime);
					player.resetActiveHand();
					world.setEntityState(player, (byte) 9);
				}
			}
		}
	}

	@Override
	public void tick() {
		super.tick();
		updateAnimations();

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

		if (ticksExisted % 50 > 10) {
			this.clawStrikeFlag = true;
		} else {
			this.clawStrikeFlag = false;
		}

		int attackRoll = ticksExisted + rand.nextInt(5);
		if (this.deathTicks <= 0) {
			if (attackRoll % 100 * diffMult == 0) {
				this.beyondFlames(getAttackTarget());
			}
			if (attackRoll % 120 == 0) {
				this.massBlind(getAttackTarget());
			}
			if (attackRoll % 170 == 0) {
				this.summonGoats(3);
			}
			if (this.getAttackTarget() != null) {
				if (this.teleportTime++ >= rand.nextInt(20000) && this.teleportToEntity(this)) {
					this.teleportTime = 0;
				}
			}

			LivingEntity target = getAttackTarget();
			if (target == null)
				return;
			double distFromTarget = getDistanceSq(target);

			getLookController().setLookPositionWithEntity(target, getHorizontalFaceSpeed(), getVerticalFaceSpeed());

			boolean isClose = distFromTarget < 40;

			if (getNavigator().noPath())
				getNavigator().tryMoveToEntityLiving(target, 1.2);

			if (isClose) {
				rotationYaw = (float) MathUtils.getAngle(EntityUzouthrhix.this, target) + 90f;
			}

			if (noActiveAnimation()) {
				if (distFromTarget > 50 && distFromTarget < 89) {
					AnimationPacket.send(EntityUzouthrhix.this, LIGHTNING_ANIMATION);

				} else if (distFromTarget > 90) {
					// AnimationPacket.send(EntityUzouthrhix.this, CHARGE_ANIMATION);
				} else if (isClose && MathHelper.degreesDifferenceAbs(
						(float) MathUtils.getAngle(EntityUzouthrhix.this, target) + 90, rotationYaw) < 30) {
					AnimationPacket.send(EntityUzouthrhix.this, BITE_ANIMATION);
				}
			}

			float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.world.addParticle(ParticleTypes.ASH, this.getPosX() + (double) f, this.getPosY() + 2.0D + (double) f1,
					this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
			this.world.addParticle(ParticleTypes.ASH, this.getPosX() + (double) f, this.getPosY() + 2.0D + (double) f1,
					this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	protected void updateAITasks() {
		/*
		 * if (this.rand.nextFloat() * 30.0F < (10 - 0.4F) * 2.0F) {
		 * this.teleportRandomly(); }
		 */
		super.updateAITasks();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}

	@Override
	public void addTrackingPlayer(ServerPlayerEntity player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void removeTrackingPlayer(ServerPlayerEntity player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundHandler.ENTITY_DARK_YOUNG_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.ENTITY_DARK_YOUNG_HURT;

	}

	@Override
	protected SoundEvent getDeathSound() {
		return null;

	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}

	@Override
	public void heal(float amount) {
		super.heal(amount);

	}

	// Death
	/**
	 * handles entity death timer, experience orb and particle creation
	 */
	@Override
	protected void onDeathUpdate() {
		++this.deathTicks;
		float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
		float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
		float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
		if (this.deathTicks == 1) {
			if (world.isRemote) {
				world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), SoundHandler.ENTITY_DARK_YOUNG_DEATH,
						SoundCategory.HOSTILE, 0.5f, 0.9f, false);
			}
		}
		if (this.deathTicks >= 100 && this.deathTicks <= 150) {

			this.world.addParticle(ParticleTypes.SOUL_FIRE_FLAME, this.getPosX() + (double) f,
					this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);

			if (this.deathTicks >= 70) {
				this.world.addParticle(ParticleTypes.SMOKE, this.getPosX() + (double) f,
						this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks >= 100) {
				this.world.addParticle(ParticleTypes.SOUL, this.getPosX() + (double) f,
						this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks >= 130) {
				this.world.addParticle(ParticleTypes.DRIPPING_OBSIDIAN_TEAR, this.getPosX() + (double) f,
						this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks > 130) {
				this.world.addParticle(ParticleTypes.FLASH, this.getPosX() + (double) f,
						this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks >= 150) {
				this.world.addParticle(ParticleTypes.EXPLOSION, this.getPosX() + (double) f,
						this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
			}
		}

		boolean flag = this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT);

		if (!this.world.isRemote && deathTicks % (15 + rand.nextInt(4)) == 0) {
			ItemEntity outputItem = new ItemEntity(world, this.getPosX(), this.getPosY(), this.getPosZ(),
					new ItemStack(ItemInit.vitreous_humor.get()));
			world.addEntity(outputItem);
		}

		if (this.deathTicks == 150) {
			if (world.isRemote) {
				world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_GENERIC_EXPLODE,
						SoundCategory.HOSTILE, 3f, 0.2f, false);
			}
		}

		if (this.deathTicks == 150 && !this.world.isRemote) {
			if (flag) {
				this.dropExperience(MathHelper.floor((float) 500 * 0.2F));
			}
			this.remove();
		}

	}

	@Override
	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropSpecialItems(source, looting, recentlyHitIn);
		ItemEntity itementity = this.entityDropItem(ItemInit.everwatchful_pendant.get());
		if (itementity != null) {
			itementity.setNoDespawn();
		}

	}

	@Override
	public boolean isImmuneToFire() {
		return true;
	}

	private void dropExperience(int xp) {
		while (xp > 0) {
			int i = ExperienceOrbEntity.getXPSplit(xp);
			xp -= i;
			this.world
					.addEntity(new ExperienceOrbEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ(), i));
		}

	}

	public boolean isArmored() {
		return this.getHealth() < this.getMaxHealth() / 2.0F && this.getHealth() >= this.getMaxHealth() / 4.0F;
	}

	public boolean isVulnerable() {
		return this.getHealth() < this.getMaxHealth() / 4.0F;
	}

	public boolean isJumpingOutOfWater() {
		return !isInWater() && !beached;
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize size) {
		return size.height * (beached ? 1f : 0.6f);
	}

	@Override
	public void writeSpawnData(PacketBuffer buffer) {
		buffer.writeLong(source.toLong());

	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void readSpawnData(PacketBuffer additionalData) {
		source = BlockPos.fromLong(additionalData.readLong());
		Minecraft.getInstance().getSoundHandler().play(new HasturMusic(this));

	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public void writeAdditional(CompoundNBT cmp) {
		super.writeAdditional(cmp);
		cmp.putInt(TAG_SOURCE_X, source.getX());
		cmp.putInt(TAG_SOURCE_Y, source.getY());
		cmp.putInt(TAG_SOURCE_Z, source.getZ());
	}

	@Override
	public void readAdditional(CompoundNBT cmp) {
		super.readAdditional(cmp);
		int x = cmp.getInt(TAG_SOURCE_X);
		int y = cmp.getInt(TAG_SOURCE_Y);
		int z = cmp.getInt(TAG_SOURCE_Z);
		source = new BlockPos(x, y, z);
	}

	public BlockPos getSource() {
		return source;
	}

	@OnlyIn(Dist.CLIENT)
	private static class HasturMusic extends TickableSound {
		private final EntityUzouthrhix hastur;

		public HasturMusic(EntityUzouthrhix hastur) {
			super(SoundHandler.ENTITY_DARK_YOUNG_MUSIC, SoundCategory.RECORDS);

			this.hastur = hastur;
			this.x = hastur.getSource().getX();
			this.y = hastur.getSource().getY();
			this.z = hastur.getSource().getZ();
			this.repeat = true;
		}

		@Override
		public float getVolume() {
			return super.getVolume();
		}

		@Override
		public void tick() {
			if (!hastur.isAlive()) {
				this.finishPlaying();
			}
		}
	}

//Animation
	@Override
	public int getAnimationTick() {
		return animationTick;
	}

	@Override
	public void setAnimationTick(int tick) {
		animationTick = tick;
	}

	@Override
	public Animation getAnimation() {
		return animation;
	}

	@Override
	public void setAnimation(Animation animation) {
		if (animation == null)
			animation = NO_ANIMATION;
		setAnimationTick(0);
		this.animation = animation;
	}

	@Override
	public Animation[] getAnimations() {
		return new Animation[] { BITE_ANIMATION, LIGHTNING_ANIMATION, CHARGE_ANIMATION };
	}

	// Attack types
	public void summonGoats(int numTent) {
		EntityBlackGoat[] tentArray = new EntityBlackGoat[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityBlackGoat(EntityInit.black_goat.get(), world);
			float xMod = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.rand.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPosition(this.getPosX() + 0.5 + xMod, this.getPosY() + 1.5 + yMod,
					this.getPosZ() + 0.5 + zMod);
			if (!world.isRemote) {
				world.addEntity(tentArray[i]);
			}
		}
	}

	private void shock(Entity target) {
		if (target != null) {
			playSound(SoundHandler.ENTITY_DARK_YOUNG_HIT, .25F, 1f);
			this.setMotion(0, 0, 0);
			Vector3 endVec = Vector3.fromEntityCenter(target);
			Vector3d speedVec = new Vector3d(endVec.x, endVec.y, endVec.z);
			HutosLibPacketHandler.sendLightningSpawn(this.getPositionVec().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					(RegistryKey<World>) this.world.getDimensionKey(), ParticleColor.BLACK, 2, 10, 9, 0.2f);
			HutosLibPacketHandler.sendLightningSpawn(this.getPositionVec().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					(RegistryKey<World>) this.world.getDimensionKey(), ParticleColor.WHITE, 2, 10, 9, 0.2f);
			HutosLibPacketHandler.sendLightningSpawn(this.getPositionVec().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					(RegistryKey<World>) this.world.getDimensionKey(), ParticleColor.PURPLE, 2, 10, 9, 0.2f);
			if (target.getPositionVec().distanceTo(this.getPositionVec()) < rand.nextInt(27)) {
				target.attackEntityFrom(DamageSource.LIGHTNING_BOLT, 4f);
			}
		}
	}

	private void beyondFlames(Entity target) {
		if (target != null) {
			playSound(SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, .25F, 1f);
			setFlame(target.getPosition().add(2, 0, 0));
			setFlame(target.getPosition().add(-2, 0, 0));
			setFlame(target.getPosition().add(0, 0, 2));
			setFlame(target.getPosition().add(0, 0, -2));
			setFlame(target.getPosition().add(-1, 0, 1));
			setFlame(target.getPosition().add(1, 0, -1));
			setFlame(target.getPosition().add(-1, 0, -1));
			setFlame(target.getPosition().add(1, 0, 1));
		}
	}

	@SuppressWarnings("deprecation")
	public void setFlame(BlockPos pos) {
		if (world.getBlockState(pos).isAir(world, pos)) {
			world.setBlockState(pos, BlockInit.beyond_flames.get().getDefaultState());
		}
	}

	@SuppressWarnings("unused")
	private void massBlind(Entity target) {
		if (target != null) {
			if (target instanceof PlayerEntity) {
				PlayerEntity player = (PlayerEntity) target;
				// player.addPotionEffect(new EffectInstance(Effects.BLINDNESS, 80, 255));
			}
		}
	}

	public void repel(World world, AxisAlignedBB effectBounds, double x, double y, double z) {
		List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(this, effectBounds);
		for (Entity ent : list) {
			if (!(ent instanceof EntitySummonedBeast)) {
				Vector3d p = new Vector3d(x, y, z);
				Vector3d t = new Vector3d(ent.getPosX(), ent.getPosY(), ent.getPosZ());
				double distance = p.distanceTo(t) + 0.1D;
				Vector3d r = new Vector3d(t.x - p.x, t.y - p.y, t.z - p.z);
				ent.setMotion(r.x * 2 / distance, r.y * 2 / distance, r.z * 2 / distance);
				for (int countparticles = 0; countparticles <= 10; ++countparticles) {
					world.addParticle(ParticleTypes.SMOKE,
							ent.getPosX() + (world.rand.nextDouble() - 0.5D) * (double) ent.getWidth(),
							ent.getPosY() + world.rand.nextDouble() * (double) ent.getHeight()
									- (double) ent.getYOffset() - 0.5,
							ent.getPosZ() + (world.rand.nextDouble() - 0.5D) * (double) ent.getWidth(), 0.0D, 0.0D,
							0.0D);
					playSound(SoundHandler.ENTITY_DARK_YOUNG_HIT, .25F, 1f);

				}
			}
		}
	}

	/**
	 * Teleport to a random nearby position
	 */
	protected boolean teleportRandomly() {
		if (!this.world.isRemote() && this.isAlive()) {
			double d0 = this.getPosX() + (this.rand.nextDouble() - 0.5D) * 16.0D;
			double d1 = this.getPosY() + (double) (this.rand.nextInt(64) - 32);
			double d2 = this.getPosZ() + (this.rand.nextDouble() - 0.5D) * 16.0D;
			return this.teleportTo(d0, d1, d2);
		} else {
			return false;
		}
	}

	/**
	 * Teleport to another entity
	 */
	private boolean teleportToEntity(Entity target) {
		Vector3d vector3d = new Vector3d(this.getPosX() - target.getPosX(),
				this.getPosYHeight(0.5D) - target.getPosYEye(), this.getPosZ() - target.getPosZ());
		vector3d = vector3d.normalize();
		double d1 = this.getPosX() + (this.rand.nextDouble() - 0.5D) * 8.0D - vector3d.x * 8.0D;
		double d2 = this.getPosY() + (double) (this.rand.nextInt(16) - 8) - vector3d.y * 8.0D;
		double d3 = this.getPosZ() + (this.rand.nextDouble() - 0.5D) * 8.0D - vector3d.z * 8.0D;
		return this.teleportTo(d1, d2, d3);
	}

	/**
	 * Teleport the boss
	 */
	private boolean teleportTo(double x, double y, double z) {
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(x, y, z);
		while (blockpos$mutable.getY() > 0
				&& !this.world.getBlockState(blockpos$mutable).getMaterial().blocksMovement()) {
			blockpos$mutable.move(Direction.DOWN);
		}
		BlockState blockstate = this.world.getBlockState(blockpos$mutable);
		boolean flag = blockstate.getMaterial().blocksMovement();
		boolean flag1 = blockstate.getFluidState().isTagged(FluidTags.WATER);
		if (flag && !flag1) {
			EnderTeleportEvent event = new EnderTeleportEvent(this, x, y, z, 0);
			if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
				return false;
			boolean flag2 = this.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
			if (flag2 && !this.isSilent()) {
				this.world.playSound((PlayerEntity) null, this.prevPosX, this.prevPosY, this.prevPosZ,
						SoundHandler.ENTITY_DARK_YOUNG_TELEPORT, this.getSoundCategory(), 0.5f, 0.5f);
				this.playSound(SoundHandler.ENTITY_DARK_YOUNG_TELEPORT, 0.5f, 0.5f);
			}
			return flag2;
		} else {
			return false;
		}
	}

	// Bite Goal
	private class AttackGoal extends Goal {
		public AttackGoal() {
			setMutexFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
		}

		@Override
		public boolean shouldExecute() {
			return !canPassengerSteer() && getAttackTarget() != null;
		}

		@Override
		public void tick() {
			LivingEntity target = getAttackTarget();
			if (target == null)
				return;
			double distFromTarget = getDistanceSq(target);

			getLookController().setLookPositionWithEntity(target, getHorizontalFaceSpeed(), getVerticalFaceSpeed());

			boolean isClose = distFromTarget < 40;

			if (getNavigator().noPath())
				getNavigator().tryMoveToEntityLiving(target, 1.2);

			if (isClose)
				rotationYaw = (float) MathUtils.getAngle(EntityUzouthrhix.this, target) + 90f;

			if (noActiveAnimation()) {
				if (isClose && MathHelper.degreesDifferenceAbs(
						(float) MathUtils.getAngle(EntityUzouthrhix.this, target) + 90, rotationYaw) < 30)
					AnimationPacket.send(EntityUzouthrhix.this, BITE_ANIMATION);
			}
		}
	}

	// Move Goal
	private class MoveTowardsTargetGoal extends Goal {
		private final CreatureEntity creature;
		private LivingEntity targetEntity;
		private double movePosX;
		private double movePosY;
		private double movePosZ;
		private final double speed;
		private final float maxTargetDistance;

		public MoveTowardsTargetGoal(CreatureEntity creature, double speedIn, float targetMaxDistance) {
			this.creature = creature;
			this.speed = speedIn;
			this.maxTargetDistance = targetMaxDistance;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		@Override
		public void tick() {
			LivingEntity target = getAttackTarget();
			if (target == null)
				return;
			double distFromTarget = getDistanceSq(target);

			getLookController().setLookPositionWithEntity(target, getHorizontalFaceSpeed(), getVerticalFaceSpeed());

			boolean isClose = distFromTarget < 40;

			if (getNavigator().noPath())
				getNavigator().tryMoveToEntityLiving(target, 1.2);

			if (isClose)
				rotationYaw = (float) MathUtils.getAngle(EntityUzouthrhix.this, target) + 90f;

			if (noActiveAnimation()) {
				if (distFromTarget > 120) {
					AnimationPacket.send(EntityUzouthrhix.this, CHARGE_ANIMATION);
				}
			}
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			this.targetEntity = this.creature.getAttackTarget();
			if (this.targetEntity == null) {
				return false;
			} else if (this.targetEntity
					.getDistanceSq(this.creature) > (double) (this.maxTargetDistance * this.maxTargetDistance)) {
				return false;
			} else {
				Vector3d vector3d = RandomPositionGenerator.findRandomTargetBlockTowards(this.creature, 16, 7,
						this.targetEntity.getPositionVec());
				if (vector3d == null) {
					return false;

				} else {
					this.movePosX = vector3d.x;
					this.movePosY = vector3d.y;
					this.movePosZ = vector3d.z;
					return true;
				}
			}
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			return !this.creature.getNavigator().noPath() && this.targetEntity.isAlive() && this.targetEntity
					.getDistanceSq(this.creature) < (double) (this.maxTargetDistance * this.maxTargetDistance);
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		public void resetTask() {
			this.targetEntity = null;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			this.creature.getNavigator().tryMoveToXYZ(this.movePosX, this.movePosY, this.movePosZ, this.speed);
		}
	}

}