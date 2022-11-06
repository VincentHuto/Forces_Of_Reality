package com.vincenthuto.forcesofreality.model.entity.mob;
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings

// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;
import com.vincenthuto.forcesofreality.entity.mob.EntityDreadBot;

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

public class ModelDreadBot extends EntityModel<EntityDreadBot> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "machina_imperfecta"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition whole = partdefinition.addOrReplaceChild("whole",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(6.0F, -5.0F, -16.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(8, 31)
						.addBox(5.0F, -3.0F, -17.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 31)
						.addBox(5.0F, -3.0F, -5.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
						.addBox(17.0F, -3.0F, -5.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(17.0F, -3.0F, -17.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(44, 27)
						.addBox(7.0F, 5.0F, -15.0F, 10.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(22, 44)
						.addBox(7.0F, -4.0F, -15.0F, 10.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(6, 43)
						.addBox(15.0F, -2.0F, -5.0F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 43)
						.addBox(7.0F, -2.0F, -5.0F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(42, 13)
						.addBox(7.0F, -2.0F, -16.0F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(42, 0)
						.addBox(15.0F, -2.0F, -16.0F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 13)
						.addBox(17.0F, -2.0F, -15.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(36, 0)
						.addBox(17.0F, -2.0F, -7.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(28, 32)
						.addBox(6.0F, -2.0F, -15.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 32)
						.addBox(6.0F, -2.0F, -7.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-12.0F, 9.0F, 10.0F));

		PartDefinition BottomGear = whole.addOrReplaceChild("BottomGear",
				CubeListBuilder.create().texOffs(48, 5)
						.addBox(-8.0F, 0.5F, -6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(48, 0)
						.addBox(6.0F, 0.5F, -6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(44, 32)
						.addBox(6.0F, 0.5F, 4.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(44, 27)
						.addBox(-8.0F, 0.5F, 4.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(53, 40)
						.addBox(-5.0F, 0.5F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
						.addBox(-6.0F, -0.5F, -6.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(12.0F, 7.5F, -10.0F));

		PartDefinition rightTread = BottomGear.addOrReplaceChild("rightTread",
				CubeListBuilder.create().texOffs(0, 43)
						.addBox(-6.0F, 1.5F, -6.0F, 3.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 44)
						.addBox(-4.5F, -1.5F, -6.0F, 0.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(32, 10)
						.addBox(-6.0F, -2.5F, -6.0F, 3.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(53, 44)
						.addBox(-6.0F, -1.5F, 10.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 51)
						.addBox(-6.0F, -1.5F, -7.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 5.0F, -2.0F));

		PartDefinition rightWheel1 = rightTread.addOrReplaceChild("rightWheel1",
				CubeListBuilder.create().texOffs(34, 34)
						.addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(43, 21)
						.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(43, 23)
						.addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.5F, 0.0F, -4.5F));

		PartDefinition rightWheel2 = rightTread.addOrReplaceChild("rightWheel2",
				CubeListBuilder.create().texOffs(33, 40)
						.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 26)
						.addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(34, 38)
						.addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.5F, 0.0F, 1.5F));

		PartDefinition rightWheel3 = rightTread.addOrReplaceChild("rightWheel3",
				CubeListBuilder.create().texOffs(22, 26)
						.addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 43)
						.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 22)
						.addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.5F, 0.0F, 8.5F));

		PartDefinition leftTread = BottomGear.addOrReplaceChild("leftTread",
				CubeListBuilder.create().texOffs(22, 27)
						.addBox(-6.0F, 1.5F, -6.0F, 3.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(38, 41)
						.addBox(-4.5F, -1.5F, -6.0F, 0.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-6.0F, -2.5F, -6.0F, 3.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 51)
						.addBox(-6.0F, -1.5F, 10.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 49)
						.addBox(-6.0F, -1.5F, -7.0F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(14.0F, 5.0F, -2.0F));

		PartDefinition leftWheel1 = leftTread.addOrReplaceChild("leftWheel1",
				CubeListBuilder.create().texOffs(8, 2)
						.addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 19)
						.addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 6)
						.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.5F, 0.0F, -4.5F));

		PartDefinition leftWheel2 = leftTread.addOrReplaceChild("leftWheel2",
				CubeListBuilder.create().texOffs(34, 29)
						.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(34, 27)
						.addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.5F, 0.0F, 1.5F));

		PartDefinition leftWheel3 = leftTread.addOrReplaceChild("leftWheel3",
				CubeListBuilder.create().texOffs(6, 31)
						.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 15)
						.addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(26, 32)
						.addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.5F, 0.0F, 8.5F));

		PartDefinition topMiddleGear = whole.addOrReplaceChild("topMiddleGear",
				CubeListBuilder.create().texOffs(6, 13)
						.addBox(-1.0F, -0.5F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(6, 22)
						.addBox(2.0F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(6, 0)
						.addBox(-1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 9)
						.addBox(-3.0F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(12.0F, -1.5F, -10.0F));

		PartDefinition turret = whole.addOrReplaceChild("turret",
				CubeListBuilder.create().texOffs(6, 13)
						.addBox(-1.0F, 0.1667F, -2.9167F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 51)
						.addBox(-1.0F, -0.8333F, 1.0833F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 26)
						.addBox(-2.0F, 0.1667F, -1.9167F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(6, 22)
						.addBox(2.0F, 0.1667F, -0.9167F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(6, 0)
						.addBox(-1.0F, 0.1667F, 2.0833F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 9)
						.addBox(-3.0F, 0.1667F, -0.9167F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 51)
						.addBox(-1.0F, -2.8333F, -1.9167F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(12.0F, -6.1667F, -10.0833F));

		PartDefinition cube_r1 = turret.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(54, 0).addBox(-0.5F, -2.5F, -2.0F, 3.0F, 3.0F, 5.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -2.3333F, -0.9167F, -0.48F, 0.0F, 0.0F));

		PartDefinition bottomMiddleGear = whole.addOrReplaceChild("bottomMiddleGear",
				CubeListBuilder.create().texOffs(40, 9)
						.addBox(-1.0F, -0.5F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 27)
						.addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(36, 22)
						.addBox(2.0F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(32, 32)
						.addBox(-1.0F, -0.5F, 2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 9)
						.addBox(-3.0F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(12.0F, 4.5F, -10.0F));

		PartDefinition eye = whole.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(22, 44).addBox(-1.0F,
				-1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(12.0F, 1.5F, -10.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	private final ModelPart whole;

	public ModelDreadBot(ModelPart root) {
		this.whole = root.getChild("whole");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		whole.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(EntityDreadBot entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}
}