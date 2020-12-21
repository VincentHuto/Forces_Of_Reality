package com.huto.forces_of_reality.capabilities.vibes.chunk;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ChunkVibrationProvider implements ICapabilitySerializable<IntNBT> {
	@CapabilityInject(IChunkVibrations.class)
	public static final Capability<IChunkVibrations> CHUNK_ENERGY_CHUNK_CAPABILITY = null;
	private LazyOptional<IChunkVibrations> instance = LazyOptional
			.of(CHUNK_ENERGY_CHUNK_CAPABILITY::getDefaultInstance);

	public static final Direction DEFAULT_FACING = null;
	public static final int DEFAULT_CAPACITY = 256;

	public static LazyOptional<IChunkVibrations> getChunkEnergy(final World world, final ChunkPos chunkPos) {
		return getChunkEnergy(world.getChunk(chunkPos.x, chunkPos.z));
	}

	public static LazyOptional<IChunkVibrations> getChunkEnergy(final Chunk chunk) {
		return chunk.getCapability(CHUNK_ENERGY_CHUNK_CAPABILITY, DEFAULT_FACING);
	}

	
	
	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		return CHUNK_ENERGY_CHUNK_CAPABILITY.orEmpty(cap, instance);

	}

	@Override
	public IntNBT serializeNBT() {
		return (IntNBT) CHUNK_ENERGY_CHUNK_CAPABILITY.getStorage().writeNBT(CHUNK_ENERGY_CHUNK_CAPABILITY,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	@Override
	public void deserializeNBT(IntNBT nbt) {
		CHUNK_ENERGY_CHUNK_CAPABILITY.getStorage().readNBT(CHUNK_ENERGY_CHUNK_CAPABILITY,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);

	}



}