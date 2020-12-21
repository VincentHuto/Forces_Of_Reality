package com.huto.forces_of_reality.events;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.network.PacketHandler;
import com.huto.forces_of_reality.network.coven.PacketDirectorToggleFlightMode;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class SparkDirectorModEvents {

	
	public static void onClientTick(TickEvent.ClientTickEvent event) {
		if (ClientEventSubscriber.keyBinds.get(2).isPressed()) {
			PacketHandler.MECHANGLOVE.sendToServer(new PacketDirectorToggleFlightMode());
		}
	}
	
	
	
}
