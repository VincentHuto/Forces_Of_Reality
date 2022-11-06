package com.vincenthuto.forcesofreality.model.armor;

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

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class ModelSparkDirector<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modelsparkdirector"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition vent2 = Body.addOrReplaceChild("vent2", CubeListBuilder.create().texOffs(22, 37).addBox(1.0F, -23.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 29).addBox(2.0F, -23.0F, 5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 3).addBox(2.0F, -22.0F, 3.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(22, 9).addBox(4.0F, -23.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(22, 12).addBox(2.0F, -23.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 31.5F, 5.0F));

		PartDefinition vent1 = Body.addOrReplaceChild("vent1", CubeListBuilder.create().texOffs(5, 40).addBox(1.0F, -23.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 6).addBox(2.0F, -23.0F, 5.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 5).addBox(2.0F, -22.0F, 3.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(42, 28).addBox(4.0F, -23.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 16).addBox(2.0F, -23.0F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 31.5F, 5.0F));

		PartDefinition sparkJar = Body.addOrReplaceChild("sparkJar", CubeListBuilder.create().texOffs(46, 0).addBox(2.5F, -23.0F, 3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 16).addBox(2.5F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 42).addBox(0.5F, -23.0F, 3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 23).addBox(0.5F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(44, 10).addBox(-1.5F, -23.0F, 3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 10).addBox(-1.5F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(40, 43).addBox(-3.0F, -23.0F, 2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 9).addBox(4.0F, -23.0F, 2.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(36, 43).addBox(-3.0F, -23.0F, -1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(4.0F, -23.0F, -1.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 42).addBox(-3.0F, -23.0F, 0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(4.0F, -23.0F, 0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 22).addBox(-3.0F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 42).addBox(4.0F, -23.0F, -3.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -17.0F, -3.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(24, 4).addBox(-3.0F, -16.0F, -5.0F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(22, 22).addBox(-3.0F, -23.0F, -5.0F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 9).addBox(-6.0F, -23.0F, -5.0F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(8, 42).addBox(8.0F, -23.0F, -5.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 42).addBox(-4.0F, -24.0F, -10.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 42).addBox(5.0F, -24.0F, -10.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(33, 34).addBox(-3.0F, -23.0F, -10.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(15, 34).addBox(-3.0F, -17.0F, -10.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 23).addBox(-2.0F, -21.0F, -10.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 23).addBox(-1.0F, -22.0F, -10.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 23).addBox(0.0F, -20.0F, -11.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 23).addBox(-3.0F, -18.0F, -11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 23).addBox(-3.0F, -22.0F, -11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 23).addBox(4.0F, -18.0F, -11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 23).addBox(4.0F, -22.0F, -11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(3.0F, -21.0F, -10.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-1.0F, -18.0F, -10.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 40).addBox(-7.0F, -23.0F, -5.0F, 1.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(5.0F, -23.0F, -5.0F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(36, 38).addBox(5.0F, -24.0F, -5.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(26, 37).addBox(-6.0F, -24.0F, -5.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 37).addBox(-6.0F, -16.0F, -5.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 17).addBox(5.0F, -16.0F, -5.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(16, 31).addBox(-3.0F, -15.0F, -5.0F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(35, 8).addBox(-3.0F, -14.0F, -5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 31).addBox(-3.0F, -13.0F, -5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(-3.0F, -24.0F, -5.0F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-2.0F, -18.0F, -2.0F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 35).addBox(-1.0F, -25.0F, -1.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0F, -26.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 7).addBox(0.0F, -27.0F, 0.5F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -29.0F, 0.5F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 7).addBox(0.0F, -30.0F, 0.5F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 3).addBox(2.0F, -29.0F, 0.5F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-2.0F, -24.0F, -2.0F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 24.5F, 7.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	private final ModelPart Body;

	public ModelSparkDirector(ModelPart root) {
		this.Body = root.getChild("Body");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}