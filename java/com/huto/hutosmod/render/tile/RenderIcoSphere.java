package com.huto.hutosmod.render.tile;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.models.ObjModelHandler;
import com.huto.hutosmod.objects.tileenties.TileEntityIcoSphere;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.NonNullLazy;

public class RenderIcoSphere extends TileEntityRenderer<TileEntityIcoSphere> {
	public static final NonNullLazy<ObjModelHandler> modelSphere = NonNullLazy
			.of(() -> ObjModelHandler.of("hutosmod:models/block/sphere.obj"));
	public static final NonNullLazy<ObjModelHandler> modelSphereInside = NonNullLazy
			.of(() -> ObjModelHandler.of("hutosmod:models/block/sphere_inside.obj"));
	static float count = 0;
	public RenderIcoSphere(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityIcoSphere te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		GlStateManager.pushMatrix();
		GlStateManager.color4f(1F, 1F, 1F, 1F);
		GlStateManager.translated(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
		GlStateManager.popMatrix();
		matrixStackIn.push();
		for (int i = 0; i < 10; i++) {
			count += 0.0002;
			if (count > 8) {
				count = 0;
			}
		}
		matrixStackIn.translate(0.5, 0.5, 0.5);
		matrixStackIn.scale(count, count, count);
		modelSphereInside.get().render(bufferIn,
				RenderType.getEntitySolid(new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/sphere_inside.png")),
				matrixStackIn, 0x00F000F0, 16777215);
		modelSphere.get().render(bufferIn,
				RenderType.getEntitySolid(new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/sphere_inside.png")),
				matrixStackIn, 0x00F000F0, 16776960);
		matrixStackIn.pop();

	}

}
