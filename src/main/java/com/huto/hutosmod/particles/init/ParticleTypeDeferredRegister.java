package com.huto.hutosmod.particles.init;

import java.util.function.Supplier;

import com.huto.hutosmod.particles.types.GenericParticleData;

import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.registries.ForgeRegistries;

public class ParticleTypeDeferredRegister extends WrappedDeferredRegister<ParticleType<?>> {

    public ParticleTypeDeferredRegister(String modid) {
        super(modid, ForgeRegistries.PARTICLE_TYPES);
    }

    public ParticleTypeRegistryObject<BasicParticleType> registerBasicParticle(String name) {
        return register(name, () -> new BasicParticleType(false));
    }
    
    public ParticleTypeRegistryObject<GenericParticleData> registerGenericParticle(String name) {
        return register(name, () -> new GenericParticleData(false));
    }

    

    public <PARTICLE extends IParticleData> ParticleTypeRegistryObject<PARTICLE> register(String name, Supplier<ParticleType<PARTICLE>> sup) {
        return register(name, sup, ParticleTypeRegistryObject::new);
    }
}