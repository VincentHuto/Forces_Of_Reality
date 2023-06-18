package com.vincenthuto.forcesofreality.client.model.armor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.vincenthuto.forcesofreality.ForcesOfReality;

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
import net.minecraft.world.entity.Entity;

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


public class ModelSkullHelmetNew<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ForcesOfReality.MOD_ID, "modelskullhelmetnew"), "main");
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone22 = partdefinition.addOrReplaceChild("bone22", CubeListBuilder.create().texOffs(1, 49).addBox(-3.0F, -2.0F, 3.0F, 1.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.3F, -7.0F, -7.1F));

		PartDefinition bone23 = partdefinition.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(0, 51).addBox(-3.0F, -2.0F, 3.0F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.3F, -7.0F, -7.1F));

		PartDefinition bone25 = partdefinition.addOrReplaceChild("bone25", CubeListBuilder.create().texOffs(0, 51).addBox(-3.0F, -1.0F, 3.3F, 1.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(7.3F, -8.0F, -7.4F));

		PartDefinition bone31 = partdefinition.addOrReplaceChild("bone31", CubeListBuilder.create().texOffs(0, 56).addBox(3.0F, -4.0F, 10.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(3.0F, -4.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -13.0F, -5.0F));

		PartDefinition bone24 = partdefinition.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(2, 48).addBox(-3.0F, -1.0F, 3.3F, 1.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(6.3F, -8.0F, -7.4F));

		PartDefinition bone29 = partdefinition.addOrReplaceChild("bone29", CubeListBuilder.create().texOffs(0, 57).addBox(1.0F, -2.0F, 11.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 57).addBox(1.0F, -2.0F, 5.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -11.0F, -9.0F));

		PartDefinition bone30 = partdefinition.addOrReplaceChild("bone30", CubeListBuilder.create().texOffs(0, 56).addBox(1.0F, -2.0F, 9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(1.0F, -2.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -13.0F, -5.0F));

		PartDefinition bone33 = partdefinition.addOrReplaceChild("bone33", CubeListBuilder.create().texOffs(0, 56).addBox(1.0F, -2.0F, 9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(1.0F, -2.0F, -2.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, -15.0F, -4.0F));

		PartDefinition bone32 = partdefinition.addOrReplaceChild("bone32", CubeListBuilder.create().texOffs(0, 56).addBox(1.0F, -2.0F, 9.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(1.0F, -2.0F, 0.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -13.0F, -5.0F));

		PartDefinition bone34 = partdefinition.addOrReplaceChild("bone34", CubeListBuilder.create().texOffs(0, 56).addBox(1.0F, -2.0F, 10.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(1.0F, -2.0F, 6.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -10.0F, -9.0F));

		PartDefinition bone19 = partdefinition.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(0, 56).addBox(3.0F, 2.0F, 10.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -17.0F));

		PartDefinition bone28 = partdefinition.addOrReplaceChild("bone28", CubeListBuilder.create().texOffs(0, 56).addBox(1.0F, -2.0F, 11.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(1.0F, -2.0F, 5.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -11.0F, -9.0F));

		PartDefinition bone20 = partdefinition.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(0, 56).addBox(3.0F, -1.0F, 10.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -17.0F));

		PartDefinition bone16 = partdefinition.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(0, 56).addBox(3.0F, 0.0F, 12.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -17.0F));

		PartDefinition bone35 = partdefinition.addOrReplaceChild("bone35", CubeListBuilder.create().texOffs(0, 56).addBox(1.0F, -2.0F, 10.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 56).addBox(1.0F, -2.0F, 6.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -10.0F, -9.0F));

		PartDefinition bone18 = partdefinition.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(0, 56).addBox(-4.0F, 1.0F, 22.0F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -17.0F));

		PartDefinition bone38 = partdefinition.addOrReplaceChild("bone38", CubeListBuilder.create().texOffs(0, 56).addBox(3.0F, -1.0F, 7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -9.0F, -15.0F));

		PartDefinition bone17 = partdefinition.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(0, 56).addBox(3.0F, 0.0F, 9.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -17.0F));

		PartDefinition bone37 = partdefinition.addOrReplaceChild("bone37", CubeListBuilder.create().texOffs(0, 56).addBox(3.0F, -2.0F, 8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -9.0F, -15.0F));

		PartDefinition bone36 = partdefinition.addOrReplaceChild("bone36", CubeListBuilder.create().texOffs(0, 56).addBox(3.0F, 1.0F, 8.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -9.0F, -15.0F));

		PartDefinition bone39 = partdefinition.addOrReplaceChild("bone39", CubeListBuilder.create().texOffs(0, 56).addBox(3.0F, -1.0F, 10.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -9.0F, -15.0F));

		PartDefinition bone42 = partdefinition.addOrReplaceChild("bone42", CubeListBuilder.create().texOffs(60, 30).addBox(3.5F, -1.0F, 10.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -9.0F, -17.0F));

		PartDefinition bone41 = partdefinition.addOrReplaceChild("bone41", CubeListBuilder.create().texOffs(60, 30).addBox(10.5F, -1.0F, 10.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -9.0F, -17.0F));

		PartDefinition bone40 = partdefinition.addOrReplaceChild("bone40", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, -1.0F, 10.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, -9.0F, -17.0F));

		PartDefinition bone26 = partdefinition.addOrReplaceChild("bone26", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -1.0F, 3.0F, 8.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -7.0F));

		PartDefinition bone27 = partdefinition.addOrReplaceChild("bone27", CubeListBuilder.create().texOffs(0, 56).addBox(-4.0F, -1.0F, 7.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -7.0F));

		PartDefinition bone6 = partdefinition.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(0, 56).addBox(-3.5F, 0.2544F, 6.653F, 7.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -17.0F));

		PartDefinition bone7 = partdefinition.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(0, 56).addBox(-2.5F, -0.5F, -5.5F, 5.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.8211F, -7.9894F));

		PartDefinition bone8 = partdefinition.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 56).addBox(-0.7F, 1.3903F, 2.9396F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -17.0F));

		PartDefinition bone9 = partdefinition.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(0, 56).addBox(-0.7F, 2.546F, -0.0461F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -17.0F));

		PartDefinition bone11 = partdefinition.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(0, 56).addBox(-1.7F, 2.4248F, 1.5649F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -17.0F));

		PartDefinition bone5 = partdefinition.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(0, 40).addBox(-3.0F, -1.3561F, -6.084F, 6.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -7.8345F, -3.1253F, 0.0873F, 0.0F, 0.0F));

		PartDefinition bone13 = partdefinition.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(4, 53).addBox(-3.0F, 3.1156F, 5.7509F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -17.0F));

		PartDefinition bone12 = partdefinition.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(1, 54).addBox(-4.0F, 1.2081F, 5.3523F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -17.0F));

		PartDefinition bone14 = partdefinition.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(7, 51).addBox(2.0F, 3.1156F, 5.7509F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -17.0F));

		PartDefinition bone10 = partdefinition.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(0, 56).addBox(0.3F, 2.4248F, 1.5649F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -17.0F));

		PartDefinition bone15 = partdefinition.addOrReplaceChild("bone15", CubeListBuilder.create().texOffs(0, 51).addBox(3.0F, 1.2081F, 5.3523F, 1.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -17.0F));

		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(4, 55).addBox(-2.5F, -0.5F, -4.0F, 5.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.9456F, -8.347F, 0.2182F, 0.0F, 0.0F));

		PartDefinition bone43 = partdefinition.addOrReplaceChild("bone43", CubeListBuilder.create().texOffs(0, 56).addBox(-3.0F, 0.9667F, 4.5818F, 6.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -17.0F));

		PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(1, 52).addBox(-3.5F, 1.6789F, 3.5106F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	private final ModelPart bone22;
	private final ModelPart bone23;
	private final ModelPart bone25;
	private final ModelPart bone31;
	private final ModelPart bone24;
	private final ModelPart bone29;
	private final ModelPart bone30;
	private final ModelPart bone33;
	private final ModelPart bone32;
	private final ModelPart bone34;
	private final ModelPart bone19;
	private final ModelPart bone28;
	private final ModelPart bone20;
	private final ModelPart bone16;
	private final ModelPart bone35;
	private final ModelPart bone18;
	private final ModelPart bone38;
	private final ModelPart bone17;
	private final ModelPart bone37;
	private final ModelPart bone36;
	private final ModelPart bone39;
	private final ModelPart bone42;
	private final ModelPart bone41;
	private final ModelPart bone40;
	private final ModelPart bone26;
	private final ModelPart bone27;
	private final ModelPart bone6;
	private final ModelPart bone7;
	private final ModelPart bone8;
	private final ModelPart bone9;
	private final ModelPart bone11;
	private final ModelPart bone5;
	private final ModelPart bone13;
	private final ModelPart bone12;
	private final ModelPart bone14;
	private final ModelPart bone10;
	private final ModelPart bone15;
	private final ModelPart bone2;
	private final ModelPart bone43;

	private final ModelPart bone3;

	public ModelSkullHelmetNew(ModelPart root) {
		this.bone22 = root.getChild("bone22");
		this.bone23 = root.getChild("bone23");
		this.bone25 = root.getChild("bone25");
		this.bone31 = root.getChild("bone31");
		this.bone24 = root.getChild("bone24");
		this.bone29 = root.getChild("bone29");
		this.bone30 = root.getChild("bone30");
		this.bone33 = root.getChild("bone33");
		this.bone32 = root.getChild("bone32");
		this.bone34 = root.getChild("bone34");
		this.bone19 = root.getChild("bone19");
		this.bone28 = root.getChild("bone28");
		this.bone20 = root.getChild("bone20");
		this.bone16 = root.getChild("bone16");
		this.bone35 = root.getChild("bone35");
		this.bone18 = root.getChild("bone18");
		this.bone38 = root.getChild("bone38");
		this.bone17 = root.getChild("bone17");
		this.bone37 = root.getChild("bone37");
		this.bone36 = root.getChild("bone36");
		this.bone39 = root.getChild("bone39");
		this.bone42 = root.getChild("bone42");
		this.bone41 = root.getChild("bone41");
		this.bone40 = root.getChild("bone40");
		this.bone26 = root.getChild("bone26");
		this.bone27 = root.getChild("bone27");
		this.bone6 = root.getChild("bone6");
		this.bone7 = root.getChild("bone7");
		this.bone8 = root.getChild("bone8");
		this.bone9 = root.getChild("bone9");
		this.bone11 = root.getChild("bone11");
		this.bone5 = root.getChild("bone5");
		this.bone13 = root.getChild("bone13");
		this.bone12 = root.getChild("bone12");
		this.bone14 = root.getChild("bone14");
		this.bone10 = root.getChild("bone10");
		this.bone15 = root.getChild("bone15");
		this.bone2 = root.getChild("bone2");
		this.bone43 = root.getChild("bone43");
		this.bone3 = root.getChild("bone3");
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone22.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone23.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone25.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone31.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone24.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone29.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone30.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone33.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone32.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone34.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone19.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone28.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone20.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone16.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone35.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone18.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone38.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone17.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone37.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone36.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone39.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone42.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone41.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone40.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone26.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone27.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone9.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone11.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone13.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone12.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone14.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone10.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone15.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone43.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
}