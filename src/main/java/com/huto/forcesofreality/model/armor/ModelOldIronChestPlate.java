
package com.huto.forcesofreality.model.armor;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class ModelOldIronChestPlate extends BipedModel<LivingEntity> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;

	public ModelOldIronChestPlate(float f) {
		super(f, 0.0F, 64, 128);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 1.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 1.01F, false);
		Body.setTextureOffset(0, 33).addBox(-4.0F, 1.0F, -4.0F, 8.0F, 4.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 33).addBox(-4.0F, 1.0F, 3.0F, 8.0F, 4.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.setTextureOffset(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.0F, false);
		RightArm.setTextureOffset(0, 33).addBox(-4.0F, -3.0F, 3.0F, 4.0F, 6.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(0, 33).addBox(-5.0F, -3.0F, -3.0F, 1.0F, 6.0F, 6.0F, 0.0F, false);
		RightArm.setTextureOffset(0, 33).addBox(-6.0F, -4.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		RightArm.setTextureOffset(0, 33).addBox(-4.0F, -3.0F, -4.0F, 4.0F, 6.0F, 1.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.setTextureOffset(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 1.0F, true);
		LeftArm.setTextureOffset(0, 33).addBox(0.0F, -3.0F, -4.0F, 4.0F, 6.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(0, 33).addBox(4.0F, -3.0F, -3.0F, 1.0F, 6.0F, 6.0F, 0.0F, false);
		LeftArm.setTextureOffset(0, 33).addBox(0.0F, -4.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		LeftArm.setTextureOffset(0, 33).addBox(0.0F, -3.0F, 3.0F, 4.0F, 6.0F, 1.0F, 0.0F, false);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}