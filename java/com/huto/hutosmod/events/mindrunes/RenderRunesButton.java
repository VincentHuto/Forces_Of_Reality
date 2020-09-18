package com.huto.hutosmod.events.mindrunes;

import com.huto.hutosmod.gui.mindrunes.RunesButton;

import net.minecraft.client.gui.DisplayEffectsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class RenderRunesButton {

    @SubscribeEvent
    public static void onGuiPostInit(GuiScreenEvent.InitGuiEvent.Post event) {
        Screen screen = event.getGui();
        if (screen instanceof DisplayEffectsScreen) {
            @SuppressWarnings("rawtypes")
			DisplayEffectsScreen displayEffectsScreen = (DisplayEffectsScreen) screen;
            if (event.getWidgetList() != null) {
                event.addWidget(new RunesButton(displayEffectsScreen, 64, 9, 10, 10));
            }
        }
    }
}