package com.huto.forces_of_reality.capabilities.tiledevotion;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.objects.tileenties.coven.TileModDevotion;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DevotionEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<TileEntity> event) {
		if (event.getObject() instanceof TileModDevotion) {
			event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "devotion"), new DevotionProvider());
		}
	}

}