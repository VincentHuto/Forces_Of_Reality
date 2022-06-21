package com.vincenthuto.forcesofreality.render.entity.layer;

import java.util.Random;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.guardian.EntityHastur;
import com.vincenthuto.forcesofreality.model.entity.guardian.ModelHastur;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class LayerHasturDeath extends RenderLayer<EntityHastur, ModelHastur> {
	private static float constant = (float) (Math.sqrt(3.0D) / 2.0D);
	private static ResourceLocation DRAGON_EXPLODING_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur/modelhastur_exploding.png");
	protected static ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur/modelhastur.png");
	static Random random = new Random(432L);

	private final ModelHastur model;
	private static final RenderType DECAL = RenderType.entityDecal(TEXTURE);

	public LayerHasturDeath(RenderLayerParent<EntityHastur, ModelHastur> entityRendererIn) {
		super(entityRendererIn);
		model=entityRendererIn.getModel();
	}

	@Override
	public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, EntityHastur entityIn,
			float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {

		matrixStackIn.pushPose();
		boolean flag = entityIn.hurtTime > 0;
		matrixStackIn.scale(1.0f, 1.0f, 1.0f);

		if (entityIn.deathTicks > 0) {
			float f2 = entityIn.deathTicks / 100.0F;
			VertexConsumer ivertexbuilder = bufferIn
					.getBuffer(RenderType.dragonExplosionAlpha(DRAGON_EXPLODING_TEXTURES));
			this.model.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F,
					1.0F, 1.0F, 1.0F);
			VertexConsumer ivertexbuilder1 = bufferIn.getBuffer(DECAL);
			this.model.renderToBuffer(matrixStackIn, ivertexbuilder1, packedLightIn, OverlayTexture.pack(0.0F, flag),
					1.0F, 1.0F, 1.0F, 1.0F);
		}
		matrixStackIn.popPose();

		if (entityIn.deathTicks > 0) {
			float f5 = (entityIn.deathTicks + partialTicks) / 100.0F;
			float f7 = Math.min(f5 > 0.4F ? (f5 - 0.8F) / 0.2F : 0.0F, 1.0F);
			Random random = new Random(432L);
			VertexConsumer ivertexbuilder2 = bufferIn.getBuffer(RenderType.lightning());
			matrixStackIn.pushPose();
			matrixStackIn.translate(0.0D, -0D, 0.0D);
			for (int i = 0; i < (f5 * f5) / 2.0F * 90.0F; ++i) {
				matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(random.nextFloat() * -360.0F));
				matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(random.nextFloat() * 360.0F));
				matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(random.nextFloat() * -360.0F));
				matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(random.nextFloat() * 360.0F));
				matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(random.nextFloat() * -360.0F));
				matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(random.nextFloat() * 360.0F + f5 * 90.0F));
				float f3 = random.nextFloat() * 2;
				float f4 = random.nextFloat() * -2;
				Matrix4f matrix4f = matrixStackIn.last().pose();
				int j = (int) (255.0F * (2.0F - f7));
				vertex01(ivertexbuilder2, matrix4f, j);
				vertex2(ivertexbuilder2, matrix4f, f3, f4);
				vertex3(ivertexbuilder2, matrix4f, f3, f4);
				vertex01(ivertexbuilder2, matrix4f, j);
				vertex3(ivertexbuilder2, matrix4f, f3, f4);
				vertex4(ivertexbuilder2, matrix4f, f3, f4);
				vertex01(ivertexbuilder2, matrix4f, j);
				vertex4(ivertexbuilder2, matrix4f, f3, f4);
				vertex2(ivertexbuilder2, matrix4f, f3, f4);
			}

			matrixStackIn.popPose();
		}

	}

	private static void vertex01(VertexConsumer vertextBuilder, Matrix4f matrix4f, int alpha) {
		vertextBuilder.vertex(matrix4f, 0.0F, 0.0F, 0.0F).color(0, 0, 0, alpha).endVertex();
		vertextBuilder.vertex(matrix4f, -0.3F, -0.3F, -.3F).color(100, 100, 0, alpha).endVertex();
	}

	private static void vertex2(VertexConsumer vertextBuilder, Matrix4f matrix4f, float y, float x) {
		vertextBuilder.vertex(matrix4f, -constant * x, y, -0.3F * x).color(100, 100, 0, 1).endVertex();
	}

	private static void vertex3(VertexConsumer vertextBuilder, Matrix4f matrix4f, float y, float x) {
		vertextBuilder.vertex(matrix4f, constant * x, y, -0.3F * x).color(100, 100, 0, 1).endVertex();
	}

	private static void vertex4(VertexConsumer vertextBuilder, Matrix4f matrix4f, float y, float z) {
		vertextBuilder.vertex(matrix4f, 0.0F, y, -0.3f * z).color(100, 100, 0, 1).endVertex();
	}
}
