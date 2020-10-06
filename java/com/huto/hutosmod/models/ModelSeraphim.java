package com.huto.hutosmod.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public class ModelSeraphim extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Skull;
	private final ModelRenderer Halo;
	private final ModelRenderer Body;
	private final ModelRenderer Belt;
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
	private final ModelRenderer RightArm;
	private final ModelRenderer RightFore;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftFore;
	private final ModelRenderer LeftWing;
	private final ModelRenderer Limb3;
	private final ModelRenderer Limb1;
	private final ModelRenderer RightWing;
	private final ModelRenderer Limb2;
	private final ModelRenderer Limb4;

	public ModelSeraphim() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, -0.5F);
		Head.setTextureOffset(18, 14).addBox(-3.0F, -3.0F, -0.5F, 6.0F, 2.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(18, 10).addBox(-4.0F, -1.0F, -1.5F, 8.0F, 1.0F, 3.0F, 0.0F, false);

		Skull = new ModelRenderer(this);
		Skull.setRotationPoint(0.0F, -7.0F, -0.5F);
		Head.addChild(Skull);
		Skull.setTextureOffset(23, 28).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		Halo = new ModelRenderer(this);
		Halo.setRotationPoint(0.0F, -7.0F, 3.0F);
		Head.addChild(Halo);
		setRotationAngle(Halo, 0.0F, 0.0F, 0.7854F);
		Halo.setTextureOffset(36, 0).addBox(-3.0F, 3.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(34, 15).addBox(-3.0F, -5.0F, -0.5F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(38, 50).addBox(-5.0F, -3.0F, -0.5F, 2.0F, 6.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(49, 25).addBox(3.0F, -3.0F, -0.5F, 2.0F, 6.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(36, 7).addBox(3.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(16, 30).addBox(-4.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(29, 28).addBox(-4.0F, 3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Halo.setTextureOffset(16, 28).addBox(3.0F, 3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 3.0F, 0.0F, false);

		Belt = new ModelRenderer(this);
		Belt.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.addChild(Belt);
		Belt.setTextureOffset(36, 5).addBox(-3.0F, -13.0F, -3.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Belt.setTextureOffset(36, 3).addBox(-3.0F, -13.0F, 1.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Belt.setTextureOffset(28, 28).addBox(3.0F, -13.0F, -3.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Belt.setTextureOffset(16, 28).addBox(-4.0F, -13.0F, -3.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		Bib = new ModelRenderer(this);
		Bib.setRotationPoint(0.0F, 1.8333F, 0.0F);
		Body.addChild(Bib);
		Bib.setTextureOffset(50, 0).addBox(2.0F, -1.8333F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Bib.setTextureOffset(46, 41).addBox(-4.0F, -1.8333F, 1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Bib.setTextureOffset(50, 3).addBox(2.0F, -1.8333F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		Bib.setTextureOffset(35, 23).addBox(4.0F, -1.8333F, -3.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Bib.setTextureOffset(35, 9).addBox(-5.0F, -1.8333F, -3.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		Bib.setTextureOffset(35, 29).addBox(-3.0F, 0.1667F, -3.0F, 6.0F, 3.0F, 1.0F, 0.0F, false);
		Bib.setTextureOffset(50, 44).addBox(-4.0F, -1.8333F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(-3.0F, 29.0F, 4.0F);
		Body.addChild(Tail);
		setRotationAngle(Tail, 0.0436F, 0.0F, 0.0F);

		f1 = new ModelRenderer(this);
		f1.setRotationPoint(0.0F, -17.0F, -1.5F);
		Tail.addChild(f1);
		setRotationAngle(f1, 0.0F, -0.6109F, 0.2182F);
		f1.setTextureOffset(34, 34).addBox(-1.738F, -0.1718F, -0.573F, 2.0F, 11.0F, 1.0F, 0.0F, false);

		f2 = new ModelRenderer(this);
		f2.setRotationPoint(1.0F, 0.0F, 0.0F);
		Tail.addChild(f2);
		setRotationAngle(f2, 0.0F, 0.0F, 0.0873F);
		f2.setTextureOffset(42, 18).addBox(-2.4855F, -17.0225F, -2.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);

		f3 = new ModelRenderer(this);
		f3.setRotationPoint(5.0F, 0.0F, 0.0F);
		Tail.addChild(f3);
		f3.setTextureOffset(32, 46).addBox(-3.0F, -17.0F, -2.0F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		f4 = new ModelRenderer(this);
		f4.setRotationPoint(8.0F, 0.0F, 0.0F);
		Tail.addChild(f4);
		setRotationAngle(f4, 0.0F, 0.0F, -0.0873F);
		f4.setTextureOffset(40, 40).addBox(-2.5031F, -17.2839F, -2.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);

		f5 = new ModelRenderer(this);
		f5.setRotationPoint(13.0F, -1.0F, -2.0F);
		Tail.addChild(f5);
		setRotationAngle(f5, 0.0F, 0.6109F, -0.2182F);
		f5.setTextureOffset(28, 34).addBox(-3.3102F, -17.3076F, -2.097F, 2.0F, 11.0F, 1.0F, 0.0F, false);

		Tail2 = new ModelRenderer(this);
		Tail2.setRotationPoint(0.0F, 24.0F, -2.0F);
		Body.addChild(Tail2);
		setRotationAngle(Tail2, 0.0436F, 3.1416F, 0.0F);

		f6 = new ModelRenderer(this);
		f6.setRotationPoint(-3.0F, -12.0F, 1.5F);
		Tail2.addChild(f6);
		setRotationAngle(f6, 0.0F, -0.6109F, 0.2182F);
		f6.setTextureOffset(22, 34).addBox(-1.738F, -0.1718F, -0.573F, 2.0F, 11.0F, 1.0F, 0.0F, false);

		f7 = new ModelRenderer(this);
		f7.setRotationPoint(-2.0F, 5.0F, 3.0F);
		Tail2.addChild(f7);
		setRotationAngle(f7, 0.0F, 0.0F, 0.0873F);
		f7.setTextureOffset(6, 37).addBox(-2.4855F, -17.0225F, -2.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);

		f8 = new ModelRenderer(this);
		f8.setRotationPoint(2.0F, 5.0F, 3.0F);
		Tail2.addChild(f8);
		f8.setTextureOffset(18, 46).addBox(-3.0F, -17.0F, -2.0F, 2.0F, 8.0F, 1.0F, 0.0F, false);

		f9 = new ModelRenderer(this);
		f9.setRotationPoint(5.0F, 5.0F, 3.0F);
		Tail2.addChild(f9);
		setRotationAngle(f9, 0.0F, 0.0F, -0.0873F);
		f9.setTextureOffset(0, 37).addBox(-2.5031F, -17.2839F, -2.0F, 2.0F, 9.0F, 1.0F, 0.0F, false);

		f10 = new ModelRenderer(this);
		f10.setRotationPoint(10.0F, 4.0F, 1.0F);
		Tail2.addChild(f10);
		setRotationAngle(f10, 0.0F, 0.6109F, -0.2182F);
		f10.setTextureOffset(16, 34).addBox(-3.3102F, -17.3076F, -2.097F, 2.0F, 11.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.setTextureOffset(45, 33).addBox(0.0F, -1.0F, -2.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		RightFore = new ModelRenderer(this);
		RightFore.setRotationPoint(1.0F, 5.0F, -1.0F);
		RightArm.addChild(RightFore);
		setRotationAngle(RightFore, -1.6581F, -0.7854F, 0.0F);
		RightFore.setTextureOffset(0, 47).addBox(-1.4142F, -1.0F, 0.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.setTextureOffset(10, 45).addBox(-2.0F, -1.0F, -2.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		LeftFore = new ModelRenderer(this);
		LeftFore.setRotationPoint(-1.0F, 5.0F, -1.0F);
		LeftArm.addChild(LeftFore);
		setRotationAngle(LeftFore, -1.6581F, 0.7854F, 0.0F);
		LeftFore.setTextureOffset(46, 46).addBox(0.4142F, -1.0F, 0.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);

		LeftWing = new ModelRenderer(this);
		LeftWing.setRotationPoint(4.0F, 2.0F, 1.5F);
		setRotationAngle(LeftWing, 0.3054F, -0.1309F, -2.3562F);
		LeftWing.setTextureOffset(6, 47).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		LeftWing.setTextureOffset(0, 15).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, 0.0F, false);

		Limb3 = new ModelRenderer(this);
		Limb3.setRotationPoint(0.0F, 3.0F, 0.0F);
		LeftWing.addChild(Limb3);
		setRotationAngle(Limb3, 0.0F, 0.0F, -1.6581F);
		Limb3.setTextureOffset(48, 16).addBox(-5.4058F, -8.7075F, -0.4026F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		Limb1 = new ModelRenderer(this);
		Limb1.setRotationPoint(-3.0F, 12.5F, -0.5F);
		LeftWing.addChild(Limb1);
		setRotationAngle(Limb1, 0.0F, 0.0F, 0.5672F);
		Limb1.setTextureOffset(28, 46).addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb1.setTextureOffset(18, 18).addBox(-8.0012F, -5.442F, 1.1F, 9.0F, 10.0F, 0.0F, 0.0F, false);

		RightWing = new ModelRenderer(this);
		RightWing.setRotationPoint(-4.0F, 2.0F, 1.5F);
		setRotationAngle(RightWing, 0.3054F, 0.1309F, 2.3562F);
		RightWing.setTextureOffset(36, 18).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		RightWing.setTextureOffset(0, 26).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, 0.0F, false);

		Limb2 = new ModelRenderer(this);
		Limb2.setRotationPoint(4.1684F, 12.096F, 0.5702F);
		RightWing.addChild(Limb2);
		setRotationAngle(Limb2, 0.0F, 0.0F, -0.5672F);
		Limb2.setTextureOffset(24, 46).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		Limb2.setTextureOffset(18, 0).addBox(-2.2013F, -5.729F, 0.0298F, 9.0F, 10.0F, 0.0F, 0.0F, false);

		Limb4 = new ModelRenderer(this);
		Limb4.setRotationPoint(8.0F, 3.0F, 0.0F);
		RightWing.addChild(Limb4);
		setRotationAngle(Limb4, 0.0F, 0.0F, -1.6581F);
		Limb4.setTextureOffset(47, 7).addBox(-4.7493F, -8.2115F, -0.4026F, 1.0F, 8.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftWing.render(matrixStack, buffer, packedLight, packedOverlay);
		RightWing.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}