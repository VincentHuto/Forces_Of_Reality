
package com.huto.forcesofreality.models.block;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelVeticalBone extends Model {
	private final ModelRenderer bone;
	private final List<ModelRenderer> skullParts;

	public ModelVeticalBone() {
		super(RenderType::getEntitySolid);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 2).addBox(-1.0F, -6.0F, -5.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 2).addBox(-1.0F, -6.0F, 3.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 2).addBox(-1.0F, -2.0F, -5.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 2).addBox(-1.0F, -2.0F, 3.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 8).addBox(-1.0F, -4.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
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