package com.vincenthuto.forcesofreality.client.render.entity.projectile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.entity.projectile.EntityHolySpirit;
import com.vincenthuto.hutoslib.client.particle.factory.GlowParticleFactory;
import com.vincenthuto.hutoslib.client.particle.util.HLParticleUtils;
import com.vincenthuto.hutoslib.client.particle.util.ParticleColor;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderHolySpirit extends EntityRenderer<EntityHolySpirit> {

	public RenderHolySpirit(Context renderManager) {
		super(renderManager);
	}

	@Nonnull
	@Override
	public ResourceLocation getTextureLocation(@Nonnull EntityHolySpirit entity) {
		return new ResourceLocation(ForcesOfReality.MOD_ID + "textures/entity/tracker.png");
	}

	@Override
	public void render(EntityHolySpirit entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		List<ParticleColor> chakraColors = new ArrayList<>();
		Collections.addAll(chakraColors, new ParticleColor(162, 86, 160), new ParticleColor(96, 96, 186),
				new ParticleColor(66, 184, 212), new ParticleColor(110, 200, 80), new ParticleColor(229, 60, 81),
				new ParticleColor(243, 124, 59));

		Level world = entityIn.getCommandSenderWorld();
		BlockPos pos = entityIn.blockPosition();
		double time = world.getGameTime() * 0.05f;
		// Random rand = world.rand;
		for (int j = 0; j < 6; j++) {
			world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
					pos.getX() + 0.5 + Math.sin(time + j) + HLParticleUtils.inRange(-0.05, 0.05),
					pos.getY() + HLParticleUtils.inRange(-0.05, 0.05),
					pos.getZ() + 0.5 + Math.cos(time + j) + HLParticleUtils.inRange(-0.05, 0.05), 0.05, 0.0, 0.05);

			world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
					pos.getX() + 0.5 + Math.sin(time + j) + HLParticleUtils.inRange(-0.05, 0.05),
					pos.getY() + HLParticleUtils.inRange(-0.05, 0.05),
					pos.getZ() + 0.5 + Math.cos(time + j) + HLParticleUtils.inRange(-0.05, 0.05), -0.05, -0, 0.05);

			world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
					pos.getX() + 0.5 + Math.sin(time + j) + HLParticleUtils.inRange(-0.05, 0.05),
					pos.getY() + HLParticleUtils.inRange(-0.05, 0.05),
					pos.getZ() + 0.5 + Math.cos(time + j) + HLParticleUtils.inRange(-0.05, 0.05), -0.05, -0, -0.05);

			world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
					pos.getX() + 0.5 + Math.sin(time + j) + HLParticleUtils.inRange(-0.05, 0.05),
					pos.getY() + HLParticleUtils.inRange(-0.05, 0.05),
					pos.getZ() + 0.5 + Math.cos(time + j) + HLParticleUtils.inRange(-0.05, 0.05), 0.05, 0.0, -0.05);
		}

		Collections.reverse(chakraColors);
		if (entityIn.tickCount > 40) {
			for (int j = 0; j < 6; j++) {
				world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
						pos.getX() + 0.5 - Math.cos(time - j) + HLParticleUtils.inRange(-0.05, 0.05),
						pos.getY() + HLParticleUtils.inRange(-0.05, 0.05),
						pos.getZ() + 0.5 - Math.sin(time - j) + HLParticleUtils.inRange(-0.05, 0.05), 0.05, 0.0, 0.05);

				world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
						pos.getX() + 0.5 - Math.cos(time - j) + HLParticleUtils.inRange(-0.05, 0.05),
						pos.getY() + HLParticleUtils.inRange(-0.05, 0.05),
						pos.getZ() + 0.5 - Math.sin(time - j) + HLParticleUtils.inRange(-0.05, 0.05), -0.05, -0, 0.05);

				world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
						pos.getX() + 0.5 - Math.cos(time - j) + HLParticleUtils.inRange(-0.05, 0.05),
						pos.getY() + HLParticleUtils.inRange(-0.05, 0.05),
						pos.getZ() + 0.5 - Math.sin(time - j) + HLParticleUtils.inRange(-0.05, 0.05), -0.05, -0, -0.05);

				world.addParticle(GlowParticleFactory.createData(chakraColors.get(j)),
						pos.getX() + 0.5 - Math.cos(time - j) + HLParticleUtils.inRange(-0.05, 0.05),
						pos.getY() + HLParticleUtils.inRange(-0.05, 0.05),
						pos.getZ() + 0.5 - Math.sin(time - j) + HLParticleUtils.inRange(-0.05, 0.05), 0.05, 0.0, -0.05);
			}
		}
	}

}