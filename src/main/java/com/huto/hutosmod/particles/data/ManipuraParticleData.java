package com.huto.hutosmod.particles.data;

import java.util.Random;

import com.huto.hutosmod.init.ParticleInit;
import com.huto.hutosmod.particles.ParticleColor;
import com.huto.hutosmod.particles.ParticleSparkle;

import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.IParticleData;

public class ManipuraParticleData implements IParticleFactory<ColoredDynamicTypeData> {
    private final IAnimatedSprite spriteSet;
    public static final String NAME = "manipura";

    public static final Random random = new Random();
    public ManipuraParticleData(IAnimatedSprite sprite) {
        this.spriteSet = sprite;
    }

    @Override
    public Particle makeParticle(ColoredDynamicTypeData data, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        return new ParticleSparkle(worldIn, x,y,z,xSpeed, ySpeed, zSpeed, data.color.getRed(), data.color.getGreen(), data.color.getBlue(),
                data.scale,
                data.age,  this.spriteSet);
    }

    public static IParticleData createData(ParticleColor color) {
        return new ColoredDynamicTypeData(ParticleInit.manipura.get(), color,.25f,  36);
    }

    public static IParticleData createData(ParticleColor color, float scale, int age) {
        return new ColoredDynamicTypeData(ParticleInit.manipura.get(), color, scale, age);
    }

}