package com.huto.hutosmod.events;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.coven.PacketDirectorToggleFlightMode;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.MOD)
public class SparkDirectorModEvents {

	
	public static void onClientTick(TickEvent.ClientTickEvent event) {
		if (ClientEventSubscriber.keyBinds.get(2).isPressed()) {
			PacketHandler.MECHANGLOVE.sendToServer(new PacketDirectorToggleFlightMode());
		}
	}
	
}
