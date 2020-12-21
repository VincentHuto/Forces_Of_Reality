package com.huto.forces_of_reality.render.entity.guardians;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.entities.guardians.EntityDarkYoung;
import com.huto.forces_of_reality.models.entity.guardians.ModelDarkYoung;
import com.huto.forces_of_reality.render.entity.layer.LayerDarkYoungDeath;
import com.huto.forces_of_reality.render.entity.layer.LayerDarkYoungPendant;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDarkYoung extends MobRenderer<EntityDarkYoung, ModelDarkYoung> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/dark_young/model_dark_young.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/dark_young/model_dark_young.png");

	public RenderDarkYoung(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelDarkYoung(), 1.5f);
		this.addLayer(new LayerDarkYoungPendant(this));
		this.addLayer(new LayerDarkYoungDeath(this));
	}

	@Override
	public void render(EntityDarkYoung entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

	// Growth Scaling
	@Override
	protected void preRenderCallback(EntityDarkYoung entitylivingbaseIn, MatrixStack matrixStackIn,
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
	public ResourceLocation getEntityTexture(EntityDarkYoung entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}