package com.huto.forcesofreality.models.entity.guardians;

import javax.swing.text.html.parser.Entity;

import com.huto.forcesofreality.entities.lords.EntityLordOfTheWild;
import com.huto.forcesofreality.models.animation.AnimatedEntityModel;
import com.huto.forcesofreality.models.animation.AnimatedModelRenderer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

public class ModelFirstBeast extends AnimatedEntityModel<EntityLordOfTheWild> {
	private final AnimatedModelRenderer whole;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer mane;
	private final AnimatedModelRenderer bone;
	private final AnimatedModelRenderer mane2;
	private final AnimatedModelRenderer mane3;
	private final AnimatedModelRenderer beard;
	private final AnimatedModelRenderer beard2;
	private final AnimatedModelRenderer beard3;
	private final AnimatedModelRenderer abs;
	private final AnimatedModelRenderer cloth;
	private final AnimatedModelRenderer rightLeg;
	private final AnimatedModelRenderer rightFemur;
	private final AnimatedModelRenderer rightBoot;
	private final AnimatedModelRenderer leftLeg;
	private final AnimatedModelRenderer leftFemur;
	private final AnimatedModelRenderer leftBoot;
	private final AnimatedModelRenderer leftArm;
	private final AnimatedModelRenderer leftFore;
	private final AnimatedModelRenderer rightArm;
	private final AnimatedModelRenderer rightFore;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer skull;
	private final AnimatedModelRenderer topJaw;
	private final AnimatedModelRenderer bottomJaw;

	public ModelFirstBeast() {
		textureWidth = 64;
		textureHeight = 64;

		whole = new AnimatedModelRenderer(this);
		whole.setRotationPoint(0.0F, -14.0F, 3.0F);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		whole.addChild(body);
		body.setTextureOffset(16, 16).addBox(-7.0F, -4.0F, -6.0F, 14.0F, 8.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(16, 16).addBox(-4.75F, -7.0F, -7.0F, 9.0F, 7.0F, 9.0F, 0.0F, false);
		body.setTextureOffset(16, 16).addBox(-5.0F, 4.0F, -4.5F, 10.0F, 5.0F, 7.0F, 0.0F, false);

		mane = new AnimatedModelRenderer(this);
		mane.setRotationPoint(0.5F, 21.0F, 7.25F);
		body.addChild(mane);
		mane.setTextureOffset(0, 0).addBox(-5.0F, -28.75F, -12.25F, 9.0F, 1.0F, 9.0F, 0.0F, false);
		mane.setTextureOffset(0, 0).addBox(-5.5F, -28.1F, -13.35F, 10.0F, 4.0F, 9.0F, 0.0F, false);
		mane.setTextureOffset(0, 0).addBox(-6.5F, -27.0F, -12.25F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		mane.setTextureOffset(0, 0).addBox(4.5F, -27.0F, -12.25F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		mane.setTextureOffset(0, 0).addBox(-5.5F, -24.0F, -4.25F, 10.0F, 9.0F, 0.0F, 0.0F, false);
		mane.setTextureOffset(0, 0).addBox(-5.0F, -28.0F, -5.0F, 9.0F, 4.0F, 2.0F, 0.0F, false);
		mane.setTextureOffset(0, 0).addBox(-6.0F, -26.0F, -7.5F, 11.0F, 8.0F, 3.0F, 0.0F, false);

		bone = new AnimatedModelRenderer(this);
		bone.setRotationPoint(-0.49F, -29.4195F, -9.3763F);
		mane.addChild(bone);
		setRotationAngle(bone, 0.3927F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-3.5F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F, 0.0F, false);

		mane2 = new AnimatedModelRenderer(this);
		mane2.setRotationPoint(-0.5F, -1.75F, -16.125F);
		mane.addChild(mane2);
		setRotationAngle(mane2, -0.0436F, 0.0F, 0.0F);
		mane2.setTextureOffset(0, 0).addBox(-4.5F, -18.25F, 11.125F, 9.0F, 9.0F, 0.0F, 0.0F, false);

		mane3 = new AnimatedModelRenderer(this);
		mane3.setRotationPoint(0.0F, -5.7827F, 11.6243F);
		mane2.addChild(mane3);
		setRotationAngle(mane3, 0.1309F, 0.0F, 0.0F);
		mane3.setTextureOffset(0, 0).addBox(-4.0F, -4.5F, 0.0F, 8.0F, 9.0F, 0.0F, 0.0F, false);

		beard = new AnimatedModelRenderer(this);
		beard.setRotationPoint(-1.25F, 3.0F, -10.45F);
		mane.addChild(beard);
		beard.setTextureOffset(0, 0).addBox(-5.0F, -28.0F, -4.0F, 11.0F, 6.0F, 0.0F, 0.0F, false);

		beard2 = new AnimatedModelRenderer(this);
		beard2.setRotationPoint(0.625F, -22.5F, -3.95F);
		beard.addChild(beard2);
		setRotationAngle(beard2, 0.0873F, 0.0F, 0.0F);
		beard2.setTextureOffset(0, 0).addBox(-4.625F, 0.25F, -0.05F, 9.0F, 4.0F, 0.0F, 0.0F, false);

		beard3 = new AnimatedModelRenderer(this);
		beard3.setRotationPoint(-0.125F, 5.25F, 0.2F);
		beard2.addChild(beard3);
		setRotationAngle(beard3, 0.0873F, 0.0F, 0.0F);
		beard3.setTextureOffset(0, 0).addBox(-4.5F, -2.0F, 0.0F, 9.0F, 4.0F, 0.0F, 0.0F, false);

		abs = new AnimatedModelRenderer(this);
		abs.setRotationPoint(0.0F, 9.3F, -2.2F);
		body.addChild(abs);
		abs.setTextureOffset(16, 16).addBox(-3.0F, 4.7F, -1.8F, 6.0F, 4.0F, 6.0F, 0.0F, false);
		abs.setTextureOffset(16, 16).addBox(-4.0F, -0.3F, -1.8F, 8.0F, 5.0F, 6.0F, 0.0F, false);

		cloth = new AnimatedModelRenderer(this);
		cloth.setRotationPoint(0.0F, 3.7F, 0.2F);
		abs.addChild(cloth);
		cloth.setTextureOffset(16, 16).addBox(-4.5F, 1.0F, -2.1F, 9.0F, 9.0F, 0.0F, 0.0F, false);
		cloth.setTextureOffset(16, 16).addBox(-4.5F, 1.0F, 4.15F, 9.0F, 9.0F, 0.0F, 0.0F, false);

		rightLeg = new AnimatedModelRenderer(this);
		rightLeg.setRotationPoint(-2.9167F, 7.825F, 0.7833F);
		abs.addChild(rightLeg);
		rightLeg.setTextureOffset(16, 16).addBox(-3.5833F, 1.875F, -1.0833F, 4.0F, 7.0F, 3.0F, 0.0F, false);
		rightLeg.setTextureOffset(16, 16).addBox(-3.3333F, -2.375F, -1.5833F, 2.0F, 4.0F, 4.0F, 0.0F, false);
		rightLeg.setTextureOffset(16, 16).addBox(-3.0833F, -3.125F, -2.5833F, 3.0F, 5.0F, 6.0F, 0.0F, false);
		rightLeg.setTextureOffset(16, 16).addBox(-2.8333F, 1.875F, 1.4167F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		rightLeg.setTextureOffset(16, 16).addBox(-3.0833F, 1.875F, -1.5833F, 3.0F, 7.0F, 4.0F, 0.0F, false);

		rightFemur = new AnimatedModelRenderer(this);
		rightFemur.setRotationPoint(-1.7333F, 8.8F, -1.3958F);
		rightLeg.addChild(rightFemur);
		rightFemur.setTextureOffset(16, 16).addBox(-1.35F, 0.075F, 0.5625F, 3.0F, 7.0F, 4.0F, 0.0F, false);
		rightFemur.setTextureOffset(16, 16).addBox(-1.85F, 0.075F, 1.0625F, 4.0F, 7.0F, 3.0F, 0.0F, false);
		rightFemur.setTextureOffset(16, 16).addBox(-1.45F, -0.725F, -0.9375F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		rightBoot = new AnimatedModelRenderer(this);
		rightBoot.setRotationPoint(0.15F, 7.215F, 2.7125F);
		rightFemur.addChild(rightBoot);
		rightBoot.setTextureOffset(16, 16).addBox(-2.5F, -1.14F, -1.4F, 5.0F, 6.0F, 4.0F, 0.0F, false);
		rightBoot.setTextureOffset(16, 16).addBox(-2.0F, -0.09F, -3.65F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		rightBoot.setTextureOffset(16, 16).addBox(-2.0F, -0.09F, -0.65F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		rightBoot.setTextureOffset(16, 16).addBox(-1.5F, 3.91F, -7.65F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		rightBoot.setTextureOffset(16, 16).addBox(-1.0F, 2.91F, -8.65F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		rightBoot.setTextureOffset(16, 16).addBox(-1.0F, 1.91F, -7.65F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		leftLeg = new AnimatedModelRenderer(this);
		leftLeg.setRotationPoint(2.9167F, 7.825F, 0.7833F);
		abs.addChild(leftLeg);
		leftLeg.setTextureOffset(16, 16).addBox(-0.4167F, 1.875F, -1.0833F, 4.0F, 7.0F, 3.0F, 0.0F, false);
		leftLeg.setTextureOffset(16, 16).addBox(0.0833F, 1.875F, -1.5833F, 3.0F, 7.0F, 4.0F, 0.0F, false);
		leftLeg.setTextureOffset(16, 16).addBox(0.8333F, 1.875F, 1.4167F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		leftLeg.setTextureOffset(16, 16).addBox(0.0833F, -3.125F, -2.5833F, 3.0F, 5.0F, 6.0F, 0.0F, false);
		leftLeg.setTextureOffset(16, 16).addBox(1.3333F, -2.375F, -1.5833F, 2.0F, 4.0F, 4.0F, 0.0F, false);

		leftFemur = new AnimatedModelRenderer(this);
		leftFemur.setRotationPoint(1.4333F, 9.3F, -0.3958F);
		leftLeg.addChild(leftFemur);
		leftFemur.setTextureOffset(16, 16).addBox(-1.45F, -1.225F, -1.9375F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		leftFemur.setTextureOffset(16, 16).addBox(-1.35F, -0.425F, -0.4375F, 3.0F, 7.0F, 4.0F, 0.0F, false);
		leftFemur.setTextureOffset(16, 16).addBox(-1.85F, -0.425F, 0.0625F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		leftBoot = new AnimatedModelRenderer(this);
		leftBoot.setRotationPoint(0.15F, 6.715F, 0.7125F);
		leftFemur.addChild(leftBoot);
		leftBoot.setTextureOffset(16, 16).addBox(-2.5F, -1.14F, -0.4F, 5.0F, 6.0F, 4.0F, 0.0F, false);
		leftBoot.setTextureOffset(16, 16).addBox(-2.0F, -0.09F, -2.65F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		leftBoot.setTextureOffset(16, 16).addBox(-2.0F, -0.09F, 0.35F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		leftBoot.setTextureOffset(16, 16).addBox(-1.5F, 3.91F, -6.65F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		leftBoot.setTextureOffset(16, 16).addBox(-1.0F, 2.91F, -7.65F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		leftBoot.setTextureOffset(16, 16).addBox(-1.0F, 1.91F, -6.65F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		leftArm = new AnimatedModelRenderer(this);
		leftArm.setRotationPoint(7.0F, -2.375F, -2.25F);
		body.addChild(leftArm);
		leftArm.setTextureOffset(16, 16).addBox(-0.5F, -1.375F, -2.25F, 4.0F, 8.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(16, 16).addBox(-1.75F, -1.875F, -1.75F, 4.0F, 8.0F, 5.0F, 0.0F, false);

		leftFore = new AnimatedModelRenderer(this);
		leftFore.setRotationPoint(2.675F, 6.4083F, 1.0167F);
		leftArm.addChild(leftFore);
		leftFore.setTextureOffset(16, 16).addBox(-3.025F, -0.7833F, -1.2667F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		leftFore.setTextureOffset(16, 16).addBox(-2.275F, 6.9167F, -2.5667F, 3.0F, 8.0F, 5.0F, 0.0F, false);
		leftFore.setTextureOffset(16, 16).addBox(-3.175F, 4.2167F, -2.6667F, 4.0F, 8.0F, 5.0F, 0.0F, false);
		leftFore.setTextureOffset(16, 16).addBox(-2.675F, 4.7167F, -3.6667F, 4.0F, 8.0F, 1.0F, 0.0F, false);
		leftFore.setTextureOffset(16, 16).addBox(0.825F, 4.2167F, -2.6667F, 1.0F, 8.0F, 5.0F, 0.0F, false);
		leftFore.setTextureOffset(16, 16).addBox(-2.675F, 4.7167F, 2.3333F, 4.0F, 8.0F, 1.0F, 0.0F, false);

		rightArm = new AnimatedModelRenderer(this);
		rightArm.setRotationPoint(-6.5F, -2.75F, -1.25F);
		body.addChild(rightArm);
		rightArm.setTextureOffset(16, 16).addBox(-4.0F, -1.0F, -3.25F, 4.0F, 8.0F, 6.0F, 0.0F, false);
		rightArm.setTextureOffset(16, 16).addBox(-3.25F, -1.5F, -2.75F, 4.0F, 8.0F, 5.0F, 0.0F, false);

		rightFore = new AnimatedModelRenderer(this);
		rightFore.setRotationPoint(-2.6667F, 6.7833F, 0.0167F);
		rightArm.addChild(rightFore);
		rightFore.setTextureOffset(16, 16).addBox(-1.5833F, -0.7833F, -1.2667F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		rightFore.setTextureOffset(16, 16).addBox(-1.0833F, 6.9167F, -2.5667F, 3.0F, 8.0F, 5.0F, 0.0F, false);
		rightFore.setTextureOffset(16, 16).addBox(-1.8333F, 4.7167F, -3.6667F, 4.0F, 8.0F, 1.0F, 0.0F, false);
		rightFore.setTextureOffset(16, 16).addBox(-2.3333F, 4.2167F, -2.6667F, 1.0F, 8.0F, 5.0F, 0.0F, false);
		rightFore.setTextureOffset(16, 16).addBox(-1.3333F, 4.2167F, -2.6667F, 4.0F, 8.0F, 5.0F, 0.0F, false);
		rightFore.setTextureOffset(16, 16).addBox(-1.8333F, 4.7167F, 2.3333F, 4.0F, 8.0F, 1.0F, 0.0F, false);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -8.0F, -6.0F);
		body.addChild(head);

		skull = new AnimatedModelRenderer(this);
		skull.setRotationPoint(0.0F, 1.7778F, -2.6667F);
		head.addChild(skull);
		setRotationAngle(skull, 0.4363F, 0.0F, 0.0F);
		skull.setTextureOffset(0, 0).addBox(-4.0F, -5.7778F, -5.3333F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		skull.setTextureOffset(0, 0).addBox(-3.0F, -6.7778F, -4.3333F, 6.0F, 2.0F, 8.0F, 0.0F, false);
		skull.setTextureOffset(0, 0).addBox(-3.0F, -4.7778F, 2.1667F, 6.0F, 4.0F, 2.0F, 0.0F, false);
		skull.setTextureOffset(0, 0).addBox(-3.5F, -2.9652F, 1.3214F, 7.0F, 5.0F, 5.0F, 0.0F, false);
		skull.setTextureOffset(0, 0).addBox(-4.5F, -4.7778F, -3.3333F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		skull.setTextureOffset(0, 0).addBox(3.5F, -4.7778F, -3.3333F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		skull.setTextureOffset(0, 0).addBox(-5.5F, -5.2778F, -1.3333F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		skull.setTextureOffset(0, 0).addBox(4.5F, -5.2778F, -1.3333F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		skull.setTextureOffset(0, 0).addBox(-5.75F, -5.7778F, -0.3333F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		skull.setTextureOffset(0, 0).addBox(4.75F, -5.7778F, -0.3333F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		topJaw = new AnimatedModelRenderer(this);
		topJaw.setRotationPoint(0.0F, -0.6944F, -5.5833F);
		skull.addChild(topJaw);
		topJaw.setTextureOffset(0, 0).addBox(-1.0F, -0.8333F, -5.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		topJaw.setTextureOffset(0, 0).addBox(-1.0F, -1.0833F, -4.75F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		topJaw.setTextureOffset(0, 0).addBox(-2.0F, -0.5833F, -5.0F, 4.0F, 2.0F, 7.0F, 0.0F, false);

		bottomJaw = new AnimatedModelRenderer(this);
		bottomJaw.setRotationPoint(0.0F, 1.4722F, -4.5833F);
		skull.addChild(bottomJaw);
		bottomJaw.setTextureOffset(0, 0).addBox(-1.5F, -1.0F, -5.5F, 3.0F, 2.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityLordOfTheWild entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		whole.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(AnimatedModelRenderer AnimatedModelRenderer, float x, float y, float z) {
		AnimatedModelRenderer.rotateAngleX = x;
		AnimatedModelRenderer.rotateAngleY = y;
		AnimatedModelRenderer.rotateAngleZ = z;
	}
}