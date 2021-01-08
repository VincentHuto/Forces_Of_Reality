package com.huto.forcesofreality.render.tiles.coven;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.models.block.ModelFloatingCandle;
import com.huto.forcesofreality.objects.tileenties.coven.TileEntityAscendantAltar;
import com.huto.forcesofreality.objects.tileenties.util.ClientTickHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class RenderAscendantAltar extends TileEntityRenderer<TileEntityAscendantAltar> {
	private final ModelFloatingCandle black_candle = new ModelFloatingCandle();

	public RenderAscendantAltar(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntityAscendantAltar te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {

		matrixStackIn.push();

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
			matrixStackIn.push();
			matrixStackIn.translate(x, y, z);
			float yRotate = (float) Math.max(0.6F, Math.sin(ticks * 0.1F) / 2F + 0.5F);
			matrixStackIn.rotate(Vector3f.YP.rotation(yRotate));
			IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer
					.getImpl(Tessellator.getInstance().getBuffer());
			IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(black_candle
					.getRenderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/entity/black_candle.png")));
			black_candle.render(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F,
					0.5F);
			irendertypebuffer$impl.finish();
			matrixStackIn.pop();

		}
		matrixStackIn.pop();

	}
}
