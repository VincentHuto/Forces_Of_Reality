package com.huto.hutosmod.render.tiles;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.models.block.ModelDrumMagatama;
import com.huto.hutosmod.objects.tileenties.TileEntityWandMaker;
import com.huto.hutosmod.objects.tileenties.util.ClientTickHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class RenderWandMaker extends TileEntityRenderer<TileEntityWandMaker> {
	private final ModelDrumMagatama magatamas = new ModelDrumMagatama();
	public static final ResourceLocation GLASSTEXTURE = new ResourceLocation(HutosMod.MOD_ID,
			"textures/blocks/machine_glass.png");

	public RenderWandMaker(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityWandMaker te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		matrixStackIn.push();
		// matrixStackIn.rotate(Vector3f.YP.rotationDegrees(te.getWorld().getGameTime()));
		/*
		 * RenderShapes.renderSizedCube(matrixStackIn, bufferIn, combinedLightIn,
		 * combinedOverlayIn,
		 * bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE)), 0f, 0f,
		 * -1f, 1, 1); RenderShapes.renderSizedCubes(matrixStackIn, bufferIn,
		 * combinedLightIn, combinedOverlayIn,
		 * bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE)), 5,-2f, 1f,
		 * -1f, 1, 1); RenderShapes.renderSizedRectangles(matrixStackIn, bufferIn,
		 * combinedLightIn, combinedOverlayIn,
		 * bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE)), 5,-2f, 1f,
		 * -2f, 1, 1,2); RenderShapes.renderSizedTunnels(matrixStackIn, bufferIn,
		 * combinedLightIn, combinedOverlayIn,
		 * bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE)), 5,-3f, 1f,
		 * 1f, 1, 1,1); RenderShapes.renderSizedTunnel(matrixStackIn, bufferIn,
		 * combinedLightIn, combinedOverlayIn,
		 * bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE)), 1f, 1f,
		 * -1f, 1, 1+ te.getWorld().rand.nextFloat(),2 +
		 * te.getWorld().rand.nextFloat());
		 * RenderShapes.renderSizedPyramid(matrixStackIn, bufferIn, combinedLightIn,
		 * combinedOverlayIn,
		 * bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE)), 1f, 1f,
		 * 0f, 1, 1, 1, 1); RenderShapes.renderSizedOctahedron(matrixStackIn, bufferIn,
		 * combinedLightIn, combinedOverlayIn,
		 * bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE)), 1f, 2f,
		 * 1f, 1, 1, 1, 1); RenderShapes.renderSizedHouse(matrixStackIn, bufferIn,
		 * combinedLightIn, combinedOverlayIn,
		 * bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE)), 1f, 0f,
		 * 0f, 1, 1, 1, 1, 1, 1);
		 */
		/*
		 * RenderShapes.renderSizedSlantedRectangles(matrixStackIn, bufferIn,
		 * combinedLightIn, combinedOverlayIn,
		 * bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE)),3,0f, 1f,
		 * 0f, 1f, 1, 0.3f,0.5f,1,-0.5f);
		 */

		//RenderShapes.renderSizedTunnels(matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, bufferIn.getBuffer(RenderType.getEntityTranslucent(GLASSTEXTURE)),3, 2, 1, 1, 3, 2, 2);
		
		matrixStackIn.pop();

		GlStateManager.pushMatrix();
		GlStateManager.color4f(1F, 1F, 1F, 1F);
		GlStateManager.translated(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());

		int items = 0;
		for (int i = 0; i < te.getSizeInventory(); i++)
			if (te.getItemHandler().getStackInSlot(i).isEmpty())
				break;
			else
				items++;
		float[] angles = new float[te.getSizeInventory()];

		float anglePer = 360F / items;
		float totalAngle = 0F;
		for (int i = 0; i < angles.length; i++)
			angles[i] = totalAngle += anglePer;

		double time = ClientTickHandler.ticksInGame + partialTicks;

		Minecraft.getInstance().textureManager.bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
		for (int i = 0; i < te.getSizeInventory(); i++) {
			matrixStackIn.push();
			matrixStackIn.translate(0.5F, 1.25F, 0.5F);
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(angles[i] + (float) time));
			// Edit True Radius
			matrixStackIn.translate(0.025F, -0.5F, 0.025F);
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90f));
			// Edit Radius Movement
			matrixStackIn.translate(0D, 0.175D + i * 0.25, 0F);
			// Block/Item Scale
			matrixStackIn.scale(0.5f, 0.5f, 0.5f);
			ItemStack stack = te.getItemHandler().getStackInSlot(i);
			Minecraft mc = Minecraft.getInstance();
			if (!stack.isEmpty()) {
				mc.getItemRenderer().renderItem(stack, TransformType.FIXED, combinedLightIn, combinedOverlayIn,
						matrixStackIn, bufferIn);
			}
			matrixStackIn.pop();
		}
		GlStateManager.popMatrix();
		matrixStackIn.translate(0.5, 1.8, 0.5);
		matrixStackIn.scale(0.4f, 0.4f, 0.4f);
		// Cubes
		for (int i = 1; i < te.getLevel(); i++) {
			double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
			final float modifier = 16F;
			final float rotationModifier = 0.3F;
			final float radiusBase = 0.55F;
			final float radiusMod = 0.01F;
			int cubes;
			if (te.getLevel() > 1) {
				cubes = te.getLevel() - 1;
			} else {
				cubes = 1;

			}
			float offsetPerCube = 135 / cubes;
			float offset = offsetPerCube * i;
			float deg = (int) (ticks / rotationModifier % 360F + offset);
			float rad = deg * (float) Math.PI / 90f;
			float radiusX = (float) (radiusBase + radiusMod * Math.sin(ticks / modifier));
			float radiusZ = (float) (radiusBase + radiusMod * Math.cos(ticks / modifier));
			float x = (float) (radiusX * Math.cos(rad));
			float z = (float) (radiusZ * Math.sin(rad));
			float y = (float) Math.cos((ticks + 50 * i) / 15F);

			// float xRotate = (float) Math.sin(ticks * rotationModifier) /15F;
			float yRotate = (float) Math.max(0.6F, Math.sin(ticks * 0.1F) / 2F + 2.5F);
			// float zRotate = (float) Math.cos(ticks * rotationModifier) / 15f;

			matrixStackIn.push();
			matrixStackIn.translate(x, y, z);
			matrixStackIn.rotate(Vector3f.YN.rotation(yRotate / 12));
			matrixStackIn.rotate(Vector3f.ZP.rotation(135));
			// matrixStackIn.rotate(Vector3f.XP.rotation(xRotate / 12));

			IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer
					.getImpl(Tessellator.getInstance().getBuffer());
			IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(magatamas
					.getRenderType(new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/end_portal_red.png")));
			magatamas.render(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F,
					1.0F);
			irendertypebuffer$impl.finish();
			matrixStackIn.pop();
		}
	}

}
