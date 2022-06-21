package com.vincenthuto.forcesofreality.model.entity.lord;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.lord.EntityLordOfTheWild;

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

public class ModelLordOfTheWild extends EntityModel<EntityLordOfTheWild> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modellordofthewild"), "main");
	private final ModelPart wholebody;

	public ModelLordOfTheWild(ModelPart root) {
		this.wholebody = root.getChild("wholebody");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition wholebody = partdefinition.addOrReplaceChild("wholebody", CubeListBuilder.create(),
				PartPose.offset(0.0F, -1.0F, -3.0F));

		PartDefinition bLLeg = wholebody.addOrReplaceChild("bLLeg", CubeListBuilder.create(),
				PartPose.offset(6.0F, 2.0F, 15.0F));

		PartDefinition bLTibia = bLLeg.addOrReplaceChild("bLTibia",
				CubeListBuilder.create().texOffs(10, 201)
						.addBox(-1.0F, -1.1F, -1.6F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(72, 181)
						.addBox(-0.5F, 0.9F, 0.4F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(98, 201)
						.addBox(-0.5F, 0.9F, 1.4F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 9.0F, 3.0F));

		PartDefinition bLFoot = bLTibia.addOrReplaceChild("bLFoot", CubeListBuilder.create(),
				PartPose.offset(0.5F, 10.5F, 0.0F));

		PartDefinition cube_r1 = bLFoot
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, 211).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 0.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.1F, 0.9F, -0.7F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bLFoot
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(0, 193).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.1F, 0.9F, -0.6F, 0.829F, 0.0F, 0.0F));

		PartDefinition duClaw = bLFoot.addOrReplaceChild("duClaw", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.1F, 2.2426F, 6.9669F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r3 = duClaw.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(48, 216).addBox(-1.3F, 6.5F, 0.5273F, 1.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -4.2426F, -5.6669F, -0.1309F, 0.0F, 0.0F));

		PartDefinition nail = bLFoot.addOrReplaceChild("nail", CubeListBuilder.create(),
				PartPose.offsetAndRotation(1.1F, 2.4F, 2.4F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r4 = nail.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(54, 216).addBox(-3.224F, -3.9426F, -3.3224F, 1.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, -1.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition cube_r5 = nail.addOrReplaceChild(
				"cube_r5", CubeListBuilder.create().texOffs(60, 216).addBox(-1.6405F, -3.8719F, -3.6411F, 1.0F, 1.0F,
						2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, -1.0F, 0.0F, 0.0873F, 0.0F));

		PartDefinition bLHip = bLLeg.addOrReplaceChild("bLHip", CubeListBuilder.create().texOffs(98, 125).addBox(-1.0F,
				-5.0F, -12.0F, 2.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -0.1F, 8.4F));

		PartDefinition femur = bLHip.addOrReplaceChild("femur", CubeListBuilder.create().texOffs(52, 156).addBox(-1.0F,
				-8.0F, -6.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 1.0F));

		PartDefinition bRLeg = wholebody.addOrReplaceChild("bRLeg", CubeListBuilder.create(),
				PartPose.offset(-6.0F, 2.0F, 15.0F));

		PartDefinition bRTibia = bRLeg.addOrReplaceChild("bRTibia",
				CubeListBuilder.create().texOffs(0, 201)
						.addBox(-2.0F, -1.1F, -1.6F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(66, 181)
						.addBox(-1.5F, 0.9F, 0.4F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(92, 201)
						.addBox(-1.5F, 0.9F, 1.4F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, 9.0F, 3.0F));

		PartDefinition bRFoot = bRTibia.addOrReplaceChild("bRFoot", CubeListBuilder.create(),
				PartPose.offset(-0.5F, 10.5F, 0.0F));

		PartDefinition cube_r6 = bRFoot
				.addOrReplaceChild("cube_r6",
						CubeListBuilder.create().texOffs(0, 208).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 0.0F, 3.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-0.1F, 0.9F, -0.7F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_r7 = bRFoot
				.addOrReplaceChild("cube_r7",
						CubeListBuilder.create().texOffs(54, 181).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-0.1F, 0.9F, -0.6F, 0.829F, 0.0F, 0.0F));

		PartDefinition duClaw2 = bRFoot.addOrReplaceChild("duClaw2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-0.1F, 2.2426F, 6.9669F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r8 = duClaw2.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(42, 216).addBox(-1.7F, 6.5F, 0.5218F, 1.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -4.2426F, -5.6669F, -0.1309F, 0.0F, 0.0F));

		PartDefinition nail2 = bRFoot.addOrReplaceChild("nail2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.9F, 2.4F, 2.4F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r9 = nail2.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(30, 216).addBox(-3.224F, -3.9426F, -3.3224F, 1.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, -1.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition cube_r10 = nail2.addOrReplaceChild(
				"cube_r10", CubeListBuilder.create().texOffs(36, 216).addBox(-1.6405F, -3.8719F, -3.6411F, 1.0F, 1.0F,
						2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, 0.0F, -1.0F, 0.0F, 0.0873F, 0.0F));

		PartDefinition bRHip = bRLeg.addOrReplaceChild("bRHip", CubeListBuilder.create().texOffs(80, 125).addBox(-2.0F,
				-5.0F, -3.0F, 2.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -0.1F, -0.6F));

		PartDefinition bRFemur = bRHip.addOrReplaceChild("bRFemur", CubeListBuilder.create().texOffs(40, 156).addBox(
				-3.0F, -8.0F, -6.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 10.0F));

		PartDefinition neck = wholebody.addOrReplaceChild("neck",
				CubeListBuilder.create().texOffs(84, 66).addBox(-2.5F, -5.0F, -2.0F, 7.0F, 10.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -4.1F, -17.6F, 0.6545F, 0.0F, 0.0F));

		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-3.4593F, -5.3659F, -14.4158F, 7.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(74, 170)
				.addBox(-1.4593F, -4.2894F, -15.4574F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(94, 216)
				.addBox(-2.4693F, -1.4531F, -14.2807F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(96, 216)
				.addBox(2.5417F, -1.4531F, -14.2807F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(82, 216)
				.addBox(-2.4693F, -1.8223F, -11.4765F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(84, 216)
				.addBox(2.5417F, -1.8223F, -11.4765F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 22)
				.addBox(-3.4593F, -8.3217F, -6.372F, 7.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(72, 44)
				.addBox(-2.4593F, -10.7018F, -4.5457F, 5.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(26, 66)
				.addBox(-2.4593F, -7.1921F, -12.7738F, 5.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(20, 162)
				.addBox(3.5407F, -9.1371F, -1.7741F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(20, 156)
				.addBox(-10.4593F, -9.1371F, -1.7741F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(20, 156)
				.addBox(-9.4593F, -9.9305F, -1.1654F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(20, 156)
				.addBox(4.5407F, -9.9305F, -1.1654F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 162)
				.addBox(-16.4593F, -9.5063F, 1.0301F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 162)
				.addBox(-15.4593F, -9.9084F, 1.8455F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 162)
				.addBox(9.5407F, -9.9084F, 1.8455F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 170)
				.addBox(-21.4593F, -10.8864F, 2.8564F, 7.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(64, 161)
				.addBox(-17.4593F, -11.6247F, 8.4648F, 7.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(6, 160)
				.addBox(-18.4593F, -11.6247F, 9.4648F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(64, 161)
				.addBox(-16.4593F, -12.4181F, 9.0736F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(64, 161)
				.addBox(11.2407F, -13.5877F, 8.2064F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 156)
				.addBox(9.5407F, -9.5063F, 1.0301F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(78, 142)
				.addBox(8.0407F, -10.4843F, 3.041F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(60, 142)
				.addBox(-11.4593F, -10.4843F, 3.041F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(3, 159)
				.addBox(-8.4593F, -10.4843F, 4.041F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(3, 159)
				.addBox(7.0407F, -10.4843F, 4.041F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 175)
				.addBox(14.5407F, -10.8864F, 2.8564F, 7.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(6, 171)
				.addBox(21.5407F, -10.8864F, 3.8564F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(6, 171)
				.addBox(-22.4593F, -10.8864F, 3.8564F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 175)
				.addBox(15.5407F, -11.6797F, 3.4651F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 175)
				.addBox(-20.4593F, -11.6797F, 3.4651F, 5.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(64, 156)
				.addBox(10.0407F, -12.2335F, 7.6715F, 7.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(3, 162)
				.addBox(17.0407F, -12.2335F, 8.6715F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.9593F, -7.3562F, 1.0022F));

		PartDefinition centerMane = head.addOrReplaceChild("centerMane", CubeListBuilder.create(),
				PartPose.offset(0.0407F, -6.1205F, 4.1817F));

		PartDefinition mane = centerMane.addOrReplaceChild("mane",
				CubeListBuilder.create().texOffs(0, 97)
						.addBox(-1.5F, -1.1779F, 0.3711F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 142)
						.addBox(0.201F, 1.8221F, 0.3711F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.255F, -1.3474F, -0.3927F, 0.0F, 0.0F));

		PartDefinition mane2 = mane.addOrReplaceChild("mane2",
				CubeListBuilder.create().texOffs(48, 112)
						.addBox(-1.0F, -1.9241F, -0.5495F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
						.texOffs(20, 142).addBox(0.2F, 1.0759F, -0.5495F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.6747F, 9.947F, -0.5236F, 0.0F, 0.0F));

		PartDefinition mane3 = mane2.addOrReplaceChild("mane3",
				CubeListBuilder.create().texOffs(58, 125)
						.addBox(-0.4F, -3.5035F, -0.3238F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(50, 97)
						.addBox(0.101F, -0.5035F, -1.3238F, 0.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.2946F, 8.9621F, 0.3927F, 0.0F, 0.0F));

		PartDefinition mane4 = mane3.addOrReplaceChild("mane4",
				CubeListBuilder.create().texOffs(40, 142).addBox(0.5F, -2.6377F, -1.1033F, 0.0F, 3.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.4F, -0.3934F, 9.4501F, -0.48F, 0.0F, 0.0F));

		PartDefinition leftMane = head.addOrReplaceChild("leftMane", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0407F, -6.1205F, 4.1817F, 0.3927F, 0.3054F, 0.0F));

		PartDefinition mane5 = leftMane.addOrReplaceChild("mane5",
				CubeListBuilder.create().texOffs(0, 97)
						.addBox(-1.5F, -1.1779F, 0.3711F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 142)
						.addBox(0.201F, 1.8221F, 0.3711F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.255F, -1.3474F, -0.3927F, 0.0F, 0.0F));

		PartDefinition mane6 = mane5.addOrReplaceChild("mane6",
				CubeListBuilder.create().texOffs(48, 112)
						.addBox(-1.0F, -1.9241F, -0.5495F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
						.texOffs(20, 142).addBox(0.2F, 1.0759F, -0.5495F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.6747F, 9.947F, -0.5236F, 0.0F, 0.0F));

		PartDefinition mane7 = mane6.addOrReplaceChild("mane7",
				CubeListBuilder.create().texOffs(58, 125)
						.addBox(-0.4F, -3.5035F, -0.3238F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(50, 97)
						.addBox(0.101F, -0.5035F, -1.3238F, 0.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.2946F, 8.9621F, 0.3927F, 0.0F, 0.0F));

		PartDefinition mane8 = mane7.addOrReplaceChild("mane8",
				CubeListBuilder.create().texOffs(40, 142).addBox(0.5F, -2.6377F, -1.1033F, 0.0F, 3.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.4F, -0.3934F, 9.4501F, -0.48F, 0.0F, 0.0F));

		PartDefinition rightMane = head.addOrReplaceChild("rightMane", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0407F, -6.1205F, 4.1817F, 0.3927F, -0.3054F, 0.0F));

		PartDefinition mane9 = rightMane.addOrReplaceChild("mane9",
				CubeListBuilder.create().texOffs(0, 97)
						.addBox(-1.5F, -1.1779F, 0.3711F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 142)
						.addBox(0.201F, 1.8221F, 0.3711F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.255F, -1.3474F, -0.3927F, 0.0F, 0.0F));

		PartDefinition mane10 = mane9.addOrReplaceChild("mane10",
				CubeListBuilder.create().texOffs(48, 112)
						.addBox(-1.0F, -1.9241F, -0.5495F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
						.texOffs(20, 142).addBox(0.2F, 1.0759F, -0.5495F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.6747F, 9.947F, -0.5236F, 0.0F, 0.0F));

		PartDefinition mane11 = mane10.addOrReplaceChild("mane11",
				CubeListBuilder.create().texOffs(58, 125)
						.addBox(-0.4F, -3.5035F, -0.3238F, 1.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(50, 97)
						.addBox(0.101F, -0.5035F, -1.3238F, 0.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.2946F, 8.9621F, 0.3927F, 0.0F, 0.0F));

		PartDefinition mane12 = mane11.addOrReplaceChild("mane12",
				CubeListBuilder.create().texOffs(40, 142).addBox(0.5F, -2.6377F, -1.1033F, 0.0F, 3.0F, 10.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.4F, -0.3934F, 9.4501F, -0.48F, 0.0F, 0.0F));

		PartDefinition bottomJaw = head.addOrReplaceChild("bottomJaw", CubeListBuilder.create().texOffs(106, 82)
				.addBox(-2.5F, -0.9462F, -8.7063F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(88, 216)
				.addBox(-2.499F, -2.9462F, -8.7063F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(86, 216)
				.addBox(2.501F, -2.9462F, -8.7063F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(108, 216)
				.addBox(-2.5F, -1.9462F, -0.7063F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(102, 216)
				.addBox(2.5F, -1.9462F, -0.7063F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(106, 216)
				.addBox(-2.499F, -1.8944F, -3.2671F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(100, 216)
				.addBox(2.501F, -1.8944F, -3.2671F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(104, 216)
				.addBox(-2.499F, -1.8795F, -5.5474F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(98, 216)
				.addBox(2.501F, -1.8795F, -5.5474F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(80, 193)
				.addBox(-1.5F, -0.9364F, -9.9069F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0407F, -0.398F, -4.7535F));

		PartDefinition rightEye = head.addOrReplaceChild("rightEye",
				CubeListBuilder.create().texOffs(60, 201)
						.addBox(-0.45F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(78, 216)
						.addBox(-0.55F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.4093F, -6.3587F, -4.5971F));

		PartDefinition leftEye = head.addOrReplaceChild("leftEye",
				CubeListBuilder.create().texOffs(52, 201)
						.addBox(-0.55F, -1.5F, -1.5F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(74, 216)
						.addBox(-0.45F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.4907F, -6.3587F, -4.5971F));

		PartDefinition lTusk = head.addOrReplaceChild("lTusk",
				CubeListBuilder.create().texOffs(24, 112)
						.addBox(5.0F, -10.1783F, -6.4413F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
						.texOffs(70, 193).addBox(5.0F, -11.0816F, -8.8319F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
						.texOffs(24, 165).addBox(5.5F, -11.0317F, -9.7525F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
						.texOffs(2, 171).addBox(7.0F, -9.575F, -5.1369F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
						.texOffs(28, 187).addBox(4.5F, -13.0803F, 0.3906F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
						.texOffs(12, 174).addBox(7.5F, -12.0803F, 1.3906F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
						.texOffs(20, 201).addBox(5.5F, -11.254F, 2.7707F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.9593F, 9.7362F, -2.8285F));

		PartDefinition rTusk = head.addOrReplaceChild("rTusk",
				CubeListBuilder.create().texOffs(24, 165)
						.addBox(5.5F, -11.0317F, -9.7525F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 112)
						.addBox(5.0F, -10.1783F, -6.4413F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
						.texOffs(12, 174).addBox(3.5F, -12.0803F, 1.3906F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
						.texOffs(2, 171).addBox(4.0F, -9.575F, -5.1369F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
						.texOffs(60, 193).addBox(5.0F, -11.0816F, -8.8319F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
						.texOffs(28, 181).addBox(4.5F, -13.0803F, 0.3906F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
						.texOffs(28, 201).addBox(5.5F, -11.254F, 2.7707F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-10.9593F, 9.7362F, -2.8285F));

		PartDefinition neck2 = neck.addOrReplaceChild("neck2",
				CubeListBuilder.create().texOffs(96, 112).addBox(-2.6F, -1.7377F, -2.6298F, 6.0F, 7.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.6F, -8.345F, -1.2783F, 0.4363F, 0.0F, 0.0F));

		PartDefinition body = wholebody.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(88, 0)
						.addBox(-3.5F, -12.5F, -13.5F, 9.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 125)
						.addBox(-3.5F, -12.5F, -15.5F, 9.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 181)
						.addBox(5.5F, -12.5F, -15.3F, 3.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(70, 216)
						.addBox(5.5F, -0.5F, -15.3F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(66, 216)
						.addBox(-5.5F, -0.5F, -15.3F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(16, 181)
						.addBox(-6.5F, -12.5F, -15.3F, 3.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(44, 170)
						.addBox(-3.5F, -0.5F, -15.3F, 9.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(62, 170)
						.addBox(-1.5F, -12.5F, -16.5F, 5.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(42, 208)
						.addBox(-1.5F, -4.5F, -16.1F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(10, 220)
						.addBox(-2.5F, -4.5F, -16.1F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(10, 219)
						.addBox(3.5F, -4.5F, -16.1F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(56, 208)
						.addBox(3.5F, -12.5F, -16.1F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(52, 208)
						.addBox(-3.5F, -12.5F, -16.1F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 66)
						.addBox(0.5F, -16.5F, -13.5F, 1.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(52, 82)
						.addBox(-2.6F, -15.5F, -13.5F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 82)
						.addBox(3.6F, -15.5F, -13.5F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(26, 97)
						.addBox(0.5F, -16.5F, 10.5F, 1.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(98, 97)
						.addBox(-2.5F, -15.5F, 10.5F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(74, 97)
						.addBox(3.5F, -15.5F, 10.5F, 1.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(102, 44)
						.addBox(0.5F, -16.1F, -1.5F, 1.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(26, 82)
						.addBox(-2.2F, -15.1F, -1.5F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(110, 66)
						.addBox(2.7F, -15.1F, -1.5F, 1.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 22)
						.addBox(-3.5F, -12.5F, 10.5F, 9.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(46, 0)
						.addBox(-3.5F, -12.1F, -1.5F, 9.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(48, 44)
						.addBox(5.5F, -12.5F, -13.5F, 2.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 44)
						.addBox(5.5F, -12.5F, 12.5F, 2.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(24, 44)
						.addBox(-5.5F, -12.5F, -13.5F, 2.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(104, 22)
						.addBox(-5.5F, -12.5F, 12.5F, 2.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, 8.4F, -2.1F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(78, 82)
				.addBox(-1.3F, -1.5616F, -0.1129F, 3.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(72, 112)
				.addBox(-0.3F, -3.5458F, -0.1678F, 1.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.8F, -11.5F, 21.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create(),
				PartPose.offset(0.2F, -5.079F, 0.7748F));

		PartDefinition cube_r11 = tail2.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(74, 22)
						.addBox(0.0F, 2.9949F, 9.175F, 1.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(56, 66)
						.addBox(-0.5F, 4.3609F, 8.809F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, 1.3829F, -0.4081F, 0.2182F, 0.0F, 0.0F));

		PartDefinition ribs = body.addOrReplaceChild("ribs", CubeListBuilder.create(),
				PartPose.offset(-6.3F, 2.4F, -6.0F));

		PartDefinition bone = ribs.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(52, 193)
						.addBox(1.5F, -5.5F, -0.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 212)
						.addBox(3.5F, -0.8F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.5F, 0.0F, 0.0F));

		PartDefinition bone4 = ribs.addOrReplaceChild("bone4",
				CubeListBuilder.create().texOffs(44, 201)
						.addBox(1.5F, -5.5F, -0.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(26, 208)
						.addBox(3.5F, -1.5F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.5F, 0.0F, 2.9F));

		PartDefinition bone2 = ribs.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(44, 193)
						.addBox(1.5F, -5.5F, -0.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 208)
						.addBox(3.5F, -0.5F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.3F, 0.0F, -3.0F));

		PartDefinition bone3 = ribs.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(20, 193)
						.addBox(1.5F, -6.0F, -0.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(26, 212)
						.addBox(3.5F, 0.0F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.8F, 0.0F, -6.0F));

		PartDefinition bone5 = ribs.addOrReplaceChild("bone5",
				CubeListBuilder.create().texOffs(12, 193)
						.addBox(3.5F, -1.0F, -0.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 208)
						.addBox(1.5F, 5.0F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.8F, -5.0F, -6.0F));

		PartDefinition bone6 = ribs.addOrReplaceChild("bone6",
				CubeListBuilder.create().texOffs(36, 193)
						.addBox(3.5F, -0.5F, -0.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 212)
						.addBox(1.5F, 4.5F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.3F, -5.0F, -3.0F));

		PartDefinition bone7 = ribs.addOrReplaceChild("bone7",
				CubeListBuilder.create().texOffs(28, 193)
						.addBox(3.5F, -0.5F, -0.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 208)
						.addBox(1.5F, 4.2F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.3F, -5.0F, 0.0F));

		PartDefinition bone8 = ribs.addOrReplaceChild("bone8",
				CubeListBuilder.create().texOffs(36, 201)
						.addBox(3.3F, -0.5F, -0.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 212)
						.addBox(1.3F, 3.5F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(6.3F, -5.0F, 3.1F));

		PartDefinition fRLeg = wholebody.addOrReplaceChild("fRLeg", CubeListBuilder.create(),
				PartPose.offset(-6.0F, 1.0F, -11.0F));

		PartDefinition tibiaR = fRLeg.addOrReplaceChild("tibiaR",
				CubeListBuilder.create().texOffs(100, 193)
						.addBox(-1.0F, -2.1F, -1.6F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 181)
						.addBox(-1.0F, -0.1F, 0.4F, 3.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(86, 201)
						.addBox(-0.5F, -0.1F, 1.4F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 11.0F, -3.0F));

		PartDefinition fRFoot = tibiaR.addOrReplaceChild("fRFoot", CubeListBuilder.create(),
				PartPose.offset(2.5F, 9.575F, 13.05F));

		PartDefinition duClaw3 = fRFoot.addOrReplaceChild("duClaw3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 2.1676F, 0.9169F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r12 = duClaw3.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(24, 216).addBox(-3.7F, 10.7566F, -5.2654F, 1.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -4.2426F, -5.6669F, -0.1309F, 0.0F, 0.0F));

		PartDefinition nail3 = fRFoot.addOrReplaceChild("nail3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(1.0F, 2.325F, -3.65F, 0.7854F, 0.0F, 0.0F));

		PartDefinition pawR = fRFoot.addOrReplaceChild("pawR",
				CubeListBuilder.create().texOffs(18, 216)
						.addBox(-2.6F, -1.0F, -8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 219)
						.addBox(-2.1F, -1.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(68, 203)
						.addBox(-2.6F, -1.0F, -6.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 185)
						.addBox(-2.6F, -2.0F, -7.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(12, 216)
						.addBox(-1.1F, -1.0F, -8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(6, 219)
						.addBox(-0.5F, -1.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 216)
						.addBox(0.3F, -1.0F, -8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(4, 219)
						.addBox(0.8F, -1.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(90, 216)
						.addBox(2.0F, -1.0F, -7.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.5F, 4.0F, -8.0F));

		PartDefinition cube_r13 = pawR.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(102, 170).addBox(-1.0F, -0.5F, -2.0F, 3.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.1F, -3.175F, -5.65F, 0.829F, 0.0F, 0.0F));

		PartDefinition hipR = fRLeg.addOrReplaceChild("hipR", CubeListBuilder.create().texOffs(40, 125).addBox(-2.0F,
				-5.0F, -3.0F, 2.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 0.9F, 0.4F));

		PartDefinition femurR = hipR.addOrReplaceChild("femurR",
				CubeListBuilder.create().texOffs(108, 142)
						.addBox(-5.0F, -1.0F, -4.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(32, 170)
						.addBox(-5.0F, -4.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition fLLeg = wholebody.addOrReplaceChild("fLLeg", CubeListBuilder.create(),
				PartPose.offset(6.0F, 2.0F, -11.0F));

		PartDefinition tibiaL = fLLeg.addOrReplaceChild("tibiaL",
				CubeListBuilder.create().texOffs(90, 193)
						.addBox(-2.0F, -2.1F, -1.6F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 181)
						.addBox(-2.0F, -0.1F, 0.4F, 3.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(80, 201)
						.addBox(-1.5F, -0.1F, 1.4F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, 10.0F, -3.0F));

		PartDefinition fLFoot = tibiaL.addOrReplaceChild("fLFoot", CubeListBuilder.create(),
				PartPose.offset(2.5F, 9.575F, 13.05F));

		PartDefinition duClaw4 = fLFoot.addOrReplaceChild("duClaw4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 2.1676F, 0.9169F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r14 = duClaw4.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(0, 216).addBox(-4.7F, 10.7566F, -5.2654F, 1.0F, 1.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -4.2426F, -5.6669F, -0.1309F, 0.0F, 0.0F));

		PartDefinition nail4 = fLFoot.addOrReplaceChild("nail4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(1.0F, 2.325F, -3.65F, 0.7854F, 0.0F, 0.0F));

		PartDefinition pawL = fLFoot.addOrReplaceChild("pawL",
				CubeListBuilder.create().texOffs(66, 208)
						.addBox(-3.5F, -1.0F, -8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(2, 219)
						.addBox(-3.0F, -1.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(92, 216)
						.addBox(-4.3F, -1.0F, -7.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(68, 201)
						.addBox(-4.7F, -1.0F, -6.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 181)
						.addBox(-3.5F, -2.0F, -7.5F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(60, 211)
						.addBox(-2.0F, -1.0F, -8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 219)
						.addBox(-1.4F, -1.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(60, 208)
						.addBox(-0.6F, -1.0F, -8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(110, 216)
						.addBox(-0.1F, -1.0F, -9.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.4F, 4.0F, -8.0F));

		PartDefinition cube_r15 = pawL.addOrReplaceChild("cube_r15",
				CubeListBuilder.create().texOffs(88, 170).addBox(-1.0F, -0.5F, -2.0F, 3.0F, 2.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -3.175F, -5.65F, 0.829F, 0.0F, 0.0F));

		PartDefinition hip4 = fLLeg.addOrReplaceChild("hip4", CubeListBuilder.create().texOffs(22, 125).addBox(-7.0F,
				-5.0F, -12.0F, 2.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(7.5F, -0.1F, 9.4F));

		PartDefinition femur4 = hip4.addOrReplaceChild("femur4",
				CubeListBuilder.create().texOffs(96, 142)
						.addBox(-5.0F, -8.0F, -13.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(20, 170)
						.addBox(-5.0F, -11.0F, -10.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 7.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(EntityLordOfTheWild entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		wholebody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}