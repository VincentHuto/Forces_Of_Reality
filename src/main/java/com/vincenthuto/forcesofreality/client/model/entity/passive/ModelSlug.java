package com.vincenthuto.forcesofreality.client.model.entity.passive;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.common.entity.passive.EntitySlug;

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

public class ModelSlug extends EntityModel<EntitySlug> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modelslug"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(5, 0)
						.addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(5, 0)
						.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.5F, 24.0F, -2.0F));

		PartDefinition LeftEye = Head.addOrReplaceChild("LeftEye",
				CubeListBuilder.create().texOffs(3, 0)
						.addBox(0.0F, -1.0F, -6.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(0.0F, 0.0F, -5.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.5F, 0.0F, 2.0F));

		PartDefinition RightEye = Head.addOrReplaceChild("RightEye",
				CubeListBuilder.create().texOffs(3, 4)
						.addBox(-1.5F, -1.0F, -7.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 1)
						.addBox(-1.5F, 0.0F, -6.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 4)
						.addBox(-0.5F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.5F, 24.0F, 0.0F));

		PartDefinition Tail = partdefinition.addOrReplaceChild("Tail",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.5F, 0.5F, 0.0F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.5F, 23.5F, 1.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}
	private final ModelPart Head;
	private final ModelPart Body;

	private final ModelPart Tail;

	public ModelSlug(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.Tail = root.getChild("Tail");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(EntitySlug entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}
}