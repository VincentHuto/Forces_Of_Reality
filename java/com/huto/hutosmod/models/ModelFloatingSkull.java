
package com.huto.hutosmod.models;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelFloatingSkull extends Model {
	private final ModelRenderer bone;
	private final List<ModelRenderer> skullParts;

	public ModelFloatingSkull() {
		super(RenderType::getEntitySolid);
		textureWidth = 32;
		textureHeight = 32;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 21.9167F, 1.3333F);
		bone.setTextureOffset(0, 0).addBox(-2.0F, -0.9167F, -2.3333F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-1.0F, 0.0833F, -6.3333F, 2.0F, 2.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-3.0F, -0.9167F, -0.3333F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(2.0F, -0.9167F, -0.3333F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(3.0F, -1.9167F, 0.6667F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-4.0F, -1.9167F, 0.6667F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		this.skullParts = ImmutableList.of(this.bone);
	}

	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		this.renderAll(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	public void renderAll(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		this.skullParts.forEach((p_228248_8_) -> {
			p_228248_8_.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		});
	}

	public void setBookState(float p_228247_1_, float rightPageFlipAmount, float leftPageFlipAmount,
			float bookOpenAmount) {

	}
}