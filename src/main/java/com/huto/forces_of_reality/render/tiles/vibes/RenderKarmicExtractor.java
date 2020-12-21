package com.huto.forces_of_reality.render.tiles.vibes;

import com.huto.forces_of_reality.ForcesOfReality;
import com.huto.forces_of_reality.models.block.ModelFloatingCube;
import com.huto.forces_of_reality.objects.tileenties.util.ClientTickHandler;
import com.huto.forces_of_reality.objects.tileenties.vibes.func.TileEntityKarmicExtractor;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class RenderKarmicExtractor extends TileEntityRenderer<TileEntityKarmicExtractor> {
	private final ModelFloatingCube cube = new ModelFloatingCube();

	public RenderKarmicExtractor(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntityKarmicExtractor te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		// Cube
		double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3 * 0.14;
		float y = (float) Math.cos((ticks + 50) / 5F) / 10F;
		matrixStackIn.translate(0.5, 1.1, 0.5);
		matrixStackIn.scale(0.5f, 0.5f, 0.5f);
		matrixStackIn.push();
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees((float) ticks));
		matrixStackIn.translate(-0.125, y - 0.75, -0.125);
		matrixStackIn.scale(4, 4, 4);
		IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer
				.getImpl(Tessellator.getInstance().getBuffer());
		IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(
				cube.getRenderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/blocks/end_portal.png")));
		cube.render(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.5F);
		irendertypebuffer$impl.finish();
		matrixStackIn.pop();

		matrixStackIn.push();
		matrixStackIn.rotate(Vector3f.YN.rotationDegrees((float) ticks));

		matrixStackIn.translate(-0.125, y - 0.75, -0.125);
		matrixStackIn.scale(4, 4, 4);
		IRenderTypeBuffer.Impl irendertypebuffer$impl1 = IRenderTypeBuffer
				.getImpl(Tessellator.getInstance().getBuffer());
		IVertexBuilder ivertexbuilder1 = irendertypebuffer$impl1.getBuffer(
				cube.getRenderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/blocks/end_portal.png")));
		cube.render(matrixStackIn, ivertexbuilder1, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.5F);
		irendertypebuffer$impl1.finish();
		matrixStackIn.pop();

	}
}
