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

public class ModelBeastlyArmor<T extends LivingEntity> extends HumanoidModel<T> {

	public static final ModelLayerLocation BEASTLY_HEAD_LAYER = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "beastly_helmet"), "main");

	public static final ModelLayerLocation BEASTLY_CHEST_LAYER = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "beastly_chestplate"), "main");

	public static final ModelLayerLocation BEASTLY_LEGS_LAYER = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "beastly_leggings"), "main");

	public static final ModelLayerLocation BEASTLY_BOOTS_LAYER = new ModelLayerLocation(
			new ResourceLocation(ForcesOfReality.MOD_ID, "beastly_boots"), "main");

	public static final Lazy<ModelBeastlyArmor<LivingEntity>> helmet = Lazy
			.of(() -> new ModelBeastlyArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(BEASTLY_HEAD_LAYER)));
	public static final Lazy<ModelBeastlyArmor<LivingEntity>> chest = Lazy.of(
			() -> new ModelBeastlyArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(BEASTLY_CHEST_LAYER)));
	public static final Lazy<ModelBeastlyArmor<LivingEntity>> legs = Lazy
			.of(() -> new ModelBeastlyArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(BEASTLY_LEGS_LAYER)));
	public static final Lazy<ModelBeastlyArmor<LivingEntity>> boots = Lazy.of(
			() -> new ModelBeastlyArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(BEASTLY_BOOTS_LAYER)));

	public static LayerDefinition createBodyLayer(EquipmentSlot slot) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body",
				CubeListBuilder.create().texOffs(16, 113)
						.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(56, 157)
						.addBox(-7.0F, 0.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(56, 157)
						.addBox(-7.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(56, 157)
						.addBox(-7.0F, -2.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(56, 157)
						.addBox(-7.0F, 0.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(56, 157)
						.addBox(5.0F, 0.0F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(56, 157)
						.addBox(5.0F, -2.0F, 1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(56, 157)
						.addBox(5.0F, -2.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(56, 157)
						.addBox(5.0F, 0.0F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(52, 129)
						.addBox(-3.0F, 9.0F, 3.2F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(48, 144)
						.addBox(-4.0F, 9.0F, 3.5F, 8.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(17, 132)
						.addBox(-2.0F, 8.9482F, 2.9068F, 4.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(11, 136)
						.addBox(4.0F, -1.0F, 2.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(31, 157)
						.addBox(-4.0F, 10.0F, 2.1F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(21, 154)
						.addBox(-4.0F, 4.0F, 2.0F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(30, 130)
						.addBox(-4.0F, 5.0F, -2.2F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 148)
						.addBox(-5.0F, 2.0F, -3.0F, 10.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(27, 145)
						.addBox(-5.0F, 0.0F, -4.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 135)
						.addBox(4.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(30, 135)
						.addBox(-5.0F, -1.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 155)
						.addBox(-4.0F, 0.0F, 2.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(11, 132)
						.addBox(-5.0F, -1.0F, 2.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm",
				CubeListBuilder.create().texOffs(40, 16)
						.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(125, 140)
						.addBox(-4.0F, 2.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm",
				CubeListBuilder.create().texOffs(32, 48)
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(125, 140)
						.addBox(3.0F, 2.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(112, 150)
						.addBox(-0.6F, 11.05F, 2.95F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(112, 150)
						.addBox(-1.1F, 10.0F, 2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(112, 150)
						.addBox(0.9F, 10.0F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(112, 150)
						.addBox(-2.1F, 10.0F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(112, 150)
						.addBox(-1.1F, 10.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(112, 150)
						.addBox(-1.1F, 9.0F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(112, 153)
						.addBox(-0.9F, 9.0F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(112, 153)
						.addBox(-0.9F, 10.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(112, 153)
						.addBox(-1.9F, 10.0F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(112, 153)
						.addBox(1.1F, 10.0F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(112, 153)
						.addBox(-0.9F, 10.0F, 2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(112, 153)
						.addBox(-0.4F, 11.05F, 2.95F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.9F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	public static LayerDefinition createHeadLayer(EquipmentSlot slot) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();
		if (slot.equals(EquipmentSlot.HEAD)) {
			PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(108, 153)
					.addBox(6.0F, -13.0F, -4.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(3.0F, -12.0F, -3.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 154)
					.addBox(-6.0F, -13.0F, -4.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-5.0F, -12.0F, -3.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(9.0F, -17.0F, -6.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-12.0F, -17.0F, -6.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-10.0F, -15.0F, -5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(7.0F, -15.0F, -5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(109, 149)
					.addBox(-3.5F, -5.3211F, -4.4894F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(108, 148)
					.addBox(4.3F, -9.0F, -4.1F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(108, 148)
					.addBox(-5.3F, -9.0F, -4.1F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-0.7F, -5.6097F, -14.0604F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-0.7F, -4.454F, -17.0461F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(168, 127)
					.addBox(3.5F, -10.0F, -7.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(168, 127)
					.addBox(-3.5F, -10.0F, -7.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 97)
					.addBox(-3.0F, -10.0F, -7.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-12.0F, -17.0F, 5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(9.0F, -17.0F, 5.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(0.3F, -4.5752F, -15.4351F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-10.0F, -15.0F, 4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 154)
					.addBox(-6.0F, -13.0F, 2.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-5.0F, -12.0F, 1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(7.0F, -15.0F, 4.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(3.0F, -12.0F, 1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(6.0F, -13.0F, 2.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-4.0F, -11.0F, 0.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-4.0F, -9.0F, 5.0F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(108, 137)
					.addBox(-2.9F, -9.1906F, -9.2093F, 6.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-4.0F, -10.0F, -8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-4.0F, -11.0F, -7.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-4.0F, -8.0F, -7.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-4.0F, -10.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(3.0F, -10.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(3.0F, -10.0F, -8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(3.0F, -11.0F, -7.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(3.0F, -8.0F, -7.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(112, 150)
					.addBox(-3.0F, -3.8844F, -11.2491F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(115, 148)
					.addBox(2.0F, -3.8844F, -11.2491F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(108, 149)
					.addBox(-2.5F, -5.3211F, -13.4894F, 5.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)).texOffs(109, 151)
					.addBox(-4.0F, -5.7919F, -11.6477F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(108, 148)
					.addBox(3.0F, -5.7919F, -11.6477F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-1.7F, -4.5752F, -15.4351F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(108, 153)
					.addBox(-3.5F, -6.7456F, -10.347F, 7.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(109, 148)
					.addBox(-3.0F, -6.0333F, -12.4182F, 6.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(110, 145)
					.addBox(3.3F, -9.0F, -4.1F, 1.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(109, 146)
					.addBox(-4.3F, -9.0F, -4.1F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(108, 150)
					.addBox(-4.0F, -10.0F, -4.0F, 8.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)),
					PartPose.offset(0.0F, 0.0F, 0.0F));

			PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1",
					CubeListBuilder.create().texOffs(112, 152).addBox(-2.5F, 2.2544F, 5.653F, 5.0F, 1.0F, 7.0F,
							new CubeDeformation(0.0F)),
					PartPose.offsetAndRotation(0.0F, -7.7F, -18.0F, 0.1309F, 0.0F, 0.0F));
		}
		return LayerDefinition.create(meshdefinition, 256, 256);

	}

	public ModelBeastlyArmor(ModelPart root) {
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