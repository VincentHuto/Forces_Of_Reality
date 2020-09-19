package com.huto.hutosmod.render.tile;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.models.ModelDrumMagatama;
import com.huto.hutosmod.models.ModelFloatingCube;
import com.huto.hutosmod.objects.tileenties.TileEntityAbsorber;
import com.huto.hutosmod.objects.tileenties.util.ClientTickHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
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

public class RenderAbsorber extends TileEntityRenderer<TileEntityAbsorber> {
	private final ModelDrumMagatama magatamas = new ModelDrumMagatama();
	private final ModelFloatingCube cube = new ModelFloatingCube();

	public RenderAbsorber(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityAbsorber te, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
			int combinedLightIn, int combinedOverlayIn) {
		// Add items above block
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
		matrixStackIn.translate(0.5, 0.9, 0.5);
		matrixStackIn.scale(0.5f, 0.5f, 0.5f);

		ResourceLocation textureExport = new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/end_portal_blue.png");
		ResourceLocation textureImport = new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/end_portal_red.png");
		ResourceLocation textureDefault = new ResourceLocation(
				HutosMod.MOD_ID + ":textures/blocks/end_portal_default.png");
		ResourceLocation textureBoth = new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/end_portal_purple.png");
		ResourceLocation textureMode;

		if (te.getMode() == 0) {
			textureMode = textureDefault;
		} else if (te.getMode() == 1) {
			textureMode = textureImport;
		} else if (te.getMode() == 2) {
			textureMode = textureExport;
		} else if (te.getMode() == 3) {
			textureMode = textureBoth;
		} else {
			textureMode = textureDefault;
		}

		// Magatamas
		for (int i = 0; i < te.getTankLevel(); i++) {
			double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
			final float modifier = 6F;
			final float rotationModifier = 0.2F;
			final float radiusBase = 0.4F;
			final float radiusMod = 0.0F;
			int cubes = te.getTankLevel();
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
			IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(magatamas.getRenderType(textureMode));
			magatamas.render(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F,
					1.0F);
			irendertypebuffer$impl.finish();
			matrixStackIn.pop();
		}
		// Cube
		double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
		float y = (float) Math.cos((ticks + 50) / 5F) / 10F;
		matrixStackIn.push();
		matrixStackIn.translate(-0.125, y - 0.75, -0.125);
		matrixStackIn.scale(4, 4, 4);
		IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer
				.getImpl(Tessellator.getInstance().getBuffer());
		IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(cube.getRenderType(textureMode));
		cube.render(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		irendertypebuffer$impl.finish();
		matrixStackIn.pop();

	}

}
