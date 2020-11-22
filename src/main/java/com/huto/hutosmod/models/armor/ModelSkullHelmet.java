package com.huto.hutosmod.models.armor;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

@SuppressWarnings("rawtypes")
public class ModelSkullHelmet extends BipedModel {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Head_r5;
	private final ModelRenderer Head_r6;
	private final ModelRenderer Head_r7;

	public ModelSkullHelmet() {
		super(1.0f);
		textureWidth = 128;
		textureHeight = 64;
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(64, 49).addBox(-4.0F, -8.0F, 4.0F, 8.0F, 6.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(64, 36).addBox(4.0F, -8.0F, -3.0F, 0.0F, 6.0F, 7.0F, 0.0F, false);
		Head.setTextureOffset(64, 36).addBox(-4.0F, -8.0F, -3.0F, 0.0F, 6.0F, 7.0F, 0.0F, false);
		Head.setTextureOffset(14, 47).addBox(-3.0F, -10.0F, -3.0F, 6.0F, 2.0F, 7.0F, 0.0F, false);
		Head.setTextureOffset(14, 47).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 0.0F, 7.0F, 0.0F, false);
		Head.setTextureOffset(64, 56).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 3.0F, 0.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setRotationPoint(0.0F, -5.0F, -11.0F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.1745F, 0.0F, 0.0F);
		Head_r1.setTextureOffset(16, 47).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setRotationPoint(0.0F, -7.0F, -6.0F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.1745F, 0.0F, 0.0F);
		Head_r2.setTextureOffset(22, 49).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setRotationPoint(0.0F, -6.0F, -7.0F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.1745F, 0.0F, 0.0F);
		Head_r3.setTextureOffset(22, 48).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 5.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setRotationPoint(0.0F, -4.0F, -11.0F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, 0.1745F, 0.0F, 0.0F);
		Head_r4.setTextureOffset(35, 52).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setRotationPoint(0.0F, -5.0F, -7.0F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 0.1745F, 0.0F, 0.0F);
		Head_r5.setTextureOffset(14, 50).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setRotationPoint(-6.875F, -10.5F, 5.375F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, 0.1309F, 0.0F, 0.0F);
		Head_r6.setTextureOffset(5, 47).addBox(1.975F, 0.5F, -7.375F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		Head_r6.setTextureOffset(23, 41).addBox(-0.025F, -0.5F, -2.375F, 2.0F, 2.0F, 7.0F, 0.0F, false);
		Head_r6.setTextureOffset(33, 53).addBox(-4.025F, -1.5F, 1.625F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		Head_r6.setTextureOffset(28, 56).addBox(13.775F, -1.5F, 1.625F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		Head_r6.setTextureOffset(11, 49).addBox(13.775F, -1.5F, -2.375F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		Head_r6.setTextureOffset(0, 59).addBox(-3.025F, -1.5F, -2.375F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		Head_r6.setTextureOffset(2, 49).addBox(11.775F, -0.5F, -2.375F, 2.0F, 2.0F, 8.0F, 0.0F, false);
		Head_r6.setTextureOffset(9, 47).addBox(9.775F, 0.5F, -7.375F, 2.0F, 2.0F, 9.0F, 0.0F, false);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setRotationPoint(-12.125F, -11.5F, 7.375F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, 0.1309F, 0.0F, 0.0F);
		Head_r7.setTextureOffset(4, 52).addBox(3.025F, -1.5F, 1.625F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		Head_r7.setTextureOffset(28, 43).addBox(23.025F, -1.5F, 1.625F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Head_r7.setTextureOffset(17, 56).addBox(0.025F, -1.5F, 1.625F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Head_r7.setTextureOffset(7, 51).addBox(20.025F, -1.5F, 1.625F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		this.bipedHead.addChild(Head);
		this.bipedHead.addChild(Head_r1);
		this.bipedHead.addChild(Head_r2);
		this.bipedHead.addChild(Head_r3);
		this.bipedHead.addChild(Head_r4);
		this.bipedHead.addChild(Head_r5);
		this.bipedHead.addChild(Head_r6);
		this.bipedHead.addChild(Head_r7);

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