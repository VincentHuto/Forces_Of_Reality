package com.huto.hutosmod.particles;

import com.mojang.serialization.Codec;

import net.minecraft.particles.ParticleType;

/**
 * Created by TGG on 25/03/2020.
 * Simple class used to describe the Particle
 */
public class FlameParticleType extends ParticleType<FlameParticleData> {
  private static boolean ALWAYS_SHOW_REGARDLESS_OF_DISTANCE_FROM_PLAYER = false;
  public FlameParticleType() {
    super(ALWAYS_SHOW_REGARDLESS_OF_DISTANCE_FROM_PLAYER, FlameParticleData.DESERIALIZER);
  }
@Override
public Codec<FlameParticleData> func_230522_e_() {
	// TODO Auto-generated method stub
	return null;
}
}