package com.huto.hutosmod.render.entity;

import javax.annotation.Nonnull;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.EntityTentacle;
import com.huto.hutosmod.models.ModelTentacle;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTentacle extends MobRenderer<EntityTentacle, ModelTentacle> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/tentacle/model_tentacle.png");

	public RenderTentacle(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelTentacle(), 0.5f);

	}

	@Override
	public void render(EntityTentacle entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

	// Growth Scaling
	@Override
	protected void preRenderCallback(EntityTentacle entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
		float f = 0.0F;
		int i = entitylivingbaseIn.ticksExisted;
		if (i > 0) {
			f = ((float) i - partialTickTime) / 30.0F * 0.5F;
		}

		matrixStackIn.scale(f, f, f);
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityTentacle entity) {
		return entity.getTentacleTypeName();
	}

}