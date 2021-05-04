package com.huto.forcesofreality.render.tiles.vibes;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.models.block.ModelDrumMagatama;
import com.huto.forcesofreality.objects.tileenties.vibes.func.TileEntityVibeResonator;
import com.huto.forcesofreality.render.tiles.ClientTickHandler;
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

public class RenderResonator extends TileEntityRenderer<TileEntityVibeResonator> {
	private final ModelDrumMagatama magatamas = new ModelDrumMagatama();

	public RenderResonator(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityVibeResonator te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
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
			matrixStackIn.translate(0D, 0.175D + i * 0.55, 0F);
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
		matrixStackIn.translate(0.5, 1.2, 0.5);
		matrixStackIn.scale(0.5f, 0.5f, 0.5f);
		// Cubes
		for (int i = 1; i < te.getLevel(); i++) {
			double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
			final float modifier = 6F;
			final float rotationModifier = 0.2F;
			final float radiusBase = 0.9F;
			final float radiusMod = 0.0F;
			int cubes;
			if (te.getLevel() > 1) {
				cubes = te.getLevel() - 1;
			} else {
				cubes = 1;

			}
			float offsetPerCube = 360 / cubes;
			float offset = offsetPerCube * i;
			float deg = (int) (ticks / rotationModifier % 360F + offset);
			float rad = deg * (float) Math.PI / 180F;
			float radiusX = (float) (radiusBase + radiusMod * Math.sin(ticks / modifier));
			float radiusZ = (float) (radiusBase + radiusMod * Math.cos(ticks / modifier));
			float x = (float) (radiusX * Math.cos(rad));
			float z = (float) (radiusZ * Math.sin(rad));
			float y = (float) Math.cos((ticks + 50 * i) / 5F) / 10F;
			matrixStackIn.push();
			matrixStackIn.translate(x, y, z);
			float yRotate = (float) Math.max(0.6F, Math.sin(ticks * 0.1F) / 2F + 0.5F);
			matrixStackIn.rotate(Vector3f.YP.rotation(yRotate));
			matrixStackIn.rotate(Vector3f.ZP.rotation(135));

			IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer
					.getImpl(Tessellator.getInstance().getBuffer());
			IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(magatamas
					.getRenderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/blocks/end_portal.png")));
			magatamas.render(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F,
					1.0F);
			irendertypebuffer$impl.finish();
			matrixStackIn.pop();
		}
	}
}
