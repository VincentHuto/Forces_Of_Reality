package com.huto.forces_of_reality.capabilities.vibes;

import net.minecraft.nbt.FloatNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class VibrationStorage implements IStorage<IVibrations> {

	@Override
	public INBT writeNBT(Capability<IVibrations> capability, IVibrations instance, Direction side) {
		return FloatNBT.valueOf(instance.getVibes());
	}

	@Override
	public void readNBT(Capability<IVibrations> capability, IVibrations instance, Direction side, INBT nbt) {
		   if (!(instance instanceof Vibrations))
	            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
	        instance.setVibes(((FloatNBT)nbt).getFloat());
	    }
}
