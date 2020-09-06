package com.huto.hutosmod.particles;

import com.huto.hutosmod.HutosMod;

import net.minecraft.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/**
 * User: The Grey Ghost
 * Date: 24/12/2014
 *
 * The Startup classes for this example are called during startup
 *  See MinecraftByExample class for more information
 */
@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD,value = Dist.CLIENT)
public class ParticleStartupServerOnly
{
  public static ParticleType<FlameParticleData> flameParticleType;

  @SubscribeEvent
  public static void onIParticleTypeRegistration(RegistryEvent.Register<ParticleType<?>> iParticleTypeRegisterEvent) {
    flameParticleType = new FlameParticleType();
    flameParticleType.setRegistryName("hutosmod:mbe50_flame_particle");
    iParticleTypeRegisterEvent.getRegistry().register(flameParticleType);
  }

}