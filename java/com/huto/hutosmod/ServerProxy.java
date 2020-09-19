/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * File Created @ [Jan 13, 2014, 7:45:37 PM (GMT)]
 */
package com.huto.hutosmod;

import com.huto.hutosmod.particles.types.Vector3;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class ServerProxy implements IProxy {

	@Override
	public boolean isTheClientPlayer(LivingEntity entity) {
		return false;
	}

	@Override
	public PlayerEntity getClientPlayer() {
		return null;
	}


	@Override
	public void lightningFX(Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, long seed, int colorOuter, int colorInner) {}


}