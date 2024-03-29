package com.vincenthuto.forcesofreality.client.render.entity.guardians;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.guardian.ModelDarkYoung;
import com.vincenthuto.forcesofreality.client.render.entity.layer.LayerDarkYoungDeath;
import com.vincenthuto.forcesofreality.client.render.entity.layer.LayerDarkYoungPendant;
import com.vincenthuto.forcesofreality.common.entity.guardian.EntityDarkYoung;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderDarkYoung extends MobRenderer<EntityDarkYoung, ModelDarkYoung> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/dark_young/model_dark_young.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/dark_young/model_dark_young.png");

	public RenderDarkYoung(Context renderManagerIn) {
		super(renderManagerIn, new ModelDarkYoung(renderManagerIn.bakeLayer(ModelDarkYoung.LAYER_LOCATION)), 1.5f);
		this.addLayer(new LayerDarkYoungPendant(this));
		this.addLayer(new LayerDarkYoungDeath(this));
	}

	@Override
	public ResourceLocation getTextureLocation(EntityDarkYoung entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}

	@Override
	public void render(EntityDarkYoung entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

	// Growth Scaling
	@Override
	protected void scale(EntityDarkYoung entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
		super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
		matrixStackIn.scale(2, 2, 2);
		if (entitylivingbaseIn.deathTicks > 0) {
			float d = entitylivingbaseIn.deathTicks;
			float scaleFactor = 1 - d * 0.0075f;
			if (scaleFactor > 0) {
				matrixStackIn.scale(1, scaleFactor, 1);
			} else {
				matrixStackIn.scale(1, 0, 1);

			}
			matrixStackIn.translate(0, d * 0.01, 0);
			// matrixStackIn.scale(1,1-d*0.01f, 1);

		}

	}
}