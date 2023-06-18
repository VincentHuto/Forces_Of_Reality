package com.vincenthuto.forcesofreality.client.render.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.entity.guardian.ModelMalformedAutomaton;
import com.vincenthuto.forcesofreality.common.entity.guardian.EntityMalformedAutomaton;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

public class LayerAutomatonWindow extends RenderLayer<EntityMalformedAutomaton, ModelMalformedAutomaton> {

	public static final ResourceLocation GLASSTEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/block/machine_glass.png");
	public static final ResourceLocation GLASSBREAK1 = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/block/machine_glass_break_1.png");
	public static final ResourceLocation GLASSBREAK2 = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/block/machine_glass_break_2.png");

	public static double angleOf(Vec3 p1, Vec3 p2) {
		final double deltaY = p2.z - p1.z;
		final double deltaX = p2.x - p1.x;
		final double result = Math.toDegrees(Math.atan2(deltaY, deltaX));
		return result < 0 ? 360d + result : result;
	}

	public LayerAutomatonWindow(RenderLayerParent<EntityMalformedAutomaton, ModelMalformedAutomaton> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public ResourceLocation getTextureLocation(EntityMalformedAutomaton entity) {
		if (entity.isVulnerable()) {
			return GLASSBREAK2;
		} else if (entity.isArmored()) {
			return GLASSBREAK1;
		} else {
			return GLASSTEXTURE;
		}
	}

	@Override
	public void render(PoseStack matrix, MultiBufferSource buf, int packedLight, EntityMalformedAutomaton entity,
			float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {

		// Chest Panel
		matrix.pushPose();
		double yOffset = -1.44;
		matrix.translate(-0.22f, yOffset, -0.31);
		VertexConsumer builder = buf.getBuffer(RenderType.entityTranslucent(getTextureLocation(entity)));
		int color = 0xB6B900;
		int r = color >> 16 & 255, g = color >> 8 & 255, b = color & 255;
		builder.vertex(matrix.last().pose(), -0.47f, 0.45f, 0).color(r, g, b, 255).uv(1, 1)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		builder.vertex(matrix.last().pose(), -0.47f, 1, 0).color(r, g, b, 255).uv(1, 0)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		builder.vertex(matrix.last().pose(), 0.91f, 1, 0).color(r, g, b, 255).uv(0, 0)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		builder.vertex(matrix.last().pose(), .91f, 0.45f, 0).color(r, g, b, 255).uv(0, 1)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		matrix.popPose();

		// Lower Front Panel
		matrix.pushPose();
		matrix.translate(-0.22f, -0.37, -0.32);
		builder.vertex(matrix.last().pose(), 0.03f, 0.54f, 0).color(r, g, b, 255).uv(1, 1)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		builder.vertex(matrix.last().pose(), 0.03f, 1, 0).color(r, g, b, 255).uv(1, 0)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		builder.vertex(matrix.last().pose(), 0.41f, 1, 0).color(r, g, b, 255).uv(0, 0)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		builder.vertex(matrix.last().pose(), .41f, 0.54f, 0).color(r, g, b, 255).uv(0, 1)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		matrix.popPose();

		// Lower Back Panel
		matrix.pushPose();
		matrix.translate(-0.22f, -0.37, 0.32);
		builder.vertex(matrix.last().pose(), 0.03f, 0.54f, 0).color(r, g, b, 255).uv(1, 1)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		builder.vertex(matrix.last().pose(), 0.03f, 1, 0).color(r, g, b, 255).uv(1, 0)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		builder.vertex(matrix.last().pose(), 0.41f, 1, 0).color(r, g, b, 255).uv(0, 0)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		builder.vertex(matrix.last().pose(), .41f, 0.54f, 0).color(r, g, b, 255).uv(0, 1)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		matrix.popPose();

		// Leg Panel
		matrix.pushPose();
		matrix.translate(-0.51f, 0.1, 0.22);
		matrix.mulPose(Vector3.YP.rotationDegrees(90f).toMoj());
		builder.vertex(matrix.last().pose(), 0.0f, 0.26f, 0).color(r, g, b, 255).uv(1, 1)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		builder.vertex(matrix.last().pose(), 0.0f, 1, 0).color(r, g, b, 255).uv(1, 0)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		builder.vertex(matrix.last().pose(), 0.43f, 1, 0).color(r, g, b, 255).uv(0, 0)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		builder.vertex(matrix.last().pose(), .43f, 0.26f, 0).color(r, g, b, 255).uv(0, 1)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(matrix.last().normal(), 0, 1, 0)
				.endVertex();
		matrix.popPose();

	}

}