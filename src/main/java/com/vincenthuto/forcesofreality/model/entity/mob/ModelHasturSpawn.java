package com.vincenthuto.forcesofreality.model.entity.mob;
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.summon.EntityHasturSpawn;

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

public class ModelHasturSpawn extends EntityModel<EntityHasturSpawn> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modelhasturspawn"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(12, 12).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(6, 16).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.5F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.5F, 0.0F));

		PartDefinition LeftShould = Body.addOrReplaceChild("LeftShould", CubeListBuilder.create().texOffs(0, 16).addBox(-1.0F, -3.0F, -3.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 1.5F, 1.0F));

		PartDefinition RightShould = Body.addOrReplaceChild("RightShould", CubeListBuilder.create().texOffs(10, 17).addBox(1.0F, -3.0F, -3.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 1.5F, 1.0F));

		PartDefinition FrontShould = Body.addOrReplaceChild("FrontShould", CubeListBuilder.create().texOffs(16, 17).addBox(-3.0F, -4.0F, 2.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.5F, -6.0F));

		PartDefinition BackShould = Body.addOrReplaceChild("BackShould", CubeListBuilder.create().texOffs(20, 21).addBox(-3.0F, -4.0F, 1.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 2.5F, 2.0F));

		PartDefinition FrontTent = partdefinition.addOrReplaceChild("FrontTent", CubeListBuilder.create().texOffs(26, 17).addBox(-1.0F, 6.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 28).addBox(-2.0F, 4.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(27, 27).addBox(-1.0F, 2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 28).addBox(-2.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(22, 25).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, -4.5F));

		PartDefinition BackTent = partdefinition.addOrReplaceChild("BackTent", CubeListBuilder.create().texOffs(25, 0).addBox(0.0F, 6.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(1.0F, 4.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 12).addBox(0.0F, 2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 12).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 4.5F));

		PartDefinition RightTent = partdefinition.addOrReplaceChild("RightTent", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(29, 14).addBox(-0.5F, 0.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 8).addBox(-0.5F, 2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 5).addBox(-0.5F, 4.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 2).addBox(-0.5F, 6.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 11.0F, 0.0F));

		PartDefinition LeftTent = partdefinition.addOrReplaceChild("LeftTent", CubeListBuilder.create().texOffs(12, 24).addBox(-0.5F, -2.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 30).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(5, 29).addBox(-0.5F, 2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(29, 24).addBox(-0.5F, 4.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(29, 19).addBox(-0.5F, 6.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 11.0F, 0.0F));

		PartDefinition Waist = partdefinition.addOrReplaceChild("Waist", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, 0.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.5F, 0.5F));

		PartDefinition RightLeg = Waist.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(8, 30).addBox(-0.5F, 7.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 25).addBox(-0.5F, 3.0F, 0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 2.5F, -1.0F));

		PartDefinition LeftLeg = Waist.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(6, 23).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(15, 30).addBox(-0.5F, 7.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 6).addBox(-0.5F, 3.0F, 0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 2.5F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart FrontTent;
	private final ModelPart BackTent;
	private final ModelPart RightTent;
	private final ModelPart LeftTent;

	private final ModelPart Waist;

	public ModelHasturSpawn(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.FrontTent = root.getChild("FrontTent");
		this.BackTent = root.getChild("BackTent");
		this.RightTent = root.getChild("RightTent");
		this.LeftTent = root.getChild("LeftTent");
		this.Waist = root.getChild("Waist");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		FrontTent.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackTent.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightTent.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftTent.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Waist.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(EntityHasturSpawn entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}