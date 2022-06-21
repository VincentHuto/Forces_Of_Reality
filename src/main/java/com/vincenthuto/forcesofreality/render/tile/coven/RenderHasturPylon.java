package com.vincenthuto.forcesofreality.render.tile.coven;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.math.Vector3f;
import com.vincenthuto.forcesofreality.render.tile.ClientTickHandler;
import com.vincenthuto.forcesofreality.tile.coven.BlockEntityHasturPylon;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class RenderHasturPylon implements BlockEntityRenderer<BlockEntityHasturPylon> {
//	private final ModelHasturPylon pylon = new ModelHasturPylon();
//	public static final NonNullLazy<ObjModelHandler> modelTorus = NonNullLazy
//			.of(() -> ObjModelHandler.of("forcesofreality:models/block/torus.obj"));

	public RenderHasturPylon(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(BlockEntityHasturPylon te, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
		
		

		// Cubes
		matrixStackIn.translate(0.5, 1.6, 0.5);
		double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
		float y = (float) Math.cos((ticks + 50) / 5F) / 10F;
		matrixStackIn.pushPose();
		matrixStackIn.translate(0, y, 0);
		matrixStackIn.mulPose(Vector3f.YP.rotation((float) (0.05 * ticks)));
		matrixStackIn.mulPose(Vector3f.ZN.rotationDegrees(180));
		MultiBufferSource.BufferSource impl = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());
		//VertexConsumer ivertexbuilder = impl.getBuffer(
		//		pylon.renderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/blocks/hastur_pylon.png")));
	//	pylon.renderToBuffer(matrixStackIn, ivertexbuilder, combinedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F,
		//		1.0F, 1.0F);
		impl.endBatch();
		matrixStackIn.popPose();

	}

}
