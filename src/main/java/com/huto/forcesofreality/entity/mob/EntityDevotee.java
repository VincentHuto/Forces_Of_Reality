package com.huto.forcesofreality.entity.mob;

import com.huto.forcesofreality.entity.projectile.EntityTrackingOrb;
import com.huto.forcesofreality.entity.summon.EntityTentacle;
import com.huto.forcesofreality.init.EntityInit;
import com.huto.forcesofreality.sound.SoundHandler;

import net.minecraft.block.BlockState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityDevotee extends Monster {

	public EntityDevotee(EntityType<? extends EntityDevotee> type, Level worldIn) {
		super(type, worldIn);

	}

	@Override
	public void tick() {
		super.tick();
		float f = (this.rand.nextFloat() - 0.5F) * 2.0F;
		float f1 = (this.rand.nextFloat() - 0.5F) * 1.0F;
		float f2 = (this.rand.nextFloat() - 0.5F) * 2.0F;
		this.world.addParticle(ParticleTypes.ASH, this.getPosX() + (double) f, this.getPosY() + 2.0D + (double) f1,
				this.getPosZ() + (double) f2, 0.0D, 0.0D, 0.0D);
	}

	@Override
	protected void registerGoals() {
		/*
		 * this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		 * this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		 */
		this.applyEntityAI();
		this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 0.12));
		this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 1d, 5));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1d, true));
		this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 6.0F));

	}

	protected void applyEntityAI() {
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}

	public static AttributeModifierMap.MutableAttribute setAttributes() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.15D)
				.createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();

	}

	@Override
	public void addTrackingPlayer(ServerPlayerEntity player) {
		super.addTrackingPlayer(player);
	}

	@Override
	public void removeTrackingPlayer(ServerPlayerEntity player) {
		super.removeTrackingPlayer(player);
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

	@SuppressWarnings("unused")
	private void spawnMissile() {
		EntityTrackingOrb missile = new EntityTrackingOrb(this, true);
		missile.setPosition(this.getPosX() + (Math.random() - 0.5 * 0.1),
				this.getPosY() + 2.4 + (Math.random() - 0.5 * 0.1), this.getPosZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			playSound(SoundHandler.ENTITY_HASTUR_HIT, 0.6F, 0.8F + (float) Math.random() * 0.2F);
			world.addEntity(missile);
		}
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}