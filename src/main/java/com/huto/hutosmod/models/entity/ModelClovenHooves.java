package com.huto.hutosmod.models.entity;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class ModelClovenHooves extends BipedModel<LivingEntity> {

	public ModelClovenHooves() {
		super(0.1f, 0, 64, 64);

		ModelRenderer bone = new ModelRenderer(this);
		bone.setRotationPoint(-1.1F, 24.0F, -3.0F);
		bone.setTextureOffset(52, 60).addBox(2.0F, -13.7F, 5.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(2.9F, 24.5F, 1.7F);
		bone2.setTextureOffset(52, 60).addBox(-0.6F, -14.7F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.9F, 24.5F, 1.7F);
		bone3.setTextureOffset(52, 60).addBox(-0.6F, -14.7F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(2.9F, 24.0F, -3.0F);
		bone4.setTextureOffset(52, 60).addBox(-2.5F, -15.7F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(3.6F, 24.0F, -4.0F);
		bone5.setTextureOffset(52, 60).addBox(-3.5F, -14.7F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-1.1F, 24.0F, -3.0F);
		bone6.setTextureOffset(52, 60).addBox(0.8F, -14.7F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(4.6F, 25.0F, -3.0F);
		bone7.setTextureOffset(52, 60).addBox(-4.3F, -15.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(-1.5F, 25.0F, 2.7F);
		bone8.setTextureOffset(52, 60).addBox(1.6F, -14.5F, -8.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(4.1F, 24.0F, -4.0F);
		bone9.setTextureOffset(52, 60).addBox(-6.5F, -15.7F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone10.setTextureOffset(52, 60).addBox(-3.1F, -14.7F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone11.setTextureOffset(52, 60).addBox(-2.5F, -14.2F, 1.7F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone12.setTextureOffset(52, 60).addBox(-0.7F, -14.7F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone13.setTextureOffset(52, 60).addBox(-0.5F, -14.2F, 1.7F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone14.setTextureOffset(52, 60).addBox(-2.5F, -15.7F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone19.setTextureOffset(52, 60).addBox(-2.7F, -14.7F, -4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone20.setTextureOffset(52, 60).addBox(-1.2F, -14.7F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone21.setTextureOffset(52, 60).addBox(-2.5F, -14.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone22.setTextureOffset(52, 60).addBox(-1.9F, -13.7F, 2.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone15.setTextureOffset(52, 60).addBox(-2.7F, -13.5F, -5.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone16.setTextureOffset(52, 60).addBox(-1.3F, -14.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone17.setTextureOffset(52, 60).addBox(-1.1F, -13.5F, -5.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone18.setTextureOffset(52, 60).addBox(1.7F, -13.5F, -5.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone23.setTextureOffset(52, 60).addBox(1.6F, -14.7F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone24.setTextureOffset(52, 60).addBox(2.1F, -14.7F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		ModelRenderer bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone25.setTextureOffset(52, 60).addBox(1.5F, -14.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone26.setTextureOffset(52, 60).addBox(0.3F, -15.7F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		this.bipedLeftLeg.addChild(bone);
		this.bipedLeftLeg.addChild(bone2);
		this.bipedLeftLeg.addChild(bone3);
		this.bipedLeftLeg.addChild(bone4);
		this.bipedLeftLeg.addChild(bone5);
		this.bipedLeftLeg.addChild(bone6);
		this.bipedLeftLeg.addChild(bone7);
		this.bipedLeftLeg.addChild(bone8);
		this.bipedLeftLeg.addChild(bone18);
		this.bipedLeftLeg.addChild(bone23);
		this.bipedLeftLeg.addChild(bone24);
		this.bipedLeftLeg.addChild(bone26);
		this.bipedLeftLeg.addChild(bone25);

		this.bipedRightLeg.addChild(bone9);
		this.bipedRightLeg.addChild(bone10);
		this.bipedRightLeg.addChild(bone11);
		this.bipedRightLeg.addChild(bone12);
		this.bipedRightLeg.addChild(bone13);
		this.bipedRightLeg.addChild(bone14);
		this.bipedRightLeg.addChild(bone15);
		this.bipedRightLeg.addChild(bone16);
		this.bipedRightLeg.addChild(bone17);
		this.bipedRightLeg.addChild(bone19);
		this.bipedRightLeg.addChild(bone20);
		this.bipedRightLeg.addChild(bone21);
		this.bipedRightLeg.addChild(bone22);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}