package com.huto.hutosmod.render.tiles.vibes;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.capabilities.vibes.chunk.ChunkVibrationProvider;
import com.huto.hutosmod.capabilities.vibes.chunk.IChunkVibrations;
import com.huto.hutosmod.objects.tileenties.vibes.TileEntityLectorTable;
import com.huto.hutosmod.render.effects.LectorVectorColorData;
import com.huto.hutosmod.render.effects.RenderShapes;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
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
		ResourceLocation GLASSTEXTURE = new ResourceLocation(HutosMod.MOD_ID, "textures/blocks/lector_square.png");

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
					gridColor = new LectorVectorColorData(
							(Math.max(0, Math.abs(250 - directedChunkVibe.getEnergyStored()))),
							Math.max(directedChunkVibe.getEnergyStored()+ (chunkHeight * 0.95f) - 1 , 1), 0, 255);
				}
				if (nextChunk == mainChunk) {
					matrixStackIn.push();
					RenderShapes.renderSizedOctahedron(matrixStackIn, bufferIn, 15728640, combinedOverlayIn,
							builder, 1, gridSpacing * (x * 1.01f), 2.1f + yMod + distMod + chunkHeightMod,
							gridSpacing * (z * 1.01f), 0.5f, 0.5f, 0.5f);
					matrixStackIn.pop();
				}

				// Draws the grid
				RenderShapes.renderSizedColorRectangle(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn,
						builder, gridSpacing * (x * 1.001f), 1.1f + yMod + distMod + chunkHeightMod,
						gridSpacing * (z * 1.001f), 0.5f, 0.5f, 0.5f, gridColor, -chunkHeightMod);
			}
		}
		matrixStackIn.pop();
	}

	public boolean isChunkVibeFull(IChunkVibrations currentChunkCap) {
		return currentChunkCap.canReceive() ? false : true;
	}
}
