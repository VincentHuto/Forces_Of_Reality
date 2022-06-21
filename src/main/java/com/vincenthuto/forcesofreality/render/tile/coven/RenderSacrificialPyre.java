package com.vincenthuto.forcesofreality.render.tile.coven;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.math.Vector3f;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.render.tile.ClientTickHandler;
import com.vincenthuto.forcesofreality.tile.coven.BlockEntitySacrificePyre;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class RenderSacrificialPyre implements BlockEntityRenderer<BlockEntitySacrificePyre> {

//	private final ModelHorizontalBone boneHoriz = new ModelHorizontalBone();

	public static final ResourceLocation NEW_TEXTURE_BOOK = new ResourceLocation(ForcesOfReality.MOD_ID,
			"textures/entity/floating_skull_pyre.png");
//	private final ModelFloatingSkull modelBook = new ModelFloatingSkull();

	public RenderSacrificialPyre(BlockEntityRendererProvider.Context rendererDispatcherIn) {
	}

	@Override
	public void render(BlockEntitySacrificePyre te, float partialTicks, PoseStack matrixStackIn,
			MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
		matrixStackIn.pushPose();
		matrixStackIn.translate(0.5D, 2.1D + te.yFloatLevel, 0.5D);
		float f = te.ticks + partialTicks;
		matrixStackIn.translate(0.0D, 0.1F + Mth.sin(f * 0.1F) * 0.01F, 0.0D);

		float f1;
		for (f1 = te.nextPageAngle - te.pageAngle; f1 >= (float) Math.PI; f1 -= ((float) Math.PI * 2F)) {
		}

		while (f1 < -(float) Math.PI) {
			f1 += ((float) Math.PI * 2F);
		}
		float f2 = te.pageAngle + f1 * partialTicks;
		matrixStackIn.mulPose(Vector3f.YP.rotation(-f2 + 55));
		matrixStackIn.mulPose(Vector3f.ZN.rotationDegrees(180));
		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(10));

		float f3 = Mth.lerp(partialTicks, te.oFlip, te.flip);
		float f4 = Mth.frac(f3 + 0.25F) * 1.6F - 0.3F;
		float f5 = Mth.frac(f3 + 0.75F) * 1.6F - 0.3F;
		float f6 = Mth.lerp(partialTicks, te.pageTurningSpeed, te.nextPageTurningSpeed);
//		this.modelBook.setBookState(f, Mth.clamp(f4, 0.0F, 1.0F), Mth.clamp(f5, 0.0F, 1.0F), f6);
//		MultiBufferSource.BufferSource irendertypebuffer$impl = MultiBufferSource
//				.immediate(Tesselator.getInstance().getBuilder());
//		VertexConsumer ivertexbuilder = irendertypebuffer$impl.getBuffer(modelBook.renderType(NEW_TEXTURE_BOOK));
//		matrixStackIn.scale(0.95f, 0.95f, 0.95f);
//		modelBook.renderToBuffer(matrixStackIn, ivertexbuilder, combinedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F,
//				1.0F, 1.0F);
//		irendertypebuffer$impl.endBatch();
		matrixStackIn.popPose();

		matrixStackIn.pushPose();

		matrixStackIn.translate(0.5, 1., 0.5);
		matrixStackIn.scale(0.5f, -0.5f, 0.5f);
		// Cubes
		for (int i = 0; i < te.clientDevo; i++) {
			double ticks = ClientTickHandler.ticksInGame + ClientTickHandler.partialTicks - 1.3;
			final float modifier = 2f;
			final float rotationModifier = 0.2F;
			final float radiusBase = 0.7F;
			final float radiusMod = 0.0F;
			int cubes = te.clientDevo;
			float offsetPerCube = 360 / cubes;
			float offset = offsetPerCube * i;
			float deg = (int) (ticks / rotationModifier % 360F + offset);
			float rad = deg * (float) Math.PI / 180F;
			float radiusX = (float) (radiusBase + radiusMod * Math.sin(ticks / modifier));
			float radiusZ = (float) (radiusBase + radiusMod * Math.cos(ticks / modifier));
			float x = (float) (radiusX * Math.cos(rad));
			float z = (float) (radiusZ * Math.sin(rad));
			float y = (float) Math.cos((ticks + 510 * i) / 5F) / 120F;
			matrixStackIn.pushPose();
			matrixStackIn.translate(x, y, z);
			float yRotate = (float) Math.max(1.6F, Math.sin(ticks * 1.1F) / 2F + 0.5F);
			matrixStackIn.mulPose(Vector3f.YP.rotation(yRotate));
			MultiBufferSource.BufferSource irendertypebuffer$impl1 = MultiBufferSource
					.immediate(Tesselator.getInstance().getBuilder());
//			VertexConsumer ivertexbuilder1 = irendertypebuffer$impl1.getBuffer(boneHoriz
//					.renderType(new ResourceLocation(ForcesOfReality.MOD_ID + ":textures/entity/bone_wrap.png")));
//			boneHoriz.renderToBuffer(matrixStackIn, ivertexbuilder1, combinedLightIn, combinedOverlayIn, 1.0F, 1.0F,
//					1.0F, 1.0F);
			irendertypebuffer$impl1.endBatch();
			matrixStackIn.popPose();

		}
		matrixStackIn.popPose();

	}

}
