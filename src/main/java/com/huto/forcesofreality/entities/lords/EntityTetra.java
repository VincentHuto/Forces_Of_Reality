package com.huto.forcesofreality.entities.lords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.huto.forcesofreality.entities.projectiles.EntityHolyFlare;
import com.huto.forcesofreality.entities.projectiles.EntityJudgement;
import com.huto.forcesofreality.entities.projectiles.EntityStarStrike;
import com.huto.forcesofreality.entities.summons.EntityThrone;
import com.huto.forcesofreality.entities.utils.Vector3;
import com.huto.forcesofreality.init.EntityInit;
import com.huto.forcesofreality.init.ItemInit;
import com.huto.forcesofreality.particles.ParticleColor;
import com.huto.forcesofreality.particles.ParticleUtil;
import com.huto.forcesofreality.particles.data.GlowParticleData;
import com.huto.forcesofreality.sounds.SoundHandler;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.TickableSound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.BossInfo;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityTetra extends MonsterEntity implements IEntityAdditionalSpawnData {

	private BlockPos source = BlockPos.ZERO;
	private static final String TAG_SOURCE_X = "sourceX";
	private static final String TAG_SOURCE_Y = "sourceY";
	private static final String TAG_SOURCE_Z = "sourcesZ";

	public int deathTicks;
	private float heightOffset = 0.5F;
	private int heightOffsetUpdateTime;
	public float wingRotation;
	public float destPos;
	public float oFlapSpeed;
	public float oFlap;
	public float wingRotDelta = 1.0F;
	private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(),
			BossInfo.Color.BLUE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);

	public EntityTetra(EntityType<? extends EntityTetra> type, World worldIn) {
		super(type, worldIn);

	}

	@Override
	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	@Override
	public void livingTick() {

		if (!this.onGround && this.getMotion().y < 0.0D) {
			this.setMotion(this.getMotion().mul(1.0D, 0.6D, 1.0D));
		}

		super.livingTick();
		this.oFlap = this.wingRotation;
		this.oFlapSpeed = this.destPos;
		this.destPos = (float) ((double) this.destPos + (double) (4) * 0.3D);
		this.destPos = MathHelper.clamp(this.destPos, 1.2F, 1.5F);
		if (!this.onGround) {
			this.wingRotDelta = 2.0F;
		} else {
			this.wingRotDelta = 2.0F;
		}
		this.wingRotDelta = (float) ((double) this.wingRotDelta * 0.9D);
		Vector3d vector3d = this.getMotion();
		if (!this.onGround) {
			this.setMotion(vector3d.mul(1.0D, 0.6D, 1.0D));
		} else {
			this.setMotion(vector3d.mul(1.0D, 0.6D, 1.0D));

		}
		this.wingRotation += this.wingRotDelta * 0.1F;
		if (wingRotation > 1000) {
			wingRotation = 0;
		}
	}

	int timer = 200;

	@SuppressWarnings("unused")
	@Override
	public void tick() {
		super.tick();

		World world = this.getEntityWorld();
		BlockPos pos = this.getPosition();
		double time = world.getGameTime() * 0.2f;
		List<ParticleColor> chakraColors = new ArrayList<ParticleColor>();
		Collections.addAll(chakraColors, new ParticleColor(162, 86, 160), new ParticleColor(96, 96, 186),
				new ParticleColor(66, 184, 212), new ParticleColor(110, 200, 80), new ParticleColor(255, 165, 44),
				new ParticleColor(243, 124, 59), new ParticleColor(229, 60, 81));
		Collections.reverse(chakraColors);

		Vector3 center = Vector3.fromEntityCenter(this);
		for (int j = 0; j < chakraColors.size(); j++) {
			world.addParticle(GlowParticleData.createData(new ParticleColor(229, 229, 0)),
					center.x + Math.sin(time + j) * 0.55f + ParticleUtil.inRange(-0.1, 0.1),
					center.y + (j * 0.15) - 0.1 + ParticleUtil.inRange(-0.1, 0.1),
					center.z + Math.cos(time + j) * 0.55f + ParticleUtil.inRange(-0.1, 0.1), 0, -0.05, 0);
			world.addParticle(GlowParticleData.createData(new ParticleColor(229, 229, 229)),
					center.x + Math.sin(time + j) * 0.55f + ParticleUtil.inRange(-0.1, 0.1),
					center.y + (j * 0.15) - 0.1 + ParticleUtil.inRange(-0.1, 0.1),
					center.z + Math.cos(time + j) * 0.55f + ParticleUtil.inRange(-0.1, 0.1), 0, -0.05, 0);
		}

		world.addParticle(GlowParticleData.createData(new ParticleColor(250, 200, 0)),
				center.x + ParticleUtil.inRange(-0.1, 0.1),
				center.y + (1 * 0.15) - 1.3 + ParticleUtil.inRange(-0.2, 0.2),
				center.z + ParticleUtil.inRange(-0.1, 0.1), 0, -0.05, 0);
		world.addParticle(GlowParticleData.createData(new ParticleColor(20, 0, 0)),
				center.x + ParticleUtil.inRange(-0.1, 0.1),
				center.y + (1 * 0.15) - 1.3 + ParticleUtil.inRange(-0.2, 0.2),
				center.z + ParticleUtil.inRange(-0.1, 0.1), 0, -0.05, 0);

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

			if (this.ticksExisted % 10 - rand.nextInt(10) > 20) {
				pullPlayer(
						new AxisAlignedBB(this.getPositionVec().add(-15, -15, -15),
								this.getPositionVec().add(15, 15, 15)),
						this.getPositionVec().getX() + 0.5, this.getPositionVec().getY() + 0.5,
						this.getPositionVec().getZ() + 0.5);
			}

			if (attackRoll % 100 * diffMult == 0) {
				this.spawnMissile();

			} else if (attackRoll % 110 * diffMult == 0) {
				this.magnificentFlash();

			} else if (attackRoll % 130 * diffMult == 0) {
				this.summonThroneAid(rand.nextInt(2) + 2);
			} else if (attackRoll % 160 * diffMult == 0) {
				this.summonJudgement(rand.nextInt(3) + 3);
			}
			if (!this.isOnGround()) {
				if (attackRoll % 100 * diffMult == 0) {
					this.summonHolyFlare(rand.nextInt(1) + 3);
					playSound(SoundHandler.ENTITY_SERAPHIM_FLARE, 0.6F, 0.8F + (float) Math.random() * 0.2F);
				}
			}

			float f = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float f1 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float f2 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.world.addParticle(ParticleTypes.ENCHANT, this.getPosX() + (double) f,
					this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
			this.world.addParticle(ParticleTypes.REVERSE_PORTAL, this.getPosX() + (double) f,
					this.getPosY() + 2.0D + (double) f1, this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public ItemStack getHeldItemOffhand() {
		return new ItemStack(ItemInit.destruction_orb.get(), 1);
	}

	@Override
	protected void registerGoals() {

		this.applyEntityAI();
		this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 0.12));
		this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 3d, 5));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1d, true));
		this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.2f));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));
		this.goalSelector.addGoal(4, new LookAtGoal(this, AbstractVillagerEntity.class, 6.0F));

	}

	protected void applyEntityAI() {
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, true));

	}

	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 100.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.15D)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	@Override
	protected void updateAITasks() {
		--this.heightOffsetUpdateTime;
		if (this.heightOffsetUpdateTime <= 0) {
			this.heightOffsetUpdateTime = 100;
			this.heightOffset = 0.5F + (float) this.rand.nextGaussian() * 3.0F;
		}

		LivingEntity livingentity = this.getAttackTarget();
		if (livingentity != null && livingentity.getPosYEye() > this.getPosYEye() + (double) this.heightOffset
				&& this.canAttack(livingentity)) {
			Vector3d vector3d = this.getMotion();
			this.setMotion(this.getMotion().add(0.0D, ((double) 0.3F - vector3d.y) * (double) 0.3F, 0.0D));
			this.isAirBorne = true;
		}

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
		return SoundHandler.ENTITY_SERAPHIM_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundHandler.ENTITY_SERAPHIM_HURT;

	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundHandler.ENTITY_SERAPHIM_DEATH;

	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.ENTITY_HOGLIN_STEP, 0.15F, 1.0F);
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
				this.world.addParticle(ParticleTypes.WHITE_ASH, this.getPosX() + (double) f,
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
					new ItemStack(ItemInit.seraph_feather.get()));
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
	public void pullPlayer(AxisAlignedBB effectBounds, double x, double y, double z) {
		List<Entity> list = world.getEntitiesWithinAABB(Entity.class, effectBounds);
		for (Entity ent : list) {
			if (ent instanceof PlayerEntity) {
				Vector3d p = new Vector3d(x, y, z);
				Vector3d t = new Vector3d(ent.getPosX(), ent.getPosY(), ent.getPosZ());
				double distance = p.distanceTo(t) + 0.1D;
				Vector3d r = new Vector3d(t.x - p.x, t.y - p.y, t.z - p.z);
				ent.setMotion(-r.x / 10.2D / distance * 3.3, -r.y / 10.2D / distance * 3.3,
						-r.z / 10.2D / distance * 3.3);
				if (world.isRemote) {
					for (int countparticles = 0; countparticles <= 1; ++countparticles) {
						ent.world.addParticle(ParticleTypes.PORTAL,
								ent.getPosX() + (world.rand.nextDouble() - 0.5D) * (double) ent.getWidth(),
								ent.getPosY() + world.rand.nextDouble() * (double) ent.getHeight()
										- (double) ent.getYOffset() - 0.5,
								ent.getPosZ() + (world.rand.nextDouble() - 0.5D) * (double) ent.getWidth(), 0.0D, 0.0D,
								0.0D);
					}
				}
			}
		}
	}

	public void summonThroneAid(int numTent) {
		EntityThrone[] tentArray = new EntityThrone[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityThrone(EntityInit.throne.get(), world);
			tentArray[i].setTentacleType(rand.nextInt(4));
			float xMod = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float yMod = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float zMod = (this.rand.nextFloat() - 0.5F) * 8.0F;
			tentArray[i].setPosition(this.getPosX() + 0.5 + xMod, this.getPosY() + 1.5 + yMod,
					this.getPosZ() + 0.5 + zMod);
			if (!world.isRemote) {
				playSound(SoundHandler.ENTITY_SERAPHIM_THRONE, 0.6F, 0.8F + (float) Math.random() * 0.2F);
				world.addEntity(tentArray[i]);

			}
		}
	}

	public void summonHolyFlare(int numTent) {
		EntityHolyFlare[] tentArray = new EntityHolyFlare[numTent];
		for (int i = 0; i < numTent; i++) {
			tentArray[i] = new EntityHolyFlare(EntityInit.holy_flare.get(), world);
			float xMod = (this.rand.nextFloat() - 0.5F) * 16.0F;
			float yMod = (this.rand.nextFloat() - 0.5F) * 2.0F;
			float zMod = (this.rand.nextFloat() - 0.5F) * 16.0F;
			tentArray[i].setPosition(this.getPosX() + 0.5 + xMod, this.getPosY() + 1.5 + yMod,
					this.getPosZ() + 0.5 + zMod);
			if (!world.isRemote) {
				world.addEntity(tentArray[i]);

			}
		}
	}

	private void magnificentFlash() {
		playSound(SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, .25F, 1f);
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
			if (!(ent instanceof EntityThrone)) {
				Vector3d p = new Vector3d(x, y, z);
				Vector3d t = new Vector3d(ent.getPosX(), ent.getPosY(), ent.getPosZ());
				double distance = p.distanceTo(t) + 0.1D;
				Vector3d r = new Vector3d(t.x - p.x, t.y - p.y, t.z - p.z);
				ent.setMotion(r.x * 3 / distance, r.y * 3 / distance, r.z * 3 / distance);
				for (int countparticles = 0; countparticles <= 30; ++countparticles) {
					world.addParticle(ParticleTypes.FLASH,
							ent.getPosX() + (world.rand.nextDouble() - 0.5D) * (double) ent.getWidth(),
							ent.getPosY() + world.rand.nextDouble() * (double) ent.getHeight()
									- (double) ent.getYOffset() - 0.5,
							ent.getPosZ() + (world.rand.nextDouble() - 0.5D) * (double) ent.getWidth(), 0.0D, 0.0D,
							0.0D);
					world.addParticle(GlowParticleData.createData(new ParticleColor(255, 255, 0)),
							ent.getPosX() + (world.rand.nextDouble() - 0.5D) * (double) ent.getWidth(),
							ent.getPosY() + world.rand.nextDouble() * (double) ent.getHeight()
									- (double) ent.getYOffset() - 0.5,
							ent.getPosZ() + (world.rand.nextDouble() - 0.5D) * (double) ent.getWidth(), 0.0D, 0.0D,
							0.0D);

					ent.playSound(SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, .15F, 1f + (float) Math.random() * 0.2F);

				}
			}
		}
	}

	private void spawnMissile() {
		EntityStarStrike missile = new EntityStarStrike(this, true);
		missile.setPosition(this.getPosX() + (Math.random() - 0.5 * 0.1),
				this.getPosY() + 2.4 + (Math.random() - 0.5 * 0.1), this.getPosZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			playSound(SoundHandler.ENTITY_HASTUR_HIT, 0.6F, 0.8F + (float) Math.random() * 0.2F);

			world.addEntity(missile);
		}
	}

	public void summonJudgement(int numMiss) {
		EntityJudgement[] missArray = new EntityJudgement[numMiss];
		for (int i = 0; i < numMiss; i++) {
			missArray[i] = new EntityJudgement(this, true);
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

	@SuppressWarnings("unused")
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

	@Override
	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropSpecialItems(source, looting, recentlyHitIn);
		ItemEntity itementity = this.entityDropItem(ItemInit.crossed_keys.get());
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
		private final EntityTetra tetra;

		public HasturMusic(EntityTetra tetra) {
			super(SoundHandler.ENTITY_SERAPHIM_MUSIC, SoundCategory.RECORDS);

			this.tetra = tetra;
			this.x = tetra.getSource().getX();
			this.y = tetra.getSource().getY();
			this.z = tetra.getSource().getZ();
			this.repeat = true; //
		}

		@Override
		public float getVolume() {
			return super.getVolume() / 2;
		}

		@Override
		public void tick() {
			if (!tetra.isAlive()) {
				this.finishPlaying();
			}
		}
	}

}