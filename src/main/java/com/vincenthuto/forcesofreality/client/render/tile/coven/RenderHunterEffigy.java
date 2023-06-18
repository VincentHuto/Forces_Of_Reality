package com.vincenthuto.forcesofreality.client.render.tile.coven;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vincenthuto.forcesofreality.common.tile.coven.BlockEntityHunterEffigy;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class RenderHunterEffigy implements BlockEntityRenderer<BlockEntityHunterEffigy> {

	public RenderHunterEffigy(BlockEntityRendererProvider.Context rendererDispatcherIn) {
	}

	@Override
	public void render(BlockEntityHunterEffigy te, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {

	}

}