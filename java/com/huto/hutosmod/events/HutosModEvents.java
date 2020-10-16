package com.huto.hutosmod.events;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.ItemInit;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.FORGE)
public class HutosModEvents {

	@SubscribeEvent
	public static void overrideTooltips1(ItemTooltipEvent e) {
		if (e.getItemStack().getItem() == ItemInit.yellow_sign.get()) {
			System.out.println("t");
		}
	}
}
