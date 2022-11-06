package com.vincenthuto.forcesofreality.render.tile.coven;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.math.Vector3f;
import com.vincenthuto.forcesofreality.render.tile.ClientTickHandler;
import com.vincenthuto.forcesofreality.tile.BlockEntityRafflesiaOfFidelity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemStack;

public class RenderRafflesiaOfFidelity implements BlockEntityRenderer<BlockEntityRafflesiaOfFidelity> {
	//private final ModelDrumMagatama magatamas = new ModelDrumMagatama();

	public RenderRafflesiaOfFidelity(BlockEntityRendererProvider.Context rendererDispatcherIn) {
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(BlockEntityRafflesiaOfFidelity te, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {

		int items = 0;
		for (int i = 0; i < te.getSizeInventory(); i++)
			if (te.getItemHandler().getStackInSlot(i).isEmpty())
				break;
			else
				items++;
		float[] angles = new float[te.getSizeInventory()];
		float anglePer = 360F / (items - 1);
		float totalAngle = 0F;
		for (int i = 1; i < angles.length; i++)
			angles[i] = totalAngle += anglePer;

		double time = ClientTickHandler.ticksInGame + partialTicks;


		for (int i = 0; i < te.getSizeInventory(); i++) {
			matrixStackIn.pushPose();
			if (i == 0) {
				matrixStackIn.translate(0.5F, 1.5F, 0.5F);
				matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(angles[i] + (float) time));
				// Edit True Radius
				matrixStackIn.translate(0.025F, -0.5F, 0.025F);
				matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90f));
				// Edit Radius Movement
				matrixStackIn.translate(0D, 0.175D + i * 0.55, 0F);
				// Block/Item Scale
				matrixStackIn.scale(0.5f, 0.5f, 0.5f);
				ItemStack stack = te.getItemHandler().getStackInSlot(i);
				Minecraft mc = Minecraft.getInstance();
				if (!stack.isEmpty()) {
					mc.getItemRenderer().renderStatic(stack, TransformType.FIXED, combinedLightIn, combinedOverlayIn,
							matrixStackIn, bufferIn, i);
				}

			} else {
				matrixStackIn.translate(0.5F, 2.5f, 0.5F);
				matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(angles[i] + (float) time));
				// Edit True Radius
				matrixStackIn.translate(.1, -1.7F, 0.65F);
				matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(90f));
				// Edit Radius Movement
				matrixStackIn.translate(0D, 0.175f + 0.25, 0F);
				// Block/Item Scale
				matrixStackIn.scale(0.3f, 0.3f, 0.3f);
				ItemStack stack = te.getItemHandler().getStackInSlot(i);
				Minecraft mc = Minecraft.getInstance();
				if (!stack.isEmpty()) {
					mc.getItemRenderer().renderStatic(stack, TransformType.FIXED, combinedLightIn, combinedOverlayIn,
							matrixStackIn, bufferIn, i);
				}
			}
			matrixStackIn.popPose();

		}

		matrixStackIn.translate(0.5, 1.8, 0.5);
		matrixStackIn.scale(0.75f, 0.75f, 0.75f);
		// Cubes
		for (int i = 1; i < te.getRank(); i++) {
			double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
			final float modifier = 6F;
			final float rotationModifier = 0.2F;
			final float radiusBase = 0.9F;
			final float radiusMod = 0.0F;
			int cubes;
			if (te.getRank() > 1) {
				cubes = te.getRank() - 1;
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
			matrixStackIn.pushPose();
			matrixStackIn.translate(x, y, z);
			float yRotate = (float) Math.max(0.6F, Math.sin(ticks * 0.1F) / 2F + 0.5F);
			matrixStackIn.mulPose(Vector3f.YP.rotation(yRotate));
			matrixStackIn.mulPose(Vector3f.ZP.rotation(135));

			MultiBufferSource.BufferSource irendertypebuffer$impl = MultiBufferSource
					.immediate(Tesselator.getInstance().getBuilder());
//			VertexConsumer ivertexbuilder = irendertypebuffer$impl.getBuffer(magatamas
//					.renderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/blocks/end_portal_red.png")));
//			magatamas.renderToBuffer(matrixStackIn, ivertexbuilder, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F,
//					1.0F, 1.0F);
			irendertypebuffer$impl.endBatch();
			matrixStackIn.popPose();
		}
	}
}
