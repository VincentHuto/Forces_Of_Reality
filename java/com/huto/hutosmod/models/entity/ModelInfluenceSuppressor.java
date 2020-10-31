package com.huto.hutosmod.models.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

@SuppressWarnings("rawtypes")
public class ModelInfluenceSuppressor extends BipedModel {
	private final ModelRenderer LeftBand;
	private final ModelRenderer BackBand;
	private final ModelRenderer RightBand;
	private final ModelRenderer Mask;

	public ModelInfluenceSuppressor() {
		super(1.0f);
		textureWidth = 128;
		textureHeight = 64;

		LeftBand = new ModelRenderer(this);
		LeftBand.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftBand.setTextureOffset(0, 40).addBox(4.0F, -6.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		BackBand = new ModelRenderer(this);
		BackBand.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackBand.setTextureOffset(18, 49).addBox(-4.0F, -6.0F, 4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		RightBand = new ModelRenderer(this);
		RightBand.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightBand.setTextureOffset(18, 40).addBox(-5.0F, -6.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);

		Mask = new ModelRenderer(this);
		Mask.setRotationPoint(0.0F, 0.0F, 0.0F);
		Mask.setTextureOffset(0, 52).addBox(-3.0F, -7.0F, -5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Mask.setTextureOffset(0, 49).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		Mask.setTextureOffset(4, 54).addBox(-3.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mask.setTextureOffset(0, 54).addBox(2.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Mask.setTextureOffset(22, 52).addBox(1.0F, -4.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Mask.setTextureOffset(14, 52).addBox(-4.0F, -4.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		this.bipedHead.addChild(Mask);
		this.bipedHead.addChild(LeftBand);
		this.bipedHead.addChild(RightBand);
		this.bipedHead.addChild(BackBand);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setRotationAngles(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}