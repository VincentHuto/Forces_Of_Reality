package com.huto.forcesofreality.init;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.particles.ParticleColor;
import com.huto.forcesofreality.particles.data.AjnaParticleData;
import com.huto.forcesofreality.particles.data.AnahataParticleData;
import com.huto.forcesofreality.particles.data.ColorParticleTypeData;
import com.huto.forcesofreality.particles.data.ColoredDynamicTypeData;
import com.huto.forcesofreality.particles.data.GlowParticleData;
import com.huto.forcesofreality.particles.data.ManipuraParticleData;
import com.huto.forcesofreality.particles.data.MuladharaaParticleData;
import com.huto.forcesofreality.particles.data.ParticleLineData;
import com.huto.forcesofreality.particles.data.ParticleSparkleData;
import com.huto.forcesofreality.particles.data.SahasraraParticleData;
import com.huto.forcesofreality.particles.data.SvadhishthanaParticleData;
import com.huto.forcesofreality.particles.data.VishuddhaParticleData;
import com.huto.forcesofreality.particles.types.GlowParticleType;
import com.huto.forcesofreality.particles.types.LineParticleType;
import com.huto.forcesofreality.particles.types.SparkleParticleType;

import net.minecraft.client.Minecraft;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleInit {

	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister
			.create(ForgeRegistries.PARTICLE_TYPES, ForcesOfReality.MOD_ID);

	public static List<IParticleData> chakraData = new ArrayList<IParticleData>();
	public static List<IParticleData> chakraDataReverse = new ArrayList<IParticleData>();

	// Wisp
	@ObjectHolder(ForcesOfReality.MOD_ID + ":" + ParticleSparkleData.NAME)
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
	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> anahata = PARTICLE_TYPES
			.register("anahata", () -> new SparkleParticleType());
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

		Collections.addAll(chakraData, MuladharaaParticleData.createData(new ParticleColor(229, 60, 81)),
				SvadhishthanaParticleData.createData(new ParticleColor(243, 124, 59)),
				ManipuraParticleData.createData(new ParticleColor(255, 165, 44)),
				AnahataParticleData.createData(new ParticleColor(110, 200, 80)),
				VishuddhaParticleData.createData(new ParticleColor(66, 184, 212)),
				VishuddhaParticleData.createData(new ParticleColor(66, 184, 212)),
				AjnaParticleData.createData(new ParticleColor(96, 96, 186)),
				SahasraraParticleData.createData(new ParticleColor(162, 86, 160)));

		Collections.addAll(chakraDataReverse, SahasraraParticleData.createData(new ParticleColor(162, 86, 160)),
				AjnaParticleData.createData(new ParticleColor(96, 96, 186)),
				VishuddhaParticleData.createData(new ParticleColor(66, 184, 212)),
				AnahataParticleData.createData(new ParticleColor(110, 200, 80)),
				ManipuraParticleData.createData(new ParticleColor(255, 165, 44)),
				SvadhishthanaParticleData.createData(new ParticleColor(243, 124, 59)),
				MuladharaaParticleData.createData(new ParticleColor(229, 60, 81)));
	}
}