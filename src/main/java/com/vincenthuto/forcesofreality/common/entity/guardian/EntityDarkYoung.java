package com.vincenthuto.forcesofreality.common.entity.guardian;

import java.util.List;

import com.vincenthuto.forcesofreality.common.entity.projectile.EntityWolfShot;
import com.vincenthuto.forcesofreality.common.entity.summon.EntityBlackGoat;
import com.vincenthuto.forcesofreality.common.entity.summon.EntitySummonedBeast;
import com.vincenthuto.forcesofreality.registry.BlockInit;
import com.vincenthuto.forcesofreality.registry.EntityInit;
import com.vincenthuto.forcesofreality.registry.ItemInit;
import com.vincenthuto.forcesofreality.registry.SoundInit;
import com.vincenthuto.hutoslib.client.particle.util.ParticleColor;
import com.vincenthuto.hutoslib.common.network.HLPacketHandler;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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

public class EntityDarkYoung extends Monster implements IEntityAdditionalSpawnData {

	@OnlyIn(Dist.CLIENT)
	private static class HasturMusic extends AbstractTickableSoundInstance {
		private final EntityDarkYoung hastur;

		public HasturMusic(EntityDarkYoung hastur) {
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

	private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(),
			BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

	public EntityDarkYoung(EntityType<? extends EntityDarkYoung> type, Level worldIn) {
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
		if (this.attackTimer > 0) {
			--this.attackTimer;
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
			this.level().addFreshEntity(new ExperienceOrb(this.level(), this.getX(), this.getY(), this.getZ(), i));
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
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
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

	// Attack types

	public boolean isVulnerable() {
		return this.getHealth() < this.getMaxHealth() / 4.0F;
	}

	@SuppressWarnings("unused")
	private void massBlind(Entity target) {
		if (target != null) {
			if (target instanceof Player) {
				Player player = (Player) target;
				player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 80, 255));
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
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
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
		if (level().getBlockState(pos).isAir()) {
			level().setBlockAndUpdate(pos, BlockInit.beyond_flames.get().defaultBlockState());
		}
	}

	private void shock(Entity target) {
		if (target != null) {
			playSound(SoundInit.ENTITY_DARK_YOUNG_HIT.get(), .25F, 1f);
			this.setDeltaMovement(0, 0, 0);
			Vector3 endVec = Vector3.fromEntityCenter(target);

			Vec3 speedVec = new Vec3(endVec.x, endVec.y, endVec.z);
			HLPacketHandler.sendLightningSpawn(this.position().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					this.level().dimension(), ParticleColor.BLACK, 2, 10, 9, 0.2f);
			HLPacketHandler.sendLightningSpawn(this.position().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					this.level().dimension(), ParticleColor.WHITE, 2, 10, 9, 0.2f);
			HLPacketHandler.sendLightningSpawn(this.position().add(0.5, 0.5, 0.5), speedVec, 64.0f,
					this.level().dimension(), ParticleColor.PURPLE, 2, 10, 9, 0.2f);
			if (target.position().distanceTo(this.position()) < random.nextInt(7)) {
				target.hurt(target.damageSources().lightningBolt(), 4f);
			}
		}
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

	public void summonGoats(int numTent) {
		EntityBlackGoat[] tentArray = new EntityBlackGoat[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityBlackGoat(EntityInit.black_goat.get(), level());
			float xMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 1.5 + yMod, this.getZ() + 0.5 + zMod);
			if (!level().isClientSide) {
				level().addFreshEntity(tentArray[i]);
			}
		}
	}

	/**
	 * Teleport the boss
	 */
	private boolean teleport(double x, double y, double z) {
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos(x, y, z);
		//TODO update with new enderman code
//		while (blockpos$mutable.getY() > 0
//				&& !this.level().getBlockState(blockpos$mutable).getMaterial().blocksMotion()) {
//			blockpos$mutable.move(Direction.DOWN);
//		}
//		BlockState blockstate = this.level().getBlockState(blockpos$mutable);
//		boolean flag = blockstate.getMaterial().blocksMotion();
//		boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
//		if (flag && !flag1) {
//			net.minecraftforge.event.entity.EntityTeleportEvent.EnderEntity event = net.minecraftforge.event.ForgeEventFactory
//					.onEnderTeleport(this, x, y, z);
//			if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
//				return false;
//			boolean flag2 = this.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
//			if (flag2 && !this.isSilent()) {
//				this.level().playSound((Player) null, this.xo, this.yo, this.zo, SoundInit.ENTITY_DARK_YOUNG_TELEPORT.get(),
//						this.getSoundSource(), 0.5f, 0.5f);
//				this.playSound(SoundInit.ENTITY_DARK_YOUNG_TELEPORT.get(), 0.5f, 0.5f);
//			}
//			return flag2;
//		} else {
//			return false;
//		}
		return false;
	}

	/**
	 * Teleport to a random nearby position
	 */
	protected boolean teleportRandomly() {
		if (!this.level().isClientSide() && this.isAlive()) {
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

	@SuppressWarnings("unused")
	@Override
	public void tick() {
		super.tick();
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
			if (attackRoll % 50 * diffMult == 0) {
				this.shock(getTarget());
			}
			if (attackRoll % 100 * diffMult == 0) {
				this.beyondFlames(getTarget());
			}
			if (attackRoll % 120 == 0) {
				this.massBlind(getTarget());
			}
			if (attackRoll % 170 == 0) {
				this.summonGoats(3);
			}
			// Random Teleportation
			if (this.getTarget() != null) {
				if (this.teleportTime++ >= random.nextInt(1000) && this.teleportToEntity(this)) {
					this.teleportTime = 0;
				}
			}

			// Removed Starstrikes to use on the seraphim, still has the one missle spawn
			// though
			float f = (this.random.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;
			this.level().addParticle(ParticleTypes.ASH, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D,
					0.0D, 0.0D);
			this.level().addParticle(ParticleTypes.ASH, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D,
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
			if (level().isClientSide) {
				level().playLocalSound(this.getX(), this.getY(), this.getZ(), SoundInit.ENTITY_DARK_YOUNG_DEATH.get(),
						SoundSource.HOSTILE, 0.5f, 0.9f, false);
			}
		}
		if (this.deathTicks >= 100 && this.deathTicks <= 200) {

			this.level().addParticle(ParticleTypes.SOUL_FIRE_FLAME, this.getX() + f, this.getY() + 2.0D + f1,
					this.getZ() + f2, 0.0D, 0.0D, 0.0D);

			if (this.deathTicks >= 70) {
				this.level().addParticle(ParticleTypes.SMOKE, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2,
						0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks >= 100) {
				this.level().addParticle(ParticleTypes.SOUL, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2,
						0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks >= 130) {
				this.level().addParticle(ParticleTypes.DRIPPING_OBSIDIAN_TEAR, this.getX() + f, this.getY() + 2.0D + f1,
						this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks > 180) {
				this.level().addParticle(ParticleTypes.FLASH, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2,
						0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks >= 200) {
				this.level().addParticle(ParticleTypes.EXPLOSION, this.getX() + f, this.getY() + 2.0D + f1,
						this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}
		}

		boolean flag = this.level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT);

		if (!this.level().isClientSide && deathTicks % (15 + random.nextInt(4)) == 0) {
			ItemEntity outputItem = new ItemEntity(level(), this.getX(), this.getY(), this.getZ(),
					new ItemStack(ItemInit.vitreous_humor.get()));
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

}