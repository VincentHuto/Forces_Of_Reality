package com.huto.forces_of_reality.models.block;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelFloatingGearVert extends Model {
	private final ModelRenderer bb_main;
	private final List<ModelRenderer> bookParts;

	public ModelFloatingGearVert() {
		super(RenderType::getEntitySolid);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 4.0F, 0.5F);
		bb_main.setTextureOffset(8, 4).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(7, 8).addBox(-1.0F, -8.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(4, 9).addBox(-4.0F, -5.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 9).addBox(3.0F, -5.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 14).addBox(2.0F, -8.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(11, 13).addBox(-3.0F, -8.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(12, 9).addBox(-3.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(12, 6).addBox(2.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(12, 2).addBox(3.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(12, 0).addBox(-4.0F, -2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(8, 12).addBox(-4.0F, -7.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(4, 12).addBox(3.0F, -7.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 12).addBox(-2.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(11, 11).addBox(1.0F, -6.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(8, 10).addBox(-2.0F, -6.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(9, 1).addBox(1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(4, 4).addBox(-3.0F, -6.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 2).addBox(-2.0F, -7.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 4).addBox(2.0F, -6.0F, 0.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(7, 6).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 0.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(7, 7).addBox(-1.0F, -5.0F, 0.0F, 2.0F, 0.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(6, 13).addBox(-1.0F, -5.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(4, 13).addBox(1.0F, -5.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		this.bookParts = ImmutableList.of(this.bb_main);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		this.renderAll(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	public void renderAll(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		this.bookParts.forEach((p_228248_8_) -> {
			p_228248_8_.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		});
	}

}