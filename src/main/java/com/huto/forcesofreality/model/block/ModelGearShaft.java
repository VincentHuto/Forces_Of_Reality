
package com.huto.forcesofreality.model.block;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;

public class ModelGearShaft extends Model {
	private final ModelPart bone;
	private final List<ModelPart> skullParts;

	public ModelGearShaft() {
		super(RenderType::getEntitySolid);
		textureWidth = 32;
		textureHeight = 32;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 2).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
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