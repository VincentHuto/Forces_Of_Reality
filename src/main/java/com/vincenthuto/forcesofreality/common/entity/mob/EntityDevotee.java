package com.vincenthuto.forcesofreality.common.entity.mob;

import com.vincenthuto.forcesofreality.common.entity.projectile.EntityTrackingOrb;
import com.vincenthuto.forcesofreality.common.entity.summon.EntityTentacle;
import com.vincenthuto.forcesofreality.registry.EntityInit;
import com.vincenthuto.forcesofreality.registry.SoundInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;

public class EntityDevotee extends Monster {

	public static AttributeSupplier.Builder setAttributes() {
		return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.15D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1.0D).add(Attributes.ATTACK_DAMAGE, 1.0D);
	}

	public EntityDevotee(EntityType<? extends EntityDevotee> type, Level worldIn) {
		super(type, worldIn);

	}

	protected void applyEntityAI() {
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, true));
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();

	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundInit.ENTITY_HASTUR_AMBIENT.get();
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

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(SoundEvents.COW_STEP, 0.15F, 1.0F);
	}

	@Override
	protected void registerGoals() {
		/*
		 * this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		 * this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		 */
		this.applyEntityAI();
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.12));
		this.goalSelector.addGoal(5, new MoveTowardsTargetGoal(this, 1d, 5));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1d, true));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));

	}

	@SuppressWarnings("unused")
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
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
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
		float f = (this.random.nextFloat() - 0.5F) * 2.0F;
		float f1 = (this.random.nextFloat() - 0.5F) * 1.0F;
		float f2 = (this.random.nextFloat() - 0.5F) * 2.0F;
		this.level().addParticle(ParticleTypes.ASH, this.getX() + f, this.getY() + 2.0D + f1,
				this.getZ() + f2, 0.0D, 0.0D, 0.0D);
	}

}