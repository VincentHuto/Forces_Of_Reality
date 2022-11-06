package com.vincenthuto.forcesofreality.model.entity.passive;
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings

// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.passive.EntityDenizenSage;

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

public class ModelDenizenSage extends EntityModel<EntityDenizenSage> implements ArmedModel {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "steve"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(52, 39)
						.addBox(-2.0F, -3.0F, -3.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(48, 32)
						.addBox(-2.0F, -6.0F, -7.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(27, 51)
						.addBox(-1.0F, -5.0F, -12.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(30, 0)
						.addBox(-1.0F, -3.0F, -14.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 24)
						.addBox(-5.0F, -10.6667F, -2.0F, 10.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-5.0F, 1.3333F, -3.0F, 10.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(35, 19)
						.addBox(-4.0F, -7.6667F, -7.0F, 8.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 9.6667F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 0)
				.addBox(-3.0F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 2.0F, -1.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(38, 38)
				.addBox(0.0F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, -1.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(16, 45)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.1F, 7.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(45, 47)
						.addBox(-1.2F, 12.0F, -2.0F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(54, 0)
						.addBox(-2.2F, 12.0F, -4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(29, 29)
						.addBox(-0.2F, 12.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 11.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(0, 45)
						.addBox(-1.9F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 24)
						.addBox(-1.0F, 7.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(47, 9)
						.addBox(-1.0F, 12.0F, -2.0F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(36, 54)
						.addBox(1.0F, 12.0F, -4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 7)
						.addBox(-1.0F, 12.0F, -4.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 11.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;

	private final ModelPart LeftLeg;

	public ModelDenizenSage(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
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
	}

	@Override
	public void setupAnim(EntityDenizenSage entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

	}

	@Override
	public void translateToHand(HumanoidArm pSide, PoseStack pPoseStack) {
		// TODO Auto-generated method stub

	}
}