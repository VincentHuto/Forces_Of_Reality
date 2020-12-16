package com.huto.hutosmod.capabilities.vibes.chunk;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;

public interface IChunkVibrations {

	/**
	 * Get the {@link World} containing this instance's chunk.
	 *
	 * @return The World
	 */
	World getWorld();

	/**
	 * Get the {@link ChunkPos} of this instance's chunk.
	 *
	 * @return The chunk position
	 */
	ChunkPos getChunkPos();

	/**
	 * Adds energy to the storage. Returns quantity of energy that was accepted.
	 *
	 * @param maxReceive Maximum amount of energy to be inserted.
	 * @param simulate   If TRUE, the insertion will only be simulated.
	 * @return Amount of energy that was (or would have been, if simulated) accepted
	 *         by the storage.
	 */
	void receiveEnergy(int maxReceive);

	/**
	 * Removes energy from the storage. Returns quantity of energy that was removed.
	 *
	 * @param maxExtract Maximum amount of energy to be extracted.
	 * @param simulate   If TRUE, the extraction will only be simulated.
	 * @return Amount of energy that was (or would have been, if simulated)
	 *         extracted from the storage.
	 */
	void extractEnergy(int maxExtract);

	/**
	 * Returns the amount of energy currently stored.
	 */
	int getEnergyStored();

	/**
	 * Returns the maximum amount of energy that can be stored.
	 */
	int getMaxEnergyStored();

	/**
	 * Returns if this storage can have energy extracted. If this is false, then any
	 * calls to extractEnergy will return 0.
	 */
	boolean canExtract();

	/**
	 * Used to determine if this storage can receive energy. If this is false, then
	 * any calls to receiveEnergy will return 0.
	 */
	boolean canReceive();

	void setEnergy(int int1);

	void onEnergyChanged();

}