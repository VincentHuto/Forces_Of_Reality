package com.huto.forcesofreality.network.vibes;

import java.util.Optional;
import java.util.function.Supplier;

import com.huto.forcesofreality.capabilities.vibes.chunk.ChunkVibrationProvider;
import com.huto.forcesofreality.capabilities.vibes.chunk.ChunkVibrations;
import com.huto.forcesofreality.capabilities.vibes.chunk.IChunkVibrations;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.LogicalSidedProvider;
import net.minecraftforge.fml.network.NetworkEvent;

/**
 * Sent from the server to update the energy value of an
 * {@link IChunkVibrations}.
 *
 * @author Choonster
 */
public class UpdateChunkEnergyValueMessage {
	/**
	 * The position of the {@link IChunkVibrations}'s chunk.
	 */
	private final ChunkPos chunkPos;

	/**
	 * The new energy value.
	 */
	private final int energy;

	public UpdateChunkEnergyValueMessage(final IChunkVibrations chunkEnergy) {
		chunkPos = chunkEnergy.getChunkPos();
		energy = chunkEnergy.getEnergyStored();
	}

	private UpdateChunkEnergyValueMessage(final ChunkPos chunkPos, final int energy) {
		this.chunkPos = chunkPos;
		this.energy = energy;
	}

	public static UpdateChunkEnergyValueMessage decode(final PacketBuffer buffer) {
		return new UpdateChunkEnergyValueMessage(new ChunkPos(buffer.readInt(), buffer.readInt()), buffer.readInt());
	}

	public static void encode(final UpdateChunkEnergyValueMessage message, final PacketBuffer buffer) {
		buffer.writeInt(message.chunkPos.x);
		buffer.writeInt(message.chunkPos.z);
		buffer.writeInt(message.energy);
	}

	public static void handle(final UpdateChunkEnergyValueMessage message, final Supplier<NetworkEvent.Context> ctx) {
		ctx.get().enqueueWork(() -> {
			final Optional<World> optionalWorld = LogicalSidedProvider.CLIENTWORLD
					.get(ctx.get().getDirection().getReceptionSide());

			optionalWorld.ifPresent(
					world -> ChunkVibrationProvider.getChunkEnergy(world, message.chunkPos).ifPresent(chunkEnergy -> {
						if (!(chunkEnergy instanceof ChunkVibrations)) {
							return;
						}
						((ChunkVibrations) chunkEnergy).setEnergy(message.energy);
					}));
		});

		ctx.get().setPacketHandled(true);
	}
}