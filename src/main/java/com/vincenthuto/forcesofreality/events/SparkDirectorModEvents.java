package com.vincenthuto.forcesofreality.events;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.network.PacketHandler;
import com.vincenthuto.forcesofreality.network.coven.PacketDirectorToggleFlightMode;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class SparkDirectorModEvents {

	public static void onClientTick(TickEvent.ClientTickEvent event) {
		if (ClientEventSubscriber.keyBinds.get(1).consumeClick()) {
			PacketHandler.MECHANGLOVE.sendToServer(new PacketDirectorToggleFlightMode());
		}

	}

}
