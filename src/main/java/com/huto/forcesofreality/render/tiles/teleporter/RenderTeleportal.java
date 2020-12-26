package com.huto.forcesofreality.render.tiles.teleporter;
/*package com.huto.forcesofreality.render.tiles.teleporter;

import java.nio.FloatBuffer;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DimensionType;

public class RenderTeleportal {

	private static final FloatBuffer FOG_BUFFER = GLAllocation.createDirectFloatBuffer(16);
	
	@SuppressWarnings("deprecation")
	public static void renderWorldToPlane(IBotiEnabled tile, float minX, float minY, float maxX, float maxY, float zPostion, float angle, float partialTicks) {
		
		if(tile == null || tile.getBotiWorld() == null)
			return;
		
		GlStateManager.pushMatrix();
		
		BotiManager boti = tile.getBotiWorld().getRenderManager(); 
		
		BlockPos offset = tile.getBotiWorld().getOffset();
		
		GlStateManager.pushMatrix();
		Minecraft.getInstance().getFramebuffer().unbindFramebuffer();
		boti.setupFramebuffer();
		GlStateManager.loadIdentity();
		
		
		DimensionType type = tile.getBotiWorld().getDimensionType();
		
		if(type != null) {
			
			boti.world.setDayTime(Minecraft.getInstance().world.getDayTime());
			boti.world.setGameTime(Minecraft.getInstance().world.getGameTime());
			
			GlStateManager.translated(0, -2, -10);
			GlStateManager.rotatef(45, 1, 0, 0);
			
			GlStateManager.rotatef(angle, 0, 1, 0);
			
			ClientWorld oldWorld = Minecraft.getInstance().world;
			Minecraft.getInstance().world = boti.world;
			
			boti.worldRenderer.renderSky(partialTicks);
			if(boti.world.dimension.isSurfaceWorld())
				boti.worldRenderer.renderClouds(partialTicks, offset.getX(), offset.getY(), offset.getZ());
			
			float angleRad = (float)Math.toRadians(angle);
			BlockState cameraState = tile.getBotiWorld()
					.getBlockState(new BlockPos((int)Math.floor(Math.sin(angleRad)), 8,
							(int)Math.floor(-(Math.cos(angleRad) * -10)))
							.add(tile.getBotiWorld().getOffset()));
			
			//Water fog
			if(cameraState.getFluidState().isTagged(FluidTags.WATER)) {
				GlStateManager.fogMode(2049);
				GlStateManager.fogDensity(0.05F);
				
				int waterFog = tile.getBotiWorld().getBiome(BlockPos.ZERO).getWaterFogColor();
				int r = waterFog >> 16 & 255;
			    int g = waterFog >> 8 & 255;
			    int b = waterFog & 255;
				
				FOG_BUFFER.clear();
				FOG_BUFFER.put(r / 255.0F).put(g / 255.0F).put(b / 255.0F).put(1.0F).flip();
				GlStateManager.fog(2918, FOG_BUFFER);
				GlStateManager.fogDensity(0.1F);
		        GlStateManager.fogStart(5F);
		        GlStateManager.fogEnd(15F);
			}
			//Lava fog
			else if(cameraState.getFluidState().isTagged(FluidTags.LAVA)) {
				 GlStateManager.fogMode(2048);
		         GlStateManager.fogDensity(0.25F);
				
				float r = 0.6F;
		        float g = 0.1F;
		        float b = 0.0F;
				
				FOG_BUFFER.clear();
				FOG_BUFFER.put(r).put(g).put(b).put(1.0F).flip();
				GlStateManager.fog(2918, FOG_BUFFER);
		        GlStateManager.fogStart(10F);
		        GlStateManager.fogEnd(20F);
			}
			//Other fog
			else {
				if(boti.world.dimension.isSkyColored()) {
					GlStateManager.fogMode(9729);
					Vector3d color = tile.getBotiWorld().getWorld().getCloudColor(partialTicks);
					FOG_BUFFER.clear();
					FOG_BUFFER.put((float)color.x).put((float)color.y).put((float)color.z).put(1.0F).flip();
					GlStateManager.fogDensity(0.2F);
					GlStateManager.fog(2918, FOG_BUFFER);
					GlStateManager.fogStart(10.0F);
					GlStateManager.fogEnd(30F);
					
				}
			}
			
			Minecraft.getInstance().world = oldWorld;
		}
		
		GlStateManager.translated(-offset.getX(), -offset.getY(), -offset.getZ());
		
		boti.renderWorld(tile.getBotiWorld());
		boti.endFBO();
		Minecraft.getInstance().getFramebuffer().bindFramebuffer(true);
		
		GlStateManager.disableFog();
		GlStateManager.popMatrix();
		
	//	Minecraft.getInstance().gameRenderer.disableLightmap();
		RenderHelper.disableStandardItemLighting();
		boti.fbo.bindFramebufferTexture();
		BufferBuilder bb = Tessellator.getInstance().getBuffer();
		bb.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
		
		double width = maxX - minX;
		double height = maxY - minY;
		double ratio = height / width;
		
		bb.pos(minX, minY, zPostion).tex(0, 0).endVertex();
		bb.pos(minX, maxY, zPostion).tex(0, 1).endVertex();
		bb.pos(maxX, maxY, zPostion).tex(1, 1).endVertex();
		bb.pos(maxX, minY, zPostion).tex(1, 0).endVertex();
			
		Tessellator.getInstance().draw();
		
		//Minecraft.getInstance().gameRenderer.getMapItemRenderer()
		
		GlStateManager.popMatrix();
	}
}*/