package com.huto.hutosmod.particles.types;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SmokeParticle;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;

public class GenericParticle extends SmokeParticle {

	public GenericParticle(ClientWorld world, double posX, double posY, double posZ, double velX, double velY,
			double velZ, float r, float g, float b, float a, int age, IAnimatedSprite sprite) {
		super(world, posX, posY, posZ, velX, velY, velZ, 1.0F, sprite);
		setColor(r, g, b);
		setAlphaF(a);
		setMaxAge(age);

	}

	@Override
	public int getBrightnessForRender(float partialTick) {
		return 190 + (int) (20F * (1.0F - Minecraft.getInstance().gameSettings.gamma));
	}

	@Override
	public void renderParticle(@Nonnull IVertexBuilder vertexBuilder, @Nonnull ActiveRenderInfo renderInfo,
			float partialTicks) {
		if (age > 0) {
			super.renderParticle(vertexBuilder, renderInfo, partialTicks);
		}
	}

	public static class Factory implements IParticleFactory<BasicParticleType> {

		private final IAnimatedSprite spriteSet;

		public Factory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		@Override
		public Particle makeParticle(@Nonnull BasicParticleType type, @Nonnull ClientWorld world, double x, double y,
				double z, double xSpeed, double ySpeed, double zSpeed) {
			return new GenericParticle(world, x, y, z, xSpeed, ySpeed, zSpeed, 0, 0, 0, 100, 100, this.spriteSet);
		}
	}
}