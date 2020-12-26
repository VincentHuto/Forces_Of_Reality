package com.huto.forcesofreality.models.entity.guardians;
// Made with Blockbench 3.7.2

import com.huto.forcesofreality.entities.guardians.EntityMalformedAutomaton;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelMalformedAutomaton extends EntityModel<EntityMalformedAutomaton> {
	private final ModelRenderer head;
	private final ModelRenderer neck;
	private final ModelRenderer chest;
	private final ModelRenderer frontGear;
	private final ModelRenderer backGear;
	private final ModelRenderer midLefFronPipe;
	private final ModelRenderer midLefBackPipe;
	private final ModelRenderer midRightFronPipe;
	private final ModelRenderer midRightBackPipe;
	private final ModelRenderer topLeftFrontPipe;
	private final ModelRenderer topLeftBackPipe2;
	private final ModelRenderer topRightShoulderPipe;
	private final ModelRenderer topBarF;
	private final ModelRenderer topBarBottom;
	private final ModelRenderer topBarB;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer hips;
	private final ModelRenderer rightLeg;
	private final ModelRenderer tread;
	private final ModelRenderer legBar;
	private final ModelRenderer frontWheel;
	private final ModelRenderer middleWheel;
	private final ModelRenderer backWheel;
	private final ModelRenderer leftLeg;
	private final ModelRenderer lowBarF;
	private final ModelRenderer lowBarB;

	public ModelMalformedAutomaton() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -17.0F, 0.0F);
		head.setTextureOffset(72, 57).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);

		neck = new ModelRenderer(this);
		neck.setRotationPoint(0.0F, -17.0F, 0.0F);
		neck.setTextureOffset(49, 63).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		chest = new ModelRenderer(this);
		chest.setRotationPoint(-0.0147F, -5.2721F, 1.0735F);
		chest.setTextureOffset(91, 50).addBox(-2.9853F, 4.2721F, -5.0735F, 6.0F, 3.0F, 7.0F, 0.0F, false);
		chest.setTextureOffset(72, 72).addBox(-3.9853F, -0.7279F, -6.0735F, 8.0F, 5.0F, 10.0F, 0.0F, false);
		chest.setTextureOffset(6, 104).addBox(6.0147F, -14.7279F, -4.0735F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chest.setTextureOffset(0, 11).addBox(-10.9853F, -10.7279F, -6.0735F, 22.0F, 1.0F, 10.0F, 0.0F, false);
		chest.setTextureOffset(0, 11).addBox(-10.9853F, -1.7279F, -6.0735F, 22.0F, 1.0F, 10.0F, 0.0F, false);
		chest.setTextureOffset(54, 28).addBox(-3.9853F, -9.7279F, -6.0735F, 8.0F, 8.0F, 10.0F, 0.0F, false);
		chest.setTextureOffset(54, 11).addBox(-11.9853F, -9.7279F, 3.9265F, 23.0F, 8.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(78, 75).addBox(-2.9853F, -7.7279F, 4.9265F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(45, 65).addBox(-2.9853F, -7.7279F, 6.9265F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(72, 46).addBox(2.0147F, -7.7279F, 4.9265F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(8, 65).addBox(2.0147F, -7.7279F, 6.9265F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(54, 24).addBox(-1.9853F, -3.7279F, 4.9265F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(0, 63).addBox(-1.9853F, -3.7279F, 6.9265F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(34, 85).addBox(-1.9853F, -8.7279F, 4.9265F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(39, 72).addBox(-1.9853F, -8.7279F, 6.9265F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		chest.setTextureOffset(62, 87).addBox(-11.9853F, -9.7279F, -6.0735F, 1.0F, 8.0F, 10.0F, 0.0F, false);
		chest.setTextureOffset(0, 80).addBox(11.0147F, -9.7279F, -6.0735F, 1.0F, 8.0F, 10.0F, 0.0F, false);
		chest.setTextureOffset(0, 22).addBox(-9.9853F, -11.7279F, -6.0735F, 20.0F, 1.0F, 10.0F, 0.0F, false);

		frontGear = new ModelRenderer(this);
		frontGear.setRotationPoint(0.0147F, -5.7279F, -6.5735F);
		chest.addChild(frontGear);
		frontGear.setTextureOffset(0, 71).addBox(-2.0F, 2.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		frontGear.setTextureOffset(0, 71).addBox(2.0F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		frontGear.setTextureOffset(0, 71).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		frontGear.setTextureOffset(0, 71).addBox(-2.0F, 1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		frontGear.setTextureOffset(0, 71).addBox(-3.0F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		frontGear.setTextureOffset(0, 71).addBox(-2.0F, -3.0F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		frontGear.setTextureOffset(0, 71).addBox(-2.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		frontGear.setTextureOffset(0, 71).addBox(1.0F, 1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		frontGear.setTextureOffset(0, 71).addBox(1.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		backGear = new ModelRenderer(this);
		backGear.setRotationPoint(-0.0238F, -5.3433F, 6.4649F);
		chest.addChild(backGear);
		backGear.setTextureOffset(83, 104).addBox(-0.9615F, 1.6154F, -0.5385F, 2.0F, 13.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(90, 37).addBox(-13.9615F, -1.3846F, -0.5385F, 12.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(88, 46).addBox(1.0385F, -1.3846F, -0.5385F, 13.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(91, 104).addBox(-0.9615F, -14.3846F, -0.5385F, 2.0F, 13.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(50, 25).addBox(-11.9615F, -16.3846F, -0.5385F, 24.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(50, 22).addBox(-11.9615F, 14.6154F, -0.5385F, 24.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(0, 98).addBox(-15.9615F, -12.3846F, -0.5385F, 2.0F, 25.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(24, 59).addBox(14.0385F, -12.3846F, -0.5385F, 2.0F, 25.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(46, 105).addBox(-13.9615F, -14.3846F, -0.5385F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(40, 105).addBox(-13.9615F, 12.6154F, -0.5385F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(34, 105).addBox(12.0385F, 12.6154F, -0.5385F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(28, 105).addBox(12.0385F, -14.3846F, -0.5385F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		backGear.setTextureOffset(12, 24).addBox(-1.9615F, -2.3846F, -1.5385F, 4.0F, 4.0F, 4.0F, 0.0F, false);

		midLefFronPipe = new ModelRenderer(this);
		midLefFronPipe.setRotationPoint(11.0147F, -0.7279F, -4.0735F);
		chest.addChild(midLefFronPipe);
		midLefFronPipe.setTextureOffset(69, 105).addBox(-7.0F, 3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midLefFronPipe.setTextureOffset(73, 105).addBox(-7.0F, 3.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midLefFronPipe.setTextureOffset(77, 105).addBox(-7.0F, 4.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midLefFronPipe.setTextureOffset(74, 95).addBox(-7.0F, 3.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		midLefFronPipe.setTextureOffset(105, 105).addBox(-7.0F, 2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midLefFronPipe.setTextureOffset(65, 105).addBox(-5.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		midLefFronPipe.setTextureOffset(22, 105).addBox(-7.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		midLefFronPipe.setTextureOffset(84, 20).addBox(-6.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		midLefFronPipe.setTextureOffset(80, 33).addBox(-6.0F, 0.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		midLefFronPipe.setTextureOffset(16, 105).addBox(-3.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		midLefBackPipe = new ModelRenderer(this);
		midLefBackPipe.setRotationPoint(7.0147F, -0.7279F, 0.9265F);
		chest.addChild(midLefBackPipe);
		midLefBackPipe.setTextureOffset(14, 105).addBox(-3.0F, 4.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midLefBackPipe.setTextureOffset(104, 34).addBox(-3.0F, 3.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midLefBackPipe.setTextureOffset(92, 8).addBox(-3.0F, 3.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		midLefBackPipe.setTextureOffset(20, 105).addBox(-3.0F, 3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midLefBackPipe.setTextureOffset(102, 79).addBox(-3.0F, 2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midLefBackPipe.setTextureOffset(61, 105).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		midLefBackPipe.setTextureOffset(76, 20).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		midLefBackPipe.setTextureOffset(68, 8).addBox(-2.0F, 0.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		midLefBackPipe.setTextureOffset(104, 102).addBox(1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		midLefBackPipe.setTextureOffset(10, 105).addBox(-3.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		midRightFronPipe = new ModelRenderer(this);
		midRightFronPipe.setRotationPoint(-2.9853F, -0.7279F, -4.0735F);
		chest.addChild(midRightFronPipe);
		midRightFronPipe.setTextureOffset(100, 94).addBox(-2.0F, 4.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midRightFronPipe.setTextureOffset(100, 34).addBox(-2.0F, 3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midRightFronPipe.setTextureOffset(58, 100).addBox(-2.0F, 2.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midRightFronPipe.setTextureOffset(54, 100).addBox(-2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midRightFronPipe.setTextureOffset(12, 88).addBox(-3.0F, 3.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		midRightFronPipe.setTextureOffset(52, 105).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		midRightFronPipe.setTextureOffset(104, 87).addBox(-6.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		midRightFronPipe.setTextureOffset(66, 54).addBox(-5.0F, 0.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		midRightFronPipe.setTextureOffset(104, 90).addBox(-2.0F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		midRightFronPipe.setTextureOffset(16, 65).addBox(-5.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		midRightBackPipe = new ModelRenderer(this);
		midRightBackPipe.setRotationPoint(-2.9853F, -0.7279F, 3.9265F);
		chest.addChild(midRightBackPipe);
		midRightBackPipe.setTextureOffset(50, 100).addBox(-2.0F, 4.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midRightBackPipe.setTextureOffset(99, 65).addBox(-2.0F, 3.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midRightBackPipe.setTextureOffset(4, 80).addBox(-3.0F, 3.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		midRightBackPipe.setTextureOffset(37, 100).addBox(-2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midRightBackPipe.setTextureOffset(34, 99).addBox(-2.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		midRightBackPipe.setTextureOffset(12, 80).addBox(-4.0F, 0.0F, -3.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		midRightBackPipe.setTextureOffset(99, 104).addBox(-2.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		midRightBackPipe.setTextureOffset(16, 63).addBox(-5.0F, 0.0F, -4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		midRightBackPipe.setTextureOffset(104, 79).addBox(-6.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		midRightBackPipe.setTextureOffset(0, 65).addBox(-5.0F, 0.0F, -1.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

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

		topRightShoulderPipe = new ModelRenderer(this);
		topRightShoulderPipe.setRotationPoint(-4.9853F, -12.7279F, 0.9265F);
		chest.addChild(topRightShoulderPipe);
		topRightShoulderPipe.setTextureOffset(96, 87).addBox(-5.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(90, 87).addBox(-4.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(30, 95).addBox(-3.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(96, 90).addBox(0.0F, 0.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(90, 91).addBox(1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(27, 33).addBox(1.0F, -2.0F, -3.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(24, 86).addBox(-4.0F, -2.0F, -3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(4, 83).addBox(-1.0F, -4.0F, -3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(4, 83).addBox(-2.0F, -4.0F, -3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(4, 83).addBox(-1.0F, -4.0F, -3.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(18, 88).addBox(-1.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(18, 88).addBox(-2.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(64, 50).addBox(-3.0F, -3.0F, -3.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(28, 85).addBox(-1.0F, -3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(28, 85).addBox(-2.0F, -3.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(5, 88).addBox(1.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		topRightShoulderPipe.setTextureOffset(84, 28).addBox(-4.0F, 0.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

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
		rightArm.setTextureOffset(52, 54).addBox(-4.0F, -3.0F, -3.0F, 4.0F, 14.0F, 6.0F, 0.0F, false);
		rightArm.setTextureOffset(56, 65).addBox(-1.0F, 11.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightArm.setTextureOffset(56, 65).addBox(-4.0F, 11.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightArm.setTextureOffset(56, 65).addBox(-3.0F, 11.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		rightArm.setTextureOffset(52, 74).addBox(-2.0F, 11.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		rightArm.setTextureOffset(56, 74).addBox(-1.0F, 11.0F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		rightArm.setTextureOffset(56, 74).addBox(-4.0F, 11.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		rightArm.setTextureOffset(94, 50).addBox(-6.0F, -5.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rightArm.setTextureOffset(50, 94).addBox(-5.0F, -5.0F, -5.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		rightArm.setTextureOffset(0, 33).addBox(-7.0F, -5.0F, -3.0F, 2.0F, 5.0F, 6.0F, 0.0F, false);
		rightArm.setTextureOffset(24, 88).addBox(-6.0F, -6.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		rightArm.setTextureOffset(54, 50).addBox(-5.0F, -6.0F, -4.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		rightArm.setTextureOffset(92, 0).addBox(-5.0F, -7.0F, -3.0F, 5.0F, 2.0F, 6.0F, 0.0F, false);
		rightArm.setTextureOffset(56, 8).addBox(-5.0F, -6.0F, 3.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		rightArm.setTextureOffset(46, 54).addBox(-5.0F, -5.0F, 4.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		rightArm.setTextureOffset(92, 0).addBox(-6.0F, -5.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(13.0147F, -4.7279F, -1.0735F);
		chest.addChild(leftArm);
		leftArm.setTextureOffset(32, 54).addBox(-1.0F, -3.0F, -3.0F, 4.0F, 34.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(96, 87).addBox(4.0F, -6.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(96, 14).addBox(-1.0F, -7.0F, -3.0F, 5.0F, 2.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(102, 8).addBox(-1.0F, -5.0F, 4.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(37, 94).addBox(4.0F, -5.0F, 3.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(66, 57).addBox(-1.0F, -6.0F, 3.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(64, 20).addBox(-1.0F, -6.0F, -4.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(100, 28).addBox(-1.0F, -5.0F, -5.0F, 5.0F, 5.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(27, 33).addBox(4.0F, -5.0F, -3.0F, 2.0F, 5.0F, 6.0F, 0.0F, false);
		leftArm.setTextureOffset(96, 60).addBox(4.0F, -5.0F, -4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		hips = new ModelRenderer(this);
		hips.setRotationPoint(0.0F, 2.5F, 0.0F);
		hips.setTextureOffset(84, 87).addBox(3.0F, 0.5F, -5.0F, 1.0F, 7.0F, 10.0F, 0.0F, false);
		hips.setTextureOffset(66, 0).addBox(-4.0F, -0.5F, -5.0F, 8.0F, 1.0F, 10.0F, 0.0F, false);
		hips.setTextureOffset(66, 46).addBox(-3.0F, 7.5F, -5.0F, 6.0F, 1.0F, 10.0F, 0.0F, false);
		hips.setTextureOffset(12, 88).addBox(-4.0F, 0.5F, -5.0F, 1.0F, 7.0F, 10.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(0.0F, 21.5F, 0.0F);
		hips.addChild(rightLeg);
		rightLeg.setTextureOffset(32, 71).addBox(-5.0F, -18.0F, -4.0F, 1.0F, 12.0F, 8.0F, 0.0F, false);
		rightLeg.setTextureOffset(44, 78).addBox(-8.0F, -18.0F, 3.0F, 3.0F, 12.0F, 1.0F, 0.0F, false);
		rightLeg.setTextureOffset(41, 68).addBox(-7.0F, -7.0F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		rightLeg.setTextureOffset(41, 68).addBox(-7.0F, -7.0F, -3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		rightLeg.setTextureOffset(41, 68).addBox(-8.0F, -7.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		rightLeg.setTextureOffset(33, 81).addBox(-8.0F, -19.0F, -3.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);
		rightLeg.setTextureOffset(38, 73).addBox(-8.0F, -18.0F, -4.0F, 3.0F, 12.0F, 1.0F, 0.0F, false);

		tread = new ModelRenderer(this);
		tread.setRotationPoint(-2.0F, -1.0F, -4.0F);
		rightLeg.addChild(tread);
		tread.setTextureOffset(0, 22).addBox(-6.0F, -4.0F, 13.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		tread.setTextureOffset(18, 47).addBox(-5.0F, -5.0F, -5.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		tread.setTextureOffset(5, 34).addBox(-3.0F, -5.0F, -5.0F, 1.0F, 1.0F, 18.0F, 0.0F, false);
		tread.setTextureOffset(0, 27).addBox(-6.0F, -4.0F, -6.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		tread.setTextureOffset(1, 34).addBox(-6.0F, 0.0F, -5.0F, 4.0F, 1.0F, 18.0F, 0.0F, false);
		tread.setTextureOffset(0, 35).addBox(-4.0F, -5.0F, -5.0F, 0.0F, 5.0F, 18.0F, 0.0F, false);
		tread.setTextureOffset(7, 34).addBox(-6.0F, -5.0F, -5.0F, 1.0F, 1.0F, 18.0F, 0.0F, false);
		tread.setTextureOffset(17, 47).addBox(-5.0F, -5.0F, 8.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		tread.setTextureOffset(20, 42).addBox(-4.0F, -17.0F, 3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		tread.setTextureOffset(22, 36).addBox(-4.0F, -16.0F, 2.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);
		tread.setTextureOffset(22, 36).addBox(-4.0F, -16.0F, 5.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);

		legBar = new ModelRenderer(this);
		legBar.setRotationPoint(-6.0F, -8.0F, 0.0F);
		rightLeg.addChild(legBar);
		legBar.setTextureOffset(17, 28).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		frontWheel = new ModelRenderer(this);
		frontWheel.setRotationPoint(-6.0F, -3.0F, -7.0F);
		rightLeg.addChild(frontWheel);
		frontWheel.setTextureOffset(37, 33).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		frontWheel.setTextureOffset(24, 95).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		frontWheel.setTextureOffset(62, 94).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		middleWheel = new ModelRenderer(this);
		middleWheel.setRotationPoint(-6.0F, -3.0F, 0.0F);
		rightLeg.addChild(middleWheel);
		middleWheel.setTextureOffset(37, 33).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		middleWheel.setTextureOffset(24, 95).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		middleWheel.setTextureOffset(62, 94).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		backWheel = new ModelRenderer(this);
		backWheel.setRotationPoint(-6.0F, -3.0F, 7.0F);
		rightLeg.addChild(backWheel);
		backWheel.setTextureOffset(10, 33).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		backWheel.setTextureOffset(24, 91).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		backWheel.setTextureOffset(90, 60).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(4.0F, 4.4091F, -0.0455F);
		hips.addChild(leftLeg);
		leftLeg.setTextureOffset(96, 60).addBox(0.0F, -1.9091F, -3.9545F, 4.0F, 4.0F, 7.0F, 0.0F, false);
		leftLeg.setTextureOffset(34, 94).addBox(0.0F, 13.0909F, -3.9545F, 4.0F, 3.0F, 8.0F, 0.0F, false);
		leftLeg.setTextureOffset(80, 28).addBox(-1.0F, 16.0909F, -3.9545F, 6.0F, 1.0F, 8.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 19).addBox(0.0F, 16.0909F, -4.9545F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 8).addBox(0.0F, 16.0909F, 4.0455F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 11).addBox(1.0F, 7.0909F, -2.9545F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 0).addBox(1.0F, 2.0909F, 1.0455F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		leftLeg.setTextureOffset(27, 44).addBox(0.0F, 4.0909F, -3.9545F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 44).addBox(0.0F, 8.0909F, 0.0455F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		leftLeg.setTextureOffset(16, 59).addBox(1.0F, 2.0909F, -2.9545F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		leftLeg.setTextureOffset(0, 59).addBox(1.0F, 11.0909F, 1.0455F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		lowBarF = new ModelRenderer(this);
		lowBarF.setRotationPoint(-2.0F, 5.5F, 0.0F);
		hips.addChild(lowBarF);
		lowBarF.setTextureOffset(17, 28).addBox(-5.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, 0.0F, false);

		lowBarB = new ModelRenderer(this);
		lowBarB.setRotationPoint(0.0F, 3.5F, -2.0F);
		hips.addChild(lowBarB);
		lowBarB.setTextureOffset(98, 71).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityMalformedAutomaton entity, float limbSwing, float limbSwingAmount,
			float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.head.showModel = true;
		this.neck.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.neck.rotateAngleX = headPitch * ((float) Math.PI / 180F);

		this.leftLeg.rotateAngleX = -1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F) * limbSwingAmount;
		this.leftLeg.rotateAngleY = 0.0F;
		this.backGear.rotateAngleZ = ageInTicks * 0.1f;
		this.frontGear.rotateAngleZ = -ageInTicks * 0.1f;

		this.lowBarB.rotateAngleX = -ageInTicks * 0.1f;
		this.lowBarF.rotateAngleX = ageInTicks * 0.1f;

		this.topBarF.rotateAngleX = ageInTicks * 0.2f;
		this.topBarBottom.rotateAngleX = -ageInTicks * 0.14f;
		this.topBarB.rotateAngleX = ageInTicks * 0.3f;

		this.frontWheel.rotateAngleX = limbSwing * 0.4f;
		this.backWheel.rotateAngleX = limbSwing * 0.4f;
		this.middleWheel.rotateAngleX = limbSwing * 0.4f;
		this.legBar.rotateAngleX = limbSwing * 0.4f;

	}

	@Override
	public void setLivingAnimations(EntityMalformedAutomaton entityIn, float limbSwing, float limbSwingAmount,
			float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
		int i = entityIn.getAttackTimer();
		if (i > 0) {

			this.leftArm.rotateAngleX = -2.0F + 1.5F * MathHelper.func_233021_e_((float) i - partialTick, 10.0F);
		} else {
			int j = entityIn.getAttackTimer();
			if (j > 0) {
				// this.rightArm.rotateAngleX = -0.8F + 0.025F *
				// MathHelper.func_233021_e_((float) j, 70.0F);
				this.leftArm.rotateAngleX = 0.0F;
			} else {
				// this.rightArm.rotateAngleX = (-0.2F + 1.5F *
				// MathHelper.func_233021_e_(limbSwing, 13.0F))* limbSwingAmount;
				this.leftArm.rotateAngleX = (-0.2F - 1.5F * MathHelper.func_233021_e_(limbSwing, 13.0F))
						* limbSwingAmount;
			}

		}

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		neck.render(matrixStack, buffer, packedLight, packedOverlay);
		chest.render(matrixStack, buffer, packedLight, packedOverlay);
		hips.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}