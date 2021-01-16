package com.huto.forcesofreality.render.entity.lords;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entities.lords.EntityUzouthrhix;
import com.huto.forcesofreality.models.animation.ModelUzouthrhixAnim;
import com.huto.forcesofreality.render.entity.layer.LayerUzouthrhixDeath;
import com.huto.forcesofreality.render.entity.layer.LayerUzouthrihixGlow;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderUzouthrhix extends MobRenderer<EntityUzouthrhix, ModelUzouthrhixAnim> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/uzouthrhix/model_uzouthrhix.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/uzouthrhix/model_uzouthrhix_awoken.png");

	public RenderUzouthrhix(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelUzouthrhixAnim(), 1.5f);
		addLayer(new LayerUzouthrihixGlow(this));
		addLayer(new LayerUzouthrhixDeath(this));
	}

	@Override
	public void render(EntityUzouthrhix entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

	// Growth Scaling
	@Override
	protected void preRenderCallback(EntityUzouthrhix entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
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

	@Override
	public ResourceLocation getEntityTexture(EntityUzouthrhix entity) {
		if (entity.isArmored()) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}