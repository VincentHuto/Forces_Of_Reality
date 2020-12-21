package com.huto.forces_of_reality.init;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.capabilities.covenant.Covenant;
import com.huto.forces_of_reality.capabilities.covenant.CovenantStorage;
import com.huto.forces_of_reality.capabilities.covenant.ICovenant;
import com.huto.forces_of_reality.capabilities.karma.IKarma;
import com.huto.forces_of_reality.capabilities.karma.Karma;
import com.huto.forces_of_reality.capabilities.karma.KarmaStorage;
import com.huto.forces_of_reality.capabilities.karma.activation.IKarmaActivation;
import com.huto.forces_of_reality.capabilities.karma.activation.KarmaActivation;
import com.huto.forces_of_reality.capabilities.karma.activation.KarmaActivationStorage;
import com.huto.forces_of_reality.capabilities.mindrunes.IRune;
import com.huto.forces_of_reality.capabilities.mindrunes.IRunesItemHandler;
import com.huto.forces_of_reality.capabilities.mindrunes.RuneCap.IRuneFactory;
import com.huto.forces_of_reality.capabilities.mindrunes.RuneCap.IRuneStorage;
import com.huto.forces_of_reality.capabilities.mindrunes.RunesItemHandlerCap.IRunesItemHandlerFactory;
import com.huto.forces_of_reality.capabilities.mindrunes.RunesItemHandlerCap.IRunesItemHandlerStorage;
import com.huto.forces_of_reality.capabilities.tiledevotion.Devotion;
import com.huto.forces_of_reality.capabilities.tiledevotion.DevotionStorage;
import com.huto.forces_of_reality.capabilities.tiledevotion.IDevotion;
import com.huto.forces_of_reality.capabilities.vibes.IVibrations;
import com.huto.forces_of_reality.capabilities.vibes.VibrationStorage;
import com.huto.forces_of_reality.capabilities.vibes.Vibrations;
import com.huto.forces_of_reality.capabilities.vibes.chunk.ChunkVibrationStorage;
import com.huto.forces_of_reality.capabilities.vibes.chunk.IChunkVibrations;

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
