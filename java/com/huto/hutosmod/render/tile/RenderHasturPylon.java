package com.huto.hutosmod.render.tile;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.models.ModelHasturPylon;
import com.huto.hutosmod.models.ObjModelHandler;
import com.huto.hutosmod.objects.tileenties.TileEntityHasturPylon;
import com.huto.hutosmod.objects.tileenties.util.ClientTickHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.common.util.NonNullLazy;

public class RenderHasturPylon extends TileEntityRenderer<TileEntityHasturPylon> {
	private final ModelHasturPylon pylon = new ModelHasturPylon();
	public static final NonNullLazy<ObjModelHandler> modelTorus = NonNullLazy
			.of(() -> ObjModelHandler.of("hutosmod:models/block/torus.obj"));

	public RenderHasturPylon(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityHasturPylon te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		GlStateManager.pushMatrix();
		GlStateManager.color4f(1F, 1F, 1F, 1F);
		GlStateManager.translated(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ());
		GlStateManager.popMatrix();

		// Cubes
		matrixStackIn.translate(0.5, 1.6, 0.5);
		double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
		float y = (float) Math.cos((ticks + 50) / 5F) / 10F;
		matrixStackIn.push();
		matrixStackIn.translate(0, y, 0);
		matrixStackIn.rotate(Vector3f.YP.rotation((float) (0.05 * ticks)));
		matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(180));
		IRenderTypeBuffer.Impl impl = IRenderTypeBuffer.getImpl(Tessellator.getInstance().getBuffer());
		IVertexBuilder ivertexbuilder = impl.getBuffer(
				pylon.getRenderType(new ResourceLocation(HutosMod.MOD_ID + ":textures/blocks/hastur_pylon.png")));
		pylon.render(matrixStackIn, ivertexbuilder, combinedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		impl.finish();
		matrixStackIn.pop();

	}

}
