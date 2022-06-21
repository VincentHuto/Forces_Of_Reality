package com.vincenthuto.forcesofreality.events.adornments;

import com.vincenthuto.forcesofreality.ForcesOfReality;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ForcesOfReality.MOD_ID, value = Dist.CLIENT)
public class ClientPlayerTick {

	/*
	 * @SubscribeEvent public static void playerTick(TickEvent.ClientTickEvent
	 * event) { if (event.phase == TickEvent.Phase.START) { if
	 * (ClientEventSubscriber.KEY_ADORNMENTS.isPressed() &&
	 * Minecraft.getInstance().isGameFocused()) {
	 * PacketHandler.INSTANCE.sendToServer(new OpenAdornmentsInvPacket()); } } }
	 */
}