package com.vincenthuto.forcesofreality.model.entity.passive;
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings

// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.passive.EntityDenizen;

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

public class ModelDenizen extends EntityModel<EntityDenizen> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modeldenizen"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create()
				.texOffs(40, 40).addBox(-4.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 2.0F, 1.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(0, 38)
						.addBox(-4.0F, -15.5F, 0.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-9.0F, -16.5F, -4.0F, 18.0F, 25.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(49, 0)
						.addBox(-2.0F, -9.0F, -6.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(50, 50)
						.addBox(-1.0F, -7.0F, -12.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 7)
						.addBox(-1.0F, -5.0F, -13.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 54)
						.addBox(-2.0F, -7.0F, -1.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 1.0F, 2.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(24, 38)
				.addBox(0.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(4.0F, 2.0F, 1.0F));

		PartDefinition right_leg = left_arm.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(28, 54)
						.addBox(-4.0F, -4.5F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 32)
						.addBox(-3.0F, 7.5F, -2.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(42, 56)
						.addBox(-3.0F, 2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(36, 38)
						.addBox(-4.0F, 7.5F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 38)
						.addBox(-2.0F, 7.5F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.0F, 14.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(14, 54)
						.addBox(1.0F, -4.5F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(6, 9)
						.addBox(1.0F, 7.5F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(6, 6)
						.addBox(3.0F, 7.5F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(1.0F, 2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(56, 39)
						.addBox(1.0F, 7.5F, -2.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 16.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	private final ModelPart right_arm;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart left_arm;

	private final ModelPart left_leg;

	public ModelDenizen(ModelPart root) {
		this.right_arm = root.getChild("right_arm");
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.left_arm = root.getChild("left_arm");
		this.left_leg = root.getChild("left_leg");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(EntityDenizen entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

	}
}