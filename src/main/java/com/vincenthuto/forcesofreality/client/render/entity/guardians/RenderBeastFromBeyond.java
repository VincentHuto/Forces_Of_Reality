package com.vincenthuto.forcesofreality.client.render.entity.guardians;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.guardian.ModelBeastFromBeyond;
import com.vincenthuto.forcesofreality.common.entity.guardian.EntityBeastFromBeyond;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderBeastFromBeyond extends MobRenderer<EntityBeastFromBeyond, ModelBeastFromBeyond> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/beast_from_beyond/model_beast_from_beyond.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/beast_from_beyond/model_beast_from_beyond.png");

	public RenderBeastFromBeyond(Context renderManagerIn) {
		super(renderManagerIn, new ModelBeastFromBeyond(renderManagerIn.bakeLayer(ModelBeastFromBeyond.LAYER_LOCATION)), 1.5f);
		// this.addLayer(new LayerHasturAura(this));
		// this.addLayer(new LayerHasturDeath(this));
	}

	@Override
	public ResourceLocation getTextureLocation(EntityBeastFromBeyond entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}

	@Override
	public void render(EntityBeastFromBeyond entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.pushPose();
		matrixStackIn.popPose();

	}

	// Growth Scaling
	@Override
	protected void scale(EntityBeastFromBeyond entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
		super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
		matrixStackIn.scale(2, 2, 2);
	}
}