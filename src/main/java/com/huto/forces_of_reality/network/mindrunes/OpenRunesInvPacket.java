package com.huto.forces_of_reality.network.mindrunes;

import java.util.function.Supplier;

import com.huto.forces_of_reality.gui.mindrunes.GuiProvider;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkHooks;

public class OpenRunesInvPacket {

    public OpenRunesInvPacket(PacketBuffer buf) {
    }

    public OpenRunesInvPacket() {
    }

    public void toBytes(PacketBuffer buf) {
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ctx.get().getSender().closeContainer();
            NetworkHooks.openGui(ctx.get().getSender(), new GuiProvider());
        });
        ctx.get().setPacketHandled(true);
    }
}
