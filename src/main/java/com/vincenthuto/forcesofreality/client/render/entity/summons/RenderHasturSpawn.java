package com.vincenthuto.forcesofreality.client.render.entity.summons;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.mob.ModelHasturSpawn;
import com.vincenthuto.forcesofreality.common.entity.summon.EntityHasturSpawn;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderHasturSpawn extends MobRenderer<EntityHasturSpawn, ModelHasturSpawn> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur_spawn/model_hastur_spawn_brown.png");

	public RenderHasturSpawn(Context renderManagerIn) {
		super(renderManagerIn, new ModelHasturSpawn(renderManagerIn.bakeLayer(ModelHasturSpawn.LAYER_LOCATION)), 0.5f);

	}

	@Nonnull
	@Override
	public ResourceLocation getTextureLocation(@Nonnull EntityHasturSpawn entity) {
		return entity.getSpawnTypeName();
	}

	@Override
	public void render(EntityHasturSpawn entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

	}

	// Growth Scaling
	@Override
	protected void scale(EntityHasturSpawn entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
		super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
		float f = 0.0F;
		int i = entitylivingbaseIn.tickCount;
		if (i > 0) {
			f = (i - partialTickTime) / 30.0F * 0.5F;
		}

		if (f > 1) {
			f = 1;
		}
		if (entitylivingbaseIn.deathTicks == 1) {
			matrixStackIn.scale(f, f, f);
		}

		if (entitylivingbaseIn.deathTicks > 0) {
			float d = entitylivingbaseIn.deathTicks;
			matrixStackIn.scale(d, d, d);

		}
	}

}