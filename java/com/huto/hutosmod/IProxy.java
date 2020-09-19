package com.huto.hutosmod;

import com.huto.hutosmod.particles.types.Vector3;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.world.World;

public interface IProxy {
	default void registerHandlers() {
	}

	boolean isTheClientPlayer(LivingEntity entity);

	PlayerEntity getClientPlayer();



	default void lightningFX(Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, int colorOuter,
			int colorInner) {
		lightningFX(vectorStart, vectorEnd, ticksPerMeter, System.nanoTime(), colorOuter, colorInner);
	}

	void lightningFX(Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, long seed, int colorOuter,
			int colorInner);

	default void addParticleForce(World world, IParticleData particleData, double x, double y, double z, double xSpeed,
			double ySpeed, double zSpeed) {
	}
}