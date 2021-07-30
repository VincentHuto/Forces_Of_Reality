package com.huto.forcesofreality.model.entity.summon;

import com.huto.forcesofreality.entity.summon.EntityThrone;
import com.hutoslib.client.ClientUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;


public class ModelThrone extends EntityModel<EntityThrone> {
	private final ModelPart Core;
	private final ModelPart NSWheel;
	private final ModelPart EWWheel;

	public ModelThrone() {
		textureWidth = 64;
		textureHeight = 64;

		Core = new ModelRenderer(this);
		Core.setRotationPoint(0.0F, 16.0F, 0.0F);
		Core.setTextureOffset(16, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		NSWheel = new ModelRenderer(this);
		NSWheel.setRotationPoint(0.0F, 16.0F, 0.0F);
		NSWheel.setTextureOffset(26, 26).addBox(-1.0F, -6.0F, 6.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		NSWheel.setTextureOffset(0, 14).addBox(-1.0F, 6.0F, -6.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
		NSWheel.setTextureOffset(0, 0).addBox(-1.0F, -8.0F, -6.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
		NSWheel.setTextureOffset(0, 28).addBox(-1.0F, -6.0F, -8.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);

		EWWheel = new ModelRenderer(this);
		EWWheel.setRotationPoint(0.0F, 16.0F, 0.0F);
		EWWheel.setTextureOffset(0, 0).addBox(-6.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
		EWWheel.setTextureOffset(16, 0).addBox(-4.0F, 4.0F, -1.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
		EWWheel.setTextureOffset(16, 16).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
		EWWheel.setTextureOffset(0, 14).addBox(4.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityThrone entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		float parTicks = ClientUtils.getPartialTicks();

		
		this.NSWheel.rotateAngleX = (entity.ticksExisted+ parTicks) * 0.4f;
		this.EWWheel.rotateAngleX = -(entity.ticksExisted+ parTicks) * 0.4f;
		this.NSWheel.rotateAngleY = (entity.ticksExisted+ parTicks) * 0.4f;
		this.EWWheel.rotateAngleZ = -(entity.ticksExisted+ parTicks) * 0.4f;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Core.render(matrixStack, buffer, packedLight, packedOverlay);
		NSWheel.render(matrixStack, buffer, packedLight, packedOverlay);
		EWWheel.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}