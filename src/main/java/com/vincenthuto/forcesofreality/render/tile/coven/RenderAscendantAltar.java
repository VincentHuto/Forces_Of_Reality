package com.vincenthuto.forcesofreality.render.tile.coven;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.vincenthuto.forcesofreality.render.tile.ClientTickHandler;
import com.vincenthuto.forcesofreality.tile.coven.BlockEntityAscendantAltar;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class RenderAscendantAltar implements BlockEntityRenderer<BlockEntityAscendantAltar> {
//	private final ModelFloatingCandle black_candle = new ModelFloatingCandle();

	public RenderAscendantAltar(BlockEntityRendererProvider.Context rendererDispatcherIn) {
	}

	@Override
	public void render(BlockEntityAscendantAltar te, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {

		matrixStackIn.pushPose();

		matrixStackIn.translate(0.5, 1.8, 0.5);
		matrixStackIn.scale(0.5f, -0.5f, 0.5f);
		// Cubes
		for (int i = 0; i < te.clientDevo; i++) {
			double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
			final float modifier = 6F;
			final float rotationModifier = 0.2F;
			final float radiusBase = 0.9F;
			final float radiusMod = 0.0F;
			int cubes = te.clientDevo;
			float offsetPerCube = 90 / cubes;
			float offset = offsetPerCube * i;
			float deg = (int) (ticks / rotationModifier % 360F + offset);
			float rad = deg * (float) Math.PI / 180F;
			float radiusX = (float) (radiusBase + radiusMod * Math.sin(ticks / modifier));
			float radiusZ = (float) (radiusBase + radiusMod * Math.cos(ticks / modifier));
			float x = (float) (radiusX * Math.cos(rad));
			float z = (float) (radiusZ * Math.sin(rad));
			float y = (float) Math.cos((ticks + 50 * i) / 5F) / 10F;
			matrixStackIn.pushPose();
			matrixStackIn.translate(x, y, z);
			float yRotate = (float) Math.max(0.6F, Math.sin(ticks * 0.1F) / 2F + 0.5F);
			matrixStackIn.mulPose(Vector3.YP.rotation(yRotate).toMoj());
			MultiBufferSource.BufferSource irendertypebuffer$impl = MultiBufferSource
					.immediate(Tesselator.getInstance().getBuilder());
			//VertexConsumer ivertexbuilder = irendertypebuffer$impl.getBuffer(black_candle
			//		.renderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/entity/black_candle.png")));
//			black_candle.renderToBuffer(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F,
//					1.0F, 0.5F);
			irendertypebuffer$impl.endBatch();
			matrixStackIn.popPose();

		}
		matrixStackIn.popPose();

	}
}
