package com.huto.forcesofreality.capabilitie.tiledevotion;

import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.Tag;
import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class DevotionStorage implements IStorage<IDevotion> {

	@Override
	public Tag writeNBT(Capability<IDevotion> capability, IDevotion instance, Direction side) {
		return IntTag.valueOf(instance.getDevotion());
	}

	@Override
	public void readNBT(Capability<IDevotion> capability, IDevotion instance, Direction side, Tag nbt) {
		if (!(instance instanceof Devotion))
			throw new IllegalArgumentException(
					"Can not deserialize to an instance that isn't the default implementation");
		instance.setDevotion(((IntTag) nbt).getInt());
	}
}
