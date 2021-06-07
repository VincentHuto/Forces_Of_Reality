package com.huto.forcesofreality.render.entity.projectile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.projectile.EntityHolySpirit;
import com.hutoslib.client.particle.util.ParticleColor;
import com.hutoslib.client.particle.util.ParticleUtils;
import com.hutoslib.client.particle.factory.GlowParticleFactory;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderHolySpirit extends EntityRenderer<EntityHolySpirit> {

	public RenderHolySpirit(EntityRendererManager renderManager) {
		super(renderManager);
	}

	@Override
	public void render(EntityHolySpirit entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		List<ParticleColor> chakraColors = new ArrayList<ParticleColor>();
		Collections.addAll(chakraColors, new ParticleColor(162, 86, 160), new ParticleColor(96, 96, 186),
				new ParticleColor(66, 184, 212), new ParticleColor(110, 200, 80), new ParticleColor(229, 60, 81),
				new ParticleColor(243, 124, 59));

		World world = entityIn.getEntityWorld();
		BlockPos pos = entityIn.getPosition();
		double time = world.getGameTime() * 0.05f;
		// Random rand = world.rand;
		for (int j = 0; j < 6; j++) {
			world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
					pos.getX() + 0.5 + Math.sin(time + j) + ParticleUtils.inRange(-0.05, 0.05),
					pos.getY() + ParticleUtils.inRange(-0.05, 0.05),
					pos.getZ() + 0.5 + Math.cos(time + j) + ParticleUtils.inRange(-0.05, 0.05), 0.05, 0.0, 0.05);

			world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
					pos.getX() + 0.5 + Math.sin(time + j) + ParticleUtils.inRange(-0.05, 0.05),
					pos.getY() + ParticleUtils.inRange(-0.05, 0.05),
					pos.getZ() + 0.5 + Math.cos(time + j) + ParticleUtils.inRange(-0.05, 0.05), -0.05, -0, 0.05);

			world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
					pos.getX() + 0.5 + Math.sin(time + j) + ParticleUtils.inRange(-0.05, 0.05),
					pos.getY() + ParticleUtils.inRange(-0.05, 0.05),
					pos.getZ() + 0.5 + Math.cos(time + j) + ParticleUtils.inRange(-0.05, 0.05), -0.05, -0, -0.05);

			world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
					pos.getX() + 0.5 + Math.sin(time + j) + ParticleUtils.inRange(-0.05, 0.05),
					pos.getY() + ParticleUtils.inRange(-0.05, 0.05),
					pos.getZ() + 0.5 + Math.cos(time + j) + ParticleUtils.inRange(-0.05, 0.05), 0.05, 0.0, -0.05);
		}

		Collections.reverse(chakraColors);
		if (entityIn.ticksExisted > 40) {
			for (int j = 0; j < 6; j++) {
				world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
						pos.getX() + 0.5 - Math.cos(time - j) + ParticleUtils.inRange(-0.05, 0.05),
						pos.getY() + ParticleUtils.inRange(-0.05, 0.05),
						pos.getZ() + 0.5 - Math.sin(time - j) + ParticleUtils.inRange(-0.05, 0.05), 0.05, 0.0, 0.05);

				world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
						pos.getX() + 0.5 - Math.cos(time - j) + ParticleUtils.inRange(-0.05, 0.05),
						pos.getY() + ParticleUtils.inRange(-0.05, 0.05),
						pos.getZ() + 0.5 - Math.sin(time - j) + ParticleUtils.inRange(-0.05, 0.05), -0.05, -0, 0.05);

				world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
						pos.getX() + 0.5 - Math.cos(time - j) + ParticleUtils.inRange(-0.05, 0.05),
						pos.getY() + ParticleUtils.inRange(-0.05, 0.05),
						pos.getZ() + 0.5 - Math.sin(time - j) + ParticleUtils.inRange(-0.05, 0.05), -0.05, -0, -0.05);

				world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
						pos.getX() + 0.5 - Math.cos(time - j) + ParticleUtils.inRange(-0.05, 0.05),
						pos.getY() + ParticleUtils.inRange(-0.05, 0.05),
						pos.getZ() + 0.5 - Math.sin(time - j) + ParticleUtils.inRange(-0.05, 0.05), 0.05, 0.0, -0.05);
			}
		}
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityHolySpirit entity) {
		return new ResourceLocation(ForcesOfReality.MOD_ID + "textures/entity/tracker.png");
	}

}