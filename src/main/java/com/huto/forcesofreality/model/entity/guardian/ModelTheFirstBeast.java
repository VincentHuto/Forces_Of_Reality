package com.huto.forcesofreality.model.entity.guardian;

import com.huto.forcesofreality.entity.guardian.EntityTheFirstBeast;
import com.huto.forcesofreality.entity.passive.EntityDenizenSage;
import com.hutoslib.client.model.AnimatedEntityModel;
import com.hutoslib.client.model.AnimatedModelRenderer;
import com.hutoslib.client.model.ModelAnimator;
import com.hutoslib.client.ClientUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModelTheFirstBeast extends AnimatedEntityModel<EntityTheFirstBeast> implements IHasArm {
	private final AnimatedModelRenderer whole;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer upperBody;
	private final AnimatedModelRenderer mane;
	private final AnimatedModelRenderer bone;
	private final AnimatedModelRenderer mane1;
	private final AnimatedModelRenderer mane2;
	private final AnimatedModelRenderer mane3;
	private final AnimatedModelRenderer beard;
	private final AnimatedModelRenderer beard2;
	private final AnimatedModelRenderer beard3;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer skull;
	private final AnimatedModelRenderer hat;
	private final AnimatedModelRenderer hat2;
	private final AnimatedModelRenderer hat3;
	private final AnimatedModelRenderer rightEar;
	private final AnimatedModelRenderer leftEar;
	private final AnimatedModelRenderer topJaw;
	private final AnimatedModelRenderer bottomJaw;
	private final AnimatedModelRenderer rightArm;
	private final AnimatedModelRenderer rightFore;
	private final AnimatedModelRenderer knife;
	private final AnimatedModelRenderer leftArm;
	private final AnimatedModelRenderer leftFore;
	private final AnimatedModelRenderer abs;
	private final AnimatedModelRenderer cloth;
	private final AnimatedModelRenderer rightLeg;
	private final AnimatedModelRenderer rightFemur;
	private final AnimatedModelRenderer rightBoot;
	private final AnimatedModelRenderer leftLeg;
	private final AnimatedModelRenderer leftFemur;
	private final AnimatedModelRenderer leftBoot;
	public ArmPose leftArmPose = ArmPose.EMPTY;
	public ArmPose rightArmPose = ArmPose.EMPTY;
	public ModelAnimator animator;
	public final AnimatedModelRenderer[] headArray;

	public ModelTheFirstBeast() {
		textureWidth = 128;
		textureHeight = 128;

		whole = new AnimatedModelRenderer(this);
		whole.setRotationPoint(0.0F, -14.0F, 3.0F);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		whole.addChild(body);

		upperBody = new AnimatedModelRenderer(this);
		upperBody.setRotationPoint(0.0F, 5.0F, -3.0F);
		body.addChild(upperBody);
		upperBody.setTextureOffset(0, 16).addBox(-4.75F, -12.0F, -4.0F, 9.0F, 7.0F, 9.0F, 0.0F, false);
		upperBody.setTextureOffset(28, 52).addBox(-4.0F, 4.0F, -1.0F, 8.0F, 5.0F, 6.0F, 0.0F, false);
		upperBody.setTextureOffset(32, 40).addBox(-5.0F, -1.0F, -1.5F, 10.0F, 5.0F, 7.0F, 0.0F, false);
		upperBody.setTextureOffset(0, 0).addBox(-7.0F, -9.0F, -3.0F, 14.0F, 8.0F, 8.0F, 0.0F, false);

		mane = new AnimatedModelRenderer(this);
		mane.setRotationPoint(0.5F, 16.0F, 10.25F);
		upperBody.addChild(mane);
		mane.setTextureOffset(35, 7).addBox(-5.0F, -28.75F, -12.25F, 9.0F, 1.0F, 9.0F, 0.0F, false);
		mane.setTextureOffset(27, 27).addBox(-5.5F, -28.1F, -13.35F, 10.0F, 4.0F, 9.0F, 0.0F, false);
		mane.setTextureOffset(8, 19).addBox(-5.5F, -11.1F, -10.85F, 10.0F, 4.0F, 6.0F, 0.0F, false);
		mane.setTextureOffset(18, 23).addBox(-5.25F, -9.1F, -11.85F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		mane.setTextureOffset(18, 23).addBox(3.25F, -9.1F, -11.85F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		mane.setTextureOffset(36, 84).addBox(-6.5F, -27.0F, -12.25F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		mane.setTextureOffset(0, 82).addBox(4.5F, -27.0F, -12.25F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		mane.setTextureOffset(88, 71).addBox(-5.0F, -28.0F, -5.0F, 9.0F, 4.0F, 2.0F, 0.0F, false);
		mane.setTextureOffset(88, 71).addBox(-5.0F, -10.75F, -7.15F, 9.0F, 4.0F, 2.0F, 0.0F, false);
		mane.setTextureOffset(0, 48).addBox(-6.0F, -26.0F, -7.5F, 11.0F, 8.0F, 3.0F, 0.0F, false);

		bone = new AnimatedModelRenderer(this);
		bone.setRotationPoint(-0.49F, -29.4195F, -9.3763F);
		mane.addChild(bone);
		setRotationAngle(bone, 0.3927F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 59).addBox(-3.5F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F, 0.0F, false);

		mane1 = new AnimatedModelRenderer(this);
		mane1.setRotationPoint(-0.5F, -25.0F, -4.25F);
		mane.addChild(mane1);
		setRotationAngle(mane1, 0.1745F, 0.0F, 0.0F);
		mane1.setTextureOffset(86, 0).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 9.0F, 0.0F, 0.0F, false);
		mane1.setTextureOffset(86, 0).addBox(-13.0F, 0.0F, 0.0F, 8.0F, 9.0F, 0.0F, 0.0F, true);
		mane1.setTextureOffset(86, 0).addBox(5.0F, 0.0F, 0.0F, 8.0F, 9.0F, 0.0F, 0.0F, false);

		mane2 = new AnimatedModelRenderer(this);
		mane2.setRotationPoint(0.0F, 9.0F, -0.075F);
		mane1.addChild(mane2);
		setRotationAngle(mane2, -0.0436F, 0.0F, 0.0F);
		mane2.setTextureOffset(30, 95).addBox(-4.5F, -0.3666F, 0.0116F, 9.0F, 9.0F, 0.0F, 0.0F, false);
		mane2.setTextureOffset(35, 95).addBox(-8.5F, -0.3666F, 0.0116F, 4.0F, 9.0F, 0.0F, 0.0F, false);
		mane2.setTextureOffset(35, 95).addBox(4.5F, -0.3666F, 0.0116F, 4.0F, 9.0F, 0.0F, 0.0F, true);

		mane3 = new AnimatedModelRenderer(this);
		mane3.setRotationPoint(0.0F, 7.1054F, 0.2928F);
		mane2.addChild(mane3);
		setRotationAngle(mane3, 0.1309F, 0.0F, 0.0F);
		mane3.setTextureOffset(97, 9).addBox(-4.0F, 0.481F, -0.4358F, 8.0F, 9.0F, 0.0F, 0.0F, false);

		beard = new AnimatedModelRenderer(this);
		beard.setRotationPoint(-0.625F, -24.5F, -14.3F);
		mane.addChild(beard);
		beard.setTextureOffset(36, 0).addBox(-5.625F, -0.5F, -0.05F, 11.0F, 6.0F, 0.0F, 0.0F, false);

		beard2 = new AnimatedModelRenderer(this);
		beard2.setRotationPoint(0.0F, 5.5F, 0.0F);
		beard.addChild(beard2);
		setRotationAngle(beard2, 0.0873F, 0.0F, 0.0F);
		beard2.setTextureOffset(27, 21).addBox(-4.625F, -0.2481F, -0.0064F, 9.0F, 4.0F, 0.0F, 0.0F, false);

		beard3 = new AnimatedModelRenderer(this);
		beard3.setRotationPoint(-0.125F, 4.7519F, 0.2436F);
		beard2.addChild(beard3);
		setRotationAngle(beard3, 0.0873F, 0.0F, 0.0F);
		beard3.setTextureOffset(27, 17).addBox(-4.5F, -2.0F, 0.0F, 9.0F, 4.0F, 0.0F, 0.0F, false);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -13.0F, -3.0F);
		upperBody.addChild(head);

		skull = new AnimatedModelRenderer(this);
		skull.setRotationPoint(0.0F, 1.7778F, -2.6667F);
		head.addChild(skull);
		setRotationAngle(skull, 0.2618F, 0.0F, 0.0F);
		skull.setTextureOffset(0, 32).addBox(-4.0F, -5.7778F, -5.3333F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		skull.setTextureOffset(48, 55).addBox(-3.0F, -6.7778F, -4.3333F, 6.0F, 2.0F, 8.0F, 0.0F, false);
		skull.setTextureOffset(106, 0).addBox(-3.0F, -4.7778F, 2.1667F, 6.0F, 4.0F, 2.0F, 0.0F, false);
		skull.setTextureOffset(60, 35).addBox(-3.5F, -2.9652F, 1.3214F, 7.0F, 5.0F, 5.0F, 0.0F, false);

		hat = new AnimatedModelRenderer(this);
		hat.setRotationPoint(0.0F, -5.9423F, -2.1148F);
		skull.addChild(hat);
		setRotationAngle(hat, 0.1745F, 0.0F, 0.0F);
		hat.setTextureOffset(36, 17).addBox(-4.0F, -1.1238F, -2.3652F, 8.0F, 1.0F, 9.0F, 0.0F, false);
		hat.setTextureOffset(59, 45).addBox(-3.0F, -2.1238F, -2.3652F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(50, 52).addBox(-3.0F, -1.1238F, -3.3652F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(24, 32).addBox(-2.0F, -1.1238F, -5.3652F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		hat.setTextureOffset(58, 2).addBox(-2.0F, -2.1238F, -3.3652F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(58, 0).addBox(-2.0F, -3.1238F, -2.3652F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(0, 37).addBox(-1.0F, -1.1238F, -6.3652F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(36, 6).addBox(-1.0F, -2.1238F, -4.3652F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(0, 5).addBox(-1.0F, -3.1238F, -3.3652F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		hat.setTextureOffset(56, 27).addBox(-3.0F, -2.1238F, -1.3652F, 6.0F, 1.0F, 7.0F, 0.0F, false);
		hat.setTextureOffset(75, 21).addBox(-2.0F, -3.1238F, -1.3652F, 4.0F, 1.0F, 7.0F, 0.0F, false);

		hat2 = new AnimatedModelRenderer(this);
		hat2.setRotationPoint(3.5F, -2.6603F, 3.0128F);
		hat.addChild(hat2);
		setRotationAngle(hat2, 0.3491F, 0.0F, 0.4363F);
		hat2.setTextureOffset(10, 77).addBox(-0.3085F, -0.853F, -4.5057F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		hat2.setTextureOffset(28, 50).addBox(-0.3085F, -1.853F, 3.4943F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		hat2.setTextureOffset(50, 56).addBox(0.0531F, 1.4411F, 3.3595F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hat2.setTextureOffset(28, 54).addBox(-0.3085F, 0.147F, -5.5057F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		hat3 = new AnimatedModelRenderer(this);
		hat3.setRotationPoint(-3.5F, -2.6603F, 3.0128F);
		hat.addChild(hat3);
		setRotationAngle(hat3, 0.3491F, 0.0F, -0.4363F);
		hat3.setTextureOffset(50, 76).addBox(-0.6915F, -0.853F, -4.5057F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		hat3.setTextureOffset(32, 40).addBox(-0.6915F, -1.853F, 3.4943F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		hat3.setTextureOffset(50, 54).addBox(-1.0836F, 1.2199F, 3.2719F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hat3.setTextureOffset(25, 48).addBox(-0.6915F, 0.147F, -5.5057F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		rightEar = new AnimatedModelRenderer(this);
		rightEar.setRotationPoint(-4.75F, -4.5948F, 1.3289F);
		skull.addChild(rightEar);
		rightEar.setTextureOffset(110, 66).addBox(0.25F, -0.6667F, -3.3333F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		rightEar.setTextureOffset(0, 32).addBox(-0.75F, -1.1667F, -1.3333F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		rightEar.setTextureOffset(61, 21).addBox(-1.0F, -1.6667F, -0.3333F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		leftEar = new AnimatedModelRenderer(this);
		leftEar.setRotationPoint(4.75F, -4.5948F, 1.3289F);
		skull.addChild(leftEar);
		leftEar.setTextureOffset(36, 110).addBox(-1.25F, -0.6667F, -3.3333F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		leftEar.setTextureOffset(0, 0).addBox(-0.25F, -1.1667F, -1.3333F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		leftEar.setTextureOffset(19, 59).addBox(0.0F, -1.6667F, -0.3333F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		topJaw = new AnimatedModelRenderer(this);
		topJaw.setRotationPoint(0.0F, -0.6944F, -5.5833F);
		skull.addChild(topJaw);
		topJaw.setTextureOffset(56, 125).addBox(-1.25F, 1.076F, -0.8431F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		topJaw.setTextureOffset(94, 6).addBox(-1.25F, 1.3348F, 0.1228F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		topJaw.setTextureOffset(56, 125).addBox(-1.25F, 1.3001F, -1.9384F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		topJaw.setTextureOffset(56, 125).addBox(1.25F, 1.4122F, -2.4861F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		topJaw.setTextureOffset(56, 125).addBox(-1.25F, 1.3775F, -4.5474F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		topJaw.setTextureOffset(56, 125).addBox(1.25F, 1.3775F, -4.5474F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		topJaw.setTextureOffset(56, 125).addBox(1.25F, 0.9639F, -0.2954F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		topJaw.setTextureOffset(94, 6).addBox(1.25F, 1.3348F, 0.1228F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		topJaw.setTextureOffset(32, 44).addBox(-1.0F, -0.8333F, -5.75F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		topJaw.setTextureOffset(92, 28).addBox(-1.0F, -1.0833F, -4.75F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		topJaw.setTextureOffset(62, 55).addBox(1.0F, -3.0833F, -0.25F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		topJaw.setTextureOffset(75, 10).addBox(-2.0F, -0.5833F, -5.0F, 4.0F, 2.0F, 7.0F, 0.0F, false);

		bottomJaw = new AnimatedModelRenderer(this);
		bottomJaw.setRotationPoint(0.0F, 1.4722F, -4.5833F);
		skull.addChild(bottomJaw);
		bottomJaw.setTextureOffset(81, 40).addBox(-1.5F, -1.0F, -5.5F, 3.0F, 2.0F, 7.0F, 0.0F, false);
		bottomJaw.setTextureOffset(56, 125).addBox(-1.25F, -1.9319F, -4.9824F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(56, 125).addBox(-1.25F, -1.7204F, -3.2273F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(94, 6).addBox(-1.25F, -1.6857F, -1.166F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(56, 125).addBox(1.25F, -1.9319F, -4.9824F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(56, 125).addBox(1.25F, -1.7204F, -3.2273F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(94, 6).addBox(1.25F, -1.6857F, -1.166F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		rightArm = new AnimatedModelRenderer(this);
		rightArm.setRotationPoint(-6.5F, -7.75F, 1.75F);
		upperBody.addChild(rightArm);
		rightArm.setTextureOffset(90, 108).addBox(-4.5F, -2.5F, 2.35F, 4.0F, 6.0F, 1.0F, 0.0F, false);
		rightArm.setTextureOffset(0, 93).addBox(-5.0F, -3.0F, -2.65F, 1.0F, 6.0F, 5.0F, 0.0F, false);
		rightArm.setTextureOffset(71, 60).addBox(-4.0F, -3.0F, -2.65F, 4.0F, 6.0F, 5.0F, 0.0F, false);
		rightArm.setTextureOffset(110, 40).addBox(-4.5F, -2.5F, -3.65F, 4.0F, 6.0F, 1.0F, 0.0F, false);
		rightArm.setTextureOffset(18, 63).addBox(-4.0F, -1.0F, -3.15F, 4.0F, 8.0F, 6.0F, 0.0F, false);
		rightArm.setTextureOffset(68, 45).addBox(-3.25F, -1.5F, -2.75F, 4.0F, 8.0F, 5.0F, 0.0F, false);

		rightFore = new AnimatedModelRenderer(this);
		rightFore.setRotationPoint(-2.6667F, 6.7833F, 0.0167F);
		rightArm.addChild(rightFore);
		rightFore.setTextureOffset(79, 88).addBox(-0.8333F, -0.7833F, -1.5167F, 3.0F, 8.0F, 4.0F, 0.0F, false);
		rightFore.setTextureOffset(63, 83).addBox(-1.0833F, 6.9167F, -2.5667F, 3.0F, 8.0F, 5.0F, 0.0F, false);
		rightFore.setTextureOffset(110, 40).addBox(-1.8333F, 4.7167F, -3.6667F, 4.0F, 8.0F, 1.0F, 0.0F, false);
		rightFore.setTextureOffset(0, 93).addBox(-2.3333F, 4.2167F, -2.6667F, 1.0F, 8.0F, 5.0F, 0.0F, false);
		rightFore.setTextureOffset(71, 60).addBox(-1.3333F, 4.2167F, -2.6667F, 4.0F, 8.0F, 5.0F, 0.0F, false);
		rightFore.setTextureOffset(90, 108).addBox(-1.8333F, 4.7167F, 2.3333F, 4.0F, 8.0F, 1.0F, 0.0F, false);

		knife = new AnimatedModelRenderer(this);
		knife.setRotationPoint(0.4167F, 14.5167F, 0.2458F);
		rightFore.addChild(knife);
		knife.setTextureOffset(71, 117).addBox(-1.0F, -0.6F, -0.8125F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		knife.setTextureOffset(75, 121).addBox(-0.5F, -0.7F, -2.5625F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		knife.setTextureOffset(57, 119).addBox(0.0F, -0.6F, 4.1875F, 0.0F, 2.0F, 7.0F, 0.0F, false);
		knife.setTextureOffset(56, 124).addBox(0.0F, -2.1F, 11.1875F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		leftArm = new AnimatedModelRenderer(this);
		leftArm.setRotationPoint(7.0F, -7.375F, 0.75F);
		upperBody.addChild(leftArm);
		leftArm.setTextureOffset(38, 65).addBox(-0.5F, -1.375F, -2.15F, 4.0F, 8.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(14, 89).addBox(1.4F, -0.375F, -0.7F, 3.0F, 8.0F, 4.0F, 0.0F, false);
		leftArm.setTextureOffset(0, 69).addBox(-1.25F, -1.875F, -1.75F, 4.0F, 8.0F, 5.0F, 0.0F, false);

		leftFore = new AnimatedModelRenderer(this);
		leftFore.setRotationPoint(2.675F, 6.4083F, 1.0167F);
		leftArm.addChild(leftFore);
		leftFore.setTextureOffset(14, 89).addBox(-2.275F, -0.7833F, -1.5167F, 3.0F, 8.0F, 4.0F, 0.0F, false);
		leftFore.setTextureOffset(14, 89).addBox(-1.875F, -0.7833F, -1.4167F, 3.0F, 8.0F, 4.0F, 0.0F, false);
		leftFore.setTextureOffset(63, 86).addBox(-1.925F, 11.9167F, -2.5667F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		leftFore.setTextureOffset(25, 114).addBox(0.225F, 6.2167F, 1.3333F, 0.0F, 8.0F, 6.0F, 0.0F, false);
		leftFore.setTextureOffset(25, 114).addBox(-1.775F, 6.2167F, 1.3333F, 0.0F, 8.0F, 6.0F, 0.0F, false);
		leftFore.setTextureOffset(12, 0).addBox(-2.175F, 6.9167F, -2.5667F, 3.0F, 5.0F, 4.0F, 0.0F, false);

		abs = new AnimatedModelRenderer(this);
		abs.setRotationPoint(0.0F, 9.3F, -2.2F);
		body.addChild(abs);
		abs.setTextureOffset(62, 0).addBox(-3.0F, 4.7F, -1.8F, 6.0F, 4.0F, 6.0F, 0.0F, false);

		cloth = new AnimatedModelRenderer(this);
		cloth.setRotationPoint(0.0F, 3.7F, 0.2F);
		abs.addChild(cloth);
		cloth.setTextureOffset(93, 77).addBox(-4.5F, 1.0F, -2.1F, 9.0F, 9.0F, 0.0F, 0.0F, false);
		cloth.setTextureOffset(90, 19).addBox(-4.5F, 1.0F, 4.15F, 9.0F, 9.0F, 0.0F, 0.0F, false);

		rightLeg = new AnimatedModelRenderer(this);
		rightLeg.setRotationPoint(-2.9167F, 7.825F, 0.7833F);
		abs.addChild(rightLeg);
		rightLeg.setTextureOffset(45, 102).addBox(-3.5833F, 1.875F, -1.0833F, 4.0F, 7.0F, 3.0F, 0.0F, false);
		rightLeg.setTextureOffset(0, 106).addBox(-3.3333F, -2.375F, -1.5833F, 2.0F, 4.0F, 4.0F, 0.0F, false);
		rightLeg.setTextureOffset(79, 29).addBox(-3.0833F, -3.125F, -2.5833F, 3.0F, 5.0F, 6.0F, 0.0F, false);
		rightLeg.setTextureOffset(0, 16).addBox(-2.8333F, 1.875F, 1.4167F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		rightLeg.setTextureOffset(97, 46).addBox(-3.0833F, 1.875F, -1.5833F, 3.0F, 7.0F, 4.0F, 0.0F, false);

		rightFemur = new AnimatedModelRenderer(this);
		rightFemur.setRotationPoint(-1.7333F, 8.8F, -1.3958F);
		rightLeg.addChild(rightFemur);
		rightFemur.setTextureOffset(66, 96).addBox(-1.35F, 0.075F, 0.5625F, 3.0F, 7.0F, 4.0F, 0.0F, false);
		rightFemur.setTextureOffset(12, 101).addBox(-1.85F, 0.075F, 1.0625F, 4.0F, 7.0F, 3.0F, 0.0F, false);
		rightFemur.setTextureOffset(108, 18).addBox(-1.45F, -0.725F, -0.9375F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		rightBoot = new AnimatedModelRenderer(this);
		rightBoot.setRotationPoint(0.15F, 7.215F, 2.7125F);
		rightFemur.addChild(rightBoot);
		rightBoot.setTextureOffset(11, 0).addBox(-2.65F, -2.64F, -0.65F, 1.0F, 6.0F, 3.0F, 0.0F, false);
		rightBoot.setTextureOffset(50, 92).addBox(-2.1F, -1.14F, -1.9F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		rightBoot.setTextureOffset(60, 76).addBox(-1.5F, 1.91F, -4.15F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		rightBoot.setTextureOffset(76, 103).addBox(-1.5F, -0.09F, -1.15F, 3.0F, 5.0F, 4.0F, 0.0F, false);
		rightBoot.setTextureOffset(114, 43).addBox(-0.5F, 0.41F, 2.35F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rightBoot.setTextureOffset(62, 10).addBox(-1.0F, 3.16F, -7.15F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		rightBoot.setTextureOffset(11, 113).addBox(-0.5F, 4.26F, -8.15F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		rightBoot.setTextureOffset(89, 65).addBox(-0.5F, 2.16F, -6.15F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		rightBoot.setTextureOffset(32, 63).addBox(-0.5F, 1.16F, -5.15F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		leftLeg = new AnimatedModelRenderer(this);
		leftLeg.setRotationPoint(2.9167F, 7.825F, 0.7833F);
		abs.addChild(leftLeg);
		leftLeg.setTextureOffset(26, 104).addBox(-0.4167F, 1.875F, -1.0833F, 4.0F, 7.0F, 3.0F, 0.0F, false);
		leftLeg.setTextureOffset(98, 59).addBox(0.0833F, 1.875F, -1.5833F, 3.0F, 7.0F, 4.0F, 0.0F, false);
		leftLeg.setTextureOffset(111, 74).addBox(0.8333F, 1.875F, 1.4167F, 2.0F, 7.0F, 2.0F, 0.0F, false);
		leftLeg.setTextureOffset(84, 52).addBox(0.0833F, -3.125F, -2.5833F, 3.0F, 5.0F, 6.0F, 0.0F, false);
		leftLeg.setTextureOffset(59, 107).addBox(1.3333F, -2.375F, -1.5833F, 2.0F, 4.0F, 4.0F, 0.0F, false);

		leftFemur = new AnimatedModelRenderer(this);
		leftFemur.setRotationPoint(1.4333F, 9.3F, -0.3958F);
		leftLeg.addChild(leftFemur);
		leftFemur.setTextureOffset(108, 83).addBox(-1.45F, -1.225F, -1.9375F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		leftFemur.setTextureOffset(97, 86).addBox(-1.35F, -0.425F, -0.4375F, 3.0F, 7.0F, 4.0F, 0.0F, false);
		leftFemur.setTextureOffset(102, 102).addBox(-1.85F, -0.425F, 0.0625F, 4.0F, 7.0F, 3.0F, 0.0F, false);

		leftBoot = new AnimatedModelRenderer(this);
		leftBoot.setRotationPoint(0.15F, 6.715F, 0.7125F);
		leftFemur.addChild(leftBoot);
		leftBoot.setTextureOffset(94, 36).addBox(-1.9F, -1.14F, -0.9F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		leftBoot.setTextureOffset(11, 0).addBox(1.6F, -2.64F, 0.35F, 1.0F, 6.0F, 3.0F, 0.0F, false);
		leftBoot.setTextureOffset(114, 43).addBox(-0.5F, 0.41F, 3.35F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		leftBoot.setTextureOffset(106, 33).addBox(-1.5F, 1.91F, -3.15F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		leftBoot.setTextureOffset(104, 24).addBox(-1.5F, -0.09F, -0.15F, 3.0F, 5.0F, 4.0F, 0.0F, false);
		leftBoot.setTextureOffset(58, 65).addBox(-1.0F, 3.16F, -6.15F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		leftBoot.setTextureOffset(11, 113).addBox(-0.5F, 4.26F, -7.15F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		leftBoot.setTextureOffset(106, 92).addBox(-0.5F, 2.16F, -5.15F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		leftBoot.setTextureOffset(52, 65).addBox(-0.5F, 1.16F, -4.15F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		animator = ModelAnimator.create();
		headArray = new AnimatedModelRenderer[] { head };
		setDefaultPose();
	}

	@Override
	public void setLivingAnimations(EntityTheFirstBeast entityIn, float limbSwing, float limbSwingAmount,
			float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
		this.entity = entityIn;
		resetToDefaultPose();
		animator.update(entity, partialTick);
		if (animator.setAnimation(EntityTheFirstBeast.ARROW_ANIMATION)) {
			arrowAnim(partialTick);
		}
		idle(entity.ticksExisted + partialTick);
	}

	private void arrowAnim(float partialTick) {
		animator.startKeyframe(35);
		animator.rotate(leftArm, -(float) Math.toRadians(40), 0, 0);
		animator.rotate(leftFore, -(float) Math.toRadians(25), 0, 0);
		animator.endKeyframe();
		animator.resetKeyframe(10);

	}

	@Override
	public void idle(float frame) {
		// Mane
		this.mane1.rotateAngleX = (float) ((float) Math.abs(Math.sin((frame) * 0.3f) * 0.25f) + Math.toRadians(8d));
		this.mane2.rotateAngleX = (float) -Math.sin((frame) * 0.5f) * 0.15f;
		this.mane3.rotateAngleX = (float) -Math.abs(Math.sin((frame) * 0.7f) * 0.05f);
		// Beard
		this.beard.rotateAngleX = -(float) Math.abs(Math.sin((frame) * 0.3f) * 0.05f);
		this.beard2.rotateAngleX = (float) Math.sin((frame) * 0.5f) * 0.06f;
		this.beard3.rotateAngleX = (float) Math.sin((frame) * 0.7f) * 0.05f;

	}

	@Override
	public void setRotationAngles(EntityTheFirstBeast entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

		netHeadYaw = MathHelper.wrapDegrees(netHeadYaw);
		float frame = entity.ticksExisted + ClientUtils.getPartialTicks();
		faceTarget(netHeadYaw, headPitch, 1, headArray);

		// Head
		this.head.rotateAngleX = (float) (headPitch * ((float) Math.PI / 180F) + Math.toRadians(15d) * 0.75f);
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) * 0.75f;

		// Arms
		this.rightArm.rotateAngleX = (float) (Math.sin((frame) * 0.04f) * 0.0325)
				+ MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.5F * limbSwingAmount * 0.5F;
		if (entity.noActiveAnimation()) {
			this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.5F * limbSwingAmount * 0.5F;

			this.leftFore.rotateAngleX = -Math
					.abs(MathHelper.sin(limbSwing * 0.1662F + (float) Math.PI) * 1.4F * limbSwingAmount);
		}
		this.rightFore.rotateAngleX = -Math
				.abs(MathHelper.cos(limbSwing * 0.1662F + (float) Math.PI) * 1.4F * limbSwingAmount);

		this.rightArm.rotateAngleZ = -(float) Math.abs(((Math.cos((frame) * 0.04f) * 0.0525)));
		this.leftArm.rotateAngleZ = (float) -Math.abs(((Math.sin((frame) * 0.04f) * 0.0525)));

		this.rightEar.rotateAngleZ = -(float) Math.abs(((Math.cos((frame) * 0.14f) * 0.0525)));
		this.leftEar.rotateAngleZ = (float) -Math.abs(((Math.sin((frame) * 0.14f) * 0.0525)));

		this.topJaw.rotateAngleX = -limbSwingAmount * 0.33f;
		this.bottomJaw.rotateAngleX = limbSwingAmount * 0.33f;

		// Legs
		this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.9662F) * 2.4F * limbSwingAmount / 2;
		this.rightFemur.rotateAngleX = Math
				.abs(MathHelper.cos(limbSwing * 0.1662F + (float) Math.PI) * 1.4F * limbSwingAmount);
		this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.9662F + (float) Math.PI) * 2.4F * limbSwingAmount / 2;
		this.leftFemur.rotateAngleX = Math
				.abs(MathHelper.sin(limbSwing * 0.1662F + (float) Math.PI) * 1.4F * limbSwingAmount);

		boolean flag2 = entity.getPrimaryHand() == HandSide.RIGHT;
		boolean flag3 = flag2 ? this.leftArmPose.func_241657_a_() : this.rightArmPose.func_241657_a_();
		if (flag2 != flag3) {
			this.func_241655_c_(entity);
			this.func_241654_b_(entity);
		} else {
			this.func_241654_b_(entity);
			this.func_241655_c_(entity);
		}

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

	private void func_241654_b_(EntityTheFirstBeast entity) {
		switch (this.rightArmPose) {
		case EMPTY:
			this.rightFore.rotateAngleY = 0.0F;
			break;
		case BLOCK:
			this.rightFore.rotateAngleX = this.rightFore.rotateAngleX * 0.5F - 0.9424779F;
			this.rightFore.rotateAngleY = (-(float) Math.PI / 6F);
			break;
		case ITEM:
			this.rightFore.rotateAngleX = this.rightFore.rotateAngleX * 0.5F - ((float) Math.PI / 10F);
			this.rightFore.rotateAngleY = 0.0F;
			break;
		case THROW_SPEAR:
			this.rightFore.rotateAngleX = this.rightFore.rotateAngleX * 0.5F - (float) Math.PI;
			this.rightFore.rotateAngleY = 0.0F;
			break;
		case BOW_AND_ARROW:
			this.rightFore.rotateAngleY = -0.1F + this.head.rotateAngleY;
			this.leftFore.rotateAngleY = 0.1F + this.head.rotateAngleY + 0.4F;
			this.rightFore.rotateAngleX = (-(float) Math.PI / 2F) + this.head.rotateAngleX;
			this.leftFore.rotateAngleX = (-(float) Math.PI / 2F) + this.head.rotateAngleX;
			break;
		case CROSSBOW_CHARGE:
			ModelHelper.func_239102_a_(this.rightFore, this.leftFore, entity, true);
			break;
		case CROSSBOW_HOLD:
			ModelHelper.func_239104_a_(this.rightFore, this.leftFore, this.head, true);
		}

	}

	protected HandSide getMainHand(EntityDenizenSage entityIn) {
		HandSide handside = entityIn.getPrimaryHand();
		return entityIn.swingingHand == Hand.MAIN_HAND ? handside : handside.opposite();
	}

	private void func_241655_c_(EntityTheFirstBeast entity) {
		switch (this.leftArmPose) {
		case EMPTY:
			this.leftFore.rotateAngleY = 0.0F;
			break;
		case BLOCK:
			this.leftFore.rotateAngleX = this.leftFore.rotateAngleX * 0.5F - 0.9424779F;
			this.leftFore.rotateAngleY = ((float) Math.PI / 6F);
			break;
		case ITEM:
			this.leftFore.rotateAngleX = this.leftFore.rotateAngleX * 0.5F - ((float) Math.PI / 10F);
			this.leftFore.rotateAngleY = 0.0F;
			break;
		case THROW_SPEAR:
			this.leftFore.rotateAngleX = this.leftFore.rotateAngleX * 2.5F - (float) Math.PI;
			this.leftFore.rotateAngleY = 0.0F;
			break;
		case BOW_AND_ARROW:
			this.rightFore.rotateAngleY = -0.1F + this.head.rotateAngleY - 0.4F;
			this.leftFore.rotateAngleY = 0.1F + this.head.rotateAngleY;
			this.rightFore.rotateAngleX = (-(float) Math.PI / 2F) + this.head.rotateAngleX;
			this.leftFore.rotateAngleX = (-(float) Math.PI / 2F) + this.head.rotateAngleX;
			break;
		case CROSSBOW_CHARGE:
			func_239102_a_(this.rightFore, this.leftFore, entity, false);
			break;
		case CROSSBOW_HOLD:
			func_239104_a_(this.rightFore, this.leftFore, this.head, false);
		}
	}

	public static void func_239104_a_(AnimatedModelRenderer rightArm, AnimatedModelRenderer leftArm,
			AnimatedModelRenderer head, boolean leftHanded) {
		AnimatedModelRenderer AnimatedModelRenderer = leftHanded ? rightArm : leftArm;
		AnimatedModelRenderer modelrenderer1 = leftHanded ? leftArm : rightArm;
		AnimatedModelRenderer.rotateAngleY = (leftHanded ? -0.3F : 0.3F) + head.rotateAngleY;
		modelrenderer1.rotateAngleY = (leftHanded ? 0.6F : -0.6F) + head.rotateAngleY;
		AnimatedModelRenderer.rotateAngleX = (-(float) Math.PI / 2F) + head.rotateAngleX + 0.1F;
		modelrenderer1.rotateAngleX = -1.5F + head.rotateAngleX;
	}

	public static void func_239102_a_(AnimatedModelRenderer rightArm, AnimatedModelRenderer leftArm,
			LivingEntity entity, boolean leftHanded) {
		AnimatedModelRenderer AnimatedModelRenderer = leftHanded ? rightArm : leftArm;
		AnimatedModelRenderer modelrenderer1 = leftHanded ? leftArm : rightArm;
		AnimatedModelRenderer.rotateAngleY = leftHanded ? -0.8F : 0.8F;
		AnimatedModelRenderer.rotateAngleX = -0.97079635F;
		modelrenderer1.rotateAngleX = AnimatedModelRenderer.rotateAngleX;
		float f = (float) CrossbowItem.getChargeTime(entity.getActiveItemStack());
		float f1 = MathHelper.clamp((float) entity.getItemInUseMaxCount(), 0.0F, f);
		float f2 = f1 / f;
		modelrenderer1.rotateAngleY = MathHelper.lerp(f2, 0.4F, 0.85F) * (float) (leftHanded ? 1 : -1);
		modelrenderer1.rotateAngleX = MathHelper.lerp(f2, modelrenderer1.rotateAngleX, (-(float) Math.PI / 2F));
	}

	protected void func_230486_a_(EntityDenizenSage p_230486_1_, float p_230486_2_) {
		if (!(this.swingProgress <= 0.0F)) {
			HandSide handside = this.getMainHand(p_230486_1_);
			AnimatedModelRenderer AnimatedModelRenderer = this.getArmForSide(handside);
			float f = this.swingProgress;
			this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f) * ((float) Math.PI * 2F)) * 0.2F;
			if (handside == HandSide.LEFT) {
				this.body.rotateAngleY *= -1.0F;
			}

			this.rightFore.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
			this.rightFore.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
			this.leftFore.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
			this.leftFore.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
			this.rightFore.rotateAngleY += this.body.rotateAngleY;
			this.leftFore.rotateAngleY += this.body.rotateAngleY;
			this.leftFore.rotateAngleX += this.body.rotateAngleY;
			f = 1.0F - this.swingProgress;
			f = f * f;
			f = f * f;
			f = 1.0F - f;
			float f1 = MathHelper.sin(f * (float) Math.PI);
			float f2 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
			AnimatedModelRenderer.rotateAngleX = (float) ((double) AnimatedModelRenderer.rotateAngleX
					- ((double) f1 * 1.2D + (double) f2));
			AnimatedModelRenderer.rotateAngleY += this.body.rotateAngleY * 2.0F;
			AnimatedModelRenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
		}
	}

	protected float rotLerpRad(float angleIn, float maxAngleIn, float mulIn) {
		float f = (mulIn - maxAngleIn) % ((float) Math.PI * 2F);
		if (f < -(float) Math.PI) {
			f += ((float) Math.PI * 1F);
		}

		if (f >= (float) Math.PI) {
			f -= ((float) Math.PI * 1F);
		}

		return maxAngleIn + angleIn * f;
	}

	public void translateHand(HandSide sideIn, MatrixStack matrixStackIn) {
		switch (sideIn) {
		case LEFT:
			this.leftArm.translateRotate(matrixStackIn);
			this.getArmForSide(sideIn).translateRotate(matrixStackIn);
			break;
		case RIGHT:
			this.rightArm.translateRotate(matrixStackIn);
			this.getArmForSide(sideIn).translateRotate(matrixStackIn);
			break;
		default:
			break;

		}
	}

	protected AnimatedModelRenderer getArmForSide(HandSide side) {
		return side == HandSide.LEFT ? this.leftFore : this.rightFore;
	}

	public AnimatedModelRenderer getModelHead() {
		return this.head;
	}

	@OnlyIn(Dist.CLIENT)
	public static enum ArmPose {
		EMPTY(false), ITEM(false), BLOCK(false), BOW_AND_ARROW(true), THROW_SPEAR(false), CROSSBOW_CHARGE(true),
		CROSSBOW_HOLD(true);

		private final boolean field_241656_h_;

		private ArmPose(boolean p_i241257_3_) {
			this.field_241656_h_ = p_i241257_3_;
		}

		public boolean func_241657_a_() {
			return this.field_241656_h_;
		}
	}
}