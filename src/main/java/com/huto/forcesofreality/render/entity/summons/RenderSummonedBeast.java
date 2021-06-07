package com.huto.forcesofreality.render.entity.summons;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.summon.EntitySummonedBeast;
import com.huto.forcesofreality.model.entity.summon.ModelSummonedBeast;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderSummonedBeast extends MobRenderer<EntitySummonedBeast, ModelSummonedBeast> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/summoned_beast/model_summoned_beast_grey.png");

	public RenderSummonedBeast(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ModelSummonedBeast(), 0.5f);

	}

	@Override
	public void render(EntitySummonedBeast entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

	// Growth Scaling
	@Override
	protected void preRenderCallback(EntitySummonedBeast entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
		float f = 0.0F;
		int i = entitylivingbaseIn.ticksExisted;
		if (i > 0) {
			f = ((float) i - partialTickTime) / 30.0F * 0.5F;
		}

		if (f > 1.1) {
			f = 1.1f;
		}
		if (entitylivingbaseIn.deathTicks == 1) {
			matrixStackIn.scale(f, 1, f);
		}

		if (entitylivingbaseIn.deathTicks > 0) {
			float d = entitylivingbaseIn.deathTicks;
			matrixStackIn.scale(d, 1, d);

		}
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntitySummonedBeast entity) {
		return entity.getBeastTypeName();
	}

}