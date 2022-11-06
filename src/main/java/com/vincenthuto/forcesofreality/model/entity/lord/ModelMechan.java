package com.vincenthuto.forcesofreality.model.entity.lord;
// Made with Blockbench 4.2.5

// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.lord.EntityMechan;

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

public class ModelMechan extends EntityModel<EntityMechan> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modelmechan"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(16, 25)
						.addBox(-3.0F, -3.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(10, 32)
						.addBox(-3.0F, -10.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(29, 53)
						.addBox(-2.0F, -11.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(17, 62)
						.addBox(-1.0F, -12.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(34, 18)
						.addBox(-2.0F, -13.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(32, 22)
						.addBox(-3.0F, -14.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(22, 18)
						.addBox(-4.0F, -16.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(32, 21)
						.addBox(-3.0F, -17.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(-2.0F, -18.0F, 0.0F, 3.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(22, 16)
						.addBox(1.0F, -17.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cage = Head.addOrReplaceChild("cage",
				CubeListBuilder.create().texOffs(14, 72)
						.addBox(-4.0F, -9.0F, -4.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(61, 71)
						.addBox(-4.0F, -9.0F, 3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(65, 71)
						.addBox(3.0F, -9.0F, -4.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 71)
						.addBox(3.0F, -9.0F, 3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(10, 72)
						.addBox(-2.0F, -9.0F, -4.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 50)
						.addBox(-2.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.0F, -4.0F, 2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(53, 70)
						.addBox(-4.0F, -9.0F, -2.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 69)
						.addBox(3.0F, -9.0F, -2.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(58, 49)
						.addBox(2.0F, -4.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 53)
						.addBox(-3.0F, -4.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(49, 70)
						.addBox(-4.0F, -9.0F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(45, 69)
						.addBox(3.0F, -9.0F, 1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(62, 6)
						.addBox(2.0F, -4.0F, 1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(54, 31)
						.addBox(-3.0F, -4.0F, 1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(57, 70)
						.addBox(-2.0F, -9.0F, 3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(71, 62)
						.addBox(1.0F, -9.0F, -4.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(29, 53)
						.addBox(1.0F, -4.0F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 22)
						.addBox(1.0F, -4.0F, 2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(70, 70)
						.addBox(1.0F, -9.0F, 3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -2.0F, -2.0F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(36, 21)
						.addBox(-3.0F, 5.0F, -2.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 39)
						.addBox(-4.0F, -2.0F, -3.0F, 8.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(47, 10)
						.addBox(-4.0F, -2.0F, -4.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
						.addBox(2.0F, -2.0F, -4.0F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(66, 31)
						.addBox(-2.0F, 4.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 16)
						.addBox(-3.0F, 5.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 10)
						.addBox(2.0F, 5.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(74, 44)
						.addBox(1.0F, 6.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(74, 74)
						.addBox(-2.0F, 6.0F, -4.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(66, 28)
						.addBox(-2.0F, 2.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(66, 26)
						.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(47, 59)
						.addBox(-2.0F, -2.0F, -4.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(53, 71)
						.addBox(-2.0F, -1.0F, -3.5F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body2 = Body.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(24, 0).addBox(-4.0F,
				-2.0F, -2.0F, 8.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition backGear = Body2.addOrReplaceChild("backGear",
				CubeListBuilder.create().texOffs(64, 57)
						.addBox(-0.5F, -0.5F, -2.4231F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(27, 12)
						.addBox(-2.5F, 3.5F, 0.5769F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 8)
						.addBox(-3.5F, 2.5F, -0.4231F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(72, 33)
						.addBox(-4.5F, -2.5F, 0.5769F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 72)
						.addBox(-6.5F, -2.5F, -0.4231F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 72)
						.addBox(5.5F, -2.5F, -0.4231F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 6)
						.addBox(-3.5F, -3.5F, -0.4231F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(51, 76)
						.addBox(-5.5F, -3.5F, -0.4231F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(47, 76)
						.addBox(-3.5F, -5.5F, -0.4231F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 65)
						.addBox(-3.5F, 4.5F, -0.4231F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 48)
						.addBox(2.5F, 4.5F, -0.4231F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 32)
						.addBox(2.5F, -5.5F, -0.4231F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 63)
						.addBox(-5.5F, 2.5F, -0.4231F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 54)
						.addBox(4.5F, 2.5F, -0.4231F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 29)
						.addBox(4.5F, -3.5F, -0.4231F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 27)
						.addBox(3.5F, -4.5F, 0.5769F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(75, 25)
						.addBox(-4.5F, -4.5F, 0.5769F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(44, 75)
						.addBox(-4.5F, 3.5F, 0.5769F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(74, 71)
						.addBox(3.5F, 3.5F, 0.5769F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(27, 14)
						.addBox(-2.5F, -4.5F, 0.5769F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 22)
						.addBox(-2.5F, -6.5F, -0.4231F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 13)
						.addBox(-2.5F, 5.5F, -0.4231F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 74)
						.addBox(-0.5F, -3.5F, -0.4231F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(72, 49)
						.addBox(3.5F, -2.5F, 0.5769F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 76)
						.addBox(2.5F, 2.5F, -0.4231F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(25, 59)
						.addBox(0.5F, -0.5F, -0.4231F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(68, 76)
						.addBox(2.5F, -3.5F, -0.4231F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(47, 61)
						.addBox(-3.5F, -0.5F, -0.4231F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(64, 57)
						.addBox(-0.5F, 0.5F, -0.4231F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, 1.5F, 3.4231F, 0.0F, 0.0F, 0.7854F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(0, 22)
						.addBox(-3.0F, -4.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 6)
						.addBox(-4.0F, 3.0F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 62)
						.addBox(-5.0F, 3.0F, -1.5F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 69)
						.addBox(-4.0F, 9.0F, 1.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(5, 37)
						.addBox(-3.5F, 9.0F, -1.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(24, 67)
						.addBox(-4.0F, 9.0F, 1.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 67)
						.addBox(-4.0F, 9.0F, -2.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(61, 0)
						.addBox(-4.0F, 19.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(57, 59)
						.addBox(-4.0F, 18.0F, 0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 58)
						.addBox(-4.0F, 18.0F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(74, 22)
						.addBox(-4.0F, 9.0F, 2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 36)
						.addBox(-4.0F, 11.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 34)
						.addBox(-4.0F, 11.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(74, 3)
						.addBox(-4.0F, 9.0F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(51, 61)
						.addBox(-4.0F, -4.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(54, 26)
						.addBox(-3.0F, -5.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(31, 66)
						.addBox(-3.0F, -4.0F, -3.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 77)
						.addBox(-4.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 38)
						.addBox(-4.0F, 0.7F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 58)
						.addBox(-4.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 50)
						.addBox(-4.0F, 0.7F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(61, 65)
						.addBox(-3.0F, -4.0F, 2.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition rightArmGear = RightArm.addOrReplaceChild("rightArmGear",
				CubeListBuilder.create().texOffs(61, 11)
						.addBox(-0.5F, 3.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(44, 77)
						.addBox(-0.5F, 2.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(72, 55)
						.addBox(-0.5F, -2.5F, -4.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(58, 77)
						.addBox(-0.5F, -3.5F, -3.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(61, 44)
						.addBox(-0.5F, -4.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(40, 75)
						.addBox(-0.5F, -3.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(67, 0)
						.addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(74, 67)
						.addBox(-0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(72, 0)
						.addBox(-1.5F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 58)
						.addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(73, 11)
						.addBox(-0.5F, -2.5F, 3.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(71, 77)
						.addBox(-0.5F, 2.5F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(62, 77)
						.addBox(-0.5F, -3.5F, 2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.5F, -2.5F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(34, 40)
						.addBox(-1.0F, -4.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 52)
						.addBox(2.0F, 5.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 24)
						.addBox(-1.0F, 5.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 50)
						.addBox(0.0F, 6.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(42, 0)
						.addBox(0.0F, 6.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(44, 2)
						.addBox(2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 2)
						.addBox(-1.0F, 5.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(73, 39)
						.addBox(3.0F, 6.0F, -2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 17)
						.addBox(4.0F, 6.0F, -1.5F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(32, 18)
						.addBox(3.0F, 5.0F, -1.5F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(22, 20)
						.addBox(3.0F, 10.0F, -1.5F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(21, 15)
						.addBox(1.0F, 11.0F, -1.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(6, 13)
						.addBox(4.0F, 6.0F, 1.5F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(32, 20)
						.addBox(3.0F, 5.0F, 1.5F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(25, 15)
						.addBox(3.0F, 10.0F, 1.5F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(24, 12)
						.addBox(1.0F, 11.0F, 1.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(74, 61)
						.addBox(2.0F, 10.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(51, 63)
						.addBox(2.0F, 10.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(73, 17)
						.addBox(3.0F, 6.0F, 1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(54, 31)
						.addBox(-1.0F, -5.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(41, 59)
						.addBox(3.0F, -4.0F, -2.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(27, 77)
						.addBox(3.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 52)
						.addBox(3.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(17, 77)
						.addBox(3.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(76, 56)
						.addBox(3.0F, 2.0F, 2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(62, 50)
						.addBox(-1.0F, -4.0F, -3.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(62, 36)
						.addBox(-1.0F, -4.0F, 2.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(50, 39)
						.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(28, 32)
						.addBox(-1.0F, -2.0F, -3.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 15)
						.addBox(-1.0F, -2.0F, 2.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition RightLeg2 = RightLeg.addOrReplaceChild("RightLeg2",
				CubeListBuilder.create().texOffs(46, 49)
						.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(4, 68)
						.addBox(-1.0F, 1.0F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(68, 11)
						.addBox(1.0F, 1.0F, 4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 39)
						.addBox(-2.0F, 1.0F, 4.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
						.addBox(-2.0F, 7.0F, -3.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(47, 10)
						.addBox(-3.0F, 6.0F, -3.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(60, 0)
						.addBox(-3.0F, 5.0F, -1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(27, 32)
						.addBox(-2.0F, 6.0F, -2.0F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(27, 61)
						.addBox(-1.0F, 5.0F, 4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 16)
						.addBox(-1.0F, 0.0F, 4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 4.0F, -2.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(0, 50)
						.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(68, 43)
						.addBox(-1.0F, 5.0F, -3.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(53, 19)
						.addBox(1.0F, 5.0F, 2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 53)
						.addBox(-2.0F, 5.0F, 2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition LeftLeg2 = LeftLeg.addOrReplaceChild("LeftLeg2",
				CubeListBuilder.create().texOffs(44, 0)
						.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(42, 30)
						.addBox(-1.0F, -6.0F, -1.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 25)
						.addBox(-1.0F, -6.0F, 4.0F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 12)
						.addBox(-2.0F, 6.0F, -2.0F, 4.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(66, 33)
						.addBox(-1.0F, 5.0F, 4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 0)
						.addBox(-1.0F, 0.0F, 4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 61)
						.addBox(2.0F, 5.0F, -1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(16, 16)
						.addBox(-2.0F, 7.0F, -3.0F, 4.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(9, 53)
						.addBox(2.0F, 6.0F, -3.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 4.0F, -2.0F));

		PartDefinition Turret = partdefinition.addOrReplaceChild("Turret", CubeListBuilder.create(),
				PartPose.offsetAndRotation(5.0F, 2.0F, 4.0F, 0.0F, 0.0F, -2.1817F));

		PartDefinition turretArm = Turret.addOrReplaceChild("turretArm", CubeListBuilder.create().texOffs(66, 6)
				.addBox(-2.0626F, -1.1187F, -0.4583F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(63, 17)
				.addBox(-2.0626F, -2.1187F, -1.4583F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 40)
				.addBox(-1.9819F, 2.4832F, -2.4583F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 60)
				.addBox(-1.4904F, 10.8036F, -1.9583F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(66, 23)
				.addBox(-1.4904F, 15.8036F, -1.9583F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.6202F, -3.3361F, 1.4583F));

		PartDefinition turretHead = turretArm.addOrReplaceChild("turretHead",
				CubeListBuilder.create().texOffs(18, 53)
						.addBox(-1.5F, -2.75F, -1.625F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(52, 19)
						.addBox(-1.5F, 1.25F, -1.625F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(57, 57)
						.addBox(-2.5F, -1.75F, -1.625F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(30, 40)
						.addBox(-2.5F, -2.75F, -2.625F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(42, 30)
						.addBox(-1.5F, -1.75F, -2.625F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(46, 39)
						.addBox(-2.5F, 1.25F, -2.625F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(32, 20)
						.addBox(1.5F, 1.25F, -2.625F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(56, 0)
						.addBox(1.5F, -2.75F, -2.625F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(29, 58)
						.addBox(1.5F, -1.75F, -1.625F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0096F, 15.5536F, -5.3333F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	private final ModelPart Turret;

	public ModelMechan(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.Turret = root.getChild("Turret");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Turret.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(EntityMechan entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}