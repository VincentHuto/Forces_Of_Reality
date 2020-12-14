package com.huto.hutosmod.render.tiles.vibes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.capabilities.vibes.IVibrations;
import com.huto.hutosmod.capabilities.vibes.VibrationProvider;
import com.huto.hutosmod.entities.utils.Vector3;
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
		IVibrations chunkVibes = mainChunk.getCapability(VibrationProvider.VIBE_CAPA).orElseThrow(NullPointerException::new);
		System.out.println(chunkVibes.getVibes());
		List<Integer> mcBiomeList = Arrays.stream(mainChunk.getBiomes().getBiomeIds()).boxed()
				.collect(Collectors.toList());
		Chunk xpChunk = world.getChunkAt(te.getPos().add(16, 0, 0));
		List<Integer> xpBiomeList = Arrays.stream(xpChunk.getBiomes().getBiomeIds()).boxed()
				.collect(Collectors.toList());
		Chunk xnChunk = world.getChunkAt(te.getPos().add(-16, 0, 0));
		List<Integer> xnBiomeList = Arrays.stream(xnChunk.getBiomes().getBiomeIds()).boxed()
				.collect(Collectors.toList());
		Chunk zpChunk = world.getChunkAt(te.getPos().add(0, 0, 16));
		List<Integer> zpBiomeList = Arrays.stream(zpChunk.getBiomes().getBiomeIds()).boxed()
				.collect(Collectors.toList());
		Chunk znChunk = world.getChunkAt(te.getPos().add(0, 0, -16));
		List<Integer> znBiomeList = Arrays.stream(znChunk.getBiomes().getBiomeIds()).boxed()
				.collect(Collectors.toList());
		List<PlayerEntity> players = world.getEntitiesWithinAABB(PlayerEntity.class, te.getRenderBoundingBox().grow(8));
		double closestDistance = 0;
		if (players.contains(player)) {
			for (PlayerEntity currentPlayer : players) {
				// Check if a player is nearby to decide if it gets rendered
				Vector3 blockVec = Vector3.fromTileEntity(te);
				Vector3 playerVec = Vector3.fromEntityCenter(currentPlayer);
				closestDistance = playerVec.distanceTo(blockVec);
				float mod = (float) (1 - (closestDistance * 0.25f) + 0.3f);
				if (mod > 1) {
					mod = 1;
				}
				if (mod < 0.25f) {
					mod = 0;
				}
				// Access Biomes for colors
				LectorVectorColorData biomeColor;

				float yMod = mod * 0.3f;
				matrixStackIn.translate(0.25, 0, 0.75);
				if (mod > 0.0f) {
					// Current Chunk
					biomeColor = mcBiomeList.contains(6) ? green : red;
					createSquare(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0, 0.8f + yMod, 0),
							new LectorGridPosVector(0.5f, 0.8f + yMod, 0),
							new LectorGridPosVector(0.5f, 0.8f + yMod, -0.5f),
							new LectorGridPosVector(0, 0.8f + yMod, -0.5f), biomeColor);
					// XP
					matrixStackIn.translate(1, 0, 0);
					biomeColor = xpBiomeList.contains(7) ? green : red;
					createSquare(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0, 0.8f + yMod, 0),
							new LectorGridPosVector(0.5f, 0.8f + yMod, 0),
							new LectorGridPosVector(0.5f, 0.8f + yMod, -0.5f),
							new LectorGridPosVector(0, 0.8f + yMod, -0.5f), biomeColor);

					// XN
					biomeColor = xnBiomeList.contains(6) ? green : red;
					matrixStackIn.translate(-2, 0, 0);
					createSquare(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0, 0.8f + yMod, 0),
							new LectorGridPosVector(0.5f, 0.8f + yMod, 0),
							new LectorGridPosVector(0.5f, 0.8f + yMod, -0.5f),
							new LectorGridPosVector(0, 0.8f + yMod, -0.5f), biomeColor);

					// ZP
					biomeColor = zpBiomeList.contains(1) ? green : red;
					matrixStackIn.translate(+1, 0, 1);
					createSquare(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0, 0.8f + yMod, 0),
							new LectorGridPosVector(0.5f, 0.8f + yMod, 0),
							new LectorGridPosVector(0.5f, 0.8f + yMod, -0.5f),
							new LectorGridPosVector(0, 0.8f + yMod, -0.5f), biomeColor);
					// ZN
					biomeColor = znBiomeList.contains(7) ? green : red;
					matrixStackIn.translate(0, 0, -2);
					createSquare(matrixStackIn, builder, combinedLightIn, new LectorGridPosVector(0, 0.8f + yMod, 0),
							new LectorGridPosVector(0.5f, 0.8f + yMod, 0),
							new LectorGridPosVector(0.5f, 0.8f + yMod, -0.5f),
							new LectorGridPosVector(0, 0.8f + yMod, -0.5f), biomeColor);
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
