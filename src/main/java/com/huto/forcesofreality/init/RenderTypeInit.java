package com.huto.forcesofreality.init;

import java.util.OptionalDouble;

import org.lwjgl.opengl.GL11;

import com.huto.forcesofreality.ForcesOfReality;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.client.renderer.RenderStateShard.LineStateShard;

public class RenderTypeInit extends RenderType {
	private final static ResourceLocation laserBeam = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/misc/laser.png");
	private final static ResourceLocation laserBeam2 = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/misc/laser2.png");
	private final static ResourceLocation laserBeamGlow = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/misc/laser_glow.png");
	private final static ResourceLocation orbTrans = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/blocks/sphere_outside_trans.png");
	private final static ResourceLocation hastur_pylon = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/blocks/hastur_pylon.png");
	private final static ResourceLocation end_trans = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/blocks/end_portal.png");

	public RenderTypeInit(String nameIn, VertexFormat formatIn, int drawModeIn, int bufferSizeIn, boolean useDelegateIn,
			boolean needsSortingIn, Runnable setupTaskIn, Runnable clearTaskIn) {
		super(nameIn, formatIn, drawModeIn, bufferSizeIn, useDelegateIn, needsSortingIn, setupTaskIn, clearTaskIn);
	}

	@SuppressWarnings("unused")
	private static final LineStateShard THICK_LINES = new LineStateShard(OptionalDouble.of(3.0D));

	public static final RenderType TRANSLUCENT = makeType("testTrans", DefaultVertexFormats.POSITION_COLOR_TEX, 7, 256,
			false, true, State.getBuilder().texture(new TextureState(orbTrans, false, false))
					.transparency(CRUMBLING_TRANSPARENCY).writeMask(COLOR_DEPTH_WRITE).build(false));

	public static final RenderType HASTURTRANS = makeType("hasturTrans", DefaultVertexFormats.POSITION_COLOR_TEX, 7,
			256, false, true,
			State.getBuilder().texture(new TextureState(hastur_pylon, false, false))
					.transparency(CRUMBLING_TRANSPARENCY).writeMask(COLOR_DEPTH_WRITE).layer(VIEW_OFFSET_Z_LAYERING)
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

	public static final RenderType LASER_MAIN_ADDITIVE = makeType("LaserAdditiveBeam",
			DefaultVertexFormats.POSITION_COLOR_TEX, GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().texture(new TextureState(laserBeamGlow, false, false))
					.transparency(TRANSLUCENT_TRANSPARENCY).depthTest(DEPTH_ALWAYS).writeMask(COLOR_DEPTH_WRITE)
					.build(false));

	public static final RenderType LASER_MAIN_CORE = makeType("LaserCoreBeam",
			DefaultVertexFormats.POSITION_COLOR_TEX, GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().texture(new TextureState(laserBeam, false, false))
					.transparency(TRANSLUCENT_TRANSPARENCY).depthTest(DEPTH_ALWAYS).writeMask(COLOR_DEPTH_WRITE)
					.build(false));

	public static RenderType SolidBlockOverlay = makeType("SolidBlockOverlay", DefaultVertexFormats.POSITION_COLOR,
			GL11.GL_QUADS, 256,
			RenderType.State.getBuilder().layer(VIEW_OFFSET_Z_LAYERING).transparency(TRANSLUCENT_TRANSPARENCY)
					.texture(NO_TEXTURE).depthTest(DEPTH_LEQUAL).cull(CULL_DISABLED).lightmap(LIGHTMAP_DISABLED)
					.writeMask(COLOR_WRITE).build(false));

	
	public static final IParticleRenderType EMBER_RENDER = new IParticleRenderType() {
		@SuppressWarnings("deprecation")
		@Override
		public void beginRender(BufferBuilder buffer, TextureManager textureManager) {

			RenderSystem.disableAlphaTest();
			RenderSystem.enableBlend();
			RenderSystem.alphaFunc(516, 0.3f);
			RenderSystem.enableCull();
			textureManager.bindTexture(AtlasTexture.LOCATION_PARTICLES_TEXTURE);
			RenderSystem.depthMask(false);
			RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA.param, GlStateManager.DestFactor.ONE.param);
			buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
		}

		@SuppressWarnings("deprecation")
		@Override
		public void finishRender(Tessellator tessellator) {
			tessellator.draw();
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();

			RenderSystem.depthMask(true);
			RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA.param, GlStateManager.DestFactor.ONE.param);
			RenderSystem.disableCull();
			RenderSystem.alphaFunc(516, 0.1F);
		}

		@Override
		public String toString() {
			return "forcesofreality:em_rend";
		}
	};

}