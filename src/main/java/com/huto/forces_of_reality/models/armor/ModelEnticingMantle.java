package com.huto.forces_of_reality.models.armor;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class ModelEnticingMantle extends BipedModel<LivingEntity> {

	public ModelEnticingMantle() {
		super(1.0f, 0, 64, 64);
		ModelRenderer bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(1.0F, 24.0F, 4.0F);
		bone18.setTextureOffset(11, 39).addBox(3.0F, -25.0F, -2.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		ModelRenderer bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(-8.0F, 24.0F, 4.0F);
		bone19.setTextureOffset(11, 35).addBox(3.0F, -25.0F, -2.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		ModelRenderer bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(1.0F, 24.0F, 2.0F);
		bone16.setTextureOffset(30, 38).addBox(3.0F, -25.0F, -6.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		ModelRenderer bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(-8.0F, 24.0F, 2.0F);
		bone17.setTextureOffset(30, 38).addBox(3.0F, -25.0F, -6.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		ModelRenderer bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 24.0F, 4.0F);
		bone15.setTextureOffset(0, 58).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 4.0F, 2.0F, 0.0F, false);

		ModelRenderer bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 31.0F, 4.0F);
		bone14.setTextureOffset(21, 57).addBox(-4.0F, -27.0F, -2.0F, 8.0F, 6.0F, 1.0F, 0.0F, false);

		ModelRenderer bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 37.0F, 4.1F);
		bone13.setTextureOffset(31, 60).addBox(-4.0F, -27.0F, -2.0F, 8.0F, 4.0F, 0.0F, 0.0F, false);

		ModelRenderer bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 13.5F, 3.1F);
		setRotationAngle(bone, 0.2618F, 0.0F, 0.0F);
		bone.setTextureOffset(17, 35).addBox(-2.0F, -4.5518F, -0.1932F, 4.0F, 11.0F, 0.0F, 0.0F, false);

		ModelRenderer bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 13.5F, 3.2F);
		setRotationAngle(bone3, 0.2618F, 0.0F, 0.0F);
		bone3.setTextureOffset(52, 32).addBox(-3.0F, -4.5F, 0.0F, 6.0F, 9.0F, 0.0F, 0.0F, false);

		ModelRenderer bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 13.5F, 3.5F);
		setRotationAngle(bone2, 0.2618F, 0.0F, 0.0F);
		bone2.setTextureOffset(48, 47).addBox(-4.0F, -4.5F, 0.0F, 8.0F, 7.0F, 0.0F, 0.0F, false);

		ModelRenderer 	bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(10.0F, 24.0F, 4.0F);
		bone11.setTextureOffset(56, 60).addBox(-5.0F, -24.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		ModelRenderer bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-2.0F, 24.0F, -2.0F);
		bone12.setTextureOffset(56, 60).addBox(-5.0F, -24.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		ModelRenderer bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(10.0F, 24.0F, -2.0F);
		bone5.setTextureOffset(56, 60).addBox(-5.0F, -24.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		ModelRenderer bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-2.0F, 24.0F, 4.0F);
		bone10.setTextureOffset(56, 60).addBox(-5.0F, -24.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		ModelRenderer bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(10.0F, 22.0F, -1.0F);
		bone4.setTextureOffset(56, 60).addBox(-5.0F, -24.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		ModelRenderer bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(-2.0F, 22.0F, -1.0F);
		bone20.setTextureOffset(56, 60).addBox(-5.0F, -24.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		ModelRenderer bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 29.0F, -2.2F);
		bone9.setTextureOffset(30, 33).addBox(-4.0F, -24.0F, 0.0F, 8.0F, 4.0F, 0.0F, 0.0F, false);

		ModelRenderer bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 26.0F, -2.0F);
		bone8.setTextureOffset(0, 51).addBox(-5.0F, -24.0F, -1.0F, 10.0F, 3.0F, 1.0F, 0.0F, false);

		ModelRenderer bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-2.0F, 22.0F, 3.0F);
		bone7.setTextureOffset(56, 60).addBox(-5.0F, -24.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		ModelRenderer Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(27, 48).addBox(-5.0F, 0.0F, -4.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);

		ModelRenderer bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(10.0F, 22.0F, 3.0F);
		bone6.setTextureOffset(56, 60).addBox(-5.0F, -24.0F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		this.bipedBody.addChild(Body);
		this.bipedBody.addChild(bone);
		this.bipedBody.addChild(bone2);
		this.bipedBody.addChild(bone3);
		this.bipedBody.addChild(bone4);
		this.bipedBody.addChild(bone5);
		this.bipedBody.addChild(bone6);
		this.bipedBody.addChild(bone7);
		this.bipedBody.addChild(bone8);
		this.bipedBody.addChild(bone9);
		this.bipedBody.addChild(bone10);
		this.bipedBody.addChild(bone11);
		this.bipedBody.addChild(bone12);
		this.bipedBody.addChild(bone13);
		this.bipedBody.addChild(bone14);
		this.bipedBody.addChild(bone15);
		this.bipedBody.addChild(bone16);
		this.bipedBody.addChild(bone17);
		this.bipedBody.addChild(bone18);
		this.bipedBody.addChild(bone19);
		this.bipedBody.addChild(bone20);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}