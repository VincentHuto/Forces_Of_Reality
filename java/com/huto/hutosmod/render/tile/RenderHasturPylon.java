package com.huto.hutosmod.render.tile;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLX14;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.models.ModelHasturPylon;
import com.huto.hutosmod.objects.tileenties.TileEntityHasturPylon;
import com.huto.hutosmod.objects.tileenties.util.ClientTickHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.util.LWJGLMemoryUntracker;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class RenderHasturPylon extends TileEntityRenderer<TileEntityHasturPylon> {
	private final ModelHasturPylon pylon = new ModelHasturPylon();

	public RenderHasturPylon(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityHasturPylon te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		GlStateManager.pushMatrix();
		GlStateManager.color4f(1F, 1F, 1F, 1F);
		GlStateManager.translated(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
		GlStateManager.popMatrix();

		// Cubes
		matrixStackIn.translate(0.5, 1.6, 0.5);
		double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
		float y = (float) Math.cos((ticks + 50) / 5F) / 10F;
		matrixStackIn.push();
		matrixStackIn.translate(0, y, 0);
		matrixStackIn.rotate(Vector3f.YP.rotation((float) (0.05 * ticks)));
		matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(180));
		IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer
				.getImpl(Tessellator.getInstance().getBuffer());
		IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(
				pylon.getRenderType(new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/hastur_pylon.png")));
		pylon.render(matrixStackIn, ivertexbuilder, combinedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		irendertypebuffer$impl.finish();
		matrixStackIn.pop();

	/*	matrixStackIn.push();
		matrixStackIn.translate(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
		//drawSphere(10, 10, 10);
		matrixStackIn.pop();*/
		
		

	}

	public static void drawSphere(double r, int lats, int longs) {
		int i, j;
		for (i = 0; i <= lats; i++) {
			double lat0 = Math.PI * (-0.5 + (double) (i - 1) / lats);
			double z0 = Math.sin(lat0);
			double zr0 = Math.cos(lat0);

			double lat1 = Math.PI * (-0.5 + (double) i / lats);
			double z1 = Math.sin(lat1);
			double zr1 = Math.cos(lat1);
			GL11.glBegin(0x8);
			for (j = 0; j <= longs; j++) {
				double lng = 2 * Math.PI * (double) (j - 1) / longs;
				double x = Math.cos(lng);
				double y = Math.sin(lng);
				GL11.glNormal3d(x * zr0, y * zr0, z0);
				GL11.glVertex3d(r * x * zr0, r * y * zr0, r * z0);
				GL11.glNormal3d(x * zr1, y * zr1, z1);
				GL11.glVertex3d(r * x * zr1, r * y * zr1, r * z1);
			}
			GL11.glEnd();

		}

	}

}
