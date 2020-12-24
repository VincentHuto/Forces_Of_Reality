package com.huto.forces_of_reality.models.armor;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class ModelWrithingHelmet extends BipedModel<LivingEntity> {

	public ModelRenderer bone2;

	public ModelWrithingHelmet() {
		super(0.1f, 0, 64, 64);

		ModelRenderer Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		ModelRenderer bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone3.setTextureOffset(32, 0).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

		ModelRenderer bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(19, 58).addBox(-3.0F, -33.0F, -1.0F, 6.0F, 3.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(19, 58).addBox(-1.0F, -33.0F, 1.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(19, 58).addBox(-5.0F, -32.6F, 0.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(19, 58).addBox(3.0F, -32.6F, 0.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(19, 58).addBox(3.0F, -27.6F, 0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(19, 58).addBox(-5.0F, -27.6F, 0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(19, 58).addBox(-1.0F, -32.3F, 5.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(19, 58).addBox(-0.5F, -25.3F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -8.0F, -3.0F);
		bone2.setTextureOffset(0, 56).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		this.bipedHead.addChild(Head);
		this.bipedHead.addChild(bone);
		this.bipedHead.addChild(bone2);
		this.bipedHead.addChild(bone3);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}