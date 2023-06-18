package com.vincenthuto.forcesofreality.common.capability.tiledevotion;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.tile.coven.DevotionalBlockEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DevotionEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<BlockEntity> event) {
		if (event.getObject() instanceof DevotionalBlockEntity) {
			event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "devotion"), new DevotionProvider());
		}
	}

}
