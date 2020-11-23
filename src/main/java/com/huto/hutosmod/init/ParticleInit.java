package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.particles.data.ColorParticleTypeData;
import com.huto.hutosmod.particles.data.ColoredDynamicTypeData;
import com.huto.hutosmod.particles.data.GlowParticleData;
import com.huto.hutosmod.particles.data.ParticleLineData;
import com.huto.hutosmod.particles.data.ParticleSparkleData;
import com.huto.hutosmod.particles.types.GlowParticleType;
import com.huto.hutosmod.particles.types.LineParticleType;
import com.huto.hutosmod.particles.types.SparkleParticleType;

import net.minecraft.client.Minecraft;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleInit {

	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister
			.create(ForgeRegistries.PARTICLE_TYPES, HutosMod.MOD_ID);

	// Wisp
	@ObjectHolder(HutosMod.MOD_ID + ":" + ParticleSparkleData.NAME)
	public static ParticleType<ColoredDynamicTypeData> SPARKLE_TYPE;

	public static final RegistryObject<ParticleType<ColorParticleTypeData>> glow = PARTICLE_TYPES.register("glow",
			() -> new GlowParticleType());
	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> line = PARTICLE_TYPES.register("line",
			() -> new LineParticleType());
	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> sparkle = PARTICLE_TYPES
			.register("sparkle", () -> new SparkleParticleType());

	// Chakra Particles
	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> sahasrara = PARTICLE_TYPES
			.register("sahasrara", () -> new SparkleParticleType());
	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> ajna = PARTICLE_TYPES.register("ajna",
			() -> new SparkleParticleType());
	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> vishuddha = PARTICLE_TYPES
			.register("vishuddha", () -> new SparkleParticleType());
	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> anahata = PARTICLE_TYPES.register("anahata",
			() -> new SparkleParticleType());
	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> manipura = PARTICLE_TYPES
			.register("manipura", () -> new SparkleParticleType());
	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> svadhishthana = PARTICLE_TYPES
			.register("svadhishthana", () -> new SparkleParticleType());
	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> muladharaa = PARTICLE_TYPES
			.register("muladharaa", () -> new SparkleParticleType());

	@SubscribeEvent
	public static void registerParticleFactories(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particles.registerFactory(glow.get(), GlowParticleData::new);
		Minecraft.getInstance().particles.registerFactory(line.get(), ParticleLineData::new);
		Minecraft.getInstance().particles.registerFactory(sparkle.get(), ParticleSparkleData::new);
		// Chakra Colors
		Minecraft.getInstance().particles.registerFactory(sahasrara.get(), ParticleSparkleData::new);
		Minecraft.getInstance().particles.registerFactory(ajna.get(), ParticleSparkleData::new);
		Minecraft.getInstance().particles.registerFactory(vishuddha.get(), ParticleSparkleData::new);
		Minecraft.getInstance().particles.registerFactory(anahata.get(), ParticleSparkleData::new);
		Minecraft.getInstance().particles.registerFactory(manipura.get(), ParticleSparkleData::new);
		Minecraft.getInstance().particles.registerFactory(svadhishthana.get(), ParticleSparkleData::new);
		Minecraft.getInstance().particles.registerFactory(muladharaa.get(), ParticleSparkleData::new);

	}
}