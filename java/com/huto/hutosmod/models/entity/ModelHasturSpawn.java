package com.huto.hutosmod.models.entity;

import com.huto.hutosmod.entities.EntityHasturSpawn;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelHasturSpawn extends EntityModel<EntityHasturSpawn> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer LeftShould;
	private final ModelRenderer RightShould;
	private final ModelRenderer FrontShould;
	private final ModelRenderer BackShould;
	private final ModelRenderer FrontTent;
	private final ModelRenderer BackTent;
	private final ModelRenderer RightTent;
	private final ModelRenderer LeftTent;
	private final ModelRenderer Waist;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;

	public ModelHasturSpawn() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 7.0F, 0.0F);
		Head.setTextureOffset(12, 12).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(6, 16).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(0, 11).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 9.5F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-3.0F, -2.5F, -3.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);

		LeftShould = new ModelRenderer(this);
		LeftShould.setRotationPoint(4.0F, 1.5F, 1.0F);
		Body.addChild(LeftShould);
		LeftShould.setTextureOffset(0, 16).addBox(-1.0F, -3.0F, -3.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		RightShould = new ModelRenderer(this);
		RightShould.setRotationPoint(-5.0F, 1.5F, 1.0F);
		Body.addChild(RightShould);
		RightShould.setTextureOffset(10, 17).addBox(1.0F, -3.0F, -3.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);

		FrontShould = new ModelRenderer(this);
		FrontShould.setRotationPoint(1.0F, 2.5F, -6.0F);
		Body.addChild(FrontShould);
		FrontShould.setTextureOffset(16, 17).addBox(-3.0F, -4.0F, 2.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);

		BackShould = new ModelRenderer(this);
		BackShould.setRotationPoint(1.0F, 2.5F, 2.0F);
		Body.addChild(BackShould);
		BackShould.setTextureOffset(20, 21).addBox(-3.0F, -4.0F, 1.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);

		FrontTent = new ModelRenderer(this);
		FrontTent.setRotationPoint(0.0F, 11.0F, -4.5F);
		FrontTent.setTextureOffset(26, 17).addBox(-1.0F, 6.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		FrontTent.setTextureOffset(12, 28).addBox(-2.0F, 4.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		FrontTent.setTextureOffset(27, 27).addBox(-1.0F, 2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		FrontTent.setTextureOffset(22, 28).addBox(-2.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		FrontTent.setTextureOffset(22, 25).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		BackTent = new ModelRenderer(this);
		BackTent.setRotationPoint(0.0F, 11.0F, 4.5F);
		BackTent.setTextureOffset(25, 0).addBox(0.0F, 6.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		BackTent.setTextureOffset(0, 16).addBox(1.0F, 4.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		BackTent.setTextureOffset(12, 12).addBox(0.0F, 2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		BackTent.setTextureOffset(0, 11).addBox(1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		BackTent.setTextureOffset(24, 12).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		RightTent = new ModelRenderer(this);
		RightTent.setRotationPoint(-4.5F, 11.0F, 0.0F);
		RightTent.setTextureOffset(0, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		RightTent.setTextureOffset(29, 14).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightTent.setTextureOffset(28, 8).addBox(-0.5F, 2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightTent.setTextureOffset(28, 5).addBox(-0.5F, 4.0F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightTent.setTextureOffset(28, 2).addBox(-0.5F, 6.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		LeftTent = new ModelRenderer(this);
		LeftTent.setRotationPoint(4.5F, 11.0F, 0.0F);
		LeftTent.setTextureOffset(12, 24).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		LeftTent.setTextureOffset(4, 30).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftTent.setTextureOffset(5, 29).addBox(-0.5F, 2.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftTent.setTextureOffset(29, 24).addBox(-0.5F, 4.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftTent.setTextureOffset(29, 19).addBox(-0.5F, 6.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		Waist = new ModelRenderer(this);
		Waist.setRotationPoint(0.0F, 11.5F, 0.5F);
		Waist.setTextureOffset(18, 0).addBox(-1.0F, 0.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.5F, 2.5F, -1.0F);
		Waist.addChild(RightLeg);
		RightLeg.setTextureOffset(8, 30).addBox(-0.5F, 7.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(18, 25).addBox(-0.5F, 3.0F, 0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(0, 23).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.5F, 2.5F, -1.0F);
		Waist.addChild(LeftLeg);
		LeftLeg.setTextureOffset(6, 23).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		LeftLeg.setTextureOffset(15, 30).addBox(-0.5F, 7.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(24, 6).addBox(-0.5F, 3.0F, 0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityHasturSpawn entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

		this.Body.rotateAngleX = (float) (Math.sin(ageInTicks) * 0.0225);
		this.Body.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0225);

		if (entity.isAggressive()) {
			this.Head.rotateAngleY = ageInTicks * 0.5f;

		} else {
			this.Head.rotateAngleY = ageInTicks * 0.33f;

		}

		this.BackShould.rotateAngleX = (float) (Math.sin(ageInTicks) * 0.1625);
		this.FrontShould.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.1625);
		this.LeftShould.rotateAngleX = (float) (Math.sin(ageInTicks) * 0.1625);
		this.RightShould.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.1625);

		this.FrontTent.rotateAngleX = (float) (Math.sin(ageInTicks) * 0.1625);
		this.BackTent.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.1625);
		this.RightTent.rotateAngleX = (float) (Math.sin(ageInTicks) * 0.1625);
		this.LeftTent.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.1625);

		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 1.6662F) * .5F * limbSwingAmount;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 1.6662F + (float) Math.PI) * .5F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		FrontTent.render(matrixStack, buffer, packedLight, packedOverlay);
		BackTent.render(matrixStack, buffer, packedLight, packedOverlay);
		RightTent.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftTent.render(matrixStack, buffer, packedLight, packedOverlay);
		Waist.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}