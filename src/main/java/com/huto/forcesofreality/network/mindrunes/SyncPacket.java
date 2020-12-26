package com.huto.forcesofreality.network.mindrunes;

import java.util.function.Supplier;

import com.huto.forcesofreality.capabilities.mindrunes.RunesCapabilities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class SyncPacket {

    public int playerId;
    public byte slot;
    ItemStack bauble;

    public SyncPacket(PacketBuffer buf) {
        this.playerId = buf.readInt();
        this.slot = buf.readByte();
        this.bauble = buf.readItemStack();
    }

    public SyncPacket(int playerId, byte slot, ItemStack bauble) {
        this.playerId = playerId;
        this.slot = slot;
        this.bauble = bauble;
    }

    public void toBytes(PacketBuffer buf) {
        buf.writeInt(this.playerId);
        buf.writeByte(this.slot);
        buf.writeItemStack(this.bauble);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Entity p = Minecraft.getInstance().world.getEntityByID(playerId);
            if (p instanceof PlayerEntity) {
                p.getCapability(RunesCapabilities.RUNES).ifPresent(b -> {
                    b.setStackInSlot(slot, bauble);
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
