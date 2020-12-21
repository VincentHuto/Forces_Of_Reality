package com.huto.forces_of_reality.capabilities.vibes.chunk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huto.forces_of_reality.ForcesOfReality;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.ChunkWatchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ChunkVibrationEvents {
	@SubscribeEvent
	public static void attachChunkCapabilities(final AttachCapabilitiesEvent<Chunk> event) {
		final Chunk chunk = event.getObject();

		final IChunkVibrations chunkEnergy = new ChunkVibrations(ChunkVibrationProvider.DEFAULT_CAPACITY,
				chunk.getWorld(), chunk.getPos());
		event.addCapability(new ResourceLocation(ForcesOfReality.MOD_ID, "chunk_energy"), new SerializableCapabilityProvider<>(
				ChunkVibrationProvider.CHUNK_ENERGY_CHUNK_CAPABILITY, null, chunkEnergy));

	}

	@SubscribeEvent
	public static void chunkTick(ChunkEvent event) {
		/*
		 * IChunkVibrations chunkVibe = ((Chunk) event.getChunk())
		 * .getCapability(ChunkVibrationProvider.CHUNK_ENERGY_CHUNK_CAPABILITY)
		 * .orElseThrow(NullPointerException::new);
		 * //System.out.println(chunkVibe.getEnergyStored()); if (chunkVibe.canReceive()
		 * && event.getWorld().getRandom().nextInt(11) == 10) {
		 * chunkVibe.receiveEnergy(1); System.out.println("BEANS");
		 * PacketHandler.CHANNELVIBES.send(PacketDistributor.TRACKING_CHUNK.with(() ->
		 * (Chunk) event.getChunk()), new UpdateChunkEnergyValueMessage(chunkVibe)); }
		 */
	}

	@SubscribeEvent
	public static void playerTick(PlayerTickEvent event) {
		PlayerEntity player = event.player;
		World world = player.world;
		ChunkPos currentChunkPos = world.getChunkAt(player.getPosition()).getPos();
		List<ChunkPos> chunkList = new ArrayList<ChunkPos>();
		if (!chunkList.contains(currentChunkPos)) {
			chunkList.add(currentChunkPos);
		}
		int range = 16;
		for (int x = 0; x < range; x++) {
			for (int z = 0; z < range; z++) {
				ChunkPos posChunk = new ChunkPos(currentChunkPos.x + x, currentChunkPos.z + z);
				if (!chunkList.contains(posChunk)) {
					chunkList.add(posChunk);
				}
				ChunkPos negChunk = new ChunkPos(currentChunkPos.x - x, currentChunkPos.z - z);
				if (!chunkList.contains(negChunk)) {
					chunkList.add(negChunk);
				}
			}
		}

		if (!world.isRemote) {
			ServerWorld sWorld = (ServerWorld) world;
			Iterator<ChunkPos> itr = chunkList.iterator();

			while (itr.hasNext()) {
				ChunkPos cPos = itr.next();
				if (sWorld.getChunkProvider().isChunkLoaded(cPos)) {
					// System.out.println(chunkList.size());
					IChunkVibrations chunkVibe = sWorld.getChunk(cPos.x, cPos.z)
							.getCapability(ChunkVibrationProvider.CHUNK_ENERGY_CHUNK_CAPABILITY)
							.orElseThrow(NullPointerException::new);
					if (chunkVibe.canReceive() && player.world.rand.nextInt(11) % 2 == 0) {
						chunkVibe.receiveEnergy(1);

					}

				} else {

					itr.remove();
				}
			}
		}
	}

	@SubscribeEvent
	public static void chunkWatch(ChunkWatchEvent.Watch event) {
	}
}
