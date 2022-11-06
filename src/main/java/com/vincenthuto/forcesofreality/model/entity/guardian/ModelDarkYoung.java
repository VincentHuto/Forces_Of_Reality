package com.vincenthuto.forcesofreality.model.entity.guardian;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.guardian.EntityDarkYoung;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelDarkYoung extends EntityModel<EntityDarkYoung> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modeldarkyoung"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition frontHead = partdefinition.addOrReplaceChild("frontHead",
				CubeListBuilder.create().texOffs(36, 19)
						.addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 0)
						.addBox(-3.0F, 2.0F, 2.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 14.0F, -9.0F));

		PartDefinition mouth3 = frontHead.addOrReplaceChild("mouth3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 1.0F, 3.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition lowerJaw3 = mouth3.addOrReplaceChild("lowerJaw3",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-1.0F, 0.5F, -6.5F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(38, 67)
						.addBox(-1.0F, -0.5F, -7.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(30, 63)
						.addBox(-2.0F, -0.5F, -6.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(62, 8)
						.addBox(1.0F, -0.5F, -6.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 40)
						.addBox(-1.0F, -1.5F, -6.5F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(27, 38)
						.addBox(1.0F, -1.5F, -6.5F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.5F, -4.5F));

		PartDefinition upperJaw3 = mouth3.addOrReplaceChild("upperJaw3",
				CubeListBuilder.create().texOffs(36, 8)
						.addBox(-2.0F, -1.0F, -4.25F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(27, 45)
						.addBox(-2.0F, 0.0F, -5.25F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 62)
						.addBox(-3.0F, 0.0F, -4.25F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(46, 61)
						.addBox(2.0F, 0.0F, -4.25F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 38)
						.addBox(-2.0F, 0.0F, -4.25F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 8)
						.addBox(2.0F, 0.0F, -4.25F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, -6.75F));

		PartDefinition frontLeftEye3 = frontHead.addOrReplaceChild("frontLeftEye3", CubeListBuilder.create()
				.texOffs(80, 35).addBox(-2.0F, -1.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, -2.0F, 3.0F));

		PartDefinition frontRightEye3 = frontHead.addOrReplaceChild("frontRightEye3", CubeListBuilder.create()
				.texOffs(80, 30).addBox(0.0F, -1.0F, -7.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, -2.0F, 3.0F));

		PartDefinition backRightEye3 = frontHead.addOrReplaceChild("backRightEye3", CubeListBuilder.create()
				.texOffs(80, 26).addBox(0.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, -3.0F, 1.0F));

		PartDefinition centerEye3 = frontHead.addOrReplaceChild("centerEye3", CubeListBuilder.create().texOffs(66, 80)
				.addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -3.0F, 2.0F));

		PartDefinition backLeftEye3 = frontHead.addOrReplaceChild("backLeftEye3", CubeListBuilder.create()
				.texOffs(80, 6).addBox(-2.0F, -1.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.0F, -3.0F, 1.0F));

		PartDefinition rearHead = partdefinition.addOrReplaceChild("rearHead", CubeListBuilder.create().texOffs(36, 19)
				.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 14.0F, 9.0F));

		PartDefinition mouth2 = rearHead.addOrReplaceChild("mouth2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition lowerJaw2 = mouth2.addOrReplaceChild("lowerJaw2",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-1.0F, 0.5F, 0.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(38, 67)
						.addBox(-1.0F, -0.5F, 6.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(30, 63)
						.addBox(-2.0F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(62, 8)
						.addBox(1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 40)
						.addBox(-1.0F, -0.5F, 1.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(27, 38)
						.addBox(1.0F, -1.5F, 1.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.5F, -1.0F));

		PartDefinition upperJaw2 = mouth2.addOrReplaceChild("upperJaw2",
				CubeListBuilder.create().texOffs(36, 8)
						.addBox(-2.0F, -1.0F, -1.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(27, 45)
						.addBox(-2.0F, 0.0F, 5.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 62)
						.addBox(-3.0F, 0.0F, -1.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(46, 61)
						.addBox(2.0F, 0.0F, -1.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 38)
						.addBox(-2.0F, 0.0F, 0.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 8)
						.addBox(2.0F, 0.0F, 0.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition frontLeftEye2 = rearHead.addOrReplaceChild("frontLeftEye2", CubeListBuilder.create()
				.texOffs(80, 35).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, -2.0F, 5.0F));

		PartDefinition frontRightEye2 = rearHead.addOrReplaceChild("frontRightEye2", CubeListBuilder.create()
				.texOffs(80, 30).addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, -2.0F, 5.0F));

		PartDefinition backRightEye2 = rearHead.addOrReplaceChild("backRightEye2", CubeListBuilder.create()
				.texOffs(80, 26).addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, -3.0F, 3.0F));

		PartDefinition centerEye2 = rearHead.addOrReplaceChild("centerEye2", CubeListBuilder.create().texOffs(66, 80)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -3.0F, 4.0F));

		PartDefinition backLeftEye2 = rearHead.addOrReplaceChild("backLeftEye2", CubeListBuilder.create().texOffs(80, 6)
				.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.0F, -3.0F, 3.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 12.3125F, 1.9375F));

		PartDefinition torso = body.addOrReplaceChild("torso",
				CubeListBuilder.create().texOffs(0, 36)
						.addBox(-4.0F, 0.8F, -1.8F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(27, 36)
						.addBox(-5.0F, 0.8F, 4.2F, 10.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(27, 36)
						.addBox(-5.0F, 0.8F, -6.8F, 10.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-5.0F, -2.2F, -6.8F, 10.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 19)
						.addBox(-5.0F, -3.2F, -6.8F, 10.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -0.1125F, -2.1375F));

		PartDefinition midRightTentacle = body.addOrReplaceChild("midRightTentacle", CubeListBuilder.create(),
				PartPose.offset(0.0F, 11.6875F, -1.9375F));

		PartDefinition mrSeg1 = midRightTentacle.addOrReplaceChild("mrSeg1", CubeListBuilder.create().texOffs(67, 68)
				.addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, -16.0F, 2.5F));

		PartDefinition mrSeg2 = midRightTentacle.addOrReplaceChild("mrSeg2", CubeListBuilder.create().texOffs(58, 80)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, -18.0F, 1.0F));

		PartDefinition mrSeg3 = midRightTentacle.addOrReplaceChild("mrSeg3", CubeListBuilder.create().texOffs(34, 80)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, -20.0F, 2.0F));

		PartDefinition mrSeg4 = midRightTentacle.addOrReplaceChild("mrSeg4", CubeListBuilder.create().texOffs(42, 80)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, -22.0F, 1.0F));

		PartDefinition mrSeg5 = midRightTentacle.addOrReplaceChild("mrSeg5", CubeListBuilder.create().texOffs(20, 80)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, -24.0F, 2.0F));

		PartDefinition mrSeg6 = midRightTentacle.addOrReplaceChild("mrSeg6", CubeListBuilder.create().texOffs(30, 62)
				.addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, -26.0F, 0.5F));

		PartDefinition midLeftTentacle = body.addOrReplaceChild("midLeftTentacle", CubeListBuilder.create(),
				PartPose.offset(-7.0F, -13.3125F, 12.0625F));

		PartDefinition mlSeg1 = midLeftTentacle.addOrReplaceChild("mlSeg1", CubeListBuilder.create().texOffs(41, 68)
				.addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 9.0F, -11.5F));

		PartDefinition mlSeg2 = midLeftTentacle.addOrReplaceChild("mlSeg2", CubeListBuilder.create().texOffs(76, 45)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 7.0F, -12.0F));

		PartDefinition mlSeg3 = midLeftTentacle.addOrReplaceChild("mlSeg3", CubeListBuilder.create().texOffs(76, 11)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 5.0F, -11.0F));

		PartDefinition mlSeg4 = midLeftTentacle.addOrReplaceChild("mlSeg4", CubeListBuilder.create().texOffs(76, 18)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 3.0F, -10.0F));

		PartDefinition mlSeg5 = midLeftTentacle.addOrReplaceChild("mlSeg5", CubeListBuilder.create().texOffs(71, 76)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 1.0F, -11.0F));

		PartDefinition mlSeg6 = midLeftTentacle.addOrReplaceChild("mlSeg6", CubeListBuilder.create().texOffs(52, 15)
				.addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, -1.0F, -9.5F));

		PartDefinition frontRightTentacle = body.addOrReplaceChild("frontRightTentacle", CubeListBuilder.create(),
				PartPose.offset(0.0F, -13.3125F, 20.0625F));

		PartDefinition frSeg1 = frontRightTentacle.addOrReplaceChild("frSeg1", CubeListBuilder.create().texOffs(70, 8)
				.addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 10.5F, -12.0F));

		PartDefinition frSeg2 = frontRightTentacle.addOrReplaceChild("frSeg2", CubeListBuilder.create().texOffs(78, 0)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 8.0F, -11.0F));

		PartDefinition frSeg3 = frontRightTentacle.addOrReplaceChild("frSeg3", CubeListBuilder.create().texOffs(52, 78)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 6.0F, -13.0F));

		PartDefinition frSeg4 = frontRightTentacle.addOrReplaceChild("frSeg4", CubeListBuilder.create().texOffs(77, 78)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 4.0F, -14.0F));

		PartDefinition frSeg5 = frontRightTentacle.addOrReplaceChild("frSeg5", CubeListBuilder.create().texOffs(28, 78)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 2.0F, -13.0F));

		PartDefinition frSeg6 = frontRightTentacle.addOrReplaceChild("frSeg6", CubeListBuilder.create().texOffs(46, 61)
				.addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 0.0F, -14.5F));

		PartDefinition frontLeftTentacle = body.addOrReplaceChild("frontLeftTentacle", CubeListBuilder.create(),
				PartPose.offset(-6.0F, -13.3125F, 20.0625F));

		PartDefinition flSeg1 = frontLeftTentacle.addOrReplaceChild("flSeg1", CubeListBuilder.create().texOffs(30, 70)
				.addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 10.5F, -12.0F));

		PartDefinition flSeg2 = frontLeftTentacle.addOrReplaceChild("flSeg2", CubeListBuilder.create().texOffs(0, 75)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 8.0F, -13.0F));

		PartDefinition flSeg3 = frontLeftTentacle.addOrReplaceChild("flSeg3", CubeListBuilder.create().texOffs(76, 53)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 6.0F, -11.0F));

		PartDefinition flSeg4 = frontLeftTentacle.addOrReplaceChild("flSeg4", CubeListBuilder.create().texOffs(6, 78)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 4.0F, -10.0F));

		PartDefinition flSeg5 = frontLeftTentacle.addOrReplaceChild("flSeg5", CubeListBuilder.create().texOffs(76, 49)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 2.0F, -11.0F));

		PartDefinition flSeg6 = frontLeftTentacle.addOrReplaceChild("flSeg6", CubeListBuilder.create().texOffs(60, 2)
				.addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 0.0F, -9.5F));

		PartDefinition rearTentacle = body.addOrReplaceChild("rearTentacle", CubeListBuilder.create(),
				PartPose.offset(-3.0F, -11.3125F, 2.0625F));

		PartDefinition rearSeg1 = rearTentacle.addOrReplaceChild("rearSeg1", CubeListBuilder.create().texOffs(51, 68)
				.addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 9.0F, -11.5F));

		PartDefinition rearSeg2 = rearTentacle.addOrReplaceChild("rearSeg2", CubeListBuilder.create().texOffs(12, 80)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 7.0F, -12.0F));

		PartDefinition rearSeg4 = rearTentacle.addOrReplaceChild("rearSeg4", CubeListBuilder.create().texOffs(0, 80)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 3.0F, -10.0F));

		PartDefinition rearSeg3 = rearTentacle.addOrReplaceChild("rearSeg3", CubeListBuilder.create().texOffs(79, 74)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 5.0F, -11.0F));

		PartDefinition rearSeg5 = rearTentacle.addOrReplaceChild("rearSeg5", CubeListBuilder.create().texOffs(78, 60)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 1.0F, -11.0F));

		PartDefinition rearSeg6 = rearTentacle.addOrReplaceChild("rearSeg6", CubeListBuilder.create().texOffs(22, 62)
				.addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, -1.0F, -9.5F));

		PartDefinition midTentacle = body.addOrReplaceChild("midTentacle", CubeListBuilder.create(),
				PartPose.offset(-3.0F, -13.3125F, 15.0625F));

		PartDefinition mTSeg1 = midTentacle.addOrReplaceChild("mTSeg1", CubeListBuilder.create().texOffs(65, 34).addBox(
				-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 9.0F, -11.5F));

		PartDefinition mTSeg2 = midTentacle.addOrReplaceChild("mTSeg2", CubeListBuilder.create().texOffs(74, 67).addBox(
				-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 7.0F, -12.0F));

		PartDefinition mTSeg3 = midTentacle.addOrReplaceChild("mTSeg3", CubeListBuilder.create().texOffs(74, 4).addBox(
				-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 5.0F, -13.0F));

		PartDefinition mTSeg4 = midTentacle.addOrReplaceChild("mTSeg4", CubeListBuilder.create().texOffs(74, 28).addBox(
				-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 3.0F, -12.0F));

		PartDefinition mTSeg5 = midTentacle.addOrReplaceChild("mTSeg5", CubeListBuilder.create().texOffs(8, 74).addBox(
				-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 1.0F, -13.0F));

		PartDefinition mTSeg6 = midTentacle.addOrReplaceChild("mTSeg6", CubeListBuilder.create().texOffs(10, 13)
				.addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, -1.0F, -11.5F));

		PartDefinition midTentacle2 = body.addOrReplaceChild("midTentacle2", CubeListBuilder.create(),
				PartPose.offset(-3.0F, -13.3125F, 8.0625F));

		PartDefinition mTSeg7 = midTentacle2.addOrReplaceChild("mTSeg7", CubeListBuilder.create().texOffs(65, 34)
				.addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 9.0F, -11.5F));

		PartDefinition mTSeg8 = midTentacle2.addOrReplaceChild("mTSeg8", CubeListBuilder.create().texOffs(74, 67)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 7.0F, -12.0F));

		PartDefinition mTSeg9 = midTentacle2.addOrReplaceChild("mTSeg9", CubeListBuilder.create().texOffs(74, 4).addBox(
				-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 5.0F, -13.0F));

		PartDefinition mTSeg10 = midTentacle2.addOrReplaceChild("mTSeg10", CubeListBuilder.create().texOffs(74, 28)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 3.0F, -12.0F));

		PartDefinition mTSeg11 = midTentacle2.addOrReplaceChild("mTSeg11", CubeListBuilder.create().texOffs(8, 74)
				.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 1.0F, -13.0F));

		PartDefinition mTSeg12 = midTentacle2.addOrReplaceChild("mTSeg12", CubeListBuilder.create().texOffs(10, 13)
				.addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, -1.0F, -11.5F));

		PartDefinition rearRightBrain = body.addOrReplaceChild("rearRightBrain",
				CubeListBuilder.create().texOffs(58, 41).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, -3.8125F, -7.9375F, 0.0F, 0.0F, 0.3054F));

		PartDefinition rearLeftBrain = body.addOrReplaceChild("rearLeftBrain",
				CubeListBuilder.create().texOffs(56, 48).addBox(-1.9537F, -0.8007F, -2.0F, 4.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, -3.8125F, -7.9375F, 0.0F, 0.0F, -0.3054F));

		PartDefinition midLeftBrain = body.addOrReplaceChild("midLeftBrain",
				CubeListBuilder.create().texOffs(56, 21).addBox(-1.0F, -0.5F, -3.0F, 4.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, -3.8125F, -1.9375F, 0.0F, 0.0F, -0.3054F));

		PartDefinition cube_r1 = midLeftBrain.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(56, 21).addBox(2.0872F, -2.9981F, -11.0F, 4.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 0.5F, 10.0F, 0.0F, 0.0F, 1.8762F));

		PartDefinition midRightBrain = body.addOrReplaceChild("midRightBrain",
				CubeListBuilder.create().texOffs(0, 7).addBox(-2.0F, -0.5F, -3.0F, 4.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -3.8125F, -1.9375F, 0.0F, 0.0F, 0.3054F));

		PartDefinition cube_r2 = midRightBrain
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(0, 7).addBox(3.1056F, -5.3726F, -11.0F, 4.0F, 2.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-3.0F, 0.5F, 10.0F, 0.0F, 0.0F, 1.309F));

		PartDefinition frontRightBrain = body.addOrReplaceChild("frontRightBrain",
				CubeListBuilder.create().texOffs(58, 58).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, -3.8125F, 4.0625F, 0.0F, 0.0F, 0.3054F));

		PartDefinition frontLeftBrain = body.addOrReplaceChild("frontLeftBrain",
				CubeListBuilder.create().texOffs(52, 35).addBox(-1.9397F, -0.842F, -2.0F, 4.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, -3.8125F, 4.0625F, 0.0F, 0.0F, -0.3491F));

		PartDefinition leftFrontLeg = partdefinition.addOrReplaceChild("leftFrontLeg",
				CubeListBuilder.create().texOffs(18, 49)
						.addBox(-3.0F, -2.5F, -2.5F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(65, 73)
						.addBox(-4.0F, -2.5F, -3.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(38, 54)
						.addBox(-4.0F, -2.5F, 3.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 73)
						.addBox(-2.0F, -2.5F, -3.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 60)
						.addBox(-2.0F, -2.5F, 3.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(60, 0)
						.addBox(-2.0F, -4.5F, -2.5F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(14, 60)
						.addBox(-4.0F, -4.5F, -2.5F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(20, 69)
						.addBox(-3.0F, 2.5F, -2.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(50, 30)
						.addBox(-4.0F, 9.5F, -1.5F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(80, 64)
						.addBox(1.0F, 9.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(77, 71)
						.addBox(-3.0F, 9.5F, 2.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 57)
						.addBox(-3.0F, 9.5F, -2.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(80, 42)
						.addBox(-5.0F, 9.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(73, 15)
						.addBox(-4.0F, 6.5F, 2.5F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(71, 73)
						.addBox(-4.0F, 6.5F, -1.5F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(62, 50)
						.addBox(1.0F, 6.5F, -1.5F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(60, 11)
						.addBox(-4.0F, 6.5F, -1.5F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 68)
						.addBox(-3.0F, 4.5F, -0.5F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 13.5F, 6.5F, 0.0F, 0.0F, 0.0F));

		PartDefinition leftFrontLegEye = leftFrontLeg.addOrReplaceChild("leftFrontLegEye", CubeListBuilder.create()
				.texOffs(10, 68).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 0.0F, 1.0F));

		PartDefinition rightFrontLeg = partdefinition.addOrReplaceChild("rightFrontLeg",
				CubeListBuilder.create().texOffs(0, 49)
						.addBox(0.0F, -2.5F, -2.5F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(42, 73)
						.addBox(3.0F, -2.5F, -3.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 49)
						.addBox(3.0F, -2.5F, 3.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 73)
						.addBox(1.0F, -2.5F, -3.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(36, 8)
						.addBox(1.0F, -2.5F, 3.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 60)
						.addBox(1.0F, -4.5F, -2.5F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(38, 59)
						.addBox(3.0F, -4.5F, -2.5F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(68, 47)
						.addBox(0.0F, 2.5F, -2.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(50, 8)
						.addBox(-1.0F, 9.5F, -1.5F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(80, 39)
						.addBox(4.0F, 9.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(68, 4)
						.addBox(0.0F, 9.5F, 2.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(54, 64)
						.addBox(0.0F, 9.5F, -2.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(78, 22)
						.addBox(-2.0F, 9.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(72, 34)
						.addBox(-1.0F, 6.5F, 2.5F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(72, 25)
						.addBox(-1.0F, 6.5F, -1.5F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(56, 23)
						.addBox(4.0F, 6.5F, -1.5F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(54, 55)
						.addBox(-1.0F, 6.5F, -1.5F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(64, 27)
						.addBox(0.0F, 4.5F, -0.5F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, 13.5F, 6.5F, 0.0F, 0.0F, 0.0F));

		PartDefinition rightFrontLegEye = rightFrontLeg.addOrReplaceChild("rightFrontLegEye", CubeListBuilder.create()
				.texOffs(12, 49).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, 0.0F, 1.0F));

		PartDefinition leftBackLeg = partdefinition.addOrReplaceChild("leftBackLeg",
				CubeListBuilder.create().texOffs(44, 48)
						.addBox(-3.0F, -2.5F, -3.5F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(24, 73)
						.addBox(-4.0F, -2.5F, -4.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 27)
						.addBox(-4.0F, -2.5F, 2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 73)
						.addBox(-2.0F, -2.5F, -4.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 19)
						.addBox(-2.0F, -2.5F, 2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(30, 54)
						.addBox(-2.0F, -4.5F, -3.5F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(52, 13)
						.addBox(-4.0F, -4.5F, -3.5F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(68, 21)
						.addBox(-3.0F, 2.5F, -0.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(44, 43)
						.addBox(-4.0F, 9.5F, -2.5F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(30, 75)
						.addBox(1.0F, 9.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 60)
						.addBox(-3.0F, 9.5F, 1.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(46, 59)
						.addBox(-3.0F, 9.5F, -3.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 68)
						.addBox(-5.0F, 9.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(70, 64)
						.addBox(-4.0F, 6.5F, 1.5F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(70, 59)
						.addBox(-4.0F, 6.5F, -2.5F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(8, 26)
						.addBox(1.0F, 6.5F, -2.5F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(8, 23)
						.addBox(-4.0F, 6.5F, -2.5F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(60, 64)
						.addBox(-3.0F, 4.5F, -1.5F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0F, 13.5F, -4.5F, 0.0F, 0.0F, 0.0F));

		PartDefinition leftBackLegEye = leftBackLeg.addOrReplaceChild("leftBackLegEye", CubeListBuilder.create()
				.texOffs(66, 15).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 0.0F, 0.0F));

		PartDefinition rightBackLeg = partdefinition.addOrReplaceChild("rightBackLeg",
				CubeListBuilder.create().texOffs(32, 43)
						.addBox(0.0F, -2.5F, -3.5F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(59, 71)
						.addBox(3.0F, -2.5F, -4.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 0)
						.addBox(3.0F, -2.5F, 2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(70, 52)
						.addBox(1.0F, -2.5F, -4.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(1.0F, -2.5F, 2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 27)
						.addBox(1.0F, -4.5F, -3.5F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 19)
						.addBox(3.0F, -4.5F, -3.5F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(68, 0)
						.addBox(0.0F, 2.5F, -0.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(36, 29)
						.addBox(-1.0F, 9.5F, -2.5F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(30, 65)
						.addBox(4.0F, 9.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(58, 0)
						.addBox(0.0F, 9.5F, 1.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(52, 21)
						.addBox(0.0F, 9.5F, -3.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 62)
						.addBox(-2.0F, 9.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(70, 42)
						.addBox(-1.0F, 6.5F, 1.5F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(70, 39)
						.addBox(-1.0F, 6.5F, -2.5F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(8, 18)
						.addBox(4.0F, 6.5F, -2.5F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(8, 15)
						.addBox(-1.0F, 6.5F, -2.5F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 36)
						.addBox(0.0F, 4.5F, -1.5F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 13.5F, -4.5F));

		PartDefinition rightBackLegEye = rightBackLeg.addOrReplaceChild("rightBackLegEye", CubeListBuilder.create()
				.texOffs(8, 60).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	public final ModelPart frontHead;
	public final ModelPart rearHead;
	private final ModelPart body;
	private final ModelPart leftFrontLeg;
	private final ModelPart rightFrontLeg;
	private final ModelPart leftBackLeg;

	private final ModelPart rightBackLeg;

	public ModelDarkYoung(ModelPart root) {
		this.frontHead = root.getChild("frontHead");
		this.rearHead = root.getChild("rearHead");
		this.body = root.getChild("body");
		this.leftFrontLeg = root.getChild("leftFrontLeg");
		this.rightFrontLeg = root.getChild("rightFrontLeg");
		this.leftBackLeg = root.getChild("leftBackLeg");
		this.rightBackLeg = root.getChild("rightBackLeg");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		frontHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rearHead.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftBackLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightBackLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(EntityDarkYoung entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

	}
}