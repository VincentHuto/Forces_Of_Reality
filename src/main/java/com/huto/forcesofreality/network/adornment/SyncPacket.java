package com.huto.forcesofreality.network.adornment;

import java.util.function.Supplier;

import com.huto.forcesofreality.capabilitie.adornment.AdornmentsCapabilities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.network.NetworkEvent;

public class SyncPacket {

    public int playerId;
    public byte slot;
    ItemStack adornment;

    public SyncPacket(FriendlyByteBuf buf) {
        this.playerId = buf.readInt();
        this.slot = buf.readByte();
        this.adornment = buf.readItemStack();
    }

    public SyncPacket(int playerId, byte slot, ItemStack adornment) {
        this.playerId = playerId;
        this.slot = slot;
        this.adornment = adornment;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeInt(this.playerId);
        buf.writeByte(this.slot);
        buf.writeItemStack(this.adornment);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Entity p = Minecraft.getInstance().world.getEntityByID(playerId);
            if (p instanceof PlayerEntity) {
                p.getCapability(AdornmentsCapabilities.ADORNMENTS).ifPresent(b -> {
                    b.setStackInSlot(slot, adornment);
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
