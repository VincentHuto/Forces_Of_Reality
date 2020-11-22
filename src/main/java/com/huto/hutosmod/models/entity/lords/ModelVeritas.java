package com.huto.hutosmod.models.entity.lords;

import com.huto.hutosmod.entities.lords.EntityVeritas;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelVeritas extends EntityModel<EntityVeritas> {
	private final ModelRenderer Head;
	private final ModelRenderer Halo;
	private final ModelRenderer Neck;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer bone3;
	private final ModelRenderer cube_r1;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer bone;
	private final ModelRenderer cube_r2;

	public ModelVeritas() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-0.25F, -3.75F, 4.0F);
		Head.setTextureOffset(0, 26).addBox(-2.75F, -4.25F, -5.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		Halo = new ModelRenderer(this);
		Halo.setRotationPoint(0.0F, -11.0F, 4.0F);
		setRotationAngle(Halo, -0.3054F, 0.0F, 0.0F);
		Halo.setTextureOffset(0, 0).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, 0.0F, false);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(-1.0F, 23.0F, 8.0F);
		Neck.setTextureOffset(45, 27).addBox(-1.0F, -28.0F, -3.0F, 3.0F, 5.0F, 2.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 16).addBox(-6.0F, 0.0F, 2.0F, 12.0F, 5.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(41, 16).addBox(-2.0F, 5.0F, 4.0F, 4.0F, 9.0F, 2.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setRotationPoint(2.0F, 9.5F, 4.5F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.0F, 0.9163F, 0.0F);
		Body_r1.setTextureOffset(12, 38).addBox(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r1.setTextureOffset(12, 40).addBox(-1.0F, -2.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r1.setTextureOffset(44, 38).addBox(-1.0F, -4.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setRotationPoint(3.1695F, 9.5F, 2.1919F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.0F, 2.4435F, 0.0F);
		Body_r2.setTextureOffset(0, 12).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r2.setTextureOffset(8, 12).addBox(-1.0F, -2.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r2.setTextureOffset(0, 14).addBox(-1.0F, -4.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setRotationPoint(-3.0F, 9.5F, 3.5F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, -0.9163F, 0.0F);
		Body_r3.setTextureOffset(28, 38).addBox(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r3.setTextureOffset(28, 40).addBox(-2.0F, -2.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r3.setTextureOffset(44, 40).addBox(-1.0F, -4.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setRotationPoint(-3.0229F, 9.5F, 2.1987F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.0F, -2.2253F, 0.0F);
		Body_r4.setTextureOffset(8, 14).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r4.setTextureOffset(29, 16).addBox(-2.0F, -2.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r4.setTextureOffset(29, 18).addBox(-3.0F, -4.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		setRotationAngle(RightArm, -0.5672F, 0.0F, -0.3491F);
		RightArm.setTextureOffset(32, 38).addBox(-4.5374F, -3.9067F, 1.971F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		RightArm.setTextureOffset(48, 0).addBox(-3.4284F, 3.0705F, 2.6732F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		setRotationAngle(LeftArm, -0.5672F, 0.0F, 0.3491F);
		LeftArm.setTextureOffset(16, 38).addBox(0.5374F, -3.9067F, 1.971F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setRotationPoint(2.8078F, 5.9936F, 3.8056F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -1.1345F, 0.48F, -0.0873F);
		LeftArm_r1.setTextureOffset(45, 46).addBox(-1.2785F, -2.805F, -3.3534F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		setRotationAngle(RightLeg, -0.6545F, -0.2618F, 1.309F);
		RightLeg.setTextureOffset(0, 38).addBox(-0.0317F, -2.9945F, 1.0245F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(11.2565F, 6.9405F, 3.7364F);
		RightLeg.addChild(bone3);
		setRotationAngle(bone3, 0.1745F, -0.8727F, 0.0436F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-5.0318F, 0.1371F, -0.2839F);
		bone3.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.0873F, -0.6981F, 0.2182F);
		cube_r1.setTextureOffset(18, 26).addBox(-4.7308F, -2.3252F, 4.3744F, 10.0F, 3.0F, 3.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.6545F, 0.2618F, -1.309F);
		LeftLeg.setTextureOffset(0, 0).addBox(-3.9683F, -2.9945F, 1.0245F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(3.85F, 10.7255F, -4.3588F);
		LeftLeg.addChild(bone);
		setRotationAngle(bone, 0.1745F, -0.8727F, 0.0436F);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-0.5474F, -6.1708F, 2.7342F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.0873F, -0.6109F, 0.2182F);
		cube_r2.setTextureOffset(24, 32).addBox(-0.3461F, 0.8857F, 3.8611F, 9.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityVeritas entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Halo.render(matrixStack, buffer, packedLight, packedOverlay);
		Neck.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}