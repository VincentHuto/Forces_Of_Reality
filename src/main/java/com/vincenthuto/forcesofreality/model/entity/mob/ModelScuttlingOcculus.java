package com.vincenthuto.forcesofreality.model.entity.mob;

// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required import

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.mob.EntityScuttlingOcculus;

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



public class ModelScuttlingOcculus extends EntityModel<EntityScuttlingOcculus> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modelscuttlingocculus"), "main");
	private final ModelPart whole;
	private final ModelPart bone;

	public ModelScuttlingOcculus(ModelPart root) {
		this.whole = root.getChild("whole");
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition whole = partdefinition.addOrReplaceChild("whole", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.5F, -1.75F, 8.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(9, 21).addBox(-4.0F, -2.5F, -1.75F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.5F, -2.25F));

		PartDefinition frontLeftLeg = whole.addOrReplaceChild("frontLeftLeg", CubeListBuilder.create(), PartPose.offset(4.0F, -3.5F, -0.75F));

		PartDefinition segment1 = frontLeftLeg.addOrReplaceChild("segment1", CubeListBuilder.create().texOffs(30, 17).addBox(-1.9207F, -0.0609F, -2.01F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9F, 1.0F, 0.0F, 0.0F, -0.9163F));

		PartDefinition segment2 = frontLeftLeg.addOrReplaceChild("segment2", CubeListBuilder.create(), PartPose.offset(4.75F, 0.0F, 1.0F));

		PartDefinition cube_r1 = segment2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.5F, -0.01F, 0.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 13).addBox(-2.0F, -2.5F, -0.01F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(14, 38).addBox(-2.0F, -2.5F, -1.01F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3695F, 4.3964F, -1.011F, 0.0F, 0.0F, -0.6545F));

		PartDefinition segment3 = frontLeftLeg.addOrReplaceChild("segment3", CubeListBuilder.create(), PartPose.offset(3.75F, 3.5F, 0.0F));

		PartDefinition cube_r2 = segment3.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 38).addBox(0.0F, -1.5F, -1.03F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2502F, -0.8749F, 0.01F, 0.0F, 0.0F, -0.6545F));

		PartDefinition frontRightLeg = whole.addOrReplaceChild("frontRightLeg", CubeListBuilder.create(), PartPose.offset(-4.0F, -3.5F, -0.75F));

		PartDefinition segment10 = frontRightLeg.addOrReplaceChild("segment10", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.8871F, -2.4269F, -0.01F, 0.0F, 0.0F, -0.1745F));

		PartDefinition cube_r3 = segment10.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 29).addBox(-1.0F, -1.5F, -1.01F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7964F, 3.5226F, 0.01F, 0.0F, 0.0F, 1.0472F));

		PartDefinition segment11 = frontRightLeg.addOrReplaceChild("segment11", CubeListBuilder.create(), PartPose.offset(12.75F, 0.0F, 1.0F));

		PartDefinition cube_r4 = segment11.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(22, 21).addBox(1.0F, -2.5F, -0.01F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(24, 29).addBox(1.0F, -2.5F, -1.01F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.7876F, 4.4985F, -1.001F, 0.0F, 0.0F, 0.6545F));

		PartDefinition segment12 = frontRightLeg.addOrReplaceChild("segment12", CubeListBuilder.create(), PartPose.offset(11.75F, 3.5F, 0.0F));

		PartDefinition cube_r5 = segment12.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 9).addBox(-1.0F, -1.5F, -1.03F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.1679F, -0.7728F, 0.02F, 0.0F, 0.0F, 0.6545F));

		PartDefinition middleRightLeg = whole.addOrReplaceChild("middleRightLeg", CubeListBuilder.create(), PartPose.offset(-4.0F, -3.5F, 1.75F));

		PartDefinition segment13 = middleRightLeg.addOrReplaceChild("segment13", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.8871F, -2.4269F, -0.51F, 0.0F, 0.0F, -0.1745F));

		PartDefinition cube_r6 = segment13.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(26, 27).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7964F, 3.5226F, 0.01F, 0.0F, 0.0F, 1.0472F));

		PartDefinition segment14 = middleRightLeg.addOrReplaceChild("segment14", CubeListBuilder.create(), PartPose.offset(12.75F, 0.0F, 0.5F));

		PartDefinition cube_r7 = segment14.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(13, 18).addBox(1.0F, -2.5F, 0.001F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(1.0F, -2.5F, 1.001F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.7876F, 4.4985F, -1.001F, 0.0F, 0.0F, 0.6545F));

		PartDefinition cube_r8 = segment14.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(23, 4).addBox(1.0F, -3.5F, -1.499F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7876F, 5.4985F, 0.999F, 0.0F, 0.0F, 0.6545F));

		PartDefinition segment15 = middleRightLeg.addOrReplaceChild("segment15", CubeListBuilder.create(), PartPose.offset(11.75F, 3.5F, -0.5F));

		PartDefinition cube_r9 = segment15.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(3, 3).addBox(-1.0F, -1.5F, -0.02F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.1679F, -0.7728F, 0.02F, 0.0F, 0.0F, 0.6545F));

		PartDefinition backRightLeg = whole.addOrReplaceChild("backRightLeg", CubeListBuilder.create(), PartPose.offset(-4.0F, -3.5F, 4.25F));

		PartDefinition segment16 = backRightLeg.addOrReplaceChild("segment16", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.8871F, -2.4269F, -0.01F, 0.0F, 0.0F, -0.1745F));

		PartDefinition cube_r10 = segment16.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 27).addBox(-1.0F, -1.5F, -0.99F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7964F, 3.5226F, 0.01F, 0.0F, 0.0F, 1.0472F));

		PartDefinition segment17 = backRightLeg.addOrReplaceChild("segment17", CubeListBuilder.create(), PartPose.offset(12.75F, 0.0F, 1.0F));

		PartDefinition cube_r11 = segment17.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 18).addBox(1.0F, -2.5F, -0.01F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(11, 11).addBox(1.0F, -2.5F, 0.99F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.7876F, 4.4985F, -1.001F, 0.0F, 0.0F, 0.6545F));

		PartDefinition segment18 = backRightLeg.addOrReplaceChild("segment18", CubeListBuilder.create(), PartPose.offset(11.75F, 3.5F, 0.0F));

		PartDefinition cube_r12 = segment18.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.5F, -0.03F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.1679F, -0.7728F, 0.02F, 0.0F, 0.0F, 0.6545F));

		PartDefinition backLeftLeg = whole.addOrReplaceChild("backLeftLeg", CubeListBuilder.create(), PartPose.offset(4.0F, -3.5F, 4.25F));

		PartDefinition segment4 = backLeftLeg.addOrReplaceChild("segment4", CubeListBuilder.create().texOffs(29, 7).addBox(-1.9207F, -0.0609F, -1.99F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9F, 1.0F, 0.0F, 0.0F, -0.9163F));

		PartDefinition segment5 = backLeftLeg.addOrReplaceChild("segment5", CubeListBuilder.create(), PartPose.offset(4.75F, 0.0F, 1.0F));

		PartDefinition cube_r13 = segment5.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(36, 31).addBox(-2.0F, -2.5F, -0.01F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3695F, 4.3964F, -1.011F, 0.0F, 0.0F, -0.6545F));

		PartDefinition cube_r14 = segment5.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(12, 38).addBox(-2.0F, -2.5F, -0.01F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3695F, 4.3964F, -0.011F, 0.0F, 0.0F, -0.6545F));

		PartDefinition segment6 = backLeftLeg.addOrReplaceChild("segment6", CubeListBuilder.create(), PartPose.offset(3.75F, 3.5F, 0.0F));

		PartDefinition cube_r15 = segment6.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(37, 21).addBox(0.0F, -1.5F, -0.03F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2502F, -0.8749F, 0.01F, 0.0F, 0.0F, -0.6545F));

		PartDefinition middleLeftLeg = whole.addOrReplaceChild("middleLeftLeg", CubeListBuilder.create(), PartPose.offset(4.0F, -3.5F, 1.75F));

		PartDefinition segment7 = middleLeftLeg.addOrReplaceChild("segment7", CubeListBuilder.create().texOffs(16, 29).addBox(-1.9207F, -0.0609F, -1.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9F, 0.5F, 0.0F, 0.0F, -0.9163F));

		PartDefinition segment8 = middleLeftLeg.addOrReplaceChild("segment8", CubeListBuilder.create(), PartPose.offset(4.75F, 0.0F, 0.5F));

		PartDefinition cube_r16 = segment8.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, -2.5F, -0.989F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(35, 6).addBox(-2.0F, -2.5F, -1.989F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(23, 0).addBox(-2.0F, -2.5F, -1.489F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3695F, 4.3964F, 0.989F, 0.0F, 0.0F, -0.6545F));

		PartDefinition segment9 = middleLeftLeg.addOrReplaceChild("segment9", CubeListBuilder.create(), PartPose.offset(3.75F, 3.5F, -0.5F));

		PartDefinition cube_r17 = segment9.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(3, 12).addBox(0.0F, -1.5F, -0.01F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2502F, -0.8749F, 0.01F, 0.0F, 0.0F, -0.6545F));

		PartDefinition head = whole.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.5F, -3.75F, 0.3491F, 0.0F, 0.0F));

		PartDefinition skull = head.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(37, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition eye2 = head.addOrReplaceChild("eye2", CubeListBuilder.create().texOffs(8, 22).addBox(-0.5F, -0.842F, -1.4397F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -1.184F, 2.3794F));

		PartDefinition eye3 = head.addOrReplaceChild("eye3", CubeListBuilder.create().texOffs(18, 21).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -1.4397F, 0.158F));

		PartDefinition eye4 = head.addOrReplaceChild("eye4", CubeListBuilder.create().texOffs(18, 9).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -1.4397F, 0.158F));

		PartDefinition eye5 = head.addOrReplaceChild("eye5", CubeListBuilder.create().texOffs(9, 18).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.5F, 1.0977F));

		PartDefinition eye7 = head.addOrReplaceChild("eye7", CubeListBuilder.create().texOffs(14, 29).addBox(-0.5F, 0.0977F, -1.7817F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.0977F, 1.7817F));

		PartDefinition eye8 = head.addOrReplaceChild("eye8", CubeListBuilder.create().texOffs(28, 17).addBox(-0.5F, -0.158F, -1.4397F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0977F, 1.7817F));

		PartDefinition eye9 = head.addOrReplaceChild("eye9", CubeListBuilder.create().texOffs(26, 25).addBox(-0.5F, -0.2443F, -2.7214F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 1.0374F, 2.1237F));

		PartDefinition eye10 = head.addOrReplaceChild("eye10", CubeListBuilder.create().texOffs(14, 9).addBox(-0.5F, -0.2443F, -2.7214F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0374F, 2.1237F));

		PartDefinition eye11 = head.addOrReplaceChild("eye11", CubeListBuilder.create().texOffs(16, 25).addBox(-0.5F, -0.5864F, -3.6611F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.2443F, 2.7214F));

		PartDefinition bone4 = whole.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.8158F, -3.9228F, 5.9373F, 2.2253F, 2.9234F, 1.0908F));

		PartDefinition cube_r18 = bone4.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(20, 36).addBox(-4.8158F, 0.5772F, -0.3127F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8158F, -1.5772F, -0.6873F, 0.0F, -0.2618F, 0.0F));

		PartDefinition bone5 = whole.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6692F, -5.7881F, 2.5984F, 0.0F, 0.0F, -1.1781F));

		PartDefinition cube_r19 = bone5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(34, 27).addBox(-1.6692F, -1.2881F, -0.6516F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6692F, 0.2881F, -0.3484F, -0.3491F, -1.0036F, 1.0908F));

		PartDefinition rock1 = whole.addOrReplaceChild("rock1", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, -5.5F, 4.25F, -0.3927F, 0.0873F, 0.0F));

		PartDefinition cube_r20 = rock1.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(34, 12).addBox(-3.7219F, 1.402F, 0.0379F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(37, 8).addBox(-3.92F, -0.4458F, -0.7014F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 1.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r21 = rock1.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(34, 27).addBox(-1.5549F, 1.5246F, 1.3658F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 1.0F, -2.4871F, -1.0036F, 1.0472F));

		PartDefinition cube_r22 = rock1.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 36).addBox(-1.9302F, -0.6439F, -0.7394F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 1.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition rock5 = whole.addOrReplaceChild("rock5", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, -5.5F, -1.75F, -0.3927F, 0.2618F, 0.0F));

		PartDefinition cube_r23 = rock5.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(36, 16).addBox(-5.331F, -1.1811F, -0.9071F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 1.0F, 0.0436F, 0.2182F, -0.1745F));

		PartDefinition rock6 = whole.addOrReplaceChild("rock6", CubeListBuilder.create().texOffs(36, 36).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7071F, -5.9687F, -0.6185F, -0.3491F, 2.4435F, 0.2182F));

		PartDefinition rock15 = whole.addOrReplaceChild("rock15", CubeListBuilder.create().texOffs(22, 32).addBox(-0.2337F, -0.6211F, -0.4812F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6025F, -5.3294F, 5.2906F, -1.2654F, -0.2618F, 0.9163F));

		PartDefinition bone3 = whole.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6842F, -5.8233F, 0.357F, 0.48F, 0.0F, -0.7418F));

		PartDefinition rock16 = whole.addOrReplaceChild("rock16", CubeListBuilder.create().texOffs(0, 32).addBox(-0.2337F, -1.641F, -1.0433F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6025F, -5.101F, 2.1425F, -0.3927F, 0.2618F, 0.6545F));

		PartDefinition bone2 = whole.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.9192F, -4.2991F, 6.5937F, -0.4363F, -0.2618F, -0.2618F));

		PartDefinition cube_r24 = bone2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(31, 23).addBox(-0.0808F, -3.7991F, 7.3437F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9192F, 2.7991F, -8.3437F, 0.0F, -0.3054F, 0.0F));

		PartDefinition rock14 = whole.addOrReplaceChild("rock14", CubeListBuilder.create().texOffs(30, 32).addBox(-0.2929F, -1.4687F, 0.1315F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.5F, 0.25F, -0.3927F, 0.2618F, 0.0F));

		PartDefinition bone7 = whole.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(30, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5164F, -3.8598F, -1.2957F, 2.1817F, 0.0873F, 1.2217F));

		PartDefinition rock18 = whole.addOrReplaceChild("rock18", CubeListBuilder.create(), PartPose.offset(2.0F, -3.5F, -1.75F));

		PartDefinition cube_r25 = rock18.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(31, 2).addBox(-5.2185F, -0.2837F, -0.0272F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, 0.0F, 0.2618F, -0.3054F, 0.1745F));

		PartDefinition cube_r26 = rock18.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(31, 2).addBox(-5.2185F, -0.2837F, -0.0272F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, 8.0F, 0.2618F, -0.3054F, 0.1745F));

		PartDefinition rock7 = whole.addOrReplaceChild("rock7", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -5.5F, -1.75F, -0.3927F, 0.2618F, 0.0F));

		PartDefinition cube_r27 = rock7.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(28, 36).addBox(-3.6079F, 0.6986F, -1.0305F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 1.0F, -0.0436F, 0.4363F, 0.4363F));

		PartDefinition rock2 = whole.addOrReplaceChild("rock2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, -5.5F, 2.25F, -0.3927F, 0.2618F, 0.0F));

		PartDefinition cube_r28 = rock2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(18, 25).addBox(-5.1727F, -1.4169F, -1.1076F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition rock17 = whole.addOrReplaceChild("rock17", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -4.5F, 4.25F, -0.3927F, 0.2618F, 0.0F));

		PartDefinition cube_r29 = rock17.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 23).addBox(-5.1727F, -1.4169F, -1.1076F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition bone6 = whole.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(37, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9659F, -6.267F, 0.5109F, 0.5236F, 0.0F, 0.0F));

		PartDefinition rock4 = whole.addOrReplaceChild("rock4", CubeListBuilder.create().texOffs(37, 0).addBox(0.4836F, 0.5641F, -2.163F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, 0.25F, -0.3927F, 0.2618F, 0.0F));

		PartDefinition rock8 = whole.addOrReplaceChild("rock8", CubeListBuilder.create().texOffs(23, 4).addBox(-2.9659F, 0.099F, -1.2391F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(23, 4).addBox(-2.1895F, 1.208F, -3.9163F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -5.5F, 1.25F, -0.3927F, 0.2618F, 0.0F));

		PartDefinition rock9 = whole.addOrReplaceChild("rock9", CubeListBuilder.create().texOffs(8, 25).addBox(-3.673F, -0.4323F, -2.3706F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 25).addBox(-2.8966F, 0.6767F, -5.0478F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.5F, 3.25F, -0.3927F, 0.2618F, 0.0F));

		PartDefinition rock11 = whole.addOrReplaceChild("rock11", CubeListBuilder.create().texOffs(23, 0).addBox(-4.7777F, -2.5646F, 5.3904F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, -0.75F, -0.3927F, 0.2618F, 0.0F));

		PartDefinition rock12 = whole.addOrReplaceChild("rock12", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.5F, 2.25F, -0.6981F, -0.0873F, -0.48F));

		PartDefinition cube_r30 = rock12.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(15, 16).addBox(-5.3447F, 1.4785F, -5.66F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(15, 16).addBox(-5.673F, -0.4323F, -3.3706F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition rock10 = whole.addOrReplaceChild("rock10", CubeListBuilder.create().texOffs(24, 13).addBox(-2.9659F, -0.901F, -1.2391F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.5F, 3.25F, -0.3927F, 0.2618F, 0.0F));

		PartDefinition rock3 = whole.addOrReplaceChild("rock3", CubeListBuilder.create().texOffs(14, 34).addBox(-1.9659F, -0.901F, -1.2391F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 34).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -5.5F, 0.25F, -0.3927F, 0.2618F, 0.0F));

		PartDefinition rightMicroLegs = whole.addOrReplaceChild("rightMicroLegs", CubeListBuilder.create().texOffs(2, 21).addBox(0.0F, -1.75F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(15, 17).addBox(0.0F, -0.75F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(21, 8).addBox(0.0F, -1.75F, 1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(9, 19).addBox(0.0F, -0.75F, 2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(9, 19).addBox(0.0F, -0.75F, 4.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 21).addBox(0.0F, -1.75F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.25F, 0.25F));

		PartDefinition leftMicroLegs = whole.addOrReplaceChild("leftMicroLegs", CubeListBuilder.create().texOffs(17, 8).addBox(-1.0F, 3.0F, -7.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 19).addBox(-1.0F, 3.0F, -5.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 19).addBox(-1.0F, 3.0F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 21).addBox(-1.0F, 2.0F, -6.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 10).addBox(-1.0F, 2.0F, -4.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 12).addBox(-1.0F, 2.0F, -8.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 7.25F));

		PartDefinition rightForeLimb = whole.addOrReplaceChild("rightForeLimb", CubeListBuilder.create().texOffs(3, 7).addBox(0.1F, -1.25F, 0.25F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.75F, -3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition rightClaw = rightForeLimb.addOrReplaceChild("rightClaw", CubeListBuilder.create().texOffs(4, 0).addBox(0.0F, 0.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.1F, -0.25F, 0.25F));

		PartDefinition leftForeLimb = whole.addOrReplaceChild("leftForeLimb", CubeListBuilder.create().texOffs(11, 7).addBox(-0.1F, -1.25F, 0.25F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.75F, -3.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition leftClaw = leftForeLimb.addOrReplaceChild("leftClaw", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, 0.0F, -1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, -0.25F, 0.25F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(21, 21).addBox(-2.0F, 2.0F, -5.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-7.0F, 2.0F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 9).addBox(-2.0F, 2.0F, -1.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-4.0F, 2.0F, -5.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 17.0F, 1.0F));

		PartDefinition rock13 = bone.addOrReplaceChild("rock13", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -1.0F, -1.0F, -0.829F, 0.1309F, -0.7418F));

		PartDefinition cube_r31 = rock13.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(11, 11).addBox(-6.9565F, -0.324F, -3.0925F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(11, 11).addBox(-5.5044F, -2.1503F, -1.2067F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 1.0F, 0.1745F, -0.4363F, -0.48F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityScuttlingOcculus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		whole.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}