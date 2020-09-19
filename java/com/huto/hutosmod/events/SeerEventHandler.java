package com.huto.hutosmod.events;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.gui.VibrationalSeerHud;
import com.huto.hutosmod.init.ItemInit;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, bus = Bus.FORGE)
public class SeerEventHandler {

	public SeerEventHandler() {

	}

	static Minecraft mc = Minecraft.getInstance();

	@SubscribeEvent(receiveCanceled = true)
	public static void onEvent(RenderGameOverlayEvent.Pre event) {
		ClientPlayerEntity entityPlayerSP = Minecraft.getInstance().player;

		if (entityPlayerSP == null)
			return; // just in case

		boolean foundOnHead = false;
		for (int i = 0; i < 103; ++i) {
			ItemStack slotItemStack = entityPlayerSP.inventory.armorItemInSlot(3);
			if (slotItemStack.getItem() == ItemInit.vibrational_seer.get()) {

				foundOnHead = true;
				break;
			}
		}
		if (!foundOnHead)
			return;

		switch (event.getType()) {
		case ALL:
			VibrationalSeerHud vibrationalSeerHudIn = new VibrationalSeerHud(entityPlayerSP);
			vibrationalSeerHudIn.renderStatusBar(event.getWindow().getScaledWidth(),
					event.getWindow().getScaledHeight(), entityPlayerSP.world,
					entityPlayerSP); /* Call a helper method so that this method stays organized */

		default: // If it's not one of the above cases, do nothing
			break;
		}
	}

}
