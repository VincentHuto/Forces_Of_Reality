package com.vincenthuto.forcesofreality.client.render.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.lord.ModelTrueXanthousKing;
import com.vincenthuto.forcesofreality.common.entity.lord.EntityTrueXanthousKing;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LayerTrueXanthousGlow extends RenderLayer<EntityTrueXanthousKing, ModelTrueXanthousKing> {
	private static final RenderType RENDER_TYPE = RenderType.eyes(new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/true_xanthous_king/model_true_xanthous_king_lines.png"));

	public LayerTrueXanthousGlow(RenderLayerParent<EntityTrueXanthousKing, ModelTrueXanthousKing> rendererIn) {
		super(rendererIn);

	}

	public RenderType getRenderType() {
		return RENDER_TYPE;
	}

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn,
			EntityTrueXanthousKing entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float netHeadYaw, float headPitch) {
		if (entitylivingbaseIn.isVulnerable()) {
			VertexConsumer ivertexbuilder = bufferIn.getBuffer(RENDER_TYPE);
			this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY,
					1.0F, 1.0F, 1.0F, 1.0F);
		} else {

		}
	}
}
