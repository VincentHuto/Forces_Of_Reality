package com.huto.forces_of_reality.particles.types;

import com.huto.forces_of_reality.particles.data.ColoredDynamicTypeData;
import com.mojang.serialization.Codec;
import net.minecraft.particles.ParticleType;

public class SparkleParticleType extends ParticleType<ColoredDynamicTypeData> {
	public SparkleParticleType() {
        super(false, ColoredDynamicTypeData.DESERIALIZER);
    }

    @Override
    public Codec<ColoredDynamicTypeData> func_230522_e_() {
        return ColoredDynamicTypeData.CODEC;
    }
}