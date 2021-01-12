package com.huto.forcesofreality.models.entity.lords;

import com.huto.forcesofreality.entities.lords.EntityTetra;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


public class ModelTetra extends EntityModel<EntityTetra> {
	private final ModelRenderer Head;
	private final ModelRenderer Skull;
	private final ModelRenderer Body;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer Bib;
	private final ModelRenderer r;
	private final ModelRenderer l;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightFore;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftFore;
	private final ModelRenderer LeftWing;
	private final ModelRenderer Limb3;
	private final ModelRenderer Limb1;
	private final ModelRenderer LeftWing2;
	private final ModelRenderer Limb7;
	private final ModelRenderer Limb8;
	private final ModelRenderer RightWing;
	private final ModelRenderer Limb2;
	private final ModelRenderer Limb4;
	private final ModelRenderer RightWing2;
	private final ModelRenderer Limb5;
	private final ModelRenderer Limb6;
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

	public ModelTetra() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, -0.5F);
		

		Skull = new ModelRenderer(this);
		Skull.setRotationPoint(0.0F, -7.0F, 0.5F);
		Head.addChild(Skull);
		

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(1, 0).addBox(-3.0F, -1.0F, -2.0F, 6.0F, 8.0F, 5.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-4.4F, 8.5F, 0.0F);
		Body.addChild(bone);
		setRotationAngle(bone, 0.0F, 0.0F, -0.7854F);
		bone.setTextureOffset(0, 6).addBox(-13.0F, -1.5F, 0.0F, 16.0F, 3.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(4.6F, 8.5F, 0.0F);
		Body.addChild(bone2);
		setRotationAngle(bone2, 0.0F, 0.0F, 0.7854F);
		bone2.setTextureOffset(0, 6).addBox(-3.0F, -1.5F, 0.0F, 16.0F, 3.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(4.6F, -1.5F, 0.0F);
		Body.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.0F, -0.7854F);
		bone3.setTextureOffset(0, 6).addBox(-3.0F, -1.5F, 0.0F, 16.0F, 3.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-4.4F, -1.5F, 0.0F);
		Body.addChild(bone4);
		setRotationAngle(bone4, 0.0F, 0.0F, 0.7854F);
		bone4.setTextureOffset(0, 6).addBox(-13.0F, -1.5F, 0.0F, 16.0F, 3.0F, 1.0F, 0.0F, false);

		Bib = new ModelRenderer(this);
		Bib.setRotationPoint(0.0F, 1.8333F, 0.0F);
		Body.addChild(Bib);
		Bib.setTextureOffset(41, 14).addBox(2.0F, -1.8333F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Bib.setTextureOffset(32, 14).addBox(-4.0F, -1.8333F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		r = new ModelRenderer(this);
		r.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		l = new ModelRenderer(this);
		l.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		

		RightFore = new ModelRenderer(this);
		RightFore.setRotationPoint(1.0F, 5.0F, -1.0F);
		RightArm.addChild(RightFore);
		setRotationAngle(RightFore, -1.6581F, -0.7854F, 0.0F);
		

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		

		LeftFore = new ModelRenderer(this);
		LeftFore.setRotationPoint(-1.0F, 5.0F, -1.0F);
		LeftArm.addChild(LeftFore);
		setRotationAngle(LeftFore, -1.6581F, 0.7854F, 0.0F);
		

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(4.0F, 2.0F, 1.5F);
		setRotationAngle(LeftWing, 0.4363F, -0.1309F, -2.3562F);
		LeftWing.setTextureOffset(41, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		LeftWing.setTextureOffset(0, 15).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb3 = new ModelRenderer(this);
		Limb3.setRotationPoint(0.0F, 3.0F, 0.0F);
		LeftWing.addChild(Limb3);
		setRotationAngle(Limb3, 0.0F, 0.0F, -1.6581F);
		

		Limb1 = new ModelRenderer(this);
		Limb1.setRotationPoint(-3.0F, 12.5F, -0.5F);
		LeftWing.addChild(Limb1);
		setRotationAngle(Limb1, 0.0F, 0.0F, 0.5672F);
		Limb1.setTextureOffset(37, 49).addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb1.setTextureOffset(37, 33).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb1.setTextureOffset(18, 0).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		LeftWing2 = new ModelRenderer(this);
		LeftWing2.setRotationPoint(4.0F, 2.0F, 1.5F);
		setRotationAngle(LeftWing2, 0.3054F, 0.48F, -2.8362F);
		LeftWing2.setTextureOffset(41, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		LeftWing2.setTextureOffset(0, 15).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb7 = new ModelRenderer(this);
		Limb7.setRotationPoint(0.0F, 3.0F, 0.0F);
		LeftWing2.addChild(Limb7);
		setRotationAngle(Limb7, 0.0F, 0.0F, -1.6581F);
		

		Limb8 = new ModelRenderer(this);
		Limb8.setRotationPoint(-3.0F, 12.5F, -0.5F);
		LeftWing2.addChild(Limb8);
		setRotationAngle(Limb8, 0.0F, 0.0F, 0.5672F);
		Limb8.setTextureOffset(37, 49).addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb8.setTextureOffset(37, 33).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb8.setTextureOffset(18, 0).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-4.0F, 2.0F, 1.5F);
		setRotationAngle(RightWing, 0.4363F, 0.1309F, 2.3562F);
		RightWing.setTextureOffset(52, 0).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing.setTextureOffset(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb2 = new ModelRenderer(this);
		Limb2.setRotationPoint(4.1684F, 12.096F, 0.5702F);
		RightWing.addChild(Limb2);
		setRotationAngle(Limb2, 0.0F, 0.0F, -0.5672F);
		Limb2.setTextureOffset(33, 44).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb2.setTextureOffset(37, 27).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb2.setTextureOffset(0, 26).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		Limb4 = new ModelRenderer(this);
		Limb4.setRotationPoint(8.0F, 3.0F, 0.0F);
		RightWing.addChild(Limb4);
		setRotationAngle(Limb4, 0.0F, 0.0F, -1.6581F);
		

		RightWing2 = new ModelRenderer(this);
		RightWing2.setRotationPoint(-4.0F, 2.0F, 1.5F);
		setRotationAngle(RightWing2, 0.2182F, -0.48F, 2.8362F);
		RightWing2.setTextureOffset(52, 0).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing2.setTextureOffset(52, 0).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing2.setTextureOffset(52, 0).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing2.setTextureOffset(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);
		RightWing2.setTextureOffset(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);
		RightWing2.setTextureOffset(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb5 = new ModelRenderer(this);
		Limb5.setRotationPoint(4.1684F, 12.096F, 0.5702F);
		RightWing2.addChild(Limb5);
		setRotationAngle(Limb5, 0.0F, 0.0F, -0.5672F);
		Limb5.setTextureOffset(33, 44).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb5.setTextureOffset(33, 44).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb5.setTextureOffset(33, 44).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb5.setTextureOffset(37, 27).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb5.setTextureOffset(37, 27).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb5.setTextureOffset(37, 27).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb5.setTextureOffset(0, 26).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);
		Limb5.setTextureOffset(0, 26).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);
		Limb5.setTextureOffset(0, 26).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		Limb6 = new ModelRenderer(this);
		Limb6.setRotationPoint(8.0F, 3.0F, 0.0F);
		RightWing2.addChild(Limb6);
		setRotationAngle(Limb6, 0.0F, 0.0F, -1.6581F);
		

		LeftWing3 = new ModelRenderer(this);
		LeftWing3.setRotationPoint(4.0F, 2.0F, 1.5F);
		setRotationAngle(LeftWing3, 0.2181F, 0.6982F, 2.8798F);
		LeftWing3.setTextureOffset(41, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		LeftWing3.setTextureOffset(0, 15).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb9 = new ModelRenderer(this);
		Limb9.setRotationPoint(0.0F, 3.0F, 0.0F);
		LeftWing3.addChild(Limb9);
		setRotationAngle(Limb9, 0.0F, 0.0F, -1.6581F);
		

		Limb10 = new ModelRenderer(this);
		Limb10.setRotationPoint(-3.0F, 12.5F, -0.5F);
		LeftWing3.addChild(Limb10);
		setRotationAngle(Limb10, 0.0F, 0.0F, 0.5672F);
		Limb10.setTextureOffset(37, 49).addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb10.setTextureOffset(37, 33).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb10.setTextureOffset(18, 0).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		RightWing3 = new ModelRenderer(this);
		RightWing3.setRotationPoint(-4.0F, 2.0F, 1.5F);
		setRotationAngle(RightWing3, 0.2181F, -0.6981F, -2.8798F);
		RightWing3.setTextureOffset(52, 0).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing3.setTextureOffset(52, 0).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing3.setTextureOffset(52, 0).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing3.setTextureOffset(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);
		RightWing3.setTextureOffset(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);
		RightWing3.setTextureOffset(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb11 = new ModelRenderer(this);
		Limb11.setRotationPoint(4.1684F, 12.096F, 0.5702F);
		RightWing3.addChild(Limb11);
		setRotationAngle(Limb11, 0.0F, 0.0F, -0.5672F);
		Limb11.setTextureOffset(33, 44).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb11.setTextureOffset(33, 44).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb11.setTextureOffset(33, 44).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb11.setTextureOffset(37, 27).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb11.setTextureOffset(37, 27).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb11.setTextureOffset(37, 27).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb11.setTextureOffset(0, 26).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);
		Limb11.setTextureOffset(0, 26).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);
		Limb11.setTextureOffset(0, 26).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		Limb12 = new ModelRenderer(this);
		Limb12.setRotationPoint(8.0F, 3.0F, 0.0F);
		RightWing3.addChild(Limb12);
		setRotationAngle(Limb12, 0.0F, 0.0F, -1.6581F);
		

		RightWing4 = new ModelRenderer(this);
		RightWing4.setRotationPoint(-4.0F, 2.0F, 1.5F);
		setRotationAngle(RightWing4, 0.3054F, 0.1309F, 1.3963F);
		RightWing4.setTextureOffset(52, 0).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing4.setTextureOffset(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb13 = new ModelRenderer(this);
		Limb13.setRotationPoint(4.1684F, 12.096F, 0.5702F);
		RightWing4.addChild(Limb13);
		setRotationAngle(Limb13, 0.0F, 0.0F, -0.5672F);
		Limb13.setTextureOffset(33, 44).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb13.setTextureOffset(37, 27).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb13.setTextureOffset(0, 26).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		Limb14 = new ModelRenderer(this);
		Limb14.setRotationPoint(8.0F, 3.0F, 0.0F);
		RightWing4.addChild(Limb14);
		setRotationAngle(Limb14, 0.0F, 0.0F, -1.6581F);
		

		RightWing5 = new ModelRenderer(this);
		RightWing5.setRotationPoint(-4.0F, 2.0F, 1.5F);
		setRotationAngle(RightWing5, 0.2618F, 0.1309F, 0.7854F);
		RightWing5.setTextureOffset(52, 0).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing5.setTextureOffset(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb15 = new ModelRenderer(this);
		Limb15.setRotationPoint(4.1684F, 12.096F, 0.5702F);
		RightWing5.addChild(Limb15);
		setRotationAngle(Limb15, 0.0F, 0.0F, -0.5672F);
		Limb15.setTextureOffset(33, 44).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb15.setTextureOffset(37, 27).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb15.setTextureOffset(0, 26).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		Limb16 = new ModelRenderer(this);
		Limb16.setRotationPoint(8.0F, 3.0F, 0.0F);
		RightWing5.addChild(Limb16);
		setRotationAngle(Limb16, 0.0F, 0.0F, -1.6581F);
		

		LeftWing4 = new ModelRenderer(this);
		LeftWing4.setRotationPoint(4.0F, 2.0F, 1.5F);
		setRotationAngle(LeftWing4, 0.2182F, -0.1309F, -1.3963F);
		LeftWing4.setTextureOffset(41, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		LeftWing4.setTextureOffset(0, 15).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb17 = new ModelRenderer(this);
		Limb17.setRotationPoint(0.0F, 3.0F, 0.0F);
		LeftWing4.addChild(Limb17);
		setRotationAngle(Limb17, 0.0F, 0.0F, -1.6581F);
		

		Limb18 = new ModelRenderer(this);
		Limb18.setRotationPoint(-3.0F, 12.5F, -0.5F);
		LeftWing4.addChild(Limb18);
		setRotationAngle(Limb18, 0.0F, 0.0F, 0.5672F);
		Limb18.setTextureOffset(37, 49).addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb18.setTextureOffset(37, 33).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb18.setTextureOffset(18, 0).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		LeftWing5 = new ModelRenderer(this);
		LeftWing5.setRotationPoint(4.0F, 2.0F, 1.5F);
		setRotationAngle(LeftWing5, 0.2182F, -0.1309F, -0.7854F);
		LeftWing5.setTextureOffset(41, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		LeftWing5.setTextureOffset(0, 15).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb19 = new ModelRenderer(this);
		Limb19.setRotationPoint(0.0F, 3.0F, 0.0F);
		LeftWing5.addChild(Limb19);
		setRotationAngle(Limb19, 0.0F, 0.0F, -1.6581F);
		

		Limb20 = new ModelRenderer(this);
		Limb20.setRotationPoint(-3.0F, 12.5F, -0.5F);
		LeftWing5.addChild(Limb20);
		setRotationAngle(Limb20, 0.0F, 0.0F, 0.5672F);
		Limb20.setTextureOffset(37, 49).addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb20.setTextureOffset(37, 33).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb20.setTextureOffset(18, 0).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(EntityTetra entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		float f = MathHelper.lerp(0, entity.oFlap, entity.wingRotation);
		float f1 = MathHelper.lerp(0, entity.oFlapSpeed, entity.destPos);
		float f3 = (MathHelper.sin(f) + 1.6F) * f1;

		this.RightWing.rotateAngleZ = f3 *1.15f;
		this.LeftWing.rotateAngleZ = -f3 *1.15f;

		this.RightWing2.rotateAngleZ = f3 * 0.8f;
		this.LeftWing2.rotateAngleZ = -f3 * 0.8f;

		this.RightWing3.rotateAngleZ = f3 * 0.65f;
		this.LeftWing3.rotateAngleZ = -f3 * 0.65f;
		
		
		this.RightWing4.rotateAngleZ = f3 * 0.4f;
		this.LeftWing4.rotateAngleZ = -f3 * 0.4f;

		this.RightWing5.rotateAngleZ = f3 * 0.15f;
		this.LeftWing5.rotateAngleZ = -f3 * 0.15f;
		
		if (entity.isArmored()) {
			float a = MathHelper.lerp(0, entity.oFlap * 1.4f, entity.wingRotation);
			float a1 = MathHelper.lerp(0, entity.oFlapSpeed * 1.4f, entity.destPos);
			float a3 = (MathHelper.sin(a) + 1.6F) * a1;
			this.RightFore.rotateAngleY = a3 * 0.5f - 0.9f;
			this.LeftFore.rotateAngleY = -a3 * 0.5f + 0.9f;
		} else {
			this.RightFore.rotateAngleY = -1.7854F;
			this.RightFore.rotateAngleX = -1.6581F;
			this.LeftFore.rotateAngleX = -1.6581F;
			this.LeftFore.rotateAngleY = 0.7854F;
		}	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		r.render(matrixStack, buffer, packedLight, packedOverlay);
		l.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing2.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing2.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing3.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing3.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing4.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing5.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing4.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing5.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}