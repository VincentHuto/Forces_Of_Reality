package com.huto.hutosmod.capabilities.moduletiers;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.objects.items.modules.ItemMechanModuleBase;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModuleEvents {
	@SubscribeEvent
	public static void attachCapabilitiesEntity(final AttachCapabilitiesEvent<ItemStack> event) {
		if (event.getObject().getItem() instanceof ItemMechanModuleBase) {
			event.addCapability(new ResourceLocation(HutosMod.MOD_ID, "module_tier"),
					new ModuleProvider());
		}
	}


}
