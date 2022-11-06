package com.vincenthuto.forcesofreality.model.entity.lord;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.lord.EntityVeritas;

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

public class ModelVeritas extends EntityModel<EntityVeritas> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modelveritas"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create(),
				PartPose.offset(-0.25F, -3.75F, 4.0F));

		PartDefinition ring = Head.addOrReplaceChild("ring",
				CubeListBuilder.create().texOffs(0, 26)
						.addBox(-4.0F, 4.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(2.0F, 4.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(5.0F, 1.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(5.0F, -3.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-7.0F, 1.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-7.0F, -3.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-4.0F, -6.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(2.0F, -6.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.25F, -4.75F, -1.0F));

		PartDefinition Halo = partdefinition.addOrReplaceChild("Halo", CubeListBuilder.create().texOffs(16, 0).addBox(
				-8.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.1F, -8.9F, 4.0F));

		PartDefinition Neck = partdefinition.addOrReplaceChild("Neck",
				CubeListBuilder.create().texOffs(45, 27)
						.addBox(-0.5F, -28.0F, -3.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(45, 27)
						.addBox(-0.5F, -29.0F, -3.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(45, 27)
						.addBox(-0.5F, -24.0F, -5.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(45, 27)
						.addBox(-0.5F, -25.0F, -4.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, 23.0F, 8.0F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 16)
						.addBox(-6.0F, 0.0F, 2.0F, 12.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(41, 16)
						.addBox(-2.0F, 5.0F, 4.0F, 4.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(41, 16)
						.addBox(-1.0F, 12.0F, 6.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 16)
						.addBox(-1.0F, 9.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(41, 16)
						.addBox(-1.0F, 6.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(41, 16)
						.addBox(-1.0F, 3.0F, 6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(41, 16)
						.addBox(-1.0F, 0.0F, 6.7F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 16)
						.addBox(-1.0F, -4.0F, 6.7F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(41, 16)
						.addBox(-3.0F, 13.0F, 3.6F, 6.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body_r1 = Body.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(28, 38).mirror()
				.addBox(-2.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(28, 40)
				.mirror().addBox(-2.0F, -2.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(44, 40).mirror().addBox(-2.0F, -4.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.mirror(false), PartPose.offsetAndRotation(3.0F, 9.5F, 3.5F, 0.0F, 0.9163F, 0.0F));

		PartDefinition Body_r2 = Body.addOrReplaceChild("Body_r2",
				CubeListBuilder.create().texOffs(28, 38)
						.addBox(-1.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 40)
						.addBox(-2.0F, -2.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(44, 40)
						.addBox(-1.0F, -4.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 9.5F, 3.5F, 0.0F, -0.9163F, 0.0F));

		PartDefinition Body_r3 = Body.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(8, 14).mirror()
				.addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(29, 16)
				.mirror().addBox(-1.0F, -2.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(29, 18).mirror().addBox(-1.0F, -4.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.mirror(false), PartPose.offsetAndRotation(3.0229F, 9.5F, 2.1987F, 0.0F, 2.2253F, 0.0F));

		PartDefinition Body_r4 = Body.addOrReplaceChild("Body_r4",
				CubeListBuilder.create().texOffs(8, 14)
						.addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(29, 16)
						.addBox(-2.0F, -2.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(29, 18)
						.addBox(-3.0F, -4.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0229F, 9.5F, 2.1987F, 0.0F, -2.2253F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm",
				CubeListBuilder.create().texOffs(32, 38)
						.addBox(-3.5374F, -4.444F, -1.1856F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(48, 0)
						.addBox(-2.4284F, 2.5332F, -0.4834F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.2F, 4.0F, 4.0F, -0.5672F, 0.0F, -0.3491F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(16, 38).addBox(-0.8453F, -1.9067F, -1.1052F, 4.0F, 7.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.0F, 2.0F, 4.0F, 0.0F, 0.3927F, -0.2182F));

		PartDefinition bone2 = LeftArm.addOrReplaceChild("bone2",
				CubeListBuilder.create().texOffs(39, 46).addBox(-1.8827F, -1.5F, -6.0761F, 3.0F, 3.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5293F, 6.6886F, -0.5478F, 0.0F, -0.6545F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg",
				CubeListBuilder.create().texOffs(0, 38).addBox(-0.0317F, -2.9945F, 1.0245F, 4.0F, 8.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, -0.6545F, -0.2618F, 1.309F));

		PartDefinition bone3 = RightLeg.addOrReplaceChild("bone3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(11.2565F, 6.9405F, 3.7364F, 0.1745F, -0.8727F, 0.0436F));

		PartDefinition cube_r1 = bone3.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(18, 26).addBox(-3.7308F, -2.3252F, 4.3744F, 9.0F, 3.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-5.0318F, 0.1371F, -0.2839F, -0.0873F, -0.6981F, 0.2182F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.9683F, -2.9945F, 1.0245F, 4.0F, 8.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, -0.48F, 0.2618F, -1.0472F));

		PartDefinition bone = LeftLeg.addOrReplaceChild("bone", CubeListBuilder.create(),
				PartPose.offsetAndRotation(3.85F, 10.7255F, -4.3588F, 0.1745F, -0.8727F, 0.0436F));

		PartDefinition cube_r2 = bone.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(24, 32).addBox(-6.5027F, -1.2301F, -0.895F, 9.0F, 3.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.2804F, -3.182F, 9.9955F, -0.0873F, -0.1309F, -0.1309F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	private final ModelPart Head;
	private final ModelPart Halo;
	private final ModelPart Neck;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;

	private final ModelPart LeftLeg;

	public ModelVeritas(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Halo = root.getChild("Halo");
		this.Neck = root.getChild("Neck");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Halo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(EntityVeritas entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

	}
}