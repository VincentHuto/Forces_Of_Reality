package com.huto.hutosmod.render.tiles.coven;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.models.block.ModelFloatingSkull;
import com.huto.hutosmod.models.block.ModelHorizontalBone;
import com.huto.hutosmod.objects.tileenties.TileEntitySacrificePyre;
import com.huto.hutosmod.objects.tileenties.util.ClientTickHandler;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class RenderSacrificialPyre extends TileEntityRenderer<TileEntitySacrificePyre> {

	private final ModelHorizontalBone boneHoriz = new ModelHorizontalBone();

	public static final ResourceLocation NEW_TEXTURE_BOOK = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/floating_skull_pyre.png");
	private final ModelFloatingSkull modelBook = new ModelFloatingSkull();

	public RenderSacrificialPyre(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntitySacrificePyre te, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		matrixStackIn.push();
		matrixStackIn.translate(0.5D, 2.1D + te.yFloatLevel, 0.5D);
		float f = (float) te.ticks + partialTicks;
		matrixStackIn.translate(0.0D, (double) (0.1F + MathHelper.sin(f * 0.1F) * 0.01F), 0.0D);

		float f1;
		for (f1 = te.nextPageAngle - te.pageAngle; f1 >= (float) Math.PI; f1 -= ((float) Math.PI * 2F)) {
		}

		while (f1 < -(float) Math.PI) {
			f1 += ((float) Math.PI * 2F);
		}
		float f2 = te.pageAngle + f1 * partialTicks;
		matrixStackIn.rotate(Vector3f.YP.rotation(-f2 + 55));
		matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(180));
		matrixStackIn.rotate(Vector3f.XP.rotationDegrees(10));

		float f3 = MathHelper.lerp(partialTicks, te.field_195524_g, te.field_195523_f);
		float f4 = MathHelper.frac(f3 + 0.25F) * 1.6F - 0.3F;
		float f5 = MathHelper.frac(f3 + 0.75F) * 1.6F - 0.3F;
		float f6 = MathHelper.lerp(partialTicks, te.pageTurningSpeed, te.nextPageTurningSpeed);
		this.modelBook.setBookState(f, MathHelper.clamp(f4, 0.0F, 1.0F), MathHelper.clamp(f5, 0.0F, 1.0F), f6);
		IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer
				.getImpl(Tessellator.getInstance().getBuffer());
		IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(modelBook.getRenderType(NEW_TEXTURE_BOOK));
		matrixStackIn.scale(0.95f, 0.95f, 0.95f);
		modelBook.render(matrixStackIn, ivertexbuilder, combinedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F,
				1.0F);
		irendertypebuffer$impl.finish();
		matrixStackIn.pop();

		matrixStackIn.push();

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
			float y = (float) Math.cos((ticks + 510 * i) / 5F) /120F;
			matrixStackIn.push();
			matrixStackIn.translate(x, y, z);
			float yRotate = (float) Math.max(1.6F, Math.sin(ticks * 1.1F) / 2F + 0.5F);
			matrixStackIn.rotate(Vector3f.YP.rotation(yRotate));
			IRenderTypeBuffer.Impl irendertypebuffer$impl1 = IRenderTypeBuffer
					.getImpl(Tessellator.getInstance().getBuffer());
			IVertexBuilder ivertexbuilder1 = irendertypebuffer$impl1.getBuffer(
					boneHoriz.getRenderType(new ResourceLocation(HutosMod.MOD_ID + ":textures/entity/bone_wrap.png")));
			boneHoriz.render(matrixStackIn, ivertexbuilder1, combinedLightIn,combinedOverlayIn, 1.0F, 1.0F, 1.0F,
					1.0F);
			irendertypebuffer$impl1.finish();
			matrixStackIn.pop();

		}
		matrixStackIn.pop();

	}

}
