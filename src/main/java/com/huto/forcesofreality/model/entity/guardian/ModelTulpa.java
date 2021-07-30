package com.huto.forcesofreality.model.entity.guardian;

import com.huto.forcesofreality.entity.guardian.EntityTulpa;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelTulpa extends PlayerModel<EntityTulpa> {
	public ModelTulpa() {
		super(0.3f, Minecraft.getInstance().getRenderManager().getSkinMap().get("default") != null ? false : true);
		textureWidth = 64;
		textureHeight = 64;
	}

	@Override
	public void setRotationAngles(EntityTulpa entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}