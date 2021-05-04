package com.huto.forcesofreality.models.entity.summons;

import java.util.Random;

import com.huto.forcesofreality.entities.summons.EntityBlackGoat;
import com.hutoslib.util.ClientUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelBlackGoat extends EntityModel<EntityBlackGoat> {
	private final ModelRenderer body;
	private final ModelRenderer tent9;
	private final ModelRenderer tent10;
	private final ModelRenderer tent17;
	private final ModelRenderer tent18;
	private final ModelRenderer tent19;
	private final ModelRenderer tent20;
	private final ModelRenderer tent21;
	private final ModelRenderer tent22;
	private final ModelRenderer tent23;
	private final ModelRenderer tent24;
	private final ModelRenderer tent25;
	private final ModelRenderer tent26;
	private final ModelRenderer tent27;
	private final ModelRenderer tent28;
	private final ModelRenderer tent29;
	private final ModelRenderer tent30;
	private final ModelRenderer tent31;
	private final ModelRenderer tent32;
	private final ModelRenderer tent33;
	private final ModelRenderer tent34;
	private final ModelRenderer tent35;
	private final ModelRenderer tent36;
	private final ModelRenderer tent37;
	private final ModelRenderer tent38;
	private final ModelRenderer tent39;
	private final ModelRenderer tent40;
	private final ModelRenderer tent41;
	private final ModelRenderer tent42;
	private final ModelRenderer tent2;
	private final ModelRenderer tent3;
	private final ModelRenderer tent4;
	private final ModelRenderer tent5;
	private final ModelRenderer tent6;
	private final ModelRenderer tent7;
	private final ModelRenderer tent8;
	private final ModelRenderer brain;
	private final ModelRenderer eye1;
	private final ModelRenderer eye2;
	private final ModelRenderer eye3;
	private final ModelRenderer eye4;
	private final ModelRenderer tounge;
	private final ModelRenderer backLeftLeg;
	private final ModelRenderer backRightLeg;
	private final ModelRenderer frontLeg;

	public ModelBlackGoat() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.25F, 21.375F, -0.005F);
		setRotationAngle(body, 0.0F, -1.0472F, 0.0F);
		body.setTextureOffset(0, 9).addBox(-3.25F, -5.275F, -2.995F, 7.0F, 2.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(34, 13).addBox(-3.25F, -3.275F, -0.995F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(0, 2).addBox(-1.15F, -3.275F, -0.995F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(1.65F, -3.275F, -0.995F, 0.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(34, 10).addBox(1.75F, -3.275F, -0.995F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(26, 5).addBox(-1.25F, -3.275F, -2.995F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(24, 26).addBox(-1.25F, -3.275F, 1.005F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(24, 22).addBox(-1.25F, -3.275F, 0.905F, 3.0F, 2.0F, 0.0F, 0.0F, false);
		body.setTextureOffset(0, 13).addBox(-1.25F, -3.275F, -0.995F, 3.0F, 2.0F, 0.0F, 0.0F, false);

		tent9 = new ModelRenderer(this);
		tent9.setRotationPoint(6.75F, -16.275F, -3.995F);
		body.addChild(tent9);

		tent10 = new ModelRenderer(this);
		tent10.setRotationPoint(-4.0F, 8.5F, 2.0F);
		tent9.addChild(tent10);
		tent10.setTextureOffset(34, 4).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		tent17 = new ModelRenderer(this);
		tent17.setRotationPoint(-4.0F, 6.9F, 2.0F);
		tent9.addChild(tent17);
		tent17.setTextureOffset(22, 33).addBox(-0.3F, -0.9F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		tent18 = new ModelRenderer(this);
		tent18.setRotationPoint(-3.1F, 6.0F, 2.5F);
		tent9.addChild(tent18);
		tent18.setTextureOffset(0, 37).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent19 = new ModelRenderer(this);
		tent19.setRotationPoint(-3.5F, 4.0F, 1.8F);
		tent9.addChild(tent19);
		tent19.setTextureOffset(36, 17).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent20 = new ModelRenderer(this);
		tent20.setRotationPoint(-3.5F, 2.0F, 2.5F);
		tent9.addChild(tent20);
		tent20.setTextureOffset(35, 36).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		tent21 = new ModelRenderer(this);
		tent21.setRotationPoint(-3.5F, 0.1F, 1.9F);
		tent9.addChild(tent21);

		tent22 = new ModelRenderer(this);
		tent22.setRotationPoint(6.75F, -16.275F, 0.005F);
		body.addChild(tent22);

		tent23 = new ModelRenderer(this);
		tent23.setRotationPoint(-4.0F, 8.5F, 2.0F);
		tent22.addChild(tent23);
		tent23.setTextureOffset(24, 33).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		tent24 = new ModelRenderer(this);
		tent24.setRotationPoint(-4.0F, 6.9F, 2.0F);
		tent22.addChild(tent24);
		tent24.setTextureOffset(6, 33).addBox(-0.1F, -0.9F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		tent25 = new ModelRenderer(this);
		tent25.setRotationPoint(-3.1F, 6.0F, 2.5F);
		tent22.addChild(tent25);
		tent25.setTextureOffset(31, 36).addBox(-1.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent26 = new ModelRenderer(this);
		tent26.setRotationPoint(-3.5F, 4.0F, 1.8F);
		tent22.addChild(tent26);
		tent26.setTextureOffset(27, 36).addBox(-0.5F, -2.0F, 0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent27 = new ModelRenderer(this);
		tent27.setRotationPoint(-3.5F, 2.0F, 2.5F);
		tent22.addChild(tent27);
		tent27.setTextureOffset(23, 36).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent28 = new ModelRenderer(this);
		tent28.setRotationPoint(-2.9F, -0.1F, 2.9F);
		tent22.addChild(tent28);

		tent29 = new ModelRenderer(this);
		tent29.setRotationPoint(1.75F, -16.275F, 0.005F);
		body.addChild(tent29);

		tent30 = new ModelRenderer(this);
		tent30.setRotationPoint(-4.0F, 8.5F, 2.0F);
		tent29.addChild(tent30);
		tent30.setTextureOffset(16, 33).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		tent31 = new ModelRenderer(this);
		tent31.setRotationPoint(-4.0F, 6.9F, 2.0F);
		tent29.addChild(tent31);
		tent31.setTextureOffset(22, 26).addBox(-1.1F, -0.9F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		tent32 = new ModelRenderer(this);
		tent32.setRotationPoint(-3.1F, 6.0F, 2.5F);
		tent29.addChild(tent32);
		tent32.setTextureOffset(19, 36).addBox(-1.5F, -2.0F, -1.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent33 = new ModelRenderer(this);
		tent33.setRotationPoint(-3.5F, 4.0F, 1.8F);
		tent29.addChild(tent33);
		tent33.setTextureOffset(15, 36).addBox(-1.5F, -2.0F, -0.1F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent34 = new ModelRenderer(this);
		tent34.setRotationPoint(-3.5F, 2.0F, 2.5F);
		tent29.addChild(tent34);
		tent34.setTextureOffset(11, 36).addBox(-1.8F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		tent35 = new ModelRenderer(this);
		tent35.setRotationPoint(-4.2F, -0.2F, 2.4F);
		tent29.addChild(tent35);

		tent36 = new ModelRenderer(this);
		tent36.setRotationPoint(4.25F, -16.275F, -1.995F);
		body.addChild(tent36);

		tent37 = new ModelRenderer(this);
		tent37.setRotationPoint(-4.0F, 8.5F, 2.0F);
		tent36.addChild(tent37);
		tent37.setTextureOffset(8, 33).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		tent38 = new ModelRenderer(this);
		tent38.setRotationPoint(-4.0F, 6.9F, 2.0F);
		tent36.addChild(tent38);
		tent38.setTextureOffset(6, 26).addBox(-1.1F, -0.9F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		tent39 = new ModelRenderer(this);
		tent39.setRotationPoint(-3.1F, 6.0F, 2.5F);
		tent36.addChild(tent39);
		tent39.setTextureOffset(7, 36).addBox(-1.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent40 = new ModelRenderer(this);
		tent40.setRotationPoint(-3.5F, 4.0F, 1.8F);
		tent36.addChild(tent40);
		tent40.setTextureOffset(0, 17).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent41 = new ModelRenderer(this);
		tent41.setRotationPoint(-3.5F, 2.0F, 2.5F);
		tent36.addChild(tent41);
		tent41.setTextureOffset(0, 9).addBox(-1.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent42 = new ModelRenderer(this);
		tent42.setRotationPoint(-4.1F, 0.1F, 1.9F);
		tent36.addChild(tent42);
		tent42.setTextureOffset(0, 0).addBox(0.1F, -1.1F, -0.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		tent2 = new ModelRenderer(this);
		tent2.setRotationPoint(1.75F, -16.275F, -3.995F);
		body.addChild(tent2);

		tent3 = new ModelRenderer(this);
		tent3.setRotationPoint(1.0F, 8.0F, 1.0F);
		tent2.addChild(tent3);
		tent3.setTextureOffset(34, 7).addBox(-6.0F, -1.0F, 0.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		tent4 = new ModelRenderer(this);
		tent4.setRotationPoint(0.5F, 7.0F, 0.5F);
		tent2.addChild(tent4);
		tent4.setTextureOffset(41, 33).addBox(-5.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		tent5 = new ModelRenderer(this);
		tent5.setRotationPoint(2.4F, 6.0F, 2.0F);
		tent2.addChild(tent5);
		tent5.setTextureOffset(38, 20).addBox(-6.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent6 = new ModelRenderer(this);
		tent6.setRotationPoint(1.0F, 4.0F, 0.3F);
		tent2.addChild(tent6);
		tent6.setTextureOffset(38, 38).addBox(-5.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent7 = new ModelRenderer(this);
		tent7.setRotationPoint(-3.5F, 2.0F, 2.5F);
		tent2.addChild(tent7);
		tent7.setTextureOffset(4, 38).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		tent8 = new ModelRenderer(this);
		tent8.setRotationPoint(-4.5F, -0.1F, 1.5F);
		tent2.addChild(tent8);
		tent8.setTextureOffset(41, 22).addBox(-0.5F, -0.9F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		brain = new ModelRenderer(this);
		brain.setRotationPoint(2.75F, -5.275F, -2.995F);
		body.addChild(brain);
		brain.setTextureOffset(0, 0).addBox(-6.0F, -3.0F, 0.0F, 7.0F, 3.0F, 6.0F, 0.0F, false);
		brain.setTextureOffset(12, 18).addBox(-6.1F, -3.0F, 0.0F, 0.0F, 2.0F, 6.0F, 0.0F, false);
		brain.setTextureOffset(0, 18).addBox(1.1F, -3.0F, 0.0F, 0.0F, 2.0F, 6.0F, 0.0F, false);
		brain.setTextureOffset(20, 13).addBox(-6.0F, -3.0F, 6.1F, 7.0F, 2.0F, 0.0F, 0.0F, false);
		brain.setTextureOffset(24, 24).addBox(-6.0F, -3.0F, -0.1F, 7.0F, 2.0F, 0.0F, 0.0F, false);

		eye1 = new ModelRenderer(this);
		eye1.setRotationPoint(1.2337F, 0.0F, 0.4029F);
		brain.addChild(eye1);
		eye1.setTextureOffset(30, 31).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye2 = new ModelRenderer(this);
		eye2.setRotationPoint(0.6122F, -2.0F, 6.2794F);
		brain.addChild(eye2);
		eye2.setTextureOffset(24, 29).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye3 = new ModelRenderer(this);
		eye3.setRotationPoint(-5.2179F, 0.0F, 6.3775F);
		brain.addChild(eye3);
		eye3.setTextureOffset(28, 15).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		eye4 = new ModelRenderer(this);
		eye4.setRotationPoint(-6.1821F, -1.0F, 0.0474F);
		brain.addChild(eye4);
		eye4.setTextureOffset(30, 20).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		tounge = new ModelRenderer(this);
		tounge.setRotationPoint(0.25F, -1.775F, 0.005F);
		body.addChild(tounge);
		tounge.setTextureOffset(18, 18).addBox(-0.5F, -1.5F, 0.0F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		tounge.setTextureOffset(18, 18).addBox(-0.6866F, 2.0F, 0.1232F, 1.0F, 1.0F, 0.0F, 0.0F, true);
		tounge.setTextureOffset(18, 18).addBox(0.1696F, 1.0F, 0.0402F, 1.0F, 1.0F, 0.0F, 0.0F, true);

		backLeftLeg = new ModelRenderer(this);
		backLeftLeg.setRotationPoint(3.75F, -4.375F, 3.005F);
		body.addChild(backLeftLeg);
		backLeftLeg.setTextureOffset(20, 0).addBox(-1.0F, 6.0F, 0.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(12, 42).addBox(-1.0F, 4.1F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(39, 41).addBox(-1.0F, 2.1F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(41, 29).addBox(-1.0F, 4.1F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(35, 41).addBox(0.0F, 2.1F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(41, 12).addBox(2.0F, 4.1F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(41, 9).addBox(2.0F, 2.1F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(8, 42).addBox(2.0F, 4.1F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(41, 6).addBox(1.0F, 2.1F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(16, 26).addBox(0.0F, 1.1F, 1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(32, 27).addBox(-1.0F, -0.9F, 0.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(31, 35).addBox(-1.0F, 7.0F, 4.0F, 4.0F, 0.0F, 1.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(12, 17).addBox(-2.0F, 7.0F, 0.0F, 1.0F, 0.0F, 4.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(10, 17).addBox(3.0F, 7.0F, 0.0F, 1.0F, 0.0F, 4.0F, 0.0F, false);
		backLeftLeg.setTextureOffset(33, 16).addBox(-1.0F, 7.0F, -1.0F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		backRightLeg = new ModelRenderer(this);
		backRightLeg.setRotationPoint(-3.25F, -4.375F, 2.005F);
		body.addChild(backRightLeg);
		backRightLeg.setTextureOffset(16, 17).addBox(-4.0F, 6.0F, -1.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		backRightLeg.setTextureOffset(4, 41).addBox(-4.0F, 4.1F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backRightLeg.setTextureOffset(40, 17).addBox(-4.0F, 2.1F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backRightLeg.setTextureOffset(40, 3).addBox(-4.0F, 4.1F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backRightLeg.setTextureOffset(40, 0).addBox(-3.0F, 2.1F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backRightLeg.setTextureOffset(0, 40).addBox(-1.0F, 4.1F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backRightLeg.setTextureOffset(39, 35).addBox(-1.0F, 2.1F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backRightLeg.setTextureOffset(39, 26).addBox(-1.0F, 4.1F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backRightLeg.setTextureOffset(32, 39).addBox(-2.0F, 2.1F, 2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		backRightLeg.setTextureOffset(8, 26).addBox(-3.0F, 1.1F, 0.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		backRightLeg.setTextureOffset(0, 33).addBox(-2.0F, -0.9F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		backRightLeg.setTextureOffset(31, 26).addBox(-4.0F, 7.0F, 3.0F, 4.0F, 0.0F, 1.0F, 0.0F, false);
		backRightLeg.setTextureOffset(8, 17).addBox(-5.0F, 7.0F, -1.0F, 1.0F, 0.0F, 4.0F, 0.0F, false);
		backRightLeg.setTextureOffset(16, 0).addBox(0.0F, 7.0F, -1.0F, 1.0F, 0.0F, 4.0F, 0.0F, false);
		backRightLeg.setTextureOffset(27, 19).addBox(-4.0F, 7.0F, -2.0F, 4.0F, 0.0F, 1.0F, 0.0F, false);

		frontLeg = new ModelRenderer(this);
		frontLeg.setRotationPoint(1.75F, -4.375F, -2.995F);
		body.addChild(frontLeg);
		frontLeg.setTextureOffset(0, 17).addBox(-1.0F, 6.0F, -4.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		frontLeg.setTextureOffset(28, 39).addBox(-1.0F, 4.1F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		frontLeg.setTextureOffset(24, 39).addBox(-1.0F, 2.1F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		frontLeg.setTextureOffset(20, 39).addBox(-1.0F, 4.1F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		frontLeg.setTextureOffset(16, 39).addBox(0.0F, 2.1F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		frontLeg.setTextureOffset(12, 39).addBox(2.0F, 4.1F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		frontLeg.setTextureOffset(8, 39).addBox(2.0F, 2.1F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		frontLeg.setTextureOffset(38, 31).addBox(2.0F, 4.1F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		frontLeg.setTextureOffset(38, 23).addBox(1.0F, 2.1F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		frontLeg.setTextureOffset(0, 26).addBox(0.0F, 1.1F, -3.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		frontLeg.setTextureOffset(32, 0).addBox(-1.0F, -0.9F, -2.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		frontLeg.setTextureOffset(25, 8).addBox(-1.0F, 7.0F, 0.0F, 4.0F, 0.0F, 1.0F, 0.0F, false);
		frontLeg.setTextureOffset(0, 9).addBox(-2.0F, 7.0F, -4.0F, 1.0F, 0.0F, 4.0F, 0.0F, false);
		frontLeg.setTextureOffset(0, 0).addBox(3.0F, 7.0F, -4.0F, 1.0F, 0.0F, 4.0F, 0.0F, false);
		frontLeg.setTextureOffset(19, 5).addBox(-1.0F, 7.0F, -5.0F, 4.0F, 0.0F, 1.0F, 0.0F, false);

	}

	@Override
	public void setRotationAngles(EntityBlackGoat entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		
		float parTicks = ClientUtils.getPartialTicks();

		
		// Legs
		this.frontLeg.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
		this.backLeftLeg.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
		this.backLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
		this.backRightLeg.rotateAngleZ = MathHelper.sin(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;

		// Eyes
		this.eye1.rotateAngleZ = -(float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725);
		this.eye2.rotateAngleZ = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725);
		this.eye3.rotateAngleZ = -(float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725);
		this.eye4.rotateAngleZ = -(float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725);

		this.eye1.rotateAngleY = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725);
		this.eye2.rotateAngleY = -(float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725);
		this.eye3.rotateAngleY = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725);
		this.eye4.rotateAngleY = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725);

		this.eye1.rotateAngleX = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725);
		this.eye2.rotateAngleX = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725);
		this.eye3.rotateAngleX = -(float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725);
		this.eye4.rotateAngleX = -(float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725);

		// Each Tentacle Segment
		Random rand = new Random();
		float tentMod = rand.nextInt(3) * 0.1f;
		this.tent4.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0625) * tentMod;
		this.tent5.rotateAngleZ = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0625) * tentMod;
		this.tent6.rotateAngleY = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0625) * tentMod;
		this.tent7.rotateAngleZ = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0625) * tentMod;
		this.tent8.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0625) * tentMod;
		this.tent9.rotateAngleZ = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725) * tentMod;
		this.tent20.rotateAngleZ = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0825) * tentMod;
		this.tent21.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0825) * tentMod;
		this.tent22.rotateAngleZ = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0925) * tentMod;
		this.tent24.rotateAngleZ = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0625) * tentMod;
		this.tent25.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0625) * tentMod;
		this.tent26.rotateAngleZ = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725) * tentMod;
		this.tent27.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0725) * tentMod;
		this.tent28.rotateAngleZ = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0825) * tentMod;
		this.tent29.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0825) * tentMod;
		this.tent31.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0925) * tentMod;
		this.tent32.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0625) * tentMod;
		this.tent33.rotateAngleZ = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0725) * tentMod;
		this.tent34.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0725) * tentMod;
		this.tent35.rotateAngleZ = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0825) * tentMod;
		this.tent36.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0825) * tentMod;
		this.tent37.rotateAngleZ = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0925) * tentMod;
		this.tent38.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0925) * tentMod;
		this.tent39.rotateAngleZ = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0625) * tentMod;
		this.tent40.rotateAngleY = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0625) * tentMod;
		this.tent41.rotateAngleZ = (float) (Math.cos((entity.ticksExisted+ parTicks)) * 0.0625) * tentMod;
		this.tent42.rotateAngleY = (float) (Math.sin((entity.ticksExisted+ parTicks)) * 0.0625) * tentMod;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}