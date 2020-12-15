package com.huto.hutosmod.capabilities.vibes.chunk;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ChunkVibrationStorage implements IStorage<IChunkVibrations> {

	@Override
	public INBT writeNBT(final Capability<IChunkVibrations> capability, final IChunkVibrations instance,
			final Direction side) {
		return IntNBT.valueOf(instance.getEnergyStored());
	}

	@Override
	public void readNBT(Capability<IChunkVibrations> capability, IChunkVibrations instance, Direction side, INBT nbt) {
		if (!(instance instanceof ChunkVibrations))
			throw new IllegalArgumentException(
					"Can not deserialize to an instance that isn't the default implementation");
		((ChunkVibrations) instance).setEnergy(((IntNBT) nbt).getInt());
	}
}
