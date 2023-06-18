package com.vincenthuto.forcesofreality.common.network.coven;
//package com.vincenthuto.forcesofreality.network.coven;
//
//import java.util.function.Supplier;
//
//import com.vincenthuto.forcesofreality.capa.covenant.CovenantProvider;
//import com.vincenthuto.forcesofreality.capa.covenant.ICovenant;
//import com.vincenthuto.forcesofreality.network.PacketHandler;
//
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraftforge.network.NetworkEvent;
//import net.minecraftforge.network.PacketDistributor;
//
//public class CovenantUpdateMorphPacket {
//
//	public CovenantUpdateMorphPacket() {
//
//	}
//
//	public static void handle(final CovenantUpdateMorphPacket msg, Supplier<NetworkEvent.Context> ctx) {
//		ctx.get().enqueueWork(() -> {
//			ServerPlayer sender = ctx.get().getSender(); // the client that sent this packet
//			if (sender != null) {
//				ICovenant covenant = sender.getCapability(CovenantProvider.COVEN_CAPA)
//						.orElseThrow(IllegalStateException::new);
//				PacketHandler.CHANNELCOVENANT.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> sender),
//						new PacketCovenantServer(covenant.getDevotion()));
//			}
//		});
//		ctx.get().setPacketHandled(true);
//	}
//
//	public static void encode(final CovenantUpdateMorphPacket msg, final FriendlyByteBuf packetBuffer) {
//
//	}
//
//	public static CovenantUpdateMorphPacket decode(final FriendlyByteBuf packetBuffer) {
//		return new CovenantUpdateMorphPacket();
//	}
//}