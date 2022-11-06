package com.vincenthuto.forcesofreality.render.entity.lords;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.lord.EntityUzouthrhix;
import com.vincenthuto.forcesofreality.model.entity.lord.ModelUzouthrhix;
import com.vincenthuto.forcesofreality.render.entity.layer.LayerUzouthrhixDeath;
import com.vincenthuto.forcesofreality.render.entity.layer.LayerUzouthrihixGlow;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderUzouthrhix extends MobRenderer<EntityUzouthrhix, ModelUzouthrhix> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/uzouthrhix/model_uzouthrhix.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/uzouthrhix/model_uzouthrhix_awoken.png");

	public RenderUzouthrhix(Context renderManagerIn) {
		super(renderManagerIn, new ModelUzouthrhix(renderManagerIn.bakeLayer(ModelUzouthrhix.LAYER_LOCATION)), 3.5f);
		addLayer(new LayerUzouthrihixGlow(this));
		addLayer(new LayerUzouthrhixDeath(this));
	}

	@Override
	public ResourceLocation getTextureLocation(EntityUzouthrhix entity) {
		if (entity.isArmored()) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}

	@Override
	public void render(EntityUzouthrhix entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

	// Growth Scaling
	@Override
	protected void scale(EntityUzouthrhix entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
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