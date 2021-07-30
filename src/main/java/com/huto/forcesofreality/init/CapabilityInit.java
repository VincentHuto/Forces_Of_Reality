package com.huto.forcesofreality.init;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.capabilitie.adornment.IAdornment;
import com.huto.forcesofreality.capabilitie.adornment.IAdornmentsItemHandler;
import com.huto.forcesofreality.capabilitie.adornment.AdornmentCap.IAdornmentFactory;
import com.huto.forcesofreality.capabilitie.adornment.AdornmentCap.IAdornmentStorage;
import com.huto.forcesofreality.capabilitie.adornment.AdornmentsItemHandlerCap.IAdornmentsItemHandlerFactory;
import com.huto.forcesofreality.capabilitie.adornment.AdornmentsItemHandlerCap.IAdornmentsItemHandlerStorage;
import com.huto.forcesofreality.capabilitie.covenant.Covenant;
import com.huto.forcesofreality.capabilitie.covenant.CovenantStorage;
import com.huto.forcesofreality.capabilitie.covenant.ICovenant;
import com.huto.forcesofreality.capabilitie.tiledevotion.Devotion;
import com.huto.forcesofreality.capabilitie.tiledevotion.DevotionStorage;
import com.huto.forcesofreality.capabilitie.tiledevotion.IDevotion;

import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class CapabilityInit {

	public static void init() {
		CapabilityManager.INSTANCE.register(ICovenant.class, new CovenantStorage(), Covenant::new);
		CapabilityManager.INSTANCE.register(IDevotion.class, new DevotionStorage(), Devotion::new);
		CapabilityManager.INSTANCE.register(IAdornment.class, new IAdornmentStorage(), new IAdornmentFactory());
		CapabilityManager.INSTANCE.register(IAdornmentsItemHandler.class, new IAdornmentsItemHandlerStorage(),
				new IAdornmentsItemHandlerFactory());
	}

}
