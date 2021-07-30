package com.huto.forcesofreality.model.entity.summon;

import com.huto.forcesofreality.entity.summon.EntitySummonedBeast;
import com.hutoslib.client.ClientUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.math.MathHelper;

public class ModelSummonedBeast extends EntityModel<EntitySummonedBeast> {
	private final ModelPart Head;
	private final ModelPart JawTop;
	private final ModelPart JawBottom;
	private final ModelPart Body;
	private final ModelPart Tail1;
	private final ModelPart Tail2;
	private final ModelPart Tail3;
	private final ModelPart Tail4;
	private final ModelPart LeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart RightLeg;
	private final ModelPart RightFoot;

	public ModelSummonedBeast() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 12.0F, -10.0F);
		Head.setTextureOffset(40, 0).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(0, 22).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(0, 3).addBox(0.0F, -2.0F, -3.0F, 0.0F, 1.0F, 3.0F, 0.0F, false);

		JawTop = new ModelRenderer(this);
		JawTop.setRotationPoint(0.0F, -0.5F, -4.0F);
		Head.addChild(JawTop);
		JawTop.setTextureOffset(12, 26).addBox(-1.0F, 1.5F, -4.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		JawTop.setTextureOffset(20, 25).addBox(1.0F, 2.5F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		JawTop.setTextureOffset(20, 25).addBox(1.0F, 2.5F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		JawBottom = new ModelRenderer(this);
		JawBottom.setRotationPoint(0.0F, 1.5F, -4.0F);
		Head.addChild(JawBottom);
		JawBottom.setTextureOffset(26, 17).addBox(-1.0F, 1.5F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
		JawBottom.setTextureOffset(20, 25).addBox(-1.0F, 0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		JawBottom.setTextureOffset(20, 25).addBox(-1.0F, 0.5F, -3.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 14.4091F, -3.4091F);
		Body.setTextureOffset(19, 11).addBox(-4.0F, 0.5909F, -6.5909F, 8.0F, 5.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(26, 9).addBox(-3.0F, 5.5909F, -6.5909F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(26, 6).addBox(-3.0F, 4.5909F, -5.5909F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(19, 0).addBox(-3.0F, -0.4091F, -6.5909F, 6.0F, 1.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-3.0F, 0.5909F, -5.5909F, 6.0F, 4.0F, 7.0F, 0.0F, false);
		Body.setTextureOffset(14, 28).addBox(0.0F, -1.4091F, -1.5909F, 0.0F, 2.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(12, 19).addBox(0.0F, -2.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(12, 19).addBox(2.0F, -2.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(12, 19).addBox(-2.0F, -2.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(12, 19).addBox(-3.0F, -2.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, 0.0F, true);
		Body.setTextureOffset(12, 19).addBox(3.0F, -2.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, 0.0F, false);

		Tail1 = new ModelRenderer(this);
		Tail1.setRotationPoint(0.0F, 3.8409F, 1.4091F);
		Body.addChild(Tail1);
		Tail1.setTextureOffset(21, 21).addBox(-2.0F, -1.25F, 0.0F, 4.0F, 3.0F, 5.0F, 0.0F, false);
		Tail1.setTextureOffset(0, 25).addBox(0.0F, -3.25F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F, false);

		Tail2 = new ModelRenderer(this);
		Tail2.setRotationPoint(0.0F, 4.8409F, 6.4091F);
		Body.addChild(Tail2);
		Tail2.setTextureOffset(21, 21).addBox(-1.5F, -0.25F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		Tail2.setTextureOffset(0, 25).addBox(0.0F, -2.25F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F, false);

		Tail3 = new ModelRenderer(this);
		Tail3.setRotationPoint(0.0F, 7.5909F, 11.4091F);
		Body.addChild(Tail3);
		Tail3.setTextureOffset(21, 21).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		Tail3.setTextureOffset(0, 25).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F, false);

		Tail4 = new ModelRenderer(this);
		Tail4.setRotationPoint(0.0F, 8.3409F, 16.4091F);
		Body.addChild(Tail4);
		Tail4.setTextureOffset(21, 21).addBox(-0.5F, 0.25F, 0.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Tail4.setTextureOffset(15, 20).addBox(0.0F, -1.75F, -1.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(3.0F, 15.0F, -6.0F);
		LeftLeg.setTextureOffset(8, 41).addBox(0.0F, 2.0F, 2.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		LeftLeg.setTextureOffset(0, 36).addBox(0.0F, -1.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		LeftFoot = new ModelRenderer(this);
		LeftFoot.setRotationPoint(1.0F, 8.0F, 2.0F);
		LeftLeg.addChild(LeftFoot);
		LeftFoot.setTextureOffset(6, 31).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		LeftFoot.setTextureOffset(0, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot.setTextureOffset(0, 20).addBox(-1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot.setTextureOffset(0, 20).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		LeftFoot.setTextureOffset(0, 20).addBox(1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-3.0F, 15.0F, -6.0F);
		RightLeg.setTextureOffset(8, 41).addBox(-2.0F, 2.0F, 2.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 36).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		RightFoot = new ModelRenderer(this);
		RightFoot.setRotationPoint(-1.0F, 8.0F, 2.0F);
		RightLeg.addChild(RightFoot);
		RightFoot.setTextureOffset(0, 20).addBox(1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot.setTextureOffset(0, 20).addBox(-1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot.setTextureOffset(0, 20).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		RightFoot.setTextureOffset(6, 31).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		RightFoot.setTextureOffset(0, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntitySummonedBeast entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		
		float parTicks = ClientUtils.getPartialTicks();

		
		this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.JawTop.rotateAngleX = -limbSwingAmount * 0.43f;
		this.JawBottom.rotateAngleX = limbSwingAmount * 0.43f;

		this.Tail1.rotateAngleY = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0825);
		this.Tail2.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0625);
		this.Tail3.rotateAngleY = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0425);
		this.Tail4.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.1225);

		if (!entity.isAggressive()) {
			this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
			this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

			this.LeftFoot.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
					* limbSwingAmount;
			this.RightFoot.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		} else {

			this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.7F * limbSwingAmount;
			this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.7F * limbSwingAmount;

			this.LeftFoot.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.7F
					* limbSwingAmount;
			this.RightFoot.rotateAngleX = -MathHelper.cos(limbSwing * 0.6662F) * 1.7F * limbSwingAmount;
		}
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}