package com.vincenthuto.forcesofreality.render.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.lord.EntityUzouthrhix;
import com.vincenthuto.forcesofreality.model.entity.lord.ModelUzouthrhix;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class LayerUzouthrhixDeath extends RenderLayer<EntityUzouthrhix, ModelUzouthrhix> {

	public static final ResourceLocation GLASSTEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/blocks/end_portal_circle.png");

	public LayerUzouthrhixDeath(RenderLayerParent<EntityUzouthrhix, ModelUzouthrhix> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public void render(PoseStack matrix, MultiBufferSource buf, int packedLight, EntityUzouthrhix entity,
			float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {

		// Chest Panel
		float d = entity.deathTicks;
		float scale = d * 0.01f + 0.8f;
		if (d > 0) {
			if (d > 130) {
				d = 130;
			}
			matrix.pushPose();
			// matrix.scale(scale, scale, scale);
			matrix.translate(0, 1.5, 0);
			matrix.translate(0, -d * 0.01, 0);
			matrix.scale(1, 1, 1);
			if (scale < 5) {
				scale += 0.08f;
				matrix.scale(scale, scale, scale);
			}

			matrix.mulPose(Vector3f.YP.rotation(d * scale * 0.3f));
			VertexConsumer builder = buf.getBuffer(RenderType.entityTranslucent(GLASSTEXTURE));
			int color = 0xB6B900;
			int r = color >> 16 & 255, g = color & 255, b = color >> 16 & 255;
			builder.vertex(matrix.last().pose(), 1f, 0f, 1).color(r, g, b, 255).uv(1, 1)
					.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
					.endVertex();
			builder.vertex(matrix.last().pose(), 1f, 0, -1).color(r, g, b, 255).uv(1, 0)
					.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 0, 0)
					.endVertex();
			builder.vertex(matrix.last().pose(), -1f, 0, -1).color(r, g, b, 255).uv(0, 0)
					.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 0, 0)
					.endVertex();
			builder.vertex(matrix.last().pose(), -1f, 0, 1).color(r, g, b, 255).uv(0, 1)
					.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 0, 0)
					.endVertex();

			matrix.popPose();

			/*
			 * matrix.push(); matrix.translate(0, d * 0.01, 0); matrix.pop();
			 */

		}
	}

}