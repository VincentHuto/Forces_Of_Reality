/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * File Created @ [Jan 13, 2014, 7:46:05 PM (GMT)]
 */
package com.huto.hutosmod;

import com.huto.hutosmod.particles.types.FXLightning;
import com.huto.hutosmod.particles.types.Vector3;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.IParticleData;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {

	@Override
	public boolean isTheClientPlayer(LivingEntity entity) {
		return entity == Minecraft.getInstance().player;
	}

	@Override
	public PlayerEntity getClientPlayer() {
		return Minecraft.getInstance().player;
	}

	@Override
	public void lightningFX(Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, long seed, int colorOuter,
			int colorInner) {
		Minecraft.getInstance().particles.addEffect(new FXLightning(Minecraft.getInstance().world, vectorStart,
				vectorEnd, ticksPerMeter, seed, colorOuter, colorInner));

	}

	@Override
	public void addParticleForce(World world, IParticleData particleData, double x, double y, double z, double xSpeed,
			double ySpeed, double zSpeed) {
		world.addParticle(particleData, true, x, y, z, xSpeed, ySpeed, zSpeed);
	}

}
