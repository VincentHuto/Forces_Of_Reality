package com.huto.forcesofreality.network.coven;

import java.util.function.Supplier;

import com.huto.forcesofreality.capabilities.karma.activation.KarmaActivationProvider;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class SyncKarmaPacket {

    private final boolean activ;
    private final int entityID;

    public SyncKarmaPacket(boolean activ, int entityID) {
        this.activ = activ;
        this.entityID = entityID;
    }

    public SyncKarmaPacket(PacketBuffer packetBuffer) {
        this.activ = packetBuffer.readBoolean();
        this.entityID = packetBuffer.readInt();
    }

    public void encode(PacketBuffer buf) {
        buf.writeBoolean(activ);
        buf.writeInt(entityID);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            PlayerEntity player =ctx.get().getSender();
            if(player != null) {
                Entity entity = player.world.getEntityByID(entityID);
                if (entity instanceof PlayerEntity) {
                    entity.getCapability(KarmaActivationProvider.KARMA_CAPA).ifPresent(kar -> kar.setKarmaActivation(activ ? 1:0));
            		ctx.get().setPacketHandled(true);

				}
			}
		});
		ctx.get().setPacketHandled(true);
    }
}