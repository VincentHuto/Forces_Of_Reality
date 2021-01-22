package com.huto.forcesofreality.events;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.containers.ContainerMechanGlove;
import com.huto.forcesofreality.objects.items.coven.tool.ItemMechanGlove;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class MechanGloveEvents {
	public static void pickupEvent(PlayerTickEvent event) {
		if (event.player.openContainer instanceof ContainerMechanGlove || event.player.isSneaking()) {
			return;
		}
		PlayerInventory playerInv = event.player.inventory;
		for (int i = 0; i <= 8; i++) {
			ItemStack stack = playerInv.getStackInSlot(i);
			if (stack.getItem() instanceof ItemMechanGlove) {
				event.setResult(Event.Result.ALLOW);
				return;
			}
		}
	}

	public static void onClientTick(TickEvent.ClientTickEvent event) {
		if (ClientEventSubscriber.keyBinds.get(0).isPressed()) {
			if (ForcesOfReality.findMechanGlove(ClientEventSubscriber.getClientPlayer()) != ItemStack.EMPTY
					&& ForcesOfReality.findMechanGlove(ClientEventSubscriber.getClientPlayer()) != null)
				ForcesOfReality.proxy.openMechanGui();
		}
	}

}
