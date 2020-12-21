package com.huto.forces_of_reality.models.armor;

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
		sparkJar.setRotationPoint(-1.0F, 24.5F, 7.0F);
		Body.addChild(sparkJar);
		sparkJar.setTextureOffset(0, 35).addBox(2.5F, -23.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(2.5F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(0.5F, -23.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(0.5F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(-1.5F, -23.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(-1.5F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(-3.0F, -23.0F, 2.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(4.0F, -23.0F, 2.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(-3.0F, -23.0F, -1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(4.0F, -23.0F, -1.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(-3.0F, -23.0F, 0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(4.0F, -23.0F, 0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(-3.0F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(4.0F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(34, 35).addBox(-3.0F, -17.0F, -3.0F, 8.0F, 1.0F, 6.0F, 0.0F, false);
		sparkJar.setTextureOffset(34, 35).addBox(-3.0F, -16.0F, -5.0F, 8.0F, 1.0F, 3.0F, 0.0F, false);
		sparkJar.setTextureOffset(32, 35).addBox(-3.0F, -23.0F, -5.0F, 8.0F, 7.0F, 2.0F, 0.0F, false);
		sparkJar.setTextureOffset(34, 35).addBox(-6.0F, -23.0F, -5.0F, 3.0F, 7.0F, 5.0F, 0.0F, false);
		sparkJar.setTextureOffset(37, 34).addBox(8.0F, -23.0F, -5.0F, 1.0F, 7.0F, 3.0F, 0.0F, false);
		sparkJar.setTextureOffset(31, 48).addBox(-4.0F, -24.0F, -10.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(31, 48).addBox(5.0F, -24.0F, -10.0F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(25, 50).addBox(-3.0F, -23.0F, -10.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(27, 49).addBox(-3.0F, -17.0F, -10.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(31, 48).addBox(-2.0F, -21.0F, -10.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(31, 48).addBox(-1.0F, -22.0F, -10.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(18, 62).addBox(0.0F, -20.0F, -11.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(18, 62).addBox(-3.0F, -18.0F, -11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(18, 62).addBox(-3.0F, -22.0F, -11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(18, 62).addBox(4.0F, -18.0F, -11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(18, 62).addBox(4.0F, -22.0F, -11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(31, 48).addBox(3.0F, -21.0F, -10.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(31, 48).addBox(-1.0F, -18.0F, -10.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(34, 35).addBox(-7.0F, -23.0F, -5.0F, 1.0F, 7.0F, 3.0F, 0.0F, false);
		sparkJar.setTextureOffset(37, 34).addBox(5.0F, -23.0F, -5.0F, 3.0F, 7.0F, 5.0F, 0.0F, false);
		sparkJar.setTextureOffset(32, 35).addBox(5.0F, -24.0F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		sparkJar.setTextureOffset(32, 35).addBox(-6.0F, -24.0F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		sparkJar.setTextureOffset(32, 35).addBox(-6.0F, -16.0F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		sparkJar.setTextureOffset(37, 34).addBox(5.0F, -16.0F, -5.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		sparkJar.setTextureOffset(34, 35).addBox(-3.0F, -15.0F, -5.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
		sparkJar.setTextureOffset(34, 35).addBox(-3.0F, -14.0F, -5.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(34, 35).addBox(-3.0F, -13.0F, -5.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(34, 35).addBox(-3.0F, -24.0F, -5.0F, 8.0F, 1.0F, 3.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(-2.0F, -18.0F, -2.0F, 6.0F, 1.0F, 5.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(-1.0F, -25.0F, -1.0F, 4.0F, 1.0F, 3.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(0.0F, -26.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(0.0F, -27.0F, 0.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(-1.0F, -29.0F, 0.5F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(0.0F, -30.0F, 0.5F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(2.0F, -29.0F, 0.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		sparkJar.setTextureOffset(0, 35).addBox(-2.0F, -24.0F, -2.0F, 6.0F, 1.0F, 5.0F, 0.0F, false);
		ModelRenderer vent1 = new ModelRenderer(this);
		vent1.setRotationPoint(-1.0F, 31.5F, 5.0F);
		Body.addChild(vent1);
		vent1.setTextureOffset(0, 35).addBox(1.0F, -23.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		vent1.setTextureOffset(0, 35).addBox(2.0F, -23.0F, 5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		vent1.setTextureOffset(27, 61).addBox(2.0F, -22.0F, 3.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);
		vent1.setTextureOffset(0, 35).addBox(4.0F, -23.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		vent1.setTextureOffset(0, 35).addBox(2.0F, -23.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		ModelRenderer vent2 = new ModelRenderer(this);
		vent2.setRotationPoint(-5.0F, 31.5F, 5.0F);
		Body.addChild(vent2);
		vent2.setTextureOffset(0, 35).addBox(1.0F, -23.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		vent2.setTextureOffset(0, 35).addBox(2.0F, -23.0F, 5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		vent2.setTextureOffset(27, 61).addBox(2.0F, -22.0F, 3.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);
		vent2.setTextureOffset(0, 35).addBox(4.0F, -23.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		vent2.setTextureOffset(0, 35).addBox(2.0F, -23.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		this.bipedBody.addChild(Body);
		this.bipedBody.addChild(sparkJar);
		this.bipedBody.addChild(vent1);
		this.bipedBody.addChild(vent2);

	}


}