package com.huto.forcesofreality.capabilities.tiledevotion;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class DevotionProvider implements ICapabilitySerializable<IntNBT> {
	@CapabilityInject(IDevotion.class)
	public static final Capability<IDevotion> DEVO_CAPA = null;
	private LazyOptional<IDevotion> instance = LazyOptional.of(DEVO_CAPA::getDefaultInstance);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		return DEVO_CAPA.orEmpty(cap, instance);

	}

	
	@Override
	public IntNBT serializeNBT() {
		return (IntNBT) DEVO_CAPA.getStorage().writeNBT(DEVO_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	@Override
	public void deserializeNBT(IntNBT nbt) {
		DEVO_CAPA.getStorage().readNBT(DEVO_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);

	}

	public static int getPlayerDevotion(PlayerEntity player) {
		return player.getCapability(DEVO_CAPA).orElseThrow(IllegalStateException::new).getDevotion();
	}

}
