package com.huto.hutosmod.particles.glow;

import com.huto.hutosmod.HutosMod;

import net.minecraft.client.Minecraft;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModParticles {
	
	//TODO CLEAN THIS UP AND SWITCH TO DIFFERED REGISTRY
	@ObjectHolder(HutosMod.MOD_ID + ":" + GlowParticleData.NAME)
	public static ParticleType<ColorParticleTypeData> GLOW_TYPE;
	@ObjectHolder(HutosMod.MOD_ID + ":" + ParticleLineData.NAME)
	public static ParticleType<ColoredDynamicTypeData> LINE_TYPE;
	@ObjectHolder(HutosMod.MOD_ID + ":" + ParticleSparkleData.NAME)
	public static ParticleType<ColoredDynamicTypeData> SPARKLE_TYPE;

	@SubscribeEvent
	public static void registerParticles(RegistryEvent.Register<ParticleType<?>> event) {
		System.out.println("Rendering particles");
		IForgeRegistry<ParticleType<?>> r = event.getRegistry();
		r.register(new GlowParticleType().setRegistryName(GlowParticleData.NAME));
		r.register(new LineParticleType().setRegistryName(ParticleLineData.NAME));
		r.register(new GlowParticleType().setRegistryName(ParticleSparkleData.NAME));

	}
	


	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void registerFactories(ParticleFactoryRegisterEvent evt) {
		System.out.println("Rendering factories");
		Minecraft.getInstance().particles.registerFactory(GLOW_TYPE, GlowParticleData::new);
		Minecraft.getInstance().particles.registerFactory(LINE_TYPE, ParticleLineData::new);
		Minecraft.getInstance().particles.registerFactory(SPARKLE_TYPE, ParticleSparkleData::new);

	}

}