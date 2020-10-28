package com.huto.hutosmod.init;

import java.util.OptionalDouble;

import org.lwjgl.opengl.GL11;

import com.huto.hutosmod.HutosMod;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;

public class RenderTypeInit extends RenderType {
	private final static ResourceLocation laserBeam = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/misc/laser.png");
	private final static ResourceLocation laserBeam2 = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/misc/laser2.png");
	private final static ResourceLocation laserBeamGlow = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/misc/laser_glow.png");
	private final static ResourceLocation orbTrans = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/blocks/sphere_outside_trans.png");
	private final static ResourceLocation hastur_pylon = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/blocks/hastur_pylon.png");
	private final static ResourceLocation end_trans = new ResourceLocation(
			HutosMod.MOD_ID + ":textures/blocks/end_portal.png");

	public RenderTypeInit(String nameIn, VertexFormat formatIn, int drawModeIn, int bufferSizeIn, boolean useDelegateIn,
			boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
		super(nameIn, formatIn, drawModeIn, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
	}

	@SuppressWarnings("unused")
	private static final LineState THICK_LINES = new LineState(OptionalDouble.of(3.0D));

	public static final RenderType TRANSLUCENT = makeType("testTrans", DefaultVertexFormats.POSITION_COLOR_TEX, 7, 256,
			false, true, State.getBuilder().texture(new TextureState(orbTrans, false, false))
					.transparency(CRUMBLING_TRANSPARENCY).writeMask(COLOR_DEPTH_WRITE).build(false));

	public static final RenderType HASTURTRANS = makeType("hasturTrans", DefaultVertexFormats.POSITION_COLOR_TEX, 7,
			256, false, true,
			State.getBuilder().texture(new TextureState(hastur_pylon, false, false))
					.transparency(CRUMBLING_TRANSPARENCY).writeMask(COLOR_DEPTH_WRITE).layer(field_239235_M_)
					.build(false));

	public static final RenderType SPHEREIN = makeType("sphereTrans", DefaultVertexFormats.POSITION_COLOR_TEX, 7, 256,
			false, true, State.getBuilder().texture(new TextureState(orbTrans, false, false))
					.transparency(CRUMBLING_TRANSPARENCY).writeMask(COLOR_DEPTH_WRITE).build(false));
	public static final RenderType ENDTRANS = makeType("end_trans", DefaultVertexFormats.POSITION_COLOR_TEX, 7, 256,
			false, true, State.getBuilder().texture(new TextureState(end_trans, false, false))
					.transparency(CRUMBLING_TRANSPARENCY).writeMask(COLOR_DEPTH_WRITE).build(false));

	public static final RenderType LASER_MAIN_BEAM = makeType("MiningLaserMainBeam",
			DefaultVertexFormats.POSITION_COLOR_TEX, GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().texture(new TextureState(laserBeam2, false, false))
					.transparency(TRANSLUCENT_TRANSPARENCY).depthTest(DEPTH_ALWAYS).writeMask(COLOR_DEPTH_WRITE)
					.build(false));

	public static final RenderType LASER_MAIN_ADDITIVE = makeType("MiningLaserAdditiveBeam",
			DefaultVertexFormats.POSITION_COLOR_TEX, GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().texture(new TextureState(laserBeamGlow, false, false))
					.transparency(TRANSLUCENT_TRANSPARENCY).depthTest(DEPTH_ALWAYS).writeMask(COLOR_DEPTH_WRITE)
					.build(false));

	public static final RenderType LASER_MAIN_CORE = makeType("MiningLaserCoreBeam",
			DefaultVertexFormats.POSITION_COLOR_TEX, GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().texture(new TextureState(laserBeam, false, false))
					.transparency(TRANSLUCENT_TRANSPARENCY).depthTest(DEPTH_ALWAYS).writeMask(COLOR_DEPTH_WRITE)
					.build(false));

	public static final RenderType BlockOverlay = makeType("MiningLaserBlockOverlay",
			DefaultVertexFormats.POSITION_COLOR, GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().layer(field_239235_M_).transparency(TRANSLUCENT_TRANSPARENCY)
					.texture(NO_TEXTURE).depthTest(DEPTH_LEQUAL).cull(CULL_ENABLED).lightmap(LIGHTMAP_DISABLED)
					.writeMask(COLOR_DEPTH_WRITE).build(false));

}