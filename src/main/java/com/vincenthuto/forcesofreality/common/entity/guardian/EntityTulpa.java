package com.vincenthuto.forcesofreality.common.entity.guardian;

import com.vincenthuto.forcesofreality.common.entity.passive.EntityDenizen;
import com.vincenthuto.forcesofreality.common.entity.projectile.EntityTrackingOrb;
import com.vincenthuto.forcesofreality.common.entity.summon.EntityEldritchGrip;
import com.vincenthuto.forcesofreality.common.entity.summon.EntityTentacle;
import com.vincenthuto.forcesofreality.registry.EntityInit;
import com.vincenthuto.forcesofreality.registry.ItemInit;
import com.vincenthuto.forcesofreality.registry.SoundInit;

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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

public class EntityTulpa extends Monster implements IEntityAdditionalSpawnData {

	@OnlyIn(Dist.CLIENT)
	private static class HasturMusic extends AbstractTickableSoundInstance {
		private final EntityTulpa hastur;

		public HasturMusic(EntityTulpa hastur) {
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

	public int deathTicks;

	private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(),
			BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

	public EntityTulpa(EntityType<? extends EntityTulpa> type, Level worldIn) {
		super(type, worldIn);

	}

	@Override
	public void addAdditionalSaveData(CompoundTag cmp) {
		super.addAdditionalSaveData(cmp);
		cmp.putInt(TAG_SOURCE_X, source.getX());
		cmp.putInt(TAG_SOURCE_Y, source.getY());
		cmp.putInt(TAG_SOURCE_Z, source.getZ());
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

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
		this.getBossInfo().setProgress(this.getHealth() / this.getMaxHealth());

	}

	@Override
	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		ItemEntity itementity = this.spawnAtLocation(ItemInit.yellow_sign.get());
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
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.12));
		this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 3d, 5));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1d, true));
		this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.2f));
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
			}
			if (this.onGround()) {
				if (attackRoll % 100 * diffMult == 0) {
					this.summonEldritchGrip(random.nextInt(1) + 3);
				}
			}

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
		if (this.deathTicks >= 100 && this.deathTicks <= 200) {
			float f = (this.random.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;
			this.level().addParticle(ParticleTypes.ASH, this.getX() + f, this.getY() + 2.0D + f1,
					this.getZ() + f2, 0.0D, 0.0D, 0.0D);

			if (this.deathTicks >= 100) {
				this.level().addParticle(ParticleTypes.FLASH, this.getX() + f, this.getY() + 2.0D + f1,
						this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}
		}

		boolean flag = this.level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT);

		if (!this.level().isClientSide && deathTicks % (15 + random.nextInt(4)) == 0) {
			ItemEntity outputItem = new ItemEntity(level(), this.getX(), this.getY(), this.getZ(),
					new ItemStack(ItemInit.unsettling_fabric.get()));
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