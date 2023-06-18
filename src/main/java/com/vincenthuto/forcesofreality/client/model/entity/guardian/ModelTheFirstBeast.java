package com.vincenthuto.forcesofreality.client.model.entity.guardian;
// Made with Blockbench 4.2.5

// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.entity.guardian.EntityTheFirstBeast;

import net.minecraft.client.model.ArmedModel;
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
import net.minecraft.world.entity.HumanoidArm;

public class ModelTheFirstBeast extends EntityModel<EntityTheFirstBeast> implements ArmedModel {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modelthefirstbeast"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition whole = partdefinition.addOrReplaceChild("whole", CubeListBuilder.create(),
				PartPose.offset(0.0F, -14.0F, 3.0F));

		PartDefinition body = whole.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition upperBody = body.addOrReplaceChild("upperBody",
				CubeListBuilder.create().texOffs(0, 16)
						.addBox(-4.75F, -12.0F, -4.0F, 9.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(28, 52)
						.addBox(-4.0F, 4.0F, -1.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(32, 40)
						.addBox(-5.0F, -1.0F, -1.5F, 10.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-7.0F, -9.0F, -3.0F, 14.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 5.0F, -3.0F));

		PartDefinition mane = upperBody.addOrReplaceChild("mane",
				CubeListBuilder.create().texOffs(35, 7)
						.addBox(-5.0F, -28.75F, -12.25F, 9.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(27, 27)
						.addBox(-5.5F, -28.1F, -13.35F, 10.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(8, 19)
						.addBox(-5.5F, -11.1F, -10.85F, 10.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(18, 23)
						.addBox(-5.25F, -9.1F, -11.85F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 23)
						.addBox(3.25F, -9.1F, -11.85F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(36, 84)
						.addBox(-6.5F, -27.0F, -12.25F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 82)
						.addBox(4.5F, -27.0F, -12.25F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(88, 71)
						.addBox(-5.0F, -28.0F, -5.0F, 9.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(88, 71)
						.addBox(-5.0F, -10.75F, -7.15F, 9.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 48)
						.addBox(-6.0F, -26.0F, -7.5F, 11.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.5F, 16.0F, 10.25F));

		PartDefinition bone = mane.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 59).addBox(-3.5F, -2.5F, -2.5F, 7.0F, 5.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.49F, -29.4195F, -9.3763F, 0.3927F, 0.0F, 0.0F));

		PartDefinition mane1 = mane.addOrReplaceChild("mane1",
				CubeListBuilder.create().texOffs(86, 0)
						.addBox(-5.0F, 0.0F, 0.0F, 10.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(86, 0).mirror()
						.addBox(-13.0F, 0.0F, 0.0F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(86, 0).addBox(5.0F, 0.0F, 0.0F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.5F, -25.0F, -4.25F, 0.1745F, 0.0F, 0.0F));

		PartDefinition mane2 = mane1.addOrReplaceChild("mane2", CubeListBuilder.create().texOffs(30, 95)
				.addBox(-4.5F, -0.3666F, 0.0116F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(35, 95)
				.addBox(-8.5F, -0.3666F, 0.0116F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(35, 95).mirror()
				.addBox(4.5F, -0.3666F, 0.0116F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 9.0F, -0.075F, -0.0436F, 0.0F, 0.0F));

		PartDefinition mane3 = mane2.addOrReplaceChild("mane3",
				CubeListBuilder.create().texOffs(97, 9).addBox(-4.0F, 0.481F, -0.4358F, 8.0F, 9.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 7.1054F, 0.2928F, 0.1309F, 0.0F, 0.0F));

		PartDefinition beard = mane.addOrReplaceChild("beard", CubeListBuilder.create().texOffs(36, 0).addBox(-5.625F,
				-0.5F, -0.05F, 11.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.625F, -24.5F, -14.3F));

		PartDefinition beard2 = beard
				.addOrReplaceChild("beard2",
						CubeListBuilder.create().texOffs(27, 21).addBox(-4.625F, -0.2481F, -0.0064F, 9.0F, 4.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition beard3 = beard2.addOrReplaceChild("beard3",
				CubeListBuilder.create().texOffs(27, 17).addBox(-4.5F, -2.0F, 0.0F, 9.0F, 4.0F, 0.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.125F, 4.7519F, 0.2436F, 0.0873F, 0.0F, 0.0F));

		PartDefinition head = upperBody.addOrReplaceChild("head", CubeListBuilder.create(),
				PartPose.offset(0.0F, -13.0F, -3.0F));

		PartDefinition skull = head.addOrReplaceChild("skull",
				CubeListBuilder.create().texOffs(0, 32)
						.addBox(-4.0F, -5.7778F, -5.3333F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(48, 55)
						.addBox(-3.0F, -6.7778F, -4.3333F, 6.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(106, 0)
						.addBox(-3.0F, -4.7778F, 2.1667F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(60, 35)
						.addBox(-3.5F, -2.9652F, 1.3214F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.7778F, -2.6667F, 0.2618F, 0.0F, 0.0F));

		PartDefinition hat = skull.addOrReplaceChild("hat",
				CubeListBuilder.create().texOffs(36, 17)
						.addBox(-4.0F, -1.1238F, -2.3652F, 8.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(59, 45)
						.addBox(-3.0F, -2.1238F, -2.3652F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(50, 52)
						.addBox(-3.0F, -1.1238F, -3.3652F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(24, 32)
						.addBox(-2.0F, -1.1238F, -5.3652F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(58, 2)
						.addBox(-2.0F, -2.1238F, -3.3652F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(58, 0)
						.addBox(-2.0F, -3.1238F, -2.3652F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 37)
						.addBox(-1.0F, -1.1238F, -6.3652F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 6)
						.addBox(-1.0F, -2.1238F, -4.3652F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 5)
						.addBox(-1.0F, -3.1238F, -3.3652F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 27)
						.addBox(-3.0F, -2.1238F, -1.3652F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(75, 21)
						.addBox(-2.0F, -3.1238F, -1.3652F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.9423F, -2.1148F, 0.1745F, 0.0F, 0.0F));

		PartDefinition hat2 = hat.addOrReplaceChild("hat2", CubeListBuilder.create().texOffs(10, 77)
				.addBox(-0.3085F, -0.853F, -4.5057F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(28, 50)
				.addBox(-0.3085F, -1.853F, 3.4943F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(50, 56)
				.addBox(0.0531F, 1.4411F, 3.3595F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 54)
				.addBox(-0.3085F, 0.147F, -5.5057F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.5F, -2.6603F, 3.0128F, 0.3491F, 0.0F, 0.4363F));

		PartDefinition hat3 = hat.addOrReplaceChild("hat3", CubeListBuilder.create().texOffs(50, 76)
				.addBox(-0.6915F, -0.853F, -4.5057F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(32, 40)
				.addBox(-0.6915F, -1.853F, 3.4943F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(50, 54)
				.addBox(-1.0836F, 1.2199F, 3.2719F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(25, 48)
				.addBox(-0.6915F, 0.147F, -5.5057F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.5F, -2.6603F, 3.0128F, 0.3491F, 0.0F, -0.4363F));

		PartDefinition rightEar = skull.addOrReplaceChild("rightEar",
				CubeListBuilder.create().texOffs(110, 66)
						.addBox(0.25F, -0.6667F, -3.3333F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
						.addBox(-0.75F, -1.1667F, -1.3333F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(61, 21)
						.addBox(-1.0F, -1.6667F, -0.3333F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.75F, -4.5948F, 1.3289F));

		PartDefinition leftEar = skull.addOrReplaceChild("leftEar",
				CubeListBuilder.create().texOffs(36, 110)
						.addBox(-1.25F, -0.6667F, -3.3333F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-0.25F, -1.1667F, -1.3333F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(19, 59)
						.addBox(0.0F, -1.6667F, -0.3333F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.75F, -4.5948F, 1.3289F));

		PartDefinition topJaw = skull.addOrReplaceChild("topJaw",
				CubeListBuilder.create().texOffs(56, 125)
						.addBox(-1.25F, 1.076F, -0.8431F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(94, 6)
						.addBox(-1.25F, 1.3348F, 0.1228F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 125)
						.addBox(-1.25F, 1.3001F, -1.9384F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 125)
						.addBox(1.25F, 1.4122F, -2.4861F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 125)
						.addBox(-1.25F, 1.3775F, -4.5474F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 125)
						.addBox(1.25F, 1.3775F, -4.5474F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 125)
						.addBox(1.25F, 0.9639F, -0.2954F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(94, 6)
						.addBox(1.25F, 1.3348F, 0.1228F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 44)
						.addBox(-1.0F, -0.8333F, -5.75F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(92, 28)
						.addBox(-1.0F, -1.0833F, -4.75F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(62, 55)
						.addBox(1.0F, -3.0833F, -0.25F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 10)
						.addBox(-2.0F, -0.5833F, -5.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -0.6944F, -5.5833F));

		PartDefinition bottomJaw = skull.addOrReplaceChild("bottomJaw", CubeListBuilder.create().texOffs(81, 40)
				.addBox(-1.5F, -1.0F, -5.5F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(56, 125)
				.addBox(-1.25F, -1.9319F, -4.9824F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 125)
				.addBox(-1.25F, -1.7204F, -3.2273F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(94, 6)
				.addBox(-1.25F, -1.6857F, -1.166F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 125)
				.addBox(1.25F, -1.9319F, -4.9824F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 125)
				.addBox(1.25F, -1.7204F, -3.2273F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(94, 6)
				.addBox(1.25F, -1.6857F, -1.166F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 1.4722F, -4.5833F));

		PartDefinition rightArm = upperBody.addOrReplaceChild("rightArm",
				CubeListBuilder.create().texOffs(90, 108)
						.addBox(-4.5F, -2.5F, 2.35F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 93)
						.addBox(-5.0F, -3.0F, -2.65F, 1.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(71, 60)
						.addBox(-4.0F, -3.0F, -2.65F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(110, 40)
						.addBox(-4.5F, -2.5F, -3.65F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 63)
						.addBox(-4.0F, -1.0F, -3.15F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(68, 45)
						.addBox(-3.25F, -1.5F, -2.75F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-6.5F, -7.75F, 1.75F));

		PartDefinition rightFore = rightArm.addOrReplaceChild("rightFore", CubeListBuilder.create().texOffs(79, 88)
				.addBox(-0.8333F, -0.7833F, -1.5167F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(63, 83)
				.addBox(-1.0833F, 6.9167F, -2.5667F, 3.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(110, 40)
				.addBox(-1.8333F, 4.7167F, -3.6667F, 4.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 93)
				.addBox(-2.3333F, 4.2167F, -2.6667F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(71, 60)
				.addBox(-1.3333F, 4.2167F, -2.6667F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(90, 108)
				.addBox(-1.8333F, 4.7167F, 2.3333F, 4.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.6667F, 6.7833F, 0.0167F));

		PartDefinition knife = rightFore.addOrReplaceChild("knife",
				CubeListBuilder.create().texOffs(71, 117)
						.addBox(-1.0F, -0.6F, -0.8125F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(75, 121)
						.addBox(-0.5F, -0.7F, -2.5625F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(57, 119)
						.addBox(0.0F, -0.6F, 4.1875F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(56, 124)
						.addBox(0.0F, -2.1F, 11.1875F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.4167F, 14.5167F, 0.2458F));

		PartDefinition leftArm = upperBody.addOrReplaceChild("leftArm",
				CubeListBuilder.create().texOffs(38, 65)
						.addBox(-0.5F, -1.375F, -2.15F, 4.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(14, 89)
						.addBox(1.4F, -0.375F, -0.7F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 69)
						.addBox(-1.25F, -1.875F, -1.75F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(7.0F, -7.375F, 0.75F));

		PartDefinition leftFore = leftArm.addOrReplaceChild("leftFore", CubeListBuilder.create().texOffs(14, 89)
				.addBox(-2.275F, -0.7833F, -1.5167F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 89)
				.addBox(-1.875F, -0.7833F, -1.4167F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(63, 86)
				.addBox(-1.925F, 11.9167F, -2.5667F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(25, 114)
				.addBox(0.225F, 6.2167F, 1.3333F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(25, 114)
				.addBox(-1.775F, 6.2167F, 1.3333F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(12, 0)
				.addBox(-2.175F, 6.9167F, -2.5667F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.675F, 6.4083F, 1.0167F));

		PartDefinition crossbow = leftFore.addOrReplaceChild("crossbow", CubeListBuilder.create(),
				PartPose.offset(-0.675F, 13.9667F, -1.7667F));

		PartDefinition crossbowBody = crossbow.addOrReplaceChild("crossbowBody",
				CubeListBuilder.create().texOffs(75, 123)
						.addBox(-5.5F, -21.0F, 4.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(-5.0F, -22.0F, 5.75F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(-5.5F, -21.0F, 5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 118)
						.addBox(-6.0F, -24.0F, 2.0F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(-5.5F, -26.0F, 1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(-5.0F, -23.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.65F, 21.95F, -4.8F));

		PartDefinition bow = crossbow.addOrReplaceChild("bow",
				CubeListBuilder.create().texOffs(75, 123)
						.addBox(-2.0F, -15.0F, 3.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(3.0F, -16.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(2.0F, -15.5F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(4.0F, -15.5F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(4.0F, -17.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(71, 125)
						.addBox(-5.0F, -15.0F, 3.0F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(2.0F, -14.5F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(-7.0F, -14.5F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(-6.0F, -15.5F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(-8.0F, -15.5F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(-8.0F, -17.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 123)
						.addBox(-7.0F, -16.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(92, 116)
						.addBox(-6.0F, -16.0F, 3.0F, 9.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(90, 115)
						.addBox(-7.0F, -16.5F, 3.0F, 11.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.65F, 20.95F, -6.3F));

		PartDefinition abs = body.addOrReplaceChild("abs", CubeListBuilder.create().texOffs(62, 0).addBox(-3.0F, 4.7F,
				-1.8F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.3F, -2.2F));

		PartDefinition cloth = abs.addOrReplaceChild("cloth",
				CubeListBuilder.create().texOffs(93, 77)
						.addBox(-4.5F, 1.0F, -2.1F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(90, 19)
						.addBox(-4.5F, 1.0F, 4.15F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 3.7F, 0.2F));

		PartDefinition rightLeg = abs.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(45, 102)
				.addBox(-3.5833F, 1.875F, -1.0833F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 106)
				.addBox(-3.3333F, -2.375F, -1.5833F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(79, 29)
				.addBox(-3.0833F, -3.125F, -2.5833F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 16)
				.addBox(-2.8333F, 1.875F, 1.4167F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(97, 46)
				.addBox(-3.0833F, 1.875F, -1.5833F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.9167F, 7.825F, 0.7833F));

		PartDefinition rightFemur = rightLeg.addOrReplaceChild("rightFemur",
				CubeListBuilder.create().texOffs(66, 96)
						.addBox(-1.35F, 0.075F, 0.5625F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 101)
						.addBox(-1.85F, 0.075F, 1.0625F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(108, 18)
						.addBox(-1.45F, -0.725F, -0.9375F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.7333F, 8.8F, -1.3958F));

		PartDefinition rightBoot = rightFemur.addOrReplaceChild("rightBoot",
				CubeListBuilder.create().texOffs(11, 0)
						.addBox(-2.65F, -2.64F, -0.65F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(50, 92)
						.addBox(-2.1F, -1.14F, -1.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(60, 76)
						.addBox(-1.5F, 1.91F, -4.15F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(76, 103)
						.addBox(-1.5F, -0.09F, -1.15F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(114, 43)
						.addBox(-0.5F, 0.41F, 2.35F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(62, 10)
						.addBox(-1.0F, 3.16F, -7.15F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(11, 113)
						.addBox(-0.5F, 4.26F, -8.15F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(89, 65)
						.addBox(-0.5F, 2.16F, -6.15F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(32, 63)
						.addBox(-0.5F, 1.16F, -5.15F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.15F, 7.215F, 2.7125F));

		PartDefinition leftLeg = abs.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(26, 104)
				.addBox(-0.4167F, 1.875F, -1.0833F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(98, 59)
				.addBox(0.0833F, 1.875F, -1.5833F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(111, 74)
				.addBox(0.8333F, 1.875F, 1.4167F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(84, 52)
				.addBox(0.0833F, -3.125F, -2.5833F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(59, 107)
				.addBox(1.3333F, -2.375F, -1.5833F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.9167F, 7.825F, 0.7833F));

		PartDefinition leftFemur = leftLeg.addOrReplaceChild("leftFemur", CubeListBuilder.create().texOffs(108, 83)
				.addBox(-1.45F, -1.225F, -1.9375F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(97, 86)
				.addBox(-1.35F, -0.425F, -0.4375F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(102, 102)
				.addBox(-1.85F, -0.425F, 0.0625F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.4333F, 9.3F, -0.3958F));

		PartDefinition leftBoot = leftFemur.addOrReplaceChild("leftBoot",
				CubeListBuilder.create().texOffs(94, 36)
						.addBox(-1.9F, -1.14F, -0.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(11, 0)
						.addBox(1.6F, -2.64F, 0.35F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(114, 43)
						.addBox(-0.5F, 0.41F, 3.35F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(106, 33)
						.addBox(-1.5F, 1.91F, -3.15F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(104, 24)
						.addBox(-1.5F, -0.09F, -0.15F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(58, 65)
						.addBox(-1.0F, 3.16F, -6.15F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(11, 113)
						.addBox(-0.5F, 4.26F, -7.15F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(106, 92)
						.addBox(-0.5F, 2.16F, -5.15F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(52, 65)
						.addBox(-0.5F, 1.16F, -4.15F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.15F, 6.715F, 0.7125F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	private final ModelPart whole;

	public ModelTheFirstBeast(ModelPart root) {
		this.whole = root.getChild("whole");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		whole.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(EntityTheFirstBeast entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

	}

	@Override
	public void translateToHand(HumanoidArm pSide, PoseStack pPoseStack) {
//		switch (pSide) {
//		case LEFT:
//			this.leftArm.translateRotate(pPoseStack);
//			this.getArmForSide(pSide).translateRotate(pPoseStack);
//			break;
//		case RIGHT:
//			this.rightArm.translateRotate(pPoseStack);
//			this.getArmForSide(pSide).translateRotate(pPoseStack);
//			break;
//		default:
//			break;
//
//		}
	}
}