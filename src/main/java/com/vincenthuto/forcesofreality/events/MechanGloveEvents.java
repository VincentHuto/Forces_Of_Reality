package com.vincenthuto.forcesofreality.events;

import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.container.ContainerMechanGlove;
import com.vincenthuto.forcesofreality.item.coven.tool.ItemMechanGlove;
import com.vincenthuto.hutoslib.client.HLClientUtils;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.MOD)
public class MechanGloveEvents {
	public static void pickupEvent(PlayerTickEvent event) {
		if (event.player.containerMenu instanceof ContainerMechanGlove || event.player.isShiftKeyDown()) {
			return;
		}
		Inventory playerInv = event.player.getInventory();
		for (int i = 0; i <= 8; i++) {
			ItemStack stack = playerInv.getItem(i);
			if (stack.getItem() instanceof ItemMechanGlove) {
				event.setResult(Event.Result.ALLOW);
				return;
			}
		}
	}

	public static void onClientTick(TickEvent.ClientTickEvent event) {
		if (ClientEventSubscriber.keyBinds.get(0).consumeClick()) {
			if (ForcesOfReality.findMechanGlove(HLClientUtils.getClientPlayer()) != ItemStack.EMPTY
					&& ForcesOfReality.findMechanGlove(HLClientUtils.getClientPlayer()) != null)
				ForcesOfReality.proxy.openMechanGui();
		}
	}

}
