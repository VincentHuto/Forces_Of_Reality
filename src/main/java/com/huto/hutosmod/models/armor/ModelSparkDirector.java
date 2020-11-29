package com.huto.hutosmod.models.armor;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class ModelSparkDirector extends BipedModel<LivingEntity> {

	public ModelSparkDirector() {
		super(1.0f, 0, 64, 64);
		ModelRenderer Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		ModelRenderer sparkJar = new ModelRenderer(this);
		sparkJar.setRotationPoint(-1.0F, 24.5F, 7.0F);
		Body.addChild(sparkJar);
		sparkJar.setTextureOffset(16, 16).addBox(4.0F, -23.0F, 4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(2.5F, -23.0F, 4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(2.5F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(0.5F, -23.0F, 4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(0.5F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-1.5F, -23.0F, 4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-1.5F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -23.0F, 4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -23.0F, 2.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(4.0F, -23.0F, 2.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -23.0F, -1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(4.0F, -23.0F, -1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -23.0F, 0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(4.0F, -23.0F, 0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(4.0F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -17.0F, -3.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -16.0F, -5.0F, 8.0F, 1.0F, 3.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -23.0F, -5.0F, 8.0F, 7.0F, 2.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-6.0F, -23.0F, -5.0F, 3.0F, 7.0F, 5.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(8.0F, -23.0F, -5.0F, 1.0F, 7.0F, 3.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-4.0F, -24.0F, -10.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(5.0F, -24.0F, -10.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -23.0F, -10.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -18.0F, -10.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-2.0F, -21.0F, -10.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(3.0F, -21.0F, -10.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-7.0F, -23.0F, -5.0F, 1.0F, 7.0F, 3.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(5.0F, -23.0F, -5.0F, 3.0F, 7.0F, 5.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(5.0F, -24.0F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-6.0F, -24.0F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-6.0F, -16.0F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(5.0F, -16.0F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -15.0F, -5.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -14.0F, -5.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -13.0F, -5.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-3.0F, -24.0F, -5.0F, 8.0F, 1.0F, 3.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-2.0F, -18.0F, -2.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-1.0F, -25.0F, -1.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(0.0F, -26.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(0.0F, -27.0F, 1.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-1.0F, -29.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(0.0F, -30.0F, 1.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(2.0F, -29.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		sparkJar.setTextureOffset(16, 16).addBox(-2.0F, -24.0F, -2.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);

		ModelRenderer vent1 = new ModelRenderer(this);
		vent1.setRotationPoint(0.0F, 7.0F, -2.0F);
		sparkJar.addChild(vent1);
		vent1.setTextureOffset(16, 16).addBox(1.0F, -23.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		vent1.setTextureOffset(16, 16).addBox(2.0F, -23.0F, 5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		vent1.setTextureOffset(16, 16).addBox(2.0F, -22.0F, 3.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);
		vent1.setTextureOffset(16, 16).addBox(4.0F, -23.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		vent1.setTextureOffset(16, 16).addBox(2.0F, -23.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer vent2 = new ModelRenderer(this);
		vent2.setRotationPoint(-4.0F, 7.0F, -2.0F);
		sparkJar.addChild(vent2);
		vent2.setTextureOffset(16, 16).addBox(1.0F, -23.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		vent2.setTextureOffset(16, 16).addBox(2.0F, -23.0F, 5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		vent2.setTextureOffset(16, 16).addBox(2.0F, -22.0F, 3.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);
		vent2.setTextureOffset(16, 16).addBox(4.0F, -23.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		vent2.setTextureOffset(16, 16).addBox(2.0F, -23.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		
		
		this.bipedBody.addChild(Body);
		this.bipedBody.addChild(sparkJar);
		this.bipedBody.addChild(vent1);
		this.bipedBody.addChild(vent2);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}