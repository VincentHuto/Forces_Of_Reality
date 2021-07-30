package com.huto.forcesofreality.model.block;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;

public class ModelFloatingCube extends Model {

	final ModelPart spinningCube;
	private final List<ModelPart> bookParts;

	public ModelFloatingCube() {
		super(RenderType::getEntitySolid);

		spinningCube = new ModelRenderer(1, 1, 0, 10);
		spinningCube.addBox(0, 0, 0, 1.0F, 1.0F, 1.0F);
		spinningCube.setRotationPoint(0F, 0F, 0F);
		spinningCube.setTextureSize(256, 256);

		this.bookParts = ImmutableList.of(this.spinningCube);

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
