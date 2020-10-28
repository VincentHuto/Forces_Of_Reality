package com.huto.hutosmod.capabilities.tiledevotion;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.objects.tileenties.TileModDevotion;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DevotionEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<TileEntity> event) {
		if (event.getObject() instanceof TileModDevotion) {
			System.out.println("Attatches Capability");
			event.addCapability(new ResourceLocation(HutosMod.MOD_ID, "devotion"), new DevotionProvider());
		}
	}

}
