package com.huto.forcesofreality.render.entity.layer;

import java.util.Random;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.entities.guardians.EntityHastur;
import com.huto.forcesofreality.models.entity.guardians.ModelHastur;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;

public class LayerHasturDeath extends LayerRenderer<EntityHastur, ModelHastur> {
	private static float constant = (float) (Math.sqrt(3.0D) / 2.0D);
	private static ResourceLocation DRAGON_EXPLODING_TEXTURES = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur/modelhastur_exploding.png");
	protected static ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/hastur/modelhastur.png");
	static Random random = new Random(432L);

	private final ModelHastur model = new ModelHastur();
	private static final RenderType field_229054_i_ = RenderType.getEntityDecal(TEXTURE);

	public LayerHasturDeath(IEntityRenderer<EntityHastur, ModelHastur> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, EntityHastur entityIn,
			float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch) {

		matrixStackIn.push();
		boolean flag = entityIn.hurtTime > 0;
		matrixStackIn.scale(1.0f, 1.0f, 1.0f);

		if (entityIn.deathTicks > 0) {
			float f2 = (float) entityIn.deathTicks / 100.0F;
			IVertexBuilder ivertexbuilder = bufferIn
					.getBuffer(RenderType.getEntityAlpha(DRAGON_EXPLODING_TEXTURES, f2));
			this.model.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F,
					1.0F);
			IVertexBuilder ivertexbuilder1 = bufferIn.getBuffer(field_229054_i_);
			this.model.render(matrixStackIn, ivertexbuilder1, packedLightIn, OverlayTexture.getPackedUV(0.0F, flag),
					1.0F, 1.0F, 1.0F, 1.0F);
		}
		matrixStackIn.pop();

		if (entityIn.deathTicks > 0) {
			float f5 = ((float) entityIn.deathTicks + partialTicks) / 100.0F;
			float f7 = Math.min(f5 > 0.4F ? (f5 - 0.8F) / 0.2F : 0.0F, 1.0F);
			Random random = new Random(432L);
			IVertexBuilder ivertexbuilder2 = bufferIn.getBuffer(RenderType.getLightning());
			matrixStackIn.push();
			matrixStackIn.translate(0.0D, -0D, 0.0D);
			for (int i = 0; (float) i < (f5 * f5) / 2.0F * 90.0F; ++i) {
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(random.nextFloat() * -360.0F));
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(random.nextFloat() * 360.0F));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(random.nextFloat() * -360.0F));
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(random.nextFloat() * 360.0F));
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(random.nextFloat() * -360.0F));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(random.nextFloat() * 360.0F + f5 * 90.0F));
				float f3 = random.nextFloat() * 2;
				float f4 = random.nextFloat() * -2;
				Matrix4f matrix4f = matrixStackIn.getLast().getMatrix();
				int j = (int) (255.0F * (2.0F - f7));
				func_229061_a_(ivertexbuilder2, matrix4f, j);
				func_229060_a_(ivertexbuilder2, matrix4f, f3, f4);
				func_229062_b_(ivertexbuilder2, matrix4f, f3, f4);
				func_229061_a_(ivertexbuilder2, matrix4f, j);
				func_229062_b_(ivertexbuilder2, matrix4f, f3, f4);
				func_229063_c_(ivertexbuilder2, matrix4f, f3, f4);
				func_229061_a_(ivertexbuilder2, matrix4f, j);
				func_229063_c_(ivertexbuilder2, matrix4f, f3, f4);
				func_229060_a_(ivertexbuilder2, matrix4f, f3, f4);
			}

			matrixStackIn.pop();
		}

	}

	private static void func_229061_a_(IVertexBuilder vertextBuilder, Matrix4f matrix4f, int alpha) {
		vertextBuilder.pos(matrix4f, 0.0F, 0.0F, 0.0F).color(0, 0, 0, alpha).endVertex();
		vertextBuilder.pos(matrix4f, -0.3F, -0.3F, -.3F).color(100, 100, 0, alpha).endVertex();
	}

	private static void func_229060_a_(IVertexBuilder vertextBuilder, Matrix4f matrix4f, float y, float x) {
		vertextBuilder.pos(matrix4f, -constant * x, y, -0.3F * x).color(100, 100, 0, 1).endVertex();
	}

	private static void func_229062_b_(IVertexBuilder vertextBuilder, Matrix4f matrix4f, float y, float x) {
		vertextBuilder.pos(matrix4f, constant * x, y, -0.3F * x).color(100, 100, 0, 1).endVertex();
	}

	private static void func_229063_c_(IVertexBuilder vertextBuilder, Matrix4f matrix4f, float y, float z) {
		vertextBuilder.pos(matrix4f, 0.0F, y, -0.3f * z).color(100, 100, 0, 1).endVertex();
	}
}
