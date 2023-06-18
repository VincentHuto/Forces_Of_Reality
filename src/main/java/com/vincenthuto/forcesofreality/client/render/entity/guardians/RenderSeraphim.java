package com.vincenthuto.forcesofreality.client.render.entity.guardians;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.guardian.ModelSeraphim;
import com.vincenthuto.forcesofreality.common.entity.guardian.EntitySeraphim;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderSeraphim extends MobRenderer<EntitySeraphim, ModelSeraphim> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/seraphim/modelseraphim.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/seraphim/modelseraphim.png");

	public RenderSeraphim(Context renderManagerIn) {
		super(renderManagerIn, new ModelSeraphim(renderManagerIn.bakeLayer(ModelSeraphim.LAYER_LOCATION)),1.5f);

	}

	@Override
	protected float getBob(EntitySeraphim livingBase, float partialTicks) {
		return 1f;
	}

	@Override
	public ResourceLocation getTextureLocation(EntitySeraphim entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}

	@Override
	public void render(EntitySeraphim entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.pushPose();
		matrixStackIn.popPose();

	}
}