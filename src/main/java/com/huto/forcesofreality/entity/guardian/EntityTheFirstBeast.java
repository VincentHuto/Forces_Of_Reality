package com.huto.forcesofreality.entity.guardian;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import com.huto.forcesofreality.entity.projectile.EntityFirstBeastBolt;
import com.huto.forcesofreality.entity.projectile.EntityWolfShot;
import com.huto.forcesofreality.entity.summon.EntitySummonedBeast;
import com.huto.forcesofreality.init.EntityInit;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.item.coven.tool.ItemBeastBolt;
import com.huto.forcesofreality.item.coven.tool.ItemBeastCrossbow;
import com.huto.forcesofreality.sound.SoundHandler;
import com.hutoslib.client.model.Animation;
import com.hutoslib.client.model.AnimationPacket;
import com.hutoslib.client.model.IAnimatable;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.TickableSound;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ICrossbowUser;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.RangedInteger;
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
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityTheFirstBeast extends MonsterEntity
		implements IEntityAdditionalSpawnData, IAnimatable, ICrossbowUser {

	private BlockPos source = BlockPos.ZERO;
	private static final String TAG_SOURCE_X = "sourceX";
	private static final String TAG_SOURCE_Y = "sourceY";
	private static final String TAG_SOURCE_Z = "sourcesZ";
	private static final DataParameter<Boolean> DATA_CHARGING_STATE = EntityDataManager
			.createKey(EntityTheFirstBeast.class, DataSerializers.BOOLEAN);
	private Animation animation = NO_ANIMATION;
	public static final Animation ARROW_ANIMATION = new Animation(64);
	public static final Animation CHARGE_ANIMATION = new Animation(104);
	public static final Animation BITE_ANIMATION = new Animation(17);
	private int animationTick;
	public int deathTicks;
	private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(),
			BossInfo.Color.RED, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

	public EntityTheFirstBeast(EntityType<? extends EntityTheFirstBeast> type, World worldIn) {
		super(type, worldIn);
		this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.first_beast_crossbow.get()));

	}

	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(ItemInit.first_beast_crossbow.get()));
	}

	@Override
	protected void func_241844_w(float p_241844_1_) {
		super.func_241844_w(p_241844_1_);
		if (this.rand.nextInt(300) == 0) {
			ItemStack itemstack = this.getHeldItemOffhand();
			if (itemstack.getItem() == ItemInit.first_beast_crossbow.get()) {
				Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemstack);
				map.putIfAbsent(Enchantments.PIERCING, 1);
				EnchantmentHelper.setEnchantments(map, itemstack);
				this.setItemStackToSlot(EquipmentSlotType.OFFHAND, itemstack);
			}
		}

	}

	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
		this.setEquipmentBasedOnDifficulty(difficultyIn);
		this.setEnchantmentBasedOnDifficulty(difficultyIn);
		return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);

	}

	@SuppressWarnings("unused")
	@Override
	public void livingTick() {
		super.livingTick();
		Animation animation = getAnimation();
		int animTick = getAnimationTick();
	}

	@SuppressWarnings("unused")
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

		int attackRoll = ticksExisted + rand.nextInt(5);
		if (this.deathTicks <= 0) {

			/*
			 * if (attackRoll % 50 * diffMult == 0) { this.spawnWolfShot(); } else if
			 * (attackRoll % 120 * diffMult == 0) { if (world.rand.nextBoolean()) { // //
			 * this.summonTentacleAid(rand.nextInt(10)); } else { // //
			 * this.summonSpawnAid(rand.nextInt(5)); } } else if (attackRoll % 130 *
			 * diffMult == 0) { this.greatHowl(); } if (this.isOnGround()) { if (attackRoll
			 * % 100 * diffMult == 0) { this.summonHounds(rand.nextInt(1) + 2); } }
			 */

			// Removed Starstrikes to use on the seraphim, still has the one missle spawn
			// though
			float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			/*
			 * this.world.addParticle(ParticleTypes.AMBIENT_ENTITY_EFFECT, this.getPosX() +
			 * (double) f, this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double)
			 * f2, 0.0D, 0.0D, 0.0D);
			 */
		}
	}

	@Override
	protected void registerGoals() {
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, VillagerEntity.class, true));
		this.goalSelector.addGoal(1, new GoalFirstBeastCrossbowAttack<>(this, 1.0D, 8.0F));

	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(DATA_CHARGING_STATE, false);

	}

	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.15D)
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
	protected SoundEvent getAmbientSound() {
		return SoundHandler.ENTITY_BEAST_FROM_BEYOND_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.ENTITY_BEAST_FROM_BEYOND_HURT;

	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundHandler.ENTITY_BEAST_FROM_BEYOND_DEATH;

	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundHandler.ENTITY_BEAST_FROM_BEYOND_STEP, 0.15F, 1.0F);
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
				this.world.addParticle(ParticleTypes.FALLING_LAVA, this.getPosX() + (double) f,
						this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
			}

			if (this.deathTicks >= 150) {
				this.world.addParticle(ParticleTypes.FLASH, this.getPosX() + (double) f,
						this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
			}

		}

		boolean flag = this.world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT);

		if (!this.world.isRemote && deathTicks % (15 + rand.nextInt(4)) == 0) {
			ItemEntity outputItem = new ItemEntity(world, this.getPosX(), this.getPosY(), this.getPosZ(),
					new ItemStack(ItemInit.blooddrawn_fang.get()));
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

	@Override
	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropSpecialItems(source, looting, recentlyHitIn);
		ItemEntity itementity = this.entityDropItem(ItemInit.breath_of_the_beast.get());
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
		private final EntityTheFirstBeast hastur;

		public HasturMusic(EntityTheFirstBeast hastur) {
			super(SoundHandler.ENTITY_BEAST_FROM_BEYOND_MUSIC, SoundCategory.RECORDS);

			this.hastur = hastur;
			this.x = hastur.getSource().getX();
			this.y = hastur.getSource().getY();
			this.z = hastur.getSource().getZ();
			this.repeat = true;
		}

		@Override
		public void tick() {
			if (!hastur.isAlive()) {
				this.finishPlaying();
			}
		}
	}

	// Attacks
	public void summonHounds(int numTent) {
		EntitySummonedBeast[] tentArray = new EntitySummonedBeast[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntitySummonedBeast(EntityInit.summoned_beast.get(), world);
			tentArray[i].setBeastType(rand.nextInt(4));
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

	@SuppressWarnings("unused")
	private void spawnWolfShot() {
		EntityWolfShot missile = new EntityWolfShot(this, true);
		missile.setPosition(this.getPosX() + (Math.random() - 0.5 * 0.1), this.getPosY() + (Math.random() - 0.5 * 0.1),
				this.getPosZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			playSound(SoundEvents.ENTITY_WOLF_GROWL, 0.6F, 0.8F + (float) Math.random() * 0.2F);
			world.addEntity(missile);
		}
	}

	@SuppressWarnings("unused")
	private void greatHowl() {
		playSound(SoundEvents.ENTITY_WOLF_HOWL, .25F, 1f);
		this.setMotion(0, 0, 0);
		this.setMotion(0, 0, 0);
		this.setMotion(0, 0, 0);
		this.setMotion(0, 0, 0);

		repel(world, new AxisAlignedBB(this.getPositionVec().add(-8, -8, -8), this.getPositionVec().add(8, 8, 8)),
				this.getPositionVec().getX() + 0.5, this.getPositionVec().getY(), this.getPositionVec().getZ() + 0.5);
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
					ent.playSound(SoundEvents.ENTITY_WOLF_HOWL, .15F, 1f + (float) Math.random() * 0.2F);

				}
			}
		}
	}

	public boolean isCharging() {
		return this.dataManager.get(DATA_CHARGING_STATE);
	}

	@Override
	public void setCharging(boolean isCharging) {
		this.dataManager.set(DATA_CHARGING_STATE, isCharging);
	}

	@Override
	public void fireProjectile(LivingEntity p_230284_1_, ItemStack p_230284_2_, ProjectileEntity p_230284_3_,
			float p_230284_4_) {
		this.func_234279_a_(this, p_230284_1_, p_230284_3_, p_230284_4_, 1.6F);
	}

	@Override
	public void func_230283_U__() {
		this.idleTime = 0;
	}

	class GoalFirstBeastCrossbowAttack<T extends MonsterEntity & IRangedAttackMob & ICrossbowUser> extends Goal {
		public final RangedInteger field_241381_a_ = new RangedInteger(20, 40);
		private final T field_220748_a;
		private EntityTheFirstBeast.CrossbowState field_220749_b = EntityTheFirstBeast.CrossbowState.UNCHARGED;
		private final double field_220750_c;
		private final float field_220751_d;
		private int field_220752_e;
		private int field_220753_f;
		private int field_241382_h_;

		public GoalFirstBeastCrossbowAttack(T shooter, double speed, float p_i50322_4_) {
			this.field_220748_a = shooter;
			this.field_220750_c = speed;
			this.field_220751_d = p_i50322_4_ * p_i50322_4_;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
		}

		/**
		 * Returns whether execution should begin. You can also read and cache any state
		 * necessary for execution in this method as well.
		 */
		public boolean shouldExecute() {
			return this.func_220746_h() && this.func_220745_g();
		}

		private boolean func_220745_g() {
			return this.field_220748_a.canEquip(ItemInit.first_beast_crossbow.get());
		}

		/**
		 * Returns whether an in-progress EntityAIBase should continue executing
		 */
		public boolean shouldContinueExecuting() {
			return this.func_220746_h() && (this.shouldExecute() || !this.field_220748_a.getNavigator().noPath())
					&& this.func_220745_g();
		}

		private boolean func_220746_h() {
			return this.field_220748_a.getAttackTarget() != null && this.field_220748_a.getAttackTarget().isAlive();
		}

		/**
		 * Reset the task's internal state. Called when this task is interrupted by
		 * another one
		 */
		public void resetTask() {
			super.resetTask();
			this.field_220748_a.setAggroed(false);
			this.field_220748_a.setAttackTarget((LivingEntity) null);
			this.field_220752_e = 0;
			if (this.field_220748_a.isHandActive()) {
				this.field_220748_a.resetActiveHand();
				this.field_220748_a.setCharging(false);
				ItemBeastCrossbow.setCharged(this.field_220748_a.getActiveItemStack(), false);
			}

		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void tick() {
			LivingEntity livingentity = this.field_220748_a.getAttackTarget();
			if (livingentity != null) {
				boolean flag = this.field_220748_a.getEntitySenses().canSee(livingentity);
				boolean flag1 = this.field_220752_e > 0;
				if (flag != flag1) {
					this.field_220752_e = 0;
				}

				if (flag) {
					++this.field_220752_e;
				} else {
					--this.field_220752_e;
				}

				double d0 = this.field_220748_a.getDistanceSq(livingentity);
				boolean flag2 = (d0 > (double) this.field_220751_d || this.field_220752_e < 5)
						&& this.field_220753_f == 0;
				if (flag2) {
					--this.field_241382_h_;
					if (this.field_241382_h_ <= 0) {
						this.field_220748_a.getNavigator().tryMoveToEntityLiving(livingentity,
								this.func_220747_j() ? this.field_220750_c : this.field_220750_c * 0.5D);
						this.field_241382_h_ = field_241381_a_.getRandomWithinRange(this.field_220748_a.getRNG());
					}
				} else {
					this.field_241382_h_ = 0;
					this.field_220748_a.getNavigator().clearPath();
				}

				this.field_220748_a.getLookController().setLookPositionWithEntity(livingentity, 30.0F, 30.0F);
				if (this.field_220749_b == EntityTheFirstBeast.CrossbowState.UNCHARGED) {
					if (!flag2) {
						this.field_220748_a.setActiveHand(
								ProjectileHelper.getHandWith(this.field_220748_a, ItemInit.first_beast_crossbow.get()));
						this.field_220749_b = EntityTheFirstBeast.CrossbowState.CHARGING;
						this.field_220748_a.setCharging(true);
					}
				} else if (this.field_220749_b == EntityTheFirstBeast.CrossbowState.CHARGING) {
					if (!this.field_220748_a.isHandActive()) {
						this.field_220749_b = EntityTheFirstBeast.CrossbowState.UNCHARGED;

						if (noActiveAnimation()) {
							AnimationPacket.send(EntityTheFirstBeast.this, ARROW_ANIMATION);
						}
					}

					int i = this.field_220748_a.getItemInUseMaxCount();
					ItemStack itemstack = this.field_220748_a.getActiveItemStack();
					if (i >= ItemBeastCrossbow.getChargeTime(itemstack)) {
						this.field_220748_a.stopActiveHand();
						this.field_220749_b = EntityTheFirstBeast.CrossbowState.CHARGED;
						this.field_220753_f = 20 + this.field_220748_a.getRNG().nextInt(20);
						this.field_220748_a.setCharging(false);

						if (noActiveAnimation()) {
							AnimationPacket.send(EntityTheFirstBeast.this, ARROW_ANIMATION);
						}
					}
				} else if (this.field_220749_b == EntityTheFirstBeast.CrossbowState.CHARGED) {
					--this.field_220753_f;
					if (this.field_220753_f == 0) {
						this.field_220749_b = EntityTheFirstBeast.CrossbowState.READY_TO_ATTACK;

					}
				} else if (this.field_220749_b == EntityTheFirstBeast.CrossbowState.READY_TO_ATTACK && flag) {
					this.field_220748_a.attackEntityWithRangedAttack(livingentity, 1.0F);
					ItemStack itemstack1 = this.field_220748_a.getHeldItem(
							ProjectileHelper.getHandWith(this.field_220748_a, ItemInit.first_beast_crossbow.get()));
					ItemBeastCrossbow.setCharged(itemstack1, false);
					this.field_220749_b = EntityTheFirstBeast.CrossbowState.UNCHARGED;

					if (noActiveAnimation()) {
						AnimationPacket.send(EntityTheFirstBeast.this, ARROW_ANIMATION);
					}

				}

			}
		}

		private boolean func_220747_j() {
			return this.field_220749_b == EntityTheFirstBeast.CrossbowState.UNCHARGED;
		}

	}

	enum CrossbowState {
		UNCHARGED, CHARGING, CHARGED, READY_TO_ATTACK;
	}

	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
		ItemStack itemstack = this.findAmmo(this.getHeldItem(ProjectileHelper.getHandWith(this, Items.BOW)));
		AbstractArrowEntity abstractarrowentity = this.fireArrow(itemstack, this, distanceFactor);
		if (this.getHeldItemMainhand().getItem() instanceof net.minecraft.item.BowItem)
			abstractarrowentity = ((net.minecraft.item.BowItem) this.getHeldItemMainhand().getItem())
					.customArrow(abstractarrowentity);
		double d0 = target.getPosX() - this.getPosX();
		double d1 = target.getPosYHeight(0.3333333333333333D) - abstractarrowentity.getPosY();
		double d2 = target.getPosZ() - this.getPosZ();
		double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
		abstractarrowentity.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F,
				(float) (14 - this.world.getDifficulty().getId() * 4));
		this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.world.addEntity(abstractarrowentity);
	}

	public boolean func_230280_a_(ShootableItem p_230280_1_) {
		return p_230280_1_ == Items.BOW;
	}

	protected EntityFirstBeastBolt fireArrow(ItemStack arrowStack, EntityTheFirstBeast shooter, float distanceFactor) {
		ItemBeastBolt arrowitem = (ItemBeastBolt) (arrowStack.getItem() instanceof ItemBeastBolt ? arrowStack.getItem()
				: ItemInit.first_beast_bolt.get());
		EntityFirstBeastBolt abstractarrowentity = (EntityFirstBeastBolt) arrowitem.createArrow(shooter.world,
				arrowStack, shooter);
		abstractarrowentity.setEnchantmentEffectsFromEntity(shooter, distanceFactor);
		if (arrowStack.getItem() == Items.TIPPED_ARROW && abstractarrowentity instanceof EntityFirstBeastBolt) {
			((EntityFirstBeastBolt) abstractarrowentity).setPotionEffect(arrowStack);
		}

		return abstractarrowentity;
	}

	// Animation
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
		return new Animation[] { BITE_ANIMATION, ARROW_ANIMATION, CHARGE_ANIMATION };
	}

}