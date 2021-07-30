package com.huto.forcesofreality.model.entity.passive;

import com.huto.forcesofreality.entity.passive.EntityAngelicFowl;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.math.MathHelper;

public class ModelAngelicFowl extends EntityModel<EntityAngelicFowl> {
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart Body;
	private final ModelPart tail;
	private final ModelPart RightWing;
	private final ModelPart LeftWing;
	private final ModelPart Neck;
	private final ModelPart Head;

	public ModelAngelicFowl() {
		textureWidth = 64;
		textureHeight = 64;

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.0F, 19.0F, 4.0F);
		RightLeg.setTextureOffset(20, 12).addBox(-1.0F, 2.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(19, 4).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(2, 11).addBox(-1.0F, 5.0F, -3.0F, 1.0F, 0.0F, 3.0F, 0.0F, false);
		RightLeg.setTextureOffset(16, 12).addBox(0.0F, 5.0F, -4.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);
		RightLeg.setTextureOffset(3, 16).addBox(-2.0F, 5.0F, -4.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.0F, 19.0F, 4.0F);
		LeftLeg.setTextureOffset(0, 22).addBox(0.0F, 2.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(20, 16).addBox(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 16).addBox(0.0F, 5.0F, -3.0F, 1.0F, 0.0F, 3.0F, 0.0F, false);
		LeftLeg.setTextureOffset(8, 17).addBox(1.0F, 5.0F, -4.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);
		LeftLeg.setTextureOffset(10, 17).addBox(-1.0F, 5.0F, -4.0F, 1.0F, 0.0F, 2.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 16.5F, 2.1F);
		Body.setTextureOffset(0, 4).addBox(0.0F, -2.5F, -2.1F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(1, 5).addBox(0.0F, -2.5F, 2.9F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 2).addBox(0.0F, -2.5F, -0.1F, 0.0F, 1.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(2, 4).addBox(0.0F, -1.5F, 3.9F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-3.0F, -1.5F, -3.1F, 6.0F, 4.0F, 7.0F, 0.0F, false);
		Body.setTextureOffset(10, 13).addBox(-2.0F, -1.5F, -3.2F, 4.0F, 4.0F, 0.0F, 0.0F, false);
		Body.setTextureOffset(14, 17).addBox(-1.0F, 2.5F, -3.1F, 2.0F, 2.0F, 0.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -0.2F, 4.3F);
		Body.addChild(tail);
		setRotationAngle(tail, -0.6545F, 0.0F, 0.0F);
		tail.setTextureOffset(8, 11).addBox(-2.0F, 0.0F, 3.5F, 4.0F, 0.0F, 2.0F, 0.0F, false);
		tail.setTextureOffset(15, 0).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 0.0F, 4.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-3.0F, 16.0F, 2.0F);
		RightWing.setTextureOffset(10, 14).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		RightWing.setTextureOffset(19, 4).addBox(-1.0F, 2.0F, -2.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		RightWing.setTextureOffset(0, 22).addBox(-1.0F, 3.0F, -2.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(3.0F, 16.0F, 2.0F);
		LeftWing.setTextureOffset(0, 11).addBox(0.0F, -1.0F, -2.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		LeftWing.setTextureOffset(20, 12).addBox(0.0F, 2.0F, -2.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		LeftWing.setTextureOffset(22, 22).addBox(0.0F, 3.0F, -2.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, 15.0F, -1.0F);
		Neck.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-0.5F, 12.0F, -2.0F);
		Head.setTextureOffset(28, 1).addBox(-1.0F, -3.0F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(0, 2).addBox(0.5F, -4.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(0, 4).addBox(0.5F, -5.0F, -3.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(0, 10).addBox(0.5F, -3.0F, 0.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 10).addBox(0.5F, 0.0F, 1.0F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(0, 11).addBox(0.0F, -2.0F, -6.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(20, 20).addBox(0.0F, -1.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityAngelicFowl entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		// this.Body.rotateAngleX = ((float) Math.PI / 2F);
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.RightWing.rotateAngleZ = ageInTicks;
		this.LeftWing.rotateAngleZ = -ageInTicks;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing.render(matrixStack, buffer, packedLight, packedOverlay);
		Neck.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}