package com.huto.forcesofreality.render.entity.layer;

import com.huto.forcesofreality.capabilitie.adornment.AdornmentsCapabilities;
import com.huto.forcesofreality.capabilitie.adornment.IAdornmentsItemHandler;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.item.ItemStack;

public class AdornmentsRenderLayer<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {

	public AdornmentsRenderLayer(RenderLayerParent<T, M> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public void render(PoseStack matrixStack, MultiBufferSource iRenderTypeBuffer, int packedLight,
			Player player, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
			float headPitch, float scale) {
		player.getCapability(AdornmentsCapabilities.ADORNMENTS).ifPresent(inv -> {
			dispatchRenders(matrixStack, packedLight, iRenderTypeBuffer, inv, player, IRenderAdornments.RenderType.BODY,
					partialTicks);

			matrixStack.push();
			EntityRenderer<?> renderer = Minecraft.getInstance().getRenderManager().getRenderer(player);
			EntityModel<?> model = ((IEntityRenderer<?, ?>) renderer).getEntityModel();
			if (model instanceof BipedModel<?>) {
				BipedModel<?> biModel = (BipedModel<?>) model;
				biModel.bipedHead.translateRotate(matrixStack);
			}
			dispatchRenders(matrixStack, packedLight, iRenderTypeBuffer, inv, player, IRenderAdornments.RenderType.HEAD,
					partialTicks);
			matrixStack.pop();
		});
	}

	private void dispatchRenders(MatrixStack matrix, int packedLightIn, IRenderTypeBuffer iRenderTypeBuffer,
			IAdornmentsItemHandler inv, PlayerEntity player, IRenderAdornments.RenderType type, float partialTicks) {
		for (int i = 0; i < inv.getSlots(); i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if (!stack.isEmpty()) {
				stack.getCapability(AdornmentsCapabilities.ITEM_ADORNMENT).ifPresent(rune -> {
					if (rune instanceof IRenderAdornments) {
						matrix.push();
						((IRenderAdornments) rune).onPlayerAdornmentRender(matrix, packedLightIn, iRenderTypeBuffer, player, type,
								partialTicks);
						matrix.pop();

					}
				});
			}
		}
	}
}