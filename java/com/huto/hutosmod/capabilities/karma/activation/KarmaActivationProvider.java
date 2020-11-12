package com.huto.hutosmod.capabilities.karma.activation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class KarmaActivationProvider implements ICapabilitySerializable<IntNBT> {
	@CapabilityInject(IKarmaActivation.class)
	public static final Capability<IKarmaActivation> KARMA_CAPA = null;
	private LazyOptional<IKarmaActivation> instance = LazyOptional.of(KARMA_CAPA::getDefaultInstance);

	@Nonnull
	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		return KARMA_CAPA.orEmpty(cap, instance);

	}

	@Override
	public IntNBT serializeNBT() {
		return (IntNBT) KARMA_CAPA.getStorage().writeNBT(KARMA_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null);
	}

	@Override
	public void deserializeNBT(IntNBT nbt) {
		KARMA_CAPA.getStorage().readNBT(KARMA_CAPA,
				instance.orElseThrow(() -> new IllegalArgumentException("LazyOptional cannot be empty!")), null, nbt);

	}

	public static int getPlayerKarma(PlayerEntity player) {
		return player.getCapability(KARMA_CAPA).orElseThrow(IllegalStateException::new).getActivation();
	}

}
