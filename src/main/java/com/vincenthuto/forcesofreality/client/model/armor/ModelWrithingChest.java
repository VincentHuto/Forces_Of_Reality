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


public class ModelWrithingChest<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modelwrithingchest"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(19, 58).addBox(2.0F, 1.0F, 2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(2.0F, 7.0F, 2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(-7.0F, 1.0F, 2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(-7.0F, 7.0F, 2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 57).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(5.0F, -1.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(8.0F, -3.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(5.0F, 9.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(8.0F, 11.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(-9.0F, -1.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(-12.0F, -3.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(-9.0F, 9.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(-12.0F, 11.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(4.0F, 0.0F, 4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(4.0F, 8.0F, 4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(-8.0F, 0.0F, 4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 58).addBox(-8.0F, 8.0F, 4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(16, 16).addBox(-4.0F, 0.0F, 2.0F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition eye1 = partdefinition.addOrReplaceChild("eye1", CubeListBuilder.create().texOffs(0, 56).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 15.0F, 3.0F));

		PartDefinition eye2 = partdefinition.addOrReplaceChild("eye2", CubeListBuilder.create().texOffs(0, 56).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -4.0F, 3.0F));

		PartDefinition eye3 = partdefinition.addOrReplaceChild("eye3", CubeListBuilder.create().texOffs(0, 56).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, -4.0F, 3.0F));

		PartDefinition eye4 = partdefinition.addOrReplaceChild("eye4", CubeListBuilder.create().texOffs(0, 56).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 15.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart eye1;
	private final ModelPart eye2;
	private final ModelPart eye3;

	private final ModelPart eye4;

	public ModelWrithingChest(ModelPart root) {
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.eye1 = root.getChild("eye1");
		this.eye2 = root.getChild("eye2");
		this.eye3 = root.getChild("eye3");
		this.eye4 = root.getChild("eye4");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		eye1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		eye2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		eye3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		eye4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}