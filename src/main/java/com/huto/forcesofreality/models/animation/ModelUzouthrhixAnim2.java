package com.huto.forcesofreality.models.animation;

import com.huto.forcesofreality.entities.lords.EntityUzouthrhix;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.util.math.MathHelper;

public class ModelUzouthrhixAnim2 extends WREntityModel<EntityUzouthrhix> {
	WRModelRenderer wholeBody;
	WRModelRenderer body;
	WRModelRenderer upperTorso;
	WRModelRenderer armTent3;
	WRModelRenderer shoulder3;
	WRModelRenderer armEye3;
	WRModelRenderer seg7;
	WRModelRenderer bone4;
	WRModelRenderer seg8;
	WRModelRenderer seg9;
	WRModelRenderer hand3;
	WRModelRenderer armTent2;
	WRModelRenderer shoulder2;
	WRModelRenderer armEye2;
	WRModelRenderer seg4;
	WRModelRenderer bone2;
	WRModelRenderer seg5;
	WRModelRenderer seg6;
	WRModelRenderer hand2;
	WRModelRenderer armTent;
	WRModelRenderer shoulder;
	WRModelRenderer armEye;
	WRModelRenderer seg3;
	WRModelRenderer bone3;
	WRModelRenderer seg2;
	WRModelRenderer seg1;
	WRModelRenderer hand;
	WRModelRenderer armTent4;
	WRModelRenderer shoulder4;
	WRModelRenderer armEye4;
	WRModelRenderer seg11;
	WRModelRenderer bone6;
	WRModelRenderer seg12;
	WRModelRenderer seg13;
	WRModelRenderer hand4;
	WRModelRenderer neck;
	WRModelRenderer neck1;
	WRModelRenderer cube_r1;
	WRModelRenderer cube_r2;
	WRModelRenderer lGills;
	WRModelRenderer cube_r3;
	WRModelRenderer cube_r4;
	WRModelRenderer cube_r5;
	WRModelRenderer cube_r6;
	WRModelRenderer cube_r7;
	WRModelRenderer cube_r8;
	WRModelRenderer rGills;
	WRModelRenderer cube_r9;
	WRModelRenderer cube_r10;
	WRModelRenderer cube_r11;
	WRModelRenderer cube_r12;
	WRModelRenderer cube_r13;
	WRModelRenderer cube_r14;
	WRModelRenderer face;
	WRModelRenderer eyes;
	WRModelRenderer eye2;
	WRModelRenderer eye3;
	WRModelRenderer eye11;
	WRModelRenderer eye6;
	WRModelRenderer eye4;
	WRModelRenderer eye5;
	WRModelRenderer eye12;
	WRModelRenderer eye7;
	WRModelRenderer eye10;
	WRModelRenderer eye9;
	WRModelRenderer eye8;
	WRModelRenderer eye;
	WRModelRenderer tentacles;
	WRModelRenderer tent6;
	WRModelRenderer tent7;
	WRModelRenderer tent8;
	WRModelRenderer tent9;
	WRModelRenderer tent10;
	WRModelRenderer tent22;
	WRModelRenderer tent23;
	WRModelRenderer tent24;
	WRModelRenderer tent25;
	WRModelRenderer tent26;
	WRModelRenderer tent2;
	WRModelRenderer tent3;
	WRModelRenderer tent4;
	WRModelRenderer tent5;
	WRModelRenderer tent11;
	WRModelRenderer tent12;
	WRModelRenderer tent13;
	WRModelRenderer tent14;
	WRModelRenderer tent15;
	WRModelRenderer tent16;
	WRModelRenderer tent17;
	WRModelRenderer tent18;
	WRModelRenderer tent19;
	WRModelRenderer tent20;
	WRModelRenderer tent21;
	WRModelRenderer neck2;
	WRModelRenderer cube_r15;
	WRModelRenderer rightArm;
	WRModelRenderer rShoulder;
	WRModelRenderer rBicep;
	WRModelRenderer rElbow;
	WRModelRenderer rFore;
	WRModelRenderer rHand;
	WRModelRenderer rHTent1;
	WRModelRenderer tent28;
	WRModelRenderer tent29;
	WRModelRenderer tent30;
	WRModelRenderer tent31;
	WRModelRenderer rHTent4;
	WRModelRenderer tent39;
	WRModelRenderer tent40;
	WRModelRenderer tent41;
	WRModelRenderer tent42;
	WRModelRenderer rHTent2;
	WRModelRenderer tent33;
	WRModelRenderer tent34;
	WRModelRenderer tent35;
	WRModelRenderer tent36;
	WRModelRenderer rHTent3;
	WRModelRenderer tent27;
	WRModelRenderer tent32;
	WRModelRenderer tent37;
	WRModelRenderer tent38;
	WRModelRenderer leftArm;
	WRModelRenderer lShoulder;
	WRModelRenderer lBicep;
	WRModelRenderer lElbow;
	WRModelRenderer lFore;
	WRModelRenderer lHand;
	WRModelRenderer lUpperClaw;
	WRModelRenderer lLowerClaw;
	WRModelRenderer backEye2;
	WRModelRenderer backEye3;
	WRModelRenderer backEye;
	WRModelRenderer backEye5;
	WRModelRenderer backEye6;
	WRModelRenderer backEye4;
	WRModelRenderer tail;
	WRModelRenderer foot;
	WRModelRenderer bone5;
	WRModelRenderer bone;
	WRModelRenderer seg10;
	WRModelRenderer endSeg;
	public ModelAnimator animator;
	public final WRModelRenderer[] headArray;

	public ModelUzouthrhixAnim2() {
		textureWidth = 256;
		textureHeight = 256;

		wholeBody = new WRModelRenderer(this);
		wholeBody.setRotationPoint(0.0F, 24.0F, 0.0F);

		body = new WRModelRenderer(this);
		body.setRotationPoint(-1.0F, -31.0F, -9.0F);
		wholeBody.addChild(body);

		upperTorso = new WRModelRenderer(this);
		upperTorso.setRotationPoint(0.0F, -2.0F, 20.0F);
		body.addChild(upperTorso);
		upperTorso.setTextureOffset(42, 0).addBox(-12.0F, -10.0F, -21.0F, 25.0F, 1.0F, 8.0F, 0.0F, false);
		upperTorso.setTextureOffset(43, 21).addBox(-11.0F, -11.0F, -21.0F, 23.0F, 1.0F, 8.0F, 0.0F, false);
		upperTorso.setTextureOffset(154, 60).addBox(-3.0F, -14.0F, -20.0F, 8.0F, 3.0F, 7.0F, 0.0F, false);
		upperTorso.setTextureOffset(168, 13).addBox(0.0F, -3.0F, -2.4F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		upperTorso.setTextureOffset(92, 168).addBox(0.0F, -10.0F, -5.4F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		upperTorso.setTextureOffset(115, 168).addBox(0.0F, -6.0F, -5.4F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		upperTorso.setTextureOffset(163, 182).addBox(7.0F, -13.0F, -20.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		upperTorso.setTextureOffset(182, 146).addBox(-7.0F, -13.0F, -20.0F, 1.0F, 3.0F, 8.0F, 0.0F, false);
		upperTorso.setTextureOffset(83, 141).addBox(-1.0F, -16.0F, -20.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		upperTorso.setTextureOffset(0, 21).addBox(-3.0F, -12.0F, -13.0F, 1.0F, 4.0F, 7.0F, 0.0F, false);
		upperTorso.setTextureOffset(0, 0).addBox(4.0F, -12.0F, -13.0F, 1.0F, 4.0F, 7.0F, 0.0F, false);
		upperTorso.setTextureOffset(184, 34).addBox(-6.0F, -12.0F, -13.0F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		upperTorso.setTextureOffset(182, 25).addBox(6.0F, -12.0F, -13.0F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		upperTorso.setTextureOffset(183, 82).addBox(-1.0F, -11.0F, -6.0F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		upperTorso.setTextureOffset(51, 184).addBox(2.0F, -11.0F, -6.0F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		upperTorso.setTextureOffset(165, 0).addBox(-2.0F, -11.0F, -13.0F, 6.0F, 3.0F, 7.0F, 0.0F, false);
		upperTorso.setTextureOffset(118, 67).addBox(2.0F, -16.0F, -20.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		upperTorso.setTextureOffset(28, 66).addBox(-7.0F, -6.0F, -12.4F, 16.0F, 5.0F, 8.0F, 0.0F, false);
		upperTorso.setTextureOffset(0, 40).addBox(-11.0F, -9.0F, -21.0F, 24.0F, 4.0F, 8.0F, 0.0F, false);
		upperTorso.setTextureOffset(151, 43).addBox(-2.0F, -9.0F, -6.0F, 6.0F, 7.0F, 8.0F, 0.0F, false);
		upperTorso.setTextureOffset(0, 53).addBox(-11.0F, -5.0F, -20.0F, 23.0F, 3.0F, 7.0F, 0.0F, false);
		upperTorso.setTextureOffset(0, 84).addBox(-5.0F, -8.0F, -10.4F, 12.0F, 9.0F, 9.0F, 0.0F, false);
		upperTorso.setTextureOffset(113, 14).addBox(-4.5F, -5.0F, -15.0F, 11.0F, 5.0F, 8.0F, 0.0F, false);
		upperTorso.setTextureOffset(118, 55).addBox(-5.5F, -1.0F, -9.5F, 13.0F, 5.0F, 6.0F, 0.0F, false);
		upperTorso.setTextureOffset(57, 32).addBox(-8.0F, -10.0F, -15.0F, 18.0F, 5.0F, 8.0F, 0.0F, false);
		upperTorso.setTextureOffset(0, 168).addBox(-0.5F, -12.0F, -8.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		upperTorso.setTextureOffset(155, 6).addBox(-0.5F, -12.0F, -12.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		upperTorso.setTextureOffset(28, 201).addBox(-1.5F, -12.0F, -11.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		upperTorso.setTextureOffset(19, 201).addBox(2.5F, -12.0F, -11.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		upperTorso.setTextureOffset(154, 76).addBox(-11.0F, -12.0F, -15.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		upperTorso.setTextureOffset(147, 132).addBox(-11.0F, -12.0F, -19.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		upperTorso.setTextureOffset(74, 165).addBox(-12.0F, -12.0F, -18.5F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		upperTorso.setTextureOffset(10, 201).addBox(-8.0F, -12.0F, -18.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		upperTorso.setTextureOffset(138, 128).addBox(-9.0F, -2.0F, -15.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		upperTorso.setTextureOffset(118, 132).addBox(-9.0F, -2.0F, -19.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		upperTorso.setTextureOffset(200, 54).addBox(-10.0F, -2.0F, -18.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		upperTorso.setTextureOffset(144, 110).addBox(9.0F, -12.0F, -15.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		upperTorso.setTextureOffset(138, 132).addBox(9.0F, -12.0F, -19.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		upperTorso.setTextureOffset(200, 86).addBox(8.0F, -12.0F, -18.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		upperTorso.setTextureOffset(23, 151).addBox(12.0F, -12.0F, -18.5F, 1.0F, 2.0F, 3.0F, 0.0F, false);
		upperTorso.setTextureOffset(200, 47).addBox(-6.0F, -2.0F, -18.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		upperTorso.setTextureOffset(124, 199).addBox(-2.0F, -2.0F, -18.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		upperTorso.setTextureOffset(193, 149).addBox(2.0F, -2.0F, -18.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		upperTorso.setTextureOffset(96, 14).addBox(-1.0F, -2.0F, -19.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		upperTorso.setTextureOffset(110, 39).addBox(-1.0F, -2.0F, -15.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		upperTorso.setTextureOffset(199, 14).addBox(10.0F, -2.0F, -18.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		upperTorso.setTextureOffset(199, 19).addBox(6.0F, -2.0F, -18.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		upperTorso.setTextureOffset(113, 28).addBox(7.0F, -2.0F, -19.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		upperTorso.setTextureOffset(123, 52).addBox(7.0F, -2.0F, -15.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		armTent = new WRModelRenderer(this);
		armTent.setRotationPoint(7.5F, -35.9333F, 1.5F);
		wholeBody.addChild(armTent);
		shoulder = new WRModelRenderer(this);
		shoulder.setRotationPoint(3.0F, 10.6F, -0.1F);
		armTent.addChild(shoulder);
		shoulder.setTextureOffset(68, 184).addBox(-3.0F, -12.6F, -2.9F, 2.0F, 4.0F, 6.0F, 0.0F, false);
		shoulder.setTextureOffset(150, 185).addBox(-2.5F, -13.0F, -2.4F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		shoulder.setTextureOffset(47, 161).addBox(-2.5F, -12.1667F, 2.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder.setTextureOffset(157, 114).addBox(-2.5F, -12.1667F, -3.4F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder.setTextureOffset(0, 132).addBox(-1.4F, -12.4667F, -1.9F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		shoulder.setTextureOffset(175, 146).addBox(-1.2F, -11.4667F, -0.9F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		armEye = new WRModelRenderer(this);
		armEye.setRotationPoint(-0.3F, -0.3667F, 0.1F);
		shoulder.addChild(armEye);
		armEye.setTextureOffset(150, 179).addBox(-0.4F, -10.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		seg3 = new WRModelRenderer(this);
		seg3.setRotationPoint(-2.379F, -8.7233F, -0.4F);
		shoulder.addChild(seg3);
		seg3.setTextureOffset(48, 136).addBox(-0.121F, 0.0566F, -1.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		seg3.setTextureOffset(183, 146).addBox(0.379F, 0.0566F, 0.2F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg3.setTextureOffset(198, 187).addBox(0.379F, 0.0566F, -1.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg3.setTextureOffset(202, 66).addBox(1.179F, -0.7434F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		bone3 = new WRModelRenderer(this);
		bone3.setRotationPoint(0.9981F, 5.0712F, 0.5F);
		seg3.addChild(bone3);

		seg2 = new WRModelRenderer(this);
		seg2.setRotationPoint(0.381F, -0.0145F, 0.0F);
		bone3.addChild(seg2);
		seg2.setTextureOffset(0, 160).addBox(-1.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg2.setTextureOffset(107, 199).addBox(-1.0F, 0.0F, -1.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg2.setTextureOffset(37, 203).addBox(-0.2F, 0.2F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		seg1 = new WRModelRenderer(this);
		seg1.setRotationPoint(0.0F, 5.0F, 0.0F);
		seg2.addChild(seg1);
		seg1.setTextureOffset(100, 199).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg1.setTextureOffset(93, 199).addBox(-1.0F, 0.0F, -0.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg1.setTextureOffset(0, 147).addBox(-1.5F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg1.setTextureOffset(72, 204).addBox(-0.2F, 1.2F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		hand = new WRModelRenderer(this);
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

		armTent2 = new WRModelRenderer(this);
		armTent2.setRotationPoint(-8.5F, -35.9333F, 1.5F);
		wholeBody.addChild(armTent2);
		this.setRotateAngle(armTent2, 0.0F, 3.1416F, 0.4363F);

		shoulder2 = new WRModelRenderer(this);
		shoulder2.setRotationPoint(3.0F, 10.6F, -0.1F);
		armTent2.addChild(shoulder2);
		shoulder2.setTextureOffset(133, 183).addBox(-3.0F, -12.6F, -2.9F, 2.0F, 4.0F, 6.0F, 0.0F, false);
		shoulder2.setTextureOffset(108, 148).addBox(-2.5F, -13.0F, -2.4F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		shoulder2.setTextureOffset(119, 157).addBox(-2.5F, -12.1667F, 2.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder2.setTextureOffset(146, 117).addBox(-2.5F, -12.1667F, -3.4F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder2.setTextureOffset(94, 128).addBox(-1.4F, -12.4667F, -1.9F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		shoulder2.setTextureOffset(19, 173).addBox(-1.2F, -11.4667F, -0.9F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		armEye2 = new WRModelRenderer(this);
		armEye2.setRotationPoint(-0.3F, -0.3667F, 0.1F);
		shoulder2.addChild(armEye2);
		armEye2.setTextureOffset(70, 178).addBox(-0.4F, -10.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		seg4 = new WRModelRenderer(this);
		seg4.setRotationPoint(-1.5338F, -10.5359F, 0.1F);
		shoulder2.addChild(seg4);
		seg4.setTextureOffset(106, 111).addBox(-0.9662F, 1.8692F, -1.5F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		seg4.setTextureOffset(180, 50).addBox(-0.4662F, 1.8692F, -0.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg4.setTextureOffset(12, 178).addBox(-0.4662F, 1.8692F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg4.setTextureOffset(67, 202).addBox(0.3338F, 1.0692F, -0.5F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		bone2 = new WRModelRenderer(this);
		bone2.setRotationPoint(0.1529F, 6.8838F, 0.0F);
		seg4.addChild(bone2);

		seg5 = new WRModelRenderer(this);
		seg5.setRotationPoint(-0.3473F, -0.2843F, 0.0F);
		bone2.addChild(seg5);
		seg5.setTextureOffset(128, 0).addBox(-0.7717F, 0.2698F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg5.setTextureOffset(169, 153).addBox(-0.2717F, 0.2698F, -1.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg5.setTextureOffset(202, 139).addBox(0.5283F, 0.4698F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		seg6 = new WRModelRenderer(this);
		seg6.setRotationPoint(0.0F, 5.0F, 0.0F);
		seg5.addChild(seg6);
		seg6.setTextureOffset(158, 143).addBox(-0.2717F, 0.2698F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg6.setTextureOffset(83, 141).addBox(-0.2717F, 0.2698F, -0.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg6.setTextureOffset(0, 118).addBox(-0.7717F, 0.2698F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg6.setTextureOffset(0, 204).addBox(0.5283F, 1.4698F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		hand2 = new WRModelRenderer(this);
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

		armTent3 = new WRModelRenderer(this);
		armTent3.setRotationPoint(-4.5F, -32.9333F, 7.5F);
		wholeBody.addChild(armTent3);
		this.setRotateAngle(armTent3, 0.0F, 3.1416F, 0.4363F);

		shoulder3 = new WRModelRenderer(this);
		shoulder3.setRotationPoint(3.0F, 10.6F, -0.1F);
		armTent3.addChild(shoulder3);
		shoulder3.setTextureOffset(182, 11).addBox(-3.0F, -12.6F, -2.9F, 2.0F, 4.0F, 6.0F, 0.0F, false);
		shoulder3.setTextureOffset(64, 141).addBox(-2.5F, -13.0F, -2.4F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		shoulder3.setTextureOffset(72, 141).addBox(-2.5F, -12.1667F, 2.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder3.setTextureOffset(138, 117).addBox(-2.5F, -12.1667F, -3.4F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder3.setTextureOffset(32, 103).addBox(-1.4F, -12.4667F, -1.9F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		shoulder3.setTextureOffset(128, 117).addBox(-1.2F, -11.4667F, -0.9F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		armEye3 = new WRModelRenderer(this);
		armEye3.setRotationPoint(-0.3F, -0.3667F, 0.1F);
		shoulder3.addChild(armEye3);
		armEye3.setTextureOffset(168, 30).addBox(-0.4F, -10.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		seg7 = new WRModelRenderer(this);
		seg7.setRotationPoint(-1.9564F, -9.6296F, -0.4F);
		shoulder3.addChild(seg7);
		seg7.setTextureOffset(0, 103).addBox(-0.5436F, 0.9629F, -1.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		seg7.setTextureOffset(118, 67).addBox(-0.0436F, 0.9629F, 0.2F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg7.setTextureOffset(113, 14).addBox(-0.0436F, 0.9629F, -1.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg7.setTextureOffset(62, 202).addBox(0.7564F, 0.1629F, 0.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		bone4 = new WRModelRenderer(this);
		bone4.setRotationPoint(0.5755F, 5.9775F, 0.5F);
		seg7.addChild(bone4);

		seg8 = new WRModelRenderer(this);
		seg8.setRotationPoint(0.381F, 9.9855F, 0.0F);
		bone4.addChild(seg8);
		seg8.setTextureOffset(79, 105).addBox(-1.5F, -10.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg8.setTextureOffset(101, 0).addBox(-1.0F, -10.0F, -1.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg8.setTextureOffset(46, 187).addBox(-0.2F, -9.8F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		seg9 = new WRModelRenderer(this);
		seg9.setRotationPoint(-0.7283F, -5.2698F, 0.0F);
		seg8.addChild(seg9);
		seg9.setTextureOffset(98, 20).addBox(-0.2717F, 0.2698F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg9.setTextureOffset(69, 66).addBox(-0.2717F, 0.2698F, -0.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg9.setTextureOffset(48, 105).addBox(-0.7717F, 0.2698F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg9.setTextureOffset(108, 147).addBox(0.5283F, 1.4698F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		hand3 = new WRModelRenderer(this);
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

		armTent4 = new WRModelRenderer(this);
		armTent4.setRotationPoint(-5.5F, -39.9333F, 5.5F);
		wholeBody.addChild(armTent4);
		this.setRotateAngle(armTent4, 0.0F, 3.1416F, 2.138F);

		shoulder4 = new WRModelRenderer(this);
		shoulder4.setRotationPoint(3.0F, 10.6F, -0.1F);
		armTent4.addChild(shoulder4);
		shoulder4.setTextureOffset(94, 61).addBox(-3.0F, -12.6F, -2.9F, 2.0F, 4.0F, 6.0F, 0.0F, false);
		shoulder4.setTextureOffset(120, 117).addBox(-2.5F, -13.0F, -2.4F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		shoulder4.setTextureOffset(120, 117).addBox(-2.5F, -12.1667F, 2.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder4.setTextureOffset(60, 80).addBox(-2.5F, -12.1667F, -3.4F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		shoulder4.setTextureOffset(90, 89).addBox(-1.4F, -12.4667F, -1.9F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		shoulder4.setTextureOffset(56, 126).addBox(-1.2F, -11.4667F, -0.9F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		armEye4 = new WRModelRenderer(this);
		armEye4.setRotationPoint(-0.3F, -0.3667F, 0.1F);
		shoulder4.addChild(armEye4);
		armEye4.setTextureOffset(147, 128).addBox(-0.4F, -10.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		seg11 = new WRModelRenderer(this);
		seg11.setRotationPoint(-2.379F, -8.7233F, 0.6F);
		shoulder4.addChild(seg11);
		seg11.setTextureOffset(74, 46).addBox(-0.121F, 0.0566F, -2.0F, 2.0F, 5.0F, 3.0F, 0.0F, false);
		seg11.setTextureOffset(11, 64).addBox(0.379F, 0.0566F, -0.8F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg11.setTextureOffset(0, 64).addBox(0.379F, 0.0566F, -2.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg11.setTextureOffset(66, 118).addBox(1.179F, -0.7434F, -1.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		bone6 = new WRModelRenderer(this);
		bone6.setRotationPoint(0.9981F, 5.0712F, -0.5F);
		seg11.addChild(bone6);

		seg12 = new WRModelRenderer(this);
		seg12.setRotationPoint(-0.3812F, 0.0146F, 0.0F);
		bone6.addChild(seg12);
		seg12.setTextureOffset(76, 89).addBox(-0.7378F, -0.0291F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg12.setTextureOffset(43, 21).addBox(-0.2378F, -0.0291F, -1.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg12.setTextureOffset(0, 53).addBox(0.5622F, 0.1709F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		seg13 = new WRModelRenderer(this);
		seg13.setRotationPoint(0.0F, 5.0F, 0.0F);
		seg12.addChild(seg13);
		seg13.setTextureOffset(42, 0).addBox(-0.2378F, -0.0291F, -2.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg13.setTextureOffset(0, 40).addBox(-0.2378F, -0.0291F, -0.3F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		seg13.setTextureOffset(0, 84).addBox(-0.7378F, -0.0291F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		seg13.setTextureOffset(105, 61).addBox(0.5622F, 1.1709F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		hand4 = new WRModelRenderer(this);
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

		neck = new WRModelRenderer(this);
		neck.setRotationPoint(0.0F, 5.0F, -20.0F);
		upperTorso.addChild(neck);

		neck1 = new WRModelRenderer(this);
		neck1.setRotationPoint(1.0F, -8.4698F, -7.6119F);
		neck.addChild(neck1);

		cube_r1 = new WRModelRenderer(this);
		cube_r1.setRotationPoint(5.5F, -3.2167F, -2.1711F);
		neck1.addChild(cube_r1);
		this.setRotateAngle(cube_r1, 0.5672F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(48, 118).addBox(-4.0F, -9.0F, -5.0F, 1.0F, 2.0F, 15.0F, 0.0F, false);
		cube_r1.setTextureOffset(120, 120).addBox(-8.0F, -9.0F, -5.0F, 1.0F, 2.0F, 15.0F, 0.0F, false);
		cube_r1.setTextureOffset(114, 79).addBox(-6.0F, -9.0F, -5.0F, 1.0F, 9.0F, 13.0F, 0.0F, false);

		cube_r2 = new WRModelRenderer(this);
		cube_r2.setRotationPoint(6.0F, -1.2167F, -2.1711F);
		neck1.addChild(cube_r2);
		this.setRotateAngle(cube_r2, 0.5672F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(67, 141).addBox(-5.0F, -9.0F, -5.0F, 2.0F, 8.0F, 11.0F, 0.0F, false);
		cube_r2.setTextureOffset(142, 142).addBox(-9.0F, -9.0F, -5.0F, 2.0F, 8.0F, 11.0F, 0.0F, false);
		cube_r2.setTextureOffset(144, 83).addBox(-7.0F, -9.0F, -5.0F, 2.0F, 8.0F, 11.0F, 0.0F, false);
		cube_r2.setTextureOffset(94, 147).addBox(-2.0F, -9.0F, -5.0F, 1.0F, 9.0F, 11.0F, 0.0F, false);
		cube_r2.setTextureOffset(22, 151).addBox(-11.0F, -9.0F, -5.0F, 1.0F, 9.0F, 11.0F, 0.0F, false);
		cube_r2.setTextureOffset(65, 68).addBox(-10.0F, -8.0F, -5.0F, 8.0F, 8.0F, 12.0F, 0.0F, false);

		lGills = new WRModelRenderer(this);
		lGills.setRotationPoint(4.5F, -5.0302F, -3.3881F);
		neck1.addChild(lGills);

		cube_r3 = new WRModelRenderer(this);
		cube_r3.setRotationPoint(4.0F, 1.3135F, 8.017F);
		lGills.addChild(cube_r3);
		this.setRotateAngle(cube_r3, 0.5672F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(86, 197).addBox(-4.0F, -9.0F, -5.0F, 3.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r4 = new WRModelRenderer(this);
		cube_r4.setRotationPoint(4.0F, 0.8135F, 7.217F);
		lGills.addChild(cube_r4);
		this.setRotateAngle(cube_r4, 0.5672F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(114, 199).addBox(-4.0F, -9.0F, -5.0F, 2.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r5 = new WRModelRenderer(this);
		cube_r5.setRotationPoint(4.0F, 1.8135F, 7.217F);
		lGills.addChild(cube_r5);
		this.setRotateAngle(cube_r5, 0.5672F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(197, 197).addBox(-4.0F, -9.0F, -5.0F, 3.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r6 = new WRModelRenderer(this);
		cube_r6.setRotationPoint(4.0F, 1.8135F, 6.217F);
		lGills.addChild(cube_r6);
		this.setRotateAngle(cube_r6, 0.5672F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(119, 199).addBox(-4.0F, -9.0F, -5.0F, 2.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r7 = new WRModelRenderer(this);
		cube_r7.setRotationPoint(4.0F, 2.0135F, 5.217F);
		lGills.addChild(cube_r7);
		this.setRotateAngle(cube_r7, 0.5672F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(91, 161).addBox(-4.0F, -9.0F, -5.0F, 1.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r8 = new WRModelRenderer(this);
		cube_r8.setRotationPoint(4.0F, 1.7135F, 8.817F);
		lGills.addChild(cube_r8);
		this.setRotateAngle(cube_r8, 0.5672F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(102, 147).addBox(-4.0F, -9.0F, -5.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		rGills = new WRModelRenderer(this);
		rGills.setRotationPoint(-5.0F, -5.0302F, -3.3881F);
		neck1.addChild(rGills);

		cube_r9 = new WRModelRenderer(this);
		cube_r9.setRotationPoint(1.5F, 1.3135F, 8.017F);
		rGills.addChild(cube_r9);
		this.setRotateAngle(cube_r9, 0.5672F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(28, 64).addBox(-4.0F, -9.0F, -5.0F, 3.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r10 = new WRModelRenderer(this);
		cube_r10.setRotationPoint(2.5F, 0.8135F, 7.217F);
		rGills.addChild(cube_r10);
		this.setRotateAngle(cube_r10, 0.5672F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(64, 136).addBox(-4.0F, -9.0F, -5.0F, 2.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r11 = new WRModelRenderer(this);
		cube_r11.setRotationPoint(1.5F, 1.8135F, 7.217F);
		rGills.addChild(cube_r11);
		this.setRotateAngle(cube_r11, 0.5672F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(173, 30).addBox(-4.0F, -9.0F, -5.0F, 3.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r12 = new WRModelRenderer(this);
		cube_r12.setRotationPoint(2.5F, 1.8135F, 6.217F);
		rGills.addChild(cube_r12);
		this.setRotateAngle(cube_r12, 0.5672F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(17, 160).addBox(-4.0F, -9.0F, -5.0F, 2.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r13 = new WRModelRenderer(this);
		cube_r13.setRotationPoint(3.5F, 2.0135F, 5.217F);
		rGills.addChild(cube_r13);
		this.setRotateAngle(cube_r13, 0.5672F, 0.0F, 0.0F);
		cube_r13.setTextureOffset(127, 102).addBox(-4.0F, -9.0F, -5.0F, 1.0F, 9.0F, 0.0F, 0.0F, false);

		cube_r14 = new WRModelRenderer(this);
		cube_r14.setRotationPoint(3.5F, 1.7135F, 8.817F);
		rGills.addChild(cube_r14);
		this.setRotateAngle(cube_r14, 0.5672F, 0.0F, 0.0F);
		cube_r14.setTextureOffset(62, 31).addBox(-4.0F, -9.0F, -5.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);

		face = new WRModelRenderer(this);
		face.setRotationPoint(0.0F, 8.4698F, -6.3881F);
		neck1.addChild(face);
		face.setTextureOffset(138, 28).addBox(-6.0F, -15.0F, -5.0F, 12.0F, 9.0F, 5.0F, 0.0F, false);

		eyes = new WRModelRenderer(this);
		eyes.setRotationPoint(-4.5F, 2.5F, 7.5F);
		face.addChild(eyes);

		eye2 = new WRModelRenderer(this);
		eye2.setRotationPoint(9.1F, -15.0F, -13.0F);
		eyes.addChild(eye2);
		eye2.setTextureOffset(73, 197).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		eye3 = new WRModelRenderer(this);
		eye3.setRotationPoint(4.5F, -18.0F, -13.0F);
		eyes.addChild(eye3);
		eye3.setTextureOffset(196, 165).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		eye11 = new WRModelRenderer(this);
		eye11.setRotationPoint(7.5F, -8.0F, -13.0F);
		eyes.addChild(eye11);
		eye11.setTextureOffset(196, 113).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		eye6 = new WRModelRenderer(this);
		eye6.setRotationPoint(6.0F, -14.5F, -13.5F);
		eyes.addChild(eye6);
		eye6.setTextureOffset(44, 202).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye4 = new WRModelRenderer(this);
		eye4.setRotationPoint(1.0F, -11.5F, -13.5F);
		eyes.addChild(eye4);
		eye4.setTextureOffset(201, 152).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye5 = new WRModelRenderer(this);
		eye5.setRotationPoint(3.0F, -15.5F, -13.5F);
		eyes.addChild(eye5);
		eye5.setTextureOffset(201, 134).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye12 = new WRModelRenderer(this);
		eye12.setRotationPoint(-1.7F, -11.9F, -12.5F);
		eyes.addChild(eye12);
		eye12.setTextureOffset(157, 201).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye7 = new WRModelRenderer(this);
		eye7.setRotationPoint(10.0F, -17.5F, -12.5F);
		eyes.addChild(eye7);
		eye7.setTextureOffset(201, 91).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye10 = new WRModelRenderer(this);
		eye10.setRotationPoint(0.0F, -8.5F, -12.5F);
		eyes.addChild(eye10);
		eye10.setTextureOffset(166, 201).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye9 = new WRModelRenderer(this);
		eye9.setRotationPoint(4.0F, -10.5F, -12.5F);
		eyes.addChild(eye9);
		eye9.setTextureOffset(175, 201).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye8 = new WRModelRenderer(this);
		eye8.setRotationPoint(10.0F, -10.5F, -12.5F);
		eyes.addChild(eye8);
		eye8.setTextureOffset(201, 27).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye = new WRModelRenderer(this);
		eye.setRotationPoint(-0.3F, -16.2F, -13.0F);
		eyes.addChild(eye);
		eye.setTextureOffset(184, 197).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		tentacles = new WRModelRenderer(this);
		tentacles.setRotationPoint(0.0F, 6.0F, 8.0F);
		face.addChild(tentacles);

		tent6 = new WRModelRenderer(this);
		tent6.setRotationPoint(-5.9F, -16.0F, -12.0F);
		tentacles.addChild(tent6);
		this.setRotateAngle(tent6, 0.48F, 0.0F, 0.0F);
		tent6.setTextureOffset(0, 197).addBox(-1.0F, -1.9235F, -3.774F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent7 = new WRModelRenderer(this);
		tent7.setRotationPoint(0.1F, -0.4982F, -3.1228F);
		tent6.addChild(tent7);
		this.setRotateAngle(tent7, 0.48F, 0.0F, 0.0F);
		tent7.setTextureOffset(196, 180).addBox(-1.09F, -1.5649F, -3.9195F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent8 = new WRModelRenderer(this);
		tent8.setRotationPoint(-0.1F, -0.2873F, -3.5936F);
		tent7.addChild(tent8);
		this.setRotateAngle(tent8, 0.5236F, 0.0F, 0.0F);
		tent8.setTextureOffset(196, 173).addBox(-1.0F, -1.2695F, -3.6435F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent9 = new WRModelRenderer(this);
		tent9.setRotationPoint(0.1F, -0.2079F, -3.361F);
		tent8.addChild(tent9);
		this.setRotateAngle(tent9, 0.6545F, 0.0F, 0.0F);
		tent9.setTextureOffset(196, 120).addBox(-1.09F, -1.0142F, -3.5778F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent10 = new WRModelRenderer(this);
		tent10.setRotationPoint(0.0F, 0.0749F, -3.6048F);
		tent9.addChild(tent10);
		this.setRotateAngle(tent10, 0.2182F, 0.0F, 0.0F);
		tent10.setTextureOffset(53, 202).addBox(-0.7F, -0.4611F, -2.1723F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		tent22 = new WRModelRenderer(this);
		tent22.setRotationPoint(6.1F, -16.0F, -12.0F);
		tentacles.addChild(tent22);
		this.setRotateAngle(tent22, 0.48F, 0.0F, 0.0F);
		tent22.setTextureOffset(0, 197).addBox(-1.0F, -1.9235F, -3.774F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent23 = new WRModelRenderer(this);
		tent23.setRotationPoint(0.1F, -0.4982F, -3.1228F);
		tent22.addChild(tent23);
		this.setRotateAngle(tent23, 0.48F, 0.0F, 0.0F);
		tent23.setTextureOffset(196, 180).addBox(-1.09F, -1.5649F, -3.9195F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent24 = new WRModelRenderer(this);
		tent24.setRotationPoint(-0.1F, -0.2873F, -3.5936F);
		tent23.addChild(tent24);
		this.setRotateAngle(tent24, 0.5236F, 0.0F, 0.0F);
		tent24.setTextureOffset(196, 173).addBox(-1.0F, -1.2695F, -3.6435F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent25 = new WRModelRenderer(this);
		tent25.setRotationPoint(0.1F, -0.2079F, -3.361F);
		tent24.addChild(tent25);
		this.setRotateAngle(tent25, 0.6545F, 0.0F, 0.0F);
		tent25.setTextureOffset(196, 120).addBox(-1.09F, -1.0142F, -3.5778F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent26 = new WRModelRenderer(this);
		tent26.setRotationPoint(0.0F, 0.0749F, -3.6048F);
		tent25.addChild(tent26);
		this.setRotateAngle(tent26, 0.2182F, 0.0F, 0.0F);
		tent26.setTextureOffset(53, 202).addBox(-0.7F, -0.4611F, -2.1723F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		tent2 = new WRModelRenderer(this);
		tent2.setRotationPoint(2.2F, -16.6F, -12.0F);
		tentacles.addChild(tent2);
		this.setRotateAngle(tent2, 0.48F, 0.0F, 0.0F);
		tent2.setTextureOffset(0, 197).addBox(-1.0F, -1.9235F, -3.774F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent3 = new WRModelRenderer(this);
		tent3.setRotationPoint(0.1F, -0.4982F, -3.1228F);
		tent2.addChild(tent3);
		this.setRotateAngle(tent3, 0.48F, 0.0F, 0.0F);
		tent3.setTextureOffset(196, 180).addBox(-1.09F, -1.5649F, -3.9195F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent4 = new WRModelRenderer(this);
		tent4.setRotationPoint(-0.1F, -0.2873F, -3.5936F);
		tent3.addChild(tent4);
		this.setRotateAngle(tent4, 0.5236F, 0.0F, 0.0F);
		tent4.setTextureOffset(196, 173).addBox(-1.0F, -1.2695F, -3.6435F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent5 = new WRModelRenderer(this);
		tent5.setRotationPoint(0.1F, -0.2079F, -3.361F);
		tent4.addChild(tent5);
		this.setRotateAngle(tent5, 0.6545F, 0.0F, 0.0F);
		tent5.setTextureOffset(196, 120).addBox(-1.09F, -1.0142F, -3.5778F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent11 = new WRModelRenderer(this);
		tent11.setRotationPoint(0.0F, 0.0749F, -3.6048F);
		tent5.addChild(tent11);
		this.setRotateAngle(tent11, 0.2182F, 0.0F, 0.0F);
		tent11.setTextureOffset(53, 202).addBox(-0.7F, -0.4611F, -2.1723F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		tent12 = new WRModelRenderer(this);
		tent12.setRotationPoint(-2.5F, -12.3F, -12.0F);
		tentacles.addChild(tent12);
		this.setRotateAngle(tent12, 0.48F, 0.0F, 0.0F);
		tent12.setTextureOffset(0, 197).addBox(-1.0F, -1.9235F, -3.774F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent13 = new WRModelRenderer(this);
		tent13.setRotationPoint(0.1F, -0.4982F, -3.1228F);
		tent12.addChild(tent13);
		this.setRotateAngle(tent13, 0.48F, 0.0F, 0.0F);
		tent13.setTextureOffset(196, 180).addBox(-1.09F, -1.5649F, -3.9195F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent14 = new WRModelRenderer(this);
		tent14.setRotationPoint(-0.1F, -1.9256F, -4.7407F);
		tent13.addChild(tent14);
		this.setRotateAngle(tent14, 0.5236F, 0.0F, 0.0F);
		tent14.setTextureOffset(196, 173).addBox(-1.0F, 0.7229F, -3.4692F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent15 = new WRModelRenderer(this);
		tent15.setRotationPoint(0.1F, 1.7845F, -3.1867F);
		tent14.addChild(tent15);
		this.setRotateAngle(tent15, 0.6545F, 0.0F, 0.0F);
		tent15.setTextureOffset(196, 120).addBox(-1.09F, -1.0142F, -3.5778F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent16 = new WRModelRenderer(this);
		tent16.setRotationPoint(0.0F, 0.0749F, -3.6048F);
		tent15.addChild(tent16);
		this.setRotateAngle(tent16, 0.2182F, 0.0F, 0.0F);
		tent16.setTextureOffset(53, 202).addBox(-0.7F, -0.4611F, -2.1723F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		tent17 = new WRModelRenderer(this);
		tent17.setRotationPoint(-0.9F, -15.0F, -12.0F);
		tentacles.addChild(tent17);
		this.setRotateAngle(tent17, 0.48F, 0.0F, 0.0F);
		tent17.setTextureOffset(0, 197).addBox(-1.0F, -1.9235F, -3.774F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent18 = new WRModelRenderer(this);
		tent18.setRotationPoint(0.1F, -0.4982F, -3.1228F);
		tent17.addChild(tent18);
		this.setRotateAngle(tent18, 0.48F, 0.0F, 0.0F);
		tent18.setTextureOffset(196, 180).addBox(-1.09F, -1.5649F, -3.9195F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent19 = new WRModelRenderer(this);
		tent19.setRotationPoint(-0.1F, -0.2873F, -3.5936F);
		tent18.addChild(tent19);
		this.setRotateAngle(tent19, 0.5236F, 0.0F, 0.0F);
		tent19.setTextureOffset(196, 173).addBox(-1.0F, -1.2695F, -3.6435F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent20 = new WRModelRenderer(this);
		tent20.setRotationPoint(0.1F, -0.2079F, -3.361F);
		tent19.addChild(tent20);
		this.setRotateAngle(tent20, 0.6545F, 0.0F, 0.0F);
		tent20.setTextureOffset(196, 120).addBox(-1.09F, -1.0142F, -3.5778F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent21 = new WRModelRenderer(this);
		tent21.setRotationPoint(0.0F, 0.0749F, -3.6048F);
		tent20.addChild(tent21);
		this.setRotateAngle(tent21, 0.2182F, 0.0F, 0.0F);
		tent21.setTextureOffset(53, 202).addBox(-0.7F, -0.4611F, -2.1723F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		neck2 = new WRModelRenderer(this);
		neck2.setRotationPoint(1.0F, 0.2851F, -0.6844F);
		neck.addChild(neck2);
		this.setRotateAngle(neck2, -0.2618F, 0.0F, 0.0F);

		cube_r15 = new WRModelRenderer(this);
		cube_r15.setRotationPoint(-1.0F, 2.3032F, 6.6599F);
		neck2.addChild(cube_r15);
		this.setRotateAngle(cube_r15, -0.2618F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(102, 111).addBox(0.5F, -18.0885F, -24.5263F, 1.0F, 5.0F, 15.0F, 0.0F, false);
		cube_r15.setTextureOffset(28, 105).addBox(0.0F, -16.4904F, -25.0263F, 2.0F, 5.0F, 15.0F, 0.0F, false);
		cube_r15.setTextureOffset(88, 89).addBox(-2.0F, -14.4904F, -23.7583F, 6.0F, 8.0F, 13.0F, 0.0F, false);

		rightArm = new WRModelRenderer(this);
		rightArm.setRotationPoint(-12.0F, -5.0F, -14.0F);
		upperTorso.addChild(rightArm);
		this.setRotateAngle(rightArm, 0.0F, 3.1416F, 0.0F);

		rShoulder = new WRModelRenderer(this);
		rShoulder.setRotationPoint(-2.0F, -1.5F, 3.2F);
		rightArm.addChild(rShoulder);
		this.setRotateAngle(rShoulder, 1.1345F, 0.0F, 0.0F);
		rShoulder.setTextureOffset(43, 93).addBox(5.0F, -2.0F, -1.7F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		rShoulder.setTextureOffset(66, 121).addBox(4.0F, -3.0F, -2.7F, 1.0F, 5.0F, 5.0F, 0.0F, false);
		rShoulder.setTextureOffset(0, 64).addBox(1.0F, -4.5F, -4.2F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		rShoulder.setTextureOffset(20, 172).addBox(2.0F, -4.0F, -3.7F, 2.0F, 7.0F, 7.0F, 0.0F, false);

		rBicep = new WRModelRenderer(this);
		rBicep.setRotationPoint(8.0F, 0.5F, -0.2F);
		rShoulder.addChild(rBicep);
		this.setRotateAngle(rBicep, 0.0F, 0.829F, 1.309F);
		rBicep.setTextureOffset(158, 132).addBox(-0.3954F, -2.4176F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, false);
		rBicep.setTextureOffset(197, 59).addBox(-1.3954F, -1.4176F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		rBicep.setTextureOffset(157, 114).addBox(-0.3954F, -2.4176F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, false);
		rBicep.setTextureOffset(160, 89).addBox(0.6046F, -2.9176F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		rBicep.setTextureOffset(157, 125).addBox(0.6046F, 2.0824F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		rBicep.setTextureOffset(106, 168).addBox(0.1046F, -1.9176F, -3.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		rBicep.setTextureOffset(155, 0).addBox(0.1046F, -1.9176F, 2.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);

		rElbow = new WRModelRenderer(this);
		rElbow.setRotationPoint(7.6F, 0.0F, 0.0F);
		rBicep.addChild(rElbow);
		rElbow.setTextureOffset(43, 31).addBox(0.0046F, -1.4176F, -1.5F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		rElbow.setTextureOffset(130, 28).addBox(1.0046F, 1.0824F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		rElbow.setTextureOffset(74, 118).addBox(1.0046F, -1.9176F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		rElbow.setTextureOffset(114, 88).addBox(0.5046F, -0.9176F, -2.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		rElbow.setTextureOffset(110, 52).addBox(0.5046F, -0.9176F, 1.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		rFore = new WRModelRenderer(this);
		rFore.setRotationPoint(6.0F, 0.0F, 0.0F);
		rElbow.addChild(rFore);
		this.setRotateAngle(rFore, 0.829F, -0.8727F, 0.6545F);
		rFore.setTextureOffset(119, 157).addBox(0.0046F, -2.4176F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, false);
		rFore.setTextureOffset(154, 71).addBox(1.0046F, -2.9176F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		rFore.setTextureOffset(34, 88).addBox(1.0046F, 2.0824F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		rFore.setTextureOffset(94, 72).addBox(0.5046F, -1.9176F, -3.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		rFore.setTextureOffset(0, 33).addBox(0.5046F, -1.9176F, 2.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		rFore.setTextureOffset(0, 178).addBox(7.5046F, -1.4176F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		rHand = new WRModelRenderer(this);
		rHand.setRotationPoint(8.5046F, 0.0F, -0.5F);
		rFore.addChild(rHand);
		rHand.setTextureOffset(129, 168).addBox(0.0F, -1.4176F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		rHTent1 = new WRModelRenderer(this);
		rHTent1.setRotationPoint(1.3959F, 0.1431F, -0.0452F);
		rHand.addChild(rHTent1);
		this.setRotateAngle(rHTent1, -0.5672F, -0.6981F, -1.9635F);
		rHTent1.setTextureOffset(190, 22).addBox(-0.9268F, -1.231F, -2.8888F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent28 = new WRModelRenderer(this);
		tent28.setRotationPoint(-0.0555F, -0.0351F, -2.6395F);
		rHTent1.addChild(tent28);
		this.setRotateAngle(tent28, 0.48F, 0.0F, 0.0F);
		tent28.setTextureOffset(0, 190).addBox(-0.8614F, -1.1759F, -3.6689F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent29 = new WRModelRenderer(this);
		tent29.setRotationPoint(0.3437F, -0.4013F, -3.9596F);
		tent28.addChild(tent29);
		this.setRotateAngle(tent29, 0.5236F, 0.0F, 0.0F);
		tent29.setTextureOffset(189, 43).addBox(-1.215F, -0.5255F, -3.361F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent30 = new WRModelRenderer(this);
		tent30.setRotationPoint(-0.1291F, 0.6675F, -3.1555F);
		tent29.addChild(tent30);
		this.setRotateAngle(tent30, 0.6545F, 0.0F, 0.0F);
		tent30.setTextureOffset(188, 134).addBox(-1.0759F, -1.0716F, -3.4369F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent31 = new WRModelRenderer(this);
		tent31.setRotationPoint(-32.6686F, -18.6186F, 4.3332F);
		tent30.addChild(tent31);
		this.setRotateAngle(tent31, 0.2182F, 0.0F, 0.0F);
		tent31.setTextureOffset(91, 172).addBox(31.9827F, 16.0457F, -13.8181F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		rHTent4 = new WRModelRenderer(this);
		rHTent4.setRotationPoint(1.3959F, 0.1431F, -0.0452F);
		rHand.addChild(rHTent4);
		this.setRotateAngle(rHTent4, 0.8727F, -2.4871F, -2.4435F);
		rHTent4.setTextureOffset(182, 74).addBox(-0.9268F, -1.231F, -2.8888F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent39 = new WRModelRenderer(this);
		tent39.setRotationPoint(-0.0555F, -0.0351F, -2.6395F);
		rHTent4.addChild(tent39);
		this.setRotateAngle(tent39, 0.48F, 0.0F, 0.0F);
		tent39.setTextureOffset(51, 172).addBox(-0.8614F, -1.1759F, -3.6689F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent40 = new WRModelRenderer(this);
		tent40.setRotationPoint(0.354F, -0.1984F, -3.4547F);
		tent39.addChild(tent40);
		this.setRotateAngle(tent40, 0.5236F, 0.0F, 0.0F);
		tent40.setTextureOffset(32, 172).addBox(-1.2254F, -0.9537F, -3.6968F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent41 = new WRModelRenderer(this);
		tent41.setRotationPoint(-0.1395F, 0.2393F, -3.4912F);
		tent40.addChild(tent41);
		this.setRotateAngle(tent41, 0.6545F, 0.0F, 0.0F);
		tent41.setTextureOffset(145, 43).addBox(-1.0759F, -1.0716F, -3.4369F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent42 = new WRModelRenderer(this);
		tent42.setRotationPoint(-32.6686F, -18.6186F, 4.3332F);
		tent41.addChild(tent42);
		this.setRotateAngle(tent42, 0.2182F, 0.0F, 0.0F);
		tent42.setTextureOffset(118, 138).addBox(31.9827F, 16.0457F, -13.8181F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		rHTent2 = new WRModelRenderer(this);
		rHTent2.setRotationPoint(1.3959F, 0.1431F, -0.0452F);
		rHand.addChild(rHTent2);
		this.setRotateAngle(rHTent2, -1.4399F, 0.9163F, 2.7489F);
		rHTent2.setTextureOffset(188, 62).addBox(-0.9268F, -1.231F, -2.8888F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent33 = new WRModelRenderer(this);
		tent33.setRotationPoint(-0.0555F, -0.0351F, -2.6395F);
		rHTent2.addChild(tent33);
		this.setRotateAngle(tent33, 0.48F, 0.0F, 0.0F);
		tent33.setTextureOffset(187, 177).addBox(-0.8614F, -1.1759F, -3.6689F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent34 = new WRModelRenderer(this);
		tent34.setRotationPoint(0.7018F, -0.1359F, -3.0483F);
		tent33.addChild(tent34);
		this.setRotateAngle(tent34, 0.5236F, 0.0F, 0.0F);
		tent34.setTextureOffset(187, 170).addBox(-1.5731F, -1.2109F, -4.0175F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent35 = new WRModelRenderer(this);
		tent35.setRotationPoint(-0.4872F, -0.018F, -3.812F);
		tent34.addChild(tent35);
		this.setRotateAngle(tent35, 0.6545F, 0.0F, 0.0F);
		tent35.setTextureOffset(187, 116).addBox(-1.0759F, -1.0716F, -3.4369F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent36 = new WRModelRenderer(this);
		tent36.setRotationPoint(-32.6686F, -18.6186F, 4.3332F);
		tent35.addChild(tent36);
		this.setRotateAngle(tent36, 0.2182F, 0.0F, 0.0F);
		tent36.setTextureOffset(153, 132).addBox(31.9827F, 16.0457F, -13.8181F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		rHTent3 = new WRModelRenderer(this);
		rHTent3.setRotationPoint(1.3959F, 0.1431F, -0.0452F);
		rHand.addChild(rHTent3);
		this.setRotateAngle(rHTent3, -2.4871F, -0.0873F, 1.3526F);
		rHTent3.setTextureOffset(182, 187).addBox(-0.9268F, -1.231F, -2.8888F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent27 = new WRModelRenderer(this);
		tent27.setRotationPoint(-0.0555F, -0.0351F, -2.6395F);
		rHTent3.addChild(tent27);
		this.setRotateAngle(tent27, 0.48F, 0.0F, 0.0F);
		tent27.setTextureOffset(30, 187).addBox(-0.8614F, -1.1759F, -3.6689F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent32 = new WRModelRenderer(this);
		tent32.setRotationPoint(-0.1447F, -0.0289F, -3.4157F);
		tent27.addChild(tent32);
		this.setRotateAngle(tent32, 0.5236F, 0.0F, 0.0F);
		tent32.setTextureOffset(17, 187).addBox(-0.7267F, -1.12F, -3.6458F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent37 = new WRModelRenderer(this);
		tent37.setRotationPoint(0.3592F, 0.073F, -3.4403F);
		tent32.addChild(tent37);
		this.setRotateAngle(tent37, 0.6545F, 0.0F, 0.0F);
		tent37.setTextureOffset(185, 0).addBox(-1.0759F, -1.0716F, -3.4369F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		tent38 = new WRModelRenderer(this);
		tent38.setRotationPoint(-32.6686F, -18.6186F, 4.3332F);
		tent37.addChild(tent38);
		this.setRotateAngle(tent38, 0.2182F, 0.0F, 0.0F);
		tent38.setTextureOffset(148, 201).addBox(31.9827F, 16.0457F, -13.8181F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		leftArm = new WRModelRenderer(this);
		leftArm.setRotationPoint(14.0F, -5.0F, -20.0F);
		upperTorso.addChild(leftArm);

		lShoulder = new WRModelRenderer(this);
		lShoulder.setRotationPoint(-2.0F, -1.5F, 3.2F);
		leftArm.addChild(lShoulder);
		this.setRotateAngle(lShoulder, -1.1345F, 0.0F, 0.0F);
		lShoulder.setTextureOffset(129, 67).addBox(5.0F, -2.0F, -1.7F, 2.0F, 4.0F, 3.0F, 0.0F, false);
		lShoulder.setTextureOffset(138, 117).addBox(4.0F, -3.0F, -2.7F, 1.0F, 5.0F, 5.0F, 0.0F, false);
		lShoulder.setTextureOffset(165, 165).addBox(1.0F, -4.5F, -4.2F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		lShoulder.setTextureOffset(39, 172).addBox(2.0F, -4.0F, -3.7F, 2.0F, 7.0F, 7.0F, 0.0F, false);

		lBicep = new WRModelRenderer(this);
		lBicep.setRotationPoint(8.0F, 0.5F, -0.2F);
		lShoulder.addChild(lBicep);
		this.setRotateAngle(lBicep, 0.0F, -0.829F, 1.309F);
		lBicep.setTextureOffset(146, 162).addBox(-0.3954F, -2.4176F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, false);
		lBicep.setTextureOffset(197, 127).addBox(-1.3954F, -1.4176F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		lBicep.setTextureOffset(160, 78).addBox(-0.3954F, -2.4176F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, false);
		lBicep.setTextureOffset(180, 101).addBox(0.6046F, -2.9176F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		lBicep.setTextureOffset(176, 165).addBox(0.6046F, 2.0824F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		lBicep.setTextureOffset(180, 128).addBox(0.1046F, -1.9176F, -3.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		lBicep.setTextureOffset(103, 180).addBox(0.1046F, -1.9176F, 2.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);

		lElbow = new WRModelRenderer(this);
		lElbow.setRotationPoint(7.6F, 0.0F, 0.0F);
		lBicep.addChild(lElbow);
		this.setRotateAngle(lElbow, -0.5672F, 0.0F, 0.0F);
		lElbow.setTextureOffset(102, 32).addBox(0.0046F, -1.4176F, -1.5F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		lElbow.setTextureOffset(172, 46).addBox(1.0046F, 1.0824F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		lElbow.setTextureOffset(142, 138).addBox(1.0046F, -1.9176F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		lElbow.setTextureOffset(69, 161).addBox(0.5046F, -0.9176F, -2.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		lElbow.setTextureOffset(121, 153).addBox(0.5046F, -0.9176F, 1.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);

		lFore = new WRModelRenderer(this);
		lFore.setRotationPoint(6.0F, 0.0F, 0.0F);
		lElbow.addChild(lFore);
		this.setRotateAngle(lFore, 0.0F, 0.3491F, 0.8727F);
		lFore.setTextureOffset(47, 161).addBox(0.0046F, -2.4176F, -2.5F, 8.0F, 5.0F, 5.0F, 0.0F, false);
		lFore.setTextureOffset(0, 173).addBox(1.0046F, -2.9176F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		lFore.setTextureOffset(168, 25).addBox(1.0046F, 2.0824F, -1.5F, 6.0F, 1.0F, 3.0F, 0.0F, false);
		lFore.setTextureOffset(141, 173).addBox(0.5046F, -1.9176F, -3.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		lFore.setTextureOffset(70, 172).addBox(0.5046F, -1.9176F, 2.0F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		lFore.setTextureOffset(198, 37).addBox(7.5046F, -1.4176F, -1.5F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		lHand = new WRModelRenderer(this);
		lHand.setRotationPoint(8.5046F, 0.0F, -0.5F);
		lFore.addChild(lHand);
		lHand.setTextureOffset(198, 0).addBox(0.0F, -1.4176F, -1.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		lUpperClaw = new WRModelRenderer(this);
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

		lLowerClaw = new WRModelRenderer(this);
		lLowerClaw.setRotationPoint(1.3954F, 0.3F, 2.0F);
		lHand.addChild(lLowerClaw);
		lLowerClaw.setTextureOffset(178, 62).addBox(-0.3954F, -0.7176F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lLowerClaw.setTextureOffset(69, 15).addBox(0.6046F, -0.7176F, 1.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		lLowerClaw.setTextureOffset(74, 66).addBox(0.6046F, -0.7176F, 0.0F, 5.0F, 0.0F, 1.0F, 0.0F, false);
		lLowerClaw.setTextureOffset(42, 15).addBox(0.6046F, 0.2824F, 0.0F, 5.0F, 0.0F, 1.0F, 0.0F, false);
		lLowerClaw.setTextureOffset(80, 178).addBox(4.6046F, -0.7176F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lLowerClaw.setTextureOffset(75, 178).addBox(5.6046F, -0.7176F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		backEye2 = new WRModelRenderer(this);
		backEye2.setRotationPoint(-8.0F, 2.0F, -16.5F);
		upperTorso.addChild(backEye2);
		backEye2.setTextureOffset(61, 184).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		backEye3 = new WRModelRenderer(this);
		backEye3.setRotationPoint(10.5F, -12.5F, -17.0F);
		upperTorso.addChild(backEye3);
		backEye3.setTextureOffset(190, 50).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		backEye = new WRModelRenderer(this);
		backEye.setRotationPoint(-9.5F, -12.5F, -17.0F);
		upperTorso.addChild(backEye);
		backEye.setTextureOffset(191, 158).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		backEye5 = new WRModelRenderer(this);
		backEye5.setRotationPoint(8.5F, 0.0F, -17.0F);
		upperTorso.addChild(backEye5);
		backEye5.setTextureOffset(124, 183).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		backEye6 = new WRModelRenderer(this);
		backEye6.setRotationPoint(0.5F, 0.0F, -17.0F);
		upperTorso.addChild(backEye6);
		backEye6.setTextureOffset(59, 15).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		backEye4 = new WRModelRenderer(this);
		backEye4.setRotationPoint(1.0F, -12.5F, -10.0F);
		upperTorso.addChild(backEye4);
		backEye4.setTextureOffset(93, 192).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		tail = new WRModelRenderer(this);
		tail.setRotationPoint(0.0F, 25.0F, 24.6F);
		body.addChild(tail);
		tail.setTextureOffset(118, 138).addBox(-2.0F, -6.0F, -6.0F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		tail.setTextureOffset(24, 136).addBox(-2.0F, -9.0F, -8.0F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		tail.setTextureOffset(112, 180).addBox(4.0F, -7.0F, -7.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(150, 173).addBox(-3.0F, -7.0F, -7.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(91, 180).addBox(4.0F, -10.0F, -7.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(172, 34).addBox(-3.0F, -10.0F, -7.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(178, 50).addBox(4.0F, -13.0F, -7.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(79, 172).addBox(-3.0F, -13.0F, -7.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(0, 178).addBox(4.0F, -16.0F, -7.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(58, 172).addBox(-3.0F, -16.0F, -7.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(176, 134).addBox(4.0F, -19.0F, -7.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(171, 89).addBox(-3.0F, -19.0F, -7.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(176, 62).addBox(4.0F, -22.0F, -7.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(129, 171).addBox(-3.0F, -22.0F, -7.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(175, 116).addBox(4.0F, -24.0F, -3.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(168, 153).addBox(0.0F, -26.0F, -3.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(106, 79).addBox(0.0F, -5.0F, 0.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		tail.setTextureOffset(76, 89).addBox(0.0F, -8.0F, -5.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(175, 175).addBox(-3.0F, -24.0F, -3.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);
		tail.setTextureOffset(94, 132).addBox(-2.0F, -12.0F, -9.0F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		tail.setTextureOffset(0, 132).addBox(-2.0F, -15.0F, -8.0F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		tail.setTextureOffset(130, 68).addBox(-2.0F, -18.0F, -9.0F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		tail.setTextureOffset(70, 126).addBox(-2.0F, -21.0F, -8.0F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		tail.setTextureOffset(120, 102).addBox(-2.0F, -24.0F, -9.0F, 6.0F, 3.0F, 11.0F, 0.0F, false);
		tail.setTextureOffset(110, 32).addBox(-3.0F, -27.0F, -11.0F, 8.0F, 3.0F, 11.0F, 0.0F, false);
		tail.setTextureOffset(48, 105).addBox(-4.0F, -29.0F, -11.0F, 10.0F, 2.0F, 10.0F, 0.0F, false);

		foot = new WRModelRenderer(this);
		foot.setRotationPoint(-9.0F, 3.0F, 37.0F);
		tail.addChild(foot);

		bone5 = new WRModelRenderer(this);
		bone5.setRotationPoint(9.0F, -6.0F, -40.0F);
		foot.addChild(bone5);
		bone5.setTextureOffset(46, 46).addBox(5.0F, 9.0F, -9.0F, 4.0F, 0.0F, 19.0F, 0.0F, false);
		bone5.setTextureOffset(0, 64).addBox(-7.0F, 9.0F, -9.0F, 4.0F, 0.0F, 19.0F, 0.0F, false);
		bone5.setTextureOffset(42, 10).addBox(-7.0F, 9.0F, -13.0F, 16.0F, 0.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(110, 47).addBox(-5.0F, 9.0F, -17.0F, 12.0F, 0.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(130, 83).addBox(-3.0F, 5.0F, -13.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(24, 132).addBox(-2.0F, 4.0F, -11.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
		bone5.setTextureOffset(155, 103).addBox(-4.0F, 3.0F, -9.0F, 10.0F, 6.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(36, 152).addBox(-4.0F, 0.0F, -5.0F, 10.0F, 4.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(74, 61).addBox(-4.0F, 2.0F, -7.0F, 10.0F, 1.0F, 2.0F, 0.0F, false);
		bone5.setTextureOffset(144, 12).addBox(-5.0F, 4.0F, -5.0F, 12.0F, 5.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(74, 46).addBox(-5.0F, 6.0F, -1.0F, 12.0F, 3.0F, 11.0F, 0.0F, false);
		bone5.setTextureOffset(0, 103).addBox(-4.0F, 3.0F, -1.0F, 10.0F, 3.0F, 11.0F, 0.0F, false);
		bone5.setTextureOffset(78, 111).addBox(-3.0F, 0.0F, -1.0F, 8.0F, 3.0F, 11.0F, 0.0F, false);

		bone = new WRModelRenderer(this);
		bone.setRotationPoint(1.0F, 8.0F, 10.0F);
		bone5.addChild(bone);
		bone.setTextureOffset(0, 0).addBox(-6.0F, -2.0F, 0.0F, 12.0F, 3.0F, 17.0F, 0.0F, false);
		bone.setTextureOffset(94, 61).addBox(-9.0F, 1.0F, 0.0F, 3.0F, 0.0F, 17.0F, 0.0F, false);
		bone.setTextureOffset(89, 14).addBox(6.0F, 1.0F, 0.0F, 3.0F, 0.0F, 17.0F, 0.0F, false);
		bone.setTextureOffset(42, 80).addBox(-3.0F, -4.0F, 12.0F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(43, 89).addBox(-5.0F, -5.0F, 0.0F, 10.0F, 3.0F, 12.0F, 0.0F, false);
		bone.setTextureOffset(128, 0).addBox(-4.0F, -6.0F, 0.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);

		seg10 = new WRModelRenderer(this);
		seg10.setRotationPoint(0.0F, 0.0F, 17.0F);
		bone.addChild(seg10);
		seg10.setTextureOffset(0, 118).addBox(-4.0F, -1.9F, -2.0F, 8.0F, 3.0F, 10.0F, 0.0F, false);
		seg10.setTextureOffset(0, 162).addBox(-7.0F, 0.99F, -2.0F, 3.0F, 0.0F, 10.0F, 0.0F, false);
		seg10.setTextureOffset(74, 161).addBox(4.0F, 0.99F, -2.0F, 3.0F, 0.0F, 10.0F, 0.0F, false);
		seg10.setTextureOffset(75, 10).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);

		endSeg = new WRModelRenderer(this);
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
		headArray = new WRModelRenderer[] { neck1, neck2, face };
		setDefaultPose();

	}

	@Override
	public void setLivingAnimations(EntityUzouthrhix entityIn, float limbSwing, float limbSwingAmount,
			float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
		this.entity = entityIn;
		this.entity = entityIn;
		resetToDefaultPose();
		animator.update(entity, partialTick);
		if (animator.setAnimation(EntityUzouthrhix.LIGHTNING_ANIMATION)) {
			roarAnim(partialTick);
		} else if (animator.setAnimation(EntityUzouthrhix.BITE_ANIMATION)) {
			biteAnim();
		}

		idle(entity.ticksExisted + partialTick);

	}

	private void roarAnim(float partialTick) {
		animator.startKeyframe(16);
		animator.rotate(upperTorso, -0.55f, 0, 0);
		animator.rotate(rShoulder, -0.55f, 0, 0);
		animator.rotate(leftArm, -0.55f, 0, 0);
	//	animator.rotate(leftArm, -0.55f, 0, 0);

		animator.endKeyframe();
		animator.startKeyframe(3);
		animator.rotate(neck1, -0.45f, 0, 0);
		animator.endKeyframe();
		animator.resetKeyframe(18);
	}

	private void biteAnim() {
		animator.startKeyframe(6);
		animator.rotate(neck1, -0.6f, 0, 0);
		animator.rotate(neck2, 0.3f, 0, 0);
		animator.rotate(face, 0.4f, 0, 0);
		animator.rotate(upperTorso, 0.55f, 0, 0);
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
		this.rHTent1.rotateAngleX = (float) (Math.sin((frame) * 0.53f) * 0.0325);
		this.rHTent2.rotateAngleX = (float) (Math.sin((frame) * 0.53f) * 0.0325) - 1.5f;
		this.rHTent3.rotateAngleX = (float) (Math.sin((frame) * 0.53f) * 0.0325) - 2.5f;
		this.rHTent4.rotateAngleX = (float) (Math.sin((frame) * 0.53f) * 0.0325) + 0.5f;

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