package com.vincenthuto.forcesofreality.render.entity.lords;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.lord.EntityTrueXanthousKing;
import com.vincenthuto.forcesofreality.model.entity.lord.ModelTrueXanthousKing;
import com.vincenthuto.forcesofreality.render.entity.layer.LayerTrueXanthousGlow;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTrueXanthousKing extends MobRenderer<EntityTrueXanthousKing, ModelTrueXanthousKing> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/true_xanthous_king/model_true_xanthous_king.png");
	private static final ResourceLocation DRAGON_DEAD_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/true_xanthous_king/model_true_xanthous_king.png");

	public RenderTrueXanthousKing(Context renderManagerIn) {
		super(renderManagerIn, new ModelTrueXanthousKing(renderManagerIn.bakeLayer(ModelTrueXanthousKing.LAYER_LOCATION)), 1.5f);
		addLayer(new LayerTrueXanthousGlow(this));
	}

	@Override
	public void render(EntityTrueXanthousKing entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.pushPose();
		matrixStackIn.popPose();

	}

	@Override
	public ResourceLocation getTextureLocation(EntityTrueXanthousKing entity) {
		if (entity.deathTicks > 0) {
			return DRAGON_DEAD_TEXTURES;
		} else {
			return TEXTURE;

		}
	}
}