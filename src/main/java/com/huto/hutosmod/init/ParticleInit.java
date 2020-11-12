package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.particles.init.ParticleTypeDeferredRegister;
import com.huto.hutosmod.particles.init.ParticleTypeRegistryObject;
import com.huto.hutosmod.particles.types.GenericParticle;
import com.huto.hutosmod.particles.types.GenericParticleData;
import com.huto.hutosmod.particles.types.RadiationParticle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleInit {
	public static final ParticleTypeDeferredRegister PARTICLE_TYPES = new ParticleTypeDeferredRegister(HutosMod.MOD_ID);
	
	
	public static final ParticleTypeRegistryObject<GenericParticleData> GENERIC = PARTICLE_TYPES
			.registerGenericParticle("generic");
	public static final ParticleTypeRegistryObject<BasicParticleType> RADIATION = PARTICLE_TYPES
			.registerBasicParticle("radiation");

	public static <T extends IParticleData> void registerParticleFactory(ParticleTypeRegistryObject<T> particleTypeRO,
			ParticleManager.IParticleMetaFactory<T> factory) {
		Minecraft.getInstance().particles.registerFactory(particleTypeRO.getParticleType(), factory);
	}

	@SubscribeEvent
	public static void registerParticleFactories(ParticleFactoryRegisterEvent event) {
		registerParticleFactory(ParticleInit.RADIATION, RadiationParticle.Factory::new);
		registerParticleFactory(ParticleInit.GENERIC, GenericParticle.Factory::new);

	}
}