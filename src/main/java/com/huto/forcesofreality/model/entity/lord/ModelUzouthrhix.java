package com.huto.forcesofreality.model.entity.lord;

import com.huto.forcesofreality.entity.lord.EntityUzouthrhix;
import com.hutoslib.client.model.AnimatedEntityModel;
import com.hutoslib.client.model.AnimatedModelRenderer;
import com.hutoslib.client.model.ModelAnimator;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.util.math.MathHelper;

public class ModelUzouthrhix extends AnimatedEntityModel<EntityUzouthrhix> {
	private final AnimatedModelRenderer wholeBody;
	private final AnimatedModelRenderer lowerColumn;
	private final AnimatedModelRenderer upperColumn;
	private final AnimatedModelRenderer upperTorso;
	private final AnimatedModelRenderer neck;
	private final AnimatedModelRenderer neck2;
	private final AnimatedModelRenderer neck1;
	private final AnimatedModelRenderer cube_r2;
	private final AnimatedModelRenderer lGills;
	private final AnimatedModelRenderer cube_r3;
	private final AnimatedModelRenderer cube_r4;
	private final AnimatedModelRenderer cube_r5;
	private final AnimatedModelRenderer cube_r6;
	private final AnimatedModelRenderer cube_r7;
	private final AnimatedModelRenderer cube_r8;
	private final AnimatedModelRenderer rGills;
	private final AnimatedModelRenderer cube_r9;
	private final AnimatedModelRenderer cube_r10;
	private final AnimatedModelRenderer cube_r11;
	private final AnimatedModelRenderer cube_r12;
	private final AnimatedModelRenderer cube_r13;
	private final AnimatedModelRenderer cube_r14;
	private final AnimatedModelRenderer face;
	private final AnimatedModelRenderer eyes;
	private final AnimatedModelRenderer eye2;
	private final AnimatedModelRenderer eye3;
	private final AnimatedModelRenderer eye11;
	private final AnimatedModelRenderer eye6;
	private final AnimatedModelRenderer eye4;
	private final AnimatedModelRenderer eye5;
	private final AnimatedModelRenderer eye12;
	private final AnimatedModelRenderer eye7;
	private final AnimatedModelRenderer eye10;
	private final AnimatedModelRenderer eye9;
	private final AnimatedModelRenderer eye8;
	private final AnimatedModelRenderer eye;
	private final AnimatedModelRenderer tentacles;
	private final AnimatedModelRenderer tent6;
	private final AnimatedModelRenderer tent7;
	private final AnimatedModelRenderer tent8;
	private final AnimatedModelRenderer tent9;
	private final AnimatedModelRenderer tent10;
	private final AnimatedModelRenderer tent22;
	private final AnimatedModelRenderer tent23;
	private final AnimatedModelRenderer tent24;
	private final AnimatedModelRenderer tent25;
	private final AnimatedModelRenderer tent26;
	private final AnimatedModelRenderer tent2;
	private final AnimatedModelRenderer tent3;
	private final AnimatedModelRenderer tent4;
	private final AnimatedModelRenderer tent5;
	private final AnimatedModelRenderer tent11;
	private final AnimatedModelRenderer tent12;
	private final AnimatedModelRenderer tent13;
	private final AnimatedModelRenderer tent14;
	private final AnimatedModelRenderer tent15;
	private final AnimatedModelRenderer tent16;
	private final AnimatedModelRenderer tent17;
	private final AnimatedModelRenderer tent18;
	private final AnimatedModelRenderer tent19;
	private final AnimatedModelRenderer tent20;
	private final AnimatedModelRenderer tent21;
	private final AnimatedModelRenderer armTent;
	private final AnimatedModelRenderer shoulder;
	private final AnimatedModelRenderer armEye;
	private final AnimatedModelRenderer seg3;
	private final AnimatedModelRenderer bone3;
	private final AnimatedModelRenderer seg2;
	private final AnimatedModelRenderer seg1;
	private final AnimatedModelRenderer hand;
	private final AnimatedModelRenderer armTent2;
	private final AnimatedModelRenderer shoulder2;
	private final AnimatedModelRenderer armEye2;
	private final AnimatedModelRenderer seg4;
	private final AnimatedModelRenderer bone2;
	private final AnimatedModelRenderer seg5;
	private final AnimatedModelRenderer seg6;
	private final AnimatedModelRenderer hand2;
	private final AnimatedModelRenderer armTent3;
	private final AnimatedModelRenderer shoulder3;
	private final AnimatedModelRenderer armEye3;
	private final AnimatedModelRenderer seg7;
	private final AnimatedModelRenderer bone4;
	private final AnimatedModelRenderer seg8;
	private final AnimatedModelRenderer seg9;
	private final AnimatedModelRenderer hand3;
	private final AnimatedModelRenderer armTent4;
	private final AnimatedModelRenderer shoulder4;
	private final AnimatedModelRenderer armEye4;
	private final AnimatedModelRenderer seg11;
	private final AnimatedModelRenderer bone6;
	private final AnimatedModelRenderer seg12;
	private final AnimatedModelRenderer seg13;
	private final AnimatedModelRenderer hand4;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer backEye;
	private final AnimatedModelRenderer backEye2;
	private final AnimatedModelRenderer backEye4;
	private final AnimatedModelRenderer backEye5;
	private final AnimatedModelRenderer backEye6;
	private final AnimatedModelRenderer backEye3;
	private final AnimatedModelRenderer leftArm;
	private final AnimatedModelRenderer lShoulder;
	private final AnimatedModelRenderer lBicep;
	private final AnimatedModelRenderer lElbow;
	private final AnimatedModelRenderer lFore;
	private final AnimatedModelRenderer lHand;
	private final AnimatedModelRenderer lUpperClaw;
	private final AnimatedModelRenderer lLowerClaw;
	private final AnimatedModelRenderer rightArm;
	private final AnimatedModelRenderer rShoulder;
	private final AnimatedModelRenderer rBicep;
	private final AnimatedModelRenderer rElbow;
	private final AnimatedModelRenderer rFore;
	private final AnimatedModelRenderer rHand;
	private final AnimatedModelRenderer rHTent1;
	private final AnimatedModelRenderer tent43;
	private final AnimatedModelRenderer tent44;
	private final AnimatedModelRenderer tent45;
	private final AnimatedModelRenderer tent46;
	private final AnimatedModelRenderer rHTent2;
	private final AnimatedModelRenderer tent47;
	private final AnimatedModelRenderer tent48;
	private final AnimatedModelRenderer tent49;
	private final AnimatedModelRenderer tent50;
	private final AnimatedModelRenderer rHTent3;
	private final AnimatedModelRenderer tent51;
	private final AnimatedModelRenderer tent52;
	private final AnimatedModelRenderer tent53;
	private final AnimatedModelRenderer tent54;
	private final AnimatedModelRenderer rHTent4;
	private final AnimatedModelRenderer tent55;
	private final AnimatedModelRenderer tent56;
	private final AnimatedModelRenderer tent57;
	private final AnimatedModelRenderer tent58;
	private final AnimatedModelRenderer tail;
	private final AnimatedModelRenderer foot;
	private final AnimatedModelRenderer bone5;
	private final AnimatedModelRenderer bone;
	private final AnimatedModelRenderer seg10;
	private final AnimatedModelRenderer endSeg;

	public ModelAnimator animator;
	public final AnimatedModelRenderer[] headArray;

	public ModelUzouthrhix() {
		textureWidth = 256;
		textureHeight = 256;

		wholeBody = new AnimatedModelRenderer(this);
		wholeBody.setRotationPoint(0.0F, 24.0F, 0.0F);

		lowerColumn = new AnimatedModelRenderer(this);
		lowerColumn.setRotationPoint(0.0F, -8.9545F, 13.8727F);
		wholeBody.addChild(lowerColumn);
		lowerColumn.setTextureOffset(118, 138).addBox(-3.0F, -3.0455F, -4.2727F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		lowerColumn.setTextureOffset(24, 136).addBox(-3.0F, -6.0455F, -6.2727F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		lowerColumn.setTextureOffset(112, 180).addBox(3.0F, -4.0455F, -5.2727F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		lowerColumn.setTextureOffset(150, 173).addBox(-4.0F, -4.0455F, -5.2727F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		lowerColumn.setTextureOffset(91, 180).addBox(3.0F, -7.0455F, -5.2727F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		lowerColumn.setTextureOffset(172, 34).addBox(-4.0F, -7.0455F, -5.2727F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		lowerColumn.setTextureOffset(178, 50).addBox(3.0F, -10.0455F, -5.2727F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		lowerColumn.setTextureOffset(94, 132).addBox(-3.0F, -9.0455F, -7.2727F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		lowerColumn.setTextureOffset(79, 172).addBox(-4.0F, -10.0455F, -5.2727F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		lowerColumn.setTextureOffset(106, 79).addBox(-1.0F, -2.0455F, 1.7273F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		lowerColumn.setTextureOffset(76, 89).addBox(-1.0F, -5.0455F, -3.2727F, 2.0F, 2.0F, 9.0F, 0.0F, false);

		upperColumn = new AnimatedModelRenderer(this);
		upperColumn.setRotationPoint(0.0F, -9.3455F, -0.5394F);
		lowerColumn.addChild(upperColumn);
		upperColumn.setTextureOffset(0, 178).addBox(3.0F, -3.7F, -4.7333F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		upperColumn.setTextureOffset(58, 172).addBox(-4.0F, -3.7F, -4.7333F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		upperColumn.setTextureOffset(176, 134).addBox(3.0F, -6.7F, -4.7333F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		upperColumn.setTextureOffset(171, 89).addBox(-4.0F, -6.7F, -4.7333F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		upperColumn.setTextureOffset(176, 62).addBox(3.0F, -9.7F, -4.7333F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		upperColumn.setTextureOffset(129, 171).addBox(-4.0F, -9.7F, -4.7333F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		upperColumn.setTextureOffset(168, 153).addBox(-1.0F, -13.7F, -0.7333F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		upperColumn.setTextureOffset(175, 116).addBox(3.0F, -11.7F, -0.7333F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		upperColumn.setTextureOffset(175, 175).addBox(-4.0F, -11.7F, -0.7333F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		upperColumn.setTextureOffset(0, 132).addBox(-3.0F, -2.7F, -5.7333F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		upperColumn.setTextureOffset(70, 126).addBox(-3.0F, -8.7F, -5.7333F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		upperColumn.setTextureOffset(130, 68).addBox(-3.0F, -5.7F, -6.7333F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		upperColumn.setTextureOffset(120, 102).addBox(-3.0F, -11.7F, -6.7333F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		upperColumn.setTextureOffset(110, 32).addBox(-4.0F, -14.7F, -8.7333F, 8.0F, 3.0F, 11.0F, 0.0F, false);
		upperColumn.setTextureOffset(48, 105).addBox(-5.0F, -16.7F, -8.7333F, 10.0F, 2.0F, 10.0F, 0.0F, false);

		upperTorso = new AnimatedModelRenderer(this);
		upperTorso.setRotationPoint(0.0F, -13.7F, -3.3333F);
		upperColumn.addChild(upperTorso);

		neck = new AnimatedModelRenderer(this);
		neck.setRotationPoint(-1.0F, -9.0F, -16.0F);
		upperTorso.addChild(neck);

		neck2 = new AnimatedModelRenderer(this);
		neck2.setRotationPoint(1.0F, 0.2851F, -1.6844F);
		neck.addChild(neck2);
		setRotateAngle(neck2, -0.6109F, 0.0F, 0.0F);
		neck2.setTextureOffset(102, 111).addBox(-0.5F, -6.4466F, -13.7689F, 1.0F, 5.0F, 15.0F, 0.0F, false);
		neck2.setTextureOffset(88, 89).addBox(-3.0F, -2.8485F, -13.0009F, 6.0F, 8.0F, 13.0F, 0.0F, false);
		neck2.setTextureOffset(28, 105).addBox(-1.0F, -4.8485F, -14.2689F, 2.0F, 5.0F, 15.0F, 0.0F, false);

		neck1 = new AnimatedModelRenderer(this);
		neck1.setRotationPoint(0.0F, -4.9597F, -14.479F);
		neck2.addChild(neck1);
		setRotateAngle(neck1, 0.5236F, 0.0F, 0.0F);

		cube_r2 = new AnimatedModelRenderer(this);
		cube_r2.setRotationPoint(6.0F, 1.7833F, 0.8289F);
		neck1.addChild(cube_r2);
		setRotateAngle(cube_r2, 0.5672F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(114, 79).addBox(-6.5F, -3.6405F, -12.0595F, 1.0F, 9.0F, 13.0F, 0.0F, false);
		cube_r2.setTextureOffset(120, 120).addBox(-8.5F, -3.6405F, -12.0595F, 1.0F, 2.0F, 15.0F, 0.0F, false);
		cube_r2.setTextureOffset(48, 118).addBox(-4.5F, -3.6405F, -12.0595F, 1.0F, 2.0F, 15.0F, 0.0F, false);
		cube_r2.setTextureOffset(67, 141).addBox(-5.0F, -1.6405F, -12.0595F, 2.0F, 8.0F, 11.0F, 0.0F, false);
		cube_r2.setTextureOffset(142, 142).addBox(-9.0F, -1.6405F, -12.0595F, 2.0F, 8.0F, 11.0F, 0.0F, false);
		cube_r2.setTextureOffset(144, 83).addBox(-7.0F, -1.6405F, -12.0595F, 2.0F, 8.0F, 11.0F, 0.0F, false);
		cube_r2.setTextureOffset(94, 147).addBox(-2.0F, -1.6405F, -12.0595F, 1.0F, 9.0F, 11.0F, 0.0F, false);
		cube_r2.setTextureOffset(22, 151).addBox(-11.0F, -1.6405F, -12.0595F, 1.0F, 9.0F, 11.0F, 0.0F, false);
		cube_r2.setTextureOffset(65, 68).addBox(-10.0F, -0.6405F, -12.0595F, 8.0F, 8.0F, 12.0F, 0.0F, false);

		lGills = new AnimatedModelRenderer(this);
		lGills.setRotationPoint(2.0F, 7.4698F, -1.3881F);
		neck1.addChild(lGills);

		cube_r3 = new AnimatedModelRenderer(this);
		cube_r3.setRotationPoint(7.0F, 1.8135F, 7.017F);
		lGills.addChild(cube_r3);
		setRotateAngle(cube_r3, 0.5672F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(86, 197).addBox(-4.0F, -9.0F, -5.0F, 3.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r4 = new AnimatedModelRenderer(this);
		cube_r4.setRotationPoint(7.0F, 1.3135F, 6.217F);
		lGills.addChild(cube_r4);
		setRotateAngle(cube_r4, 0.5672F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(114, 199).addBox(-4.0F, -9.0F, -5.0F, 2.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r5 = new AnimatedModelRenderer(this);
		cube_r5.setRotationPoint(7.0F, 2.3135F, 6.217F);
		lGills.addChild(cube_r5);
		setRotateAngle(cube_r5, 0.5672F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(197, 197).addBox(-4.0F, -9.0F, -5.0F, 3.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r6 = new AnimatedModelRenderer(this);
		cube_r6.setRotationPoint(7.0F, 2.3135F, 5.217F);
		lGills.addChild(cube_r6);
		setRotateAngle(cube_r6, 0.5672F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(119, 199).addBox(-4.0F, -9.0F, -5.0F, 2.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r7 = new AnimatedModelRenderer(this);
		cube_r7.setRotationPoint(7.0F, 2.5135F, 4.217F);
		lGills.addChild(cube_r7);
		setRotateAngle(cube_r7, 0.5672F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(91, 161).addBox(-4.0F, -9.0F, -5.0F, 1.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r8 = new AnimatedModelRenderer(this);
		cube_r8.setRotationPoint(7.0F, 2.2135F, 7.817F);
		lGills.addChild(cube_r8);
		setRotateAngle(cube_r8, 0.5672F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(102, 147).addBox(-4.0F, -9.0F, -5.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		rGills = new AnimatedModelRenderer(this);
		rGills.setRotationPoint(-2.0F, 7.2833F, -2.3711F);
		neck1.addChild(rGills);

		cube_r9 = new AnimatedModelRenderer(this);
		cube_r9.setRotationPoint(-2.0F, 2.0F, 8.0F);
		rGills.addChild(cube_r9);
		setRotateAngle(cube_r9, 0.5672F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(28, 64).addBox(-4.0F, -9.0F, -5.0F, 3.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r10 = new AnimatedModelRenderer(this);
		cube_r10.setRotationPoint(-1.0F, 1.5F, 7.2F);
		rGills.addChild(cube_r10);
		setRotateAngle(cube_r10, 0.5672F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(64, 136).addBox(-4.0F, -9.0F, -5.0F, 2.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r11 = new AnimatedModelRenderer(this);
		cube_r11.setRotationPoint(-2.0F, 2.5F, 7.2F);
		rGills.addChild(cube_r11);
		setRotateAngle(cube_r11, 0.5672F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(173, 30).addBox(-4.0F, -9.0F, -5.0F, 3.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r12 = new AnimatedModelRenderer(this);
		cube_r12.setRotationPoint(-1.0F, 2.5F, 6.2F);
		rGills.addChild(cube_r12);
		setRotateAngle(cube_r12, 0.5672F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(17, 160).addBox(-4.0F, -9.0F, -5.0F, 2.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r13 = new AnimatedModelRenderer(this);
		cube_r13.setRotationPoint(0.0F, 2.7F, 5.2F);
		rGills.addChild(cube_r13);
		setRotateAngle(cube_r13, 0.5672F, 0.0F, 0.0F);
		cube_r13.setTextureOffset(127, 102).addBox(-4.0F, -9.0F, -5.0F, 1.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r14 = new AnimatedModelRenderer(this);
		cube_r14.setRotationPoint(0.0F, 2.4F, 8.8F);
		rGills.addChild(cube_r14);
		setRotateAngle(cube_r14, 0.5672F, 0.0F, 0.0F);
		cube_r14.setTextureOffset(62, 31).addBox(-4.0F, -9.0F, -5.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		face = new AnimatedModelRenderer(this);
		face.setRotationPoint(0.0F, 11.826F, -5.5472F);
		neck1.addChild(face);
		face.setTextureOffset(138, 28).addBox(-6.0F, -5.3562F, -4.8409F, 12.0F, 9.0F, 5.0F, 0.0F, false);

		eyes = new AnimatedModelRenderer(this);
		eyes.setRotationPoint(-4.5F, 12.1438F, 7.6591F);
		face.addChild(eyes);

		eye2 = new AnimatedModelRenderer(this);
		eye2.setRotationPoint(9.1F, -15.0F, -13.0F);
		eyes.addChild(eye2);
		eye2.setTextureOffset(73, 197).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		eye3 = new AnimatedModelRenderer(this);
		eye3.setRotationPoint(4.5F, -18.0F, -13.0F);
		eyes.addChild(eye3);
		eye3.setTextureOffset(196, 165).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		eye11 = new AnimatedModelRenderer(this);
		eye11.setRotationPoint(7.5F, -8.0F, -13.0F);
		eyes.addChild(eye11);
		eye11.setTextureOffset(196, 113).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		eye6 = new AnimatedModelRenderer(this);
		eye6.setRotationPoint(6.0F, -14.5F, -13.5F);
		eyes.addChild(eye6);
		eye6.setTextureOffset(44, 202).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye4 = new AnimatedModelRenderer(this);
		eye4.setRotationPoint(1.0F, -11.5F, -13.5F);
		eyes.addChild(eye4);
		eye4.setTextureOffset(201, 152).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye5 = new AnimatedModelRenderer(this);
		eye5.setRotationPoint(3.0F, -15.5F, -13.5F);
		eyes.addChild(eye5);
		eye5.setTextureOffset(201, 134).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye12 = new AnimatedModelRenderer(this);
		eye12.setRotationPoint(-1.7F, -11.9F, -12.5F);
		eyes.addChild(eye12);
		eye12.setTextureOffset(157, 201).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye7 = new AnimatedModelRenderer(this);
		eye7.setRotationPoint(10.0F, -17.5F, -12.5F);
		eyes.addChild(eye7);
		eye7.setTextureOffset(201, 91).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye10 = new AnimatedModelRenderer(this);
		eye10.setRotationPoint(0.0F, -8.5F, -12.5F);
		eyes.addChild(eye10);
		eye10.setTextureOffset(166, 201).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye9 = new AnimatedModelRenderer(this);
		eye9.setRotationPoint(4.0F, -10.5F, -12.5F);
		eyes.addChild(eye9);
		eye9.setTextureOffset(175, 201).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye8 = new AnimatedModelRenderer(this);
		eye8.setRotationPoint(10.0F, -10.5F, -12.5F);
		eyes.addChild(eye8);
		eye8.setTextureOffset(201, 27).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye = new AnimatedModelRenderer(this);
		eye.setRotationPoint(-0.3F, -16.2F, -13.0F);
		eyes.addChild(eye);
		eye.setTextureOffset(184, 197).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		tentacles = new AnimatedModelRenderer(this);
		tentacles.setRotationPoint(0.0F, 0.6438F, -4.8409F);
		face.addChild(tentacles);

		tent6 = new AnimatedModelRenderer(this);
		tent6.setRotationPoint(-5.9F, -1.0F, 1.0F);
		tentacles.addChild(tent6);
		setRotateAngle(tent6, 0.48F, 0.0F, 0.0F);
		tent6.setTextureOffset(0, 197).addBox(-1.0F, -1.9235F, -3.774F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent7 = new AnimatedModelRenderer(this);
		tent7.setRotationPoint(0.1F, -0.4982F, -3.1228F);
		tent6.addChild(tent7);
		setRotateAngle(tent7, 0.48F, 0.0F, 0.0F);
		tent7.setTextureOffset(196, 180).addBox(-1.09F, -1.5649F, -3.9195F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent8 = new AnimatedModelRenderer(this);
		tent8.setRotationPoint(-0.1F, -0.2873F, -3.5936F);
		tent7.addChild(tent8);
		setRotateAngle(tent8, 0.5236F, 0.0F, 0.0F);
		tent8.setTextureOffset(196, 173).addBox(-1.0F, -1.2695F, -3.6435F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent9 = new AnimatedModelRenderer(this);
		tent9.setRotationPoint(0.1F, -0.2079F, -3.361F);
		tent8.addChild(tent9);
		setRotateAngle(tent9, 0.6545F, 0.0F, 0.0F);
		tent9.setTextureOffset(196, 120).addBox(-1.09F, -1.0142F, -3.5778F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent10 = new AnimatedModelRenderer(this);
		tent10.setRotationPoint(0.0F, 0.0749F, -3.6048F);
		tent9.addChild(tent10);
		setRotateAngle(tent10, 0.2182F, 0.0F, 0.0F);
		tent10.setTextureOffset(53, 202).addBox(-0.7F, -0.4611F, -2.1723F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		tent22 = new AnimatedModelRenderer(this);
		tent22.setRotationPoint(6.1F, -1.0F, 1.0F);
		tentacles.addChild(tent22);
		setRotateAngle(tent22, 0.48F, 0.0F, 0.0F);
		tent22.setTextureOffset(0, 197).addBox(-1.0F, -1.9235F, -3.774F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent23 = new AnimatedModelRenderer(this);
		tent23.setRotationPoint(0.1F, -0.4982F, -3.1228F);
		tent22.addChild(tent23);
		setRotateAngle(tent23, 0.48F, 0.0F, 0.0F);
		tent23.setTextureOffset(196, 180).addBox(-1.09F, -1.5649F, -3.9195F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent24 = new AnimatedModelRenderer(this);
		tent24.setRotationPoint(-0.1F, -0.2873F, -3.5936F);
		tent23.addChild(tent24);
		setRotateAngle(tent24, 0.5236F, 0.0F, 0.0F);
		tent24.setTextureOffset(196, 173).addBox(-1.0F, -1.2695F, -3.6435F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent25 = new AnimatedModelRenderer(this);
		tent25.setRotationPoint(0.1F, -0.2079F, -3.361F);
		tent24.addChild(tent25);
		setRotateAngle(tent25, 0.6545F, 0.0F, 0.0F);
		tent25.setTextureOffset(196, 120).addBox(-1.09F, -1.0142F, -3.5778F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent26 = new AnimatedModelRenderer(this);
		tent26.setRotationPoint(0.0F, 0.0749F, -3.6048F);
		tent25.addChild(tent26);
		setRotateAngle(tent26, 0.2182F, 0.0F, 0.0F);
		tent26.setTextureOffset(53, 202).addBox(-0.7F, -0.4611F, -2.1723F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		tent2 = new AnimatedModelRenderer(this);
		tent2.setRotationPoint(2.2F, -1.6F, 1.0F);
		tentacles.addChild(tent2);
		setRotateAngle(tent2, 0.48F, 0.0F, 0.0F);
		tent2.setTextureOffset(0, 197).addBox(-1.0F, -1.9235F, -3.774F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent3 = new AnimatedModelRenderer(this);
		tent3.setRotationPoint(0.1F, -0.4982F, -3.1228F);
		tent2.addChild(tent3);
		setRotateAngle(tent3, 0.48F, 0.0F, 0.0F);
		tent3.setTextureOffset(196, 180).addBox(-1.09F, -1.5649F, -3.9195F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent4 = new AnimatedModelRenderer(this);
		tent4.setRotationPoint(-0.1F, -0.2873F, -3.5936F);
		tent3.addChild(tent4);
		setRotateAngle(tent4, 0.5236F, 0.0F, 0.0F);
		tent4.setTextureOffset(196, 173).addBox(-1.0F, -1.2695F, -3.6435F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent5 = new AnimatedModelRenderer(this);
		tent5.setRotationPoint(0.1F, -0.2079F, -3.361F);
		tent4.addChild(tent5);
		setRotateAngle(tent5, 0.6545F, 0.0F, 0.0F);
		tent5.setTextureOffset(196, 120).addBox(-1.09F, -1.0142F, -3.5778F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent11 = new AnimatedModelRenderer(this);
		tent11.setRotationPoint(0.0F, 0.0749F, -3.6048F);
		tent5.addChild(tent11);
		setRotateAngle(tent11, 0.2182F, 0.0F, 0.0F);
		tent11.setTextureOffset(53, 202).addBox(-0.7F, -0.4611F, -2.1723F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		tent12 = new AnimatedModelRenderer(this);
		tent12.setRotationPoint(-2.5F, 2.7F, 1.0F);
		tentacles.addChild(tent12);
		setRotateAngle(tent12, 0.48F, 0.0F, 0.0F);
		tent12.setTextureOffset(0, 197).addBox(-1.0F, -1.9235F, -3.774F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent13 = new AnimatedModelRenderer(this);
		tent13.setRotationPoint(0.1F, -0.4982F, -3.1228F);
		tent12.addChild(tent13);
		setRotateAngle(tent13, 0.48F, 0.0F, 0.0F);
		tent13.setTextureOffset(196, 180).addBox(-1.09F, -1.5649F, -3.9195F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent14 = new AnimatedModelRenderer(this);
		tent14.setRotationPoint(-0.1F, -1.9256F, -4.7407F);
		tent13.addChild(tent14);
		setRotateAngle(tent14, 0.5236F, 0.0F, 0.0F);
		tent14.setTextureOffset(196, 173).addBox(-1.0F, 0.7229F, -3.4692F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent15 = new AnimatedModelRenderer(this);
		tent15.setRotationPoint(0.1F, 1.7845F, -3.1867F);
		tent14.addChild(tent15);
		setRotateAngle(tent15, 0.6545F, 0.0F, 0.0F);
		tent15.setTextureOffset(196, 120).addBox(-1.09F, -1.0142F, -3.5778F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent16 = new AnimatedModelRenderer(this);
		tent16.setRotationPoint(0.0F, 0.0749F, -3.6048F);
		tent15.addChild(tent16);
		setRotateAngle(tent16, 0.2182F, 0.0F, 0.0F);
		tent16.setTextureOffset(53, 202).addBox(-0.7F, -0.4611F, -2.1723F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		tent17 = new AnimatedModelRenderer(this);
		tent17.setRotationPoint(-0.9F, 0.0F, 1.0F);
		tentacles.addChild(tent17);
		setRotateAngle(tent17, 0.48F, 0.0F, 0.0F);
		tent17.setTextureOffset(0, 197).addBox(-1.0F, -1.9235F, -3.774F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent18 = new AnimatedModelRenderer(this);
		tent18.setRotationPoint(0.1F, -0.4982F, -3.1228F);
		tent17.addChild(tent18);
		setRotateAngle(tent18, 0.48F, 0.0F, 0.0F);
		tent18.setTextureOffset(196, 180).addBox(-1.09F, -1.5649F, -3.9195F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent19 = new AnimatedModelRenderer(this);
		tent19.setRotationPoint(-0.1F, -0.2873F, -3.5936F);
		tent18.addChild(tent19);
		setRotateAngle(tent19, 0.5236F, 0.0F, 0.0F);
		tent19.setTextureOffset(196, 173).addBox(-1.0F, -1.2695F, -3.6435F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent20 = new AnimatedModelRenderer(this);
		tent20.setRotationPoint(0.1F, -0.2079F, -3.361F);
		tent19.addChild(tent20);
		setRotateAngle(tent20, 0.6545F, 0.0F, 0.0F);
		tent20.setTextureOffset(196, 120).addBox(-1.09F, -1.0142F, -3.5778F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent21 = new AnimatedModelRenderer(this);
		tent21.setRotationPoint(0.0F, 0.0749F, -3.6048F);
		tent20.addChild(tent21);
		setRotateAngle(tent21, 0.2182F, 0.0F, 0.0F);
		tent21.setTextureOffset(53, 202).addBox(-0.7F, -0.4611F, -2.1723F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		armTent = new AnimatedModelRenderer(this);
		armTent.setRotationPoint(7.5F, -3.9333F, -8.5F);
		upperTorso.addChild(armTent);

		shoulder = new AnimatedModelRenderer(this);
		shoulder.setRotationPoint(0.0F, -0.2F, 0.0F);
		armTent.addChild(shoulder);
		shoulder.setTextureOffset(68, 184).addBox(0.0F, -1.8F, -3.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
		shoulder.setTextureOffset(150, 185).addBox(0.5F, -2.2F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		shoulder.setTextureOffset(47, 161).addBox(0.5F, -1.3667F, 2.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder.setTextureOffset(157, 114).addBox(0.5F, -1.3667F, -3.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder.setTextureOffset(0, 132).addBox(1.6F, -1.6667F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		shoulder.setTextureOffset(175, 146).addBox(1.8F, -0.6667F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		armEye = new AnimatedModelRenderer(this);
		armEye.setRotationPoint(2.7F, 10.4333F, 0.0F);
		shoulder.addChild(armEye);
		armEye.setTextureOffset(150, 179).addBox(-0.4F, -10.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		seg3 = new AnimatedModelRenderer(this);
		seg3.setRotationPoint(0.621F, 2.0767F, -0.5F);
		shoulder.addChild(seg3);
		seg3.setTextureOffset(48, 136).addBox(-0.121F, 0.0566F, -1.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		seg3.setTextureOffset(183, 146).addBox(0.379F, 0.0566F, 0.2F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg3.setTextureOffset(198, 187).addBox(0.379F, 0.0566F, -1.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg3.setTextureOffset(202, 66).addBox(1.179F, -0.7434F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		bone3 = new AnimatedModelRenderer(this);
		bone3.setRotationPoint(0.9981F, 5.0712F, 0.5F);
		seg3.addChild(bone3);

		seg2 = new AnimatedModelRenderer(this);
		seg2.setRotationPoint(0.381F, -0.0145F, 0.0F);
		bone3.addChild(seg2);
		seg2.setTextureOffset(0, 160).addBox(-1.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg2.setTextureOffset(107, 199).addBox(-1.0F, 0.0F, -1.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg2.setTextureOffset(37, 203).addBox(-0.2F, 0.2F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		seg1 = new AnimatedModelRenderer(this);
		seg1.setRotationPoint(0.0F, 5.0F, 0.0F);
		seg2.addChild(seg1);
		seg1.setTextureOffset(100, 199).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg1.setTextureOffset(93, 199).addBox(-1.0F, 0.0F, -0.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg1.setTextureOffset(0, 147).addBox(-1.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg1.setTextureOffset(72, 204).addBox(-0.2F, 1.2F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		hand = new AnimatedModelRenderer(this);
		hand.setRotationPoint(-0.4667F, 4.9467F, 0.0467F);
		seg1.addChild(hand);
		hand.setTextureOffset(86, 184).addBox(-0.8333F, 1.0533F, 0.5533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand.setTextureOffset(134, 183).addBox(-0.8333F, 2.6533F, 0.7533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand.setTextureOffset(182, 158).addBox(-0.8333F, 3.2533F, -1.2467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand.setTextureOffset(181, 170).addBox(-0.8333F, 0.4533F, -1.1467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand.setTextureOffset(181, 74).addBox(-0.8333F, 4.5533F, -0.4467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand.setTextureOffset(180, 134).addBox(-0.8333F, 2.0533F, -0.4467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand.setTextureOffset(124, 180).addBox(-0.8333F, 1.7533F, -1.7467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand.setTextureOffset(190, 190).addBox(-0.4333F, 1.0533F, -2.4467F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		hand.setTextureOffset(35, 196).addBox(-0.4333F, 2.0533F, -1.9467F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		hand.setTextureOffset(139, 201).addBox(-0.4333F, 4.0533F, -1.4467F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		hand.setTextureOffset(130, 201).addBox(-0.4333F, 0.0533F, -1.4467F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		hand.setTextureOffset(10, 21).addBox(0.0667F, 0.8533F, -0.9467F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		hand.setTextureOffset(171, 94).addBox(-0.4333F, 5.0533F, -0.9467F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		hand.setTextureOffset(179, 116).addBox(0.0667F, 4.8533F, -0.5467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand.setTextureOffset(77, 204).addBox(0.3667F, 0.2533F, -0.5467F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		armTent2 = new AnimatedModelRenderer(this);
		armTent2.setRotationPoint(-8.5F, -3.9333F, -8.5F);
		upperTorso.addChild(armTent2);
		setRotateAngle(armTent2, 0.0F, 3.1416F, 0.4363F);

		shoulder2 = new AnimatedModelRenderer(this);
		shoulder2.setRotationPoint(0.0F, -0.0667F, 0.0F);
		armTent2.addChild(shoulder2);
		shoulder2.setTextureOffset(133, 183).addBox(0.0F, -1.9333F, -3.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
		shoulder2.setTextureOffset(108, 148).addBox(0.5F, -2.3333F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		shoulder2.setTextureOffset(119, 157).addBox(0.5F, -1.5F, 2.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder2.setTextureOffset(146, 117).addBox(0.5F, -1.5F, -3.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder2.setTextureOffset(94, 128).addBox(1.6F, -1.8F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		shoulder2.setTextureOffset(19, 173).addBox(1.8F, -0.8F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		armEye2 = new AnimatedModelRenderer(this);
		armEye2.setRotationPoint(2.7F, 10.3F, 0.0F);
		shoulder2.addChild(armEye2);
		armEye2.setTextureOffset(70, 178).addBox(-0.4F, -10.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		seg4 = new AnimatedModelRenderer(this);
		seg4.setRotationPoint(1.4662F, 0.1308F, 0.0F);
		shoulder2.addChild(seg4);
		seg4.setTextureOffset(106, 111).addBox(-0.9662F, 1.8692F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		seg4.setTextureOffset(180, 50).addBox(-0.4662F, 1.8692F, -0.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg4.setTextureOffset(12, 178).addBox(-0.4662F, 1.8692F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg4.setTextureOffset(67, 202).addBox(0.3338F, 1.0692F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		bone2 = new AnimatedModelRenderer(this);
		bone2.setRotationPoint(0.1529F, 6.8838F, 0.0F);
		seg4.addChild(bone2);

		seg5 = new AnimatedModelRenderer(this);
		seg5.setRotationPoint(-0.3473F, -0.2843F, 0.0F);
		bone2.addChild(seg5);
		seg5.setTextureOffset(128, 0).addBox(-0.7717F, 0.2698F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg5.setTextureOffset(169, 153).addBox(-0.2717F, 0.2698F, -1.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg5.setTextureOffset(202, 139).addBox(0.5283F, 0.4698F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		seg6 = new AnimatedModelRenderer(this);
		seg6.setRotationPoint(0.0F, 5.0F, 0.0F);
		seg5.addChild(seg6);
		seg6.setTextureOffset(158, 143).addBox(-0.2717F, 0.2698F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg6.setTextureOffset(83, 141).addBox(-0.2717F, 0.2698F, -0.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg6.setTextureOffset(0, 118).addBox(-0.7717F, 0.2698F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg6.setTextureOffset(0, 204).addBox(0.5283F, 1.4698F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		hand2 = new AnimatedModelRenderer(this);
		hand2.setRotationPoint(0.4396F, 5.3693F, 0.0467F);
		seg6.addChild(hand2);
		hand2.setTextureOffset(176, 170).addBox(-1.0113F, 0.9005F, 0.5533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand2.setTextureOffset(175, 129).addBox(-1.0113F, 2.5005F, 0.7533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand2.setTextureOffset(116, 174).addBox(-1.0113F, 3.1005F, -1.2467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand2.setTextureOffset(111, 174).addBox(-1.0113F, 0.3005F, -1.1467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand2.setTextureOffset(106, 174).addBox(-1.0113F, 4.4005F, -0.4467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand2.setTextureOffset(173, 40).addBox(-1.0113F, 1.9005F, -0.4467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand2.setTextureOffset(60, 172).addBox(-1.0113F, 1.6005F, -1.7467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand2.setTextureOffset(80, 190).addBox(-0.6113F, 0.9005F, -2.4467F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		hand2.setTextureOffset(142, 142).addBox(-0.6113F, 1.9005F, -1.9467F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		hand2.setTextureOffset(193, 84).addBox(-0.6113F, 3.9005F, -1.4467F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		hand2.setTextureOffset(158, 185).addBox(-0.6113F, -0.0995F, -1.4467F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		hand2.setTextureOffset(0, 21).addBox(-0.1113F, 0.7005F, -0.9467F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		hand2.setTextureOffset(134, 153).addBox(-0.6113F, 4.9005F, -0.9467F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		hand2.setTextureOffset(41, 172).addBox(-0.1113F, 4.7005F, -0.5467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand2.setTextureOffset(5, 204).addBox(0.1887F, 0.1005F, -0.5467F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		armTent3 = new AnimatedModelRenderer(this);
		armTent3.setRotationPoint(-4.5F, -0.9333F, -2.5F);
		upperTorso.addChild(armTent3);
		setRotateAngle(armTent3, 0.0F, 3.1416F, 0.4363F);

		shoulder3 = new AnimatedModelRenderer(this);
		shoulder3.setRotationPoint(0.0F, -0.0667F, 0.0F);
		armTent3.addChild(shoulder3);
		shoulder3.setTextureOffset(182, 11).addBox(0.0F, -1.9333F, -3.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
		shoulder3.setTextureOffset(64, 141).addBox(0.5F, -2.3333F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		shoulder3.setTextureOffset(72, 141).addBox(0.5F, -1.5F, 2.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder3.setTextureOffset(138, 117).addBox(0.5F, -1.5F, -3.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder3.setTextureOffset(32, 103).addBox(1.6F, -1.8F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		shoulder3.setTextureOffset(128, 117).addBox(1.8F, -0.8F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		armEye3 = new AnimatedModelRenderer(this);
		armEye3.setRotationPoint(2.7F, 10.3F, 0.0F);
		shoulder3.addChild(armEye3);
		armEye3.setTextureOffset(168, 30).addBox(-0.4F, -10.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		seg7 = new AnimatedModelRenderer(this);
		seg7.setRotationPoint(1.0436F, 1.0371F, -0.5F);
		shoulder3.addChild(seg7);
		setRotateAngle(seg7, -0.3054F, 0.0F, 0.0F);
		seg7.setTextureOffset(0, 103).addBox(-0.5436F, 0.9629F, -1.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		seg7.setTextureOffset(118, 67).addBox(-0.0436F, 0.9629F, 0.2F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg7.setTextureOffset(113, 14).addBox(-0.0436F, 0.9629F, -1.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg7.setTextureOffset(62, 202).addBox(0.7564F, 0.1629F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		bone4 = new AnimatedModelRenderer(this);
		bone4.setRotationPoint(0.5755F, 5.9775F, 0.5F);
		seg7.addChild(bone4);
		setRotateAngle(bone4, 0.2182F, 0.0F, 0.0F);

		seg8 = new AnimatedModelRenderer(this);
		seg8.setRotationPoint(0.381F, 9.9855F, 0.0F);
		bone4.addChild(seg8);
		seg8.setTextureOffset(79, 105).addBox(-1.5F, -10.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg8.setTextureOffset(101, 0).addBox(-1.0F, -10.0F, -1.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg8.setTextureOffset(46, 187).addBox(-0.2F, -9.8F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		seg9 = new AnimatedModelRenderer(this);
		seg9.setRotationPoint(-0.7283F, -5.2698F, 0.0F);
		seg8.addChild(seg9);
		seg9.setTextureOffset(98, 20).addBox(-0.2717F, 0.2698F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg9.setTextureOffset(69, 66).addBox(-0.2717F, 0.2698F, -0.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg9.setTextureOffset(48, 105).addBox(-0.7717F, 0.2698F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg9.setTextureOffset(108, 147).addBox(0.5283F, 1.4698F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		hand3 = new AnimatedModelRenderer(this);
		hand3.setRotationPoint(0.4396F, 5.3693F, 0.0467F);
		seg9.addChild(hand3);
		hand3.setTextureOffset(140, 168).addBox(-1.0113F, 0.9005F, 0.5533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand3.setTextureOffset(135, 168).addBox(-1.0113F, 2.5005F, 0.7533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand3.setTextureOffset(94, 168).addBox(-1.0113F, 3.1005F, -1.2467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand3.setTextureOffset(146, 162).addBox(-1.0113F, 0.3005F, -1.1467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand3.setTextureOffset(154, 43).addBox(-1.0113F, 4.4005F, -0.4467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand3.setTextureOffset(153, 137).addBox(-1.0113F, 1.9005F, -0.4467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand3.setTextureOffset(152, 103).addBox(-1.0113F, 1.6005F, -1.7467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand3.setTextureOffset(38, 189).addBox(-0.6113F, 0.9005F, -2.4467F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		hand3.setTextureOffset(24, 136).addBox(-0.6113F, 1.9005F, -1.9467F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		hand3.setTextureOffset(184, 106).addBox(-0.6113F, 3.9005F, -1.4467F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		hand3.setTextureOffset(90, 184).addBox(-0.6113F, -0.0995F, -1.4467F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		hand3.setTextureOffset(10, 0).addBox(-0.1113F, 0.7005F, -0.9467F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		hand3.setTextureOffset(41, 132).addBox(-0.6113F, 4.9005F, -0.9467F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		hand3.setTextureOffset(61, 152).addBox(-0.1113F, 4.7005F, -0.5467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand3.setTextureOffset(182, 11).addBox(0.1887F, 0.1005F, -0.5467F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		armTent4 = new AnimatedModelRenderer(this);
		armTent4.setRotationPoint(-5.5F, -7.9333F, -4.5F);
		upperTorso.addChild(armTent4);
		setRotateAngle(armTent4, 0.0F, 3.1416F, 2.138F);

		shoulder4 = new AnimatedModelRenderer(this);
		shoulder4.setRotationPoint(0.0F, -0.0667F, 0.0F);
		armTent4.addChild(shoulder4);
		shoulder4.setTextureOffset(94, 61).addBox(0.0F, -1.9333F, -3.0F, 2.0F, 4.0F, 6.0F, 0.0F, false);
		shoulder4.setTextureOffset(120, 117).addBox(0.5F, -2.3333F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		shoulder4.setTextureOffset(120, 117).addBox(0.5F, -1.5F, 2.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder4.setTextureOffset(60, 80).addBox(0.5F, -1.5F, -3.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder4.setTextureOffset(90, 89).addBox(1.6F, -1.8F, -2.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		shoulder4.setTextureOffset(56, 126).addBox(1.8F, -0.8F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		armEye4 = new AnimatedModelRenderer(this);
		armEye4.setRotationPoint(2.7F, 10.3F, 0.0F);
		shoulder4.addChild(armEye4);
		armEye4.setTextureOffset(147, 128).addBox(-0.4F, -10.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		seg11 = new AnimatedModelRenderer(this);
		seg11.setRotationPoint(0.621F, 1.9434F, 0.5F);
		shoulder4.addChild(seg11);
		seg11.setTextureOffset(74, 46).addBox(-0.121F, 0.0566F, -2.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		seg11.setTextureOffset(11, 64).addBox(0.379F, 0.0566F, -0.8F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg11.setTextureOffset(0, 64).addBox(0.379F, 0.0566F, -2.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg11.setTextureOffset(66, 118).addBox(1.179F, -0.7434F, -1.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		bone6 = new AnimatedModelRenderer(this);
		bone6.setRotationPoint(0.9981F, 5.0712F, -0.5F);
		seg11.addChild(bone6);

		seg12 = new AnimatedModelRenderer(this);
		seg12.setRotationPoint(-0.3812F, 0.0146F, 0.0F);
		bone6.addChild(seg12);
		seg12.setTextureOffset(76, 89).addBox(-0.7378F, -0.0291F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg12.setTextureOffset(43, 21).addBox(-0.2378F, -0.0291F, -1.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg12.setTextureOffset(0, 53).addBox(0.5622F, 0.1709F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		seg13 = new AnimatedModelRenderer(this);
		seg13.setRotationPoint(0.0F, 5.0F, 0.0F);
		seg12.addChild(seg13);
		seg13.setTextureOffset(42, 0).addBox(-0.2378F, -0.0291F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg13.setTextureOffset(0, 40).addBox(-0.2378F, -0.0291F, -0.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg13.setTextureOffset(0, 84).addBox(-0.7378F, -0.0291F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg13.setTextureOffset(105, 61).addBox(0.5622F, 1.1709F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		hand4 = new AnimatedModelRenderer(this);
		hand4.setRotationPoint(0.2924F, 5.4302F, 0.0467F);
		seg13.addChild(hand4);
		hand4.setTextureOffset(146, 50).addBox(-0.8301F, 0.5407F, 0.5533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand4.setTextureOffset(139, 47).addBox(-0.8301F, 2.1407F, 0.7533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand4.setTextureOffset(124, 138).addBox(-0.8301F, 2.7407F, -1.2467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand4.setTextureOffset(132, 52).addBox(-0.8301F, -0.0593F, -1.1467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand4.setTextureOffset(127, 132).addBox(-0.8301F, 4.0407F, -0.4467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand4.setTextureOffset(122, 28).addBox(-0.8301F, 1.5407F, -0.4467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand4.setTextureOffset(50, 88).addBox(-0.8301F, 1.2407F, -1.7467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand4.setTextureOffset(168, 71).addBox(-0.4301F, 0.5407F, -2.4467F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		hand4.setTextureOffset(54, 53).addBox(-0.4301F, 1.5407F, -1.9467F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		hand4.setTextureOffset(183, 93).addBox(-0.4301F, 3.5407F, -1.4467F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		hand4.setTextureOffset(144, 183).addBox(-0.4301F, -0.4593F, -1.4467F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		hand4.setTextureOffset(0, 0).addBox(0.0699F, 0.3407F, -0.9467F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		hand4.setTextureOffset(34, 84).addBox(-0.4301F, 4.5407F, -0.9467F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		hand4.setTextureOffset(41, 80).addBox(0.0699F, 4.3407F, -0.5467F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		hand4.setTextureOffset(106, 79).addBox(0.3699F, -0.2593F, -0.5467F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(-1.0F, 1.0F, -19.0F);
		upperTorso.addChild(body);
		body.setTextureOffset(42, 0).addBox(-12.0F, -12.0F, -1.0F, 25.0F, 1.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(43, 21).addBox(-11.0F, -13.0F, -1.0F, 23.0F, 1.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(154, 60).addBox(-3.0F, -16.0F, 0.0F, 8.0F, 3.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(168, 13).addBox(0.0F, -5.0F, 17.6F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		body.setTextureOffset(115, 168).addBox(0.0F, -8.0F, 14.6F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		body.setTextureOffset(92, 168).addBox(0.0F, -12.0F, 14.6F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		body.setTextureOffset(83, 141).addBox(-1.0F, -18.0F, 0.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(182, 146).addBox(-7.0F, -15.0F, 0.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(163, 182).addBox(7.0F, -15.0F, 0.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(0, 21).addBox(-3.0F, -14.0F, 7.0F, 1.0F, 4.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(4.0F, -14.0F, 7.0F, 1.0F, 4.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(184, 34).addBox(-6.0F, -14.0F, 7.0F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(182, 25).addBox(6.0F, -14.0F, 7.0F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(183, 82).addBox(-1.0F, -13.0F, 14.0F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(118, 67).addBox(2.0F, -18.0F, 0.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(51, 184).addBox(2.0F, -13.0F, 14.0F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(165, 0).addBox(-2.0F, -13.0F, 7.0F, 6.0F, 3.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(0, 53).addBox(-11.0F, -7.0F, 0.0F, 23.0F, 3.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(151, 43).addBox(-2.0F, -11.0F, 14.0F, 6.0F, 7.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(0, 40).addBox(-11.0F, -11.0F, -1.0F, 24.0F, 4.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(28, 66).addBox(-7.0F, -8.0F, 7.6F, 16.0F, 5.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(57, 32).addBox(-8.0F, -12.0F, 5.0F, 18.0F, 5.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(113, 14).addBox(-4.5F, -7.0F, 5.0F, 11.0F, 5.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(118, 55).addBox(-5.5F, -3.0F, 10.5F, 13.0F, 5.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(0, 84).addBox(-5.0F, -10.0F, 9.6F, 12.0F, 9.0F, 9.0F, 0.0F, false);

		backEye = new AnimatedModelRenderer(this);
		backEye.setRotationPoint(1.0F, -13.7F, 10.0F);
		body.addChild(backEye);
		backEye.setTextureOffset(93, 192).addBox(-1.5F, -2.3F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		backEye.setTextureOffset(0, 168).addBox(-1.5F, -0.3F, 1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backEye.setTextureOffset(155, 6).addBox(-1.5F, -0.3F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backEye.setTextureOffset(28, 201).addBox(-2.5F, -0.3F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		backEye.setTextureOffset(19, 201).addBox(1.5F, -0.3F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		backEye2 = new AnimatedModelRenderer(this);
		backEye2.setRotationPoint(-9.5F, -13.6F, 3.0F);
		body.addChild(backEye2);
		backEye2.setTextureOffset(191, 158).addBox(-1.5F, -2.4F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		backEye2.setTextureOffset(154, 76).addBox(-1.5F, -0.4F, 1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backEye2.setTextureOffset(147, 132).addBox(-1.5F, -0.4F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backEye2.setTextureOffset(74, 165).addBox(-2.5F, -0.4F, -1.5F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		backEye2.setTextureOffset(10, 201).addBox(1.5F, -0.4F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		backEye4 = new AnimatedModelRenderer(this);
		backEye4.setRotationPoint(-7.5F, -3.2F, 3.0F);
		body.addChild(backEye4);
		backEye4.setTextureOffset(61, 184).addBox(-1.5F, 0.2F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		backEye4.setTextureOffset(138, 128).addBox(-1.5F, -0.8F, 1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backEye4.setTextureOffset(118, 132).addBox(-1.5F, -0.8F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backEye4.setTextureOffset(200, 54).addBox(-2.5F, -0.8F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		backEye4.setTextureOffset(200, 47).addBox(1.5F, -0.8F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		backEye5 = new AnimatedModelRenderer(this);
		backEye5.setRotationPoint(8.5F, -3.2F, 3.0F);
		body.addChild(backEye5);
		backEye5.setTextureOffset(124, 183).addBox(-1.5F, 0.2F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		backEye5.setTextureOffset(123, 52).addBox(-1.5F, -0.8F, 1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backEye5.setTextureOffset(113, 28).addBox(-1.5F, -0.8F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backEye5.setTextureOffset(199, 19).addBox(-2.5F, -0.8F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		backEye5.setTextureOffset(199, 14).addBox(1.5F, -0.8F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		backEye6 = new AnimatedModelRenderer(this);
		backEye6.setRotationPoint(0.5F, -3.2F, 3.0F);
		body.addChild(backEye6);
		backEye6.setTextureOffset(59, 15).addBox(-1.5F, 0.2F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		backEye6.setTextureOffset(110, 39).addBox(-1.5F, -0.8F, 1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backEye6.setTextureOffset(96, 14).addBox(-1.5F, -0.8F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backEye6.setTextureOffset(124, 199).addBox(-2.5F, -0.8F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		backEye6.setTextureOffset(193, 149).addBox(1.5F, -0.8F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		backEye3 = new AnimatedModelRenderer(this);
		backEye3.setRotationPoint(10.5F, -13.6F, 3.0F);
		body.addChild(backEye3);
		backEye3.setTextureOffset(190, 50).addBox(-1.5F, -2.4F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		backEye3.setTextureOffset(144, 110).addBox(-1.5F, -0.4F, 1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backEye3.setTextureOffset(138, 132).addBox(-1.5F, -0.4F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backEye3.setTextureOffset(200, 86).addBox(-2.5F, -0.4F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		backEye3.setTextureOffset(23, 151).addBox(1.5F, -0.4F, -1.5F, 1.0F, 2.0F, 3.0F, 0.0F, false);

		leftArm = new AnimatedModelRenderer(this);
		leftArm.setRotationPoint(14.0F, -7.0F, 0.0F);
		body.addChild(leftArm);

		lShoulder = new AnimatedModelRenderer(this);
		lShoulder.setRotationPoint(-2.0F, -1.5F, 3.2F);
		leftArm.addChild(lShoulder);
		setRotateAngle(lShoulder, -1.1345F, 0.0F, 0.0F);
		lShoulder.setTextureOffset(129, 67).addBox(5.0F, -2.0F, -1.7F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		lShoulder.setTextureOffset(138, 117).addBox(4.0F, -3.0F, -2.7F, 1.0F, 5.0F, 5.0F, 0.0F, false);
		lShoulder.setTextureOffset(165, 165).addBox(1.0F, -4.5F, -4.2F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		lShoulder.setTextureOffset(39, 172).addBox(2.0F, -4.0F, -3.7F, 2.0F, 7.0F, 7.0F, 0.0F, false);

		lBicep = new AnimatedModelRenderer(this);
		lBicep.setRotationPoint(8.0F, 0.5F, -0.2F);
		lShoulder.addChild(lBicep);
		setRotateAngle(lBicep, 0.0F, -0.829F, 1.309F);
		lBicep.setTextureOffset(146, 162).addBox(-0.3954F, -2.4176F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, false);
		lBicep.setTextureOffset(197, 127).addBox(-1.3954F, -1.4176F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		lBicep.setTextureOffset(160, 78).addBox(-0.3954F, -2.4176F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, false);
		lBicep.setTextureOffset(180, 101).addBox(0.6046F, -2.9176F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		lBicep.setTextureOffset(176, 165).addBox(0.6046F, 2.0824F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		lBicep.setTextureOffset(180, 128).addBox(0.1046F, -1.9176F, -3.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		lBicep.setTextureOffset(103, 180).addBox(0.1046F, -1.9176F, 2.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);

		lElbow = new AnimatedModelRenderer(this);
		lElbow.setRotationPoint(7.6F, 0.0F, 0.0F);
		lBicep.addChild(lElbow);
		setRotateAngle(lElbow, -0.5672F, 0.0F, 0.0F);
		lElbow.setTextureOffset(102, 32).addBox(0.0046F, -1.4176F, -1.5F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		lElbow.setTextureOffset(172, 46).addBox(1.0046F, 1.0824F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		lElbow.setTextureOffset(142, 138).addBox(1.0046F, -1.9176F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		lElbow.setTextureOffset(69, 161).addBox(0.5046F, -0.9176F, -2.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		lElbow.setTextureOffset(121, 153).addBox(0.5046F, -0.9176F, 1.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		lFore = new AnimatedModelRenderer(this);
		lFore.setRotationPoint(6.0F, 0.0F, 0.0F);
		lElbow.addChild(lFore);
		setRotateAngle(lFore, 0.0F, 0.3491F, 0.8727F);
		lFore.setTextureOffset(47, 161).addBox(0.0046F, -2.4176F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, false);
		lFore.setTextureOffset(0, 173).addBox(1.0046F, -2.9176F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		lFore.setTextureOffset(168, 25).addBox(1.0046F, 2.0824F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		lFore.setTextureOffset(141, 173).addBox(0.5046F, -1.9176F, -3.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		lFore.setTextureOffset(70, 172).addBox(0.5046F, -1.9176F, 2.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		lFore.setTextureOffset(198, 37).addBox(7.5046F, -1.4176F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		lHand = new AnimatedModelRenderer(this);
		lHand.setRotationPoint(8.5046F, 0.0F, -0.5F);
		lFore.addChild(lHand);
		lHand.setTextureOffset(198, 0).addBox(0.0F, -1.4176F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		lUpperClaw = new AnimatedModelRenderer(this);
		lUpperClaw.setRotationPoint(0.3954F, 0.3F, 0.0F);
		lHand.addChild(lUpperClaw);
		lUpperClaw.setTextureOffset(181, 111).addBox(0.6046F, -2.7176F, -1.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		lUpperClaw.setTextureOffset(0, 12).addBox(0.6046F, 1.2824F, -1.0F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		lUpperClaw.setTextureOffset(144, 103).addBox(5.6046F, -1.7176F, -2.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		lUpperClaw.setTextureOffset(117, 79).addBox(7.6046F, -1.3176F, -2.0F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		lUpperClaw.setTextureOffset(152, 22).addBox(0.6046F, -1.7176F, -2.0F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		lUpperClaw.setTextureOffset(37, 126).addBox(0.6046F, 0.2824F, -2.0F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		lUpperClaw.setTextureOffset(28, 80).addBox(-0.3954F, -0.7176F, -2.3F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		lUpperClaw.setTextureOffset(28, 80).addBox(4.6046F, -0.7176F, -2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		lLowerClaw = new AnimatedModelRenderer(this);
		lLowerClaw.setRotationPoint(1.3954F, 0.3F, 2.0F);
		lHand.addChild(lLowerClaw);
		lLowerClaw.setTextureOffset(178, 62).addBox(-0.3954F, -0.7176F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lLowerClaw.setTextureOffset(69, 15).addBox(0.6046F, -0.7176F, 1.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		lLowerClaw.setTextureOffset(74, 66).addBox(0.6046F, -0.7176F, 0.0F, 5.0F, 0.0F, 1.0F, 0.0F, false);
		lLowerClaw.setTextureOffset(42, 15).addBox(0.6046F, 0.2824F, 0.0F, 5.0F, 0.0F, 1.0F, 0.0F, false);
		lLowerClaw.setTextureOffset(80, 178).addBox(4.6046F, -0.7176F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lLowerClaw.setTextureOffset(75, 178).addBox(5.6046F, -0.7176F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rightArm = new AnimatedModelRenderer(this);
		rightArm.setRotationPoint(-11.0F, -8.0F, 1.0F);
		body.addChild(rightArm);

		rShoulder = new AnimatedModelRenderer(this);
		rShoulder.setRotationPoint(-2.0F, -0.5F, 3.2F);
		rightArm.addChild(rShoulder);
		setRotateAngle(rShoulder, 2.0071F, 0.0F, 0.0F);
		rShoulder.setTextureOffset(43, 93).addBox(-3.0F, -2.0F, -1.7F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		rShoulder.setTextureOffset(66, 121).addBox(-2.0F, -3.0F, -2.7F, 1.0F, 5.0F, 5.0F, 0.0F, false);
		rShoulder.setTextureOffset(0, 64).addBox(1.0F, -4.5F, -4.2F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		rShoulder.setTextureOffset(20, 172).addBox(-1.0F, -4.0F, -3.7F, 2.0F, 7.0F, 7.0F, 0.0F, false);

		rBicep = new AnimatedModelRenderer(this);
		rBicep.setRotationPoint(-2.5F, 0.5F, -0.2F);
		rShoulder.addChild(rBicep);
		setRotateAngle(rBicep, 0.0F, -0.6109F, 1.2654F);
		rBicep.setTextureOffset(158, 132).addBox(-9.3954F, -2.4176F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, false);
		rBicep.setTextureOffset(197, 59).addBox(-1.3954F, -1.4176F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		rBicep.setTextureOffset(160, 89).addBox(-8.3954F, -2.9176F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		rBicep.setTextureOffset(157, 125).addBox(-8.3954F, 2.0824F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		rBicep.setTextureOffset(106, 168).addBox(-8.8954F, -1.9176F, -3.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		rBicep.setTextureOffset(155, 0).addBox(-8.8954F, -1.9176F, 2.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);

		rElbow = new AnimatedModelRenderer(this);
		rElbow.setRotationPoint(-9.4F, 0.0F, 0.0F);
		rBicep.addChild(rElbow);
		setRotateAngle(rElbow, -0.576F, 0.0F, 0.0F);
		rElbow.setTextureOffset(43, 31).addBox(-5.9954F, -1.4176F, -1.5F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		rElbow.setTextureOffset(130, 28).addBox(-4.9954F, 1.0824F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		rElbow.setTextureOffset(74, 118).addBox(-4.9954F, -1.9176F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		rElbow.setTextureOffset(114, 88).addBox(-5.4954F, -0.9176F, -2.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		rElbow.setTextureOffset(110, 52).addBox(-5.4954F, -0.9176F, 1.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		rFore = new AnimatedModelRenderer(this);
		rFore.setRotationPoint(-6.0F, 0.0F, 0.0F);
		rElbow.addChild(rFore);
		setRotateAngle(rFore, 0.0F, 0.2182F, 1.0036F);
		rFore.setTextureOffset(119, 157).addBox(-7.9954F, -2.4176F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, false);
		rFore.setTextureOffset(154, 71).addBox(-6.9954F, -2.9176F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		rFore.setTextureOffset(34, 88).addBox(-6.9954F, 2.0824F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		rFore.setTextureOffset(94, 72).addBox(-7.4954F, -1.9176F, -3.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		rFore.setTextureOffset(0, 33).addBox(-7.4954F, -1.9176F, 2.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		rFore.setTextureOffset(129, 168).addBox(-8.9954F, -1.4176F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		rHand = new AnimatedModelRenderer(this);
		rHand.setRotationPoint(-8.4954F, 0.0F, -0.5F);
		rFore.addChild(rHand);
		setRotateAngle(rHand, 1.4835F, 2.8798F, 0.7418F);

		rHTent1 = new AnimatedModelRenderer(this);
		rHTent1.setRotationPoint(1.3959F, 0.1431F, -0.0452F);
		rHand.addChild(rHTent1);
		setRotateAngle(rHTent1, -0.6545F, -0.6981F, -1.2654F);
		rHTent1.setTextureOffset(190, 22).addBox(-0.9268F, -1.231F, -2.8888F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent43 = new AnimatedModelRenderer(this);
		tent43.setRotationPoint(-0.0555F, -0.0351F, -2.6395F);
		rHTent1.addChild(tent43);
		setRotateAngle(tent43, 0.48F, 0.0F, 0.0F);
		tent43.setTextureOffset(0, 190).addBox(-0.8614F, -1.1759F, -3.6689F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent44 = new AnimatedModelRenderer(this);
		tent44.setRotationPoint(0.3437F, -0.4013F, -3.9596F);
		tent43.addChild(tent44);
		setRotateAngle(tent44, 0.9163F, 0.0F, 0.0F);
		tent44.setTextureOffset(189, 43).addBox(-1.215F, -0.5255F, -3.361F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent45 = new AnimatedModelRenderer(this);
		tent45.setRotationPoint(-0.1291F, 0.6675F, -3.1555F);
		tent44.addChild(tent45);
		setRotateAngle(tent45, 0.6545F, 0.0F, 0.0F);
		tent45.setTextureOffset(188, 134).addBox(-1.0759F, -1.0716F, -3.4369F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent46 = new AnimatedModelRenderer(this);
		tent46.setRotationPoint(-32.6686F, -18.6186F, 4.3332F);
		tent45.addChild(tent46);
		setRotateAngle(tent46, 0.2182F, 0.0F, 0.0F);
		tent46.setTextureOffset(91, 172).addBox(31.9827F, 16.0457F, -13.8181F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		rHTent2 = new AnimatedModelRenderer(this);
		rHTent2.setRotationPoint(1.3959F, 0.1431F, -0.0452F);
		rHand.addChild(rHTent2);
		setRotateAngle(rHTent2, 0.8727F, -2.4871F, -2.4435F);
		rHTent2.setTextureOffset(182, 74).addBox(-0.9268F, -1.231F, -2.8888F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent47 = new AnimatedModelRenderer(this);
		tent47.setRotationPoint(-0.0555F, -0.0351F, -2.6395F);
		rHTent2.addChild(tent47);
		setRotateAngle(tent47, 0.48F, 0.0F, 0.0F);
		tent47.setTextureOffset(51, 172).addBox(-0.8614F, -1.1759F, -3.6689F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent48 = new AnimatedModelRenderer(this);
		tent48.setRotationPoint(0.354F, -0.1984F, -3.4547F);
		tent47.addChild(tent48);
		setRotateAngle(tent48, 0.5236F, 0.0F, 0.0F);
		tent48.setTextureOffset(32, 172).addBox(-1.2254F, -0.9537F, -3.6968F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent49 = new AnimatedModelRenderer(this);
		tent49.setRotationPoint(-0.1395F, 0.2393F, -3.4912F);
		tent48.addChild(tent49);
		setRotateAngle(tent49, 0.6545F, 0.0F, 0.0F);
		tent49.setTextureOffset(145, 43).addBox(-1.0759F, -1.0716F, -3.4369F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent50 = new AnimatedModelRenderer(this);
		tent50.setRotationPoint(-32.6686F, -18.6186F, 4.3332F);
		tent49.addChild(tent50);
		setRotateAngle(tent50, 0.2182F, 0.0F, 0.0F);
		tent50.setTextureOffset(118, 138).addBox(31.9827F, 16.0457F, -13.8181F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		rHTent3 = new AnimatedModelRenderer(this);
		rHTent3.setRotationPoint(1.3959F, 0.1431F, -0.0452F);
		rHand.addChild(rHTent3);
		setRotateAngle(rHTent3, -1.4399F, 0.9163F, 2.9671F);
		rHTent3.setTextureOffset(188, 62).addBox(-0.9268F, -1.231F, -2.8888F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent51 = new AnimatedModelRenderer(this);
		tent51.setRotationPoint(-0.0555F, -0.0351F, -2.6395F);
		rHTent3.addChild(tent51);
		setRotateAngle(tent51, 0.48F, 0.0F, 0.0F);
		tent51.setTextureOffset(187, 177).addBox(-0.8614F, -1.1759F, -3.6689F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent52 = new AnimatedModelRenderer(this);
		tent52.setRotationPoint(0.7018F, -0.1359F, -3.0483F);
		tent51.addChild(tent52);
		setRotateAngle(tent52, 0.5236F, 0.0F, 0.0F);
		tent52.setTextureOffset(187, 170).addBox(-1.5731F, -1.2109F, -4.0175F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent53 = new AnimatedModelRenderer(this);
		tent53.setRotationPoint(-0.4872F, -0.018F, -3.812F);
		tent52.addChild(tent53);
		setRotateAngle(tent53, 0.6545F, 0.0F, 0.0F);
		tent53.setTextureOffset(187, 116).addBox(-1.0759F, -1.0716F, -3.4369F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent54 = new AnimatedModelRenderer(this);
		tent54.setRotationPoint(-32.6686F, -18.6186F, 4.3332F);
		tent53.addChild(tent54);
		setRotateAngle(tent54, 0.2182F, 0.0F, 0.0F);
		tent54.setTextureOffset(153, 132).addBox(31.9827F, 16.0457F, -13.8181F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		rHTent4 = new AnimatedModelRenderer(this);
		rHTent4.setRotationPoint(1.3959F, 0.1431F, -0.0452F);
		rHand.addChild(rHTent4);
		setRotateAngle(rHTent4, -2.4871F, -0.0873F, 1.3526F);
		rHTent4.setTextureOffset(182, 187).addBox(-0.9268F, -1.231F, -2.8888F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent55 = new AnimatedModelRenderer(this);
		tent55.setRotationPoint(-0.0555F, -0.0351F, -2.6395F);
		rHTent4.addChild(tent55);
		setRotateAngle(tent55, 0.48F, 0.0F, 0.0F);
		tent55.setTextureOffset(30, 187).addBox(-0.8614F, -1.1759F, -3.6689F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent56 = new AnimatedModelRenderer(this);
		tent56.setRotationPoint(-0.1447F, -0.0289F, -3.4157F);
		tent55.addChild(tent56);
		setRotateAngle(tent56, 0.5236F, 0.0F, 0.0F);
		tent56.setTextureOffset(17, 187).addBox(-0.7267F, -1.12F, -3.6458F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent57 = new AnimatedModelRenderer(this);
		tent57.setRotationPoint(0.3592F, 0.073F, -3.4403F);
		tent56.addChild(tent57);
		setRotateAngle(tent57, 0.6545F, 0.0F, 0.0F);
		tent57.setTextureOffset(185, 0).addBox(-1.0759F, -1.0716F, -3.4369F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent58 = new AnimatedModelRenderer(this);
		tent58.setRotationPoint(-32.6686F, -18.6186F, 4.3332F);
		tent57.addChild(tent58);
		setRotateAngle(tent58, 0.2182F, 0.0F, 0.0F);
		tent58.setTextureOffset(148, 201).addBox(31.9827F, 16.0457F, -13.8181F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		tail = new AnimatedModelRenderer(this);
		tail.setRotationPoint(-1.0F, -6.0F, 15.6F);
		wholeBody.addChild(tail);

		foot = new AnimatedModelRenderer(this);
		foot.setRotationPoint(1.0F, -2.0F, -0.6F);
		tail.addChild(foot);

		bone5 = new AnimatedModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, -1.4F);
		foot.addChild(bone5);
		bone5.setTextureOffset(46, 46).addBox(4.0F, 8.0F, -10.0F, 4.0F, 0.0F, 19.0F, 0.0F, false);
		bone5.setTextureOffset(0, 64).addBox(-8.0F, 8.0F, -10.0F, 4.0F, 0.0F, 19.0F, 0.0F, false);
		bone5.setTextureOffset(42, 10).addBox(-8.0F, 8.0F, -14.0F, 16.0F, 0.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(110, 47).addBox(-6.0F, 8.0F, -18.0F, 12.0F, 0.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(130, 83).addBox(-4.0F, 4.0F, -14.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(24, 132).addBox(-3.0F, 3.0F, -12.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
		bone5.setTextureOffset(155, 103).addBox(-5.0F, 2.0F, -10.0F, 10.0F, 6.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(36, 152).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 4.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(74, 61).addBox(-5.0F, 1.0F, -8.0F, 10.0F, 1.0F, 2.0F, 0.0F, false);
		bone5.setTextureOffset(144, 12).addBox(-6.0F, 3.0F, -6.0F, 12.0F, 5.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(74, 46).addBox(-6.0F, 5.0F, -2.0F, 12.0F, 3.0F, 11.0F, 0.0F, false);
		bone5.setTextureOffset(0, 103).addBox(-5.0F, 2.0F, -2.0F, 10.0F, 3.0F, 11.0F, 0.0F, false);
		bone5.setTextureOffset(78, 111).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 3.0F, 11.0F, 0.0F, false);
		bone5.setTextureOffset(78, 111).addBox(-2.9F, -3.9F, -0.1F, 6.0F, 3.0F, 8.0F, 0.0F, false);

		bone = new AnimatedModelRenderer(this);
		bone.setRotationPoint(0.0F, 7.0F, 9.0F);
		bone5.addChild(bone);
		bone.setTextureOffset(0, 0).addBox(-6.0F, -2.0F, 0.0F, 12.0F, 3.0F, 17.0F, 0.0F, false);
		bone.setTextureOffset(94, 61).addBox(-9.0F, 1.0F, 0.0F, 3.0F, 0.0F, 17.0F, 0.0F, false);
		bone.setTextureOffset(89, 14).addBox(6.0F, 1.0F, 0.0F, 3.0F, 0.0F, 17.0F, 0.0F, false);
		bone.setTextureOffset(42, 80).addBox(-3.0F, -4.0F, 12.0F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(43, 89).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 3.0F, 12.0F, 0.0F, false);
		bone.setTextureOffset(128, 0).addBox(-4.0F, -6.0F, 0.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);

		seg10 = new AnimatedModelRenderer(this);
		seg10.setRotationPoint(0.0F, 0.0F, 17.0F);
		bone.addChild(seg10);
		seg10.setTextureOffset(0, 118).addBox(-4.0F, -1.9F, -2.0F, 8.0F, 3.0F, 10.0F, 0.0F, false);
		seg10.setTextureOffset(0, 162).addBox(-7.0F, 0.99F, -2.0F, 3.0F, 0.0F, 10.0F, 0.0F, false);
		seg10.setTextureOffset(74, 161).addBox(4.0F, 0.99F, -2.0F, 3.0F, 0.0F, 10.0F, 0.0F, false);
		seg10.setTextureOffset(75, 10).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);

		endSeg = new AnimatedModelRenderer(this);
		endSeg.setRotationPoint(0.0F, 0.0F, 8.0F);
		seg10.addChild(endSeg);
		endSeg.setTextureOffset(0, 21).addBox(-6.0F, 1.0F, -2.0F, 12.0F, 0.0F, 18.0F, 0.0F, false);
		endSeg.setTextureOffset(138, 117).addBox(-8.0F, 1.0F, -1.0F, 2.0F, 0.0F, 14.0F, 0.0F, false);
		endSeg.setTextureOffset(45, 137).addBox(6.0F, 1.0F, -1.0F, 2.0F, 0.0F, 14.0F, 0.0F, false);
		endSeg.setTextureOffset(97, 0).addBox(-4.5F, 0.1F, -0.8958F, 9.0F, 1.0F, 12.0F, 0.0F, false);
		endSeg.setTextureOffset(0, 147).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 10.0F, 0.0F, false);
		endSeg.setTextureOffset(158, 143).addBox(-2.0F, -1.8F, -1.0F, 4.0F, 1.0F, 8.0F, 0.0F, false);
		endSeg.setTextureOffset(158, 143).addBox(-2.0F, 0.2F, 6.0F, 4.0F, 1.0F, 8.0F, 0.0F, false);
		animator = ModelAnimator.create();
		headArray = new AnimatedModelRenderer[] { neck1, neck2, face };
		setDefaultPose();
	}

	@Override
	public void setLivingAnimations(EntityUzouthrhix entityIn, float limbSwing, float limbSwingAmount,
			float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
		this.entity = entityIn;
		resetToDefaultPose();
		animator.update(entity, partialTick);
		if (animator.setAnimation(EntityUzouthrhix.LIGHTNING_ANIMATION)) {
			roarAnim(partialTick);
		} else if (animator.setAnimation(EntityUzouthrhix.CHARGE_ANIMATION)) {
			diveAnim(partialTick);
		} else if (animator.setAnimation(EntityUzouthrhix.BITE_ANIMATION)) {
			biteAnim();
		}

		idle(entity.ticksExisted + partialTick);

	}

	private void diveAnim(float partialTick) {
		animator.startKeyframe(56);
		animator.rotate(lowerColumn, 1.75f, 0, 0);
		animator.rotate(upperTorso, -1.75f, 0, 0);
		animator.rotate(shoulder, 2.65f, 0, 0);
		animator.rotate(shoulder2, -2.65f, 0, 0);
		animator.rotate(shoulder3, -2.65f, 0, 0);
		animator.rotate(shoulder4, -2.65f, 0, 0);
		animator.rotate(lShoulder, -1.35f, 0, 0);
		animator.rotate(rShoulder, -1.35f, 0, 0);
		animator.rotate(lFore, 0, 0, -1.05f);
		animator.rotate(rFore, 0, -0.5f, -1.05f);
		animator.rotate(face, -1.65f, 0, 0);
		animator.rotate(neck1, 0.35f, 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(46);
		animator.rotate(lowerColumn, 0, 0, 0);
		animator.rotate(upperTorso, 0, 0, 0);
		animator.rotate(shoulder, 0, 0, 0);
		animator.rotate(shoulder2, 0, 0, 0);
		animator.rotate(shoulder3, 0, 0, 0);
		animator.rotate(shoulder4, 0, 0, 0);
		animator.rotate(lShoulder, 0, 0, 0);
		animator.rotate(rShoulder, 0, 0, 0);
		animator.rotate(lFore, 0, 0, 0);
		animator.rotate(rFore, 0, 0, 0);
		animator.rotate(face, 0, 0, 0);
		animator.rotate(neck1, 0, 0, 0);

		animator.endKeyframe();
		animator.resetKeyframe(66);

	}

	private void roarAnim(float partialTick) {
		animator.startKeyframe(16);
		animator.rotate(upperTorso, -0.85f, 0, 0);
		animator.rotate(leftArm, -0.55f, 0, -1.55f);
		animator.rotate(rightArm, -0.55f, 0, 1.55f);
		animator.endKeyframe();
		animator.resetKeyframe(18);

	}

	private void biteAnim() {
		animator.startKeyframe(9);
		animator.rotate(neck1, -0.6f, 0, 0);
		animator.rotate(neck2, 0.3f, 0, 0);
		animator.rotate(face, 0.4f, 0, 0);
		animator.rotate(upperTorso, 0.55f, 0, 0);
		animator.rotate(face, -1.65f, 0, 0);
		animator.endKeyframe();
		animator.startKeyframe(3);
		animator.rotate(neck1, 0.45f, 0, 0);
		animator.endKeyframe();
		animator.resetKeyframe(8);
	}

	@Override
	public void idle(float frame) {
		this.lGills.rotateAngleY = (float) Math.abs((Math.cos((frame) * 0.5f) * 0.1325));
		this.rGills.rotateAngleY = (float) Math.abs((Math.cos((frame) * 0.5f) * 0.1325));
		this.lGills.rotateAngleX = (float) Math.abs((Math.cos((frame) * 0.5f) * 0.1325));
		this.rGills.rotateAngleX = (float) Math.abs((Math.cos((frame) * 0.5f) * 0.1325));
		// Upper Body
		// this.upperTorso.rotateAngleX = (float) (Math.sin((frame) * 0.13f) * 0.0325);

		// Eyes
		this.eye.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.eye.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.eye2.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.eye2.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.eye3.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.eye3.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.eye4.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.eye4.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.eye5.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.eye5.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.eye6.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.eye6.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.eye7.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.eye7.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.eye8.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.eye8.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.eye9.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.eye9.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.eye10.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.eye10.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.eye11.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.eye11.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.eye12.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.eye12.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		// cheese monke
		// Body Eyes
		this.backEye.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.backEye.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.backEye2.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.backEye2.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.backEye3.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.backEye3.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.backEye4.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.backEye4.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.backEye5.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.backEye5.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);
		this.backEye6.rotateAngleZ = (float) (Math.sin((frame)) * 0.0325);
		this.backEye6.rotateAngleY = (float) (Math.cos((frame)) * 0.0325);

		/*
		 * * // Left Arm this.leftArm.rotateAngleX = MathHelper.sin(limbSwing * 0.1662F
		 * + (float) Math.PI) * 1.2F * limbSwingAmount; this.lFore.rotateAngleX =
		 * MathHelper.cos(limbSwing * 0.1662F) * 1.2F * limbSwingAmount;
		 * this.lHand.rotateAngleX = -Math .abs(MathHelper.sin(limbSwing * 0.1662F +
		 * (float) Math.PI) * 1.2F * limbSwingAmount); // Claw
		 * this.lLowerClaw.rotateAngleY = (float) -Math.abs((Math.cos((frame) * 0.2f) *
		 * 0.2325));
		 * 
		 * // Right Arm this.rightArm.rotateAngleX = -MathHelper.cos(limbSwing *
		 * 0.1662F) * 1.2F * limbSwingAmount; this.rFore.rotateAngleX =
		 * MathHelper.cos(limbSwing * 0.1662F) * 1.2F * limbSwingAmount;
		 * this.rHand.rotateAngleX = -Math.abs(MathHelper.cos(limbSwing * 0.1662F) *
		 * 1.2F * limbSwingAmount);
		 */
		this.lLowerClaw.rotateAngleY = (float) -Math.abs((Math.cos((frame) * 0.2f) * 0.2325));
		// Right Hand Tentacles
		this.rHTent1.rotateAngleX = (float) (Math.sin((frame) * 0.53f) * 0.0325) - 0.75f;
		this.rHTent2.rotateAngleX = (float) (Math.sin((frame) * 0.53f) * 0.0325) - 5.5f;
		this.rHTent3.rotateAngleX = (float) (Math.sin((frame) * 0.53f) * 0.0325) - 1.5f;
		this.rHTent4.rotateAngleX = (float) (Math.sin((frame) * 0.53f) * 0.0325) - 2.5f;

		// Foot
		this.bone5.rotateAngleY = (float) Math.sin((frame) * 0.3f) * 0.05f;
		this.bone.rotateAngleY = (float) Math.cos((frame) * 0.5f) * 0.1f - 44.0f;
		this.seg10.rotateAngleY = (float) Math.sin((frame) * 0.6f) * 0.15f;
		this.endSeg.rotateAngleY = (float) Math.cos((frame) * 0.7f) * 0.25f;

		// Tentacles
		// Face
		this.tent6.rotateAngleX = (float) Math.sin((frame) * 0.3f) * 0.05f + 25.5f;
		this.tent7.rotateAngleX = (float) Math.cos((frame) * 0.5f) * 0.1f + 25.7f;
		this.tent8.rotateAngleX = (float) Math.sin((frame) * 0.6f) * 0.15f + 25.5f;
		this.tent9.rotateAngleX = (float) Math.cos((frame) * 0.7f) * 0.25f + 25.5f;
		this.tent10.rotateAngleX = (float) Math.sin((frame) * 0.8f) * 0.35f + 25.5f;

		this.tent22.rotateAngleX = (float) Math.cos((frame) * 0.3f) * 0.05f + 25.5f;
		this.tent23.rotateAngleX = (float) Math.cos((frame) * 0.5f) * 0.1f + 25.7f;
		this.tent24.rotateAngleX = (float) Math.cos((frame) * 0.6f) * 0.15f + 25.5f;
		this.tent25.rotateAngleX = (float) Math.cos((frame) * 0.7f) * 0.25f + 25.5f;
		this.tent26.rotateAngleX = (float) Math.cos((frame) * 0.8f) * 0.35f + 25.5f;

		this.tent2.rotateAngleX = (float) Math.sin((frame) * 0.3f) * 0.05f + 25.5f;
		this.tent3.rotateAngleX = (float) Math.sin((frame) * 0.5f) * 0.1f + 25.7f;
		this.tent4.rotateAngleX = (float) Math.sin((frame) * 0.6f) * 0.15f + 25.5f;
		this.tent5.rotateAngleX = (float) Math.sin((frame) * 0.7f) * 0.25f + 25.5f;
		this.tent11.rotateAngleX = (float) Math.sin((frame) * 0.8f) * 0.35f + 25.5f;

		this.tent12.rotateAngleX = (float) Math.cos((frame) * 0.3f) * 0.05f + 25.5f;
		this.tent13.rotateAngleX = (float) Math.sin((frame) * 0.5f) * 0.1f + 25.7f;
		this.tent14.rotateAngleX = (float) Math.cos((frame) * 0.6f) * 0.15f + 25.5f;
		this.tent15.rotateAngleX = (float) Math.sin((frame) * 0.7f) * 0.25f + 25.5f;
		this.tent16.rotateAngleX = (float) Math.cos((frame) * 0.8f) * 0.35f + 25.5f;

		this.tent17.rotateAngleX = (float) Math.cos((frame) * 0.3f) * 0.05f + 25.5f;
		this.tent18.rotateAngleX = (float) Math.cos((frame) * 0.5f) * 0.1f + 25.7f;
		this.tent19.rotateAngleX = (float) Math.sin((frame) * 0.6f) * 0.15f + 25.5f;
		this.tent20.rotateAngleX = (float) Math.sin((frame) * 0.7f) * 0.25f + 25.5f;
		this.tent21.rotateAngleX = (float) Math.sin((frame) * 0.8f) * 0.35f + 25.5f;
		// Body
		this.armTent.rotateAngleX = (float) Math.sin((frame) * 0.3f) * 0.05f;
		this.seg3.rotateAngleX = (float) Math.sin((frame) * 0.5f) * 0.1f;
		this.seg2.rotateAngleX = (float) Math.sin((frame) * 0.6f) * 0.15f;
		this.seg1.rotateAngleX = (float) Math.sin((frame) * 0.7f) * 0.25f;
		this.hand.rotateAngleX = (float) Math.sin((frame) * 0.8f) * 0.35f;

		this.armTent2.rotateAngleX = (float) Math.cos((frame) * 0.3f) * 0.05f;
		this.seg4.rotateAngleX = (float) Math.cos((frame) * 0.5f) * 0.1f;
		this.seg5.rotateAngleX = (float) Math.cos((frame) * 0.6f) * 0.15f;
		this.seg6.rotateAngleX = (float) Math.cos((frame) * 0.7f) * 0.25f;
		this.hand2.rotateAngleX = (float) Math.cos((frame) * 0.8f) * 0.35f;

		this.armTent3.rotateAngleX = (float) Math.sin((frame) * 0.3f) * 0.05f;
		this.seg7.rotateAngleX = (float) Math.cos((frame) * 0.5f) * 0.1f;
		this.bone4.rotateAngleX = (float) Math.sin((frame) * 0.6f) * 0.15f;
		this.seg9.rotateAngleX = (float) Math.cos((frame) * 0.7f) * 0.25f;
		this.hand3.rotateAngleX = (float) Math.sin((frame) * 0.8f) * 0.35f;

		this.armTent4.rotateAngleX = (float) Math.cos((frame) * 0.3f) * 0.05f;
		this.seg11.rotateAngleX = (float) Math.sin((frame) * 0.5f) * 0.1f;
		this.seg12.rotateAngleX = (float) Math.cos((frame) * 0.6f) * 0.15f;
		this.seg13.rotateAngleX = (float) Math.sin((frame) * 0.7f) * 0.25f;
		this.hand4.rotateAngleX = (float) Math.cos((frame) * 0.8f) * 0.35f;
	}

	@Override
	public void setRotationAngles(EntityUzouthrhix entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		netHeadYaw = MathHelper.wrapDegrees(netHeadYaw);
		faceTarget(netHeadYaw, headPitch, 1, headArray);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		wholeBody.render(matrixStack, buffer, packedLight, packedOverlay);
	}

}