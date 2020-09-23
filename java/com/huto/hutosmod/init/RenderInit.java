package com.huto.hutosmod.init;

import java.util.OptionalDouble;

import org.lwjgl.opengl.GL11;

import com.huto.hutosmod.HutosMod;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;

public class RenderInit extends RenderType {
	private final static ResourceLocation laserBeam = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/misc/laser.png");
	private final static ResourceLocation laserBeam2 = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/misc/laser2.png");
	private final static ResourceLocation laserBeamGlow = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/misc/laser_glow.png");

	public RenderInit(String nameIn, VertexFormat formatIn, int drawModeIn, int bufferSizeIn, boolean useDelegateIn,
			boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
		super(nameIn, formatIn, drawModeIn, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
	}

	private static final LineState THICK_LINES = new LineState(OptionalDouble.of(3.0D));

	public static final RenderType LASER_MAIN_BEAM = makeType("MiningLaserMainBeam",
			DefaultVertexFormats.POSITION_COLOR_TEX, GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().texture(new TextureState(laserBeam2, false, false)).layer(field_239235_M_)
					.transparency(TRANSLUCENT_TRANSPARENCY).depthTest(DEPTH_ALWAYS).cull(CULL_DISABLED)
					.lightmap(LIGHTMAP_DISABLED).writeMask(COLOR_WRITE).build(false));

	public static final RenderType LASER_MAIN_ADDITIVE = makeType("MiningLaserAdditiveBeam",
			DefaultVertexFormats.POSITION_COLOR_TEX, GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().texture(new TextureState(laserBeamGlow, false, false)).layer(field_239235_M_)
					.transparency(TRANSLUCENT_TRANSPARENCY).depthTest(DEPTH_ALWAYS).cull(CULL_DISABLED)
					.lightmap(LIGHTMAP_DISABLED).writeMask(COLOR_WRITE).build(false));

	public static final RenderType LASER_MAIN_CORE = makeType("MiningLaserCoreBeam",
			DefaultVertexFormats.POSITION_COLOR_TEX, GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().texture(new TextureState(laserBeam, false, false)).layer(field_239235_M_)
					.transparency(TRANSLUCENT_TRANSPARENCY).depthTest(DEPTH_ALWAYS).cull(CULL_DISABLED)
					.lightmap(LIGHTMAP_DISABLED).writeMask(COLOR_WRITE).build(false));

	public static final RenderType BlockOverlay = makeType("MiningLaserBlockOverlay",
			DefaultVertexFormats.POSITION_COLOR, GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().layer(field_239235_M_).transparency(TRANSLUCENT_TRANSPARENCY)
					.texture(NO_TEXTURE).depthTest(DEPTH_LEQUAL).cull(CULL_ENABLED).lightmap(LIGHTMAP_DISABLED)
					.writeMask(COLOR_DEPTH_WRITE).build(false));

	public static final RenderType RenderBlock = makeType("MiningLaserRenderBlock", DefaultVertexFormats.BLOCK,
			GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().shadeModel(SHADE_ENABLED).lightmap(LIGHTMAP_ENABLED)
					.texture(BLOCK_SHEET_MIPPED).layer(field_239235_M_).transparency(TRANSLUCENT_TRANSPARENCY)
					.depthTest(DEPTH_LEQUAL).cull(CULL_ENABLED).writeMask(COLOR_WRITE).build(false));
}