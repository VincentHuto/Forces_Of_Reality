package com.huto.forcesofreality.render.entity.layer;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entities.guardians.EntityMalformedAutomaton;
import com.huto.forcesofreality.models.entity.guardians.ModelMalformedAutomaton;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;

public class LayerAutomatonWindow extends LayerRenderer<EntityMalformedAutomaton, ModelMalformedAutomaton> {

	public static final ResourceLocation GLASSTEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/blocks/machine_glass.png");
	public static final ResourceLocation GLASSBREAK1 = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/blocks/machine_glass_break_1.png");
	public static final ResourceLocation GLASSBREAK2 = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/blocks/machine_glass_break_2.png");

	public LayerAutomatonWindow(IEntityRenderer<EntityMalformedAutomaton, ModelMalformedAutomaton> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public ResourceLocation getEntityTexture(EntityMalformedAutomaton entity) {
		if (entity.isVulnerable()) {
			return GLASSBREAK2;
		} else if (entity.isArmored()) {
			return GLASSBREAK1;
		} else {
			return GLASSTEXTURE;
		}
	}

	@Override
	public void render(MatrixStack matrix, IRenderTypeBuffer buf, int packedLight, EntityMalformedAutomaton entity,
			float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {

		// Chest Panel
		matrix.push();
		double yOffset = -1.44;
		matrix.translate(-0.22f, yOffset, -0.31);
		IVertexBuilder builder = buf.getBuffer(RenderType.getEntityTranslucent(getEntityTexture(entity)));
		int color = 0xB6B900;
		int r = color >> 16 & 255, g = color >> 8 & 255, b = color & 255;
		builder.pos(matrix.getLast().getMatrix(), -0.47f, 0.45f, 0).color(r, g, b, 255).tex(1, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		builder.pos(matrix.getLast().getMatrix(), -0.47f, 1, 0).color(r, g, b, 255).tex(1, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		builder.pos(matrix.getLast().getMatrix(), 0.91f, 1, 0).color(r, g, b, 255).tex(0, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		builder.pos(matrix.getLast().getMatrix(), .91f, 0.45f, 0).color(r, g, b, 255).tex(0, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		matrix.pop();

		// Lower Front Panel
		matrix.push();
		matrix.translate(-0.22f, -0.37, -0.32);
		builder.pos(matrix.getLast().getMatrix(), 0.03f, 0.54f, 0).color(r, g, b, 255).tex(1, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		builder.pos(matrix.getLast().getMatrix(), 0.03f, 1, 0).color(r, g, b, 255).tex(1, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		builder.pos(matrix.getLast().getMatrix(), 0.41f, 1, 0).color(r, g, b, 255).tex(0, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		builder.pos(matrix.getLast().getMatrix(), .41f, 0.54f, 0).color(r, g, b, 255).tex(0, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		matrix.pop();

		// Lower Back Panel
		matrix.push();
		matrix.translate(-0.22f, -0.37, 0.32);
		builder.pos(matrix.getLast().getMatrix(), 0.03f, 0.54f, 0).color(r, g, b, 255).tex(1, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		builder.pos(matrix.getLast().getMatrix(), 0.03f, 1, 0).color(r, g, b, 255).tex(1, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		builder.pos(matrix.getLast().getMatrix(), 0.41f, 1, 0).color(r, g, b, 255).tex(0, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		builder.pos(matrix.getLast().getMatrix(), .41f, 0.54f, 0).color(r, g, b, 255).tex(0, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		matrix.pop();

		// Leg Panel
		matrix.push();
		matrix.translate(-0.51f, 0.1, 0.22);
		matrix.rotate(Vector3f.YP.rotationDegrees(90f));
		builder.pos(matrix.getLast().getMatrix(), 0.0f, 0.26f, 0).color(r, g, b, 255).tex(1, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		builder.pos(matrix.getLast().getMatrix(), 0.0f, 1, 0).color(r, g, b, 255).tex(1, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		builder.pos(matrix.getLast().getMatrix(), 0.43f, 1, 0).color(r, g, b, 255).tex(0, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		builder.pos(matrix.getLast().getMatrix(), .43f, 0.26f, 0).color(r, g, b, 255).tex(0, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight).normal(matrix.getLast().getNormal(), 0, 1, 0)
				.endVertex();
		matrix.pop();

	}

	public static double angleOf(Vector3d p1, Vector3d p2) {
		final double deltaY = p2.z - p1.z;
		final double deltaX = p2.x - p1.x;
		final double result = Math.toDegrees(Math.atan2(deltaY, deltaX));
		return result < 0 ? 360d + result : result;
	}

}