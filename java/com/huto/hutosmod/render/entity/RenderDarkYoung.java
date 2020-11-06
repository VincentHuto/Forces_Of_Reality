package com.huto.hutosmod.render.entity;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.EntityDarkYoung;
import com.huto.hutosmod.models.entity.ModelDarkYoung;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDarkYoung extends MobRenderer<EntityDarkYoung, ModelDarkYoung> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/dark_young/model_dark_young.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/dark_young/model_dark_young.png");

	public RenderDarkYoung(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelDarkYoung(), 1.5f);
	}

	@Override
	public void render(EntityDarkYoung entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.push();
		matrixStackIn.pop();

	}

	// Growth Scaling
	@Override
	protected void preRenderCallback(EntityDarkYoung entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
		matrixStackIn.scale(2, 2, 2);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityDarkYoung entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}