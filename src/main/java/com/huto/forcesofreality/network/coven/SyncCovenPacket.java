package com.huto.forcesofreality.network.coven;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.huto.forcesofreality.capabilitie.covenant.CovenantProvider;
import com.huto.forcesofreality.capabilitie.covenant.EnumCovenants;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.network.NetworkEvent;

public class SyncCovenPacket {

	private Map<EnumCovenants, Integer> devotion = new HashMap<>();
	private final int entityID;

	public SyncCovenPacket(Map<EnumCovenants, Integer> devotionIn, int entityID) {
		this.devotion = devotionIn;
		this.entityID = entityID;
	}

	public SyncCovenPacket(FriendlyByteBuf packetBuffer) {
		Map<EnumCovenants, Integer> devo = new HashMap<>();
		for (EnumCovenants key : EnumCovenants.values()) {
			devo.put(key, packetBuffer.readCompoundTag().getInt(key.toString()));

		}
		this.devotion = devo;
		this.entityID = packetBuffer.readInt();
	}

	public void encode(PacketBuffer packetBuffer) {
		CompoundNBT covenTag = new CompoundNBT();
		for (EnumCovenants key : EnumCovenants.values()) {
			if (devotion.get(key) != null) {
				covenTag.putInt(key.toString(), devotion.get(key));
				packetBuffer.writeCompoundTag(covenTag);
			} else {
				covenTag.putInt(key.toString(), 0);
				packetBuffer.writeCompoundTag(covenTag);

			}
		}
		packetBuffer.writeInt(entityID);
	}

	public void handle(Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			PlayerEntity player = ctx.get().getSender();
			if (player != null) {
				Entity entity = player.world.getEntityByID(entityID);
				if (entity instanceof PlayerEntity) {
					entity.getCapability(CovenantProvider.COVEN_CAPA).ifPresent(covens -> covens.setDevotion(devotion));
				}
			}
		});
		ctx.get().setPacketHandled(true);

	}
}