package com.huto.forces_of_reality.events;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.containers.ContainerRuneBinder;
import com.huto.forces_of_reality.network.PacketHandler;
import com.huto.forces_of_reality.network.mindrunes.PacketBinderTogglePickup;
import com.huto.forces_of_reality.objects.items.tools.ItemRuneBinder;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class RuneBinderEvents {

	public static void pickupEvent(EntityItemPickupEvent event) {
		if (event.getPlayer().openContainer instanceof ContainerRuneBinder || event.getPlayer().isSneaking()
				|| event.getItem().getItem().getItem() instanceof ItemRuneBinder)
			return;
		PlayerInventory playerInv = event.getPlayer().inventory;
		for (int i = 0; i <= 8; i++) {
			ItemStack stack = playerInv.getStackInSlot(i);
			if (stack.getItem() instanceof ItemRuneBinder
					&& ((ItemRuneBinder) stack.getItem()).pickupEvent(event, stack)) {
				event.setResult(Event.Result.ALLOW);
				return;
			}
		}
	}

	public static void onClientTick(TickEvent.ClientTickEvent event) {
		if (ClientEventSubscriber.keyBinds.get(0).isPressed())
			PacketHandler.RUNEBINDER.sendToServer(new PacketBinderTogglePickup());
	}
	
	

}
