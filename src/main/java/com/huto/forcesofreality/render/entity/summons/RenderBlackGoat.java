package com.huto.forcesofreality.render.entity.summons;

import javax.annotation.Nonnull;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entity.summon.EntityBlackGoat;
import com.huto.forcesofreality.model.entity.summon.ModelBlackGoat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderBlackGoat extends MobRenderer<EntityBlackGoat, ModelBlackGoat> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/black_goat/model_black_goat.png");
	public static final ResourceLocation GLASSTEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/blocks/end_portal_circle.png");

	public RenderBlackGoat(EntityRenderDispatcher renderManagerIn) {
		super(renderManagerIn, new ModelBlackGoat(), 0.5f);

	}

	@Override
	public void render(EntityBlackGoat entityIn, float entityYaw, float partialTicks, PoseStack matrix,
			MultiBufferSource buf, int packedLight) {
		super.render(entityIn, entityYaw, partialTicks, matrix, buf, packedLight);
		// Chest Panel
		float e = entityIn.ticksExisted;
		float escale = e * 0.005f + 0.8f;
		matrix.push();
		if (entityIn.isOnGround()) {
			if (80 > e) {
				// matrix.scale(scale, scale, scale);
				matrix.translate(0, 0.1, 0);
				matrix.scale(1, 1, 1);
				if (escale < 5) {
					escale += 0.08f;
					matrix.scale(escale, escale, escale);
				}
				matrix.rotate(Vector3f.YP.rotation(e * escale * 0.3f));
				IVertexBuilder builder = buf.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE));
				int color = 0xB6B900;
				int r = color >> 16 & 255, g = color & 255, b = color >> 16 & 255;
				builder.pos(matrix.getLast().getMatrix(), 1f, 0f, 1).color(r, g, b, 255).tex(1, 1)
						.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
						.normal(matrix.getLast().getNormal(), 0, 1, 0).endVertex();
				builder.pos(matrix.getLast().getMatrix(), 1f, 0, -1).color(r, g, b, 255).tex(1, 0)
						.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
						.normal(matrix.getLast().getNormal(), 0, 0, 0).endVertex();
				builder.pos(matrix.getLast().getMatrix(), -1f, 0, -1).color(r, g, b, 255).tex(0, 0)
						.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
						.normal(matrix.getLast().getNormal(), 0, 0, 0).endVertex();
				builder.pos(matrix.getLast().getMatrix(), -1f, 0, 1).color(r, g, b, 255).tex(0, 1)
						.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
						.normal(matrix.getLast().getNormal(), 0, 0, 0).endVertex();

			}
		}
		matrix.pop();

		/*matrix.push();
		
		float d = entityIn.deathTicks;
		float dscale = d * 0.005f + 0.8f;
		if (d > 0) {
			// matrix.scale(scale, scale, scale);
			matrix.translate(0, 0.1, 0);
			matrix.scale(1, 1, 1);
			if (dscale > 5) {
				dscale -= 0.08f;
				matrix.scale(dscale, dscale, dscale);
			}
			matrix.rotate(Vector3f.YP.rotation(d * dscale * 0.3f));
			IVertexBuilder builder = buf.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE));
			int color = 0xB6B900;
			int r = color >> 16 & 255, g = color & 255, b = color >> 16 & 255;
			builder.pos(matrix.getLast().getMatrix(), 1f, 0f, 1).color(r, g, b, 255).tex(1, 1)
					.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
					.normal(matrix.getLast().getNormal(), 0, 1, 0).endVertex();
			builder.pos(matrix.getLast().getMatrix(), 1f, 0, -1).color(r, g, b, 255).tex(1, 0)
					.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
					.normal(matrix.getLast().getNormal(), 0, 0, 0).endVertex();
			builder.pos(matrix.getLast().getMatrix(), -1f, 0, -1).color(r, g, b, 255).tex(0, 0)
					.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
					.normal(matrix.getLast().getNormal(), 0, 0, 0).endVertex();
			builder.pos(matrix.getLast().getMatrix(), -1f, 0, 1).color(r, g, b, 255).tex(0, 1)
					.overlay(OverlayTexture.NO_OVERLAY).lightmap(packedLight)
					.normal(matrix.getLast().getNormal(), 0, 0, 0).endVertex();

		}
		matrix.pop();
*/
	}

	// Growth Scaling
	@Override
	protected void preRenderCallback(EntityBlackGoat entitylivingbaseIn, MatrixStack matrixStackIn,
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
			matrixStackIn.scale(1, f, 1);
		}

		if (entitylivingbaseIn.deathTicks > 0) {
			float d = entitylivingbaseIn.deathTicks;
			matrixStackIn.scale(1, d, 1);

		}
	}

	@Nonnull
	@Override
	public ResourceLocation getEntityTexture(@Nonnull EntityBlackGoat entity) {
		return TEXTURE;
	}

}