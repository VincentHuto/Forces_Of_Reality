package com.huto.forces_of_reality.capabilities.karma;

import net.minecraft.nbt.IntNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class KarmaStorage implements IStorage<IKarma> {

	@Override
	public INBT writeNBT(Capability<IKarma> capability, IKarma instance, Direction side) {
		return IntNBT.valueOf(instance.getKarma());
	}

	@Override
	public void readNBT(Capability<IKarma> capability, IKarma instance, Direction side, INBT nbt) {
		   if (!(instance instanceof Karma))
	            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
	        instance.setKarma(((IntNBT)nbt).getInt());
	    }
}
