package com.huto.hutosmod.network;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.huto.hutosmod.capabilities.covenant.CovenantProvider;
import com.huto.hutosmod.capabilities.covenant.EnumCovenants;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class CovenantPacketServer {
	private Map<EnumCovenants, Integer> devotion = new HashMap<>();

	public CovenantPacketServer(Map<EnumCovenants, Integer> devotionIn) {
		this.devotion = devotionIn;
	}

	// This code only runs on the client
	@SuppressWarnings("unused")
	public static void handle(final CovenantPacketServer msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayerEntity sender = ctx.get().getSender(); // the client that sent this packet
			Minecraft.getInstance().player.getCapability(CovenantProvider.COVEN_CAPA)
					.orElseThrow(IllegalStateException::new).setDevotion(msg.devotion);
		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final CovenantPacketServer msg, final PacketBuffer packetBuffer) {
		CompoundNBT covenTag = new CompoundNBT();
		for (EnumCovenants key : EnumCovenants.values()) {
			if (msg.devotion.get(key) != null) {
				covenTag.putInt(key.toString(), msg.devotion.get(key));
				packetBuffer.writeCompoundTag(covenTag);
			} else {
				covenTag.putInt(key.toString(), 0);
				packetBuffer.writeCompoundTag(covenTag);

			}
		}
	}

	public static CovenantPacketServer decode(final PacketBuffer packetBuffer) {
		Map<EnumCovenants, Integer> devo = new HashMap<>();
		for (EnumCovenants key : EnumCovenants.values()) {
			devo.put(key, packetBuffer.readCompoundTag().getInt(key.toString()));
		}
		return new CovenantPacketServer(devo);
	}
}