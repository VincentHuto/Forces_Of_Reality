package com.huto.forcesofreality.capabilitie.covenant;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CovenantStorage implements IStorage<ICovenant> {

	@Override
	public CompoundTag writeNBT(Capability<ICovenant> capability, ICovenant instance, Direction side) {
		CompoundTag covenTag = new CompoundTag();
		for (EnumCovenants key : instance.getDevotion().keySet()) {
			if (instance.getDevotion().get(key) != null) {
				covenTag.putInt(key.toString(), instance.getDevotion().get(key));
			} else {
				covenTag.putInt(key.toString(), 0);

			}
		}
		return covenTag;
	}

	@Override
	public void readNBT(Capability<ICovenant> capability, ICovenant instance, Direction side, Tag nbt) {
		if (!(instance instanceof Covenant))
			throw new IllegalArgumentException(
					"Can not deserialize to an instance that isn't the default implementation");
		CompoundTag test = (CompoundTag) nbt;
		for (EnumCovenants coven : EnumCovenants.values()) {
			instance.getDevotion().put(coven, test.getInt(coven.toString()));
		}
	}

}
