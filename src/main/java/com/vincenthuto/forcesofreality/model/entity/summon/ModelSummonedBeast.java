package com.vincenthuto.forcesofreality.model.entity.summon;
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.summon.EntitySummonedBeast;

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

public class ModelSummonedBeast extends EntityModel<EntitySummonedBeast> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modelsummonedbeast"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;

	public ModelSummonedBeast(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 3).addBox(0.0F, -2.0F, -3.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, -10.0F));

		PartDefinition JawTop = Head.addOrReplaceChild("JawTop", CubeListBuilder.create().texOffs(12, 26).addBox(-1.0F, 1.5F, -4.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(20, 25).addBox(1.0F, 2.5F, -2.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 25).addBox(1.0F, 2.5F, -4.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -4.0F));

		PartDefinition JawBottom = Head.addOrReplaceChild("JawBottom", CubeListBuilder.create().texOffs(26, 17).addBox(-1.0F, 1.5F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 25).addBox(-1.0F, 0.5F, -1.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 25).addBox(-1.0F, 0.5F, -3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.5F, -4.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(19, 11).addBox(-4.0F, 0.5909F, -6.5909F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 9).addBox(-3.0F, 5.5909F, -6.5909F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 6).addBox(-3.0F, 4.5909F, -5.5909F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 0).addBox(-3.0F, -0.4091F, -6.5909F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, 0.5909F, -5.5909F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(14, 28).addBox(0.0F, -1.4091F, -1.5909F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(12, 19).addBox(0.0F, -2.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(12, 19).addBox(2.0F, -2.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(12, 19).addBox(-2.0F, -2.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(12, 19).mirror().addBox(-3.0F, -2.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(12, 19).addBox(3.0F, -2.4091F, -6.5909F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 14.4091F, -3.4091F));

		PartDefinition Tail1 = Body.addOrReplaceChild("Tail1", CubeListBuilder.create().texOffs(21, 21).addBox(-2.0F, -1.25F, 0.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(0.0F, -3.25F, 0.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.8409F, 1.4091F));

		PartDefinition Tail2 = Body.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(21, 21).addBox(-1.5F, -0.25F, 0.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(0.0F, -2.25F, 0.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.8409F, 6.4091F));

		PartDefinition Tail3 = Body.addOrReplaceChild("Tail3", CubeListBuilder.create().texOffs(21, 21).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 25).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.5909F, 11.4091F));

		PartDefinition Tail4 = Body.addOrReplaceChild("Tail4", CubeListBuilder.create().texOffs(21, 21).addBox(-0.5F, 0.25F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(15, 20).addBox(0.0F, -1.75F, -1.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.3409F, 16.4091F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(8, 41).addBox(0.0F, 2.0F, 2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(0.0F, -1.0F, -1.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 15.0F, -6.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(6, 31).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 8.0F, 2.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(8, 41).addBox(-2.0F, 2.0F, 2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 15.0F, -6.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 20).addBox(1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-1.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, 0.0F, -5.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 31).addBox(-1.0F, 0.0F, -3.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 8.0F, 2.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntitySummonedBeast entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}