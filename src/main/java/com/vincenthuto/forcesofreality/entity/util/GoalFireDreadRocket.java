package com.vincenthuto.forcesofreality.entity.util;

import java.util.EnumSet;

import com.vincenthuto.forcesofreality.entity.mob.EntityDreadBot;
import com.vincenthuto.forcesofreality.entity.projectile.EntityDreadRocket;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;

public class GoalFireDreadRocket extends Goal {
	private final EntityDreadBot blaze;
	private int attackStep;
	private int attackTime;
	private int firedRecentlyTimer;

	public GoalFireDreadRocket(EntityDreadBot blazeIn) {
		this.blaze = blazeIn;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
	}

	/**
	 * Returns whether execution should begin. You can also read and cache any state
	 * necessary for execution in this method as well.
	 */
	@Override
	public boolean canUse() {
		LivingEntity livingentity = this.blaze.getTarget();
		return livingentity != null && livingentity.isAlive() && this.blaze.canAttack(livingentity);
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	@Override
	public void start() {
		this.attackStep = 0;
	}

	/**
	 * Reset the task's internal state. Called when this task is interrupted by
	 * another one
	 */
	@Override
	public void stop() {
		this.firedRecentlyTimer = 0;
	}

	/**
	 * Keep ticking a continuous task that has already been started
	 */
	@Override
	public void tick() {
		--this.attackTime;
		LivingEntity livingentity = this.blaze.getTarget();
		if (livingentity != null) {
			++this.firedRecentlyTimer;

			double d0 = this.blaze.distanceToSqr(livingentity);
			if (d0 < 2.0D) {

				this.blaze.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(),
						livingentity.getZ(), 1.0D);
			} else if (d0 < this.getFollowDistance() * this.getFollowDistance()) {
				if (this.attackTime <= 0) {
					++this.attackStep;
					if (this.attackStep == 1) {
						this.attackTime = 2;
					} else if (this.attackStep <= 4) {
						this.attackTime = 6;
					} else {
						this.attackTime = 10;
						this.attackStep = 0;
					}
					if (this.attackStep > 1) {
						if (!this.blaze.isSilent()) {
							this.blaze.level.levelEvent((Player) null, 1018, this.blaze.blockPosition(), 0);
						}
						for (int i = 0; i < 1; ++i) {
							spawnWolfShot();
						}
					}
				}

				this.blaze.getLookControl().setLookAt(livingentity, 10.0F, 10.0F);
			} else if (this.firedRecentlyTimer < 5) {
				this.blaze.getMoveControl().setWantedPosition(livingentity.getX(), livingentity.getY(),
						livingentity.getZ(), 1.0D);
			}

			super.tick();
		}
	}

	private double getFollowDistance() {
		return this.blaze.getAttributeValue(Attributes.FOLLOW_RANGE);
	}

	private void spawnWolfShot() {
		EntityDreadRocket missile = new EntityDreadRocket(blaze, true);
		missile.setPos(blaze.getX() + (Math.random() - 0.5 * 0.1), blaze.getY() + 1,
				blaze.getZ() + (Math.random() - 0.5 * 0.1));
		if (missile.findTarget()) {
			blaze.playSound(SoundEvents.REDSTONE_TORCH_BURNOUT, 0.6F, 0.8F + (float) Math.random() * 0.2F);
			blaze.level.addFreshEntity(missile);
		}
	}

}
