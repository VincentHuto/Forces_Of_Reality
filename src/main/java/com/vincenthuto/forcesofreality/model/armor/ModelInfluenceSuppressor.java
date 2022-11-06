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


public class ModelInfluenceSuppressor<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modelinfluencesuppressor"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftBand = partdefinition.addOrReplaceChild("LeftBand", CubeListBuilder.create().texOffs(0, 40).addBox(4.0F, -6.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BackBand = partdefinition.addOrReplaceChild("BackBand", CubeListBuilder.create().texOffs(18, 49).addBox(-4.0F, -6.0F, 4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightBand = partdefinition.addOrReplaceChild("RightBand", CubeListBuilder.create().texOffs(18, 40).addBox(-5.0F, -6.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Mask = partdefinition.addOrReplaceChild("Mask", CubeListBuilder.create().texOffs(0, 52).addBox(-3.0F, -7.0F, -5.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 49).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 54).addBox(-3.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(2.0F, -3.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 52).addBox(1.0F, -4.0F, -5.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(14, 52).addBox(-4.0F, -4.0F, -5.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}
	private final ModelPart LeftBand;
	private final ModelPart BackBand;
	private final ModelPart RightBand;

	private final ModelPart Mask;

	public ModelInfluenceSuppressor(ModelPart root) {
		this.LeftBand = root.getChild("LeftBand");
		this.BackBand = root.getChild("BackBand");
		this.RightBand = root.getChild("RightBand");
		this.Mask = root.getChild("Mask");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftBand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackBand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightBand.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Mask.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}