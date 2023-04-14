package com.vincenthuto.forcesofreality.entity.lord;

import java.util.List;

import com.vincenthuto.forcesofreality.entity.projectile.EntityWolfShot;
import com.vincenthuto.forcesofreality.entity.summon.EntitySummonedBeast;
import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.init.SoundInit;
import com.vincenthuto.hutoslib.client.particle.factory.EmberParticleFactory;
import com.vincenthuto.hutoslib.client.particle.util.ParticleColor;
import com.vincenthuto.hutoslib.common.network.HLPacketHandler;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
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

public class EntityMechan extends Monster implements IEntityAdditionalSpawnData {

	@OnlyIn(Dist.CLIENT)
	private static class HasturMusic extends AbstractTickableSoundInstance {
		private final EntityMechan hastur;

		public HasturMusic(EntityMechan hastur) {
			super(SoundInit.ENTITY_HASTUR_MUSIC.get(), SoundSource.RECORDS, RandomSource.create());

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
	protected static final EntityDataAccessor<Byte> PLAYER_CREATED = SynchedEntityData.defineId(EntityMechan.class,
			EntityDataSerializers.BYTE);
	private static final String TAG_SOURCE_X = "sourceX";
	private static final String TAG_SOURCE_Y = "sourceY";
	private static final String TAG_SOURCE_Z = "sourcesZ";
	public static final EntityDataAccessor<Integer> RED = SynchedEntityData.defineId(EntityMechan.class,
			EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> GREEN = SynchedEntityData.defineId(EntityMechan.class,
			EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> BLUE = SynchedEntityData.defineId(EntityMechan.class,
			EntityDataSerializers.INT);
	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).add(Attributes.MOVEMENT_SPEED, 0.3D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1.15D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	private BlockPos source = BlockPos.ZERO;
	private int attackTimer;

	public int deathTicks;

	private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(),
			BossEvent.BossBarColor.YELLOW, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

	public EntityMechan(EntityType<? extends EntityMechan> type, Level worldIn) {
		super(type, worldIn);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag cmp) {
		super.addAdditionalSaveData(cmp);
		cmp.putInt(TAG_SOURCE_X, source.getX());
		cmp.putInt(TAG_SOURCE_Y, source.getY());
		cmp.putInt(TAG_SOURCE_Z, source.getZ());
		cmp.putInt("red", entityData.get(RED));
		cmp.putInt("green", entityData.get(GREEN));
		cmp.putInt("blue", entityData.get(BLUE));
	}

	@Override
	public void aiStep() {
		super.aiStep();
		if (this.attackTimer > 0) {
			--this.attackTimer;
		}

	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(PLAYER_CREATED, (byte) 0);
		this.entityData.define(RED, 255);
		this.entityData.define(GREEN, 180);
		this.entityData.define(BLUE, 0);
	}

	@Override
	public boolean doHurtTarget(Entity entityIn) {
		this.attackTimer = 10;
		return super.doHurtTarget(entityIn);
	}

	@Override
	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		ItemEntity itementity = this.spawnAtLocation(ItemInit.integral_cog.get());
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
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.WOLF_AMBIENT;
	}

	@OnlyIn(Dist.CLIENT)
	public int getAttackTimer() {
		return this.attackTimer;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.WOLF_DEATH;

	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.WOLF_HURT;

	}

	public ParticleColor getParticleColor() {
		return new ParticleColor(entityData.get(RED), entityData.get(GREEN), entityData.get(BLUE));
	}

	public ParticleColor.IntWrapper getParticleColorWrapper() {
		return new ParticleColor.IntWrapper(entityData.get(RED), entityData.get(GREEN), entityData.get(BLUE));
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
		repel(level, new AABB(this.position().add(-8, -8, -8), this.position().add(8, 8, 8)), this.position().x() + 0.5,
				this.position().y(), this.position().z() + 0.5);
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

	// Attack types

	@Override
	public boolean hurt(DamageSource source, float amount) {
		float f = (this.random.nextFloat() - 0.5F) * 8.0F;
		float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
		float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;
		this.level.addParticle(ParticleTypes.SOUL, this.getX() + f, this.getY() + 2.0D + f1,
				this.getZ() + f2, 0.0D, 0.0D, 0.0D);
		return super.hurt(source, amount);
	}

	public boolean isArmored() {
		return this.getHealth() < this.getMaxHealth() / 2.0F && this.getHealth() >= this.getMaxHealth() / 4.0F;
	}

	// Player Creation
	public boolean isPlayerCreated() {
		return (this.entityData.get(PLAYER_CREATED) & 1) != 0;
	}

	public boolean isVulnerable() {
		return this.getHealth() < this.getMaxHealth() / 4.0F;
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		entityData.set(RED, compound.getInt("red"));
		entityData.set(GREEN, compound.getInt("green"));
		entityData.set(BLUE, compound.getInt("blue"));
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
							ent.getY() + world.random.nextDouble() * ent.getBbHeight()
									- ent.getMyRidingOffset() - 0.5,
							ent.getZ() + (world.random.nextDouble() - 0.5D) * ent.getBbWidth(), 0.0D, 0.0D,
							0.0D);
					ent.playSound(SoundEvents.WOLF_HOWL, .15F, 1f + (float) Math.random() * 0.2F);

				}
			}
		}
	}

	public void setColor(ParticleColor.IntWrapper colors) {
		entityData.set(RED, colors.r);
		entityData.set(GREEN, colors.g);
		entityData.set(BLUE, colors.b);
	}

	public void setPlayerCreated(boolean playerCreated) {
		byte b0 = this.entityData.get(PLAYER_CREATED);
		if (playerCreated) {
			this.entityData.set(PLAYER_CREATED, (byte) (b0 | 1));
		} else {
			this.entityData.set(PLAYER_CREATED, (byte) (b0 & -2));
		}

	}

	@SuppressWarnings("unused")
	private void shock(Entity target) {
		playSound(SoundEvents.WOLF_HOWL, .25F, 1f);
		this.setDeltaMovement(0, 0, 0);
		Vector3 startVec = Vector3.fromEntityCenter(this);
		Vector3 endVec = Vector3.fromEntityCenter(target);
		Vec3 speedVec = new Vec3(endVec.x, endVec.y, endVec.z);
		HLPacketHandler.sendLightningSpawn(this.position().add(0.5, 0.5, 0.5), speedVec, 64.0f,
				this.level.dimension(), ParticleColor.YELLOW, 2, 10, 9, 0.2f);

		target.hurt(target.damageSources().lightningBolt(), 4f);
	}

	@SuppressWarnings("unused")
	private void spawnWolfShot() {
		EntityWolfShot missile = new EntityWolfShot(this, true);
		missile.setPos(this.getX() + (Math.random() - 0.5 * 0.1), this.getY() + (Math.random() - 0.5 * 0.1),
				this.getZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			playSound(SoundEvents.WOLF_GROWL, 0.6F, 0.8F + (float) Math.random() * 0.2F);
			level.addFreshEntity(missile);
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

	public void summonHounds(int numTent) {
		EntitySummonedBeast[] tentArray = new EntitySummonedBeast[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntitySummonedBeast(EntityInit.summoned_beast.get(), level);
			tentArray[i].setBeastType(random.nextInt(4));
			float xMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 1.5 + yMod, this.getZ() + 0.5 + zMod);
			if (!level.isClientSide) {
				level.addFreshEntity(tentArray[i]);
			}
		}
	}

	@Override
	public void tick() {
		super.tick();

		float diffMult = 1f;
		float particleMod = (level.random.nextFloat() - level.random.nextFloat()) * 0.3f;
		if (level.isClientSide) {
			level.addParticle(ParticleTypes.SMOKE, getX() + particleMod, getY() + 1.87f + particleMod,
					getZ() + particleMod, 0, 0.01f, 0);
			level.addParticle(EmberParticleFactory.createData(getParticleColor(), 1, 0.25f, 135), getX() + particleMod,
					getY() + 1.87f, getZ() + particleMod, 0, level.random.nextFloat() * 0.01f, 0);
			level.addParticle(EmberParticleFactory.createData(new ParticleColor(200, 200, 0), 1, 0.25f, 135), getX(),
					getY() + 1.87f, getZ(), 0, level.random.nextFloat() * 0.01f, 0);

		}
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
				if (getTarget() != null) {
					this.shock(getTarget());
				}
			} else if (attackRoll % 130 * diffMult == 0) {
				// this.greatHowl();
			}
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
			this.level.addParticle(ParticleTypes.ASH, this.getX() + f, this.getY() + 2.0D + f1,
					this.getZ() + f2, 0.0D, 0.0D, 0.0D);

			if (this.deathTicks >= 100) {
				this.level.addParticle(DustParticleOptions.REDSTONE, this.getX() + f,
						this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}
			if (this.deathTicks >= 150) {
				this.level.addParticle(ParticleTypes.FLASH, this.getX() + f, this.getY() + 2.0D + f1,
						this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}
		}

		boolean flag = this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT);

		if (!this.level.isClientSide && deathTicks % (15 + random.nextInt(4)) == 0) {
			ItemEntity outputItem = new ItemEntity(level, this.getX(), this.getY(), this.getZ(),
					new ItemStack(ItemInit.discared_gear.get()));
			level.addFreshEntity(outputItem);
		}

		if (this.deathTicks == 200) {
			if (level.isClientSide) {
				level.playLocalSound(this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_EXPLODE,
						SoundSource.HOSTILE, 3f, 0.2f, false);
			}
		}

		if (this.deathTicks == 200 && !this.level.isClientSide) {
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