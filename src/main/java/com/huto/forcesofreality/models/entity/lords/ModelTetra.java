package com.huto.forcesofreality.models.entity.lords;

import com.huto.forcesofreality.entities.lords.EntityTetra;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelTetra extends EntityModel<EntityTetra> {
	private final ModelRenderer Head;
	private final ModelRenderer Skull;
	private final ModelRenderer Body;
	private final ModelRenderer leftArm;
	private final ModelRenderer lforeArm;
	private final ModelRenderer lHand;
	private final ModelRenderer rightArm;
	private final ModelRenderer rforeArm;
	private final ModelRenderer rHand;
	private final ModelRenderer steve;
	private final ModelRenderer stRLeg;
	private final ModelRenderer stLLeg;
	private final ModelRenderer stLArm;
	private final ModelRenderer stRArm;
	private final ModelRenderer stHead;
	private final ModelRenderer eye;
	private final ModelRenderer halos;
	private final ModelRenderer halo4;
	private final ModelRenderer halo3;
	private final ModelRenderer halo2;
	private final ModelRenderer halo;
	private final ModelRenderer bone5;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone6;
	private final ModelRenderer lowerHalf;
	private final ModelRenderer bottomHalf;
	private final ModelRenderer wheel;
	private final ModelRenderer LeftWing;
	private final ModelRenderer Limb3;
	private final ModelRenderer Limb1;
	private final ModelRenderer RightWing;
	private final ModelRenderer Limb2;
	private final ModelRenderer Limb4;
	private final ModelRenderer LeftWing3;
	private final ModelRenderer Limb9;
	private final ModelRenderer Limb10;
	private final ModelRenderer RightWing3;
	private final ModelRenderer Limb11;
	private final ModelRenderer Limb12;
	private final ModelRenderer RightWing4;
	private final ModelRenderer Limb13;
	private final ModelRenderer Limb14;
	private final ModelRenderer RightWing5;
	private final ModelRenderer Limb15;
	private final ModelRenderer Limb16;
	private final ModelRenderer LeftWing4;
	private final ModelRenderer Limb17;
	private final ModelRenderer Limb18;
	private final ModelRenderer LeftWing5;
	private final ModelRenderer Limb19;
	private final ModelRenderer Limb20;
	private final ModelRenderer RightWing2;
	private final ModelRenderer Limb5;
	private final ModelRenderer Limb6;
	private final ModelRenderer LeftWing2;
	private final ModelRenderer Limb7;
	private final ModelRenderer Limb8;

	public ModelTetra() {
		textureWidth = 256;
		textureHeight = 256;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, -0.5F);

		Skull = new ModelRenderer(this);
		Skull.setRotationPoint(0.0F, -7.0F, 0.5F);
		Head.addChild(Skull);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(48, 16).addBox(-3.0F, -11.0F, 0.0F, 7.0F, 6.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(0, 8).addBox(-3.0F, -5.0F, -3.0F, 7.0F, 2.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(88, 32).addBox(4.0F, -11.0F, -3.0F, 2.0F, 6.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(72, 32).addBox(-5.0F, -11.0F, -3.0F, 2.0F, 6.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-3.0F, -13.0F, -3.0F, 7.0F, 2.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(0, 91).addBox(4.0F, -12.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(82, 76).addBox(4.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(0, 84).addBox(-4.0F, -12.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(96, 76).addBox(-4.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(0, 76).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 3.0F, 0.0F, false);
		Body.setTextureOffset(26, 136).addBox(-2.0F, -3.0F, -0.1F, 4.0F, 6.0F, 0.0F, 0.0F, false);
		Body.setTextureOffset(26, 136).addBox(-1.0F, 3.0F, -0.1F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		Body.setTextureOffset(24, 170).addBox(-2.1F, -2.3F, -1.0F, 0.0F, 5.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(22, 170).addBox(2.1F, -2.3F, -1.0F, 0.0F, 5.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(4, 183).addBox(-0.5F, 3.3F, -0.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 183).addBox(-2.0F, 1.6F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(44, 181).addBox(1.0F, -2.0F, -0.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(44, 179).addBox(-2.0F, -2.0F, -0.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(40, 181).addBox(-2.0F, 0.0F, -0.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(40, 179).addBox(1.0F, 0.0F, -0.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(36, 181).addBox(-0.5F, -1.0F, -0.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(36, 179).addBox(-0.5F, 1.0F, -0.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 173).addBox(-0.5F, -3.0F, -1.1F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(48, 179).addBox(1.0F, 1.6F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 44).addBox(-4.0F, 1.0F, 0.0F, 8.0F, 3.0F, 3.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(7.5F, -9.0F, 0.0F);
		Body.addChild(leftArm);
		leftArm.setTextureOffset(66, 76).addBox(0.5F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		leftArm.setTextureOffset(6, 173).addBox(1.5F, -0.6F, -2.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(6, 170).addBox(1.5F, -0.6F, 1.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		leftArm.setTextureOffset(50, 164).addBox(4.0F, -0.6F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		leftArm.setTextureOffset(44, 164).addBox(0.0F, -0.6F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		leftArm.setTextureOffset(64, 161).addBox(1.5F, -2.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		leftArm.setTextureOffset(64, 158).addBox(1.5F, 1.4F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		lforeArm = new ModelRenderer(this);
		lforeArm.setRotationPoint(3.0F, 2.5F, 0.0F);
		leftArm.addChild(lforeArm);
		lforeArm.setTextureOffset(4, 138).addBox(-0.2F, 0.8F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		lforeArm.setTextureOffset(36, 148).addBox(-1.7F, 1.8F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		lforeArm.setTextureOffset(46, 148).addBox(0.1F, -0.1F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		lforeArm.setTextureOffset(40, 148).addBox(-2.0F, -0.1F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		lHand = new ModelRenderer(this);
		lHand.setRotationPoint(-0.5F, 5.5F, 0.5F);
		lforeArm.addChild(lHand);
		lHand.setTextureOffset(42, 173).addBox(-0.6F, 4.4F, -2.4F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		lHand.setTextureOffset(26, 170).addBox(0.7F, 4.4F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		lHand.setTextureOffset(46, 170).addBox(0.9F, 4.4F, -1.1F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		lHand.setTextureOffset(36, 148).addBox(-1.2F, -0.7F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		lHand.setTextureOffset(4, 138).addBox(0.3F, -0.7F, -1.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		lHand.setTextureOffset(8, 127).addBox(-1.0F, -0.6F, -1.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		lHand.setTextureOffset(0, 176).addBox(0.6F, 4.4F, -0.1F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-6.5F, -9.0F, 0.0F);
		Body.addChild(rightArm);
		rightArm.setTextureOffset(50, 76).addBox(-4.5F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		rightArm.setTextureOffset(56, 167).addBox(-3.5F, -0.6F, -2.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		rightArm.setTextureOffset(56, 164).addBox(-3.5F, -0.6F, 1.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		rightArm.setTextureOffset(38, 164).addBox(-1.0F, -0.6F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		rightArm.setTextureOffset(32, 164).addBox(-5.0F, -0.6F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		rightArm.setTextureOffset(56, 161).addBox(-3.5F, -2.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		rightArm.setTextureOffset(56, 158).addBox(-3.5F, 1.4F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		rforeArm = new ModelRenderer(this);
		rforeArm.setRotationPoint(-3.0F, 2.5F, 0.0F);
		rightArm.addChild(rforeArm);
		rforeArm.setTextureOffset(32, 148).addBox(0.8F, 1.8F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		rforeArm.setTextureOffset(0, 138).addBox(-0.7F, 0.8F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		rforeArm.setTextureOffset(26, 148).addBox(1.1F, -0.1F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		rforeArm.setTextureOffset(20, 148).addBox(-1.0F, -0.1F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		rHand = new ModelRenderer(this);
		rHand.setRotationPoint(0.5F, 5.0F, 0.0F);
		rforeArm.addChild(rHand);
		rHand.setTextureOffset(0, 138).addBox(-1.2F, -0.2F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rHand.setTextureOffset(32, 148).addBox(0.3F, -0.2F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rHand.setTextureOffset(34, 170).addBox(-0.3F, 4.9F, -1.9F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		rHand.setTextureOffset(18, 170).addBox(-1.6F, 4.9F, -1.6F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		rHand.setTextureOffset(30, 173).addBox(-1.9F, 4.9F, -0.6F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		rHand.setTextureOffset(0, 127).addBox(-1.0F, -0.1F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		rHand.setTextureOffset(30, 170).addBox(-1.8F, 4.9F, 0.4F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		steve = new ModelRenderer(this);
		steve.setRotationPoint(0.4875F, -2.25F, 0.475F);
		Body.addChild(steve);
		steve.setTextureOffset(0, 170).addBox(-0.9875F, -6.75F, -1.475F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		stRLeg = new ModelRenderer(this);
		stRLeg.setRotationPoint(-0.4875F, -4.75F, -0.875F);
		steve.addChild(stRLeg);
		stRLeg.setTextureOffset(38, 173).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		stLLeg = new ModelRenderer(this);
		stLLeg.setRotationPoint(0.5125F, -4.75F, -0.875F);
		steve.addChild(stLLeg);
		stLLeg.setTextureOffset(34, 173).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		stLArm = new ModelRenderer(this);
		stLArm.setRotationPoint(1.0125F, -6.55F, -0.875F);
		steve.addChild(stLArm);
		stLArm.setTextureOffset(42, 170).addBox(-0.2F, -0.2F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		stRArm = new ModelRenderer(this);
		stRArm.setRotationPoint(-0.8875F, -6.55F, -0.875F);
		steve.addChild(stRArm);
		stRArm.setTextureOffset(38, 170).addBox(-1.0F, -0.2F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		stHead = new ModelRenderer(this);
		stHead.setRotationPoint(0.0125F, -6.75F, -0.975F);
		steve.addChild(stHead);
		stHead.setTextureOffset(62, 164).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		eye = new ModelRenderer(this);
		eye.setRotationPoint(0.0F, -11.5F, 1.0F);
		stHead.addChild(eye);
		eye.setTextureOffset(28, 101).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		halos = new ModelRenderer(this);
		halos.setRotationPoint(1.0F, -20.0F, 0.0F);
		Body.addChild(halos);
		setRotationAngle(halos, 0.0F, -1.5708F, 0.0F);

		halo4 = new ModelRenderer(this);
		halo4.setRotationPoint(0.5F, -0.7645F, 0.7F);
		halos.addChild(halo4);
		setRotationAngle(halo4, 2.3562F, 0.0F, 0.0F);
		halo4.setTextureOffset(16, 123).addBox(-2.5F, 3.5F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		halo4.setTextureOffset(60, 176).addBox(2.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo4.setTextureOffset(56, 176).addBox(3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo4.setTextureOffset(14, 158).addBox(3.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		halo4.setTextureOffset(52, 176).addBox(3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo4.setTextureOffset(16, 120).addBox(-2.5F, -5.5F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		halo4.setTextureOffset(48, 176).addBox(2.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo4.setTextureOffset(44, 176).addBox(-3.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo4.setTextureOffset(40, 176).addBox(-4.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo4.setTextureOffset(8, 158).addBox(-5.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		halo4.setTextureOffset(36, 176).addBox(-4.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo4.setTextureOffset(32, 176).addBox(-3.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		halo3 = new ModelRenderer(this);
		halo3.setRotationPoint(0.5F, -0.5355F, 0.4355F);
		halos.addChild(halo3);
		setRotationAngle(halo3, 0.7854F, 0.0F, 0.0F);
		halo3.setTextureOffset(28, 123).addBox(-2.5F, 3.5F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		halo3.setTextureOffset(92, 176).addBox(2.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo3.setTextureOffset(88, 176).addBox(3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo3.setTextureOffset(26, 158).addBox(3.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		halo3.setTextureOffset(84, 176).addBox(3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo3.setTextureOffset(28, 120).addBox(-2.5F, -5.5F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		halo3.setTextureOffset(80, 176).addBox(2.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo3.setTextureOffset(76, 176).addBox(-3.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo3.setTextureOffset(72, 176).addBox(-4.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo3.setTextureOffset(20, 158).addBox(-5.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		halo3.setTextureOffset(68, 176).addBox(-4.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo3.setTextureOffset(64, 176).addBox(-3.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		halo2 = new ModelRenderer(this);
		halo2.setRotationPoint(0.5F, -0.5F, 0.5F);
		halos.addChild(halo2);
		setRotationAngle(halo2, 1.5708F, 0.0F, 0.0F);
		halo2.setTextureOffset(40, 123).addBox(-2.5F, 3.5F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		halo2.setTextureOffset(12, 181).addBox(2.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo2.setTextureOffset(12, 179).addBox(3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo2.setTextureOffset(38, 158).addBox(3.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		halo2.setTextureOffset(8, 181).addBox(3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo2.setTextureOffset(40, 120).addBox(-2.5F, -5.5F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		halo2.setTextureOffset(8, 179).addBox(2.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo2.setTextureOffset(4, 181).addBox(-3.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo2.setTextureOffset(4, 179).addBox(-4.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo2.setTextureOffset(32, 158).addBox(-5.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		halo2.setTextureOffset(0, 181).addBox(-4.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo2.setTextureOffset(0, 179).addBox(-3.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		halo = new ModelRenderer(this);
		halo.setRotationPoint(0.5F, -0.5F, 0.5F);
		halos.addChild(halo);
		halo.setTextureOffset(52, 123).addBox(-2.5F, 3.5F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		halo.setTextureOffset(28, 179).addBox(2.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo.setTextureOffset(16, 179).addBox(3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo.setTextureOffset(50, 158).addBox(3.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		halo.setTextureOffset(16, 181).addBox(3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo.setTextureOffset(52, 120).addBox(-2.5F, -5.5F, -0.5F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		halo.setTextureOffset(28, 181).addBox(2.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo.setTextureOffset(24, 181).addBox(-3.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo.setTextureOffset(20, 179).addBox(-4.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo.setTextureOffset(44, 158).addBox(-5.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		halo.setTextureOffset(20, 181).addBox(-4.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		halo.setTextureOffset(24, 179).addBox(-3.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-1.0F, 2.2F, -0.5F);
		Body.addChild(bone5);
		setRotationAngle(bone5, 0.0F, 0.0F, -2.0508F);
		bone5.setTextureOffset(34, 179).addBox(4.453F, 1.1327F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(1.3233F, 8.2455F, -0.5F);
		Body.addChild(bone7);
		setRotationAngle(bone7, 0.0F, 0.0F, -2.2602F);
		bone7.setTextureOffset(14, 183).addBox(3.781F, 2.1168F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(1.3233F, 8.2455F, -0.5F);
		Body.addChild(bone8);
		setRotationAngle(bone8, 0.0F, 0.0F, 2.2602F);
		bone8.setTextureOffset(12, 183).addBox(-2.1407F, 4.1366F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.5F, 1.9F, -0.5F);
		Body.addChild(bone6);
		setRotationAngle(bone6, 0.0F, 0.0F, -1.0908F);
		bone6.setTextureOffset(32, 179).addBox(4.453F, -3.4848F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		lowerHalf = new ModelRenderer(this);
		lowerHalf.setRotationPoint(-0.0333F, 3.9667F, 1.0533F);
		Body.addChild(lowerHalf);
		lowerHalf.setTextureOffset(12, 164).addBox(-2.9667F, 3.0333F, 1.2467F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		lowerHalf.setTextureOffset(8, 164).addBox(2.0333F, 3.0333F, 1.2467F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		lowerHalf.setTextureOffset(34, 76).addBox(-4.9667F, 0.0333F, -2.0533F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		lowerHalf.setTextureOffset(20, 176).addBox(-5.4667F, 1.0333F, -0.0533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lowerHalf.setTextureOffset(24, 176).addBox(-2.4667F, 1.0333F, -0.0533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lowerHalf.setTextureOffset(18, 76).addBox(2.0333F, 0.0333F, -2.0533F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		lowerHalf.setTextureOffset(28, 176).addBox(1.5333F, 1.0333F, -0.0533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lowerHalf.setTextureOffset(8, 183).addBox(4.5333F, 1.0333F, -0.0533F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lowerHalf.setTextureOffset(16, 109).addBox(1.0333F, 3.0333F, -1.0533F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		lowerHalf.setTextureOffset(0, 164).addBox(2.0333F, 3.0333F, -1.3533F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		lowerHalf.setTextureOffset(16, 101).addBox(-3.9667F, 3.0333F, -1.0533F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		lowerHalf.setTextureOffset(4, 164).addBox(-2.9667F, 3.0333F, -1.3533F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bottomHalf = new ModelRenderer(this);
		bottomHalf.setRotationPoint(0.0333F, 8.1444F, 0.28F);
		lowerHalf.addChild(bottomHalf);
		bottomHalf.setTextureOffset(8, 120).addBox(-3.0F, -0.1111F, -1.3333F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		bottomHalf.setTextureOffset(0, 120).addBox(2.0F, -0.1111F, -1.3333F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		bottomHalf.setTextureOffset(4, 109).addBox(1.0F, 3.8889F, -1.3333F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bottomHalf.setTextureOffset(28, 164).addBox(2.0F, 3.8889F, -1.6333F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		bottomHalf.setTextureOffset(4, 101).addBox(-4.0F, 3.8889F, -1.3333F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bottomHalf.setTextureOffset(24, 164).addBox(-3.0F, 3.8889F, -1.6333F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		bottomHalf.setTextureOffset(16, 164).addBox(2.0F, 3.8889F, 0.9667F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		bottomHalf.setTextureOffset(20, 164).addBox(-3.0F, 3.8889F, 0.9667F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		wheel = new ModelRenderer(this);
		wheel.setRotationPoint(0.0F, 9.8889F, 0.1667F);
		bottomHalf.addChild(wheel);
		wheel.setTextureOffset(4, 176).addBox(1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		wheel.setTextureOffset(4, 176).addBox(1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		wheel.setTextureOffset(4, 176).addBox(-2.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		wheel.setTextureOffset(4, 176).addBox(-2.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		wheel.setTextureOffset(4, 176).addBox(1.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		wheel.setTextureOffset(12, 176).addBox(-1.0F, 1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		wheel.setTextureOffset(8, 176).addBox(-3.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		wheel.setTextureOffset(0, 158).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wheel.setTextureOffset(16, 176).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(4.0F, -6.0F, 4.5F);
		setRotationAngle(LeftWing, 0.2618F, 0.1745F, -2.7925F);
		LeftWing.setTextureOffset(16, 148).addBox(1.1684F, -1.3494F, -1.1676F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		LeftWing.setTextureOffset(54, 32).addBox(-6.8316F, -1.3494F, -0.1676F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb3 = new ModelRenderer(this);
		Limb3.setRotationPoint(-5.6084F, -1.8148F, 3.0599F);
		LeftWing.addChild(Limb3);
		setRotationAngle(Limb3, 0.0F, 0.0F, -1.6581F);

		Limb1 = new ModelRenderer(this);
		Limb1.setRotationPoint(-8.6084F, 7.6852F, 2.5599F);
		LeftWing.addChild(Limb1);
		setRotationAngle(Limb1, 0.0F, 0.0F, 0.5672F);
		Limb1.setTextureOffset(0, 101).addBox(9.1451F, -4.1325F, -3.7275F, 1.0F, 16.0F, 1.0F, 0.0F, false);
		Limb1.setTextureOffset(126, 118).addBox(3.1451F, 11.8675F, -3.7275F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb1.setTextureOffset(32, 16).addBox(2.1451F, -4.1325F, -2.7249F, 8.0F, 16.0F, 0.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-4.0F, -6.0F, 7.5F);
		setRotationAngle(RightWing, 0.3491F, -0.1745F, 2.7925F);
		RightWing.setTextureOffset(8, 148).addBox(-1.7768F, -2.6064F, -3.8632F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		RightWing.setTextureOffset(48, 55).addBox(-1.7768F, -2.6064F, -2.8632F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb2 = new ModelRenderer(this);
		Limb2.setRotationPoint(10.1684F, 6.0242F, 0.9344F);
		RightWing.addChild(Limb2);
		setRotationAngle(Limb2, 0.0F, 0.0F, -0.5672F);
		Limb2.setTextureOffset(26, 84).addBox(-11.3476F, -4.4195F, -4.7977F, 1.0F, 16.0F, 1.0F, 0.0F, false);
		Limb2.setTextureOffset(98, 118).addBox(-10.3476F, 11.5805F, -4.7977F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb2.setTextureOffset(0, 16).addBox(-11.3476F, -4.4195F, -3.7951F, 8.0F, 16.0F, 0.0F, 0.0F, false);

		Limb4 = new ModelRenderer(this);
		Limb4.setRotationPoint(14.0F, -3.0718F, 0.3642F);
		RightWing.addChild(Limb4);
		setRotationAngle(Limb4, 0.0F, 0.0F, -1.6581F);

		LeftWing3 = new ModelRenderer(this);
		LeftWing3.setRotationPoint(4.0F, -7.0F, 1.5F);
		setRotationAngle(LeftWing3, 0.2181F, 0.3055F, 2.8798F);
		LeftWing3.setTextureOffset(0, 148).addBox(-0.432F, 0.3539F, -0.7741F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		LeftWing3.setTextureOffset(18, 32).addBox(-8.432F, -1.6461F, 0.2259F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb9 = new ModelRenderer(this);
		Limb9.setRotationPoint(1.7843F, -5.1633F, 3.3432F);
		LeftWing3.addChild(Limb9);
		setRotationAngle(Limb9, 0.0F, 0.0F, -1.6581F);

		Limb10 = new ModelRenderer(this);
		Limb10.setRotationPoint(-1.2157F, 4.3367F, 2.8432F);
		LeftWing3.addChild(Limb10);
		setRotationAngle(Limb10, 0.0F, 0.0F, 0.5672F);
		Limb10.setTextureOffset(44, 127).addBox(3.1999F, 3.2732F, -3.6172F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb10.setTextureOffset(84, 118).addBox(-2.8001F, 13.2732F, -3.6172F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb10.setTextureOffset(80, 66).addBox(-3.8001F, 3.2732F, -2.6146F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		RightWing3 = new ModelRenderer(this);
		RightWing3.setRotationPoint(-4.0F, -7.0F, 1.5F);
		setRotationAngle(RightWing3, 0.2181F, -0.48F, -2.8798F);
		RightWing3.setTextureOffset(28, 138).addBox(-0.568F, 0.3539F, -0.7741F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing3.setTextureOffset(16, 55).addBox(-0.568F, -1.6461F, 0.2259F, 8.0F, 11.0F, 0.0F, 0.0F, false);
		RightWing3.setTextureOffset(0, 55).addBox(-0.568F, -1.6461F, 0.2259F, 8.0F, 11.0F, 0.0F, 0.0F, false);
		RightWing3.setTextureOffset(70, 44).addBox(-0.568F, -1.6461F, 0.2259F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb11 = new ModelRenderer(this);
		Limb11.setRotationPoint(2.384F, 3.9327F, 3.9133F);
		RightWing3.addChild(Limb11);
		setRotationAngle(Limb11, 0.0F, 0.0F, -0.5672F);
		Limb11.setTextureOffset(28, 127).addBox(-5.4023F, 2.9862F, -4.6874F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb11.setTextureOffset(28, 118).addBox(-4.4023F, 12.9862F, -4.6874F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb11.setTextureOffset(64, 66).addBox(-5.4023F, 2.9862F, -3.6848F, 8.0F, 10.0F, 0.0F, 0.0F, false);
		Limb11.setTextureOffset(48, 66).addBox(-5.4023F, 2.9862F, -3.6848F, 8.0F, 10.0F, 0.0F, 0.0F, false);
		Limb11.setTextureOffset(16, 66).addBox(-5.4023F, 2.9862F, -3.6848F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		Limb12 = new ModelRenderer(this);
		Limb12.setRotationPoint(6.2156F, -5.1633F, 3.3431F);
		RightWing3.addChild(Limb12);
		setRotationAngle(Limb12, 0.0F, 0.0F, -1.6581F);

		RightWing4 = new ModelRenderer(this);
		RightWing4.setRotationPoint(-2.1F, -7.6F, 3.5F);
		setRotationAngle(RightWing4, 0.3054F, 0.1309F, 1.3963F);
		RightWing4.setTextureOffset(20, 138).addBox(-1.049F, 1.3866F, -1.1107F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing4.setTextureOffset(38, 44).addBox(-1.049F, -0.6134F, -0.1107F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb13 = new ModelRenderer(this);
		Limb13.setRotationPoint(13.6496F, 16.0783F, 0.5659F);
		RightWing4.addChild(Limb13);
		setRotationAngle(Limb13, 0.0F, 0.0F, -0.5672F);
		Limb13.setTextureOffset(18, 84).addBox(-9.3387F, -12.6976F, -1.6766F, 1.0F, 16.0F, 1.0F, 0.0F, false);
		Limb13.setTextureOffset(14, 118).addBox(-8.3387F, 3.3024F, -1.6766F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb13.setTextureOffset(42, 0).addBox(-9.3387F, -12.6976F, -0.674F, 8.0F, 16.0F, 0.0F, 0.0F, false);

		Limb14 = new ModelRenderer(this);
		Limb14.setRotationPoint(17.4812F, 6.9823F, -0.0043F);
		RightWing4.addChild(Limb14);
		setRotationAngle(Limb14, 0.0F, 0.0F, -1.6581F);

		RightWing5 = new ModelRenderer(this);
		RightWing5.setRotationPoint(-2.0F, -3.0F, 2.2F);
		setRotationAngle(RightWing5, 0.4363F, 0.1309F, 0.7854F);
		RightWing5.setTextureOffset(16, 138).addBox(-2.9202F, 0.1673F, -0.3876F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		RightWing5.setTextureOffset(22, 44).addBox(-2.9202F, 0.1673F, 0.6124F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb15 = new ModelRenderer(this);
		Limb15.setRotationPoint(5.3095F, 18.1389F, 0.1441F);
		RightWing5.addChild(Limb15);
		setRotationAngle(Limb15, 0.0F, 0.0F, -0.5672F);
		Limb15.setTextureOffset(20, 127).addBox(-3.1953F, -10.3015F, -0.5318F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb15.setTextureOffset(0, 118).addBox(-2.1953F, -0.3015F, -0.5318F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb15.setTextureOffset(80, 55).addBox(-3.1953F, -10.3015F, 0.4708F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		Limb16 = new ModelRenderer(this);
		Limb16.setRotationPoint(9.1411F, 9.0429F, -0.4261F);
		RightWing5.addChild(Limb16);
		setRotationAngle(Limb16, 0.0F, 0.0F, -1.6581F);

		LeftWing4 = new ModelRenderer(this);
		LeftWing4.setRotationPoint(2.0F, -7.0F, 2.5F);
		setRotationAngle(LeftWing4, 0.2182F, 0.0873F, -1.3963F);
		LeftWing4.setTextureOffset(12, 138).addBox(0.8287F, 1.3005F, -0.3395F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		LeftWing4.setTextureOffset(0, 32).addBox(-7.1713F, -0.6995F, 0.6605F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb17 = new ModelRenderer(this);
		Limb17.setRotationPoint(-8.6579F, 6.7193F, 0.4559F);
		LeftWing4.addChild(Limb17);
		setRotationAngle(Limb17, 0.0F, 0.0F, -1.6581F);

		Limb18 = new ModelRenderer(this);
		Limb18.setRotationPoint(-11.6579F, 16.2193F, -0.0441F);
		LeftWing4.addChild(Limb18);
		setRotationAngle(Limb18, 0.0F, 0.0F, 0.5672F);
		Limb18.setTextureOffset(14, 84).addBox(7.1945F, -12.238F, -0.2954F, 1.0F, 16.0F, 1.0F, 0.0F, false);
		Limb18.setTextureOffset(28, 109).addBox(1.1945F, 3.762F, -0.2954F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb18.setTextureOffset(26, 0).addBox(0.1945F, -12.238F, 0.7072F, 8.0F, 16.0F, 0.0F, 0.0F, false);

		LeftWing5 = new ModelRenderer(this);
		LeftWing5.setRotationPoint(4.0F, -3.0F, 2.2F);
		setRotationAngle(LeftWing5, 0.4364F, -0.1309F, -0.7854F);
		LeftWing5.setTextureOffset(8, 138).addBox(1.4783F, -0.443F, 0.0291F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		LeftWing5.setTextureOffset(68, 16).addBox(-6.5217F, -0.443F, 1.0291F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb19 = new ModelRenderer(this);
		Limb19.setRotationPoint(-1.583F, 8.4486F, 0.1358F);
		LeftWing5.addChild(Limb19);
		setRotationAngle(Limb19, 0.0F, 0.0F, -1.6581F);

		Limb20 = new ModelRenderer(this);
		Limb20.setRotationPoint(-4.583F, 17.9486F, -0.3642F);
		LeftWing5.addChild(Limb20);
		setRotationAngle(Limb20, 0.0F, 0.0F, 0.5672F);
		Limb20.setTextureOffset(16, 127).addBox(0.9841F, -10.028F, 0.3933F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb20.setTextureOffset(28, 107).addBox(-5.0159F, -0.028F, 0.3933F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb20.setTextureOffset(64, 55).addBox(-6.0159F, -10.028F, 1.3959F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		RightWing2 = new ModelRenderer(this);
		RightWing2.setRotationPoint(-4.0F, -6.0F, 7.5F);
		setRotationAngle(RightWing2, 0.4363F, 0.1309F, 2.0944F);
		RightWing2.setTextureOffset(8, 148).addBox(-1.7768F, -2.6064F, -3.8632F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		RightWing2.setTextureOffset(48, 55).addBox(-1.7768F, -2.6064F, -2.8632F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb5 = new ModelRenderer(this);
		Limb5.setRotationPoint(10.1684F, 6.0242F, 0.9344F);
		RightWing2.addChild(Limb5);
		setRotationAngle(Limb5, 0.0F, 0.0F, -0.5672F);
		Limb5.setTextureOffset(26, 84).addBox(-11.3476F, -4.4195F, -4.7977F, 1.0F, 16.0F, 1.0F, 0.0F, false);
		Limb5.setTextureOffset(98, 118).addBox(-10.3476F, 11.5805F, -4.7977F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb5.setTextureOffset(0, 16).addBox(-11.3476F, -4.4195F, -3.7951F, 8.0F, 16.0F, 0.0F, 0.0F, false);

		Limb6 = new ModelRenderer(this);
		Limb6.setRotationPoint(14.0F, -3.0718F, 0.3642F);
		RightWing2.addChild(Limb6);
		setRotationAngle(Limb6, 0.0F, 0.0F, -1.6581F);

		LeftWing2 = new ModelRenderer(this);
		LeftWing2.setRotationPoint(4.0F, -6.0F, 4.5F);
		setRotationAngle(LeftWing2, 0.2182F, 0.1309F, -2.0944F);
		LeftWing2.setTextureOffset(16, 148).addBox(1.1684F, -1.3494F, -1.1676F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		LeftWing2.setTextureOffset(54, 32).addBox(-6.8316F, -1.3494F, -0.1676F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb7 = new ModelRenderer(this);
		Limb7.setRotationPoint(-5.6084F, -1.8148F, 3.0599F);
		LeftWing2.addChild(Limb7);
		setRotationAngle(Limb7, 0.0F, 0.0F, -1.6581F);

		Limb8 = new ModelRenderer(this);
		Limb8.setRotationPoint(-8.6084F, 7.6852F, 2.5599F);
		LeftWing2.addChild(Limb8);
		setRotationAngle(Limb8, 0.0F, 0.0F, 0.5672F);
		Limb8.setTextureOffset(0, 101).addBox(9.1451F, -4.1325F, -3.7275F, 1.0F, 16.0F, 1.0F, 0.0F, false);
		Limb8.setTextureOffset(126, 118).addBox(3.1451F, 11.8675F, -3.7275F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb8.setTextureOffset(32, 16).addBox(2.1451F, -4.1325F, -2.7249F, 8.0F, 16.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityTetra entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		float f = MathHelper.lerp(0, entity.oFlap, entity.wingRotation);
		float f1 = MathHelper.lerp(0, entity.oFlapSpeed, entity.destPos);
		float f3 = (MathHelper.sin(f) + 1.6F) * f1;

		// Mini Steve
		this.stHead.rotateAngleX = headPitch * ((float) Math.PI / 180F) * 0.5f;
		this.stHead.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) * 0.5f;
		this.stRArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount
				* 0.5F;
		this.stLArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.stRLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.stLLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

		this.eye.rotateAngleX = headPitch * ((float) Math.PI / 180F) * 0.5f;
		this.eye.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F) * 0.5f;

		this.halos.rotateAngleX += ageInTicks * 0.002f;
		this.halo.rotateAngleX += -ageInTicks * 0.002f;
		this.halo2.rotateAngleX += ageInTicks * 0.002f;
		this.halo3.rotateAngleX = -ageInTicks * 0.002f;
		this.halo4.rotateAngleX = -ageInTicks * 0.002f;
		this.halos.rotateAngleY += ageInTicks * 0.002f;
		this.halo.rotateAngleY += ageInTicks * 0.002f;
		this.halo2.rotateAngleY += -ageInTicks * 0.002f;
		this.halo3.rotateAngleY = ageInTicks * 0.002f;
		this.halo4.rotateAngleY = ageInTicks * 0.002f;
		this.halos.rotateAngleZ += -ageInTicks * 0.002f;
		this.halo.rotateAngleZ += ageInTicks * 0.002f;
		this.halo2.rotateAngleZ += -ageInTicks * 0.002f;
		this.halo3.rotateAngleZ += ageInTicks * 0.002f;
		this.halo4.rotateAngleZ += -ageInTicks * 0.002f;

		this.leftArm.rotateAngleX = MathHelper.sin(limbSwing * 0.1662F + (float) Math.PI) * 1.2F * limbSwingAmount;
		this.rightArm.rotateAngleX = -MathHelper.cos(limbSwing * 0.1662F) * 1.2F * limbSwingAmount;

		this.rforeArm.rotateAngleX = MathHelper.sin(limbSwing * 0.1662F + (float) Math.PI) * 1.2F * limbSwingAmount;
		this.lforeArm.rotateAngleX = MathHelper.cos(limbSwing * 0.1662F) * 1.2F * limbSwingAmount;

		this.lHand.rotateAngleX = -Math
				.abs(MathHelper.sin(limbSwing * 0.1662F + (float) Math.PI) * 1.2F * limbSwingAmount);
		this.rHand.rotateAngleX = -Math.abs(MathHelper.cos(limbSwing * 0.1662F) * 1.2F * limbSwingAmount);

		this.lowerHalf.rotateAngleX = MathHelper.sin(limbSwing * 0.1662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		this.bottomHalf.rotateAngleX = Math
				.abs(MathHelper.sin(limbSwing * 0.1662F + (float) Math.PI) * 1.2F * limbSwingAmount);

		this.RightWing.rotateAngleZ = f3 * 1.0f;
		this.LeftWing.rotateAngleZ = -f3 * 1.0f;
		this.RightWing2.rotateAngleZ = f3 * 0.8f;
		this.LeftWing2.rotateAngleZ = -f3 * 0.8f;
		this.RightWing3.rotateAngleZ = f3 * 0.65f;
		this.LeftWing3.rotateAngleZ = -f3 * 0.65f;
		this.RightWing4.rotateAngleZ = f3 * 0.4f;
		this.LeftWing4.rotateAngleZ = -f3 * 0.4f;
		this.RightWing5.rotateAngleZ = f3 * 0.15f;
		this.LeftWing5.rotateAngleZ = -f3 * 0.15f;

		this.wheel.rotateAngleZ += ageInTicks * 0.012f;

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing3.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing3.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing4.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing5.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing4.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing5.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing2.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}