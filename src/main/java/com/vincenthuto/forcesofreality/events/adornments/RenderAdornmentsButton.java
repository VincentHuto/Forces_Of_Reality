package com.vincenthuto.forcesofreality.events.adornments;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class RenderAdornmentsButton {

	// No Longer necccisairy as you cannot acsess runes from INV anymore

	/*
	 * @SubscribeEvent public static void
	 * onGuiPostInit(GuiScreenEvent.InitGuiEvent.Post event) { Screen screen =
	 * event.getGui(); if (screen instanceof DisplayEffectsScreen) {
	 *
	 * @SuppressWarnings("rawtypes") DisplayEffectsScreen displayEffectsScreen =
	 * (DisplayEffectsScreen) screen; if (event.getWidgetList() != null) {
	 * event.addWidget(new AdornmentsButton(displayEffectsScreen, 64, 9, 10, 10)); }
	 * } }
	 */
}