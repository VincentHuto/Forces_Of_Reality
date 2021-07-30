package com.huto.forcesofreality.model.entity.mob;


import com.huto.forcesofreality.entity.mob.EntityDerangedBeast;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.math.MathHelper;



public class ModelDerangedBeast extends EntityModel<EntityDerangedBeast> {
	private final ModelPart Head;
	private final ModelPart JawTop;
	private final ModelPart JawBottom;
	private final ModelPart Body;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;
	private final ModelPart BottomLeftLeg;
	private final ModelPart LeftFoot2;
	private final ModelPart BottomRightLeg;
	private final ModelPart RightFoot2;

	public ModelDerangedBeast() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 6.0F, -4.4F);
		Head.setTextureOffset(40, 0).addBox(-1.0F, -3.0F, -2.6F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(0, 22).addBox(-2.0F, -2.0F, -3.6F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(0, 3).addBox(0.0F, -4.0F, -2.6F, 0.0F, 1.0F, 3.0F, 0.0F, false);

		JawTop = new ModelRenderer(this);
		JawTop.setRotationPoint(0.6667F, 1.1667F, -3.9333F);
		Head.addChild(JawTop);
		JawTop.setTextureOffset(14, 28).addBox(-1.6667F, -1.1667F, -1.6667F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		JawTop.setTextureOffset(20, 25).addBox(0.3333F, -0.1667F, -1.6667F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		JawTop.setTextureOffset(20, 25).addBox(-1.6667F, -0.1667F, -1.6667F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		JawBottom = new ModelRenderer(this);
		JawBottom.setRotationPoint(-0.6667F, 1.8333F, -3.1F);
		Head.addChild(JawBottom);
		JawBottom.setTextureOffset(26, 17).addBox(-0.3333F, 0.1667F, -1.5F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		JawBottom.setTextureOffset(20, 25).addBox(-0.3333F, -0.8333F, 0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		JawBottom.setTextureOffset(20, 25).addBox(-0.3333F, -0.8333F, -1.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		JawBottom.setTextureOffset(20, 25).addBox(1.6667F, -0.8333F, -1.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 7.7667F, 0.56F);
		Body.setTextureOffset(19, 11).addBox(-4.0F, -0.7667F, -4.56F, 8.0F, 5.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(26, 9).addBox(-3.0F, 4.2333F, -4.56F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(26, 6).addBox(-3.0F, 3.2333F, -3.56F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(19, 0).addBox(-3.0F, -1.7667F, -4.56F, 6.0F, 1.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-3.0F, -0.7667F, -3.56F, 6.0F, 4.0F, 7.0F, 0.0F, false);
		Body.setTextureOffset(27, 5).addBox(-2.0F, -0.7667F, 3.44F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(21, 8).addBox(-2.0F, 3.2333F, 0.44F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(14, 8).addBox(0.0F, -2.7667F, 0.44F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(18, 11).addBox(0.0F, -0.7667F, 4.34F, 0.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 9).addBox(0.0F, -2.7667F, 7.44F, 0.0F, 2.0F, 0.0F, 0.0F, false);
		Body.setTextureOffset(12, 19).addBox(0.0F, -3.7667F, -4.56F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(12, 19).addBox(2.5F, -3.7667F, -3.56F, 0.0F, 2.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(12, 19).addBox(-2.5F, -3.7667F, -3.56F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(3.5F, 8.5F, 1.0F);
		LeftLeg.setTextureOffset(8, 41).addBox(-0.5F, 0.5F, -3.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 36).addBox(-0.5F, -2.5F, -2.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		LeftFoot = new ModelRenderer(this);
		LeftFoot.setRotationPoint(0.5F, 14.5F, -5.0F);
		LeftLeg.addChild(LeftFoot);
		LeftFoot.setTextureOffset(0, 32).addBox(-1.0F, -9.0F, 1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot.setTextureOffset(0, 20).addBox(-1.0F, -8.0F, 1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot.setTextureOffset(0, 20).addBox(0.0F, -8.0F, 1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot.setTextureOffset(1, 21).addBox(0.0F, -9.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		LeftFoot.setTextureOffset(0, 20).addBox(1.0F, -8.0F, 1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-3.5F, 8.5F, 1.0F);
		RightLeg.setTextureOffset(8, 41).addBox(-1.5F, 0.5F, -3.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 36).addBox(-0.5F, -2.5F, -2.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		RightFoot = new ModelRenderer(this);
		RightFoot.setRotationPoint(-0.5F, 14.5F, -5.0F);
		RightLeg.addChild(RightFoot);
		RightFoot.setTextureOffset(0, 20).addBox(1.0F, -8.0F, 1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot.setTextureOffset(0, 20).addBox(-1.0F, -8.0F, 1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot.setTextureOffset(0, 20).addBox(0.0F, -8.0F, 1.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot.setTextureOffset(1, 21).addBox(0.0F, -9.0F, 4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		RightFoot.setTextureOffset(0, 32).addBox(-1.0F, -9.0F, 1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		BottomLeftLeg = new ModelRenderer(this);
		BottomLeftLeg.setRotationPoint(2.0F, 14.0F, 4.0F);
		BottomLeftLeg.setTextureOffset(8, 41).addBox(0.0F, 3.0F, 0.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		BottomLeftLeg.setTextureOffset(0, 36).addBox(0.0F, 0.0F, -2.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		LeftFoot2 = new ModelRenderer(this);
		LeftFoot2.setRotationPoint(1.0F, 17.0F, -5.0F);
		BottomLeftLeg.addChild(LeftFoot2);
		LeftFoot2.setTextureOffset(0, 32).addBox(-1.0F, -9.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot2.setTextureOffset(0, 20).addBox(-1.0F, -8.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot2.setTextureOffset(0, 20).addBox(0.0F, -8.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot2.setTextureOffset(0, 20).addBox(0.0F, -8.0F, 6.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot2.setTextureOffset(0, 20).addBox(1.0F, -8.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		BottomRightLeg = new ModelRenderer(this);
		BottomRightLeg.setRotationPoint(-2.0F, 14.0F, 4.0F);
		BottomRightLeg.setTextureOffset(8, 41).addBox(-2.0F, 3.0F, 0.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		BottomRightLeg.setTextureOffset(0, 36).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		RightFoot2 = new ModelRenderer(this);
		RightFoot2.setRotationPoint(-1.0F, 17.0F, -5.0F);
		BottomRightLeg.addChild(RightFoot2);
		RightFoot2.setTextureOffset(0, 20).addBox(1.0F, -8.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot2.setTextureOffset(0, 20).addBox(-1.0F, -8.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot2.setTextureOffset(0, 20).addBox(0.0F, -8.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot2.setTextureOffset(0, 20).addBox(0.0F, -8.0F, 6.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot2.setTextureOffset(0, 32).addBox(-1.0F, -9.0F, 4.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityDerangedBeast entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.JawTop.rotateAngleX = -limbSwingAmount * 0.43f;
		this.JawBottom.rotateAngleX = limbSwingAmount * 0.43f;
		if (!entity.isAggressive()) {
			this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.BottomLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.BottomRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
					* limbSwingAmount;

	/*		this.LeftFoot.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
					* limbSwingAmount;
			this.RightFoot.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RightFoot2.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftFoot2.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
					* limbSwingAmount;*/
		} else {

			this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.7F * limbSwingAmount;
			this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.7F * limbSwingAmount;
			this.BottomLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.7F * limbSwingAmount;
			this.BottomRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.7F
					* limbSwingAmount;

	/*		this.LeftFoot.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.7F
					* limbSwingAmount;
			this.RightFoot.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F) * 1.7F * limbSwingAmount;
			this.RightFoot2.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F) * 1.7F * limbSwingAmount;
			this.LeftFoot2.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.7F
					* limbSwingAmount;*/
		}	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		BottomLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		BottomRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}