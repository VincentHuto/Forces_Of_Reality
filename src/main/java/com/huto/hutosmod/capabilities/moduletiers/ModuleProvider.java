package com.huto.hutosmod.capabilities.moduletiers;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class ModuleProvider implements ICapabilitySerializable<IntNBT> {
	@CapabilityInject(IModule.class)
	public static final Capability<IModule> TIER_CAPA = null;
	private LazyOptional<IModule> instance = LazyOptional.of(TIER_CAPA::getDefaultInstance);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		return TIER_CAPA.orEmpty(cap, instance);

	}
	@Override
	public IntNBT serializeNBT() {
		return (IntNBT) TIER_CAPA.getStorage().writeNBT(TIER_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}
	@Override
	public void deserializeNBT(IntNBT nbt) {
		TIER_CAPA.getStorage().readNBT(TIER_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);
	}

}
