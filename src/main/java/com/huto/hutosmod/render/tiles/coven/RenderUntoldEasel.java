package com.huto.hutosmod.render.tiles.coven;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.init.ItemInit;
import com.huto.hutosmod.models.block.ModelFloatingEye;
import com.huto.hutosmod.objects.tileenties.coven.TileEntityUntoldEasel;
import com.huto.hutosmod.objects.tileenties.util.ClientTickHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.FaceDirection;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

public class RenderUntoldEasel extends TileEntityRenderer<TileEntityUntoldEasel> {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private final ModelFloatingEye magatamas = new ModelFloatingEye();

	public RenderUntoldEasel(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityUntoldEasel te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		GlStateManager.pushMatrix();

		Minecraft mc = Minecraft.getInstance();

		matrixStackIn.push();
		matrixStackIn.translate(0.5F, 1F, 0.69F);
		matrixStackIn.translate(0.025F, -0.32F, 0.025F);
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90f));
		if (te.getBlockState().getValues().get(FACING).toString().toUpperCase().equals(FaceDirection.EAST.toString())) {
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180f));
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(22.5f));
			matrixStackIn.translate(-0.36f, -0.14D, 0.02F);
		} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
				.equals(FaceDirection.WEST.toString())) {
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(22.5f));
			matrixStackIn.translate(0.05f, -0.16D, -0.02F);
		} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
				.equals(FaceDirection.NORTH.toString())) {
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(-90f));
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(22.5f));

			matrixStackIn.translate(-0.16f, -0.2D, -0.24F);
		} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
				.equals(FaceDirection.SOUTH.toString())) {
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90f));
			matrixStackIn.rotate(Vector3f.XP.rotationDegrees(22.5f));
			matrixStackIn.translate(-0.12f, -0.05D, 0.2F);
		}
		matrixStackIn.scale(0.25f, 0.25f, 0.25f);
		ItemStack stack = new ItemStack(ItemInit.yellow_sign.get());
		if (!stack.isEmpty()) {
			GlStateManager.pushMatrix();
			mc.getItemRenderer().renderItem(stack, TransformType.FIXED, combinedLightIn, combinedOverlayIn,
					matrixStackIn, bufferIn);
			GlStateManager.popMatrix();
		}
		matrixStackIn.pop();

		GlStateManager.popMatrix();
		matrixStackIn.push();
		matrixStackIn.translate(0.5, 1.4, 0.5);
		matrixStackIn.scale(0.5f, -0.5f, 0.5f);
		// Cubes
		for (int i = 0; i < te.clientDevo; i++) {
			double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
			final float modifier = 16F;
			final float rotationModifier = 0.2F;
			final float radiusBase = 0.9F;
			final float radiusMod = 0.2F;
			int cubes = te.clientDevo;
			float offsetPerCube = 360 / cubes;
			float offset = offsetPerCube * i;
			float deg = (int) (ticks / rotationModifier % 360F + offset);
			float rad = deg * (float) Math.PI / 180F;
			float radiusX = (float) (radiusBase + radiusMod * Math.cos(ticks / modifier));
			float radiusZ = (float) (radiusBase + radiusMod * Math.sin(ticks / modifier));
			float x = (float) (radiusX * Math.sin(rad));
			float z = (float) (radiusZ * Math.cos(rad));
			float y = (float) Math.cos((ticks + 50 * i) / 52F) / 1F;
			matrixStackIn.push();
			matrixStackIn.translate(x, y, z);
			IRenderTypeBuffer.Impl irendertypebuffer$impl1 = IRenderTypeBuffer
					.getImpl(Tessellator.getInstance().getBuffer());
			IVertexBuilder ivertexbuilder1 = irendertypebuffer$impl1.getBuffer(magatamas
					.getRenderType(new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/sphere_outside.png")));
			magatamas.render(matrixStackIn, ivertexbuilder1, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F,
					1.0F);
			irendertypebuffer$impl1.finish();
			matrixStackIn.pop();

		}
		matrixStackIn.pop();
	}
}
