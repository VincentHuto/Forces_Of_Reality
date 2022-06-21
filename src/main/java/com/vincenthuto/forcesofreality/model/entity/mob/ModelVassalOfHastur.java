package com.vincenthuto.forcesofreality.model.entity.mob;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.mob.EntityHasturVassal;

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

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class ModelVassalOfHastur extends EntityModel<EntityHasturVassal> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "vassalofhastur"), "main");
	private final ModelPart body;
	private final ModelPart tentacle1;
	private final ModelPart tentacle2;
	private final ModelPart tentacle3;
	private final ModelPart tentacle4;
	private final ModelPart tentacle5;
	private final ModelPart tentacle6;
	private final ModelPart tentacle7;
	private final ModelPart tentacle8;

	public ModelVassalOfHastur(ModelPart root) {
		this.body = root.getChild("body");
		this.tentacle1 = root.getChild("tentacle1");
		this.tentacle2 = root.getChild("tentacle2");
		this.tentacle3 = root.getChild("tentacle3");
		this.tentacle4 = root.getChild("tentacle4");
		this.tentacle5 = root.getChild("tentacle5");
		this.tentacle6 = root.getChild("tentacle6");
		this.tentacle7 = root.getChild("tentacle7");
		this.tentacle8 = root.getChild("tentacle8");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cloak = body.addOrReplaceChild("cloak", CubeListBuilder.create().texOffs(0, 17).addBox(-7.0F, -8.0F, -18.1F, 0.0F, 17.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 17).addBox(6.1F, -8.0F, -18.1F, 0.0F, 17.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(-6.0F, -7.0F, -18.2F, 12.0F, 16.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(-6.0F, -8.0F, -6.0F, 12.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 12.1F));

		PartDefinition mouth = body.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(10, 20).addBox(-6.0F, 1.2879F, -8.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(10, 20).addBox(-6.0F, 1.2879F, 6.0F, 12.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(10, 20).addBox(-6.0F, -0.7121F, 7.0F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 20).addBox(-6.0F, -0.7121F, -8.0F, 12.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 12).mirror().addBox(6.0F, 0.2879F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(10, 12).addBox(-8.0F, -0.7121F, -6.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(10, 12).addBox(-7.0F, 0.2879F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 12).mirror().addBox(-7.0F, 0.2879F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(10, 12).addBox(6.0F, 0.2879F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 12).addBox(7.0F, -0.7121F, -6.0F, 1.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(10, 12).addBox(-8.0F, 1.2879F, -6.0F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(10, 12).addBox(6.0F, 1.2879F, -6.0F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, 2.2879F, -6.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.2879F, 0.0F));

		PartDefinition teeth = mouth.addOrReplaceChild("teeth", CubeListBuilder.create().texOffs(46, 30).mirror().addBox(10.0F, 5.0F, -3.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(46, 30).mirror().addBox(11.0F, 3.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(46, 30).mirror().addBox(9.0F, 7.0F, 3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(46, 30).mirror().addBox(4.0F, 4.0F, 4.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(46, 30).mirror().addBox(5.0F, 4.0F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(48, 30).addBox(1.0F, 6.0F, -3.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(1.0F, 6.0F, -1.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(1.0F, 6.0F, 1.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(1.0F, 6.0F, 3.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(1.0F, 6.0F, 5.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(4.0F, 6.0F, 6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(6.0F, 6.0F, 6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(8.0F, 6.0F, 6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(10.0F, 6.0F, 6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(12.0F, 6.0F, 6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(13.0F, 6.0F, 5.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(13.0F, 6.0F, 3.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(13.0F, 6.0F, 1.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(13.0F, 6.0F, -1.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(13.0F, 6.0F, -3.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(12.0F, 6.0F, -6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(10.0F, 6.0F, -6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(8.0F, 6.0F, -6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(6.0F, 6.0F, -6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 30).addBox(4.0F, 6.0F, -6.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -7.7121F, -1.0F));

		PartDefinition tentacle1 = partdefinition.addOrReplaceChild("tentacle1", CubeListBuilder.create().texOffs(0, 39).addBox(-5.9F, 1.0F, 2.0F, 12.0F, 24.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 18).addBox(-1.0F, 13.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-1.0F, 4.0F, 1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 31.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition tentacle2 = partdefinition.addOrReplaceChild("tentacle2", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-3.5F, 1.0F, 0.0F, 6.0F, 21.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 31.0F, 3.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition tentacle3 = partdefinition.addOrReplaceChild("tentacle3", CubeListBuilder.create().texOffs(0, 29).addBox(-6.0F, 1.0F, 2.1F, 12.0F, 24.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 18).addBox(-1.0F, 13.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-1.0F, 4.0F, 1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 31.0F, 5.0F));

		PartDefinition tentacle4 = partdefinition.addOrReplaceChild("tentacle4", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-3.0F, 1.0F, 0.0F, 6.0F, 21.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 31.0F, 3.5F, 0.0F, -0.7854F, 0.0F));

		PartDefinition tentacle5 = partdefinition.addOrReplaceChild("tentacle5", CubeListBuilder.create().texOffs(0, 30).addBox(-6.0F, 1.0F, 2.0F, 12.0F, 23.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 18).addBox(-1.0F, 13.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-1.0F, 4.0F, 1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 31.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition tentacle6 = partdefinition.addOrReplaceChild("tentacle6", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-3.0F, 1.0F, -0.5F, 6.0F, 21.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 31.0F, -3.5F, 0.0F, -2.3562F, 0.0F));

		PartDefinition tentacle7 = partdefinition.addOrReplaceChild("tentacle7", CubeListBuilder.create().texOffs(0, 29).addBox(-6.0F, 1.0F, 2.0F, 12.0F, 24.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 18).addBox(-1.0F, 13.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-1.0F, 4.0F, 1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 31.0F, -5.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition tentacle8 = partdefinition.addOrReplaceChild("tentacle8", CubeListBuilder.create().texOffs(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-3.0F, 1.0F, 0.0F, 6.0F, 21.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 31.0F, -3.5F, 0.0F, -3.927F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityHasturVassal entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tentacle1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tentacle2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tentacle3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tentacle4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tentacle5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tentacle6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tentacle7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tentacle8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}