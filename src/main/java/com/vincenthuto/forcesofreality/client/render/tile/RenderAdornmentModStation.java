package com.vincenthuto.forcesofreality.client.render.tile;
//package com.vincenthuto.forcesofreality.render.tile;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.math.Vector3f;
//import com.vincenthuto.forcesofreality.capa.adornment.AdornmentsCapabilities;
//import com.vincenthuto.forcesofreality.capa.adornment.IAdornmentsItemHandler;
//import com.vincenthuto.forcesofreality.tile.BlockEntityAdornmentModStation;
//import com.vincenthuto.hutoslib.client.HLClientUtils;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.FaceInfo;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
//import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
//import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.block.HorizontalDirectionalBlock;
//import net.minecraft.world.level.block.state.properties.DirectionProperty;
//
//public class RenderAdornmentModStation implements BlockEntityRenderer<BlockEntityAdornmentModStation> {
//	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
//
//	public RenderAdornmentModStation(BlockEntityRenderDispatcher rendererDispatcherIn) {
//	}
//
//	@SuppressWarnings("deprecation")
//	@Override
//	public void render(BlockEntityAdornmentModStation te, float partialTicks, PoseStack matrixStackIn,
//			MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
//		Player player = HLClientUtils.getClientPlayer();
//		if (player.isAlive()) {
//
//			IAdornmentsItemHandler runes = player.getCapability(AdornmentsCapabilities.ADORNMENTS)
//					.orElseThrow(IllegalArgumentException::new);
//			int items = 0;
//			for (int i = 0; i < runes.getSlots(); i++) {
//				items++;
//			}
//			float[] angles = new float[runes.getSlots()];
//			float anglePer = 360F / items;
//			float totalAngle = 0F;
//			for (int i = 0; i < angles.length; i++) {
//				angles[i] = totalAngle += anglePer;
//			}
//
//			double time = ClientTickHandler.ticksInGame + partialTicks;
//			Minecraft mc = Minecraft.getInstance();
//
//			matrixStackIn.pushPose();
//			matrixStackIn.translate(0.5F, 1F, 0.69F);
//			matrixStackIn.translate(0.025F, -0.32F, 0.025F);
//			matrixStackIn.mulPose(Vector3.YP.rotationDegrees(90f).toMoj());
//			if (te.getBlockState().getValues().get(FACING).toString().toUpperCase().equals(FaceInfo.EAST.toString())) {
//				matrixStackIn.mulPose(Vector3.YP.rotationDegrees(180f).toMoj());
//				matrixStackIn.mulPose(Vector3.XP.rotationDegrees(22.5f).toMoj());
//
//				matrixStackIn.translate(-0.22, 0.38D, -0.2F);
//			} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
//					.equals(FaceInfo.WEST.toString())) {
//				matrixStackIn.mulPose(Vector3.XP.rotationDegrees(22.5f).toMoj());
//				matrixStackIn.translate(0.21, 0.36D, -0.25F);
//			} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
//					.equals(FaceInfo.NORTH.toString())) {
//				matrixStackIn.mulPose(Vector3.YP.rotationDegrees(-90f).toMoj());
//				matrixStackIn.mulPose(Vector3.XP.rotationDegrees(22.5f).toMoj());
//
//				matrixStackIn.translate(-0.028F, 0.28D, -0.42F);
//			} else if (te.getBlockState().getValues().get(FACING).toString().toUpperCase()
//					.equals(FaceInfo.SOUTH.toString())) {
//				matrixStackIn.mulPose(Vector3.YP.rotationDegrees(90f).toMoj());
//				matrixStackIn.mulPose(Vector3.XP.rotationDegrees(22.5f).toMoj());
//
//				matrixStackIn.translate(0.02F, 0.45D, -0.02F);
//			}
//			matrixStackIn.scale(0.25f, 0.25f, 0.25f);
//			ItemStack stack = runes.getStackInSlot(0);
//			if (!stack.isEmpty()) {
//
//				mc.getItemRenderer().renderStatic(stack, ItemDisplayContext.FIXED, combinedLightIn, combinedOverlayIn,
//						matrixStackIn, bufferIn, items);
//
//			}
//			matrixStackIn.popPose();
//
//			for (int i = 1; i < runes.getSlots(); i++) {
//				matrixStackIn.pushPose();
//				matrixStackIn.translate(0.5F, 1F, 0.5F);
//				matrixStackIn.mulPose(Vector3.YP.rotationDegrees(angles[i] + (float) time));
//				matrixStackIn.translate(0.025F, -0.25F, 0.025F);
//				matrixStackIn.mulPose(Vector3.YP.rotationDegrees(90f).toMoj());
//				matrixStackIn.translate(0.35, 0.3175D, 0F);
//				matrixStackIn.scale(0.1f, 0.1f, 0.1f);
//				ItemStack stack2 = runes.getStackInSlot(i);
//				mc.getItemRenderer().renderStatic(stack2, ItemDisplayContext.FIXED, combinedLightIn, combinedOverlayIn,
//						matrixStackIn, bufferIn, i);
//				matrixStackIn.popPose();
//			}
//
//		}
//	}
//}
