package com.huto.forcesofreality.render.tile.coven;

import com.huto.forcesofreality.ForcesOfReality;
import com.huto.forcesofreality.model.block.ModelHasturPylon;
import com.huto.forcesofreality.model.block.ObjModelHandler;
import com.huto.forcesofreality.render.tile.ClientTickHandler;
import com.huto.forcesofreality.tile.coven.TileEntityHasturPylon;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.common.util.NonNullLazy;

public class RenderHasturPylon extends BlockEntityRenderer<TileEntityHasturPylon> {
	private final ModelHasturPylon pylon = new ModelHasturPylon();
	public static final NonNullLazy<ObjModelHandler> modelTorus = NonNullLazy
			.of(() -> ObjModelHandler.of("forcesofreality:models/block/torus.obj"));

	public RenderHasturPylon(BlockEntityRenderDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void render(TileEntityHasturPylon te, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
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
				pylon.getRenderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/blocks/hastur_pylon.png")));
		pylon.render(matrixStackIn, ivertexbuilder, combinedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		impl.finish();
		matrixStackIn.pop();

	}

}
