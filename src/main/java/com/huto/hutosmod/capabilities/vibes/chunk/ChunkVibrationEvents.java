package com.huto.hutosmod.capabilities.vibes.chunk;

import java.util.Iterator;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.network.PacketHandler;
import com.huto.hutosmod.network.vibes.UpdateChunkEnergyValueMessage;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent.WorldTickEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.PacketDistributor;

public class ChunkVibrationEvents {
	@SubscribeEvent
	public static void attachChunkCapabilities(final AttachCapabilitiesEvent<Chunk> event) {
		final Chunk chunk = event.getObject();

		final IChunkVibrations chunkEnergy = new ChunkVibrations(ChunkVibrationProvider.DEFAULT_CAPACITY,
				chunk.getWorld(), chunk.getPos());
		event.addCapability(new ResourceLocation(HutosMod.MOD_ID, "chunk_energy"), new SerializableCapabilityProvider<>(
				ChunkVibrationProvider.CHUNK_ENERGY_CHUNK_CAPABILITY, null, chunkEnergy));

	}

	@SubscribeEvent
	public static void worldTick(ChunkEvent e) {
		if (e.getWorld().getChunkProvider().isChunkLoaded(e.getChunk().getPos())) {
			IChunkVibrations chunkVibe = ((Chunk) e.getChunk())
					.getCapability(ChunkVibrationProvider.CHUNK_ENERGY_CHUNK_CAPABILITY)
					.orElseThrow(NullPointerException::new);
			System.out.println(chunkVibe.getEnergyStored());
			if (chunkVibe.canReceive()) {
				System.out.println("tv");

				chunkVibe.receiveEnergy(1);
				PacketHandler.CHANNELVIBES.send(PacketDistributor.TRACKING_CHUNK.with(() ->(Chunk)e.getChunk()),
						new UpdateChunkEnergyValueMessage(chunkVibe));
			}
		}
	}

	@SubscribeEvent
	public static void chunkTick(LivingEvent event) {
	/*	IChunkVibrations chunkVibe = event.getEntityLiving().world.getChunkAt(event.getEntityLiving().getPosition())
				.getCapability(ChunkVibrationProvider.CHUNK_ENERGY_CHUNK_CAPABILITY)
				.orElseThrow(NullPointerException::new);
		// System.out.println(chunkVibe.getEnergyStored());
		if (chunkVibe.canReceive()) {
			chunkVibe.receiveEnergy(1);
		}*/
	}

}
