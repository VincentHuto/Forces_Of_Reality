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
	public static final Lazy<ModelAuricArmor<LivingEntity>> helmet = Lazy
			.of(() -> new ModelAuricArmor<>(Minecraft.getInstance().getEntityModels().bakeLayer(AURIC_HEAD_LAYER)));

	public ModelAuricArmor(ModelPart root) {
		super(root, RenderType::entityTranslucent);

	}

	public static LayerDefinition createHeadLayer(EquipmentSlot slot) {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0);
		PartDefinition partdefinition = meshdefinition.getRoot();
		if (slot.equals(EquipmentSlot.HEAD)) {

			PartDefinition head = partdefinition.addOrReplaceChild("head",
					CubeListBuilder.create().texOffs(33, 48)
							.addBox(2.0F, -33.0F, -6.0F, 0.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(-4, 52)
							.addBox(1.0F, -32.0F, -6.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 53)
							.addBox(1.0F, -30.0F, 2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(38, 53)
							.addBox(2.0F, -34.0F, -6.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(38, 53)
							.addBox(2.0F, -35.0F, -8.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(38, 53)
							.addBox(2.0F, -33.0F, 2.0F, 0.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)),
					PartPose.offset(-2.0F, 21.0F, 2.0F));
		}

		return LayerDefinition.create(meshdefinition, 64, 64);
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