package com.vincenthuto.forcesofreality.network.coven;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.vincenthuto.forcesofreality.capa.covenant.CovenantProvider;
import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

public class PacketCovenantServer {
	private Map<EnumCovenants, Integer> devotion = new HashMap<>();

	public PacketCovenantServer(Map<EnumCovenants, Integer> devotionIn) {
		this.devotion = devotionIn;
	}

	// This code only runs on the client
	@SuppressWarnings("unused")
	public static void handle(final PacketCovenantServer msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			ServerPlayer sender = ctx.get().getSender();
			Minecraft.getInstance().player.getCapability(CovenantProvider.COVEN_CAPA)
					.orElseThrow(IllegalStateException::new).setDevotion(msg.devotion);

		});
		ctx.get().setPacketHandled(true);
	}

	public static void encode(final PacketCovenantServer msg, final FriendlyByteBuf packetBuffer) {
		CompoundTag covenTag = new CompoundTag();
		for (EnumCovenants key : EnumCovenants.values()) {
			if (msg.devotion.get(key) != null) {
				covenTag.putInt(key.toString(), msg.devotion.get(key));
				packetBuffer.writeNbt(covenTag);
			} else {
				covenTag.putInt(key.toString(), 0);
				packetBuffer.writeNbt(covenTag);

			}
		}
	}

	public static PacketCovenantServer decode(final FriendlyByteBuf packetBuffer) {
		Map<EnumCovenants, Integer> devo = new HashMap<>();
		for (EnumCovenants key : EnumCovenants.values()) {
			devo.put(key, packetBuffer.readNbt().getInt(key.toString()));
		}
		return new PacketCovenantServer(devo);
	}
}