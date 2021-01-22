package com.huto.forcesofreality.models.entity.lords;

import com.huto.forcesofreality.entities.lords.EntityXanthousKing;
import com.huto.forcesofreality.events.ClientEventSubscriber;
import com.huto.forcesofreality.models.animation.ModelAnimator;
import com.huto.forcesofreality.models.animation.WREntityModel;
import com.huto.forcesofreality.models.animation.WRModelRenderer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelPlayerTrueXanthousKing extends WREntityModel<Entity> {
	private final WRModelRenderer whole;
	private final WRModelRenderer upperBody;
	private final WRModelRenderer hasturForm;
	private final WRModelRenderer head;
	private final WRModelRenderer body;
	private final WRModelRenderer rightLeg;
	private final WRModelRenderer rightLeg2;
	private final WRModelRenderer leftLeg;
	private final WRModelRenderer leftLeg2;
	private final WRModelRenderer cape;
	private final WRModelRenderer Body_r1;
	private final WRModelRenderer bone3;
	private final WRModelRenderer Body_r2;
	private final WRModelRenderer cape2;
	private final WRModelRenderer Body_r3;
	private final WRModelRenderer Body_r4;
	private final WRModelRenderer bone2;
	private final WRModelRenderer Body_r5;
	private final WRModelRenderer leftArm;
	private final WRModelRenderer leftElbow;
	private final WRModelRenderer rightArm;
	private final WRModelRenderer rElbow;
	private final WRModelRenderer staff;
	private final WRModelRenderer bone;
	private final WRModelRenderer crest;
	private final WRModelRenderer crest2;
	private final WRModelRenderer crest3;
	private final WRModelRenderer crest4;
	private final WRModelRenderer crest5;
	public ModelAnimator animator;

	public ModelPlayerTrueXanthousKing() {
		textureWidth = 512;
		textureHeight = 512;

		whole = new WRModelRenderer(this);
		whole.setRotationPoint(0.0F, -15.0F, -15.0F);

		upperBody = new WRModelRenderer(this);
		upperBody.setRotationPoint(0.1F, -19.0F, -19.0F);

		hasturForm = new WRModelRenderer(this);
		hasturForm.setRotationPoint(0.0F, 0.0F, 0.0F);
		upperBody.addChild(hasturForm);

		head = new WRModelRenderer(this);
		head.setRotationPoint(0.0F, 12.0F, 21.0F);
		hasturForm.addChild(head);
		setRotateAngle(head, 0.2182F, 0.0F, 0.0F);
		head.setTextureOffset(191, 242).addBox(-4.1F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(144, 57).addBox(-4.1F, -10.0F, 4.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(144, 55).addBox(-4.1F, -10.0F, -5.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(124, 178).addBox(-5.1F, -14.0F, -5.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(176, 103).addBox(3.9F, -14.0F, 4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(176, 64).addBox(-5.1F, -13.0F, 4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(142, 20).addBox(-5.1F, -13.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(134, 113).addBox(-5.1F, -12.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(66, 103).addBox(3.9F, -13.0F, 3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(143, 2).addBox(-4.1F, -13.0F, -5.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-4.1F, -11.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(36, 0).addBox(2.9F, -13.0F, 4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(72, 230).addBox(-5.1F, -10.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(185, 103).addBox(-6.1F, -10.0F, -5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(185, 64).addBox(-6.1F, -10.0F, 2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(173, 54).addBox(4.9F, -10.0F, 2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(187, 186).addBox(-5.1F, -10.0F, -6.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(146, 154).addBox(-5.1F, -10.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(16, 166).addBox(1.9F, -10.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(200, 90).addBox(3.9F, -10.0F, -4.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 28).addBox(-5.1F, -9.0F, -5.0F, 9.0F, 1.0F, 10.0F, 0.0F, false);
		head.setTextureOffset(202, 169).addBox(-5.1F, -8.0F, -5.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(173, 58).addBox(-5.1F, -8.0F, 3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(185, 68).addBox(2.9F, -8.0F, 3.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		body = new WRModelRenderer(this);
		body.setRotationPoint(-0.1F, 18.1615F, 20.1846F);
		hasturForm.addChild(body);
		body.setTextureOffset(112, 137).addBox(-4.0F, -6.1615F, -1.1846F, 8.0F, 14.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(112, 137).addBox(-4.0F, 7.7385F, -1.9346F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(111, 270).addBox(-4.0F, -6.1615F, -2.2846F, 8.0F, 7.0F, 5.0F, 0.0F, false);
		body.setTextureOffset(112, 137).addBox(-4.0F, 7.7385F, 2.5654F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(112, 137).addBox(3.75F, 7.7385F, -1.1846F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(112, 137).addBox(3.35F, -0.1615F, -1.1846F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(112, 137).addBox(-4.35F, -0.1615F, -1.1846F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(112, 137).addBox(-4.75F, 7.7385F, -1.1846F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		rightLeg = new WRModelRenderer(this);
		rightLeg.setRotationPoint(-2.1F, 8.8385F, 0.8154F);
		body.addChild(rightLeg);
		rightLeg.setTextureOffset(134, 113).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		rightLeg2 = new WRModelRenderer(this);
		rightLeg2.setRotationPoint(0.0F, 7.0F, -2.0F);
		rightLeg.addChild(rightLeg2);
		rightLeg2.setTextureOffset(134, 113).addBox(-2.0F, 0.0F, -0.1F, 4.0F, 9.0F, 4.0F, 0.0F, false);
		rightLeg2.setTextureOffset(28, 212).addBox(-2.0F, 7.0F, -1.1F, 4.0F, 2.0F, 1.0F, 0.0F, false);

		leftLeg = new WRModelRenderer(this);
		leftLeg.setRotationPoint(2.0F, 8.8385F, 0.8154F);
		body.addChild(leftLeg);
		leftLeg.setTextureOffset(134, 113).addBox(-1.9F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, true);

		leftLeg2 = new WRModelRenderer(this);
		leftLeg2.setRotationPoint(-1.0F, 7.0F, -2.0F);
		leftLeg.addChild(leftLeg2);
		leftLeg2.setTextureOffset(134, 113).addBox(-0.9F, 0.0F, -0.1F, 4.0F, 9.0F, 4.0F, 0.0F, true);
		leftLeg2.setTextureOffset(27, 204).addBox(-0.9F, 7.0F, -1.1F, 4.0F, 2.0F, 1.0F, 0.0F, true);

		cape = new WRModelRenderer(this);
		cape.setRotationPoint(0.0F, -6.1615F, 3.8154F);
		body.addChild(cape);
		setRotateAngle(cape, -0.5672F, 0.0F, 0.0F);

		Body_r1 = new WRModelRenderer(this);
		Body_r1.setRotationPoint(3.0F, 1.6868F, 0.0746F);
		cape.addChild(Body_r1);
		setRotateAngle(Body_r1, 0.829F, 0.0F, 0.0F);
		Body_r1.setTextureOffset(152, 203).addBox(1.0F, -0.9319F, -0.4824F, 3.0F, 11.0F, 2.0F, 0.0F, false);
		Body_r1.setTextureOffset(152, 203).addBox(-10.0F, -0.9319F, -0.4824F, 3.0F, 11.0F, 2.0F, 0.0F, false);
		Body_r1.setTextureOffset(217, 202).addBox(-7.0F, -1.9319F, -0.4824F, 8.0F, 12.0F, 2.0F, 0.0F, false);

		bone3 = new WRModelRenderer(this);
		bone3.setRotationPoint(0.0F, 8.0F, 8.0F);
		cape.addChild(bone3);

		Body_r2 = new WRModelRenderer(this);
		Body_r2.setRotationPoint(0.0F, 1.6868F, 1.0746F);
		bone3.addChild(Body_r2);
		setRotateAngle(Body_r2, 0.829F, 0.0F, 0.0F);
		Body_r2.setTextureOffset(155, 214).addBox(-4.0F, -1.9319F, -0.4824F, 8.0F, 5.0F, 2.0F, 0.0F, false);

		cape2 = new WRModelRenderer(this);
		cape2.setRotationPoint(0.0F, 3.0F, 4.0F);
		bone3.addChild(cape2);

		Body_r3 = new WRModelRenderer(this);
		Body_r3.setRotationPoint(-8.0F, 1.3891F, 0.0237F);
		cape2.addChild(Body_r3);
		setRotateAngle(Body_r3, 0.829F, 0.0F, 0.0F);
		Body_r3.setTextureOffset(152, 203).addBox(1.0F, -0.9319F, -0.4824F, 3.0F, 11.0F, 2.0F, 0.0F, false);
		Body_r3.setTextureOffset(152, 203).addBox(12.0F, -0.9319F, -0.4824F, 3.0F, 11.0F, 2.0F, 0.0F, false);

		Body_r4 = new WRModelRenderer(this);
		Body_r4.setRotationPoint(0.0F, 2.0647F, 0.761F);
		cape2.addChild(Body_r4);
		setRotateAngle(Body_r4, 0.829F, 0.0F, 0.0F);
		Body_r4.setTextureOffset(182, 205).addBox(-4.0F, -1.9319F, -0.4824F, 8.0F, 12.0F, 2.0F, 0.0F, false);

		bone2 = new WRModelRenderer(this);
		bone2.setRotationPoint(0.0F, 8.485F, 8.5337F);
		cape2.addChild(bone2);
		setRotateAngle(bone2, 0.7418F, 0.0F, 0.0F);

		Body_r5 = new WRModelRenderer(this);
		Body_r5.setRotationPoint(0.0F, 1.9696F, -0.3473F);
		bone2.addChild(Body_r5);
		setRotateAngle(Body_r5, 0.829F, 0.0F, 0.0F);
		Body_r5.setTextureOffset(152, 224).addBox(-9.0F, -2.0746F, 1.6868F, 18.0F, 6.0F, 1.0F, 0.0F, false);

		leftArm = new WRModelRenderer(this);
		leftArm.setRotationPoint(4.1F, -4.1615F, -0.1846F);
		body.addChild(leftArm);
		setRotateAngle(leftArm, 0.0F, 0.0F, -0.3927F);
		leftArm.setTextureOffset(281, 22).addBox(-0.4751F, -2.1144F, -1.0F, 4.0F, 5.0F, 4.0F, 1.0F, false);
		leftArm.setTextureOffset(92, 230).addBox(-0.4751F, -2.1144F, -1.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

		leftElbow = new WRModelRenderer(this);
		leftElbow.setRotationPoint(1.6173F, 8.7239F, 0.5F);
		leftArm.addChild(leftElbow);
		setRotateAngle(leftElbow, -1.0472F, 0.0F, 0.0F);
		leftElbow.setTextureOffset(249, 266).addBox(-2.0924F, 2.1809F, -1.5331F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		leftElbow.setTextureOffset(0, 52).addBox(-1.0924F, -0.8191F, -0.5331F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		rightArm = new WRModelRenderer(this);
		rightArm.setRotationPoint(-4.1F, -4.1615F, -1.1846F);
		body.addChild(rightArm);
		setRotateAngle(rightArm, 0.0F, 0.0F, 0.3054F);
		rightArm.setTextureOffset(54, 103).addBox(-4.6357F, -2.3177F, 0.0F, 4.0F, 5.0F, 4.0F, 1.0F, false);
		rightArm.setTextureOffset(82, 281).addBox(-4.6357F, -2.3177F, 0.0F, 4.0F, 11.0F, 4.0F, 0.0F, false);

		rElbow = new WRModelRenderer(this);
		rElbow.setRotationPoint(-2.2396F, 9.3559F, 2.5F);
		rightArm.addChild(rElbow);
		setRotateAngle(rElbow, -1.0908F, 0.0F, 0.0F);
		rElbow.setTextureOffset(223, 266).addBox(-2.3961F, 2.5384F, -2.6233F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		rElbow.setTextureOffset(15, 52).addBox(-1.3961F, -0.4616F, -1.6233F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		staff = new WRModelRenderer(this);
		staff.setRotationPoint(-12.9947F, 73.0542F, -92.1387F);
		rElbow.addChild(staff);
		setRotateAngle(staff, 0.3927F, 0.0F, 0.0F);
		staff.setTextureOffset(66, 66).addBox(7.768F, -23.0327F, 88.2578F, 9.0F, 0.0F, 8.0F, 0.0F, false);
		staff.setTextureOffset(241, 256).addBox(6.5935F, -23.8204F, 89.4705F, 2.0F, 2.0F, 7.0F, 0.0F, false);
		staff.setTextureOffset(124, 86).addBox(7.3865F, -23.9316F, 96.3771F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		staff.setTextureOffset(103, 139).addBox(11.3865F, -24.9316F, 91.3771F, 2.0F, 1.0F, 17.0F, 0.0F, false);
		staff.setTextureOffset(240, 240).addBox(11.3865F, -23.9316F, 98.3771F, 2.0F, 1.0F, 15.0F, 0.0F, false);
		staff.setTextureOffset(198, 28).addBox(11.3865F, -22.9316F, 98.3771F, 2.0F, 1.0F, 24.0F, 0.0F, false);
		staff.setTextureOffset(208, 28).addBox(11.3865F, -23.9316F, 118.3771F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		staff.setTextureOffset(143, 2).addBox(11.3865F, -21.9316F, 118.3771F, 2.0F, 1.0F, 5.0F, 0.0F, false);

		bone = new WRModelRenderer(this);
		bone.setRotationPoint(-0.5F, 17.5F, -3.6F);
		upperBody.addChild(bone);
		setRotateAngle(bone, 0.6109F, 0.0F, 0.0F);

		crest = new WRModelRenderer(this);
		crest.setRotationPoint(-21.6F, -3.5F, 28.3889F);
		upperBody.addChild(crest);
		crest.setTextureOffset(0, 256).addBox(6.5F, -3.5F, -0.3889F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(67, 245).addBox(-7.5F, -3.5F, -0.3889F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(207, 197).addBox(-3.5F, 6.5F, -0.3889F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(156, 64).addBox(-4.5F, 5.5F, -0.3889F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(127, 153).addBox(-4.5F, -6.5F, -0.3889F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(108, 230).addBox(5.5F, -4.5F, -0.3889F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(142, 218).addBox(-6.5F, -4.5F, -0.3889F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(279, 183).addBox(-5.5F, -5.5F, -1.3889F, 11.0F, 11.0F, 1.0F, 0.0F, false);
		crest.setTextureOffset(207, 195).addBox(-3.5F, -7.5F, -0.3889F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		crest2 = new WRModelRenderer(this);
		crest2.setRotationPoint(21.4F, -3.5F, 28.3889F);
		upperBody.addChild(crest2);
		crest2.setTextureOffset(63, 245).addBox(6.5F, -3.5F, -0.3889F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(54, 112).addBox(-7.5F, -3.5F, -0.3889F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(198, 49).addBox(-3.5F, 6.5F, -0.3889F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(127, 151).addBox(-4.5F, 5.5F, -0.3889F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(143, 0).addBox(-4.5F, -6.5F, -0.3889F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(122, 218).addBox(5.5F, -4.5F, -0.3889F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(153, 8).addBox(-6.5F, -4.5F, -0.3889F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(262, 279).addBox(-5.5F, -5.5F, -1.3889F, 11.0F, 11.0F, 1.0F, 0.0F, false);
		crest2.setTextureOffset(172, 197).addBox(-3.5F, -7.5F, -0.3889F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		crest3 = new WRModelRenderer(this);
		crest3.setRotationPoint(-0.6F, -11.5F, 24.3889F);
		upperBody.addChild(crest3);
		crest3.setTextureOffset(52, 245).addBox(6.5F, -3.5F, -0.3889F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(48, 241).addBox(-7.5F, -3.5F, -0.3889F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(82, 197).addBox(-3.5F, 6.5F, -0.3889F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(134, 132).addBox(-4.5F, 5.5F, -0.3889F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(80, 101).addBox(-4.5F, -6.5F, -0.3889F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(8, 52).addBox(5.5F, -4.5F, -0.3889F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(23, 150).addBox(-6.5F, -4.5F, -0.3889F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(238, 279).addBox(-5.5F, -5.5F, -1.3889F, 11.0F, 11.0F, 1.0F, 0.0F, false);
		crest3.setTextureOffset(82, 195).addBox(-3.5F, -7.5F, -0.3889F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		crest4 = new WRModelRenderer(this);
		crest4.setRotationPoint(17.525F, 16.5F, 25.375F);
		upperBody.addChild(crest4);
		crest4.setTextureOffset(62, 195).addBox(-6.625F, -3.5F, -0.375F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(34, 185).addBox(-2.625F, 6.5F, -0.375F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(134, 130).addBox(-3.625F, 5.5F, -0.375F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(125, 56).addBox(-3.625F, -6.5F, -0.375F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(20, 141).addBox(6.375F, -4.5F, -0.375F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(125, 28).addBox(-5.625F, -4.5F, -0.375F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(198, 37).addBox(-4.625F, -5.5F, -1.375F, 11.0F, 11.0F, 1.0F, 0.0F, false);
		crest4.setTextureOffset(163, 0).addBox(-2.625F, -7.5F, -0.375F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		crest5 = new WRModelRenderer(this);
		crest5.setRotationPoint(-18.6F, 16.5F, 26.3889F);
		upperBody.addChild(crest5);
		crest5.setTextureOffset(124, 189).addBox(6.5F, -3.5F, -0.3889F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(79, 151).addBox(-7.5F, -3.5F, -0.3889F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(182, 17).addBox(-3.5F, 6.5F, -0.3889F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(125, 54).addBox(-4.5F, 5.5F, -0.3889F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(0, 125).addBox(-4.5F, -6.5F, -0.3889F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(23, 52).addBox(5.5F, -4.5F, -0.3889F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(98, 28).addBox(-6.5F, -4.5F, -0.3889F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(214, 279).addBox(-5.5F, -5.5F, -1.3889F, 11.0F, 11.0F, 1.0F, 0.0F, false);
		crest5.setTextureOffset(182, 15).addBox(-3.5F, -7.5F, -0.3889F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		animator = ModelAnimator.create();
		setDefaultPose();

	}

	@Override
	public void setLivingAnimations(Entity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
		this.entity = entityIn;
		resetToDefaultPose();
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
		/*
		 * animator.rotate(lowerColumn, 1.75f, 0, 0); animator.rotate(upperTorso,
		 * -1.75f, 0, 0); animator.rotate(shoulder, 2.65f, 0, 0);
		 * animator.rotate(shoulder2, -2.65f, 0, 0); animator.rotate(shoulder3, -2.65f,
		 * 0, 0); animator.rotate(shoulder4, -2.65f, 0, 0); animator.rotate(lShoulder,
		 * -1.35f, 0, 0); animator.rotate(rShoulder, -1.35f, 0, 0);
		 * animator.rotate(lFore, 0, 0, -1.05f); animator.rotate(rFore, 0, -0.5f,
		 * -1.05f); animator.rotate(face, -1.65f, 0, 0); animator.rotate(neck1, 0.35f,
		 * 0, 0);
		 */
		animator.endKeyframe();
		animator.startKeyframe(46);
		/*
		 * animator.rotate(lowerColumn, 0, 0, 0); animator.rotate(upperTorso,0, 0, 0);
		 * animator.rotate(shoulder, 0, 0, 0); animator.rotate(shoulder2, 0, 0, 0);
		 * animator.rotate(shoulder3, 0, 0, 0); animator.rotate(shoulder4, 0, 0, 0);
		 * animator.rotate(lShoulder, 0, 0, 0); animator.rotate(rShoulder, 0, 0, 0);
		 * animator.rotate(lFore, 0, 0, 0); animator.rotate(rFore,0, 0, 0);
		 * animator.rotate(face, 0, 0, 0); animator.rotate(neck1, 0, 0, 0);
		 */
		animator.endKeyframe();
		animator.resetKeyframe(66);

	}

	private void roarAnim(float partialTick) {
		animator.startKeyframe(16);
		// animator.rotate(upperTorso, -0.85f, 0, 0);
		animator.rotate(leftArm, -0.55f, 0, -1.55f);
		animator.rotate(rightArm, -0.55f, 0, 1.55f);
		animator.endKeyframe();
		animator.resetKeyframe(18);
	}

	private void biteAnim() {
		animator.startKeyframe(9);

		animator.endKeyframe();
		animator.resetKeyframe(8);
	}

	@Override
	public void idle(float frame) {

	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		netHeadYaw = MathHelper.wrapDegrees(netHeadYaw);
		float frame = entity.ticksExisted + ClientEventSubscriber.getPartialTicks();

		// Head
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F) * 0.75f;
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) * 0.75f;

		// Arms
		this.rightArm.rotateAngleX = (float) (Math.sin((frame) * 0.04f) * 0.0325)
				+ MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.rightArm.rotateAngleZ = (float) Math.abs(((Math.cos((frame) * 0.04f) * 0.0525) + Math.toRadians(22.5)));
		this.leftArm.rotateAngleZ = (float) -Math.abs(((Math.sin((frame) * 0.04f) * 0.0525) + Math.toRadians(-22.5)));

		// Legs
		this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.9662F) * 1.4F * limbSwingAmount / 2;
		this.rightLeg2.rotateAngleX = Math
				.abs(MathHelper.cos(limbSwing * 0.1662F + (float) Math.PI) * 1.4F * limbSwingAmount);
		this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.9662F + (float) Math.PI) * 1.4F * limbSwingAmount / 2;
		this.leftLeg2.rotateAngleX = Math
				.abs(MathHelper.sin(limbSwing * 0.1662F + (float) Math.PI) * 1.4F * limbSwingAmount);
		// Cape
		this.cape.rotateAngleX = (float) Math.sin((frame) * 0.3f) * 0.05f + 05.75f;
		this.bone3.rotateAngleX = (float) Math.sin((frame) * 0.5f) * 0.1f + 25.25f;
		this.cape2.rotateAngleX = (float) Math.sin((frame) * 0.7f) * 0.15f + 25.25f;
		this.bone2.rotateAngleX = (float) Math.sin((frame) * 0.8f) * 0.25f + 25.5f;

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		whole.render(matrixStack, buffer, packedLight, packedOverlay);
		upperBody.render(matrixStack, buffer, packedLight, packedOverlay);
	}

}