package com.huto.forcesofreality.model.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class ModelWrithingChest extends HumanoidModel<LivingEntity> {
	public ModelPart Body;
	public ModelPart eye1;
	public ModelPart eye2;
	public ModelPart eye3;
	public ModelPart eye4;

	public ModelWrithingChest() {
		super(0.1f, 0, 64, 64);

		Body = new ModelPart(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(19, 58).addBox(2.0F, 1.0F, 2.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(2.0F, 7.0F, 2.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(-7.0F, 1.0F, 2.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(-7.0F, 7.0F, 2.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(1, 57).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(5.0F, -1.0F, 5.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(8.0F, -3.0F, 5.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(5.0F, 9.0F, 5.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(8.0F, 11.0F, 5.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(-9.0F, -1.0F, 5.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(-12.0F, -3.0F, 5.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(-9.0F, 9.0F, 5.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(-12.0F, 11.0F, 5.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(4.0F, 0.0F, 4.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(4.0F, 8.0F, 4.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(-8.0F, 0.0F, 4.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(19, 58).addBox(-8.0F, 8.0F, 4.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, 2.0F, 8.0F, 12.0F, 0.0F, 0.0F, false);

		eye1 = new ModelRenderer(this);
		eye1.setRotationPoint(-11.0F, 15.0F, 3.0F);
		eye1.setTextureOffset(0, 56).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		eye2 = new ModelRenderer(this);
		eye2.setRotationPoint(-11.0F, -4.0F, 3.0F);
		eye2.setTextureOffset(0, 56).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		eye3 = new ModelRenderer(this);
		eye3.setRotationPoint(10.0F, -4.0F, 3.0F);
		eye3.setTextureOffset(0, 56).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		eye4 = new ModelRenderer(this);
		eye4.setRotationPoint(10.0F, 15.0F, 3.0F);
		eye4.setTextureOffset(0, 56).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		this.bipedBody.addChild(Body);
		this.bipedBody.addChild(eye1);
		this.bipedBody.addChild(eye2);
		this.bipedBody.addChild(eye3);
		this.bipedBody.addChild(eye4);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}