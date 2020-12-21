package com.huto.forces_of_reality.models.entity.guardians;

import java.util.Random;

import com.huto.forces_of_reality.entities.guardians.EntityDarkYoung;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelDarkYoung extends EntityModel<EntityDarkYoung> {
	public final ModelRenderer frontHead;
	public final ModelRenderer mouth3;
	public final ModelRenderer lowerJaw3;
	public final ModelRenderer upperJaw3;
	public final ModelRenderer frontLeftEye3;
	public final ModelRenderer frontRightEye3;
	public final ModelRenderer backRightEye3;
	public final ModelRenderer centerEye3;
	public final ModelRenderer backLeftEye3;
	public final ModelRenderer rearHead;
	public final ModelRenderer mouth2;
	public final ModelRenderer lowerJaw2;
	public final ModelRenderer upperJaw2;
	public final ModelRenderer frontLeftEye2;
	public final ModelRenderer frontRightEye2;
	public final ModelRenderer backRightEye2;
	public final ModelRenderer centerEye2;
	public final ModelRenderer backLeftEye2;
	public final ModelRenderer body;
	public final ModelRenderer torso;
	public final ModelRenderer midRightTentacle;
	public final ModelRenderer mrSeg1;
	public final ModelRenderer mrSeg2;
	public final ModelRenderer mrSeg3;
	public final ModelRenderer mrSeg4;
	public final ModelRenderer mrSeg5;
	public final ModelRenderer mrSeg6;
	public final ModelRenderer midLeftTentacle;
	public final ModelRenderer mlSeg1;
	public final ModelRenderer mlSeg2;
	public final ModelRenderer mlSeg3;
	public final ModelRenderer mlSeg4;
	public final ModelRenderer mlSeg5;
	public final ModelRenderer mlSeg6;
	public final ModelRenderer frontRightTentacle;
	public final ModelRenderer frSeg1;
	public final ModelRenderer frSeg2;
	public final ModelRenderer frSeg3;
	public final ModelRenderer frSeg4;
	public final ModelRenderer frSeg5;
	public final ModelRenderer frSeg6;
	public final ModelRenderer frontLeftTentacle;
	public final ModelRenderer flSeg1;
	public final ModelRenderer flSeg2;
	public final ModelRenderer flSeg3;
	public final ModelRenderer flSeg4;
	public final ModelRenderer flSeg5;
	public final ModelRenderer flSeg6;
	public final ModelRenderer rearTentacle;
	public final ModelRenderer rearSeg1;
	public final ModelRenderer rearSeg2;
	public final ModelRenderer rearSeg4;
	public final ModelRenderer rearSeg3;
	public final ModelRenderer rearSeg5;
	public final ModelRenderer rearSeg6;
	public final ModelRenderer midTentacle;
	public final ModelRenderer mTSeg1;
	public final ModelRenderer mTSeg2;
	public final ModelRenderer mTSeg3;
	public final ModelRenderer mTSeg4;
	public final ModelRenderer mTSeg5;
	public final ModelRenderer mTSeg6;
	public final ModelRenderer midTentacle2;
	public final ModelRenderer mTSeg7;
	public final ModelRenderer mTSeg8;
	public final ModelRenderer mTSeg9;
	public final ModelRenderer mTSeg10;
	public final ModelRenderer mTSeg11;
	public final ModelRenderer mTSeg12;
	public final ModelRenderer rearRightBrain;
	public final ModelRenderer rearLeftBrain;
	public final ModelRenderer midLeftBrain;
	public final ModelRenderer cube_r1;
	public final ModelRenderer midRightBrain;
	public final ModelRenderer cube_r2;
	public final ModelRenderer frontRightBrain;
	public final ModelRenderer frontLeftBrain;
	public final ModelRenderer leftFrontLeg;
	public final ModelRenderer leftFrontLegEye;
	public final ModelRenderer rightFrontLeg;
	public final ModelRenderer rightFrontLegEye;
	public final ModelRenderer leftBackLeg;
	public final ModelRenderer leftBackLegEye;
	public final ModelRenderer rightBackLeg;
	public final ModelRenderer rightBackLegEye;

	public ModelDarkYoung() {
		textureWidth = 128;
		textureHeight = 128;

		frontHead = new ModelRenderer(this);
		frontHead.setRotationPoint(0.0F, 14.0F, -9.0F);
		frontHead.setTextureOffset(36, 19).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, 0.0F, false);

		mouth3 = new ModelRenderer(this);
		mouth3.setRotationPoint(0.0F, 1.0F, 3.0F);
		frontHead.addChild(mouth3);
		setRotationAngle(mouth3, 0.0F, 0.0F, 0.0F);
		

		lowerJaw3 = new ModelRenderer(this);
		lowerJaw3.setRotationPoint(0.0F, 0.5F, -4.5F);
		mouth3.addChild(lowerJaw3);
		lowerJaw3.setTextureOffset(0, 0).addBox(-1.0F, 0.5F, -6.5F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		lowerJaw3.setTextureOffset(38, 67).addBox(-1.0F, -0.5F, -7.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		lowerJaw3.setTextureOffset(30, 63).addBox(-2.0F, -0.5F, -6.5F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		lowerJaw3.setTextureOffset(62, 8).addBox(1.0F, -0.5F, -6.5F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		lowerJaw3.setTextureOffset(0, 40).addBox(-1.0F, -1.5F, -6.5F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		lowerJaw3.setTextureOffset(27, 38).addBox(1.0F, -1.5F, -6.5F, 0.0F, 2.0F, 5.0F, 0.0F, false);

		upperJaw3 = new ModelRenderer(this);
		upperJaw3.setRotationPoint(0.0F, -2.0F, -6.75F);
		mouth3.addChild(upperJaw3);
		upperJaw3.setTextureOffset(36, 8).addBox(-2.0F, -1.0F, -4.25F, 4.0F, 1.0F, 6.0F, 0.0F, false);
		upperJaw3.setTextureOffset(27, 45).addBox(-2.0F, 0.0F, -5.25F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		upperJaw3.setTextureOffset(22, 62).addBox(-3.0F, 0.0F, -4.25F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		upperJaw3.setTextureOffset(46, 61).addBox(2.0F, 0.0F, -4.25F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		upperJaw3.setTextureOffset(0, 38).addBox(-2.0F, 0.0F, -4.25F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		upperJaw3.setTextureOffset(0, 8).addBox(2.0F, 0.0F, -4.25F, 0.0F, 2.0F, 5.0F, 0.0F, false);

		frontLeftEye3 = new ModelRenderer(this);
		frontLeftEye3.setRotationPoint(-2.0F, -2.0F, 3.0F);
		frontHead.addChild(frontLeftEye3);
		frontLeftEye3.setTextureOffset(80, 35).addBox(-2.0F, -1.0F, -7.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		frontRightEye3 = new ModelRenderer(this);
		frontRightEye3.setRotationPoint(2.0F, -2.0F, 3.0F);
		frontHead.addChild(frontRightEye3);
		frontRightEye3.setTextureOffset(80, 30).addBox(0.0F, -1.0F, -7.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		backRightEye3 = new ModelRenderer(this);
		backRightEye3.setRotationPoint(3.0F, -3.0F, 1.0F);
		frontHead.addChild(backRightEye3);
		backRightEye3.setTextureOffset(80, 26).addBox(0.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		centerEye3 = new ModelRenderer(this);
		centerEye3.setRotationPoint(0.0F, -3.0F, 2.0F);
		frontHead.addChild(centerEye3);
		centerEye3.setTextureOffset(66, 80).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		backLeftEye3 = new ModelRenderer(this);
		backLeftEye3.setRotationPoint(-3.0F, -3.0F, 1.0F);
		frontHead.addChild(backLeftEye3);
		backLeftEye3.setTextureOffset(80, 6).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rearHead = new ModelRenderer(this);
		rearHead.setRotationPoint(0.0F, 14.0F, 9.0F);
		rearHead.setTextureOffset(36, 19).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 4.0F, 0.0F, false);

		mouth2 = new ModelRenderer(this);
		mouth2.setRotationPoint(0.0F, 1.0F, 5.0F);
		rearHead.addChild(mouth2);
		setRotationAngle(mouth2, 0.0F, 0.0F, 0.0F);
		

		lowerJaw2 = new ModelRenderer(this);
		lowerJaw2.setRotationPoint(0.0F, 0.5F, -1.0F);
		mouth2.addChild(lowerJaw2);
		lowerJaw2.setTextureOffset(0, 0).addBox(-1.0F, 0.5F, 0.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		lowerJaw2.setTextureOffset(38, 67).addBox(-1.0F, -0.5F, 6.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		lowerJaw2.setTextureOffset(30, 63).addBox(-2.0F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		lowerJaw2.setTextureOffset(62, 8).addBox(1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		lowerJaw2.setTextureOffset(0, 40).addBox(-1.0F, -0.5F, 1.0F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		lowerJaw2.setTextureOffset(27, 38).addBox(1.0F, -1.5F, 1.0F, 0.0F, 2.0F, 5.0F, 0.0F, false);

		upperJaw2 = new ModelRenderer(this);
		upperJaw2.setRotationPoint(0.0F, -2.0F, 0.0F);
		mouth2.addChild(upperJaw2);
		upperJaw2.setTextureOffset(36, 8).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);
		upperJaw2.setTextureOffset(27, 45).addBox(-2.0F, 0.0F, 5.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		upperJaw2.setTextureOffset(22, 62).addBox(-3.0F, 0.0F, -1.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		upperJaw2.setTextureOffset(46, 61).addBox(2.0F, 0.0F, -1.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		upperJaw2.setTextureOffset(0, 38).addBox(-2.0F, 0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F, false);
		upperJaw2.setTextureOffset(0, 8).addBox(2.0F, 0.0F, 0.0F, 0.0F, 2.0F, 5.0F, 0.0F, false);

		frontLeftEye2 = new ModelRenderer(this);
		frontLeftEye2.setRotationPoint(-2.0F, -2.0F, 5.0F);
		rearHead.addChild(frontLeftEye2);
		frontLeftEye2.setTextureOffset(80, 35).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		frontRightEye2 = new ModelRenderer(this);
		frontRightEye2.setRotationPoint(2.0F, -2.0F, 5.0F);
		rearHead.addChild(frontRightEye2);
		frontRightEye2.setTextureOffset(80, 30).addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		backRightEye2 = new ModelRenderer(this);
		backRightEye2.setRotationPoint(3.0F, -3.0F, 3.0F);
		rearHead.addChild(backRightEye2);
		backRightEye2.setTextureOffset(80, 26).addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		centerEye2 = new ModelRenderer(this);
		centerEye2.setRotationPoint(0.0F, -3.0F, 4.0F);
		rearHead.addChild(centerEye2);
		centerEye2.setTextureOffset(66, 80).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		backLeftEye2 = new ModelRenderer(this);
		backLeftEye2.setRotationPoint(-3.0F, -3.0F, 3.0F);
		rearHead.addChild(backLeftEye2);
		backLeftEye2.setTextureOffset(80, 6).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 12.3125F, 1.9375F);
		

		torso = new ModelRenderer(this);
		torso.setRotationPoint(0.0F, -0.1125F, -2.1375F);
		body.addChild(torso);
		torso.setTextureOffset(0, 36).addBox(-4.0F, 0.8F, -1.8F, 8.0F, 2.0F, 6.0F, 0.0F, false);
		torso.setTextureOffset(27, 36).addBox(-5.0F, 0.8F, 4.2F, 10.0F, 2.0F, 5.0F, 0.0F, false);
		torso.setTextureOffset(27, 36).addBox(-5.0F, 0.8F, -6.8F, 10.0F, 2.0F, 5.0F, 0.0F, false);
		torso.setTextureOffset(0, 0).addBox(-5.0F, -2.2F, -6.8F, 10.0F, 3.0F, 16.0F, 0.0F, false);
		torso.setTextureOffset(0, 19).addBox(-5.0F, -3.2F, -6.8F, 10.0F, 1.0F, 16.0F, 0.0F, false);

		midRightTentacle = new ModelRenderer(this);
		midRightTentacle.setRotationPoint(0.0F, 11.6875F, -1.9375F);
		body.addChild(midRightTentacle);
		

		mrSeg1 = new ModelRenderer(this);
		mrSeg1.setRotationPoint(4.0F, -16.0F, 2.5F);
		midRightTentacle.addChild(mrSeg1);
		mrSeg1.setTextureOffset(67, 68).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		mrSeg2 = new ModelRenderer(this);
		mrSeg2.setRotationPoint(4.0F, -18.0F, 1.0F);
		midRightTentacle.addChild(mrSeg2);
		mrSeg2.setTextureOffset(58, 80).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mrSeg3 = new ModelRenderer(this);
		mrSeg3.setRotationPoint(4.0F, -20.0F, 2.0F);
		midRightTentacle.addChild(mrSeg3);
		mrSeg3.setTextureOffset(34, 80).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mrSeg4 = new ModelRenderer(this);
		mrSeg4.setRotationPoint(4.0F, -22.0F, 1.0F);
		midRightTentacle.addChild(mrSeg4);
		mrSeg4.setTextureOffset(42, 80).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mrSeg5 = new ModelRenderer(this);
		mrSeg5.setRotationPoint(4.0F, -24.0F, 2.0F);
		midRightTentacle.addChild(mrSeg5);
		mrSeg5.setTextureOffset(20, 80).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mrSeg6 = new ModelRenderer(this);
		mrSeg6.setRotationPoint(4.0F, -26.0F, 0.5F);
		midRightTentacle.addChild(mrSeg6);
		mrSeg6.setTextureOffset(30, 62).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		midLeftTentacle = new ModelRenderer(this);
		midLeftTentacle.setRotationPoint(-7.0F, -13.3125F, 12.0625F);
		body.addChild(midLeftTentacle);
		

		mlSeg1 = new ModelRenderer(this);
		mlSeg1.setRotationPoint(3.0F, 9.0F, -11.5F);
		midLeftTentacle.addChild(mlSeg1);
		mlSeg1.setTextureOffset(41, 68).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		mlSeg2 = new ModelRenderer(this);
		mlSeg2.setRotationPoint(3.0F, 7.0F, -12.0F);
		midLeftTentacle.addChild(mlSeg2);
		mlSeg2.setTextureOffset(76, 45).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mlSeg3 = new ModelRenderer(this);
		mlSeg3.setRotationPoint(3.0F, 5.0F, -11.0F);
		midLeftTentacle.addChild(mlSeg3);
		mlSeg3.setTextureOffset(76, 11).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mlSeg4 = new ModelRenderer(this);
		mlSeg4.setRotationPoint(3.0F, 3.0F, -10.0F);
		midLeftTentacle.addChild(mlSeg4);
		mlSeg4.setTextureOffset(76, 18).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mlSeg5 = new ModelRenderer(this);
		mlSeg5.setRotationPoint(3.0F, 1.0F, -11.0F);
		midLeftTentacle.addChild(mlSeg5);
		mlSeg5.setTextureOffset(71, 76).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mlSeg6 = new ModelRenderer(this);
		mlSeg6.setRotationPoint(3.0F, -1.0F, -9.5F);
		midLeftTentacle.addChild(mlSeg6);
		mlSeg6.setTextureOffset(52, 15).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		frontRightTentacle = new ModelRenderer(this);
		frontRightTentacle.setRotationPoint(0.0F, -13.3125F, 20.0625F);
		body.addChild(frontRightTentacle);
		

		frSeg1 = new ModelRenderer(this);
		frSeg1.setRotationPoint(3.0F, 10.5F, -12.0F);
		frontRightTentacle.addChild(frSeg1);
		frSeg1.setTextureOffset(70, 8).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		frSeg2 = new ModelRenderer(this);
		frSeg2.setRotationPoint(3.0F, 8.0F, -11.0F);
		frontRightTentacle.addChild(frSeg2);
		frSeg2.setTextureOffset(78, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		frSeg3 = new ModelRenderer(this);
		frSeg3.setRotationPoint(3.0F, 6.0F, -13.0F);
		frontRightTentacle.addChild(frSeg3);
		frSeg3.setTextureOffset(52, 78).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		frSeg4 = new ModelRenderer(this);
		frSeg4.setRotationPoint(3.0F, 4.0F, -14.0F);
		frontRightTentacle.addChild(frSeg4);
		frSeg4.setTextureOffset(77, 78).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		frSeg5 = new ModelRenderer(this);
		frSeg5.setRotationPoint(3.0F, 2.0F, -13.0F);
		frontRightTentacle.addChild(frSeg5);
		frSeg5.setTextureOffset(28, 78).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		frSeg6 = new ModelRenderer(this);
		frSeg6.setRotationPoint(3.0F, 0.0F, -14.5F);
		frontRightTentacle.addChild(frSeg6);
		frSeg6.setTextureOffset(46, 61).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		frontLeftTentacle = new ModelRenderer(this);
		frontLeftTentacle.setRotationPoint(-6.0F, -13.3125F, 20.0625F);
		body.addChild(frontLeftTentacle);
		

		flSeg1 = new ModelRenderer(this);
		flSeg1.setRotationPoint(3.0F, 10.5F, -12.0F);
		frontLeftTentacle.addChild(flSeg1);
		flSeg1.setTextureOffset(30, 70).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		flSeg2 = new ModelRenderer(this);
		flSeg2.setRotationPoint(3.0F, 8.0F, -13.0F);
		frontLeftTentacle.addChild(flSeg2);
		flSeg2.setTextureOffset(0, 75).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		flSeg3 = new ModelRenderer(this);
		flSeg3.setRotationPoint(3.0F, 6.0F, -11.0F);
		frontLeftTentacle.addChild(flSeg3);
		flSeg3.setTextureOffset(76, 53).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		flSeg4 = new ModelRenderer(this);
		flSeg4.setRotationPoint(3.0F, 4.0F, -10.0F);
		frontLeftTentacle.addChild(flSeg4);
		flSeg4.setTextureOffset(6, 78).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		flSeg5 = new ModelRenderer(this);
		flSeg5.setRotationPoint(3.0F, 2.0F, -11.0F);
		frontLeftTentacle.addChild(flSeg5);
		flSeg5.setTextureOffset(76, 49).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		flSeg6 = new ModelRenderer(this);
		flSeg6.setRotationPoint(3.0F, 0.0F, -9.5F);
		frontLeftTentacle.addChild(flSeg6);
		flSeg6.setTextureOffset(60, 2).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		rearTentacle = new ModelRenderer(this);
		rearTentacle.setRotationPoint(-3.0F, -11.3125F, 2.0625F);
		body.addChild(rearTentacle);
		

		rearSeg1 = new ModelRenderer(this);
		rearSeg1.setRotationPoint(3.0F, 9.0F, -11.5F);
		rearTentacle.addChild(rearSeg1);
		rearSeg1.setTextureOffset(51, 68).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rearSeg2 = new ModelRenderer(this);
		rearSeg2.setRotationPoint(3.0F, 7.0F, -12.0F);
		rearTentacle.addChild(rearSeg2);
		rearSeg2.setTextureOffset(12, 80).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rearSeg4 = new ModelRenderer(this);
		rearSeg4.setRotationPoint(3.0F, 3.0F, -10.0F);
		rearTentacle.addChild(rearSeg4);
		rearSeg4.setTextureOffset(0, 80).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rearSeg3 = new ModelRenderer(this);
		rearSeg3.setRotationPoint(3.0F, 5.0F, -11.0F);
		rearTentacle.addChild(rearSeg3);
		rearSeg3.setTextureOffset(79, 74).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rearSeg5 = new ModelRenderer(this);
		rearSeg5.setRotationPoint(3.0F, 1.0F, -11.0F);
		rearTentacle.addChild(rearSeg5);
		rearSeg5.setTextureOffset(78, 60).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rearSeg6 = new ModelRenderer(this);
		rearSeg6.setRotationPoint(3.0F, -1.0F, -9.5F);
		rearTentacle.addChild(rearSeg6);
		rearSeg6.setTextureOffset(22, 62).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		midTentacle = new ModelRenderer(this);
		midTentacle.setRotationPoint(-3.0F, -13.3125F, 15.0625F);
		body.addChild(midTentacle);
		

		mTSeg1 = new ModelRenderer(this);
		mTSeg1.setRotationPoint(3.0F, 9.0F, -11.5F);
		midTentacle.addChild(mTSeg1);
		mTSeg1.setTextureOffset(65, 34).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		mTSeg2 = new ModelRenderer(this);
		mTSeg2.setRotationPoint(3.0F, 7.0F, -12.0F);
		midTentacle.addChild(mTSeg2);
		mTSeg2.setTextureOffset(74, 67).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mTSeg3 = new ModelRenderer(this);
		mTSeg3.setRotationPoint(3.0F, 5.0F, -13.0F);
		midTentacle.addChild(mTSeg3);
		mTSeg3.setTextureOffset(74, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mTSeg4 = new ModelRenderer(this);
		mTSeg4.setRotationPoint(3.0F, 3.0F, -12.0F);
		midTentacle.addChild(mTSeg4);
		mTSeg4.setTextureOffset(74, 28).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mTSeg5 = new ModelRenderer(this);
		mTSeg5.setRotationPoint(3.0F, 1.0F, -13.0F);
		midTentacle.addChild(mTSeg5);
		mTSeg5.setTextureOffset(8, 74).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mTSeg6 = new ModelRenderer(this);
		mTSeg6.setRotationPoint(3.0F, -1.0F, -11.5F);
		midTentacle.addChild(mTSeg6);
		mTSeg6.setTextureOffset(10, 13).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		midTentacle2 = new ModelRenderer(this);
		midTentacle2.setRotationPoint(-3.0F, -13.3125F, 8.0625F);
		body.addChild(midTentacle2);
		

		mTSeg7 = new ModelRenderer(this);
		mTSeg7.setRotationPoint(3.0F, 9.0F, -11.5F);
		midTentacle2.addChild(mTSeg7);
		mTSeg7.setTextureOffset(65, 34).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		mTSeg8 = new ModelRenderer(this);
		mTSeg8.setRotationPoint(3.0F, 7.0F, -12.0F);
		midTentacle2.addChild(mTSeg8);
		mTSeg8.setTextureOffset(74, 67).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mTSeg9 = new ModelRenderer(this);
		mTSeg9.setRotationPoint(3.0F, 5.0F, -13.0F);
		midTentacle2.addChild(mTSeg9);
		mTSeg9.setTextureOffset(74, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mTSeg10 = new ModelRenderer(this);
		mTSeg10.setRotationPoint(3.0F, 3.0F, -12.0F);
		midTentacle2.addChild(mTSeg10);
		mTSeg10.setTextureOffset(74, 28).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mTSeg11 = new ModelRenderer(this);
		mTSeg11.setRotationPoint(3.0F, 1.0F, -13.0F);
		midTentacle2.addChild(mTSeg11);
		mTSeg11.setTextureOffset(8, 74).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		mTSeg12 = new ModelRenderer(this);
		mTSeg12.setRotationPoint(3.0F, -1.0F, -11.5F);
		midTentacle2.addChild(mTSeg12);
		mTSeg12.setTextureOffset(10, 13).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		rearRightBrain = new ModelRenderer(this);
		rearRightBrain.setRotationPoint(4.0F, -3.8125F, -7.9375F);
		body.addChild(rearRightBrain);
		setRotationAngle(rearRightBrain, 0.0F, 0.0F, 0.3054F);
		rearRightBrain.setTextureOffset(58, 41).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		rearLeftBrain = new ModelRenderer(this);
		rearLeftBrain.setRotationPoint(-4.0F, -3.8125F, -7.9375F);
		body.addChild(rearLeftBrain);
		setRotationAngle(rearLeftBrain, 0.0F, 0.0F, -0.3054F);
		rearLeftBrain.setTextureOffset(56, 48).addBox(-1.9537F, -0.8007F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		midLeftBrain = new ModelRenderer(this);
		midLeftBrain.setRotationPoint(-5.0F, -3.8125F, -1.9375F);
		body.addChild(midLeftBrain);
		setRotationAngle(midLeftBrain, 0.0F, 0.0F, -0.3054F);
		midLeftBrain.setTextureOffset(56, 21).addBox(-1.0F, -0.5F, -3.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-3.0F, 0.5F, 10.0F);
		midLeftBrain.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 1.8762F);
		cube_r1.setTextureOffset(56, 21).addBox(2.0872F, -2.9981F, -11.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		midRightBrain = new ModelRenderer(this);
		midRightBrain.setRotationPoint(5.0F, -3.8125F, -1.9375F);
		body.addChild(midRightBrain);
		setRotationAngle(midRightBrain, 0.0F, 0.0F, 0.3054F);
		midRightBrain.setTextureOffset(0, 7).addBox(-2.0F, -0.5F, -3.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-3.0F, 0.5F, 10.0F);
		midRightBrain.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 1.309F);
		cube_r2.setTextureOffset(0, 7).addBox(3.1056F, -5.3726F, -11.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		frontRightBrain = new ModelRenderer(this);
		frontRightBrain.setRotationPoint(4.0F, -3.8125F, 4.0625F);
		body.addChild(frontRightBrain);
		setRotationAngle(frontRightBrain, 0.0F, 0.0F, 0.3054F);
		frontRightBrain.setTextureOffset(58, 58).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		frontLeftBrain = new ModelRenderer(this);
		frontLeftBrain.setRotationPoint(-4.0F, -3.8125F, 4.0625F);
		body.addChild(frontLeftBrain);
		setRotationAngle(frontLeftBrain, 0.0F, 0.0F, -0.3491F);
		frontLeftBrain.setTextureOffset(52, 35).addBox(-1.9397F, -0.842F, -2.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);

		leftFrontLeg = new ModelRenderer(this);
		leftFrontLeg.setRotationPoint(-5.0F, 13.5F, 6.5F);
		setRotationAngle(leftFrontLeg, 0.0F, 0.0F, 0.0F);
		leftFrontLeg.setTextureOffset(18, 49).addBox(-3.0F, -2.5F, -2.5F, 3.0F, 5.0F, 6.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(65, 73).addBox(-4.0F, -2.5F, -3.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(38, 54).addBox(-4.0F, -2.5F, 3.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(48, 73).addBox(-2.0F, -2.5F, -3.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(0, 60).addBox(-2.0F, -2.5F, 3.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(60, 0).addBox(-2.0F, -4.5F, -2.5F, 1.0F, 2.0F, 6.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(14, 60).addBox(-4.0F, -4.5F, -2.5F, 1.0F, 2.0F, 6.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(20, 69).addBox(-3.0F, 2.5F, -2.5F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(50, 30).addBox(-4.0F, 9.5F, -1.5F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(80, 64).addBox(1.0F, 9.5F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(77, 71).addBox(-3.0F, 9.5F, 2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(76, 57).addBox(-3.0F, 9.5F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(80, 42).addBox(-5.0F, 9.5F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(73, 15).addBox(-4.0F, 6.5F, 2.5F, 5.0F, 3.0F, 0.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(71, 73).addBox(-4.0F, 6.5F, -1.5F, 5.0F, 3.0F, 0.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(62, 50).addBox(1.0F, 6.5F, -1.5F, 0.0F, 3.0F, 4.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(60, 11).addBox(-4.0F, 6.5F, -1.5F, 0.0F, 3.0F, 4.0F, 0.0F, false);
		leftFrontLeg.setTextureOffset(0, 68).addBox(-3.0F, 4.5F, -0.5F, 3.0F, 5.0F, 2.0F, 0.0F, false);

		leftFrontLegEye = new ModelRenderer(this);
		leftFrontLegEye.setRotationPoint(-4.0F, 0.0F, 1.0F);
		leftFrontLeg.addChild(leftFrontLegEye);
		leftFrontLegEye.setTextureOffset(10, 68).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		rightFrontLeg = new ModelRenderer(this);
		rightFrontLeg.setRotationPoint(5.0F, 13.5F, 6.5F);
		setRotationAngle(rightFrontLeg, 0.0F, 0.0F, 0.0F);
		rightFrontLeg.setTextureOffset(0, 49).addBox(0.0F, -2.5F, -2.5F, 3.0F, 5.0F, 6.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(42, 73).addBox(3.0F, -2.5F, -3.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(0, 49).addBox(3.0F, -2.5F, 3.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(36, 73).addBox(1.0F, -2.5F, -3.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(36, 8).addBox(1.0F, -2.5F, 3.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(0, 60).addBox(1.0F, -4.5F, -2.5F, 1.0F, 2.0F, 6.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(38, 59).addBox(3.0F, -4.5F, -2.5F, 1.0F, 2.0F, 6.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(68, 47).addBox(0.0F, 2.5F, -2.5F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(50, 8).addBox(-1.0F, 9.5F, -1.5F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(80, 39).addBox(4.0F, 9.5F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(68, 4).addBox(0.0F, 9.5F, 2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(54, 64).addBox(0.0F, 9.5F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(78, 22).addBox(-2.0F, 9.5F, -0.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(72, 34).addBox(-1.0F, 6.5F, 2.5F, 5.0F, 3.0F, 0.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(72, 25).addBox(-1.0F, 6.5F, -1.5F, 5.0F, 3.0F, 0.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(56, 23).addBox(4.0F, 6.5F, -1.5F, 0.0F, 3.0F, 4.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(54, 55).addBox(-1.0F, 6.5F, -1.5F, 0.0F, 3.0F, 4.0F, 0.0F, false);
		rightFrontLeg.setTextureOffset(64, 27).addBox(0.0F, 4.5F, -0.5F, 3.0F, 5.0F, 2.0F, 0.0F, false);

		rightFrontLegEye = new ModelRenderer(this);
		rightFrontLegEye.setRotationPoint(4.0F, 0.0F, 1.0F);
		rightFrontLeg.addChild(rightFrontLegEye);
		rightFrontLegEye.setTextureOffset(12, 49).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		leftBackLeg = new ModelRenderer(this);
		leftBackLeg.setRotationPoint(-5.0F, 13.5F, -4.5F);
		setRotationAngle(leftBackLeg, 0.0F, 0.0F, 0.0F);
		leftBackLeg.setTextureOffset(44, 48).addBox(-3.0F, -2.5F, -3.5F, 3.0F, 5.0F, 6.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(24, 73).addBox(-4.0F, -2.5F, -4.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(0, 27).addBox(-4.0F, -2.5F, 2.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(18, 73).addBox(-2.0F, -2.5F, -4.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(0, 19).addBox(-2.0F, -2.5F, 2.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(30, 54).addBox(-2.0F, -4.5F, -3.5F, 1.0F, 2.0F, 6.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(52, 13).addBox(-4.0F, -4.5F, -3.5F, 1.0F, 2.0F, 6.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(68, 21).addBox(-3.0F, 2.5F, -0.5F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(44, 43).addBox(-4.0F, 9.5F, -2.5F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(30, 75).addBox(1.0F, 9.5F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(22, 60).addBox(-3.0F, 9.5F, 1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(46, 59).addBox(-3.0F, 9.5F, -3.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(48, 68).addBox(-5.0F, 9.5F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(70, 64).addBox(-4.0F, 6.5F, 1.5F, 5.0F, 3.0F, 0.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(70, 59).addBox(-4.0F, 6.5F, -2.5F, 5.0F, 3.0F, 0.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(8, 26).addBox(1.0F, 6.5F, -2.5F, 0.0F, 3.0F, 4.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(8, 23).addBox(-4.0F, 6.5F, -2.5F, 0.0F, 3.0F, 4.0F, 0.0F, false);
		leftBackLeg.setTextureOffset(60, 64).addBox(-3.0F, 4.5F, -1.5F, 3.0F, 5.0F, 2.0F, 0.0F, false);

		leftBackLegEye = new ModelRenderer(this);
		leftBackLegEye.setRotationPoint(-4.0F, 0.0F, 0.0F);
		leftBackLeg.addChild(leftBackLegEye);
		leftBackLegEye.setTextureOffset(66, 15).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);

		rightBackLeg = new ModelRenderer(this);
		rightBackLeg.setRotationPoint(5.0F, 13.5F, -4.5F);
		rightBackLeg.setTextureOffset(32, 43).addBox(0.0F, -2.5F, -3.5F, 3.0F, 5.0F, 6.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(59, 71).addBox(3.0F, -2.5F, -4.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(10, 0).addBox(3.0F, -2.5F, 2.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(70, 52).addBox(1.0F, -2.5F, -4.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(0, 0).addBox(1.0F, -2.5F, 2.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(0, 27).addBox(1.0F, -4.5F, -3.5F, 1.0F, 2.0F, 6.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(0, 19).addBox(3.0F, -4.5F, -3.5F, 1.0F, 2.0F, 6.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(68, 0).addBox(0.0F, 2.5F, -0.5F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(36, 29).addBox(-1.0F, 9.5F, -2.5F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(30, 65).addBox(4.0F, 9.5F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(58, 0).addBox(0.0F, 9.5F, 1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(52, 21).addBox(0.0F, 9.5F, -3.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(38, 62).addBox(-2.0F, 9.5F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(70, 42).addBox(-1.0F, 6.5F, 1.5F, 5.0F, 3.0F, 0.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(70, 39).addBox(-1.0F, 6.5F, -2.5F, 5.0F, 3.0F, 0.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(8, 18).addBox(4.0F, 6.5F, -2.5F, 0.0F, 3.0F, 4.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(8, 15).addBox(-1.0F, 6.5F, -2.5F, 0.0F, 3.0F, 4.0F, 0.0F, false);
		rightBackLeg.setTextureOffset(0, 36).addBox(0.0F, 4.5F, -1.5F, 3.0F, 5.0F, 2.0F, 0.0F, false);

		rightBackLegEye = new ModelRenderer(this);
		rightBackLegEye.setRotationPoint(4.0F, 0.0F, 0.0F);
		rightBackLeg.addChild(rightBackLegEye);
		rightBackLegEye.setTextureOffset(8, 60).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityDarkYoung entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		
		
		//Head
		this.upperJaw2.rotateAngleX = -limbSwingAmount * 0.13f;
		this.lowerJaw2.rotateAngleX = limbSwingAmount * 0.13f;
		
		this.upperJaw3.rotateAngleX = -limbSwingAmount * 0.13f;
		this.lowerJaw3.rotateAngleX = limbSwingAmount * 0.13f;
		
		this.frontHead.rotateAngleX = headPitch * ((float) Math.PI / 180F) * 0.5f;
		this.frontHead.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) * 0.5f;
		this.rearHead.rotateAngleX = -headPitch * ((float) Math.PI / 180F) * 0.5f;
		this.rearHead.rotateAngleY = -netHeadYaw * ((float) Math.PI / 180F) * 0.5f;
		this.rightBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5f;
		this.leftBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				* 0.5f;
		this.rightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				* 0.5f;
		this.leftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5f;

		
		
		
		// Each Tentacle Segment
		Random rand = new Random();
		float tentMod = rand.nextInt(3) * 1.1f;

		
		//Head Eyes
		this.backLeftEye2.rotateAngleZ = -(float) (Math.sin(ageInTicks) * 0.0325);
		this.backLeftEye2.rotateAngleY = -(float) (Math.cos(ageInTicks) * 0.0325);
		
		this.backRightEye2.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0325);
		this.backRightEye2.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0325);
		
		this.backLeftEye3.rotateAngleZ = -(float) (Math.sin(ageInTicks) * 0.0325);
		this.backLeftEye3.rotateAngleY = -(float) (Math.cos(ageInTicks) * 0.0325);
		
		this.backRightEye3.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0325);
		this.backRightEye3.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0325);
		
		
		this.centerEye2.rotateAngleZ = (float) (Math.cos(ageInTicks) * 0.0325);
		this.centerEye2.rotateAngleY = -(float) (Math.sin(ageInTicks) * 0.0325);
		
		this.centerEye3.rotateAngleZ = -(float) (Math.cos(ageInTicks) * 0.0325);
		this.centerEye3.rotateAngleY = (float) (Math.sin(ageInTicks) * 0.0325);
		
		
		
		// Shoulder Eyes
		this.leftFrontLegEye.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0325);
		this.leftFrontLegEye.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0325);

		this.rightFrontLegEye.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0325);
		this.rightFrontLegEye.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0325);

		this.leftBackLegEye.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0325);
		this.leftBackLegEye.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0325);

		this.rightBackLegEye.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0325);
		this.rightBackLegEye.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0325);

		// Front left
		this.frSeg1.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.frSeg1.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.frSeg2.rotateAngleZ = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.frSeg2.rotateAngleY = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.frSeg3.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.frSeg3.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.frSeg4.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0725) * tentMod;
		this.frSeg4.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0725) * tentMod;
		this.frSeg5.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0825) * tentMod;
		this.frSeg5.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0825) * tentMod;
		this.frSeg6.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0925) * tentMod;
		this.frSeg6.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0925) * tentMod;

		// Middle left
		this.mlSeg1.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.mlSeg1.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.mlSeg2.rotateAngleZ = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.mlSeg2.rotateAngleY = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.mlSeg3.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.mlSeg3.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.mlSeg4.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0725) * tentMod;
		this.mlSeg4.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0725) * tentMod;
		this.mlSeg5.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0825) * tentMod;
		this.mlSeg5.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0825) * tentMod;
		this.mlSeg6.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0925) * tentMod;
		this.mlSeg6.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0925) * tentMod;

		// Middle right
		this.mrSeg1.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.mrSeg1.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.mrSeg2.rotateAngleZ = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.mrSeg2.rotateAngleY = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.mrSeg3.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.mrSeg3.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.mrSeg4.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0725) * tentMod;
		this.mrSeg4.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0725) * tentMod;
		this.mrSeg5.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0825) * tentMod;
		this.mrSeg5.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0825) * tentMod;
		this.mrSeg6.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0925) * tentMod;
		this.mrSeg6.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0925) * tentMod;

		// Front right
		this.flSeg1.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.flSeg1.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.flSeg2.rotateAngleZ = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.flSeg2.rotateAngleY = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.flSeg3.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.flSeg3.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.flSeg4.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0725) * tentMod;
		this.flSeg4.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0725) * tentMod;
		this.flSeg5.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0825) * tentMod;
		this.flSeg5.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0825) * tentMod;
		this.flSeg6.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0925) * tentMod;
		this.flSeg6.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0925) * tentMod;

		// Middle Tentacles
		this.mTSeg1.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.mTSeg1.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.mTSeg2.rotateAngleZ = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.mTSeg2.rotateAngleY = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.mTSeg3.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.mTSeg3.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.mTSeg4.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0725) * tentMod;
		this.mTSeg4.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0725) * tentMod;
		this.mTSeg5.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0825) * tentMod;
		this.mTSeg5.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0825) * tentMod;
		this.mTSeg6.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0925) * tentMod;
		this.mTSeg6.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0925) * tentMod;

		this.mTSeg7.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.mTSeg7.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.mTSeg8.rotateAngleZ = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.mTSeg8.rotateAngleY = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.mTSeg9.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.mTSeg9.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.mTSeg10.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0725) * tentMod;
		this.mTSeg10.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0725) * tentMod;
		this.mTSeg11.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0825) * tentMod;
		this.mTSeg11.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0825) * tentMod;
		this.mTSeg12.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0925) * tentMod;
		this.mTSeg12.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0925) * tentMod;

		// Rear Tentacle
		this.rearSeg1.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.rearSeg1.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.rearSeg2.rotateAngleZ = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.rearSeg2.rotateAngleY = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.rearSeg3.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0625) * tentMod;
		this.rearSeg3.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0625) * tentMod;
		this.rearSeg4.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0725) * tentMod;
		this.rearSeg4.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0725) * tentMod;
		this.rearSeg5.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0825) * tentMod;
		this.rearSeg5.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0825) * tentMod;
		this.rearSeg6.rotateAngleX = (float) (Math.cos(ageInTicks) * 0.0925) * tentMod;
		this.rearSeg6.rotateAngleZ = (float) (Math.sin(ageInTicks) * 0.0925) * tentMod;
		this.rearSeg6.rotateAngleY = (float) (Math.cos(ageInTicks) * 0.0925) * tentMod;

	}

	@Override
	public void setLivingAnimations(EntityDarkYoung entityIn, float limbSwing, float limbSwingAmount,
			float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		frontHead.render(matrixStack, buffer, packedLight, packedOverlay);
		rearHead.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		leftFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}