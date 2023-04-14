package com.vincenthuto.forcesofreality.render.tile.coven;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.vincenthuto.forcesofreality.render.tile.ClientTickHandler;
import com.vincenthuto.forcesofreality.tile.BlockEntityMachinaImperfecta;
import com.vincenthuto.hutoslib.math.Vector3;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class RenderMachinaImperfecta implements BlockEntityRenderer<BlockEntityMachinaImperfecta> {
//	private final ModelFloatingGearVert gearVert = new ModelFloatingGearVert();
//	private final ModelFloatingGearHoriz gearHoriz = new ModelFloatingGearHoriz();
//	private final ModelGearShaft gearshaft = new ModelGearShaft();

	public RenderMachinaImperfecta(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super();
	}

	@Override
	public void render(BlockEntityMachinaImperfecta te, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {

		matrixStackIn.pushPose();
		matrixStackIn.pushPose();
		MultiBufferSource.BufferSource impl = MultiBufferSource.immediate(Tesselator.getInstance().getBuilder());
		matrixStackIn.translate(0.5f, -1.12f, 0.5f);
		matrixStackIn.mulPose(Vector3.YP.rotation(te.getLevel().getGameTime() * 0.22f).toMoj());
//		VertexConsumer vb = impl.getBuffer(gearHoriz
//				.renderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/entity/model_floating_gear.png")));
//		VertexConsumer vb1 = impl.getBuffer(gearshaft
//				.renderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/entity/model_gearshaft.png")));
//		gearHoriz.renderToBuffer(matrixStackIn, vb, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
//
//		matrixStackIn.translate(0, .45, 0);
//		gearshaft.renderToBuffer(matrixStackIn, vb1, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
//		matrixStackIn.translate(0, -.45, 0);
//
//		matrixStackIn.mulPose(Vector3.YP.rotation(te.getLevel().getGameTime() * -0.44f));
//		matrixStackIn.translate(0, .38, 0);
//
//		gearHoriz.renderToBuffer(matrixStackIn, vb, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
//		gearshaft.renderToBuffer(matrixStackIn, vb1, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F, 1.0F, 1.0F);
//		impl.endBatch();

		matrixStackIn.popPose();

		matrixStackIn.translate(0.5f, 0.55f, 0.5f);
		matrixStackIn.scale(0.5f, 0.5f, 0.5f);
		// Cubes
		for (int i = 0; i < te.clientDevo; i++) {
			double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
			final float modifier = 6F;
			final float rotationModifier = 0.4F;
			final float radiusBase = 0.3F;
			final float radiusMod = 0.1F;
			int cubes = te.clientDevo;
			float offsetPerCube = 360 / cubes;
			float offset = offsetPerCube * i;
			float deg = (int) (ticks / rotationModifier % 360F + offset);
			float rad = deg * (float) Math.PI / 180F;
			float radiusX = (float) (radiusBase + radiusMod * Math.sin(ticks / modifier));
			float radiusZ = (float) (radiusBase + radiusMod * Math.cos(ticks / modifier));
			float x = (float) (radiusX * Math.cos(rad));
			float z = (float) (radiusZ * Math.sin(rad));
			float y = (float) Math.cos((ticks + 50 * i) / 5F) / 10F;
			matrixStackIn.pushPose();
			matrixStackIn.translate(x, y, z);
			float yRotate = (float) Math.max(0.6F, Math.sin(ticks * 0.1F) / 2F + 0.5F);
			matrixStackIn.mulPose(Vector3.YP.rotation(yRotate).toMoj());
			MultiBufferSource.BufferSource irendertypebuffer$impl1 = MultiBufferSource
					.immediate(Tesselator.getInstance().getBuilder());
//			VertexConsumer ivertexbuilder1 = irendertypebuffer$impl1.getBuffer(gearVert.renderType(
//					new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/entity/model_floating_gear.png")));
//			gearVert.renderToBuffer(matrixStackIn, ivertexbuilder1, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F,
//					1.0F, 1.0F);

			irendertypebuffer$impl1.endBatch();
			matrixStackIn.popPose();

		}
		matrixStackIn.popPose();

	}
}
