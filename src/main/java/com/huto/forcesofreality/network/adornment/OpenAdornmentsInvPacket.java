package com.huto.forcesofreality.network.adornment;

import java.util.function.Supplier;

import com.huto.forcesofreality.gui.adornments.GuiProvider;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.NetworkHooks;

public class OpenAdornmentsInvPacket {

    public OpenAdornmentsInvPacket(FriendlyByteBuf buf) {
    }

    public OpenAdornmentsInvPacket() {
    }

    public void toBytes(FriendlyByteBuf buf) {
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ctx.get().getSender().closeContainer();
            NetworkHooks.openGui(ctx.get().getSender(), new GuiProvider());
        });
        ctx.get().setPacketHandled(true);
    }
}
