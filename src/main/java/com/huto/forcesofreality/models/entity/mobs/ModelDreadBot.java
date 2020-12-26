package com.huto.forcesofreality.models.entity.mobs;

import com.huto.forcesofreality.entities.mobs.EntityDreadBot;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelDreadBot extends EntityModel<EntityDreadBot> {
	private final ModelRenderer whole;
	private final ModelRenderer BottomGear;
	private final ModelRenderer rightTread;
	private final ModelRenderer rightWheel1;
	private final ModelRenderer rightWheel2;
	private final ModelRenderer rightWheel3;
	private final ModelRenderer leftTread;
	private final ModelRenderer leftWheel1;
	private final ModelRenderer leftWheel2;
	private final ModelRenderer leftWheel3;
	private final ModelRenderer topMiddleGear;
	private final ModelRenderer turret;
	private final ModelRenderer cube_r1;
	private final ModelRenderer bottomMiddleGear;
	private final ModelRenderer eye;

	public ModelDreadBot() {
		textureWidth = 128;
		textureHeight = 128;

		whole = new ModelRenderer(this);
		whole.setRotationPoint(-12.0F, 9.0F, 10.0F);
		whole.setTextureOffset(0, 0).addBox(6.0F, -5.0F, -16.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);
		whole.setTextureOffset(8, 31).addBox(5.0F, -3.0F, -17.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
		whole.setTextureOffset(0, 31).addBox(5.0F, -3.0F, -5.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
		whole.setTextureOffset(0, 13).addBox(17.0F, -3.0F, -5.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
		whole.setTextureOffset(0, 0).addBox(17.0F, -3.0F, -17.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
		whole.setTextureOffset(44, 27).addBox(7.0F, 5.0F, -15.0F, 10.0F, 2.0F, 11.0F, 0.0F, false);
		whole.setTextureOffset(22, 44).addBox(7.0F, -4.0F, -15.0F, 10.0F, 2.0F, 11.0F, 0.0F, false);
		whole.setTextureOffset(6, 43).addBox(15.0F, -2.0F, -5.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
		whole.setTextureOffset(0, 43).addBox(7.0F, -2.0F, -5.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
		whole.setTextureOffset(42, 13).addBox(7.0F, -2.0F, -16.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
		whole.setTextureOffset(42, 0).addBox(15.0F, -2.0F, -16.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
		whole.setTextureOffset(36, 13).addBox(17.0F, -2.0F, -15.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
		whole.setTextureOffset(36, 0).addBox(17.0F, -2.0F, -7.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
		whole.setTextureOffset(28, 32).addBox(6.0F, -2.0F, -15.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
		whole.setTextureOffset(22, 32).addBox(6.0F, -2.0F, -7.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);

		BottomGear = new ModelRenderer(this);
		BottomGear.setRotationPoint(12.0F, 7.5F, -10.0F);
		whole.addChild(BottomGear);
		BottomGear.setTextureOffset(48, 5).addBox(-8.0F, 0.5F, -6.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		BottomGear.setTextureOffset(48, 0).addBox(6.0F, 0.5F, -6.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		BottomGear.setTextureOffset(44, 32).addBox(6.0F, 0.5F, 4.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		BottomGear.setTextureOffset(44, 27).addBox(-8.0F, 0.5F, 4.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		BottomGear.setTextureOffset(53, 40).addBox(-5.0F, 0.5F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		BottomGear.setTextureOffset(0, 13).addBox(-6.0F, -0.5F, -6.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);

		rightTread = new ModelRenderer(this);
		rightTread.setRotationPoint(-5.0F, 5.0F, -2.0F);
		BottomGear.addChild(rightTread);
		rightTread.setTextureOffset(0, 43).addBox(-6.0F, 1.5F, -6.0F, 3.0F, 1.0F, 16.0F, 0.0F, false);
		rightTread.setTextureOffset(0, 44).addBox(-4.5F, -1.5F, -6.0F, 0.0F, 3.0F, 16.0F, 0.0F, false);
		rightTread.setTextureOffset(32, 10).addBox(-6.0F, -2.5F, -6.0F, 3.0F, 1.0F, 16.0F, 0.0F, false);
		rightTread.setTextureOffset(53, 44).addBox(-6.0F, -1.5F, 10.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		rightTread.setTextureOffset(8, 51).addBox(-6.0F, -1.5F, -7.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		rightWheel1 = new ModelRenderer(this);
		rightWheel1.setRotationPoint(-4.5F, 0.0F, -4.5F);
		rightTread.addChild(rightWheel1);
		rightWheel1.setTextureOffset(34, 34).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		rightWheel1.setTextureOffset(43, 21).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightWheel1.setTextureOffset(43, 23).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rightWheel2 = new ModelRenderer(this);
		rightWheel2.setRotationPoint(-4.5F, 0.0F, 1.5F);
		rightTread.addChild(rightWheel2);
		rightWheel2.setTextureOffset(33, 40).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightWheel2.setTextureOffset(12, 26).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		rightWheel2.setTextureOffset(34, 38).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rightWheel3 = new ModelRenderer(this);
		rightWheel3.setRotationPoint(-4.5F, 0.0F, 8.5F);
		rightTread.addChild(rightWheel3);
		rightWheel3.setTextureOffset(22, 26).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		rightWheel3.setTextureOffset(12, 43).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightWheel3.setTextureOffset(40, 22).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		leftTread = new ModelRenderer(this);
		leftTread.setRotationPoint(14.0F, 5.0F, -2.0F);
		BottomGear.addChild(leftTread);
		leftTread.setTextureOffset(22, 27).addBox(-6.0F, 1.5F, -6.0F, 3.0F, 1.0F, 16.0F, 0.0F, false);
		leftTread.setTextureOffset(38, 41).addBox(-4.5F, -1.5F, -6.0F, 0.0F, 3.0F, 16.0F, 0.0F, false);
		leftTread.setTextureOffset(0, 26).addBox(-6.0F, -2.5F, -6.0F, 3.0F, 1.0F, 16.0F, 0.0F, false);
		leftTread.setTextureOffset(0, 51).addBox(-6.0F, -1.5F, 10.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		leftTread.setTextureOffset(22, 49).addBox(-6.0F, -1.5F, -7.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		leftWheel1 = new ModelRenderer(this);
		leftWheel1.setRotationPoint(-4.5F, 0.0F, -4.5F);
		leftTread.addChild(leftWheel1);
		leftWheel1.setTextureOffset(8, 2).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		leftWheel1.setTextureOffset(8, 19).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		leftWheel1.setTextureOffset(8, 6).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		leftWheel2 = new ModelRenderer(this);
		leftWheel2.setRotationPoint(-4.5F, 0.0F, 1.5F);
		leftTread.addChild(leftWheel2);
		leftWheel2.setTextureOffset(34, 29).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		leftWheel2.setTextureOffset(0, 26).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		leftWheel2.setTextureOffset(34, 27).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		leftWheel3 = new ModelRenderer(this);
		leftWheel3.setRotationPoint(-4.5F, 0.0F, 8.5F);
		leftTread.addChild(leftWheel3);
		leftWheel3.setTextureOffset(6, 31).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		leftWheel3.setTextureOffset(8, 15).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		leftWheel3.setTextureOffset(26, 32).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		topMiddleGear = new ModelRenderer(this);
		topMiddleGear.setRotationPoint(12.0F, -1.5F, -10.0F);
		whole.addChild(topMiddleGear);
		topMiddleGear.setTextureOffset(6, 13).addBox(-1.0F, -0.5F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		topMiddleGear.setTextureOffset(0, 26).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		topMiddleGear.setTextureOffset(6, 22).addBox(2.0F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topMiddleGear.setTextureOffset(6, 0).addBox(-1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		topMiddleGear.setTextureOffset(6, 9).addBox(-3.0F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		turret = new ModelRenderer(this);
		turret.setRotationPoint(12.0F, -6.1667F, -10.0833F);
		whole.addChild(turret);
		turret.setTextureOffset(6, 13).addBox(-1.0F, 0.1667F, -2.9167F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		turret.setTextureOffset(8, 51).addBox(-1.0F, -0.8333F, 1.0833F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		turret.setTextureOffset(0, 26).addBox(-2.0F, 0.1667F, -1.9167F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		turret.setTextureOffset(6, 22).addBox(2.0F, 0.1667F, -0.9167F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		turret.setTextureOffset(6, 0).addBox(-1.0F, 0.1667F, 2.0833F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		turret.setTextureOffset(6, 9).addBox(-3.0F, 0.1667F, -0.9167F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		turret.setTextureOffset(8, 51).addBox(-1.0F, -2.8333F, -1.9167F, 2.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-1.0F, -2.3333F, -0.9167F);
		turret.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.48F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(54, 0).addBox(-0.5F, -2.5F, -2.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);

		bottomMiddleGear = new ModelRenderer(this);
		bottomMiddleGear.setRotationPoint(12.0F, 4.5F, -10.0F);
		whole.addChild(bottomMiddleGear);
		bottomMiddleGear.setTextureOffset(40, 9).addBox(-1.0F, -0.5F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bottomMiddleGear.setTextureOffset(22, 27).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		bottomMiddleGear.setTextureOffset(36, 22).addBox(2.0F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bottomMiddleGear.setTextureOffset(32, 32).addBox(-1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		bottomMiddleGear.setTextureOffset(36, 9).addBox(-3.0F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		eye = new ModelRenderer(this);
		eye.setRotationPoint(12.0F, 1.5F, -10.0F);
		whole.addChild(eye);
		eye.setTextureOffset(22, 44).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityDreadBot entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.turret.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.eye.rotateAngleX = ageInTicks * 0.25f;
		this.eye.rotateAngleY = ageInTicks * 0.25f;
		this.eye.rotateAngleZ = ageInTicks * 0.25f;

		this.topMiddleGear.rotateAngleY = ageInTicks * 0.25f;
		this.bottomMiddleGear.rotateAngleY = -ageInTicks * 0.25f;

		this.leftWheel1.rotateAngleX = limbSwing * 0.4f;
		this.leftWheel2.rotateAngleX = limbSwing * 0.4f;
		this.leftWheel3.rotateAngleX = limbSwing * 0.4f;

		this.rightWheel1.rotateAngleX = limbSwing * 0.4f;
		this.rightWheel2.rotateAngleX = limbSwing * 0.4f;
		this.rightWheel3.rotateAngleX = limbSwing * 0.4f;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		whole.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}