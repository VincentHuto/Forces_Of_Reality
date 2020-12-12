package com.huto.hutosmod.render.tiles.vibes;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.objects.tileenties.vibes.TileEntityLectorTable;
import com.huto.hutosmod.render.effects.LectorGridPosVector;
import com.huto.hutosmod.render.effects.LectorVectorColorData;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;

public class RenderLectorTable extends TileEntityRenderer<TileEntityLectorTable> {

	public RenderLectorTable(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntityLectorTable te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		ResourceLocation GLASSTEXTURE = new ResourceLocation(HutosMod.MOD_ID, "textures/blocks/machine_glass.png");

		matrixStackIn.push();
		IVertexBuilder builder = bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE));
		int color = 0xB6B900;
		int r = color >> 16 & 255, g = color >> 8 & 255, b = color & 255;
		matrixStackIn.translate(0, 0, 1);


		/*builder.pos(matrixStackIn.getLast().getMatrix(), 0, 1, 0).color(r, g, b, 255).tex(1, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), 1 , 1 , 0).color(r, g, b, 255)
				.tex(1, 0).overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), 1, 1, -1 )
				.color(r, g, b, 255).tex(0, 0).overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), 0, 1 , -1 ).color(r, g, b, 255)
				.tex(0, 1).overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();*/
		
		// Top
		createSquare(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0, 1, 0),
				new LectorGridPosVector(1, 1, 0), new LectorGridPosVector(1, 1, -1), new LectorGridPosVector(0, 1, -1),
				new LectorVectorColorData(r, g, b, 255));
		
	
		createVertex(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0, 1, 0), new LectorVectorColorData(r, g, b, 255)).endVertex();
		createVertex(matrixStackIn, builder, combinedLightIn, 	new LectorGridPosVector(1, 1, 0), new LectorVectorColorData(r, g, b, 255)).endVertex();
		createVertex(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(1, 1, -1), new LectorVectorColorData(r, g, b, 255)).endVertex();
		createVertex(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0, 1, -1), new LectorVectorColorData(r, g, b, 255)).endVertex();
		matrixStackIn.pop();

	}
	

	public static IVertexBuilder createVertex(MatrixStack matrixStackIn, IVertexBuilder builderIn, int combinedLightIn,
			LectorGridPosVector gridIn, LectorVectorColorData colorDataIn) {
		return builderIn.pos(matrixStackIn.getLast().getMatrix(), gridIn.getX(), gridIn.getY(), gridIn.getZ())
				.color(colorDataIn.getRed(), colorDataIn.getGreen(), colorDataIn.getBlue(), colorDataIn.getAlpha()).tex(1, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0);
	}

	public static void createSquare(MatrixStack matrixStackIn, IVertexBuilder builderIn, int combinedLightIn,
			LectorGridPosVector vec1, LectorGridPosVector vec2, LectorGridPosVector vec3, LectorGridPosVector vec4,
			LectorVectorColorData colorDataIn) {
		createVertex(matrixStackIn, builderIn, combinedLightIn, vec1, colorDataIn).endVertex();
		createVertex(matrixStackIn, builderIn, combinedLightIn, vec2, colorDataIn).endVertex();
		createVertex(matrixStackIn, builderIn, combinedLightIn, vec3, colorDataIn).endVertex();
		createVertex(matrixStackIn, builderIn, combinedLightIn, vec4, colorDataIn).endVertex();

	}
}

