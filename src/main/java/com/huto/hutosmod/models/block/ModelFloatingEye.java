package com.huto.hutosmod.models.block;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelFloatingEye extends Model {
	private final ModelRenderer bb_main;
	private final List<ModelRenderer> candleParts;

	public ModelFloatingEye() {
		super(RenderType::getEntitySolid);
		textureWidth = 16;
		textureHeight = 16;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		this.candleParts = ImmutableList.of(this.bb_main);

		}

		@Override
		public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
				float red, float green, float blue, float alpha) {
			this.renderAll(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		}

		public void renderAll(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
				float green, float blue, float alpha) {
			this.candleParts.forEach((p_228248_8_) -> {
				p_228248_8_.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			});
		}
}