package com.huto.forcesofreality.model.block;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;

// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class ModelHasturPylon extends Model {
	private final ModelPart bb_main;
	private final List<ModelPart> bookParts;

	public ModelHasturPylon() {
		super(RenderType::getEntitySolid);
		textureWidth = 32;
		textureHeight = 32;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 20).addBox(-5.0F, -14.0F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-3.0F, -12.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		bb_main.setTextureOffset(18, 12).addBox(-2.0F, -14.0F, -5.0F, 4.0F, 6.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(12, 16).addBox(4.0F, -14.0F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(22, 22).addBox(-2.0F, -14.0F, 4.0F, 4.0F, 6.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(18, 0).addBox(-4.0F, -6.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(6, 20).addBox(-1.0F, -6.0F, 3.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(12, 12).addBox(-1.0F, -6.0F, -4.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(3.0F, -6.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(14, 26).addBox(3.0F, -16.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(10, 26).addBox(-4.0F, -16.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(24, 6).addBox(-4.0F, -16.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(24, 0).addBox(3.0F, -16.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 12).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		this.bookParts = ImmutableList.of(bb_main);

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