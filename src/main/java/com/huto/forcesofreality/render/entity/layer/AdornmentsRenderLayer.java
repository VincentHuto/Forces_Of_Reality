package com.huto.forcesofreality.render.entity.layer;

import com.huto.forcesofreality.capabilitie.adornment.AdornmentsCapabilities;
import com.huto.forcesofreality.capabilitie.adornment.IAdornmentsItemHandler;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class AdornmentsRenderLayer<T extends PlayerEntity, M extends PlayerModel<T>> extends LayerRenderer<T, M> {

	public AdornmentsRenderLayer(IEntityRenderer<T, M> entityRendererIn) {
		super(entityRendererIn);
	}

	@Override
	public void render(MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int packedLight,
			PlayerEntity player, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw,
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