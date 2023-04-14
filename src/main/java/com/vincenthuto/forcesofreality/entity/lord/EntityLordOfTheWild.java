package com.vincenthuto.forcesofreality.entity.lord;

import java.util.List;

import com.vincenthuto.forcesofreality.entity.projectile.EntityWolfShot;
import com.vincenthuto.forcesofreality.entity.summon.EntitySummonedBeast;
import com.vincenthuto.forcesofreality.init.EntityInit;
import com.vincenthuto.forcesofreality.init.ItemInit;
import com.vincenthuto.forcesofreality.init.SoundInit;
import com.vincenthuto.hutoslib.common.item.HLItemInit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.grower.DarkOakTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

public class EntityLordOfTheWild extends Monster implements IEntityAdditionalSpawnData {

	@OnlyIn(Dist.CLIENT)
	private static class HasturMusic extends AbstractTickableSoundInstance {
		private final EntityLordOfTheWild hastur;

		public HasturMusic(EntityLordOfTheWild hastur) {
			super(SoundInit.ENTITY_BEAST_FROM_BEYOND_MUSIC.get(), SoundSource.RECORDS, RandomSource.create());

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

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 100.0D).add(Attributes.MOVEMENT_SPEED, 0.3D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 0.15D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}
	private BlockPos source = BlockPos.ZERO;
	public int deathTicks;

	private final ServerBossEvent bossInfo = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(),
			BossEvent.BossBarColor.GREEN, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

	public final AnimationState idleAnimationState = new AnimationState();

	public EntityLordOfTheWild(EntityType<? extends EntityLordOfTheWild> type, Level worldIn) {
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
	protected void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
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

	private void greatHowl() {
		playSound(SoundEvents.WOLF_HOWL, .25F, 1f);
		this.setDeltaMovement(0, 0, 0);
		this.setDeltaMovement(0, 0, 0);
		this.setDeltaMovement(0, 0, 0);
		this.setDeltaMovement(0, 0, 0);

		repel(level, new AABB(this.position().add(-8, -8, -8), this.position().add(8, 8, 8)), this.position().x() + 0.5,
				this.position().y(), this.position().z() + 0.5);
	}

	@Override
	public void heal(float amount) {
		super.heal(amount);

	}

	@Override
	public InteractionResult interactAt(Player player, Vec3 vec, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (itemstack.getItem() == HLItemInit.cured_clay_flask.get()) {
			player.playSound(SoundEvents.BLAZE_AMBIENT, 1.0F, 1.0F);
			ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, player,
					ItemInit.breath_of_the_beast.get().getDefaultInstance());
			player.setItemInHand(hand, itemstack1);
			return InteractionResult.sidedSuccess(this.level.isClientSide);
		} else {
			return super.interactAt(player, vec, hand);
		}
	}

	public boolean isArmored() {
		return this.getHealth() <= this.getMaxHealth() / 2.0F;
	}

	public boolean isVulnerable() {
		return this.getHealth() <= this.getMaxHealth() / 4.0F;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundInit.ENTITY_BEAST_FROM_BEYOND_STEP.get(), 0.15F, 1.0F);
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
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
		this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
		this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
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
					ent.playSound(SoundEvents.WOLF_HOWL, .15F, 1f + (float) Math.random() * 0.2F);

				}
			}
		}
	}

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

	// Attack types
	public void summonHounds(int numTent) {
		EntitySummonedBeast[] tentArray = new EntitySummonedBeast[numTent];
		Wolf[] wolfArray = new Wolf[numTent];

		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntitySummonedBeast(EntityInit.summoned_beast.get(), level);
			wolfArray[i] = new Wolf(EntityType.WOLF, level);
			if (this.getKillCredit() != null) {
				wolfArray[i].setPersistentAngerTarget(getKillCredit().getUUID());
			}
			tentArray[i].setBeastType(random.nextInt(4));
			float xMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.random.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.random.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 1.5 + yMod, this.getZ() + 0.5 + zMod);
			wolfArray[i].setPos(this.getX() + 0.5 + xMod, this.getY() + 1.5 + yMod, this.getZ() + 0.5 + zMod);
			if (!level.isClientSide) {
				level.addFreshEntity(tentArray[i]);
				level.addFreshEntity(wolfArray[i]);

			}
		}
	}

	@Override
	public void tick() {
		super.tick();
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

		int attackRoll = tickCount + random.nextInt(5);
		if (this.deathTicks <= 0) {
			if (attackRoll % 50 * diffMult == 0) {
				this.spawnWolfShot();
			} else if (attackRoll % 120 * diffMult == 0) {
				if (level.random.nextBoolean()) {
					// this.summonTentacleAid(rand.nextInt(10));
				} else {
					// this.summonSpawnAid(rand.nextInt(5));
				}
			} else if (attackRoll % 130 * diffMult == 0) {
				this.greatHowl();
			}
			if (this.isOnGround()) {
				if (attackRoll % 100 * diffMult == 0) {
					this.summonHounds(random.nextInt(1) + 2);
				}
			}

			// Removed Starstrikes to use on the seraphim, still has the one missle spawn
			// though
			float f = (this.random.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.random.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.random.nextFloat() - 0.5F) * 8.0F;
			this.level.addParticle(ParticleTypes.AMBIENT_ENTITY_EFFECT, this.getX() + f, this.getY() + 2.0D + f1,
					this.getZ() + f2, 0.0D, 0.0D, 0.0D);
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
			this.level.addParticle(ParticleTypes.ASH, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2, 0.0D,
					0.0D, 0.0D);

			if (this.deathTicks >= 100) {
				this.level.addParticle(ParticleTypes.HAPPY_VILLAGER, this.getX() + f, this.getY() + 2.0D + f1,
						this.getZ() + f2, 0.0D, 0.0D, 0.0D);
			}

			if (this.deathTicks >= 150) {
				this.level.addParticle(ParticleTypes.FLASH, this.getX() + f, this.getY() + 2.0D + f1, this.getZ() + f2,
						0.0D, 0.0D, 0.0D);
			}

		}

		boolean flag = this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT);

		if (!this.level.isClientSide && deathTicks % (15 + random.nextInt(4)) == 0) {
			ItemEntity outputItem = new ItemEntity(level, this.getX(), this.getY(), this.getZ(),
					new ItemStack(ItemInit.blooddrawn_fang.get()));
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
			DarkOakTreeGrower tree = new DarkOakTreeGrower();
			ServerLevel sWorld = (ServerLevel) level;
			tree.growTree(sWorld, sWorld.getChunkSource().getGenerator(), this.getBlockPosBelowThatAffectsMyMovement(),
					sWorld.getBlockState(this.getBlockPosBelowThatAffectsMyMovement()), random);
			this.remove(RemovalReason.KILLED);
		}
	}

	@Override
	public void writeSpawnData(FriendlyByteBuf buffer) {
		buffer.writeLong(source.asLong());

	}

}