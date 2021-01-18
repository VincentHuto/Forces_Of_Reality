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
import com.huto.forcesofreality.capabilities.adornments.IAdornment;
import com.huto.forcesofreality.capabilities.adornments.IAdornmentsItemHandler;
import com.huto.forcesofreality.capabilities.adornments.AdornmentCap.IAdornmentFactory;
import com.huto.forcesofreality.capabilities.adornments.AdornmentCap.IAdornmentStorage;
import com.huto.forcesofreality.capabilities.adornments.AdornmentsItemHandlerCap.IAdornmentsItemHandlerFactory;
import com.huto.forcesofreality.capabilities.adornments.AdornmentsItemHandlerCap.IAdornmentsItemHandlerStorage;
import com.huto.forcesofreality.capabilities.tiledevotion.Devotion;
import com.huto.forcesofreality.capabilities.tiledevotion.DevotionStorage;
import com.huto.forcesofreality.capabilities.tiledevotion.IDevotion;
import com.huto.forcesofreality.capabilities.vibes.IVibrations;
import com.huto.forcesofreality.capabilities.vibes.VibrationStorage;
import com.huto.forcesofreality.capabilities.vibes.Vibrations;
import com.huto.forcesofreality.capabilities.vibes.chunk.ChunkVibrationStorage;
import com.huto.forcesofreality.capabilities.vibes.chunk.IChunkVibrations;
import com.huto.forcesofreality.models.animation.IAnimatable;

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
		CapabilityManager.INSTANCE.register(IAdornment.class, new IAdornmentStorage(), new IAdornmentFactory());
		CapabilityManager.INSTANCE.register(IAdornmentsItemHandler.class, new IAdornmentsItemHandlerStorage(),
				new IAdornmentsItemHandlerFactory());
		CapabilityManager.INSTANCE.register(IChunkVibrations.class, new ChunkVibrationStorage(), () -> null);
		IAnimatable.registerCapability();

	}

}
