package com.vincenthuto.forcesofreality.network.coven;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.vincenthuto.forcesofreality.capa.covenant.CovenantProvider;
import com.vincenthuto.forcesofreality.capa.covenant.EnumCovenants;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

public class SyncCovenPacket {

	private Map<EnumCovenants, Integer> devotion = new HashMap<>();
	private final int entityID;

	public SyncCovenPacket(Map<EnumCovenants, Integer> devotionIn, int entityID) {
		this.devotion = devotionIn;
		this.entityID = entityID;
	}

	public static SyncCovenPacket decode(final FriendlyByteBuf packetBuffer) {
		Map<EnumCovenants, Integer> devo = new HashMap<>();
		for (EnumCovenants key : EnumCovenants.values()) {
			devo.put(key, packetBuffer.readNbt().getInt(key.toString()));

		}
		int entID = packetBuffer.readInt();
		return new SyncCovenPacket(devo, entID);
	}

	public static void encode(final SyncCovenPacket msg, final FriendlyByteBuf packetBuffer) {
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
		packetBuffer.writeInt(msg.entityID);
	}

	public static void handle(SyncCovenPacket msg, Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			Player player = ctx.get().getSender();
			if (player != null) {
				Entity entity = player.level.getEntity(msg.entityID);
				if (entity instanceof Player) {
					entity.getCapability(CovenantProvider.COVEN_CAPA)
							.ifPresent(covens -> covens.setDevotion(msg.devotion));
				}
			}
		});
		ctx.get().setPacketHandled(true);

	}
}