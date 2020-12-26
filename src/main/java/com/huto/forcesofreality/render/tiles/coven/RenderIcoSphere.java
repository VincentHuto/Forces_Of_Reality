package com.huto.forcesofreality.render.tiles.coven;

import com.huto.forcesofreality.init.RenderTypeInit;
import com.huto.forcesofreality.models.block.ObjModelHandler;
import com.huto.forcesofreality.objects.tileenties.TileEntityIcoSphere;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.common.util.NonNullLazy;

public class RenderIcoSphere extends TileEntityRenderer<TileEntityIcoSphere> {
	public static final NonNullLazy<ObjModelHandler> modelSphere = NonNullLazy
			.of(() -> ObjModelHandler.of("forcesofreality:models/block/sphere.obj"));
	public static final NonNullLazy<ObjModelHandler> modelSphereInside = NonNullLazy
			.of(() -> ObjModelHandler.of("forcesofreality:models/block/sphere_inside.obj"));

	public static final NonNullLazy<ObjModelHandler> modelTorus = NonNullLazy
			.of(() -> ObjModelHandler.of("forcesofreality:models/block/torus.obj"));

	public static final NonNullLazy<ObjModelHandler> modelHexTorus = NonNullLazy
			.of(() -> ObjModelHandler.of("forcesofreality:models/block/hextorus.obj"));

	float count = 5.5f;

	public RenderIcoSphere(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityIcoSphere te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		GlStateManager.pushMatrix();
		GlStateManager.color4f(1F, 1F, 1F, 1F);
		GlStateManager.translated(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
		GlStateManager.popMatrix();
		for (int i = 0; i < 16; i++) {
			count += 0.0002;
			if (count > 12) {
				count = 5.5f;
			}
		}
		// System.out.println(count);
		// count =9;
		// Changing the tan to sin/cos to other fun stuff can do neat things
		// float rotationRate = (float) Math.sin(count *4) + (float) Math.tan(count *4);
		float rotationRate = count * 20;

		// Spheres
		matrixStackIn.push();
		matrixStackIn.translate(0.5, 0.5, 0.5);
		matrixStackIn.rotate(Vector3f.YP.rotation(rotationRate));

		matrixStackIn.scale(5, 5, 5);
		modelSphereInside.get().render(bufferIn, RenderTypeInit.SPHEREIN, matrixStackIn, 0x00F000F0, 0x8f8f8f);
		modelSphere.get().render(bufferIn, RenderTypeInit.SPHEREIN, matrixStackIn, 0x00F000F0, 0xBEAE00);
		matrixStackIn.scale(0.95f, 0.95f, 0.95f);
		modelSphereInside.get().render(bufferIn, RenderTypeInit.SPHEREIN, matrixStackIn, 0x00F000F0, 0x8f8f8f);
		modelSphere.get().render(bufferIn, RenderTypeInit.SPHEREIN, matrixStackIn, 0x00F000F0, 0xBEAE00);
		matrixStackIn.pop();

		// Torus
		matrixStackIn.push();
		matrixStackIn.translate(0.5, 0.5, 0.5);
		matrixStackIn.rotate(Vector3f.YN.rotation(rotationRate));
		matrixStackIn.scale(8 * 2.8f, 8 * 1f, 8 * 2.8f);
		modelTorus.get().render(bufferIn, RenderTypeInit.ENDTRANS, matrixStackIn, combinedLightIn, 0xFF8400);
		matrixStackIn.scale(0.9f, 0.9f, 0.9f);
		modelTorus.get().render(bufferIn, RenderTypeInit.ENDTRANS, matrixStackIn, combinedLightIn, 0xFF8400);
		matrixStackIn.pop();

	}

}
