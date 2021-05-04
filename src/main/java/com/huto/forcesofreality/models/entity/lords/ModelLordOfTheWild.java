package com.huto.forcesofreality.models.entity.lords;


import com.huto.forcesofreality.entities.lords.EntityLordOfTheWild;
import com.hutoslib.util.ClientUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;



public class ModelLordOfTheWild extends EntityModel<EntityLordOfTheWild> {
	private final ModelRenderer wholebody;
	private final ModelRenderer bLLeg;
	private final ModelRenderer bLTibia;
	private final ModelRenderer bLFoot;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer duClaw;
	private final ModelRenderer cube_r3;
	private final ModelRenderer nail;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer bLHip;
	private final ModelRenderer bLFemur;
	private final ModelRenderer bRLeg;
	private final ModelRenderer bRTibia;
	private final ModelRenderer bRFoot;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer duClaw2;
	private final ModelRenderer cube_r8;
	private final ModelRenderer nail2;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer bRHip;
	private final ModelRenderer bRFemur;
	private final ModelRenderer neck;
	private final ModelRenderer head;
	private final ModelRenderer centerMane;
	private final ModelRenderer mane;
	private final ModelRenderer mane2;
	private final ModelRenderer mane3;
	private final ModelRenderer mane4;
	private final ModelRenderer leftMane;
	private final ModelRenderer mane5;
	private final ModelRenderer mane6;
	private final ModelRenderer mane7;
	private final ModelRenderer mane8;
	private final ModelRenderer rightMane;
	private final ModelRenderer mane9;
	private final ModelRenderer mane10;
	private final ModelRenderer mane11;
	private final ModelRenderer mane12;
	private final ModelRenderer bottomJaw;
	private final ModelRenderer rightEye;
	private final ModelRenderer leftEye;
	private final ModelRenderer lTusk;
	private final ModelRenderer rTusk;
	private final ModelRenderer neck2;
	private final ModelRenderer body;
	private final ModelRenderer tail;
	private final ModelRenderer tail2;
	private final ModelRenderer cube_r11;
	private final ModelRenderer ribs;
	private final ModelRenderer bone;
	private final ModelRenderer bone4;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer fRLeg;
	private final ModelRenderer tibiaR;
	private final ModelRenderer fRFoot;
	private final ModelRenderer duClaw3;
	private final ModelRenderer cube_r12;
	private final ModelRenderer nail3;
	private final ModelRenderer pawR;
	private final ModelRenderer cube_r13;
	private final ModelRenderer hipR;
	private final ModelRenderer femurR;
	private final ModelRenderer fLLeg;
	private final ModelRenderer tibiaL;
	private final ModelRenderer fLFoot;
	private final ModelRenderer duClaw4;
	private final ModelRenderer cube_r14;
	private final ModelRenderer nail4;
	private final ModelRenderer pawL;
	private final ModelRenderer cube_r15;
	private final ModelRenderer hip4;
	private final ModelRenderer femur4;

	public ModelLordOfTheWild() {
		textureWidth = 256;
		textureHeight = 256;

		wholebody = new ModelRenderer(this);
		wholebody.setRotationPoint(0.0F, -1.0F, -3.0F);
		

		bLLeg = new ModelRenderer(this);
		bLLeg.setRotationPoint(6.0F, 2.0F, 15.0F);
		wholebody.addChild(bLLeg);
		

		bLTibia = new ModelRenderer(this);
		bLTibia.setRotationPoint(1.0F, 9.0F, 3.0F);
		bLLeg.addChild(bLTibia);
		bLTibia.setTextureOffset(10, 201).addBox(-1.0F, -1.1F, -1.6F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		bLTibia.setTextureOffset(72, 181).addBox(-0.5F, 0.9F, 0.4F, 2.0F, 10.0F, 1.0F, 0.0F, false);
		bLTibia.setTextureOffset(98, 201).addBox(-0.5F, 0.9F, 1.4F, 2.0F, 6.0F, 1.0F, 0.0F, false);

		bLFoot = new ModelRenderer(this);
		bLFoot.setRotationPoint(0.5F, 10.5F, 0.0F);
		bLTibia.addChild(bLFoot);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.1F, 0.9F, -0.7F);
		bLFoot.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.829F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 211).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 0.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.1F, 0.9F, -0.6F);
		bLFoot.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.829F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 193).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		duClaw = new ModelRenderer(this);
		duClaw.setRotationPoint(0.1F, 2.2426F, 6.9669F);
		bLFoot.addChild(duClaw);
		setRotationAngle(duClaw, -0.7854F, 0.0F, 0.0F);
		

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(1.0F, -4.2426F, -5.6669F);
		duClaw.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.1309F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(48, 216).addBox(-1.3F, 6.5F, 0.5273F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		nail = new ModelRenderer(this);
		nail.setRotationPoint(1.1F, 2.4F, 2.4F);
		bLFoot.addChild(nail);
		setRotationAngle(nail, 0.7854F, 0.0F, 0.0F);
		

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(1.0F, 0.0F, -1.0F);
		nail.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -0.0873F, 0.0F);
		cube_r4.setTextureOffset(54, 216).addBox(-3.224F, -3.9426F, -3.3224F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(1.0F, 0.0F, -1.0F);
		nail.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0873F, 0.0F);
		cube_r5.setTextureOffset(60, 216).addBox(-1.6405F, -3.8719F, -3.6411F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bLHip = new ModelRenderer(this);
		bLHip.setRotationPoint(1.5F, -0.1F, 8.4F);
		bLLeg.addChild(bLHip);
		bLHip.setTextureOffset(98, 125).addBox(-1.0F, -5.0F, -12.0F, 2.0F, 10.0F, 7.0F, 0.0F, false);

		bLFemur = new ModelRenderer(this);
		bLFemur.setRotationPoint(0.0F, 7.0F, 1.0F);
		bLHip.addChild(bLFemur);
		bLFemur.setTextureOffset(52, 156).addBox(-1.0F, -8.0F, -6.0F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		bRLeg = new ModelRenderer(this);
		bRLeg.setRotationPoint(-6.0F, 2.0F, 15.0F);
		wholebody.addChild(bRLeg);
		

		bRTibia = new ModelRenderer(this);
		bRTibia.setRotationPoint(-1.0F, 9.0F, 3.0F);
		bRLeg.addChild(bRTibia);
		bRTibia.setTextureOffset(0, 201).addBox(-2.0F, -1.1F, -1.6F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		bRTibia.setTextureOffset(66, 181).addBox(-1.5F, 0.9F, 0.4F, 2.0F, 10.0F, 1.0F, 0.0F, false);
		bRTibia.setTextureOffset(92, 201).addBox(-1.5F, 0.9F, 1.4F, 2.0F, 6.0F, 1.0F, 0.0F, false);

		bRFoot = new ModelRenderer(this);
		bRFoot.setRotationPoint(-0.5F, 10.5F, 0.0F);
		bRTibia.addChild(bRFoot);
		

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-0.1F, 0.9F, -0.7F);
		bRFoot.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.829F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(0, 208).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 0.0F, 3.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-0.1F, 0.9F, -0.6F);
		bRFoot.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.829F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(54, 181).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		duClaw2 = new ModelRenderer(this);
		duClaw2.setRotationPoint(-0.1F, 2.2426F, 6.9669F);
		bRFoot.addChild(duClaw2);
		setRotationAngle(duClaw2, -0.7854F, 0.0F, 0.0F);
		

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(1.0F, -4.2426F, -5.6669F);
		duClaw2.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.1309F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(42, 216).addBox(-1.7F, 6.5F, 0.5218F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		nail2 = new ModelRenderer(this);
		nail2.setRotationPoint(0.9F, 2.4F, 2.4F);
		bRFoot.addChild(nail2);
		setRotationAngle(nail2, 0.7854F, 0.0F, 0.0F);
		

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(1.0F, 0.0F, -1.0F);
		nail2.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -0.0873F, 0.0F);
		cube_r9.setTextureOffset(30, 216).addBox(-3.224F, -3.9426F, -3.3224F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(1.0F, 0.0F, -1.0F);
		nail2.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0873F, 0.0F);
		cube_r10.setTextureOffset(36, 216).addBox(-1.6405F, -3.8719F, -3.6411F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		bRHip = new ModelRenderer(this);
		bRHip.setRotationPoint(-0.5F, -0.1F, -0.6F);
		bRLeg.addChild(bRHip);
		bRHip.setTextureOffset(80, 125).addBox(-2.0F, -5.0F, -3.0F, 2.0F, 10.0F, 7.0F, 0.0F, false);

		bRFemur = new ModelRenderer(this);
		bRFemur.setRotationPoint(0.0F, 7.0F, 10.0F);
		bRHip.addChild(bRFemur);
		bRFemur.setTextureOffset(40, 156).addBox(-3.0F, -8.0F, -6.0F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(-1.0F, -4.1F, -17.6F);
		wholebody.addChild(neck);
		setRotationAngle(neck, 0.6545F, 0.0F, 0.0F);
		neck.setTextureOffset(84, 66).addBox(-2.5F, -5.0F, -2.0F, 7.0F, 10.0F, 6.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.9593F, -7.3562F, 1.0022F);
		neck.addChild(head);
		head.setTextureOffset(0, 0).addBox(-3.4593F, -5.3659F, -14.4158F, 7.0F, 4.0F, 16.0F, 0.0F, false);
		head.setTextureOffset(74, 170).addBox(-1.4593F, -4.2894F, -15.4574F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(94, 216).addBox(-2.4693F, -1.4531F, -14.2807F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(96, 216).addBox(2.5417F, -1.4531F, -14.2807F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(82, 216).addBox(-2.4693F, -1.8223F, -11.4765F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(84, 216).addBox(2.5417F, -1.8223F, -11.4765F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(40, 22).addBox(-3.4593F, -8.3217F, -6.372F, 7.0F, 3.0F, 10.0F, 0.0F, false);
		head.setTextureOffset(72, 44).addBox(-2.4593F, -10.7018F, -4.5457F, 5.0F, 3.0F, 10.0F, 0.0F, false);
		head.setTextureOffset(26, 66).addBox(-2.4593F, -7.1921F, -12.7738F, 5.0F, 2.0F, 10.0F, 0.0F, false);
		head.setTextureOffset(20, 162).addBox(3.5407F, -9.1371F, -1.7741F, 7.0F, 3.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(20, 156).addBox(-10.4593F, -9.1371F, -1.7741F, 7.0F, 3.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(20, 156).addBox(-9.4593F, -9.9305F, -1.1654F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(20, 156).addBox(4.5407F, -9.9305F, -1.1654F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(0, 162).addBox(-16.4593F, -9.5063F, 1.0301F, 7.0F, 3.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(0, 162).addBox(-15.4593F, -9.9084F, 1.8455F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 162).addBox(9.5407F, -9.9084F, 1.8455F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 170).addBox(-21.4593F, -10.8864F, 2.8564F, 7.0F, 2.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(64, 161).addBox(-17.4593F, -11.6247F, 8.4648F, 7.0F, 2.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(6, 160).addBox(-18.4593F, -11.6247F, 9.4648F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(64, 161).addBox(-16.4593F, -12.4181F, 9.0736F, 5.0F, 2.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(64, 161).addBox(11.2407F, -13.5877F, 8.2064F, 5.0F, 2.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(0, 156).addBox(9.5407F, -9.5063F, 1.0301F, 7.0F, 3.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(78, 142).addBox(8.0407F, -10.4843F, 3.041F, 3.0F, 3.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(60, 142).addBox(-11.4593F, -10.4843F, 3.041F, 3.0F, 3.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(3, 159).addBox(-8.4593F, -10.4843F, 4.041F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(3, 159).addBox(7.0407F, -10.4843F, 4.041F, 1.0F, 3.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(0, 175).addBox(14.5407F, -10.8864F, 2.8564F, 7.0F, 2.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(6, 171).addBox(21.5407F, -10.8864F, 3.8564F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(6, 171).addBox(-22.4593F, -10.8864F, 3.8564F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 175).addBox(15.5407F, -11.6797F, 3.4651F, 5.0F, 2.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(0, 175).addBox(-20.4593F, -11.6797F, 3.4651F, 5.0F, 2.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(64, 156).addBox(10.0407F, -12.2335F, 7.6715F, 7.0F, 2.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(3, 162).addBox(17.0407F, -12.2335F, 8.6715F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		centerMane = new ModelRenderer(this);
		centerMane.setRotationPoint(0.0407F, -6.1205F, 4.1817F);
		head.addChild(centerMane);
		

		mane = new ModelRenderer(this);
		mane.setRotationPoint(0.0F, -1.255F, -1.3474F);
		centerMane.addChild(mane);
		setRotationAngle(mane, -0.3927F, 0.0F, 0.0F);
		mane.setTextureOffset(0, 97).addBox(-1.5F, -1.1779F, 0.3711F, 3.0F, 3.0F, 10.0F, 0.0F, false);
		mane.setTextureOffset(0, 142).addBox(0.201F, 1.8221F, 0.3711F, 0.0F, 3.0F, 10.0F, 0.0F, false);

		mane2 = new ModelRenderer(this);
		mane2.setRotationPoint(0.0F, 0.6747F, 9.947F);
		mane.addChild(mane2);
		setRotationAngle(mane2, -0.5236F, 0.0F, 0.0F);
		mane2.setTextureOffset(48, 112).addBox(-1.0F, -1.9241F, -0.5495F, 2.0F, 3.0F, 10.0F, 0.0F, false);
		mane2.setTextureOffset(20, 142).addBox(0.2F, 1.0759F, -0.5495F, 0.0F, 3.0F, 10.0F, 0.0F, false);

		mane3 = new ModelRenderer(this);
		mane3.setRotationPoint(0.0F, 2.2946F, 8.9621F);
		mane2.addChild(mane3);
		setRotationAngle(mane3, 0.3927F, 0.0F, 0.0F);
		mane3.setTextureOffset(58, 125).addBox(-0.4F, -3.5035F, -0.3238F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		mane3.setTextureOffset(50, 97).addBox(0.101F, -0.5035F, -1.3238F, 0.0F, 2.0F, 12.0F, 0.0F, false);

		mane4 = new ModelRenderer(this);
		mane4.setRotationPoint(-0.4F, -0.3934F, 9.4501F);
		mane3.addChild(mane4);
		setRotationAngle(mane4, -0.48F, 0.0F, 0.0F);
		mane4.setTextureOffset(40, 142).addBox(0.5F, -2.6377F, -1.1033F, 0.0F, 3.0F, 10.0F, 0.0F, false);

		leftMane = new ModelRenderer(this);
		leftMane.setRotationPoint(0.0407F, -6.1205F, 4.1817F);
		head.addChild(leftMane);
		setRotationAngle(leftMane, 0.3927F, 0.3054F, 0.0F);
		

		mane5 = new ModelRenderer(this);
		mane5.setRotationPoint(0.0F, -1.255F, -1.3474F);
		leftMane.addChild(mane5);
		setRotationAngle(mane5, -0.3927F, 0.0F, 0.0F);
		mane5.setTextureOffset(0, 97).addBox(-1.5F, -1.1779F, 0.3711F, 3.0F, 3.0F, 10.0F, 0.0F, false);
		mane5.setTextureOffset(0, 142).addBox(0.201F, 1.8221F, 0.3711F, 0.0F, 3.0F, 10.0F, 0.0F, false);

		mane6 = new ModelRenderer(this);
		mane6.setRotationPoint(0.0F, 0.6747F, 9.947F);
		mane5.addChild(mane6);
		setRotationAngle(mane6, -0.5236F, 0.0F, 0.0F);
		mane6.setTextureOffset(48, 112).addBox(-1.0F, -1.9241F, -0.5495F, 2.0F, 3.0F, 10.0F, 0.0F, false);
		mane6.setTextureOffset(20, 142).addBox(0.2F, 1.0759F, -0.5495F, 0.0F, 3.0F, 10.0F, 0.0F, false);

		mane7 = new ModelRenderer(this);
		mane7.setRotationPoint(0.0F, 2.2946F, 8.9621F);
		mane6.addChild(mane7);
		setRotationAngle(mane7, 0.3927F, 0.0F, 0.0F);
		mane7.setTextureOffset(58, 125).addBox(-0.4F, -3.5035F, -0.3238F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		mane7.setTextureOffset(50, 97).addBox(0.101F, -0.5035F, -1.3238F, 0.0F, 2.0F, 12.0F, 0.0F, false);

		mane8 = new ModelRenderer(this);
		mane8.setRotationPoint(-0.4F, -0.3934F, 9.4501F);
		mane7.addChild(mane8);
		setRotationAngle(mane8, -0.48F, 0.0F, 0.0F);
		mane8.setTextureOffset(40, 142).addBox(0.5F, -2.6377F, -1.1033F, 0.0F, 3.0F, 10.0F, 0.0F, false);

		rightMane = new ModelRenderer(this);
		rightMane.setRotationPoint(0.0407F, -6.1205F, 4.1817F);
		head.addChild(rightMane);
		setRotationAngle(rightMane, 0.3927F, -0.3054F, 0.0F);
		

		mane9 = new ModelRenderer(this);
		mane9.setRotationPoint(0.0F, -1.255F, -1.3474F);
		rightMane.addChild(mane9);
		setRotationAngle(mane9, -0.3927F, 0.0F, 0.0F);
		mane9.setTextureOffset(0, 97).addBox(-1.5F, -1.1779F, 0.3711F, 3.0F, 3.0F, 10.0F, 0.0F, false);
		mane9.setTextureOffset(0, 142).addBox(0.201F, 1.8221F, 0.3711F, 0.0F, 3.0F, 10.0F, 0.0F, false);

		mane10 = new ModelRenderer(this);
		mane10.setRotationPoint(0.0F, 0.6747F, 9.947F);
		mane9.addChild(mane10);
		setRotationAngle(mane10, -0.5236F, 0.0F, 0.0F);
		mane10.setTextureOffset(48, 112).addBox(-1.0F, -1.9241F, -0.5495F, 2.0F, 3.0F, 10.0F, 0.0F, false);
		mane10.setTextureOffset(20, 142).addBox(0.2F, 1.0759F, -0.5495F, 0.0F, 3.0F, 10.0F, 0.0F, false);

		mane11 = new ModelRenderer(this);
		mane11.setRotationPoint(0.0F, 2.2946F, 8.9621F);
		mane10.addChild(mane11);
		setRotationAngle(mane11, 0.3927F, 0.0F, 0.0F);
		mane11.setTextureOffset(58, 125).addBox(-0.4F, -3.5035F, -0.3238F, 1.0F, 3.0F, 10.0F, 0.0F, false);
		mane11.setTextureOffset(50, 97).addBox(0.101F, -0.5035F, -1.3238F, 0.0F, 2.0F, 12.0F, 0.0F, false);

		mane12 = new ModelRenderer(this);
		mane12.setRotationPoint(-0.4F, -0.3934F, 9.4501F);
		mane11.addChild(mane12);
		setRotationAngle(mane12, -0.48F, 0.0F, 0.0F);
		mane12.setTextureOffset(40, 142).addBox(0.5F, -2.6377F, -1.1033F, 0.0F, 3.0F, 10.0F, 0.0F, false);

		bottomJaw = new ModelRenderer(this);
		bottomJaw.setRotationPoint(0.0407F, -0.398F, -4.7535F);
		head.addChild(bottomJaw);
		bottomJaw.setTextureOffset(106, 82).addBox(-2.5F, -0.9462F, -8.7063F, 5.0F, 3.0F, 9.0F, 0.0F, false);
		bottomJaw.setTextureOffset(88, 216).addBox(-2.499F, -2.9462F, -8.7063F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(86, 216).addBox(2.501F, -2.9462F, -8.7063F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(108, 216).addBox(-2.5F, -1.9462F, -0.7063F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(102, 216).addBox(2.5F, -1.9462F, -0.7063F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(106, 216).addBox(-2.499F, -1.8944F, -3.2671F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(100, 216).addBox(2.501F, -1.8944F, -3.2671F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(104, 216).addBox(-2.499F, -1.8795F, -5.5474F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(98, 216).addBox(2.501F, -1.8795F, -5.5474F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bottomJaw.setTextureOffset(80, 193).addBox(-1.5F, -0.9364F, -9.9069F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		rightEye = new ModelRenderer(this);
		rightEye.setRotationPoint(-3.4093F, -6.3587F, -4.5971F);
		head.addChild(rightEye);
		rightEye.setTextureOffset(60, 201).addBox(-0.45F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		rightEye.setTextureOffset(78, 216).addBox(-0.55F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		leftEye = new ModelRenderer(this);
		leftEye.setRotationPoint(3.4907F, -6.3587F, -4.5971F);
		head.addChild(leftEye);
		leftEye.setTextureOffset(52, 201).addBox(-0.55F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		leftEye.setTextureOffset(74, 216).addBox(-0.45F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		lTusk = new ModelRenderer(this);
		lTusk.setRotationPoint(-0.9593F, 9.7362F, -2.8285F);
		head.addChild(lTusk);
		lTusk.setTextureOffset(24, 112).addBox(5.0F, -10.1783F, -6.4413F, 2.0F, 3.0F, 10.0F, 0.0F, false);
		lTusk.setTextureOffset(70, 193).addBox(5.0F, -11.0816F, -8.8319F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		lTusk.setTextureOffset(24, 165).addBox(5.5F, -11.0317F, -9.7525F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		lTusk.setTextureOffset(2, 171).addBox(7.0F, -9.575F, -5.1369F, 1.0F, 2.0F, 7.0F, 0.0F, false);
		lTusk.setTextureOffset(28, 187).addBox(4.5F, -13.0803F, 0.3906F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		lTusk.setTextureOffset(12, 174).addBox(7.5F, -12.0803F, 1.3906F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		lTusk.setTextureOffset(20, 201).addBox(5.5F, -11.254F, 2.7707F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		rTusk = new ModelRenderer(this);
		rTusk.setRotationPoint(-10.9593F, 9.7362F, -2.8285F);
		head.addChild(rTusk);
		rTusk.setTextureOffset(24, 165).addBox(5.5F, -11.0317F, -9.7525F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		rTusk.setTextureOffset(0, 112).addBox(5.0F, -10.1783F, -6.4413F, 2.0F, 3.0F, 10.0F, 0.0F, false);
		rTusk.setTextureOffset(12, 174).addBox(3.5F, -12.0803F, 1.3906F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		rTusk.setTextureOffset(2, 171).addBox(4.0F, -9.575F, -5.1369F, 1.0F, 2.0F, 7.0F, 0.0F, false);
		rTusk.setTextureOffset(60, 193).addBox(5.0F, -11.0816F, -8.8319F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		rTusk.setTextureOffset(28, 181).addBox(4.5F, -13.0803F, 0.3906F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		rTusk.setTextureOffset(28, 201).addBox(5.5F, -11.254F, 2.7707F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		neck2 = new ModelRenderer(this);
		neck2.setRotationPoint(0.6F, -8.345F, -1.2783F);
		neck.addChild(neck2);
		setRotationAngle(neck2, 0.4363F, 0.0F, 0.0F);
		neck2.setTextureOffset(96, 112).addBox(-2.6F, -1.7377F, -2.6298F, 6.0F, 7.0F, 6.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(-1.0F, 8.4F, -2.1F);
		wholebody.addChild(body);
		body.setTextureOffset(88, 0).addBox(-3.5F, -12.5F, -13.5F, 9.0F, 10.0F, 12.0F, 0.0F, false);
		body.setTextureOffset(0, 125).addBox(-3.5F, -12.5F, -15.5F, 9.0F, 12.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(22, 181).addBox(5.5F, -12.5F, -15.3F, 3.0F, 12.0F, 0.0F, 0.0F, false);
		body.setTextureOffset(70, 216).addBox(5.5F, -0.5F, -15.3F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		body.setTextureOffset(66, 216).addBox(-5.5F, -0.5F, -15.3F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		body.setTextureOffset(16, 181).addBox(-6.5F, -12.5F, -15.3F, 3.0F, 12.0F, 0.0F, 0.0F, false);
		body.setTextureOffset(44, 170).addBox(-3.5F, -0.5F, -15.3F, 9.0F, 3.0F, 0.0F, 0.0F, false);
		body.setTextureOffset(62, 170).addBox(-1.5F, -12.5F, -16.5F, 5.0F, 8.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(42, 208).addBox(-1.5F, -4.5F, -16.1F, 5.0F, 2.0F, 0.0F, 0.0F, false);
		body.setTextureOffset(10, 220).addBox(-2.5F, -4.5F, -16.1F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		body.setTextureOffset(10, 219).addBox(3.5F, -4.5F, -16.1F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		body.setTextureOffset(56, 208).addBox(3.5F, -12.5F, -16.1F, 2.0F, 8.0F, 0.0F, 0.0F, false);
		body.setTextureOffset(52, 208).addBox(-3.5F, -12.5F, -16.1F, 2.0F, 8.0F, 0.0F, 0.0F, false);
		body.setTextureOffset(0, 66).addBox(0.5F, -16.5F, -13.5F, 1.0F, 4.0F, 12.0F, 0.0F, false);
		body.setTextureOffset(52, 82).addBox(-2.6F, -15.5F, -13.5F, 1.0F, 3.0F, 12.0F, 0.0F, false);
		body.setTextureOffset(0, 82).addBox(3.6F, -15.5F, -13.5F, 1.0F, 3.0F, 12.0F, 0.0F, false);
		body.setTextureOffset(26, 97).addBox(0.5F, -16.5F, 10.5F, 1.0F, 4.0F, 11.0F, 0.0F, false);
		body.setTextureOffset(98, 97).addBox(-2.5F, -15.5F, 10.5F, 1.0F, 3.0F, 11.0F, 0.0F, false);
		body.setTextureOffset(74, 97).addBox(3.5F, -15.5F, 10.5F, 1.0F, 3.0F, 11.0F, 0.0F, false);
		body.setTextureOffset(102, 44).addBox(0.5F, -16.1F, -1.5F, 1.0F, 4.0F, 12.0F, 0.0F, false);
		body.setTextureOffset(26, 82).addBox(-2.2F, -15.1F, -1.5F, 1.0F, 3.0F, 12.0F, 0.0F, false);
		body.setTextureOffset(110, 66).addBox(2.7F, -15.1F, -1.5F, 1.0F, 3.0F, 12.0F, 0.0F, false);
		body.setTextureOffset(0, 22).addBox(-3.5F, -12.5F, 10.5F, 9.0F, 10.0F, 11.0F, 0.0F, false);
		body.setTextureOffset(46, 0).addBox(-3.5F, -12.1F, -1.5F, 9.0F, 10.0F, 12.0F, 0.0F, false);
		body.setTextureOffset(48, 44).addBox(5.5F, -12.5F, -13.5F, 2.0F, 12.0F, 10.0F, 0.0F, false);
		body.setTextureOffset(0, 44).addBox(5.5F, -12.5F, 12.5F, 2.0F, 12.0F, 10.0F, 0.0F, false);
		body.setTextureOffset(24, 44).addBox(-5.5F, -12.5F, -13.5F, 2.0F, 12.0F, 10.0F, 0.0F, false);
		body.setTextureOffset(104, 22).addBox(-5.5F, -12.5F, 12.5F, 2.0F, 12.0F, 10.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.8F, -11.5F, 21.0F);
		body.addChild(tail);
		setRotationAngle(tail, -0.7418F, 0.0F, 0.0F);
		tail.setTextureOffset(78, 82).addBox(-1.3F, -1.5616F, -0.1129F, 3.0F, 2.0F, 11.0F, 0.0F, false);
		tail.setTextureOffset(72, 112).addBox(-0.3F, -3.5458F, -0.1678F, 1.0F, 2.0F, 11.0F, 0.0F, false);

		tail2 = new ModelRenderer(this);
		tail2.setRotationPoint(0.2F, -5.079F, 0.7748F);
		tail.addChild(tail2);
		

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-0.5F, 1.3829F, -0.4081F);
		tail2.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.2182F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(74, 22).addBox(0.0F, 2.9949F, 9.175F, 1.0F, 2.0F, 14.0F, 0.0F, false);
		cube_r11.setTextureOffset(56, 66).addBox(-0.5F, 4.3609F, 8.809F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		ribs = new ModelRenderer(this);
		ribs.setRotationPoint(-6.3F, 2.4F, -6.0F);
		body.addChild(ribs);
		

		bone = new ModelRenderer(this);
		bone.setRotationPoint(1.5F, 0.0F, 0.0F);
		ribs.addChild(bone);
		bone.setTextureOffset(52, 193).addBox(1.5F, -5.5F, -0.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(34, 212).addBox(3.5F, -0.8F, -0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(1.5F, 0.0F, 2.9F);
		ribs.addChild(bone4);
		bone4.setTextureOffset(44, 201).addBox(1.5F, -5.5F, -0.5F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		bone4.setTextureOffset(26, 208).addBox(3.5F, -1.5F, -0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(1.3F, 0.0F, -3.0F);
		ribs.addChild(bone2);
		bone2.setTextureOffset(44, 193).addBox(1.5F, -5.5F, -0.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(34, 208).addBox(3.5F, -0.5F, -0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.8F, 0.0F, -6.0F);
		ribs.addChild(bone3);
		bone3.setTextureOffset(20, 193).addBox(1.5F, -6.0F, -0.5F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		bone3.setTextureOffset(26, 212).addBox(3.5F, 0.0F, -0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(6.8F, -5.0F, -6.0F);
		ribs.addChild(bone5);
		bone5.setTextureOffset(12, 193).addBox(3.5F, -1.0F, -0.5F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		bone5.setTextureOffset(10, 208).addBox(1.5F, 5.0F, -0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(6.3F, -5.0F, -3.0F);
		ribs.addChild(bone6);
		bone6.setTextureOffset(36, 193).addBox(3.5F, -0.5F, -0.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bone6.setTextureOffset(18, 212).addBox(1.5F, 4.5F, -0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(6.3F, -5.0F, 0.0F);
		ribs.addChild(bone7);
		bone7.setTextureOffset(28, 193).addBox(3.5F, -0.5F, -0.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		bone7.setTextureOffset(18, 208).addBox(1.5F, 4.2F, -0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(6.3F, -5.0F, 3.1F);
		ribs.addChild(bone8);
		bone8.setTextureOffset(36, 201).addBox(3.3F, -0.5F, -0.5F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		bone8.setTextureOffset(10, 212).addBox(1.3F, 3.5F, -0.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		fRLeg = new ModelRenderer(this);
		fRLeg.setRotationPoint(-6.0F, 1.0F, -11.0F);
		wholebody.addChild(fRLeg);
		

		tibiaR = new ModelRenderer(this);
		tibiaR.setRotationPoint(-4.0F, 11.0F, -3.0F);
		fRLeg.addChild(tibiaR);
		tibiaR.setTextureOffset(100, 193).addBox(-1.0F, -2.1F, -1.6F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		tibiaR.setTextureOffset(8, 181).addBox(-1.0F, -0.1F, 0.4F, 3.0F, 10.0F, 1.0F, 0.0F, false);
		tibiaR.setTextureOffset(86, 201).addBox(-0.5F, -0.1F, 1.4F, 2.0F, 6.0F, 1.0F, 0.0F, false);

		fRFoot = new ModelRenderer(this);
		fRFoot.setRotationPoint(2.5F, 9.575F, 13.05F);
		tibiaR.addChild(fRFoot);
		

		duClaw3 = new ModelRenderer(this);
		duClaw3.setRotationPoint(0.0F, 2.1676F, 0.9169F);
		fRFoot.addChild(duClaw3);
		setRotationAngle(duClaw3, -0.7854F, 0.0F, 0.0F);
		

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(1.0F, -4.2426F, -5.6669F);
		duClaw3.addChild(cube_r12);
		setRotationAngle(cube_r12, -0.1309F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(24, 216).addBox(-3.7F, 10.7566F, -5.2654F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		nail3 = new ModelRenderer(this);
		nail3.setRotationPoint(1.0F, 2.325F, -3.65F);
		fRFoot.addChild(nail3);
		setRotationAngle(nail3, 0.7854F, 0.0F, 0.0F);
		

		pawR = new ModelRenderer(this);
		pawR.setRotationPoint(-1.5F, 4.0F, -8.0F);
		fRFoot.addChild(pawR);
		pawR.setTextureOffset(18, 216).addBox(-2.6F, -1.0F, -8.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		pawR.setTextureOffset(8, 219).addBox(-2.1F, -1.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		pawR.setTextureOffset(68, 203).addBox(-2.6F, -1.0F, -6.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		pawR.setTextureOffset(40, 185).addBox(-2.6F, -2.0F, -7.5F, 4.0F, 1.0F, 3.0F, 0.0F, false);
		pawR.setTextureOffset(12, 216).addBox(-1.1F, -1.0F, -8.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		pawR.setTextureOffset(6, 219).addBox(-0.5F, -1.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		pawR.setTextureOffset(6, 216).addBox(0.3F, -1.0F, -8.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		pawR.setTextureOffset(4, 219).addBox(0.8F, -1.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		pawR.setTextureOffset(90, 216).addBox(2.0F, -1.0F, -7.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-1.1F, -3.175F, -5.65F);
		pawR.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.829F, 0.0F, 0.0F);
		cube_r13.setTextureOffset(102, 170).addBox(-1.0F, -0.5F, -2.0F, 3.0F, 2.0F, 4.0F, 0.0F, false);

		hipR = new ModelRenderer(this);
		hipR.setRotationPoint(-0.5F, 0.9F, 0.4F);
		fRLeg.addChild(hipR);
		hipR.setTextureOffset(40, 125).addBox(-2.0F, -5.0F, -3.0F, 2.0F, 10.0F, 7.0F, 0.0F, false);

		femurR = new ModelRenderer(this);
		femurR.setRotationPoint(0.0F, 0.0F, 1.0F);
		hipR.addChild(femurR);
		femurR.setTextureOffset(108, 142).addBox(-5.0F, -1.0F, -4.0F, 3.0F, 11.0F, 3.0F, 0.0F, false);
		femurR.setTextureOffset(32, 170).addBox(-5.0F, -4.0F, -1.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		fLLeg = new ModelRenderer(this);
		fLLeg.setRotationPoint(6.0F, 2.0F, -11.0F);
		wholebody.addChild(fLLeg);
		

		tibiaL = new ModelRenderer(this);
		tibiaL.setRotationPoint(4.0F, 10.0F, -3.0F);
		fLLeg.addChild(tibiaL);
		tibiaL.setTextureOffset(90, 193).addBox(-2.0F, -2.1F, -1.6F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		tibiaL.setTextureOffset(0, 181).addBox(-2.0F, -0.1F, 0.4F, 3.0F, 10.0F, 1.0F, 0.0F, false);
		tibiaL.setTextureOffset(80, 201).addBox(-1.5F, -0.1F, 1.4F, 2.0F, 6.0F, 1.0F, 0.0F, false);

		fLFoot = new ModelRenderer(this);
		fLFoot.setRotationPoint(2.5F, 9.575F, 13.05F);
		tibiaL.addChild(fLFoot);
		

		duClaw4 = new ModelRenderer(this);
		duClaw4.setRotationPoint(0.0F, 2.1676F, 0.9169F);
		fLFoot.addChild(duClaw4);
		setRotationAngle(duClaw4, -0.7854F, 0.0F, 0.0F);
		

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(1.0F, -4.2426F, -5.6669F);
		duClaw4.addChild(cube_r14);
		setRotationAngle(cube_r14, -0.1309F, 0.0F, 0.0F);
		cube_r14.setTextureOffset(0, 216).addBox(-4.7F, 10.7566F, -5.2654F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		nail4 = new ModelRenderer(this);
		nail4.setRotationPoint(1.0F, 2.325F, -3.65F);
		fLFoot.addChild(nail4);
		setRotationAngle(nail4, 0.7854F, 0.0F, 0.0F);
		

		pawL = new ModelRenderer(this);
		pawL.setRotationPoint(-1.4F, 4.0F, -8.0F);
		fLFoot.addChild(pawL);
		pawL.setTextureOffset(66, 208).addBox(-3.5F, -1.0F, -8.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		pawL.setTextureOffset(2, 219).addBox(-3.0F, -1.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		pawL.setTextureOffset(92, 216).addBox(-4.3F, -1.0F, -7.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		pawL.setTextureOffset(68, 201).addBox(-4.7F, -1.0F, -6.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		pawL.setTextureOffset(40, 181).addBox(-3.5F, -2.0F, -7.5F, 4.0F, 1.0F, 3.0F, 0.0F, false);
		pawL.setTextureOffset(60, 211).addBox(-2.0F, -1.0F, -8.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		pawL.setTextureOffset(0, 219).addBox(-1.4F, -1.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		pawL.setTextureOffset(60, 208).addBox(-0.6F, -1.0F, -8.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		pawL.setTextureOffset(110, 216).addBox(-0.1F, -1.0F, -9.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-2.0F, -3.175F, -5.65F);
		pawL.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.829F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(88, 170).addBox(-1.0F, -0.5F, -2.0F, 3.0F, 2.0F, 4.0F, 0.0F, false);

		hip4 = new ModelRenderer(this);
		hip4.setRotationPoint(7.5F, -0.1F, 9.4F);
		fLLeg.addChild(hip4);
		hip4.setTextureOffset(22, 125).addBox(-7.0F, -5.0F, -12.0F, 2.0F, 10.0F, 7.0F, 0.0F, false);

		femur4 = new ModelRenderer(this);
		femur4.setRotationPoint(0.0F, 7.0F, 1.0F);
		hip4.addChild(femur4);
		femur4.setTextureOffset(96, 142).addBox(-5.0F, -8.0F, -13.0F, 3.0F, 11.0F, 3.0F, 0.0F, false);
		femur4.setTextureOffset(20, 170).addBox(-5.0F, -11.0F, -10.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityLordOfTheWild entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		
		float parTicks = ClientUtils.getPartialTicks();

		
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F)/1.5f;
		this.neck.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F)/1.5f;
		this.tail.rotateAngleX = headPitch * ((float) Math.PI / 180F) / 2;
		this.tail.rotateAngleX =43.5f;
		this.tail.rotateAngleY = headPitch * ((float) Math.PI / 180F) / 2;
		this.bottomJaw.rotateAngleX = limbSwingAmount * 0.73f;
		
		this.centerMane.rotateAngleX = (float) Math.cos((entity.ticksExisted+ parTicks)*0.3f) *0.05f;
		this.mane.rotateAngleX = (float) Math.sin((entity.ticksExisted+ parTicks)*0.5f) *0.1f -44.5f;
		this.mane2.rotateAngleX = (float) Math.cos((entity.ticksExisted+ parTicks)*0.6f) *0.15f;
		this.mane3.rotateAngleX = (float) Math.sin((entity.ticksExisted+ parTicks)*0.7f) *0.25f;
		this.mane4.rotateAngleX = (float) Math.cos((entity.ticksExisted+ parTicks)*0.8f) *0.35f;

		
		this.leftMane.rotateAngleX = (float) Math.sin((entity.ticksExisted+ parTicks)*0.3f) *0.05f;
		this.mane5.rotateAngleX = (float) Math.cos((entity.ticksExisted+ parTicks)*0.5f) *0.1f -44.0f;
		this.mane6.rotateAngleX = (float) Math.sin((entity.ticksExisted+ parTicks)*0.6f) *0.15f;
		this.mane7.rotateAngleX = (float) Math.sin((entity.ticksExisted+ parTicks)*0.7f) *0.25f;
		this.mane8.rotateAngleX = (float) Math.cos((entity.ticksExisted+ parTicks)*0.8f) *0.25f;
		
		this.rightMane.rotateAngleX = (float) Math.sin((entity.ticksExisted+ parTicks)*0.3f) *0.05f;
		this.mane9.rotateAngleX = (float) Math.cos((entity.ticksExisted+ parTicks)*0.5f) *0.1f -44.0f;
		this.mane10.rotateAngleX = (float) Math.sin((entity.ticksExisted+ parTicks)*0.6f) *0.15f;
		this.mane11.rotateAngleX = (float) Math.cos((entity.ticksExisted+ parTicks)*0.7f) *0.25f;
		this.mane12.rotateAngleX = (float) Math.sin((entity.ticksExisted+ parTicks)*0.8f) *0.35f;
		
		
		this.fLLeg.rotateAngleX = MathHelper.sin(limbSwing * 0.1662F + (float) Math.PI) * 1.2F * limbSwingAmount;
		this.fRLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.1662F) * 1.2F * limbSwingAmount;
		//ABS makes it so the Knees dont swing forward
		this.tibiaL.rotateAngleX =Math.abs( MathHelper.cos(limbSwing * 0.1662F + (float) Math.PI) * 1.5F * limbSwingAmount);
		this.tibiaR.rotateAngleX = Math.abs(MathHelper.cos(limbSwing * 0.1662F) * 1.5F * limbSwingAmount);
	
		this.bLLeg.rotateAngleX =-MathHelper.cos(limbSwing * 0.1662F + (float) Math.PI) * 1.2F * limbSwingAmount;
		this.bRLeg.rotateAngleX = MathHelper.sin(limbSwing * 0.1662F) * 1.2F * limbSwingAmount;
		//ABS makes it so the Knees dont swing forward
		this.bLTibia.rotateAngleX = Math.abs(MathHelper.cos(limbSwing * 0.1662F + (float) Math.PI) * 1.5F * limbSwingAmount);
		this.bRTibia.rotateAngleX =Math.abs( MathHelper.cos(limbSwing * 0.1662F) * 1.5F * limbSwingAmount);
		
	
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		wholebody.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}