package com.huto.forcesofreality.models.entity.mobs;

import com.huto.forcesofreality.entities.mobs.EntityDevotee;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelDevotee extends PlayerModel<EntityDevotee> {

	public ModelDevotee() {
		super(0.3f, false);
		textureWidth = 64;
		textureHeight = 64;
	}

	@Override
	public void setRotationAngles(EntityDevotee entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		this.getHeadParts().forEach((p_228228_8_) -> {
			p_228228_8_.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		});
		this.getBodyParts().forEach((p_228227_8_) -> {
			p_228227_8_.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		});
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}