package com.huto.forcesofreality.render.tile.coven;

import com.huto.forcesofreality.tile.coven.TileEntityHunterEffigy;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;

public class RenderHunterEffigy extends BlockEntityRenderer<TileEntityHunterEffigy> {

	public RenderHunterEffigy(BlockEntityRenderDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntityHunterEffigy te, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {

	}

}