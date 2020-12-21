package com.huto.forces_of_reality.capabilities.covenant;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class CovenantProvider implements ICapabilitySerializable<INBT> {
	@CapabilityInject(ICovenant.class)
	public static final Capability<ICovenant> COVEN_CAPA = null;
	private LazyOptional<ICovenant> instance = LazyOptional.of(COVEN_CAPA::getDefaultInstance);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		return COVEN_CAPA.orEmpty(cap, instance);

	}

	@Override
	public INBT serializeNBT() {
		return (INBT) COVEN_CAPA.getStorage().writeNBT(COVEN_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	@Override
	public void deserializeNBT(INBT nbt) {
		COVEN_CAPA.getStorage().readNBT(COVEN_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);

	}

	public static Map<EnumCovenants, Integer> getPlayerDevotion(PlayerEntity player) {
		return player.getCapability(COVEN_CAPA).orElseThrow(IllegalStateException::new).getDevotion();
	}

}
