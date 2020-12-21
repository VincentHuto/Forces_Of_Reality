package com.huto.forces_of_reality.capabilities.karma;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.gui.KarmaHud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class KarmaHudEventHandler {

	public KarmaHudEventHandler() {

	}

	static Minecraft mc = Minecraft.getInstance();

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(receiveCanceled = true)
	public static void onEvent(RenderGameOverlayEvent.Pre event) {
		ClientPlayerEntity entityPlayerSP = Minecraft.getInstance().player;
		if (entityPlayerSP == null) {
			return;
		}
		switch (event.getType()) {
		case ALL:

			KarmaHud karmaHud = new KarmaHud(entityPlayerSP, mc);
			if (entityPlayerSP.isAlive()) {
				karmaHud.renderStatusBar(event.getMatrixStack(), event.getWindow().getScaledWidth(),
						event.getWindow().getScaledHeight(), entityPlayerSP.world,
						entityPlayerSP);
			}
		default: 
			break;
		}
	}

}
