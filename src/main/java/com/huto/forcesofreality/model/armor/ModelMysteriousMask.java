package com.huto.forcesofreality.model.armor;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.entity.LivingEntity;

@SuppressWarnings("rawtypes")
public class ModelMysteriousMask extends HumanoidModel {
	private final ModelPart LeftBand;
	private final ModelPart BackBand;
	private final ModelPart RightBand;
	private final ModelPart Mask;

	public ModelMysteriousMask() {
		super(1.0f);
		textureWidth = 128;
		textureHeight = 64;
		LeftBand = new ModelRenderer(this);
		LeftBand.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftBand.setTextureOffset(80, 34).addBox(4.0F, -7.0F, -4.0F, 1.0F, 1.0F, 5.0F, 0.0F, true);
		LeftBand.setTextureOffset(80, 34).addBox(4.0F, -6.0F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		BackBand = new ModelRenderer(this);
		BackBand.setRotationPoint(0.0F, 0.0F, 0.0F);
		BackBand.setTextureOffset(50, 45).addBox(-4.0F, -6.0F, 4.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);

		RightBand = new ModelRenderer(this);
		RightBand.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightBand.setTextureOffset(80, 34).addBox(-5.0F, -7.0F, -4.0F, 1.0F, 1.0F, 5.0F, 0.0F, true);
		RightBand.setTextureOffset(80, 34).addBox(-5.0F, -6.0F, 1.0F, 1.0F, 1.0F, 3.0F, 0.0F, true);

		Mask = new ModelRenderer(this);
		Mask.setRotationPoint(0.0F, 0.0F, 0.0F);
		Mask.setTextureOffset(50, 34).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 8.0F, 1.0F, 0.0F, true);
		this.bipedHead.addChild(Mask);
		this.bipedHead.addChild(LeftBand);
		this.bipedHead.addChild(RightBand);
		this.bipedHead.addChild(BackBand);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setRotationAngles(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
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

	public void renderMask(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		LeftBand.render(matrixStack, buffer, packedOverlay, packedOverlay);
		RightBand.render(matrixStack, buffer, packedOverlay, packedOverlay);
		BackBand.render(matrixStack, buffer, packedOverlay, packedOverlay);
		Mask.render(matrixStack, buffer, packedOverlay, packedOverlay);
	}
}