package com.vincenthuto.forcesofreality.entity.lord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vincenthuto.forcesofreality.entity.projectile.EntityHolyFlare;
import com.vincenthuto.forcesofreality.entity.projectile.EntityJudgement;
import com.vincenthuto.forcesofreality.entity.projectile.EntityStarStrike;
import com.vincenthuto.forcesofreality.entity.summon.EntityThrone;
import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.init.SoundInit;
import com.vincenthuto.hutoslib.client.particle.factory.GlowParticleFactory;
import com.vincenthuto.hutoslib.client.particle.util.HLParticleUtils;
import com.vincenthuto.hutoslib.client.particle.util.ParticleColor;
import com.vincenthuto.hutoslib.math.Vector3;

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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

public class EntityVeritas extends Monster implements IEntityAdditionalSpawnData {

	@OnlyIn(Dist.CLIENT)
	private static class HasturMusic extends AbstractTickableSoundInstance {
		private final EntityVeritas seraph;

		public HasturMusic(EntityVeritas seraph) {
			super(SoundInit.ENTITY_SERAPHIM_MUSIC.get(), SoundSource.RECORDS,RandomSource.create());

			this.seraph = seraph;
			this.x = seraph.getSource().getX();
			this.y = seraph.getSource().getY();
			this.z = seraph.getSource().getZ();
			this.looping = true; //
		}

		@Override
		public void tick() {
			if (!seraph.isAlive()) {
				this.stop();
			}
		}
	}
	private static final String TAG_SOURCE_X = "sourceX";
	private static final String TAG_SOURCE_Y = "sourceY";
	private static final String TAG_SOURCE_Z = "sourcesZ";

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).add(Attributes.MOVEMENT_SPEED, 0.15D)
				.add(Attributes.ATTACK_DAMAGE, 1.0D);
	}
	private BlockPos source = BlockPos.ZERO;
	public int deathTicks;
	private float heightOffset = 0.5F;
	private int heightOffsetUpdateTime;
	public float wingRotation;
	public float destPos;
	public float oFlapSpeed;
	public float oFlap;

	public float wingRotDelta = 1.0F;

	private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(),
			BossEvent.BossBarColor.WHITE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

	int timer = 200;

	public EntityVeritas(EntityType<? extends EntityVeritas> type, Level worldIn) {
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

		if (!this.onGround && this.getDeltaMovement().y < 0.0D) {
			// this.setMotion(this.getMotion().mul(1.0D, 0.6D, 1.0D));
		} else if (this.onGround && this.getDeltaMovement().y < 0.0D) {
			// this.setMotion(0, Math.sin(this.world.getGameTime()) * 0.15f, 0);

		}

		super.aiStep();
		this.oFlap = this.wingRotation;
		this.oFlapSpeed = this.destPos;
		this.destPos = (float) (this.destPos + (4) * 0.3D);
		this.destPos = Mth.clamp(this.destPos, 0.0F, 1.0F);
		if (!this.onGround) {
			this.wingRotDelta = 4.0F;
		} else {
			this.wingRotDelta = 1.0F;
		}
		this.wingRotDelta = (float) (this.wingRotDelta * 0.9D);
		Vec3 vector3d = this.getDeltaMovement();
		if (!this.onGround) {
			this.setDeltaMovement(vector3d.multiply(1.0D, 0.6D, 1.0D));
		} else {
			this.setDeltaMovement(vector3d.multiply(1.0D, 0.6D, 1.0D));

		}
		this.wingRotation += this.wingRotDelta * 0.1F;
		if (wingRotation > 1000) {
			wingRotation = 0;
		}
	}

	protected void applyEntityAI() {
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true));

	}

	@Override
	public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
		return false;
	}

	@Override
	protected void customServerAiStep() {
		--this.heightOffsetUpdateTime;
		if (this.heightOffsetUpdateTime <= 0) {
			this.heightOffsetUpdateTime = 100;
			this.heightOffset = 0.5F + (float) this.random.nextGaussian() * 3.0F;
		}

		LivingEntity livingentity = this.getTarget();
		if (livingentity != null && livingentity.getEyeY() > this.getEyeY() + this.heightOffset
				&& this.canAttack(livingentity)) {
			Vec3 vector3d = this.getDeltaMovement();
			this.setDeltaMovement(
					this.getDeltaMovement().add(0.0D, (0.3F - vector3d.y) * 0.3F, 0.0D));
			this.hasImpulse = true;
		}

		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());

	}

	@Override
	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		ItemEntity itementity = this.spawnAtLocation(ItemInit.crossed_keys.get());
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
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.ENTITY_SERAPHIM_AMBIENT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundInit.ENTITY_SERAPHIM_DEATH.get();

	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundInit.ENTITY_SERAPHIM_HURT.get();

	}

	@Override
	public ItemStack getOffhandItem() {
		return new ItemStack(ItemInit.destruction_orb.get(), 1);
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
		this.playSound(SoundEvents.HOGLIN_STEP, 0.15F, 1.0F);
	}

	// Attack types
	public void pullPlayer(AABB effectBounds, double x, double y, double z) {
		List<Entity> list = level.getEntitiesOfClass(Entity.class, effectBounds);
		for (Entity ent : list) {
			if (ent instanceof Player) {
				Vec3 p = new Vec3(x, y, z);
				Vec3 t = new Vec3(ent.getX(), ent.getY(), ent.getZ());
				double distance = p.distanceTo(t) + 0.1D;
				Vec3 r = new Vec3(t.x - p.x, t.y - p.y, t.z - p.z);
				ent.setDeltaMovement(-r.x / 10.2D / distance * 3.3, -r.y / 10.2D / distance * 3.3,
						-r.z / 10.2D / distance * 3.3);
				if (level.isClientSide) {
					for (int countparticles = 0; countparticles <= 1; ++countparticles) {
						ent.level.addParticle(ParticleTypes.PORTAL,
								ent.getX() + (level.random.nextDouble() - 0.5D) * ent.getBbWidth(),
								ent.getY() + level.random.nextDouble() * ent.getBbHeight()
										- ent.getMyRidingOffset() - 0.5,
								ent.getZ() + (level.random.nextDouble() - 0.5D) * ent.getBbWidth(), 0.0D, 0.0D,
								0.0D);
					}
				}
			}
		}
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

		this.applyEntityAI();
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.12));
		this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 3d, 5));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1d, true));
		this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.2f));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, AbstractVillager.class, 6.0F));

	}

	@SuppressWarnings("unused")
	private void spawnMissile() {
		EntityStarStrike missile = new EntityStarStrike(this, true);
		missile.setPos(this.getX() + (Math.random() - 0.5 * 0.1), this.getY() + 2.4 + (Math.random() - 0.5 * 0.1),
				this.getZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			playSound(SoundInit.ENTITY_HASTUR_HIT.get(), 0.6F, 0.8F + (float) Math.random() * 0.2F);

			level.addFreshEntity(missile);
		}
	}

	@SuppressWarnings("unused")
	private void spawnMissileVortex(int numMiss) {

		EntityStarStrike[] missArray = new EntityStarStrike[numMiss];
		for (int i = 0; i < numMiss; i++) {
			missArray[i] = new EntityStarStrike(this, true);

			float xMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			missArray[i].setPos(this.getX() + (Math.random() - 0.5 * 0.1) + 0.5 + xMod,
					this.getY() + 2.4 + (Math.random() - 0.5 * 0.1) + yMod,
					this.getZ() + (Math.random() - 0.5 * 0.1) + 0.5 + zMod);
			if (missArray[i].findTarget()) {
				playSound(SoundInit.ENTITY_HASTUR_HIT.get(), 0.6F, 0.8F + (float) Math.random() * 0.2F);
				level.addFreshEntity(missArray[i]);
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

	public void summonHolyFlare(int numTent) {
		EntityHolyFlare[] tentArray = new EntityHolyFlare[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityHolyFlare(EntityInit.holy_flare.get(), level);
			float xMod = (this.random.nextFloat() - 0.5F) * 16.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 2.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 16.0F;
			tentArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 1.5 + yMod, this.getZ() + 0.5 + zMod);
			if (!level.isClientSide) {
				level.addFreshEntity(tentArray[i]);

			}
		}
	}

	public void summonJudgement(int numMiss) {
		EntityJudgement[] missArray = new EntityJudgement[numMiss];
		for (int i = 0; i < numMiss; i++) {
			missArray[i] = new EntityJudgement(this, true);
			float xMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			missArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 1.5 + yMod, this.getZ() + 0.5 + zMod);
			if (!level.isClientSide) {
				playSound(SoundInit.ENTITY_HASTUR_HIT.get(), 0.6F, 0.8F + (float) Math.random() * 0.2F);

				level.addFreshEntity(missArray[i]);

			}
		}
	}

	public void summonThroneAid(int numTent) {
		EntityThrone[] tentArray = new EntityThrone[numTent];
		for (int i = 0; i < numTent; i++) {
		//	tentArray[i] = new EntityThrone(EntityInit.throne.get(), level);
			tentArray[i].setTentacleType(random.nextInt(4));
			float xMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 1.5 + yMod, this.getZ() + 0.5 + zMod);
			if (!level.isClientSide) {
				playSound(SoundInit.ENTITY_SERAPHIM_THRONE.get(), 0.6F, 0.8F + (float) Math.random() * 0.2F);
				level.addFreshEntity(tentArray[i]);

			}
		}
	}

	@SuppressWarnings("unused")
	@Override
	public void tick() {
		super.tick();

		Level world = this.getCommandSenderWorld();
		BlockPos pos = this.blockPosition();
		double time = world.getGameTime() * 0.2f;
		List<ParticleColor> chakraColors = new ArrayList<>();
		Collections.addAll(chakraColors, new ParticleColor(162, 86, 160), new ParticleColor(96, 96, 186),
				new ParticleColor(66, 184, 212), new ParticleColor(110, 200, 80), new ParticleColor(255, 165, 44),
				new ParticleColor(243, 124, 59), new ParticleColor(229, 60, 81));
		/*
		 * for (int j = 0; j < ParticleInit.chakraData.size(); j++) {
		 * world.addParticle(ParticleInit.chakraData.get(j), getPosX() + 0.5 +
		 * Math.cos(time - j) + HLParticleUtils.inRange(-0.1, 0.1), getPosY() + (j * 0.5)
		 * + 0.1 + HLParticleUtils.inRange(-0.1, 0.1), getPosZ() + 0.5 + -Math.sin(time -
		 * j) + HLParticleUtils.inRange(-0.1, 0.1), 0, 0, 0);
		 * world.addParticle(ParticleTypes.WHITE_ASH, getPosX() + 0.5 + Math.cos(time -
		 * j) + HLParticleUtils.inRange(-0.1, 0.1), getPosY() + (j * 0.5) +
		 * HLParticleUtils.inRange(-0.1, 0.1), getPosZ() + 0.5 + -Math.sin(time - j) +
		 * HLParticleUtils.inRange(-0.1, 0.1), 0, 0, 0);
		 *
		 * }
		 */
		Vector3 center = Vector3.fromEntityCenter(this);
		for (int j = 0; j < chakraColors.size(); j++) {
			world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
					center.x + Math.sin(time + j) + HLParticleUtils.inRange(-0.1, 0.1),
					center.y + (j * 0.5) + 0.1f + HLParticleUtils.inRange(-0.1, 0.1),
					center.z + Math.cos(time + j) + HLParticleUtils.inRange(-0.1, 0.1), 0, -0.05, 0);

			Collections.reverse(chakraColors);

			world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
					center.x - Math.sin(time - j) + HLParticleUtils.inRange(-0.1, 0.1),
					center.y + (j * 0.5) + 0.1f + HLParticleUtils.inRange(-0.1, 0.1),
					center.z + Math.cos(time - j) + HLParticleUtils.inRange(-0.1, 0.1), 0, -0.05, 0);

		}

		@SuppressWarnings("unused")
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
			 * if (this.ticksExisted % 10 - rand.nextInt(10) > 20) { pullPlayer( new
			 * AxisAlignedBB(this.getPositionVec().add(-15, -15, -15),
			 * this.getPositionVec().add(15, 15, 15)), this.getPositionVec().getX() + 0.5,
			 * this.getPositionVec().getY() + 0.5, this.getPositionVec().getZ() + 0.5); }
			 *
			 * if (attackRoll % 100 * diffMult == 0) { this.spawnMissile(); } else if
			 * (attackRoll % 110 * diffMult == 0) {
			 * this.spawnMissileVortex(rand.nextInt(15)); } else if (attackRoll % 130 *
			 * diffMult == 0) { this.summonThroneAid(rand.nextInt(2) + 2); } else if
			 * (attackRoll % 160 * diffMult == 0) { this.summonJudgement(rand.nextInt(3) +
			 * 3);
			 *
			 * } if (!this.isOnGround()) { if (attackRoll % 100 * diffMult == 0) {
			 * this.summonHolyFlare(rand.nextInt(1) + 3);
			 * playSound(SoundHandler.ENTITY_SERAPHIM_FLARE, 0.6F, 0.8F + (float)
			 * Math.random() * 0.2F); } }
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

			if (this.deathTicks >= 100) {
				this.level.addParticle(ParticleTypes.WHITE_ASH, this.getX() + f,
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
					new ItemStack(ItemInit.seraph_feather.get()));
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