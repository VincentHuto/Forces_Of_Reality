package com.huto.hutosmod.models;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelDrumMagatama extends Model {

	// final ModelRenderer spinningCube;
	private final List<ModelRenderer> bookParts;
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape3;
	public ModelRenderer shape4;
	public ModelRenderer shape5;
	public ModelRenderer shape6;
	public ModelRenderer shape7;
	public ModelRenderer shape8;

	public ModelDrumMagatama() {
		super(RenderType::getEntitySolid);
		/*
		 * spinningCube = new ModelRenderer(64, 32, 0, 10); spinningCube.addBox(0,0,0,
		 * 8.0F, 8.0F, 8.0F); spinningCube.setRotationPoint(0F, 0F, 0F);
		 * spinningCube.setTextureSize(32, 32);
		 */

		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(-2.0F, 23.0F, 0.0F);
		this.shape1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.shape4 = new ModelRenderer(this, 14, 0);
		this.shape4.setRotationPoint(-3.0F, 19.0F, 0.0F);
		this.shape4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
		this.shape8 = new ModelRenderer(this, 0, 0);
		this.shape8.setRotationPoint(-2.0F, 17.0F, 0.0F);
		this.shape8.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.shape2 = new ModelRenderer(this, 4, 0);
		this.shape2.setRotationPoint(-1.0F, 20.0F, 0.0F);
		this.shape2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
		this.shape5 = new ModelRenderer(this, 24, 0);
		this.shape5.setRotationPoint(-3.0F, 17.0F, 0.0F);
		this.shape5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
		this.shape3 = new ModelRenderer(this, 0, 0);
		this.shape3.setRotationPoint(-1.0F, 22.0F, 0.0F);
		this.shape3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.shape7 = new ModelRenderer(this, 15, 2);
		this.shape7.setRotationPoint(-2.0F, 16.0F, 0.0F);
		this.shape7.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.shape6 = new ModelRenderer(this, 9, 2);
		this.shape6.setRotationPoint(-1.0F, 17.0F, 0.0F);
		this.shape6.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);

		this.bookParts = ImmutableList.of(this.shape1, this.shape2, this.shape3, this.shape4, this.shape5, this.shape6,
				this.shape7, this.shape8);

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
