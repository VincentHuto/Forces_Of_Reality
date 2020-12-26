package com.huto.forcesofreality.render.tiles.vibes;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.models.block.ModelFloatingCube;
import com.huto.forcesofreality.objects.tileenties.util.ClientTickHandler;
import com.huto.forcesofreality.objects.tileenties.vibes.gen.TileEntityThermalInfluxer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class RenderThermalInfluxer extends TileEntityRenderer<TileEntityThermalInfluxer> {
	private final ModelFloatingCube cube = new ModelFloatingCube();

	public RenderThermalInfluxer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntityThermalInfluxer te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		// Cube
		double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3 * 0.14;
		matrixStackIn.push();
		matrixStackIn.translate(0.5, -0.5, 0.5);
		matrixStackIn.scale(3, 19, 3);
		if (te.canGenerate()) {
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) ticks));
		}
		IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer
				.getImpl(Tessellator.getInstance().getBuffer());
		IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(
				cube.getRenderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/blocks/end_portal_red.png")));
		cube.render(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		irendertypebuffer$impl.finish();
		matrixStackIn.pop();

		matrixStackIn.push();
		matrixStackIn.translate(0.5, -0.5, 0.5);
		matrixStackIn.scale(3, 19, 3);
		if (te.canGenerate()) {
			matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) ticks));
		}
		IRenderTypeBuffer.Impl irendertypebuffer$impl1 = IRenderTypeBuffer
				.getImpl(Tessellator.getInstance().getBuffer());
		IVertexBuilder ivertexbuilder1 = irendertypebuffer$impl1.getBuffer(
				cube.getRenderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/blocks/end_portal_red.png")));
		cube.render(matrixStackIn, ivertexbuilder1, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		irendertypebuffer$impl1.finish();
		matrixStackIn.pop();

	}
}
