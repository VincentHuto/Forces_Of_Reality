package com.huto.forcesofreality.models.entity.lords;


import com.huto.forcesofreality.entities.lords.EntityLordOfTheWild;
import com.huto.forcesofreality.events.ClientEventSubscriber;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;



public class ModelLordOfTheWild extends EntityModel<EntityLordOfTheWild> {
	private final ModelRenderer Head;
	private final ModelRenderer JawTop;
	private final ModelRenderer JawBottom;
	private final ModelRenderer Body;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer LeftFoot;
	private final ModelRenderer LeftLeg2;
	private final ModelRenderer LeftFoot2;
	private final ModelRenderer RightLeg;
	private final ModelRenderer RightFoot;
	private final ModelRenderer RightLeg2;
	private final ModelRenderer RightFoot2;
	private final ModelRenderer Tail;

	public ModelBeastFromBeyond() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 12.0F, -10.0F);
		Head.setTextureOffset(40, 0).addBox(-1.0F, -3.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(0, 22).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(2.0F, -4.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, true);
		Head.setTextureOffset(0, 3).addBox(0.0F, -4.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);

		JawTop = new ModelRenderer(this);
		JawTop.setRotationPoint(0.0F, -0.5F, -4.0F);
		Head.addChild(JawTop);
		JawTop.setTextureOffset(12, 26).addBox(-1.0F, -0.5F, -4.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		JawTop.setTextureOffset(20, 25).addBox(1.0F, 0.5F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		JawTop.setTextureOffset(20, 25).addBox(1.0F, 0.5F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		JawTop.setTextureOffset(20, 25).addBox(-1.0F, 0.5F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		JawTop.setTextureOffset(20, 25).addBox(-1.0F, 0.5F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		JawBottom = new ModelRenderer(this);
		JawBottom.setRotationPoint(0.0F, 1.5F, -4.0F);
		Head.addChild(JawBottom);
		JawBottom.setTextureOffset(26, 17).addBox(-1.0F, -0.5F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		JawBottom.setTextureOffset(20, 25).addBox(1.0F, -1.5F, -3.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		JawBottom.setTextureOffset(20, 25).addBox(1.0F, -1.5F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		JawBottom.setTextureOffset(20, 25).addBox(-1.0F, -1.5F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		JawBottom.setTextureOffset(20, 25).addBox(-1.0F, -1.5F, -3.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 14.4091F, -3.4091F);
		Body.setTextureOffset(19, 11).addBox(-4.0F, -1.4091F, -6.5909F, 8.0F, 5.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(26, 9).addBox(-3.0F, 3.5909F, -6.5909F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(26, 6).addBox(-3.0F, 2.5909F, -5.5909F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(19, 0).addBox(-4.0F, -2.4091F, -6.5909F, 8.0F, 1.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(21, 21).addBox(-2.0F, -0.4091F, 1.4091F, 4.0F, 4.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-3.0F, -1.4091F, -5.5909F, 6.0F, 4.0F, 7.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-3.0F, -1.4091F, 6.4091F, 6.0F, 4.0F, 7.0F, 0.0F, true);
		Body.setTextureOffset(12, 15).addBox(0.0F, -3.4091F, 6.4091F, 0.0F, 2.0F, 7.0F, 0.0F, false);
		Body.setTextureOffset(14, 28).addBox(0.0F, -3.4091F, -1.5909F, 0.0F, 2.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(12, 19).addBox(0.0F, -4.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(12, 19).addBox(2.0F, -4.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(12, 19).addBox(-2.0F, -4.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(12, 19).addBox(-3.0F, -4.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, 0.0F, true);
		Body.setTextureOffset(12, 19).addBox(3.0F, -4.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(0, 25).addBox(0.0F, -2.4091F, 1.4091F, 0.0F, 2.0F, 5.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(3.0F, 15.0F, -6.0F);
		LeftLeg.setTextureOffset(8, 41).addBox(0.0F, 2.0F, 2.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 36).addBox(0.0F, -2.0F, -1.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		LeftFoot = new ModelRenderer(this);
		LeftFoot.setRotationPoint(1.0F, 8.0F, 2.0F);
		LeftLeg.addChild(LeftFoot);
		LeftFoot.setTextureOffset(6, 31).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		LeftFoot.setTextureOffset(0, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot.setTextureOffset(0, 20).addBox(-1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot.setTextureOffset(0, 20).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot.setTextureOffset(0, 20).addBox(1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		LeftLeg2 = new ModelRenderer(this);
		LeftLeg2.setRotationPoint(3.0F, 15.0F, 7.0F);
		LeftLeg2.setTextureOffset(8, 41).addBox(0.0F, 2.0F, 2.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		LeftLeg2.setTextureOffset(0, 36).addBox(0.0F, -2.0F, -1.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		LeftFoot2 = new ModelRenderer(this);
		LeftFoot2.setRotationPoint(1.0F, 8.0F, 2.0F);
		LeftLeg2.addChild(LeftFoot2);
		LeftFoot2.setTextureOffset(6, 31).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		LeftFoot2.setTextureOffset(0, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot2.setTextureOffset(0, 20).addBox(-1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot2.setTextureOffset(0, 20).addBox(1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot2.setTextureOffset(0, 20).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-3.0F, 15.0F, -6.0F);
		RightLeg.setTextureOffset(8, 41).addBox(-2.0F, 2.0F, 2.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 36).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		RightFoot = new ModelRenderer(this);
		RightFoot.setRotationPoint(-1.0F, 8.0F, 2.0F);
		RightLeg.addChild(RightFoot);
		RightFoot.setTextureOffset(0, 20).addBox(1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot.setTextureOffset(0, 20).addBox(-1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot.setTextureOffset(0, 20).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot.setTextureOffset(6, 31).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		RightFoot.setTextureOffset(0, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		RightLeg2 = new ModelRenderer(this);
		RightLeg2.setRotationPoint(-3.0F, 15.0F, 7.0F);
		RightLeg2.setTextureOffset(8, 41).addBox(-2.0F, 2.0F, 2.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		RightLeg2.setTextureOffset(0, 36).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		RightFoot2 = new ModelRenderer(this);
		RightFoot2.setRotationPoint(-1.0F, 8.0F, 2.0F);
		RightLeg2.addChild(RightFoot2);
		RightFoot2.setTextureOffset(6, 31).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		RightFoot2.setTextureOffset(0, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot2.setTextureOffset(0, 20).addBox(-1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot2.setTextureOffset(0, 20).addBox(1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot2.setTextureOffset(0, 20).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(0.0F, 14.0F, 10.0F);
		Tail.setTextureOffset(37, 34).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		Tail.setTextureOffset(37, 34).addBox(-0.5F, 0.0F, 4.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityBeastFromBeyond entity, float limbSwing, float limbSwingAmount,
			float ageInTicks, float netHeadYaw, float headPitch) {
		

		
		this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.Tail.rotateAngleX = headPitch * ((float) Math.PI / 180F) / 2;
		this.Tail.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) / 2;
		this.Tail.rotateAngleZ = headPitch * ((float) Math.PI / 180F) / 2;
		this.JawTop.rotateAngleX = -limbSwingAmount * 0.43f;	
		this.JawBottom.rotateAngleX = limbSwingAmount * 0.43f;
		if (!entity.isAggressive()) {
			this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RightLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
					* limbSwingAmount;

			this.LeftFoot.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
					* limbSwingAmount;
			this.RightFoot.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.RightFoot2.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.LeftFoot2.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
					* limbSwingAmount;
		} else {

			this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.7F * limbSwingAmount;
			this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.7F * limbSwingAmount;
			this.LeftLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.7F * limbSwingAmount;
			this.RightLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.7F
					* limbSwingAmount;

			this.LeftFoot.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.7F
					* limbSwingAmount;
			this.RightFoot.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F) * 1.7F * limbSwingAmount;
			this.RightFoot2.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F) * 1.7F * limbSwingAmount;
			this.LeftFoot2.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.7F
					* limbSwingAmount;
		}
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
		Tail.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}