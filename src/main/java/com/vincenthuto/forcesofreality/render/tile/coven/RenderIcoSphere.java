//package com.vincenthuto.forcesofreality.render.tile.coven;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.math.Vector3f;
//import com.vincenthuto.forcesofreality.init.RenderTypeInit;
//import com.vincenthuto.forcesofreality.model.block.ObjModelHandler;
//import com.vincenthuto.forcesofreality.tile.BlockEntityIcoSphere;
//
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
//import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
//import net.minecraftforge.common.util.NonNullLazy;
//
//public class RenderIcoSphere implements BlockEntityRenderer<BlockEntityIcoSphere> {
//	public static final NonNullLazy<ObjModelHandler> modelSphere = NonNullLazy
//			.of(() -> ObjModelHandler.of("forcesofreality:models/block/sphere.obj"));
//	public static final NonNullLazy<ObjModelHandler> modelSphereInside = NonNullLazy
//			.of(() -> ObjModelHandler.of("forcesofreality:models/block/sphere_inside.obj"));
//
//	public static final NonNullLazy<ObjModelHandler> modelTorus = NonNullLazy
//			.of(() -> ObjModelHandler.of("forcesofreality:models/block/torus.obj"));
//
//	public static final NonNullLazy<ObjModelHandler> modelHexTorus = NonNullLazy
//			.of(() -> ObjModelHandler.of("forcesofreality:models/block/hextorus.obj"));
//
//	float count = 5.5f;
//
//	public RenderIcoSphere(BlockEntityRenderDispatcher rendererDispatcherIn) {
//		super();
//	}
//
//	@SuppressWarnings("deprecation")
//	@Override
//	public void render(BlockEntityIcoSphere te, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn,
//			int combinedLightIn, int combinedOverlayIn) {
//
//	//	GlStateManager._color4f(1F, 1F, 1F, 1F);
//	//	GlStateManager._translated(te.getBlockPos().getX(), te.getBlockPos().getY(), te.getBlockPos().getZ());
//
//		for (int i = 0; i < 16; i++) {
//			count += 0.0002;
//			if (count > 12) {
//				count = 5.5f;
//			}
//		}
//		// System.out.println(count);
//		// count =9;
//		// Changing the tan to sin/cos to other fun stuff can do neat things
//		// float rotationRate = (float) Math.sin(count *4) + (float) Math.tan(count *4);
//		float rotationRate = count * 20;
//
//		// Spheres
//		matrixStackIn.pushPose();
//		matrixStackIn.translate(0.5, 0.5, 0.5);
//		matrixStackIn.mulPose(Vector3f.YP.rotation(rotationRate));
//
//		matrixStackIn.scale(5, 5, 5);
//		modelSphereInside.get().render(bufferIn, RenderTypeInit.SPHEREIN, matrixStackIn, 0x00F000F0, 0x8f8f8f);
//		modelSphere.get().render(bufferIn, RenderTypeInit.SPHEREIN, matrixStackIn, 0x00F000F0, 0xBEAE00);
//		matrixStackIn.scale(0.95f, 0.95f, 0.95f);
//		modelSphereInside.get().render(bufferIn, RenderTypeInit.SPHEREIN, matrixStackIn, 0x00F000F0, 0x8f8f8f);
//		modelSphere.get().render(bufferIn, RenderTypeInit.SPHEREIN, matrixStackIn, 0x00F000F0, 0xBEAE00);
//		matrixStackIn.popPose();
//
//		// Torus
//		matrixStackIn.pushPose();
//		matrixStackIn.translate(0.5, 0.5, 0.5);
//		matrixStackIn.mulPose(Vector3f.YN.rotation(rotationRate));
//		matrixStackIn.scale(8 * 2.8f, 8 * 1f, 8 * 2.8f);
//		modelTorus.get().render(bufferIn, RenderTypeInit.ENDTRANS, matrixStackIn, combinedLightIn, 0xFF8400);
//		matrixStackIn.scale(0.9f, 0.9f, 0.9f);
//		modelTorus.get().render(bufferIn, RenderTypeInit.ENDTRANS, matrixStackIn, combinedLightIn, 0xFF8400);
//		matrixStackIn.popPose();
//
//	}
//
//}
