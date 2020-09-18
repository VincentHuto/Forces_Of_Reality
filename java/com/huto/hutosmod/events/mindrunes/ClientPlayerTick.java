package com.huto.hutosmod.events.mindrunes;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.events.ClientEventSubscriber;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.mindrunes.OpenRunesInvPacket;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HutosMod.MOD_ID, value = Dist.CLIENT)
public class ClientPlayerTick {

    @SubscribeEvent
    public static void playerTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            if (ClientEventSubscriber.KEY_RUNES.isPressed() && Minecraft.getInstance().isGameFocused()) {
                PacketHandler.INSTANCE.sendToServer(new OpenRunesInvPacket());
            }
        }
    }
}