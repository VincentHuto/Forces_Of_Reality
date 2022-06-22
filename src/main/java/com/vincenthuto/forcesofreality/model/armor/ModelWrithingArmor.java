package com.vincenthuto.forcesofreality.model.armor;
// Made with Blockbench 4.2.5

// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.util.Lazy;

public class ModelWrithingArmor<T extends LivingEntity> extends HumanoidModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation WRITHING_HEAD_LAYER = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modelwrithingarmor_helm"), "main");

	public static final ModelLayerLocation WRITHING_CHEST_LAYER = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modelwrithingarmor_chest"), "main");

	public static final ModelLayerLocation WRITHING_LEGS_LAYER = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modelwrithingarmor_legs"), "main");

	public static final ModelLayerLocation WRITHING_BOOTS_LAYER = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "modelwrithingarmor_boots"), "main");

	public static final Lazy<ModelWrithingArmor<LivingEntity>> helmet = Lazy.of(
			() -> new ModelWrithingArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(WRITHING_HEAD_LAYER)));
	public static final Lazy<ModelWrithingArmor<LivingEntity>> chest = Lazy.of(
			() -> new ModelWrithingArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(WRITHING_CHEST_LAYER)));
	public static final Lazy<ModelWrithingArmor<LivingEntity>> legs = Lazy.of(
			() -> new ModelWrithingArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(WRITHING_LEGS_LAYER)));
	public static final Lazy<ModelWrithingArmor<LivingEntity>> boots = Lazy.of(
			() -> new ModelWrithingArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(WRITHING_BOOTS_LAYER)));

	public ModelWrithingArmor(ModelPart root) {
		super(root, RenderType::entityTranslucent);

	}

	public static LayerDefinition createHeadLayer(EquipmentSlot slot) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();
		if (slot.equals(EquipmentSlot.HEAD)) {

			PartDefinition head = partdefinition.addOrReplaceChild("head",
					CubeListBuilder.create().texOffs(0, 0)
							.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(32, 0)
							.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)).texOffs(0, 0)
							.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
							.addBox(-3.0F, -9.0F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 56)
							.addBox(-2.0F, -10.0F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
							.addBox(-1.0F, -9.0F, 1.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
							.addBox(-1.0F, -8.3F, 5.0F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
							.addBox(-5.0F, -8.6F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
							.addBox(3.0F, -8.6F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
							.addBox(-0.5F, -1.3F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
							.addBox(3.0F, -3.6F, 0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
							.addBox(3.0F, -3.6F, 0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
					PartPose.offset(0.0F, 0.0F, 0.0F));
		}

		return LayerDefinition.create(meshdefinition, 256, 256);

	}

	public static LayerDefinition createBodyLayer(EquipmentSlot slot) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();

		if (slot.equals(EquipmentSlot.CHEST)) {

			PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 17)
					.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(1, 57)
					.addBox(-2.0F, 2.0F, -3.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(16, 16)
					.addBox(-4.0F, 0.0F, 2.0F, 8.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 56)
					.addBox(-13.0F, -6.0F, 1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 56)
					.addBox(-13.0F, 13.0F, 1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 56)
					.addBox(8.0F, 13.0F, 1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 56)
					.addBox(8.0F, -6.0F, 1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(-12.0F, -3.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(-12.0F, 11.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(8.0F, 11.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(8.0F, -3.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(5.0F, 9.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(4.0F, 8.0F, 4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(2.0F, 7.0F, 2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(-9.0F, 9.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(-8.0F, 8.0F, 4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(-7.0F, 7.0F, 2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(-9.0F, -1.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(-8.0F, 0.0F, 4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(-7.0F, 1.0F, 2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(4.0F, 0.0F, 4.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(5.0F, -1.0F, 5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(16, 16)
					.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(19, 58)
					.addBox(2.0F, 1.0F, 2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(40, 16).mirror()
					.addBox(4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
					.texOffs(40, 16).addBox(-8.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
					PartPose.offset(0.0F, 0.0F, 0.0F));

			PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create()
					.texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
					PartPose.offset(-5.0F, 2.0F, 0.0F));

			PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create()
					.texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
					PartPose.offset(5.0F, 2.0F, 0.0F));
		}
		if (slot.equals(EquipmentSlot.FEET)) {

			PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg ", CubeListBuilder.create()
					.texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)),
					PartPose.offset(-1.9F, 12.0F, 0.0F));

			PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg",
					CubeListBuilder.create().texOffs(0, 16).mirror()
							.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
					PartPose.offset(1.9F, 12.0F, 0.0F));
		}

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		leftArm.render(poseStack, buffer, packedLight, packedOverlay);
		rightLeg.render(poseStack, buffer, packedLight, packedOverlay);
		leftLeg.render(poseStack, buffer, packedLight, packedOverlay);
		rightArm.render(poseStack, buffer, packedLight, packedOverlay);

	}
}