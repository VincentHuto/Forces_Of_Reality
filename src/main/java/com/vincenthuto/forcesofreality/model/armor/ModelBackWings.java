package com.vincenthuto.forcesofreality.model.armor;
// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;

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
import net.minecraft.world.entity.Entity;

public class ModelBackWings<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modelbackwings"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftWing = partdefinition.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(60, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 2.0F, 1.5F, 0.2182F, -0.1309F, -2.3562F));

		PartDefinition Limb1 = LeftWing.addOrReplaceChild("Limb1", CubeListBuilder.create().texOffs(60, 53).addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 52).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 12.5F, -0.5F, 0.0F, 0.0F, 0.5672F));

		PartDefinition LeftWing2 = partdefinition.addOrReplaceChild("LeftWing2", CubeListBuilder.create().texOffs(60, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 2.0F, 1.5F, 0.3054F, 0.48F, -2.8362F));

		PartDefinition Limb8 = LeftWing2.addOrReplaceChild("Limb8", CubeListBuilder.create().texOffs(60, 53).addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 52).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 12.5F, -0.5F, 0.0F, 0.0F, 0.5672F));

		PartDefinition RightWing = partdefinition.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(60, 53).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 54).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, 1.5F, 0.3054F, 0.1309F, 2.3562F));

		PartDefinition Limb2 = RightWing.addOrReplaceChild("Limb2", CubeListBuilder.create().texOffs(60, 53).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 52).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 54).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1684F, 12.096F, 0.5702F, 0.0F, 0.0F, -0.5672F));

		PartDefinition RightWing2 = partdefinition.addOrReplaceChild("RightWing2", CubeListBuilder.create().texOffs(60, 53).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 54).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, 1.5F, 0.2182F, -0.48F, 2.8362F));

		PartDefinition Limb5 = RightWing2.addOrReplaceChild("Limb5", CubeListBuilder.create().texOffs(60, 53).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 52).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 54).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1684F, 12.096F, 0.5702F, 0.0F, 0.0F, -0.5672F));

		PartDefinition LeftWing3 = partdefinition.addOrReplaceChild("LeftWing3", CubeListBuilder.create().texOffs(60, 53).addBox(-0.2337F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-8.2337F, -2.5531F, 0.5974F, 9.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 2.0F, 1.5F, 0.2181F, 0.6982F, 2.8798F));

		PartDefinition Limb9 = LeftWing3.addOrReplaceChild("Limb9", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -1.6581F));

		PartDefinition Limb10 = LeftWing3.addOrReplaceChild("Limb10", CubeListBuilder.create().texOffs(60, 53).addBox(-0.0012F, -5.442F, 0.0974F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 52).addBox(-6.0012F, 4.558F, 0.0974F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-7.0012F, -5.442F, 1.1F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 12.5F, -0.5F, 0.0F, 0.0F, 0.5672F));

		PartDefinition RightWing3 = partdefinition.addOrReplaceChild("RightWing3", CubeListBuilder.create().texOffs(60, 53).addBox(-0.7663F, -0.5531F, -0.4026F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 54).addBox(-0.7663F, -2.5531F, 0.5974F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, 1.5F, 0.2181F, -0.6981F, -2.8798F));

		PartDefinition Limb11 = RightWing3.addOrReplaceChild("Limb11", CubeListBuilder.create().texOffs(60, 53).addBox(-2.2013F, -5.729F, -0.9728F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 52).addBox(-1.2013F, 4.271F, -0.9728F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 54).addBox(-2.2013F, -5.729F, 0.0298F, 8.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1684F, 12.096F, 0.5702F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(29, 40).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(33, 42).addBox(-4.0F, -24.0F, -3.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(29, 40).addBox(-4.0F, -24.0F, 2.0F, 7.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(30, 42).addBox(-6.0F, 4.0F, -1.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 42).addBox(-1.0F, 5.0F, -1.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(29, 42).addBox(-6.0F, 4.0F, -1.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(30, 42).addBox(-6.0F, 5.0F, 4.0F, 5.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -6.0F, -2.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(30, 42).addBox(-1.0F, 4.0F, -1.0F, 5.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(30, 42).addBox(-1.0F, 4.0F, -1.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 42).addBox(-2.0F, 5.0F, -1.0F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(30, 42).addBox(-1.0F, 4.0F, 4.0F, 5.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -6.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	private final ModelPart LeftWing;
	private final ModelPart LeftWing2;
	private final ModelPart RightWing;
	private final ModelPart RightWing2;
	private final ModelPart LeftWing3;
	private final ModelPart RightWing3;
	private final ModelPart Body;
	private final ModelPart LeftArm;

	private final ModelPart RightArm;

	public ModelBackWings(ModelPart root) {
		this.LeftWing = root.getChild("LeftWing");
		this.LeftWing2 = root.getChild("LeftWing2");
		this.RightWing = root.getChild("RightWing");
		this.RightWing2 = root.getChild("RightWing2");
		this.LeftWing3 = root.getChild("LeftWing3");
		this.RightWing3 = root.getChild("RightWing3");
		this.Body = root.getChild("Body");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}