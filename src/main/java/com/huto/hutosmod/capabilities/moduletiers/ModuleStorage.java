package com.huto.hutosmod.capabilities.moduletiers;

import net.minecraft.nbt.IntNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ModuleStorage implements IStorage<IModule> {

	@Override
	public INBT writeNBT(Capability<IModule> capability, IModule instance, Direction side) {
		return IntNBT.valueOf(instance.getTier());
	}

	@Override
	public void readNBT(Capability<IModule> capability, IModule instance, Direction side, INBT nbt) {
		   if (!(instance instanceof Module))
	            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
	        instance.setTier(((IntNBT)nbt).getInt());
	    }
}
