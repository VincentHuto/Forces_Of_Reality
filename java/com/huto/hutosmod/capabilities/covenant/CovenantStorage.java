package com.huto.hutosmod.capabilities.covenant;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CovenantStorage implements IStorage<ICovenant> {

	@Override
	public StringNBT writeNBT(Capability<ICovenant> capability, ICovenant instance, Direction side) {
		return StringNBT.valueOf(instance.getCovenant().toString());
	}

	@Override
	public void readNBT(Capability<ICovenant> capability, ICovenant instance, Direction side, INBT nbt) {
		if (!(instance instanceof Covenant))
			throw new IllegalArgumentException(
					"Can not deserialize to an instance that isn't the default implementation");
		instance.setCovenant(EnumCovenants.valueOf(nbt.toString().replace('"', ' ').trim()));

	}

}
