package com.huto.hutosmod.events;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderLaserWithItem {

	@SubscribeEvent
	public static void renderWorldLastEvent(RenderWorldLastEvent evt) {

		List<AbstractClientPlayerEntity> players = Minecraft.getInstance().world.getPlayers();
		PlayerEntity myplayer = Minecraft.getInstance().player;
		for (PlayerEntity player : players) {
			if (player.getDistanceSq(myplayer) > 500)
				continue;

			// ItemStack heldItem = new ItemStack(ItemInit.frequency_matcher.get());
			/*
			 * if (heldItem.getItem() instanceof ItemFrequencyMatcher) {
			 * RenderMiningLaser2.renderLaser(evt, player,
			 * Minecraft.getInstance().getRenderPartialTicks()); }
			 */
		}
	}

}