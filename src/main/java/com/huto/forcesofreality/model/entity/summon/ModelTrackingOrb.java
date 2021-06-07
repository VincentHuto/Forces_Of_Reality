package com.huto.forcesofreality.model.entity.summon;

import com.huto.forcesofreality.entity.projectile.EntityTrackingOrb;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelTrackingOrb extends EntityModel<EntityTrackingOrb> {

	public ModelTrackingOrb() {

		textureWidth = 64;
		textureHeight = 64;
	}

	@Override
	public void setRotationAngles(EntityTrackingOrb entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}