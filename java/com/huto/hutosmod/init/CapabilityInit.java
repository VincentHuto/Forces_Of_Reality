package com.huto.hutosmod.init;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.capabilities.covenant.Covenant;
import com.huto.hutosmod.capabilities.covenant.CovenantStorage;
import com.huto.hutosmod.capabilities.covenant.ICovenant;
import com.huto.hutosmod.capabilities.karma.IKarma;
import com.huto.hutosmod.capabilities.karma.Karma;
import com.huto.hutosmod.capabilities.karma.KarmaStorage;
import com.huto.hutosmod.capabilities.mindrunes.IRune;
import com.huto.hutosmod.capabilities.mindrunes.IRunesItemHandler;
import com.huto.hutosmod.capabilities.mindrunes.RuneCap;
import com.huto.hutosmod.capabilities.mindrunes.RunestemHandlerCap.IRunesItemHandlerFactory;
import com.huto.hutosmod.capabilities.mindrunes.RunestemHandlerCap.IRunesItemHandlerStorage;
import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationStorage;
import com.huto.hutosmod.capabilities.vibes.Vibrations;

import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD)
public class CapabilityInit {

	public static void init() {
		CapabilityManager.INSTANCE.register(IVibrations.class, new VibrationStorage(), Vibrations::new);
		CapabilityManager.INSTANCE.register(IKarma.class, new KarmaStorage(), Karma::new);
		CapabilityManager.INSTANCE.register(ICovenant.class, new CovenantStorage(), Covenant::new);
		CapabilityManager.INSTANCE.register(IRune.class, new RuneCap.IBaubleStorage(), new RuneCap.IBaubleFactory());
		CapabilityManager.INSTANCE.register(IRunesItemHandler.class, new IRunesItemHandlerStorage(),
				new IRunesItemHandlerFactory());
	}

}
