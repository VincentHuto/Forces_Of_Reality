package com.vincenthuto.forcesofreality.client.render.entity.projectile;

import org.joml.Matrix3f;
import org.joml.Matrix4f;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.entity.projectile.EntityFirstBeastBolt;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RenderFirstBeastBolt<T extends EntityFirstBeastBolt> extends EntityRenderer<EntityFirstBeastBolt> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/first_beast_bolt/model_first_beast_bolt.png");

	public RenderFirstBeastBolt(net.minecraft.client.renderer.entity.EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn);
	}

	public void drawVertex(Matrix4f matrix, Matrix3f normals, VertexConsumer vertexBuilder, int offsetX, int offsetY,
			int offsetZ, float textureX, float textureY, int p_229039_9_, int p_229039_10_, int p_229039_11_,
			int packedLightIn) {
		vertexBuilder.vertex(matrix, offsetX, offsetY, offsetZ).color(255, 255, 255, 255).uv(textureX, textureY)
				.overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLightIn)
				.normal(normals, p_229039_9_, p_229039_11_, p_229039_10_).endVertex();
	}

	@Override
	public ResourceLocation getTextureLocation(EntityFirstBeastBolt entity) {
		return TEXTURE;
	}

	@Override
	@SuppressWarnings("unused")
	public void render(EntityFirstBeastBolt entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int packedLightIn) {
		matrixStackIn.pushPose();
		matrixStackIn.mulPose(
				Vector3.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F).toMoj());
		matrixStackIn.mulPose(Vector3.ZP.rotationDegrees(Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())).toMoj());
		int i = 0;
		float f = 0.0F;
		float f1 = 0.5F;
		float f2 = 0.0F;
		float f3 = 0.15625F;
		float f4 = 0.0F;
		float f5 = 0.15625F;
		float f6 = 0.15625F;
		float f7 = 0.3125F;
		float f8 = 0.05625F;
		float f9 = entityIn.shakeTime - partialTicks;
		if (f9 > 0.0F) {
			float f10 = -Mth.sin(f9 * 3.0F) * f9;
			matrixStackIn.mulPose(Vector3.ZP.rotationDegrees(f10).toMoj());
		}

		matrixStackIn.mulPose(Vector3.XP.rotationDegrees(45.0F).toMoj());
		matrixStackIn.scale(0.05625F, 0.05625F, 0.05625F);
		matrixStackIn.translate(-4.0D, 0.0D, 0.0D);
		VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutout(TEXTURE));
		PoseStack.Pose matrixstack$entry = matrixStackIn.last();
		Matrix4f matrix4f = matrixstack$entry.pose();
		Matrix3f matrix3f = matrixstack$entry.normal();
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, -2, -2, 0.0F, 0.15625F, -1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, -2, 2, 0.15625F, 0.15625F, -1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, 2, 2, 0.15625F, 0.3125F, -1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, 2, -2, 0.0F, 0.3125F, -1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, 2, -2, 0.0F, 0.15625F, 1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, 2, 2, 0.15625F, 0.15625F, 1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, -2, 2, 0.15625F, 0.3125F, 1, 0, 0, packedLightIn);
		this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -7, -2, -2, 0.0F, 0.3125F, 1, 0, 0, packedLightIn);

		for (int j = 0; j < 4; ++j) {
			matrixStackIn.mulPose(Vector3.XP.rotationDegrees(90.0F).toMoj());
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -8, -2, 0, 0.0F, 0.0F, 0, 1, 0, packedLightIn);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, 8, -2, 0, 0.5F, 0.0F, 0, 1, 0, packedLightIn);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, 8, 2, 0, 0.5F, 0.15625F, 0, 1, 0, packedLightIn);
			this.drawVertex(matrix4f, matrix3f, ivertexbuilder, -8, 2, 0, 0.0F, 0.15625F, 0, 1, 0, packedLightIn);
		}

		matrixStackIn.popPose();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
}
