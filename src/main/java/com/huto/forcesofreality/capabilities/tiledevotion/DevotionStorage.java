package com.huto.forcesofreality.capabilities.tiledevotion;

import net.minecraft.nbt.IntNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class DevotionStorage implements IStorage<IDevotion> {

	@Override
	public INBT writeNBT(Capability<IDevotion> capability, IDevotion instance, Direction side) {
		return IntNBT.valueOf(instance.getDevotion());
	}

	@Override
	public void readNBT(Capability<IDevotion> capability, IDevotion instance, Direction side, INBT nbt) {
		if (!(instance instanceof Devotion))
			throw new IllegalArgumentException(
					"Can not deserialize to an instance that isn't the default implementation");
		instance.setDevotion(((IntNBT) nbt).getInt());
	}
}
