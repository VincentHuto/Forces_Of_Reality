package com.huto.hutosmod.capabilities.covenant;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class CovenantProvider implements ICapabilitySerializable<StringNBT> {
	@CapabilityInject(ICovenant.class)
	public static final Capability<ICovenant> COVEN_CAPA = null;
	private LazyOptional<ICovenant> instance = LazyOptional.of(COVEN_CAPA::getDefaultInstance);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		return COVEN_CAPA.orEmpty(cap, instance);

	}

	@Override
	public StringNBT serializeNBT() {
		return (StringNBT) COVEN_CAPA.getStorage().writeNBT(COVEN_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	@Override
	public void deserializeNBT(StringNBT nbt) {
		COVEN_CAPA.getStorage().readNBT(COVEN_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);

	}

	public static EnumCovenants getPlayerCovenant(PlayerEntity player) {
		return player.getCapability(COVEN_CAPA).orElseThrow(IllegalStateException::new).getCovenant();
	}

}
