package com.huto.forcesofreality.render.entity.summons;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entities.summons.EntityTentacle;
import com.huto.forcesofreality.models.entity.summons.ModelTentacle;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTentacle extends MobRenderer<EntityTentacle, ModelTentacle> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
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

		if (f > 1.3) {
			f = 1.3f;
		}
		if (entitylivingbaseIn.deathTicks == 1) {
			matrixStackIn.scale(f, f, f);
		}

		if (entitylivingbaseIn.deathTicks > 0) {
			float d = entitylivingbaseIn.deathTicks;
			matrixStackIn.scale(d, d, d);

		}
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityTentacle entity) {
		return entity.getTentacleTypeName();
	}

}