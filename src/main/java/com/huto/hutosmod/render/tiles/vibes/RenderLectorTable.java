package com.huto.hutosmod.render.tiles.vibes;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.entities.utils.Vector3;
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
import net.minecraft.util.math.vector.Vector3f;

public class RenderLectorTable extends TileEntityRenderer<TileEntityLectorTable> {

	public RenderLectorTable(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntityLectorTable te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		ResourceLocation GLASSTEXTURE = new ResourceLocation(HutosMod.MOD_ID, "textures/blocks/lector_square.png");

		matrixStackIn.push();
		IVertexBuilder builder = bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE));

		// Top
		/*
		 * createSquare(matrixStackIn, builder, combinedLightIn, new
		 * LectorGridPosVector(0, 1, 0), new LectorGridPosVector(1, 1, 0), new
		 * LectorGridPosVector(1, 1, -1), new LectorGridPosVector(0, 1, -1), new
		 * LectorVectorColorData(16, 0, 16, 255));
		 */

		LectorVectorColorData red = new LectorVectorColorData(255, 0, 0, 255);
		LectorVectorColorData green = new LectorVectorColorData(0, 255, 0, 255);
		LectorVectorColorData blue = new LectorVectorColorData(0, 0, 255, 255);
		matrixStackIn.translate(-0.125f/2, 0, 0.125f/2);

		for (int x = 0; x <= 4; x++) {
			for (int y = 0; y <= 4; y++) {
				float count = x * y;
				float xMod = x * 0.25f;
				float yMod = y * 0.25f;
				if (count <= 3) {
					createSquare(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0 + xMod, 1.2f, 0 + yMod),
							new LectorGridPosVector(0.1f + xMod, 1.2f, 0 + yMod),
							new LectorGridPosVector(0.1f + xMod, 1.2f, -0.1f + yMod),
							new LectorGridPosVector(0 + xMod, 1.2f, -0.1f + yMod), red);
				}
				if (count > 3 && count <= 6) {
					createSquare(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0 + xMod, 1.2f, 0 + yMod),
							new LectorGridPosVector(0.1f + xMod, 1.2f, 0 + yMod),
							new LectorGridPosVector(0.1f + xMod, 1.2f, -0.1f +yMod),
							new LectorGridPosVector(0 + xMod, 1.2f, -0.1f + yMod), green);
				}
				if (count > 6) {
					createSquare(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0 + xMod, 1.2f, 0 + yMod),
							new LectorGridPosVector(0.1f + xMod, 1.2f, 0 + yMod),
							new LectorGridPosVector(0.1f + xMod, 1.2f, -0.1f + yMod),
							new LectorGridPosVector(0 + xMod, 1.2f, -0.1f + yMod), blue);
				}
			}

		}
		matrixStackIn.translate(0, -0.25f, 0);
		matrixStackIn.translate(0.5, 0, 0.50);
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(te.getWorld().getGameTime()));

		for (int x = 0; x <= 8; x++) {
			for (int y = 0; y <= 8; y++) {
				float count = x * y;
				float xMod = x * 0.25f;
				float yMod = y * 0.25f;
			/*	float xMod = x * 0.25f+te.getWorld().rand.nextFloat();
				float yMod = y * 0.25f+te.getWorld().rand.nextFloat();*/
				if (count <= 3) {
					createSquare(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0 + xMod, 1.2f, 0 + yMod),
							new LectorGridPosVector(0.1f + xMod, 1.2f, 0 + yMod),
							new LectorGridPosVector(0.1f + xMod, 1.2f, -0.1f + yMod),
							new LectorGridPosVector(0 + xMod, 1.2f, -0.1f + yMod), red);
				}
				if (count > 3 && count <= 6) {
					createSquare(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0 + xMod, 1.2f, 0 + yMod),
							new LectorGridPosVector(0.1f + xMod, 1.2f, 0 + yMod),
							new LectorGridPosVector(0.1f + xMod, 1.2f, -0.1f +yMod),
							new LectorGridPosVector(0 + xMod, 1.2f, -0.1f + yMod), green);
				}
				if (count > 6) {
					createSquare(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0 + xMod, 1.2f, 0 + yMod),
							new LectorGridPosVector(0.1f + xMod, 1.2f, 0 + yMod),
							new LectorGridPosVector(0.1f + xMod, 1.2f, -0.1f + yMod),
							new LectorGridPosVector(0 + xMod, 1.2f, -0.1f + yMod), blue);
				}
			}

		}

		matrixStackIn.pop();

	}

	public void createVertex(MatrixStack matrixStackIn, IVertexBuilder builderIn, int combinedLightIn,
			LectorGridPosVector gridIn, LectorVectorColorData colorDataIn) {
		builderIn.pos(matrixStackIn.getLast().getMatrix(), gridIn.getX(), gridIn.getY(), gridIn.getZ())
				.color(colorDataIn.getRed(), colorDataIn.getGreen(), colorDataIn.getBlue(), colorDataIn.getAlpha())
				.tex(1, 1).overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
	}

	public void createSquare(MatrixStack matrixStackIn, IVertexBuilder builderIn, int combinedLightIn,
			LectorGridPosVector vec1, LectorGridPosVector vec2, LectorGridPosVector vec3, LectorGridPosVector vec4,
			LectorVectorColorData colorDataIn) {
		matrixStackIn.push();
		int r = (int) colorDataIn.getRed(), g = (int) colorDataIn.getGreen(), b = (int) colorDataIn.getBlue();
		createVertex(matrixStackIn, builderIn, combinedLightIn, vec1, colorDataIn);
		createVertex(matrixStackIn, builderIn, combinedLightIn, vec2, colorDataIn);
		createVertex(matrixStackIn, builderIn, combinedLightIn, vec3, colorDataIn);
		builderIn.pos(matrixStackIn.getLast().getMatrix(), vec4.getX(), vec4.getY(), vec4.getZ()).color(r, g, b, 255)
				.tex(0, 1).overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		matrixStackIn.pop();

	}
}
