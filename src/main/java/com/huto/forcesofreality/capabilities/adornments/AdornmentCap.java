package com.huto.forcesofreality.capabilities.adornments;

import java.util.concurrent.Callable;

import javax.annotation.Nullable;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

public class AdornmentCap {

    public static class IAdornmentStorage implements Capability.IStorage<IAdornment> {

        @Nullable
        @Override
        public INBT writeNBT(Capability<IAdornment> capability, IAdornment instance, Direction side) {
            return null;
        }

        @Override
        public void readNBT(Capability<IAdornment> capability, IAdornment instance, Direction side, INBT nbt) {

        }
    }

    public static class IAdornmentFactory implements Callable<IAdornment> {

        @Override
        public IAdornment call() {
            return () -> AdornmentType.OVERRIDE;
        }
    }
}
