package com.vincenthuto.forcesofreality.render.entity.summons;

import javax.annotation.Nonnull;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.summon.EntityBlackGoat;
import com.vincenthuto.forcesofreality.model.entity.summon.ModelBlackGoat;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderBlackGoat extends MobRenderer<EntityBlackGoat, ModelBlackGoat> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/black_goat/model_black_goat.png");
	public static final ResourceLocation GLASSTEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/block/end_portal_circle.png");

	public RenderBlackGoat(Context renderManagerIn) {
		super(renderManagerIn, new ModelBlackGoat(renderManagerIn.bakeLayer(ModelBlackGoat.LAYER_LOCATION)), 0.5f);

	}

	@Nonnull
	@Override
	public ResourceLocation getTextureLocation(@Nonnull EntityBlackGoat entity) {
		return TEXTURE;
	}

	@Override
	public void render(EntityBlackGoat entityIn, float entityYaw, float partialTicks, PoseStack matrix,
			MultiBufferSource buf, int packedLight) {
		super.render(entityIn, entityYaw, partialTicks, matrix, buf, packedLight);
		// Chest Panel
		float e = entityIn.tickCount;
		float escale = e * 0.005f + 0.8f;
		matrix.pushPose();
		if (entityIn.isOnGround()) {
			if (80 > e) {
				// matrix.scale(scale, scale, scale);
				matrix.translate(0, 0.1, 0);
				matrix.scale(1, 1, 1);
				if (escale < 5) {
					escale += 0.08f;
					matrix.scale(escale, escale, escale);
				}
				matrix.mulPose(Vector3.YP.rotation(e * escale * 0.3f).toMoj());
				VertexConsumer builder = buf.getBuffer(RenderType.entityTranslucent(GLASSTEXTURE));
				int color = 0xB6B900;
				int r = color >> 16 & 255, g = color & 255, b = color >> 16 & 255;
				builder.vertex(matrix.last().pose(), 1f, 0f, 1).color(r, g, b, 255).uv(1, 1)
						.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight)
						.normal(matrix.last().normal(), 0, 1, 0).endVertex();
				builder.vertex(matrix.last().pose(), 1f, 0, -1).color(r, g, b, 255).uv(1, 0)
						.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight)
						.normal(matrix.last().normal(), 0, 0, 0).endVertex();
				builder.vertex(matrix.last().pose(), -1f, 0, -1).color(r, g, b, 255).uv(0, 0)
						.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight)
						.normal(matrix.last().normal(), 0, 0, 0).endVertex();
				builder.vertex(matrix.last().pose(), -1f, 0, 1).color(r, g, b, 255).uv(0, 1)
						.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight)
						.normal(matrix.last().normal(), 0, 0, 0).endVertex();

			}
		}
		matrix.popPose();

		/*
		 * matrix.push();
		 *
		 * float d = entityIn.deathTicks; float dscale = d * 0.005f + 0.8f; if (d > 0) {
		 * // matrix.scale(scale, scale, scale); matrix.translate(0, 0.1, 0);
		 * matrix.scale(1, 1, 1); if (dscale > 5) { dscale -= 0.08f;
		 * matrix.scale(dscale, dscale, dscale); } matrix.rotate(Vector3.YP.rotation(d
		 * * dscale * 0.3f)); IVertexBuilder builder =
		 * buf.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE)); int color =
		 * 0xB6B900; int r = color >> 16 & 255, g = color & 255, b = color >> 16 & 255;
		 * builder.pos(matrix.getLast().getMatrix(), 1f, 0f, 1).color(r, g, b,
		 * 255).tex(1, 1) .overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
		 * .normal(matrix.getLast().getNormal(), 0, 1, 0).endVertex();
		 * builder.pos(matrix.getLast().getMatrix(), 1f, 0, -1).color(r, g, b,
		 * 255).tex(1, 0) .overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
		 * .normal(matrix.getLast().getNormal(), 0, 0, 0).endVertex();
		 * builder.pos(matrix.getLast().getMatrix(), -1f, 0, -1).color(r, g, b,
		 * 255).tex(0, 0) .overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
		 * .normal(matrix.getLast().getNormal(), 0, 0, 0).endVertex();
		 * builder.pos(matrix.getLast().getMatrix(), -1f, 0, 1).color(r, g, b,
		 * 255).tex(0, 1) .overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
		 * .normal(matrix.getLast().getNormal(), 0, 0, 0).endVertex();
		 *
		 * } matrix.pop();
		 */
	}

	// Growth Scaling
	@Override
	protected void scale(EntityBlackGoat entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
		super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);
		float f = 0.0F;
		int i = entitylivingbaseIn.tickCount;
		if (i > 0) {
			f = (i - partialTickTime) / 30.0F * 0.5F;
		}

		if (f > 1.1) {
			f = 1.1f;
		}
		if (entitylivingbaseIn.deathTicks == 1) {
			matrixStackIn.scale(1, f, 1);
		}

		if (entitylivingbaseIn.deathTicks > 0) {
			float d = entitylivingbaseIn.deathTicks;
			matrixStackIn.scale(1, d, 1);

		}
	}

}