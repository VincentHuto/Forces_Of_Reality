package com.huto.forcesofreality.capabilities.adornments;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class AdornmentsCapabilities {

    @CapabilityInject(IAdornmentsItemHandler.class)
    public static final Capability<IAdornmentsItemHandler> ADORNMENTS = null;

    @CapabilityInject(IAdornment.class)
    public static final Capability<IAdornment> ITEM_ADORNMENT = null;
}