package com.huto.forcesofreality.models.entity.lords;

import com.huto.forcesofreality.entities.lords.EntityVeritas;
import com.hutoslib.util.ClientUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;



public class ModelVeritas extends EntityModel<EntityVeritas> {
	private final ModelRenderer Head;
	private final ModelRenderer ring;
	private final ModelRenderer Halo;
	private final ModelRenderer Neck;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer bone2;
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
		

		ring = new ModelRenderer(this);
		ring.setRotationPoint(0.25F, -4.75F, -1.0F);
		Head.addChild(ring);
		ring.setTextureOffset(0, 26).addBox(-4.0F, 4.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		ring.setTextureOffset(0, 26).addBox(2.0F, 4.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		ring.setTextureOffset(0, 26).addBox(5.0F, 1.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		ring.setTextureOffset(0, 26).addBox(5.0F, -3.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		ring.setTextureOffset(0, 26).addBox(-7.0F, 1.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		ring.setTextureOffset(0, 26).addBox(-7.0F, -3.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		ring.setTextureOffset(0, 26).addBox(-4.0F, -6.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		ring.setTextureOffset(0, 26).addBox(2.0F, -6.5F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Halo = new ModelRenderer(this);
		Halo.setRotationPoint(0.1F, -8.9F, 4.0F);
		Halo.setTextureOffset(16, 0).addBox(-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(-1.0F, 23.0F, 8.0F);
		Neck.setTextureOffset(45, 27).addBox(-0.5F, -28.0F, -3.0F, 3.0F, 5.0F, 2.0F, 0.0F, false);
		Neck.setTextureOffset(45, 27).addBox(-0.5F, -29.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Neck.setTextureOffset(45, 27).addBox(-0.5F, -24.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Neck.setTextureOffset(45, 27).addBox(-0.5F, -25.0F, -4.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 16).addBox(-6.0F, 0.0F, 2.0F, 12.0F, 5.0F, 5.0F, 0.0F, false);
		Body.setTextureOffset(41, 16).addBox(-2.0F, 5.0F, 4.0F, 4.0F, 9.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(41, 16).addBox(-1.0F, 12.0F, 6.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(41, 16).addBox(-1.0F, 9.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(41, 16).addBox(-1.0F, 6.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(41, 16).addBox(-1.0F, 3.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(41, 16).addBox(-1.0F, 0.0F, 6.7F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(41, 16).addBox(-1.0F, -4.0F, 6.7F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(41, 16).addBox(-3.0F, 13.0F, 3.6F, 6.0F, 2.0F, 3.0F, 0.0F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setRotationPoint(3.0F, 9.5F, 3.5F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.0F, 0.9163F, 0.0F);
		Body_r1.setTextureOffset(28, 38).addBox(-2.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r1.setTextureOffset(28, 40).addBox(-2.0F, -2.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r1.setTextureOffset(44, 40).addBox(-2.0F, -4.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setRotationPoint(-3.0F, 9.5F, 3.5F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.0F, -0.9163F, 0.0F);
		Body_r2.setTextureOffset(28, 38).addBox(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r2.setTextureOffset(28, 40).addBox(-2.0F, -2.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r2.setTextureOffset(44, 40).addBox(-1.0F, -4.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setRotationPoint(3.0229F, 9.5F, 2.1987F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, 2.2253F, 0.0F);
		Body_r3.setTextureOffset(8, 14).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r3.setTextureOffset(29, 16).addBox(-1.0F, -2.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r3.setTextureOffset(29, 18).addBox(-1.0F, -4.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setRotationPoint(-3.0229F, 9.5F, 2.1987F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.0F, -2.2253F, 0.0F);
		Body_r4.setTextureOffset(8, 14).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r4.setTextureOffset(29, 16).addBox(-2.0F, -2.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r4.setTextureOffset(29, 18).addBox(-3.0F, -4.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.2F, 4.0F, 4.0F);
		setRotationAngle(RightArm, -0.5672F, 0.0F, -0.3491F);
		RightArm.setTextureOffset(32, 38).addBox(-3.5374F, -4.444F, -1.1856F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		RightArm.setTextureOffset(48, 0).addBox(-2.4284F, 2.5332F, -0.4834F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(6.0F, 2.0F, 4.0F);
		setRotationAngle(LeftArm, 0.0F, 0.3927F, -0.2182F);
		LeftArm.setTextureOffset(16, 38).addBox(-0.8453F, -1.9067F, -1.1052F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(1.5293F, 6.6886F, -0.5478F);
		LeftArm.addChild(bone2);
		setRotationAngle(bone2, 0.0F, -0.6545F, 0.0F);
		bone2.setTextureOffset(39, 46).addBox(-1.8827F, -1.5F, -6.0761F, 3.0F, 3.0F, 8.0F, 0.0F, false);

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
		cube_r1.setTextureOffset(18, 26).addBox(-3.7308F, -2.3252F, 4.3744F, 9.0F, 3.0F, 3.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		setRotationAngle(LeftLeg, -0.48F, 0.2618F, -1.0472F);
		LeftLeg.setTextureOffset(0, 0).addBox(-3.9683F, -2.9945F, 1.0245F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(3.85F, 10.7255F, -4.3588F);
		LeftLeg.addChild(bone);
		setRotationAngle(bone, 0.1745F, -0.8727F, 0.0436F);
		

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(1.2804F, -3.182F, 9.9955F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.0873F, -0.1309F, -0.1309F);
		cube_r2.setTextureOffset(24, 32).addBox(-6.5027F, -1.2301F, -0.895F, 9.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityVeritas entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		float parTicks = ClientUtils.getPartialTicks();

		
		this.ring.rotateAngleX= 0;
		this.ring.rotateAngleZ= (ageInTicks + parTicks)*0.1f;
		this.Halo.rotateAngleZ= -(ageInTicks + parTicks)*0.2f;	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
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