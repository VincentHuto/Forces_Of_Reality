package com.huto.forcesofreality.render.tiles.vibes;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.capabilities.vibes.chunk.ChunkVibrationProvider;
import com.huto.forcesofreality.capabilities.vibes.chunk.IChunkVibrations;
import com.huto.forcesofreality.objects.tileenties.vibes.func.TileEntityLectorTable;
import com.huto.forcesofreality.render.effects.LectorVectorColorData;
import com.hutoslib.client.render.RenderShapes;
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
	LectorVectorColorData cyan = new LectorVectorColorData(0, 125, 125, 255);
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
		ResourceLocation GLASSTEXTURE = new ResourceLocation(ForcesOfReality.MOD_ID,
				"textures/blocks/lector_square.png");

		matrixStackIn.push();
		IVertexBuilder builder = bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE));
		PlayerEntity player = Minecraft.getInstance().player;
		World world = player.getEntityWorld();
		Chunk mainChunk = world.getChunkAt(te.getPos());

		switch (te.getGridScale()) {
		case (1):
			matrixStackIn.translate(0.125 + 0.1875, 0.5, 0.375 + 0.0625);
			break;
		case (3):
			matrixStackIn.translate(-0.125 + 0.31, 0.5, 0.125 + 0.1875);
			break;
		case (5):
			matrixStackIn.translate(-0.375 + 0.435, 0.5, -.125 + 0.31);
			break;
		case (7):
			matrixStackIn.translate(-.625f + 0.56, 0.5, -.375 + 0.435);
			break;
		case (9):
			matrixStackIn.translate(-0.875f + 0.687, 0.5, -0.625f + 0.562);
			break;

		}
		matrixStackIn.scale(0.25f, 0.25f, 0.25f);
		float yMod = 0.005f;
		float distMod = (float) (yMod * 1.2f + (0.05f * Math.sin(te.getWorld().getGameTime() * 0.25f)));
		// biomeColor = mcBiomeList.contains(6) ? green : red;
		// gridsize x gridsize
		int gridSize = te.getGridScale() * 1;
		float gridSpacing = 0.5f;
		// This isnt a perfect formula but it does work on the levels 1,3,5,7,9
		int centerMod = gridSize == 1 ? 1 : gridSize != 3 ? ((gridSize + 2) % gridSize) + (gridSize / 3) : 2;
		// The most northwest chunk
		ChunkPos startingChunk = new ChunkPos(mainChunk.getPos().x - centerMod, mainChunk.getPos().z - centerMod);
		for (int x = 1; x < gridSize + 1; x++) {
			for (int z = 1; z < gridSize + 1; z++) {
				// Current Chunk being drawn
				ChunkPos nextChunkPos = new ChunkPos(startingChunk.x + (x), startingChunk.z + (z));
				Chunk nextChunk = world.getChunk(nextChunkPos.x, nextChunkPos.z);
				int chunkHeight = nextChunk.getTopBlockY(net.minecraft.world.gen.Heightmap.Type.WORLD_SURFACE,
						nextChunkPos.x, nextChunkPos.z);
				float chunkHeightMod = (chunkHeight * 1.2f) * 0.005f;
				// Getting the vibrations in that chunk
				IChunkVibrations directedChunkVibe = world.getChunk(nextChunkPos.x, nextChunkPos.z)
						.getCapability(ChunkVibrationProvider.CHUNK_ENERGY_CHUNK_CAPABILITY)
						.orElseThrow(NullPointerException::new);
				LectorVectorColorData gridColor;
				if (directedChunkVibe.getEnergyStored() >= 1024) {
					gridColor = purple;
				} else if (directedChunkVibe.getEnergyStored() >= 768 && directedChunkVibe.getEnergyStored() < 1024) {
					gridColor = blue;
				} else if (directedChunkVibe.getEnergyStored() >= 512 && directedChunkVibe.getEnergyStored() < 768) {
					gridColor = cyan;
				} else {
					gridColor = new LectorVectorColorData(Math.abs(250 - directedChunkVibe.getEnergyStored()),
							Math.max(directedChunkVibe.getEnergyStored() - 1, 1), chunkHeight * 0.95f, 255);
				}
				if (te.clientVibes > 5) {
					if (nextChunk == mainChunk) {
						matrixStackIn.push();
						RenderShapes.renderSizedOctahedron(matrixStackIn, bufferIn, 15728640, combinedOverlayIn,
								builder, 1, gridSpacing * (x * 1.01f), 2.1f + yMod + distMod + chunkHeightMod,
								gridSpacing * (z * 1.01f), 0.5f, 0.5f, 0.5f);
						matrixStackIn.pop();
					}

					// Draws the grid
					renderSizedColorRectangle(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, builder,
							gridSpacing * (x * 1.001f), 1.1f + yMod + distMod + chunkHeightMod,
							gridSpacing * (z * 1.001f), 0.5f, 0.5f, 0.5f, gridColor, -chunkHeightMod);
				}
			}
		}
		matrixStackIn.pop();
	}

	public boolean isChunkVibeFull(IChunkVibrations currentChunkCap) {
		return currentChunkCap.canReceive() ? false : true;
	}

	public static void renderSizedColorRectangle(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
			int combinedLightIn, int combinedOverlayIn, IVertexBuilder builderIn, float xOffset, float yOffset,
			float zOffset, float xScale, float yScale, float zScale, LectorVectorColorData color, float endYPoint) {

		// Chest Panel
		matrixStackIn.push();
		IVertexBuilder builder = builderIn;
		int r = (int) color.getRed(), g = (int) color.getGreen(), b = (int) color.getBlue();

		matrixStackIn.translate(xOffset, yOffset, zOffset);
		// Top
		builder.pos(matrixStackIn.getLast().getMatrix(), 0, yScale, 0).color(r, g, b, 255).tex(1, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), xScale, yScale, 0).color(r, g, b, 255).tex(1, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), xScale, yScale, -zScale).color(r, g, b, 255).tex(0, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), 0, yScale, -zScale).color(r, g, b, 255).tex(0, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();

		// Bottom
		builder.pos(matrixStackIn.getLast().getMatrix(), 0, endYPoint + 0.0f, 0).color(r, g, b, 255).tex(1, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), xScale, endYPoint + 0, 0).color(r, g, b, 255).tex(1, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), xScale, endYPoint + 0, -zScale).color(r, g, b, 255).tex(0, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), 0, endYPoint + 0, -zScale).color(r, g, b, 255).tex(0, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();

		// North
		builder.pos(matrixStackIn.getLast().getMatrix(), xScale, endYPoint + 0.0f, -zScale).color(r, g, b, 255)
				.tex(1, 1).overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), 0f, endYPoint + 0, -zScale).color(r, g, b, 255).tex(1, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), 0f, yScale, -zScale).color(r, g, b, 255).tex(0, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), xScale, yScale, -zScale).color(r, g, b, 255).tex(0, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		// South
		builder.pos(matrixStackIn.getLast().getMatrix(), 0f, endYPoint + 0.0f, 0).color(r, g, b, 255).tex(1, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), 0f, yScale, 0).color(r, g, b, 255).tex(1, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), xScale, yScale, 0).color(r, g, b, 255).tex(0, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), xScale, endYPoint + 0f, 0).color(r, g, b, 255).tex(0, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();

		// East
		builder.pos(matrixStackIn.getLast().getMatrix(), xScale, endYPoint + 0.0f, 0).color(r, g, b, 255).tex(1, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), xScale, yScale, 0).color(r, g, b, 255).tex(1, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), xScale, yScale, -zScale).color(r, g, b, 255).tex(0, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), xScale, endYPoint + 0f, -zScale).color(r, g, b, 255).tex(0, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		// West
		builder.pos(matrixStackIn.getLast().getMatrix(), 0f, endYPoint + 0.0f, 0).color(r, g, b, 255).tex(1, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), 0f, yScale, 0).color(r, g, b, 255).tex(1, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), 0f, yScale, -zScale).color(r, g, b, 255).tex(0, 0)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();
		builder.pos(matrixStackIn.getLast().getMatrix(), 0, endYPoint + 0f, -zScale).color(r, g, b, 255).tex(0, 1)
				.overlay(OverlayTexture.NO_OVERLAY).lightmap(combinedLightIn)
				.normal(matrixStackIn.getLast().getNormal(), 0, 1, 0).endVertex();

		matrixStackIn.pop();

	}

	public static void renderSizedColoredCube(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
			int combinedLightIn, int combinedOverlayIn, IVertexBuilder builderIn, float xOffset, float yOffset,
			float zOffset, float xScale, float yScale, LectorVectorColorData color) {

		renderSizedColorRectangle(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, builderIn, xOffset,
				yOffset, zOffset, xScale, yScale, xScale, color, 0);
	}
}