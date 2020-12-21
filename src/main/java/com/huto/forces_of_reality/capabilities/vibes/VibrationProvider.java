package com.huto.forces_of_reality.capabilities.vibes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.FloatNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class VibrationProvider implements ICapabilitySerializable<FloatNBT> {
	@CapabilityInject(IVibrations.class)
	public static final Capability<IVibrations> VIBE_CAPA = null;
	private LazyOptional<IVibrations> instance = LazyOptional.of(VIBE_CAPA::getDefaultInstance);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		return VIBE_CAPA.orEmpty(cap, instance);

	}

	@Override
	public FloatNBT serializeNBT() {
		return (FloatNBT) VIBE_CAPA.getStorage().writeNBT(VIBE_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	@Override
	public void deserializeNBT(FloatNBT nbt) {
		VIBE_CAPA.getStorage().readNBT(VIBE_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);

	}

	public static float getPlayerVibes(PlayerEntity player) {
		return player.getCapability(VIBE_CAPA).orElseThrow(IllegalStateException::new).getVibes();
	}

}
