package com.vincenthuto.forcesofreality.model.entity.lord;
// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.lord.EntityTetra;

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

public class ModelTetra extends EntityModel<EntityTetra> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modeltetra"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart LeftWing;
	private final ModelPart RightWing;
	private final ModelPart LeftWing3;
	private final ModelPart RightWing3;
	private final ModelPart RightWing4;
	private final ModelPart RightWing5;
	private final ModelPart LeftWing4;
	private final ModelPart LeftWing5;
	private final ModelPart RightWing2;
	private final ModelPart LeftWing2;
	private final ModelPart LeftWing6;

	public ModelTetra(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.LeftWing = root.getChild("LeftWing");
		this.RightWing = root.getChild("RightWing");
		this.LeftWing3 = root.getChild("LeftWing3");
		this.RightWing3 = root.getChild("RightWing3");
		this.RightWing4 = root.getChild("RightWing4");
		this.RightWing5 = root.getChild("RightWing5");
		this.LeftWing4 = root.getChild("LeftWing4");
		this.LeftWing5 = root.getChild("LeftWing5");
		this.RightWing2 = root.getChild("RightWing2");
		this.LeftWing2 = root.getChild("LeftWing2");
		this.LeftWing6 = root.getChild("LeftWing6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -0.5F));

		PartDefinition Skull = Head.addOrReplaceChild("Skull", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, 0.5F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(48, 16).addBox(-3.0F, -11.0F, 0.0F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(-3.0F, -5.0F, -3.0F, 7.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(88, 32).addBox(4.0F, -11.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(72, 32).addBox(-5.0F, -11.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -13.0F, -3.0F, 7.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 91).addBox(4.0F, -12.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(82, 76).addBox(4.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 84).addBox(-4.0F, -12.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(96, 76).addBox(-4.0F, -5.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 76).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(26, 136).addBox(-2.0F, -3.0F, -0.1F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(26, 136).addBox(-1.0F, 3.0F, -0.1F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(24, 170).addBox(-2.1F, -2.3F, -1.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 170).addBox(2.1F, -2.3F, -1.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 183).addBox(-0.5F, 3.3F, -0.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 183).addBox(-2.0F, 1.6F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 181).addBox(1.0F, -2.0F, -0.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 179).addBox(-2.0F, -2.0F, -0.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 181).addBox(-2.0F, 0.0F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 179).addBox(1.0F, 0.0F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 181).addBox(-0.5F, -1.0F, -0.8F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 179).addBox(-0.5F, 1.0F, -0.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 173).addBox(-0.5F, -3.0F, -1.1F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 179).addBox(1.0F, 1.6F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 44).addBox(-4.0F, 1.0F, 0.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftArm = Body.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(66, 76).addBox(0.5F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(6, 173).addBox(1.5F, -0.6F, -2.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 170).addBox(1.5F, -0.6F, 1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 164).addBox(4.0F, -0.6F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(44, 164).addBox(0.0F, -0.6F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 161).addBox(1.5F, -2.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 158).addBox(1.5F, 1.4F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(7.5F, -9.0F, 0.0F));

		PartDefinition lforeArm = leftArm.addOrReplaceChild("lforeArm", CubeListBuilder.create().texOffs(4, 138).addBox(-0.2F, 0.8F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 148).addBox(-1.7F, 1.8F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 148).addBox(0.1F, -0.1F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 148).addBox(-2.0F, -0.1F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 2.5F, 0.0F));

		PartDefinition lHand = lforeArm.addOrReplaceChild("lHand", CubeListBuilder.create().texOffs(42, 173).addBox(-0.6F, 4.4F, -2.4F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 170).addBox(0.7F, 4.4F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(46, 170).addBox(0.9F, 4.4F, -1.1F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 148).addBox(-1.2F, -0.7F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 138).addBox(0.3F, -0.7F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 127).addBox(-1.0F, -0.6F, -1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 176).addBox(0.6F, 4.4F, -0.1F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 5.5F, 0.5F));

		PartDefinition rightArm = Body.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(50, 76).addBox(-4.5F, -1.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 167).addBox(-3.5F, -0.6F, -2.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 164).addBox(-3.5F, -0.6F, 1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 164).addBox(-1.0F, -0.6F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 164).addBox(-5.0F, -0.6F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 161).addBox(-3.5F, -2.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 158).addBox(-3.5F, 1.4F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, -9.0F, 0.0F));

		PartDefinition rforeArm = rightArm.addOrReplaceChild("rforeArm", CubeListBuilder.create().texOffs(32, 148).addBox(0.8F, 1.8F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 138).addBox(-0.7F, 0.8F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 148).addBox(1.1F, -0.1F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(20, 148).addBox(-1.0F, -0.1F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 2.5F, 0.0F));

		PartDefinition rHand = rforeArm.addOrReplaceChild("rHand", CubeListBuilder.create().texOffs(0, 138).addBox(-1.2F, -0.2F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 148).addBox(0.3F, -0.2F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 170).addBox(-0.3F, 4.9F, -1.9F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 170).addBox(-1.6F, 4.9F, -1.6F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 173).addBox(-1.9F, 4.9F, -0.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 127).addBox(-1.0F, -0.1F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(30, 170).addBox(-1.8F, 4.9F, 0.4F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 5.0F, 0.0F));

		PartDefinition steve = Body.addOrReplaceChild("steve", CubeListBuilder.create().texOffs(0, 170).addBox(-0.9875F, -6.75F, -1.475F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.4875F, -2.25F, 0.475F));

		PartDefinition stRLeg = steve.addOrReplaceChild("stRLeg", CubeListBuilder.create().texOffs(38, 173).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.4875F, -4.75F, -0.875F));

		PartDefinition stLLeg = steve.addOrReplaceChild("stLLeg", CubeListBuilder.create().texOffs(34, 173).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5125F, -4.75F, -0.875F));

		PartDefinition stLArm = steve.addOrReplaceChild("stLArm", CubeListBuilder.create().texOffs(42, 170).addBox(-0.2F, -0.2F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0125F, -6.55F, -0.875F));

		PartDefinition stRArm = steve.addOrReplaceChild("stRArm", CubeListBuilder.create().texOffs(38, 170).addBox(-1.0F, -0.2F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.8875F, -6.55F, -0.875F));

		PartDefinition stHead = steve.addOrReplaceChild("stHead", CubeListBuilder.create().texOffs(62, 164).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0125F, -6.75F, -0.975F));

		PartDefinition eye = stHead.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(28, 101).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.5F, 1.0F));

		PartDefinition halos = Body.addOrReplaceChild("halos", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -20.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition halo4 = halos.addOrReplaceChild("halo4", CubeListBuilder.create().texOffs(16, 123).addBox(-2.5F, 3.5F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(60, 176).addBox(2.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 176).addBox(3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 158).addBox(3.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 176).addBox(3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 120).addBox(-2.5F, -5.5F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 176).addBox(2.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 176).addBox(-3.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 176).addBox(-4.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 158).addBox(-5.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 176).addBox(-4.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 176).addBox(-3.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.7645F, 0.7F, 2.3562F, 0.0F, 0.0F));

		PartDefinition halo3 = halos.addOrReplaceChild("halo3", CubeListBuilder.create().texOffs(28, 123).addBox(-2.5F, 3.5F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(92, 176).addBox(2.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 176).addBox(3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 158).addBox(3.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(84, 176).addBox(3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 120).addBox(-2.5F, -5.5F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(80, 176).addBox(2.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(76, 176).addBox(-3.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(72, 176).addBox(-4.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 158).addBox(-5.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 176).addBox(-4.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 176).addBox(-3.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5355F, 0.4355F, 0.7854F, 0.0F, 0.0F));

		PartDefinition halo2 = halos.addOrReplaceChild("halo2", CubeListBuilder.create().texOffs(40, 123).addBox(-2.5F, 3.5F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 181).addBox(2.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 179).addBox(3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 158).addBox(3.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 181).addBox(3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 120).addBox(-2.5F, -5.5F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 179).addBox(2.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 181).addBox(-3.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 179).addBox(-4.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 158).addBox(-5.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 181).addBox(-4.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 179).addBox(-3.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, 0.5F, 1.5708F, 0.0F, 0.0F));

		PartDefinition halo = halos.addOrReplaceChild("halo", CubeListBuilder.create().texOffs(52, 123).addBox(-2.5F, 3.5F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 179).addBox(2.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 179).addBox(3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 158).addBox(3.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 181).addBox(3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(52, 120).addBox(-2.5F, -5.5F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 181).addBox(2.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 181).addBox(-3.5F, -4.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 179).addBox(-4.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 158).addBox(-5.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 181).addBox(-4.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 179).addBox(-3.5F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -0.5F, 0.5F));

		PartDefinition bone5 = Body.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(34, 179).addBox(4.453F, 1.1327F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.2F, -0.5F, 0.0F, 0.0F, -2.0508F));

		PartDefinition bone7 = Body.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(14, 183).addBox(3.781F, 2.1168F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3233F, 8.2455F, -0.5F, 0.0F, 0.0F, -2.2602F));

		PartDefinition bone8 = Body.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(12, 183).addBox(-2.1407F, 4.1366F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3233F, 8.2455F, -0.5F, 0.0F, 0.0F, 2.2602F));

		PartDefinition bone6 = Body.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(32, 179).addBox(4.453F, -3.4848F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.9F, -0.5F, 0.0F, 0.0F, -1.0908F));

		PartDefinition lowerHalf = Body.addOrReplaceChild("lowerHalf", CubeListBuilder.create().texOffs(12, 164).addBox(-2.9667F, 3.0333F, 1.2467F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 164).addBox(2.0333F, 3.0333F, 1.2467F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 76).addBox(-4.9667F, 0.0333F, -2.0533F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(20, 176).addBox(-5.4667F, 1.0333F, -0.0533F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 176).addBox(-2.4667F, 1.0333F, -0.0533F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 76).addBox(2.0333F, 0.0333F, -2.0533F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(28, 176).addBox(1.5333F, 1.0333F, -0.0533F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 183).addBox(4.5333F, 1.0333F, -0.0533F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 109).addBox(1.0333F, 3.0333F, -1.0533F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 164).addBox(2.0333F, 3.0333F, -1.3533F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 101).addBox(-3.9667F, 3.0333F, -1.0533F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(4, 164).addBox(-2.9667F, 3.0333F, -1.3533F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0333F, 3.9667F, 1.0533F));

		PartDefinition bottomHalf = lowerHalf.addOrReplaceChild("bottomHalf", CubeListBuilder.create().texOffs(8, 120).addBox(-3.0F, -0.1111F, -1.3333F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(2.0F, -0.1111F, -1.3333F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(4, 109).addBox(1.0F, 3.8889F, -1.3333F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 164).addBox(2.0F, 3.8889F, -1.6333F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 101).addBox(-4.0F, 3.8889F, -1.3333F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 164).addBox(-3.0F, 3.8889F, -1.6333F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 164).addBox(2.0F, 3.8889F, 0.9667F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 164).addBox(-3.0F, 3.8889F, 0.9667F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0333F, 8.1444F, 0.28F));

		PartDefinition wheel = bottomHalf.addOrReplaceChild("wheel", CubeListBuilder.create().texOffs(4, 176).addBox(1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(4, 176).addBox(1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(4, 176).addBox(-2.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(4, 176).addBox(-2.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(4, 176).addBox(1.0F, -2.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(12, 176).addBox(-1.0F, 1.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(8, 176).addBox(-3.0F, -1.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 158).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 176).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.8889F, 0.1667F));

		PartDefinition LeftWing = partdefinition.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(16, 148).addBox(1.1684F, -1.3494F, -1.1676F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 32).addBox(-6.8316F, -1.3494F, -0.1676F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -6.0F, 4.5F, 0.2618F, 0.1745F, -2.7925F));

		PartDefinition Limb3 = LeftWing.addOrReplaceChild("Limb3", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.6084F, -1.8148F, 3.0599F, 0.0F, 0.0F, -1.6581F));

		PartDefinition Limb1 = LeftWing.addOrReplaceChild("Limb1", CubeListBuilder.create().texOffs(0, 101).addBox(9.1451F, -4.1325F, -3.7275F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(126, 118).addBox(3.1451F, 11.8675F, -3.7275F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 16).addBox(2.1451F, -4.1325F, -2.7249F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6084F, 7.6852F, 2.5599F, 0.0F, 0.0F, 0.5672F));

		PartDefinition RightWing = partdefinition.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(8, 148).addBox(-1.7768F, -2.6064F, -3.8632F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 55).addBox(-1.7768F, -2.6064F, -2.8632F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -6.0F, 7.5F, 0.3491F, -0.1745F, 2.7925F));

		PartDefinition Limb2 = RightWing.addOrReplaceChild("Limb2", CubeListBuilder.create().texOffs(26, 84).addBox(-11.3476F, -4.4195F, -4.7977F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 118).addBox(-10.3476F, 11.5805F, -4.7977F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-11.3476F, -4.4195F, -3.7951F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1684F, 6.0242F, 0.9344F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Limb4 = RightWing.addOrReplaceChild("Limb4", CubeListBuilder.create(), PartPose.offsetAndRotation(14.0F, -3.0718F, 0.3642F, 0.0F, 0.0F, -1.6581F));

		PartDefinition LeftWing3 = partdefinition.addOrReplaceChild("LeftWing3", CubeListBuilder.create().texOffs(0, 148).addBox(-0.432F, 0.3539F, -0.7741F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 32).addBox(-8.432F, -1.6461F, 0.2259F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -7.0F, 1.5F, 0.2181F, 0.3055F, 2.8798F));

		PartDefinition Limb9 = LeftWing3.addOrReplaceChild("Limb9", CubeListBuilder.create(), PartPose.offsetAndRotation(1.7843F, -5.1633F, 3.3432F, 0.0F, 0.0F, -1.6581F));

		PartDefinition Limb10 = LeftWing3.addOrReplaceChild("Limb10", CubeListBuilder.create().texOffs(44, 127).addBox(3.1999F, 3.2732F, -3.6172F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(84, 118).addBox(-2.8001F, 13.2732F, -3.6172F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(80, 66).addBox(-3.8001F, 3.2732F, -2.6146F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2157F, 4.3367F, 2.8432F, 0.0F, 0.0F, 0.5672F));

		PartDefinition RightWing3 = partdefinition.addOrReplaceChild("RightWing3", CubeListBuilder.create().texOffs(28, 138).addBox(-0.568F, 0.3539F, -0.7741F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 55).addBox(-0.568F, -1.6461F, 0.2259F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -7.0F, 1.5F, 0.2181F, -0.48F, -2.8798F));

		PartDefinition Limb11 = RightWing3.addOrReplaceChild("Limb11", CubeListBuilder.create().texOffs(28, 127).addBox(-5.4023F, 2.9862F, -4.6874F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 118).addBox(-4.4023F, 12.9862F, -4.6874F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 66).addBox(-5.4023F, 2.9862F, -3.6848F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.384F, 3.9327F, 3.9133F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Limb12 = RightWing3.addOrReplaceChild("Limb12", CubeListBuilder.create(), PartPose.offsetAndRotation(6.2156F, -5.1633F, 3.3431F, 0.0F, 0.0F, -1.6581F));

		PartDefinition RightWing4 = partdefinition.addOrReplaceChild("RightWing4", CubeListBuilder.create().texOffs(20, 138).addBox(-1.049F, 1.3866F, -1.1107F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 44).addBox(-1.049F, -0.6134F, -0.1107F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, -7.6F, 3.5F, 0.3054F, 0.1309F, 1.3963F));

		PartDefinition Limb13 = RightWing4.addOrReplaceChild("Limb13", CubeListBuilder.create().texOffs(18, 84).addBox(-9.3387F, -12.6976F, -1.6766F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 118).addBox(-8.3387F, 3.3024F, -1.6766F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 0).addBox(-9.3387F, -12.6976F, -0.674F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.6496F, 16.0783F, 0.5659F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Limb14 = RightWing4.addOrReplaceChild("Limb14", CubeListBuilder.create(), PartPose.offsetAndRotation(17.4812F, 6.9823F, -0.0043F, 0.0F, 0.0F, -1.6581F));

		PartDefinition RightWing5 = partdefinition.addOrReplaceChild("RightWing5", CubeListBuilder.create().texOffs(16, 138).addBox(-2.9202F, 0.1673F, -0.3876F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 44).addBox(-2.9202F, 0.1673F, 0.6124F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.0F, 2.2F, 0.4363F, 0.1309F, 0.7854F));

		PartDefinition Limb15 = RightWing5.addOrReplaceChild("Limb15", CubeListBuilder.create().texOffs(20, 127).addBox(-3.1953F, -10.3015F, -0.5318F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 118).addBox(-2.1953F, -0.3015F, -0.5318F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(80, 55).addBox(-3.1953F, -10.3015F, 0.4708F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3095F, 18.1389F, 0.1441F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Limb16 = RightWing5.addOrReplaceChild("Limb16", CubeListBuilder.create(), PartPose.offsetAndRotation(9.1411F, 9.0429F, -0.4261F, 0.0F, 0.0F, -1.6581F));

		PartDefinition LeftWing4 = partdefinition.addOrReplaceChild("LeftWing4", CubeListBuilder.create().texOffs(12, 138).addBox(0.8287F, 1.3005F, -0.3395F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-7.1713F, -0.6995F, 0.6605F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -7.0F, 2.5F, 0.2182F, 0.0873F, -1.3963F));

		PartDefinition Limb17 = LeftWing4.addOrReplaceChild("Limb17", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.6579F, 6.7193F, 0.4559F, 0.0F, 0.0F, -1.6581F));

		PartDefinition Limb18 = LeftWing4.addOrReplaceChild("Limb18", CubeListBuilder.create().texOffs(14, 84).addBox(7.1945F, -12.238F, -0.2954F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 109).addBox(1.1945F, 3.762F, -0.2954F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 0).addBox(0.1945F, -12.238F, 0.7072F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.6579F, 16.2193F, -0.0441F, 0.0F, 0.0F, 0.5672F));

		PartDefinition LeftWing5 = partdefinition.addOrReplaceChild("LeftWing5", CubeListBuilder.create().texOffs(8, 138).addBox(1.4783F, -0.443F, 0.0291F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(68, 16).addBox(-6.5217F, -0.443F, 1.0291F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -3.0F, 2.2F, 0.4364F, -0.1309F, -0.7854F));

		PartDefinition Limb19 = LeftWing5.addOrReplaceChild("Limb19", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.583F, 8.4486F, 0.1358F, 0.0F, 0.0F, -1.6581F));

		PartDefinition Limb20 = LeftWing5.addOrReplaceChild("Limb20", CubeListBuilder.create().texOffs(16, 127).addBox(0.9841F, -10.028F, 0.3933F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 107).addBox(-5.0159F, -0.028F, 0.3933F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 55).addBox(-6.0159F, -10.028F, 1.3959F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.583F, 17.9486F, -0.3642F, 0.0F, 0.0F, 0.5672F));

		PartDefinition RightWing2 = partdefinition.addOrReplaceChild("RightWing2", CubeListBuilder.create().texOffs(8, 148).addBox(-1.7768F, -2.6064F, -3.8632F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(48, 55).addBox(-1.7768F, -2.6064F, -2.8632F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -6.0F, 7.5F, 0.4363F, 0.1309F, 2.0944F));

		PartDefinition Limb5 = RightWing2.addOrReplaceChild("Limb5", CubeListBuilder.create().texOffs(26, 84).addBox(-11.3476F, -4.4195F, -4.7977F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(98, 118).addBox(-10.3476F, 11.5805F, -4.7977F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-11.3476F, -4.4195F, -3.7951F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1684F, 6.0242F, 0.9344F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Limb6 = RightWing2.addOrReplaceChild("Limb6", CubeListBuilder.create(), PartPose.offsetAndRotation(14.0F, -3.0718F, 0.3642F, 0.0F, 0.0F, -1.6581F));

		PartDefinition LeftWing2 = partdefinition.addOrReplaceChild("LeftWing2", CubeListBuilder.create().texOffs(16, 148).addBox(1.1684F, -1.3494F, -1.1676F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 32).addBox(-6.8316F, -1.3494F, -0.1676F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -6.0F, 4.5F, 0.2182F, 0.1309F, -2.0944F));

		PartDefinition Limb7 = LeftWing2.addOrReplaceChild("Limb7", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.6084F, -1.8148F, 3.0599F, 0.0F, 0.0F, -1.6581F));

		PartDefinition Limb8 = LeftWing2.addOrReplaceChild("Limb8", CubeListBuilder.create().texOffs(0, 101).addBox(9.1451F, -4.1325F, -3.7275F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(126, 118).addBox(3.1451F, 11.8675F, -3.7275F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 16).addBox(2.1451F, -4.1325F, -2.7249F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6084F, 7.6852F, 2.5599F, 0.0F, 0.0F, 0.5672F));

		PartDefinition LeftWing6 = partdefinition.addOrReplaceChild("LeftWing6", CubeListBuilder.create().texOffs(16, 148).addBox(1.1684F, -1.3494F, -1.1676F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 32).addBox(-6.8316F, -1.3494F, -0.1676F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -6.0F, 4.5F, 0.2182F, 0.1309F, -2.7925F));

		PartDefinition Limb21 = LeftWing6.addOrReplaceChild("Limb21", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.6084F, -1.8148F, 3.0599F, 0.0F, 0.0F, -1.6581F));

		PartDefinition Limb22 = LeftWing6.addOrReplaceChild("Limb22", CubeListBuilder.create().texOffs(0, 101).addBox(9.1451F, -4.1325F, -3.7275F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(126, 118).addBox(3.1451F, 11.8675F, -3.7275F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 16).addBox(2.1451F, -4.1325F, -2.7249F, 8.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6084F, 7.6852F, 2.5599F, 0.0F, 0.0F, 0.5672F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(EntityTetra  entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}