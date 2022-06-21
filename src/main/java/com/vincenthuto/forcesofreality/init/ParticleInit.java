package com.vincenthuto.forcesofreality.init;

import com.vincenthuto.forcesofreality.ForcesOfReality;

import net.minecraft.core.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleInit {

	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister
			.create(ForgeRegistries.PARTICLE_TYPES, ForcesOfReality.MOD_ID);

//	public static List<ParticleOptions> chakraData = new ArrayList<ParticleOptions>();
//	public static List<ParticleOptions> chakraDataReverse = new ArrayList<ParticleOptions>();
//
//	// Wisp
//	@ObjectHolder(ForcesOfReality.MOD_ID + ":" + ParticleSparkleData.NAME)
//	public static ParticleType<ColoredDynamicTypeData> SPARKLE_TYPE;
//	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> sparkle = PARTICLE_TYPES
//			.register("sparkle", () -> new SparkleParticleType());
//
//	// Chakra Particles
//	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> sahasrara = PARTICLE_TYPES
//			.register("sahasrara", () -> new SparkleParticleType());
//	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> ajna = PARTICLE_TYPES.register("ajna",
//			() -> new SparkleParticleType());
//	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> vishuddha = PARTICLE_TYPES
//			.register("vishuddha", () -> new SparkleParticleType());
//	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> anahata = PARTICLE_TYPES
//			.register("anahata", () -> new SparkleParticleType());
//	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> manipura = PARTICLE_TYPES
//			.register("manipura", () -> new SparkleParticleType());
//	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> svadhishthana = PARTICLE_TYPES
//			.register("svadhishthana", () -> new SparkleParticleType());
//	public static final RegistryObject<ParticleType<ColoredDynamicTypeData>> muladharaa = PARTICLE_TYPES
//			.register("muladharaa", () -> new SparkleParticleType());
//
//	@SubscribeEvent
//	public static void registerParticleFactories(ParticleFactoryRegisterEvent event) {
//
//		Minecraft.getInstance().particleEngine.register(sparkle.get(), ParticleSparkleData::new);
//		// Chakra Colors
//		Minecraft.getInstance().particleEngine.register(sahasrara.get(), ParticleSparkleData::new);
//		Minecraft.getInstance().particleEngine.register(ajna.get(), ParticleSparkleData::new);
//		Minecraft.getInstance().particleEngine.register(vishuddha.get(), ParticleSparkleData::new);
//		Minecraft.getInstance().particleEngine.register(anahata.get(), ParticleSparkleData::new);
//		Minecraft.getInstance().particleEngine.register(manipura.get(), ParticleSparkleData::new);
//		Minecraft.getInstance().particleEngine.register(svadhishthana.get(), ParticleSparkleData::new);
//		Minecraft.getInstance().particleEngine.register(muladharaa.get(), ParticleSparkleData::new);
//
//		Collections.addAll(chakraData, MuladharaaParticleData.createData(new ParticleColor(229, 60, 81)),
//				SvadhishthanaParticleData.createData(new ParticleColor(243, 124, 59)),
//				ManipuraParticleData.createData(new ParticleColor(255, 165, 44)),
//				AnahataParticleData.createData(new ParticleColor(110, 200, 80)),
//				VishuddhaParticleData.createData(new ParticleColor(66, 184, 212)),
//				VishuddhaParticleData.createData(new ParticleColor(66, 184, 212)),
//				AjnaParticleData.createData(new ParticleColor(96, 96, 186)),
//				SahasraraParticleData.createData(new ParticleColor(162, 86, 160)));
//
//		Collections.addAll(chakraDataReverse, SahasraraParticleData.createData(new ParticleColor(162, 86, 160)),
//				AjnaParticleData.createData(new ParticleColor(96, 96, 186)),
//				VishuddhaParticleData.createData(new ParticleColor(66, 184, 212)),
//				AnahataParticleData.createData(new ParticleColor(110, 200, 80)),
//				ManipuraParticleData.createData(new ParticleColor(255, 165, 44)),
//				SvadhishthanaParticleData.createData(new ParticleColor(243, 124, 59)),
//				MuladharaaParticleData.createData(new ParticleColor(229, 60, 81)));
//	}
}