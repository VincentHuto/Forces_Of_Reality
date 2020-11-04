package com.huto.hutosmod.models.entity;

import com.huto.hutosmod.entities.EntityMalformedAutomaton;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelMalformedAutomaton extends EntityModel<EntityMalformedAutomaton> {
	private final ModelRenderer rightLeg;
	private final ModelRenderer frontWheel;
	private final ModelRenderer backWheel;
	private final ModelRenderer leftLeg;
	private final ModelRenderer hips;
	private final ModelRenderer lowBarF;
	private final ModelRenderer lowBarB;
	private final ModelRenderer chest;
	private final ModelRenderer backGear;
	private final ModelRenderer topRightShoulderPipe;
	private final ModelRenderer topLeftFrontPipe;
	private final ModelRenderer topLeftBackPipe2;
	private final ModelRenderer topBarF;
	private final ModelRenderer topBarBottom;
	private final ModelRenderer topBarB;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer head;

	public ModelMalformedAutomaton() {
		textureWidth = 128;
		textureHeight = 128;

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
		rightLeg.setTextureOffset(0, 59).addBox(-8.0F, -19.0F, -4.0F, 4.0F, 13.0F, 8.0F, 0.0F, false);
		rightLeg.setTextureOffset(27, 34).addBox(-8.0F, -6.0F, -10.0F, 4.0F, 1.0F, 19.0F, 0.0F, false);
		rightLeg.setTextureOffset(0, 27).addBox(-8.0F, -5.0F, -11.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		rightLeg.setTextureOffset(0, 22).addBox(-8.0F, -5.0F, 9.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		rightLeg.setTextureOffset(0, 33).addBox(-8.0F, -1.0F, -10.0F, 4.0F, 1.0F, 19.0F, 0.0F, false);

		frontWheel = new ModelRenderer(this);
		frontWheel.setRotationPoint(-6.0F, -3.0F, -6.0F);
		rightLeg.addChild(frontWheel);
		frontWheel.setTextureOffset(37, 33).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		frontWheel.setTextureOffset(24, 95).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		frontWheel.setTextureOffset(62, 94).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		backWheel = new ModelRenderer(this);
		backWheel.setRotationPoint(-6.0F, -3.125F, 4.375F);
		rightLeg.addChild(backWheel);
		backWheel.setTextureOffset(10, 33).addBox(-1.0F, -1.875F, 0.625F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		backWheel.setTextureOffset(24, 91).addBox(-1.0F, -0.875F, -0.375F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		backWheel.setTextureOffset(0, 35).addBox(0.0F, -2.875F, -14.375F, 0.0F, 5.0F, 19.0F, 0.0F, false);
		backWheel.setTextureOffset(90, 60).addBox(-1.0F, -0.875F, 2.625F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(16.0F, 24.0F, 0.0F);
		leftLeg.setTextureOffset(96, 60).addBox(-12.0F, -19.0F, -4.0F, 4.0F, 4.0F, 7.0F, 0.0F, false);
		leftLeg.setTextureOffset(34, 94).addBox(-12.0F, -4.0F, -4.0F, 4.0F, 3.0F, 8.0F, 0.0F, false);
		leftLeg.setTextureOffset(80, 28).addBox(-13.0F, -1.0F, -4.0F, 6.0F, 1.0F, 8.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 19).addBox(-12.0F, -1.0F, -5.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 8).addBox(-12.0F, -1.0F, 4.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 11).addBox(-11.0F, -10.0F, -3.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 0).addBox(-11.0F, -15.0F, 1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		leftLeg.setTextureOffset(27, 44).addBox(-12.0F, -13.0F, -4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 44).addBox(-12.0F, -9.0F, 0.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		leftLeg.setTextureOffset(16, 59).addBox(-11.0F, -15.0F, -3.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 59).addBox(-11.0F, -6.0F, 1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		hips = new ModelRenderer(this);
		hips.setRotationPoint(0.0F, 2.5F, 0.0F);
		hips.setTextureOffset(12, 88).addBox(-4.0F, 0.5F, -5.0F, 1.0F, 7.0F, 10.0F, 0.0F, false);
		hips.setTextureOffset(66, 0).addBox(-4.0F, -0.5F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
		hips.setTextureOffset(66, 46).addBox(-3.0F, 7.5F, -5.0F, 6.0F, 1.0F, 10.0F, 0.0F, false);
		hips.setTextureOffset(84, 87).addBox(3.0F, 0.5F, -5.0F, 1.0F, 7.0F, 10.0F, 0.0F, false);

		lowBarF = new ModelRenderer(this);
		lowBarF.setRotationPoint(0.0F, 4.5F, -1.0F);
		hips.addChild(lowBarF);
		lowBarF.setTextureOffset(98, 75).addBox(-3.0F, 0.0F, 2.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		lowBarB = new ModelRenderer(this);
		lowBarB.setRotationPoint(0.0F, 4.5F, -2.0F);
		hips.addChild(lowBarB);
		lowBarB.setTextureOffset(98, 71).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		chest = new ModelRenderer(this);
		chest.setRotationPoint(-0.0147F, -5.2721F, 1.0735F);
		chest.setTextureOffset(91, 50).addBox(-2.9853F, 4.2721F, -5.0735F, 6.0F, 3.0F, 7.0F, 0.0F, false);
		chest.setTextureOffset(72, 72).addBox(-3.9853F, -0.7279F, -6.0735F, 8.0F, 5.0F, 10.0F, 0.0F, false);
		chest.setTextureOffset(65, 105).addBox(6.0147F, -0.7279F, -4.0735F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(52, 105).addBox(-6.9853F, -0.7279F, -4.0735F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(12, 80).addBox(-6.9853F, -0.7279F, 0.9265F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(61, 105).addBox(6.0147F, -0.7279F, 0.9265F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(74, 95).addBox(4.0147F, 2.2721F, -4.0735F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(12, 88).addBox(-5.9853F, 2.2721F, -4.0735F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(4, 80).addBox(-5.9853F, 2.2721F, 0.9265F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(92, 8).addBox(4.0147F, 2.2721F, 0.9265F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(22, 105).addBox(4.0147F, -0.7279F, -4.0735F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(104, 87).addBox(-8.9853F, -0.7279F, -4.0735F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(104, 79).addBox(-8.9853F, -0.7279F, 0.9265F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(10, 105).addBox(4.0147F, -0.7279F, 0.9265F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(105, 105).addBox(4.0147F, 1.2721F, -4.0735F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(58, 100).addBox(-4.9853F, 1.2721F, -4.0735F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(34, 99).addBox(-4.9853F, 1.2721F, 0.9265F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(102, 79).addBox(4.0147F, 1.2721F, 0.9265F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(77, 105).addBox(4.0147F, 3.2721F, -4.0735F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(6, 104).addBox(6.0147F, -14.7279F, -4.0735F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(100, 94).addBox(-4.9853F, 3.2721F, -4.0735F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(50, 100).addBox(-4.9853F, 3.2721F, 0.9265F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(14, 105).addBox(4.0147F, 3.2721F, 0.9265F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(73, 105).addBox(4.0147F, 2.2721F, -3.0735F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(54, 100).addBox(-4.9853F, 2.2721F, -3.0735F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(99, 65).addBox(-4.9853F, 2.2721F, 1.9265F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(104, 34).addBox(4.0147F, 2.2721F, 1.9265F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(69, 105).addBox(4.0147F, 2.2721F, -5.0735F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(100, 34).addBox(-4.9853F, 2.2721F, -5.0735F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(37, 100).addBox(-4.9853F, 2.2721F, -0.0735F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(20, 105).addBox(4.0147F, 2.2721F, -0.0735F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(16, 105).addBox(8.0147F, -0.7279F, -4.0735F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(96, 94).addBox(-2.9853F, -12.7279F, -0.0735F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(104, 90).addBox(-4.9853F, -0.7279F, -4.0735F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(99, 104).addBox(-4.9853F, -0.7279F, 0.9265F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(104, 102).addBox(8.0147F, -0.7279F, 0.9265F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(84, 20).addBox(5.0147F, -0.7279F, -5.0735F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(16, 65).addBox(-7.9853F, -0.7279F, -5.0735F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(16, 63).addBox(-7.9853F, -0.7279F, -0.0735F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(76, 20).addBox(5.0147F, -0.7279F, -0.0735F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(80, 33).addBox(5.0147F, -0.7279F, -2.0735F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(66, 54).addBox(-7.9853F, -0.7279F, -2.0735F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(0, 65).addBox(-7.9853F, -0.7279F, 2.9265F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(68, 8).addBox(5.0147F, -0.7279F, 2.9265F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(0, 11).addBox(-10.9853F, -10.7279F, -6.0735F, 22.0F, 1.0F, 10.0F, 0.0F, false);
		chest.setTextureOffset(0, 0).addBox(-11.9853F, -1.7279F, -6.0735F, 23.0F, 1.0F, 10.0F, 0.0F, false);
		chest.setTextureOffset(54, 28).addBox(-3.9853F, -9.7279F, -6.0735F, 8.0F, 8.0F, 10.0F, 0.0F, false);
		chest.setTextureOffset(54, 11).addBox(-11.9853F, -9.7279F, 3.9265F, 23.0F, 8.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(78, 75).addBox(-3.9853F, -8.7279F, 4.9265F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(27, 44).addBox(-2.9853F, -7.7279F, 6.9265F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(72, 46).addBox(2.0147F, -8.7279F, 4.9265F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(0, 44).addBox(1.0147F, -7.7279F, 6.9265F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(50, 30).addBox(-2.9853F, -3.7279F, 4.9265F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(0, 63).addBox(-1.9853F, -4.7279F, 6.9265F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(50, 28).addBox(-2.9853F, -9.7279F, 4.9265F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(54, 36).addBox(-1.9853F, -8.7279F, 6.9265F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(62, 87).addBox(-11.9853F, -9.7279F, -6.0735F, 1.0F, 8.0F, 10.0F, 0.0F, false);
		chest.setTextureOffset(0, 80).addBox(11.0147F, -9.7279F, -6.0735F, 1.0F, 8.0F, 10.0F, 0.0F, false);
		chest.setTextureOffset(0, 22).addBox(-9.9853F, -11.7279F, -6.0735F, 20.0F, 1.0F, 10.0F, 0.0F, false);

		backGear = new ModelRenderer(this);
		backGear.setRotationPoint(0.207F, -6.2279F, 6.4649F);
		chest.addChild(backGear);
		backGear.setTextureOffset(83, 104).addBox(-2.1923F, 1.5F, -0.5385F, 3.0F, 13.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(90, 37).addBox(-15.1923F, -1.5F, -0.5385F, 13.0F, 3.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(88, 46).addBox(0.8077F, -1.5F, -0.5385F, 15.0F, 3.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(91, 104).addBox(-2.1923F, -14.5F, -0.5385F, 3.0F, 13.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(50, 25).addBox(-13.1923F, -16.5F, -0.5385F, 27.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(50, 22).addBox(-13.1923F, 14.5F, -0.5385F, 27.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(0, 98).addBox(-17.1923F, -12.5F, -0.5385F, 2.0F, 25.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(24, 59).addBox(15.8077F, -12.5F, -0.5385F, 2.0F, 25.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(46, 105).addBox(-15.1923F, -14.5F, -0.5385F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(40, 105).addBox(-15.1923F, 12.5F, -0.5385F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(34, 105).addBox(13.8077F, 12.5F, -0.5385F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(28, 105).addBox(13.8077F, -14.5F, -0.5385F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(12, 81).addBox(-2.1923F, -1.5F, -1.5385F, 3.0F, 3.0F, 4.0F, 0.0F, false);

		topRightShoulderPipe = new ModelRenderer(this);
		topRightShoulderPipe.setRotationPoint(-4.9853F, -12.7279F, 0.9265F);
		chest.addChild(topRightShoulderPipe);
		topRightShoulderPipe.setTextureOffset(96, 87).addBox(-4.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(90, 87).addBox(-3.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(30, 95).addBox(-2.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(96, 90).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(90, 91).addBox(1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(27, 33).addBox(1.0F, -2.0F, -3.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(24, 86).addBox(-3.0F, -2.0F, -3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(4, 83).addBox(-1.0F, -4.0F, -3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(18, 88).addBox(-1.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(64, 50).addBox(-2.0F, -3.0F, -3.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(28, 85).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(5, 88).addBox(1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(84, 28).addBox(-3.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		topLeftFrontPipe = new ModelRenderer(this);
		topLeftFrontPipe.setRotationPoint(7.0147F, -12.7279F, -1.0735F);
		chest.addChild(topLeftFrontPipe);
		topLeftFrontPipe.setTextureOffset(6, 101).addBox(2.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(80, 95).addBox(1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(72, 75).addBox(1.0F, -2.0F, -3.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(84, 95).addBox(1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(102, 94).addBox(-1.0F, -4.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(72, 72).addBox(-2.0F, -3.0F, -3.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(98, 8).addBox(-1.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(88, 95).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(6, 98).addBox(-2.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(92, 20).addBox(-3.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(88, 50).addBox(-3.0F, -2.0F, -3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(98, 79).addBox(-4.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(56, 103).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topLeftFrontPipe.setTextureOffset(68, 94).addBox(-3.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		topLeftBackPipe2 = new ModelRenderer(this);
		topLeftBackPipe2.setRotationPoint(7.0147F, -12.7279F, -1.0735F);
		chest.addChild(topLeftBackPipe2);
		topLeftBackPipe2.setTextureOffset(0, 86).addBox(2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(72, 4).addBox(1.0F, 0.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(0, 33).addBox(1.0F, -2.0F, 1.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(72, 0).addBox(1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(80, 28).addBox(-1.0F, -4.0F, 1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(54, 33).addBox(-2.0F, -3.0F, 1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(42, 50).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(15, 50).addBox(-1.0F, -3.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(72, 59).addBox(-2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(6, 11).addBox(-3.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(0, 80).addBox(-3.0F, -2.0F, 1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(39, 44).addBox(-4.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(12, 44).addBox(0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topLeftBackPipe2.setTextureOffset(6, 0).addBox(-3.0F, 0.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		topBarF = new ModelRenderer(this);
		topBarF.setRotationPoint(0.0147F, -7.7279F, -4.0735F);
		chest.addChild(topBarF);
		topBarF.setTextureOffset(74, 87).addBox(4.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		topBarF.setTextureOffset(56, 4).addBox(-11.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		topBarBottom = new ModelRenderer(this);
		topBarBottom.setRotationPoint(0.0147F, -4.7279F, -2.0735F);
		chest.addChild(topBarBottom);
		topBarBottom.setTextureOffset(90, 41).addBox(-11.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		topBarBottom.setTextureOffset(54, 46).addBox(4.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		topBarB = new ModelRenderer(this);
		topBarB.setRotationPoint(0.0147F, -7.7279F, -0.0735F);
		chest.addChild(topBarB);
		topBarB.setTextureOffset(74, 91).addBox(-11.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);
		topBarB.setTextureOffset(56, 0).addBox(4.0F, -1.0F, -1.0F, 7.0F, 2.0F, 2.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-11.9853F, -4.7279F, -1.0735F);
		chest.addChild(rightArm);
		rightArm.setTextureOffset(52, 54).addBox(-4.0F, -3.0F, -3.0F, 4.0F, 34.0F, 6.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(13.0147F, -4.7279F, -1.0735F);
		chest.addChild(leftArm);
		leftArm.setTextureOffset(32, 54).addBox(-1.0F, -3.0F, -3.0F, 4.0F, 34.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(96, 87).addBox(4.0F, -6.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(96, 14).addBox(-1.0F, -7.0F, -3.0F, 5.0F, 2.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(92, 0).addBox(-30.0F, -7.0F, -3.0F, 5.0F, 2.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(24, 88).addBox(-31.0F, -6.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(56, 8).addBox(-30.0F, -6.0F, 3.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(54, 50).addBox(-30.0F, -6.0F, -4.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(102, 8).addBox(-1.0F, -5.0F, 4.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(37, 94).addBox(4.0F, -5.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(66, 57).addBox(-1.0F, -6.0F, 3.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(64, 20).addBox(-1.0F, -6.0F, -4.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(46, 54).addBox(-30.0F, -5.0F, 4.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(100, 28).addBox(-1.0F, -5.0F, -5.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(50, 94).addBox(-30.0F, -5.0F, -5.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(27, 33).addBox(4.0F, -5.0F, -3.0F, 2.0F, 5.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(0, 33).addBox(-32.0F, -5.0F, -3.0F, 2.0F, 5.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(96, 60).addBox(4.0F, -5.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(94, 50).addBox(-31.0F, -5.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(92, 0).addBox(-31.0F, -5.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -17.0F, 0.0F);
		head.setTextureOffset(72, 57).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityMalformedAutomaton entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		hips.render(matrixStack, buffer, packedLight, packedOverlay);
		chest.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}