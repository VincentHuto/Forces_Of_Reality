package com.vincenthuto.forcesofreality.client.render.tile.coven;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.vincenthuto.forcesofreality.client.render.tile.ClientTickHandler;
import com.vincenthuto.forcesofreality.common.tile.coven.BlockEntityUntoldEasel;
import com.vincenthuto.forcesofreality.registry.ItemInit;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.FaceInfo;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class RenderUntoldEasel implements BlockEntityRenderer<BlockEntityUntoldEasel> {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
//	private final ModelFloatingEye magatamas = new ModelFloatingEye();

	public RenderUntoldEasel(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(BlockEntityUntoldEasel te, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {

		Minecraft mc = Minecraft.getInstance();

		matrixStackIn.pushPose();
		matrixStackIn.translate(0.5F, 1F, 0.69F);
		matrixStackIn.translate(0.025F, -0.32F, 0.025F);
		matrixStackIn.mulPose(Vector3.YP.rotationDegrees(90f).toMoj());
		if (te.getBlockState().getValues().get(FACING).toString().toUpperCase().equals(FaceInfo.EAST.toString())) {
			matrixStackIn.mulPose(Vector3.YP.rotationDegrees(180f).toMoj());
			matrixStackIn.mulPose(Vector3.XP.rotationDegrees(22.5f).toMoj());
			matrixStackIn.translate(-0.36f, -0.14D, 0.02F);
		} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
				.equals(FaceInfo.WEST.toString())) {
			matrixStackIn.mulPose(Vector3.XP.rotationDegrees(22.5f).toMoj());
			matrixStackIn.translate(0.05f, -0.16D, -0.02F);
		} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
				.equals(FaceInfo.NORTH.toString())) {
			matrixStackIn.mulPose(Vector3.YP.rotationDegrees(-90f).toMoj());
			matrixStackIn.mulPose(Vector3.XP.rotationDegrees(22.5f).toMoj());

			matrixStackIn.translate(-0.16f, -0.2D, -0.24F);
		} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
				.equals(FaceInfo.SOUTH.toString())) {
			matrixStackIn.mulPose(Vector3.YP.rotationDegrees(90f).toMoj());
			matrixStackIn.mulPose(Vector3.XP.rotationDegrees(22.5f).toMoj());
			matrixStackIn.translate(-0.12f, -0.05D, 0.2F);
		}
		matrixStackIn.scale(0.25f, 0.25f, 0.25f);
		ItemStack stack = new ItemStack(ItemInit.yellow_sign.get());
		if (!stack.isEmpty()) {

			mc.getItemRenderer().renderStatic(stack, ItemDisplayContext.FIXED, combinedLightIn, combinedOverlayIn,
					matrixStackIn, bufferIn, te.getLevel(), combinedOverlayIn);

		}
		matrixStackIn.popPose();

		matrixStackIn.pushPose();
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
			matrixStackIn.pushPose();
			matrixStackIn.translate(x, y, z);
			MultiBufferSource.BufferSource irendertypebuffer$impl1 = MultiBufferSource
					.immediate(Tesselator.getInstance().getBuilder());
//			VertexConsumer ivertexbuilder1 = irendertypebuffer$impl1.getBuffer(magatamas
//					.renderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/block/sphere_outside.png")));
//			magatamas.renderToBuffer(matrixStackIn, ivertexbuilder1, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F,
//					1.0F, 1.0F);
			irendertypebuffer$impl1.endBatch();
			matrixStackIn.popPose();

		}
		matrixStackIn.popPose();
	}
}
