package com.huto.forces_of_reality.models.armor;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class ModelAuricHelm extends BipedModel<LivingEntity> {
	public ModelAuricHelm() {
		super(0.1f, 0, 64, 64);

		ModelRenderer Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(37, 48).addBox(-0.05F, -12.0F, -4.0F, 0.1F, 4.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(0, 52).addBox(-1.0F, -10.0F, -5.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		Head.setTextureOffset(1, 56).addBox(-1.0F, -10.0F, 4.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(42, 53).addBox(-0.05F, -13.0F, -4.0F, 0.1F, 1.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(42, 53).addBox(-0.05F, -14.0F, -6.0F, 0.1F, 6.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(42, 50).addBox(-0.05F, -12.0F, 4.0F, 0.1F, 10.0F, 3.0F, 0.0F, false);
		this.bipedHead.addChild(Head);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}