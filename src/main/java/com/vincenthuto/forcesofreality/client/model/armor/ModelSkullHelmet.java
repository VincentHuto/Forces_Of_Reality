package com.vincenthuto.forcesofreality.client.model.armor;

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


public class ModelSkullHelmet<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modelskullhelmet"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(64, 49).addBox(-4.0F, -8.0F, 4.0F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(64, 36).addBox(4.0F, -8.0F, -3.0F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(64, 36).addBox(-4.0F, -8.0F, -3.0F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(14, 47).addBox(-3.0F, -10.0F, -3.0F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(14, 47).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 0.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(64, 56).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(16, 47).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -11.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Head_r2 = Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(22, 49).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -6.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Head_r3 = Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(22, 48).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -7.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Head_r4 = Head.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(35, 52).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -11.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Head_r5 = Head.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(14, 50).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -7.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Head_r6 = Head.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(5, 47).addBox(1.975F, 0.5F, -7.375F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(23, 41).addBox(-0.025F, -0.5F, -2.375F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(33, 53).addBox(-4.025F, -1.5F, 1.625F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 56).addBox(13.775F, -1.5F, 1.625F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(11, 49).addBox(13.775F, -1.5F, -2.375F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 59).addBox(-3.025F, -1.5F, -2.375F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(2, 49).addBox(11.775F, -0.5F, -2.375F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(9, 47).addBox(9.775F, 0.5F, -7.375F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.875F, -10.5F, 5.375F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Head_r7 = Head.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(4, 52).addBox(3.025F, -1.5F, 1.625F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 43).addBox(23.025F, -1.5F, 1.625F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(17, 56).addBox(0.025F, -1.5F, 1.625F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(7, 51).addBox(20.025F, -1.5F, 1.625F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.125F, -11.5F, 7.375F, 0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	private final ModelPart Head;

	public ModelSkullHelmet(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}