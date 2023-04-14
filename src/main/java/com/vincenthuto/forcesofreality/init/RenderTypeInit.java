package com.vincenthuto.forcesofreality.init;

import java.util.OptionalDouble;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat.Mode;
import com.vincenthuto.forcesofreality.ForcesOfReality;

import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;

public class RenderTypeInit extends RenderType {

	private final static ResourceLocation laserBeam = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/misc/laser.png");

	private final static ResourceLocation laserBeam2 = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/misc/laser2.png");
	private final static ResourceLocation laserBeamGlow = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/misc/laser_glow.png");
	private final static ResourceLocation orbTrans = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/block/sphere_outside_trans.png");
	private final static ResourceLocation hastur_pylon = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/block/hastur_pylon.png");
	private final static ResourceLocation end_trans = new ResourceLocation(
			ForcesOfReality.MOD_ID + ":textures/block/end_portal.png");
	@SuppressWarnings("unused")
	private static final LineStateShard THICK_LINES = new LineStateShard(OptionalDouble.of(3.0D));

	public static final RenderType TRANSLUCENT = create("testTrans", DefaultVertexFormat.POSITION_COLOR_TEX,
			VertexFormat.Mode.QUADS, 256, false, true,
			CompositeState.builder().setTextureState(new TextureStateShard(orbTrans, false, false))
					.setTransparencyState(CRUMBLING_TRANSPARENCY).setWriteMaskState(COLOR_DEPTH_WRITE)
					.createCompositeState(false));

	public static final RenderType HASTURTRANS = create("hasturTrans", DefaultVertexFormat.POSITION_COLOR_TEX,
			VertexFormat.Mode.QUADS, 256, false, true,
			CompositeState.builder().setTextureState(new TextureStateShard(hastur_pylon, false, false))
					.setTransparencyState(CRUMBLING_TRANSPARENCY).setWriteMaskState(COLOR_DEPTH_WRITE)
					.setLayeringState(VIEW_OFFSET_Z_LAYERING).createCompositeState(false));

	public static final RenderType SPHEREIN = create("sphereTrans", DefaultVertexFormat.POSITION_COLOR_TEX,
			VertexFormat.Mode.QUADS, 256, false, true,
			CompositeState.builder().setTextureState(new TextureStateShard(orbTrans, false, false))
					.setTransparencyState(CRUMBLING_TRANSPARENCY).setWriteMaskState(COLOR_DEPTH_WRITE)
					.createCompositeState(false));

	public static final RenderType ENDTRANS = create("end_trans", DefaultVertexFormat.POSITION_COLOR_TEX,
			VertexFormat.Mode.QUADS, 256, false, true,
			CompositeState.builder().setTextureState(new TextureStateShard(end_trans, false, false))
					.setTransparencyState(CRUMBLING_TRANSPARENCY).setWriteMaskState(COLOR_DEPTH_WRITE)
					.createCompositeState(false));
	public static final RenderType LASER_MAIN_BEAM = create("MiningLaserMainBeam",
			DefaultVertexFormat.POSITION_COLOR_TEX, VertexFormat.Mode.QUADS, 256, false, true,
			RenderType.CompositeState.builder().setTextureState(new TextureStateShard(laserBeam2, false, false))
					.setTransparencyState(TRANSLUCENT_TRANSPARENCY).setDepthTestState(NO_DEPTH_TEST)
					.setWriteMaskState(COLOR_DEPTH_WRITE).createCompositeState(false));

	public static final RenderType LASER_MAIN_ADDITIVE = create("LaserAdditiveBeam",
			DefaultVertexFormat.POSITION_COLOR_TEX, VertexFormat.Mode.QUADS, 256, false, true,
			RenderType.CompositeState.builder().setTextureState(new TextureStateShard(laserBeamGlow, false, false))
					.setTransparencyState(TRANSLUCENT_TRANSPARENCY).setDepthTestState(NO_DEPTH_TEST)
					.setWriteMaskState(COLOR_DEPTH_WRITE).createCompositeState(false));

	public static final RenderType LASER_MAIN_CORE = create("LaserCoreBeam", DefaultVertexFormat.POSITION_COLOR_TEX,
			VertexFormat.Mode.QUADS, 256, false, true,
			RenderType.CompositeState.builder().setTextureState(new TextureStateShard(laserBeam, false, false))
					.setTransparencyState(TRANSLUCENT_TRANSPARENCY).setDepthTestState(NO_DEPTH_TEST)
					.setWriteMaskState(COLOR_DEPTH_WRITE).createCompositeState(false));

	public static RenderType SolidBlockOverlay = create("SolidBlockOverlay", DefaultVertexFormat.POSITION_COLOR,
			VertexFormat.Mode.QUADS, 256, false, true,
			RenderType.CompositeState.builder().setLayeringState(VIEW_OFFSET_Z_LAYERING)
					.setTransparencyState(TRANSLUCENT_TRANSPARENCY).setTextureState(NO_TEXTURE)
					.setDepthTestState(LEQUAL_DEPTH_TEST).setCullState(NO_CULL).setLightmapState(NO_LIGHTMAP)
					.setWriteMaskState(COLOR_WRITE).createCompositeState(false));

	public static final ParticleRenderType EMBER_RENDER = new ParticleRenderType() {
		@SuppressWarnings("deprecation")
		@Override
		public void begin(BufferBuilder buffer, TextureManager textureManager) {
			RenderSystem.enableBlend();
			RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA,
					GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			RenderSystem.enableCull();
			RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
			RenderSystem.depthMask(false);
			RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
			buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
		}

		@Override
		public void end(Tesselator tessellator) {
			tessellator.end();
			RenderSystem.enableDepthTest();
			RenderSystem.depthMask(true);
			RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
			RenderSystem.disableCull();

		}

		@Override
		public String toString() {
			return "forcesofreality:em_rend";
		}
	};

	public RenderTypeInit(String pName, VertexFormat pFormat, Mode pMode, int pBufferSize, boolean pAffectsCrumbling,
			boolean pSortOnUpload, Runnable pSetupState, Runnable pClearState) {
		super(pName, pFormat, pMode, pBufferSize, pAffectsCrumbling, pSortOnUpload, pSetupState, pClearState);
	}

}