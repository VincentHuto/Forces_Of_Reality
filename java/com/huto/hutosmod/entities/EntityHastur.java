package com.huto.hutosmod.entities;

import com.huto.hutosmod.entities.projectiles.EntityStarStrike;
import com.huto.hutosmod.entities.projectiles.EntityTrackingOrb;
import com.huto.hutosmod.init.EntityInit;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.sounds.SoundHandler;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.TickableSound;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityHastur extends MonsterEntity implements IEntityAdditionalSpawnData {

	private BlockPos source = BlockPos.ZERO;
	private static final String TAG_SOURCE_X = "sourceX";
	private static final String TAG_SOURCE_Y = "sourceY";
	private static final String TAG_SOURCE_Z = "sourcesZ";

	public int deathTicks;
	private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(),
			BossInfo.Color.YELLOW, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

	public EntityHastur(EntityType<? extends EntityHastur> type, World worldIn) {
		super(type, worldIn);

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

		/*
		 * this.world.createExplosion(this, this.getPosX(), this.getPosY() + (double)
		 * (this.getHeight() / 16.0F), this.getPosZ(), 4.0F, Explosion.Mode.DESTROY);
		 */
		// Attacks
		int attackRoll = ticksExisted + rand.nextInt(5);
		if (attackRoll % 137 * diffMult == 0) {
			this.setMotion(0, 0, 0);
			this.spawnMissile();
			this.setMotion(0, 0, 0);
		} else if (attackRoll % 141 * diffMult == 0) {
			this.setMotion(0, 0, 0);
			this.spawnMissileVortex(rand.nextInt(15));
			this.setMotion(0, 0, 0);
		} else if (attackRoll % 157 * diffMult == 0) {
			this.setMotion(0, 0, 0);
			if (world.rand.nextBoolean()) {
				this.summonTentacleAid(rand.nextInt(10));
			} else {
				this.summonSpawnAid(rand.nextInt(5));
			}
			this.setMotion(0, 0, 0);
		} else if (attackRoll % 180 * diffMult == 0) {
			this.setMotion(0, 0, 0);
			this.summonMissleSwarn(rand.nextInt(10));
			this.setMotion(0, 0, 0);

		}

		float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
		float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
		float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
		this.world.addParticle(ParticleTypes.WARPED_SPORE, this.getPosX() + (double) f,
				this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
		this.world.addParticle(ParticleTypes.CRIMSON_SPORE, this.getPosX() + (double) f,
				this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
	}

	@Override
	public ItemStack getHeldItemOffhand() {
		return new ItemStack(ItemInit.destruction_orb.get(), 1);
	}

	@Override
	protected void registerGoals() {
		/*
		 * this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		 * this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		 */
		this.applyEntityAI();
		this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 0.12));
		// this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 2d, 2));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1d, true));
		// this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.1f));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));

	}

	protected void applyEntityAI() {
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		/*
		 * this.targetSelector.addGoal(1, new NearestAttackableHasturAttacks<>(this,
		 * PlayerEntity.class, true));
		 * 
		 * 
		 * this.targetSelector.addGoal(1, new NearestAttackableTentacle<>(this,
		 * PlayerEntity.class, rand.nextInt(2), true));
		 */
	}

	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.15D)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	@Override
	protected void updateAITasks() {
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
	public boolean isNonBoss() {
		return false;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundHandler.ENTITY_HASTUR_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.ENTITY_HASTUR_HURT;

	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundHandler.ENTITY_HASTUR_DEATH;

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
		if (this.deathTicks >= 100 && this.deathTicks <= 200) {
			float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.world.addParticle(ParticleTypes.ASH, this.getPosX() + (double) f, this.getPosY() + 2.0D + (double) f1,
					this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);

			if (this.deathTicks >= 100) {
				this.world.addParticle(ParticleTypes.FLASH, this.getPosX() + (double) f,
						this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
			}
		}

		boolean flag = this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT);

		if (!this.world.isRemote && deathTicks % (15 + rand.nextInt(4)) == 0) {
			ItemEntity outputItem = new ItemEntity(world, this.getPosX(), this.getPosY(), this.getPosZ(),
					new ItemStack(ItemInit.unsettling_fabric.get()));
			world.addEntity(outputItem);
		}

		if (this.deathTicks == 200) {
			if (world.isRemote) {
				world.playSound(this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_GENERIC_EXPLODE,
						SoundCategory.HOSTILE, 3f, 0.2f, false);
			}
		}

		if (this.deathTicks == 200 && !this.world.isRemote) {
			if (flag) {
				this.dropExperience(MathHelper.floor((float) 500 * 0.2F));
			}
			this.remove();
		}

	}

	// Attack types
	public void summonTentacleAid(int numTent) {
		EntityTentacle[] tentArray = new EntityTentacle[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityTentacle(EntityInit.tentacle.get(), world);
			tentArray[i].setTentacleType(rand.nextInt(4));
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

	public void summonSpawnAid(int numSpawn) {
		EntityHasturSpawn[] spawnArray = new EntityHasturSpawn[numSpawn];
		for (int i = 0; i < numSpawn; i++) {
			spawnArray[i] = new EntityHasturSpawn(EntityInit.hastur_spawn.get(), world);
			spawnArray[i].setSpawnType(rand.nextInt(4));
			float xMod = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.rand.nextFloat() - 0.5F) * 8.0F;
			spawnArray[i].setPosition(this.getPosX() + 0.5 + xMod, this.getPosY() + 1.5 + yMod,
					this.getPosZ() + 0.5 + zMod);
			if (!world.isRemote) {
				world.addEntity(spawnArray[i]);
			}
		}
	}

	private void spawnMissile() {
		EntityTrackingOrb missile = new EntityTrackingOrb(this, true);
		missile.setPosition(this.getPosX() + (Math.random() - 0.5 * 0.1),
				this.getPosY() + 2.4 + (Math.random() - 0.5 * 0.1), this.getPosZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			playSound(SoundHandler.ENTITY_HASTUR_HIT, 0.6F, 0.8F + (float) Math.random() * 0.2F);
			world.addEntity(missile);
		}
	}

	public void summonMissleSwarn(int numMiss) {
		EntityStarStrike[] missArray = new EntityStarStrike[numMiss];
		for (int i = 0; i < numMiss; i++) {
			missArray[i] = new EntityStarStrike(this, true);
			float xMod = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.rand.nextFloat() - 0.5F) * 8.0F;
			missArray[i].setPosition(this.getPosX() + 0.5 + xMod, this.getPosY() + 1.5 + yMod,
					this.getPosZ() + 0.5 + zMod);
			if (!world.isRemote) {
				playSound(SoundHandler.ENTITY_HASTUR_HIT, 0.6F, 0.8F + (float) Math.random() * 0.2F);
				world.addEntity(missArray[i]);

			}
		}
	}

	private void spawnMissileVortex(int numMiss) {

		EntityStarStrike[] missArray = new EntityStarStrike[numMiss];
		for (int i = 0; i < numMiss; i++) {
			missArray[i] = new EntityStarStrike(this, true);

			float xMod = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.rand.nextFloat() - 0.5F) * 8.0F;
			missArray[i].setPosition(this.getPosX() + (Math.random() - 0.5 * 0.1) + 0.5 + xMod,
					this.getPosY() + 2.4 + (Math.random() - 0.5 * 0.1) + yMod,
					this.getPosZ() + (Math.random() - 0.5 * 0.1) + 0.5 + zMod);
			if (missArray[i].findTarget()) {
				playSound(SoundHandler.ENTITY_HASTUR_HIT, 0.6F, 0.8F + (float) Math.random() * 0.2F);
				world.addEntity(missArray[i]);
			}
		}
	}

	public void summonDenizenAid(int numTent) {
		EntityDenizen[] tentArray = new EntityDenizen[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityDenizen(EntityInit.denizen.get(), world);
			tentArray[i].setDenizenType(rand.nextInt(7));
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

	@Override
	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropSpecialItems(source, looting, recentlyHitIn);
		ItemEntity itementity = this.entityDropItem(ItemInit.yellow_sign.get());
		if (itementity != null) {
			itementity.setNoDespawn();
		}

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
		return this.getHealth() <= this.getMaxHealth() / 2.0F;
	}

	public boolean isVulnerable() {
		return this.getHealth() <= this.getMaxHealth() / 4.0F;
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
		private final EntityHastur hastur;

		public HasturMusic(EntityHastur hastur) {
			super(SoundHandler.ENTITY_HASTUR_MUSIC, SoundCategory.RECORDS);

			this.hastur = hastur;
			this.x = hastur.getSource().getX();
			this.y = hastur.getSource().getY();
			this.z = hastur.getSource().getZ();
			this.repeat = true; // TODO restore once LWJGL3/vanilla bug fixed?
		}

		@Override
		public void tick() {
			if (!hastur.isAlive()) {
				this.finishPlaying();
			}
		}
	}

}