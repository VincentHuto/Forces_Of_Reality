package com.vincenthuto.forcesofreality.model.entity.passive;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.passive.EntityAngelicFowl;

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

// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelAngelicFowl extends EntityModel<EntityAngelicFowl> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modelangelicfowl"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(20, 12)
						.addBox(-1.0F, 2.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 4)
						.addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(2, 11)
						.addBox(-1.0F, 5.0F, -3.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(16, 12)
						.addBox(0.0F, 5.0F, -4.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(3, 16)
						.addBox(-2.0F, 5.0F, -4.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, 19.0F, 4.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(0, 22)
						.addBox(0.0F, 2.0F, -2.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 16)
						.addBox(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 16)
						.addBox(0.0F, 5.0F, -3.0F, 1.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(8, 17)
						.addBox(1.0F, 5.0F, -4.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 17)
						.addBox(-1.0F, 5.0F, -4.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 19.0F, 4.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 4)
						.addBox(0.0F, -2.5F, -2.1F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(1, 5)
						.addBox(0.0F, -2.5F, 2.9F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(0.0F, -2.5F, -0.1F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(2, 4)
						.addBox(0.0F, -1.5F, 3.9F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-3.0F, -1.5F, -3.1F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(10, 13)
						.addBox(-2.0F, -1.5F, -3.2F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(14, 17)
						.addBox(-1.0F, 2.5F, -3.1F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 16.5F, 2.1F));

		PartDefinition tail = Body.addOrReplaceChild("tail",
				CubeListBuilder.create().texOffs(8, 11)
						.addBox(-2.0F, 0.0F, 3.5F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(15, 0)
						.addBox(-3.0F, 0.0F, -0.5F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -0.2F, 4.3F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightWing = partdefinition.addOrReplaceChild("RightWing",
				CubeListBuilder.create().texOffs(10, 14)
						.addBox(-1.0F, -1.0F, -2.0F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(19, 4)
						.addBox(-1.0F, 2.0F, -2.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 22)
						.addBox(-1.0F, 3.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.0F, 16.0F, 2.0F));

		PartDefinition LeftWing = partdefinition.addOrReplaceChild("LeftWing",
				CubeListBuilder.create().texOffs(0, 11)
						.addBox(0.0F, -1.0F, -2.0F, 1.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(20, 12)
						.addBox(0.0F, 2.0F, -2.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(22, 22)
						.addBox(0.0F, 3.0F, -2.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 16.0F, 2.0F));

		PartDefinition Neck = partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 0).addBox(
				-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, -1.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(28, 1)
						.addBox(-1.0F, -3.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(0.5F, -4.0F, -3.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(0.5F, -5.0F, -3.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 10)
						.addBox(0.5F, -3.0F, 0.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 10)
						.addBox(0.5F, 0.0F, 1.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 11)
						.addBox(0.0F, -2.0F, -6.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(20, 20)
						.addBox(0.0F, -1.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.5F, 12.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart Body;
	private final ModelPart RightWing;
	private final ModelPart LeftWing;
	private final ModelPart Neck;

	private final ModelPart Head;

	public ModelAngelicFowl(ModelPart root) {
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.Body = root.getChild("Body");
		this.RightWing = root.getChild("RightWing");
		this.LeftWing = root.getChild("LeftWing");
		this.Neck = root.getChild("Neck");
		this.Head = root.getChild("Head");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftWing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(EntityAngelicFowl entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

	}
}