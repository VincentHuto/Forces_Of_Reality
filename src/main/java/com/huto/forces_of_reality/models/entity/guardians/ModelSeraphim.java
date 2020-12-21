package com.huto.forces_of_reality.models.entity.guardians;

import com.huto.forces_of_reality.entities.guardians.EntitySeraphim;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public class ModelSeraphim extends EntityModel<EntitySeraphim> {
	private final ModelRenderer Head;
	private final ModelRenderer Skull;
	private final ModelRenderer Halo;
	private final ModelRenderer Body;
	private final ModelRenderer Belt;
	private final ModelRenderer SideTails;
	private final ModelRenderer Bib;
	private final ModelRenderer Tail;
	private final ModelRenderer f1;
	private final ModelRenderer f2;
	private final ModelRenderer f3;
	private final ModelRenderer f4;
	private final ModelRenderer f5;
	private final ModelRenderer Tail2;
	private final ModelRenderer f6;
	private final ModelRenderer f7;
	private final ModelRenderer f8;
	private final ModelRenderer f9;
	private final ModelRenderer f10;
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

	public ModelSeraphim() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, -0.5F);
		Head.setTextureOffset(18, 10).addBox(-4.0F, -1.0F, -1.5F, 8.0F, 1.0F, 3.0F, 0.0F, false);

		Skull = new ModelRenderer(this);
		Skull.setRotationPoint(0.0F, -7.0F, 0.5F);
		Head.addChild(Skull);
		Skull.setTextureOffset(34, 6).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Halo = new ModelRenderer(this);
		Halo.setRotationPoint(0.0F, -7.0F, 1.0F);
		Head.addChild(Halo);
		Halo.setTextureOffset(37, 24).addBox(-3.0F, 3.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(34, 30).addBox(-3.0F, -5.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(54, 10).addBox(-5.0F, -3.0F, -0.5F, 2.0F, 6.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(26, 54).addBox(3.0F, -3.0F, -0.5F, 2.0F, 6.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(41, 0).addBox(3.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(34, 17).addBox(-4.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(34, 2).addBox(-4.0F, 3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(34, 0).addBox(3.0F, 3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 3.0F, 0.0F, false);

		Belt = new ModelRenderer(this);
		Belt.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.addChild(Belt);
		Belt.setTextureOffset(40, 12).addBox(-3.0F, -13.0F, -3.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Belt.setTextureOffset(37, 35).addBox(-3.0F, -13.0F, 1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Belt.setTextureOffset(34, 0).addBox(3.0F, -13.0F, -3.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Belt.setTextureOffset(30, 24).addBox(-4.0F, -13.0F, -3.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		SideTails = new ModelRenderer(this);
		SideTails.setRotationPoint(-4.5F, -7.5F, -0.5F);
		Belt.addChild(SideTails);

		r = new ModelRenderer(this);
		r.setRotationPoint(-1.0F, 0.0F, 0.0F);
		SideTails.addChild(r);
		setRotationAngle(r, 0.0F, 0.0F, 0.2182F);
		r.setTextureOffset(13, 34).addBox(-0.5F, -5.5F, -1.5F, 1.0F, 10.0F, 3.0F, 0.0F, false);

		l = new ModelRenderer(this);
		l.setRotationPoint(10.0F, 0.0F, 0.0F);
		SideTails.addChild(l);
		setRotationAngle(l, 0.0F, 0.0F, -0.2182F);
		l.setTextureOffset(29, 31).addBox(-0.5F, -5.5F, -1.5F, 1.0F, 10.0F, 3.0F, 0.0F, false);

		Bib = new ModelRenderer(this);
		Bib.setRotationPoint(0.0F, 1.8333F, 0.0F);
		Body.addChild(Bib);
		Bib.setTextureOffset(41, 14).addBox(2.0F, -1.8333F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Bib.setTextureOffset(32, 14).addBox(-4.0F, -1.8333F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Bib.setTextureOffset(43, 37).addBox(2.0F, -1.8333F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Bib.setTextureOffset(37, 6).addBox(4.0F, -1.8333F, -3.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Bib.setTextureOffset(34, 14).addBox(-5.0F, -1.8333F, -3.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Bib.setTextureOffset(34, 20).addBox(-3.0F, 0.1667F, -3.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		Bib.setTextureOffset(18, 14).addBox(-3.0F, 0.1667F, 1.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		Bib.setTextureOffset(43, 40).addBox(-4.0F, -1.8333F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(-3.0F, 29.0F, 4.0F);
		Body.addChild(Tail);
		setRotationAngle(Tail, 0.0436F, 0.0F, 0.0F);

		f1 = new ModelRenderer(this);
		f1.setRotationPoint(0.0F, -17.0F, -1.5F);
		Tail.addChild(f1);
		setRotationAngle(f1, 0.0F, -0.6109F, 0.2182F);
		f1.setTextureOffset(37, 37).addBox(-1.738F, -0.1718F, -0.573F, 2.0F, 11.0F, 1.0F, 0.0F, false);

		f2 = new ModelRenderer(this);
		f2.setRotationPoint(1.0F, 0.0F, 0.0F);
		Tail.addChild(f2);
		setRotationAngle(f2, 0.0F, 0.0F, 0.0873F);
		f2.setTextureOffset(46, 0).addBox(-2.4855F, -17.0225F, -2.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);

		f3 = new ModelRenderer(this);
		f3.setRotationPoint(5.0F, 0.0F, 0.0F);
		Tail.addChild(f3);
		f3.setTextureOffset(49, 49).addBox(-3.0F, -17.0F, -2.0F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		f4 = new ModelRenderer(this);
		f4.setRotationPoint(8.0F, 0.0F, 0.0F);
		Tail.addChild(f4);
		setRotationAngle(f4, 0.0F, 0.0F, -0.0873F);
		f4.setTextureOffset(20, 46).addBox(-2.5031F, -17.2839F, -2.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);

		f5 = new ModelRenderer(this);
		f5.setRotationPoint(13.0F, -1.0F, -2.0F);
		Tail.addChild(f5);
		setRotationAngle(f5, 0.0F, 0.6109F, -0.2182F);
		f5.setTextureOffset(6, 36).addBox(-3.3102F, -17.3076F, -2.097F, 2.0F, 11.0F, 1.0F, 0.0F, false);

		Tail2 = new ModelRenderer(this);
		Tail2.setRotationPoint(0.0F, 24.0F, -2.0F);
		Body.addChild(Tail2);
		setRotationAngle(Tail2, 0.0436F, 3.1416F, 0.0F);

		f6 = new ModelRenderer(this);
		f6.setRotationPoint(-3.0F, -12.0F, 1.5F);
		Tail2.addChild(f6);
		setRotationAngle(f6, 0.0F, -0.6109F, 0.2182F);
		f6.setTextureOffset(0, 36).addBox(-1.738F, -0.1718F, -0.573F, 2.0F, 11.0F, 1.0F, 0.0F, false);

		f7 = new ModelRenderer(this);
		f7.setRotationPoint(-2.0F, 5.0F, 3.0F);
		Tail2.addChild(f7);
		setRotationAngle(f7, 0.0F, 0.0F, 0.0873F);
		f7.setTextureOffset(27, 44).addBox(-2.4855F, -17.0225F, -2.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);

		f8 = new ModelRenderer(this);
		f8.setRotationPoint(2.0F, 5.0F, 3.0F);
		Tail2.addChild(f8);
		f8.setTextureOffset(48, 14).addBox(-3.0F, -17.0F, -2.0F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		f9 = new ModelRenderer(this);
		f9.setRotationPoint(5.0F, 5.0F, 3.0F);
		Tail2.addChild(f9);
		setRotationAngle(f9, 0.0F, 0.0F, -0.0873F);
		f9.setTextureOffset(43, 43).addBox(-2.5031F, -17.2839F, -2.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);

		f10 = new ModelRenderer(this);
		f10.setRotationPoint(10.0F, 4.0F, 1.0F);
		Tail2.addChild(f10);
		setRotationAngle(f10, 0.0F, 0.6109F, -0.2182F);
		f10.setTextureOffset(21, 34).addBox(-3.3102F, -17.3076F, -2.097F, 2.0F, 11.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.setTextureOffset(0, 48).addBox(0.0F, -1.0F, -2.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightFore = new ModelRenderer(this);
		RightFore.setRotationPoint(1.0F, 5.0F, -1.0F);
		RightArm.addChild(RightFore);
		setRotationAngle(RightFore, -1.6581F, -0.7854F, 0.0F);
		RightFore.setTextureOffset(51, 23).addBox(-1.4142F, -1.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, true);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.setTextureOffset(10, 47).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		LeftFore = new ModelRenderer(this);
		LeftFore.setRotationPoint(-1.0F, 5.0F, -1.0F);
		LeftArm.addChild(LeftFore);
		setRotationAngle(LeftFore, -1.6581F, 0.7854F, 0.0F);
		LeftFore.setTextureOffset(49, 35).addBox(-0.5858F, -1.0F, 0.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(4.0F, 2.0F, 1.5F);
		setRotationAngle(LeftWing, 0.2182F, -0.1309F, -2.3562F);
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
		setRotationAngle(RightWing, 0.3054F, 0.1309F, 2.3562F);
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
		RightWing2.setTextureOffset(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb5 = new ModelRenderer(this);
		Limb5.setRotationPoint(4.1684F, 12.096F, 0.5702F);
		RightWing2.addChild(Limb5);
		setRotationAngle(Limb5, 0.0F, 0.0F, -0.5672F);
		Limb5.setTextureOffset(33, 44).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb5.setTextureOffset(37, 27).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
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
		RightWing3.setTextureOffset(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb11 = new ModelRenderer(this);
		Limb11.setRotationPoint(4.1684F, 12.096F, 0.5702F);
		RightWing3.addChild(Limb11);
		setRotationAngle(Limb11, 0.0F, 0.0F, -0.5672F);
		Limb11.setTextureOffset(33, 44).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb11.setTextureOffset(37, 27).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Limb11.setTextureOffset(0, 26).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, 0.0F, false);

		Limb12 = new ModelRenderer(this);
		Limb12.setRotationPoint(8.0F, 3.0F, 0.0F);
		RightWing3.addChild(Limb12);
		setRotationAngle(Limb12, 0.0F, 0.0F, -1.6581F);

	}

	@Override
	public void setRotationAngles(EntitySeraphim entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		/*
		 * this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		 * this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		 */
		// this.Body.rotateAngleX = ((float) Math.PI / 2F);
		// this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F *
		// limbSwingAmount;
		// this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)
		// Math.PI) * 1.4F * limbSwingAmount;

		this.Halo.rotateAngleZ += ageInTicks * 0.002;
		this.Skull.rotateAngleY += ageInTicks * 0.03f;

		if (Halo.rotateAngleZ > 10000) {
			Halo.rotateAngleZ = 0;
			this.Halo.rotateAngleY = 0;

		}
		float f = MathHelper.lerp(0, entity.oFlap, entity.wingRotation);
		float f1 = MathHelper.lerp(0, entity.oFlapSpeed, entity.destPos);
		float f3 = (MathHelper.sin(f) + 1.6F) * f1;

		this.RightWing.rotateAngleZ = f3;
		this.LeftWing.rotateAngleZ = -f3;

		this.RightWing2.rotateAngleZ = f3 * 0.5f;
		this.LeftWing2.rotateAngleZ = -f3 * 0.5f;

		this.RightWing3.rotateAngleZ = f3 * 0.2f;
		this.LeftWing3.rotateAngleZ = -f3 * 0.2f;

		if (entity.isArmored()) {
			float a = MathHelper.lerp(0, entity.oFlap * 1.4f, entity.wingRotation);
			float a1 = MathHelper.lerp(0, entity.oFlapSpeed * 1.4f, entity.destPos);
			float a3 = (MathHelper.sin(a) + 1.6F) * a1;
			this.RightFore.rotateAngleY = a3 * 0.5f - 0.9f;
			this.LeftFore.rotateAngleY = -a3 * 0.5f + 0.9f;
		} else {
			this.RightFore.rotateAngleY = -0.7854F;
			this.RightFore.rotateAngleX = -1.6581F;
			this.LeftFore.rotateAngleX = -1.6581F;
			this.LeftFore.rotateAngleY = 0.7854F;
		}
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing2.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing2.render(matrixStack, buffer, packedLight, packedOverlay);

		LeftWing3.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing3.render(matrixStack, buffer, packedLight, packedOverlay);

	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}