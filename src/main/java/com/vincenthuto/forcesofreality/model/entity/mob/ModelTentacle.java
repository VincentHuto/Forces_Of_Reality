package com.vincenthuto.forcesofreality.model.entity.mob;
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings

// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.summon.EntityTentacle;

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

public class ModelTentacle extends EntityModel<EntityTentacle> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modeltentacle"), "main");
	private final ModelPart Tip;
	private final ModelPart Third;
	private final ModelPart Second;
	private final ModelPart Base;

	public ModelTentacle(ModelPart root) {
		this.Tip = root.getChild("Tip");
		this.Third = root.getChild("Third");
		this.Second = root.getChild("Second");
		this.Base = root.getChild("Base");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Tip = partdefinition.addOrReplaceChild("Tip",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-1.0F, -2.1F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 23)
						.addBox(-2.0F, -3.1F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(12, 23)
						.addBox(-1.0F, -5.1F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 12)
						.addBox(-2.0F, -6.1F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(24, 0)
						.addBox(-1.0F, -10.1F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 10.1F, 0.0F));

		PartDefinition Third = partdefinition.addOrReplaceChild("Third", CubeListBuilder.create().texOffs(20, 20)
				.addBox(-2.0F, -5.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition Second = partdefinition.addOrReplaceChild("Second", CubeListBuilder.create().texOffs(0, 12)
				.addBox(-3.0F, -4.5F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 19.5F, 0.0F));

		PartDefinition Base = partdefinition.addOrReplaceChild("Base", CubeListBuilder.create().texOffs(0, 0).addBox(
				-4.0F, -4.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityTentacle entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Tip.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Third.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Second.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}