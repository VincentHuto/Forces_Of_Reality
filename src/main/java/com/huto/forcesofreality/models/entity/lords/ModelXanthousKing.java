package com.huto.forcesofreality.models.entity.lords;

import com.huto.forcesofreality.entities.lords.EntityXanthousKing;
import com.huto.forcesofreality.events.ClientEventSubscriber;
import com.huto.forcesofreality.models.animation.ModelAnimator;
import com.huto.forcesofreality.models.animation.AnimatedEntityModel;
import com.huto.forcesofreality.models.animation.AnimatedModelRenderer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.util.math.MathHelper;

public class ModelXanthousKing extends AnimatedEntityModel<EntityXanthousKing> {
	private final AnimatedModelRenderer whole;
	private final AnimatedModelRenderer upperBody;
	private final AnimatedModelRenderer hasturForm;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer leftArm;
	private final AnimatedModelRenderer leftElbow;
	private final AnimatedModelRenderer rightArm;
	private final AnimatedModelRenderer rElbow;
	private final AnimatedModelRenderer staff;
	private final AnimatedModelRenderer bone;
	private final AnimatedModelRenderer cube_r1;
	private final AnimatedModelRenderer emblem;
	private final AnimatedModelRenderer backing;
	private final AnimatedModelRenderer crest;
	private final AnimatedModelRenderer crest2;
	private final AnimatedModelRenderer crest3;
	private final AnimatedModelRenderer crest4;
	private final AnimatedModelRenderer crest5;
	private final AnimatedModelRenderer lowerBody;
	private final AnimatedModelRenderer jaw;
	private final AnimatedModelRenderer jaw2;
	private final AnimatedModelRenderer topJaw;
	private final AnimatedModelRenderer bone3;
	private final AnimatedModelRenderer bottomJaw;
	private final AnimatedModelRenderer bone2;
	private final AnimatedModelRenderer fRArm;
	private final AnimatedModelRenderer fRShoulder;
	private final AnimatedModelRenderer fRBicep;
	private final AnimatedModelRenderer fRFore;
	private final AnimatedModelRenderer fRFist;
	private final AnimatedModelRenderer rFingers;
	private final AnimatedModelRenderer rFinger1;
	private final AnimatedModelRenderer rFinger12;
	private final AnimatedModelRenderer rFinger13;
	private final AnimatedModelRenderer rFinger2;
	private final AnimatedModelRenderer rFinger22;
	private final AnimatedModelRenderer rFinger23;
	private final AnimatedModelRenderer rFinger3;
	private final AnimatedModelRenderer rFinger32;
	private final AnimatedModelRenderer rFinger33;
	private final AnimatedModelRenderer rFinger4;
	private final AnimatedModelRenderer rFinger42;
	private final AnimatedModelRenderer rFinger43;
	private final AnimatedModelRenderer rThumb;
	private final AnimatedModelRenderer rThumb2;
	private final AnimatedModelRenderer fLArm;
	private final AnimatedModelRenderer fLShoulder;
	private final AnimatedModelRenderer fLBicep;
	private final AnimatedModelRenderer fLFore;
	private final AnimatedModelRenderer fLFist;
	private final AnimatedModelRenderer lFingers;
	private final AnimatedModelRenderer lFinger1;
	private final AnimatedModelRenderer lFinger12;
	private final AnimatedModelRenderer lFinger13;
	private final AnimatedModelRenderer lFinger2;
	private final AnimatedModelRenderer rFinger5;
	private final AnimatedModelRenderer lFinger23;
	private final AnimatedModelRenderer lFinger3;
	private final AnimatedModelRenderer lFinger32;
	private final AnimatedModelRenderer lFinger33;
	private final AnimatedModelRenderer lFinger4;
	private final AnimatedModelRenderer lFinger5;
	private final AnimatedModelRenderer lFinger43;
	private final AnimatedModelRenderer lThumb;
	private final AnimatedModelRenderer lThumb2;
	private final AnimatedModelRenderer fLLeg;
	private final AnimatedModelRenderer fLHip;
	private final AnimatedModelRenderer fLFemur;
	private final AnimatedModelRenderer fLTibia;
	private final AnimatedModelRenderer fLFoot;
	private final AnimatedModelRenderer bLLeg;
	private final AnimatedModelRenderer bLHip;
	private final AnimatedModelRenderer bLFemur;
	private final AnimatedModelRenderer bLTibia;
	private final AnimatedModelRenderer bLFoot;
	private final AnimatedModelRenderer fRLeg;
	private final AnimatedModelRenderer fRHip;
	private final AnimatedModelRenderer fRFemur;
	private final AnimatedModelRenderer fRTibia;
	private final AnimatedModelRenderer fRFoot;
	private final AnimatedModelRenderer bRLeg;
	private final AnimatedModelRenderer bRHip;
	private final AnimatedModelRenderer bRFemur;
	private final AnimatedModelRenderer bRTibia;
	private final AnimatedModelRenderer bRFoot;
	private final AnimatedModelRenderer tail;
	private final AnimatedModelRenderer tail2;
	private final AnimatedModelRenderer tail3;
	private final AnimatedModelRenderer tail4;
	private final AnimatedModelRenderer tail5;
	public ModelAnimator animator;

	public ModelXanthousKing() {
		textureWidth = 512;
		textureHeight = 512;

		whole = new AnimatedModelRenderer(this);
		whole.setRotationPoint(0.0F, -15.0F, -15.0F);

		upperBody = new AnimatedModelRenderer(this);
		upperBody.setRotationPoint(0.1F, -19.0F, -19.0F);
		upperBody.setTextureOffset(196, 200).addBox(-9.5F, -16.0F, 3.2F, 22.0F, 23.0F, 2.0F, 0.0F, false);
		upperBody.setTextureOffset(176, 64).addBox(-4.5F, -7.0F, 2.2F, 12.0F, 8.0F, 18.0F, 0.0F, false);
		upperBody.setTextureOffset(48, 195).addBox(-2.5F, -13.0F, 14.2F, 8.0F, 8.0F, 18.0F, 0.0F, false);
		upperBody.setTextureOffset(217, 225).addBox(-3.5F, -11.0F, 16.2F, 1.0F, 6.0F, 18.0F, 0.0F, false);
		upperBody.setTextureOffset(52, 221).addBox(5.5F, -11.0F, 16.2F, 1.0F, 6.0F, 18.0F, 0.0F, false);
		upperBody.setTextureOffset(29, 141).addBox(-2.5F, -21.0F, 9.2F, 8.0F, 8.0F, 18.0F, 0.0F, false);
		upperBody.setTextureOffset(176, 103).addBox(-3.5F, -5.0F, 20.2F, 10.0F, 8.0F, 18.0F, 0.0F, false);
		upperBody.setTextureOffset(60, 246).addBox(-5.5F, -5.0F, 16.2F, 2.0F, 7.0F, 12.0F, 0.0F, false);
		upperBody.setTextureOffset(32, 244).addBox(6.5F, -5.0F, 16.2F, 2.0F, 7.0F, 12.0F, 0.0F, false);
		upperBody.setTextureOffset(0, 101).addBox(-3.5F, -16.0F, -2.8F, 9.0F, 17.0F, 3.0F, 0.0F, false);
		upperBody.setTextureOffset(0, 141).addBox(-2.5F, 1.0F, -2.1F, 7.0F, 17.0F, 3.0F, 0.0F, false);
		upperBody.setTextureOffset(207, 169).addBox(-8.5F, -16.0F, 0.2F, 19.0F, 23.0F, 3.0F, 0.0F, false);
		upperBody.setTextureOffset(0, 185).addBox(-3.5F, -27.0F, 2.2F, 10.0F, 26.0F, 14.0F, 0.0F, false);
		upperBody.setTextureOffset(136, 297).addBox(8.25F, -14.0F, -6.8F, 5.0F, 4.0F, 10.0F, 0.0F, false);
		upperBody.setTextureOffset(138, 313).addBox(8.25F, -16.0F, -3.8F, 5.0F, 2.0F, 7.0F, 0.0F, false);
		upperBody.setTextureOffset(138, 313).addBox(-10.0F, -16.0F, -3.8F, 5.0F, 2.0F, 7.0F, 0.0F, false);
		upperBody.setTextureOffset(136, 297).addBox(-10.0F, -14.0F, -6.8F, 5.0F, 4.0F, 10.0F, 0.0F, false);
		upperBody.setTextureOffset(166, 301).addBox(-9.1F, -10.0F, -5.8F, 4.0F, 3.0F, 9.0F, 0.0F, false);
		upperBody.setTextureOffset(166, 301).addBox(8.35F, -10.0F, -5.8F, 4.0F, 3.0F, 9.0F, 0.0F, false);

		hasturForm = new AnimatedModelRenderer(this);
		hasturForm.setRotationPoint(0.0F, 0.0F, 0.0F);
		upperBody.addChild(hasturForm);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -28.0F, 0.0F);
		hasturForm.addChild(head);
		setRotateAngle(head, 0.2618F, 0.0F, 0.0F);
		head.setTextureOffset(191, 242).addBox(-2.5F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(144, 57).addBox(-2.5F, -10.0F, 4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(144, 55).addBox(-2.5F, -10.0F, -5.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(124, 178).addBox(-3.5F, -14.0F, -5.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(177, 167).addBox(5.5F, -14.0F, -5.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(176, 103).addBox(5.5F, -14.0F, 4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(176, 64).addBox(-3.5F, -14.0F, 4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(142, 20).addBox(-3.5F, -13.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(131, 20).addBox(5.5F, -13.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(134, 113).addBox(-3.5F, -13.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(66, 103).addBox(5.5F, -13.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(143, 2).addBox(-2.5F, -13.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-2.5F, -13.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(54, 103).addBox(4.5F, -13.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(36, 0).addBox(4.5F, -13.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(72, 230).addBox(-3.5F, -10.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(185, 103).addBox(-4.5F, -10.0F, -5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(72, 141).addBox(6.5F, -10.0F, -5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(185, 64).addBox(-4.5F, -10.0F, 2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(173, 54).addBox(6.5F, -10.0F, 2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(187, 186).addBox(-3.5F, -10.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(146, 154).addBox(-3.5F, -10.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(179, 0).addBox(3.5F, -10.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(16, 166).addBox(3.5F, -10.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(200, 90).addBox(5.5F, -10.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 28).addBox(-3.5F, -9.0F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
		head.setTextureOffset(202, 169).addBox(-3.5F, -8.0F, -5.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(173, 58).addBox(-3.5F, -8.0F, 3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(185, 107).addBox(4.5F, -8.0F, -5.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(185, 68).addBox(4.5F, -8.0F, 3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, -16.0F, 0.0F);
		hasturForm.addChild(body);
		body.setTextureOffset(134, 113).addBox(-2.5F, -12.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(111, 270).addBox(-2.5F, -12.0F, -3.1F, 8.0F, 7.0F, 5.0F, 0.0F, false);

		leftArm = new AnimatedModelRenderer(this);
		leftArm.setRotationPoint(4.0F, -9.0F, 0.0F);
		body.addChild(leftArm);
		setRotateAngle(leftArm, 0.0F, 0.0F, -0.3927F);
		leftArm.setTextureOffset(281, 22).addBox(1.3858F, -2.426F, -2.0F, 4.0F, 5.0F, 4.0F, 1.0F, false);
		leftArm.setTextureOffset(92, 230).addBox(1.3858F, -2.426F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

		leftElbow = new AnimatedModelRenderer(this);
		leftElbow.setRotationPoint(2.0F, 7.8F, -0.5F);
		leftArm.addChild(leftElbow);
		setRotateAngle(leftElbow, -1.0472F, 0.0F, 0.0F);
		leftElbow.setTextureOffset(249, 266).addBox(-0.6142F, 2.487F, -1.0029F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		leftElbow.setTextureOffset(0, 52).addBox(0.3858F, -0.513F, -0.0029F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		rightArm = new AnimatedModelRenderer(this);
		rightArm.setRotationPoint(-4.0F, -9.0F, 0.0F);
		body.addChild(rightArm);
		setRotateAngle(rightArm, 0.0F, 0.0F, 0.3054F);
		rightArm.setTextureOffset(82, 281).addBox(-2.5694F, -3.4511F, -2.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);
		rightArm.setTextureOffset(54, 103).addBox(-2.5694F, -3.4511F, -2.0F, 4.0F, 5.0F, 4.0F, 1.0F, false);

		rElbow = new AnimatedModelRenderer(this);
		rElbow.setRotationPoint(-2.0F, 7.75F, -0.5F);
		rightArm.addChild(rElbow);
		setRotateAngle(rElbow, -1.0908F, 0.0F, 0.0F);
		rElbow.setTextureOffset(223, 266).addBox(-0.5694F, 1.8696F, -1.7424F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		rElbow.setTextureOffset(15, 52).addBox(0.4306F, -1.1304F, -0.7424F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		staff = new AnimatedModelRenderer(this);
		staff.setRotationPoint(-0.3222F, 10.1944F, 1.1111F);
		rElbow.addChild(staff);
		setRotateAngle(staff, 0.3927F, 0.0F, 0.0F);
		staff.setTextureOffset(66, 66).addBox(-2.9657F, -0.4897F, -18.8088F, 9.0F, 0.0F, 8.0F, 0.0F, false);
		staff.setTextureOffset(241, 256).addBox(-4.1402F, -1.2774F, -17.5961F, 2.0F, 2.0F, 7.0F, 0.0F, false);
		staff.setTextureOffset(48, 263).addBox(4.6528F, -1.3887F, -16.6894F, 2.0F, 2.0F, 6.0F, 0.0F, false);
		staff.setTextureOffset(124, 86).addBox(-3.3472F, -1.3887F, -10.6894F, 9.0F, 2.0F, 2.0F, 0.0F, false);
		staff.setTextureOffset(78, 207).addBox(0.6528F, -2.3887F, -15.6894F, 2.0F, 1.0F, 22.0F, 0.0F, false);
		staff.setTextureOffset(240, 240).addBox(0.6528F, -1.3887F, -8.6894F, 2.0F, 1.0F, 15.0F, 0.0F, false);
		staff.setTextureOffset(198, 28).addBox(0.6528F, -0.3887F, -8.6894F, 2.0F, 1.0F, 24.0F, 0.0F, false);
		staff.setTextureOffset(208, 28).addBox(0.6528F, -1.3887F, 11.3106F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		staff.setTextureOffset(143, 2).addBox(0.6528F, 0.6113F, 11.3106F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		bone = new AnimatedModelRenderer(this);
		bone.setRotationPoint(-0.5F, 17.5F, -3.6F);
		upperBody.addChild(bone);
		setRotateAngle(bone, 0.6109F, 0.0F, 0.0F);

		cube_r1 = new AnimatedModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 2.1015F, 0.3548F);
		bone.addChild(cube_r1);
		setRotateAngle(cube_r1, 0.0873F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(180, 130).addBox(-6.0F, -5.8834F, -1.0068F, 15.0F, 12.0F, 13.0F, 0.0F, false);

		emblem = new AnimatedModelRenderer(this);
		emblem.setRotationPoint(-1.4F, 9.0F, -5.8F);
		upperBody.addChild(emblem);
		emblem.setTextureOffset(193, 173).addBox(2.5F, -19.0F, 2.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(29, 145).addBox(-0.5F, -15.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(142, 228).addBox(7.5F, -15.0F, 2.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(191, 202).addBox(7.5F, -22.0F, 2.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(146, 199).addBox(7.5F, -18.0F, 2.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(195, 186).addBox(6.3F, -13.0F, 2.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(208, 28).addBox(-2.5F, -15.0F, 2.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(146, 202).addBox(-2.5F, -22.0F, 2.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(48, 199).addBox(-2.5F, -18.0F, 2.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(190, 103).addBox(-1.3F, -13.0F, 2.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(217, 28).addBox(-0.5F, -17.0F, 2.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(117, 218).addBox(5.5F, -21.0F, 2.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(117, 218).addBox(-0.5F, -21.0F, 2.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(104, 218).addBox(5.5F, -17.0F, 2.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(63, 145).addBox(4.5F, -15.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(228, 225).addBox(7.5F, -16.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(177, 185).addBox(9.5F, -11.0F, 5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(20, 125).addBox(-6.7F, -11.0F, 5.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(50, 185).addBox(8.5F, -10.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(142, 20).addBox(-3.7F, -8.0F, 3.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		emblem.setTextureOffset(131, 7).addBox(5.5F, -9.0F, 4.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		emblem.setTextureOffset(0, 35).addBox(-4.7F, -9.0F, 4.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		emblem.setTextureOffset(152, 22).addBox(-5.7F, -10.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(182, 5).addBox(7.5F, -9.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(156, 59).addBox(-4.7F, -9.0F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(142, 173).addBox(1.3F, -6.0F, 2.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(72, 145).addBox(1.3F, -8.0F, 2.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(38, 145).addBox(1.3F, -10.0F, 2.8F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(228, 230).addBox(6.5F, -17.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(228, 228).addBox(3.5F, -13.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(64, 234).addBox(6.5F, -19.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(112, 230).addBox(7.5F, -21.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(116, 262).addBox(6.5F, -25.0F, 2.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(177, 182).addBox(4.5F, -23.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(146, 178).addBox(3.5F, -21.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(95, 117).addBox(3.5F, -18.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(235, 195).addBox(3.5F, -19.0F, 1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(23, 62).addBox(0.5F, -18.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(236, 19).addBox(0.5F, -19.0F, 1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(146, 181).addBox(0.5F, -21.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(182, 2).addBox(-0.5F, -23.0F, 2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(165, 264).addBox(-3.5F, -25.0F, 2.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(90, 230).addBox(-3.5F, -21.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(232, 50).addBox(-2.5F, -19.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(118, 230).addBox(-2.5F, -17.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(226, 50).addBox(0.5F, -13.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(72, 225).addBox(0.5F, -16.0F, 2.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(223, 136).addBox(-0.5F, -24.0F, 2.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(60, 210).addBox(0.5F, -25.0F, 2.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(97, 38).addBox(-1.5F, -26.0F, 2.3F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(223, 140).addBox(3.5F, -16.0F, 2.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(223, 138).addBox(4.5F, -24.0F, 2.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(200, 167).addBox(3.5F, -25.0F, 2.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(126, 66).addBox(4.5F, -26.0F, 2.3F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(38, 141).addBox(6.5F, -26.0F, 3.3F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		emblem.setTextureOffset(96, 55).addBox(-1.5F, -26.0F, 3.3F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		emblem.setTextureOffset(191, 200).addBox(-2.5F, -27.0F, 4.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(188, 197).addBox(6.5F, -27.0F, 4.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(223, 63).addBox(3.5F, -12.0F, 2.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(72, 221).addBox(5.5F, -10.0F, 2.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(48, 221).addBox(5.5F, -8.0F, 2.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(218, 64).addBox(-1.5F, -8.0F, 2.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(72, 223).addBox(0.5F, -12.0F, 2.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(48, 223).addBox(-1.5F, -10.0F, 2.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(140, 215).addBox(-3.5F, -10.0F, 5.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(214, 106).addBox(6.5F, -10.0F, 5.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(134, 215).addBox(-3.5F, -13.0F, 5.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(213, 50).addBox(6.5F, -13.0F, 5.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(214, 110).addBox(-2.5F, -6.9F, 5.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		emblem.setTextureOffset(228, 79).addBox(-3.5F, -16.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		backing = new AnimatedModelRenderer(this);
		backing.setRotationPoint(0.0F, -11.5F, 2.5F);
		upperBody.addChild(backing);
		setRotateAngle(backing, -0.1745F, 0.0F, 0.0F);
		backing.setTextureOffset(206, 155).addBox(-10.5F, -14.2569F, -3.2784F, 24.0F, 10.0F, 4.0F, 0.0F, false);
		backing.setTextureOffset(0, 279).addBox(9.5F, -21.5F, 5.5F, 2.0F, 24.0F, 3.0F, 0.0F, false);
		backing.setTextureOffset(257, 85).addBox(-6.5F, -25.5F, 5.5F, 16.0F, 4.0F, 3.0F, 0.0F, false);
		backing.setTextureOffset(0, 0).addBox(-6.5F, -21.5F, 5.5F, 16.0F, 24.0F, 4.0F, 0.0F, false);
		backing.setTextureOffset(10, 279).addBox(-8.5F, -21.5F, 5.5F, 2.0F, 24.0F, 3.0F, 0.0F, false);
		backing.setTextureOffset(146, 200).addBox(-8.5F, -26.5F, 0.5F, 20.0F, 27.0F, 5.0F, 0.0F, false);
		backing.setTextureOffset(154, 113).addBox(8.5F, -24.2569F, -4.2784F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		backing.setTextureOffset(21, 160).addBox(-7.5F, -24.2569F, -4.2784F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		backing.setTextureOffset(64, 35).addBox(-6.5F, -21.2569F, -4.2784F, 16.0F, 3.0F, 1.0F, 0.0F, false);
		backing.setTextureOffset(92, 66).addBox(-6.5F, -27.2569F, -4.2784F, 16.0F, 3.0F, 1.0F, 0.0F, false);
		backing.setTextureOffset(0, 185).addBox(10.5F, -27.2569F, -4.2784F, 5.0F, 13.0F, 1.0F, 0.0F, false);
		backing.setTextureOffset(116, 282).addBox(-12.5F, -27.2569F, -4.2784F, 5.0F, 13.0F, 1.0F, 0.0F, false);
		backing.setTextureOffset(125, 37).addBox(-10.5F, -27.2569F, -3.2784F, 24.0F, 13.0F, 4.0F, 0.0F, false);

		crest = new AnimatedModelRenderer(this);
		crest.setRotationPoint(-21.6429F, -27.5F, 6.5F);
		upperBody.addChild(crest);
		crest.setTextureOffset(0, 256).addBox(8.1429F, -19.5F, 0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(67, 245).addBox(-5.8571F, -19.5F, 0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(207, 197).addBox(-1.8571F, -9.5F, 0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(156, 64).addBox(-2.8571F, -10.5F, 0.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(127, 153).addBox(-2.8571F, -22.5F, 0.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(108, 230).addBox(7.1429F, -20.5F, 0.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(142, 218).addBox(-4.8571F, -20.5F, 0.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(279, 183).addBox(-3.8571F, -21.5F, -0.5F, 11.0F, 11.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(207, 195).addBox(-1.8571F, -23.5F, 0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		crest2 = new AnimatedModelRenderer(this);
		crest2.setRotationPoint(21.3571F, -27.5F, 6.5F);
		upperBody.addChild(crest2);
		crest2.setTextureOffset(63, 245).addBox(8.1429F, -19.5F, 0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(54, 112).addBox(-5.8571F, -19.5F, 0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(198, 49).addBox(-1.8571F, -9.5F, 0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(127, 151).addBox(-2.8571F, -10.5F, 0.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(143, 0).addBox(-2.8571F, -22.5F, 0.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(122, 218).addBox(7.1429F, -20.5F, 0.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(153, 8).addBox(-4.8571F, -20.5F, 0.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(262, 279).addBox(-3.8571F, -21.5F, -0.5F, 11.0F, 11.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(172, 197).addBox(-1.8571F, -23.5F, 0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		crest3 = new AnimatedModelRenderer(this);
		crest3.setRotationPoint(-0.6429F, -35.5F, 2.5F);
		upperBody.addChild(crest3);
		crest3.setTextureOffset(52, 245).addBox(8.1429F, -19.5F, 0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(48, 241).addBox(-5.8571F, -19.5F, 0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(82, 197).addBox(-1.8571F, -9.5F, 0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(134, 132).addBox(-2.8571F, -10.5F, 0.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(80, 101).addBox(-2.8571F, -22.5F, 0.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(8, 52).addBox(7.1429F, -20.5F, 0.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(23, 150).addBox(-4.8571F, -20.5F, 0.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(238, 279).addBox(-3.8571F, -21.5F, -0.5F, 11.0F, 11.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(82, 195).addBox(-1.8571F, -23.5F, 0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		crest4 = new AnimatedModelRenderer(this);
		crest4.setRotationPoint(21.3571F, -27.5F, 7.5F);
		upperBody.addChild(crest4);
		crest4.setTextureOffset(183, 232).addBox(18.1429F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(62, 195).addBox(4.1429F, 0.5F, -0.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(34, 185).addBox(8.1429F, 10.5F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(134, 130).addBox(7.1429F, 9.5F, -0.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(125, 56).addBox(7.1429F, -2.5F, -0.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(20, 141).addBox(17.1429F, -0.5F, -0.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(125, 28).addBox(5.1429F, -0.5F, -0.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(198, 37).addBox(6.1429F, -1.5F, -1.5F, 11.0F, 11.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(163, 0).addBox(8.1429F, -3.5F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		crest5 = new AnimatedModelRenderer(this);
		crest5.setRotationPoint(-21.6429F, -7.5F, 6.5F);
		upperBody.addChild(crest5);
		crest5.setTextureOffset(124, 189).addBox(-1.8571F, -19.5F, 1.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(79, 151).addBox(-15.8571F, -19.5F, 1.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(182, 17).addBox(-11.8571F, -9.5F, 1.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(125, 54).addBox(-12.8571F, -10.5F, 1.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(0, 125).addBox(-12.8571F, -22.5F, 1.5F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(23, 52).addBox(-2.8571F, -20.5F, 1.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(98, 28).addBox(-14.8571F, -20.5F, 1.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(214, 279).addBox(-13.8571F, -21.5F, 0.5F, 11.0F, 11.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(182, 15).addBox(-11.8571F, -23.5F, 1.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		lowerBody = new AnimatedModelRenderer(this);
		lowerBody.setRotationPoint(0.0F, -11.0F, 2.2F);
		lowerBody.setTextureOffset(64, 0).addBox(-9.0F, 10.0F, -13.0F, 20.0F, 1.0F, 27.0F, 0.0F, false);
		lowerBody.setTextureOffset(0, 52).addBox(-10.0F, -9.0F, -15.0F, 22.0F, 19.0F, 30.0F, 0.0F, false);
		lowerBody.setTextureOffset(226, 28).addBox(-8.0F, -9.0F, -17.0F, 18.0F, 20.0F, 2.0F, 0.0F, false);
		lowerBody.setTextureOffset(64, 0).addBox(-5.0F, -9.0F, -20.0F, 12.0F, 20.0F, 1.0F, 0.0F, false);
		lowerBody.setTextureOffset(189, 225).addBox(-7.0F, -3.0F, -28.0F, 16.0F, 10.0F, 7.0F, 0.0F, false);
		lowerBody.setTextureOffset(56, 151).addBox(12.0F, -8.0F, -13.0F, 1.0F, 17.0F, 27.0F, 0.0F, false);
		lowerBody.setTextureOffset(0, 141).addBox(-11.0F, -8.0F, -13.0F, 1.0F, 17.0F, 27.0F, 0.0F, false);

		jaw = new AnimatedModelRenderer(this);
		jaw.setRotationPoint(1.0F, -27.0F, -43.0F);
		lowerBody.addChild(jaw);

		jaw2 = new AnimatedModelRenderer(this);
		jaw2.setRotationPoint(1.0F, -19.0F, -43.0F);
		lowerBody.addChild(jaw2);
		jaw2.setTextureOffset(95, 113).addBox(6.0F, 20.0F, 13.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		jaw2.setTextureOffset(24, 78).addBox(-7.0F, 20.0F, 13.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		topJaw = new AnimatedModelRenderer(this);
		topJaw.setRotationPoint(-0.25F, 19.0F, 15.7F);
		jaw2.addChild(topJaw);
		topJaw.setTextureOffset(0, 78).addBox(-4.75F, -2.0F, -2.7F, 10.0F, 2.0F, 2.0F, 0.0F, false);
		topJaw.setTextureOffset(63, 141).addBox(5.25F, 0.0F, -2.7F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		topJaw.setTextureOffset(29, 141).addBox(-5.75F, 0.0F, -2.7F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		bone3 = new AnimatedModelRenderer(this);
		bone3.setRotationPoint(0.25F, 1.0F, -3.2F);
		topJaw.addChild(bone3);
		setRotateAngle(bone3, -0.6109F, 0.0F, 0.0F);
		bone3.setTextureOffset(43, 141).addBox(-1.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(8, 62).addBox(0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(125, 38).addBox(-5.0F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(30, 29).addBox(-4.5F, 1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(30, 30).addBox(-2.25F, 1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(101, 55).addBox(-3.0F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(100, 101).addBox(2.0F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(21, 101).addBox(4.0F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(8, 28).addBox(4.25F, 1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(0, 34).addBox(-1.0F, 1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(0, 27).addBox(1.0F, 1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(0, 28).addBox(2.25F, 1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		bottomJaw = new AnimatedModelRenderer(this);
		bottomJaw.setRotationPoint(-0.25F, 24.5F, 15.7F);
		jaw2.addChild(bottomJaw);
		bottomJaw.setTextureOffset(152, 2).addBox(5.25F, -3.5F, -2.7F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bottomJaw.setTextureOffset(152, 18).addBox(-5.75F, -3.5F, -2.7F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bottomJaw.setTextureOffset(64, 21).addBox(-4.75F, -1.5F, -2.7F, 10.0F, 2.0F, 2.0F, 0.0F, false);

		bone2 = new AnimatedModelRenderer(this);
		bone2.setRotationPoint(0.25F, -1.5F, -3.2F);
		bottomJaw.addChild(bone2);
		setRotateAngle(bone2, 0.6109F, 0.0F, 0.0F);
		bone2.setTextureOffset(177, 37).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(8, 27).addBox(0.0F, -2.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(190, 64).addBox(-4.75F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(30, 36).addBox(-4.25F, -2.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(8, 35).addBox(-2.5F, -2.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(178, 54).addBox(-2.75F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 161).addBox(1.75F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(11, 161).addBox(3.75F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 35).addBox(4.5F, -2.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(8, 34).addBox(2.5F, -2.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		fRArm = new AnimatedModelRenderer(this);
		fRArm.setRotationPoint(-7.75F, 1.25F, -24.1F);
		lowerBody.addChild(fRArm);

		fRShoulder = new AnimatedModelRenderer(this);
		fRShoulder.setRotationPoint(-1.6059F, 0.1815F, -0.225F);
		fRArm.addChild(fRShoulder);
		setRotateAngle(fRShoulder, 0.0F, -0.2182F, 0.0F);
		fRShoulder.setTextureOffset(138, 269).addBox(-4.1296F, -3.3185F, -2.8914F, 7.0F, 6.0F, 6.0F, 0.0F, false);
		fRShoulder.setTextureOffset(131, 0).addBox(0.3322F, -5.4315F, -3.8914F, 1.0F, 10.0F, 10.0F, 0.0F, false);
		fRShoulder.setTextureOffset(85, 164).addBox(-20.1296F, -2.8185F, 3.0086F, 3.0F, 4.0F, 2.0F, 0.0F, false);

		fRBicep = new AnimatedModelRenderer(this);
		fRBicep.setRotationPoint(-2.7823F, -1.4656F, 1.8897F);
		fRShoulder.addChild(fRBicep);
		fRBicep.setTextureOffset(214, 106).addBox(-15.3472F, -3.8529F, -3.7811F, 17.0F, 7.0F, 7.0F, 0.0F, false);
		fRBicep.setTextureOffset(236, 16).addBox(-15.3472F, 5.1471F, -3.7811F, 17.0F, 2.0F, 7.0F, 0.0F, false);
		fRBicep.setTextureOffset(72, 221).addBox(-3.3472F, 4.1471F, -3.7811F, 5.0F, 1.0F, 7.0F, 0.0F, false);

		fRFore = new AnimatedModelRenderer(this);
		fRFore.setRotationPoint(-18.1364F, 0.4142F, -0.5847F);
		fRBicep.addChild(fRFore);
		setRotateAngle(fRFore, 0.6109F, -1.2217F, 0.0F);
		fRFore.setTextureOffset(262, 113).addBox(-12.3143F, -2.1723F, 2.1305F, 14.0F, 4.0F, 2.0F, 0.0F, false);
		fRFore.setTextureOffset(82, 207).addBox(-10.3143F, -2.1723F, -7.8695F, 6.0F, 4.0F, 2.0F, 0.0F, false);
		fRFore.setTextureOffset(147, 237).addBox(-12.3143F, -3.1723F, -5.8695F, 14.0F, 7.0F, 8.0F, 0.0F, false);
		fRFore.setTextureOffset(260, 0).addBox(-11.9143F, -2.8723F, -6.4695F, 14.0F, 7.0F, 1.0F, 0.0F, false);
		fRFore.setTextureOffset(105, 251).addBox(-12.3143F, -4.1723F, -4.8695F, 14.0F, 1.0F, 6.0F, 0.0F, false);

		fRFist = new AnimatedModelRenderer(this);
		fRFist.setRotationPoint(-12.3199F, 0.3964F, -0.2657F);
		fRFore.addChild(fRFist);
		fRFist.setTextureOffset(63, 141).addBox(-1.8695F, -5.5687F, -4.8121F, 1.0F, 10.0F, 7.0F, 0.0F, false);
		fRFist.setTextureOffset(182, 0).addBox(-2.8695F, -4.5687F, -4.8121F, 1.0F, 8.0F, 7.0F, 0.0F, false);
		fRFist.setTextureOffset(177, 167).addBox(-0.8695F, -4.5687F, -4.8121F, 1.0F, 8.0F, 7.0F, 0.0F, false);
		fRFist.setTextureOffset(104, 218).addBox(-0.8695F, -3.5687F, -3.8121F, 4.0F, 6.0F, 5.0F, 0.0F, false);

		rFingers = new AnimatedModelRenderer(this);
		rFingers.setRotationPoint(-1.4F, 0.4F, 3.0F);
		fRFist.addChild(rFingers);

		rFinger1 = new AnimatedModelRenderer(this);
		rFinger1.setRotationPoint(-1.5527F, -4.4882F, 1.0429F);
		rFingers.addChild(rFinger1);
		rFinger1.setTextureOffset(219, 53).addBox(-1.9167F, -1.4804F, -1.855F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rFinger12 = new AnimatedModelRenderer(this);
		rFinger12.setRotationPoint(-4.0158F, 0.0794F, -0.0976F);
		rFinger1.addChild(rFinger12);
		rFinger12.setTextureOffset(134, 211).addBox(-1.901F, -1.5598F, -1.7574F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		rFinger12.setTextureOffset(58, 229).addBox(-1.901F, -1.0598F, -0.7574F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		rFinger13 = new AnimatedModelRenderer(this);
		rFinger13.setRotationPoint(-2.0486F, 0.1586F, 0.2686F);
		rFinger12.addChild(rFinger13);
		rFinger13.setTextureOffset(104, 213).addBox(-2.8524F, -1.7184F, -2.026F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		rFinger13.setTextureOffset(79, 176).addBox(-3.8524F, -1.2184F, -1.526F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rFinger2 = new AnimatedModelRenderer(this);
		rFinger2.setRotationPoint(-1.5527F, -1.4882F, 1.0429F);
		rFingers.addChild(rFinger2);
		rFinger2.setTextureOffset(58, 221).addBox(-1.9167F, -1.4804F, -1.855F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rFinger22 = new AnimatedModelRenderer(this);
		rFinger22.setRotationPoint(-4.0158F, 0.0794F, -0.0976F);
		rFinger2.addChild(rFinger22);
		rFinger22.setTextureOffset(219, 57).addBox(-1.901F, -1.5598F, -1.7574F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		rFinger22.setTextureOffset(229, 16).addBox(-1.901F, -1.0598F, -0.7574F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		rFinger23 = new AnimatedModelRenderer(this);
		rFinger23.setRotationPoint(-2.0486F, 0.1586F, 0.2686F);
		rFinger22.addChild(rFinger23);
		rFinger23.setTextureOffset(235, 266).addBox(-2.8524F, -1.7184F, -2.026F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		rFinger23.setTextureOffset(179, 69).addBox(-3.8524F, -1.2184F, -1.526F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rFinger3 = new AnimatedModelRenderer(this);
		rFinger3.setRotationPoint(-1.5527F, 1.5118F, 1.0429F);
		rFingers.addChild(rFinger3);
		rFinger3.setTextureOffset(211, 258).addBox(-1.9167F, -1.4804F, -1.855F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rFinger32 = new AnimatedModelRenderer(this);
		rFinger32.setRotationPoint(-4.0158F, 0.0794F, -0.0976F);
		rFinger3.addChild(rFinger32);
		rFinger32.setTextureOffset(58, 225).addBox(-1.901F, -1.5598F, -1.7574F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		rFinger32.setTextureOffset(236, 25).addBox(-1.901F, -1.0598F, -0.7574F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		rFinger33 = new AnimatedModelRenderer(this);
		rFinger33.setRotationPoint(-2.0486F, 0.1586F, 0.2686F);
		rFinger32.addChild(rFinger33);
		rFinger33.setTextureOffset(261, 266).addBox(-2.8524F, -1.7184F, -2.026F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		rFinger33.setTextureOffset(179, 108).addBox(-3.8524F, -1.2184F, -1.526F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rFinger4 = new AnimatedModelRenderer(this);
		rFinger4.setRotationPoint(-1.5527F, 4.5118F, 1.0429F);
		rFingers.addChild(rFinger4);
		rFinger4.setTextureOffset(264, 25).addBox(-1.9167F, -1.4804F, -1.855F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rFinger42 = new AnimatedModelRenderer(this);
		rFinger42.setRotationPoint(-4.0158F, 0.0794F, -0.0976F);
		rFinger4.addChild(rFinger42);
		rFinger42.setTextureOffset(258, 155).addBox(-1.901F, -1.5598F, -1.7574F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		rFinger42.setTextureOffset(248, 25).addBox(-1.901F, -1.0598F, -0.7574F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		rFinger43 = new AnimatedModelRenderer(this);
		rFinger43.setRotationPoint(-2.0486F, 0.1586F, 0.2686F);
		rFinger42.addChild(rFinger43);
		rFinger43.setTextureOffset(0, 272).addBox(-2.8524F, -1.7184F, -2.026F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		rFinger43.setTextureOffset(180, 172).addBox(-3.8524F, -1.2184F, -1.526F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rThumb = new AnimatedModelRenderer(this);
		rThumb.setRotationPoint(-0.9685F, -4.2255F, -4.9714F);
		fRFist.addChild(rThumb);
		rThumb.setTextureOffset(132, 270).addBox(-3.901F, -1.3432F, -1.8407F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		rThumb.setTextureOffset(48, 210).addBox(-3.901F, -0.7432F, -2.8407F, 5.0F, 1.0F, 2.0F, 0.0F, false);

		rThumb2 = new AnimatedModelRenderer(this);
		rThumb2.setRotationPoint(-4.2315F, 0.2755F, -0.0286F);
		rThumb.addChild(rThumb2);
		rThumb2.setTextureOffset(15, 270).addBox(-3.6695F, -1.6187F, -1.8121F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		rThumb2.setTextureOffset(190, 79).addBox(-4.6695F, -1.1187F, -1.3121F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		fLArm = new AnimatedModelRenderer(this);
		fLArm.setRotationPoint(7.75F, 1.25F, -24.1F);
		lowerBody.addChild(fLArm);

		fLShoulder = new AnimatedModelRenderer(this);
		fLShoulder.setRotationPoint(1.6059F, 0.1815F, -0.225F);
		fLArm.addChild(fLShoulder);
		setRotateAngle(fLShoulder, 0.0F, 0.2182F, 0.0F);
		fLShoulder.setTextureOffset(266, 92).addBox(-0.9178F, -3.3185F, -2.4586F, 7.0F, 6.0F, 6.0F, 0.0F, false);
		fLShoulder.setTextureOffset(124, 66).addBox(0.6204F, -5.4315F, -3.4586F, 1.0F, 10.0F, 10.0F, 0.0F, false);
		fLShoulder.setTextureOffset(100, 151).addBox(19.0822F, -2.8185F, 3.4414F, 3.0F, 4.0F, 2.0F, 0.0F, false);

		fLBicep = new AnimatedModelRenderer(this);
		fLBicep.setRotationPoint(2.7823F, -1.4656F, 1.8897F);
		fLShoulder.addChild(fLBicep);
		fLBicep.setTextureOffset(54, 113).addBox(0.2998F, -3.8529F, -3.3483F, 17.0F, 7.0F, 7.0F, 0.0F, false);
		fLBicep.setTextureOffset(124, 190).addBox(0.2998F, 5.1471F, -3.3483F, 17.0F, 2.0F, 7.0F, 0.0F, false);
		fLBicep.setTextureOffset(156, 54).addBox(0.2998F, 4.1471F, -3.3483F, 5.0F, 1.0F, 7.0F, 0.0F, false);

		fLFore = new AnimatedModelRenderer(this);
		fLFore.setRotationPoint(18.1364F, 0.4142F, -0.5847F);
		fLBicep.addChild(fLFore);
		setRotateAngle(fLFore, 0.6109F, 1.2217F, 0.0F);
		fLFore.setTextureOffset(223, 249).addBox(-1.4246F, -1.0349F, 3.7548F, 14.0F, 4.0F, 2.0F, 0.0F, false);
		fLFore.setTextureOffset(186, 167).addBox(4.5754F, -1.0349F, -6.2452F, 6.0F, 4.0F, 2.0F, 0.0F, false);
		fLFore.setTextureOffset(236, 136).addBox(-1.4246F, -2.0349F, -4.2452F, 14.0F, 7.0F, 8.0F, 0.0F, false);
		fLFore.setTextureOffset(74, 74).addBox(-1.8246F, -1.7349F, -4.8452F, 14.0F, 7.0F, 1.0F, 0.0F, false);
		fLFore.setTextureOffset(247, 59).addBox(-1.4246F, -3.0349F, -3.2452F, 14.0F, 1.0F, 6.0F, 0.0F, false);

		fLFist = new AnimatedModelRenderer(this);
		fLFist.setRotationPoint(12.3199F, 0.3964F, -0.2657F);
		fLFore.addChild(fLFist);
		fLFist.setTextureOffset(29, 141).addBox(1.1305F, -4.4313F, -3.1879F, 1.0F, 10.0F, 7.0F, 0.0F, false);
		fLFist.setTextureOffset(176, 103).addBox(2.1305F, -3.4313F, -3.1879F, 1.0F, 8.0F, 7.0F, 0.0F, false);
		fLFist.setTextureOffset(176, 64).addBox(0.1305F, -3.4313F, -3.1879F, 1.0F, 8.0F, 7.0F, 0.0F, false);
		fLFist.setTextureOffset(48, 199).addBox(-2.8695F, -2.4313F, -2.1879F, 4.0F, 6.0F, 5.0F, 0.0F, false);

		lFingers = new AnimatedModelRenderer(this);
		lFingers.setRotationPoint(1.4F, 0.4F, 3.0F);
		fLFist.addChild(lFingers);

		lFinger1 = new AnimatedModelRenderer(this);
		lFinger1.setRotationPoint(1.5527F, -4.4882F, 1.0429F);
		lFingers.addChild(lFinger1);
		lFinger1.setTextureOffset(210, 94).addBox(-1.8222F, -0.3431F, -0.2307F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		lFinger12 = new AnimatedModelRenderer(this);
		lFinger12.setRotationPoint(4.0158F, 0.0794F, -0.0976F);
		lFinger1.addChild(lFinger12);
		lFinger12.setTextureOffset(210, 90).addBox(-1.838F, -0.4225F, -0.1331F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		lFinger12.setTextureOffset(218, 79).addBox(-1.838F, 0.0775F, 0.8669F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		lFinger13 = new AnimatedModelRenderer(this);
		lFinger13.setRotationPoint(2.0486F, 0.1586F, 0.2686F);
		lFinger12.addChild(lFinger13);
		lFinger13.setTextureOffset(100, 170).addBox(0.1134F, -0.5811F, -0.4017F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		lFinger13.setTextureOffset(0, 164).addBox(3.1134F, -0.0811F, 0.0983F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		lFinger2 = new AnimatedModelRenderer(this);
		lFinger2.setRotationPoint(1.5527F, -1.4882F, 1.0429F);
		lFingers.addChild(lFinger2);
		lFinger2.setTextureOffset(134, 207).addBox(-1.8222F, -0.3431F, -0.2307F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		rFinger5 = new AnimatedModelRenderer(this);
		rFinger5.setRotationPoint(4.0158F, 0.0794F, -0.0976F);
		lFinger2.addChild(rFinger5);
		rFinger5.setTextureOffset(187, 182).addBox(-1.838F, -0.4225F, -0.1331F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		rFinger5.setTextureOffset(217, 16).addBox(-1.838F, 0.0775F, 0.8669F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		lFinger23 = new AnimatedModelRenderer(this);
		lFinger23.setRotationPoint(2.0486F, 0.1586F, 0.2686F);
		rFinger5.addChild(lFinger23);
		lFinger23.setTextureOffset(85, 170).addBox(0.1134F, -0.5811F, -0.4017F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		lFinger23.setTextureOffset(144, 86).addBox(3.1134F, -0.0811F, 0.0983F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		lFinger3 = new AnimatedModelRenderer(this);
		lFinger3.setRotationPoint(1.5527F, 1.5118F, 1.0429F);
		lFingers.addChild(lFinger3);
		lFinger3.setTextureOffset(180, 138).addBox(-1.8222F, -0.3431F, -0.2307F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		lFinger32 = new AnimatedModelRenderer(this);
		lFinger32.setRotationPoint(4.0158F, 0.0794F, -0.0976F);
		lFinger3.addChild(lFinger32);
		lFinger32.setTextureOffset(180, 134).addBox(-1.838F, -0.4225F, -0.1331F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		lFinger32.setTextureOffset(136, 73).addBox(-1.838F, 0.0775F, 0.8669F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		lFinger33 = new AnimatedModelRenderer(this);
		lFinger33.setRotationPoint(2.0486F, 0.1586F, 0.2686F);
		lFinger32.addChild(lFinger33);
		lFinger33.setTextureOffset(85, 158).addBox(0.1134F, -0.5811F, -0.4017F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		lFinger33.setTextureOffset(144, 66).addBox(3.1134F, -0.0811F, 0.0983F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		lFinger4 = new AnimatedModelRenderer(this);
		lFinger4.setRotationPoint(1.5527F, 4.5118F, 1.0429F);
		lFingers.addChild(lFinger4);
		lFinger4.setTextureOffset(180, 130).addBox(-1.8222F, -0.3431F, -0.2307F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		lFinger5 = new AnimatedModelRenderer(this);
		lFinger5.setRotationPoint(4.0158F, 0.0794F, -0.0976F);
		lFinger4.addChild(lFinger5);
		lFinger5.setTextureOffset(71, 171).addBox(-1.838F, -0.4225F, -0.1331F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		lFinger5.setTextureOffset(93, 52).addBox(-1.838F, 0.0775F, 0.8669F, 4.0F, 1.0F, 2.0F, 0.0F, false);

		lFinger43 = new AnimatedModelRenderer(this);
		lFinger43.setRotationPoint(2.0486F, 0.1586F, 0.2686F);
		lFinger5.addChild(lFinger43);
		lFinger43.setTextureOffset(100, 157).addBox(0.1134F, -0.5811F, -0.4017F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		lFinger43.setTextureOffset(86, 21).addBox(3.1134F, -0.0811F, 0.0983F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		lThumb = new AnimatedModelRenderer(this);
		lThumb.setRotationPoint(0.9685F, -4.2255F, -4.9714F);
		fLFist.addChild(lThumb);
		lThumb.setTextureOffset(71, 167).addBox(0.162F, -0.2058F, -0.2164F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		lThumb.setTextureOffset(208, 34).addBox(-0.838F, 0.3942F, -1.2164F, 5.0F, 1.0F, 2.0F, 0.0F, false);

		lThumb2 = new AnimatedModelRenderer(this);
		lThumb2.setRotationPoint(4.2315F, 0.2755F, -0.0286F);
		lThumb.addChild(lThumb2);
		lThumb2.setTextureOffset(92, 70).addBox(-0.0695F, -0.4813F, -0.1879F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		lThumb2.setTextureOffset(22, 78).addBox(3.9305F, 0.0187F, 0.3121F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		fLLeg = new AnimatedModelRenderer(this);
		fLLeg.setRotationPoint(11.25F, 0.75F, -5.35F);
		lowerBody.addChild(fLLeg);
		fLLeg.setTextureOffset(77, 232).addBox(1.75F, -6.75F, -7.65F, 1.0F, 13.0F, 13.0F, 0.0F, false);

		fLHip = new AnimatedModelRenderer(this);
		fLHip.setRotationPoint(1.0833F, 0.0833F, 0.45F);
		fLLeg.addChild(fLHip);
		setRotateAngle(fLHip, 0.0F, 0.0F, 0.48F);
		fLHip.setTextureOffset(158, 276).addBox(-0.9081F, -3.1821F, -4.1F, 7.0F, 6.0F, 6.0F, 0.0F, false);

		fLFemur = new AnimatedModelRenderer(this);
		fLFemur.setRotationPoint(2.5284F, -0.8674F, -1.5353F);
		fLHip.addChild(fLFemur);
		setRotateAngle(fLFemur, 0.0F, 0.0F, 0.3054F);
		fLFemur.setTextureOffset(0, 225).addBox(0.3836F, -4.56F, -4.5647F, 17.0F, 7.0F, 9.0F, 0.0F, false);
		fLFemur.setTextureOffset(244, 202).addBox(0.3836F, -4.56F, -5.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		fLFemur.setTextureOffset(191, 242).addBox(4.3836F, -4.56F, -5.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		fLFemur.setTextureOffset(36, 241).addBox(9.3836F, -4.56F, -5.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		fLFemur.setTextureOffset(0, 241).addBox(13.3836F, -4.56F, -5.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		fLFemur.setTextureOffset(85, 151).addBox(16.3836F, -2.56F, -6.5647F, 3.0F, 5.0F, 2.0F, 0.0F, false);
		fLFemur.setTextureOffset(260, 70).addBox(19.3836F, -1.56F, -5.5647F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		fLFemur.setTextureOffset(158, 190).addBox(0.3836F, 1.94F, -2.5647F, 17.0F, 0.0F, 7.0F, 0.0F, false);
		fLFemur.setTextureOffset(257, 41).addBox(0.3836F, -5.56F, -3.5647F, 9.0F, 1.0F, 9.0F, 0.0F, false);
		fLFemur.setTextureOffset(56, 265).addBox(0.3836F, -6.56F, -3.5647F, 6.0F, 1.0F, 9.0F, 0.0F, false);
		fLFemur.setTextureOffset(141, 281).addBox(9.3836F, -5.56F, -3.5647F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		fLFemur.setTextureOffset(247, 53).addBox(-1.6164F, -2.06F, 5.3353F, 19.0F, 4.0F, 2.0F, 0.0F, false);
		fLFemur.setTextureOffset(0, 123).addBox(2.3836F, -5.56F, -4.5647F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		fLFemur.setTextureOffset(284, 44).addBox(3.3836F, -2.06F, 3.3353F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		fLFemur.setTextureOffset(208, 270).addBox(9.3836F, -2.06F, 3.3353F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		fLFemur.setTextureOffset(266, 29).addBox(-1.6164F, -2.06F, 3.3353F, 3.0F, 4.0F, 2.0F, 0.0F, false);

		fLTibia = new AnimatedModelRenderer(this);
		fLTibia.setRotationPoint(16.8636F, 0.4142F, 1.4153F);
		fLFemur.addChild(fLTibia);
		setRotateAngle(fLTibia, 0.0F, -0.3491F, 0.7418F);
		fLTibia.setTextureOffset(277, 256).addBox(-1.4039F, -2.6027F, 2.9277F, 14.0F, 4.0F, 2.0F, 0.0F, false);
		fLTibia.setTextureOffset(284, 38).addBox(10.5961F, -2.6027F, 4.9277F, 6.0F, 4.0F, 2.0F, 0.0F, false);
		fLTibia.setTextureOffset(244, 202).addBox(-1.4039F, -3.6027F, -5.0723F, 14.0F, 7.0F, 8.0F, 0.0F, false);
		fLTibia.setTextureOffset(277, 14).addBox(-2.0039F, -3.3027F, -5.6723F, 14.0F, 7.0F, 1.0F, 0.0F, false);
		fLTibia.setTextureOffset(255, 106).addBox(-1.4039F, -4.6027F, -4.0723F, 14.0F, 1.0F, 6.0F, 0.0F, false);

		fLFoot = new AnimatedModelRenderer(this);
		fLFoot.setRotationPoint(12.6801F, 0.3964F, 1.7343F);
		fLTibia.addChild(fLFoot);
		setRotateAngle(fLFoot, -0.3054F, 0.3491F, 0.0F);
		fLFoot.setTextureOffset(280, 195).addBox(5.9186F, -2.9528F, -22.0921F, 3.0F, 1.0F, 9.0F, 0.0F, false);
		fLFoot.setTextureOffset(280, 57).addBox(5.9186F, 0.0472F, -22.0921F, 3.0F, 1.0F, 9.0F, 0.0F, false);
		fLFoot.setTextureOffset(177, 281).addBox(6.9186F, -1.9528F, -20.0921F, 2.0F, 2.0F, 7.0F, 0.0F, false);
		fLFoot.setTextureOffset(260, 266).addBox(6.9186F, 1.0472F, -16.0921F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		fLFoot.setTextureOffset(28, 263).addBox(2.9186F, -2.9528F, -13.0921F, 6.0F, 4.0F, 8.0F, 0.0F, false);
		fLFoot.setTextureOffset(266, 25).addBox(6.9186F, -4.9528F, -16.0921F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		fLFoot.setTextureOffset(102, 271).addBox(4.9186F, 1.0472F, -3.0921F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		fLFoot.setTextureOffset(275, 272).addBox(4.9186F, 1.0472F, 2.9079F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		fLFoot.setTextureOffset(281, 31).addBox(4.9186F, -1.9528F, 2.9079F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		fLFoot.setTextureOffset(280, 205).addBox(4.9186F, -4.9528F, 2.9079F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		fLFoot.setTextureOffset(166, 264).addBox(-0.0814F, -2.9528F, -5.0921F, 6.0F, 4.0F, 8.0F, 0.0F, false);
		fLFoot.setTextureOffset(15, 266).addBox(4.9186F, -4.9528F, -3.0921F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		bLLeg = new AnimatedModelRenderer(this);
		bLLeg.setRotationPoint(6.45F, 0.75F, 20.65F);
		lowerBody.addChild(bLLeg);
		bLLeg.setTextureOffset(113, 219).addBox(-0.45F, -6.75F, -7.65F, 8.0F, 13.0F, 13.0F, 0.0F, false);

		bLHip = new AnimatedModelRenderer(this);
		bLHip.setRotationPoint(5.8833F, 2.0833F, -0.55F);
		bLLeg.addChild(bLHip);
		setRotateAngle(bLHip, 0.0F, 0.0F, 0.48F);
		bLHip.setTextureOffset(188, 273).addBox(-1.8316F, -4.9561F, -3.1F, 7.0F, 6.0F, 6.0F, 0.0F, false);

		bLFemur = new AnimatedModelRenderer(this);
		bLFemur.setRotationPoint(1.6414F, -0.4057F, 0.4647F);
		bLHip.addChild(bLFemur);
		setRotateAngle(bLFemur, 0.0F, 0.0F, 0.3054F);
		bLFemur.setTextureOffset(217, 0).addBox(-0.3235F, -6.6814F, -5.5647F, 17.0F, 7.0F, 9.0F, 0.0F, false);
		bLFemur.setTextureOffset(217, 0).addBox(-0.3235F, -6.6814F, -6.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		bLFemur.setTextureOffset(200, 90).addBox(3.6765F, -6.6814F, -6.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		bLFemur.setTextureOffset(82, 199).addBox(8.6765F, -6.6814F, -6.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		bLFemur.setTextureOffset(198, 53).addBox(12.6765F, -6.6814F, -6.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		bLFemur.setTextureOffset(124, 68).addBox(15.6765F, -4.6814F, -7.5647F, 3.0F, 5.0F, 2.0F, 0.0F, false);
		bLFemur.setTextureOffset(259, 242).addBox(18.6765F, -3.6814F, -6.5647F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		bLFemur.setTextureOffset(57, 28).addBox(-0.3235F, -0.1814F, -3.5647F, 17.0F, 0.0F, 7.0F, 0.0F, false);
		bLFemur.setTextureOffset(214, 256).addBox(-0.3235F, -7.6814F, -4.5647F, 9.0F, 1.0F, 9.0F, 0.0F, false);
		bLFemur.setTextureOffset(144, 259).addBox(-0.3235F, -8.6814F, -4.5647F, 6.0F, 1.0F, 9.0F, 0.0F, false);
		bLFemur.setTextureOffset(223, 136).addBox(8.6765F, -7.6814F, -4.5647F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		bLFemur.setTextureOffset(237, 232).addBox(-2.3235F, -4.1814F, 4.3353F, 19.0F, 4.0F, 2.0F, 0.0F, false);
		bLFemur.setTextureOffset(54, 101).addBox(1.6765F, -7.6814F, -5.5647F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		bLFemur.setTextureOffset(43, 225).addBox(2.6765F, -4.1814F, 2.3353F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		bLFemur.setTextureOffset(89, 221).addBox(8.6765F, -4.1814F, 2.3353F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		bLFemur.setTextureOffset(104, 207).addBox(-2.3235F, -4.1814F, 2.3353F, 3.0F, 4.0F, 2.0F, 0.0F, false);

		bLTibia = new AnimatedModelRenderer(this);
		bLTibia.setRotationPoint(22.5204F, 4.6568F, -2.5847F);
		bLFemur.addChild(bLTibia);
		setRotateAngle(bLTibia, 0.0F, -0.3491F, 0.7418F);
		bLTibia.setTextureOffset(274, 250).addBox(-8.827F, -2.9952F, 8.822F, 14.0F, 4.0F, 2.0F, 0.0F, false);
		bLTibia.setTextureOffset(36, 283).addBox(3.173F, -2.9952F, 10.822F, 6.0F, 4.0F, 2.0F, 0.0F, false);
		bLTibia.setTextureOffset(0, 241).addBox(-8.827F, -3.9952F, 0.822F, 14.0F, 7.0F, 8.0F, 0.0F, false);
		bLTibia.setTextureOffset(273, 217).addBox(-9.427F, -3.6952F, 0.222F, 14.0F, 7.0F, 1.0F, 0.0F, false);
		bLTibia.setTextureOffset(251, 176).addBox(-8.827F, -4.9952F, 1.822F, 14.0F, 1.0F, 6.0F, 0.0F, false);

		bLFoot = new AnimatedModelRenderer(this);
		bLFoot.setRotationPoint(5.257F, 0.0038F, 7.6286F);
		bLTibia.addChild(bLFoot);
		setRotateAngle(bLFoot, -0.6109F, 0.3491F, 0.0F);
		bLFoot.setTextureOffset(279, 69).addBox(5.9186F, -2.8973F, -22.1145F, 3.0F, 1.0F, 9.0F, 0.0F, false);
		bLFoot.setTextureOffset(48, 245).addBox(5.9186F, 0.1027F, -22.1145F, 3.0F, 1.0F, 9.0F, 0.0F, false);
		bLFoot.setTextureOffset(98, 281).addBox(6.9186F, -1.8973F, -20.1145F, 2.0F, 2.0F, 7.0F, 0.0F, false);
		bLFoot.setTextureOffset(0, 266).addBox(6.9186F, 1.1027F, -16.1145F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		bLFoot.setTextureOffset(191, 258).addBox(2.9186F, -2.8973F, -13.1145F, 6.0F, 4.0F, 8.0F, 0.0F, false);
		bLFoot.setTextureOffset(43, 221).addBox(6.9186F, -4.8973F, -16.1145F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		bLFoot.setTextureOffset(250, 151).addBox(4.9186F, 1.1027F, -3.1145F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bLFoot.setTextureOffset(237, 238).addBox(4.9186F, 1.1027F, 2.8855F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bLFoot.setTextureOffset(236, 151).addBox(4.9186F, -1.8973F, 2.8855F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bLFoot.setTextureOffset(236, 85).addBox(4.9186F, -4.8973F, 2.8855F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bLFoot.setTextureOffset(116, 258).addBox(-0.0814F, -2.8973F, -5.1145F, 6.0F, 4.0F, 8.0F, 0.0F, false);
		bLFoot.setTextureOffset(52, 234).addBox(4.9186F, -4.8973F, -3.1145F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		fRLeg = new AnimatedModelRenderer(this);
		fRLeg.setRotationPoint(-11.75F, 1.75F, -7.35F);
		lowerBody.addChild(fRLeg);
		fRLeg.setTextureOffset(0, 52).addBox(-0.25F, -7.75F, -5.65F, 1.0F, 13.0F, 13.0F, 0.0F, false);

		fRHip = new AnimatedModelRenderer(this);
		fRHip.setRotationPoint(0.0833F, 0.0833F, 2.45F);
		fRLeg.addChild(fRHip);
		setRotateAngle(fRHip, 0.0F, 0.0F, -0.48F);
		fRHip.setTextureOffset(56, 275).addBox(-4.4098F, -3.6074F, -4.1F, 7.0F, 6.0F, 6.0F, 0.0F, false);

		fRFemur = new AnimatedModelRenderer(this);
		fRFemur.setRotationPoint(-3.8968F, -0.4421F, -2.5353F);
		fRHip.addChild(fRFemur);
		setRotateAngle(fRFemur, 0.0F, 0.0F, -0.3054F);
		fRFemur.setTextureOffset(223, 120).addBox(-14.2022F, -4.56F, -3.5647F, 17.0F, 7.0F, 9.0F, 0.0F, false);
		fRFemur.setTextureOffset(136, 66).addBox(-16.2022F, -2.56F, -5.5647F, 3.0F, 5.0F, 2.0F, 0.0F, false);
		fRFemur.setTextureOffset(82, 230).addBox(-12.2022F, -4.56F, -4.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		fRFemur.setTextureOffset(72, 230).addBox(-7.2022F, -4.56F, -4.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		fRFemur.setTextureOffset(0, 225).addBox(-3.2022F, -4.56F, -4.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		fRFemur.setTextureOffset(260, 66).addBox(-18.2022F, -1.56F, -4.5647F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		fRFemur.setTextureOffset(250, 256).addBox(-6.2022F, -5.56F, -2.5647F, 9.0F, 1.0F, 9.0F, 0.0F, false);
		fRFemur.setTextureOffset(262, 151).addBox(-3.2022F, -6.56F, -2.5647F, 6.0F, 1.0F, 9.0F, 0.0F, false);
		fRFemur.setTextureOffset(136, 259).addBox(-8.2022F, -5.56F, -2.5647F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		fRFemur.setTextureOffset(105, 245).addBox(-14.2022F, -2.06F, 6.3353F, 19.0F, 4.0F, 2.0F, 0.0F, false);
		fRFemur.setTextureOffset(0, 121).addBox(-15.2022F, -5.56F, -3.5647F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		fRFemur.setTextureOffset(0, 266).addBox(-9.2022F, -2.06F, 4.3353F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		fRFemur.setTextureOffset(77, 265).addBox(-3.2022F, -2.06F, 4.3353F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		fRFemur.setTextureOffset(233, 136).addBox(1.7978F, -2.06F, 4.3353F, 3.0F, 4.0F, 2.0F, 0.0F, false);

		fRTibia = new AnimatedModelRenderer(this);
		fRTibia.setRotationPoint(-14.4293F, -1.7072F, 0.4153F);
		fRFemur.addChild(fRTibia);
		setRotateAngle(fRTibia, 0.0F, 0.3491F, -0.7418F);
		fRTibia.setTextureOffset(275, 266).addBox(-14.097F, -0.561F, 4.4952F, 14.0F, 4.0F, 2.0F, 0.0F, false);
		fRTibia.setTextureOffset(283, 151).addBox(-20.097F, -0.561F, 6.4952F, 6.0F, 4.0F, 2.0F, 0.0F, false);
		fRTibia.setTextureOffset(243, 187).addBox(-14.097F, -1.561F, -3.5048F, 14.0F, 7.0F, 8.0F, 0.0F, false);
		fRTibia.setTextureOffset(26, 275).addBox(-13.697F, -1.261F, -4.1048F, 14.0F, 7.0F, 1.0F, 0.0F, false);
		fRTibia.setTextureOffset(139, 252).addBox(-14.097F, -2.561F, -2.5048F, 14.0F, 1.0F, 6.0F, 0.0F, false);

		fRFoot = new AnimatedModelRenderer(this);
		fRFoot.setRotationPoint(-14.013F, 0.44F, 3.272F);
		fRTibia.addChild(fRFoot);
		setRotateAngle(fRFoot, -0.3054F, -0.3491F, 0.0F);
		fRFoot.setTextureOffset(279, 235).addBox(-9.0814F, -1.0472F, -21.4912F, 3.0F, 1.0F, 9.0F, 0.0F, false);
		fRFoot.setTextureOffset(279, 225).addBox(-9.0814F, 1.9528F, -21.4912F, 3.0F, 1.0F, 9.0F, 0.0F, false);
		fRFoot.setTextureOffset(130, 281).addBox(-9.0814F, -0.0472F, -19.4912F, 2.0F, 2.0F, 7.0F, 0.0F, false);
		fRFoot.setTextureOffset(234, 266).addBox(-9.0814F, 2.9528F, -15.4912F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		fRFoot.setTextureOffset(260, 66).addBox(-9.0814F, -1.0472F, -12.4912F, 6.0F, 4.0F, 8.0F, 0.0F, false);
		fRFoot.setTextureOffset(208, 266).addBox(-9.0814F, -3.0472F, -15.4912F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		fRFoot.setTextureOffset(265, 183).addBox(-10.0814F, 2.9528F, -2.4912F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		fRFoot.setTextureOffset(259, 250).addBox(-10.0814F, 2.9528F, 3.5088F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		fRFoot.setTextureOffset(110, 258).addBox(-10.0814F, -0.0472F, 3.5088F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		fRFoot.setTextureOffset(257, 92).addBox(-10.0814F, -3.0472F, 3.5088F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		fRFoot.setTextureOffset(259, 238).addBox(-6.0814F, -1.0472F, -4.4912F, 6.0F, 4.0F, 8.0F, 0.0F, false);
		fRFoot.setTextureOffset(251, 183).addBox(-10.0814F, -3.0472F, -2.4912F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		bRLeg = new AnimatedModelRenderer(this);
		bRLeg.setRotationPoint(-6.5F, 0.75F, 19.65F);
		lowerBody.addChild(bRLeg);
		bRLeg.setTextureOffset(218, 53).addBox(-5.5F, -6.75F, -6.65F, 8.0F, 13.0F, 13.0F, 0.0F, false);

		bRHip = new AnimatedModelRenderer(this);
		bRHip.setRotationPoint(-6.1667F, -0.9167F, 0.45F);
		bRLeg.addChild(bRHip);
		setRotateAngle(bRHip, 0.0F, 0.0F, -0.48F);
		bRHip.setTextureOffset(272, 130).addBox(-4.4463F, -1.3716F, -3.1F, 7.0F, 6.0F, 6.0F, 0.0F, false);

		bRFemur = new AnimatedModelRenderer(this);
		bRFemur.setRotationPoint(-3.4716F, 0.9066F, -0.5353F);
		bRHip.addChild(bRFemur);
		setRotateAngle(bRFemur, 0.0F, 0.0F, -0.3054F);
		bRFemur.setTextureOffset(214, 90).addBox(-14.9093F, -3.8529F, -4.5647F, 17.0F, 7.0F, 9.0F, 0.0F, false);
		bRFemur.setTextureOffset(30, 30).addBox(-16.9093F, -1.8529F, -6.5647F, 3.0F, 5.0F, 2.0F, 0.0F, false);
		bRFemur.setTextureOffset(34, 187).addBox(-12.9093F, -3.8529F, -5.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		bRFemur.setTextureOffset(127, 167).addBox(-7.9093F, -3.8529F, -5.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		bRFemur.setTextureOffset(56, 167).addBox(-3.9093F, -3.8529F, -5.5647F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		bRFemur.setTextureOffset(259, 238).addBox(-18.9093F, -0.8529F, -5.5647F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		bRFemur.setTextureOffset(0, 256).addBox(-6.9093F, -4.8529F, -3.5647F, 9.0F, 1.0F, 9.0F, 0.0F, false);
		bRFemur.setTextureOffset(198, 53).addBox(-3.9093F, -5.8529F, -3.5647F, 6.0F, 1.0F, 9.0F, 0.0F, false);
		bRFemur.setTextureOffset(177, 182).addBox(-8.9093F, -4.8529F, -3.5647F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		bRFemur.setTextureOffset(236, 79).addBox(-14.9093F, -1.3529F, 5.3353F, 19.0F, 4.0F, 2.0F, 0.0F, false);
		bRFemur.setTextureOffset(64, 25).addBox(-15.9093F, -4.8529F, -4.5647F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		bRFemur.setTextureOffset(191, 0).addBox(-9.9093F, -1.3529F, 3.3353F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		bRFemur.setTextureOffset(142, 167).addBox(-3.9093F, -1.3529F, 3.3353F, 3.0F, 4.0F, 2.0F, 0.0F, false);
		bRFemur.setTextureOffset(100, 164).addBox(1.0907F, -1.3529F, 3.3353F, 3.0F, 4.0F, 2.0F, 0.0F, false);

		bRTibia = new AnimatedModelRenderer(this);
		bRTibia.setRotationPoint(-15.1364F, -1.0F, 0.4153F);
		bRFemur.addChild(bRTibia);
		setRotateAngle(bRTibia, 0.0F, 0.3491F, -0.7418F);
		bRTibia.setTextureOffset(269, 8).addBox(-13.755F, -0.561F, 3.5555F, 14.0F, 4.0F, 2.0F, 0.0F, false);
		bRTibia.setTextureOffset(20, 283).addBox(-19.755F, -0.561F, 5.5555F, 6.0F, 4.0F, 2.0F, 0.0F, false);
		bRTibia.setTextureOffset(237, 217).addBox(-13.755F, -1.561F, -4.4445F, 14.0F, 7.0F, 8.0F, 0.0F, false);
		bRTibia.setTextureOffset(262, 161).addBox(-13.355F, -1.261F, -5.0445F, 14.0F, 7.0F, 1.0F, 0.0F, false);
		bRTibia.setTextureOffset(251, 169).addBox(-13.755F, -2.561F, -3.4445F, 14.0F, 1.0F, 6.0F, 0.0F, false);

		bRFoot = new AnimatedModelRenderer(this);
		bRFoot.setRotationPoint(-13.3289F, 0.44F, 1.3926F);
		bRTibia.addChild(bRFoot);
		setRotateAngle(bRFoot, -0.6109F, -0.3491F, 0.0F);
		bRFoot.setTextureOffset(127, 167).addBox(-9.0814F, -1.1816F, -20.2186F, 3.0F, 1.0F, 9.0F, 0.0F, false);
		bRFoot.setTextureOffset(56, 167).addBox(-9.0814F, 1.8184F, -20.2186F, 3.0F, 1.0F, 9.0F, 0.0F, false);
		bRFoot.setTextureOffset(280, 142).addBox(-9.0814F, -0.1816F, -18.2186F, 2.0F, 2.0F, 7.0F, 0.0F, false);
		bRFoot.setTextureOffset(85, 164).addBox(-9.0814F, 2.8184F, -14.2186F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		bRFoot.setTextureOffset(171, 252).addBox(-9.0814F, -1.1816F, -11.2186F, 6.0F, 4.0F, 8.0F, 0.0F, false);
		bRFoot.setTextureOffset(85, 151).addBox(-9.0814F, -3.1816F, -14.2186F, 2.0F, 2.0F, 11.0F, 0.0F, false);
		bRFoot.setTextureOffset(169, 232).addBox(-10.0814F, 2.8184F, -1.2186F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bRFoot.setTextureOffset(155, 232).addBox(-10.0814F, 2.8184F, 4.7814F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bRFoot.setTextureOffset(223, 195).addBox(-10.0814F, -0.1816F, 4.7814F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bRFoot.setTextureOffset(200, 99).addBox(-10.0814F, -3.1816F, 4.7814F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		bRFoot.setTextureOffset(34, 187).addBox(-6.0814F, -1.1816F, -3.2186F, 6.0F, 4.0F, 8.0F, 0.0F, false);
		bRFoot.setTextureOffset(98, 195).addBox(-10.0814F, -3.1816F, -1.2186F, 5.0F, 2.0F, 2.0F, 0.0F, false);

		tail = new AnimatedModelRenderer(this);
		tail.setRotationPoint(0.0F, 5.0F, 12.0F);
		lowerBody.addChild(tail);
		setRotateAngle(tail, 0.0F, -0.2182F, 0.0F);
		tail.setTextureOffset(80, 113).addBox(-7.0237F, -11.1F, 2.7836F, 16.0F, 16.0F, 22.0F, 0.0F, false);
		tail.setTextureOffset(124, 66).addBox(-6.0237F, -10.1F, 0.7836F, 14.0F, 13.0F, 24.0F, 0.0F, false);
		tail.setTextureOffset(131, 167).addBox(-5.0237F, -12.0F, 2.7836F, 12.0F, 1.0F, 22.0F, 0.0F, false);

		tail2 = new AnimatedModelRenderer(this);
		tail2.setRotationPoint(0.0F, 0.0F, 24.0F);
		tail.addChild(tail2);
		setRotateAngle(tail2, 0.0F, 0.3927F, 0.0F);
		tail2.setTextureOffset(156, 37).addBox(-3.0152F, -10.0F, 1.1736F, 8.0F, 1.0F, 26.0F, 0.0F, false);
		tail2.setTextureOffset(0, 101).addBox(-6.0152F, -9.0F, 1.1736F, 14.0F, 14.0F, 26.0F, 0.0F, false);
		tail2.setTextureOffset(0, 0).addBox(-5.0152F, -8.0F, -12.8264F, 12.0F, 12.0F, 40.0F, 0.0F, false);

		tail3 = new AnimatedModelRenderer(this);
		tail3.setRotationPoint(0.0F, 0.0F, 26.0F);
		tail2.addChild(tail3);
		setRotateAngle(tail3, 0.0F, 0.2618F, 0.0F);
		tail3.setTextureOffset(85, 151).addBox(-3.0937F, -7.8978F, 0.6462F, 8.0F, 1.0F, 26.0F, 0.0F, false);
		tail3.setTextureOffset(130, 130).addBox(-5.0937F, -6.8978F, 0.6462F, 12.0F, 11.0F, 26.0F, 0.0F, false);
		tail3.setTextureOffset(70, 70).addBox(-4.0937F, -5.8978F, -7.3538F, 10.0F, 9.0F, 34.0F, 0.0F, false);

		tail4 = new AnimatedModelRenderer(this);
		tail4.setRotationPoint(0.0F, 0.0F, 26.0F);
		tail3.addChild(tail4);
		setRotateAngle(tail4, 0.0F, 0.829F, 0.0F);
		tail4.setTextureOffset(134, 103).addBox(-3.3408F, -5.68F, 0.6541F, 8.0F, 1.0F, 26.0F, 0.0F, false);
		tail4.setTextureOffset(132, 2).addBox(-5.3408F, -4.68F, 0.6541F, 12.0F, 9.0F, 26.0F, 0.0F, false);
		tail4.setTextureOffset(74, 28).addBox(-4.3408F, -3.68F, -4.3459F, 10.0F, 7.0F, 31.0F, 0.0F, false);

		tail5 = new AnimatedModelRenderer(this);
		tail5.setRotationPoint(0.0F, 0.0F, 25.5F);
		tail4.addChild(tail5);
		setRotateAngle(tail5, 0.7418F, 0.0F, 0.0F);
		tail5.setTextureOffset(173, 173).addBox(-0.5893F, -5.0357F, 0.9381F, 4.0F, 1.0F, 26.0F, 0.0F, false);
		tail5.setTextureOffset(182, 0).addBox(-2.5893F, -4.0357F, 0.9381F, 8.0F, 9.0F, 19.0F, 0.0F, false);
		tail5.setTextureOffset(90, 178).addBox(-1.5893F, -3.0357F, -2.0619F, 6.0F, 7.0F, 22.0F, 0.0F, false);
		tail5.setTextureOffset(88, 258).addBox(-2.5893F, -3.0357F, 18.9381F, 8.0F, 7.0F, 6.0F, 0.0F, false);
		tail5.setTextureOffset(124, 178).addBox(-2.5893F, -2.0357F, 24.9381F, 8.0F, 5.0F, 6.0F, 0.0F, false);
		tail5.setTextureOffset(80, 271).addBox(5.4107F, -1.0357F, 25.9381F, 8.0F, 4.0F, 6.0F, 0.0F, false);
		tail5.setTextureOffset(80, 127).addBox(-18.5893F, -1.0357F, 28.9381F, 8.0F, 4.0F, 3.0F, 0.0F, false);
		tail5.setTextureOffset(74, 52).addBox(13.4107F, -1.0357F, 28.9381F, 8.0F, 4.0F, 3.0F, 0.0F, false);
		tail5.setTextureOffset(266, 119).addBox(-10.5893F, -1.0357F, 25.9381F, 8.0F, 4.0F, 6.0F, 0.0F, false);
		animator = ModelAnimator.create();
		setDefaultPose();

	}

	@Override
	public void setLivingAnimations(EntityXanthousKing entityIn, float limbSwing, float limbSwingAmount,
			float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
		this.entity = entityIn;
		resetToDefaultPose();
		animator.update(entity, partialTick);
		if (animator.setAnimation(EntityXanthousKing.LIGHTNING_ANIMATION)) {
			roarAnim(partialTick);
		} else if (animator.setAnimation(EntityXanthousKing.CHARGE_ANIMATION)) {
			diveAnim(partialTick);
		} else if (animator.setAnimation(EntityXanthousKing.BITE_ANIMATION)) {
			biteAnim();
		}

		idle(entity.ticksExisted + partialTick);

	}

	private void diveAnim(float partialTick) {
		animator.startKeyframe(56);
		animator.endKeyframe();
		animator.startKeyframe(46);
		animator.resetKeyframe(66);

	}

	private void roarAnim(float partialTick) {
		animator.startKeyframe(16);
		animator.endKeyframe();
		animator.resetKeyframe(18);
	}

	private void biteAnim() {
		animator.startKeyframe(7);
		animator.rotate(leftArm, (float) Math.toRadians(-57.5), 0, 0);
		animator.rotate(leftElbow, (float) Math.toRadians(35.5), 0, 0);

		animator.rotate(fLArm, -(float) Math.toRadians(7.5), (float) Math.toRadians(27.5), (float) Math.toRadians(15.5));
		animator.rotate(fRArm, -(float) Math.toRadians(-7.5), (float) Math.toRadians(-27.5),
				(float) Math.toRadians(-15.5));
		animator.endKeyframe();
		animator.resetKeyframe(8);
	}

	@Override
	public void idle(float frame) {
		animator.rotate(leftArm, MathHelper.cos(0 * 0.6662F) * 2.0F * 0 * 0.5F, 0,
				(float) -Math.abs(((Math.sin((frame) * 0.04f) * 0.0525) + Math.toRadians(-22.5))));
		animator.rotate(rightArm,
				(float) (Math.sin((frame) * 0.04f) * 0.0325)
						+ MathHelper.cos(0 * 0.6662F + (float) Math.PI) * 2.0F * 0 * 0.5F,
				0, (float) Math.abs(((Math.cos((frame) * 0.04f) * 0.0525) + Math.toRadians(22.5))));

		/*
		 * this.fLArm.rotateAngleX = -(float) (Math.cos((frame) * 0.13f) * 0.0325);
		 * this.fRArm.rotateAngleX = -(float) (Math.sin((frame) * 0.13f) * 0.0325);
		 * 
		 * this.bLFemur.rotateAngleX = -(float) (Math.sin((frame) * 0.13f) * 0.0325);
		 * this.bRFemur.rotateAngleX = -(float) (Math.sin((frame) * 0.13f) * 0.0325);
		 * this.fLFemur.rotateAngleX = -(float) (Math.sin((frame) * 0.13f) * 0.0325);
		 * this.fRFemur.rotateAngleX = -(float) (Math.sin((frame) * 0.13f) * 0.0325);
		 * 
		 * 
		 * this.topJaw.rotateAngleX = -(float) (Math.sin((frame) * 0.13f) * 0.0725);
		 * this.bottomJaw.rotateAngleX = (float) (Math.sin((frame) * 0.13f) * 0.0725);
		 * 
		 * this.tail.rotateAngleY = (float) (Math.sin((frame) * 0.13f) * 0.0325);
		 * this.tail2.rotateAngleY = -(float) (Math.sin((frame) * 0.13f) * 0.12325);
		 * this.tail3.rotateAngleY = (float) (Math.sin((frame) * 0.13f) * 0.1225);
		 * this.tail4.rotateAngleY = -(float) (Math.sin((frame) * 0.13f) * 0.1325) + 45;
		 * this.tail5.rotateAngleY = -(float) (Math.sin((frame) * 0.13f) * 0.12325) +
		 * 45;
		 */

	}

	@Override
	public void setRotationAngles(EntityXanthousKing entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		netHeadYaw = MathHelper.wrapDegrees(netHeadYaw);
		float frame = entity.ticksExisted + ClientEventSubscriber.getPartialTicks();
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F) * 0.5f;
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) * 0.5f;

		this.fLLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 2;
		this.fLTibia.rotateAngleX = Math
				.abs(MathHelper.sin(limbSwing * 0.1662F + (float) Math.PI) * 1.4F * limbSwingAmount);
		this.bLLeg.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 2;
		this.bLTibia.rotateAngleX = Math
				.abs(MathHelper.cos(limbSwing * 0.1662F + (float) Math.PI) * 1.4F * limbSwingAmount);
		this.fRLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 2;
		this.fRTibia.rotateAngleX = Math
				.abs(MathHelper.sin(limbSwing * 0.1662F + (float) Math.PI) * 1.4F * limbSwingAmount);
		this.bRLeg.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 2;
		this.bRTibia.rotateAngleX = Math
				.abs(MathHelper.cos(limbSwing * 0.1662F + (float) Math.PI) * 1.4F * limbSwingAmount);
/*
		this.fLArm.rotateAngleX = -(float) (Math.cos((frame) * 0.13f) * 0.0325);
		this.fRArm.rotateAngleX = -(float) (Math.sin((frame) * 0.13f) * 0.0325);*/

		this.bLFemur.rotateAngleX = -(float) (Math.sin((frame) * 0.13f) * 0.0325);
		this.bRFemur.rotateAngleX = -(float) (Math.sin((frame) * 0.13f) * 0.0325);
		this.fLFemur.rotateAngleX = -(float) (Math.sin((frame) * 0.13f) * 0.0325);
		this.fRFemur.rotateAngleX = -(float) (Math.sin((frame) * 0.13f) * 0.0325);

		this.topJaw.rotateAngleX = -(float) (Math.sin((frame) * 0.13f) * 0.0725);
		this.bottomJaw.rotateAngleX = (float) (Math.sin((frame) * 0.13f) * 0.0725);

		this.tail.rotateAngleY = (float) (Math.sin((frame) * 0.13f) * 0.0325);
		this.tail2.rotateAngleY = -(float) (Math.sin((frame) * 0.13f) * 0.12325);
		this.tail3.rotateAngleY = (float) (Math.sin((frame) * 0.13f) * 0.1225);
		this.tail4.rotateAngleY = -(float) (Math.sin((frame) * 0.13f) * 0.1325) + 45;
		this.tail5.rotateAngleY = -(float) (Math.sin((frame) * 0.13f) * 0.12325) + 45;

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		whole.render(matrixStack, buffer, packedLight, packedOverlay);
		upperBody.render(matrixStack, buffer, packedLight, packedOverlay);
		lowerBody.render(matrixStack, buffer, packedLight, packedOverlay);
	}

}