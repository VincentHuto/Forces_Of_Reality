package com.vincenthuto.forcesofreality.client.model.entity.guardian;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.entity.guardian.EntitySeraphim;

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

public class ModelSeraphim extends EntityModel<EntitySeraphim> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modelseraphim"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(18, 10).addBox(
				-4.0F, -1.0F, -1.5F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -0.5F));

		PartDefinition Skull = Head.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(34, 6).addBox(-1.0F,
				-1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.5F));

		PartDefinition Halo = Head.addOrReplaceChild("Halo",
				CubeListBuilder.create().texOffs(37, 24)
						.addBox(-3.0F, 3.0F, -0.5F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(34, 30)
						.addBox(-3.0F, -5.0F, -0.5F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(54, 10)
						.addBox(-5.0F, -3.0F, -0.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(26, 54)
						.addBox(3.0F, -3.0F, -0.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 0)
						.addBox(3.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(34, 17)
						.addBox(-4.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(34, 2)
						.addBox(-4.0F, 3.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(34, 0)
						.addBox(3.0F, 3.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -7.0F, 1.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(
				-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Belt = Body.addOrReplaceChild("Belt",
				CubeListBuilder.create().texOffs(40, 12)
						.addBox(-3.0F, -13.0F, -3.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(37, 35)
						.addBox(-3.0F, -13.0F, 1.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(34, 0)
						.addBox(3.0F, -13.0F, -3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(30, 24)
						.addBox(-4.0F, -13.0F, -3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition SideTails = Belt.addOrReplaceChild("SideTails", CubeListBuilder.create(),
				PartPose.offset(-4.5F, -7.5F, -0.5F));

		PartDefinition Bib = Body.addOrReplaceChild("Bib",
				CubeListBuilder.create().texOffs(41, 14)
						.addBox(2.0F, -1.8333F, 1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 14)
						.addBox(-4.0F, -1.8333F, 1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(43, 37)
						.addBox(2.0F, -1.8333F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(37, 6)
						.addBox(4.0F, -1.8333F, -3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(34, 14)
						.addBox(-5.0F, -1.8333F, -3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(34, 20)
						.addBox(-3.0F, 0.1667F, -3.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 14)
						.addBox(-3.0F, 0.1667F, 1.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(43, 40)
						.addBox(-4.0F, -1.8333F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 1.8333F, 0.0F));

		PartDefinition Tail = Body.addOrReplaceChild("Tail", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-3.0F, 29.0F, 4.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition f1 = Tail.addOrReplaceChild("f1",
				CubeListBuilder.create().texOffs(37, 37).addBox(-1.738F, -0.1718F, -0.573F, 2.0F, 11.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -17.0F, -1.5F, 0.0F, -0.6109F, 0.2182F));

		PartDefinition f2 = Tail
				.addOrReplaceChild("f2",
						CubeListBuilder.create().texOffs(46, 0).addBox(-2.4855F, -17.0225F, -2.0F, 2.0F, 9.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition f3 = Tail.addOrReplaceChild("f3", CubeListBuilder.create().texOffs(49, 49).addBox(-3.0F, -17.0F,
				-2.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 0.0F, 0.0F));

		PartDefinition f4 = Tail
				.addOrReplaceChild("f4",
						CubeListBuilder.create().texOffs(20, 46).addBox(-2.5031F, -17.2839F, -2.0F, 2.0F, 9.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition f5 = Tail.addOrReplaceChild("f5",
				CubeListBuilder.create().texOffs(6, 36).addBox(-3.3102F, -17.3076F, -2.097F, 2.0F, 11.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(13.0F, -1.0F, -2.0F, 0.0F, 0.6109F, -0.2182F));

		PartDefinition Tail2 = Body.addOrReplaceChild("Tail2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 24.0F, -2.0F, 0.0436F, 3.1416F, 0.0F));

		PartDefinition f6 = Tail2.addOrReplaceChild("f6",
				CubeListBuilder.create().texOffs(0, 36).addBox(-1.738F, -0.1718F, -0.573F, 2.0F, 11.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, -12.0F, 1.5F, 0.0F, -0.6109F, 0.2182F));

		PartDefinition f7 = Tail2
				.addOrReplaceChild("f7",
						CubeListBuilder.create().texOffs(27, 44).addBox(-2.4855F, -17.0225F, -2.0F, 2.0F, 9.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-2.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition f8 = Tail2.addOrReplaceChild("f8", CubeListBuilder.create().texOffs(48, 14).addBox(-3.0F, -17.0F,
				-2.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 5.0F, 3.0F));

		PartDefinition f9 = Tail2
				.addOrReplaceChild("f9",
						CubeListBuilder.create().texOffs(43, 43).addBox(-2.5031F, -17.2839F, -2.0F, 2.0F, 9.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(5.0F, 5.0F, 3.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition f10 = Tail2.addOrReplaceChild("f10",
				CubeListBuilder.create().texOffs(21, 34).addBox(-3.3102F, -17.3076F, -2.097F, 2.0F, 11.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(10.0F, 4.0F, 1.0F, 0.0F, 0.6109F, -0.2182F));

		PartDefinition r = partdefinition.addOrReplaceChild("r", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition l = partdefinition.addOrReplaceChild("l", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 48)
				.addBox(0.0F, -1.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition RightFore = RightArm.addOrReplaceChild("RightFore",
				CubeListBuilder.create().texOffs(51, 23).mirror()
						.addBox(-1.4142F, -1.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, 5.0F, -1.0F, -1.6581F, -0.7854F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(10, 47)
				.addBox(-2.0F, -1.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition LeftFore = LeftArm.addOrReplaceChild("LeftFore",
				CubeListBuilder.create().texOffs(49, 35).addBox(-0.5858F, -1.0F, 0.0F, 2.0F, 7.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 5.0F, -1.0F, -1.6581F, 0.7854F, 0.0F));

		PartDefinition LeftWing = partdefinition.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(41, 53)
				.addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 15)
				.addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 2.0F, 1.5F, 0.2182F, -0.1309F, -2.3562F));

		PartDefinition Limb3 = LeftWing.addOrReplaceChild("Limb3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -1.6581F));

		PartDefinition Limb1 = LeftWing.addOrReplaceChild("Limb1",
				CubeListBuilder.create().texOffs(37, 49)
						.addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
						.texOffs(37, 33).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
						.texOffs(18, 0).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 12.5F, -0.5F, 0.0F, 0.0F, 0.5672F));

		PartDefinition LeftWing2 = partdefinition.addOrReplaceChild("LeftWing2", CubeListBuilder.create()
				.texOffs(41, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 15).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 2.0F, 1.5F, 0.3054F, 0.48F, -2.8362F));

		PartDefinition Limb7 = LeftWing2.addOrReplaceChild("Limb7", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -1.6581F));

		PartDefinition Limb8 = LeftWing2.addOrReplaceChild("Limb8",
				CubeListBuilder.create().texOffs(37, 49)
						.addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
						.texOffs(37, 33).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
						.texOffs(18, 0).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 12.5F, -0.5F, 0.0F, 0.0F, 0.5672F));

		PartDefinition RightWing = partdefinition.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(52, 0)
				.addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 18)
				.addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 2.0F, 1.5F, 0.3054F, 0.1309F, 2.3562F));

		PartDefinition Limb2 = RightWing.addOrReplaceChild("Limb2", CubeListBuilder.create().texOffs(33, 44)
				.addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(37, 27)
				.addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
				.addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.1684F, 12.096F, 0.5702F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Limb4 = RightWing.addOrReplaceChild("Limb4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(8.0F, 3.0F, 0.0F, 0.0F, 0.0F, -1.6581F));

		PartDefinition RightWing2 = partdefinition.addOrReplaceChild("RightWing2", CubeListBuilder.create()
				.texOffs(52, 0).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 2.0F, 1.5F, 0.2182F, -0.48F, 2.8362F));

		PartDefinition Limb5 = RightWing2.addOrReplaceChild("Limb5", CubeListBuilder.create().texOffs(33, 44)
				.addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(37, 27)
				.addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
				.addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.1684F, 12.096F, 0.5702F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Limb6 = RightWing2.addOrReplaceChild("Limb6", CubeListBuilder.create(),
				PartPose.offsetAndRotation(8.0F, 3.0F, 0.0F, 0.0F, 0.0F, -1.6581F));

		PartDefinition LeftWing3 = partdefinition.addOrReplaceChild("LeftWing3", CubeListBuilder.create()
				.texOffs(41, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 15).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 2.0F, 1.5F, 0.2181F, 0.6982F, 2.8798F));

		PartDefinition Limb9 = LeftWing3.addOrReplaceChild("Limb9", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -1.6581F));

		PartDefinition Limb10 = LeftWing3.addOrReplaceChild("Limb10",
				CubeListBuilder.create().texOffs(37, 49)
						.addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
						.texOffs(37, 33).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
						.texOffs(18, 0).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 12.5F, -0.5F, 0.0F, 0.0F, 0.5672F));

		PartDefinition RightWing3 = partdefinition.addOrReplaceChild("RightWing3", CubeListBuilder.create()
				.texOffs(52, 0).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(18, 18).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 2.0F, 1.5F, 0.2181F, -0.6981F, -2.8798F));

		PartDefinition Limb11 = RightWing3.addOrReplaceChild("Limb11", CubeListBuilder.create().texOffs(33, 44)
				.addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(37, 27)
				.addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
				.addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.1684F, 12.096F, 0.5702F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Limb12 = RightWing3.addOrReplaceChild("Limb12", CubeListBuilder.create(),
				PartPose.offsetAndRotation(8.0F, 3.0F, 0.0F, 0.0F, 0.0F, -1.6581F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart r;
	private final ModelPart l;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart LeftWing;
	private final ModelPart LeftWing2;
	private final ModelPart RightWing;
	private final ModelPart RightWing2;
	private final ModelPart LeftWing3;

	private final ModelPart RightWing3;

	public ModelSeraphim(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.r = root.getChild("r");
		this.l = root.getChild("l");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.LeftWing = root.getChild("LeftWing");
		this.LeftWing2 = root.getChild("LeftWing2");
		this.RightWing = root.getChild("RightWing");
		this.RightWing2 = root.getChild("RightWing2");
		this.LeftWing3 = root.getChild("LeftWing3");
		this.RightWing3 = root.getChild("RightWing3");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		r.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		l.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(EntitySeraphim entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

	}
}