package com.huto.hutosmod.models;

import com.huto.hutosmod.entities.EntityDenizenSage;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelDenizenSage extends EntityModel<EntityDenizenSage> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public ModelDenizenSage() {
		textureWidth = 128;
		textureHeight = 128;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, -2.0F);
		Head.setTextureOffset(52, 39).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 5.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(48, 32).addBox(-2.0F, -6.0F, -7.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(27, 51).addBox(-1.0F, -5.0F, -12.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		Head.setTextureOffset(30, 0).addBox(-1.0F, -3.0F, -14.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 9.6667F, 0.0F);
		Body.setTextureOffset(0, 24).addBox(-5.0F, -10.6667F, -2.0F, 10.0F, 12.0F, 9.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-5.0F, 1.3333F, -3.0F, 10.0F, 14.0F, 10.0F, 0.0F, false);
		Body.setTextureOffset(35, 19).addBox(-4.0F, -7.6667F, -7.0F, 8.0F, 8.0F, 5.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, -1.0F);
		RightArm.setTextureOffset(40, 0).addBox(-3.0F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, -1.0F);
		LeftArm.setTextureOffset(38, 38).addBox(0.0F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
		RightLeg.setTextureOffset(16, 45).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 0).addBox(-1.1F, 7.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		RightLeg.setTextureOffset(45, 47).addBox(-1.2F, 12.0F, -2.0F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		RightLeg.setTextureOffset(54, 0).addBox(-2.2F, 12.0F, -4.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		RightLeg.setTextureOffset(29, 29).addBox(-0.2F, 12.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
		LeftLeg.setTextureOffset(0, 45).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 24).addBox(-1.0F, 7.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		LeftLeg.setTextureOffset(47, 9).addBox(-1.0F, 12.0F, -2.0F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		LeftLeg.setTextureOffset(36, 54).addBox(1.0F, 12.0F, -4.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 7).addBox(-1.0F, 12.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityDenizenSage entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.Head.rotateAngleX = (-(float) Math.PI / 4F);
		this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);

		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount
				* 0.5F;
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}