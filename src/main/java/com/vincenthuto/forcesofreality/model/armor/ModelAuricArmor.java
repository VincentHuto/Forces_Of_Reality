package com.vincenthuto.forcesofreality.model.armor;

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

public class ModelAuricArmor<T extends LivingEntity> extends HumanoidModel<T> {
	public static final ModelLayerLocation AURIC_HEAD_LAYER = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "auric_helmet"), "main");

	public static final ModelLayerLocation AURIC_CHEST_LAYER = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "auric_chestplate"), "main");

	public static final ModelLayerLocation AURIC_LEGS_LAYER = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "auric_leggings"), "main");

	public static final ModelLayerLocation AURIC_BOOTS_LAYER = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "auric_boots"), "main");

	public static final Lazy<ModelAuricArmor<LivingEntity>> helmet = Lazy
			.of(() -> new ModelAuricArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(AURIC_HEAD_LAYER)));
	public static final Lazy<ModelAuricArmor<LivingEntity>> chest = Lazy
			.of(() -> new ModelAuricArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(AURIC_CHEST_LAYER)));
	public static final Lazy<ModelAuricArmor<LivingEntity>> legs = Lazy
			.of(() -> new ModelAuricArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(AURIC_LEGS_LAYER)));
	public static final Lazy<ModelAuricArmor<LivingEntity>> boots = Lazy
			.of(() -> new ModelAuricArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(AURIC_BOOTS_LAYER)));

	public static LayerDefinition createBodyLayer(EquipmentSlot slot) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();
		if (slot.equals(EquipmentSlot.CHEST)) {
			PartDefinition body = partdefinition.addOrReplaceChild("body",
					CubeListBuilder.create().texOffs(16, 16)
							.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 104)
							.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.65F)),
					PartPose.offset(0.0F, 0.0F, 0.0F));

			PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
					CubeListBuilder.create().texOffs(42, 70)
							.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 104)
							.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.7F)).texOffs(4, 146)
							.mirror().addBox(-4.75F, -2.25F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.85F))
							.mirror(false).texOffs(62, 132).mirror()
							.addBox(-4.75F, -0.6F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.85F)).mirror(false),
					PartPose.offset(-5.0F, 2.0F, 0.0F));

			PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
					CubeListBuilder.create().texOffs(32, 48)
							.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(40, 104)
							.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.7F)).texOffs(4, 146)
							.addBox(0.75F, -2.25F, -2.0F, 4.0F, 0.0F, 4.0F, new CubeDeformation(0.85F)).texOffs(62, 132)
							.addBox(0.75F, -0.6F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.85F)),
					PartPose.offset(5.0F, 2.0F, 0.0F));

		}

		if (slot.equals(EquipmentSlot.LEGS)) {

			PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
					CubeListBuilder.create().texOffs(0, 16)
							.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(154, 173)
							.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)),
					PartPose.offset(-1.9F, 12.0F, 0.0F));

			PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
					CubeListBuilder.create().texOffs(154, 173)
							.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(16, 48)
							.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)),
					PartPose.offset(1.9F, 12.0F, 0.0F));

		}

		if (slot.equals(EquipmentSlot.FEET)) {
			PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
					CubeListBuilder.create().texOffs(0, 16)
							.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).texOffs(154, 173)
							.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)),
					PartPose.offset(-1.9F, 12.0F, 0.0F));

			PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
					CubeListBuilder.create().texOffs(154, 173)
							.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).texOffs(16, 48)
							.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)),
					PartPose.offset(1.9F, 12.0F, 0.0F));

		}

		return LayerDefinition.create(meshdefinition, 256, 256);

	}

	public static LayerDefinition createHeadLayer(EquipmentSlot slot) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();
		if (slot.equals(EquipmentSlot.HEAD)) {

			PartDefinition head = partdefinition.addOrReplaceChild("head",
					CubeListBuilder.create().texOffs(0, 0)
							.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(32, 0)
							.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)),
					PartPose.offset(0.0F, 0.0F, 0.0F));

			PartDefinition helm = head.addOrReplaceChild("helm",
					CubeListBuilder.create().texOffs(0, 88)
							.addBox(-2.0F, -29.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)).texOffs(34, 132)
							.addBox(2.0F, -33.0F, -6.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 135)
							.addBox(1.0F, -32.0F, -6.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 53)
							.addBox(1.0F, -30.0F, 2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(38, 53)
							.addBox(2.0F, -34.0F, -6.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(48, 140)
							.addBox(2.0F, -34.0F, -8.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(42, 136)
							.addBox(2.0F, -33.0F, 2.0F, 0.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)),
					PartPose.offset(-2.0F, 21.0F, 2.0F));

		}

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	public ModelAuricArmor(ModelPart root) {
		super(root, RenderType::entityTranslucent);

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

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

	}
}