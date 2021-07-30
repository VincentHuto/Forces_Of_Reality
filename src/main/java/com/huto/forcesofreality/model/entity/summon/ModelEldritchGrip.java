package com.huto.forcesofreality.model.entity.summon;

import com.huto.forcesofreality.entity.summon.EntityEldritchGrip;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;

public class ModelEldritchGrip extends EntityModel<EntityEldritchGrip> {
	private final ModelPart bone;

	public ModelEldritchGrip() {
		textureWidth = 256;
		textureHeight = 256;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-24.0F, -0.1F, -24.0F, 48.0F, 0.0F, 48.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityEldritchGrip entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		bone.rotateAngleY = ageInTicks*2f;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}