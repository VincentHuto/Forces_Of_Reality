package com.vincenthuto.forcesofreality.client.render.tile.coven;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.client.model.block.ModelHasturPylon;
import com.vincenthuto.forcesofreality.client.render.tile.ClientTickHandler;
import com.vincenthuto.forcesofreality.common.tile.coven.BlockEntityHasturPylon;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class RenderHasturPylon implements BlockEntityRenderer<BlockEntityHasturPylon> {
	private final ModelHasturPylon pylon;
//	public static final NonNullLazy<ObjModelHandler> modelTorus = NonNullLazy
//			.of(() -> ObjModelHandler.of("forcesofreality:models/block/torus.obj"));

	public RenderHasturPylon(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		pylon = new ModelHasturPylon(rendererDispatcherIn.bakeLayer(ModelHasturPylon.LAYER_LOCATION));
	}

	@Override
	public void render(BlockEntityHasturPylon te, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {

		// Cubes
		matrixStackIn.translate(0.5, 1.6, 0.5);
		double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
		float y = (float) Math.cos((ticks + 50) / 5F) / 10F;
		matrixStackIn.pushPose();
		matrixStackIn.translate(0, y, 0);
		matrixStackIn.mulPose(Vector3.YP.rotation((float) (0.05 * ticks)).toMoj());
		matrixStackIn.mulPose(Vector3.ZN.rotationDegrees(180).toMoj());
		MultiBufferSource.BufferSource impl = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());
		VertexConsumer ivertexbuilder = impl.getBuffer(
				pylon.renderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/block/hastur_pylon.png")));
		pylon.renderToBuffer(matrixStackIn, ivertexbuilder, combinedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F,
				1.0F, 1.0F);
		impl.endBatch();
		matrixStackIn.popPose();

	}

}
