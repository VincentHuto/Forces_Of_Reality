package com.huto.hutosmod.render.tile;

import com.huto.hutosmod.HutosMod;
import com.huto.hutosmod.objects.tileenties.TileEntityVirtuousEnchant;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.model.BookModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class RenderVirtuousEnchanter extends TileEntityRenderer<TileEntityVirtuousEnchant> {
	/** The texture for the book above the enchantment table. */
	public static final ResourceLocation NEW_TEXTURE_BOOK = new ResourceLocation(HutosMod.MOD_ID,
			"textures/entity/virtuous_table_book.png");
	private final BookModel modelBook = new BookModel();

	public RenderVirtuousEnchanter(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntityVirtuousEnchant tileEntityIn, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		matrixStackIn.push();
		matrixStackIn.translate(0.5D, 0.8D, 0.5D);
		float f = (float) tileEntityIn.ticks + partialTicks;
		matrixStackIn.translate(0.0D, (double) (0.1F + MathHelper.sin(f * 0.1F) * 0.01F), 0.0D);

		float f1;
		for (f1 = tileEntityIn.nextPageAngle
				- tileEntityIn.pageAngle; f1 >= (float) Math.PI; f1 -= ((float) Math.PI * 2F)) {
		}

		while (f1 < -(float) Math.PI) {
			f1 += ((float) Math.PI * 2F);
		}
		float f2 = tileEntityIn.pageAngle + f1 * partialTicks;
		matrixStackIn.rotate(Vector3f.YP.rotation(-f2));
		matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(80.0F));
		float f3 = MathHelper.lerp(partialTicks, tileEntityIn.field_195524_g, tileEntityIn.field_195523_f);
		float f4 = MathHelper.frac(f3 + 0.25F) * 1.6F - 0.3F;
		float f5 = MathHelper.frac(f3 + 0.75F) * 1.6F - 0.3F;
		float f6 = MathHelper.lerp(partialTicks, tileEntityIn.pageTurningSpeed, tileEntityIn.nextPageTurningSpeed);
		this.modelBook.setBookState(f, MathHelper.clamp(f4, 0.0F, 1.0F), MathHelper.clamp(f5, 0.0F, 1.0F), f6);
		IRenderTypeBuffer.Impl irendertypebuffer$impl = IRenderTypeBuffer
				.getImpl(Tessellator.getInstance().getBuffer());
		IVertexBuilder ivertexbuilder = irendertypebuffer$impl.getBuffer(modelBook.getRenderType(NEW_TEXTURE_BOOK));
		matrixStackIn.scale(0.75f, 0.75f, 0.75f);
		modelBook.render(matrixStackIn, ivertexbuilder, combinedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		irendertypebuffer$impl.finish();
		matrixStackIn.pop();
	}

}
