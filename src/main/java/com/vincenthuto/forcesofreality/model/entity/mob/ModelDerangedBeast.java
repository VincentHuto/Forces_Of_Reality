package com.vincenthuto.forcesofreality.model.entity.mob;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.mob.EntityDerangedBeast;

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

// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class ModelDerangedBeast extends EntityModel<EntityDerangedBeast> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modelderangedbeast"), "main");
	private final ModelPart Head;
	private final ModelPart Body;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;
	private final ModelPart BottomLeftLeg;
	private final ModelPart BottomRightLeg;

	public ModelDerangedBeast(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
		this.BottomLeftLeg = root.getChild("BottomLeftLeg");
		this.BottomRightLeg = root.getChild("BottomRightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, -3.0F, -2.6F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(-2.0F, -2.0F, -3.6F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 3).addBox(0.0F, -4.0F, -2.6F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -4.4F));

		PartDefinition JawTop = Head.addOrReplaceChild("JawTop", CubeListBuilder.create().texOffs(14, 28).addBox(-1.6667F, -1.1667F, -1.6667F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(20, 25).addBox(0.3333F, -0.1667F, -1.6667F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 25).addBox(-1.6667F, -0.1667F, -1.6667F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.6667F, 1.1667F, -3.9333F));

		PartDefinition JawBottom = Head.addOrReplaceChild("JawBottom", CubeListBuilder.create().texOffs(26, 17).addBox(-0.3333F, 0.1667F, -1.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 25).addBox(-0.3333F, -0.8333F, 0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 25).addBox(-0.3333F, -0.8333F, -1.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 25).addBox(1.6667F, -0.8333F, -1.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.6667F, 1.8333F, -3.1F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(19, 11).addBox(-4.0F, -0.7667F, -4.56F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 9).addBox(-3.0F, 4.2333F, -4.56F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 6).addBox(-3.0F, 3.2333F, -3.56F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 0).addBox(-3.0F, -1.7667F, -4.56F, 6.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, -0.7667F, -3.56F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(27, 5).addBox(-2.0F, -0.7667F, 3.44F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(21, 8).addBox(-2.0F, 3.2333F, 0.44F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 8).addBox(0.0F, -2.7667F, 0.44F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(18, 11).addBox(0.0F, -0.7667F, 4.34F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(19, 9).addBox(0.0F, -2.7667F, 7.44F, 0.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(12, 19).addBox(0.0F, -3.7667F, -4.56F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(12, 19).addBox(2.5F, -3.7667F, -3.56F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 19).addBox(-2.5F, -3.7667F, -3.56F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.7667F, 0.56F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(8, 41).addBox(-0.5F, 0.5F, -3.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(-0.5F, -2.5F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 8.5F, 1.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -9.0F, 1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-1.0F, -8.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, -8.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 21).addBox(0.0F, -9.0F, 4.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(1.0F, -8.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 14.5F, -5.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(8, 41).addBox(-1.5F, 0.5F, -3.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(-0.5F, -2.5F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, 8.5F, 1.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(0, 20).addBox(1.0F, -8.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-1.0F, -8.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, -8.0F, 1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1, 21).addBox(0.0F, -9.0F, 4.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-1.0F, -9.0F, 1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 14.5F, -5.0F));

		PartDefinition BottomLeftLeg = partdefinition.addOrReplaceChild("BottomLeftLeg", CubeListBuilder.create().texOffs(8, 41).addBox(0.0F, 3.0F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(0.0F, 0.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 14.0F, 4.0F));

		PartDefinition LeftFoot2 = BottomLeftLeg.addOrReplaceChild("LeftFoot2", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -9.0F, 4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-1.0F, -8.0F, 2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, -8.0F, 2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, -8.0F, 6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(1.0F, -8.0F, 2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 17.0F, -5.0F));

		PartDefinition BottomRightLeg = partdefinition.addOrReplaceChild("BottomRightLeg", CubeListBuilder.create().texOffs(8, 41).addBox(-2.0F, 3.0F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 36).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 14.0F, 4.0F));

		PartDefinition RightFoot2 = BottomRightLeg.addOrReplaceChild("RightFoot2", CubeListBuilder.create().texOffs(0, 20).addBox(1.0F, -8.0F, 2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(-1.0F, -8.0F, 2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, -8.0F, 2.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 20).addBox(0.0F, -8.0F, 6.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-1.0F, -9.0F, 4.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 17.0F, -5.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(EntityDerangedBeast entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BottomLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BottomRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}