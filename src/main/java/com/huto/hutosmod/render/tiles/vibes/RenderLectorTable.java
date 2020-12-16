package com.huto.hutosmod.render.tiles.vibes;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.capabilities.vibes.chunk.ChunkVibrationProvider;
import com.huto.hutosmod.capabilities.vibes.chunk.IChunkVibrations;
import com.huto.hutosmod.objects.tileenties.vibes.TileEntityLectorTable;
import com.huto.hutosmod.render.effects.LectorGridPosVector;
import com.huto.hutosmod.render.effects.LectorVectorColorData;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class RenderLectorTable extends TileEntityRenderer<TileEntityLectorTable> {
	LectorVectorColorData red = new LectorVectorColorData(255, 0, 0, 255);
	LectorVectorColorData green = new LectorVectorColorData(0, 255, 0, 255);
	LectorVectorColorData blue = new LectorVectorColorData(0, 0, 255, 255);
	LectorVectorColorData purple = new LectorVectorColorData(255, 0, 255, 255);
	LectorVectorColorData yellow = new LectorVectorColorData(255, 255, 0, 255);
	LectorVectorColorData white = new LectorVectorColorData(255, 255, 255, 255);
	LectorVectorColorData black = new LectorVectorColorData(0, 0, 0, 255);
	LectorVectorColorData[] colors = { red, green, blue, purple, yellow, black, white };

	public RenderLectorTable(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntityLectorTable te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		ResourceLocation GLASSTEXTURE = new ResourceLocation(HutosMod.MOD_ID, "textures/blocks/lector_square.png");

		matrixStackIn.push();
		IVertexBuilder builder = bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE));
		PlayerEntity player = Minecraft.getInstance().player;
		World world = player.getEntityWorld();
		Chunk mainChunk = world.getChunkAt(te.getPos());

		// System.out.println(te.getGridScale());
		switch (te.getGridScale()) {
		case (1):
			matrixStackIn.translate(0.125, 0.5, 0.375);
			break;
		case (3):
			matrixStackIn.translate(-0.125, 0.5, 0.125);
			break;
		case (5):
			matrixStackIn.translate(-0.375, 0.5, -.125);
			break;
		case (7):
			matrixStackIn.translate(-.625f, 0.5, -.375);
			break;
		case (9):
			matrixStackIn.translate(-0.875f, 0.5, -0.625f);
			break;

		}
		matrixStackIn.scale(0.5f, 0.5f, 0.5f);
		float yMod = 0.1f;
		float distMod = (float) (yMod * 1.2f + (0.05f * Math.sin(te.getWorld().getGameTime() * 0.25f)));
		// biomeColor = mcBiomeList.contains(6) ? green : red;
		// gridsize x gridsize
		int gridSize = te.getGridScale();
		float gridSpacing = 0.5f;
		// This isnt a perfect formula but it does work on the levels 1,3,5,7,9
		int centerMod = gridSize == 1 ? 1 : gridSize != 3 ? ((gridSize + 2) % gridSize) + (gridSize / 3) : 2;
		// The most northwest chunk
		ChunkPos startingChunk = new ChunkPos(mainChunk.getPos().x - centerMod, mainChunk.getPos().z - centerMod);
		for (int x = 1; x < gridSize + 1; x++) {
			for (int z = 1; z < gridSize + 1; z++) {
				ChunkPos nextChunk = new ChunkPos(startingChunk.x + (x), startingChunk.z + (z));
				IChunkVibrations directedChunkVibe = world.getChunk(nextChunk.x, nextChunk.z)
						.getCapability(ChunkVibrationProvider.CHUNK_ENERGY_CHUNK_CAPABILITY)
						.orElseThrow(NullPointerException::new);
				LectorVectorColorData gridColor = new LectorVectorColorData(
						(Math.max(0, Math.abs(255-directedChunkVibe.getEnergyStored()))), Math.max(directedChunkVibe.getEnergyStored() - 1,0), 0, 255);
				
				System.out.println(Math.max(directedChunkVibe.getEnergyStored() - 1,2));
				
				createSquare(matrixStackIn, builder, combinedLightIn,
						new LectorGridPosVector(0 + (gridSpacing * x), 0.8f + yMod + distMod, 0 + (gridSpacing * z)),
						new LectorGridPosVector(0.5f + (gridSpacing * x), 0.8f + yMod + distMod, 0 + (gridSpacing * z)),
						new LectorGridPosVector(0.5f + (gridSpacing * x), 0.8f + yMod + distMod,
								-0.5f + (gridSpacing * z)),
						new LectorGridPosVector(0 + (gridSpacing * x), 0.8f + yMod + distMod,
								-0.5f + (gridSpacing * z)),
						gridColor);

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
		builderIn.pos(matrixStackIn.getLast().getMatrix(), vec1.getX(), vec1.getY(), vec1.getZ()).color(r, g, b, 255)
				.tex(1, 1).overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builderIn.pos(matrixStackIn.getLast().getMatrix(), vec2.getX(), vec2.getY(), vec2.getZ()).color(r, g, b, 255)
				.tex(1, 0).overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builderIn.pos(matrixStackIn.getLast().getMatrix(), vec3.getX(), vec3.getY(), vec3.getZ()).color(r, g, b, 255)
				.tex(0, 0).overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builderIn.pos(matrixStackIn.getLast().getMatrix(), vec4.getX(), vec4.getY(), vec4.getZ()).color(r, g, b, 255)
				.tex(0, 1).overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();

		matrixStackIn.pop();

	}

	public boolean isChunkVibeFull(IChunkVibrations currentChunkCap) {
		return currentChunkCap.canReceive() ? false : true;
	}
}
