package com.huto.forcesofreality.init;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.capabilities.covenant.Covenant;
import com.huto.forcesofreality.capabilities.covenant.CovenantStorage;
import com.huto.forcesofreality.capabilities.covenant.ICovenant;
import com.huto.forcesofreality.capabilities.karma.IKarma;
import com.huto.forcesofreality.capabilities.karma.Karma;
import com.huto.forcesofreality.capabilities.karma.KarmaStorage;
import com.huto.forcesofreality.capabilities.karma.activation.IKarmaActivation;
import com.huto.forcesofreality.capabilities.karma.activation.KarmaActivation;
import com.huto.forcesofreality.capabilities.karma.activation.KarmaActivationStorage;
import com.huto.forcesofreality.capabilities.mindrunes.IRune;
import com.huto.forcesofreality.capabilities.mindrunes.IRunesItemHandler;
import com.huto.forcesofreality.capabilities.mindrunes.RuneCap.IRuneFactory;
import com.huto.forcesofreality.capabilities.mindrunes.RuneCap.IRuneStorage;
import com.huto.forcesofreality.capabilities.mindrunes.RunesItemHandlerCap.IRunesItemHandlerFactory;
import com.huto.forcesofreality.capabilities.mindrunes.RunesItemHandlerCap.IRunesItemHandlerStorage;
import com.huto.forcesofreality.capabilities.tiledevotion.Devotion;
import com.huto.forcesofreality.capabilities.tiledevotion.DevotionStorage;
import com.huto.forcesofreality.capabilities.tiledevotion.IDevotion;
import com.huto.forcesofreality.capabilities.vibes.IVibrations;
import com.huto.forcesofreality.capabilities.vibes.VibrationStorage;
import com.huto.forcesofreality.capabilities.vibes.Vibrations;
import com.huto.forcesofreality.capabilities.vibes.chunk.ChunkVibrationStorage;
import com.huto.forcesofreality.capabilities.vibes.chunk.IChunkVibrations;

import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class CapabilityInit {

	public static void init() {
		CapabilityManager.INSTANCE.register(IVibrations.class, new VibrationStorage(), Vibrations::new);
		CapabilityManager.INSTANCE.register(IKarmaActivation.class, new KarmaActivationStorage(), KarmaActivation::new);
		CapabilityManager.INSTANCE.register(IKarma.class, new KarmaStorage(), Karma::new);
		CapabilityManager.INSTANCE.register(ICovenant.class, new CovenantStorage(), Covenant::new);
		CapabilityManager.INSTANCE.register(IDevotion.class, new DevotionStorage(), Devotion::new);
		CapabilityManager.INSTANCE.register(IRune.class, new IRuneStorage(), new IRuneFactory());
		CapabilityManager.INSTANCE.register(IRunesItemHandler.class, new IRunesItemHandlerStorage(),
				new IRunesItemHandlerFactory());
		CapabilityManager.INSTANCE.register(IChunkVibrations.class, new ChunkVibrationStorage(),()->null);

	}

}
