package com.vincenthuto.forcesofreality.model.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

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

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelHasturPylon<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "modelhasturpylon"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition main = partdefinition.addOrReplaceChild("main",
				CubeListBuilder.create().texOffs(50, 26)
						.addBox(4.0F, -1.0F, -13.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(23, 10)
						.addBox(6.0F, 1.0F, -14.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(50, 26)
						.addBox(7.0F, -1.0F, -16.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(50, 26)
						.addBox(13.0F, -1.0F, -13.0F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(50, 26)
						.addBox(7.0F, -1.0F, -7.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(13, 2)
						.addBox(7.0F, 8.0F, -13.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(14, 44)
						.addBox(5.0F, 7.0F, -12.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(14, 44)
						.addBox(8.0F, 7.0F, -8.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 44)
						.addBox(8.0F, 7.0F, -15.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 44)
						.addBox(12.0F, 7.0F, -12.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(14, 44)
						.addBox(12.0F, -3.0F, -8.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 44)
						.addBox(5.0F, -3.0F, -8.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 44)
						.addBox(5.0F, -3.0F, -15.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(14, 44)
						.addBox(12.0F, -3.0F, -15.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-9.0F, 11.0F, 11.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	private final ModelPart main;

	public ModelHasturPylon(ModelPart root) {
		this.main = root.getChild("main");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}
}