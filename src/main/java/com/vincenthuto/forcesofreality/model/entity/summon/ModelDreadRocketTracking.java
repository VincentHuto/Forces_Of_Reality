package com.vincenthuto.forcesofreality.model.entity.summon;

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

// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelDreadRocketTracking<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "custom_model"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition rocket = partdefinition.addOrReplaceChild("rocket",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-1.0F, -2.0222F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 4)
						.addBox(-0.5F, -4.3222F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 21.0222F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition bone4 = rocket.addOrReplaceChild("bone4",
				CubeListBuilder.create().texOffs(8, 8).addBox(-0.983F, -2.2294F, -1.0F, 1.0F, 3.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.6F, 2.1778F, 0.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition bone5 = rocket.addOrReplaceChild("bone5",
				CubeListBuilder.create().texOffs(4, 6).addBox(-0.5F, -2.2035F, -0.6136F, 1.0F, 3.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.1F, 2.1778F, -1.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition bone6 = rocket.addOrReplaceChild("bone6",
				CubeListBuilder.create().texOffs(7, 12).addBox(-0.6F, -6.2402F, -0.865F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.1F, 2.1778F, 2.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition bone3 = rocket.addOrReplaceChild("bone3",
				CubeListBuilder.create().texOffs(8, 0).addBox(-0.017F, -2.2294F, -0.49F, 1.0F, 3.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.6F, 2.1778F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition cone = rocket.addOrReplaceChild("cone", CubeListBuilder.create(),
				PartPose.offset(0.5F, 1.9778F, -0.5F));

		PartDefinition bone9 = cone.addOrReplaceChild("bone9",
				CubeListBuilder.create().texOffs(0, 10).addBox(-0.75F, -1.0987F, -1.0F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.1F, -4.8F, 1.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition bone10 = cone
				.addOrReplaceChild("bone10",
						CubeListBuilder.create().texOffs(0, 6).addBox(-0.5F, -2.2035F, -1.3864F, 1.0F, 3.0F, 1.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(-0.4F, 0.2F, 2.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition bone7 = cone.addOrReplaceChild("bone7",
				CubeListBuilder.create().texOffs(4, 10).addBox(-0.6F, -0.9586F, -0.7551F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.4F, -4.8F, 0.5F, -0.2618F, 0.0F, 0.0F));

		PartDefinition bone2 = cone.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(11, 11).addBox(-0.1843F, -1.0811F, -0.49F, 1.0F, 2.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.1F, -4.8F, 0.5F, 0.0F, 0.0F, 0.2618F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	private final ModelPart rocket;

	public ModelDreadRocketTracking(ModelPart root) {
		this.rocket = root.getChild("rocket");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		rocket.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}
}