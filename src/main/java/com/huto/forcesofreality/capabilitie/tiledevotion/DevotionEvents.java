package com.huto.forcesofreality.capabilitie.tiledevotion;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.tile.coven.TileModDevotion;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DevotionEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<BlockEntity> event) {
		if (event.getObject() instanceof TileModDevotion) {
			event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "devotion"), new DevotionProvider());
		}
	}

}
