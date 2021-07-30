package com.huto.forcesofreality.model.entity.lord;

import com.huto.forcesofreality.entity.lord.EntityMechan;
import com.hutoslib.client.ClientUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.math.MathHelper;

public class ModelMechan extends EntityModel<EntityMechan> {
	private final ModelPart Head;
	private final ModelPart cage;
	private final ModelPart Body;
	private final ModelPart Body2;
	private final ModelPart backGear;
	private final ModelPart RightArm;
	private final ModelPart rightArmGear;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart RightLeg2;
	private final ModelPart LeftLeg;
	private final ModelPart LeftLeg2;
	private final ModelPart Turret;
	private final ModelPart turretArm;
	private final ModelPart turretHead;

	public ModelMechan() {
		textureWidth = 128;
		textureHeight = 128;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(16, 25).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(10, 32).addBox(-3.0F, -10.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(29, 53).addBox(-2.0F, -11.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(17, 62).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(34, 18).addBox(-2.0F, -13.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(32, 22).addBox(-3.0F, -14.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(22, 18).addBox(-4.0F, -16.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(32, 21).addBox(-3.0F, -17.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(0, 20).addBox(-2.0F, -18.0F, 0.0F, 3.0F, 1.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(22, 16).addBox(1.0F, -17.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, false);

		cage = new ModelRenderer(this);
		cage.setRotationPoint(0.0F, -2.0F, 0.0F);
		Head.addChild(cage);
		cage.setTextureOffset(14, 72).addBox(-4.0F, -9.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(61, 71).addBox(-4.0F, -9.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(65, 71).addBox(3.0F, -9.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(28, 71).addBox(3.0F, -9.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(10, 72).addBox(-2.0F, -9.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(0, 50).addBox(-2.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(0, 0).addBox(-2.0F, -4.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(53, 70).addBox(-4.0F, -9.0F, -2.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(41, 69).addBox(3.0F, -9.0F, -2.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(58, 49).addBox(2.0F, -4.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(41, 53).addBox(-3.0F, -4.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(49, 70).addBox(-4.0F, -9.0F, 1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(45, 69).addBox(3.0F, -9.0F, 1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(62, 6).addBox(2.0F, -4.0F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(54, 31).addBox(-3.0F, -4.0F, 1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(57, 70).addBox(-2.0F, -9.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(71, 62).addBox(1.0F, -9.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(29, 53).addBox(1.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(0, 22).addBox(1.0F, -4.0F, 2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		cage.setTextureOffset(70, 70).addBox(1.0F, -9.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 9.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(36, 21).addBox(-3.0F, 5.0F, -2.0F, 6.0F, 5.0F, 4.0F, 0.0F, false);
		Body.setTextureOffset(0, 39).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 10.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(47, 10).addBox(-4.0F, -2.0F, -4.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 13).addBox(2.0F, -2.0F, -4.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(66, 31).addBox(-2.0F, 4.0F, -4.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(76, 16).addBox(-3.0F, 5.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(76, 10).addBox(2.0F, 5.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(74, 44).addBox(1.0F, 6.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(74, 74).addBox(-2.0F, 6.0F, -4.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(66, 28).addBox(-2.0F, 2.0F, -4.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(66, 26).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(47, 59).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(47, 10).addBox(-4.0F, -2.0F, -4.0F, 2.0F, 6.0F, 1.0F, 0.0F, false);

		Body2 = new ModelRenderer(this);
		Body2.setRotationPoint(0.0F, 0.0F, 4.0F);
		Body.addChild(Body2);
		Body2.setTextureOffset(24, 0).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 10.0F, 2.0F, 0.0F, false);

		backGear = new ModelRenderer(this);
		backGear.setRotationPoint(0.5F, 1.5F, 3.4231F);
		Body2.addChild(backGear);
		setRotationAngle(backGear, 0.0F, 0.0F, 0.7854F);
		backGear.setTextureOffset(64, 57).addBox(-0.5F, -0.5F, -2.4231F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		backGear.setTextureOffset(27, 12).addBox(-2.5F, 3.5F, 0.5769F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(76, 8).addBox(-3.5F, 2.5F, -0.4231F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(72, 33).addBox(-4.5F, -2.5F, 0.5769F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(36, 72).addBox(-6.5F, -2.5F, -0.4231F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(32, 72).addBox(5.5F, -2.5F, -0.4231F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(76, 6).addBox(-3.5F, -3.5F, -0.4231F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(51, 76).addBox(-5.5F, -3.5F, -0.4231F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(47, 76).addBox(-3.5F, -5.5F, -0.4231F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(75, 65).addBox(-3.5F, 4.5F, -0.4231F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(75, 48).addBox(2.5F, 4.5F, -0.4231F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(75, 32).addBox(2.5F, -5.5F, -0.4231F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(75, 63).addBox(-5.5F, 2.5F, -0.4231F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(75, 54).addBox(4.5F, 2.5F, -0.4231F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(75, 29).addBox(4.5F, -3.5F, -0.4231F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(75, 27).addBox(3.5F, -4.5F, 0.5769F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(75, 25).addBox(-4.5F, -4.5F, 0.5769F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(44, 75).addBox(-4.5F, 3.5F, 0.5769F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(74, 71).addBox(3.5F, 3.5F, 0.5769F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(27, 14).addBox(-2.5F, -4.5F, 0.5769F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(12, 22).addBox(-2.5F, -6.5F, -0.4231F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(16, 13).addBox(-2.5F, 5.5F, -0.4231F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(4, 74).addBox(-0.5F, -3.5F, -0.4231F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(72, 49).addBox(3.5F, -2.5F, 0.5769F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(55, 76).addBox(2.5F, 2.5F, -0.4231F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(25, 59).addBox(0.5F, -0.5F, -0.4231F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(68, 76).addBox(2.5F, -3.5F, -0.4231F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(47, 61).addBox(-3.5F, -0.5F, -0.4231F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(64, 57).addBox(-0.5F, 0.5F, -0.4231F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.setTextureOffset(0, 22).addBox(-3.0F, -4.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
		RightArm.setTextureOffset(56, 6).addBox(-4.0F, 3.0F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);
		RightArm.setTextureOffset(12, 62).addBox(-5.0F, 3.0F, -1.5F, 1.0F, 7.0F, 3.0F, 0.0F, false);
		RightArm.setTextureOffset(0, 69).addBox(-4.0F, 9.0F, 1.0F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(5, 37).addBox(-3.5F, 9.0F, -1.0F, 0.0F, 11.0F, 2.0F, 0.0F, false);
		RightArm.setTextureOffset(24, 67).addBox(-4.0F, 9.0F, 1.0F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(20, 67).addBox(-4.0F, 9.0F, -2.0F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(61, 0).addBox(-4.0F, 19.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(57, 59).addBox(-4.0F, 18.0F, 0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(41, 58).addBox(-4.0F, 18.0F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(74, 22).addBox(-4.0F, 9.0F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(76, 36).addBox(-4.0F, 11.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(76, 34).addBox(-4.0F, 11.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(74, 3).addBox(-4.0F, 9.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(51, 61).addBox(-4.0F, -4.0F, -2.0F, 1.0F, 5.0F, 4.0F, 0.0F, false);
		RightArm.setTextureOffset(54, 26).addBox(-3.0F, -5.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		RightArm.setTextureOffset(31, 66).addBox(-3.0F, -4.0F, -3.0F, 4.0F, 5.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(7, 77).addBox(-4.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(76, 38).addBox(-4.0F, 0.7F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(76, 58).addBox(-4.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(76, 50).addBox(-4.0F, 0.7F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		RightArm.setTextureOffset(61, 65).addBox(-3.0F, -4.0F, 2.0F, 4.0F, 5.0F, 1.0F, 0.0F, false);

		rightArmGear = new ModelRenderer(this);
		rightArmGear.setRotationPoint(-4.5F, -2.5F, 0.0F);
		RightArm.addChild(rightArmGear);
		rightArmGear.setTextureOffset(61, 11).addBox(-0.5F, 3.5F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		rightArmGear.setTextureOffset(44, 77).addBox(-0.5F, 2.5F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightArmGear.setTextureOffset(72, 55).addBox(-0.5F, -2.5F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rightArmGear.setTextureOffset(58, 77).addBox(-0.5F, -3.5F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightArmGear.setTextureOffset(61, 44).addBox(-0.5F, -4.5F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		rightArmGear.setTextureOffset(40, 75).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		rightArmGear.setTextureOffset(67, 0).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		rightArmGear.setTextureOffset(74, 67).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		rightArmGear.setTextureOffset(72, 0).addBox(-1.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		rightArmGear.setTextureOffset(36, 58).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		rightArmGear.setTextureOffset(73, 11).addBox(-0.5F, -2.5F, 3.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rightArmGear.setTextureOffset(71, 77).addBox(-0.5F, 2.5F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rightArmGear.setTextureOffset(62, 77).addBox(-0.5F, -3.5F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.setTextureOffset(34, 40).addBox(-1.0F, -4.0F, -2.0F, 4.0F, 9.0F, 4.0F, 0.0F, false);
		LeftArm.setTextureOffset(12, 52).addBox(2.0F, 5.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(12, 24).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(12, 50).addBox(0.0F, 6.0F, -2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(42, 0).addBox(0.0F, 6.0F, 1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(44, 2).addBox(2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(20, 2).addBox(-1.0F, 5.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(73, 39).addBox(3.0F, 6.0F, -2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(6, 17).addBox(4.0F, 6.0F, -1.5F, 1.0F, 4.0F, 0.0F, 0.0F, false);
		LeftArm.setTextureOffset(32, 18).addBox(3.0F, 5.0F, -1.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		LeftArm.setTextureOffset(22, 20).addBox(3.0F, 10.0F, -1.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		LeftArm.setTextureOffset(21, 15).addBox(1.0F, 11.0F, -1.5F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		LeftArm.setTextureOffset(6, 13).addBox(4.0F, 6.0F, 1.5F, 1.0F, 4.0F, 0.0F, 0.0F, false);
		LeftArm.setTextureOffset(32, 20).addBox(3.0F, 5.0F, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		LeftArm.setTextureOffset(25, 15).addBox(3.0F, 10.0F, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		LeftArm.setTextureOffset(24, 12).addBox(1.0F, 11.0F, 1.5F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		LeftArm.setTextureOffset(74, 61).addBox(2.0F, 10.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(51, 63).addBox(2.0F, 10.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(73, 17).addBox(3.0F, 6.0F, 1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(54, 31).addBox(-1.0F, -5.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		LeftArm.setTextureOffset(41, 59).addBox(3.0F, -4.0F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);
		LeftArm.setTextureOffset(27, 77).addBox(3.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(76, 52).addBox(3.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(17, 77).addBox(3.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(76, 56).addBox(3.0F, 2.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(62, 50).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 6.0F, 1.0F, 0.0F, false);
		LeftArm.setTextureOffset(62, 36).addBox(-1.0F, -4.0F, 2.0F, 4.0F, 6.0F, 1.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
		RightLeg.setTextureOffset(50, 39).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		RightLeg.setTextureOffset(28, 32).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		RightLeg.setTextureOffset(16, 15).addBox(-1.0F, -2.0F, 2.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		RightLeg2 = new ModelRenderer(this);
		RightLeg2.setRotationPoint(0.0F, 4.0F, -2.0F);
		RightLeg.addChild(RightLeg2);
		RightLeg2.setTextureOffset(46, 49).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		RightLeg2.setTextureOffset(4, 68).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		RightLeg2.setTextureOffset(68, 11).addBox(1.0F, 1.0F, 4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		RightLeg2.setTextureOffset(18, 39).addBox(-2.0F, 1.0F, 4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		RightLeg2.setTextureOffset(0, 13).addBox(-2.0F, 7.0F, -3.0F, 4.0F, 1.0F, 8.0F, 0.0F, false);
		RightLeg2.setTextureOffset(47, 10).addBox(-3.0F, 6.0F, -3.0F, 1.0F, 2.0F, 7.0F, 0.0F, false);
		RightLeg2.setTextureOffset(60, 0).addBox(-3.0F, 5.0F, -1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		RightLeg2.setTextureOffset(27, 32).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 1.0F, 7.0F, 0.0F, false);
		RightLeg2.setTextureOffset(27, 61).addBox(-1.0F, 5.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		RightLeg2.setTextureOffset(32, 16).addBox(-1.0F, 0.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
		LeftLeg.setTextureOffset(0, 50).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		LeftLeg.setTextureOffset(68, 43).addBox(-1.0F, 5.0F, -3.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(53, 19).addBox(1.0F, 5.0F, 2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		LeftLeg.setTextureOffset(18, 53).addBox(-2.0F, 5.0F, 2.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);

		LeftLeg2 = new ModelRenderer(this);
		LeftLeg2.setRotationPoint(0.0F, 4.0F, -2.0F);
		LeftLeg.addChild(LeftLeg2);
		LeftLeg2.setTextureOffset(44, 0).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		LeftLeg2.setTextureOffset(42, 30).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		LeftLeg2.setTextureOffset(16, 25).addBox(-1.0F, -6.0F, 4.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		LeftLeg2.setTextureOffset(32, 12).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 1.0F, 7.0F, 0.0F, false);
		LeftLeg2.setTextureOffset(66, 33).addBox(-1.0F, 5.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		LeftLeg2.setTextureOffset(20, 0).addBox(-1.0F, 0.0F, 4.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		LeftLeg2.setTextureOffset(20, 61).addBox(2.0F, 5.0F, -1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		LeftLeg2.setTextureOffset(16, 16).addBox(-2.0F, 7.0F, -3.0F, 4.0F, 1.0F, 8.0F, 0.0F, false);
		LeftLeg2.setTextureOffset(9, 53).addBox(2.0F, 6.0F, -3.0F, 1.0F, 2.0F, 7.0F, 0.0F, false);

		Turret = new ModelRenderer(this);
		Turret.setRotationPoint(5.0F, 2.0F, 4.0F);
		setRotationAngle(Turret, 0.0F, 0.0F, -2.1817F);

		turretArm = new ModelRenderer(this);
		turretArm.setRotationPoint(2.6202F, -3.3361F, 1.4583F);
		Turret.addChild(turretArm);
		turretArm.setTextureOffset(66, 6).addBox(-2.0626F, -1.1187F, -0.4583F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		turretArm.setTextureOffset(63, 17).addBox(-2.0626F, -2.1187F, -1.4583F, 4.0F, 5.0F, 1.0F, 0.0F, false);
		turretArm.setTextureOffset(18, 40).addBox(-1.9819F, 2.4832F, -2.4583F, 4.0F, 9.0F, 4.0F, 0.0F, false);
		turretArm.setTextureOffset(0, 60).addBox(-1.4904F, 10.8036F, -1.9583F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		turretArm.setTextureOffset(66, 23).addBox(-1.4904F, 15.8036F, -1.9583F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		turretHead = new ModelRenderer(this);
		turretHead.setRotationPoint(0.0096F, 15.5536F, -5.3333F);
		turretArm.addChild(turretHead);
		turretHead.setTextureOffset(18, 53).addBox(-1.5F, -2.75F, -1.625F, 3.0F, 1.0F, 5.0F, 0.0F, false);
		turretHead.setTextureOffset(52, 19).addBox(-1.5F, 1.25F, -1.625F, 3.0F, 1.0F, 5.0F, 0.0F, false);
		turretHead.setTextureOffset(57, 57).addBox(-2.5F, -1.75F, -1.625F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		turretHead.setTextureOffset(30, 40).addBox(-2.5F, -2.75F, -2.625F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		turretHead.setTextureOffset(42, 30).addBox(-1.5F, -1.75F, -2.625F, 3.0F, 3.0F, 6.0F, 0.0F, false);
		turretHead.setTextureOffset(46, 39).addBox(-2.5F, 1.25F, -2.625F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		turretHead.setTextureOffset(32, 20).addBox(1.5F, 1.25F, -2.625F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		turretHead.setTextureOffset(56, 0).addBox(1.5F, -2.75F, -2.625F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		turretHead.setTextureOffset(29, 58).addBox(1.5F, -1.75F, -1.625F, 1.0F, 3.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityMechan entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		
		float parTicks = ClientUtils.getPartialTicks();

		
		this.backGear.rotateAngleZ = (ageInTicks+ parTicks) * 0.1f;
		this.rightArmGear.rotateAngleX = (ageInTicks+ parTicks) * 0.3f;
		this.cage.rotateAngleY = -(ageInTicks+ parTicks) * 0.015f;
		this.turretArm.rotateAngleZ = (float) (Math.sin((ageInTicks+ parTicks) / 7) * 0.35f);
		this.turretHead.rotateAngleZ = (ageInTicks+ parTicks) * 0.1f;
		this.RightArm.rotationPointZ = 0.0F;
		this.RightArm.rotationPointX = -5.0F;
		this.LeftArm.rotationPointZ = 0.0F;
		this.LeftArm.rotationPointX = 5.0F;
		float f = 1.5F;
		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount
				* 0.5F / f;
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.RightArm.rotateAngleZ = 0.0F;
		this.LeftArm.rotateAngleZ = 0.0F;

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		Turret.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}