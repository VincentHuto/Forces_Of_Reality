package com.huto.forcesofreality.models.armor;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class ModelBackWings extends BipedModel<LivingEntity> {
	public ModelRenderer LeftWing;
	public ModelRenderer Limb1;
	public ModelRenderer LeftWing2;
	public ModelRenderer Limb8;
	public ModelRenderer RightWing;
	public ModelRenderer Limb2;
	public ModelRenderer RightWing2;
	public ModelRenderer Limb5;
	public ModelRenderer LeftWing3;
	public ModelRenderer Limb9;
	public ModelRenderer Limb10;
	public ModelRenderer RightWing3;
	public ModelRenderer Limb11;
	public ModelRenderer Body;
	public ModelRenderer LeftArm;
	public ModelRenderer RightArm;
	public ModelBackWings() {
		super(1.0f, 0, 64, 64);
		textureWidth = 64;
		textureHeight = 64;


		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(4.0F, 2.0F, 1.5F);
		setRotationAngle(LeftWing, 0.2182F, -0.1309F, -2.3562F);
		LeftWing.setTextureOffset(60, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		LeftWing.setTextureOffset(0, 42).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb1 = new ModelRenderer(this);
		Limb1.setRotationPoint(-3.0F, 12.5F, -0.5F);
		LeftWing.addChild(Limb1);
		setRotationAngle(Limb1, 0.0F, 0.0F, 0.5672F);
		Limb1.setTextureOffset(60, 53).addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb1.setTextureOffset(40, 52).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb1.setTextureOffset(0, 42).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		LeftWing2 = new ModelRenderer(this);
		LeftWing2.setRotationPoint(4.0F, 2.0F, 1.5F);
		setRotationAngle(LeftWing2, 0.3054F, 0.48F, -2.8362F);
		LeftWing2.setTextureOffset(60, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		LeftWing2.setTextureOffset(0, 42).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb8 = new ModelRenderer(this);
		Limb8.setRotationPoint(-3.0F, 12.5F, -0.5F);
		LeftWing2.addChild(Limb8);
		setRotationAngle(Limb8, 0.0F, 0.0F, 0.5672F);
		Limb8.setTextureOffset(60, 53).addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb8.setTextureOffset(40, 52).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb8.setTextureOffset(0, 42).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-4.0F, 2.0F, 1.5F);
		setRotationAngle(RightWing, 0.3054F, 0.1309F, 2.3562F);
		RightWing.setTextureOffset(60, 53).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing.setTextureOffset(18, 54).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb2 = new ModelRenderer(this);
		Limb2.setRotationPoint(4.1684F, 12.096F, 0.5702F);
		RightWing.addChild(Limb2);
		setRotationAngle(Limb2, 0.0F, 0.0F, -0.5672F);
		Limb2.setTextureOffset(60, 53).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb2.setTextureOffset(40, 52).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb2.setTextureOffset(18, 54).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		RightWing2 = new ModelRenderer(this);
		RightWing2.setRotationPoint(-4.0F, 2.0F, 1.5F);
		setRotationAngle(RightWing2, 0.2182F, -0.48F, 2.8362F);
		RightWing2.setTextureOffset(60, 53).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing2.setTextureOffset(18, 54).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb5 = new ModelRenderer(this);
		Limb5.setRotationPoint(4.1684F, 12.096F, 0.5702F);
		RightWing2.addChild(Limb5);
		setRotationAngle(Limb5, 0.0F, 0.0F, -0.5672F);
		Limb5.setTextureOffset(60, 53).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb5.setTextureOffset(40, 52).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb5.setTextureOffset(18, 54).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		LeftWing3 = new ModelRenderer(this);
		LeftWing3.setRotationPoint(4.0F, 2.0F, 1.5F);
		setRotationAngle(LeftWing3, 0.2181F, 0.6982F, 2.8798F);
		LeftWing3.setTextureOffset(60, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		LeftWing3.setTextureOffset(0, 42).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb9 = new ModelRenderer(this);
		Limb9.setRotationPoint(0.0F, 3.0F, 0.0F);
		LeftWing3.addChild(Limb9);
		setRotationAngle(Limb9, 0.0F, 0.0F, -1.6581F);
		

		Limb10 = new ModelRenderer(this);
		Limb10.setRotationPoint(-3.0F, 12.5F, -0.5F);
		LeftWing3.addChild(Limb10);
		setRotationAngle(Limb10, 0.0F, 0.0F, 0.5672F);
		Limb10.setTextureOffset(60, 53).addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb10.setTextureOffset(40, 52).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb10.setTextureOffset(0, 42).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		RightWing3 = new ModelRenderer(this);
		RightWing3.setRotationPoint(-4.0F, 2.0F, 1.5F);
		setRotationAngle(RightWing3, 0.2181F, -0.6981F, -2.8798F);
		RightWing3.setTextureOffset(60, 53).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing3.setTextureOffset(18, 54).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb11 = new ModelRenderer(this);
		Limb11.setRotationPoint(4.1684F, 12.096F, 0.5702F);
		RightWing3.addChild(Limb11);
		setRotationAngle(Limb11, 0.0F, 0.0F, -0.5672F);
		Limb11.setTextureOffset(60, 53).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb11.setTextureOffset(40, 52).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb11.setTextureOffset(18, 54).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.setTextureOffset(29, 40).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 8.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(33, 42).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 0.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(29, 40).addBox(-4.0F, -24.0F, 2.0F, 7.0F, 8.0F, 1.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, -6.0F, -2.0F);
		LeftArm.setTextureOffset(30, 42).addBox(-6.0F, 4.0F, -1.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(30, 42).addBox(-1.0F, 5.0F, -1.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);
		LeftArm.setTextureOffset(30, 42).addBox(-6.0F, 4.0F, -1.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
		LeftArm.setTextureOffset(30, 42).addBox(-6.0F, 5.0F, 4.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-3.0F, -6.0F, -2.0F);
		RightArm.setTextureOffset(30, 42).addBox(-1.0F, 4.0F, -1.0F, 5.0F, 1.0F, 6.0F, 0.0F, false);
		RightArm.setTextureOffset(30, 42).addBox(-1.0F, 4.0F, -1.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(30, 42).addBox(-2.0F, 5.0F, -1.0F, 1.0F, 3.0F, 6.0F, 0.0F, false);
		RightArm.setTextureOffset(30, 42).addBox(-1.0F, 4.0F, 4.0F, 5.0F, 4.0F, 1.0F, 0.0F, false);

		this.bipedBody.addChild(Body);
		this.bipedBody.addChild(LeftWing);
		this.bipedBody.addChild(LeftWing2);
		this.bipedBody.addChild(RightWing);
		this.bipedBody.addChild(RightWing2);
		this.bipedBody.addChild(LeftWing3);
		this.bipedBody.addChild(Limb9);
		this.bipedBody.addChild(RightWing3);
		this.bipedLeftArm.addChild(LeftArm);
		this.bipedRightArm.addChild(RightArm);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}