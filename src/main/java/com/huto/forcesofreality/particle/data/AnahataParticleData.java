package com.huto.forcesofreality.particle.data;

import java.util.Random;

import com.huto.forcesofreality.init.ParticleInit;
import com.huto.forcesofreality.particle.ParticleSparkle;
import com.hutoslib.client.particle.util.ParticleColor;

import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.particles.IParticleData;

public class AnahataParticleData implements ParticleProvider<ColoredDynamicTypeData> {
    private final SpriteSet spriteSet;
    public static final String NAME = "anahata";

    public static final Random random = new Random();
    public AnahataParticleData(SpriteSet sprite) {
        this.spriteSet = sprite;
    }

    @Override
    public Particle makeParticle(ColoredDynamicTypeData data, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        return new ParticleSparkle(worldIn, x,y,z,xSpeed, ySpeed, zSpeed, data.color.getRed(), data.color.getGreen(), data.color.getBlue(),
                data.scale,
                data.age,  this.spriteSet);
    }

    public static IParticleData createData(ParticleColor color) {
        return new ColoredDynamicTypeData(ParticleInit.anahata.get(), color,.25f,  36);
    }

    public static IParticleData createData(ParticleColor color, float scale, int age) {
        return new ColoredDynamicTypeData(ParticleInit.anahata.get(), color, scale, age);
    }

}