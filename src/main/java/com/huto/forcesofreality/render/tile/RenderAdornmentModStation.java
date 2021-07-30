package com.huto.forcesofreality.render.tile;

import com.huto.forcesofreality.capabilitie.adornment.AdornmentsCapabilities;
import com.huto.forcesofreality.capabilitie.adornment.IAdornmentsItemHandler;
import com.huto.forcesofreality.tile.TileEntityAdornmentModStation;
import com.hutoslib.client.ClientUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.FaceDirection;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.util.math.vector.Vector3f;

public class RenderAdornmentModStation extends BlockEntityRenderer<TileEntityAdornmentModStation> {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public RenderAdornmentModStation(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityAdornmentModStation te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		PlayerEntity player = ClientUtils.getClientPlayer();
		if (player.isAlive()) {
			GlStateManager.pushMatrix();
			GlStateManager.color4f(1F, 1F, 1F, 1F);

			IAdornmentsItemHandler runes = player.getCapability(AdornmentsCapabilities.ADORNMENTS)
					.orElseThrow(IllegalArgumentException::new);
			int items = 0;
			for (int i = 0; i < runes.getSlots(); i++) {
				items++;
			}
			float[] angles = new float[runes.getSlots()];
			float anglePer = 360F / items;
			float totalAngle = 0F;
			for (int i = 0; i < angles.length; i++) {
				angles[i] = totalAngle += anglePer;
			}

			double time = ClientTickHandler.ticksInGame + partialTicks;
			Minecraft mc = Minecraft.getInstance();

			matrixStackIn.push();
			matrixStackIn.translate(0.5F, 1F, 0.69F);
			matrixStackIn.translate(0.025F, -0.32F, 0.025F);
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90f));
			if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
					.equals(FaceDirection.EAST.toString())) {
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180f));
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(22.5f));

				matrixStackIn.translate(-0.22, 0.38D, -0.2F);
			} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
					.equals(FaceDirection.WEST.toString())) {
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(22.5f));
				matrixStackIn.translate(0.21, 0.36D, -0.25F);
			} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
					.equals(FaceDirection.NORTH.toString())) {
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(-90f));
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(22.5f));

				matrixStackIn.translate(-0.028F, 0.28D, -0.42F);
			} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
					.equals(FaceDirection.SOUTH.toString())) {
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90f));
				matrixStackIn.rotate(Vector3f.XP.rotationDegrees(22.5f));

				matrixStackIn.translate(0.02F, 0.45D, -0.02F);
			}
			matrixStackIn.scale(0.25f, 0.25f, 0.25f);
			ItemStack stack = runes.getStackInSlot(0);
			if (!stack.isEmpty()) {
				GlStateManager.pushMatrix();
				mc.getItemRenderer().renderItem(stack, TransformType.FIXED, combinedLightIn, combinedOverlayIn,
						matrixStackIn, bufferIn);
				GlStateManager.popMatrix();
			}
			matrixStackIn.pop();

			for (int i = 1; i < runes.getSlots(); i++) {
				matrixStackIn.push();
				matrixStackIn.translate(0.5F, 1F, 0.5F);
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(angles[i] + (float) time));
				matrixStackIn.translate(0.025F, -0.25F, 0.025F);
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(90f));
				matrixStackIn.translate(0.35, 0.3175D, 0F);
				matrixStackIn.scale(0.1f, 0.1f, 0.1f);
				ItemStack stack2 = runes.getStackInSlot(i);
				mc.getItemRenderer().renderItem(stack2, TransformType.FIXED, combinedLightIn, combinedOverlayIn,
						matrixStackIn, bufferIn);
				matrixStackIn.pop();
			}
			GlStateManager.popMatrix();
		}
	}
}
