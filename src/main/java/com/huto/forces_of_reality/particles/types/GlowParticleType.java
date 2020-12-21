package com.huto.forces_of_reality.particles.types;

import com.huto.forces_of_reality.particles.data.ColorParticleTypeData;
import com.mojang.serialization.Codec;
import net.minecraft.particles.ParticleType;

public class GlowParticleType extends ParticleType<ColorParticleTypeData> {
    public GlowParticleType() {
        super(false, ColorParticleTypeData.DESERIALIZER);
    }

    @Override
    public Codec<ColorParticleTypeData> func_230522_e_() {
        return ColorParticleTypeData.CODEC;
    }
}