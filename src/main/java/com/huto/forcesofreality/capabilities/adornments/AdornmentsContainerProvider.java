package com.huto.forcesofreality.capabilities.adornments;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;

public class AdornmentsContainerProvider implements INBTSerializable<CompoundNBT>, ICapabilityProvider {

    private AdornmentsContainer inner;
    private LazyOptional<IAdornmentsItemHandler> opt;

    public AdornmentsContainerProvider(PlayerEntity player) {
        this.inner = new AdornmentsContainer(player);
        this.opt = LazyOptional.of(() -> inner);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, Direction facing) {
        return AdornmentsCapabilities.ADORNMENTS.orEmpty(capability, opt);
    }

    @Override
    public CompoundNBT serializeNBT() {
        return this.inner.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.inner.deserializeNBT(nbt);
    }
}