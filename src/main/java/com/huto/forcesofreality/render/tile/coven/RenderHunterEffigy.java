package com.huto.forcesofreality.render.tile.coven;

import com.huto.forcesofreality.tile.coven.TileEntityHunterEffigy;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;

public class RenderHunterEffigy extends TileEntityRenderer<TileEntityHunterEffigy> {

	public RenderHunterEffigy(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntityHunterEffigy te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {

	}

}