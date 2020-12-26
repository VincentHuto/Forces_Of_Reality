package com.huto.forcesofreality.capabilities.karma.activation;

import net.minecraft.nbt.IntNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class KarmaActivationStorage implements IStorage<IKarmaActivation> {

	@Override
	public INBT writeNBT(Capability<IKarmaActivation> capability, IKarmaActivation instance, Direction side) {
		return IntNBT.valueOf(instance.getActivation());
	}

	@Override
	public void readNBT(Capability<IKarmaActivation> capability, IKarmaActivation instance, Direction side, INBT nbt) {
		if (!(instance instanceof KarmaActivation))
			throw new IllegalArgumentException(
					"Can not deserialize to an instance that isn't the default implementation");
		instance.setKarmaActivation(((IntNBT) nbt).getInt());
	}
}
