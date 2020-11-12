package com.huto.hutosmod.models.entity;

import com.huto.hutosmod.entities.EntityDenizen;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;


public class ModelDenizen extends EntityModel<EntityDenizen> {
	private final ModelRenderer right_arm;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_leg;
	private final ModelRenderer left_leg;

	public ModelDenizen() {
		textureWidth = 128;
		textureHeight = 128;

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-4.0F, 2.0F, 1.0F);
		right_arm.setTextureOffset(40, 40).addBox(-4.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.0F, 0.0F);
		body.setTextureOffset(0, 38).addBox(-4.0F, -15.5F, 0.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-9.0F, -16.5F, -4.0F, 18.0F, 25.0F, 13.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 1.0F, 2.0F);
		head.setTextureOffset(49, 0).addBox(-2.0F, -9.0F, -6.0F, 4.0F, 4.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(50, 50).addBox(-1.0F, -7.0F, -12.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(0, 7).addBox(-1.0F, -5.0F, -13.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 54).addBox(-2.0F, -7.0F, -1.0F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(4.0F, 2.0F, 1.0F);
		left_arm.setTextureOffset(24, 38).addBox(0.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-4.0F, 14.0F, 0.0F);
		left_arm.addChild(right_leg);
		right_leg.setTextureOffset(28, 54).addBox(-4.0F, -4.5F, -2.0F, 3.0F, 7.0F, 4.0F, 0.0F, false);
		right_leg.setTextureOffset(56, 32).addBox(-3.0F, 7.5F, -2.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		right_leg.setTextureOffset(42, 56).addBox(-3.0F, 2.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		right_leg.setTextureOffset(36, 38).addBox(-4.0F, 7.5F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		right_leg.setTextureOffset(20, 38).addBox(-2.0F, 7.5F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(0.0F, 16.0F, 1.0F);
		left_leg.setTextureOffset(14, 54).addBox(1.0F, -4.5F, -2.0F, 3.0F, 7.0F, 4.0F, 0.0F, false);
		left_leg.setTextureOffset(6, 9).addBox(1.0F, 7.5F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		left_leg.setTextureOffset(6, 6).addBox(3.0F, 7.5F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		left_leg.setTextureOffset(0, 0).addBox(1.0F, 2.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		left_leg.setTextureOffset(56, 39).addBox(1.0F, 7.5F, -2.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityDenizen entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.head.rotateAngleX = (-(float) Math.PI / 4F);
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);

		this.right_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount
				* 0.5F;
		this.left_arm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}