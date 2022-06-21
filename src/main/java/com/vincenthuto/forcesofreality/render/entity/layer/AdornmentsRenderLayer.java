//package com.vincenthuto.forcesofreality.render.entity.layer;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.vincenthuto.forcesofreality.capa.adornment.AdornmentsCapabilities;
//import com.vincenthuto.forcesofreality.capa.adornment.IAdornmentsItemHandler;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.model.EntityModel;
//import net.minecraft.client.model.HumanoidModel;
//import net.minecraft.client.model.PlayerModel;
//import net.minecraft.client.renderer.MultiBufferSource;
//import net.minecraft.client.renderer.entity.EntityRenderer;
//import net.minecraft.client.renderer.entity.RenderLayerParent;
//import net.minecraft.client.renderer.entity.layers.RenderLayer;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.ItemStack;
//
//public class AdornmentsRenderLayer<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {
//
//	public AdornmentsRenderLayer(RenderLayerParent<T, M> entityRendererIn) {
//		super(entityRendererIn);
//	}
//
//	@Override
//	public void render(PoseStack matrixStack, MultiBufferSource iRenderTypeBuffer, int packedLight, Player player,
//			float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch,
//			float scale) {
//		player.getCapability(AdornmentsCapabilities.ADORNMENTS).ifPresent(inv -> {
//			dispatchRenders(matrixStack, packedLight, iRenderTypeBuffer, inv, player, IRenderAdornments.RenderType.BODY,
//					partialTicks);
//
//			matrixStack.pushPose();
//			EntityRenderer<?> renderer = Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(player);
//			EntityModel<?> model = ((RenderLayerParent<?, ?>) renderer).getModel();
//			if (model instanceof HumanoidModel<?>) {
//				HumanoidModel<?> biModel = (HumanoidModel<?>) model;
//				biModel.head.translateAndRotate(matrixStack);
//			}
//			dispatchRenders(matrixStack, packedLight, iRenderTypeBuffer, inv, player, IRenderAdornments.RenderType.HEAD,
//					partialTicks);
//			matrixStack.popPose();
//		});
//	}
//
//	private void dispatchRenders(PoseStack matrix, int packedLightIn, MultiBufferSource iRenderTypeBuffer,
//			IAdornmentsItemHandler inv, Player player, IRenderAdornments.RenderType type, float partialTicks) {
//		for (int i = 0; i < inv.getSlots(); i++) {
//			ItemStack stack = inv.getStackInSlot(i);
//			if (!stack.isEmpty()) {
//				stack.getCapability(AdornmentsCapabilities.ITEM_ADORNMENT).ifPresent(rune -> {
//					if (rune instanceof IRenderAdornments) {
//						matrix.pushPose();
//						((IRenderAdornments) rune).onPlayerAdornmentRender(matrix, packedLightIn, iRenderTypeBuffer,
//								player, type, partialTicks);
//						matrix.popPose();
//
//					}
//				});
//			}
//		}
//	}
//}