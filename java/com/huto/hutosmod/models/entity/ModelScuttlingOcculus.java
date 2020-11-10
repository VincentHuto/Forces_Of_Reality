package com.huto.hutosmod.models.entity;

import com.huto.hutosmod.entities.EntityScuttlingOcculus;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelScuttlingOcculus extends EntityModel<EntityScuttlingOcculus> {
	private final ModelRenderer whole;
	private final ModelRenderer frontLeftLeg;
	private final ModelRenderer segment1;
	private final ModelRenderer segment2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer segment3;
	private final ModelRenderer cube_r2;
	private final ModelRenderer frontRightLeg;
	private final ModelRenderer segment10;
	private final ModelRenderer cube_r3;
	private final ModelRenderer segment11;
	private final ModelRenderer cube_r4;
	private final ModelRenderer segment12;
	private final ModelRenderer cube_r5;
	private final ModelRenderer middleRightLeg;
	private final ModelRenderer segment13;
	private final ModelRenderer cube_r6;
	private final ModelRenderer segment14;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer segment15;
	private final ModelRenderer cube_r9;
	private final ModelRenderer backRightLeg;
	private final ModelRenderer segment16;
	private final ModelRenderer cube_r10;
	private final ModelRenderer segment17;
	private final ModelRenderer cube_r11;
	private final ModelRenderer segment18;
	private final ModelRenderer cube_r12;
	private final ModelRenderer backLeftLeg;
	private final ModelRenderer segment4;
	private final ModelRenderer segment5;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer segment6;
	private final ModelRenderer cube_r15;
	private final ModelRenderer middleLeftLeg;
	private final ModelRenderer segment7;
	private final ModelRenderer segment8;
	private final ModelRenderer cube_r16;
	private final ModelRenderer segment9;
	private final ModelRenderer cube_r17;
	private final ModelRenderer head;
	private final ModelRenderer skull;
	private final ModelRenderer eye2;
	private final ModelRenderer eye3;
	private final ModelRenderer eye4;
	private final ModelRenderer eye5;
	private final ModelRenderer eye7;
	private final ModelRenderer eye8;
	private final ModelRenderer eye9;
	private final ModelRenderer eye10;
	private final ModelRenderer eye11;
	private final ModelRenderer rock1;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer rock5;
	private final ModelRenderer cube_r21;
	private final ModelRenderer rock6;
	private final ModelRenderer rock15;
	private final ModelRenderer rock16;
	private final ModelRenderer cube_r22;
	private final ModelRenderer rock14;
	private final ModelRenderer rock18;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer rock7;
	private final ModelRenderer cube_r25;
	private final ModelRenderer rock2;
	private final ModelRenderer cube_r26;
	private final ModelRenderer rock17;
	private final ModelRenderer cube_r27;
	private final ModelRenderer rock4;
	private final ModelRenderer rock8;
	private final ModelRenderer rock9;
	private final ModelRenderer rock11;
	private final ModelRenderer rock12;
	private final ModelRenderer cube_r28;
	private final ModelRenderer rock10;
	private final ModelRenderer rock3;
	private final ModelRenderer rightMicroLegs;
	private final ModelRenderer leftMicroLegs;
	private final ModelRenderer rightForeLimb;
	private final ModelRenderer leftForeLimb;
	private final ModelRenderer bone;
	private final ModelRenderer rock13;
	private final ModelRenderer cube_r29;

	public ModelScuttlingOcculus() {
		textureWidth = 64;
		textureHeight = 64;

		whole = new ModelRenderer(this);
		whole.setRotationPoint(0.0F, 21.5F, -2.25F);
		whole.setTextureOffset(0, 0).addBox(-4.0F, -4.5F, -1.75F, 8.0F, 2.0F, 7.0F, 0.0F, false);
		whole.setTextureOffset(9, 21).addBox(-4.0F, -2.5F, -1.75F, 3.0F, 1.0F, 3.0F, 0.0F, false);

		frontLeftLeg = new ModelRenderer(this);
		frontLeftLeg.setRotationPoint(4.0F, -3.5F, -0.75F);
		whole.addChild(frontLeftLeg);

		segment1 = new ModelRenderer(this);
		segment1.setRotationPoint(0.0F, -0.9F, 1.0F);
		frontLeftLeg.addChild(segment1);
		setRotationAngle(segment1, 0.0F, 0.0F, -0.9163F);
		segment1.setTextureOffset(30, 17).addBox(-1.9207F, -0.0609F, -2.01F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		segment2 = new ModelRenderer(this);
		segment2.setRotationPoint(4.75F, 0.0F, 1.0F);
		frontLeftLeg.addChild(segment2);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.3695F, 4.3964F, -1.011F);
		segment2.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.6545F);
		cube_r1.setTextureOffset(0, 0).addBox(-1.0F, -1.5F, -0.01F, 0.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 13).addBox(-2.0F, -2.5F, -0.01F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		cube_r1.setTextureOffset(14, 38).addBox(-2.0F, -2.5F, -1.01F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		segment3 = new ModelRenderer(this);
		segment3.setRotationPoint(3.75F, 3.5F, 0.0F);
		frontLeftLeg.addChild(segment3);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-1.2502F, -0.8749F, 0.01F);
		segment3.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.6545F);
		cube_r2.setTextureOffset(8, 38).addBox(0.0F, -1.5F, -1.03F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		frontRightLeg = new ModelRenderer(this);
		frontRightLeg.setRotationPoint(-4.0F, -3.5F, -0.75F);
		whole.addChild(frontRightLeg);

		segment10 = new ModelRenderer(this);
		segment10.setRotationPoint(-2.8871F, -2.4269F, -0.01F);
		frontRightLeg.addChild(segment10);
		setRotationAngle(segment10, 0.0F, 0.0F, -0.1745F);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(1.7964F, 3.5226F, 0.01F);
		segment10.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 1.0472F);
		cube_r3.setTextureOffset(8, 29).addBox(-1.0F, -1.5F, -1.01F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		segment11 = new ModelRenderer(this);
		segment11.setRotationPoint(12.75F, 0.0F, 1.0F);
		frontRightLeg.addChild(segment11);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-17.7876F, 4.4985F, -1.001F);
		segment11.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.6545F);
		cube_r4.setTextureOffset(22, 21).addBox(1.0F, -2.5F, -0.01F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		cube_r4.setTextureOffset(24, 29).addBox(1.0F, -2.5F, -1.01F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		segment12 = new ModelRenderer(this);
		segment12.setRotationPoint(11.75F, 3.5F, 0.0F);
		frontRightLeg.addChild(segment12);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-14.1679F, -0.7728F, 0.02F);
		segment12.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 0.6545F);
		cube_r5.setTextureOffset(0, 9).addBox(-1.0F, -1.5F, -1.03F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		middleRightLeg = new ModelRenderer(this);
		middleRightLeg.setRotationPoint(-4.0F, -3.5F, 1.75F);
		whole.addChild(middleRightLeg);

		segment13 = new ModelRenderer(this);
		segment13.setRotationPoint(-2.8871F, -2.4269F, -0.51F);
		middleRightLeg.addChild(segment13);
		setRotationAngle(segment13, 0.0F, 0.0F, -0.1745F);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(1.7964F, 3.5226F, 0.01F);
		segment13.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, 1.0472F);
		cube_r6.setTextureOffset(26, 27).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		segment14 = new ModelRenderer(this);
		segment14.setRotationPoint(12.75F, 0.0F, 0.5F);
		middleRightLeg.addChild(segment14);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-17.7876F, 4.4985F, -1.001F);
		segment14.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, 0.6545F);
		cube_r7.setTextureOffset(13, 18).addBox(1.0F, -2.5F, 0.001F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		cube_r7.setTextureOffset(0, 22).addBox(1.0F, -2.5F, 1.001F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-18.7876F, 5.4985F, 0.999F);
		segment14.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, 0.6545F);
		cube_r8.setTextureOffset(23, 4).addBox(1.0F, -3.5F, -1.499F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		segment15 = new ModelRenderer(this);
		segment15.setRotationPoint(11.75F, 3.5F, -0.5F);
		middleRightLeg.addChild(segment15);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-14.1679F, -0.7728F, 0.02F);
		segment15.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, 0.6545F);
		cube_r9.setTextureOffset(3, 3).addBox(-1.0F, -1.5F, -0.02F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		backRightLeg = new ModelRenderer(this);
		backRightLeg.setRotationPoint(-4.0F, -3.5F, 4.25F);
		whole.addChild(backRightLeg);

		segment16 = new ModelRenderer(this);
		segment16.setRotationPoint(-2.8871F, -2.4269F, -0.01F);
		backRightLeg.addChild(segment16);
		setRotationAngle(segment16, 0.0F, 0.0F, -0.1745F);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(1.7964F, 3.5226F, 0.01F);
		segment16.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, 1.0472F);
		cube_r10.setTextureOffset(0, 27).addBox(-1.0F, -1.5F, -0.99F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		segment17 = new ModelRenderer(this);
		segment17.setRotationPoint(12.75F, 0.0F, 1.0F);
		backRightLeg.addChild(segment17);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-17.7876F, 4.4985F, -1.001F);
		segment17.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, 0.6545F);
		cube_r11.setTextureOffset(0, 18).addBox(1.0F, -2.5F, -0.01F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		cube_r11.setTextureOffset(11, 11).addBox(1.0F, -2.5F, 0.99F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		segment18 = new ModelRenderer(this);
		segment18.setRotationPoint(11.75F, 3.5F, 0.0F);
		backRightLeg.addChild(segment18);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-14.1679F, -0.7728F, 0.02F);
		segment18.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, 0.6545F);
		cube_r12.setTextureOffset(0, 0).addBox(-1.0F, -1.5F, -0.03F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		backLeftLeg = new ModelRenderer(this);
		backLeftLeg.setRotationPoint(4.0F, -3.5F, 4.25F);
		whole.addChild(backLeftLeg);

		segment4 = new ModelRenderer(this);
		segment4.setRotationPoint(0.0F, -0.9F, 1.0F);
		backLeftLeg.addChild(segment4);
		setRotationAngle(segment4, 0.0F, 0.0F, -0.9163F);
		segment4.setTextureOffset(29, 7).addBox(-1.9207F, -0.0609F, -1.99F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		segment5 = new ModelRenderer(this);
		segment5.setRotationPoint(4.75F, 0.0F, 1.0F);
		backLeftLeg.addChild(segment5);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(0.3695F, 4.3964F, -1.011F);
		segment5.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -0.6545F);
		cube_r13.setTextureOffset(36, 31).addBox(-2.0F, -2.5F, -0.01F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(0.3695F, 4.3964F, -0.011F);
		segment5.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, -0.6545F);
		cube_r14.setTextureOffset(12, 38).addBox(-2.0F, -2.5F, -0.01F, 1.0F, 3.0F, 0.0F, 0.0F, false);

		segment6 = new ModelRenderer(this);
		segment6.setRotationPoint(3.75F, 3.5F, 0.0F);
		backLeftLeg.addChild(segment6);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-1.2502F, -0.8749F, 0.01F);
		segment6.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, -0.6545F);
		cube_r15.setTextureOffset(37, 21).addBox(0.0F, -1.5F, -0.03F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		middleLeftLeg = new ModelRenderer(this);
		middleLeftLeg.setRotationPoint(4.0F, -3.5F, 1.75F);
		whole.addChild(middleLeftLeg);

		segment7 = new ModelRenderer(this);
		segment7.setRotationPoint(0.0F, -0.9F, 0.5F);
		middleLeftLeg.addChild(segment7);
		setRotationAngle(segment7, 0.0F, 0.0F, -0.9163F);
		segment7.setTextureOffset(16, 29).addBox(-1.9207F, -0.0609F, -1.5F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		segment8 = new ModelRenderer(this);
		segment8.setRotationPoint(4.75F, 0.0F, 0.5F);
		middleLeftLeg.addChild(segment8);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(0.3695F, 4.3964F, 0.989F);
		segment8.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.0F, -0.6545F);
		cube_r16.setTextureOffset(32, 12).addBox(-2.0F, -2.5F, -0.989F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		cube_r16.setTextureOffset(35, 6).addBox(-2.0F, -2.5F, -1.989F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		cube_r16.setTextureOffset(23, 0).addBox(-2.0F, -2.5F, -1.489F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		segment9 = new ModelRenderer(this);
		segment9.setRotationPoint(3.75F, 3.5F, -0.5F);
		middleLeftLeg.addChild(segment9);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-1.2502F, -0.8749F, 0.01F);
		segment9.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, -0.6545F);
		cube_r17.setTextureOffset(3, 12).addBox(0.0F, -1.5F, -0.01F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -2.5F, -3.75F);
		whole.addChild(head);
		setRotationAngle(head, 0.3491F, 0.0F, 0.0F);

		skull = new ModelRenderer(this);
		skull.setRotationPoint(0.0F, 0.0F, 1.0F);
		head.addChild(skull);
		skull.setTextureOffset(37, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye2 = new ModelRenderer(this);
		eye2.setRotationPoint(1.5F, -1.184F, 2.3794F);
		head.addChild(eye2);
		eye2.setTextureOffset(8, 22).addBox(-0.5F, -0.842F, -1.4397F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		eye3 = new ModelRenderer(this);
		eye3.setRotationPoint(1.5F, -1.4397F, 0.158F);
		head.addChild(eye3);
		eye3.setTextureOffset(18, 21).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		eye4 = new ModelRenderer(this);
		eye4.setRotationPoint(-1.5F, -1.4397F, 0.158F);
		head.addChild(eye4);
		eye4.setTextureOffset(18, 9).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		eye5 = new ModelRenderer(this);
		eye5.setRotationPoint(-0.5F, -1.5F, 1.0977F);
		head.addChild(eye5);
		eye5.setTextureOffset(9, 18).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		eye7 = new ModelRenderer(this);
		eye7.setRotationPoint(1.5F, 0.0977F, 1.7817F);
		head.addChild(eye7);
		eye7.setTextureOffset(14, 29).addBox(-0.5F, 0.0977F, -1.7817F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		eye8 = new ModelRenderer(this);
		eye8.setRotationPoint(-1.5F, 0.0977F, 1.7817F);
		head.addChild(eye8);
		eye8.setTextureOffset(28, 17).addBox(-0.5F, -0.158F, -1.4397F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		eye9 = new ModelRenderer(this);
		eye9.setRotationPoint(-1.0F, 1.0374F, 2.1237F);
		head.addChild(eye9);
		eye9.setTextureOffset(26, 25).addBox(-0.5F, -0.2443F, -2.7214F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		eye10 = new ModelRenderer(this);
		eye10.setRotationPoint(1.0F, 1.0374F, 2.1237F);
		head.addChild(eye10);
		eye10.setTextureOffset(14, 9).addBox(-0.5F, -0.2443F, -2.7214F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		eye11 = new ModelRenderer(this);
		eye11.setRotationPoint(0.0F, -0.2443F, 2.7214F);
		head.addChild(eye11);
		eye11.setTextureOffset(16, 25).addBox(-0.5F, -0.5864F, -3.6611F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rock1 = new ModelRenderer(this);
		rock1.setRotationPoint(-2.0F, -5.5F, 4.25F);
		whole.addChild(rock1);
		setRotationAngle(rock1, -0.3927F, 0.0873F, 0.0F);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(3.0F, 0.0F, 1.0F);
		rock1.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, -0.2618F, 0.0F);
		cube_r18.setTextureOffset(34, 12).addBox(-3.7219F, 1.402F, 0.0379F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r18.setTextureOffset(20, 36).addBox(-4.8158F, 0.5772F, -0.3127F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r18.setTextureOffset(37, 8).addBox(-3.92F, -0.4458F, -0.7014F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(3.0F, 0.0F, 1.0F);
		rock1.addChild(cube_r19);
		setRotationAngle(cube_r19, -2.4871F, -1.0036F, 1.0472F);
		cube_r19.setTextureOffset(34, 27).addBox(-3.2811F, 2.7294F, 3.5032F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		cube_r19.setTextureOffset(34, 27).addBox(-1.5549F, 1.5246F, 1.3658F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(3.0F, 0.0F, 1.0F);
		rock1.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, -0.6981F, 0.0F);
		cube_r20.setTextureOffset(0, 36).addBox(-1.9302F, -0.6439F, -0.7394F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rock5 = new ModelRenderer(this);
		rock5.setRotationPoint(-2.0F, -5.5F, -1.75F);
		whole.addChild(rock5);
		setRotationAngle(rock5, -0.3927F, 0.2618F, 0.0F);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(3.0F, 0.0F, 1.0F);
		rock5.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0436F, 0.2182F, -0.1745F);
		cube_r21.setTextureOffset(36, 16).addBox(-5.331F, -1.1811F, -0.9071F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		rock6 = new ModelRenderer(this);
		rock6.setRotationPoint(0.0F, -5.5F, -1.75F);
		whole.addChild(rock6);
		setRotationAngle(rock6, -0.3927F, 0.2618F, 0.0F);
		rock6.setTextureOffset(36, 36).addBox(-0.2929F, -1.4687F, 0.1315F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rock15 = new ModelRenderer(this);
		rock15.setRotationPoint(0.0F, -4.5F, -2.75F);
		whole.addChild(rock15);
		setRotationAngle(rock15, -0.3927F, 0.2618F, 0.0F);
		rock15.setTextureOffset(22, 32).addBox(-1.3975F, -3.601F, 7.8925F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rock16 = new ModelRenderer(this);
		rock16.setRotationPoint(-1.0F, -3.5F, -2.75F);
		whole.addChild(rock16);
		setRotationAngle(rock16, -0.3927F, 0.2618F, 0.0F);
		rock16.setTextureOffset(0, 32).addBox(-1.3975F, -3.601F, 7.8925F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		rock16.setTextureOffset(0, 32).addBox(0.673F, -0.6439F, 0.7533F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(3.0F, 0.0F, 1.0F);
		rock16.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, -0.3054F, 0.0F);
		cube_r22.setTextureOffset(31, 23).addBox(-0.0808F, -3.7991F, 7.3437F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rock14 = new ModelRenderer(this);
		rock14.setRotationPoint(-4.0F, -4.5F, 0.25F);
		whole.addChild(rock14);
		setRotationAngle(rock14, -0.3927F, 0.2618F, 0.0F);
		rock14.setTextureOffset(30, 32).addBox(-0.2929F, -1.4687F, 0.1315F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		rock14.setTextureOffset(30, 32).addBox(0.4836F, -0.3598F, -2.5457F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rock18 = new ModelRenderer(this);
		rock18.setRotationPoint(2.0F, -3.5F, -1.75F);
		whole.addChild(rock18);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(1.0F, 1.0F, 0.0F);
		rock18.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.2618F, -0.3054F, 0.1745F);
		cube_r23.setTextureOffset(31, 2).addBox(-5.2185F, -0.2837F, -0.0272F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(1.0F, 1.0F, 8.0F);
		rock18.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.2618F, -0.3054F, 0.1745F);
		cube_r24.setTextureOffset(31, 2).addBox(-5.2185F, -0.2837F, -0.0272F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rock7 = new ModelRenderer(this);
		rock7.setRotationPoint(2.0F, -5.5F, -1.75F);
		whole.addChild(rock7);
		setRotationAngle(rock7, -0.3927F, 0.2618F, 0.0F);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(3.0F, 0.0F, 1.0F);
		rock7.addChild(cube_r25);
		setRotationAngle(cube_r25, -0.0436F, 0.4363F, 0.4363F);
		cube_r25.setTextureOffset(28, 36).addBox(-3.6079F, 0.6986F, -1.0305F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rock2 = new ModelRenderer(this);
		rock2.setRotationPoint(-2.0F, -5.5F, 2.25F);
		whole.addChild(rock2);
		setRotationAngle(rock2, -0.3927F, 0.2618F, 0.0F);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(3.0F, 0.0F, 1.0F);
		rock2.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 0.0F, -0.2182F);
		cube_r26.setTextureOffset(18, 25).addBox(-5.1727F, -1.4169F, -1.1076F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		rock17 = new ModelRenderer(this);
		rock17.setRotationPoint(3.0F, -4.5F, 4.25F);
		whole.addChild(rock17);
		setRotationAngle(rock17, -0.3927F, 0.2618F, 0.0F);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(3.0F, 0.0F, 1.0F);
		rock17.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.0F, -0.2182F);
		cube_r27.setTextureOffset(0, 23).addBox(-5.1727F, -1.4169F, -1.1076F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		rock4 = new ModelRenderer(this);
		rock4.setRotationPoint(0.0F, -5.5F, 0.25F);
		whole.addChild(rock4);
		setRotationAngle(rock4, -0.3927F, 0.2618F, 0.0F);
		rock4.setTextureOffset(37, 0).addBox(-1.9659F, -0.901F, -1.2391F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		rock4.setTextureOffset(37, 0).addBox(0.4836F, 0.5641F, -2.163F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rock8 = new ModelRenderer(this);
		rock8.setRotationPoint(3.0F, -5.5F, 1.25F);
		whole.addChild(rock8);
		setRotationAngle(rock8, -0.3927F, 0.2618F, 0.0F);
		rock8.setTextureOffset(23, 4).addBox(-2.9659F, 0.099F, -1.2391F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		rock8.setTextureOffset(23, 4).addBox(-2.1895F, 1.208F, -3.9163F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		rock9 = new ModelRenderer(this);
		rock9.setRotationPoint(3.0F, -4.5F, 3.25F);
		whole.addChild(rock9);
		setRotationAngle(rock9, -0.3927F, 0.2618F, 0.0F);
		rock9.setTextureOffset(8, 25).addBox(-3.673F, -0.4323F, -2.3706F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		rock9.setTextureOffset(8, 25).addBox(-2.8966F, 0.6767F, -5.0478F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		rock11 = new ModelRenderer(this);
		rock11.setRotationPoint(0.0F, -4.5F, -0.75F);
		whole.addChild(rock11);
		setRotationAngle(rock11, -0.3927F, 0.2618F, 0.0F);
		rock11.setTextureOffset(23, 0).addBox(-4.7777F, -2.5646F, 5.3904F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		rock12 = new ModelRenderer(this);
		rock12.setRotationPoint(0.0F, -4.5F, 2.25F);
		whole.addChild(rock12);
		setRotationAngle(rock12, -0.6981F, -0.0873F, -0.48F);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(3.0F, 0.0F, 1.0F);
		rock12.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 0.0F, 0.3054F);
		cube_r28.setTextureOffset(15, 16).addBox(-5.3447F, 1.4785F, -5.66F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r28.setTextureOffset(15, 16).addBox(-5.673F, -0.4323F, -3.3706F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		rock10 = new ModelRenderer(this);
		rock10.setRotationPoint(3.0F, -4.5F, 3.25F);
		whole.addChild(rock10);
		setRotationAngle(rock10, -0.3927F, 0.2618F, 0.0F);
		rock10.setTextureOffset(24, 13).addBox(-2.9659F, -0.901F, -1.2391F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		rock3 = new ModelRenderer(this);
		rock3.setRotationPoint(0.0F, -5.5F, 0.25F);
		whole.addChild(rock3);
		setRotationAngle(rock3, -0.3927F, 0.2618F, 0.0F);
		rock3.setTextureOffset(14, 34).addBox(-1.9659F, -0.901F, -1.2391F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		rock3.setTextureOffset(6, 34).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		rightMicroLegs = new ModelRenderer(this);
		rightMicroLegs.setRotationPoint(1.0F, 1.25F, 0.25F);
		whole.addChild(rightMicroLegs);
		rightMicroLegs.setTextureOffset(2, 21).addBox(0.0F, -1.75F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		rightMicroLegs.setTextureOffset(15, 17).addBox(0.0F, -0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		rightMicroLegs.setTextureOffset(21, 8).addBox(0.0F, -1.75F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		rightMicroLegs.setTextureOffset(9, 19).addBox(0.0F, -0.75F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		rightMicroLegs.setTextureOffset(4, 21).addBox(0.0F, -1.75F, 3.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		leftMicroLegs = new ModelRenderer(this);
		leftMicroLegs.setRotationPoint(0.0F, -2.5F, 7.25F);
		whole.addChild(leftMicroLegs);
		leftMicroLegs.setTextureOffset(17, 8).addBox(-1.0F, 3.0F, -7.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		leftMicroLegs.setTextureOffset(11, 19).addBox(-1.0F, 3.0F, -5.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		leftMicroLegs.setTextureOffset(6, 21).addBox(-1.0F, 2.0F, -6.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		leftMicroLegs.setTextureOffset(20, 10).addBox(-1.0F, 2.0F, -4.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		leftMicroLegs.setTextureOffset(20, 12).addBox(-1.0F, 2.0F, -8.0F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		rightForeLimb = new ModelRenderer(this);
		rightForeLimb.setRotationPoint(1.0F, 0.75F, 6.0F);
		whole.addChild(rightForeLimb);
		setRotationAngle(rightForeLimb, -0.1745F, 0.0F, 0.0F);
		rightForeLimb.setTextureOffset(3, 7).addBox(0.1F, -1.25F, -1.75F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		rightForeLimb.setTextureOffset(4, 0).addBox(0.1F, -0.25F, 0.25F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		leftForeLimb = new ModelRenderer(this);
		leftForeLimb.setRotationPoint(-1.0F, 0.75F, 6.0F);
		whole.addChild(leftForeLimb);
		setRotationAngle(leftForeLimb, -0.2618F, 0.0F, 0.0F);
		leftForeLimb.setTextureOffset(11, 7).addBox(-0.1F, -1.25F, -1.75F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		leftForeLimb.setTextureOffset(0, 3).addBox(-0.1F, -0.25F, 0.25F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(3.0F, 17.0F, 1.0F);
		bone.setTextureOffset(21, 21).addBox(-2.0F, 2.0F, -5.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(0, 18).addBox(-7.0F, 2.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(20, 9).addBox(-2.0F, 2.0F, -1.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(0, 9).addBox(-4.0F, 2.0F, -5.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		rock13 = new ModelRenderer(this);
		rock13.setRotationPoint(-3.0F, -1.0F, -1.0F);
		bone.addChild(rock13);
		setRotationAngle(rock13, -0.829F, 0.1309F, -0.7418F);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(3.0F, 0.0F, 1.0F);
		rock13.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.1745F, -0.4363F, -0.48F);
		cube_r29.setTextureOffset(11, 11).addBox(-6.9565F, -0.324F, -3.0925F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cube_r29.setTextureOffset(11, 11).addBox(-5.5044F, -2.1503F, -1.2067F, 3.0F, 2.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityScuttlingOcculus entity, float limbSwing, float limbSwingAmount,
			float ageInTicks, float netHeadYaw, float headPitch) {
		//Head
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F) * 0.5f;
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) * 0.5f;
			
		//Legs
		this.frontLeftLeg.rotateAngleY =(float)Math.min(limbSwingAmount, 0.25);
		this.frontLeftLeg.rotateAngleZ =(float)Math.min(limbSwingAmount, 0.25);
		this.frontRightLeg.rotateAngleY =(float)Math.min(limbSwingAmount, 0.25);
		this.frontRightLeg.rotateAngleZ =-(float)Math.min(limbSwingAmount, 0.25);
		this.middleLeftLeg.rotateAngleY =(float)Math.min(limbSwingAmount, 0.25);
		this.middleLeftLeg.rotateAngleZ =-(float)Math.min(limbSwingAmount, 0.25);
		this.middleRightLeg.rotateAngleY =(float)Math.min(limbSwingAmount, 0.25);
		this.middleRightLeg.rotateAngleZ =(float)Math.min(limbSwingAmount, 0.25);
		this.backLeftLeg.rotateAngleY =-(float)Math.min(limbSwingAmount, 0.25);
		this.backLeftLeg.rotateAngleZ =(float)Math.min(limbSwingAmount, 0.25);
		this.backRightLeg.rotateAngleY =-(float)Math.min(limbSwingAmount, 0.25);
		this.backRightLeg.rotateAngleZ =-(float)Math.min(limbSwingAmount, 0.25);
		
		// Eyes
		this.eye2.rotateAngleZ = -(float) (Math.sin(ageInTicks) * 0.0325);
		this.eye2.rotateAngleY = -(float) (Math.cos(ageInTicks) * 0.0325);
		this.eye3.rotateAngleZ = -(float) (Math.sin(ageInTicks) * 0.0325);
		this.eye3.rotateAngleY = -(float) (Math.cos(ageInTicks) * 0.0325);
		this.eye4.rotateAngleZ = -(float) (Math.sin(ageInTicks) * 0.0325);
		this.eye4.rotateAngleY = -(float) (Math.cos(ageInTicks) * 0.0325);
		this.eye5.rotateAngleZ = -(float) (Math.sin(ageInTicks) * 0.0325);
		this.eye5.rotateAngleY = -(float) (Math.cos(ageInTicks) * 0.0325);
		this.eye7.rotateAngleZ = -(float) (Math.sin(ageInTicks) * 0.0325);
		this.eye7.rotateAngleY = -(float) (Math.cos(ageInTicks) * 0.0325);
		this.eye8.rotateAngleZ = -(float) (Math.sin(ageInTicks) * 0.0325);
		this.eye8.rotateAngleY = -(float) (Math.cos(ageInTicks) * 0.0325);
		this.eye9.rotateAngleZ = -(float) (Math.sin(ageInTicks) * 0.0325);
		this.eye9.rotateAngleY = -(float) (Math.cos(ageInTicks) * 0.0325);
		this.eye10.rotateAngleZ = -(float) (Math.sin(ageInTicks) * 0.0325);
		this.eye10.rotateAngleY = -(float) (Math.cos(ageInTicks) * 0.0325);
		this.eye11.rotateAngleZ = -(float) (Math.sin(ageInTicks) * 0.0325);
		this.eye11.rotateAngleY = -(float) (Math.cos(ageInTicks) * 0.0325);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		whole.render(matrixStack, buffer, packedLight, packedOverlay);
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}